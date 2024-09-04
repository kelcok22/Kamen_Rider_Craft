package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Kabuto_Rider_Items;
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

public class CaucasusEntity extends BaseHenchmenEntity {
	
		public CaucasusEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="caucasus";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Kabuto_Rider_Items.KABUTOHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Kabuto_Rider_Items.KABUTOCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Kabuto_Rider_Items.KABUTOLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Kabuto_Rider_Items.CAUCASUS_RIDER_BELT.get()));
    }

    public void aiStep() {
    	if (this.getHealth()<50 && this.getAttributeValue(Attributes.MOVEMENT_SPEED) != 1) {
    		if(this.getLastAttacker() instanceof Player playerIn) {
                playerIn.sendSystemMessage(Component.translatable("Hyper Clock Up!").withStyle(ChatFormatting.GOLD));
			
    			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(1);
    			this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(10.0D);
    			this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
    		}
    	}
       super.aiStep();
    }

	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 5.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }
    

}