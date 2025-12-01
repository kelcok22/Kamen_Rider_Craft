package com.kelco.kamenridercraft.item.zi_o;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.GrandSummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.CopyFormChangeItem;
import com.kelco.kamenridercraft.item.Zi_O_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;

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
import net.neoforged.fml.ModList;


public class OhmaRidewatchItem extends BaseItem {
    private RiderDriverItem summonBelt;
    private RiderFormChangeItem summonForm = null;
    private Map<Item, RiderFormChangeItem[]> summonAltForms = new HashMap<>();
    private Map<Item, RiderDriverItem> summonAltBelts = new HashMap<>();
    private Map<Item, Item[]> summonAltWeapons = new HashMap<>();
    private List<Item> summonWeapons = new ArrayList<>(2);

    public OhmaRidewatchItem(Properties properties) {
        super(properties);
    }

    public OhmaRidewatchItem setSummonBelt(RiderDriverItem belt) {
        this.summonBelt = belt;
        return this;
    }

    public OhmaRidewatchItem setSummonForm(RiderFormChangeItem form) {
        this.summonForm = form;
        return this;
    }

    public OhmaRidewatchItem addAltForm(Item item, RiderFormChangeItem... forms) {
        this.summonAltForms.put(item, forms);
        return this;
    }

    public OhmaRidewatchItem addAltBelt(Item item, RiderDriverItem belt) {
        this.summonAltBelts.put(item, belt);
        return this;
    }

    public OhmaRidewatchItem addAltWeapon(Item item, Item... weapons) {
        this.summonAltWeapons.put(item, weapons);
        return this;
    }

    public OhmaRidewatchItem addSummonWeapon(Item weapon) {
        this.summonWeapons.add(weapon);
        return this;
    }

    public void summon(Level level, Player player) {
        if (!level.isClientSide() && this == Zi_O_Rider_Items.RYUSOULGER_RIDEWATCH.get() && !ModList.get().isLoaded("supersentaicraft")) {
            player.sendSystemMessage(Component.translatable("message.kamenridercraft.ryusoul_red_fail"));
	    player.awardStat(Stats.ITEM_USED.get(this));
        } else {
		    GrandSummonEntity summon = MobsCore.GRAND_SUMMON.get().create(level);
		    if (summon != null) {
                summon.allowFormChanges(true);
		    	summon.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
                if (this == Zi_O_Rider_Items.RYUSOULGER_RIDEWATCH.get()) {
		    	    summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("supersentaicraft:ryusoulger_head"))));
		    	    summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("supersentaicraft:ryusoulger_torso"))));
		    	    summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("supersentaicraft:ryusoulger_legs"))));
		    	    summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("supersentaicraft:red_ryusoul_changer"))));
		    	    summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("supersentaicraft:ryusoul_ken"))));
                } else {
		    	    summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(this.summonBelt.HEAD));
		    	    summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(this.summonBelt.TORSO));
		    	    summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(this.summonBelt.LEGS));
                    Item key = player.getOffhandItem().getItem();

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

                    for (ItemStack weapon : summon.getHandSlots()) weapon.set(DataComponents.ITEM_NAME, Component.translatable("owner.kamenridercraft.zi_o", weapon.getHoverName()));

                    if (this.summonForm != null) RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), this.summonForm, this.summonForm.getSlot());
                    if (key instanceof RiderFormChangeItem || key instanceof CopyFormChangeItem) key.interactLivingEntity(player.getOffhandItem(), player, summon, InteractionHand.OFF_HAND);
                    if (this.summonAltForms.containsKey(key)) {
                        for (RiderFormChangeItem item : this.summonAltForms.get(key)) {
                            RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), item, item.getSlot());
                        }
                    }
                }
            
		    	level.addFreshEntity(summon);
		    	summon.bindToPlayer(player);
                summon.allowFormChanges(false);
                if (!player.isCreative()) player.getCooldowns().addCooldown(this, 400);
                player.awardStat(Stats.ITEM_USED.get(this));
		    }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        Item BELT = player.getItemBySlot(EquipmentSlot.FEET).getItem();

        if (player.isShiftKeyDown() && BELT instanceof RiderDriverItem driver && driver.isTransformed(player)
        && (RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), 1) == Zi_O_Rider_Items.UNFINISHED_OHMA_ZI_O_DRIVER_L.get()
        || RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), 1) == Zi_O_Rider_Items.OHMA_ZI_O_RIDEWATCH.get())) {
            summon(level, player);
            return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
        }
        return super.use(level, player, usedHand);

    }
}
