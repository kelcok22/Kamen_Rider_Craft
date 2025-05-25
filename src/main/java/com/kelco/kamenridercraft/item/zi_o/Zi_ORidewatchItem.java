package com.kelco.kamenridercraft.item.zi_o;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;
import com.kelco.kamenridercraft.item.Zi_O_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class Zi_ORidewatchItem extends RiderFormChangeItem {
    private Map<String, String[]> summonAltForms = new HashMap<>();
    private Map<String, String[]> summonAltWeapons = new HashMap<>();
    private List<String> summonWeapons = new ArrayList<>(2);

    public Zi_ORidewatchItem( Properties properties,int belt,String formName,String ridername,String beltTex, MobEffectInstance... effects) {
        super(properties, belt, formName, ridername, beltTex, effects);
    }

    public Zi_ORidewatchItem addAltForm(String item, String... forms) {
        this.summonAltForms.put(item, forms);
        return this;
    }

    public Zi_ORidewatchItem addAltWeapon(String item, String... weapons) {
        this.summonAltWeapons.put(item, weapons);
        return this;
    }

    public Zi_ORidewatchItem addSummonWeapon(String weapon) {
        this.summonWeapons.add(weapon);
        return this;
    }

    public void summon(ItemStack stack, Level level, Player player) {
		RiderSummonEntity summon = MobsCore.RIDER_SUMMON.get().create(level);
		if (summon != null) {
			summon.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
			summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Zi_O_Rider_Items.ZI_O_HELMET.get()));
			summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Zi_O_Rider_Items.ZI_O_CHESTPLATE.get()));
			summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Zi_O_Rider_Items.ZI_O_LEGGINGS.get()));
			summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zi_O_Rider_Items.ZIKU_DRIVER_ZI_O.get()));
            Item key = player.getItemBySlot(EquipmentSlot.OFFHAND).getItem();
            
            if (this.summonAltWeapons.containsKey(key.toString())) {
                summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonAltWeapons.get(key.toString())[0]))));
                if (this.summonAltWeapons.get(key.toString()).length > 1) summon.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonAltWeapons.get(key.toString())[1]))));
            } else if (!this.summonWeapons.isEmpty()) {
                summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonWeapons.get(0)))));
                if (this.summonWeapons.size() == 2) summon.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonWeapons.get(1)))));
            }

            if (key instanceof RiderFormChangeItem formItem && formItem.iscompatible((RiderDriverItem)Zi_O_Rider_Items.ZIKU_DRIVER_ZI_O.get())
            && formItem != Zi_O_Rider_Items.OHMA_ZI_O_RIDEWATCH.get() && formItem != Zi_O_Rider_Items.WOZ_RIDEWATCH.get() && formItem != Zi_O_Rider_Items.SABER_RIDEWATCH.get()
            && (formItem != Zi_O_Rider_Items.GRAND_ZI_O_RIDEWATCH.get() || player.getItemBySlot(EquipmentSlot.FEET).getItem() == Zi_O_Rider_Items.OHMA_ZI_O_DRIVER.get())) {
                RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), formItem, 1);
                if (formItem == Zi_O_Rider_Items.GRAND_ZI_O_RIDEWATCH.get()) summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Zi_O_Rider_Items.SAIKYO_ZIKAN_GIRADE.get()));
            }
            if (this.summonAltForms.containsKey(key.toString())) {
                for (String str : this.summonAltForms.get(key.toString())) {
                    RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), (RiderFormChangeItem)BuiltInRegistries.ITEM.get(ResourceLocation.parse(str)), 1);
                }
            }
        
			level.addFreshEntity(summon);
			summon.bindToPlayer(player);

            if (key == Ex_Aid_Rider_Items.MIGHTY_BROTHERS_XX_GASHAT.get()) {
		        RiderSummonEntity summon2 = MobsCore.RIDER_SUMMON.get().create(level);
		        if (summon2 != null) {
		        	summon2.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
		        	summon2.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Zi_O_Rider_Items.ZI_O_HELMET.get()));
		        	summon2.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Zi_O_Rider_Items.ZI_O_CHESTPLATE.get()));
		        	summon2.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Zi_O_Rider_Items.ZI_O_LEGGINGS.get()));
		        	summon2.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zi_O_Rider_Items.ZIKU_DRIVER_ZI_O.get()));
		        	summon2.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Zi_O_Rider_Items.ZIKAN_GIRADE.get()));
                    RiderDriverItem.set_Form_Item(summon2.getItemBySlot(EquipmentSlot.FEET), Zi_O_Rider_Items.DECADE_EX_AID_RIDEWATCH_L.get(), 1);
		        	level.addFreshEntity(summon2);
		        	summon2.bindToPlayer(player);
		        }
            }
            if (!player.isCreative()) player.getCooldowns().addCooldown(this, 200);
            player.awardStat(Stats.ITEM_USED.get(this));
		}
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if (player.isShiftKeyDown() && BELT.getItem() instanceof RiderDriverItem driver && driver.isTransformed(player)
        && (RiderDriverItem.get_Form_Item(BELT, 1) == Zi_O_Rider_Items.GRAND_ZI_O_RIDEWATCH.get()
        || RiderDriverItem.get_Form_Item(BELT, 1) == Zi_O_Rider_Items.UNFINISHED_OHMA_ZI_O_DRIVER_L.get())) {
            summon(itemstack, level, player);
            return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
        }
        return super.use(level, player, usedHand);

    }
}
