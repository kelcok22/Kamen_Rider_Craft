package com.kelco.kamenridercraft.client.renderer.layers.render_layer_util;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class RenderLayerInfo {

    private final String MODEL;
    private final RenderType TYPE;
    private boolean GLOW =false;
    private String GLOWTEXTURE;

    public RenderLayerInfo (String texture, String model){
        TYPE=RenderType.entityTranslucent(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/" + texture+ ".png"));
        MODEL=model;
    }
    public RenderLayerInfo (RenderType texture, String model){
        TYPE=texture;
        MODEL=model;
    }

    public RenderLayerInfo isglowing(String text){
        GLOWTEXTURE = text;
        GLOW=true;
        return this;
    }

    public RenderType GetRenderType(){
        return TYPE;
    }

    public String GetGlowTexture(){
        return GLOWTEXTURE;
    }
    public String GetModel(){
        return MODEL;
    }
    public boolean GetIsGlow(){
        return GLOW;
    }

}
