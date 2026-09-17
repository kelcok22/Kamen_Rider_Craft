package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.KodamaSuikaArmsModel;
import com.kelco.kamenridercraft.entity.mobs.allies.KodamaSuikaArmsEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class KodamaSuikaArmsRenderer extends GeoEntityRenderer<KodamaSuikaArmsEntity> {
    public KodamaSuikaArmsRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KodamaSuikaArmsModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull KodamaSuikaArmsEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/kodama_suika_arms.png");
    }
}