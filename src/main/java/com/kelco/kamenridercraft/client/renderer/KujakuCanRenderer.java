package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.KujakuCanModel;
import com.kelco.kamenridercraft.entities.allies.KujakuCanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class KujakuCanRenderer extends GeoEntityRenderer<KujakuCanEntity> {


	public KujakuCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KujakuCanModel());
    }

    @Override
    public ResourceLocation getTextureLocation(KujakuCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/kujaku_can.png");
    }


}