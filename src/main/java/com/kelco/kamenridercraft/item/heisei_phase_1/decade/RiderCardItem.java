package com.kelco.kamenridercraft.item.heisei_phase_1.decade;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.DecadeRiderItems;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;


public class RiderCardItem extends RiderFormChangeItem {
    private RiderDriverItem summonBelt;
    private RiderFormChangeItem summonForm = null;
    private Integer summonNeoBelt = null;
    private Integer summonNeoForm = null;
    private List<Object> summonWeapons = new ArrayList<>(2);

    public RiderCardItem( Properties properties,String formName,String ridername,String beltTex, MobEffectInstance... effects) {
        super(properties, formName, ridername, beltTex, effects);
    }

    public RiderCardItem setSummonBelt(RiderDriverItem belt) {
        summonBelt = belt;
        return this;
    }

    public RiderCardItem setSummonBelt(int neoBelt) {
        summonNeoBelt = neoBelt;
        return this;
    }

    public RiderCardItem setSummonForm(RiderFormChangeItem form) {
        summonForm = form;
        return this;
    }

    public RiderCardItem setSummonForm(int neoForm) {
        summonNeoForm = neoForm;
        return this;
    }

    public RiderCardItem addSummonWeapon(Item weapon) {
        summonWeapons.add(weapon);
        return this;
    }

    public RiderCardItem addSummonWeapon(int neoWeapon) {
        summonWeapons.add(neoWeapon);
        return this;
    }

    public void summon(ItemStack stack, Level level, Player player) {
        if (this.summonNeoBelt != null) summonBelt = (RiderDriverItem) DecadeRiderItems.NEO_DIEND_SUMMON_BELTS.get(summonNeoBelt);

		RiderSummonEntity summon = MobsCore.RIDER_SUMMON.get().create(level);
		if (summon != null) {
			summon.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
			summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(summonBelt.HEAD));
			summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(summonBelt.TORSO));
			summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(summonBelt.LEGS));
			summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(summonBelt));
            if (!summonWeapons.isEmpty()) summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(summonWeapons.get(0) instanceof Item item ? item : DecadeRiderItems.NEO_DIEND_SUMMON_WEAPONS.get((int) summonWeapons.get(0))));
            if (summonWeapons.size() == 2) summon.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(summonWeapons.get(1) instanceof Item item ? item : DecadeRiderItems.NEO_DIEND_SUMMON_WEAPONS.get((int) summonWeapons.get(1))));
            if (summonForm != null) RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), summonForm, 1);
            else if (summonNeoForm != null) RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), DecadeRiderItems.NEO_DIEND_SUMMON_FORMS.get(summonNeoForm), 1);

			level.addFreshEntity(summon);
			summon.bindToPlayer(player);
            summon.takeSummonItem(stack);
            player.awardStat(Stats.ITEM_USED.get(this));
		}
    }
}
