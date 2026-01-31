package com.kelco.kamenridercraft.item.ichigo;

import com.kelco.kamenridercraft.client.renderer.DrillArmItemRenderer;
import com.kelco.kamenridercraft.item.BaseItems.BasePickaxeItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
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
	private boolean triggered = false;
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
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
//		if (level instanceof ServerLevel serverLevel) {
//			if (!triggered) {
//				triggerAnim(player, GeoItem.getOrAssignId(player.getItemInHand(hand), serverLevel), "Drilling", "drilling");
//			}
		return super.use(level, player, hand);
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}