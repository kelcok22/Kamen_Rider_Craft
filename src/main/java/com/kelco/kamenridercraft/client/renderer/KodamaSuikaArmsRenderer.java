package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.KodamaSuikaArmsModel;
import com.kelco.kamenridercraft.client.models.TakaCanModel;
import com.kelco.kamenridercraft.entities.allies.KodamaSuikaArmsEntity;
import com.kelco.kamenridercraft.entities.allies.TakaCanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class KodamaSuikaArmsRenderer extends GeoEntityRenderer<KodamaSuikaArmsEntity> {




	public KodamaSuikaArmsRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KodamaSuikaArmsModel());
    }

    @Override
    public ResourceLocation getTextureLocation(KodamaSuikaArmsEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/kodama_suika_arms.png");
    }
}