package com.kelco.kamenridercraft.entity.mobs.allies;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.NewMoleImaginSandEntity;
import com.kelco.kamenridercraft.entity.mobs.summons.BaseSummonEntity;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.BaseBlasterItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.DenORiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.OOORiderItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;


public class RyutarosEntity extends BaseAllyEntity implements RangedAttackMob {
    private final RangedBowAttackGoal<RyutarosEntity> bowGoal = new RangedBowAttackGoal<>(this, 1.0D, 20, 15.0F);
    private final MeleeAttackGoal meleeGoal = new MeleeAttackGoal(this, 1.2D, false) {
        public void stop() {
            super.stop();
            RyutarosEntity.this.stopBeingAngry();
            RyutarosEntity.this.startPersistentAngerTimer();
            RyutarosEntity.this.setAggressive(false);
        }

        public void start() {
            super.start();
            RyutarosEntity.this.setAggressive(true);
        }
    };

    public RyutarosEntity(EntityType<? extends RyutarosEntity> entityType, Level level) {
        super(entityType, level);
        NAME = "ryutaros";
        this.setPersistenceRequired();
        this.reassessWeaponGoal();
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 40.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
    }


    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new AllyPanicGoal(1.4D));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 5.0F, 2.0F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, BaseAllyEntity.class, BaseSummonEntity.class)).setAlertOthers());
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (livingEntity) -> {
            if (isTame()) {
                if (livingEntity instanceof Creeper || livingEntity instanceof Ghast) {
                    return this.getMainHandItem().getItem() instanceof BowItem;
                }
                return livingEntity instanceof Enemy && !(livingEntity instanceof NeutralMob neutral && !neutral.isAngry());
            } else return false;
        }));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, NewMoleImaginSandEntity.class, false));
        this.targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal<>(this, true));

    }

    public void tame(Player player) {
        super.tame(player);
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(40.0D);
        this.setHealth(40.0F);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(DenORiderItems.RYUVOLVER.get()));
        this.reassessWeaponGoal();
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!this.level().isClientSide || !this.level().isClientSide && this.isBaby() && this.isFood(itemstack)) {
            if (this.isTame()) {
                if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    FoodProperties foodproperties = itemstack.getFoodProperties(this);
                    float f = foodproperties != null ? (float) foodproperties.nutrition() : 1.0F;
                    this.heal(2.0F * f);
                    itemstack.consume(1, player);
                    this.gameEvent(GameEvent.EAT);
                    return InteractionResult.sidedSuccess(this.level().isClientSide());
                } else {
                    if (itemstack.is(DenORiderItems.RIDER_PASS.get())) {
                        player.sendSystemMessage(Component.literal("<" + this.getName().getString() + "> " + Component.translatable("henshin.kamenridercraft.henshin").getString()));
                        player.sendSystemMessage(Component.translatable("henshin.kamenridercraft.den_o_gun_1"));
                        player.sendSystemMessage(Component.literal("<" + this.getName().getString() + "> " + Component.translatable("henshin.kamenridercraft.den_o_gun_2").getString()));
                        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(DenORiderItems.DEN_OHELMET.get()));
                        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(DenORiderItems.DEN_OCHESTPLATE.get()));
                        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(DenORiderItems.DEN_OLEGGINGS.get()));
                        ItemStack rider = new ItemStack(DenORiderItems.DEN_O_BELT.get());
                        RiderDriverItem.setUpdateForm(rider);
                        this.setItemSlot(EquipmentSlot.FEET, rider);
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(DenORiderItems.DEN_GASHER_GUN.get()));
                        RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), DenORiderItems.RIDER_TICKET_GUN.get(), 1);
                        if (!player.getAbilities().instabuild) {
                            itemstack.shrink(1);
                        }
                        return InteractionResult.SUCCESS;
                    }
                    InteractionResult interactionresult = super.mobInteract(player, hand);
                    if (!interactionresult.consumesAction() && this.isOwnedBy(player)) {
                        this.setOrderedToSit(!this.isOrderedToSit());
                        this.jumping = false;
                        this.navigation.stop();
                        this.setTarget(null);
                        return InteractionResult.SUCCESS_NO_ITEM_USED;
                    } else {
                        return interactionresult;
                    }
                }
            } else if (itemstack.is(ModdedItemCore.VIENNA_COFFEE) && !this.isAngry()) {
                itemstack.consume(1, player);
                this.tryToTame(player);
                return InteractionResult.SUCCESS;
            } else {
                return super.mobInteract(player, hand);
            }
        } else {
            boolean flag = this.isOwnedBy(player) || this.isTame() || itemstack.is(ModdedItemCore.VIENNA_COFFEE) && !this.isTame() && !this.isAngry();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        }
    }

    private void tryToTame(Player player) {
        if (this.random.nextInt(3) == 0 && !net.neoforged.neoforge.event.EventHooks.onAnimalTame(this, player)) {
            this.tame(player);
            this.navigation.stop();
            this.setTarget(null);
            this.setOrderedToSit(true);
            this.level().broadcastEntityEvent(this, (byte) 7);
        } else {
            this.level().broadcastEntityEvent(this, (byte) 6);
        }
    }

    public void reassessWeaponGoal() {
        if (!this.level().isClientSide) {
            this.goalSelector.removeGoal(this.meleeGoal);
            this.goalSelector.removeGoal(this.bowGoal);
            ItemStack itemstack = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof net.minecraft.world.item.BowItem));
            if (itemstack.getItem() instanceof BowItem) {
                this.goalSelector.addGoal(3, this.bowGoal);
            } else {
                this.goalSelector.addGoal(3, this.meleeGoal);
            }

        }
    }

    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.reassessWeaponGoal();
    }

    public void setItemSlot(EquipmentSlot equipmentSlot, ItemStack itemStack) {
        super.setItemSlot(equipmentSlot, itemStack);
        if (!this.level().isClientSide) {
            this.reassessWeaponGoal();
        }
    }

    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        ItemStack weapon = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, (item) -> item instanceof BowItem));
        ItemStack itemStack = this.getProjectile(weapon);
        if (weapon.getItem() instanceof BaseBlasterItem blaster && blaster.getProjectile() != BaseBlasterItem.BlasterProjectile.ARROW) {
            blaster.fire(this, this.getLookAngle());
        } else if (weapon.getItem() instanceof BowItem) {
            Arrow arrow = new Arrow(this.level(), this, new ItemStack(Items.ARROW), weapon);
            arrow.pickup = AbstractArrow.Pickup.DISALLOWED;
            arrow.setPos(arrow.getX(), this.getY(0.5) + 0.5, arrow.getZ());
            arrow.addDeltaMovement(this.getLookAngle().scale(3));
            this.level().addFreshEntity(arrow);
            level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level().getRandom().nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);
        }
    }

    public boolean canFireProjectileWeapon(ProjectileWeaponItem projectileWeaponItem) {
        return projectileWeaponItem instanceof BowItem;
    }

    public boolean canMate(Animal animal) {
        return false;
    }

    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/taros")));
    }
}
