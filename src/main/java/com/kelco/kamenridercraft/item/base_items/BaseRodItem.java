package com.kelco.kamenridercraft.item.base_items;


import com.google.common.collect.ImmutableMultimap;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class BaseRodItem extends FishingRodItem {
    private Item craftingRemainingItem = null;
    private Item changedRepairItem = ModdedItemCore.RIDER_CIRCUIT.get();

    public BaseRodItem(Tier toolTier, int Atk, float Spd, Properties prop) {
        super(prop.durability(toolTier.getUses()).attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
    }

    public BaseRodItem changeRepairItem(Item item) {
        changedRepairItem = item;
        return this;
    }

    public boolean isValidRepairItem(@NotNull ItemStack itemStackOne, ItemStack repairItem) {
        return repairItem.getItem() == changedRepairItem;
    }

    public BaseRodItem addToList(List<Item> TabList, int num) {
        for (int i = 0; i < num; i++) {
            TabList.add(this);
        }
        return this;
    }

    public BaseRodItem addToList(List<Item> TabList) {
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

    public static void setMode(ItemStack itemstack) {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
            itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        CompoundTag tag = Objects.requireNonNull(itemstack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
        tag.putInt("item_mode", getMode(itemstack) == 0 ? 1 : 0);
    }

    public BaseRodItem keepDiffItem(Item item) {
        craftingRemainingItem = item;
        return this;
    }

    public BaseRodItem keepItem() {
        craftingRemainingItem = this;
        return this;
    }

    public @NotNull ItemStack getCraftingRemainingItem(ItemStack stack) {
        if (stack.getItem() instanceof BaseRodItem) {
            if (!hasCraftingRemainingItem(stack)) {
                return ItemStack.EMPTY;
            }
            return new ItemStack(craftingRemainingItem);
        }
        return new ItemStack(this.getCraftingRemainingItem());
    }


    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return ((BaseRodItem) stack.getItem()).craftingRemainingItem != null;
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }
}