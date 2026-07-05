package com.kelco.kamenridercraft.client.renderer.layers;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.renderer.RiderArmorRenderer;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.BreezeRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;


public class WindRenderLayer<T extends GeoAnimatable> extends GeoRenderLayer<T> {

    public WindRenderLayer(GeoRenderer<T> renderer) {
        super(renderer);
    }

    protected ResourceLocation getTextureResource(T animatable, int n, LivingEntity entity, RiderDriverItem belt, EquipmentSlot slot) {
        return ResourceLocation.withDefaultNamespace("textures/entity/breeze/breeze_wind.png");
    }


    private float xOffset(float tickCount) {
        return tickCount * 0.02F;
    }

    /**
     * Get the {@link GeoModel} currently being rendered
     */
    public GeoModel<T> getGeoModel() {
        return new DefaultedItemGeoModel<>(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "wind"));
    }

    /**
     * This is the method that is actually called by the render for your render layer to function
     * <p>
     * This is called <i>after</i> the animatable has been rendered, but before supplementary rendering like nametags
     */
    @Override
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (this.getRenderer() instanceof RiderArmorRenderer renderer2) {
            LivingEntity RIDER = renderer2.GetEntity();
            if (RIDER != null && RIDER instanceof LivingEntity player) {
                        float f = (float)RIDER .tickCount + partialTick;
                        renderType = RenderType.breezeWind(ResourceLocation.withDefaultNamespace("textures/entity/breeze/breeze_wind.png"),this.xOffset(f) % 1.0F, 0.0F);
                        if (player.getAttribute(Attributes.WIND)!=null&&player.getAttribute(Attributes.WIND).getBaseValue()>0) {
                            getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, renderType,
                                    bufferSource.getBuffer(renderType), partialTick, packedLight, packedOverlay,
                                    getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
                        }
                    }

        }

    }
}


