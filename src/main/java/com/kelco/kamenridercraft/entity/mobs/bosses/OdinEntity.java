package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.entity.mobs.summons.BaseSummonEntity;
import com.kelco.kamenridercraft.item.heisei_phase_1.RyukiRiderItems;
import com.kelco.kamenridercraft.item.misc_items.MusicDiscItems;
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
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class OdinEntity extends BaseHenchmenEntity {
    private final ServerBossEvent bossEvent = new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.YELLOW, BossEvent.BossBarOverlay.PROGRESS);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(OdinEntity.class, EntityDataSerializers.BYTE);

    public OdinEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "rider_summon";
        setItemSlot(EquipmentSlot.HEAD, new ItemStack(RyukiRiderItems.RYUKIHELMET.get()));
        setItemSlot(EquipmentSlot.CHEST, new ItemStack(RyukiRiderItems.RYUKICHESTPLATE.get()));
        setItemSlot(EquipmentSlot.LEGS, new ItemStack(RyukiRiderItems.RYUKILEGGINGS.get()));
        setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.ODINDRIVER.get()));
        setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.GOLD_VISOR.get()));
    }

    protected void addBehaviourGoals() {
        goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
        goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        targetSelector.addGoal(1, (new HurtByTargetGoal(this, this.getClass())).setAlertOthers(this.getClass()));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MirrorRiderEntity.class, false));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, BaseSummonEntity.class, true));
    }

    public void actuallyHurt(@NotNull DamageSource damageSource, float amount) {
        super.actuallyHurt(damageSource, amount);
        int rand2 = this.random.nextInt(10);
        if (rand2 == 2) {
            if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.ODINDRIVER.get()) {
                int rand = this.random.nextInt(3);
                switch (rand) {
                    case 1:
                        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.GOLD_SABER.get()));
                        setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.GOLD_SABER.get()));
                        break;
                    case 2:
                        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.GOLD_SHIELD.get()));
                        this.getItemBySlot(EquipmentSlot.OFFHAND).consume(1, this);
                        break;
                    default:
                        setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.GOLD_VISOR.get()));
                        break;
                }
            }
        }
    }

    public void remove(RemovalReason removalReason) {
        if (this.isDeadOrDying()) {
            if (!level().isClientSide() && getLastAttacker() instanceof Player
                    && getLastAttacker().getItemBySlot(EquipmentSlot.FEET).is(RyukiRiderItems.ODINDRIVER.get())) {
                ItemEntity musicDisc = new ItemEntity(level(), getX(), getY(), getZ(),
                        new ItemStack(MusicDiscItems.ALIVE_A_LIFE_MUSIC_DISC.get(), 1), 0, 0, 0);
                musicDisc.setPickUpDelay(0);
                level().addFreshEntity(musicDisc);
            }
        }
        super.remove(removalReason);
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_FLAGS_ID, (byte) 0);
    }

    public void readAdditionalSaveData(CompoundTag p_31474_) {
        super.readAdditionalSaveData(p_31474_);
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


    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.23F)
                .add(Attributes.ATTACK_DAMAGE, 12.0D)
                .add(Attributes.ARMOR, 4.0D)
                .add(Attributes.MAX_HEALTH, 60.0D);
    }
}