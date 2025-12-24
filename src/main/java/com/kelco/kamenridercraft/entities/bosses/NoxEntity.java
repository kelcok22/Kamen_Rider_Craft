package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Zeztz_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NoxEntity extends BaseHenchmenEntity {

		public NoxEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="nox_knight";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Zeztz_Rider_Items.ZEZTZ_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Zeztz_Rider_Items.ZEZTZ_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Zeztz_Rider_Items.ZEZTZ_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zeztz_Rider_Items.KIGHT_INVOKER.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Zeztz_Rider_Items.BREAKAM_BUSTER.get()));
    }


	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 2.0D)
        		.add(Attributes.MAX_HEALTH, 60.0D);
     }
    

}