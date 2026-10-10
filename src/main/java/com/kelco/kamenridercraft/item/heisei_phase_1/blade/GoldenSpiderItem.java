package com.kelco.kamenridercraft.item.heisei_phase_1.blade;


import com.kelco.kamenridercraft.entity.mobs.bosses.AceUndeadEntity;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

import static com.kelco.kamenridercraft.entity.mobs.MobsCore.ACE_UNDEAD;
import static net.minecraft.world.effect.MobEffects.MOVEMENT_SPEED;
import static net.minecraft.world.entity.EntityType.ZOMBIE;


public class GoldenSpiderItem extends BaseItem {
    public GoldenSpiderItem(Properties prop) {
        super(prop);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (player instanceof ServerPlayer serverPlayer && usedHand == InteractionHand.MAIN_HAND) {
            AceUndeadEntity undead = ACE_UNDEAD.get().create(level);
            undead.setSpider();
            Random rand = new Random();

            int tempRandX = (serverPlayer.getBlockX()
                    + (rand.nextInt(5, 20))
                    * (rand.nextInt(3) > 1 ? 1 : -1));

            int tempRandZ = (serverPlayer.getBlockZ()
                    + (rand.nextInt(5, 20))
                    * (rand.nextInt(3) > 1 ? 1 : -1));

            undead.setPos(tempRandX, serverPlayer.getY(), tempRandZ);

            for (int i = 0; i < 400; ++i) {
                int randX = (serverPlayer.getBlockX()
                        + (rand.nextInt(5, 20))
                        * (rand.nextInt(3) > 1 ? 1 : -1));

                int randY = (serverPlayer.getBlockY()
                        + rand.nextInt(-10, 10));

                int randZ = (serverPlayer.getBlockZ()
                        + (rand.nextInt(5, 20))
                        * (rand.nextInt(3) > 1 ? 1 : -1));

                if (level.noCollision(EntityType.ZOMBIE.getSpawnAABB(randX, randY, randZ))) {
                    undead.setPos(randX, randY, randZ);
                }
                BlockPos potentialPosition = new BlockPos(randX, randY, randZ);
                if (SpawnPlacements.isSpawnPositionOk(ZOMBIE, level, potentialPosition)) {
                    undead.setPos(randX, randY, randZ);
                    break;
                }
            }

            if (!serverPlayer.isSpectator() && !serverPlayer.isCreative()) {
                undead.setTarget(serverPlayer);
                undead.addEffect(new MobEffectInstance(MOVEMENT_SPEED, 40, 4, true, false));
            }

            level.addFreshEntity(undead);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
            serverPlayer.setItemInHand(usedHand, serverPlayer.getItemInHand(usedHand));
            serverPlayer.getItemInHand(usedHand).consume(1, serverPlayer);
        }
        return super.use(level, player, usedHand);
    }
}