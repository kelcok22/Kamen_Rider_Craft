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

	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);
		if (!p_41128_.isClientSide()) {
			if (p_41129_.level() instanceof ServerLevel) {
				BlockPos pos = p_41129_.getOnPos();
				BaseAllyEntity boss = BOSS.get().create(p_41128_);
				if (boss != null) {
					boss.tame(p_41129_);
					boss.moveTo(pos.getX(), pos.getY(), pos.getZ(), 0, 0.0F);
					p_41128_.addFreshEntity(boss);
					if (!TEXT.isEmpty()) for (Component text : TEXT) p_41129_.sendSystemMessage(text);
				}
			}

		}

		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}

}