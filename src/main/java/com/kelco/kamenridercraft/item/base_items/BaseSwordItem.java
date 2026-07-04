package com.kelco.kamenridercraft.item.base_items;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class BaseSwordItem extends SwordItem {

    private Item changedRepairItem = ModdedItemCore.RIDER_CIRCUIT.get();
    private Item formChangeItem;
    private Item henshinBeltItem;
    private Boolean changeSword = false;
    private Boolean formItem = false;
    private Boolean henshinItem = false;
    private Item craftingRemainingItem = null;


    public BaseSwordItem(Tier toolTier, int Atk, float Spd, Properties prop) {
        super(toolTier, prop.attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));

    }

    public BaseSwordItem changeRepairItem(Item item) {
        changedRepairItem = item;
        return this;
    }

    public boolean isValidRepairItem(@NotNull ItemStack itemStackOne, ItemStack repairItem) {
        return repairItem.getItem() == changedRepairItem;
    }

    public BaseSwordItem addToList(List<Item> TabList, int num) {
        for (int i = 0; i < num; i++) {
            TabList.add(this);
        }
        return this;
    }

    public BaseSwordItem addToList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }

    public static int getMode(ItemStack itemStack) {
        if (!itemStack.has(DataComponents.CUSTOM_DATA)) {
            return 0;
        }
        CompoundTag tag = itemStack.get(DataComponents.CUSTOM_DATA).getUnsafe();
        return tag.getInt("item_mode");
    }

    public BaseSwordItem isFormItem(Item item) {
        formItem = true;
        formChangeItem = item;
        return this;
    }

    public BaseSwordItem isHenshinItem(Item item) {
        henshinItem = true;
        henshinBeltItem = item;
        return this;
    }

    public BaseSwordItem isChangeSword() {
        changeSword = true;
        KamenRiderCraftCore.CHANGE_SWORD_ITEM.add(this);
        return this;
    }

    public static void setMode(ItemStack itemStack) {
        if (!itemStack.has(DataComponents.CUSTOM_DATA)) {
            itemStack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        CompoundTag tag = Objects.requireNonNull(itemStack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
        tag.putInt("item_mode", getMode(itemStack) == 0 ? 1 : 0);
    }

    public BaseSwordItem keepDiffItem(Item Diff) {
        craftingRemainingItem = Diff;
        return this;
    }

    public BaseSwordItem KeepItem() {
        craftingRemainingItem = this;
        return this;
    }

    public @NotNull ItemStack getCraftingRemainingItem(ItemStack stack) {
        if (stack.getItem() instanceof BaseSwordItem) {
            if (!hasCraftingRemainingItem(stack)) {
                return ItemStack.EMPTY;
            }
            return new ItemStack(craftingRemainingItem);
        } else return new ItemStack(this.getCraftingRemainingItem());
    }


    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return ((BaseSwordItem) stack.getItem()).craftingRemainingItem != null;
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(@NotNull ItemStack stack, @NotNull Player player, @NotNull LivingEntity interactionTarget, @NotNull InteractionHand usedHand) {
        if (formItem) {
            formChangeItem.interactLivingEntity(stack, player, interactionTarget, usedHand);
        }
        return InteractionResult.PASS;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (henshinItem && player.getItemBySlot(EquipmentSlot.FEET) == ItemStack.EMPTY) {
            player.setItemSlot(EquipmentSlot.FEET, new ItemStack(henshinBeltItem));
            if (player.getOffhandItem().getItem() instanceof RiderFormChangeItem form)
                form.use(level, player, InteractionHand.OFF_HAND);
        }
        if (formItem && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem) {
            formChangeItem.use(level, player, interactionHand);
        }
        if (changeSword) {
            if (player.isShiftKeyDown()) {
                setMode(itemStack);
            }
            getMode(itemStack);
        }
        return InteractionResultHolder.pass(player.getItemInHand(interactionHand));
    }
}