package com.kelco.kamenridercraft.mixin;

import net.minecraft.ReportType;
import net.minecraft.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Random;

@Mixin(value = ReportType.class, priority = 899)
public class ReportTypeMixin {
    private static final ReportType KRC = new ReportType("Ferbus Crash Report", List.of(
            "Noopi Noopi!",
            "Bool bum bum...",
            "Ki ka kooey die!",
            "ｵﾝﾄﾞｩﾙﾙﾗｷﾞｯﾀﾝﾃﾞｨｽｶｰ!",
            "Ferbus has escaped containment.",
            "おのれディケイド!",
            "ONORE DECADE!",
            "DANGER! DANGER! DANGER! D-D-D-DANGER! GOODBYE!",
            "The zorse is loose!",
            "Just a witty crash..."));

    @Inject(method = "getErrorComment", at = @At("HEAD"), cancellable = true)
    public void getErrorComment(CallbackInfoReturnable<String> ci) {
        var report = ((ReportType) (Object) this);
        if (report.header().toLowerCase().contains("crash") && new Random().nextInt(5) == 1) {
            try {
                ci.setReturnValue(KRC.nuggets().get((new Random().nextInt(KRC.nuggets().size()))));
            } catch (Throwable var2) {
                ci.setReturnValue("Ferbus ate the crash message...");
            }
        }
    }
}