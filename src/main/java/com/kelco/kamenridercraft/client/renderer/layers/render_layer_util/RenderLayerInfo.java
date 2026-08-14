package com.kelco.kamenridercraft.client.renderer.layers.render_layer_util;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;

public class RenderLayerInfo {
    private final String model;
    private final RenderType renderType;
    private boolean glowing = false;
    private String glowTexture;
    private float X =0f;
    private float Y =0f;
    private float Z =0f;
    private float SX =1f;
    private float SY =1f;
    private float SZ =1f;

    public RenderLayerInfo(String texture, String model) {
        renderType = RenderType.entityTranslucent(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/" + texture + ".png"));
        this.model = model;
    }

    public RenderLayerInfo(RenderType texture, String model) {
        renderType = texture;
        this.model = model;
    }

    public RenderLayerInfo setGlowing(String text) {
        glowTexture = text;
        glowing = true;
        return this;
    }
    public RenderLayerInfo setLocation(float x, float y, float z){
        X=x;
        Y=y;
        Z=z;
        return this;
    }
    public RenderLayerInfo setScale(float x, float y, float z){
        SX=x;
        SY=y;
        SZ=z;
        return this;
    }

    public void ApplyMovement(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick){

    }

    public RenderType getRenderType() {
        return renderType;
    }
    public String getGlowTexture() {
        return glowTexture;
    }
    public String getModel() {
        return model;
    }
    public boolean isGlowing() {
        return glowing;
    }
    public float getX(){return X;}
    public float getY(){return Y;}
    public float getZ(){return Z;}
    public float getScaleX(){return SX;}
    public float getScaleY(){return SY;}
    public float getScaleZ(){return SZ;}
}