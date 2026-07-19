package com.kelco.kamenridercraft.world.level;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class CustomDimensionEffect {
    public static final ResourceLocation MOON_EFFECTS = ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"moon");

    @OnlyIn(Dist.CLIENT)
    public static class MoonEffects extends DimensionSpecialEffects {

        public MoonEffects() {
            super(Float.NaN, true, SkyType.NORMAL, false, false);
        }

        public @NotNull Vec3 getBrightnessDependentFogColor(Vec3 p_108894_, float p_108895_) {
            return p_108894_.scale(0.15000000596046448);
        }

        @Nullable
        public float[] getSunriseColor(float p_108888_, float p_108889_) {
            return null;
        }
        public boolean isFoggyAt(int x, int y) {
            return false;
        }
    }
}