package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Drive_Rider_Items;
import com.kelco.kamenridercraft.item.Gaim_Rider_Items;
import com.kelco.kamenridercraft.item.Ghost_Rider_Items;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class NecromEntity extends BaseHenchmenEntity {



    public NecromEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="necrom";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Ghost_Rider_Items.GHOST_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Ghost_Rider_Items.GHOST_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Ghost_Rider_Items.GHOST_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ghost_Rider_Items.MEGA_ULORDER.get()));
    }

	@Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
    	if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getHealth()<30
		&& this.getItemBySlot(EquipmentSlot.FEET).getItem()==Ghost_Rider_Items.MEGA_ULORDER.get() && RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET),2)==Ghost_Rider_Items.NECROM_DAMASHII.get()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3);
			this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(7.0D);
			this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);

            Inventory Inventory = playerIn.getInventory();
            boolean hasEyecon = Inventory.countItem(Ghost_Rider_Items.DEEP_SPECTER_GHOST_EYECON.get()) != 0;

            Random generator = new Random();
            int rand = generator.nextInt(2);
            if (hasEyecon) {
                playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.necrom_yujou_burst"));
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Ghost_Rider_Items.YUJOU_BURST_DAMASHII.get(), 2);
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Ghost_Rider_Items.YUJOU_BURST_GHOST_EYECON.get(), 1);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Ghost_Rider_Items.GAN_GUN_CATCHER_ROD.get()));
                this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.4);
                this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(10.0D);
                this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(80.0D);
                this.heal(40);
            }else if (rand==1) {
                playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.necrom_sanzo"));
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Ghost_Rider_Items.SANZO_GHOST_EYECON.get(), 2);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Ghost_Rider_Items.GAN_GUN_CATCHER_ROD.get()));
            }else{
                playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.necrom_grimm"));
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Ghost_Rider_Items.GRIMM_GHOST_EYECON.get(), 2);
            }
    	}
    }

    public void remove(RemovalReason p_149847_) {

        if ( this.isDeadOrDying()) {
            if(!this.level().isClientSide() && this.getItemBySlot(EquipmentSlot.FEET).getItem()==Ghost_Rider_Items.MEGA_ULORDER.get() && RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET),2)==Ghost_Rider_Items.YUJOU_BURST_DAMASHII.get()) {
                ItemEntity key = new ItemEntity(level(), getX(), getY(), getZ(), new ItemStack(Ghost_Rider_Items.YUJOU_BURST_GHOST_EYECON.get(), 1), 0, 0, 0);
                key.setPickUpDelay(0);
                level().addFreshEntity(key);
            }
            }
        super.remove(p_149847_);
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
