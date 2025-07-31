package com.kelco.kamenridercraft.entities.bikes;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.allies.BaseAllyEntity;
import com.kelco.kamenridercraft.item.OOO_Rider_Items;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public class RidevendorEntity extends baseBikeEntity {

	public RidevendorEntity(EntityType<? extends baseBikeEntity> entityType, Level level) {
		super(entityType, level);
		NAME ="ridevendor";
		NAME_MODEL ="ridevendor";
		}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (!level().isClientSide()) {
			if (itemstack.getItem() == OOO_Rider_Items.TORA_CANDROID.get()) {
				if (this.level() instanceof ServerLevel) {
					BlockPos pos = this.blockPosition();
					baseBikeEntity boss = MobsCore.TORIDEVENDOR.get().create(this.level());
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
						itemstack.consume(1, player);
					}

				}

			} else if (player.isShiftKeyDown()){
				if (this.level() instanceof ServerLevel) {
					BlockPos pos = this.blockPosition();
					baseBikeEntity boss = MobsCore.RIDEVENDOR_VENDING_MODE.get().create(this.level());
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
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}
}
