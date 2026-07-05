package com.kelco.kamenridercraft.item.reiwa.gavv;

import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.reiwa.GavvRiderItems;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class GochipodItem extends BaseItem {
    public GochipodItem(Properties prop) {
        super(prop.stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.gochipod.stored").getString() + ":" + getStoreItem(stack) + "/100"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player)
            if (getStoreItem(itemStack) == 100) {
                player.getInventory().setItem(slotId, new ItemStack(GavvRiderItems.GOCHIPOD.asItem()));
            }
    }

    public static int getStoreItem(ItemStack itemstack) {
        if (itemstack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = Objects.requireNonNull(itemstack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
            return tag.getInt("store");
        }
        return 0;
    }

    public static void setStoreItem(ItemStack itemstack, int num) {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        Consumer<CompoundTag> data = form -> form.putInt("store", num + getStoreItem(itemstack));
        CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
    }
}