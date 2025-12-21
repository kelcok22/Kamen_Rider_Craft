package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import com.kelco.kamenridercraft.level.ModGameRules;
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

public class GenmEntity extends BaseHenchmenEntity {
	


	
    public GenmEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="genm";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Ex_Aid_Rider_Items.EX_AIDHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Ex_Aid_Rider_Items.EX_AIDCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Ex_Aid_Rider_Items.EX_AIDLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ex_Aid_Rider_Items.GAMER_DRIVER_GENM.get()));
        
		ItemStack belt = new ItemStack(Ex_Aid_Rider_Items.GAMER_DRIVER_GENM.get());
		RiderDriverItem.set_Form_Item(belt, Ex_Aid_Rider_Items.PROTO_MIGHTY_ACTION_X_GASHAT.get(), 1);
	
        this.setItemSlot(EquipmentSlot.FEET,belt);
    }

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn) {
            if (this.getHealth()<30 && playerIn.getInventory().countItem(Ex_Aid_Rider_Items.BAKUSOU_BIKE_GASHAT.get().asItem())!=0 && this.getItemBySlot(EquipmentSlot.FEET).getItem()!= Ex_Aid_Rider_Items.GASHACON_BUGVISOR_GENM.get()){
                if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.genm_dangerous_zombie"));
                this.setHealth(45);
                this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ex_Aid_Rider_Items.GASHACON_BUGVISOR_GENM.get()));
                this.level().setRainLevel(10);
            }
        }
    }
    public void remove(RemovalReason p_149847_) {
        if ( this.isDeadOrDying()) {
            if(!this.level().isClientSide() && this.getItemBySlot(EquipmentSlot.FEET).getItem() == Ex_Aid_Rider_Items.GASHACON_BUGVISOR_GENM.get()){
                    ItemEntity gashat = new ItemEntity(level(), getX(), getY(), getZ(), new ItemStack(Ex_Aid_Rider_Items.DANGEROUS_ZOBIE_GASHAT.get(), 1), 0, 0, 0);
                    gashat.setPickUpDelay(0);
                    level().addFreshEntity(gashat);
                }
            }
        super.remove(p_149847_);
    }


    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.23F)
        		.add(Attributes.ATTACK_DAMAGE, 6.0D)
        		.add(Attributes.ARMOR, 0.0D)
        		.add(Attributes.MAX_HEALTH, 45.0D);
     }
    

}