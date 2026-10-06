package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.util.Color;


public class FreezeRenderLayerInfo extends ModuleRenderLayerInfo{
    public FreezeRenderLayerInfo(String texture, String model) {
        super(texture, model,Color.CYAN.getColor(),2);
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource bufferSource, PoseStack poseStack, int packedLight) {
        GeoBone door = model.getBone("door").orElse(null);
        if (door != null) {
            if (isByWater(entity, entity.level())) {
                door.setRotY(-2);
            } else {
                door.setRotY(0);
            }
        }
    }

    boolean isByWater(LivingEntity entity, Level level) {
        int xPos = entity.getBlockX();
        int yPos = entity.getBlockY();
        int zPos = entity.getBlockZ();

        return level.getBlockState(new BlockPos(xPos, yPos - 1, zPos)).is(Blocks.ICE)
                || level.getBlockState(new BlockPos(xPos + 1, yPos - 1, zPos)).is(Blocks.ICE)
                || level.getBlockState(new BlockPos(xPos - 1, yPos - 1, zPos)).is(Blocks.ICE)
                || level.getBlockState(new BlockPos(xPos, yPos - 1, zPos + 1)).is(Blocks.ICE)
                || level.getBlockState(new BlockPos(xPos, yPos - 1, zPos - 1)).is(Blocks.ICE)
                || level.getBlockState(new BlockPos(xPos + 1, yPos - 1, zPos + 1)).is(Blocks.ICE)
                || level.getBlockState(new BlockPos(xPos - 1, yPos - 1, zPos + 1)).is(Blocks.ICE)
                || level.getBlockState(new BlockPos(xPos + 1, yPos - 1, zPos + 1)).is(Blocks.ICE)
                || level.getBlockState(new BlockPos(xPos + 1, yPos - 1, zPos - 1)).is(Blocks.ICE)
                || level.getBlockState(new BlockPos(xPos + 1, yPos - 1, zPos - 1)).is(Blocks.ICE)
                || level.getBlockState(new BlockPos(xPos - 1, yPos - 1, zPos - 1)).is(Blocks.ICE)
                || level.getBlockState(new BlockPos(xPos - 1, yPos - 1, zPos + 1)).is(Blocks.ICE)
                || level.getBlockState(new BlockPos(xPos - 1, yPos - 1, zPos - 1)).is(Blocks.ICE);
    }
}