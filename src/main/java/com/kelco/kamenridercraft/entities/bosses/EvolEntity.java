package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Build_Rider_Items;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EvolEntity extends BaseHenchmenEntity {



    public EvolEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="evol";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Build_Rider_Items.BUILD_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Build_Rider_Items.BUILD_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Build_Rider_Items.BUILD_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Build_Rider_Items.EVOL_DRIVER.get()));
    }

    public void aiStep() {
    	if (this.getItemBySlot(EquipmentSlot.FEET).getItem()==Build_Rider_Items.EVOL_DRIVER.get() && RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET),1)!=Build_Rider_Items.EVOL_TRIGGER_KAIJIN.get()) {
    		if (this.getHealth()<100) {
    			if(this.getLastAttacker() instanceof Player playerIn) {
					playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.evolto"));
    				
    				this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
    				this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(10.0D);
    				this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
    			}
    	        RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Build_Rider_Items.EVOL_TRIGGER_KAIJIN.get(), 1);
    		}
    	}
       super.aiStep();
    }
    

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.3F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 200.0D);
     }
    

}
