package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.entities.footSoldiers.EnemySummonEntity;
import com.kelco.kamenridercraft.entities.footSoldiers.RideplayerEntity;
import com.kelco.kamenridercraft.entities.summons.BaseSummonEntity;
import com.kelco.kamenridercraft.item.Decade_Rider_Items;
import com.kelco.kamenridercraft.item.Ryuki_Rider_Items;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import com.kelco.kamenridercraft.item.decade.ZeinCard;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Random;

public class ZeinEntity extends BaseHenchmenEntity {
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(ZeinEntity.class, EntityDataSerializers.BYTE);
    private final ServerBossEvent bossEvent = new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS);

    public ZeinEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="zein";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zero_One_Rider_Items.ZEIN_DRIVER.get()));
        this.setDropChance(EquipmentSlot.MAINHAND, 0.0f);
        this.setDropChance(EquipmentSlot.OFFHAND, 0.0f);
        this.xpReward = 50;
    }
    protected void customServerAiStep() {
        super.customServerAiStep();
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

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(3, new ZeinEntity.ZeinEntityAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.0F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, EnemySummonEntity.class)).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, GenmEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, RideplayerEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ParaDxEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PoppyRedEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, GordDriveEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, DesastEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, HorobiEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ArkZeroEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, GlareEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, MirrorRiderEntity.class, 5, false, false,
                (p_28879_) -> p_28879_.getItemBySlot(EquipmentSlot.FEET).getItem() == Ryuki_Rider_Items.OUJADRIVER.get()));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, BaseSummonEntity.class, true));
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 200.0D);
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_FLAGS_ID, (byte)0);
    }

    void setCharged(boolean p_32241_) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if (p_32241_) {
            b0 = (byte)(b0 | 1);

            LivingEntity livingentity = this.getTarget();
            if (livingentity != null) {
                this.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
                Random rand = new Random();
                switch (rand.nextInt(16)) {
                    case 0 -> {
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.RYUKI_SURVIVE_CARD.get()));
                        if (livingentity instanceof Player player)
                            player.displayClientMessage(Component.translatable("attack.kamenridercraft.zein_ryuki"), true);
                    }
                    case 1 -> {
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.FAIZ_BLASTER_CARD.get()));
                        if (livingentity instanceof Player player)
                            player.displayClientMessage(Component.translatable("attack.kamenridercraft.zein_faiz"), true);
                    }
                    case 2 -> {
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.BLADE_KING_CARD.get()));
                        if (livingentity instanceof Player player)
                            player.displayClientMessage(Component.translatable("attack.kamenridercraft.zein_blade"), true);
                    }
                    case 3 -> {
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.KABUTO_HYPER_CARD.get()));
                        if (livingentity instanceof Player player)
                            player.displayClientMessage(Component.translatable("attack.kamenridercraft.zein_kabuto"), true);
                    }
                    case 4 -> {
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.KIVA_EMPEROR_CARD.get()));
                        if (livingentity instanceof Player player)
                            player.displayClientMessage(Component.translatable("attack.kamenridercraft.zein_kiva"), true);
                    }
                    case 5 -> {
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.OOO_PUTOTYRA_CARD.get()));
                        if (livingentity instanceof Player player)
                            player.displayClientMessage(Component.translatable("attack.kamenridercraft.zein_ooo"), true);
                    }
                    case 6 -> {
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.FOURZE_COSMIC_CARD.get()));
                        if (livingentity instanceof Player player)
                            player.displayClientMessage(Component.translatable("attack.kamenridercraft.zein_fourze"), true);
                    }
                    case 7 -> {
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.WIZARD_INFINITY_CARD.get()));
                        if (livingentity instanceof Player player)
                            player.displayClientMessage(Component.translatable("attack.kamenridercraft.zein_wizard"), true);
                    }
                    case 8 -> {
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.EX_AID_MUTEKI_CARD.get()));
                        if (livingentity instanceof Player player)
                            player.displayClientMessage(Component.translatable("attack.kamenridercraft.zein_ex_aid"), true);
                    }
                    case 9 -> {
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.GRAND_ZI_O_CARD.get()));
                        if (livingentity instanceof Player player)
                            player.displayClientMessage(Component.translatable("attack.kamenridercraft.zein_zi_o"), true);
                    }
                    case 10 -> {
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.ZERO_TWO_CARD.get()));
                        if (livingentity instanceof Player player)
                            player.displayClientMessage(Component.translatable("attack.kamenridercraft.zein_zero_one"), true);
                    }
                    case 11 -> {
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.XROSS_SABER_CARD.get()));
                        if (livingentity instanceof Player player)
                            player.displayClientMessage(Component.translatable("attack.kamenridercraft.zein_saber"), true);
                    }
                    case 12 -> {
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.ULTIMATE_REVI_CARD.get()));
                        if (livingentity instanceof Player player)
                            player.displayClientMessage(Component.translatable("attack.kamenridercraft.zein_revi"), true);
                    }
                    case 13 -> {
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.ULTIMATE_VICE_CARD.get()));
                        if (livingentity instanceof Player player)
                            player.displayClientMessage(Component.translatable("attack.kamenridercraft.zein_vice"), true);
                    }
                    case 14 -> {
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.GEATS_IX_CARD.get()));
                        if (livingentity instanceof Player player)
                            player.displayClientMessage(Component.translatable("attack.kamenridercraft.zein_geats"), true);
                    }
                    default -> {
                        if (this.getHealth()>this.getMaxHealth()/2) {
                            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.SUPER_1_CARD.get()));
                            if (livingentity instanceof Player player)
                                player.displayClientMessage(Component.translatable("attack.kamenridercraft.zein_super_1"), true);
                        } else {
                            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.DIMENSION_CARD.get()));
                            if (livingentity instanceof Player player)
                                player.displayClientMessage(Component.translatable("attack.kamenridercraft.zein_dimension"), true);
                        }
                    }
                }
                this.removeAllEffects();
            }
        } else {
            if (this.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof ZeinCard) this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
            b0 = (byte)(b0 & -2);
        }

        this.entityData.set(DATA_FLAGS_ID, b0);
    }


    static class ZeinEntityAttackGoal extends MeleeAttackGoal {
        private final ZeinEntity ZeinEntity;
        private int attackTime;

        public ZeinEntityAttackGoal(ZeinEntity p_26019_, double p_26020_, boolean p_26021_) {
            super(p_26019_, p_26020_, p_26021_);
            this.ZeinEntity = p_26019_;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity livingentity = this.ZeinEntity.getTarget();
            return livingentity != null && livingentity.isAlive() && this.ZeinEntity.canAttack(livingentity);
        }

        public boolean canContinueToUse() {
            LivingEntity livingentity = this.mob.getTarget();
            if (livingentity == null) {
                return false;
            } else if (!livingentity.isAlive()) {
                return false;
            } else {
                return this.mob.getSensing().hasLineOfSight(livingentity) && (!(livingentity instanceof Player) || !livingentity.isSpectator() && !((Player) livingentity).isCreative());
            }
        }

        public void stop() { this.ZeinEntity.setCharged(false); }

        public boolean requiresUpdateEveryTick() { return true; }

        public void tick() {
            --this.attackTime;
            LivingEntity livingentity = this.ZeinEntity.getTarget();

            if (livingentity != null) {
                if (this.attackTime <= 0) {
                    if (this.ZeinEntity.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof ZeinCard zein) {
                        zein.activateCard(this.ZeinEntity.level(), this.ZeinEntity, this.ZeinEntity.getItemBySlot(EquipmentSlot.MAINHAND));
                        if (livingentity instanceof Player player) player.displayClientMessage(Component.translatable("attack.kamenridercraft.justice_order"), true);
                        this.attackTime = 200;
                        this.ZeinEntity.setCharged(false);
                    } else {
                        this.attackTime = 60;
                        this.ZeinEntity.setCharged(true);
                    }
                }
                super.tick();
            }
        }
    }
}