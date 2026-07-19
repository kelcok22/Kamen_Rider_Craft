package com.kelco.kamenridercraft.item.base_items;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.base_entities.BaseProjectileEntity;
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
import org.jetbrains.annotations.NotNull;

public class NeoBaseBlasterItem extends BaseItem {
    private boolean singleFire = false;
    private float projDamage = 3;
    private int explosionPower = 0;
    private int accuracyMod = 0;
    private int maxAmmo = 6;
    CompoundTag tag = new CompoundTag();
    private int firingRate = 12;
    private int reloadTime = 60;

    private int drawTime = 0;
    private int meterCost = 0;
    private boolean requireFullDraw = false;

    private String projectile = "arrow";
    private String[] effects;
    private String model = "laser";
    private String texture = "red_laser";
    private String chargingEffect = "";
    private String firingParticle = "";
    private String useAnimation = "vanilla";
    private String holdAnimation = "";
    private NeoBaseBlasterItem.BlasterPreset preset;

    private int tickCount = 0;
    private int drawTick = 0;
    private boolean gunMode = true;

    private Item RepairItem = ModdedItemCore.RIDER_CIRCUIT.get();
    private Item FormChangeItem = null;
    private Item HenshinBeltItem = null;

    public NeoBaseBlasterItem(Properties prop, float Atk, float Spd) {
        super(prop.durability(1000).attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));
    }

    public enum BlasterPreset {
        BLASTER,
        AUTO_BLASTER,
        BURST_BLASTER,
        SWORD_GUN,
        AUTO_SWORD_GUN,
        BURST_SWORD_GUN,
        ROCKET,
        LIGHTNING_BALL,
        FIREBALL,
        VANILLA_FIREBALL,
        LARGE_VANILLA_FIREBALL,
        BOW_PRESET,
        SPECTRAL_BOW_PRESET
    }

    public NeoBaseBlasterItem setPreset(BlasterPreset preset) {
        switch (preset) {
            case BLASTER, AUTO_BLASTER, BURST_BLASTER, SWORD_GUN, AUTO_SWORD_GUN, BURST_SWORD_GUN:
                this.projectile = "laser";
                if (preset.equals(BlasterPreset.AUTO_BLASTER) || preset.equals(BlasterPreset.AUTO_SWORD_GUN)) {
                    this.projDamage = 2;
                    this.firingRate = 3;
                    this.reloadTime = 80;
                    this.maxAmmo = 30;
                    this.model = "short_laser";
                    this.accuracyMod = 2;
                } else if(preset.equals(BlasterPreset.BURST_BLASTER) || preset.equals(BlasterPreset.BURST_SWORD_GUN)) {
                    this.projDamage = 2;
                    this.firingRate = 3;
                    this.reloadTime = 20;
                    this.maxAmmo = 3;
                    this.model = "laser";
                    this.accuracyMod = 2;
                } else {
                    this.model = "laser";
                }
                if (preset.equals(BlasterPreset.SWORD_GUN) || preset.equals(BlasterPreset.AUTO_SWORD_GUN) || preset.equals(BlasterPreset.BURST_SWORD_GUN)) {
                    this.isSwordGun();
                }
                this.singleFire = false;
                this.firingParticle = "yellow_sparks";
                this.texture = "yellow_laser";
                break;
            case ROCKET:
                this.projectile = "rocket";
                this.texture = "rocket";
                this.model = "rocket";
                this.explosionPower = 5;
                this.maxAmmo = 1;
                this.reloadTime = 100;
                this.firingRate = 1;
                this.singleFire = true;
                this.firingParticle = "smoke";
                break;
            case LIGHTNING_BALL:
                this.projectile = "effect_ball";
                this.texture = "lightning_ball";
                this.model = "effect_ball";
                this.projDamage = 6;
                this.maxAmmo = 1;
                this.reloadTime = 100;
                this.firingRate = 1;
                this.singleFire = true;
                break;
            case FIREBALL:
                this.projectile = "effect_ball";
                this.texture = "fire_ball";
                this.model = "effect_ball";
                this.projDamage = 6;
                this.maxAmmo = 1;
                this.reloadTime = 100;
                this.firingRate = 1;
                this.singleFire = true;
                break;
            case VANILLA_FIREBALL:
                this.projectile = "small_fireball";
                this.explosionPower = 0;
                break;
            case LARGE_VANILLA_FIREBALL:
                this.projectile = "small_fireball";
                this.explosionPower = 3;
                break;
            case BOW_PRESET:
                this.projectile = "arrow";
                break;
            case SPECTRAL_BOW_PRESET:
                this.projectile = "spectral_arrow";
                break;
        }
        tag.putInt("ammo", maxAmmo);
        return this;
    }

    public void fire(LivingEntity user, Vec3 vec3) {
        if (user.level() instanceof ServerLevel serverLevel) {
            switch (firingParticle) {
                case "smoke":
                    serverLevel.sendParticles(ParticleTypes.WHITE_SMOKE, user.getX() + user.getLookAngle().x * 0.5, user.getEyeY(), user.getZ() + user.getLookAngle().z * 0.5, 10, 0, 0, 0, 0.05);
                    break;
                case "yellow_sparks":
                    serverLevel.sendParticles(ParticleTypes.WHITE_ASH, user.getX() + user.getLookAngle().x * 0.5, user.getEyeY(), user.getZ() + user.getLookAngle().z * 0.5, 10, 0, 0, 0, 0.05);
                    break;
            }
            switch (projectile) {
                case "arrow", "spectral_arrow":
                    ItemStack arrow;
                    if (projectile.contains("spectral_arrow")) {
                        arrow = new ItemStack(Items.SPECTRAL_ARROW, 1);
                        SpectralArrow arrowEntity = new SpectralArrow(user.level(), user, arrow, getDefaultInstance());
                        arrowEntity.pickup = AbstractArrow.Pickup.DISALLOWED;
                        arrowEntity.setPos(arrowEntity.getX(), user.getY(0.6) + 0.5, arrowEntity.getZ());
                        arrowEntity.setBaseDamage(projDamage / 2);

                        if (drawTime != 0) {
                            arrowEntity.addDeltaMovement(user.getLookAngle().scale(((double) 3 / drawTime) * drawTick));
                        } else {
                            arrowEntity.addDeltaMovement(user.getLookAngle().scale(3));
                        }
                        if (user.hasEffect(EffectCore.SHOT_BOOST)) {
                            arrowEntity.addDeltaMovement(user.getLookAngle().scale(1));
                        }
                        user.level().addFreshEntity(arrowEntity);
                    } else {
                        arrow = new ItemStack(Items.ARROW, 1);
                        Arrow arrowEntity = new Arrow(user.level(), user, arrow, getDefaultInstance());
                        arrowEntity.pickup = AbstractArrow.Pickup.DISALLOWED;
                        arrowEntity.setPos(arrowEntity.getX(), user.getY(0.6) + 0.5, arrowEntity.getZ());
                        arrowEntity.setBaseDamage(projDamage / 2);

                        if (drawTime != 0) {
                            arrowEntity.addDeltaMovement(user.getLookAngle().scale(((double) 3 / drawTime) * drawTick));
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
                    LargeFireball largefireball = new LargeFireball(user.level(), user, vec3.normalize(), explosionPower);
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
                    float modifiedDamage = this.projDamage;
                    if (user.hasEffect(EffectCore.SHOT_BOOST)) {
                        modifiedDamage = modifiedDamage + user.getEffect(EffectCore.SHOT_BOOST).getAmplifier() + 1;
                    }
                    BaseProjectileEntity baseProjectile = new BaseProjectileEntity(user.level(), user, projectile, modifiedDamage, explosionPower, effects);
                    if(projectile.equalsIgnoreCase("cell_medal")) {
                        baseProjectile.setModel("cell_medal");
                        baseProjectile.setTexture("cell_medal");
                    } else {
                        baseProjectile.setTexture(texture.toLowerCase());
                        baseProjectile.setModel(model.toLowerCase());
                    }

                    baseProjectile.setGlowing(true);
                    baseProjectile.shootFromRotation(user, user.getXRot(), user.getYRot(), 0.0F, 2f, 1F + accuracyMod);
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
                tickCount = 0;
                tag.putInt("ammo", tag.getInt("ammo") - 1);
                tickCount = 0;
            }
        }
    }


    public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeLeft) {
        if (livingEntity instanceof Player player && level instanceof ServerLevel serverlevel) {
            if (requireFullDraw && drawTick < drawTime) {
                drawTick = 0;
                return;
            }
            if (!requireFullDraw && tag.getInt("ammo") > 0 || drawTick >= drawTime && tag.getInt("ammo") > 0) {
                if (HenshinBeltItem != null && player.getItemBySlot(EquipmentSlot.FEET) == ItemStack.EMPTY) {
                    player.setItemSlot(EquipmentSlot.FEET, new ItemStack(HenshinBeltItem));
                    if (player.getOffhandItem().getItem() instanceof RiderFormChangeItem formItem) {
                        formItem.use(level, player, InteractionHand.OFF_HAND);
                    }
                }
                if (FormChangeItem != null && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem) {
                    FormChangeItem.use(level, player, InteractionHand.MAIN_HAND);
                }

                fire(livingEntity, livingEntity.getDeltaMovement());
                if (tag.getInt("ammo") == 0) {
                    player.getCooldowns().addCooldown(this, reloadTime);
                    if (!singleFire) {
                        serverlevel.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), SoundEvents.CHAIN_BREAK, SoundSource.PLAYERS, 3.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);
                    }
                } else {
                    player.getCooldowns().addCooldown(this, firingRate);
                }
                drawTick = 0;
            }
        }
    }

    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (hand == InteractionHand.MAIN_HAND && tag.getInt("ammo") > 0 && !player.getCooldowns().isOnCooldown(this)) {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemStack);
        }
        return InteractionResultHolder.fail(itemStack);
    }


    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack stack, int remainingUseDuration) {
        super.onUseTick(level, livingEntity, stack, remainingUseDuration);
        if (livingEntity.level() instanceof ServerLevel serverLevel && gunMode) {
            if (drawTick < drawTime) {
                drawTick += 1;
                if (drawTick == drawTime && livingEntity instanceof Player player) {
                    player.displayClientMessage(Component.translatable("message.kamenridercraft.weapon"), true);
                }
            }
            switch (chargingEffect) {
                case "warped":
                    serverLevel.sendParticles(ParticleTypes.WARPED_SPORE, livingEntity.getX() + livingEntity.getLookAngle().x * 0.5, livingEntity.getEyeY() + livingEntity.getLookAngle().y * 0.5, livingEntity.getZ() + livingEntity.getLookAngle().z * 0.5, 1, 0, 0, 0, 0.05);
            }
            if (!requireFullDraw || drawTick >= drawTime) {
                if (!singleFire) {
                    if (tag.getInt("ammo") > 0) {
                        if (tickCount >= firingRate && tag.getInt("ammo") > 1) {
                            fire(livingEntity, livingEntity.getDeltaMovement());
                        } else if (tickCount >= firingRate) {
                            livingEntity.releaseUsingItem();
                        }
                        tickCount += 1;
                    }
                }
            }
        }
    }

    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player && !level.isClientSide) {
            if (tag.getInt("ammo") == 0) {
                tag.putInt("ammo", maxAmmo);
                player.getCooldowns().addCooldown(this, reloadTime);
            }
        }
    }

    @Override
    public boolean canAttackBlock(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player) {
        return !player.isCreative();
    }

    public NeoBaseBlasterItem changeRepairItem(Item item) {
        RepairItem = item;
        return this;
    }

    public boolean isValidRepairItem(@NotNull ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == RepairItem;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        if (useAnimation.equals("vanilla") || useAnimation.isEmpty()) {
            return UseAnim.BOW;
        } else {
            return UseAnim.NONE;
        }
    }

    public NeoBaseBlasterItem isFormItem(Item item) {
        FormChangeItem = item;
        return this;
    }

    public NeoBaseBlasterItem isHenshinItem(Item item) {
        HenshinBeltItem = item;
        return this;
    }

    public NeoBaseBlasterItem isSwordGun() {
        KamenRiderCraftCore.SWORD_GUN_ITEM.add(this);
        return this;
    }

    public NeoBaseBlasterItem setRepairItem(Item item) {
        RepairItem = item;
        return this;
    }

    public NeoBaseBlasterItem setProjectile(String projectileName) {
        projectile = projectileName.toLowerCase();
        return this;
    }

    public NeoBaseBlasterItem setModelAndTexture(String textureName, String modelName) {
        texture = textureName.toLowerCase();
        model = modelName.toLowerCase();
        return this;
    }

    public NeoBaseBlasterItem setExplosivePower(int power) {
        explosionPower = power;
        return this;
    }

    public NeoBaseBlasterItem setEffects(String[] effects) {
        effects = effects;
        return this;
    }

    public NeoBaseBlasterItem setMeterCost(int cost) {
        meterCost = cost;
        return this;
    }

    public NeoBaseBlasterItem setAbility(String abilityName) {
        tag.putString("ability_name", abilityName.toLowerCase());
        return this;
    }

    public NeoBaseBlasterItem setRequiredRider(String requiredRider) {
        tag.putString("required_form", requiredRider.toLowerCase());
        return this;
    }

    public NeoBaseBlasterItem setRequiredForm(String requiredForm) {
        tag.putString("required_rider", requiredForm.toLowerCase());
        return this;
    }

    public NeoBaseBlasterItem setRequiresDraw(int drawingTime, boolean needFullDraw) {
        requireFullDraw = needFullDraw;
        drawTime = drawingTime;
        return this;
    }

    public NeoBaseBlasterItem setGunMode(boolean isGunMode) {
        gunMode = isGunMode;
        return this;
    }

    public NeoBaseBlasterItem setMaxAmmo(int maxAmmo) {
        this.maxAmmo = maxAmmo;
        tag.putInt("ammo", maxAmmo);
        return this;
    }

    public NeoBaseBlasterItem setFireRate(int firingRate) {
        this.firingRate = firingRate;
        return this;
    }

    public NeoBaseBlasterItem setReloadTime(int reloadTime) {
        this.reloadTime = reloadTime;
        return this;
    }

    public NeoBaseBlasterItem singleFire(boolean singleFire) {
        this.singleFire = multiFire;
        return this;
    }

    public NeoBaseBlasterItem setHoldAnimation(String anim) {
        holdAnimation = anim.toLowerCase();
        return this;
    }

    public NeoBaseBlasterItem setUseAnimation(String anim) {
        useAnimation = anim.toLowerCase();
        return this;
    }

    public NeoBaseBlasterItem setParticles(String chargeEffect, String firingParticle) {
        chargingEffect = chargeEffect.toLowerCase();
        firingParticle = firingParticle.toLowerCase();
        return this;
    }

    public NeoBaseBlasterItem setRequiresActionMeter(int actionCost) {
        meterCost = actionCost;
        return this;
    }
}