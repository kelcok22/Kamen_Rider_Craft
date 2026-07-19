package com.kelco.kamenridercraft.mixin.compat;

import com.kelco.kamenridercraft.item.reiwa.GavvRiderItems;
import einstein.jmc.block.cake.BaseCakeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(value = BaseCakeBlock.class, remap = false)
public class JMCGochizoCakeBlock {

    @Inject(method = "eat", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/food/FoodData;eat(IF)V"))
    private static void eat(Level level, BlockPos pos, BlockState state, Player player, CallbackInfoReturnable<InteractionResult> cir) {
        if (!player.level().isClientSide && player.canEat(false) && player.getInventory().countItem(GavvRiderItems.BLANK_GOCHIZO.get()) > 0) {
            if (player.getInventory().getItem(40).getItem() == GavvRiderItems.BLANK_GOCHIZO.get()) {
                player.getInventory().removeItem(40, 1);
            } else {
                player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(GavvRiderItems.BLANK_GOCHIZO.get())), 1);
            }

            player.drop(new ItemStack(GavvRiderItems.CAKE.get(new Random().nextInt(GavvRiderItems.CAKE.size()))), false);
        }
    }
}