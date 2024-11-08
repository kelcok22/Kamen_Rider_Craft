package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.Kabuto_Rider_Items;
import com.kelco.kamenridercraft.item.Wizard_Rider_Items;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MageFootsoldierEntity extends BaseHenchmenEntity{

    public MageFootsoldierEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="mage_foot_soldier";
		BOW_COOLDOWN=35;
		HARD_BOW_COOLDOWN=15;
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Wizard_Rider_Items.WIZARD_HEAD.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Wizard_Rider_Items.WIZARD_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Wizard_Rider_Items.WIZARD_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Wizard_Rider_Items.MAGE_DRIVER_FOOT_SOLDIERS.get()));
    }


    
	public void remove(RemovalReason p_149847_) {
		if ( this.isDeadOrDying()) {
			if (this.random.nextInt(10) == 1) {
				BaseHenchmenEntity boss = MobsCore.SORCERER.get().create(this.level());
				if (boss != null) {
					boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
					this.level().addFreshEntity(boss);
					if (this.getLastAttacker()instanceof Player playerIn) {
						playerIn.sendSystemMessage(Component.translatable("<Kamen Rider Sorcerer> Henshin!").withStyle(ChatFormatting.GOLD));
						playerIn.sendSystemMessage(Component.translatable("Change Now!").withStyle(ChatFormatting.GOLD));
					}
				}
			}
				}
		super.remove(p_149847_);
	}

}