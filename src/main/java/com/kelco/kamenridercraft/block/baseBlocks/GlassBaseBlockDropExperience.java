package com.kelco.kamenridercraft.block.baseBlocks;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GlassBaseBlockDropExperience extends StainedGlassBlock {

	private final IntProvider xpRange;

	public GlassBaseBlockDropExperience(BlockBehaviour.Properties properties,IntProvider xpRange, DyeColor dyeColor) {
		super(dyeColor, properties);
		this.xpRange = xpRange;
	}

	protected void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack stack, boolean dropExperience) {
		super.spawnAfterBreak(state, level, pos, stack, dropExperience);
	}

	public int getExpDrop(BlockState state, LevelAccessor level, BlockPos pos, @Nullable BlockEntity blockEntity, @Nullable Entity breaker, ItemStack tool) {
		return this.xpRange.sample(level.getRandom());
	}

	public GlassBaseBlockDropExperience AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}