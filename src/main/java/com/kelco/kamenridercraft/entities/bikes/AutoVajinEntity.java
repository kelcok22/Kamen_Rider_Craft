package com.kelco.kamenridercraft.entities.bikes;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.allies.AutoVajinRoboEntity;
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
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

public class AutoVajinEntity extends baseBikeEntity {

	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private AutoVajinRoboEntity boss = null;
	private int summonLevel = 21;

	public AutoVajinEntity(EntityType<? extends baseBikeEntity> entityType, Level level) {
		super(entityType, level, MobsCore.AUTO_VAJIN_SPAWN_EGG.get());
		NAME ="auto_vajin";
		NAME_MODEL ="auto_vajin";
	}

	@Override
	public void tick() {
		super.tick();
		if (summonLevel <= 0 && this.boss != null) {
			BlockPos pos = this.blockPosition();
			this.boss.moveTo(pos.getX(), pos.getY(), pos.getZ(), this.getYRot(), this.getXRot());
			this.boss.yRotO = getYRot();
			this.boss.xRotO = getXRot();
			this.boss.yBodyRot = this.getYRot();
			this.boss.yHeadRot = this.yBodyRot;
			if (this.boss.level() instanceof ServerLevel sl) {
				sl.sendParticles(ParticleTypes.GUST,
						this.boss.getX(), boss.getY() + 1.0,
						this.boss.getZ(), 1, 0, 0, 0, 1);
			}
			this.level().addFreshEntity(this.boss);
			this.remove(RemovalReason.DISCARDED);
		} else if (this.boss != null) {
			this.summonLevel--;
		}
	}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		if (!level().isClientSide()) {
			if (this.boss != null) {
				return InteractionResult.FAIL;
			}
			 if (player.isShiftKeyDown() && this.level() instanceof ServerLevel && this.boss == null && this.getControllingPassenger() == null){
				 this.boss = MobsCore.AUTO_VAJIN_ROBO.get().create(this.level());
				 this.boss.tame(player);
				 triggerAnim("Transform", "transform");
			 } else {
				 return super.mobInteract(player, hand);
			 }
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
}
