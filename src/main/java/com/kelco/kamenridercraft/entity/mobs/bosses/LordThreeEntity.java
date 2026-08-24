package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ZiORiderItems;
import com.kelco.kamenridercraft.item.reiwa.ZeztzRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
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
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class LordThreeEntity extends BaseHenchmenEntity {
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(LordThreeEntity.class, EntityDataSerializers.BYTE);
    private final ServerBossEvent bossEvent = new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.YELLOW, BossEvent.BossBarOverlay.PROGRESS);
		public LordThreeEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="nox_knight";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ZeztzRiderItems.ZEZTZ_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ZeztzRiderItems.ZEZTZ_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ZeztzRiderItems.ZEZTZ_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ZeztzRiderItems.LORD_INVOKER_THREE.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ZeztzRiderItems.BREAKAM_BREAKER_BLADE.get()));
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


    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if (!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getHealth() < 30 && playerIn.getInventory().countItem(ZeztzRiderItems.MIDNIGHT_SHADOW_CAPSEM.get()) >= 1) {
            if (playerIn.getInventory().countItem(ZeztzRiderItems.MIDNIGHT_SHADOW_CAPSEM.get()) != 0) {
                if (playerIn.getInventory().countItem(ZeztzRiderItems.MIDNIGHT_SHADOW_CAPSEM.get()) != 0 && RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET), 1) != ZeztzRiderItems.LORD_BOOSTER_CAPSEM.get()) {
                    if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS))
                        playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.lord_three_booster"));
                                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ZeztzRiderItems.LORD_BOOSTER_CAPSEM.get(), 1);
                }
            }
        }
    }
    protected void customServerAiStep() {

        super.customServerAiStep();
        if(getItemBySlot(EquipmentSlot.FEET).getItem()== ZeztzRiderItems.LORD_INVOKER_THREE.get()){
            ItemStack belt = getItemBySlot(EquipmentSlot.FEET);
            if (RiderDriverItem.getFormItem(belt,1)!= ZeztzRiderItems.LORD_BOOSTER_CAPSEM.get()&this.bossEvent.getColor()!= BossEvent.BossBarColor.PURPLE) {
                this.bossEvent.setColor(BossEvent.BossBarColor.PURPLE);
                this.bossEvent.setName(Component.translatable("entity.kamenridercraft.lord_three").withStyle(ChatFormatting.DARK_PURPLE));
            }
        }
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());}

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_FLAGS_ID, (byte)0);
    }

    public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 2.0D)
        		.add(Attributes.MAX_HEALTH, 60.0D);
     }
    

}