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
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
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
import net.neoforged.fml.ModList;
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

	public void attackride(ItemStack itemstack, Level level, Player player) {
		if (EFFECTS != null) {
			for (int i = 0; i < EFFECTS.size(); i++) {
				player.addEffect(new MobEffectInstance(EFFECTS.get(i).getEffect(),EFFECTS.get(i).getDuration(),EFFECTS.get(i).getAmplifier(),true,false));
			}
		}
		if (ITEMS.size() != 0) {
			for (int i = 0; i < ITEMS.size(); i++) {
				ItemStack item = new ItemStack(ITEMS.get(i), 1);
				item.set(DataComponents.ITEM_NAME, Component.translatable("owner.kamenridercraft.decade", ITEMS.get(i).getName(item).getString()));
				if (item.isDamageableItem() && ServerConfig.summonedItemDurability != 0) item.set(DataComponents.MAX_DAMAGE, ServerConfig.summonedItemDurability);

				ItemEntity entity = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item, 0, 0, 0);
				entity.setPickUpDelay(0);
				level.addFreshEntity(entity);
			}
		}
		if (SPECIAL != null) {
			Vec3 look = player.getLookAngle();
			switch (SPECIAL) {
				case "illusion":
					for (int i = 0; i < 2; i++) {
						RiderSummonEntity illusion = MobsCore.RIDER_SUMMON.get().create(level);
						if (illusion != null) {
							illusion.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
							illusion.NAME = "decade_illusion";
							illusion.setMeleeOnSpawn(100.0D);
							illusion.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Decade_Rider_Items.DECADEHELMET.get()));
							illusion.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Decade_Rider_Items.DECADECHESTPLATE.get()));
							illusion.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Decade_Rider_Items.DECADELEGGINGS.get()));
							illusion.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.RIDE_BOOKER.get()));

							if (player.getItemBySlot(EquipmentSlot.FEET).getItem()==Decade_Rider_Items.DARK_DECADRIVER.get()) {
								illusion.setItemSlot(EquipmentSlot.FEET, new ItemStack(Decade_Rider_Items.DARK_DECADRIVER.get()));
							} else {
								illusion.setItemSlot(EquipmentSlot.FEET, new ItemStack(Decade_Rider_Items.DECADRIVER.get()));
								RiderDriverItem.set_Form_Item(illusion.getItemBySlot(EquipmentSlot.FEET), RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),1), 1);
							}
							
							level.addFreshEntity(illusion);
							illusion.bindToPlayer(player);
						}
					}
					break;
				case "diend_illusion":
					for (int i = 0; i < 2; i++)	{
						RiderSummonEntity illusion = MobsCore.RIDER_SUMMON.get().create(level);
						if (illusion != null) {
							illusion.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
							illusion.NAME = "diend_illusion";
							illusion.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Decade_Rider_Items.DECADEHELMET.get()));
							illusion.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Decade_Rider_Items.DECADECHESTPLATE.get()));
							illusion.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Decade_Rider_Items.DECADELEGGINGS.get()));
							illusion.setItemSlot(EquipmentSlot.FEET, new ItemStack(Decade_Rider_Items.DIEND_BELT.get()));
							illusion.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Decade_Rider_Items.DIENDRIVER.get()));
							RiderDriverItem.set_Form_Item(illusion.getItemBySlot(EquipmentSlot.FEET), RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),1), 1);
							level.addFreshEntity(illusion);
							illusion.bindToPlayer(player);
						}
					}
					break;
				case "crossattack":
					List<LivingEntity> nearbyAllies = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(10), entity ->
																	(entity instanceof Player && entity != player)
																	|| (entity instanceof OwnableEntity owned && owned.getOwner() == player));
					for (LivingEntity ally : nearbyAllies) {
						if (ally.getMainHandItem().getItem() instanceof BowItem) {
							ally.addEffect(new MobEffectInstance(Effect_core.SHOT_BOOST, 250, 3,false,true));
						} else {
							ally.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 250, 3,false,true));
						}
					}
					break;
				case "barrier":
					BlockPos pos = new BlockPos((int)(Math.floor(player.getX()+ look.x*3)), (int)(Math.floor(player.getEyeY() + look.y*3)), (int)(Math.floor(player.getZ() + look.z*3)));

					for (int i = 0; i < 2; i++)	{
						if (level.getBlockState(pos).getDestroySpeed(level, pos) < 0.2) level.destroyBlock(pos, true);
						if (level.isEmptyBlock(pos) || level.getFluidState(pos)!=Fluids.EMPTY.defaultFluidState()) level.setBlock(pos, Blocks.LIGHT_BLUE_STAINED_GLASS.defaultBlockState(), 3);
						pos = pos.below(1);
					}
					break;
				case "onibi":
					Vec3 playerPos = player.getEyePosition(1.0f);
					List<LivingEntity> nearbyTargets = level.getEntitiesOfClass(LivingEntity.class, new AABB(playerPos, playerPos.add(look.scale(6))).inflate(0.2), entity ->
																	  entity != player && !(entity instanceof OwnableEntity owned && owned.getOwner() == player));
					for (Entity target : nearbyTargets) {
						target.hurt(player.damageSources().playerAttack(player), 5.0F);
						target.setRemainingFireTicks(200);
					}
					
					for (double distX = 0; distX < 8; distX += 0.5) {
						double distY = -(Math.pow(distX, 2) / 50) - 0.3;
						if (level instanceof ServerLevel serverlevel) serverlevel.sendParticles(ParticleTypes.FLAME, playerPos.x + (look.x * distX), (playerPos.y + distY) + (look.y * distX), playerPos.z + (look.z * distX), 3, 0.0, 0.0, 0.0, 0.01);
					}
					level.playSound((Player)null, new BlockPos((int) player.getX(), (int) player.getY(), (int) player.getZ()), SoundEvents.FIRECHARGE_USE, SoundSource.PLAYERS, 1.0F, (level.getRandom().nextFloat() - level.getRandom().nextFloat()) * 0.2F + 1.0F);
					break;
				case "ore_sanjou":
					Decade_Rider_Items.DEN_O_SWORD_CARD.get().use(level, player, player.getUsedItemHand());
					player.sendSystemMessage(Component.translatable("attack.kamenridercraft.ore_sanjou"));
					break;
				case "bokuni_tsurarete_miru":
					Decade_Rider_Items.DEN_O_ROD_CARD.get().use(level, player, player.getUsedItemHand());
					player.sendSystemMessage(Component.translatable("attack.kamenridercraft.bokuni_tsurarete_miru"));
					break;
				case "nakerude":
					Decade_Rider_Items.DEN_O_AX_CARD.get().use(level, player, player.getUsedItemHand());
					player.sendSystemMessage(Component.translatable("attack.kamenridercraft.nakerude"));
					break;
				case "kotaewa_kiite_nai":
					Decade_Rider_Items.DEN_O_GUN_CARD.get().use(level, player, player.getUsedItemHand());
					player.sendSystemMessage(Component.translatable("attack.kamenridercraft.kotaewa_kiite_nai"));
					break;
				case "rekka_daizantou":
					if (ModList.get().isLoaded("supersentaicraft")) {
						Item item = BuiltInRegistries.ITEM.get(ResourceLocation.parse("supersentaicraft:rekka_daizantou"));
						ItemStack stack = new ItemStack(item, 1);
						stack.set(DataComponents.ITEM_NAME, Component.literal(Component.translatable("owner.kamenridercraft.decade").getString() + item.getName(stack).getString()));
						
						ItemEntity entity = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), stack, 0, 0, 0);
						entity.setPickUpDelay(0);
						level.addFreshEntity(entity);
					}
					break;
			}
		}

		if (!player.isCreative()) {
			itemstack.shrink(1);
			player.getCooldowns().addCooldown(this, 500);
		}
		player.awardStat(Stats.ITEM_USED.get(this));
	}

	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
		
		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);
		
		if (!p_41128_.isClientSide() && p_41129_.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt && belt.isTransformed(p_41129_)){
			if (belt == Decade_Rider_Items.DECADRIVER.get() || belt == Decade_Rider_Items.NEO_DECADRIVER.get() || belt == Decade_Rider_Items.DIEND_BELT.get() || belt == Decade_Rider_Items.DARK_DECADRIVER.get()
				&& ArrayUtils.contains(FORMS, belt.GET_TEXT(p_41129_.getItemBySlot(EquipmentSlot.FEET), null, p_41129_, belt.Rider))) {
				attackride(itemstack, p_41128_, p_41129_);
			}
		}
		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}
}