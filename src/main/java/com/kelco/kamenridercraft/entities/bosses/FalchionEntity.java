package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.ai.FlyingBossControl;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Saber_Rider_Items;
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
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Saber_Rider_Items.SABER_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Saber_Rider_Items.SABER_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Saber_Rider_Items.SABER_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Saber_Rider_Items.HAKEN_BLADRIVER_FALCHION.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Saber_Rider_Items.MUMEIKEN_KYOMU.get()));
        this.moveControl = new FlyingBossControl(this, 20);
    }

	@Override
    public void actuallyHurt(DamageSource source, float amount) {
		if (!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && playerIn.getInventory().countItem(Saber_Rider_Items.EMOTIONAL_DRAGON_WONDER_RIDE_BOOK.get())==0) {
			this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 3,true,false));
		}
        super.actuallyHurt(source, amount);
    	if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn) {
			if (playerIn.getInventory().countItem(Saber_Rider_Items.WONDER_WORLD_STORY_OF_RAIMEIKEN_IKAZUCHI_WONDER_RIDE_BOOK.get())!=0 && RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET),1)!=Saber_Rider_Items.AMAZING_SIREN_WONDER_RIDE_BOOK.get()) {
                if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.falchion_siren"));
    			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.4);
    			this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(12.0D);
    			this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
    	        RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Saber_Rider_Items.AMAZING_SIREN_WONDER_RIDE_BOOK.get(), 1);
                this.moveControl = new MoveControl(this);
				this.setNoGravity(false);
			}
    	}
    }

	public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying() && this.getLastAttacker() instanceof Player playerIn) {
    		if(playerIn.getInventory().countItem(Saber_Rider_Items.BRAVE_DRAGON_WONDER_RIDE_BOOK.get())!=0){
                ItemEntity key = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(Saber_Rider_Items.EMOTIONAL_DRAGON_WONDER_RIDE_BOOK.get(), 1), 0, 0, 0);
			    key.setPickUpDelay(0);
			    playerIn.level().addFreshEntity(key);
		        playerIn.sendSystemMessage(Component.translatable("loot.kamenridercraft.emotional_dragon"));
    		}
            if(playerIn.getInventory().countItem(Saber_Rider_Items.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK.get())!=0
            &&playerIn.getInventory().countItem(Saber_Rider_Items.WONDER_WORLD_STORY_OF_RAIMEIKEN_IKAZUCHI_WONDER_RIDE_BOOK.get())!=0){
        	    if (playerIn.getInventory().getItem(40).getItem()==Saber_Rider_Items.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK.get()) playerIn.getInventory().removeItem(40, 1);
				else playerIn.getInventory().removeItem(playerIn.getInventory().findSlotMatchingItem(new ItemStack(Saber_Rider_Items.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK.get())), 1);
        	    if (playerIn.getInventory().getItem(40).getItem()==Saber_Rider_Items.WONDER_WORLD_STORY_OF_RAIMEIKEN_IKAZUCHI_WONDER_RIDE_BOOK.get()) playerIn.getInventory().removeItem(40, 1);
				else playerIn.getInventory().removeItem(playerIn.getInventory().findSlotMatchingItem(new ItemStack(Saber_Rider_Items.WONDER_WORLD_STORY_OF_RAIMEIKEN_IKAZUCHI_WONDER_RIDE_BOOK.get())), 1);
                ItemEntity key = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(Saber_Rider_Items.ARABIANA_NIGHT_WONDER_RIDE_BOOK.get(), 1), 0, 0, 0);
			    key.setPickUpDelay(0);
			    playerIn.level().addFreshEntity(key);
		        playerIn.sendSystemMessage(Component.translatable("loot.kamenridercraft.arabiana_night"));
    		}
            if(playerIn.getInventory().countItem(Saber_Rider_Items.KAENKEN_REKKA.get())!=0
            &&playerIn.getInventory().countItem(Saber_Rider_Items.SUISEIKEN_NAGARE.get())!=0
            &&playerIn.getInventory().countItem(Saber_Rider_Items.RAIMEIKEN_IKAZUCHI.get())!=0
            &&playerIn.getInventory().countItem(Saber_Rider_Items.DOGOUKEN_GEKIDO.get())!=0
            &&playerIn.getInventory().countItem(Saber_Rider_Items.FUUSOUKEN_HAYATE_ITTOURYU.get())!=0
            &&playerIn.getInventory().countItem(Saber_Rider_Items.ONJUUKEN_SUZUNE.get())!=0
            &&playerIn.getInventory().countItem(Saber_Rider_Items.ANKOKUKEN_KURAYAMI.get())!=0
            &&playerIn.getInventory().countItem(Saber_Rider_Items.KOUGOUKEN_SAIKOU.get())!=0
            &&playerIn.getInventory().countItem(Saber_Rider_Items.ENEIKEN_NOROSHI.get())!=0
            &&playerIn.getInventory().countItem(Saber_Rider_Items.JIKOKUKEN_KAIJI.get())!=0){
                ItemEntity key = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(Saber_Rider_Items.HAOUKEN_XROSS_SABER.get(), 1), 0, 0, 0);
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
