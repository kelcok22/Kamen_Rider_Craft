package com.kelco.kamenridercraft.block.baseBlocks;


import java.util.List;

import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BaseBlockDropExperience extends DropExperienceBlock {

	public BaseBlockDropExperience(BlockBehaviour.Properties properties,IntProvider xpRange) {
		super(xpRange, properties);
	}

	public BaseBlockDropExperience AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}