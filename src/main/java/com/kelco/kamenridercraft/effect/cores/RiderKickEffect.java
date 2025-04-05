package com.kelco.kamenridercraft.effect.cores;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Objects;


public class RiderKickEffect extends MobEffect {


	public RiderKickEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

		ItemStack stack =pLivingEntity.getItemBySlot(EquipmentSlot.FEET);
		if (stack!=null){
		if (stack.getItem() instanceof RiderDriverItem belt){
			if (belt.isTransformed(pLivingEntity)){

				if (pAmplifier ==0&pLivingEntity.isShiftKeyDown()){

					pLivingEntity.addEffect(new MobEffectInstance(Effect_core.RIDER_KICK, 5, 1,false,false));
				}
				else if (pAmplifier ==1){

					pLivingEntity.push(0, 0.5, 0);
					pLivingEntity.hurtMarked = true;
					if(!pLivingEntity.level().isClientSide()) {
						((ServerLevel) pLivingEntity.level()).sendParticles(ParticleTypes.GUST,
								pLivingEntity.getX(), pLivingEntity.getY() + 1.0,
								pLivingEntity.getZ(), 1, 0, 0, 0, 1);
					}
						if (pLivingEntity.getEffect(Effect_core.RIDER_KICK).getDuration()==1){
							pLivingEntity.addEffect(new MobEffectInstance(Effect_core.RIDER_KICK, 200, 2,false,false));
						}
				}else if (pAmplifier ==4){
					pLivingEntity.level().addParticle(ParticleTypes.EXPLOSION,pLivingEntity.getX(), pLivingEntity.getY()+0.5,pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
					pLivingEntity.addEffect(new MobEffectInstance(Effect_core.RIDER_KICK, 200, 5,false,false));

				}else if (pAmplifier ==5){
					if (pLivingEntity.hasEffect(Effect_core.RIDER_KICK)){
						if (pLivingEntity.getEffect(Effect_core.RIDER_KICK).getDuration() < 2) {
							pLivingEntity.removeEffect(Effect_core.RIDER_KICK);
							pLivingEntity.addEffect(new MobEffectInstance(Effect_core.RIDER_KICK, 1, 0,false,false));
						}
					}
				}else if (pAmplifier ==2){
					pLivingEntity.setDeltaMovement(0,0,0);
						pLivingEntity.addEffect(new MobEffectInstance(Effect_core.RIDER_KICK, 200, 3,false,false));

				}else if (pAmplifier ==3){
					pLivingEntity.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,pLivingEntity.getX(), pLivingEntity.getY(),pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
					pLivingEntity.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,pLivingEntity.getX(), pLivingEntity.getY()+1,pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
					pLivingEntity.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,pLivingEntity.getX(), pLivingEntity.getY()+0.5,pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);


					Vec3 look = new Vec3(pLivingEntity.getLookAngle().x*0.1, pLivingEntity.getLookAngle().y*0.04, pLivingEntity.getLookAngle().z*0.1).scale(2);
							double y= look.y+pLivingEntity.getGravity();
							if (y>0.0)y=0.0;
					pLivingEntity.push(look.x, y, look.z);
					pLivingEntity.hurtMarked=true;

							if (pLivingEntity.onGround()||pLivingEntity.isInWater()) {pLivingEntity.addEffect(new MobEffectInstance(Effect_core.RIDER_KICK, 200, 4,false,false));}


							List<LivingEntity> nearbyEnemies = pLivingEntity.level().getEntitiesOfClass(LivingEntity.class, pLivingEntity.getBoundingBox().inflate(1), sentity ->
									(sentity instanceof Player && sentity != pLivingEntity)
											|| (sentity instanceof Mob));
							for (LivingEntity enemy : nearbyEnemies) {


								DamageSource damageSource = new DamageSource(
										pLivingEntity.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(DamageTypes.PLAYER_ATTACK),pLivingEntity,pLivingEntity,pLivingEntity.position());
								float at = (float) (pLivingEntity.getAttributes().getValue(Attributes.ATTACK_DAMAGE)+pLivingEntity.fallDistance);
								enemy.hurt(damageSource, at);
								pLivingEntity.sendSystemMessage(Component.literal("power="+at));
								pLivingEntity.fallDistance = 0.0f;
								if(!pLivingEntity.level().isClientSide()) {
									((ServerLevel) pLivingEntity.level()).sendParticles(ParticleTypes.EXPLOSION,
											pLivingEntity.getX(), pLivingEntity.getY() + 1.0,
											pLivingEntity.getZ(), 1, 0, 0, 0, 1);
									((ServerLevel) pLivingEntity.level()).sendParticles(ParticleTypes.FLAME,
											pLivingEntity.getX(), pLivingEntity.getY() + 1.0,
											pLivingEntity.getZ(), 500, 0, 0, 0, 1);
								}
								pLivingEntity.addEffect(new MobEffectInstance(Effect_core.RIDER_KICK, 100, 4,false,false));
							}
						}
					}

				}
			}
		return true;
	}
}