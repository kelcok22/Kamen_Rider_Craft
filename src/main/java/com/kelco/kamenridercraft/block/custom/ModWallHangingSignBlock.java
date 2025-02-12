package com.kelco.kamenridercraft.block.custom;

import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.block.entity.ModHangingSignBlockEntity;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWallHangingSignBlock extends WallHangingSignBlock {
    public ModWallHangingSignBlock(WoodType type, Properties properties) {
        super(type, properties);
    }

    @Override
    public String getDescriptionId() {
        return Util.makeDescriptionId("item", Rider_Blocks.HELHEIM_WALL_HANGING_SIGN.getId());
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos Pos, BlockState State) {
        return new ModHangingSignBlockEntity(Pos, State);
    }
}