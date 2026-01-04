package com.kelco.kamenridercraft.entities.bikes;

import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class RisehopperEntity extends baseBikeEntity {



	public RisehopperEntity(EntityType<? extends baseBikeEntity> entityType, Level level) {
		super(entityType, level, Zero_One_Rider_Items.HIDEN_RISEPHONE.get());
		NAME ="rise_hopper_bike";
		NAME_MODEL ="sakura_hurricane";
		}


	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}
}
