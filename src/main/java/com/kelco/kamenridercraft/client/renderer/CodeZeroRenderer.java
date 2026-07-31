package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.AutoVajinModel;
import com.kelco.kamenridercraft.client.models.CodeZeroModel;
import com.kelco.kamenridercraft.entity.mobs.allies.AutoVajinRoboEntity;
import com.kelco.kamenridercraft.entity.mobs.allies.CodeZeroEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CodeZeroRenderer extends GeoEntityRenderer<CodeZeroEntity> {


    public CodeZeroRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CodeZeroModel());
    }

    @Override
    public ResourceLocation getTextureLocation(CodeZeroEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/zero.png");
    }
}