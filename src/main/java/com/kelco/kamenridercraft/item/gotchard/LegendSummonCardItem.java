package com.kelco.kamenridercraft.item.gotchard;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;


public class LegendSummonCardItem extends BaseItem {
    private RiderDriverItem summonBelt;
    private RiderFormChangeItem summonForm;
    private List<Item> summonWeapons = new ArrayList<>(2);

    public LegendSummonCardItem(Properties properties) {
        super(properties);
    }

    public LegendSummonCardItem setSummonBelt(RiderDriverItem belt) {
        summonBelt = belt;
        return this;
    }

    public LegendSummonCardItem setSummonForm(RiderFormChangeItem form) {
        summonForm = form;
        return this;
    }

    public LegendSummonCardItem addSummonWeapon(Item weapon) {
        summonWeapons.add(weapon);
        return this;
    }

    public void summon(ItemStack stack, Level level, Player player) {
		RiderSummonEntity summon = MobsCore.RIDER_SUMMON.get().create(level);
		if (summon != null) {
			summon.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
			summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(summonBelt.HEAD));
			summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(summonBelt.TORSO));
			summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(summonBelt.LEGS));
			summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(summonBelt));
            if (!summonWeapons.isEmpty()) summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(summonWeapons.get(0)));
            if (summonWeapons.size() == 2) summon.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(summonWeapons.get(1)));
            if (summonForm != null) RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), summonForm, 1);

			level.addFreshEntity(summon);
			summon.bindToPlayer(player);
            summon.takeSummonItem(stack);
            player.awardStat(Stats.ITEM_USED.get(this));
		}
    }
}