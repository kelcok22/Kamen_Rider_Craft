package com.kelco.kamenridercraft.block.baseBlocks;


import java.util.List;

import com.kelco.kamenridercraft.data.ModBlockStateProvider;
import net.minecraft.world.level.block.Block;
public class BaseBlock extends Block {



	public BaseBlock(Properties prop) {
		super(prop);
		
	}

	public BaseBlock is_basic_cube() {
		ModBlockStateProvider.SIMPLE_BLOCK.add(this);
		return this;
	}

	public BaseBlock AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}