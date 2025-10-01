package com.kelco.kamenridercraft.dimension;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class custom_dimension_effect {


    public static final ResourceLocation MOON_EFFECTS = ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"moon");

    @OnlyIn(Dist.CLIENT)
    public static class MoonEffects extends DimensionSpecialEffects {

        public MoonEffects() {
            super(Float.NaN, true, SkyType.NORMAL, false, false);
        }

        public Vec3 getBrightnessDependentFogColor(Vec3 p_108894_, float p_108895_) {
            return p_108894_.scale(0.15000000596046448);
        }

        @Nullable
        public float[] getSunriseColor(float p_108888_, float p_108889_) {
            return null;
        }
        public boolean isFoggyAt(int p_108905_, int p_108906_) {
            return false;
        }
    }

}
