package com.kelco.kamenridercraft.world.level.levelgen;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.world.level.levelgen.feature.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower HELHEIM_TREE = new TreeGrower(KamenRiderCraftCore.MOD_ID + "helheim_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.HELHEIM_TREE_KEY), Optional.empty());

    public static final TreeGrower WARPED_HELHEIM_TREE = new TreeGrower(KamenRiderCraftCore.MOD_ID + "warped_helheim_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.WARPED_HELHEIM_TREE_KEY), Optional.empty());
}