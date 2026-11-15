package com.kelco.kamenridercraft.world.level;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class CustomDimensionEffect {
    public static final ResourceLocation MOON_EFFECTS = ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "moon");

    public static class MoonEffects extends DimensionSpecialEffects {
        public MoonEffects() {
            super(Float.NaN, true, SkyType.NORMAL, false, false);
        }

        @Override
        public @NotNull Vec3 getBrightnessDependentFogColor(Vec3 vec3, float v) {
            return vec3.scale(0.15000000596046448);
        }

        @Nullable
        public float[] getSunriseColor(float timeOfDay, float partialTick) {
            return null;
        }

        public boolean isFoggyAt(int x, int y) {
            return false;
        }
    }
}