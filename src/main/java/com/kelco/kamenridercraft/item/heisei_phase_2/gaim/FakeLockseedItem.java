package com.kelco.kamenridercraft.item.heisei_phase_2.gaim;


import com.kelco.kamenridercraft.item.base_items.BaseItem;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;


public class FakeLockseedItem extends BaseItem {
    public FakeLockseedItem(Properties properties) {
        super(properties);
    }

    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);

        if (!level.isClientSide()) {
            if (player.level() instanceof ServerLevel) {
                Vec3 look = player.getLookAngle();
                BlockPos pos = new BlockPos((int) (player.getX() + look.x), (int) (player.getY() + 5), (int) (player.getZ() + look.z));

                if (player.level().isEmptyBlock(pos)) {
                    player.level().setBlockAndUpdate(pos, Blocks.ANVIL.defaultBlockState());
                    player.sendSystemMessage(Component.translatable("message.kamenridercraft.fake"));
                    itemstack.consume(1, player);
                }
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}