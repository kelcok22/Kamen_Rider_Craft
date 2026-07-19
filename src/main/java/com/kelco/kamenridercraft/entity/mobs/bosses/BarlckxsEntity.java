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
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BarlckxsEntity extends BaseHenchmenEntity {
    public BarlckxsEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="barlckxs";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ZiORiderItems.ZI_O_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ZiORiderItems.ZI_O_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ZiORiderItems.ZI_O_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ZiORiderItems.ZIKU_DRIVER_BARLCKXS.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ZiORiderItems.BARLCKXS_SWORD.get()));
        RiderDriverItem.setUpdateForm(this.getItemBySlot(EquipmentSlot.FEET));
    }

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if (!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getHealth() < 30 && playerIn.getInventory().countItem(ZiORiderItems.GRAND_ZI_O_RIDEWATCH.get()) >= 1) {
            if (playerIn.getInventory().countItem(ZiORiderItems.GRAND_ZI_O_RIDEWATCH.get()) != 0) {
                if (playerIn.getInventory().countItem(ZiORiderItems.GRAND_ZI_O_RIDEWATCH.get()) != 0 && RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET), 1) != ZiORiderItems.BIO_RIDER_RIDEWATCH.get()) {
                    if (playerIn.getInventory().getItem(40).getItem() == ZiORiderItems.GRAND_ZI_O_RIDEWATCH.get())
                        playerIn.getInventory().removeItem(40, 1);
                    else
                        playerIn.getInventory().removeItem(playerIn.getInventory().findSlotMatchingItem(new ItemStack(ZiORiderItems.GRAND_ZI_O_RIDEWATCH.get())), 1);
                    ItemEntity key = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(ZiORiderItems.OHMA_ZI_O_RIDEWATCH.get(), 1), 0, 0, 0);
                    key.setPickUpDelay(0);
                    playerIn.level().addFreshEntity(key);
                    playerIn.sendSystemMessage(Component.translatable("loot.kamenridercraft.ohma_zi_o_ridewatch"));
                    if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS))
                        playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.barlckxs_bio_rider"));
                    this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(12.0D);
                    this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
                    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ZiORiderItems.BIO_RIDER_RIDEWATCH.get(), 1);
                    this.moveControl = new MoveControl(this);
                    this.setNoGravity(false);
                }
            }
        }
    }
        public static AttributeSupplier.Builder setAttributes() {

            return Monster.createMonsterAttributes()
                    .add(Attributes.FOLLOW_RANGE, 135.0D)
                    .add(Attributes.MOVEMENT_SPEED, 0.23F)
                    .add(Attributes.ATTACK_DAMAGE, 10.0D)
                    .add(Attributes.ARMOR, 3.0D)
                    .add(Attributes.MAX_HEALTH, 60.0D);
    }
}