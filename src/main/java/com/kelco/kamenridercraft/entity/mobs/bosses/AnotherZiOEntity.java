package com.kelco.kamenridercraft.entity.mobs.bosses;


import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ZiORiderItems;
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

public class AnotherZiOEntity extends BaseHenchmenEntity {



    public AnotherZiOEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="another_zi_o";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ZiORiderItems.ZI_O_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ZiORiderItems.ZI_O_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ZiORiderItems.ZI_O_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ZiORiderItems.ANOTHER_ZIKU_DRIVER_ZI_O.get()));
    }


    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getHealth()<100
                && this.getItemBySlot(EquipmentSlot.FEET).getItem()== ZiORiderItems.ANOTHER_ZIKU_DRIVER_ZI_O.get() && RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET),1)== ZiORiderItems.ANOTHER_ZI_O_WATCH.get()) {

            Inventory Inventory = playerIn.getInventory();
            boolean hasWatch = Inventory.countItem(ZiORiderItems.ZI_O_II_RIDEWATCH.get()) != 0;
            Random generator = new Random();
            int rand = generator.nextInt(2);
            if (hasWatch) {
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ZiORiderItems.ANOTHER_ZI_O_II_WATCH.get(), 1);
                if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.another_zi_o_ii"));
                this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
                this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(10.0D);
                this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
                this.heal(40);
            }
        }
    }

    public void remove(RemovalReason p_149847_) {

        if ( this.isDeadOrDying()) {
            if(!this.level().isClientSide() && this.getItemBySlot(EquipmentSlot.FEET).getItem()== ZiORiderItems.ANOTHER_ZIKU_DRIVER_ZI_O.get() && RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET),1)== ZiORiderItems.ANOTHER_ZI_O_II_WATCH.get()) {
                ItemEntity key = new ItemEntity(level(), getX(), getY(), getZ(), new ItemStack(ZiORiderItems.ANOTHER_ZI_O_II_WATCH.get(), 1), 0, 0, 0);
                key.setPickUpDelay(0);
                level().addFreshEntity(key);
            }
        }
        super.remove(p_149847_);
    }


    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 200.0D);
}


}