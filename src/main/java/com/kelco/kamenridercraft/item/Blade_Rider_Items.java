package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;

import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Blade_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> BLADE_LOGO = ITEMS.register("blade_logo",
			() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/blade")), new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));


	public static final DeferredItem<Item> BLADECARD = ITEMS.register("bladecard",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));
	public static final DeferredItem<Item> PROPER_BLANK_UPPER = ITEMS.register("proper_blank_upper",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.BLADE_TAB_ITEM));
	public static final DeferredItem<Item> PROPER_BLANK_ROYAL = ITEMS.register("proper_blank_royal",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.BLADE_TAB_ITEM));
	public static final DeferredItem<Item> PROPER_BLANK_ACE_WILD = ITEMS.register("proper_blank_ace_wild",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.BLADE_TAB_ITEM));
	public static final DeferredItem<Item> VANITY_BLANK = ITEMS.register("vanity_blank",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> ROUZE_ABSORBER = ITEMS.register("rouze_absorber",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.BLADE_TAB_ITEM));


	public static final DeferredItem<Item> CHANGE_BEETLE = ITEMS.register("change_beetle",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "", "blade", "blay_buckle_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}
					.AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> SLASH_LIZARD = ITEMS.register("slash_lizard",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> BEAT_LION = ITEMS.register("beat_lion",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> TACKLE_BOAR = ITEMS.register("tackle_boar",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> KICK_LOCUST = ITEMS.register("kick_locust",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> THUNDER_DEER = ITEMS.register("thunder_deer",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> METAL_TRILOBITE = ITEMS.register("metal_trilobite",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> MAGNET_BUFFALO = ITEMS.register("magnet_buffalo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> MACH_JAGUAR = ITEMS.register("mach_jaguar",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> TIME_SCARAB = ITEMS.register("time_scarab",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> SEALABLE_FUSION_EAGLE= ITEMS.register("sealable_fusion_eagle",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "_eagle", "undead", "sealable_undead_buckle_royal_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			});

	public static final DeferredItem<Item> FUSION_EAGLE_UNDEAD = ITEMS.register("fusion_eagle_undead",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "_eagle", "undead", "unsealed_undead_buckle_royal_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addSwitchForm(SEALABLE_FUSION_EAGLE.get()));

	public static final DeferredItem<Item> FUSION_EAGLE = ITEMS.register("fusion_eagle",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), 0, "_jack", "blade", "blay_buckle_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}
					.addAlternative(FUSION_EAGLE_UNDEAD.get()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> ABSORB_CAPRICORN = ITEMS.register("absorb_capricorn",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> EVOLUTION_CAUCASUS = ITEMS.register("evolution_caucasus",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE), 0, "_king", "blade", "blay_buckle_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 300, 0, 0, 0, 1);
				}
			}
					.addNeedItem(ROUZE_ABSORBER.get()).addNeedItem(ABSORB_CAPRICORN.get())
					.AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> SILVER_EVOLUTION_CAUCASUS = ITEMS.register("silver_evolution_caucasus",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE), 0, "_silver_king", "blade", "blay_buckle_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 300, 0, 0, 0, 1);
				}
			}
					.addNeedItem(ROUZE_ABSORBER.get()).addNeedItem(ABSORB_CAPRICORN.get())
					.AddToList(RiderTabs.BLADE_TAB_ITEM));


	public static final DeferredItem<Item> CHANGE_STAG = ITEMS.register("change_stag",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "", "garren", "garren_buckle_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}
					.AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> BULLET_ARMADILLO = ITEMS.register("bullet_armadillo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> UPPER_FROG = ITEMS.register("upper_frog",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> RAPID_PECKER = ITEMS.register("rapid_pecker",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> DROP_WHALE = ITEMS.register("drop_whale",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> ROUZE_FIREFLY = ITEMS.register("rouze_firefly",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> ROCK_TORTOISE = ITEMS.register("rock_tortoise",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> SCOPE_BAT = ITEMS.register("scope_bat",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> GEMINI_ZEBRA = ITEMS.register("gemini_zebra",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> THIEF_CHAMELEON = ITEMS.register("thief_chameleon",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> FUSION_PEACOCK = ITEMS.register("fusion_peacock",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), 0, "_jack", "garren", "garren_buckle_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}
					.addNeedItem(ROUZE_ABSORBER.get()).hasFlyingWings(null).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> ABSORB_SERPENT = ITEMS.register("absorb_serpent",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> EVOLUTION_GIRAFFA = ITEMS.register("evolution_giraffa",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), 0, "_king", "garren", "garren_buckle_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 300, 0, 0, 0, 1);
				}
			}
					.addNeedItem(ROUZE_ABSORBER.get()).addNeedItem(ABSORB_SERPENT.get())
					.AddToList(RiderTabs.BLADE_TAB_ITEM));

//	public static final DeferredItem<Item> ULTIMATE_SPECIAL_TURBO = ITEMS.register("ultimate_turbo",
//			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ultimate_form_special_turbo","taiyaki_master","blank",
//					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
//					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
//					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
//					,new MobEffectInstance(Effect_core.FIRE_SLASH, 40, 1,true,false)
//					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
//				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
//					super.OnTransformation(itemstack, player);
//					((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
//							player.getX(), player.getY()+1,
//							player.getZ(), 100, 0, 0, 0, 1);
//				}
//			}.SetShowUnder());
//
//	public static final DeferredItem<Item> TAIYAKI_MASTER = ITEMS.register("taiyaki_master",
//			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ultimate_form","taiyaki_master","blank",
//					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)
//					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
//					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
//				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
//					super.OnTransformation(itemstack, player);
//					((ServerLevel) player.level()).sendParticles(ParticleTypes.RAIN,
//							player.getX(), player.getY()+1,
//							player.getZ(), 100, 0, 0, 0, 1);
//				}
//			}.addSwitchForm(ULTIMATE_SPECIAL_TURBO.get()).SetShowUnder());
//
//	public static final DeferredItem<Item> CHANGE_MANTIS = ITEMS.register("change_mantis",
//			() -> new RiderFormChangeItem(new Item.Properties(), 0, "", "chalice", "chalice_rouzer_belt",
//					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
//					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1, true, false),
//					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false)){
//				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
//					super.OnTransformation(itemstack, player);
//					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
//							player.getX(), player.getY()+1,
//							player.getZ(), 100, 0, 0, 0, 1);
//				}
//			}.addAlternative(TAIYAKI_MASTER.get()).addAlternative(ULTIMATE_SPECIAL_TURBO.get()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> TAIYAKI_MASTER = ITEMS.register("taiyaki_master",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ultimate_form","taiyaki_master","blank",
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.RAIN,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.SetShowUnder());

	public static final DeferredItem<Item> CHANGE_MANTIS = ITEMS.register("change_mantis",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "", "chalice", "chalice_rouzer_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addAlternative(TAIYAKI_MASTER.get()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> CHALICE_ROUZE_SPIRIT_STEVE = ITEMS.register("chalice_rouze_spirit_steve",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "_human_steve", "chalice", "chalice_rouzer_belt",
					new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 40, 0, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			});

	public static final DeferredItem<Item> CHALICE_ROUZE_SPIRIT = ITEMS.register("chalice_rouze_spirit",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "_human", "chalice", "chalice_rouzer_belt",
					new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 40, 0, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addSwitchForm(CHALICE_ROUZE_SPIRIT_STEVE.get()));

	public static final DeferredItem<Item> SEALABLE_ROUZE_SPIRIT = ITEMS.register("sealable_rouze_spirit",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "_human", "undead", "sealable_undead_buckle_belt",
					new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 40, 4, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			});


	public static final DeferredItem<Item> ROUZE_SPIRIT = ITEMS.register("rouze_spirit",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "_human", "undead", "unsealed_undead_buckle_belt",
					new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 40, 4, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addSwitchForm(SEALABLE_ROUZE_SPIRIT.get()).addAlternative(CHALICE_ROUZE_SPIRIT.get()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> CHOP_HEAD = ITEMS.register("chop_head",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> FLOAT_DRAGONFLY = ITEMS.register("float_dragonfly",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> DRILL_SHELL = ITEMS.register("drill_shell",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> TORDANDO_HAWK = ITEMS.register("tornado_hawk",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> BIO_PLANT = ITEMS.register("bio_plant",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> REFLECT_MOTH = ITEMS.register("reflect_moth",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> RECOVER_CAMEL = ITEMS.register("recover_camel",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> SHUFFLE_CENTIPEDE = ITEMS.register("shuffle_centipede",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> FUSION_WOLF = ITEMS.register("fusion_wolf",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> ABSORB_ORCHID = ITEMS.register("absorb_orchid",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> EVOLUTION_PARADOXA = ITEMS.register("evolution_paradoxa",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), 0, "_wild", "chalice", "chalice_rouzer_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 300, 0, 0, 0, 1);
				}
			}
					.AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> CHANGE_SPIDER = ITEMS.register("change_spider",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "", "leangle", "leangle_buckle_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}
					.AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> CHANGE_SPIDER_PROPER_SEAL = ITEMS.register("change_spider_proper_seal",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "", "leangle", "leangle_buckle_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> STAB_BEE = ITEMS.register("stab_bee",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> SCREW_MOLE = ITEMS.register("screw_mole",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> RUSH_RHINOCEROS = ITEMS.register("rush_rhinoceros",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> BITE_COBRA  = ITEMS.register("bite_cobra",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> BLIZZARD_POLAR = ITEMS.register("blizzard_polar",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> GEL_JELLYFISH = ITEMS.register("gel_jellyfish",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> POISON_SCORPION = ITEMS.register("poison_scorpion",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> SMOG_SQUID = ITEMS.register("smog_squid",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> REMOTE_TAPIR = ITEMS.register("remote_tapir",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> FUSION_ELEPHANT = ITEMS.register("fusion_elephant",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), 0, "_jack", "leangle", "leangle_buckle_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}
					.addNeedItem(ROUZE_ABSORBER.get()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> ABSORB_TIGER = ITEMS.register("absorb_tiger",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> EVOLUTION_TARANTULA = ITEMS.register("evolution_tarantula",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), 0, "_king", "leangle", "leangle_buckle_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 300, 0, 0, 0, 1);
				}
			}
					.addNeedItem(ROUZE_ABSORBER.get()).addNeedItem(ABSORB_TIGER.get())
					.AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> CHANGE_KERBEROS_GLAIVE = ITEMS.register("change_kerberos_glaive",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "", "glaive", "glaive_buckle_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}
					.AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> CHANGE_KERBEROS_LANCE = ITEMS.register("change_kerberos_lance",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "", "lance", "lance_buckle_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}
					.AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> CHANGE_KERBEROS_LARC = ITEMS.register("change_kerberos_larc",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "", "larc", "larc_buckle_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}
					.AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> MIGHTY_GRAVITY = ITEMS.register("mighty_gravity",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> MIGHTY_IMPACT = ITEMS.register("mighty_impact",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> MIGHTY_RAY = ITEMS.register("mighty_ray",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));



	public static final DeferredItem<Item> BLACK_JOKER_SEALED = ITEMS.register("black_joker_sealed",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));
//	public static final DeferredItem<Item> BLACK_JOKER_SEALED = ITEMS.register("black_joker_sealed",
//			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC), 0, "", "black_joker", "black_joker_buckle_belt",
//					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
//					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false)){
//				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
//					super.OnTransformation(itemstack, player);
//					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
//							player.getX(), player.getY()+1,
//							player.getZ(), 300, 0, 0, 0, 1);
//				}
//			}
//					.AddToList(RiderTabs.BLADE_TAB_ITEM));


	public static final DeferredItem<Item> ALBINO_JOKER_SEALED = ITEMS.register("albino_joker_sealed",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM));
//	public static final DeferredItem<Item> ALBINO_JOKER_SEALED = ITEMS.register("albino_joker_sealed",
//			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC), 0, "", "albino_joker", "albino_joker_buckle_belt",
//					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
//					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false)){
//				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
//					super.OnTransformation(itemstack, player);
//					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
//							player.getX(), player.getY()+1,
//							player.getZ(), 300, 0, 0, 0, 1);
//				}
//			}
//					.AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> VANITY_SEALED = ITEMS.register("vanity_sealed",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> JASHIN_FOURTEEN_SEALED = ITEMS.register("jashin_fourteen_sealed",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.EPIC)).AddToList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> BLADEHELMET = ITEMS.register("bladehead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> BLADECHESTPLATE = ITEMS.register("bladetroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> BLADELEGGINGS = ITEMS.register("bladelegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));


	public static final DeferredItem<Item> BLAYBUCKLE = ITEMS.register("blay_buckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "blade", CHANGE_BEETLE, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> GARRENBUCKLE = ITEMS.register("garren_buckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "garren", CHANGE_STAG, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> CHALICEROUZER = ITEMS.register("chalice_rouzer",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "chalice", CHANGE_MANTIS, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> LEANGLEBUCKLE = ITEMS.register("leangle_buckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "leangle", CHANGE_SPIDER, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> GLAIVEBUCKLE = ITEMS.register("glaive_buckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "glaive", CHANGE_KERBEROS_GLAIVE, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> LANCEBUCKLE = ITEMS.register("lance_buckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "lance", CHANGE_KERBEROS_LANCE, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> LARCBUCKLE = ITEMS.register("larc_buckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "larc", CHANGE_KERBEROS_LARC, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));



	public static final DeferredItem<Item> UNDEAD_ROUZER = ITEMS.register("undead_buckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "undead", ROUZE_SPIRIT, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
//	public static final DeferredItem<Item> BLACK_JOKER_UNDEAD_ROUZER = ITEMS.register("black_joker_undead_rouzer",
//			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "black_joker", BLACK_JOKER_SEALED, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
//	public static final DeferredItem<Item> ALBINO_JOKER_UNDEAD_ROUZER = ITEMS.register("albino_joker_undead_rouzer",
//			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "albino_joker", ALBINO_JOKER_SEALED, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> BLAYBUCKLE_FAKE = ITEMS.register("blay_buckle_fake",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "fake_blade", CHANGE_BEETLE, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties())
					.AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));

	public static final DeferredItem<Item> TAIYAKI_SECRET_WEAPON = ITEMS.register("taiyaki_secret_weapon",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "taiyaki_master" ,TAIYAKI_MASTER, CHANGE_BEETLE, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));


	public static final DeferredItem<Item> BLAYROUZER = ITEMS.register("blayrouzer",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToList(KamenRiderCraftCore.BLADE_CHANGING_ITEM).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> KINGROUZER = ITEMS.register("kingrouzer",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> GARRENROUZER = ITEMS.register("garrenrouzer",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
//	public static final DeferredItem<Item> GARREN_KINGROUZER = ITEMS.register("garren_kingrouzer",
//			() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> CHALICE_ARROW = ITEMS.register("chalice_arrow",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> WILD_SLASHER = ITEMS.register("wild_slasher",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> WILD_CHALICE_ARROW = ITEMS.register("wild_chalice_arrow",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties().rarity(Rarity.RARE)).setProjectile(BaseBlasterItem.BlasterProjectile.SMALL_FIREBALL).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> LEANGLEROUZER = ITEMS.register("leanglerouzer",
			() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
//	public static final DeferredItem<Item> LEANGLE_KINGROUZER = ITEMS.register("leangle_kingrouzer",
//			() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> GLAIVEROUZER = ITEMS.register("glaiverouzer",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> LANCEROUZER = ITEMS.register("lancerouzer",
			() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> LARCROUZER = ITEMS.register("larcrouzer",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));


	public static final DeferredItem<Item> DRAGONFLY_SOMERSAULT = ITEMS.register("dragonfly_somersault",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> JAGUAR_CLAWS = ITEMS.register("jaguar_claws",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -1.4F, new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> CAPRICORN_CRESCENT_EDGE = ITEMS.register("capricorn_crescent_edge",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -1.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> CAUCASUS_ALL_OVER = ITEMS.register("caucasus_all_over",
			() -> new BaseSwordItem(Tiers.DIAMOND, 13, -2.4F, new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> CAUCASUS_SOLID_SHIELD = ITEMS.register("caucasus_solid_shield",
			() -> new BaseShieldItem(new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> PEACOCK_SWORTHER = ITEMS.register("peacock_sworther",
			() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
//	public static final DeferredItem<Item> SERPENT_EVASISC = ITEMS.register("serpent_evasisc",
//			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> GIRAFFA_HELLTAR = ITEMS.register("giraffa_helltar",
			() -> new BaseSwordItem(Tiers.DIAMOND, 13, -2.4F, new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> GIRAFFA_SKELTAR = ITEMS.register("giraffa_skeltar",
			() -> new BaseSwordItem(Tiers.DIAMOND, 13, -2.4F, new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> JOKER_MANTIS = ITEMS.register("joker_mantis",
			() -> new BaseSwordItem(Tiers.DIAMOND, 19, -2.4F, new Item.Properties().rarity(Rarity.EPIC)).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> ALBINO_JOKER_DEATH_SCYTHE = ITEMS.register("albino_joker_death_scythe",
			() -> new BaseSwordItem(Tiers.DIAMOND, 19, -2.4F, new Item.Properties().rarity(Rarity.EPIC)).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
//	public static final DeferredItem<Item> MOLE_SHIELD = ITEMS.register("mole_shield",
//			() -> new BaseShieldItem(new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
//	public static final DeferredItem<Item> ELEPHANT_EARTHQUAKE = ITEMS.register("elephant_earthquake",
//			() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
//	public static final DeferredItem<Item> SPIDER_THREAD = ITEMS.register("spider_thread",
//			() -> new BaseSwordItem(Tiers.DIAMOND, 13, -2.4F, new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));

//	public static final DeferredItem<Item> JASHIN_SPADE_VLADE = ITEMS.register("jashin_spade_vlade",
//			() -> new BaseSwordItem(Tiers.DIAMOND, 19, -2.4F, new Item.Properties().rarity(Rarity.EPIC)).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
//	public static final DeferredItem<Item> JASHIN_DIA_SHIELD = ITEMS.register("jashin_dia_shield",
//			() -> new BaseShieldItem(new Item.Properties().rarity(Rarity.EPIC)).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
//	public static final DeferredItem<Item> JASHIN_HEART_THUNDER = ITEMS.register("jashin_heart_thunder",
//			() -> new BaseBlasterItem(Tiers.DIAMOND, 13, -2.4F, new Item.Properties().rarity(Rarity.EPIC)).setProjectile(BaseBlasterItem.BlasterProjectile.SMALL_FIREBALL).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
//	public static final DeferredItem<Item> JASHIN_CLOVER_CLUB = ITEMS.register("jashin_clover_club",
//			() -> new BaseSwordItem(Tiers.DIAMOND, 19, -2.4F, new Item.Properties().rarity(Rarity.EPIC)).AddToList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));


	public static final DeferredItem<Item> TAIYAKI_MOLD = ITEMS.register("taiyaki_mold",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToList(RiderTabs.BLADE_TAB_ITEM).KeepItem().ChangeRepairItem(BLADECARD.get()));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}