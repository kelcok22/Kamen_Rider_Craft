package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.ai.RangedSwordgunAttackGoal;
import com.kelco.kamenridercraft.entity.mobs.summons.BaseSummonEntity;
import com.kelco.kamenridercraft.item.base_items.BaseBlasterItem;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.damagesource.DamageContainer;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.util.Random;

import static com.kelco.kamenridercraft.world.attribute.KRCAttributes.REINFORCEMENT_CHANCE;
import static net.minecraft.world.entity.EntityType.ZOMBIE;

public abstract class BaseHenchmenEntity extends Monster implements RangedAttackMob {
    public int BOW_COOLDOWN = 40;
    public int HARD_BOW_COOLDOWN = 20;
    public double BOW_DISTANCE = 40.0D;
    private boolean swordgunMeleeOnly = false;

    private final RangedSwordgunAttackGoal<BaseHenchmenEntity> swordgunGoal = new RangedSwordgunAttackGoal<>(this, 1.0D, 20, 15.0F, 40);
    private final RangedBowAttackGoal<BaseHenchmenEntity> bowGoal = new RangedBowAttackGoal<>(this, 1.0D, 20, 15.0F);
    private final MeleeAttackGoal meleeGoal = new MeleeAttackGoal(this, 1.0D, false) {
        public void stop() {
            super.stop();
            setAggressive(false);
        }

        public void start() {
            super.start();
            setAggressive(true);
        }
    };

    public String NAME = "shocker_combatman";


