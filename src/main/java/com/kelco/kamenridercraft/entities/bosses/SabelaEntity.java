package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;
import com.kelco.kamenridercraft.item.Saber_Rider_Items;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.damagesource.DamageContainer;

public class SabelaEntity extends BaseHenchmenEntity {



    public SabelaEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="sabela";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Saber_Rider_Items.SABER_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Saber_Rider_Items.SABER_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Saber_Rider_Items.SABER_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Saber_Rider_Items.ROYAL_SWORD_OF_LOGOS_BUCKLE_SABELA.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Saber_Rider_Items.ENEIKEN_NOROSHI.get()));
    }

    public void aiStep() {
    	if (this.getHealth()<100) {
			this.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,this.getX(), this.getY(),this.getZ(), 0.0D, 0.0D, 0.0D);
			this.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,this.getX(), this.getY()+1,this.getZ(), 0.0D, 0.0D, 0.0D);
			this.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,this.getX(), this.getY()+2,this.getZ(), 0.0D, 0.0D, 0.0D);
    	}
       super.aiStep();
    }

    public void onDamageTaken(DamageContainer damage) {
    	if(this.getHealth()<100 && this.getLastAttacker() instanceof Player playerIn && this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() != 0.5) {
			playerIn.sendSystemMessage(Component.translatable("attack.kamenridercraft.noroshi_muchuu"));
    		this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
    		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(7.0D);
    		this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
    	}
        super.onDamageTaken(damage);
    }
    

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.3F)
        		.add(Attributes.ATTACK_DAMAGE, 9.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 180.0D);
     }
    

}
