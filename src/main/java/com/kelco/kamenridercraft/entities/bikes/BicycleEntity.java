package com.kelco.kamenridercraft.entities.bikes;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.Revice_Rider_Items;
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

public class BicycleEntity extends baseBikeEntity {

	public BicycleEntity(EntityType<? extends baseBikeEntity> entityType, Level level) {
		super(entityType, level, MobsCore.BICYCLE_SPAWN_EGG.get());
		NAME ="bicycle";
		NAME_MODEL ="bicycle";
		NAME_ANIMATIONS ="bicycle";
		}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (!level().isClientSide()) {
			if (itemstack.getItem() == Revice_Rider_Items.REX_VISTAMP.get()) {
				if (this.level() instanceof ServerLevel) {
					BlockPos pos = this.blockPosition();
					baseBikeEntity boss = MobsCore.VICE_BIKE.get().create(this.level());
					if (boss != null) {
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
}
