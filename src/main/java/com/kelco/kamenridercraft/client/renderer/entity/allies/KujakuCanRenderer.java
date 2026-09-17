package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.KujakuCanModel;
import com.kelco.kamenridercraft.entity.mobs.allies.KujakuCanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class KujakuCanRenderer extends GeoEntityRenderer<KujakuCanEntity> {
    public KujakuCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KujakuCanModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull KujakuCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/kujaku_can.png");
    }
}