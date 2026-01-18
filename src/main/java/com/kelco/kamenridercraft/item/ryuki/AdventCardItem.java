package com.kelco.kamenridercraft.item.ryuki;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Ryuki_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
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


public class AdventCardItem extends BaseItem {

	public String RIDER;
	private ArrayList<Item> WEAPONS;
	public String SPECIAL;
	public Item VISOR;

	public AdventCardItem (Properties properties, String rider, Item visor, Item... weapons)
	{
		super(properties);
		
		RIDER = rider;
		VISOR = visor;
		WEAPONS = Lists.newArrayList(weapons);
	}

	public AdventCardItem (Properties properties, String rider, Item visor, String special)
	{
		super(properties);
		
		RIDER = rider;
		VISOR = visor;
		SPECIAL = special;
	}

	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
		
		ItemStack itemstack = player.getItemInHand(usedHand);
		
		if (player.getInventory().countItem(VISOR)!=0) {
			if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt
			&& belt.isTransformed(player)){
				if (Objects.equals(RIDER, ((RiderDriverItem) player.getItemBySlot(EquipmentSlot.FEET).getItem()).Rider) | (player.getInventory().countItem(Ryuki_Rider_Items.SLASH_VISOR.get())!=0 && Objects.equals(((RiderDriverItem) player.getItemBySlot(EquipmentSlot.FEET).getItem()).Rider, "alternative_zero"))) {
					if (!level.isClientSide()) {
						if (WEAPONS != null) {
                            for (Item weapon : WEAPONS) {
                                ItemStack item = new ItemStack(weapon, 1);
                                ItemEntity entity = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item, 0, 0, 0);
                                entity.setPickUpDelay(0);
                                level.addFreshEntity(entity);
                            }
						} else {
                            List<LivingEntity> nearbyEnemies = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(15), entity ->
                                    (entity instanceof Player && entity != player)
                                            || (entity instanceof Mob));

						 	switch (SPECIAL) {
						 		case "trick_vent":
									for (int i = 0; i < 4; i++) {
										RiderSummonEntity trick = MobsCore.RIDER_SUMMON.get().create(level);
										if (trick != null) {
											trick.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
											trick.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10.0D);
											trick.setHealth(10.0F);
											trick.NAME = "ryuki_trick_vent";
											trick.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Ryuki_Rider_Items.RYUKIHELMET.get()));
											trick.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Ryuki_Rider_Items.RYUKICHESTPLATE.get()));
											trick.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Ryuki_Rider_Items.RYUKILEGGINGS.get()));
											trick.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.RYUKIDRIVER.get()));

											RiderDriverItem.set_Form_Item(trick.getItemBySlot(EquipmentSlot.FEET), RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),1), 1);
											if (RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),1) == Ryuki_Rider_Items.ADVENT_CARD.get()) {
												trick.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Ryuki_Rider_Items.RIDE_SABER.get()));
												trick.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Ryuki_Rider_Items.RIDE_VISOR.get()));
											}
											else if (RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),1) == Ryuki_Rider_Items.SURVIVE_REKKA.get()
												||RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),1) == Ryuki_Rider_Items.SURVIVE_BLACK.get()
												||RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),1) == Modded_item_core.DRAGRANZER.get()) {
												trick.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Ryuki_Rider_Items.DRAG_BLADE.get()));
											} else {
												trick.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Ryuki_Rider_Items.DRAG_SABER.get()));
												trick.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Ryuki_Rider_Items.DRAG_VISOR.get()));
											}

											level.addFreshEntity(trick);
											trick.bindToPlayer(player);
                                            if (!Minecraft.getInstance().isSingleplayer()){
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
											trick.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
											trick.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10.0D);
											trick.setHealth(10.0F);
											trick.NAME = "knight_trick_vent";
											trick.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Ryuki_Rider_Items.RYUKIHELMET.get()));
											trick.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Ryuki_Rider_Items.RYUKICHESTPLATE.get()));
											trick.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Ryuki_Rider_Items.RYUKILEGGINGS.get()));
											trick.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.KNIGHTDRIVER.get()));

											RiderDriverItem.set_Form_Item(trick.getItemBySlot(EquipmentSlot.FEET), RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),1), 1);
											if (RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),1) == Ryuki_Rider_Items.ADVENT_CARD.get()) {
												trick.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Ryuki_Rider_Items.RIDE_SABER.get()));
												trick.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Ryuki_Rider_Items.RIDE_VISOR.get()));
											}
											else if (RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),1) == Ryuki_Rider_Items.SURVIVE_SHIPPU.get()) {
												trick.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Ryuki_Rider_Items.DARK_BLADE.get()));
												trick.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Ryuki_Rider_Items.DARK_SHIELD.get()));
											} else trick.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Ryuki_Rider_Items.DARK_VISOR.get()));

											level.addFreshEntity(trick);
											trick.bindToPlayer(player);
                                            if (!Minecraft.getInstance().isSingleplayer()){
                                                trick.setCustomName(player.getDisplayName());
                                                trick.setCustomNameVisible(true);
                                            }
										}
									}
                                    break;
                                case "firewall_vent":
                                    player.addEffect(new MobEffectInstance(Effect_core.FIRE_ARMOR, 200, 2, true, true));
                                    break;
                                case "meteorbullet_vent":
                                    player.addEffect(new MobEffectInstance(Effect_core.CANNON, 200, 2, true, true));
                                    break;
                                case "nasty_vent":
                                    for (LivingEntity enemy : nearbyEnemies) {
                                        enemy.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0,true,true));
                                        enemy.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 0,true,true));
                                    }
                                    break;
                                case "blust_vent":
                                    player.addEffect(new MobEffectInstance(Effect_core.PUSH, 200, 2, true, true));
                                    break;
                                case "freeze_vent":
                                    for (LivingEntity enemy : nearbyEnemies) {
                                        enemy.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 5,true,true));
                                        enemy.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 5,true,true));
                                        enemy.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 5,true,true));
                                    }
                                    break;
                                case "time_vent":
                                    player.addEffect(new MobEffectInstance(Effect_core.TIME, 200, 2, true, true));
                                    break;
                                case "clear_vent":
                                    player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 2, true, true));
                                    break;
                                case "accele_vent":
                                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 3, true, true));
                                    break;


                            }
						}

						if (!player.isCreative()) {
							itemstack.shrink(1);
							player.getCooldowns().addCooldown(this, 500);
						}
						player.awardStat(Stats.ITEM_USED.get(this));
					}
				}
			}
		}
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
}