package com.kelco.kamenridercraft.item.ooo;


import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.entities.allies.BaseAllyEntity;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Supplier;


public class CandroidItem extends BaseItem {


	private List<Component> TEXT = Lists.newArrayList();
	private Supplier<? extends EntityType<? extends BaseAllyEntity>> BOSS;

	public CandroidItem(Properties properties ,Component text, Supplier<? extends EntityType<? extends BaseAllyEntity>> boss)
	{super(properties);
		BOSS =boss;
		TEXT.add(text);
	}

	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
		ItemStack itemstack = player.getItemInHand(usedHand);

		if (!level.isClientSide()) {
			if (player.level() instanceof ServerLevel) {
				BlockPos pos = player.blockPosition();
				BaseAllyEntity boss = BOSS.get().create(level);
				if (boss != null) {
					boss.tame(player);
					boss.moveTo(pos.getX(), pos.getY(), pos.getZ(), 0, 0.0F);
					level.addFreshEntity(boss);
					if (!TEXT.isEmpty()) for (Component text : TEXT) player.sendSystemMessage(text);
				itemstack.consume(1,player);
				}
			}
		}
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}

}