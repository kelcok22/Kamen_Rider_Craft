package com.kelco.kamenridercraft.entities.bikes;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.allies.AutoVajinRoboEntity;
import com.kelco.kamenridercraft.item.OOO_Rider_Items;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class AutoVajinEntity extends baseBikeEntity {

	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	public AutoVajinEntity(EntityType<? extends baseBikeEntity> entityType, Level level) {
		super(entityType, level, MobsCore.AUTO_VAJIN_SPAWN_EGG.get());
		NAME ="auto_vajin";
		NAME_MODEL ="auto_vajin";
		}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (!level().isClientSide()) {
			 if (player.isShiftKeyDown()){
				if (this.level() instanceof ServerLevel && this.getControllingPassenger() == null) {
					BlockPos pos = this.blockPosition();
					AutoVajinRoboEntity boss = MobsCore.AUTO_VAJIN_ROBO.get().create(this.level());
					if (boss != null) {
						boss.tame(player);
						boss.moveTo(pos.getX(), pos.getY(), pos.getZ(), this.getYRot(), this.getXRot());
						boss.yRotO = getYRot();
						boss.xRotO = getXRot();
						setRot(getYRot(), getXRot());
						boss.yBodyRot = this.getYRot();
						boss.yHeadRot = this.yBodyRot;
						if (boss.level() instanceof ServerLevel sl) {
							sl.sendParticles(ParticleTypes.GUST,
									boss.getX(), boss.getY() + 1.0,
									boss.getZ(), 1, 0, 0, 0, 1);
						}
						this.level().addFreshEntity(boss);
						this.remove(RemovalReason.DISCARDED);
					}

				}

			}else return super.mobInteract(player, hand);

		}
		return InteractionResult.PASS;
	}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}

	// Add our generic idle animation controller
/**	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

		RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.auto_vajin_bike.idle");
		RawAnimation WALK = RawAnimation.begin().thenLoop("animation.auto_vajin_bike.walk");


		controllers.add(new AnimationController<>(this, "Walk/Idle", 0, state -> state.setAndContinue(! state.isMoving() ? IDLE : WALK)));
	}
**/
}
