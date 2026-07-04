package com.kelco.kamenridercraft.item.base_items;

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

public class BasePickaxeItem extends PickaxeItem {

    private Item changedRepairItem = ModdedItemCore.RIDER_CIRCUIT.get();
    private Item formChangeItem;
    private Item henshinBeltItem;
    private Boolean changePick = false;
    private Boolean formItem = false;
    private Boolean henshinItem = false;
    private Item craftingRemainingItem = null;


    public BasePickaxeItem(Tier toolTier, int Atk, float Spd, Properties prop) {
        super(toolTier, prop.attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));
    }

    public BasePickaxeItem changeRepairItem(Item newRepairItem) {
        changedRepairItem = newRepairItem;
        return this;
    }

    public boolean isValidRepairItem(@NotNull ItemStack itemStackOne, ItemStack repairItem) {
        return repairItem.getItem() == changedRepairItem;
    }

    public BasePickaxeItem addToList(List<Item> TabList, int num) {
        for (int i = 0; i < num; i++) {
            TabList.add(this);
        }
        return this;
    }

    public BasePickaxeItem addToList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }

    public static int getMode(ItemStack itemstack) {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
            return 0;
        }
        CompoundTag tag = Objects.requireNonNull(itemstack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
        return tag.getInt("item_mode");
    }

    public BasePickaxeItem isFormItem(Item item) {
        formItem = true;
        formChangeItem = item;
        return this;
    }

    public BasePickaxeItem isHenshinItem(Item item) {
        henshinItem = true;
        henshinBeltItem = item;
        return this;
    }

    public static void setMode(ItemStack itemstack) {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
            itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        CompoundTag tag = Objects.requireNonNull(itemstack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
        tag.putInt("item_mode", getMode(itemstack) == 0 ? 1 : 0);
    }

    public BasePickaxeItem keepDiffItem(Item item) {
        craftingRemainingItem = item;
        return this;
    }

    public BasePickaxeItem keepItem() {
        craftingRemainingItem = this;
        return this;
    }

    public @NotNull ItemStack getCraftingRemainingItem(ItemStack stack) {
        if (stack.getItem() instanceof BasePickaxeItem) {
            if (!hasCraftingRemainingItem(stack)) {
                return ItemStack.EMPTY;
            }
            return new ItemStack(craftingRemainingItem);
        }
        return new ItemStack(this.getCraftingRemainingItem());
    }


    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return ((BasePickaxeItem) stack.getItem()).craftingRemainingItem != null;
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(@NotNull ItemStack stack, @NotNull Player player, @NotNull LivingEntity interactionTarget, @NotNull InteractionHand usedHand) {
        if (formItem) formChangeItem.interactLivingEntity(stack, player, interactionTarget, usedHand);
        return InteractionResult.PASS;
    }

    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        if (!level.isClientSide()) {
            if (henshinItem && player.getItemBySlot(EquipmentSlot.FEET) == ItemStack.EMPTY) {
                player.setItemSlot(EquipmentSlot.FEET, new ItemStack(henshinBeltItem));
                if (player.getOffhandItem().getItem() instanceof RiderFormChangeItem form)
                    form.use(level, player, InteractionHand.OFF_HAND);
            }
            if (formItem && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem) {
                formChangeItem.use(level, player, interactionHand);
            }
            if (changePick) {
                if (player.isShiftKeyDown()) {
                    setMode(itemstack);
                }
                getMode(itemstack);
            }
        }
        return InteractionResultHolder.pass(itemstack);
    }
}