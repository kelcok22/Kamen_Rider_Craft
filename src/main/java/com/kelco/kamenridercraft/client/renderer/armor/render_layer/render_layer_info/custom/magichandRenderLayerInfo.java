package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;

import java.util.Objects;


public class magichandRenderLayerInfo extends RenderLayerInfo {
    private final String texture;

    public magichandRenderLayerInfo(String texture, String model) {
        super(texture, model);
        this.texture = texture;
    }

    public void ApplyMovement(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick) {
        GeoBone bone = model.getBone("bone").orElse(null);
        if (bone != null) {
            bone.setRotY(model.getBone("armorRightArm").get().getRotY());
        }
    }

    private float xOffset(float tickCount) {
        return tickCount * 0.02F;
    }
}