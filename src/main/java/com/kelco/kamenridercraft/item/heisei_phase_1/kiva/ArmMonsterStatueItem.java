package com.kelco.kamenridercraft.item.heisei_phase_1.kiva;


import com.kelco.kamenridercraft.entity.mobs.allies.BaseAllyEntity;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;


public class ArmMonsterStatueItem extends BaseItem {
    private Supplier<? extends EntityType<? extends BaseAllyEntity>> armStatueMonster;

    public ArmMonsterStatueItem(Properties properties, Supplier<? extends EntityType<? extends BaseAllyEntity>> armStatueMonster) {
        super(properties);
        this.armStatueMonster = armStatueMonster;
    }

    public @NotNull InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        assert player != null;
        ItemStack itemstack = player.getItemInHand(context.getHand());
        Level level = player.level();

        if (!level.isClientSide()) {
            if (level instanceof ServerLevel) {
                BlockPos pos = context.getClickedPos();
                BaseAllyEntity statueMonster = armStatueMonster.get().create(level);
                if (statueMonster != null) {
                    statueMonster.setTame(true, false);
                    statueMonster.setOwnerUUID(player.getUUID());
                    statueMonster.moveTo(pos.getX(), pos.getY() + 1, pos.getZ(), 0, 0.0F);
                    level.addFreshEntity(statueMonster);
                    itemstack.consume(1, player);
                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
        return InteractionResult.PASS;
    }
}
