package com.kelco.kamenridercraft.entity.effect;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Random;
import java.util.UUID;

import static com.kelco.kamenridercraft.attachments.AttachmentTypes.MOB_STATE;
import static com.kelco.kamenridercraft.attachments.AttachmentTypes.UUID_STORE;
import static com.kelco.kamenridercraft.item.heisei_phase_1.BladeRiderItems.*;

public class SealingEntity extends Entity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<Integer> TTL_DATA = SynchedEntityData.defineId(SealingEntity.class, EntityDataSerializers.INT);
    private int TTL = 0;
    ItemEntity obtainedCard;

    public SealingEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void tick() {
        if (level() instanceof ServerLevel serverLevel) {
            if (TTL == 0) {
                Random generator = new Random();
                if (getData(MOB_STATE).equals("normal_undead")) {
                    obtainedCard = new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(NORMAL_UNDEAD_DROPS.get(generator.nextInt(NORMAL_UNDEAD_DROPS.size()))), 0, 0, 0);
                } else if (getData(MOB_STATE).equals("ace_undead")) {
                    obtainedCard = new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(ACE_UNDEAD_DROPS.get(generator.nextInt(ACE_UNDEAD_DROPS.size()))), 0, 0, 0);
                } else if (getData(MOB_STATE).equals("joker")) {
                    obtainedCard = new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(BLACK_JOKER_SEALED.get()), 0, 0, 0);
                } else if (getData(MOB_STATE).equals("albino_joker")) {
                    obtainedCard = new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(ALBINO_JOKER_SEALED.get()), 0, 0, 0);
                }

                if (obtainedCard != null) {
                    obtainedCard.setPickUpDelay(60);
                    obtainedCard.setNoGravity(true);
                    level().addFreshEntity(obtainedCard);
                }
            } else if (TTL == 60) {
                if (serverLevel.getPlayerByUUID(UUID.fromString(getData(UUID_STORE))) instanceof Player thrower && obtainedCard != null) {
                    obtainedCard.absMoveTo(thrower.getX(), thrower.getY(), thrower.getZ());
                }
            } else if (TTL >= 61) {
                discard();
            } else {
                if (obtainedCard != null) {
                    setPos(obtainedCard.getX(), obtainedCard.getY() + 0.35, obtainedCard.getZ());
                }
            }
            setTTl(++TTL);
        }
        super.tick();
    }

    public SealingEntity setTTl(int TTL) {
        this.TTL = TTL;
        entityData.set(SealingEntity.TTL_DATA, TTL);
        return this;
    }

    public int getTTl() {
        return entityData.get(TTL_DATA);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        builder.define(TTL_DATA, 0);
    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        entityData.set(TTL_DATA, compoundTag.getInt("TTL"));
        TTL = getTTl();
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        compoundTag.putInt("TTL", TTL);
    }
}
