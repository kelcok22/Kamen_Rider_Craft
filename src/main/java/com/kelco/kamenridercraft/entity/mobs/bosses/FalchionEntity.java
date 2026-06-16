package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.ai.FlyingBossControl;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.SaberRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FalchionEntity extends BaseHenchmenEntity {



    public FalchionEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="falchion";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(SaberRiderItems.SABER_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(SaberRiderItems.SABER_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(SaberRiderItems.SABER_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(SaberRiderItems.HAKEN_BLADRIVER_FALCHION.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(SaberRiderItems.MUMEIKEN_KYOMU.get()));
        this.moveControl = new FlyingBossControl(this, 20);
    }

	@Override
    public void actuallyHurt(DamageSource source, float amount) {
		if (!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && playerIn.getInventory().countItem(SaberRiderItems.EMOTIONAL_DRAGON_WONDER_RIDE_BOOK.get())==0) {
			this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 3,true,false));
		}
        super.actuallyHurt(source, amount);
    	if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn) {
			if (playerIn.getInventory().countItem(SaberRiderItems.WONDER_WORLD_STORY_OF_RAIMEIKEN_IKAZUCHI_WONDER_RIDE_BOOK.get())!=0 && RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET),1)!= SaberRiderItems.AMAZING_SIREN_WONDER_RIDE_BOOK.get()) {
                if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.falchion_siren"));
    			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.4);
    			this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(12.0D);
    			this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
    	        RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), SaberRiderItems.AMAZING_SIREN_WONDER_RIDE_BOOK.get(), 1);
                this.moveControl = new MoveControl(this);
				this.setNoGravity(false);
			}
    	}
    }

	public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying() && this.getLastAttacker() instanceof Player playerIn) {
    		if(playerIn.getInventory().countItem(SaberRiderItems.BRAVE_DRAGON_WONDER_RIDE_BOOK.get())!=0){
                ItemEntity key = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(SaberRiderItems.EMOTIONAL_DRAGON_WONDER_RIDE_BOOK.get(), 1), 0, 0, 0);
			    key.setPickUpDelay(0);
			    playerIn.level().addFreshEntity(key);
		        playerIn.sendSystemMessage(Component.translatable("loot.kamenridercraft.emotional_dragon"));
    		}
            if(playerIn.getInventory().countItem(SaberRiderItems.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK.get())!=0
            &&playerIn.getInventory().countItem(SaberRiderItems.WONDER_WORLD_STORY_OF_RAIMEIKEN_IKAZUCHI_WONDER_RIDE_BOOK.get())!=0){
        	    if (playerIn.getInventory().getItem(40).getItem()== SaberRiderItems.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK.get()) playerIn.getInventory().removeItem(40, 1);
				else playerIn.getInventory().removeItem(playerIn.getInventory().findSlotMatchingItem(new ItemStack(SaberRiderItems.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK.get())), 1);
        	    if (playerIn.getInventory().getItem(40).getItem()== SaberRiderItems.WONDER_WORLD_STORY_OF_RAIMEIKEN_IKAZUCHI_WONDER_RIDE_BOOK.get()) playerIn.getInventory().removeItem(40, 1);
				else playerIn.getInventory().removeItem(playerIn.getInventory().findSlotMatchingItem(new ItemStack(SaberRiderItems.WONDER_WORLD_STORY_OF_RAIMEIKEN_IKAZUCHI_WONDER_RIDE_BOOK.get())), 1);
                ItemEntity key = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(SaberRiderItems.ARABIANA_NIGHT_WONDER_RIDE_BOOK.get(), 1), 0, 0, 0);
			    key.setPickUpDelay(0);
			    playerIn.level().addFreshEntity(key);
		        playerIn.sendSystemMessage(Component.translatable("loot.kamenridercraft.arabiana_night"));
    		}
            if(playerIn.getInventory().countItem(SaberRiderItems.KAENKEN_REKKA.get())!=0
            &&playerIn.getInventory().countItem(SaberRiderItems.SUISEIKEN_NAGARE.get())!=0
            &&playerIn.getInventory().countItem(SaberRiderItems.RAIMEIKEN_IKAZUCHI.get())!=0
            &&playerIn.getInventory().countItem(SaberRiderItems.DOGOUKEN_GEKIDO.get())!=0
            &&playerIn.getInventory().countItem(SaberRiderItems.FUUSOUKEN_HAYATE_ITTOURYU.get())!=0
            &&playerIn.getInventory().countItem(SaberRiderItems.ONJUUKEN_SUZUNE.get())!=0
            &&playerIn.getInventory().countItem(SaberRiderItems.ANKOKUKEN_KURAYAMI.get())!=0
            &&playerIn.getInventory().countItem(SaberRiderItems.KOUGOUKEN_SAIKOU.get())!=0
            &&playerIn.getInventory().countItem(SaberRiderItems.ENEIKEN_NOROSHI.get())!=0
            &&playerIn.getInventory().countItem(SaberRiderItems.JIKOKUKEN_KAIJI.get())!=0){
                ItemEntity key = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(SaberRiderItems.HAOUKEN_XROSS_SABER.get(), 1), 0, 0, 0);
			    key.setPickUpDelay(0);
			    playerIn.level().addFreshEntity(key);
		        playerIn.sendSystemMessage(Component.translatable("loot.kamenridercraft.xross_saber"));
    		}
    	}
		super.remove(p_149847_);
	}
    

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2F)
                .add(Attributes.FLYING_SPEED, 0.2F)
        		.add(Attributes.ATTACK_DAMAGE, 2.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 70.0D);
     }
    

}
