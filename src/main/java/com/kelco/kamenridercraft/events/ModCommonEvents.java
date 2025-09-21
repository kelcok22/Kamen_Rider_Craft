package com.kelco.kamenridercraft.events;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.*;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.client.KeyBindings;
import com.kelco.kamenridercraft.client.models.ElementaryInvesModel;
import com.kelco.kamenridercraft.client.models.HeartRoidmudeModel;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.allies.*;
import com.kelco.kamenridercraft.entities.bikes.RidoronEntity;
import com.kelco.kamenridercraft.entities.bikes.baseBikeEntity;
import com.kelco.kamenridercraft.entities.bosses.*;
import com.kelco.kamenridercraft.entities.footSoldiers.*;
import com.kelco.kamenridercraft.entities.summons.*;
import com.kelco.kamenridercraft.entities.villager.RiderVillagers;
import com.kelco.kamenridercraft.item.*;
import com.kelco.kamenridercraft.item.BaseItems.BaseBlasterItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.gavv.GochipodItem;
import com.kelco.kamenridercraft.network.payload.AbilityKeyPayload;
import com.kelco.kamenridercraft.network.payload.BeltKeyPayload;
import com.kelco.kamenridercraft.particle.ModParticles;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.ItemStackedOnOtherEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent.LivingVisibilityEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import net.neoforged.neoforge.network.PacketDistributor;


public class ModCommonEvents {


	public static class EventHandler {

