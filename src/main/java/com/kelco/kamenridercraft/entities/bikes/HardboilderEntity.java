package com.kelco.kamenridercraft.entities.bikes;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentTable;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Map;

public class HardboilderEntity extends baseBikeEntity {
	

	public HardboilderEntity(EntityType<? extends baseBikeEntity> entityType, Level level) {
		super(entityType, level);
		NAME ="hardboilder";
		}


	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}
	@Override
	public boolean alwaysAccepts() {
		return super.alwaysAccepts();
	}

	@Override
	public void equip(EquipmentTable equipmentTable, LootParams params) {
		super.equip(equipmentTable, params);
	}

	@Override
	public void equip(ResourceKey<LootTable> equipmentLootTable, LootParams params, Map<EquipmentSlot, Float> slotDropChances) {
		super.equip(equipmentLootTable, params, slotDropChances);
	}
}
