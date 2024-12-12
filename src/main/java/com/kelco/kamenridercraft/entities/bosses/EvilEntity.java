package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Revice_Rider_Items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EvilEntity extends BaseHenchmenEntity {
	


	
    public EvilEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="evil";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Revice_Rider_Items.REVICE_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Revice_Rider_Items.REVICE_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Revice_Rider_Items.REVICE_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Revice_Rider_Items.TWO_SIDRIVER_EVIL.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Revice_Rider_Items.EVILBLADE.get()));
    }


    public void remove(Entity.RemovalReason p_149847_) {

		if ( this.isDeadOrDying() && !this.level().isClientSide
            && this.getLastAttacker() instanceof Player player
            && player.getInventory().countItem(Revice_Rider_Items.CROW_VISTAMP.get())!=0) {
                player.getInventory().clearOrCountMatchingItems(ItemStack -> ItemStack.getItem() == Revice_Rider_Items.CROW_VISTAMP.get(), 1, player.getInventory());
                ItemEntity stamp = new ItemEntity(this.level(), player.getX(), player.getY(), player.getZ(), new ItemStack(Revice_Rider_Items.HOLY_WING_VISTAMP.get(), 1), 0, 0, 0);
                stamp.setPickUpDelay(0);
                this.level().addFreshEntity(stamp);
                player.sendSystemMessage(Component.translatable("loot.kamenridercraft.holy_wing"));
		}
		super.remove(p_149847_);
	}

 

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.3F)
        		.add(Attributes.ATTACK_DAMAGE, 5.0D)
        		.add(Attributes.ARMOR, 0.0D)
        		.add(Attributes.MAX_HEALTH, 60.0D);
     }
    

}