		@SubscribeEvent
		public void clientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().player != null) {
				while (KeyBindings.INSTANCE.BeltKey.consumeClick()) PacketDistributor.sendToServer(new BeltKeyPayload(0));
                while (KeyBindings.INSTANCE.AbilityKey.consumeClick()) PacketDistributor.sendToServer(new AbilityKeyPayload(0));
			}
		}

		@SubscribeEvent
		public void onPlayerTick(PlayerTickEvent.Post event) {

			ResourceKey<Level> MOON = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:moon"));
			if (event.getEntity().level().dimension() == MOON) {
				event.getEntity().addEffect(new MobEffectInstance(Effect_core.LOW_GRAVITY, 30, 7, false, false));
			}

			LocalDate localdate = LocalDate.now();
			int i = localdate.get(ChronoField.DAY_OF_MONTH);
			int j = localdate.get(ChronoField.MONTH_OF_YEAR);
			if (j == 12 && i >= 22 && i <= 28 ) {
				event.getEntity().addEffect(new MobEffectInstance(Effect_core.CHRISTMAS, 30, 0, false, false));
			}
		}

		@SubscribeEvent
		public void onEntityTick(EntityTickEvent.Post event) {
			if (event.getEntity()instanceof LivingEntity entity){
				if (entity.getItemBySlot(EquipmentSlot.FEET).getItem()instanceof RiderDriverItem belt){
					belt.beltTick(entity.getItemBySlot(EquipmentSlot.FEET),entity.level(),entity,36);
					belt.giveEffects(entity);
				}
			}
		}


		private Item getGochizoDrop(ItemStack itemstack) {
			Random generator = new Random();

			if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/gummy_gochizo")))){
				int rand = generator.nextInt(Gavv_Rider_Items.GUMMY.size());
				return Gavv_Rider_Items.GUMMY.get(rand);
			}else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/marshmallow_gochizo")))){
				int rand = generator.nextInt(Gavv_Rider_Items.MARSHMALLOW.size());
				return Gavv_Rider_Items.MARSHMALLOW.get(rand);
			}else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/snack_gochizo")))){
				int rand = generator.nextInt(Gavv_Rider_Items.SNACK.size());
				return Gavv_Rider_Items.SNACK.get(rand);
			}else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/chocolate_gochizo")))){
				int rand = generator.nextInt(Gavv_Rider_Items.CHOCO.size());
				return Gavv_Rider_Items.CHOCO.get(rand);
			}else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/cookie_gochizo")))){
				int rand = generator.nextInt(Gavv_Rider_Items.COOKIE.size());
				return Gavv_Rider_Items.COOKIE.get(rand);
			}else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/doughnut_gochizo")))){
				return Gavv_Rider_Items.DOUMARU_GOCHIZO.get();
			}else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/tarakomentaiko_gochizo")))){
				return Gavv_Rider_Items.TARAKOMENTAIKO_GOCHIZO.get();
			}else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/candy_gochizo")))){
				int rand = generator.nextInt(Gavv_Rider_Items.CANDY.size());
				return Gavv_Rider_Items.CANDY.get(rand);
			}else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/cake_gochizo")))){
				int rand = generator.nextInt(Gavv_Rider_Items.CAKE.size());
				return Gavv_Rider_Items.CAKE.get(rand);
			}else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/pancake_gochizo")))){
				int rand = generator.nextInt(Gavv_Rider_Items.PANCAKE.size());
				return Gavv_Rider_Items.PANCAKE.get(rand);
			}else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/mochi_gochizo")))) {
				int rand = generator.nextInt(Gavv_Rider_Items.MOCHI.size());
				return Gavv_Rider_Items.MOCHI.get(rand);
			}else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/pudding_gochizo")))) {
				int rand = generator.nextInt(Gavv_Rider_Items.PUDDING.size());
				return Gavv_Rider_Items.PUDDING.get(rand);
			}else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/corn_gochizo")))) {
				int rand = generator.nextInt(Gavv_Rider_Items.CORN.size());
				return Gavv_Rider_Items.CORN.get(rand);
			}
			return Items.APPLE;
		}

		private Item getCupGochizoDrop(ItemStack itemstack) {
			Random generator = new Random();
			if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/frappeis_gochizo")))) {
				int rand = generator.nextInt(Gavv_Rider_Items.COFFEE.size());
				return Gavv_Rider_Items.COFFEE.get(rand);
			}else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/ala_mode_gochizo")))) {
				int rand = generator.nextInt(Gavv_Rider_Items.ALA_MODE.size());
				return Gavv_Rider_Items.ALA_MODE.get(rand);
			}else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/sorbei_gochizo")))) {
				int rand = generator.nextInt(Gavv_Rider_Items.ICE_CREAM.size());
				return Gavv_Rider_Items.ICE_CREAM.get(rand);
			}
			return Items.APPLE;
		}

		@SubscribeEvent
		public void Give_Gochizo(LivingEntityUseItemEvent.Finish event) {

			Item GOCHIZO = getGochizoDrop(event.getItem());
			Item CUP_GOCHIZO = getCupGochizoDrop(event.getItem());

				 if (event.getEntity() instanceof Player player) {
					 if (GOCHIZO!=Items.APPLE&player.getInventory().countItem(Gavv_Rider_Items.BLANK_GOCHIZO.get()) > 0) {

						 if ( player.getInventory().getItem(40).getItem()==Gavv_Rider_Items.BLANK_GOCHIZO.get()){
							 player.getInventory().removeItem(40, 1);
						 }else player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(Gavv_Rider_Items.BLANK_GOCHIZO.get())), 1);

						 player.drop(new ItemStack(GOCHIZO), false);

					 }
					 if (CUP_GOCHIZO!=Items.APPLE&player.getInventory().countItem(Gavv_Rider_Items.PROTOTYPE_CUP_GOCHIZO.get()) > 0) {

						 if ( player.getInventory().getItem(40).getItem()==Gavv_Rider_Items.PROTOTYPE_CUP_GOCHIZO.get()){
							 player.getInventory().removeItem(40, 1);
						 }else player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(Gavv_Rider_Items.PROTOTYPE_CUP_GOCHIZO.get())), 1);

						 player.drop(new ItemStack(CUP_GOCHIZO), false);
					 }
			 }
		}


		@SubscribeEvent
		public void Farmers_Delight_Cake_Gochizo(PlayerInteractEvent.RightClickBlock event) {
			if (ModList.get().isLoaded("farmersdelight") && !event.getLevel().isClientSide) {
				BlockState state = event.getLevel().getBlockState(event.getPos());
				Player player = event.getEntity();

				if (state.is(BlockTags.create(ResourceLocation.parse("kamenridercraft:fd_cakes_for_gochizo"))) && !event.getItemStack().is(ItemTags.create(ResourceLocation.fromNamespaceAndPath("farmersdelight", "tools/knives")))
				&& player.canEat(false) && player.getInventory().countItem(Gavv_Rider_Items.BLANK_GOCHIZO.get()) > 0) {
					if (player.getInventory().getItem(40).getItem()==Gavv_Rider_Items.BLANK_GOCHIZO.get()) player.getInventory().removeItem(40, 1);
					else player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(Gavv_Rider_Items.BLANK_GOCHIZO.get())), 1);

					player.drop(new ItemStack(Gavv_Rider_Items.CAKE.get(new Random().nextInt(Gavv_Rider_Items.CAKE.size()))), false);
				}
			}
		}

		@SubscribeEvent
		public void addLivingDamageEvent(ItemStackedOnOtherEvent event) {
			if (event.getCarriedItem().is(Gavv_Rider_Items.GOCHIPOD_EMPTY)){

				ItemStack stack =event.getCarriedItem();
				ItemStack other= event.getStackedOnItem();
				if (other.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/gochizo/gochizo_for_gochipod")))){
					int stored = GochipodItem.get_store_Item(stack);
					int need = 100-stored;
					int have = other.getCount();
					if (need!=0){
						if (have>need){
							GochipodItem.set_store_Item(stack,need);
							other.shrink(need);
						}else {
							GochipodItem.set_store_Item(stack,have);
							other.shrink(have);
						}
					}
				}
			}
		}


		/*
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
*/
        @SubscribeEvent
        public void addLivingDamageEvent(LivingDeathEvent event) {
            if (event.getSource().getEntity()instanceof Player player){
                if (player.hasEffect(Effect_core.HAPPY_MODE)) {
                    player.sendSystemMessage(Component.literal(Component.translatable("happy_mode.kamenridercraft.sleep").getString()));
                }
            }

        }

            @SubscribeEvent
		public void addLivingDamageEvent(LivingDamageEvent.Post event) {


			if (event.getSource().getEntity() instanceof LivingEntity _livEnt) {


					if (event.getSource().is(DamageTypes.PLAYER_ATTACK) || event.getSource().is(DamageTypes.MOB_ATTACK) || event.getSource().is(DamageTypes.MOB_ATTACK_NO_AGGRO)) {

						if (_livEnt.getItemBySlot(EquipmentSlot.FEET).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "belts/ex-aid_armor")))) {
							((ServerLevel) event.getEntity().level()).sendParticles(ModParticles.HIT_PARTICLES.get(),
									event.getEntity().getX() + 0.5, event.getEntity().getY() + 1.5,
									event.getEntity().getZ() + 0.5, 1, 0, 0, 0, 3);
						}
						if (_livEnt.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem && RiderDriverItem.get_Form_Item(_livEnt.getItemBySlot(EquipmentSlot.FEET),1).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/gochizo/puchingummy")))) {
							((ServerLevel) event.getEntity().level()).sendParticles(ModParticles.GUMMI_PARTICLES2.get(),
									event.getEntity().getX() + 0.5, event.getEntity().getY() + 1.5,
									event.getEntity().getZ() + 0.5, 10, 0, 0, 0, 3);
						}

                        if (_livEnt.hasEffect(Effect_core.HAPPY_MODE)) {
                            ((ServerLevel) event.getEntity().level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                                    event.getEntity().getX() + 0.5, event.getEntity().getY() + 1.5,
                                    event.getEntity().getZ() + 0.5, 10, 0, 0, 0, 3);
                            ((ServerLevel) event.getEntity().level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                                    event.getEntity().getX() + 0.5, event.getEntity().getY() + 1.5,
                                    event.getEntity().getZ() + 0.5, 10, 0, 0, 0, 3);
                            ((ServerLevel) event.getEntity().level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                                    event.getEntity().getX() + 0.5, event.getEntity().getY() + 1.5,
                                    event.getEntity().getZ() + 0.5, 10, 0, 0, 0, 3);
                            ((ServerLevel) event.getEntity().level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                                    event.getEntity().getX() + 0.5, event.getEntity().getY() + 1.5,
                                    event.getEntity().getZ() + 0.5, 10, 0, 0, 0, 3);
                            ((ServerLevel) event.getEntity().level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                                    event.getEntity().getX() + 0.5, event.getEntity().getY() + 1.5,
                                    event.getEntity().getZ() + 0.5, 10, 0, 0, 0, 3);
                        }

						if (_livEnt.hasEffect(Effect_core.RIDER_POISON_HAND)) {
							if (_livEnt.getMainHandItem().isEmpty()) {
								event.getEntity().addEffect(new MobEffectInstance(MobEffects.POISON, 500, _livEnt.getEffect(Effect_core.RIDER_POISON_HAND).getAmplifier(),true,true));
							}
						}
					if (_livEnt.hasEffect(Effect_core.FIRE_PUNCH)) {
						 if (_livEnt.getMainHandItem().isEmpty()) {
							 event.getEntity().igniteForSeconds(_livEnt.getEffect(Effect_core.FIRE_PUNCH).getAmplifier()+1);
						}
					}
                        if (_livEnt.hasEffect(Effect_core.FIRE_SLASH)) {
                            if (_livEnt.getMainHandItem().getItem()instanceof SwordItem||_livEnt.getMainHandItem().getItem()instanceof BaseBlasterItem) {
                                event.getEntity().igniteForSeconds(_livEnt.getEffect(Effect_core.FIRE_SLASH).getAmplifier()+1);
                            }

                        }
					if (_livEnt.hasEffect(Effect_core.THUNDER_PUNCH)) {
						if (_livEnt.getMainHandItem().isEmpty()) {
							LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT,_livEnt.level());
							thunder.setPos(   event.getEntity().getX(),   event.getEntity().getY(),   event.getEntity().getZ());
							event.getEntity().level().addFreshEntity(thunder);
						}

					}
					if (_livEnt.hasEffect(Effect_core.THUNDER_SLASH)) {
						if (_livEnt.getMainHandItem().getItem()instanceof SwordItem||_livEnt.getMainHandItem().getItem()instanceof BaseBlasterItem) {
							LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT,_livEnt.level());
							thunder.setPos(   event.getEntity().getX(),   event.getEntity().getY(),   event.getEntity().getZ());
							event.getEntity().level().addFreshEntity(thunder);
						}

					}

					if (event.getEntity().hasEffect(Effect_core.FIRE_ARMOR)) {
						_livEnt.igniteForSeconds(event.getEntity().getEffect(Effect_core.FIRE_ARMOR).getAmplifier()+1);
					}


					if (_livEnt.hasEffect(Effect_core.EXPLOSION_PUNCH)) {
						if (_livEnt.getMainHandItem().isEmpty()) {
							boolean flag = event.getEntity().level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
							event.getEntity().level().explode(null, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), _livEnt.getEffect(Effect_core.EXPLOSION_PUNCH).getAmplifier(), flag, Level.ExplosionInteraction.MOB);
						}
						}
					if (_livEnt.hasEffect(Effect_core.EXPLOSION_SLASH)) {
						if (_livEnt.getMainHandItem().getItem()instanceof SwordItem||_livEnt.getMainHandItem().getItem()instanceof BaseBlasterItem) {
							boolean flag = event.getEntity().level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
							event.getEntity().level().explode(null, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), _livEnt.getEffect(Effect_core.EXPLOSION_SLASH).getAmplifier(), flag, Level.ExplosionInteraction.MOB);
						}
					}

					if (event.getEntity().hasEffect(Effect_core.REFLECT)) {
						event.getSource().getEntity().hurt(event.getSource(), (event.getOriginalDamage()) * (1 + event.getEntity().getEffect(Effect_core.REFLECT).getAmplifier() + 1));
					}

				} else if (event.getSource().is(DamageTypes.ARROW) || event.getSource().is(DamageTypes.MOB_PROJECTILE)) {
					if (_livEnt.hasEffect(Effect_core.FIRE_SHOT)) {
						event.getEntity().setRemainingFireTicks(25*(Objects.requireNonNull(_livEnt.getEffect(Effect_core.FIRE_SHOT)).getAmplifier() + 1));
					}

					if (_livEnt.hasEffect(Effect_core.EXPLOSION_SHOT)) {
						boolean flag = event.getEntity().level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
						event.getEntity().level().explode(null, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), _livEnt.getEffect(Effect_core.EXPLOSION_SHOT).getAmplifier(), flag, Level.ExplosionInteraction.MOB);
					}
					if (_livEnt.hasEffect(Effect_core.THUNDER_SHOT)) {

							LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT,_livEnt.level());
							thunder.setPos(   event.getEntity().getX(),   event.getEntity().getY(),   event.getEntity().getZ());
							event.getEntity().level().addFreshEntity(thunder);
					}
				}
			}
		}

		@SubscribeEvent
		public void formTimeout(MobEffectEvent.Expired event) {
			LivingEntity entity = event.getEntity();
			ItemStack belt = entity.getItemBySlot(EquipmentSlot.FEET);
			
			if (event.getEffectInstance() != null && event.getEffectInstance().getEffect() == Effect_core.FORM_TIMEOUT
			&& belt.getItem() instanceof RiderDriverItem driver && driver.isTransformed(entity)) {
                for (int n = 1; n == driver.Num_Base_Form_Item; n++) {
                    RiderFormChangeItem form = RiderDriverItem.get_Form_Item(belt, n);
					if (form.getTimeoutDuration() != 0) RiderDriverItem.set_Form_Item(belt, form.getRevertForm(), n);
                }
			}
		}
	}

	public static class CommonEvents {

		@SubscribeEvent
		public void addCustomWandererTrades(WandererTradesEvent event) {
			List<ItemListing> trades = event.getGenericTrades();
			trades.add((trader, rand) -> new MerchantOffer(
					new ItemCost(Items.EMERALD, 2),
					new ItemStack(Rider_Blocks.GINGA_METEOR.get(), 1), 10, 8, 0.02F));
			trades.add((trader, rand) -> new MerchantOffer(
					new ItemCost(Items.EMERALD, 2),
					new ItemStack(Rider_Blocks.HELHEIM_SAPLING.get(), 1), 10, 8, 0.02F));
			trades.add((trader, rand) -> new MerchantOffer(
					new ItemCost(Items.EMERALD, 2),
					new ItemStack(Miscellaneous_Rider_Items.KUUGA_AMAZING_MIGHTY_ARTIST.get(), 1), 10, 8, 0.02F));
		}


		@SubscribeEvent
		public void addCustomTrades(VillagerTradesEvent event) {
			Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
			if (event.getType() == VillagerProfession.LIBRARIAN) {
				trades.get(1).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 2),
						new ItemStack(Ichigo_Rider_Items.RIDER3_VS_THE_DEMON_OF_GENERAL_BLACK.get(), 1), 10, 8, 0.02F));
				trades.get(1).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 2),
						new ItemStack(Kuuga_Rider_Items.KUUGA_MANGA.get(), 1), 10, 8, 0.02F));
				trades.get(2).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 2),
						new ItemStack(Modded_item_core.CARD_WARRIOR_KAMEN_RIDER_MANGA.get(), 1), 10, 8, 0.02F));
			} else if (event.getType() == VillagerProfession.CLERIC) {
				trades.get(1).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 5),
						new ItemStack(Gotchard_Rider_Items.ALCHEMIST_RING_NO_GEM.get(), 1), 10, 8, 0.02F));
		}
			else if (event.getType() == RiderVillagers.SHOCKER_VILLAGER.get()) {
				trades.get(1).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Ichigo_Rider_Items.RIDOL_CORE.get(), 1),
						new ItemStack(Ichigo_Rider_Items.PREFECTER.get(), 1), 10, 8, 0.02F));
				trades.get(1).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 2),
						new ItemStack(Modded_item_core.SHOCKER_EMBLEM.get(), 1), 10, 8, 0.02F));
				trades.get(1).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 2),
						new ItemStack(Ichigo_Rider_Items.SHIN_STONE.get(), 1), 10, 8, 0.02F));
				trades.get(1).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 2),
						new ItemStack(Ichigo_Rider_Items.ZO_STONE.get(), 1), 10, 8, 0.02F));
				trades.get(1).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 2),
						new ItemStack(Ichigo_Rider_Items.J_STONE.get(), 1), 10, 8, 0.02F));
				trades.get(2).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 2),
						new ItemStack(Miscellaneous_Rider_Items.GORO_WINE_BOTTLE.get(), 1), 10, 8, 0.02F));
				trades.get(2).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 4),
						new ItemStack(Modded_item_core.SINISTER_PACHINKO_BALL.get(), 1), 10, 8, 0.02F));
				trades.get(3).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 2),
						new ItemStack(Rider_Blocks.ICHIGO_CHAIR.get(), 1), 10, 8, 0.02F));
				trades.get(3).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 2),
						new ItemStack(Ichigo_Rider_Items.NOPHOON_CORE.get(), 1), 10, 8, 0.02F));
			}
			else if (event.getType() == RiderVillagers.HUMAGEAR_VILLAGER.get()) {
				trades.get(1).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 1),
						new ItemStack(Zero_One_Rider_Items.BLANK_PROGRISEKEY.get(), 3), 10, 8, 0.02F));
				trades.get(1).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Zero_One_Rider_Items.HIDEN_METAL.get(), 3),
						new ItemStack(Items.EMERALD, 1), 10, 8, 0.02F));
				trades.get(2).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 2),
						new ItemStack(Zero_One_Rider_Items.HUMAGEAR_PROGRISEKEY.get(), 3), 10, 8, 0.02F));
				trades.get(3).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 12),
						new ItemStack(Zero_One_Rider_Items.THOUSAND_KEY.get(), 1), 10, 8, 0.02F));
			}
			else if (event.getType() == RiderVillagers.KAMEN_CAFE_BUTLER.get()) {
				trades.get(1).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 1),
						new ItemStack(Miscellaneous_Rider_Items.CANDY.get(), 3), 10, 8, 0.02F));
				trades.get(1).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 2),
						new ItemStack(Miscellaneous_Rider_Items.CONTRACT_CHAOSTONE.get(), 1), 10, 8, 0.02F));
				trades.get(2).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 6),
						new ItemStack(Miscellaneous_Rider_Items.GASHA_TICKET.get(), 1), 10, 8, 0.02F));
				trades.get(2).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 2),
						new ItemStack(Miscellaneous_Rider_Items.ENERGY_DRINK.get(), 1), 10, 8, 0.02F));
			}
			else if (event.getType() == RiderVillagers.AGENT_VILLAGER.get()) {
			trades.get(1).add((trader, rand) -> new MerchantOffer(
					new ItemCost(Gavv_Rider_Items.HEATPRESS, 1),
					new ItemStack(Gavv_Rider_Items.DOPPUDDING_GOCHIZO.get(), 1), 10, 8, 0.02F));
			trades.get(1).add((trader, rand) -> new MerchantOffer(
					new ItemCost(Gavv_Rider_Items.HEATPRESS, 2),
					new ItemStack(Gavv_Rider_Items.PURUJELLY_GOCHIZO.get(), 1), 10, 8, 0.02F));
			}
			else if (event.getType() == RiderVillagers.CANDYSHOP_VILLAGER.get()) {
				trades.get(1).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 1),
						new ItemStack(Modded_item_core.DANGO.get(), 2), 10, 8, 0.02F));
				trades.get(3).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 1),
						new ItemStack(Modded_item_core.PUDDING.get(), 1), 10, 8, 0.02F));
				trades.get(1).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 1),
						new ItemStack(Modded_item_core.GUMMI_CANDY.get(), 1), 10, 8, 0.02F));
				trades.get(1).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 1),
						new ItemStack(Modded_item_core.POTATO_SNACKS.get(), 1), 10, 8, 0.02F));
				trades.get(2).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 1),
						new ItemStack(Modded_item_core.CHOCOLATE_BAR.get(), 1), 10, 8, 0.02F));
				trades.get(2).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 1),
						new ItemStack(Modded_item_core.LOLLIPOP.get(), 1), 10, 8, 0.02F));
				trades.get(2).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 1),
						new ItemStack(Miscellaneous_Rider_Items.CANDY.get(), 1), 10, 8, 0.02F));
				trades.get(1).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 1),
						new ItemStack(Modded_item_core.MARSHMALLOW.get(), 1), 10, 8, 0.02F));
				trades.get(1).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 1),
						new ItemStack(Items.COOKIE, 1), 10, 8, 0.02F));
				trades.get(2).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 1),
						new ItemStack(Modded_item_core.CORN_SNACK.get(), 1), 10, 8, 0.02F));
				trades.get(3).add((trader, rand) -> new MerchantOffer(
						new ItemCost(Items.EMERALD, 1),
						new ItemStack(Modded_item_core.MAYO.get(), 1), 10, 8, 0.02F));
		}
		}

	}
	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ElementaryInvesModel.LAYER_LOCATION, ElementaryInvesModel::createBodyLayer);
		event.registerLayerDefinition(HeartRoidmudeModel.LAYER_LOCATION, HeartRoidmudeModel::createBodyLayer);
	}

	@SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
		event.put(MobsCore.SHOCKER_COMBATMAN.get(), ShockerCombatmanEntity.setAttributes().build());
		event.put(MobsCore.SHOCKER_RIDER.get(), ShockerRidersEntity.setAttributes().build());
		event.put(MobsCore.DESTRON_COMBATMAN.get(), DestronCombatmanEntity.setAttributes().build());
		event.put(MobsCore.GOD_WARFARE_AGENT.get(), GODWarfareAgentEntity.setAttributes().build());
		event.put(MobsCore.RED_FOLLWER.get(), RedFollowerEntity.setAttributes().build());
		event.put(MobsCore.BLACK_SATAN_SOLDIER.get(), BlackSatanSoldierEntity.setAttributes().build());
		event.put(MobsCore.ARI_COMMANDO.get(), AriCommandoEntity.setAttributes().build());
		event.put(MobsCore.DOGMA_FIGHTER.get(), DogmaFighterEntity.setAttributes().build());
		event.put(MobsCore.COMBAT_ROID.get(), CombatRoidEntity.setAttributes().build());
		event.put(MobsCore.CHAP.get(), ChapEntity.setAttributes().build());
		event.put(MobsCore.CHAP_GREY.get(), ChapGreyEntity.setAttributes().build());
		event.put(MobsCore.SHADOWMOON.get(), ShadowmoonEntity.setAttributes().build());

		event.put(MobsCore.ZU_GUMUN_BA.get(), ZuGumunBaEntity.setAttributes().build());

		event.put(MobsCore.PANTHERAS_LUTEUS.get(), PantherasLuteusEntity.setAttributes().build());
		event.put(MobsCore.EL_OF_THE_WATER.get(), ElOfTheWaterEntity.setAttributes().build());
		event.put(MobsCore.ANGUIS_MASCULUS.get(), AnguisMasculusEntity.setAttributes().build());
		event.put(MobsCore.ANOTHER_AGITO.get(), AnotherAgitoEntity.setAttributes().build());

		event.put(MobsCore.RIOTROOPER.get(), RiotrooperEntity.setAttributes().build());
		event.put(MobsCore.ORGA.get(), OrgaEntity.setAttributes().build());
		event.put(MobsCore.MUEZ.get(), MuezEntity.setAttributes().build());

		event.put(MobsCore.ZECTROOPER.get(), ZectrooperEntity.setAttributes().build());
		event.put(MobsCore.SHADOW_TROOPER.get(), ShadowTrooperEntity.setAttributes().build());
		event.put(MobsCore.NEOTROOPER.get(), NeotrooperEntity.setAttributes().build());
		event.put(MobsCore.CAUCASUS.get(), CaucasusEntity.setAttributes().build());

		event.put(MobsCore.NEW_MOLE_IMAGIN.get(), NewMoleImaginEntity.setAttributes().build());
		event.put(MobsCore.NEW_MOLE_IMAGIN_SAND.get(), NewMoleImaginSandEntity.setAttributes().build());
		event.put(MobsCore.GAOH.get(), GaohEntity.setAttributes().build());
		event.put(MobsCore.MOMOTAROS.get(), MomotarosEntity.setAttributes().build());
		event.put(MobsCore.URATAROS.get(), UratarosEntity.setAttributes().build());
		event.put(MobsCore.KINTAROS.get(), KintarosEntity.setAttributes().build());
		event.put(MobsCore.RYUTAROS.get(), RyutarosEntity.setAttributes().build());

		event.put(MobsCore.MASQUERADE.get(), MasqueradeEntity.setAttributes().build());
		event.put(MobsCore.CLAYDOLL_DOPANT.get(), ClayDollDopantEntity.setAttributes().build());
		event.put(MobsCore.TERROR_DOPANT.get(), TerrorDopantEntity.setAttributes().build());
		event.put(MobsCore.NASCA_DOPANT.get(), NazcaDopantEntity.setAttributes().build());
		// event.put(MobsCore.RED_NASCA_DOPANT.get(),RedNazcaDopantEntity.setAttributes().build());
		event.put(MobsCore.SMILODON_DOPANT.get(), SmilodonDopantEntity.setAttributes().build());
		event.put(MobsCore.WEATHER_DOPANT.get(), WeatherDopantEntity.setAttributes().build());

		event.put(MobsCore.FOUNDATION_X_MASQUERADE.get(), FoundationXMasqueradeEntity.setAttributes().build());
		event.put(MobsCore.COMMANDER_DOPANT.get(), CommanderDopantEntity.setAttributes().build());
		event.put(MobsCore.ETERNAL.get(), EternalEntity.setAttributes().build());

		event.put(MobsCore.MUCHIRI.get(), MuchiriEntity.setAttributes().build());
		event.put(MobsCore.YUMMY.get(), YummyEntity.setAttributes().build());
		event.put(MobsCore.KNIGHT_SOLDIER.get(), KnightSoldierEntity.setAttributes().build());
		event.put(MobsCore.ANKH.get(), AnkhEntity.setAttributes().build());

		event.put(MobsCore.ANKHCOMPLETE.get(), AnkhCompleteEntity.setAttributes().build());
		event.put(MobsCore.ANKH_LOST.get(), AnkhLostEntity.setAttributes().build());
		event.put(MobsCore.UVA.get(), UvaEntity.setAttributes().build());
		event.put(MobsCore.KAZARI.get(), KazariEntity.setAttributes().build());
		event.put(MobsCore.MEZOOL.get(), MezoolEntity.setAttributes().build());
		event.put(MobsCore.GAMEL.get(), GamelEntity.setAttributes().build());
		event.put(MobsCore.POSEIDON.get(), PoseidonEntity.setAttributes().build());
		event.put(MobsCore.CORE.get(), CoreEntity.setAttributes().build());
		event.put(MobsCore.POWERED_UP_CORE.get(), PoweredUpCoreEntity.setAttributes().build());
		event.put(MobsCore.ANCIENT_OOO.get(), AncientOOOEntity.setAttributes().build());

		event.put(MobsCore.GODA.get(), GodaEntity.setAttributes().build());
		event.put(MobsCore.TAKA_CAN.get(), TakaCanEntity.setAttributes().build());
		event.put(MobsCore.TAKO_CAN.get(), TakoCanEntity.setAttributes().build());
		event.put(MobsCore.BATTA_CAN.get(), BattaCanEntity.setAttributes().build());
		event.put(MobsCore.TORA_CAN.get(), ToraCanEntity.setAttributes().build());
		event.put(MobsCore.DENKIUNAGI_CAN.get(), DenkiunagiCanEntity.setAttributes().build());
		event.put(MobsCore.GORILLA_CAN.get(), GorillaCanEntity.setAttributes().build());
		event.put(MobsCore.KUJAKU_CAN.get(), KujakuCanEntity.setAttributes().build());
		event.put(MobsCore.PTERA_CAN.get(), PteraCanEntity.setAttributes().build());
		event.put(MobsCore.TORIKERA_CAN.get(), TorikeraCanEntity.setAttributes().build());

		event.put(MobsCore.SUPER_GINGAOH.get(), SuperGingaOhEntity.setAttributes().build());

		event.put(MobsCore.GHOULS.get(), GhoulsEntity.setAttributes().build());
		event.put(MobsCore.MEDUSA_PHANTOM.get(), MedusaPhantomEntity.setAttributes().build());
		event.put(MobsCore.PHOENIX_PHANTOM.get(), PhoenixPhantomEntity.setAttributes().build());
		event.put(MobsCore.GREMLIN_PHANTOM.get(), GremlinPhantomEntity.setAttributes().build());
		event.put(MobsCore.MAGE_FOOTSOLDIER.get(), MageFootsoldierEntity.setAttributes().build());
		event.put(MobsCore.MAGE_CAPTAIN.get(), MageCaptainEntity.setAttributes().build());
		event.put(MobsCore.SORCERER.get(), SorcererEntity.setAttributes().build());
		event.put(MobsCore.WISEMAN.get(), WisemanEntity.setAttributes().build());

		event.put(MobsCore.ELEMENTARY_INVES_RED.get(), ElementaryInvesRedEntity.setAttributes().build());
		event.put(MobsCore.KUROKAGE_TROOPER.get(), KurokageTrooperEntity.setAttributes().build());
		event.put(MobsCore.ZANGETSU_SHIN.get(), ZangetsuShinEntity.setAttributes().build());
		event.put(MobsCore.MARIKA.get(), MarikaEntity.setAttributes().build());
		event.put(MobsCore.DUKE.get(), DukeEntity.setAttributes().build());
		event.put(MobsCore.SIGURD.get(), SigurdEntity.setAttributes().build());
		event.put(MobsCore.ROSYUO.get(), RosyuoEntity.setAttributes().build());
		event.put(MobsCore.REDYUE.get(), RedyueEntity.setAttributes().build());
		event.put(MobsCore.DEMUSHU.get(), DemushuEntity.setAttributes().build());
		event.put(MobsCore.LORD_BARON.get(), LordBaronEntity.setAttributes().build());

		event.put(MobsCore.ROIDMUDE.get(), RoidmudeEntity.setAttributes().build());
		event.put(MobsCore.REAPER_LEGION.get(), ReaperlegionEntity.setAttributes().build());
		event.put(MobsCore.MASHIN_CHASER.get(), MashinChaserEntity.setAttributes().build());
		event.put(MobsCore.HEART_ROIDMUDE.get(), HeartRoidmudeEntity.setAttributes().build());
		event.put(MobsCore.BRAIN_ROIDMUDE.get(), BrainRoidmudeEntity.setAttributes().build());
		event.put(MobsCore.MEDIC_ROIDMUDE.get(), MedicRoidmudeEntity.setAttributes().build());
		event.put(MobsCore.GORD_DRIVE.get(), GordDriveEntity.setAttributes().build());
		event.put(MobsCore.DARK_DRIVE.get(), DarkDriveEntity.setAttributes().build());

		event.put(MobsCore.GAMMA_COMMANDO.get(), GammaCommandoEntity.setAttributes().build());

		event.put(MobsCore.BUGSTERVIRUS.get(), BugsterVirusEntity.setAttributes().build());
		event.put(MobsCore.NEBULA_BUGSTERVIRUS.get(), BugsterVirusEntity.setAttributes().build());
		//event.put(MobsCore.MIGHTY_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.TADDLE_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.BANG_BANG_BUGSTER.get(), GodaEntity.setAttributes().build());
		//	event.put(MobsCore.LOVELY_BUGSTER.get(), LovelyBugsterEntity.setAttributes().build());
		//event.put(MobsCore.SALTY_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.CHARLIE_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.VERNIER_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.GATTON_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.KAIDEN_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.MOTORS_BUGSTER.get(), GodaEntity.setAttributes().build());
		event.put(MobsCore.GRAPHITE_BUGSTER.get(), GraphiteBugsterEntity.setAttributes().build());
		//event.put(MobsCore.ARANBURA_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.REVOL_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.LOVELICA_BUGSTER.get(), LovelicaBugsterEntity.setAttributes().build());
		event.put(MobsCore.GENM.get(), GenmEntity.setAttributes().build());
		event.put(MobsCore.POPPY_RED.get(), PoppyRedEntity.setAttributes().build());
		event.put(MobsCore.RIDEPLAYER.get(), RideplayerEntity.setAttributes().build());
		event.put(MobsCore.PARADX.get(), ParaDxEntity.setAttributes().build());
		event.put(MobsCore.CRONUS.get(), CronusEntity.setAttributes().build());

		event.put(MobsCore.HOKUTOGUARDIAN.get(), HokutoGuardianEntity.setAttributes().build());
		event.put(MobsCore.TOUTOGUARDIAN.get(), GuardianEntity.setAttributes().build());
		event.put(MobsCore.SEITOGUARDIAN.get(), SeitoGuardianEntity.setAttributes().build());
		event.put(MobsCore.HARD_GUARDIAN.get(), HardGuardianEntity.setAttributes().build());
		event.put(MobsCore.DOWNFALL_GUARDIAN.get(), DownfallGuardianEntity.setAttributes().build());
		event.put(MobsCore.PHANTOM_CRUSHER.get(), PhantomCrusherEntity.setAttributes().build());
		event.put(MobsCore.SMASH.get(), SmashEntity.setAttributes().build());
		event.put(MobsCore.BLOOD_STALK.get(), BloodStalkEntity.setAttributes().build());
		event.put(MobsCore.NIGHT_ROGUE.get(), NightRogueEntity.setAttributes().build());
		event.put(MobsCore.GREASE.get(), GreaseEntity.setAttributes().build());
		event.put(MobsCore.BUILD.get(), BuildEntity.setAttributes().build());
		event.put(MobsCore.EVOL.get(), EvolEntity.setAttributes().build());
		event.put(MobsCore.KILLBUS.get(), EvolEntity.setAttributes().build());
		event.put(MobsCore.STAG_LOST_SMASH.get(), StagLostSmashEntity.setAttributes().build());
		event.put(MobsCore.OWL_LOST_SMASH.get(), OwlLostSmashEntity.setAttributes().build());
		event.put(MobsCore.CASTLE_LOST_SMASH.get(), CastleLostSmashEntity.setAttributes().build());
		event.put(MobsCore.ENGINE_BROS.get(), EngineBrosEntity.setAttributes().build());
		event.put(MobsCore.REMOCON_BROS.get(), RemoconBrosEntity.setAttributes().build());
		event.put(MobsCore.MAD_ROGUE.get(), MadRogueEntity.setAttributes().build());
		event.put(MobsCore.KAISER.get(), KaiserEntity.setAttributes().build());
		event.put(MobsCore.KAISER_REVERSE.get(), KaiserReverseEntity.setAttributes().build());
		event.put(MobsCore.BIKAISER.get(), KaiserEntity.setAttributes().build());

		event.put(MobsCore.GINGA.get(), GingaEntity.setAttributes().build());
		event.put(MobsCore.WOZ.get(), GingaEntity.setAttributes().build());

		event.put(MobsCore.TRILOBITE_MAGIA.get(), TrilobiteMagiaEntity.setAttributes().build());
		event.put(MobsCore.DODO_MAGIA_CHICK.get(), DodoMagiaChickEntity.setAttributes().build());
		event.put(MobsCore.BATTLE_RAIDER.get(), BattleRaiderEntity.setAttributes().build());
		event.put(MobsCore.ABADDON.get(), AbaddonEntity.setAttributes().build());
		event.put(MobsCore.MAGIA.get(), MagiaEntity.setAttributes().build());
		event.put(MobsCore.GIGER.get(), GigerEntity.setAttributes().build());
		event.put(MobsCore.HOROBI.get(), HorobiEntity.setAttributes().build());
		event.put(MobsCore.JIN.get(), JinEntity.setAttributes().build());
		event.put(MobsCore.IKAZUCHI.get(), IkazuchiEntity.setAttributes().build());
		event.put(MobsCore.NAKI.get(), NakiEntity.setAttributes().build());
		event.put(MobsCore.DODO_MAGIA.get(), DodoMagiaEntity.setAttributes().build());
		event.put(MobsCore.RAIDER.get(), RaiderEntity.setAttributes().build());
		event.put(MobsCore.ARK_ZERO.get(), ArkZeroEntity.setAttributes().build());
		event.put(MobsCore.ABADDON_COMMANDER.get(), AbaddonCommanderEntity.setAttributes().build());
		event.put(MobsCore.EDEN.get(), EdenEntity.setAttributes().build());
		event.put(MobsCore.ZAIA.get(), ZaiaEntity.setAttributes().build());
		event.put(MobsCore.DIRE_WOLF_SOLD_MAGIA.get(), DireWolfSoldMagiaEntity.setAttributes().build());
		event.put(MobsCore.SERVAL_TIGER_SOLD_MAGIA.get(), ServalTigerSoldMagiaEntity.setAttributes().build());

		event.put(MobsCore.SHIMI.get(), ShimiEntity.setAttributes().build());
		event.put(MobsCore.CALIBUR.get(), CaliburEntity.setAttributes().build());
		event.put(MobsCore.FALCHION.get(), FalchionEntity.setAttributes().build());
		event.put(MobsCore.SABELA.get(), SabelaEntity.setAttributes().build());
		event.put(MobsCore.DURENDAL.get(), DurendalEntity.setAttributes().build());
		event.put(MobsCore.SOLOMON.get(), SolomonEntity.setAttributes().build());
		event.put(MobsCore.STORIOUS_RIDER.get(), StoriousRiderEntity.setAttributes().build());
		event.put(MobsCore.LEGEIEL.get(), LegeielEntity.setAttributes().build());
		event.put(MobsCore.LEGEIEL_FORBIDDEN.get(), LegeielForbiddenEntity.setAttributes().build());
		event.put(MobsCore.ZOOOUS.get(), ZooousEntity.setAttributes().build());
		event.put(MobsCore.ZOOOUS_PREDATOR.get(), ZooousPredatorEntity.setAttributes().build());
		event.put(MobsCore.STORIOUS.get(), StoriousEntity.setAttributes().build());
		event.put(MobsCore.DESAST.get(), DesastEntity.setAttributes().build());
		event.put(MobsCore.CHARYBDIS.get(), CharybdisEntity.setAttributes().build());
		event.put(MobsCore.CHARYBDIS_HERCULES.get(), CharybdisHerculesEntity.setAttributes().build());

		event.put(MobsCore.GIFF_JUNIOR.get(), GiffJuniorEntity.setAttributes().build());
		event.put(MobsCore.EVIL.get(), EvilEntity.setAttributes().build());
		event.put(MobsCore.DAIOUIKA_DEADMAN.get(), DaiouikaDeadmanEntity.setAttributes().build());
		event.put(MobsCore.ANOMALOCARIS_DEADMAN.get(), AnomalocarisDeadmanEntity.setAttributes().build());
		event.put(MobsCore.QUEEN_BEE_DEADMAN.get(), QueenBeeDeadmanEntity.setAttributes().build());
		event.put(MobsCore.WOLF_DEADMAN.get(), WolfDeadmanEntity.setAttributes().build());
		event.put(MobsCore.CRIMSON_VAIL.get(), VailEntity.setAttributes().build());

		event.put(MobsCore.PAWN_JYAMATO.get(), PawnJyamatoEntity.setAttributes().build());
		event.put(MobsCore.JYAMATO_RIDER.get(), JyamatoRiderEntity.setAttributes().build());
		event.put(MobsCore.GM_RIDER.get(), GmRiderEntity.setAttributes().build());
		event.put(MobsCore.GLARE.get(), GlareEntity.setAttributes().build());
		event.put(MobsCore.GLARE2.get(), Glare2Entity.setAttributes().build());
		event.put(MobsCore.GAZER.get(), GazerEntity.setAttributes().build());
		event.put(MobsCore.END_RIDER.get(), EndRiderEntity.setAttributes().build());
		event.put(MobsCore.PREMIUM_BEROBA.get(), PremiumBerobaEntity.setAttributes().build());
		event.put(MobsCore.PREMIUM_KEKERA.get(), PremiumKekeraEntity.setAttributes().build());

		event.put(MobsCore.AGENT.get(), AgentEntity.setAttributes().build());
		event.put(MobsCore.BITTER_GAVV.get(), BitterGavvEntity.setAttributes().build());
		event.put(MobsCore.NYELV_STOMACH.get(), NyelvEntity.setAttributes().build());
		event.put(MobsCore.GLOTTA_STOMACH.get(), GlottaEntity.setAttributes().build());
		event.put(MobsCore.JEEB_STOMACH.get(), JeebEntity.setAttributes().build());
		event.put(MobsCore.SHIITA_STOMACH.get(), ShiitaEntity.setAttributes().build());
		event.put(MobsCore.LANGO_STOMACH.get(), LangoEntity.setAttributes().build());

		event.put(MobsCore.ACROBATTER.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.RIDORON.get(), RidoronEntity.setAttributes().build());
		event.put(MobsCore.MACEHINE_TORADOR.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.MACEHINE_DENBIRD.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.HARDBOILER.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.SKULLBOILER.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.ACCEL_BIKE_FORM.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.RIDEVENDOR.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.RIDEVENDOR_VENDING_MODE.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.MACEHINE_MASSIGLER.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.TORIDEVENDOR.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.BIKE_GAMER.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.SAKURA_HURRICANE.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.ROSE_ATTACKER.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.MACEHINE_BUILDER.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.RIDESTRIKER.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.RISEHOPPER.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.DIAGOSPEEDY.get(), baseBikeEntity.setAttributes().build());

		event.put(MobsCore.RIDER_SUMMON.get(), RiderSummonEntity.setAttributes().build());
		event.put(MobsCore.COMPLETE_SUMMON.get(), CompleteSummonEntity.setAttributes().build());
		event.put(MobsCore.GRAND_SUMMON.get(), GrandSummonEntity.setAttributes().build());
		event.put(MobsCore.PARADX_SUMMON.get(), ParaDXSummonEntity.setAttributes().build());
		event.put(MobsCore.DECADE_ARMOR_EX_AID.get(), DecadeArmorExAidEntity.setAttributes().build());
		event.put(MobsCore.VICE.get(), ViceEntity.setAttributes().build());
		event.put(MobsCore.LOVEKOV.get(), LovekovEntity.setAttributes().build());
		event.put(MobsCore.WHIPPED_SOLDIER.get(), WhippedSoldierEntity.setAttributes().build());

	}

	@SubscribeEvent
	public static void entitySpawnRestriction(RegisterSpawnPlacementsEvent event) {
		event.register(MobsCore.SHOCKER_COMBATMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);


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

		event.register(MobsCore.ZECTROOPER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.SHADOW_TROOPER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.NEOTROOPER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.NEW_MOLE_IMAGIN_SAND.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.MASQUERADE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.FOUNDATION_X_MASQUERADE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.YUMMY.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.GHOULS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.MAGE_FOOTSOLDIER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.MAGE_CAPTAIN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.ELEMENTARY_INVES_RED.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.GAMMA_COMMANDO.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.ROIDMUDE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.REAPER_LEGION.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.BUGSTERVIRUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.NEBULA_BUGSTERVIRUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		//	event.register(MobsCore.LOVELY_BUGSTER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.RIDEPLAYER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.TOUTOGUARDIAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.SEITOGUARDIAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.HOKUTOGUARDIAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.DOWNFALL_GUARDIAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.HARD_GUARDIAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);


		event.register(MobsCore.TRILOBITE_MAGIA.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.DODO_MAGIA_CHICK.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.BATTLE_RAIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.ABADDON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.SHIMI.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.CHARYBDIS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		
		event.register(MobsCore.GIFF_JUNIOR.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.PAWN_JYAMATO.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.JYAMATO_RIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.GM_RIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.END_RIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
		event.register(MobsCore.KUROKAGE_TROOPER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

		event.register(MobsCore.AGENT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);


		event.register(MobsCore.ANKH.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AnkhEntity::checkAnkhSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);


	}
}
