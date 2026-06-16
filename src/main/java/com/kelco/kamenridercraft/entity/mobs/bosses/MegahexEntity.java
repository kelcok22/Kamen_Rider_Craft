package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.DriveRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.GaimRiderItems;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
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

import javax.annotation.Nullable;

public class MegahexEntity extends BaseHenchmenEntity {

    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(MegahexEntity.class, EntityDataSerializers.BYTE);
    private final ServerBossEvent bossEvent = new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS);



    public MegahexEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="megahex";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(GaimRiderItems.GAIM_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(GaimRiderItems.GAIM_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(GaimRiderItems.GAIM_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(GaimRiderItems.MEGAHEX.get()));
    }

    protected void customServerAiStep() {
        super.customServerAiStep();

        if(getItemBySlot(EquipmentSlot.FEET).getItem()== GaimRiderItems.MEGAHEX.get()){
            ItemStack belt = getItemBySlot(EquipmentSlot.FEET);
            if (RiderDriverItem.getFormItem(belt,1)== GaimRiderItems.MEGAHEX_KIWAMI.get()&this.bossEvent.getColor()!=BossEvent.BossBarColor.YELLOW) {
                this.bossEvent.setColor(BossEvent.BossBarColor.BLUE);
                this.bossEvent.setName(Component.translatable("entity.kamenridercraft.megahex_kiwami").withStyle(ChatFormatting.GOLD));
            }
            if (RiderDriverItem.getFormItem(belt,1)== DriveRiderItems.MEGAHEX_VIRAL_CORE.get()&this.bossEvent.getColor()!=BossEvent.BossBarColor.YELLOW) {
                this.bossEvent.setColor(BossEvent.BossBarColor.YELLOW);
               this.bossEvent.setName(Component.translatable("entity.kamenridercraft.megahex_zzz").withStyle(ChatFormatting.GOLD));
            }
        }
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }



    public void readAdditionalSaveData(CompoundTag p_31474_) {
        super.readAdditionalSaveData(p_31474_);
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
    }

    public void setCustomName(@Nullable Component p_31476_) {
        super.setCustomName(p_31476_);
        this.bossEvent.setName(this.getDisplayName());
    }

    public void startSeenByPlayer(ServerPlayer p_31483_) {
        super.startSeenByPlayer(p_31483_);
        this.bossEvent.addPlayer(p_31483_);
    }

    public void stopSeenByPlayer(ServerPlayer p_31488_) {
        super.stopSeenByPlayer(p_31488_);
        this.bossEvent.removePlayer(p_31488_);
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_FLAGS_ID, (byte)0);
    }

    void setCharged(boolean p_32241_) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if (p_32241_) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.entityData.set(DATA_FLAGS_ID, b0);
    }


    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getHealth()<80
                && this.getItemBySlot(EquipmentSlot.FEET).getItem()== GaimRiderItems.MEGAHEX.get() && RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET),1)== GaimRiderItems.MEGAHEX_CORE.get()) {
           // if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.megahex_kiwami"));
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(7.0D);
            this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
            RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GaimRiderItems.MEGAHEX_KIWAMI.get(), 1);
        }else if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getHealth()<30
                && this.getItemBySlot(EquipmentSlot.FEET).getItem()== GaimRiderItems.MEGAHEX.get() && RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET),1)== GaimRiderItems.MEGAHEX_KIWAMI.get()) {
            //if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.megahex_zzz"));
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.4);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(7.0D);
            this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
            RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), DriveRiderItems.MEGAHEX_VIRAL_CORE.get(), 1);

            if (playerIn.getItemBySlot(EquipmentSlot.FEET).getItem()== DriveRiderItems.DRIVE_DRIVER.asItem()||playerIn.getItemBySlot(EquipmentSlot.FEET).getItem()== GaimRiderItems.SENGOKU_DRIVER_GAIM.asItem()){
                ItemEntity key = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(DriveRiderItems.SHIFT_FRUITS.get(), 1), 0, 0, 0);
                ItemEntity key2 = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(GaimRiderItems.DRIVE_LOCKSEED.get(), 1), 0, 0, 0);
                key.setPickUpDelay(0);
                playerIn.level().addFreshEntity(key);
                key2.setPickUpDelay(0);
                playerIn.level().addFreshEntity(key2);
                //playerIn.sendSystemMessage(Component.translatable("loot.kamenridercraft.gaim_drive_megahex"));
            }
        }
    }

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.23F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }
}