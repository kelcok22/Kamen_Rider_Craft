package com.kelco.kamenridercraft.mixin.structure;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = JigsawStructure.class, priority = 999)
public abstract class JigsawExpansion extends Structure {
    @WrapOperation(method = {"lambda$static$10"}, at = @At(value = "INVOKE", target = "Lcom/mojang/serialization/Codec;intRange(II)Lcom/mojang/serialization/Codec;"))
    private static Codec<Integer> x(int minInclusive, int maxInclusive, Operation<Codec<Integer>> original) {
        return Codec.INT;
    }

    protected JigsawExpansion(Structure.StructureSettings config) {
        super(config);
    }

    @ModifyExpressionValue(method = "<init>(Lnet/minecraft/world/level/levelgen/structure/Structure$StructureSettings;Lnet/minecraft/core/Holder;ILnet/minecraft/world/level/levelgen/heightproviders/HeightProvider;ZLnet/minecraft/world/level/levelgen/Heightmap$Types;)V", at = @At(value = "CONSTANT", args = "intValue=80"), require = 0)
    private static int init1(int value) {
        return KamenRiderCraftCore.NEW_STRUCTURE_SIZE;
    }

    @ModifyExpressionValue(method = "<init>(Lnet/minecraft/world/level/levelgen/structure/Structure$StructureSettings;Lnet/minecraft/core/Holder;ILnet/minecraft/world/level/levelgen/heightproviders/HeightProvider;Z)V", at = @At(value = "CONSTANT", args = "intValue=80"), require = 0)
    private static int init2(int value) {
        return KamenRiderCraftCore.NEW_STRUCTURE_SIZE;
    }

    @ModifyExpressionValue(method = "verifyRange", at = @At(value = "CONSTANT", args = "intValue=128"), require = 0)
    private static int maxDistanceFromCenter(int value) {
        return KamenRiderCraftCore.NEW_STRUCTURE_SIZE;
    }
}