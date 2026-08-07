package com.kelco.kamenridercraft.entity.mobs.allies;


import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.NewMoleImaginSandEntity;
import com.kelco.kamenridercraft.entity.mobs.summons.BaseSummonEntity;
import com.kelco.kamenridercraft.entity.vehicles.baseBikeEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.ZeroOneRiderItems;
import com.kelco.kamenridercraft.item.reiwa.ZeztzRiderItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;


public class CodeZeroEntity extends BaseAllyEntity  {

    public CodeZeroEntity(EntityType<? extends CodeZeroEntity> entityType, Level level) {
        super(entityType, level);
        NAME="zero";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ZeztzRiderItems.ZEZTZ_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ZeztzRiderItems.ZEZTZ_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ZeztzRiderItems.ZEZTZ_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ZeztzRiderItems.ZEROIDER_CONTROL.get()));
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 60.0D).add(Attributes.ATTACK_DAMAGE, 7.0D);
    }


    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 5.0F, 2.0F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, BaseAllyEntity.class, BaseSummonEntity.class)).setAlertOthers());
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (p_28879_) -> {
            if (isTame()) {
                if (p_28879_ instanceof Creeper || p_28879_ instanceof Ghast) {
                    return this.getMainHandItem().getItem() instanceof BowItem;
                }
                return p_28879_ instanceof Enemy && !(p_28879_ instanceof NeutralMob neutral && !neutral.isAngry());
            } else return false;
        }));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, NewMoleImaginSandEntity.class, false));
        this.targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal<>(this, true));

    }

    public void tame(Player p_21829_) {
        super.tame(p_21829_);
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(40.0D);
        this.setHealth(40.0F);
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if (!level().isClientSide()) {
            if (player.isShiftKeyDown()) {
                if (this.level() instanceof ServerLevel && player == this.getOwner()) {
                    BlockPos pos = this.blockPosition();
                    baseBikeEntity boss = MobsCore.CODE_ZEROIDER.get().create(this.level());
                    if (boss != null) {
                        boss.moveTo(pos.getX(), pos.getY(), pos.getZ(), this.getYRot(), this.getXRot());
                        boss.yRotO = getYRot();
                        boss.xRotO = getXRot();
                        setRot(getYRot(), getXRot());
                        boss.yBodyRot = this.getYRot();
                        boss.yHeadRot = this.yBodyRot;
                        if (boss.level() instanceof ServerLevel sl) {
                            sl.sendParticles(ParticleTypes.GUST,
                                    boss.getX(), boss.getY() + 1.0,
                                    boss.getZ(), 1, 0, 0, 0, 1);
                        }
                        this.level().addFreshEntity(boss);
                        this.remove(RemovalReason.DISCARDED);
                    }
                }
            }

        }
        return InteractionResult.PASS;
    }


    private void tryToTame(Player player) {
        this.tame(player);
        this.navigation.stop();
        this.setTarget(null);
        this.setOrderedToSit(true);
        this.level().broadcastEntityEvent(this, (byte) 7);
    }

    public boolean canMate(Animal p_30392_) {
        return false;
    }


}
