package com.kelco.kamenridercraft.item.reiwa.gotchard;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.reiwa.GeatsRiderItems;
import com.kelco.kamenridercraft.item.reiwa.GotchardRiderItems;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;


public class LegendChemyCardItem extends RiderFormChangeItem {
    private RiderDriverItem summonBelt;
    private RiderFormChangeItem summonForm = null;
    private List<Item> summonWeapons = new ArrayList<>(2);

    public LegendChemyCardItem(Properties properties,  String formName, String riderName, String beltTex, MobEffectInstance... effects) {
        super(properties, formName, riderName, beltTex, effects);
    }

    public LegendChemyCardItem setSummonBelt(RiderDriverItem belt) {
        summonBelt = belt;
        return this;
    }

    public LegendChemyCardItem setSummonForm(RiderFormChangeItem form) {
        summonForm = form;
        return this;
    }

    public LegendChemyCardItem addSummonWeapon(Item weapon) {
        summonWeapons.add(weapon);
        return this;
    }

    public void summon(ItemStack stack, Level level, Player player) {
		RiderSummonEntity summon = MobsCore.RIDER_SUMMON.get().create(level);
		if (summon != null) {
			summon.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
			summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(summonBelt.helmet));
			summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(summonBelt.chestplate));
			summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(summonBelt.leggings));
			summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(summonBelt));
            if (!summonWeapons.isEmpty()) summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(summonWeapons.get(0)));
            if (summonWeapons.size() == 2) summon.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(summonWeapons.get(1)));
            if (summonForm != null) RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), summonForm, 1);
            if (this == GotchardRiderItems.GEATS_RIDE_CHEMY_CARD.get()) RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.MAGNUM_RAISE_BUCKLE.get(), 2);
            if (this == GotchardRiderItems.GEATS_RIDE_CHEMY_CARD.get()) RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.BOOST_RAISE_BUCKLE.get(), 3);

            level.addFreshEntity(summon);
			summon.bindToPlayer(player);
            summon.takeSummonItem(stack);
            player.awardStat(Stats.ITEM_USED.get(this));
        }
    }
}
