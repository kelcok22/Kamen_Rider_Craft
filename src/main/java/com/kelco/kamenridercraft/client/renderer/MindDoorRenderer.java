package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.blockentity.MindDoorBlockEntity;
import com.kelco.kamenridercraft.client.block_models.MindDoorModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class MindDoorRenderer extends GeoBlockRenderer<MindDoorBlockEntity> {
    public MindDoorRenderer(BlockEntityRendererProvider.Context context) {
        super(new MindDoorModel());
    }
}