package com.kelco.kamenridercraft.item.heisei_phase_1.blade;


import com.kelco.kamenridercraft.item.base_items.BaseItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;


public class GoldenSpiderItem extends BaseItem {
    public GoldenSpiderItem(Properties prop) {
        super(prop);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (player instanceof ServerPlayer serverPlayer && usedHand == InteractionHand.MAIN_HAND) {
            Mob goldenSpider = null;
            int tempRandX = Mth.floor(serverPlayer.getX())
                    + Mth.nextInt(serverPlayer.getRandom(), 9, 35)
                    * Mth.nextInt(serverPlayer.getRandom(), -1, 1);
            int tempRandZ = Mth.floor(serverPlayer.getZ())
                    + Mth.nextInt(serverPlayer.getRandom(), 9, 35)
                    * Mth.nextInt(serverPlayer.getRandom(), -1, 1);
            goldenSpider.setPos(tempRandX, serverPlayer.getY(), tempRandZ);

            for (int i = 0; i < 100; ++i) {
                int randX = Mth.floor(serverPlayer.getX())
                        + Mth.nextInt(serverPlayer.getRandom(), 9, 35)
                        * Mth.nextInt(serverPlayer.getRandom(), -1, 1);
                int randY = Mth.floor(serverPlayer.getY())
                        + Mth.nextInt(serverPlayer.getRandom(), 9, 35)
                        * Mth.nextInt(serverPlayer.getRandom(), -1, 1);
                int randZ = Mth.floor(serverPlayer.getZ())
                        + Mth.nextInt(serverPlayer.getRandom(), 9, 35)
                        * Mth.nextInt(serverPlayer.getRandom(), -1, 1);

                BlockPos potentialPosition = new BlockPos(randX, randY, randZ);
//                if (SpawnPlacements.isSpawnPositionOk(this.getType(), level, potentialPosition)) {
//                    reinforcement.setPos(randX, serverPlayer.getY(), randZ);
//                }
            }

            goldenSpider.setTarget(serverPlayer);
            goldenSpider.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4, true, false));
            goldenSpider.addEffect(new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false));

            level.addFreshEntity(goldenSpider);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
            serverPlayer.setItemInHand(usedHand, serverPlayer.getItemInHand(usedHand));
            serverPlayer.getItemInHand(usedHand).shrink(1);
        }
        return super.use(level, player, usedHand);
    }
}