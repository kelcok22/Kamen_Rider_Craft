package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.ZeztzRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ZeztzDarknessNightmareEntity extends BaseHenchmenEntity {
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(ZeztzDarknessNightmareEntity.class,
            EntityDataSerializers.BYTE);
    private final ServerBossEvent bossEvent = new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.WHITE,
            BossEvent.BossBarOverlay.PROGRESS);

    public ZeztzDarknessNightmareEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "nightmare";
        setItemSlot(EquipmentSlot.HEAD, new ItemStack(ZeztzRiderItems.ZEZTZ_HELMET.get()));
        setItemSlot(EquipmentSlot.CHEST, new ItemStack(ZeztzRiderItems.ZEZTZ_CHESTPLATE.get()));
        setItemSlot(EquipmentSlot.LEGS, new ItemStack(ZeztzRiderItems.ZEZTZ_LEGGINGS.get()));
        setItemSlot(EquipmentSlot.FEET, new ItemStack(ZeztzRiderItems.ZEZTZ_DARKNESS_BELT.get()));
        RiderDriverItem.setUpdateForm(getItemBySlot(EquipmentSlot.FEET));
    }

    public void remove(@NotNull RemovalReason removalReason) {
        if (isDeadOrDying() && level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ModParticles.BUTTERFLY_PARTICLES.get(), getX(), getY() + 1, getZ(),
                    1, 0, 0, 0, 1);
        }
        super.remove(removalReason);
    }

    @Override
    public void actuallyHurt(@NotNull DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if (!level().isClientSide() && source.getEntity() instanceof ServerPlayer serverPlayer && getHealth() < 30) {
            if (RiderDriverItem.getFormItem(getItemBySlot(EquipmentSlot.FEET), 1) != ZeztzRiderItems.DARKNESS_CAPSEM_DRIVER.get()) {
                if (level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) {
                    serverPlayer.sendSystemMessage(Component.translatable("henshin.kamenridercraft.zeztz_darkness_nightmare_driver"));
                }
            }
            RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), ZeztzRiderItems.DARKNESS_CAPSEM_DRIVER.get(), 1);
            RiderDriverItem.setUpdateForm(getItemBySlot(EquipmentSlot.FEET));
        }
    }


    protected void customServerAiStep() {
        super.customServerAiStep();
        bossEvent.setProgress(getHealth() / getMaxHealth());
    }

    public void readAdditionalSaveData(CompoundTag p_31474_) {
        super.readAdditionalSaveData(p_31474_);
        if (hasCustomName()) {
            bossEvent.setName(getDisplayName());
        }
    }

    public void setCustomName(@Nullable Component p_31476_) {
        super.setCustomName(p_31476_);
        bossEvent.setName(getDisplayName());
    }

    public void startSeenByPlayer(@NotNull ServerPlayer serverPlayer) {
        super.startSeenByPlayer(serverPlayer);
        bossEvent.addPlayer(serverPlayer);
    }

    public void stopSeenByPlayer(@NotNull ServerPlayer serverPlayer) {
        super.stopSeenByPlayer(serverPlayer);
        bossEvent.removePlayer(serverPlayer);
    }


    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_FLAGS_ID, (byte) 0);
    }

    void setCharged(boolean p_32241_) {
        byte b0 = entityData.get(DATA_FLAGS_ID);
        if (p_32241_) {
            b0 = (byte) (b0 | 1);
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