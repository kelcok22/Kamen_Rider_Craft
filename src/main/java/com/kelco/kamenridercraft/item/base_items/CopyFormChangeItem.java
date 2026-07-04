package com.kelco.kamenridercraft.item.base_items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class CopyFormChangeItem extends BaseItem {
    private RiderFormChangeItem formItem;

    public CopyFormChangeItem(Properties properties, Item form_item) {
        super(properties);
        if (form_item instanceof RiderFormChangeItem form) formItem = form;

    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(@NotNull ItemStack stack, @NotNull Player player, @NotNull LivingEntity interactionTarget, @NotNull InteractionHand usedHand) {
        if (formItem != null && !player.level().isClientSide()) {
            formItem.interactLivingEntity(stack, player, interactionTarget, usedHand);
        }
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemStack = player.getItemInHand(usedHand);
        if (formItem != null && !level.isClientSide()) {
            formItem.use(level, player, usedHand);
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}