package com.kelco.kamenridercraft.item.zi_o;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.GrandSummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.Geats_Rider_Items;
import com.kelco.kamenridercraft.item.Zi_O_Rider_Items;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public class ReiwaRidewatchItem extends BaseItem {
    private String summonBelt;
    private String summonForm;
    //private Map<String, String[]> summonAltForms = new HashMap<>();
    //private Map<String, String[]> summonAltWeapons = new HashMap<>();
    private List<String> summonWeapons = new ArrayList<>(2);

    public ReiwaRidewatchItem(Properties properties, String belt, String form) {
        super(properties);
        summonBelt = belt;
        summonForm = form;
    }

    /*public ReiwaRidewatchItem addAltForm(String item, String... forms) {
        this.summonAltForms.put(item, forms);
        return this;
    }

    public ReiwaRidewatchItem addAltWeapon(String item, String... weapons) {
        this.summonAltWeapons.put(item, weapons);
        return this;
    }*/

    public ReiwaRidewatchItem addSummonWeapon(String weapon) {
        this.summonWeapons.add(weapon);
        return this;
    }

    public void summon(Level level, Player player) {
		GrandSummonEntity summon = MobsCore.GRAND_SUMMON.get().create(level);
		if (summon != null) {
            RiderDriverItem belt = (RiderDriverItem) BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonBelt));
            RiderFormChangeItem form = (RiderFormChangeItem) BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonForm));

			summon.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
			summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(belt.HEAD));
			summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(belt.TORSO));
			summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(belt.LEGS));
			summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(belt));
            //Item key = player.getOffhandItem().getItem();
            
            /*if (this.summonAltWeapons.containsKey(key.toString())) {
                summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonAltWeapons.get(key.toString())[0]))));
                if (this.summonAltWeapons.get(key.toString()).length > 1) summon.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonAltWeapons.get(key.toString())[1]))));
            } else*/ if (!this.summonWeapons.isEmpty()) {
                summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonWeapons.get(0)))));
                if (this.summonWeapons.size() == 2) summon.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonWeapons.get(1)))));
            }

            if (this.summonForm != null) RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), form, form.getSlot());
            if (this == Zi_O_Rider_Items.GEATS_RIDEWATCH.get()) RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.BOOST_RAISE_BUCKLE.get(), 3);
            for (ItemStack weapon : summon.getHandSlots()) weapon.set(DataComponents.ITEM_NAME, Component.translatable("owner.kamenridercraft.zi_o", weapon.getHoverName()));

            /*if (key instanceof RiderFormChangeItem formItem && formItem.iscompatible((RiderDriverItem)summon.getItemBySlot(EquipmentSlot.FEET).getItem())) {
                RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), formItem, formItem.getSlot());
            }
            if (this.summonAltForms.containsKey(key.toString())) {
                for (String str : this.summonAltForms.get(key.toString())) {
                    RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), (RiderFormChangeItem)BuiltInRegistries.ITEM.get(ResourceLocation.parse(str)), 1);
                }
            }*/
        
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

        if (level.getGameRules().getBoolean(ModGameRules.RULE_REIWA_RIDEWATCHES) && player.isShiftKeyDown() && BELT.getItem() instanceof RiderDriverItem driver && driver.isTransformed(player)
        && (RiderDriverItem.get_Form_Item(BELT, 1) == Zi_O_Rider_Items.UNFINISHED_OHMA_ZI_O_DRIVER_L.get()
        || RiderDriverItem.get_Form_Item(BELT, 1) == Zi_O_Rider_Items.OHMA_ZI_O_RIDEWATCH.get())) {
            summon(level, player);
            return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
        }
        return super.use(level, player, usedHand);

    }
}
