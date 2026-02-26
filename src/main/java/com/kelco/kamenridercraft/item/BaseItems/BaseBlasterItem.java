package com.kelco.kamenridercraft.item.BaseItems;


import com.google.common.collect.ImmutableMultimap;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.projectile.CellMedalProjectileEntity;
import com.kelco.kamenridercraft.entities.projectile.LaserProjectileEntity;
import com.kelco.kamenridercraft.entities.projectile.RocketProjectileEntity;
import com.kelco.kamenridercraft.item.Modded_item_core;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Unit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.entity.projectile.windcharge.WindCharge;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;

import javax.annotation.Nullable;
import java.util.List;

public class BaseBlasterItem extends BowItem {

    public BaseBlasterItem(Tier toolTier, int Atk, float Spd, Properties prop) {
        super(prop.durability(toolTier.getUses()).attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
    }

    private Item RepairItem = Modded_item_core.RIDER_CIRCUIT.get();
    private Item FormChangeItem = null;
    private Item HenshinBeltItem = null;
    private Item craftingRemainingItem = null;

    private int cooldown = 5;
    private float projDamage = 4;
    private int explosionPower = 4;
    private String projShape = "long";
    private String projColor = "red";

    private String fireType = "single";
    private int fireRate = 5;
    private int shots = 3;

    public enum BlasterProjectile {
        ARROW,
        SMALL_FIREBALL,
        LARGE_FIREBALL,
        LASER,
        CELL_MEDAL,
        DRAGON_FIREBALL,
        EGG,
        ENDER_PEARL,
        ROCKET,
        ROUZE_CARD,
        WIND_CHARGE,
        WITHER_SKULL,
        FIREWORK
    };
    private BlasterProjectile projectile = BlasterProjectile.ARROW;

    public void fire(LivingEntity user, Vec3 vec3) {
        switch (projectile) {
            case ARROW:
                break;

            case SMALL_FIREBALL:
                SmallFireball smallfireball = new SmallFireball(user.level(), user, vec3.normalize());
                smallfireball.setPos(smallfireball.getX(), user.getY(0.5) + 0.5, smallfireball.getZ());
                user.level().addFreshEntity(smallfireball);
                break;

            case LARGE_FIREBALL:
                LargeFireball largefireball = new LargeFireball(user.level(), user, vec3.normalize(), explosionPower);
                largefireball.setPos(largefireball.getX(), user.getY(0.5) + 0.5, largefireball.getZ());
                user.level().addFreshEntity(largefireball);
                break;

            case LASER:
                LaserProjectileEntity laserProjectile = new LaserProjectileEntity(user, user.level());
                laserProjectile.setNoGravity(true);
                laserProjectile.shootFromRotation(user, user.getXRot(), user.getYRot(), 0.0F, 2f, 5F);
                laserProjectile.damageValue = this.projDamage;
                user.level().addFreshEntity(laserProjectile);
                break;

            case CELL_MEDAL:
                CellMedalProjectileEntity cellProjectile = new CellMedalProjectileEntity(user, user.level());
                cellProjectile.shootFromRotation(user, user.getXRot(), user.getYRot(), 0.0F, 4f, 0F);
                cellProjectile.damageValue = this.projDamage;
                user.level().addFreshEntity(cellProjectile);
                break;

            case DRAGON_FIREBALL:
                DragonFireball dragonfireball = new DragonFireball(user.level(), user, vec3.normalize());
                dragonfireball.setPos(dragonfireball.getX(), user.getY(0.5D) + 0.5D, dragonfireball.getZ());
                user.level().addFreshEntity(dragonfireball);
                break;

            case EGG:
                ThrownEgg egg = new ThrownEgg(user.level(), user);
                egg.setPos(egg.getX(), user.getY(0.5D) + 0.5D, egg.getZ());
                egg.addDeltaMovement(vec3.scale(3));
                user.level().addFreshEntity(egg);
                break;

            case ENDER_PEARL:
                ThrownEnderpearl pearl = new ThrownEnderpearl(user.level(), user);
                pearl.setPos(pearl.getX(), user.getY(0.5D) + 0.5D, pearl.getZ());
                pearl.addDeltaMovement(vec3.scale(3));
                user.level().addFreshEntity(pearl);
                break;

            case ROCKET:
                RocketProjectileEntity rocketProjectile = new RocketProjectileEntity(user, user.level());
                rocketProjectile.shootFromRotation(user, user.getXRot(), user.getYRot(), 0.0F, 4f, 0F);
                rocketProjectile.explosionPower = this.explosionPower;
                user.level().addFreshEntity(rocketProjectile);
                break;

            case ROUZE_CARD:
                System.out.println("Next update :3");
                break;

            case WIND_CHARGE:
                WindCharge windcharge = new WindCharge(user.level(), user.getX(), user.getY(0.5D) + 0.5D, user.getZ(), user.getLookAngle());
                user.level().addFreshEntity(windcharge);
                break;

            case WITHER_SKULL:
                WitherSkull witherSkull = new WitherSkull(user.level(), user, vec3.normalize());
                witherSkull.setPos(witherSkull.getX(), user.getY(0.5D) + 0.5D, witherSkull.getZ());
                user.level().addFreshEntity(witherSkull);
                break;

            case FIREWORK:
                ItemStack rocket = new ItemStack(Items.FIREWORK_ROCKET);
                FireworkRocketEntity firework = new FireworkRocketEntity(user.level(), rocket ,user);
                firework.setPos(firework.getX(), user.getY(0.5D) + 0.5D, firework.getZ());
                user.level().addFreshEntity(firework);
                break;
        }
    }

    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player player && level instanceof ServerLevel serverlevel) {
            if (HenshinBeltItem != null && player.getItemBySlot(EquipmentSlot.FEET) == ItemStack.EMPTY) {
                player.setItemSlot(EquipmentSlot.FEET, new ItemStack(HenshinBeltItem));
                if (player.getOffhandItem().getItem() instanceof RiderFormChangeItem formItem)
                    formItem.use(level, player, InteractionHand.OFF_HAND);
            }
            if (FormChangeItem != null && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem) {
                FormChangeItem.use(level, player, InteractionHand.MAIN_HAND);
            }

            if (projectile != BlasterProjectile.ARROW) {
                fire(player, player.getLookAngle());
            } else if (entityLiving.hasEffect(Effect_core.SHOT_BOOST)) {
                ItemStack arrow = new ItemStack(Items.ARROW, 1);
                arrow.set(DataComponents.INTANGIBLE_PROJECTILE, Unit.INSTANCE);
                this.shoot(serverlevel, player, player.getUsedItemHand(), stack, List.of(arrow), 2 * (entityLiving.getEffect(Effect_core.SHOT_BOOST).getAmplifier() + 1), 1.0F, true, null);
            } else {
                ItemStack arrow = new ItemStack(Items.ARROW, 1);
                arrow.set(DataComponents.INTANGIBLE_PROJECTILE, Unit.INSTANCE);
                this.shoot(serverlevel, player, player.getUsedItemHand(), stack, List.of(arrow), 3, 1.0F, true, null);
            }

            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);
            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
            player.awardStat(Stats.ITEM_USED.get(this));
            player.getCooldowns().addCooldown(this, this.cooldown);
        }
    }

    public BaseBlasterItem AddToList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }

    public BaseBlasterItem KeepItem() {
        craftingRemainingItem = this;
        return this;
    }

    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        if (stack.getItem() instanceof BaseItem) {
            if (!hasCraftingRemainingItem(stack)) {
                return ItemStack.EMPTY;
            }
            ItemStack save = new ItemStack(craftingRemainingItem);
            save.applyComponents(stack.getComponents());
            return save;
        } else return new ItemStack(this.getCraftingRemainingItem());
    }


    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return ((BaseBlasterItem) stack.getItem()).craftingRemainingItem != null;
    }

    public BaseBlasterItem setCooldown(int cd) {
        this.cooldown = cd;
        return this;
    }

    public BaseBlasterItem setDamage(float damageChange) {
        this.projDamage = damageChange;
        return this;
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    @Override
    protected void shootProjectile(LivingEntity shooter, Projectile projectile, int index, float velocity, float inaccuracy, float angle, @Nullable LivingEntity target) {
        projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0F, velocity, inaccuracy);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        boolean flag = !player.getProjectile(itemstack).isEmpty();
        InteractionResultHolder<ItemStack> ret = EventHooks.onArrowNock(itemstack, level, player, hand, flag);

        if (ret != null) return ret;
        else {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    public int getDefaultProjectileRange() {
        return 30;
    }

    public BaseBlasterItem ChangeRepairItem(Item item) {
        RepairItem = item;
        return this;
    }

    public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
        return p_40393_.getItem() == RepairItem;
    }

    public BaseBlasterItem IsFormItem(Item item) {
        FormChangeItem = item;
        return this;
    }

    public BaseBlasterItem IsHenshinItem(Item item) {
        HenshinBeltItem = item;
        return this;
    }

    public BaseBlasterItem IsSwordGun() {
        KamenRiderCraftCore.SWORD_GUN_ITEM.add(this);
        return this;
    }

    public BaseBlasterItem setProjectile(BlasterProjectile type) {
        projectile = type;
        return this;
    }

    public BaseBlasterItem setFireTypeData(String type, int rate) {
        fireType = type;
        fireRate = rate;
        return this;
    }

    public BaseBlasterItem setExplosionPower(int blast) {
        explosionPower = blast;
        return this;
    }

    public BlasterProjectile getProjectile() {
        return this.projectile;
    }


    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

    public static ItemAttributeModifiers createAttributes(Tier tier, int attackDamage, float attackSpeed) {
        return createAttributes(tier, (float) attackDamage, attackSpeed);
    }

    public static ItemAttributeModifiers createAttributes(Tier p_330371_, float p_331976_, float p_332104_) {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, p_331976_ + p_330371_.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, p_332104_, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }
}