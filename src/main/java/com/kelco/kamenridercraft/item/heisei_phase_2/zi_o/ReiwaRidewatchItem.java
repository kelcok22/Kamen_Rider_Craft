package com.kelco.kamenridercraft.item.heisei_phase_2.zi_o;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.summons.GrandSummonEntity;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ZiORiderItems;
import com.kelco.kamenridercraft.item.reiwa.GeatsRiderItems;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReiwaRidewatchItem extends BaseItem {
    private String summonBelt;
    private String summonForm;
    private Map<String, String[]> summonAltForms = new HashMap<>();
    private Map<String, String> summonAltBelts = new HashMap<>();
    private Map<String, String[]> summonAltWeapons = new HashMap<>();
    private List<String> summonWeapons = new ArrayList<>(2);

    public ReiwaRidewatchItem(Properties properties, String belt) {
        super(properties);
        summonBelt = belt;
    }

    public ReiwaRidewatchItem(Properties properties, String belt, String form) {
        super(properties);
        summonBelt = belt;
        summonForm = form;
    }

    public ReiwaRidewatchItem addAltForm(String item, String... forms) {
        this.summonAltForms.put(item, forms);
        return this;
    }

    public ReiwaRidewatchItem addAltWeapon(String item, String... weapons) {
        this.summonAltWeapons.put(item, weapons);
        return this;
    }

    public ReiwaRidewatchItem addAltBelt(String item, String belt) {
        this.summonAltBelts.put(item, belt);
        return this;
    }

    public ReiwaRidewatchItem addSummonWeapon(String weapon) {
        this.summonWeapons.add(weapon);
        return this;
    }

    public void summon(Level level, Player player) {
		GrandSummonEntity summon = MobsCore.GRAND_SUMMON.get().create(level);
		if (summon != null) {
            summon.allowFormChanges(true);
            RiderDriverItem belt = (RiderDriverItem) BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonBelt));

			summon.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
			summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(belt.HEAD));
			summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(belt.TORSO));
			summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(belt.LEGS));
            Item key = player.getOffhandItem().getItem();

            if (this.summonAltBelts.containsKey(key.toString())) {
                summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonAltBelts.get(key.toString())))));
            } else summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(belt));
            
            if (this.summonAltWeapons.containsKey(key.toString())) {
                summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonAltWeapons.get(key.toString())[0]))));
                if (this.summonAltWeapons.get(key.toString()).length > 1) summon.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonAltWeapons.get(key.toString())[1]))));
            } else if (!this.summonWeapons.isEmpty()) {
                summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonWeapons.get(0)))));
                if (this.summonWeapons.size() == 2) summon.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonWeapons.get(1)))));
            }

            if (this.summonForm != null) {
                RiderFormChangeItem form = (RiderFormChangeItem) BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonForm));
                RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), form, form.getSlot());
            }
            if (key instanceof RiderFormChangeItem formItem) {
                if (this == ZiORiderItems.GEATS_RIDEWATCH.get()) {
                    if (key == GeatsRiderItems.GEATS_CORE_ID.get()) RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), ModdedItemCore.BLANK_FORM.get(), 2);
                    else if (key == GeatsRiderItems.COMMAND_TWIN_BUCKLE_CANNON.get()) RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.COMMAND_TWIN_BUCKLE_JET.get(), 3);
                    else if (key == GeatsRiderItems.UNITE_GRIP.get()) RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.BOOST_MKII_RAISE_BUCKLE.get(), 3);
                    else if (key == GeatsRiderItems.BOOST_MKIII_RAISE_BUCKLE.get()||key == GeatsRiderItems.ONENESS_RAISE_BUCKLE.get()) RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.BOOST_MKIII_RAISE_BUCKLE.get(), 3);
                    RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), formItem, formItem.getSlot());
                } else formItem.interactLivingEntity(player.getOffhandItem(), player, summon, InteractionHand.OFF_HAND);
            } else if (this == ZiORiderItems.GEATS_RIDEWATCH.get()) {
                if (key == GeatsRiderItems.POWERED_BUILDER_RAISE_BUCKLE.get()) RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.GIGANT_CONTAINER_BUCKLE.get(), 3);
                else if (key == GeatsRiderItems.FEVER_SLOT_RAISE_BUCKLE.get()) RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.MAGNUM_RAISE_BUCKLE.get(), 3);
                else if (key == GeatsRiderItems.FANTASY_RAISE_BUCKLE.get()) RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), ModdedItemCore.BLANK_FORM.get(), 3);
                else RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.BOOST_RAISE_BUCKLE.get(), 3);
            }
            for (ItemStack weapon : summon.getHandSlots()) weapon.set(DataComponents.ITEM_NAME, Component.translatable("owner.kamenridercraft.zi_o", weapon.getHoverName()));

            if (this.summonAltForms.containsKey(key.toString())) {
                for (String str : this.summonAltForms.get(key.toString())) {
                    RiderFormChangeItem form = (RiderFormChangeItem) BuiltInRegistries.ITEM.get(ResourceLocation.parse(str));
                    RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), form, form.getSlot());
                }
            }
        
			level.addFreshEntity(summon);
			summon.bindToPlayer(player);
            summon.allowFormChanges(false);
            if (!player.isCreative()) player.getCooldowns().addCooldown(this, 400);
            player.awardStat(Stats.ITEM_USED.get(this));
		}
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if (level.getGameRules().getBoolean(ModGameRules.RULE_REIWA_RIDEWATCHES) && player.isShiftKeyDown() && BELT.getItem() instanceof RiderDriverItem driver && driver.isTransformed(player)
        && (RiderDriverItem.getFormItem(BELT, 1) == ZiORiderItems.UNFINISHED_OHMA_ZI_O_DRIVER_L.get()
        || RiderDriverItem.getFormItem(BELT, 1) == ZiORiderItems.OHMA_ZI_O_RIDEWATCH.get())) {
            summon(level, player);
            return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
        }
        return super.use(level, player, usedHand);

    }
}
