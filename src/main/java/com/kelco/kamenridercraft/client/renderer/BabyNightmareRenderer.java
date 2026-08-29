package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.client.models.BabyNightmareModel;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BabyNightmareEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BabyNightmareRenderer extends GeoEntityRenderer<BabyNightmareEntity> {


    public BabyNightmareRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BabyNightmareModel());
    }
}