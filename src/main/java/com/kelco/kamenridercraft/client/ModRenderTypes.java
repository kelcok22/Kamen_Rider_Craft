package com.kelco.kamenridercraft.client;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.MOD_ID;
import static net.minecraft.client.renderer.RenderStateShard.*;

public class ModRenderTypes {
    private static final ResourceLocation MUTEKI_TEXT = ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/render_layer/muteki.png");
    public static final RenderType MUTEKI_GLINT = RenderType.create("cool_glint", DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.QUADS, 1536, RenderType.CompositeState.builder().setShaderState(RENDERTYPE_GLINT_TRANSLUCENT_SHADER).setTextureState(new RenderStateShard.TextureStateShard(MUTEKI_TEXT, true, true)).setWriteMaskState(COLOR_WRITE).setCullState(NO_CULL).setDepthTestState(EQUAL_DEPTH_TEST).setTransparencyState(GLINT_TRANSPARENCY).setTexturingState(GLINT_TEXTURING).setOutputState(ITEM_ENTITY_TARGET).createCompositeState(false));

    public static RenderType mutekiGlint() {
        return MUTEKI_GLINT;
    }
}
