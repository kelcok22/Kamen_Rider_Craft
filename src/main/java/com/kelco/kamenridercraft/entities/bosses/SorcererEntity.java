package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Kabuto_Rider_Items;
import com.kelco.kamenridercraft.item.Wizard_Rider_Items;
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

public class SorcererEntity extends BaseHenchmenEntity {

		public SorcererEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="sorcerer";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Wizard_Rider_Items.WIZARD_HEAD.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Wizard_Rider_Items.WIZARD_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Wizard_Rider_Items.WIZARD_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Wizard_Rider_Items.SORCERER_DRIVER.get()));
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Wizard_Rider_Items.DIS_HALBERD.get()));
    }

	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 5.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }
    

}