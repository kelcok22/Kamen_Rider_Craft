package com.kelco.kamenridercraft.entities.bosses;

import java.util.Random;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;
import com.kelco.kamenridercraft.item.Ichigo_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ParaDxEntity extends BaseHenchmenEntity {
	

	
    public ParaDxEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="para-dx";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Ex_Aid_Rider_Items.EX_AIDHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Ex_Aid_Rider_Items.EX_AIDCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Ex_Aid_Rider_Items.EX_AIDLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ex_Aid_Rider_Items.PARA_DX_BELT.get()));
    }

    public void tick() {
		if (this.getHealth()<20) {
			if(getItemBySlot(EquipmentSlot.FEET).getItem()==Ex_Aid_Rider_Items.PARA_DX_BELT.get()){
				ItemStack belt = getItemBySlot(EquipmentSlot.FEET);
				if (RiderDriverItem.get_Form_Item(belt,1)!=Ex_Aid_Rider_Items.KNOCK_OUT_FIGHTER_GASHAT.get()) {
					RiderDriverItem.set_Form_Item(belt, Ex_Aid_Rider_Items.KNOCK_OUT_FIGHTER_GASHAT.get(), 1);
					if (this.getTarget() instanceof Player playerIn){
						playerIn.sendSystemMessage(Component.translatable("Dual Up! Explosion hit! Knock Out Fighter!").withStyle(ChatFormatting.RED));
						
					}
				}
			}
		}
		super.tick();
	}

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.23F)
        		.add(Attributes.ATTACK_DAMAGE, 6.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 45.0D);
     }
    

}