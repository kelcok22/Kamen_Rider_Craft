package com.kelco.kamenridercraft.entities.bikes;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class SkullboilderEntity extends baseBikeEntity {


	
	public SkullboilderEntity(EntityType<? extends baseBikeEntity> entityType, Level level) {
		super(entityType, level);
		NAME ="skullboilder";
		}


	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}
}
