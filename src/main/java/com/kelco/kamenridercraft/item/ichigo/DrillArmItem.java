package com.kelco.kamenridercraft.item.ichigo;

import com.kelco.kamenridercraft.client.renderer.DrillArmItemRenderer;
import com.kelco.kamenridercraft.item.BaseItems.BasePickaxeItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;


public class DrillArmItem extends BasePickaxeItem implements GeoItem {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private int swingTimer = 0;
	private boolean animationOn = false;
	private static final RawAnimation ACTIVATE_ANIM = RawAnimation.begin().thenPlay("drilling");

	public DrillArmItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, Atk, Spd, prop);
		SingletonGeoAnimatable.registerSyncedAnimatable(this);
	}

	@Override
	public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
		consumer.accept(new GeoRenderProvider() {
			private DrillArmItemRenderer renderer;

			@Override
			public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
				if (this.renderer == null)
					this.renderer = new DrillArmItemRenderer();
				return this.renderer;
			}
		});
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>(this, "Drilling", 0, state -> PlayState.STOP)
				.triggerableAnim("drilling", ACTIVATE_ANIM));
	}

	@Override
	public boolean onEntitySwing(ItemStack stack, LivingEntity entity, InteractionHand hand) {
		if (entity.level() instanceof ServerLevel serverLevel) {
			triggerAnim(entity, GeoItem.getOrAssignId(stack, serverLevel), "Drilling", "drilling");
			swingTimer = 0;
			animationOn = true;
		}
		return super.onEntitySwing(stack, entity, hand);
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		super.inventoryTick(stack, level, entity, slotId, isSelected);
		if (entity.level() instanceof ServerLevel serverLevel){
			if (!isSelected) {
				animationOn = false;
				swingTimer = 0;
			}
			if (animationOn) {
				if (swingTimer >= 20) {
					animationOn = false;
					swingTimer = 0;
				}
				swingTimer +=1;
			} else{
				stopTriggeredAnim(entity, GeoItem.getOrAssignId(stack, (ServerLevel) entity.level()), "Drilling", "drilling");
			}
		}
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}