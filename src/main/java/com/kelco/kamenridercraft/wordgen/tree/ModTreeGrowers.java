package com.kelco.kamenridercraft.wordgen.tree;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.wordgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower HELHEIM_TREE = new TreeGrower(KamenRiderCraftCore.MOD_ID + "helheim_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.HELHEIM_TREE_KEY), Optional.empty());
}
