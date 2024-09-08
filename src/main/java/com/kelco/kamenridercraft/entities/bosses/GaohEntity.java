package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Den_O_Rider_Items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GaohEntity extends BaseHenchmenEntity {
	
		public GaohEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="gaoh";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Den_O_Rider_Items.DEN_OHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Den_O_Rider_Items.DEN_OCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Den_O_Rider_Items.DEN_OLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Den_O_Rider_Items.GAOH_BELT.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Den_O_Rider_Items.GAOH_GASHER.get()));
    }
 
    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.40F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D)
        		.add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
     }
    

}