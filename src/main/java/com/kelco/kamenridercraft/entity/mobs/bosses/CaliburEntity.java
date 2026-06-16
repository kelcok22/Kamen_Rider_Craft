package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.SaberRiderItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CaliburEntity extends BaseHenchmenEntity {



    public CaliburEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="calibur";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(SaberRiderItems.SABER_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(SaberRiderItems.SABER_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(SaberRiderItems.SABER_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(SaberRiderItems.JAKEN_CALIBURDRIVER.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(SaberRiderItems.ANKOKUKEN_KURAYAMI.get()));
    }

	@Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
    	if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getHealth()<30
		&& this.getItemBySlot(EquipmentSlot.FEET).getItem()== SaberRiderItems.JAKEN_CALIBURDRIVER.get() && RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET),1)!= SaberRiderItems.JAOU_DRAGON_WONDER_RIDE_BOOK.get()) {
			playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.calibur_jaou"));
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3);
			this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(7.0D);
			this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);

			if (playerIn.getInventory().countItem(SaberRiderItems.KING_OF_ARTHUR_WONDER_RIDE_BOOK.get())!=0){
				ItemEntity key = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(SaberRiderItems.DRAGONIC_KNIGHT_WONDER_RIDE_BOOK.get(), 1), 0, 0, 0);
				key.setPickUpDelay(0);
				playerIn.level().addFreshEntity(key);
				playerIn.sendSystemMessage(Component.translatable("loot.kamenridercraft.dragonic_knight"));
			}
			RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), SaberRiderItems.JAOU_DRAGON_WONDER_RIDE_BOOK.get(), 1);
    	}
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
