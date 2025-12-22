package com.kelco.kamenridercraft.entities.bosses;


import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.W_Rider_Items;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;

public class TabooDopantEntity extends BaseHenchmenEntity implements GeoEntity , FlyingAnimal {

    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(TabooDopantEntity .class, EntityDataSerializers.BYTE);

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);


    public TabooDopantEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="taboo_dopant";
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(W_Rider_Items.GAIA_DRIVER_TABOO.get()));
        this.moveControl = new FlyingMoveControl(this, 20, true);
        if (level != null && !level.isClientSide) {
            this.registerGoals();
        }
    }

    @Override
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(3, new TabooEntityAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0F));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0F, 0.0F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 35.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.2F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 4.0D)
        		.add(Attributes.MAX_HEALTH, 110.0D)
                .add(Attributes.FLYING_SPEED, 0.1F);
     }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    // Add our generic idle animation controller
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

        RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.taboo.idle");
        RawAnimation SHOOT = RawAnimation.begin().thenLoop("animation.taboo.shoot");

        controllers.add(new AnimationController<>(this, "Walk/Idle", 0, state -> state.setAndContinue(isCharged() ? SHOOT : IDLE)));
    }


    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    protected void doPush(Entity entity) {
        if (!(entity instanceof Player)) {
            super.doPush(entity);
        }
    }

    @Override
    protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {
    }
    @Override
    protected PathNavigation createNavigation(Level level) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, level);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    public void aiStep() {
        if (!this.onGround() && this.getDeltaMovement().y < (double)0.0F) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0F, 0.6, 1.0F));
        }
        super.aiStep();
    }

    @Override
    public void travel(Vec3 travelVector) {
        if (this.isControlledByLocalInstance()) {
            if (this.isInWater()) {
                this.moveRelative(0.02F, travelVector);
                this.move(MoverType.SELF, this.getDeltaMovement());
                this.setDeltaMovement(this.getDeltaMovement().scale(0.8F));
            } else if (this.isInLava()) {
                this.moveRelative(0.02F, travelVector);
                this.move(MoverType.SELF, this.getDeltaMovement());
                this.setDeltaMovement(this.getDeltaMovement().scale(0.5));
            } else {
                this.moveRelative(this.getSpeed(), travelVector);
                this.move(MoverType.SELF, this.getDeltaMovement());
                this.setDeltaMovement(this.getDeltaMovement().scale(0.91F));
            }
        }

        this.calculateEntityAnimation(false);
    }

    @Override
    public boolean isFlying() {
        return !this.onGround();
    }


    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_FLAGS_ID, (byte)0);
    }
    private boolean isCharged() {
        return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
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


    static class TabooEntityAttackGoal extends MeleeAttackGoal {
        private final TabooDopantEntity CoreEntity;
        private int attackStep;
        private int attackTime;
        private int lastSeen;

        public TabooEntityAttackGoal(TabooDopantEntity p_26019_, double p_26020_, boolean p_26021_) {
            super(p_26019_, p_26020_, p_26021_);
            this.CoreEntity = p_26019_;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity livingentity = this.CoreEntity.getTarget();
            return livingentity != null && livingentity.isAlive() && this.CoreEntity.canAttack(livingentity);
        }

        public void start() {
            this.attackStep = 0;
        }

        public void stop() {
            this.CoreEntity.setCharged(false);
            this.lastSeen = 0;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            --this.attackTime;
            LivingEntity livingentity = this.CoreEntity.getTarget();
            if (livingentity != null) {
                boolean flag = this.CoreEntity.getSensing().hasLineOfSight(livingentity);
                if (flag) {
                    this.lastSeen = 0;
                } else {
                    ++this.lastSeen;
                }

                double d0 = this.CoreEntity.distanceToSqr(livingentity);
                if (d0 < 4.0D) {
                    if (!flag) {
                        return;
                    }

                    if (this.attackTime <= 0) {
                        this.attackTime = 20;
                        this.CoreEntity.doHurtTarget(livingentity);
                    }

                    this.CoreEntity.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0D);
                } else if (d0 < this.getFollowDistance() * this.getFollowDistance() && flag) {
                    double d1 = livingentity.getX() - this.CoreEntity.getX();
                    double d2 = livingentity.getY(0.5D) - this.CoreEntity.getY(0.5D);
                    double d3 = livingentity.getZ() - this.CoreEntity.getZ();
                    if (this.attackTime <= 0) {
                        ++this.attackStep;
                        if (this.attackStep == 1) {
                            this.attackTime = 60;
                            this.CoreEntity.setCharged(true);
                        } else if (this.attackStep <= 4) {
                            this.attackTime = 6;
                        } else {
                            this.attackTime = 100;
                            this.attackStep = 0;
                            this.CoreEntity.setCharged(false);
                        }

                        if (this.attackStep > 1) {
                            double d4 = Math.sqrt(Math.sqrt(d0)) * 0.5D;
                            if (!this.CoreEntity.isSilent()) {
                                this.CoreEntity.level().levelEvent(null, 1018, this.CoreEntity.blockPosition(), 0);
                            }

                            for(int i = 0; i < 1; ++i) {
                                Vec3 vec3 = new Vec3(this.CoreEntity.getRandom().triangle(d1, 2.297 * d4), d2, this.CoreEntity.getRandom().triangle(d3, 2.297 * d4));
                                SmallFireball smallfireball = new SmallFireball(this.CoreEntity.level(), this.CoreEntity, vec3.normalize());
                                smallfireball.setPos(smallfireball.getX(), this.CoreEntity.getY(0.5D) + 0.5D, smallfireball.getZ());
                                this.CoreEntity.level().addFreshEntity(smallfireball);
                            }
                        }
                    }

                    this.CoreEntity.getLookControl().setLookAt(livingentity, 10.0F, 10.0F);
                } else if (this.lastSeen < 5) {
                    this.CoreEntity.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0D);
                }

                super.tick();
            }
        }

        private double getFollowDistance() {
            return this.CoreEntity.getAttributeValue(Attributes.FOLLOW_RANGE);
        }
    }
}

