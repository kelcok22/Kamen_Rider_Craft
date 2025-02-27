package com.kelco.kamenridercraft.mixin.block;

import com.kelco.kamenridercraft.item.Gavv_Rider_Items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = CakeBlock.class)
public class GochizoCakeBlock {

    @Inject(method = "eat", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/food/FoodData;eat(IF)V"))
    private static void eat(LevelAccessor level, BlockPos pos, BlockState state, Player player, CallbackInfoReturnable<InteractionResult> cir) {
        if (!player.level().isClientSide && state.getBlock() instanceof CakeBlock
        && player.canEat(false) && player.getInventory().countItem(Gavv_Rider_Items.BLANK_GOCHIZO.get()) > 0) {
            if (player.getInventory().getItem(40).getItem()==Gavv_Rider_Items.BLANK_GOCHIZO.get()) player.getInventory().removeItem(40, 1);
            else player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(Gavv_Rider_Items.BLANK_GOCHIZO.get())), 1);

            player.drop(new ItemStack(Gavv_Rider_Items.CAKE.get(new Random().nextInt(Gavv_Rider_Items.CAKE.size()))), false);
        }
    }
}

