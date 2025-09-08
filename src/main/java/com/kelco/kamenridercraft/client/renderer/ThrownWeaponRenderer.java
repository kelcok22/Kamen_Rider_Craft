package com.kelco.kamenridercraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemDisplayContext;

public class ThrownWeaponRenderer<T extends Entity & ItemSupplier> extends EntityRenderer<T> {
	   private static final float MIN_CAMERA_DISTANCE_SQUARED = 12.25F;
	   private final ItemRenderer itemRenderer;
	   private final float scale;
	   private final boolean fullBright;
	   private float rotation;

	   public ThrownWeaponRenderer(EntityRendererProvider.Context p_174416_, float p_174417_, boolean p_174418_) {
	      super(p_174416_);
	      this.itemRenderer = p_174416_.getItemRenderer();
	      this.scale = p_174417_;
	      this.fullBright = p_174418_;
	   }

	   public ThrownWeaponRenderer(EntityRendererProvider.Context p_174414_) {
	      this(p_174414_, 1.0F, false);
	   }

	   protected int getBlockLightLevel(T p_116092_, BlockPos p_116093_) {
	      return this.fullBright ? 15 : super.getBlockLightLevel(p_116092_, p_116093_);
	   }

	   public void render(T p_116085_, float p_116086_, float p_116087_, PoseStack p_116088_, MultiBufferSource p_116089_, int p_116090_) {
	      if (p_116085_.tickCount >= 2 || !(this.entityRenderDispatcher.camera.getEntity().distanceToSqr(p_116085_) < 12.25D)) {
			 rotation += 10.0f;
			 if(rotation >= 360) {
				 rotation = 0;
			 }
	         p_116088_.pushPose();
	         p_116088_.scale(this.scale, this.scale, this.scale);
	         p_116088_.mulPose(this.entityRenderDispatcher.cameraOrientation());
	         p_116088_.mulPose(Axis.YP.rotationDegrees(-90.0F));
	         p_116088_.mulPose(Axis.ZP.rotationDegrees(rotation));
	         this.itemRenderer.renderStatic(p_116085_.getItem(), ItemDisplayContext.FIXED, p_116090_, OverlayTexture.NO_OVERLAY, p_116088_, p_116089_, p_116085_.level(), p_116085_.getId());
	         p_116088_.popPose();
	         super.render(p_116085_, p_116086_, p_116087_, p_116088_, p_116089_, p_116090_);
	      }
	   }

		public ResourceLocation getTextureLocation(Entity p_116083_) {
			return ResourceLocation.withDefaultNamespace("textures/atlas/blocks.png");
		}
}