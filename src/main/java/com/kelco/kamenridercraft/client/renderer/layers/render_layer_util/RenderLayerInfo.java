package com.kelco.kamenridercraft.client.renderer.layers.render_layer_util;

public class RenderLayerInfo {
    private String TEXTURE;
    private String MODEL;
    private boolean GLOW;

    public RenderLayerInfo (String texture, String model){
        TEXTURE=texture;
        MODEL=model;
        GLOW=false;
    }
    public RenderLayerInfo (String texture, String model, boolean glow){
        TEXTURE=texture;
        MODEL=model;
        GLOW=glow;
    }
    public String GetTexture(){
        return TEXTURE;
    }
    public String GetModel(){
        return MODEL;
    }
    public boolean GetIsGlow(){
        return GLOW;
    }

}
