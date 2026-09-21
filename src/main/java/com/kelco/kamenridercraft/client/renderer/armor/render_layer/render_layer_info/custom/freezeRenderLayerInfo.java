package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class freezeRenderLayerInfo extends RenderLayerInfo {

    public freezeRenderLayerInfo(String texture, String model) {
        super(texture, model);
    }
    public void ApplyMovement(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick) {
        GeoBone door = model.getBone("door").orElse(null);
        if (door != null) {
            if(isByWater(entity))door.setRotY(-2);
            else door.setRotY(0);
        }
    }
    boolean isByWater(LivingEntity entity){
        if (entity.level().getBlockState(new BlockPos((int)entity.getX(),(int)entity.getY()-1,(int)entity.getZ())).is(Blocks.ICE))return true;
        return false;
    }
}