    public BaseHenchmenEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        goalSelector.addGoal(2, swordgunGoal);
        reassessWeaponGoal();
    }

    public void setMeleeOnSpawn(double chance) {
        if (random.nextDouble() * 100.0 <= chance) swordgunMeleeOnly = true;
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(1, new FloatGoal(this));
        goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        addBehaviourGoals();

    }

    protected void addBehaviourGoals() {
        goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
        goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        targetSelector.addGoal(1, (new HurtByTargetGoal(this, getClass(), EnemySummonEntity.class)).setAlertOthers(getClass()));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, BaseSummonEntity.class, true));
    }

    public boolean canBreakDoors() {
        return true;
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
                .add(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE, 35.0D)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED, 0.23F)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE, 4.0D)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR, 3.0D)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH, 45.0D);
    }

    public int getMaxSpawnClusterSize() {
        return 2;
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType,
                                        @Nullable SpawnGroupData spawnGroupData) {
        RandomSource randomsource = level.getRandom();

        float f = difficulty.getSpecialMultiplier();
        setCanPickUpLoot(randomsource.nextFloat() < 0.55F * f);

        spawnGroupData = super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
        if (getOffhandItem().isEmpty()) {
            LocalDate localdate = LocalDate.now();
            if (localdate.getMonthValue() == 6 && localdate.getDayOfMonth() == 22 && randomsource.nextFloat() < 0.25F) {
                setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.APPLE));
                armorDropChances[EquipmentSlot.HEAD.getIndex()] = 0.0F;
            }
        }
        return spawnGroupData;
    }


    public static boolean getSpawnAsBabyOdds(RandomSource p_219163_) {
        return false;
    }

    public boolean isBaby() {
        return false;
    }

    protected boolean isSunSensitive() {
        return false;
    }


    protected SoundEvent getAmbientSound() {
        return SoundEvents.PILLAGER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return SoundEvents.PILLAGER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.PILLAGER_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        playSound(getStepSound(), 0.15F, 1.0F);
    }

    @Override
    public void onDamageTaken(DamageContainer damageContainer) {
        float reinforcementChance = (float) getAttribute(REINFORCEMENT_CHANCE).getValue();
        if (reinforcementChance > 0 && level() instanceof ServerLevel serverLevel && serverLevel.getDifficulty() == Difficulty.HARD
                && serverLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
            if ((getTarget() != null && !(getLastAttacker() instanceof Monster) && getLastAttacker() == getTarget())
                    && random.nextFloat() * 100 <= reinforcementChance) {
                LivingEntity reinforcement = (LivingEntity) getType().create(level());
                Random rand = new Random();

                int tempRandX = (getBlockX()
                        + (rand.nextInt(5, 20))
                        * (rand.nextInt(3) > 1 ? 1 : -1));

                int tempRandZ = (getBlockZ()
                        + (rand.nextInt(5, 20))
                        * (rand.nextInt(3) > 1 ? 1 : -1));

                reinforcement.setPos(tempRandX, getY(), tempRandZ);

                for (int i = 0; i < 400; ++i) {
                    int randX = (getBlockX()
                            + (rand.nextInt(5, 20))
                            * (rand.nextInt(3) > 1 ? 1 : -1));

                    int randY = (getBlockY()
                            + rand.nextInt(-10, 10));

                    int randZ = (getBlockZ()
                            + (rand.nextInt(5, 20))
                            * (rand.nextInt(3) > 1 ? 1 : -1));
                    if (level().noCollision(EntityType.ZOMBIE.getSpawnAABB(randX, randY, randZ))) {
                        reinforcement.setPos(randX, randY, randZ);
                    }
                    BlockPos potentialPosition = new BlockPos(randX, randY, randZ);
                    if (SpawnPlacements.isSpawnPositionOk(ZOMBIE, serverLevel, potentialPosition)) {
                        reinforcement.setPos(randX, randY, randZ);
                        break;
                    }
                }

                reinforcement.getAttribute(REINFORCEMENT_CHANCE).setBaseValue(0);
                getAttribute(REINFORCEMENT_CHANCE).setBaseValue(reinforcementChance - 3);
                if (reinforcement instanceof Monster monster && !getLastAttacker().isInvulnerable()) {
                    monster.setTarget(getLastAttacker());
                }
                level().addFreshEntity(reinforcement);
            }
        }
        super.onDamageTaken(damageContainer);
    }

    public void reassessWeaponGoal() {
        if (!level().isClientSide) {
            swordgunGoal.setMinAttackInterval(level().getDifficulty() == Difficulty.HARD ? HARD_BOW_COOLDOWN : BOW_COOLDOWN);
            bowGoal.setMinAttackInterval(level().getDifficulty() == Difficulty.HARD ? HARD_BOW_COOLDOWN : BOW_COOLDOWN);
            goalSelector.removeGoal(meleeGoal);
            goalSelector.removeGoal(bowGoal);
            ItemStack itemstack = getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof BowItem));
            if (itemstack.getItem() instanceof BowItem && !itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "arsenal/all_swordguns")))) {
                goalSelector.addGoal(3, bowGoal);
            } else {
                goalSelector.addGoal(3, meleeGoal);
            }
        }
    }

    public boolean getMeleeOnly() {
        return swordgunMeleeOnly;
    }

    public void addAdditionalSaveData(CompoundTag p_30418_) {
        super.addAdditionalSaveData(p_30418_);
        p_30418_.putBoolean("SwordgunMeleeOnly", swordgunMeleeOnly);
    }

    public void readAdditionalSaveData(CompoundTag p_32152_) {
        super.readAdditionalSaveData(p_32152_);
        reassessWeaponGoal();
        swordgunMeleeOnly = p_32152_.getBoolean("SwordgunMeleeOnly");
    }

    public void setItemSlot(@NotNull EquipmentSlot equipmentSlot, @NotNull ItemStack itemStack) {
        super.setItemSlot(equipmentSlot, itemStack);
        Level level = level();
        if (!level.isClientSide) reassessWeaponGoal();
    }

    public void performRangedAttack(@NotNull LivingEntity target, float distanceFactor) {
        ItemStack weapon = getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, (item) -> item instanceof BowItem));
        ItemStack itemstack1 = getProjectile(weapon);
        if (weapon.getItem() instanceof BaseBlasterItem blaster && blaster.getProjectile() != BaseBlasterItem.BlasterProjectile.ARROW) {
            blaster.fire(this, getLookAngle());
        } else {
            AbstractArrow abstractarrow = getArrow(itemstack1, distanceFactor, weapon);
            Item var7 = weapon.getItem();
            if (var7 instanceof ProjectileWeaponItem weaponItem) {
                abstractarrow = weaponItem.customArrow(abstractarrow, itemstack1, weapon);
            }

            double d0 = target.getX() - getX();
            double d1 = target.getY(0.3333333333333333) - abstractarrow.getY();
            double d2 = target.getZ() - getZ();
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            abstractarrow.shoot(d0, d1 + d3 * 0.20000000298023224, d2, 1.6F, (float) (14 - level().getDifficulty().getId() * 4));
            level().addFreshEntity(abstractarrow);
        }
        playSound(SoundEvents.BLAZE_SHOOT, 1.0F, 1.0F / (getRandom().nextFloat() * 0.4F + 0.8F));
    }

    protected AbstractArrow getArrow(ItemStack arrow, float velocity, @Nullable ItemStack weapon) {
        return ProjectileUtil.getMobArrow(this, arrow, velocity, weapon);
    }

    public boolean canFireProjectileWeapon(@NotNull ProjectileWeaponItem projectileWeaponItem) {
        return projectileWeaponItem instanceof BowItem;
    }
}