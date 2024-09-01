package com.kelco.kamenridercraft.events;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import java.util.List;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.bosses.ShockerRidersEntity;
import com.kelco.kamenridercraft.entities.footSoldiers.ShockerCombatmanEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.neoforge.client.event.RenderPlayerEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;


public class ModCommonEvents {


	public static class EventHandler {

		@SubscribeEvent
		public void onPlayerTick(PlayerTickEvent.Post event) {
			Entity entity=event.getEntity();
			if (entity == null)
				return;
			if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(Effect_core.FLYING) : false) {
				if (entity instanceof Player _player) {
					_player.getAbilities().mayfly = (true);
					_player.onUpdateAbilities();
				}
			}
			else if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(Effect_core.FLYING) : false)) {
				if (entity instanceof Player _player) {

					boolean checkGamemode = false;

					if (_player instanceof ServerPlayer _serverPlayer) {
						checkGamemode = _serverPlayer.gameMode.getGameModeForPlayer() != GameType.CREATIVE&_serverPlayer.gameMode.getGameModeForPlayer() != GameType.SPECTATOR;
					} else if (entity.level().isClientSide()) {
						checkGamemode =  Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance()
								.getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() != GameType.SPECTATOR && Minecraft.getInstance()
								.getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() != GameType.CREATIVE;
					}

					_player.getAbilities().mayfly = (checkGamemode? false:true);
					_player.onUpdateAbilities();
				}
			}
		}

		@SubscribeEvent
		public void EquipmentChange(LivingEquipmentChangeEvent event) {
			event.getEntity().setInvisible(false);
		}

		@SubscribeEvent
		public void addLivingDamageEvent(LivingDamageEvent.Post event) {

			if (event.getSource().getEntity() instanceof LivingEntity _livEnt) {
				if (event.getSource().is(DamageTypes.PLAYER_ATTACK) || event.getSource().is(DamageTypes.MOB_ATTACK) || event.getSource().is(DamageTypes.MOB_ATTACK_NO_AGGRO)) {

					if (_livEnt.hasEffect(Effect_core.FIRE_PUNCH)) {
						 if (_livEnt.getMainHandItem().isEmpty()) {
						event.getEntity().setRemainingFireTicks(25*(_livEnt.getEffect(Effect_core.FIRE_PUNCH).getAmplifier() + 1));
						}
					}

					if (event.getEntity().hasEffect(Effect_core.FIRE_ARMOR)) {
						event.getEntity().setRemainingFireTicks(25*(_livEnt.getEffect(Effect_core.FIRE_ARMOR).getAmplifier() + 1));
					}

					if (_livEnt.hasEffect(Effect_core.EXPLOSION_PUNCH)) {
						if (_livEnt.getMainHandItem().isEmpty()) {
							boolean flag = event.getEntity().level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
							event.getEntity().level().explode(null, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), _livEnt.getEffect(Effect_core.EXPLOSION_PUNCH).getAmplifier(), flag, Level.ExplosionInteraction.MOB);
						}
						}

					if (event.getEntity().hasEffect(Effect_core.REFLECT)) {
						event.getSource().getEntity().hurt(event.getSource(), (event.getOriginalDamage()) * (1 + event.getEntity().getEffect(Effect_core.REFLECT).getAmplifier() + 1));
					}

				} else if (event.getSource().is(DamageTypes.ARROW) || event.getSource().is(DamageTypes.MOB_PROJECTILE)) {
					if (_livEnt.hasEffect(Effect_core.FIRE_SHOT)) {
						event.getEntity().setRemainingFireTicks(25*(_livEnt.getEffect(Effect_core.FIRE_SHOT).getAmplifier() + 1));
					}

					if (_livEnt.hasEffect(Effect_core.EXPLOSION_SHOT)) {
						boolean flag = event.getEntity().level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
						event.getEntity().level().explode(null, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), _livEnt.getEffect(Effect_core.EXPLOSION_SHOT).getAmplifier(), flag, Level.ExplosionInteraction.MOB);
					}
				}
			}
		}
	}

		/**
		@SubscribeEvent
		// Heals an entity by half a heart every time they jump.
		public void onLivingJump(LivingEvent.LivingJumpEvent event) {
			Entity entity = event.getEntity();
			// Only heal on the server side
			if (!entity.level().isClientSide()) {
				boolean flag = entity.level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();

				entity.level().explode(null, entity.getX(), entity.getY() +1, entity.getZ(), 3, flag, Level.ExplosionInteraction.MOB);

			}
		}


	public static class ForgeCommonEvents {

		/**
		@SubscribeEvent
		public static void addCustomWandererTrades(WandererTradesEvent event) {
			List<ItemListing> trades = event.getGenericTrades();
			ItemStack stack = new ItemStack(Rider_Blocks.GINGA_METEOR.get(), 1);
			trades.add((trader, rand) -> new MerchantOffer(
					new ItemStack(Items.EMERALD, 2),
					stack,10,8,0.02F));
			
			trades.add((trader, rand) -> new MerchantOffer(
					new ItemStack(Items.EMERALD, 2),
					new ItemStack(Miscellaneous_Rider_Items.KUUGA_AMAZING_MIGHTY_ARTIST.get(), 1),10,8,0.02F));
		}
		

		@SubscribeEvent
		public static void addCustomTrades(VillagerTradesEvent event) {
			if(event.getType() == VillagerProfession.LIBRARIAN) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Ichigo_Rider_Items.RIDER3_VS_THE_DEMON_OF_GENERAL_BLACK.get(), 1);
				int villagerLevel = 1;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 2),
						stack,10,8,0.02F));
			}
			if(event.getType() == VillagerProfession.LIBRARIAN) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Kuuga_Rider_Items.KUUGA_MANGA.get(), 1);
				int villagerLevel = 1;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 2),
						stack,10,8,0.02F));
			}
			if(event.getType() == VillagerProfession.LIBRARIAN) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Modded_item_core.CARD_WARRIOR_KAMEN_RIDER_MANGA.get(), 1);
				int villagerLevel = 2;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 2),
						stack,10,8,0.02F));
			}
			
			if(event.getType() == RiderVillagers.SHOCKER_VILLAGER.get()) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Ichigo_Rider_Items.PREFECTER.get(), 1);
				int villagerLevel = 1;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Ichigo_Rider_Items.RIDOL_CORE.get(), 1),
						stack,10,8,0.02F));
			}
			
			if(event.getType() == RiderVillagers.SHOCKER_VILLAGER.get()) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Modded_item_core.SHOCKER_EMBLEM.get(), 1);
				int villagerLevel = 1;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 2),
						stack,10,8,0.02F));
			}

			if(event.getType() == RiderVillagers.SHOCKER_VILLAGER.get()) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Ichigo_Rider_Items.J_STONE.get(), 1);
				int villagerLevel = 1;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 2),
						stack,10,8,0.02F));
			}

			if(event.getType() == RiderVillagers.SHOCKER_VILLAGER.get()) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Ichigo_Rider_Items.ZO_STONE.get(), 1);
				int villagerLevel = 1;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 2),
						stack,10,8,0.02F));
			}
			if(event.getType() == RiderVillagers.SHOCKER_VILLAGER.get()) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Miscellaneous_Rider_Items.GORO_WINE_BOTTLE.get(), 1);
				int villagerLevel = 2;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 2),
						stack,10,8,0.02F));
			} 

			if(event.getType() == RiderVillagers.SHOCKER_VILLAGER.get()) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Rider_Blocks.ICHIGO_CHAIR.get(), 1);
				int villagerLevel = 3;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 2),
						stack,10,8,0.02F));
			} 

			if(event.getType() == RiderVillagers.SHOCKER_VILLAGER.get()) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Ichigo_Rider_Items.NOPHOON_CORE.get(), 1);
				int villagerLevel = 3;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 2),
						stack,10,8,0.02F));
			} 
			
			if(event.getType() == RiderVillagers.SHOCKER_VILLAGER.get()) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Ichigo_Rider_Items.SHIN_STONE.get(), 1);
				int villagerLevel = 1;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 2),
						stack,10,8,0.02F));
			}
			if(event.getType() == RiderVillagers.SHOCKER_VILLAGER.get()) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Modded_item_core.SINISTER_PACHINKO_BALL.get(), 1);
				int villagerLevel = 2;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 4),
						stack,10,8,0.02F));
			}
			
			if(event.getType() == RiderVillagers.HUMAGEAR_VILLAGER.get()) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Zero_One_Rider_Items.BLANK_PROGRISEKEY.get(), 3);
				int villagerLevel = 1;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 1),
						stack,10,8,0.02F));
			}
			if(event.getType() == RiderVillagers.HUMAGEAR_VILLAGER.get()) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Items.EMERALD, 1);
				int villagerLevel = 1;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Zero_One_Rider_Items.HIDEN_METAL.get(), 3),
						stack,10,8,0.02F));
			}
			if(event.getType() == RiderVillagers.HUMAGEAR_VILLAGER.get()) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Zero_One_Rider_Items.HUMAGEAR_PROGRISEKEY.get(), 3);
				int villagerLevel = 2;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 2),
						stack,10,8,0.02F));
			}
			if(event.getType() == RiderVillagers.HUMAGEAR_VILLAGER.get()) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Zero_One_Rider_Items.THOUSAND_KEY.get(), 1);
				int villagerLevel = 3;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 12),
						stack,10,8,0.02F));
			}
			
			if(event.getType() == RiderVillagers.KAMEN_CAFE_BUTLER.get()) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Miscellaneous_Rider_Items.CANDY.get(), 3);
				int villagerLevel = 1;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 1),
						stack,10,8,0.02F));
			}
			if(event.getType() == RiderVillagers.KAMEN_CAFE_BUTLER.get()) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Miscellaneous_Rider_Items.CONTRACT_CHAOSTONE.get(), 1);
				int villagerLevel = 1;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 2),
						stack,10,8,0.02F));
			}
			if(event.getType() == RiderVillagers.KAMEN_CAFE_BUTLER.get()) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Miscellaneous_Rider_Items.GASHA_TICKET.get(), 1);
				int villagerLevel = 2;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 6),
						stack,10,8,0.02F));
			}
			if(event.getType() == RiderVillagers.KAMEN_CAFE_BUTLER.get()) {
				Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
				ItemStack stack = new ItemStack(Miscellaneous_Rider_Items.ENERGY_DRINK.get(), 1);
				int villagerLevel = 2;

				trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
						new ItemStack(Items.EMERALD, 2),
						stack,10,8,0.02F));
			}
		}
	}
**/

	@SubscribeEvent
	public static void entitySpawnRestriction(RegisterSpawnPlacementsEvent event) {

		event.register(MobsCore.SHOCKER_COMBATMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	/*
		event.register(MobsCore.DESTRON_COMBATMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.GOD_WARFARE_AGENT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.RED_FOLLWER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.BLACK_SATAN_SOLDIER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.ARI_COMMANDO.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.DOGMA_FIGHTER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.COMBAT_ROID.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.CHAP.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.CHAP_GREY.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.ZU_GUMUN_BA.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.PANTHERAS_LUTEUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.ANGUIS_MASCULUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.RIOTROOPER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.ZECTROOPER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.SHADOW_TROOPER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.NEOTROOPER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.NEW_MOLE_IMAGIN_SAND.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.MASQUERADE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.FOUNDATION_X_MASQUERADE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.YUMMY.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.BUGSTERVIRUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	//	event.register(MobsCore.LOVELY_BUGSTER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.RIDEPLAYER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		
		event.register(MobsCore.TRILOBITE_MAGIA.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.DODO_MAGIA_CHICK.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.BATTLE_RAIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.ABADDON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.PAWN_JYAMATO.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.JYAMATO_RIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.GM_RIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		
		event.register(MobsCore.ANKH.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AnkhEntity::checkAnkhSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	 **/
	}
}
