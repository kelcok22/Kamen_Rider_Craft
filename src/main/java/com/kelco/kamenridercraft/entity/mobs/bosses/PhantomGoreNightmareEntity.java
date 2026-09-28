package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.reiwa.ZeztzRiderItems;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class PhantomGoreNightmareEntity extends BaseHenchmenEntity {
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(PhantomGoreNightmareEntity.class, EntityDataSerializers.BYTE);
    private final ServerBossEvent bossEvent = new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS);

    public PhantomGoreNightmareEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "nightmare";
        setItemSlot(EquipmentSlot.HEAD, new ItemStack(ZeztzRiderItems.ZEZTZ_HELMET.get()));
        setItemSlot(EquipmentSlot.CHEST, new ItemStack(ZeztzRiderItems.ZEZTZ_CHESTPLATE.get()));
        setItemSlot(EquipmentSlot.LEGS, new ItemStack(ZeztzRiderItems.ZEZTZ_LEGGINGS.get()));
        setItemSlot(EquipmentSlot.FEET, new ItemStack(ZeztzRiderItems.PHANTOM_GORE_NIGHTMARE_BELT.get()));
    }

    public void remove(@NotNull RemovalReason removalReason) {
        if (isDeadOrDying()) {
            ((ServerLevel) level()).sendParticles(ModParticles.BUTTERFLY_PARTICLES.get(), getX(), getY() + 1,
                    getZ(), 1, 0, 0, 0, 1);
        }
        super.remove(removalReason);
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        bossEvent.setProgress(getHealth() / getMaxHealth());
    }

    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (hasCustomName()) {
            bossEvent.setName(getDisplayName());
        }
    }

    public void setCustomName(@Nullable Component component) {
        super.setCustomName(component);
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

    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 128.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.30F)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.MAX_HEALTH, 100.0D);
    }
}