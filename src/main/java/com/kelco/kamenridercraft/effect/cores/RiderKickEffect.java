package com.kelco.kamenridercraft.effect.cores;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.footSoldiers.ShockerCombatmanEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Decade_Rider_Items;
import com.kelco.kamenridercraft.item.Kuuga_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
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
import java.util.Stack;


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

				boolean fly = pLivingEntity instanceof Player player && player.getAbilities().flying;

				if (pAmplifier ==0&pLivingEntity.isShiftKeyDown()&!fly){

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
								belt.OnRiderKickHit(stack,pLivingEntity,enemy);
								if (enemy.isDeadOrDying()&enemy instanceof ShockerCombatmanEntity){
									if (pLivingEntity instanceof Player player) {
										if (belt.Rider=="ichigo") {
											player.drop(new ItemStack(Modded_item_core.LETS_GO_RIDER_MUSIC_DISC.get(), pAmplifier + 1), false);
										}
									}
								}
								pLivingEntity.addEffect(new MobEffectInstance(Effect_core.RIDER_KICK, 100, 4,false,true));
							}
						}
					}

				}
			}
		return true;
	}
}