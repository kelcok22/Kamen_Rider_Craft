package com.kelco.kamenridercraft.client.renderer.layers.render_layer_util;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;

import java.util.Objects;

public class SmokeRenderLayerInfo  extends RenderLayerInfo{
    private final String Texture;

    public SmokeRenderLayerInfo(String texture, String model) {
       super(texture,model);
        this.Texture =texture;
    }

    @Override
    public RenderType getRenderType(float partialTick,LivingEntity RIDER ) {
        float f = (float) RIDER.tickCount + partialTick;
        return RenderType.breezeWind(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/render_layer/"+Texture+".png"),  0.0F, this.xOffset(f) %1.0F);
    }
    private float xOffset(float tickCount) {
        return tickCount * 0.02F;
    }
}