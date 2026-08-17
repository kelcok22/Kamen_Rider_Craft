package com.kelco.kamenridercraft.client.renderer.layers.render_layer_util;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;

import java.util.Objects;

public class RenderLayerInfo {
    private final String model;
    private final RenderType renderType;
    private final String GlowTexture;
    private final float X =0f;
    private final float Y =0f;
    private final float Z =0f;
    private final float SX =1f;
    private final float SY =1f;
    private final float SZ =1f;


    public RenderLayerInfo(String texture, String model) {
        if (!texture.contains("blank")) renderType = RenderType.entityTranslucent(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/" + texture + ".png"));
        else renderType= null;
        this.model = model;
        this.GlowTexture =null;
    }

    public RenderLayerInfo(String texture, String model,String glowTexture) {
        if (!texture.contains("blank")) renderType = RenderType.entityTranslucent(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/" + texture + ".png"));
        else renderType= null;
        this.model = model;
        GlowTexture = glowTexture;
    }

    public RenderLayerInfo(RenderType texture, String model) {
        renderType = texture;
        this.model = model;
        GlowTexture = null;
    }



    public void ApplyMovement(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick){
        GeoBone wizard_circle5 = model.getBone("wizard_circle5").orElse(null);
        double GetTransforming = Objects.requireNonNull(entity.getAttribute(Attributes.IS_TRANSFORMING)).getBaseValue();

        float Transforming = (float) Mth.lerp(1, GetTransforming, (GetTransforming - 1) - partialTick);
        if (wizard_circle5 != null) {
            if (RiderDriverItem.isTransforming(entity)) {
                wizard_circle5.setScaleX(1.1f);
                wizard_circle5.setScaleY(1.1f);
                wizard_circle5.setScaleZ(1.1f);
                wizard_circle5.setPosX(2.5f);
                wizard_circle5.setPosZ(30 - Transforming);
                wizard_circle5.setHidden(false);
            } else {
                wizard_circle5.setHidden(true);
                wizard_circle5.setPosZ(0);
            }
        }
    }

    public RenderType getRenderType() {
        return renderType;
    }
    public String getGlowTexture() {
        return GlowTexture;
    }
    public String getModel() {
        return model;
    }
    public boolean isGlowing() {
        return GlowTexture!=null;
    }
    public float getX(){return X;}
    public float getY(){return Y;}
    public float getZ(){return Z;}
    public float getScaleX(){return SX;}
    public float getScaleY(){return SY;}
    public float getScaleZ(){return SZ;}
}