//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kelco.kamenridercraft.wordgen.customFeature;

import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class helheimVineFeature extends Feature<NoneFeatureConfiguration> {
    public helheimVineFeature(Codec<NoneFeatureConfiguration> p_67337_) {
        super(p_67337_);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> p_160628_) {
        WorldGenLevel worldgenlevel = p_160628_.level();
        BlockPos blockpos = p_160628_.origin();
        p_160628_.config();
        if (!worldgenlevel.isEmptyBlock(blockpos)) {
            return false;
        } else {
            Direction[] var4 = Direction.values();
            int var5 = var4.length;

            for (Direction direction : var4) {
                if (direction != Direction.DOWN && VineBlock.isAcceptableNeighbour(worldgenlevel, blockpos.relative(direction), direction)) {
                    worldgenlevel.setBlock(blockpos, Rider_Blocks.HELHEIM_VINE.get().defaultBlockState().setValue(VineBlock.getPropertyForFace(direction), true), 2);
                    return true;
                }
            }

            return false;
        }
    }
}
