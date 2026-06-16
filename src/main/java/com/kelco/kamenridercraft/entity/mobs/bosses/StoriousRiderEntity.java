package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.reiwa.SaberRiderItems;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StoriousRiderEntity extends BaseHenchmenEntity {



    public StoriousRiderEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="storious";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(SaberRiderItems.SABER_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(SaberRiderItems.SABER_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(SaberRiderItems.SABER_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(SaberRiderItems.DOOMS_DRIVER_BUCKLE_STORIOUS.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(SaberRiderItems.BILGAMED.get()));
    }

	public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
    		if(this.getLastAttacker() instanceof Player playerIn){
                ItemEntity key = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(SaberRiderItems.WONDER_ALMIGHTY_WONDER_RIDE_BOOK.get(), 1), 0, 0, 0);
			    key.setPickUpDelay(0);
			    playerIn.level().addFreshEntity(key);
		        playerIn.sendSystemMessage(Component.translatable("loot.kamenridercraft.wonder_almighty"));
    		}
    	}
		super.remove(p_149847_);
	}    

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.3F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 200.0D);
     }
    

}
