package com.kelco.kamenridercraft.block.base_blocks;


import com.kelco.kamenridercraft.data.ModBlockStateProvider;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColoredFallingBlock;
import net.minecraft.world.level.block.FallingBlock;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BaseFallingBlock extends FallingBlock {
	private final ColorRGBA dustColor = new ColorRGBA(-16777216);
	public final MapCodec<ColoredFallingBlock> CODEC = RecordCodecBuilder.mapCodec((p_308812_) -> p_308812_.group(ColorRGBA.CODEC.fieldOf("falling_dust_color").forGetter((p_304722_) -> this.dustColor), propertiesCodec()).apply(p_308812_, ColoredFallingBlock::new));

	public BaseFallingBlock(Properties prop) {
		super(prop);
	}

	@Override
	protected @NotNull MapCodec<? extends FallingBlock> codec() {
		return CODEC;
	}

	public BaseFallingBlock is_basic_cube() {
		ModBlockStateProvider.SIMPLE_BLOCK.add(this);
		return this;
	}

	public BaseFallingBlock addToList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}
}