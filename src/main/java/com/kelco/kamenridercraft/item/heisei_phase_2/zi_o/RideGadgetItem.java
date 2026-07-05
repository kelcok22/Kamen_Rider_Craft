package com.kelco.kamenridercraft.item.heisei_phase_2.zi_o;


import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.entity.mobs.allies.BaseAllyEntity;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
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


public class RideGadgetItem extends BaseItem {
    private List<Component> text = Lists.newArrayList();
    private Supplier<? extends EntityType<? extends BaseAllyEntity>> rideGadget;

    public RideGadgetItem(Properties properties, Component text, Supplier<? extends EntityType<? extends BaseAllyEntity>> rideGadget) {
        super(properties);
        this.rideGadget = rideGadget;
        this.text.add(text);
    }

    /**
     * Called when this item is used when targeting a Block
     */
    public @NotNull InteractionResult useOn(UseOnContext context) {

        Player player = context.getPlayer();
        assert player != null;
        ItemStack itemstack = player.getItemInHand(context.getHand());
        Level level = player.level();

        if (!level.isClientSide()) {
            if (level instanceof ServerLevel) {
                BlockPos pos = context.getClickedPos();
                BaseAllyEntity boss = rideGadget.get().create(level);
                if (boss != null) {
                    boss.setTame(true, false);
                    boss.setOwnerUUID(player.getUUID());
                    boss.moveTo(pos.getX(), pos.getY() + 1, pos.getZ(), 0, 0.0F);
                    level.addFreshEntity(boss);
                    if (!text.isEmpty()) for (Component text : text) player.displayClientMessage(text, true);
                    itemstack.consume(1, player);
                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
        return InteractionResult.PASS;
    }
}