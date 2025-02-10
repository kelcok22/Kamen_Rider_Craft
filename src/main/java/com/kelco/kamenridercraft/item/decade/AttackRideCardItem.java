package com.kelco.kamenridercraft.item.decade;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.Decade_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.server.level.ServerLevel;


public class AttackRideCardItem extends BaseItem {

	public String[] FORMS = new String[] {""};
	private List<MobEffectInstance> EFFECTS;
	private List<Item> ITEMS = Lists.newArrayList();
	public String SPECIAL;

	public AttackRideCardItem (Properties properties, String[] forms)
	{
		super(properties);
		FORMS = forms;
	}

	public AttackRideCardItem addEffects(MobEffectInstance... effects)
	{
		EFFECTS = Lists.newArrayList(effects);
		return this;
	}

	public AttackRideCardItem addItem(Item item)
	{
		ITEMS.add(item);
		return this;
	}

	public AttackRideCardItem addSpecial(String special)
	{
		SPECIAL = special;
		return this;
	}

	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
		
		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);
		
		if (!p_41128_.isClientSide() && p_41129_.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt){
			if (belt.isTransformed(p_41129_)
				&& (belt == Decade_Rider_Items.DECADRIVER.get() || belt == Decade_Rider_Items.NEO_DECADRIVER.get()
				|| belt == Decade_Rider_Items.DIEND_BELT.get() || belt == Decade_Rider_Items.DARK_DECADRIVER.get())
				&& ArrayUtils.contains(FORMS, belt.GET_TEXT(p_41129_.getItemBySlot(EquipmentSlot.FEET), null, p_41129_, belt.Rider))) {
				if (EFFECTS != null) {
					for (int i = 0; i < EFFECTS.size(); i++) {
						p_41129_.addEffect(new MobEffectInstance(EFFECTS.get(i).getEffect(),EFFECTS.get(i).getDuration(),EFFECTS.get(i).getAmplifier(),true,false));
					}
				}
				if (ITEMS.size() != 0) {
					for (int i = 0; i < ITEMS.size(); i++) {
						ItemStack item = new ItemStack(ITEMS.get(i), 1);
						item.set(DataComponents.ITEM_NAME, Component.literal(Component.translatable("owner.kamenridercraft.decade").getString() + ITEMS.get(i).getName(item).getString()));
						if (item.isDamageableItem() && ServerConfig.summonedItemDurability != 0) item.set(DataComponents.MAX_DAMAGE, ServerConfig.summonedItemDurability);

						ItemEntity entity = new ItemEntity(p_41128_, p_41129_.getX(), p_41129_.getY(), p_41129_.getZ(), item, 0, 0, 0);
						entity.setPickUpDelay(0);
						p_41128_.addFreshEntity(entity);
					}
				}
				if (SPECIAL != null) {
					Vec3 look = p_41129_.getLookAngle();
					switch (SPECIAL) {
						case "illusion":
							for (int i = 0; i < 2; i++) {
								RiderSummonEntity illusion = MobsCore.RIDER_SUMMON.get().create(p_41128_);
								if (illusion != null) {
									illusion.moveTo(p_41129_.getX(), p_41129_.getY()+1, p_41129_.getZ(), p_41129_.getYRot(), p_41129_.getXRot());
									illusion.setMeleeOnly(true);
									illusion.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Decade_Rider_Items.DECADEHELMET.get()));
									illusion.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Decade_Rider_Items.DECADECHESTPLATE.get()));
									illusion.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Decade_Rider_Items.DECADELEGGINGS.get()));
									illusion.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.RIDE_BOOKER.get()));

									if (p_41129_.getItemBySlot(EquipmentSlot.FEET).getItem()==Decade_Rider_Items.DARK_DECADRIVER.get()) {
										illusion.setItemSlot(EquipmentSlot.FEET, new ItemStack(Decade_Rider_Items.DARK_DECADRIVER.get()));
									} else {
										illusion.setItemSlot(EquipmentSlot.FEET, new ItemStack(Decade_Rider_Items.DECADRIVER.get()));
										RiderDriverItem.set_Form_Item(illusion.getItemBySlot(EquipmentSlot.FEET), RiderDriverItem.get_Form_Item(p_41129_.getItemBySlot(EquipmentSlot.FEET),1), 1);
									}
									
									p_41128_.addFreshEntity(illusion);
									illusion.bindToPlayer(p_41129_);
								}
							}
							break;
						case "diend_illusion":
							for (int i = 0; i < 2; i++)	{
								RiderSummonEntity illusion = MobsCore.RIDER_SUMMON.get().create(p_41128_);
								if (illusion != null) {
									illusion.moveTo(p_41129_.getX(), p_41129_.getY()+1, p_41129_.getZ(), p_41129_.getYRot(), p_41129_.getXRot());
									illusion.NAME = "diend_illusion";
									illusion.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Decade_Rider_Items.DECADEHELMET.get()));
									illusion.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Decade_Rider_Items.DECADECHESTPLATE.get()));
									illusion.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Decade_Rider_Items.DECADELEGGINGS.get()));
									illusion.setItemSlot(EquipmentSlot.FEET, new ItemStack(Decade_Rider_Items.DIEND_BELT.get()));
									illusion.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.DIENDRIVER.get()));
									RiderDriverItem.set_Form_Item(illusion.getItemBySlot(EquipmentSlot.FEET), RiderDriverItem.get_Form_Item(p_41129_.getItemBySlot(EquipmentSlot.FEET),1), 1);
									p_41128_.addFreshEntity(illusion);
									illusion.bindToPlayer(p_41129_);
								}
							}
							break;
						case "crossattack":
							List<LivingEntity> nearbyAllies = p_41128_.getEntitiesOfClass(LivingEntity.class, p_41129_.getBoundingBox().inflate(10), entity ->
																			(entity instanceof Player && entity != p_41129_)
																			|| (entity instanceof OwnableEntity owned && owned.getOwner() == p_41129_));
							for (LivingEntity ally : nearbyAllies) {
								if (ally.getMainHandItem().getItem() instanceof BowItem) {
									ally.addEffect(new MobEffectInstance(Effect_core.SHOT_BOOST, 250, 3,true,true));
								} else {
									ally.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 250, 3,true,true));
								}
							}
							break;
						case "barrier":
							BlockPos pos = new BlockPos((int)(Math.floor(p_41129_.getX()+ look.x*3)), (int)(Math.floor(p_41129_.getEyeY() + look.y*3)), (int)(Math.floor(p_41129_.getZ() + look.z*3)));

							for (int i = 0; i < 2; i++)	{
								if (p_41128_.getBlockState(pos).getDestroySpeed(p_41128_, pos) < 0.2) p_41128_.destroyBlock(pos, true);
								if (p_41128_.isEmptyBlock(pos) || p_41128_.getFluidState(pos)!=Fluids.EMPTY.defaultFluidState()) p_41128_.setBlock(pos, Blocks.LIGHT_BLUE_STAINED_GLASS.defaultBlockState(), 3);
								pos = pos.below(1);
							}
							break;
						case "onibi":
        					Vec3 playerPos = p_41129_.getEyePosition(1.0f);
							List<LivingEntity> nearbyTargets = p_41128_.getEntitiesOfClass(LivingEntity.class, new AABB(playerPos, playerPos.add(look.scale(6))).inflate(0.2), entity ->
																			  entity != p_41129_ && !(entity instanceof OwnableEntity owned && owned.getOwner() == p_41129_));
							for (Entity toIgnite : nearbyTargets) toIgnite.setRemainingFireTicks(200);
							
							for (double distX = 0; distX < 8; distX += 0.5) {
								double distY = -(Math.pow(distX, 2) / 50) - 0.3;
								if (p_41128_ instanceof ServerLevel level) level.sendParticles(ParticleTypes.FLAME, playerPos.x + (look.x * distX), (playerPos.y + distY) + (look.y * distX), playerPos.z + (look.z * distX), 3, 0.0, 0.0, 0.0, 0.01);
							}
							p_41128_.playSound((Player)null, new BlockPos((int) p_41129_.getX(), (int) p_41129_.getY(), (int) p_41129_.getZ()), SoundEvents.FIRECHARGE_USE, SoundSource.PLAYERS, 1.0F, (p_41128_.getRandom().nextFloat() - p_41128_.getRandom().nextFloat()) * 0.2F + 1.0F);
							break;
						case "ore_sanjou":
							Decade_Rider_Items.DEN_O_SWORD_CARD.get().use(p_41128_, p_41129_, p_41130_);
							p_41129_.sendSystemMessage(Component.translatable("attack.kamenridercraft.ore_sanjou"));
							break;
						case "bokuni_tsurarete_miru":
							Decade_Rider_Items.DEN_O_ROD_CARD.get().use(p_41128_, p_41129_, p_41130_);
							p_41129_.sendSystemMessage(Component.translatable("attack.kamenridercraft.bokuni_tsurarete_miru"));
							break;
						case "nakerude":
							Decade_Rider_Items.DEN_O_AX_CARD.get().use(p_41128_, p_41129_, p_41130_);
							p_41129_.sendSystemMessage(Component.translatable("attack.kamenridercraft.nakerude"));
							break;
						case "kotaewa_kiite_nai":
							Decade_Rider_Items.DEN_O_GUN_CARD.get().use(p_41128_, p_41129_, p_41130_);
							p_41129_.sendSystemMessage(Component.translatable("attack.kamenridercraft.kotaewa_kiite_nai"));
							break;
					}
				}

				if (!p_41129_.isCreative()) {
					itemstack.shrink(1);
					p_41129_.getCooldowns().addCooldown(this, 500);
				}
				p_41129_.awardStat(Stats.ITEM_USED.get(this));
			}
		}
		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}
}