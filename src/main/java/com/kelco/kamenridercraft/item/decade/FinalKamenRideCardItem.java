package com.kelco.kamenridercraft.item.decade;

import java.util.ArrayList;
import java.util.List;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.CompleteSummonEntity;
import com.kelco.kamenridercraft.item.*;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;

import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class FinalKamenRideCardItem extends BaseItem {
    private RiderDriverItem summonBelt;
    private RiderFormChangeItem summonForm;
    private Integer summonNeoBelt = null;
    private Integer summonNeoForm = null;
    private Integer summonNeoSlot = null;
    private List<Object> summonWeapons = new ArrayList<>(2);

    public FinalKamenRideCardItem( Properties properties) {
        super(properties);
    }

    public FinalKamenRideCardItem setSummonBelt(RiderDriverItem belt) {
        summonBelt = belt;
        return this;
    }

    public FinalKamenRideCardItem setSummonBelt(int neoBelt) {
        summonNeoBelt = neoBelt;
        return this;
    }

    public FinalKamenRideCardItem setSummonForm(RiderFormChangeItem form) {
        summonForm = form;
        return this;
    }

    public FinalKamenRideCardItem setSummonForm(int neoForm, int neoSlot) {
        summonNeoForm = neoForm;
        summonNeoSlot = neoSlot;
        return this;
    }

    public FinalKamenRideCardItem addSummonWeapon(Item weapon) {
        summonWeapons.add(weapon);
        return this;
    }

    public FinalKamenRideCardItem addSummonWeapon(int neoWeapon) {
        summonWeapons.add(neoWeapon);
        return this;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if (!level.isClientSide() && BELT.getItem() instanceof RiderDriverItem belt && belt.isTransformed(player)
        && ((this.summonNeoBelt == null && (RiderDriverItem.get_Form_Item(BELT, 1) == Decade_Rider_Items.K_TOUCH.get() || RiderDriverItem.get_Form_Item(BELT, 1) == Gotchard_Rider_Items.DECADE_COMPLETE_RIDE_CHEMY_CARD.get())) || RiderDriverItem.get_Form_Item(BELT, 1) == Decade_Rider_Items.K_TOUCH_21.get())) {
            if (this.summonNeoBelt != null) summonBelt = (RiderDriverItem) Decade_Rider_Items.NEO_DIEND_SUMMON_BELTS.get(summonNeoBelt);
            
			CompleteSummonEntity summon = MobsCore.COMPLETE_SUMMON.get().create(level);
			if (summon != null) {
				summon.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
				summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(summonBelt.HEAD));
				summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(summonBelt.TORSO));
				summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(summonBelt.LEGS));
				summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(summonBelt));
                if (!summonWeapons.isEmpty()) summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(summonWeapons.get(0) instanceof Item item ? item : Decade_Rider_Items.COMPLETE_21_WEAPONS.get((int) summonWeapons.get(0))));
                if (summonWeapons.size() == 2) summon.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(summonWeapons.get(1) instanceof Item item ? item : Decade_Rider_Items.COMPLETE_21_WEAPONS.get((int) summonWeapons.get(1))));
                if (summonNeoBelt == null) {
                    summon.addRequiredForm((RiderFormChangeItem)Decade_Rider_Items.K_TOUCH.get(), 1);
                    summon.addRequiredForm((RiderFormChangeItem)Gotchard_Rider_Items.DECADE_COMPLETE_RIDE_CHEMY_CARD.get(), 1);
                }
                if (summonForm != null) RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), summonForm, 1);
                else if (summonNeoForm != null) {
                    RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), Decade_Rider_Items.COMPLETE_21_FORMS.get(summonNeoForm), summonNeoSlot);
                    switch (summonNeoForm) {
                        case 1:
                            RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.TRICERA_MEDAL.get(), 2);
                            RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.TYRANNO_MEDAL.get(), 3);
                            break;
                        case 2:
                            RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), Fourze_Rider_Items.FOURZE_COSMIC_STATES.get(), 5);
                            break;
                        case 4:
                            summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.COMPLETE_21_WEAPONS.get(summon.getRandom().nextInt(5, 15))));
                            break;
                        case 6:
                            RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), Ghost_Rider_Items.MUGEN_GHOST_EYECON.get(), 1);
                            break;
                    }
                }
            
				level.addFreshEntity(summon);
				summon.bindToPlayer(player);
				player.displayClientMessage(Component.translatable(this.toString() + ".name"), true);
				if (!player.isCreative()) player.getCooldowns().addCooldown(this, 1000);
                player.awardStat(Stats.ITEM_USED.get(this));
			}
        }
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(usedHand), level.isClientSide());
    }
}