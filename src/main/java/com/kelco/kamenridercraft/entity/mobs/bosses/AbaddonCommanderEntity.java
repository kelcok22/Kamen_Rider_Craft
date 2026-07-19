package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.ZeroOneRiderItems;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AbaddonCommanderEntity extends BaseHenchmenEntity {
   
    public AbaddonCommanderEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="abaddon_commander";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ZeroOneRiderItems.ZERO_ONE_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ZeroOneRiderItems.ZERO_ONE_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ZeroOneRiderItems.ZERO_ONE_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ZeroOneRiderItems.SLASH_ABADDO_RISER_R.get()));
        RiderDriverItem.setUpdateForm(this.getItemBySlot(EquipmentSlot.FEET));
	    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ZeroOneRiderItems.SLASHABADDORISER_SWORD.get()));
       switch (this.getRandom().nextInt(4)) {
         case 0:
            this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ZeroOneRiderItems.SHOT_ABADDO_RISER_G.get()));
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ZeroOneRiderItems.SHOTABADDORISER_GUN.get()));
            break;
         case 1:
             this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ZeroOneRiderItems.SHOT_ABADDO_RISER_B.get()));
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ZeroOneRiderItems.SHOTABADDORISER_GUN.get()));
            break;
         case 2:
               this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ZeroOneRiderItems.SLASH_ABADDO_RISER_O.get()));
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ZeroOneRiderItems.SLASHABADDORISER_SWORD.get()));
            break;
       }
    }
    

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.23F)
        		.add(Attributes.ATTACK_DAMAGE, 6.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 45.0D);
     }
}