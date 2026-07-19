package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.BuildRiderItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BikaiserEntity extends BaseHenchmenEntity {

		public BikaiserEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="bikaiser";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(BuildRiderItems.BUILD_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(BuildRiderItems.BUILD_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(BuildRiderItems.BUILD_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(BuildRiderItems.NEBULASTEAM_GUN.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(BuildRiderItems.NEBULA_STEAM_GUN_KAISER.get()));
            RiderDriverItem.setUpdateForm(this.getItemBySlot(EquipmentSlot.FEET));
            RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), BuildRiderItems.GEAR_BI_KAISER.get(), 1);
    }

	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 6.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }
}