package com.kelco.kamenridercraft.item.base_items;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.projectiles.BaseProjectileEntity;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.entity.projectile.windcharge.WindCharge;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class NeoBaseBlasterItem extends BaseItem {
    private boolean singleFire;
    private float projDamage;
    private int explosionPower = 0;
    private int accuracyMod = 0;
    private int maxAmmo;
    CompoundTag tag = new CompoundTag();
    private int firingRate;
    private int reloadTime;

    private int drawTime = 0;
    private int meterCost = 0;
    private boolean requireFullDraw = false;

    private String projectile = "arrow";
    private String[] effects;
    private String model = "";
    private String texture = "";
    private String chargingEffect = "";
    private String firingParticle = "";
    private String useAnimation = "vanilla";
    private String holdAnimation = "";

    private int tickCount = 0;
    private int drawTick = 0;
    private boolean gunMode = true;

    private Item RepairItem = ModdedItemCore.RIDER_CIRCUIT.get();
    private Item FormChangeItem = null;
    private Item HenshinBeltItem = null;

    public NeoBaseBlasterItem(Properties prop, float Atk, float Spd, boolean isSingleFire, Float projectileDamage, int fireRate, int totalAmmo, int reloadLength, int actionCost) {
        super(prop.durability(1000).attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));
        this.singleFire = isSingleFire;
        this.projDamage = projectileDamage;
        this.firingRate = fireRate;
        this.maxAmmo = totalAmmo;
        tag.putInt("ammo", totalAmmo);
        this.reloadTime = reloadLength;
        this.meterCost = actionCost;
        if (!singleFire) {
            this.accuracyMod = 2;
        }
    }

    public void fire(LivingEntity user, Vec3 vec3) {
        if (user.level() instanceof ServerLevel serverLevel) {
            switch (firingParticle) {
                case "smoke":
                    serverLevel.sendParticles(ParticleTypes.WHITE_SMOKE, user.getX() + user.getLookAngle().x * 0.5, user.getEyeY(), user.getZ() + user.getLookAngle().z * 0.5, 10, 0, 0, 0, 0.05);
            }
            switch (projectile) {
                case "arrow", "spectral_arrow":
                    ItemStack arrow;
                    if (projectile.contains("spectral_arrow")) {
                        arrow = new ItemStack(Items.SPECTRAL_ARROW, 1);
                        SpectralArrow arrowEntity = new SpectralArrow(user.level(), user, arrow, this.getDefaultInstance());
                        arrowEntity.pickup = AbstractArrow.Pickup.DISALLOWED;
                        arrowEntity.setPos(arrowEntity.getX(), user.getY(0.6) + 0.5, arrowEntity.getZ());
                        arrowEntity.setBaseDamage(projDamage / 2);

                        if (drawTime != 0) {
                            arrowEntity.addDeltaMovement(user.getLookAngle().scale(((double) 3 / this.drawTime) * this.drawTick));
                        } else {
                            arrowEntity.addDeltaMovement(user.getLookAngle().scale(3));
                        }
                        if (user.hasEffect(EffectCore.SHOT_BOOST)) {
                            arrowEntity.addDeltaMovement(user.getLookAngle().scale(1));
                        }
                        user.level().addFreshEntity(arrowEntity);
                    } else {
                        arrow = new ItemStack(Items.ARROW, 1);
                        Arrow arrowEntity = new Arrow(user.level(), user, arrow, this.getDefaultInstance());
                        arrowEntity.pickup = AbstractArrow.Pickup.DISALLOWED;
                        arrowEntity.setPos(arrowEntity.getX(), user.getY(0.6) + 0.5, arrowEntity.getZ());
                        arrowEntity.setBaseDamage(projDamage / 2);

                        if (drawTime != 0) {
                            arrowEntity.addDeltaMovement(user.getLookAngle().scale(((double) 3 / this.drawTime) * this.drawTick));
                        } else {
                            arrowEntity.addDeltaMovement(user.getLookAngle().scale(3));
                        }
                        if (user.hasEffect(EffectCore.SHOT_BOOST)) {
                            arrowEntity.addDeltaMovement(user.getLookAngle().scale(1));
                        }
                        user.level().addFreshEntity(arrowEntity);
                    }
                    break;

                case "small_fireball":
                    SmallFireball smallfireball = new SmallFireball(user.level(), user, vec3.normalize());
                    smallfireball.setPos(smallfireball.getX(), user.getY(0.5) + 0.5, smallfireball.getZ());
                    user.level().addFreshEntity(smallfireball);
                    break;

                case "large_fireball":
                    LargeFireball largefireball = new LargeFireball(user.level(), user, vec3.normalize(), this.explosionPower);
                    largefireball.setPos(largefireball.getX(), user.getY(0.5) + 0.5, largefireball.getZ());
                    user.level().addFreshEntity(largefireball);
                    break;

                case "dragon_fireball":
                    DragonFireball dragonfireball = new DragonFireball(user.level(), user, vec3.normalize());
                    dragonfireball.setPos(dragonfireball.getX(), user.getY(0.5D) + 0.5D, dragonfireball.getZ());
                    user.level().addFreshEntity(dragonfireball);
                    break;

                case "egg":
                    ThrownEgg egg = new ThrownEgg(user.level(), user);
                    egg.setPos(egg.getX(), user.getY(0.5D) + 0.5D, egg.getZ());
                    egg.addDeltaMovement(vec3.scale(3));
                    user.level().addFreshEntity(egg);
                    break;

                case "ender_pearl":
                    ThrownEnderpearl pearl = new ThrownEnderpearl(user.level(), user);
                    pearl.setPos(pearl.getX(), user.getY(0.5D) + 0.5D, pearl.getZ());
                    pearl.addDeltaMovement(vec3.scale(3));
                    user.level().addFreshEntity(pearl);
                    break;

                case "rocket", "cell_medal", "laser", "effect_ball", "laser_beam":
                    BaseProjectileEntity baseProjectile = new BaseProjectileEntity(user.level(), user, projectile, model, texture, projDamage, explosionPower, effects);
                    baseProjectile.shootFromRotation(user, user.getXRot(), user.getYRot(), 0.0F, 2f, 1F + this.accuracyMod);
                    user.level().addFreshEntity(baseProjectile);
                    break;

                case "wind_charge":
                    WindCharge windcharge = new WindCharge(user.level(), user.getX(), user.getY(0.5D) + 0.5D, user.getZ(), user.getLookAngle());
                    user.level().addFreshEntity(windcharge);
                    break;

                case "wither_skull":
                    WitherSkull witherSkull = new WitherSkull(user.level(), user, vec3.normalize());
                    witherSkull.setPos(witherSkull.getX(), user.getY(0.5D) + 0.5D, witherSkull.getZ());
                    user.level().addFreshEntity(witherSkull);
                    break;

                case "firework":
                    ItemStack rocket = new ItemStack(Items.FIREWORK_ROCKET);
                    FireworkRocketEntity firework = new FireworkRocketEntity(user.level(), rocket, user);
                    firework.setPos(firework.getX(), user.getY(0.5D) + 0.5D, firework.getZ());
                    user.level().addFreshEntity(firework);
                    break;
            }
            serverLevel.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (user.level().getRandom().nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);
            if (user instanceof Player player) {
                ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
                player.awardStat(Stats.ITEM_USED.get(this));
                this.tickCount = 0;
                tag.putInt("ammo", tag.getInt("ammo") - 1);
                this.tickCount = 0;
            }
        }
    }


    public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeLeft) {
        if (livingEntity instanceof Player player && level instanceof ServerLevel serverlevel) {
            if (requireFullDraw && this.drawTick < this.drawTime) {
                this.drawTick = 0;
                return;
            }
            if (!requireFullDraw && tag.getInt("ammo") > 0 || this.drawTick >= this.drawTime && tag.getInt("ammo") > 0) {
                if (HenshinBeltItem != null && player.getItemBySlot(EquipmentSlot.FEET) == ItemStack.EMPTY) {
                    player.setItemSlot(EquipmentSlot.FEET, new ItemStack(HenshinBeltItem));
                    if (player.getOffhandItem().getItem() instanceof RiderFormChangeItem formItem)
                        formItem.use(level, player, InteractionHand.OFF_HAND);
                }
                if (FormChangeItem != null && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem) {
                    FormChangeItem.use(level, player, InteractionHand.MAIN_HAND);
                }

                fire(livingEntity, livingEntity.getDeltaMovement());
                if (tag.getInt("ammo") == 0) {
                    player.getCooldowns().addCooldown(this, this.reloadTime);
                    if (!this.singleFire) {
                        serverlevel.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), SoundEvents.CHAIN_BREAK, SoundSource.PLAYERS, 3.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);
                    }
                } else {
                    player.getCooldowns().addCooldown(this, this.firingRate);
                }
                this.drawTick = 0;
            }
        }
    }

    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (hand == InteractionHand.MAIN_HAND && tag.getInt("ammo") > 0 && !player.getCooldowns().isOnCooldown(this)) {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemstack);
        }
        return InteractionResultHolder.fail(itemstack);
    }


    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack stack, int remainingUseDuration) {
        super.onUseTick(level, livingEntity, stack, remainingUseDuration);
        if (livingEntity.level() instanceof ServerLevel serverLevel && this.gunMode) {
            if (this.drawTick < this.drawTime) {
                this.drawTick += 1;
                if (this.drawTick == this.drawTime && livingEntity instanceof Player player) {
                    player.displayClientMessage(Component.translatable("message.kamenridercraft.weapon"), true);
                }
            }
            switch (chargingEffect) {
                case "warped":
                    serverLevel.sendParticles(ParticleTypes.WARPED_SPORE, livingEntity.getX() + livingEntity.getLookAngle().x * 0.5, livingEntity.getEyeY(), livingEntity.getZ() + livingEntity.getLookAngle().z * 0.5, 1, 0, 0, 0, 0.05);
            }
            if (!requireFullDraw || this.drawTick >= this.drawTime) {
                if (!this.singleFire) {
                    if (tag.getInt("ammo") > 0) {
                        if (this.tickCount >= this.firingRate && tag.getInt("ammo") > 1) {
                            fire(livingEntity, livingEntity.getDeltaMovement());
                        } else if (this.tickCount >= this.firingRate) {
                            livingEntity.releaseUsingItem();
                        }
                        this.tickCount += 1;
                    }
                }
            }
        }
    }

    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player && !level.isClientSide) {
            if (tag.getInt("ammo") == 0) {
                tag.putInt("ammo", this.maxAmmo);
                player.getCooldowns().addCooldown(this, this.reloadTime);
            }
        }
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    public NeoBaseBlasterItem ChangeRepairItem(Item item) {
        RepairItem = item;
        return this;
    }

    public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
        return p_40393_.getItem() == RepairItem;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        if (useAnimation.equals("vanilla") || useAnimation.isEmpty()) {
            return UseAnim.BOW;
        } else return UseAnim.NONE;
    }

    public NeoBaseBlasterItem IsFormItem(Item item) {
        FormChangeItem = item;
        return this;
    }

    public NeoBaseBlasterItem IsHenshinItem(Item item) {
        HenshinBeltItem = item;
        return this;
    }

    public NeoBaseBlasterItem IsSwordGun() {
        KamenRiderCraftCore.SWORD_GUN_ITEM.add(this);
        return this;
    }

    public NeoBaseBlasterItem setRepairItem(Item item) {
        this.RepairItem = item;
        return this;
    }

    public NeoBaseBlasterItem setProjectile(String projectileName) {
        this.projectile = projectileName.toLowerCase();
        return this;
    }

    public NeoBaseBlasterItem setModelAndTexture(String textureName, String modelName) {
        this.texture = textureName.toLowerCase();
        this.model = modelName.toLowerCase();
        return this;
    }

    public NeoBaseBlasterItem setExplosivePower(int power) {
        this.explosionPower = power;
        return this;
    }

    public NeoBaseBlasterItem setEffects(String[] effects) {
        this.effects = effects;
        return this;
    }

    public NeoBaseBlasterItem setMeterCost(int cost) {
        this.meterCost = cost;
        return this;
    }

    public NeoBaseBlasterItem setRequiresDraw(int drawingTime, boolean needFullDraw) {
        this.requireFullDraw = needFullDraw;
        this.drawTime = drawingTime;
        return this;
    }

    public NeoBaseBlasterItem setGunMode(boolean isGunMode) {
        this.gunMode = isGunMode;
        return this;
    }

    public NeoBaseBlasterItem setHoldAnimation(String anim) {
        this.holdAnimation = anim.toLowerCase();
        return this;
    }

    public NeoBaseBlasterItem setUseAnimation(String anim) {
        this.useAnimation = anim.toLowerCase();
        return this;
    }

    public NeoBaseBlasterItem setParticles(String chargeEffect, String firingParticle) {
        this.chargingEffect = chargeEffect.toLowerCase();
        this.firingParticle = firingParticle.toLowerCase();
        return this;
    }

    public NeoBaseBlasterItem setRequiresActionMeter(int actionCost) {
        this.meterCost = actionCost;
        return this;
    }
}
