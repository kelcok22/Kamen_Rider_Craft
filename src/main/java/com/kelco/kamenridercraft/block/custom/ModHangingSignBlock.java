package com.kelco.kamenridercraft.block.custom;

import com.kelco.kamenridercraft.block.entity.ModHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModHangingSignBlock extends CeilingHangingSignBlock {
    public ModHangingSignBlock(WoodType type, Properties properties) {
        super(type, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos Pos, BlockState State) {
        return new ModHangingSignBlockEntity(Pos, State);
    }
}
