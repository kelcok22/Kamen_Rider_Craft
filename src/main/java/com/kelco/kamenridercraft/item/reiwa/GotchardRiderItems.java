package com.kelco.kamenridercraft.item.reiwa;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.*;
import com.kelco.kamenridercraft.item.heisei_phase_1.*;
import com.kelco.kamenridercraft.item.heisei_phase_2.*;
import com.kelco.kamenridercraft.item.reiwa.gotchard.*;
import com.kelco.kamenridercraft.particle.ModParticles;
import com.kelco.kamenridercraft.world.inventory.GotchandrawHolderGuiMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class GotchardRiderItems {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static String[] Gotchards = new String[] {"gotchard","gotchar_brother"};

	public static List<Item> NEED_ITEM_SteamHopper= new ArrayList<>();
	public static List<Item> NEED_ITEM_AppareSkebow= new ArrayList<>();
	public static List<Item> NEED_ITEM_VenomMariner= new ArrayList<>();
	public static List<Item> NEED_ITEM_AntWrestler= new ArrayList<>();
	public static List<Item> NEED_ITEM_BurningGorilla= new ArrayList<>();
	public static List<Item> NEED_ITEM_NeedleHawk= new ArrayList<>();
	public static List<Item> NEED_ITEM_DokkiriShovel= new ArrayList<>();
	public static List<Item> NEED_ITEM_GoldMechanichor= new ArrayList<>();
	public static List<Item> NEED_ITEM_HiikesuRose= new ArrayList<>();
	public static List<Item> NEED_ITEM_LightningJungle= new ArrayList<>();
	public static List<Item> NEED_ITEM_MarsPhoenix= new ArrayList<>();
	public static List<Item> NEED_ITEM_MarsPhoenix2= new ArrayList<>();

	public static List<Item> NEED_ITEM_Super= new ArrayList<>();
	public static List<Item> NEED_ITEM_Platina= new ArrayList<>();
	public static List<Item> NEED_ITEM_Rainbow= new ArrayList<>();
	public static List<Item> NEED_ITEM_Ultima= new ArrayList<>();
	public static List<Item> NEED_ITEM_Miracle= new ArrayList<>();
	public static List<Item> NEED_ITEM_LegendLiner= new ArrayList<>();

	public static List<Item> NEED_ITEM_OdoriMantis= new ArrayList<>();
	public static List<Item> NEED_ITEM_MadPilets= new ArrayList<>();
	public static List<Item> NEED_ITEM_EnergyMaru= new ArrayList<>();
	public static List<Item> NEED_ITEM_BulletChoucho= new ArrayList<>();
	public static List<Item> NEED_ITEM_SmaHotaru= new ArrayList<>();
	public static List<Item> NEED_ITEM_SpicleWhale= new ArrayList<>();
	public static List<Item> NEED_ITEM_BatKingRobo= new ArrayList<>();
	public static List<Item> NEED_ITEM_StagMirror= new ArrayList<>();
	public static List<Item> NEED_ITEM_GreatSasorry= new ArrayList<>();
	public static List<Item> NEED_ITEM_BunnyParka= new ArrayList<>();
	public static List<Item> NEED_ITEM_DoctorHebi= new ArrayList<>();
	public static List<Item> NEED_ITEM_BakuonTelevi= new ArrayList<>();
	public static List<Item> NEED_ITEM_OniCopter= new ArrayList<>();

	public static List<Item> NEED_ITEM_SunUnicorn= new ArrayList<>();
	public static List<Item> NEED_ITEM_MoonCerberus= new ArrayList<>();
	public static List<Item> NEED_ITEM_Twilight= new ArrayList<>();

	public static List<Item> NEED_ITEM_Valvarad= new ArrayList<>();
	public static List<Item> NEED_ITEM_OrochiShovel= new ArrayList<>();
	public static List<Item> NEED_ITEM_AngeCopter= new ArrayList<>();
	public static List<Item> NEED_ITEM_Kurogane= new ArrayList<>();
	public static List<Item> NEED_ITEM_GT= new ArrayList<>();

	public static List<Item> NEED_ITEM_TypeThree= new ArrayList<>();

	public static List<Item> NEED_ITEM_SteamHopper_daybreak= new ArrayList<>();
	public static List<Item> NEED_ITEM_Shining_DB= new ArrayList<>();

	public static List<Item> NEED_ITEM_ExceedMighty= new ArrayList<>();
	public static List<Item> NEED_ITEM_CycloneTaToBa= new ArrayList<>();
	public static List<Item> NEED_ITEM_FullFullRocket= new ArrayList<>();

	public static final DeferredItem<Item> ARK_ONE_MALGAM = ITEMS.register("ark_one_malgam",
			() -> new RiderFormChangeItem(new Item.Properties(),"_malgam","ark_zero","ark_driver_belt_1",
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
					.IsBeltGlowing().changeRiderName("ark_one").has_basic_model().model_has_different_name("ark_one_ride_chemy_card"));


	public static final DeferredItem<Item> GOTCHARD_LOGO = ITEMS.register("gotchard_logo",
			() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/gotchard")), new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> BLANK_RIDE_CHEMY_CARD = ITEMS.register("blank_ride_chemy_card",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> HOPPER1_RIDE_CHEMY_CARD = ITEMS.register("hopper1_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_SteamHopper).addToList(NEED_ITEM_SteamHopper)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.insectChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> PIKAHOTARU_RIDE_CHEMY_CARD = ITEMS.register("pikahotaru_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_sma_hotaru","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_SmaHotaru).addToList(NEED_ITEM_SmaHotaru)
					.addToList(ChemyRiserItem.insectChemy).addToList(ChemyRiserItem.allChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GENGENCHOUCHO_RIDE_CHEMY_CARD = ITEMS.register("gengenchoucho_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_bullet_choucho","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(EffectCore.GATLING, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_BulletChoucho).addToList(NEED_ITEM_BulletChoucho)
					.addToList(ChemyRiserItem.insectChemy).addToList(ChemyRiserItem.allChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> BAKUONZEMI_RIDE_CHEMY_CARD = ITEMS.register("bakuonzemi_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_bakuon_televi","gotchard","gotchardriver_belt",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_BakuonTelevi).addToList(NEED_ITEM_BakuonTelevi)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.insectChemy).has_basic_model());

	public static final DeferredItem<Item> ANTROOPER_RIDE_CHEMY_CARD = ITEMS.register("antrooper_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_ant_wrestler","gotchard","gotchardriver_belt",
					new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_AntWrestler).addToList(NEED_ITEM_AntWrestler)
					.addToList(ChemyRiserItem.insectChemy).addToList(ChemyRiserItem.allChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> GREATONBO_RIDE_CHEMY_CARD = ITEMS.register("greatonbo_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_great_sasorry","gotchard","gotchardriver_belt",
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(EffectCore.ANTIPOISON, 40, 0,true,false),
					new MobEffectInstance(EffectCore.RIDER_POISON_HAND, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_GreatSasorry).addToList(NEED_ITEM_GreatSasorry)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.insectChemy).has_basic_model());

	public static final DeferredItem<Item> STAGVINE_RIDE_CHEMY_CARD = ITEMS.register("stagvine_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_stag_mirror","gotchard","gotchardriver_belt",
					new MobEffectInstance(EffectCore.REFLECT, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_StagMirror).addToList(NEED_ITEM_StagMirror)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.insectChemy).has_basic_model());

	public static final DeferredItem<Item> KAISERBEE_RIDE_CHEMY_CARD = ITEMS.register("kaiserbee_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.insectChemy).has_basic_model());

	public static final DeferredItem<Item> KAMANTIS_RIDE_CHEMY_CARD = ITEMS.register("kamantis_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_odori_mantis","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_OdoriMantis).addToList(NEED_ITEM_OdoriMantis)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.insectChemy).addToList(ChemyRiserItem.allChemy).has_basic_model());

	public static final DeferredItem<Item> BEETLX_RIDE_CHEMY_CARD = ITEMS.register("beetlx_ride_chemy_card",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ODORIPPA_RIDE_CHEMY_CARD = ITEMS.register("odorippa_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),KAMANTIS_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_OdoriMantis)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.jobChemy).addToList(ChemyRiserItem.allChemy).has_basic_model());

	public static final DeferredItem<Item> DOKKIRIMAJIN_RIDE_CHEMY_CARD = ITEMS.register("dokkirimajin_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_dokkiri_shovel","gotchard","gotchardriver_belt",
					new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_DokkiriShovel).addToList(NEED_ITEM_DokkiriShovel).addToList(ChemyRiserItem.jobChemy)
					.addToList(ChemyRiserItem.allChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> DOCTORKOZO_RIDE_CHEMY_CARD = ITEMS.register("doctorkozo_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_doctor_hebi","gotchard","gotchardriver_belt",
					new MobEffectInstance(EffectCore.ANTIPOISON, 40, 0,true,false),
					new MobEffectInstance(EffectCore.RIDER_POISON_HAND, 40, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 400, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_DoctorHebi).addToList(NEED_ITEM_DoctorHebi).addToList(ChemyRiserItem.jobChemy)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.allChemy).has_basic_model());

	public static final DeferredItem<Item> PILETS_RIDE_CHEMY_CARD = ITEMS.register("pilets_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_mad_pilets","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(EffectCore.CANNON,40,1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_MadPilets).addToList(NEED_ITEM_MadPilets).addToList(ChemyRiserItem.jobChemy)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.allChemy).has_basic_model());

	public static final DeferredItem<Item> WRESTLER_G_RIDE_CHEMY_CARD = ITEMS.register("wrestler_g_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),ANTROOPER_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_AntWrestler)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.jobChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> SASUKEMARU_RIDE_CHEMY_CARD = ITEMS.register("sasukemaru_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_energy_maru","gotchard","gotchardriver_belt",
					new MobEffectInstance(EffectCore.STEALTH, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED,40,3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST,40,1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_EnergyMaru).addToList(NEED_ITEM_EnergyMaru).addToList(ChemyRiserItem.jobChemy)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.allChemy).has_basic_model());

	public static final DeferredItem<Item> BULLETBAANG_RIDE_CHEMY_CARD = ITEMS.register("bulletbaang_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),GENGENCHOUCHO_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_BulletChoucho)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.jobChemy).addToList(ChemyRiserItem.allChemy).has_basic_model());

	public static final DeferredItem<Item> APPAREBUSHIDO_RIDE_CHEMY_CARD = ITEMS.register("apparebushido_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_appare_skebow","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(EffectCore.SLASH, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.CHERRY_LEAVES,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_AppareSkebow).addToList(ChemyRiserItem.jobChemy).addToList(NEED_ITEM_AppareSkebow)
					.addToList(ChemyRiserItem.allChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> KARYUDOS_RIDE_CHEMY_CARD = ITEMS.register("karyudos_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.jobChemy).has_basic_model());

	public static final DeferredItem<Item> X_WIZARD_RIDE_CHEMY_CARD = ITEMS.register("x_wizard_ride_chemy_card",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> SPICLE_RIDE_CHEMY_CARD = ITEMS.register("spicle_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_spicle_whale","gotchard","gotchardriver_belt_big1",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 3,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().changeBeltModel("geo/gotchard_belt_big.geo.json")
					.addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_SpicleWhale).addToList(NEED_ITEM_SpicleWhale)
					.has_basic_model().addToList(ChemyRiserItem.vehicleChemy).addToList(ChemyRiserItem.allChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> SKEBOWS_RIDE_CHEMY_CARD = ITEMS.register("skebows_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),APPAREBUSHIDO_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_AppareSkebow)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.vehicleChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> HIIKESCUE_RIDE_CHEMY_CARD = ITEMS.register("hiikescue_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_hiikesu_rose","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(EffectCore.REFLECT, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_HiikesuRose).addToList(NEED_ITEM_HiikesuRose).addToList(ChemyRiserItem.allChemy)
					.addToList(ChemyRiserItem.vehicleChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> GEKIOCOPTER_RIDE_CHEMY_CARD_G = ITEMS.register("gekiocopter_ride_chemy_card_g",
			() -> new RiderFormChangeItem(new Item.Properties(),"_oni_copter","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_OniCopter).model_has_different_name("gekiocopter_ride_chemy_card"));

	public static final DeferredItem<Item> GEKIOCOPTER_RIDE_CHEMY_CARD_V = ITEMS.register("gekiocopter_ride_chemy_card_v",
			() -> new RiderFormChangeItem(new Item.Properties(),"_ange_copter","valvarad_rider","valvaradriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addAlternative(GEKIOCOPTER_RIDE_CHEMY_CARD_G.get()).addNeedItemList(NEED_ITEM_AngeCopter).has_basic_model().model_has_different_name("gekiocopter_ride_chemy_card"));

	public static final DeferredItem<Item> GEKIOCOPTER_RIDE_CHEMY_CARD = ITEMS.register("gekiocopter_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","valvarad","",
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().changeSlot(2).addAlternative(GEKIOCOPTER_RIDE_CHEMY_CARD_V.get()).addSwitchForm(ModdedItemCore.BLANK_FORM.get())
					.addToList(NEED_ITEM_AngeCopter).addToList(NEED_ITEM_OniCopter)
					.addToList(ChemyRiserItem.vehicleChemy).addToList(ChemyRiserItem.allChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> DEEPMARINER_RIDE_CHEMY_CARD = ITEMS.register("deepmariner_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_venom_mariner","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 1,true,false),
					new MobEffectInstance(EffectCore.ANTIPOISON, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_VenomMariner).addToList(NEED_ITEM_VenomMariner).addToList(ChemyRiserItem.allChemy)
					.addToList(ChemyRiserItem.vehicleChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> MADWHEEL_RIDE_CHEMY_CARD = ITEMS.register("madwheel_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","valvarad","valvaradraw_buckle_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addAlternative(PILETS_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_MadPilets).addToList(ChemyRiserItem.allChemy)
					.addToList(ChemyRiserItem.vehicleChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> MACHWHEEL_RIDE_CHEMY_CARD = ITEMS.register("machwheel_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","valvarad_rider","valvaradriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addAlternative(GEKIOCOPTER_RIDE_CHEMY_CARD_G.get())
					.addNeedItemList(NEED_ITEM_Valvarad).addToList(NEED_ITEM_Valvarad).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GOLDDASH_RIDE_CHEMY_CARD = ITEMS.register("golddash_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_gold_mechanichor","gotchard","gotchardriver_belt_big",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().changeBeltModel("geo/gotchard_belt_big.geo.json")
					.addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_GoldMechanichor).addToList(NEED_ITEM_GoldMechanichor)
					.addToList(ChemyRiserItem.vehicleChemy).addToList(ChemyRiserItem.allChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> GUTSSHOVEL_RIDE_CHEMY_CARD_V = ITEMS.register("gutsshovel_ride_chemy_card_v",
			() -> new RiderFormChangeItem(new Item.Properties(),"_orochi_shovel","valvarad_rider","valvaradriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addAlternative(DOKKIRIMAJIN_RIDE_CHEMY_CARD.get()).addNeedItemList(NEED_ITEM_OrochiShovel)
					.isGlowing().has_basic_model().model_has_different_name("gutsshovel_ride_chemy_card"));

	public static final DeferredItem<Item> GUTSSHOVEL_RIDE_CHEMY_CARD = ITEMS.register("gutsshovel_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","valvarad","",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().changeSlot(3).addAlternative(GUTSSHOVEL_RIDE_CHEMY_CARD_V.get()).addSwitchForm(ModdedItemCore.BLANK_FORM.get())
					.addToList(NEED_ITEM_DokkiriShovel).addToList(NEED_ITEM_OrochiShovel)
					.addToList(ChemyRiserItem.vehicleChemy).addToList(ChemyRiserItem.allChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> STEAMLINER_RIDE_CHEMY_CARD = ITEMS.register("steamliner_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),HOPPER1_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_SteamHopper)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.vehicleChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> EXCEEDFIGHTER_RIDE_CHEMY_CARD = ITEMS.register("exceedfighter_ride_chemy_card",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> YAMIBAT_RIDE_CHEMY_CARD = ITEMS.register("yamibat_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_bat_king_robo","_gotchard","gotchardriver_belt_big1",
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(EffectCore.CANNON, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().changeBeltModel("geo/gotchard_belt_big.geo.json")
					.addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_BatKingRobo).addToList(NEED_ITEM_BatKingRobo)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.animalChemy).has_basic_model());

	public static final DeferredItem<Item> CATCHULA_RIDE_CHEMY_CARD = ITEMS.register("catchula_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.animalChemy).has_basic_model());

	public static final DeferredItem<Item> MECHANICHANI_RIDE_CHEMY_CARD = ITEMS.register("mechanichani_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),GOLDDASH_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_GoldMechanichor)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.animalChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> BUSSASORRY_RIDE_CHEMY_CARD = ITEMS.register("bussasorry_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),GREATONBO_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_GreatSasorry)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.animalChemy).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> BOUNTYBUNNY_RIDE_CHEMY_CARD = ITEMS.register("bountybunny_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_bunny_parka","gotchard","gotchardriver_belt",
					new MobEffectInstance(EffectCore.GHOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_BunnyParka).addToList(NEED_ITEM_BunnyParka)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.animalChemy).has_basic_model());

	public static final DeferredItem<Item> HAWKSTAR_RIDE_CHEMY_CARD = ITEMS.register("hawkstar_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_needle_hawk","gotchard","gotchardriver_belt",
					new MobEffectInstance(EffectCore.FLYING, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).hasFlyingWings(null).addNeedItemList(NEED_ITEM_NeedleHawk).addToList(ChemyRiserItem.allChemy).addToList(NEED_ITEM_NeedleHawk)
					.addToList(ChemyRiserItem.animalChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> TSUPPARIHEBI_RIDE_CHEMY_CARD = ITEMS.register("tsupparihebi_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),DOCTORKOZO_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_DoctorHebi)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.animalChemy).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> GORILLASENSEI_RIDE_CHEMY_CARD = ITEMS.register("gorillasensei_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_burning_gorilla","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false),
					new MobEffectInstance(EffectCore.FIRE_PUNCH, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_BurningGorilla).addToList(NEED_ITEM_BurningGorilla)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.animalChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> GANVHALE_RIDE_CHEMY_CARD = ITEMS.register("ganvhale_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),SPICLE_RIDE_CHEMY_CARD.get())
					.has_basic_model().addToList(NEED_ITEM_SpicleWhale).addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.animalChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> LIXION_RIDE_CHEMY_CARD = ITEMS.register("lixion_ride_chemy_card",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> RAIDENJI_RIDE_CHEMY_CARD = ITEMS.register("raidenji_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_lightning_jungle","gotchard","gotchardriver_belt_big",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().changeBeltModel("geo/gotchard_belt_big.geo.json")
					.addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_LightningJungle).addToList(NEED_ITEM_LightningJungle)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.artifactChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> KESUZO_RIDE_CHEMY_CARD = ITEMS.register("kesuzo_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.artifactChemy).has_basic_model());

	public static final DeferredItem<Item> MITEMIRROR_RIDE_CHEMY_CARD = ITEMS.register("mitemirror_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),STAGVINE_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_StagMirror).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.artifactChemy).has_basic_model());

	public static final DeferredItem<Item> ENERGYL_RIDE_CHEMY_CARD = ITEMS.register("energyl_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),SASUKEMARU_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_EnergyMaru)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.artifactChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> PANPAKAPARKA_RIDE_CHEMY_CARD = ITEMS.register("panpakaparka_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),BOUNTYBUNNY_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_BunnyParka)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.artifactChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> TELEVI_RIDE_CHEMY_CARD = ITEMS.register("televi_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),BAKUONZEMI_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_BakuonTelevi)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.artifactChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> TIMELORD_RIDE_CHEMY_CARD = ITEMS.register("timelord_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.artifactChemy).has_basic_model());

	public static final DeferredItem<Item> SMAPHONE_RIDE_CHEMY_CARD = ITEMS.register("smaphone_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),PIKAHOTARU_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_SmaHotaru)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.artifactChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> RENKINGROBO_RIDE_CHEMY_CARD = ITEMS.register("renkingrobo_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),YAMIBAT_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_BatKingRobo).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.artifactChemy).has_basic_model());

	public static final DeferredItem<Item> X_FORTRESS_RIDE_CHEMY_CARD = ITEMS.register("x_fortress_ride_chemy_card",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> HAPPYCLOVER_RIDE_CHEMY_CARD = ITEMS.register("happyclover_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.plantChemy).has_basic_model());

	public static final DeferredItem<Item> BURNINGNERO_RIDE_CHEMY_CARD = ITEMS.register("burningnero_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),GORILLASENSEI_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_BurningGorilla)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.plantChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> BAMBAMBOO_RIDE_CHEMY_CARD = ITEMS.register("bambamboo_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.plantChemy).has_basic_model());

	public static final DeferredItem<Item> SABONEEDLE_RIDE_CHEMY_CARD = ITEMS.register("saboneedle_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),HAWKSTAR_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_NeedleHawk)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.plantChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> VENOMDAKE_RIDE_CHEMY_CARD = ITEMS.register("venomdake_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),DEEPMARINER_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_VenomMariner)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.plantChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> UTSUBOCCHAMA_RIDE_CHEMY_CARD = ITEMS.register("utsubocchama_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.plantChemy).has_basic_model());

	public static final DeferredItem<Item> FLAYROSE_RIDE_CHEMY_CARD = ITEMS.register("flayrose_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),HIIKESCUE_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_HiikesuRose)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.plantChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> BUGLESIA_RIDE_CHEMY_CARD = ITEMS.register("buglesia_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.plantChemy).has_basic_model());

	public static final DeferredItem<Item> JUNGLEJAN_RIDE_CHEMY_CARD = ITEMS.register("junglejan_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),RAIDENJI_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_LightningJungle)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.plantChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> XEGGDRASIL_RIDE_CHEMY_CARD = ITEMS.register("xeggdrasil_ride_chemy_card",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> CARERY_RIDE_CHEMY_CARD = ITEMS.register("carery_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.occultChemy).has_basic_model());

	public static final DeferredItem<Item> BEROSOL_RIDE_CHEMY_CARD = ITEMS.register("berosol_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.occultChemy).has_basic_model());

	public static final DeferredItem<Item> SAYZOMBIE_RIDE_CHEMY_CARD = ITEMS.register("sayzombie_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.occultChemy).has_basic_model());

	public static final DeferredItem<Item> ANGELEAD_RIDE_CHEMY_CARD = ITEMS.register("angelead_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),GEKIOCOPTER_RIDE_CHEMY_CARD_V.get()).addToList(NEED_ITEM_AngeCopter)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.occultChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ZUKYUMPIRE_RIDE_CHEMY_CARD = ITEMS.register("zukyumpire_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.occultChemy).has_basic_model());

	public static final DeferredItem<Item> DAIOHNI_RIDE_CHEMY_CARD = ITEMS.register("daiohni_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),MACHWHEEL_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_Valvarad).addToList(NEED_ITEM_OniCopter)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.occultChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> MACKRAKEN_RIDE_CHEMY_CARD = ITEMS.register("mackraken_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.occultChemy).has_basic_model());

	public static final DeferredItem<Item> JYAMATANOOROCHI_RIDE_CHEMY_CARD = ITEMS.register("jyamatanoorochi_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),GUTSSHOVEL_RIDE_CHEMY_CARD_V.get()).addToList(NEED_ITEM_OrochiShovel)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.occultChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> NINETAIL_RIDE_CHEMY_CARD = ITEMS.register("ninetail_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.occultChemy).has_basic_model());

	public static final DeferredItem<Item> UFO_X_RIDE_CHEMY_CARD = ITEMS.register("ufo_x_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_super_cross_ufo_x","gotchard","gotchardriver_belt_s",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 0, true, false),
					new MobEffectInstance(MobEffects.NIGHT_VISION,400,0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_Super).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> NAMMONITE_RIDE_CHEMY_CARD = ITEMS.register("nammonite_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.ancientChemy).has_basic_model());

	public static final DeferredItem<Item> AKUMANOCARIS_RIDE_CHEMY_CARD = ITEMS.register("akumanocaris_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.ancientChemy).has_basic_model());

	public static final DeferredItem<Item> PAKURAPTOR_RIDE_CHEMY_CARD = ITEMS.register("pakuraptor_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.ancientChemy).has_basic_model());

	public static final DeferredItem<Item> OJILACANTH_RIDE_CHEMY_CARD = ITEMS.register("ojilacanth_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.ancientChemy).has_basic_model());

	public static final DeferredItem<Item> SABELIGER_RIDE_CHEMY_CARD = ITEMS.register("sabeliger_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.ancientChemy).has_basic_model());

	public static final DeferredItem<Item> WARPTERA_RIDE_CHEMY_CARD = ITEMS.register("warptera_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.ancientChemy).has_basic_model());

	public static final DeferredItem<Item> GIGALODON_RIDE_CHEMY_CARD = ITEMS.register("gigalodon_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.ancientChemy).has_basic_model());

	public static final DeferredItem<Item> TRICERA_RIDE_CHEMY_CARD = ITEMS.register("tricera_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.ancientChemy).has_basic_model());

	public static final DeferredItem<Item> BLIZZAMMOTH_RIDE_CHEMY_CARD = ITEMS.register("blizzammoth_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.ancientChemy).has_basic_model());

	public static final DeferredItem<Item> X_REX_RIDE_CHEMY_CARD = ITEMS.register("x_rex_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_super_cross_x_rex","gotchard","gotchardriver_belt_s",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_Super).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> MERCURIN_RIDE_CHEMY_CARD = ITEMS.register("mercurin_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.cosmicCHEMY).has_basic_model());

	public static final DeferredItem<Item> KINKIRAVINA_RIDE_CHEMY_CARD = ITEMS.register("kinkiravina_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.cosmicCHEMY).has_basic_model());

	public static final DeferredItem<Item> GOKIGENMETEON_RIDE_CHEMY_CARD = ITEMS.register("gokigenmeteon_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.cosmicCHEMY).has_basic_model());

	public static final DeferredItem<Item> NEMINEMOON_RIDE_CHEMY_CARD_G = ITEMS.register("neminemoon_ride_chemy_card_g",
			() -> new RiderFormChangeItem(new Item.Properties(),"_moon_cerberus","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_MoonCerberus).model_has_different_name("neminemoon_ride_chemy_card"));

	public static final DeferredItem<Item> NEMINEMOON_RIDE_CHEMY_CARD = ITEMS.register("neminemoon_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_moon_cerberus","majade","alchemisdriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addAlternative(NEMINEMOON_RIDE_CHEMY_CARD_G.get())
					.addNeedItemList(NEED_ITEM_MoonCerberus).addToList(NEED_ITEM_MoonCerberus).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.cosmicCHEMY).has_basic_model());

	public static final DeferredItem<Item> FIREMARS_RIDE_CHEMY_CARD = ITEMS.register("firemars_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties(),"_mars_phoenix","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(EffectCore.FIRE_PUNCH, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addNeedItemList(NEED_ITEM_MarsPhoenix)
					.isGlowing().addCompatibilityList(Gotchards).addToList(NEED_ITEM_MarsPhoenix).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.cosmicCHEMY)
					.addToList(ChemyRiserItem.allChemy).has_basic_model());

	public static final DeferredItem<Item> GRANDSATURN_RIDE_CHEMY_CARD = ITEMS.register("grandsaturn_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.cosmicCHEMY).has_basic_model());

	public static final DeferredItem<Item> THE_SUN_RIDE_CHEMY_CARD_G = ITEMS.register("the_sun_ride_chemy_card_g",
			() -> new RiderFormChangeItem(new Item.Properties(),"_sun_unicorn","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_SunUnicorn).model_has_different_name("the_sun_ride_chemy_card"));

	public static final DeferredItem<Item> THE_SUN_RIDE_CHEMY_CARD = ITEMS.register("the_sun_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","majade","alchemisdriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addAlternative(THE_SUN_RIDE_CHEMY_CARD_G.get())
					.addNeedItemList(NEED_ITEM_SunUnicorn).addToList(NEED_ITEM_SunUnicorn).addToList(ChemyRiserItem.allChemy)
					.addToList(ChemyRiserItem.cosmicCHEMY).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> JUPITTA_RIDE_CHEMY_CARD = ITEMS.register("jupitta_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.cosmicCHEMY).has_basic_model());

	public static final DeferredItem<Item> KUROANA_RIDE_CHEMY_CARD = ITEMS.register("kuroana_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","wind","alchemisdriver_belt_wind",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().hasCape().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.cosmicCHEMY).has_basic_model());

	public static final DeferredItem<Item> GAIARD_RIDE_CHEMY_CARD = ITEMS.register("gaiard_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"","","")
					.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GIGABAHAM_RIDE_CHEMY_CARD = ITEMS.register("gigabaham_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.fantasticChemy).has_basic_model());

	public static final DeferredItem<Item> MACENTAURUS_RIDE_CHEMY_CARD = ITEMS.register("macentaurus_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.fantasticChemy).has_basic_model());

	public static final DeferredItem<Item> UNICON_RIDE_CHEMY_CARD = ITEMS.register("unicon_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),THE_SUN_RIDE_CHEMY_CARD.get())
					.addToList(NEED_ITEM_SunUnicorn).addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.fantasticChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> VANFENRIR_RIDE_CHEMY_CARD = ITEMS.register("vanfenrir_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.fantasticChemy).has_basic_model());

	public static final DeferredItem<Item> INPHOENIX_RIDE_CHEMY_CARD = ITEMS.register("inphoenix_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),FIREMARS_RIDE_CHEMY_CARD.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.fantasticChemy).has_basic_model());

	public static final DeferredItem<Item> YOACERBERUS_RIDE_CHEMY_CARD = ITEMS.register("yoacerberus_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),NEMINEMOON_RIDE_CHEMY_CARD.get())
					.addToList(NEED_ITEM_MoonCerberus).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.fantasticChemy).has_basic_model());

	public static final DeferredItem<Item> HAODIN_RIDE_CHEMY_CARD = ITEMS.register("haodin_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.fantasticChemy).has_basic_model());

	public static final DeferredItem<Item> GINGRIFFON_RIDE_CHEMY_CARD = ITEMS.register("gingriffon_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.fantasticChemy).has_basic_model());

	public static final DeferredItem<Item> DONPOSEIDON_RIDE_CHEMY_CARD = ITEMS.register("donposeidon_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","","").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.allChemy).addToList(ChemyRiserItem.fantasticChemy).has_basic_model());

	public static final DeferredItem<Item> DRAGONALOS_RIDE_CHEMY_CARD = ITEMS.register("dragonalos_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"","","")
					.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> TAMAGON_RIDE_CHEMY_CARD = ITEMS.register("tamagon_ride_chemy_card",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> NIJIGON_RIDE_CHEMY_CARD_EXTRA = ITEMS.register("nijigon_ride_chemy_card_extra",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),"_rainbow","gotchard","gotchardriver_belt_r",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 6,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 6,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 6,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RANDOM_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addNeedItemList(NEED_ITEM_Rainbow).addToList(NEED_ITEM_Rainbow).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> NIJIGON_RIDE_CHEMY_CARD_SPECIAL = ITEMS.register("nijigon_ride_chemy_card_special",
			() -> new CopyFormChangeItem(new Item.Properties().rarity(Rarity.RARE), NIJIGON_RIDE_CHEMY_CARD_EXTRA.get()).addToList(NEED_ITEM_Rainbow).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> TENLINER_RIDE_CHEMY_CARD = ITEMS.register("tenliner_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_iron","gotchard","gotchardriver_belt_i",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 4,true,false),
					new MobEffectInstance(EffectCore.BOOST, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addToList(NEED_ITEM_Platina).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> CROSSHOPPER_RIDE_CHEMY_CARD = ITEMS.register("crosshopper_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_platina","gotchard","gotchardriver_belt_p",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 6,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_Platina).addToList(NEED_ITEM_Platina).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> HOPPER1_RIDE_CHEMY_CARD_ULTIMA = ITEMS.register("hopper1_ride_chemy_card_ultima",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC),"","gotchard","gotchardriver_belt_daybreak",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 9,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 9,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 9,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 9,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addNeedItemList(NEED_ITEM_Ultima).addToList(NEED_ITEM_Ultima).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> STEAMLINER_RIDE_CHEMY_CARD_ULTIMA = ITEMS.register("steamliner_ride_chemy_card_ultima",
			() -> new CopyFormChangeItem(new Item.Properties().rarity(Rarity.EPIC), HOPPER1_RIDE_CHEMY_CARD_ULTIMA.get()).addToList(NEED_ITEM_Ultima).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> TWILIGHT_THE_SUN_RIDE_CHEMY_CARD = ITEMS.register("twilight_the_sun_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC),"_twilight","majade","alchemisdriver_belt_t",
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(EffectCore.ANTIPOISON, 40, 0,true,false),
					new MobEffectInstance(EffectCore.FIRE_PUNCH, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addNeedItemList(NEED_ITEM_Twilight).addToList(NEED_ITEM_Twilight).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> TWILIGHT_UNICON_RIDE_CHEMY_CARD = ITEMS.register("twilight_unicon_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties().rarity(Rarity.EPIC), TWILIGHT_THE_SUN_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_Twilight).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> METAL_MACHWHEEL_RIDE_CHEMY_CARD = ITEMS.register("metal_machwheel_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC),"_kurogane","valvarad_rider","valvaradriver_belt_k",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addNeedItemList(NEED_ITEM_Kurogane).addToList(NEED_ITEM_Kurogane).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> METAL_DAIOHNI_RIDE_CHEMY_CARD = ITEMS.register("metal_daiohni_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties().rarity(Rarity.EPIC), METAL_MACHWHEEL_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_Kurogane).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> X_ASSEMBLE_RIDE_CHEMY_CARD = ITEMS.register("x_assemble_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_star","gotchard","gotchardriver_belt_star",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 0, true, false),
					new MobEffectInstance(EffectCore.THUNDER_PUNCH, 40, 0, true, false),
					new MobEffectInstance(MobEffects.NIGHT_VISION,400,0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addNeedItemList(NEED_ITEM_Super).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> HOPPER101_RIDE_CHEMY_CARD = ITEMS.register("hopper101_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),"_miracle","gotchard","gotchardriver_belt_r",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 6,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 6,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 6,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RANDOM_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addNeedForm(NIJIGON_RIDE_CHEMY_CARD_EXTRA.get()).addNeedItemList(NEED_ITEM_Miracle).addToList(NEED_ITEM_Miracle).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GIGANTLINER_RIDE_CHEMY_CARD = ITEMS.register("gigantliner_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties().rarity(Rarity.RARE), HOPPER101_RIDE_CHEMY_CARD.get()).addToList(NEED_ITEM_Miracle).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GIGANTLINER_RIDE_CHEMY_CARD_FS = ITEMS.register("gigantliner_ride_chemy_card_fs",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),"_legend_liner","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 6,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 6,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 6,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RANDOM_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addNeedItemList(NEED_ITEM_LegendLiner).addToList(NEED_ITEM_LegendLiner).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> LEGENDARY_LEGEND_RIDE_CHEMY_CARD_FS = ITEMS.register("legendary_legend_ride_chemy_card_fs",
			() -> new CopyFormChangeItem(new Item.Properties().rarity(Rarity.RARE), GIGANTLINER_RIDE_CHEMY_CARD_FS.get()).addToList(NEED_ITEM_LegendLiner).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> FIREMARS_RIDE_CHEMY_CARD_TELEVIKUN = ITEMS.register("firemars_ride_chemy_card_televikun",
			() -> new RideChemyCardItem(new Item.Properties(),"_mars_phoenix","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(EffectCore.FIRE_PUNCH, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addNeedItemList(NEED_ITEM_MarsPhoenix2)
					.isGlowing().addCompatibilityList(Gotchards).addToList(NEED_ITEM_MarsPhoenix2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> INPHOENIX_RIDE_CHEMY_CARD_TELEVIKUN = ITEMS.register("inphoenix_ride_chemy_card_televikun",
			() -> new CopyChemyCardItem(new Item.Properties(),FIREMARS_RIDE_CHEMY_CARD_TELEVIKUN.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(NEED_ITEM_MarsPhoenix2).has_basic_model());

	public static final DeferredItem<Item> DAIOHNI_GT_RIDE_CHEMY_CARD = ITEMS.register("daiohni_gt_ride_chemy_card",
			() -> new RideChemyCardItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_gt","valvarad_rider","valvaradriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 6,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addNeedItemList(NEED_ITEM_GT).addToList(NEED_ITEM_GT).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GIGANTLINER_GT_RIDE_CHEMY_CARD = ITEMS.register("gigantliner_gt_ride_chemy_card",
			() -> new CopyChemyCardItem(new Item.Properties(),DAIOHNI_GT_RIDE_CHEMY_CARD.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(NEED_ITEM_GT).has_basic_model());

	public static final DeferredItem<Item> HOPPER1_RIDE_CHEMY_CARD_DAYBREAK = ITEMS.register("daybreak_hopper1_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","gotchard_daybreak","gotchardriver_belt_daybreak",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addNeedItemList(NEED_ITEM_SteamHopper_daybreak)
					.isGlowing().addToList(ChemyRiserItem.daybreakChemy).addToList(NEED_ITEM_SteamHopper_daybreak).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> STEAMLINER_RIDE_CHEMY_CARD_DAYBREAK = ITEMS.register("daybreak_steamliner_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),HOPPER1_RIDE_CHEMY_CARD_DAYBREAK.get()).addToList(NEED_ITEM_SteamHopper_daybreak)
					.addToList(ChemyRiserItem.daybreakChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> TIMELORD_RIDE_CHEMY_CARD_DAYBREAK  = ITEMS.register("timelord_daybreak_chemy_card",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.daybreakChemy).has_basic_model());

	public static final DeferredItem<Item> GOLDDASH_RIDE_CHEMY_CARD_DAYBREAK  = ITEMS.register("golddash_daybreak_chemy_card",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.daybreakChemy).has_basic_model());

	public static final DeferredItem<Item> APPAREBUSHIDO_RIDE_CHEMY_CARD_DAYBREAK  = ITEMS.register("apparebushido_daybreak_chemy_card",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.daybreakChemy).has_basic_model());

	public static final DeferredItem<Item> BULLETBAANG_RIDE_CHEMY_CARD_DAYBREAK  = ITEMS.register("bulletbaang_daybreak_chemy_card",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.daybreakChemy).has_basic_model());

	public static final DeferredItem<Item> SKEBOWS_RIDE_CHEMY_CARD_DAYBREAK  = ITEMS.register("skebows_daybreak_chemy_card",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.daybreakChemy).has_basic_model());

	public static final DeferredItem<Item> MECHANICHANI_RIDE_CHEMY_CARD_DAYBREAK  = ITEMS.register("mechanichani_daybreak_chemy_card",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.daybreakChemy).has_basic_model());

	public static final DeferredItem<Item> JUNGLEJAN_RIDE_CHEMY_CARD_DAYBREAK  = ITEMS.register("junglejan_daybreak_chemy_card",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.daybreakChemy).has_basic_model());

	public static final DeferredItem<Item> RAIDENJI_RIDE_CHEMY_CARD_DAYBREAK  = ITEMS.register("raidenji_daybreak_chemy_card",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.daybreakChemy).has_basic_model());

	public static final DeferredItem<Item> THE_SUN_RIDE_CHEMY_CARD_DAYBREAK  = ITEMS.register("the_sun_daybreak_chemy_card",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.daybreakChemy).has_basic_model());

	public static final DeferredItem<Item> SHINING_HOPPER1_RIDE_CHEMY_CARD_DAYBREAK = ITEMS.register("shining_hopper1_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_shining","gotchard_daybreak","gotchardriver_belt_daybreak",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(EffectCore.BOOST,40,5,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE,40,0,true,false),
					new MobEffectInstance(EffectCore.FIRE_PUNCH,40,3,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addNeedItemList(NEED_ITEM_Shining_DB)
					.isGlowing().hasCape().addToList(NEED_ITEM_Shining_DB).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> SHINING_STEAMLINER_RIDE_CHEMY_CARD = ITEMS.register("shining_steamliner_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),SHINING_HOPPER1_RIDE_CHEMY_CARD_DAYBREAK.get()).addToList(NEED_ITEM_Shining_DB)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> DREAD_TYPE_THREE_CARDS = ITEMS.register("dread_type_three_cards",
			() -> new RiderFormChangeItem(new Item.Properties(),"_type_three","dread","dreadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
				}
			}.isGlowing().changeModel("dread_type_one.geo.json").addNeedItemList(NEED_ITEM_TypeThree)
					.has_basic_model().model_has_different_name("steamliner_repli_chemy_card"));

	public static final DeferredItem<Item> STEAMLINER_REPLI_CHEMY_CARD = ITEMS.register("steamliner_repli_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","dread","dreadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
				}
			}.addShiftForm(DREAD_TYPE_THREE_CARDS.get())
					.isGlowing().addToList(NEED_ITEM_TypeThree).addToList(ChemyRiserItem.repliChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> UNICON_REPLI_CHEMY_CARD = ITEMS.register("unicon_repli_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_type_one","dread","dreadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
				}
			}.addShiftForm(DREAD_TYPE_THREE_CARDS.get())
					.isGlowing().addToList(NEED_ITEM_TypeThree).addToList(ChemyRiserItem.repliChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> DAIOHNI_REPLI_CHEMY_CARD = ITEMS.register("daiohni_repli_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_type_two","dread","dreadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
				}
			}.addShiftForm(DREAD_TYPE_THREE_CARDS.get())
					.isGlowing().addToList(NEED_ITEM_TypeThree).addToList(ChemyRiserItem.repliChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> MADWHEEL_REPLI_CHEMY_CARD = ITEMS.register("madwheel_repli_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","valvarad_lachesis","valvaradraw_buckle_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addToList(ChemyRiserItem.repliChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ANTROOPER_REPLI_CHEMY_CARD = ITEMS.register("antrooper_repli_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","dreatrooper","dreadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
				}
			}.isGlowing().addToList(ChemyRiserItem.repliChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GIGANTLINER_REPLI_CHEMY_CARD = ITEMS.register("gigantliner_repli_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),"_type_final","dread","dreadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 5,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 5,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> APPAREBUSHIDO_REPLI_CHEMY_CARD = ITEMS.register("apparebushido_repli_chemy_card",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> BULLETBAANG_REPLI_CHEMY_CARD = ITEMS.register("bulletbaang_repli_chemy_card",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> KAMANTIS_REPLI_CHEMY_CARD = ITEMS.register("kamantis_repli_chemy_card",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> LEGEND_RIDE_CHEMY_CARD = ITEMS.register("legend_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().isGold().resetFormToBase().addToList(ChemyRiserItem.legendChemy,10).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> LEGENDARY_LEGEND = ITEMS.register("legendary_legend",
			() -> new RiderFormChangeItem(new Item.Properties(),"_legendary","legend","legendriver_belt_l")
					.isGlowing().isGold().changeSlot(2).has_basic_model().model_has_different_name("legendary_legend_ride_chemy_card"));

	public static final DeferredItem<Item> LEGENDARY_LEGEND_RIDE_CHEMY_CARD = ITEMS.register("legendary_legend_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),"_legendary","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().isGold().alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> DARK_ETHER_CHEMY_CARD = ITEMS.register("dark_ether_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","dorado","eldoradriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE,40,0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ELDRAGON_CHEMY_CARD = ITEMS.register("eldragon_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),"","eld","eldoradriver_belt_e",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 5,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 5,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> SANTACLAUS_RIDE_CHEMY_CARD = ITEMS.register("santaclaus_ride_chemy_card",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> TONAKAILINER_RIDE_CHEMY_CARD = ITEMS.register("tonakailiner_ride_chemy_card",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_RIDE_CHEMY_CARD_GOTCHARD = ITEMS.register("kuuga_ride_chemy_card_gotchard",
			() -> new RideChemyCardItem(new Item.Properties(),"_exceed_mighty","gotchard","gotchardriver_belt",
					new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_ExceedMighty).has_basic_model().model_has_different_name("kuuga_ride_chemy_card"));

	public static final DeferredItem<Item> KUUGA_RIDE_CHEMY_CARD = ITEMS.register("kuuga_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false))
					.setSummonBelt((RiderDriverItem) KuugaRiderItems.ARCLE.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("kuuga").changeModel("kuuga.geo.json").addAlternative(KUUGA_RIDE_CHEMY_CARD_GOTCHARD.get())
					.addToList(NEED_ITEM_ExceedMighty).addToList(ChemyRiserItem.legendChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_RIDE_CHEMY_CARD = ITEMS.register("agito_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
					.setSummonBelt((RiderDriverItem) AgitoRiderItems.ALTERING.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("agito").changeModel("agito.geo.json").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.legendChemy).has_basic_model());

	public static final DeferredItem<Item> RYUKI_RIDE_CHEMY_CARD = ITEMS.register("ryuki_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.setSummonBelt((RiderDriverItem) RyukiRiderItems.RYUKIDRIVER.get())
					.addSummonWeapon(RyukiRiderItems.DRAG_CLAW.get())
					.isGlowing().alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).changeRiderName("ryuki").addToList(ChemyRiserItem.legendChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> FAIZ_RIDE_CHEMY_CARD = ITEMS.register("faiz_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.setSummonBelt((RiderDriverItem) FaizRiderItems.FAIZ_DRIVER.get())
					.addSummonWeapon(FaizRiderItems.FAIZ_EDGE.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("faiz").addAlternative(KUUGA_RIDE_CHEMY_CARD_GOTCHARD.get())
					.addToList(NEED_ITEM_ExceedMighty).addToList(ChemyRiserItem.legendChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> BLADE_RIDE_CHEMY_CARD = ITEMS.register("blade_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false))
					.setSummonBelt((RiderDriverItem) BladeRiderItems.BLAYBUCKLE.get()).addSummonWeapon(BladeRiderItems.BLAYROUZER.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("blade").addToList(ChemyRiserItem.legendChemy)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> HIBIKI_RIDE_CHEMY_CARD = ITEMS.register("hibiki_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.setSummonBelt((RiderDriverItem) HibikiRiderItems.HIBIKIDRIVER.get()).addSummonWeapon(HibikiRiderItems.ONGEKIBO_REKKA.get()).addSummonWeapon(HibikiRiderItems.ONGEKIBO_REKKA.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("hibiki").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.legendChemy).has_basic_model());

	public static final DeferredItem<Item> KABUTO_RIDE_CHEMY_CARD = ITEMS.register("kabuto_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
					.setSummonBelt((RiderDriverItem) KabutoRiderItems.KABUTO_RIDER_BELT.get())
					.setSummonForm((RiderFormChangeItem) KabutoRiderItems.KABUTO_ZECTER.get()).addSummonWeapon(KabutoRiderItems.KABUTO_KUNAI.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("kabuto").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.legendChemy).has_basic_model());

	public static final DeferredItem<Item> DEN_O_RIDE_CHEMY_CARD = ITEMS.register("den_o_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.setSummonBelt((RiderDriverItem) DenORiderItems.DEN_O_BELT.get()).addSummonWeapon(DenORiderItems.DEN_GASHER_SWORD.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("den_o").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.legendChemy).has_basic_model());

	public static final DeferredItem<Item> KIVA_RIDE_CHEMY_CARD = ITEMS.register("kiva_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
					.setSummonBelt((RiderDriverItem) KivaRiderItems.KIVAT_BELT.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("kiva").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.legendChemy).has_basic_model());

	public static final DeferredItem<Item> DECADE_RIDE_CHEMY_CARD = ITEMS.register("decade_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
					.setSummonBelt((RiderDriverItem) DecadeRiderItems.DECADRIVER.get()).addSummonWeapon(DecadeRiderItems.RIDE_BOOKER.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("decade").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.legendChemy).has_basic_model());

	public static final DeferredItem<Item> W_RIDE_CHEMY_CARD_GOTCHARD = ITEMS.register("w_ride_chemy_card_gotchard",
			() -> new RideChemyCardItem(new Item.Properties(),"_cyclone_tatoba","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_CycloneTaToBa).has_basic_model().model_has_different_name("w_ride_chemy_card"));

	public static final DeferredItem<Item> W_RIDE_CHEMY_CARD = ITEMS.register("w_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false))
					.setSummonBelt((RiderDriverItem) WRiderItems.WDRIVER.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("decade_w").addAlternative(W_RIDE_CHEMY_CARD_GOTCHARD.get())
					.addToList(NEED_ITEM_CycloneTaToBa).addToList(ChemyRiserItem.legendChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> OOO_RIDE_CHEMY_CARD = ITEMS.register("ooo_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.setSummonBelt((RiderDriverItem) OOORiderItems.OOODRIVER.get()).addSummonWeapon(OOORiderItems.MEDAJALIBUR.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).changeModel("ooo_tora.geo.json").isGlowing().changeRiderName("decade_ooo").addAlternative(W_RIDE_CHEMY_CARD_GOTCHARD.get())
					.addToList(NEED_ITEM_CycloneTaToBa).addToList(ChemyRiserItem.legendChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> FOURZE_RIDE_CHEMY_CARD_GOTCHARD = ITEMS.register("fourze_ride_chemy_card_gotchard",
			() -> new RideChemyCardItem(new Item.Properties(),"_full_full_rocket","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(Gotchards).addNeedItemList(NEED_ITEM_FullFullRocket).has_basic_model().model_has_different_name("fourze_ride_chemy_card"));

	public static final DeferredItem<Item> FOURZE_RIDE_CHEMY_CARD = ITEMS.register("fourze_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.setSummonBelt((RiderDriverItem) FourzeRiderItems.FOURZE_DRIVER.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("fourze").addAlternative(FOURZE_RIDE_CHEMY_CARD_GOTCHARD.get())
					.addToList(NEED_ITEM_FullFullRocket).addToList(ChemyRiserItem.legendChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_RIDE_CHEMY_CARD = ITEMS.register("wizard_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.setSummonBelt((RiderDriverItem) WizardRiderItems.WIZARDRIVER.get()).addSummonWeapon(WizardRiderItems.WIZARSWORDSGUN.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("wizard").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.legendChemy).has_basic_model());

	public static final DeferredItem<Item> GAIM_RIDE_CHEMY_CARD = ITEMS.register("gaim_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
					.setSummonBelt((RiderDriverItem) GaimRiderItems.SENGOKU_DRIVER_GAIM.get()).addSummonWeapon(GaimRiderItems.MUSOU_SABER.get()).addSummonWeapon(GaimRiderItems.DAIDAIMARU.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("decade_gaim").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.legendChemy).has_basic_model());

	public static final DeferredItem<Item> DRIVE_RIDE_CHEMY_CARD = ITEMS.register("drive_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.setSummonBelt((RiderDriverItem) DriveRiderItems.DRIVE_DRIVER.get()).addSummonWeapon(DriveRiderItems.HANDLE_KEN.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("drive").changeModel("drive.geo.json").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.legendChemy).has_basic_model());

	public static final DeferredItem<Item> GHOST_RIDE_CHEMY_CARD = ITEMS.register("ghost_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(EffectCore.GHOST, 40, 0,true,false))
					.setSummonBelt((RiderDriverItem) GhostRiderItems.GHOST_DRIVER.get()).addSummonWeapon(GhostRiderItems.GAN_GUN_SABER_BLADE.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("decade_ghost").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.legendChemy).has_basic_model());

	public static final DeferredItem<Item> EX_AID_RIDE_CHEMY_CARD = ITEMS.register("ex_aid_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.setSummonBelt((RiderDriverItem) ExAidRiderItems.GAMER_DRIVER_EX_AID.get())
					.setSummonForm((RiderFormChangeItem) ExAidRiderItems.MIGHTY_ACTION_X_GASHAT.get()).addSummonWeapon(ExAidRiderItems.GASHACON_BREAKER.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("ex_aid").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.legendChemy).has_basic_model());

	public static final DeferredItem<Item> BUILD_RIDE_CHEMY_CARD = ITEMS.register("build_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false))
					.setSummonBelt((RiderDriverItem) BuildRiderItems.BUILD_DRIVER.get()).addSummonWeapon(BuildRiderItems.DRILL_CRUSHER.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("decade_build").addAlternative(FOURZE_RIDE_CHEMY_CARD_GOTCHARD.get())
					.addToList(NEED_ITEM_FullFullRocket).addToList(ChemyRiserItem.legendChemy).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ZI_O_RIDE_CHEMY_CARD = ITEMS.register("zi_o_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
					.setSummonBelt((RiderDriverItem) ZiORiderItems.ZIKU_DRIVER_ZI_O.get()).addSummonWeapon(ZiORiderItems.ZIKAN_GIRADE.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("zi_o").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.legendChemy).has_basic_model());

	public static final DeferredItem<Item> ZERO_ONE_RIDE_CHEMY_CARD = ITEMS.register("zero_one_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false))
					.setSummonBelt((RiderDriverItem) ZeroOneRiderItems.HIDEN_ZERO_ONE_DRIVER.get()).addSummonWeapon(ZeroOneRiderItems.ATTACHE_CALIBUR.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("zero_one").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.legendChemy).has_basic_model());

	public static final DeferredItem<Item> SABER_RIDE_CHEMY_CARD = ITEMS.register("saber_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"_saber","legend","legendriver_belt"
					,new MobEffectInstance(EffectCore.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.setSummonBelt((RiderDriverItem) SaberRiderItems.SEIKEN_SWORDRIVER_DRIVER_SABER.get()).addSummonWeapon(SaberRiderItems.KAENKEN_REKKA.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.legendChemy).has_basic_model());

	public static final DeferredItem<Item> REVI_RIDE_CHEMY_CARD = ITEMS.register("revi_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.setSummonBelt((RiderDriverItem) ReviceRiderItems.REVICE_DRIVER.get()).addSummonWeapon(ReviceRiderItems.OHINBUSTER_50.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("revi").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.legendChemy).has_basic_model());

	public static final DeferredItem<Item> VICE_RIDE_CHEMY_CARD = ITEMS.register("vice_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.setSummonBelt((RiderDriverItem) ReviceRiderItems.BUDDY_BUCKLE.get()).addSummonWeapon(ReviceRiderItems.OSUTODERUHAMMER_50.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("vice").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.legendChemy).has_basic_model());

	public static final DeferredItem<Item> GEATS_RIDE_CHEMY_CARD = ITEMS.register("geats_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"_geats","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(EffectCore.FIRE_SHOT, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(EffectCore.BOOST, 40, 0,true,false))
					.setSummonBelt((RiderDriverItem) GeatsRiderItems.DESIRE_DRIVER_GEATS.get()).addSummonWeapon(GeatsRiderItems.MAGNUM_SHOOTER_40X.get())
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).addToList(ChemyRiserItem.legendChemy).has_basic_model());

	public static final DeferredItem<Item> GOTCHARD_RIDE_CHEMY_CARD = ITEMS.register("gotchard_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
					.alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("gotchard").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
					.addToList(ChemyRiserItem.legendChemy).has_basic_model());

    public static final DeferredItem<Item> Gavv_RIDE_CHEMY_CARD = ITEMS.register("gavv_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),"","legend","legendriver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
                    .alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("gavv").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
                    .addToList(ChemyRiserItem.legendChemy).has_basic_model());

    public static final DeferredItem<Item> ZEZTZ_RIDE_CHEMY_CARD = ITEMS.register("zeztz_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),"","legend","legendriver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false))
                    .alsoChange2ndSlot(ModdedItemCore.BLANK_FORM.get()).isGlowing().changeRiderName("zeztz").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM)
                    .addToList(ChemyRiserItem.legendChemy).has_basic_model());


    public static final DeferredItem<Item> KUUGA_ULTIMATE_RIDE_CHEMY_CARD = ITEMS.register("kuuga_ultimate_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 5,true,false),
					new MobEffectInstance(EffectCore.FIRE_ARMOR, 40, 5,true,false))
					.setBaseSummon((RiderDriverItem) KuugaRiderItems.ARCLE.get())
					.setSuperSummon((RiderDriverItem) KuugaRiderItems.ARCLE.get(), (RiderFormChangeItem) KuugaRiderItems.KUUGA_AMAZING_MIGHTY.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2).isGlowing()
					.changeRiderName("kuuga_ultimate").changeModel("kuuga_ultimate.geo.json").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> AGITO_SHINING_RIDE_CHEMY_CARD = ITEMS.register("agito_shining_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false))
					.setBaseSummon((RiderDriverItem) AgitoRiderItems.ALTERING.get())
					.setSuperSummon((RiderDriverItem) AgitoRiderItems.ALTERING.get(), (RiderFormChangeItem) AgitoRiderItems.AGITO_BURNING.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2).isGlowing()
					.changeRiderName("agito_shining").changeModel("agito_shining.geo.json").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> RYUKI_SURVIVE_RIDE_CHEMY_CARD = ITEMS.register("ryuki_survive_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"_ryuki_survive","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false))
					.setBaseSummon((RiderDriverItem) RyukiRiderItems.RYUKIDRIVER.get())
					.setSuperSummon((RiderDriverItem) RyukiRiderItems.RYUKIDRIVER.get(), (RiderFormChangeItem) RyukiRiderItems.DRAG_SHIELD_VENT_FORM.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2).isGlowing()
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> FAIZ_BLASTER_RIDE_CHEMY_CARD = ITEMS.register("faiz_blaster_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"_faiz_blaster","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 1,true,false))
					.setBaseSummon((RiderDriverItem) FaizRiderItems.FAIZ_DRIVER.get())
					.setSuperSummon((RiderDriverItem) FaizRiderItems.FAIZ_DRIVER.get(), (RiderFormChangeItem) FaizRiderItems.FAIZ_AXEL_FORM.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2).isGlowing()
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> BLADE_KING_RIDE_CHEMY_CARD = ITEMS.register("blade_king_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false))
					.setBaseSummon((RiderDriverItem) BladeRiderItems.BLAYBUCKLE.get())
					.setSuperSummon((RiderDriverItem) BladeRiderItems.BLAYBUCKLE.get(), (RiderFormChangeItem) BladeRiderItems.FUSION_EAGLE.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.changeRiderName("blade_king").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ARMED_HIBIKI_RIDE_CHEMY_CARD = ITEMS.register("armed_hibiki_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false))
					.setBaseSummon((RiderDriverItem) HibikiRiderItems.HIBIKIDRIVER.get())
					.setSuperSummon((RiderDriverItem) HibikiRiderItems.HIBIKIDRIVER.get(), (RiderFormChangeItem) HibikiRiderItems.HENSHIN_ONSA_KURENAI.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
					.changeRiderName("hibiki_armed").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> KABUTO_HYPER_RIDE_CHEMY_CARD = ITEMS.register("kabuto_hyper_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 7,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.setBaseSummon((RiderDriverItem) KabutoRiderItems.KABUTO_RIDER_BELT.get())
					.setSuperSummon((RiderDriverItem) KabutoRiderItems.KABUTO_RIDER_BELT.get(), (RiderFormChangeItem) KabutoRiderItems.KABUTO_ZECTER.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.changeRiderName("kabuto_hyper").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> DEN_O_LINER_RIDE_CHEMY_CARD = ITEMS.register("den_o_liner_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false))
					.setBaseSummon((RiderDriverItem) DenORiderItems.DEN_O_BELT.get())
					.setSuperSummon((RiderDriverItem) DenORiderItems.DEN_O_BELT.get(), (RiderFormChangeItem) DenORiderItems.KTAROS.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.changeRiderName("den_o_liner").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> KIVA_EMPEROR_RIDE_CHEMY_CARD = ITEMS.register("kiva_emperor_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false))
					.setBaseSummon((RiderDriverItem) KivaRiderItems.KIVAT_BELT.get())
					.setSuperSummon((RiderDriverItem) KivaRiderItems.KIVAT_BELT.get(), (RiderFormChangeItem) KivaRiderItems.DOGABAKI.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.changeRiderName("kiva_emperor").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> DECADE_COMPLETE_RIDE_CHEMY_CARD = ITEMS.register("decade_complete_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.setBaseSummon((RiderDriverItem) DecadeRiderItems.DECADRIVER.get())
					.setSuperSummon((RiderDriverItem) DecadeRiderItems.NEO_DECADRIVER.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.changeRiderName("decade_complete").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> W_CYCLONE_JOKER_XTREME_RIDE_CHEMY_CARD = ITEMS.register("w_cyclone_joker_xtreme_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"_w_cyclone_joker_xtreme","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 3,true,false))
					.setBaseSummon((RiderDriverItem) WRiderItems.WDRIVER.get())
					.setSuperSummon((RiderDriverItem) WRiderItems.WDRIVER.get(), (RiderFormChangeItem) WRiderItems.FANG_MEMORY.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> OOO_PUTOTYRA_RIDE_CHEMY_CARD = ITEMS.register("ooo_putotyra_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"_ooo_putotyra","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40	, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(EffectCore.FLYING,400,0,true,false))
					.setBaseSummon((RiderDriverItem) OOORiderItems.OOODRIVER.get())
					.setSuperSummon((RiderDriverItem) OOORiderItems.OOODRIVER.get(), (RiderFormChangeItem) OOORiderItems.KUJAKU_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.CONDOR_MEDAL.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).hasCape().isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> FOURZE_COSMIC_RIDE_CHEMY_CARD = ITEMS.register("fourze_cosmic_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
					.setBaseSummon((RiderDriverItem) FourzeRiderItems.FOURZE_DRIVER.get())
					.setSuperSummon((RiderDriverItem) FourzeRiderItems.FOURZE_DRIVER.get(), (RiderFormChangeItem) FourzeRiderItems.MAGNET_ASTROSWITCH_N.get(), (RiderFormChangeItem) FourzeRiderItems.MAGNET_ASTROSWITCH_S.get(), (RiderFormChangeItem) FourzeRiderItems.FOURZE_MAGNET_STATES.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.changeRiderName("fourze_cosmic").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> WIZARD_INFINITY_RIDE_CHEMY_CARD = ITEMS.register("wizard_infinity_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(EffectCore.PUNCH, 40, 5,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.setBaseSummon((RiderDriverItem) WizardRiderItems.WIZARDRIVER.get())
					.setSuperSummon((RiderDriverItem) WizardRiderItems.WIZARDRIVER.get(), (RiderFormChangeItem) WizardRiderItems.DRAGO_TIMER.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.changeRiderName("wizard_infinity").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GAIM_KIWAMI_RIDE_CHEMY_CARD = ITEMS.register("gaim_kiwami_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"_gaim_kiwami","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.setBaseSummon((RiderDriverItem) GaimRiderItems.SENGOKU_DRIVER_GAIM.get())
					.setSuperSummon((RiderDriverItem) GaimRiderItems.SENGOKU_DRIVER_GAIM.get(), (RiderFormChangeItem) GaimRiderItems.KACHIDOKI_LOCKSEED.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> DRIVE_TRIDORON_RIDE_CHEMY_CARD = ITEMS.register("drive_tridoron_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false))
					.setBaseSummon((RiderDriverItem) DriveRiderItems.DRIVE_DRIVER.get())
					.setSuperSummon((RiderDriverItem) DriveRiderItems.DRIVE_DRIVER.get(), (RiderFormChangeItem) DriveRiderItems.SHIFT_FORMULA.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().changeModel("drive_tridoron.geo.json").addNeedForm(LEGENDARY_LEGEND.get(),2)
					.changeRiderName("drive_tridoron").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GHOST_MUGEN_RIDE_CHEMY_CARD = ITEMS.register("ghost_mugen_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"_ghost_mugen","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(EffectCore.GHOST, 40, 0,true,false))
					.setBaseSummon((RiderDriverItem) GhostRiderItems.GHOST_DRIVER.get())
					.setSuperSummon((RiderDriverItem) GhostRiderItems.EYECON_DRIVER_G.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.hasCape()
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> EX_AID_MUTEKI_RIDE_CHEMY_CARD = ITEMS.register("ex_aid_muteki_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 6,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(EffectCore.MUTEKI, 40, 0,true,false))
					.setBaseSummon((RiderDriverItem) ExAidRiderItems.GAMER_DRIVER_EX_AID.get(), (RiderFormChangeItem) ExAidRiderItems.MIGHTY_ACTION_X_GASHAT.get())
					.setSuperSummon((RiderDriverItem) ExAidRiderItems.GAMER_DRIVER_EX_AID.get(), (RiderFormChangeItem) ExAidRiderItems.MAXIMUM_MIGHTY_X_GASHAT.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.changeRiderName("ex_aid_muteki").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> BUILD_GENIUS_RIDE_CHEMY_CARD = ITEMS.register("build_genius_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"_build_genius","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 0, true, false))
					.setBaseSummon((RiderDriverItem) BuildRiderItems.BUILD_DRIVER.get())
					.setSuperSummon((RiderDriverItem) BuildRiderItems.BUILD_DRIVER.get(), (RiderFormChangeItem) BuildRiderItems.FULLFULL_RABBIT_TANK_BOTTLE.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GRAND_ZI_O_RIDE_CHEMY_CARD = ITEMS.register("grand_zi_o_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
					.setBaseSummon((RiderDriverItem) ZiORiderItems.ZIKU_DRIVER_ZI_O.get())
					.setSuperSummon((RiderDriverItem) ZiORiderItems.ZIKU_DRIVER_ZI_O.get(), (RiderFormChangeItem) ZiORiderItems.ZI_O_II_RIDEWATCH.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.changeRiderName("zi_o_grand").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ZERO_TWO_RIDE_CHEMY_CARD = ITEMS.register("zero_two_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 8,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.setBaseSummon((RiderDriverItem) ZeroOneRiderItems.HIDEN_ZERO_ONE_DRIVER.get())
					.setSuperSummon((RiderDriverItem) ZeroOneRiderItems.HIDEN_ZERO_ONE_DRIVER.get(), (RiderFormChangeItem) ZeroOneRiderItems.METALCLUSTER_HOPPER_PROGRISEKEY.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.changeRiderName("zero_two").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> XROSS_SABER_RIDE_CHEMY_CARD = ITEMS.register("xross_saber_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"_xross_saber","legend","legendriver_belt_l",
					new MobEffectInstance(EffectCore.SLASH, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
					.setBaseSummon((RiderDriverItem) SaberRiderItems.SEIKEN_SWORDRIVER_DRIVER_SABER.get())
					.setSuperSummon((RiderDriverItem) SaberRiderItems.SEIKEN_SWORDRIVER_DRIVER_SABER.get(), (RiderFormChangeItem) SaberRiderItems.ELEMENTAL_DRAGON_WONDER_RIDE_BOOK.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ULTIMATE_REVI_RIDE_CHEMY_CARD = ITEMS.register("ultimate_revi_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 8,true,false))
					.setBaseSummon((RiderDriverItem) ReviceRiderItems.REVICE_DRIVER.get())
					.setSuperSummon((RiderDriverItem) ReviceRiderItems.REVICE_DRIVER.get(), (RiderFormChangeItem) ReviceRiderItems.THUNDER_GALE_VISTAMP.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.changeRiderName("revi_ultimate").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ULTIMATE_VICE_RIDE_CHEMY_CARD = ITEMS.register("ultimate_vice_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 8,true,false))
					.setBaseSummon((RiderDriverItem) ReviceRiderItems.BUDDY_BUCKLE.get())
					.setSuperSummon((RiderDriverItem) ReviceRiderItems.BUDDY_BUCKLE.get(), (RiderFormChangeItem) ReviceRiderItems.VOLCANO_VISTAMP_VICE.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.changeRiderName("vice_ultimate").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GEATS_IX_RIDE_CHEMY_CARD = ITEMS.register("geats_ix_ride_chemy_card",
			() -> new LegendaryChemyCardItem(new Item.Properties().rarity(Rarity.RARE),"_geats_ix","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 6,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 7,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 2,true,false),
					new MobEffectInstance(EffectCore.FIRE_PUNCH, 40, 6,true,false),
					new MobEffectInstance(EffectCore.BOOST, 40, 6,true,false))
					.setBaseSummon((RiderDriverItem) GeatsRiderItems.DESIRE_DRIVER_GEATS.get(), (RiderFormChangeItem) GeatsRiderItems.MAGNUM_RAISE_BUCKLE.get())
					.setSuperSummon((RiderDriverItem) GeatsRiderItems.DESIRE_DRIVER_GEATS.get(), (RiderFormChangeItem) GeatsRiderItems.UNITE_GRIP.get())
					.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).isGlowing().hasStaticWings().addNeedForm(LEGENDARY_LEGEND.get(),2)
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());


	public static final DeferredItem<Item> ARK_ZERO_RIDE_CHEMY_CARD = ITEMS.register("ark_zero_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"_outsiders","ark_zero","ark_driver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.setSummonBelt((RiderDriverItem) ZeroOneRiderItems.ARK_DRIVER_ZERO.get())
					.IsBeltGlowing().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ARK_ONE_RIDE_CHEMY_CARD = ITEMS.register("ark_one_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"_saigetsu","ark_zero","ark_driver_belt_1",
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
					.setSummonBelt((RiderDriverItem) ZeroOneRiderItems.ARK_DRIVER_ZERO.get())
					.setSummonForm((RiderFormChangeItem) ZeroOneRiderItems.ARK_ONE_PROGRISEKEY.get())
					.IsBeltGlowing().isGlowing().changeRiderName("ark_one").addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ETERNAL_RIDE_CHEMY_CARD = ITEMS.register("eternal_ride_chemy_card",
			() -> new LegendChemyCardItem(new Item.Properties(),"_yellowed","eternal","lostdriver_belt_e",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
				}
			}.setSummonBelt((RiderDriverItem) WRiderItems.LOSTDRIVER_ETERNAL.get()).addSummonWeapon(WRiderItems.ETERNAL_EDGE.get())
					.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());


	public static final DeferredItem<Item> GOTCHAR_IGNITER_DB = ITEMS.register("gotchar_igniter_db",
			() -> new RiderFormChangeItem(new Item.Properties(),"_fire","gotchard_daybreak","gotchardriver_belt_daybreak_fire",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(EffectCore.BOOST,40,4,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE,40,0,true,false),
					new MobEffectInstance(EffectCore.FIRE_PUNCH,40,2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.hasCape().isGlowing().model_has_different_name("gotchar_igniter").has_basic_model());

	public static final DeferredItem<Item> GOTCHAR_IGNITER_EM = ITEMS.register("gotchar_igniter_em",
			() -> new RiderFormChangeItem(new Item.Properties(),"_exceed_mighty_fire","gotchard","gotchardriver_belt_fire",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(EffectCore.BOOST,40,2,true,false),
					new MobEffectInstance(EffectCore.FIRE_PUNCH,40,0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addAlternative(GOTCHAR_IGNITER_DB.get()).addNeedForm(KUUGA_RIDE_CHEMY_CARD_GOTCHARD.get(),1).isGlowing().changeModel("gotchard_fire.geo.json").model_has_different_name("gotchar_igniter").has_basic_model());

	public static final DeferredItem<Item> GOTCHAR_IGNITER_AW = ITEMS.register("gotchar_igniter_aw",
			() -> new RiderFormChangeItem(new Item.Properties(),"_ant_wrestler_fire","gotchard","gotchardriver_belt_fire",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(EffectCore.BOOST,40,2,true,false),
					new MobEffectInstance(EffectCore.FIRE_PUNCH,40,1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addAlternative(GOTCHAR_IGNITER_EM.get()).addNeedForm(ANTROOPER_RIDE_CHEMY_CARD.get(),1).isGlowing().changeModel("gotchard_fire.geo.json").model_has_different_name("gotchar_igniter").has_basic_model());

	public static final DeferredItem<Item> GOTCHAR_IGNITER_AS = ITEMS.register("gotchar_igniter_as",
			() -> new RiderFormChangeItem(new Item.Properties(),"_appare_skebow_fire","gotchard","gotchardriver_belt_fire",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(EffectCore.BOOST,40,4,true,false),
					new MobEffectInstance(EffectCore.FIRE_PUNCH,40,1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addAlternative(GOTCHAR_IGNITER_AW.get()).addNeedForm(APPAREBUSHIDO_RIDE_CHEMY_CARD.get(),1).isGlowing().changeModel("gotchard_fire.geo.json").model_has_different_name("gotchar_igniter").has_basic_model());

	public static final DeferredItem<Item> GOTCHAR_IGNITER = ITEMS.register("gotchar_igniter",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_fire","gotchard","gotchardriver_belt_fire",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(EffectCore.BOOST,40,3,true,false),
					new MobEffectInstance(EffectCore.FIRE_PUNCH,40,1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addAlternative(GOTCHAR_IGNITER_AS.get()).addNeedForm(HOPPER1_RIDE_CHEMY_CARD.get(),1).isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GOTCHARD_HELMET = ITEMS.register("gotchard_head",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));
	public static final DeferredItem<Item> GOTCHARD_CHESTPLATE = ITEMS.register("gotchard_torso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));
	public static final DeferredItem<Item> GOTCHARD_LEGGINGS = ITEMS.register("gotchard_legs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));


	public static final DeferredItem<Item> GOTCHARDRIVER = ITEMS.register("gotchardriver",
			() -> new GotcharDriverItem(ArmorMaterials.DIAMOND,"gotchard", HOPPER1_RIDE_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS
					, new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("gotchandraw_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new GotchandrawHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.hasInventoryGui().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> GOTCHARDRIVER_DAYBREAK = ITEMS.register("gotchardriver_daybreak",
			() -> new GotcharDriverItem(ArmorMaterials.DIAMOND,"gotchard_daybreak", HOPPER1_RIDE_CHEMY_CARD_DAYBREAK ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("gotchandraw_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new GotchandrawHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.hasInventoryGui().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> GOTCHARDRIVER_BROTHER = ITEMS.register("gotchardriver_brother",
			() -> new GotcharDriverBrothersItem(ArmorMaterials.DIAMOND,"gotchar_brother", HOPPER1_RIDE_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS
					, new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("gotchandraw_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new GotchandrawHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.hasInventoryGui().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> ALCHEMISDRIVER = ITEMS.register("alchemisdriver",
			() -> new GotcharDriverItem(ArmorMaterials.DIAMOND,"majade", THE_SUN_RIDE_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("gotchandraw_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new GotchandrawHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.hasInventoryGui().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> ALCHEMISDRIVER_WIND = ITEMS.register("alchemisdriver_wind",
			() -> new GotcharDriverItem(ArmorMaterials.DIAMOND,"wind", KUROANA_RIDE_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("gotchandraw_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new GotchandrawHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.hasInventoryGui().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()).has_basic_model());

	public static final DeferredItem<Item> VALVARADRIVER = ITEMS.register("valvaradriver",
			() -> new ValvaraDriverItem(ArmorMaterials.DIAMOND,"valvarad_rider", MACHWHEEL_RIDE_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties())
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()).has_basic_model());

	public static final DeferredItem<Item>  DREADRIVER = ITEMS.register("dreadriver",
			() -> new GotcharDriverItem(ArmorMaterials.DIAMOND,"dread", STEAMLINER_REPLI_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item>  DREADRIVER_TROOPER = ITEMS.register("dreadriver_trooper",
			() -> new GotcharDriverItem(ArmorMaterials.DIAMOND,"dreatrooper", ANTROOPER_REPLI_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties()).hideBeltFormInfo().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item>  DREADRIVER_MEIKOKU_NO_SANSHIMAI = ITEMS.register("dreadriver_meikoku_no_sanshimai",
			() -> new GotcharDriverItem(ArmorMaterials.DIAMOND,"meikoku_no_sanshimai", STEAMLINER_REPLI_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS ,
					new Item.Properties()).hideBeltFormInfo().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> LEGENDRIVER = ITEMS.register("legendriver",
			() -> new LegenDriverItem(ArmorMaterials.DIAMOND,"legend", LEGEND_RIDE_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties())
					.addExtraBaseFormItems(ModdedItemCore.BLANK_FORM).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item>  ELDORADRIVER = ITEMS.register("eldoradriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dorado", DARK_ETHER_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties()).hideBeltFormInfo().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()).has_basic_model());

	public static final DeferredItem<Item>  ELDORADRIVER_ELD = ITEMS.register("eldoradriver_eld",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"eld", ELDRAGON_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties()).hideBeltFormInfo().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()).has_basic_model());

	public static final DeferredItem<Item> VALVARADRAW_BUCKLE = ITEMS.register("valvaradraw_buckle",
			() -> new ValvaradItem(ArmorMaterials.DIAMOND,"valvarad", MADWHEEL_RIDE_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties())
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> VALVARADRAW_BUCKLE_LACHESIS = ITEMS.register("valvaradraw_buckle_lachesis",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"valvarad_lachesis", MADWHEEL_REPLI_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties())
					.hideBeltFormInfo().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));



	public static final DeferredItem<Item> GOTCHANCOLLECTION_PANEL = ITEMS.register("gotchancollection_panel",
			() -> new GotchancollectionPanelItem().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());


	public static final DeferredItem<Item> GOTCHARGE_GUN = ITEMS.register("gotcharge_gun",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> GOTCHAR_TORNADO = ITEMS.register("gotchar_tornado",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> EXGOTCHALIBUR = ITEMS.register("exgotchalibur",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(NEED_ITEM_Super).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> VALVARUSHER = ITEMS.register("valvarusher",
			() -> new ValvarusherItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> BLOODY_AB = ITEMS.register("bloody_ab",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> BLOODY_BB = ITEMS.register("bloody_bb",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> BLOODY_UC = ITEMS.register("bloody_uc",
			() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> BLOODY_DO = ITEMS.register("bloody_do",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> TROOP_GOLDENT = ITEMS.register("troop_goldent",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> TROOP_AUTHIFY = ITEMS.register("troop_authify",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> LEGEND_RIDE_MAGNUM = ITEMS.register("legend_ride_magnum",
			() -> new LegendRideMagnumItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> LEGEND_KAMEN_RISER = ITEMS.register("legend_kamen_riser",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> DORADO_SCYTHE = ITEMS.register("dorado_scythe",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).changeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> CHEMY_RISER = ITEMS.register("chemy_riser",
			() -> new ChemyRiserItem().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> CHEMY_RISER_SUPANA = ITEMS.register("chemy_riser_supana",
			() -> new ChemyRiserItem().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ALCHEMIST_RING_BLUE = ITEMS.register("alchemist_ring_blue",
			() -> new BaseItem(new Item.Properties()).KeepItem().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ALCHEMIST_RING_GREEN = ITEMS.register("alchemist_ring_green",
			() -> new BaseItem(new Item.Properties()).KeepItem().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ALCHEMIST_RING_RED = ITEMS.register("alchemist_ring_red",
			() -> new BaseItem(new Item.Properties()).KeepItem().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ALCHEMIST_RING_ORANGE = ITEMS.register("alchemist_ring_orange",
			() -> new BaseItem(new Item.Properties()).KeepItem().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ALCHEMIST_RING_PURPLE = ITEMS.register("alchemist_ring_purple",
			() -> new BaseItem(new Item.Properties()).KeepItem().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ALCHEMIST_RING_GOLD = ITEMS.register("alchemist_ring_gold",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).KeepItem().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ALCHEMIST_RING_BLACK = ITEMS.register("alchemist_ring_black",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).KeepItem().addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ALCHEMIST_RING_NO_GEM = ITEMS.register("alchemist_ring_no_gem",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> GLION_GOLD_CUBE = ITEMS.register("glion_gold_cube",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> YOUNG_ICHINOSE_TREASURE = ITEMS.register("young_ichinose_treasure",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> UNFINISHED_EXGOTCHALIBUR = ITEMS.register("unfinished_exgotchalibur",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ATROPOS_ORIGAMI = ITEMS.register("atropos_origami",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> PHILOSOPHERS_STONE_FRAGMENT = ITEMS.register("philosophers_stone_fragment",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> KUUGA_KIVA_LEGEND = ITEMS.register("kuuga_kiva_legend",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());
	public static final DeferredItem<Item> DECADE_EX_AID_LEGEND = ITEMS.register("decade_ex_aid_legend",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());
	public static final DeferredItem<Item> BUILD_GOTCHARD_LEGEND = ITEMS.register("build_gotchard_legend",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GOTCHARD_TAB_ITEM).has_basic_model());


	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}