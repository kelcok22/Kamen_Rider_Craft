package com.kelco.kamenridercraft.mixin.structure;

import net.minecraft.server.commands.PlaceCommand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = PlaceCommand.class, priority = 999)
public class PlaceCommandUnlimit {

    @ModifyConstant(method = "register", constant = @Constant(intValue = 20), require = 0, remap = false)
    private static int changeJigsawDepth(int value) {
        return Integer.MAX_VALUE;
    }
}