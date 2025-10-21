package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Drive_Rider_Items;
import com.kelco.kamenridercraft.item.Gaim_Rider_Items;
import com.kelco.kamenridercraft.item.Ghost_Rider_Items;
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

import java.util.Random;

public class DarkGhostEntity extends BaseHenchmenEntity {



    public DarkGhostEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="dark_ghost";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Ghost_Rider_Items.GHOST_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Ghost_Rider_Items.GHOST_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Ghost_Rider_Items.GHOST_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ghost_Rider_Items.DARK_GHOST_DRIVER.get()));
    }

	@Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
    	if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getHealth()<60
		&& this.getItemBySlot(EquipmentSlot.FEET).getItem()==Ghost_Rider_Items.DARK_GHOST_DRIVER.get() && RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET),2)==Ghost_Rider_Items.DARK_DAMASHII.get()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3);
			this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(8.0D);
			this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);

            Random generator = new Random();
            int rand = generator.nextInt(3);
            if (rand==1) {
                playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.dark_ghost_napoleon"));
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Ghost_Rider_Items.NAPOLEON_GHOST_EYECON.get(), 2);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Ghost_Rider_Items.GAN_GUN_SABER_BLADE.get()));
            }else if (rand==2) {
                playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.dark_ghost_ikkyu"));
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Ghost_Rider_Items.IKKYU_GHOST_EYECON.get(), 2);
            }else {
                playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.dark_ghost_pythagoras"));
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Ghost_Rider_Items.PYTHAGORAS_GHOST_EYECON.get(), 2);
            }
            if (playerIn.getItemBySlot(EquipmentSlot.FEET).getItem()== Ghost_Rider_Items.GHOST_DRIVER.asItem()){
                ItemEntity key = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(Ghost_Rider_Items.DARWIN_GHOST_EYECON.get(), 1), 0, 0, 0);
                key.setPickUpDelay(0);
                playerIn.level().addFreshEntity(key);
            }
    	}
    }
    
    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.15F)
        		.add(Attributes.ATTACK_DAMAGE, 6.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }
    

}
