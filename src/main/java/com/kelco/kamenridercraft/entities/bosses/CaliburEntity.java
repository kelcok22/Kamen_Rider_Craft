package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;
import com.kelco.kamenridercraft.item.Saber_Rider_Items;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;

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

public class CaliburEntity extends BaseHenchmenEntity {



    public CaliburEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="calibur";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Saber_Rider_Items.SABER_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Saber_Rider_Items.SABER_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Saber_Rider_Items.SABER_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Saber_Rider_Items.JAKEN_CALIBURDRIVER.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Saber_Rider_Items.ANKOKUKEN_KURAYAMI.get()));
    }

    public void aiStep() {
    	if (this.getItemBySlot(EquipmentSlot.FEET).getItem()==Saber_Rider_Items.JAKEN_CALIBURDRIVER.get() && RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET),1)!=Saber_Rider_Items.JAOU_DRAGON_WONDER_RIDE_BOOK.get()) {
    		if (this.getHealth()<30) {
    			if(this.getLastAttacker() instanceof Player playerIn) {
					playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.calibur_jaou"));
    				this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3);
    				this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(7.0D);
    				this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);

		            if (playerIn.getInventory().countItem(Saber_Rider_Items.KING_OF_ARTHUR_WONDER_RIDE_BOOK.get())!=0){
                        ItemEntity key = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(Saber_Rider_Items.DRAGONIC_KNIGHT_WONDER_RIDE_BOOK.get(), 1), 0, 0, 0);
				        key.setPickUpDelay(0);
				        playerIn.level().addFreshEntity(key);
		            	playerIn.sendSystemMessage(Component.translatable("loot.kamenridercraft.dragonic_knight"));
		            }
    			}
    	        RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Saber_Rider_Items.JAOU_DRAGON_WONDER_RIDE_BOOK.get(), 1);
    		}
    	}
       super.aiStep();
    }
    

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.15F)
        		.add(Attributes.ATTACK_DAMAGE, 5.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 50.0D);
     }
    

}
