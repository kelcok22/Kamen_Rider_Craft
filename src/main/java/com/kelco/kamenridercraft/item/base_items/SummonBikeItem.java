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
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;


public class SummonBikeItem extends BaseItem {
    private List<Component> text = Lists.newArrayList();
    private Supplier<? extends EntityType<? extends baseBikeEntity>> bike;

    public SummonBikeItem(Properties properties, Supplier<? extends EntityType<? extends baseBikeEntity>> bike) {
        super(properties);
        this.bike = bike;
    }

    public @NotNull InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        assert player != null;
        ItemStack itemStack = player.getItemInHand(context.getHand());
        Level level = context.getLevel();

        if (!level.isClientSide()) {
            BlockPos pos = context.getClickedPos();
            baseBikeEntity boss = bike.get().create(level);
            if (boss != null) {
                boss.moveTo(pos.getX(), pos.getY() + 1, pos.getZ(), 0, 0.0F);
                level.addFreshEntity(boss);
                if (!text.isEmpty()) for (Component text : text) {
                    player.displayClientMessage(text, true);
                }
                itemStack.consume(1, player);
                CriteriaTriggers.SUMMONED_ENTITY.trigger((ServerPlayer) player, boss);
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
        return InteractionResult.PASS;
    }
}