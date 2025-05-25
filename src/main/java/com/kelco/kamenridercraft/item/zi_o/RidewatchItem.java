package com.kelco.kamenridercraft.item.zi_o;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.Zi_O_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;

import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class RidewatchItem extends RiderFormChangeItem {
    private RiderDriverItem summonBelt;
    private RiderFormChangeItem summonForm = null;
    private Map<Item, RiderFormChangeItem[]> summonAltForms = new HashMap<>();
    private Map<Item, RiderDriverItem> summonAltBelts = new HashMap<>();
    private Map<Item, Item[]> summonAltWeapons = new HashMap<>();
    private List<Item> summonWeapons = new ArrayList<>(2);

    public RidewatchItem( Properties properties,int belt,String formName,String ridername,String beltTex, MobEffectInstance... effects) {
        super(properties, belt, formName, ridername, beltTex, effects);
    }

    public RidewatchItem setSummonBelt(RiderDriverItem belt) {
        this.summonBelt = belt;
        return this;
    }

    public RidewatchItem setSummonForm(RiderFormChangeItem form) {
        this.summonForm = form;
        return this;
    }

    public RidewatchItem addAltForm(Item item, RiderFormChangeItem... forms) {
        this.summonAltForms.put(item, forms);
        return this;
    }

    public RidewatchItem addAltBelt(Item item, RiderDriverItem belt) {
        this.summonAltBelts.put(item, belt);
        return this;
    }

    public RidewatchItem addAltWeapon(Item item, Item... weapons) {
        this.summonAltWeapons.put(item, weapons);
        return this;
    }

    public RidewatchItem addSummonWeapon(Item weapon) {
        this.summonWeapons.add(weapon);
        return this;
    }

    public void summon(ItemStack stack, Level level, Player player) {
		RiderSummonEntity summon = MobsCore.RIDER_SUMMON.get().create(level);
		if (summon != null) {
			summon.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
			summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(this.summonBelt.HEAD));
			summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(this.summonBelt.TORSO));
			summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(this.summonBelt.LEGS));
            Item key = player.getItemBySlot(EquipmentSlot.OFFHAND).getItem();

			if (this.summonAltBelts.containsKey(key)) {
                summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(this.summonAltBelts.get(key)));
            } else summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(this.summonBelt));
            
            if (this.summonAltWeapons.containsKey(key)) {
                summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(this.summonAltWeapons.get(key)[0]));
                if (this.summonAltWeapons.get(key).length > 1) summon.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(this.summonAltWeapons.get(key)[1]));
            } else if (!summonWeapons.isEmpty()) {
                summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(this.summonWeapons.get(0)));
                if (this.summonWeapons.size() == 2) summon.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(summonWeapons.get(1)));
            }

            if (this.summonForm != null) RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), this.summonForm, 1);
            if (key instanceof RiderFormChangeItem formItem && formItem.iscompatible((RiderDriverItem)summon.getItemBySlot(EquipmentSlot.FEET).getItem())) {
                RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), formItem, formItem.getSlot());
            }
            if (this.summonAltForms.containsKey(key)) {
                for (RiderFormChangeItem item : this.summonAltForms.get(key)) {
                    RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), item, item.getSlot());
                }
            }
        
			level.addFreshEntity(summon);
			summon.bindToPlayer(player);
            if (!player.isCreative()) player.getCooldowns().addCooldown(this, 200);
            player.awardStat(Stats.ITEM_USED.get(this));
		}
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if (player.isShiftKeyDown() && BELT.getItem() instanceof RiderDriverItem driver && driver.isTransformed(player)
        && (RiderDriverItem.get_Form_Item(BELT, 1) == Zi_O_Rider_Items.GRAND_ZI_O_RIDEWATCH.get() && (this != Zi_O_Rider_Items.BIO_RIDER_RIDEWATCH.get() && this != Zi_O_Rider_Items.GENM_RIDEWATCH.get())
        || RiderDriverItem.get_Form_Item(BELT, 1) == Zi_O_Rider_Items.UNFINISHED_OHMA_ZI_O_DRIVER_L.get())) {
            summon(itemstack, level, player);
            return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
        }
        return super.use(level, player, usedHand);

    }
}
