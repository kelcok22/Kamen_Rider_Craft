package com.kelco.kamenridercraft.block.base_blocks;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class BaseStairsBlock extends StairBlock {


	public BaseStairsBlock(BlockState state ,Properties prop) {
		super(state, prop);
		
		
	}

	public BaseStairsBlock AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}