package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Drive_Rider_Items;
import com.kelco.kamenridercraft.item.Gaim_Rider_Items;
import com.kelco.kamenridercraft.item.Saber_Rider_Items;
import com.kelco.kamenridercraft.item.drive.DriveDriverItem;
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

public class MegahexEntity extends BaseHenchmenEntity {

    public MegahexEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="megahex";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Gaim_Rider_Items.GAIM_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Gaim_Rider_Items.GAIM_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Gaim_Rider_Items.GAIM_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Gaim_Rider_Items.MEGAHEX.get()));
    }

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getHealth()<80
                && this.getItemBySlot(EquipmentSlot.FEET).getItem()== Gaim_Rider_Items.MEGAHEX.get() && RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET),1)==Gaim_Rider_Items.MEGAHEX_CORE.get()) {
            if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.megahex_kiwami"));
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(7.0D);
            this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
            RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Gaim_Rider_Items.MEGAHEX_KIWAMI.get(), 1);
        }else if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getHealth()<30
                && this.getItemBySlot(EquipmentSlot.FEET).getItem()== Gaim_Rider_Items.MEGAHEX.get() && RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET),1)==Gaim_Rider_Items.MEGAHEX_KIWAMI.get()) {
            if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.megahex_kiwami"));
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.4);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(7.0D);
            this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
            RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Drive_Rider_Items.MEGAHEX_VIRAL_CORE.get(), 1);

            if (playerIn.getItemBySlot(EquipmentSlot.FEET).getItem()==Drive_Rider_Items.DRIVE_DRIVER.asItem()||playerIn.getItemBySlot(EquipmentSlot.FEET).getItem()==Gaim_Rider_Items.SENGOKU_DRIVER_GAIM.asItem()){
                ItemEntity key = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(Drive_Rider_Items.SHIFT_FRUITS.get(), 1), 0, 0, 0);
                ItemEntity key2 = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(Gaim_Rider_Items.DRIVE_LOCKSEED.get(), 1), 0, 0, 0);
                key.setPickUpDelay(0);
                playerIn.level().addFreshEntity(key);
                key2.setPickUpDelay(0);
                playerIn.level().addFreshEntity(key2);
                if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("loot.kamenridercraft.gaim_drive_megahex"));
            }
        }
    }

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.23F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }
}