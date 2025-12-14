package com.kelco.kamenridercraft.client.renderer.layers;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.MetamateriamModel;
import com.kelco.kamenridercraft.entities.summons.TechnolomProjectionEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MetamateriamEyesLayer<T extends TechnolomProjectionEntity, M extends MetamateriamModel<T>> extends EyesLayer<T, M> {
    private static final RenderType METAMATERIAM_EYES = RenderType.breezeEyes(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/technolom_projection_eyes.png"));

    public MetamateriamEyesLayer(RenderLayerParent<T, M> p_117507_) {
        super(p_117507_);
    }

    public RenderType renderType() { return METAMATERIAM_EYES; }
}
