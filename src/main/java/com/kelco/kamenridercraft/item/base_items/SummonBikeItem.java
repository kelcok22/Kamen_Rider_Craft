package com.kelco.kamenridercraft.item.base_items;


import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.entity.vehicles.baseBikeEntity;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Supplier;


public class SummonBikeItem extends BaseItem {
    private List<Component> TEXT = Lists.newArrayList();
    private Supplier<? extends EntityType<? extends baseBikeEntity>> BOSS;

    public SummonBikeItem(Properties properties, Supplier<? extends EntityType<? extends baseBikeEntity>> boss) {
        super(properties);
        BOSS = boss;
    }

    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        ItemStack itemstack = player.getItemInHand(context.getHand());
        Level level = context.getLevel();

        if (!level.isClientSide()) {
            BlockPos pos = context.getClickedPos();
            baseBikeEntity boss = BOSS.get().create(level);
            if (boss != null) {
                boss.moveTo(pos.getX(), pos.getY() + 1, pos.getZ(), 0, 0.0F);
                level.addFreshEntity(boss);
                if (!TEXT.isEmpty()) for (Component text : TEXT) {
                    player.displayClientMessage(text, true);
                }
                itemstack.consume(1, player);
                CriteriaTriggers.SUMMONED_ENTITY.trigger((ServerPlayer) player, boss);
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
        return InteractionResult.PASS;
    }
}