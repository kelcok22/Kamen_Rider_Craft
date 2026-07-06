package com.kelco.kamenridercraft.item.heisei_phase_2.gaim;

import com.kelco.kamenridercraft.block.RiderBlocks;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;


public class SidLockseedItem extends BaseItem {
    public SidLockseedItem(Properties properties) {
        super(properties);
    }

    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);

        ResourceKey<Level> HELHEIM = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:helheim"));

        if (!level.isClientSide() && (level.dimension() == HELHEIM || level.dimension() == Level.OVERWORLD)) {
            Vec3 look = player.getLookAngle().scale(3);
            BlockPos pos = new BlockPos((int) (Math.floor(player.getX() + look.x)), (int) (player.getY()), (int) (Math.floor(player.getZ() + look.z)));

            if (level.getBlockState(pos).getDestroySpeed(level, pos) < 0.2) level.destroyBlock(pos, true);
            if (player.level().isEmptyBlock(pos)) {
                player.level().setBlockAndUpdate(pos, RiderBlocks.HELHEIM_CRACK.get().defaultBlockState());
                player.getCooldowns().addCooldown(this, 500);
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}