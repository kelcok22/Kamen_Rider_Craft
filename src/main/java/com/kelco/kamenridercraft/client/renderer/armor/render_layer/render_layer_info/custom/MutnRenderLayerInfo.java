package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;


public class MutnRenderLayerInfo extends RenderLayerInfo {
    public MutnRenderLayerInfo(String texture, String model) {
        super(texture, model);
    }

    @Override
    public int getColor(float partialTick, LivingEntity RIDER) {
        if (RIDER.hasCustomName() && "jeb_".equals(RIDER.getName().getString())) {
            int k = RIDER.tickCount / 25 + RIDER.getId();
            int l = DyeColor.values().length;
            int i1 = k % l;
            int j1 = (k + 1) % l;
            float f = ((float)(RIDER.tickCount % 25) + partialTick) / 25.0F;
            int k1 = Sheep.getColor(DyeColor.byId(i1));
            int l1 = Sheep.getColor(DyeColor.byId(j1));
            return FastColor.ARGB32.lerp(f, k1, l1);
        } return super.getColor(partialTick, RIDER);
    }
}