package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Ghost_Rider_Items;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class IgorEntity extends BaseHenchmenEntity {



    public IgorEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="igor";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Ghost_Rider_Items.GHOST_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Ghost_Rider_Items.GHOST_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Ghost_Rider_Items.GHOST_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ghost_Rider_Items.PROTO_MEGA_ULORDER_IGOR.get()));
    }
    
    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.15F)
        		.add(Attributes.ATTACK_DAMAGE, 5.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 50.0D);
     }
    

}
