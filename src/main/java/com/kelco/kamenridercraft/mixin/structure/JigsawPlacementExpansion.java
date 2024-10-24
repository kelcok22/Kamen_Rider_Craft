package com.kelco.kamenridercraft.mixin.structure;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;


@Mixin(value = JigsawPlacement.class, priority = 999)
public class JigsawPlacementExpansion {

    @ModifyConstant(method = "generateJigsaw", constant = @Constant(intValue = 128), require = 0, remap = false)
    private static int changeMaxGenDistance(int value) {
        return KamenRiderCraftCore.NEW_STRUCTURE_SIZE;
    }
}