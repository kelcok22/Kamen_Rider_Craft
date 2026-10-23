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
                obtainedCard = switch (getData(MOB_STATE)) {
                    case "normal_undead" -> new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(NORMAL_UNDEAD_DROPS.get(generator.nextInt(NORMAL_UNDEAD_DROPS.size()))), 0, 0, 0);
                    case "beetle" -> new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(CHANGE_BEETLE.get()), 0, 0, 0);
                    case "stag" -> new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(CHANGE_STAG.get()), 0, 0, 0);
                    case "mantis" -> new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(CHANGE_MANTIS.get()), 0, 0, 0);
                    case "spider" -> new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(CHANGE_SPIDER.get()), 0, 0, 0);
                    case "proper_seal_spider" -> new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(CHANGE_SPIDER_PROPER_SEAL.get()), 0, 0, 0);
                    case "eagle" -> new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(FUSION_EAGLE.get()), 0, 0, 0);
                    case "peacock" -> new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(FUSION_PEACOCK.get()), 0, 0, 0);
                    case "wolf" -> new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(FUSION_WOLF.get()), 0, 0, 0);
                    case "elephant" -> new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(FUSION_ELEPHANT.get()), 0, 0, 0);
                    case "serpent", "capricorn", "orchid", "tiger" ->
                            new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                                    new ItemStack(QUEEN_UNDEAD_DROPS.get(generator.nextInt(QUEEN_UNDEAD_DROPS.size()))), 0, 0, 0);
                    case "caucasus" -> new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(EVOLUTION_CAUCASUS.get()), 0, 0, 0);
                    case "giraffa" -> new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(EVOLUTION_GIRAFFA.get()), 0, 0, 0);
                    case "paradoxa" -> new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(EVOLUTION_PARADOXA.get()), 0, 0, 0);
                    case "tarantula" -> new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(EVOLUTION_TARANTULA.get()), 0, 0, 0);
                    case "joker" -> new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(SEALABLE_BLACK_JOKER.get()), 0, 0, 0);
                    case "albino_joker" -> new ItemEntity(level(), getX(), getY() - 0.35, getZ(),
                            new ItemStack(SEALABLE_ALBINO_JOKER.get()), 0, 0, 0);
                    default -> throw new IllegalStateException("Unexpected value: " + getData(MOB_STATE));
                };

                obtainedCard.setPickUpDelay(60);
                obtainedCard.setNoGravity(true);
                level().addFreshEntity(obtainedCard);
            } else if (TTL == 60) {
                try {
                    if (!getData(UUID_STORE).isEmpty()
                            && serverLevel.getPlayerByUUID(UUID.fromString(getData(UUID_STORE))) instanceof Player thrower
                            && obtainedCard != null) {
                        obtainedCard.absMoveTo(thrower.getX(), thrower.getY(), thrower.getZ());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
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
