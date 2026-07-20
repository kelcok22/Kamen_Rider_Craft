package com.kelco.kamenridercraft.item.heisei_phase_1.ryuki;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.base_entities.BaseProjectileEntity;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.RyukiRiderItems;
import net.minecraft.client.Minecraft;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;


public class AdventCardItem extends BaseItem {
    public String rider;
    private ArrayList<Item> weapons;
    public String special;
    public Item visor;
    private static String[] effects;

    public AdventCardItem(Properties properties, String rider, Item visor, Item... weapons) {
        super(properties);
        this.rider = rider;
        this.visor = visor;
        this.weapons = Lists.newArrayList(weapons);
    }

    public AdventCardItem(Properties properties, String rider, Item visor, String special) {
        super(properties);
        this.rider = rider;
        this.visor = visor;
        this.special = special;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);

        if (!level.isClientSide() && player.getInventory().countItem(visor) != 0 && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt
                && belt.isTransformed(player)) {
            if (rider.equals(((RiderDriverItem) player.getItemBySlot(EquipmentSlot.FEET).getItem()).riderName) || (player.getInventory().countItem(RyukiRiderItems.SLASH_VISOR.get()) != 0 && ((RiderDriverItem) player.getItemBySlot(EquipmentSlot.FEET).getItem()).riderName.equals("alternative_zero"))) {
                if (weapons != null) {
                    for (Item weapon : weapons) {
                        ItemStack item = new ItemStack(weapon, 1);
                        ItemEntity entity = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item, 0, 0, 0);
                        entity.setPickUpDelay(0);
                        level.addFreshEntity(entity);
                    }
                } else {
                    List<LivingEntity> nearbyEnemies = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(15), entity ->
                            (entity instanceof Player && entity != player)
                                    || (entity instanceof Mob));

                    switch (special) {
                        case "trick_vent":
                            for (int i = 0; i < 4; i++) {
                                RiderSummonEntity trick = MobsCore.RIDER_SUMMON.get().create(level);
                                if (trick != null) {
                                    trick.moveTo(player.getX(), player.getY() + 1, player.getZ(), player.getYRot(), player.getXRot());
                                    trick.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10.0D);
                                    trick.setHealth(10.0F);
                                    trick.NAME = "ryuki_trick_vent";
                                    trick.setItemSlot(EquipmentSlot.HEAD, new ItemStack(RyukiRiderItems.RYUKIHELMET.get()));
                                    trick.setItemSlot(EquipmentSlot.CHEST, new ItemStack(RyukiRiderItems.RYUKICHESTPLATE.get()));
                                    trick.setItemSlot(EquipmentSlot.LEGS, new ItemStack(RyukiRiderItems.RYUKILEGGINGS.get()));
                                    trick.setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.RYUKIDRIVER.get()));

                                    RiderDriverItem.setFormItem(trick.getItemBySlot(EquipmentSlot.FEET), RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1), 1);
                                    if (RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1) == RyukiRiderItems.ADVENT_CARD.get()) {
                                        trick.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.RIDE_SABER.get()));
                                        trick.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.RIDE_VISOR.get()));
                                    } else if (RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1) == RyukiRiderItems.SURVIVE_REKKA.get()
                                            || RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1) == RyukiRiderItems.SURVIVE_BLACK.get()
                                            || RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1) == ModdedItemCore.DRAGRANZER.get()) {
                                        trick.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.DRAG_BLADE.get()));
                                    } else {
                                        trick.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.DRAG_SABER.get()));
                                        trick.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.DRAG_VISOR.get()));
                                    }

                                    level.addFreshEntity(trick);
                                    trick.bindToPlayer(player);
                                    if (!Minecraft.getInstance().isSingleplayer()) {
                                        trick.setCustomName(player.getDisplayName());
                                        trick.setCustomNameVisible(true);
                                    }
                                }
                            }
                            break;
                        case "trick_vent_knight":
                            for (int i = 0; i < 4; i++) {
                                RiderSummonEntity trick = MobsCore.RIDER_SUMMON.get().create(level);
                                if (trick != null) {
                                    trick.moveTo(player.getX(), player.getY() + 1, player.getZ(), player.getYRot(), player.getXRot());
                                    trick.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10.0D);
                                    trick.setHealth(10.0F);
                                    trick.NAME = "knight_trick_vent";
                                    trick.setItemSlot(EquipmentSlot.HEAD, new ItemStack(RyukiRiderItems.RYUKIHELMET.get()));
                                    trick.setItemSlot(EquipmentSlot.CHEST, new ItemStack(RyukiRiderItems.RYUKICHESTPLATE.get()));
                                    trick.setItemSlot(EquipmentSlot.LEGS, new ItemStack(RyukiRiderItems.RYUKILEGGINGS.get()));
                                    trick.setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.KNIGHTDRIVER.get()));

                                    RiderDriverItem.setFormItem(trick.getItemBySlot(EquipmentSlot.FEET), RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1), 1);
                                    if (RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1) == RyukiRiderItems.ADVENT_CARD.get()) {
                                        trick.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.RIDE_SABER.get()));
                                        trick.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.RIDE_VISOR.get()));
                                    } else if (RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1) == RyukiRiderItems.SURVIVE_SHIPPU.get()) {
                                        trick.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.DARK_BLADE.get()));
                                        trick.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.DARK_SHIELD.get()));
                                    } else
                                        trick.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.DARK_VISOR.get()));

                                    level.addFreshEntity(trick);
                                    trick.bindToPlayer(player);
                                    if (!Minecraft.getInstance().isSingleplayer()) {
                                        trick.setCustomName(player.getDisplayName());
                                        trick.setCustomNameVisible(true);
                                    }
                                }
                            }
                            break;
                        case "firewall_vent":
                            player.addEffect(new MobEffectInstance(EffectCore.FIRE_ARMOR, 200, 2, true, true));
                            break;
                        case "meteorbullet_vent":
                            BaseProjectileEntity baseProjectile = new BaseProjectileEntity(player.level(), player, "rocket", 8, 2, effects);
                            baseProjectile.setTexture("rocket");
                            baseProjectile.setModel("rocket");
                            baseProjectile.setGlowing(false);
                            baseProjectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2f, 1F);
                            player.level().addFreshEntity(baseProjectile);
                            break;
                        case "nasty_vent":
                            for (LivingEntity enemy : nearbyEnemies) {
                                enemy.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0, true, true));
                                enemy.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 0, true, true));
                            }
                            break;
                        case "blust_vent":
                            player.addEffect(new MobEffectInstance(EffectCore.PUSH, 200, 2, true, true));
                            break;
                        case "freeze_vent":
                            for (LivingEntity enemy : nearbyEnemies) {
                                enemy.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 5, true, true));
                                enemy.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 5, true, true));
                                enemy.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 5, true, true));
                            }
                            break;
                        case "time_vent":
                            player.addEffect(new MobEffectInstance(EffectCore.TIME, 200, 2, true, true));
                            break;
                        case "clear_vent":
                            player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 2, true, true));
                            break;
                        case "accele_vent":
                            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 3, true, true));
                            break;

                    }

                    if (!player.isCreative()) {
                        itemstack.shrink(1);
                        player.getCooldowns().addCooldown(this, 500);
                    }
                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}