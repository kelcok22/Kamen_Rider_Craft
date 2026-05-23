package com.kelco.kamenridercraft.item.extra_riders;


import com.kelco.kamenridercraft.entity.mobs.allies.TojimaTakoyakiEntity;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import static com.kelco.kamenridercraft.entity.mobs.MobsCore.TOJIMA_TAKOYAKI;


public class ToujimaTakoyakiItem extends BaseItem {

	public ToujimaTakoyakiItem(Properties prop) {
		super(prop);
	}

	public InteractionResult useOn(UseOnContext context) {

        Player player = context.getPlayer();
        ItemStack itemstack = player.getItemInHand(context.getHand());
        Level level = player.level();
            if (player.level() instanceof ServerLevel) {
                BlockPos pos = context.getClickedPos();
                TojimaTakoyakiEntity boss = TOJIMA_TAKOYAKI.get().create(level);
                if (boss != null) {
                    boss.setTame(true, false);
                    boss.setOwnerUUID(player.getUUID());
                    boss.moveTo(pos.getX(), pos.getY()+1, pos.getZ(), 0, 0.0F);
                    level.addFreshEntity(boss);
                    itemstack.consume(1,player);
                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        return InteractionResult.PASS;
    }
}
