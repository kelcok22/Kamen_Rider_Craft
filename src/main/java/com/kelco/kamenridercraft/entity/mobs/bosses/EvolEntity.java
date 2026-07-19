package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.block.RiderBlocks;
import com.kelco.kamenridercraft.entity.ai.FlyingBossControl;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.BuildRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
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

public class EvolEntity extends BaseHenchmenEntity {



    public EvolEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="evol";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(BuildRiderItems.BUILD_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(BuildRiderItems.BUILD_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(BuildRiderItems.BUILD_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(BuildRiderItems.EVOL_DRIVER.get()));
    }

	@Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
    	if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn) {
            if (this.getHealth()<100 && playerIn.getInventory().countItem(RiderBlocks.PANDORA_BOX.get().asItem())!=0 && RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET),1)!= BuildRiderItems.EVOL_TRIGGER.get()
            && RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET),1)!= BuildRiderItems.EVOL_TRIGGER_KAIJIN.get()) {
                if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.evol_black_hole"));
		    	this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
		    	this.getAttribute(Attributes.FLYING_SPEED).setBaseValue(0.5);
		    	this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(12.0D);
		    	this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
		    	RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), BuildRiderItems.EVOL_TRIGGER.get(), 1);
                this.moveControl = new FlyingBossControl(this, 20);
    	    } else if(this.getHealth()<50 && playerIn.getInventory().countItem(BuildRiderItems.LAST_PANDORA_PANEL_BLACK.get())!=0 && RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET),1)!= BuildRiderItems.EVOL_TRIGGER_KAIJIN.get()) {
                if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.evolto"));
                this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(1);
                this.getAttribute(Attributes.FLYING_SPEED).setBaseValue(1);
                this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(15.0D);
                this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), BuildRiderItems.EVOL_TRIGGER_KAIJIN.get(), 1);
                this.moveControl = new FlyingBossControl(this, 20);
            }
        }
    }


    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.FLYING_SPEED, 0.3F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 200.0D);
     }
    

}
