package com.kelco.kamenridercraft.block.entity;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModSignBlockEntity extends SignBlockEntity {

    public ModSignBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.MOD_SIGN.get(), pos, blockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.MOD_SIGN.get();
    }
}
