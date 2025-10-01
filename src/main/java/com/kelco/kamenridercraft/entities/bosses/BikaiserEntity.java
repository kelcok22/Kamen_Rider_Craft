package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Build_Rider_Items;
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
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Build_Rider_Items.BUILD_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Build_Rider_Items.BUILD_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Build_Rider_Items.BUILD_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Build_Rider_Items.NEBULASTEAM_GUN.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Build_Rider_Items.NEBULA_STEAM_GUN_KAISER.get()));
            RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Build_Rider_Items.GEAR_BI_KAISER.get(), 1);
    }

	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 6.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }
}