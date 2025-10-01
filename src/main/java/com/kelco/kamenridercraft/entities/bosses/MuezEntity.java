package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Faiz_Rider_Items;
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

public class MuezEntity extends BaseHenchmenEntity {
	
		public MuezEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="muez";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Faiz_Rider_Items.FAIZHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Faiz_Rider_Items.FAIZCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Faiz_Rider_Items.FAIZLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Faiz_Rider_Items.MUEZ_DRIVER.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Faiz_Rider_Items.MUEZ_EDGE.get()));
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Faiz_Rider_Items.MUEZ_EDGE.get()));
    }

	@Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
    	if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getHealth()<50
		&& this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue()!=0.5) {
			playerIn.sendSystemMessage(Component.translatable("attack.kamenridercraft.predictive_ai"));
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
			this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(10.0D);
			this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
    	}
    }

	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 5.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }
    

}