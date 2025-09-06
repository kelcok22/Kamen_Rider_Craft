package com.kelco.kamenridercraft.item;

import java.util.ArrayList;
import java.util.List;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machineBlocks.GaiaMemoryRefinerBlock;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.gotchard.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Gotchard_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static String[] Gotchards = new String[] {"gotchard","gotchar_brother"};

	public static List<Item> NEED_ITEM_SteamHopper= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_AppareSkebow= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_VenomMariner= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_AntWrestler= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_BurningGorilla= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_NeedleHawk= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_DokkiriShovel= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_GoldMechanichor= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_HiikesuRose= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_LightningJungle= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_MarsPhoenix= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_MarsPhoenix2= new ArrayList<Item>();

	public static List<Item> NEED_ITEM_Platina= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_Rainbow= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_Ultima= new ArrayList<Item>();

	public static List<Item> NEED_ITEM_OdoriMantis= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_MadPilets= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_EnergyMaru= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_BulletChoucho= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_SmaHotaru= new ArrayList<Item>();

	public static List<Item> NEED_ITEM_SunUnicorn= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_MoonCerberus= new ArrayList<Item>();

	public static List<Item> NEED_ITEM_Valvarad= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_OrochiShovel= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_AngeCopter= new ArrayList<Item>();

	public static List<Item> NEED_ITEM_TypeThree= new ArrayList<Item>();

	public static List<Item> NEED_ITEM_SteamHopper_daybreak= new ArrayList<Item>();

	public static List<Item> NEED_ITEM_ExceedMighty= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_CycloneTaToBa= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_FullFullRocket= new ArrayList<Item>();

	public static final DeferredItem<Item> ARK_ONE_MALGAM = ITEMS.register("ark_one_malgam",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_malgam","ark_zero","ark_driver_belt_1",
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false)).ChangeRiderName("ark_one"));


	public static final DeferredItem<Item> GOTCHARD_LOGO = ITEMS.register("gotchard_logo",
    		() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/gotchard")), new Item.Properties()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> BLANK_RIDE_CHEMY_CARD = ITEMS.register("blank_ride_chemy_card",
    		() -> new BaseItem(new Item.Properties()).AddToList(KamenRiderCraftCore.CHEMY_CARD).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> HOPPER1_RIDE_CHEMY_CARD = ITEMS.register("hopper1_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","gotchard","gotchardriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                            player.getX(), player.getY()+1,
                            player.getZ(), 300, 0, 0, 0, 0.1);
                }
            }.IsGlowing().AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_SteamHopper).AddToList(NEED_ITEM_SteamHopper)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Insect_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> PIKAHOTARU_RIDE_CHEMY_CARD = ITEMS.register("pikahotaru_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_sma_hotaru","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_SmaHotaru).AddToList(NEED_ITEM_SmaHotaru)
					.AddToList(ChemyRiserItem.Insect_CHEMY).AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GENGENCHOUCHO_RIDE_CHEMY_CARD = ITEMS.register("gengenchoucho_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_bullet_choucho","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.GATLING, 40, 0,true,false))
					.AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_BulletChoucho).AddToList(NEED_ITEM_BulletChoucho)
					.AddToList(ChemyRiserItem.Insect_CHEMY).AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> BAKUONZEMI_RIDE_CHEMY_CARD = ITEMS.register("bakuonzemi_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Insect_CHEMY).has_basic_model());
    
    public static final DeferredItem<Item> ANTROOPER_RIDE_CHEMY_CARD = ITEMS.register("antrooper_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_ant_wrestler","gotchard","gotchardriver_belt",
            		new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
					.AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_AntWrestler).AddToList(NEED_ITEM_AntWrestler)
					.AddToList(ChemyRiserItem.Insect_CHEMY).AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> GREATONBO_RIDE_CHEMY_CARD = ITEMS.register("greatonbo_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Insect_CHEMY).has_basic_model());

	public static final DeferredItem<Item> STAGVINE_RIDE_CHEMY_CARD = ITEMS.register("stagvine_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Insect_CHEMY).has_basic_model());

	public static final DeferredItem<Item> KAISERBEE_RIDE_CHEMY_CARD = ITEMS.register("kaiserbee_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Insect_CHEMY).has_basic_model());

	public static final DeferredItem<Item> KAMANTIS_RIDE_CHEMY_CARD = ITEMS.register("kamantis_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_odori_mantis","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_OdoriMantis).AddToList(NEED_ITEM_OdoriMantis)
					.AddToList(RiderTabs.GOTCHARD_TAB_ITEM).AddToList(ChemyRiserItem.Insect_CHEMY).AddToList(ChemyRiserItem.ALL_CHEMY).has_basic_model());

	public static final DeferredItem<Item> BEETLX_RIDE_CHEMY_CARD = ITEMS.register("beetlx_ride_chemy_card",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ODORIPPA_RIDE_CHEMY_CARD = ITEMS.register("odorippa_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),KAMANTIS_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_OdoriMantis)
					.AddToList(RiderTabs.GOTCHARD_TAB_ITEM).AddToList(ChemyRiserItem.Job_CHEMY).AddToList(ChemyRiserItem.ALL_CHEMY).has_basic_model());
    
    public static final DeferredItem<Item> DOKKIRIMAJIN_RIDE_CHEMY_CARD = ITEMS.register("dokkirimajin_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_dokkiri_shovel","gotchard","gotchardriver_belt",
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
					.AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_DokkiriShovel).AddToList(NEED_ITEM_DokkiriShovel).AddToList(ChemyRiserItem.Job_CHEMY)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> DOCTORKOZO_RIDE_CHEMY_CARD = ITEMS.register("doctorkozo_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Job_CHEMY).has_basic_model());

	public static final DeferredItem<Item> PILETS_RIDE_CHEMY_CARD = ITEMS.register("pilets_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_mad_pilets","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(Effect_core.CANNON,40,1,true,false))
					.AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_MadPilets).AddToList(NEED_ITEM_MadPilets).AddToList(ChemyRiserItem.Job_CHEMY)
					.AddToList(RiderTabs.GOTCHARD_TAB_ITEM).AddToList(ChemyRiserItem.ALL_CHEMY).has_basic_model());
    
    public static final DeferredItem<Item> WRESTLER_G_RIDE_CHEMY_CARD = ITEMS.register("wrestler_g_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),ANTROOPER_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_AntWrestler)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Job_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> SASUKEMARU_RIDE_CHEMY_CARD = ITEMS.register("sasukemaru_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_energy_maru","gotchard","gotchardriver_belt",
					new MobEffectInstance(Effect_core.STEALTH, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED,40,3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST,40,1,true,false))
					.AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_EnergyMaru).AddToList(NEED_ITEM_EnergyMaru).AddToList(ChemyRiserItem.Job_CHEMY)
					.AddToList(RiderTabs.GOTCHARD_TAB_ITEM).AddToList(ChemyRiserItem.ALL_CHEMY).has_basic_model());

	public static final DeferredItem<Item> BULLETBAANG_RIDE_CHEMY_CARD = ITEMS.register("bulletbaang_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),GENGENCHOUCHO_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_BulletChoucho)
					.AddToList(RiderTabs.GOTCHARD_TAB_ITEM).AddToList(ChemyRiserItem.Job_CHEMY).AddToList(ChemyRiserItem.ALL_CHEMY).has_basic_model());
    
    public static final DeferredItem<Item> APPAREBUSHIDO_RIDE_CHEMY_CARD = ITEMS.register("apparebushido_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_appare_skebow","gotchard","gotchardriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
            		new MobEffectInstance(Effect_core.SLASH, 40, 1,true,false))
					.AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_AppareSkebow).AddToList(ChemyRiserItem.Job_CHEMY).AddToList(NEED_ITEM_AppareSkebow)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> KARYUDOS_RIDE_CHEMY_CARD = ITEMS.register("karyudos_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Job_CHEMY).has_basic_model());

	public static final DeferredItem<Item> X_WIZARD_RIDE_CHEMY_CARD = ITEMS.register("x_wizard_ride_chemy_card",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> SPICLE_RIDE_CHEMY_CARD = ITEMS.register("spicle_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Vehicle_CHEMY).has_basic_model());
    
    public static final DeferredItem<Item> SKEBOWS_RIDE_CHEMY_CARD = ITEMS.register("skebows_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),APPAREBUSHIDO_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_AppareSkebow)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Vehicle_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
    public static final DeferredItem<Item> HIIKESCUE_RIDE_CHEMY_CARD = ITEMS.register("hiikescue_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_hiikesu_rose","gotchard","gotchardriver_belt",
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
            		new MobEffectInstance(Effect_core.REFLECT, 40, 1,true,false))
					.AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_HiikesuRose).AddToList(NEED_ITEM_HiikesuRose).AddToList(ChemyRiserItem.ALL_CHEMY)
					.AddToList(ChemyRiserItem.Vehicle_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> GEKIOCOPTER_RIDE_CHEMY_CARD_V = ITEMS.register("gekiocopter_ride_chemy_card_v",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ange_copter","valvarad_rider","valvaradriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false))
			.AddNeedItemList(NEED_ITEM_AngeCopter).has_basic_model().model_has_different_name("gekiocopter_ride_chemy_card"));

	public static final DeferredItem<Item> GEKIOCOPTER_RIDE_CHEMY_CARD = ITEMS.register("gekiocopter_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","valvarad","",
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
            		new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false))
            .ChangeSlot(2).addAlternative(GEKIOCOPTER_RIDE_CHEMY_CARD_V.get()).addSwitchForm(Modded_item_core.BLANK_FORM.get()).AddToList(NEED_ITEM_AngeCopter)
					.AddToList(ChemyRiserItem.Vehicle_CHEMY).AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
    public static final DeferredItem<Item> DEEPMARINER_RIDE_CHEMY_CARD = ITEMS.register("deepmariner_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_venom_mariner","gotchard","gotchardriver_belt",
            		new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 1,true,false),
            		new MobEffectInstance(Effect_core.ANTIPOISON, 40, 1,true,false))
					.AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_VenomMariner).AddToList(NEED_ITEM_VenomMariner).AddToList(ChemyRiserItem.ALL_CHEMY)
					.AddToList(ChemyRiserItem.Vehicle_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
    public static final DeferredItem<Item> MADWHEEL_RIDE_CHEMY_CARD = ITEMS.register("madwheel_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","valvarad","valvaradraw_buckle_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
			.addAlternative(PILETS_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_MadPilets).AddToList(ChemyRiserItem.ALL_CHEMY)
					.AddToList(ChemyRiserItem.Vehicle_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> MACHWHEEL_RIDE_CHEMY_CARD = ITEMS.register("machwheel_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","valvarad_rider","valvaradriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
					.AddNeedItemList(NEED_ITEM_Valvarad).AddToList(NEED_ITEM_Valvarad).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());
    
    public static final DeferredItem<Item> GOLDDASH_RIDE_CHEMY_CARD = ITEMS.register("golddash_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_gold_mechanichor","gotchard","gotchardriver_belt_big",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false))
			.ChangeBeltModel("geo/gotchard_belt_big.geo.json")
					.AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_GoldMechanichor).AddToList(NEED_ITEM_GoldMechanichor)
					.AddToList(ChemyRiserItem.Vehicle_CHEMY).AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
    public static final DeferredItem<Item> GUTSSHOVEL_RIDE_CHEMY_CARD_V = ITEMS.register("gutsshovel_ride_chemy_card_v",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_orochi_shovel","valvarad_rider","valvaradriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false))
					.addAlternative(DOKKIRIMAJIN_RIDE_CHEMY_CARD.get()).AddNeedItemList(NEED_ITEM_OrochiShovel)
					.has_basic_model().model_has_different_name("gutsshovel_ride_chemy_card"));

	public static final DeferredItem<Item> GUTSSHOVEL_RIDE_CHEMY_CARD = ITEMS.register("gutsshovel_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","valvarad","",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false))
			.ChangeSlot(3).addAlternative(GUTSSHOVEL_RIDE_CHEMY_CARD_V.get()).addSwitchForm(Modded_item_core.BLANK_FORM.get())
					.AddToList(NEED_ITEM_DokkiriShovel).AddToList(NEED_ITEM_OrochiShovel)
					.AddToList(ChemyRiserItem.Vehicle_CHEMY).AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> STEAMLINER_RIDE_CHEMY_CARD = ITEMS.register("steamliner_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),HOPPER1_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_SteamHopper)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Vehicle_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> EXCEEDFIGHTER_RIDE_CHEMY_CARD = ITEMS.register("exceedfighter_ride_chemy_card",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> YAMIBAT_RIDE_CHEMY_CARD = ITEMS.register("yamibat_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Animal_CHEMY).has_basic_model());

	public static final DeferredItem<Item> CATCHULA_RIDE_CHEMY_CARD = ITEMS.register("catchula_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Animal_CHEMY).has_basic_model());
    
    public static final DeferredItem<Item> MECHANICHANI_RIDE_CHEMY_CARD = ITEMS.register("mechanichani_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),GOLDDASH_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_GoldMechanichor)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Animal_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> BUSSASORRY_RIDE_CHEMY_CARD = ITEMS.register("bussasorry_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Animal_CHEMY).has_basic_model());

	public static final DeferredItem<Item> BOUNTYBUNNY_RIDE_CHEMY_CARD = ITEMS.register("bountybunny_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Animal_CHEMY).has_basic_model());
	   
    public static final DeferredItem<Item> HAWKSTAR_RIDE_CHEMY_CARD = ITEMS.register("hawkstar_ride_chemy_card",
         	() -> new RiderFormChangeItem(new Item.Properties(),0,"_needle_hawk","gotchard","gotchardriver_belt",
         		new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false),
         		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
				new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
					.AddCompatibilityList(Gotchards).hasFlyingWings(null).AddNeedItemList(NEED_ITEM_NeedleHawk).AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(NEED_ITEM_NeedleHawk)
					.AddToList(ChemyRiserItem.Animal_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> TSUPPARIHEBI_RIDE_CHEMY_CARD = ITEMS.register("tsupparihebi_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Animal_CHEMY).has_basic_model());
    
    public static final DeferredItem<Item> GORILLASENSEI_RIDE_CHEMY_CARD = ITEMS.register("gorillasensei_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_burning_gorilla","gotchard","gotchardriver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false),
            		new MobEffectInstance(Effect_core.FIRE_PUNCH, 40, 0,true,false))
					.AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_BurningGorilla).AddToList(NEED_ITEM_BurningGorilla)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Animal_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> GANVHALE_RIDE_CHEMY_CARD = ITEMS.register("ganvhale_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Animal_CHEMY).has_basic_model());

	public static final DeferredItem<Item> LIXION_RIDE_CHEMY_CARD = ITEMS.register("lixion_ride_chemy_card",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
   	public static final DeferredItem<Item> RAIDENJI_RIDE_CHEMY_CARD = ITEMS.register("raidenji_ride_chemy_card",
           	() -> new RiderFormChangeItem(new Item.Properties(),0,"_lightning_jungle","gotchard","gotchardriver_belt_big",
           			new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false))
			.ChangeBeltModel("geo/gotchard_belt_big.geo.json")
					.AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_LightningJungle).AddToList(NEED_ITEM_LightningJungle)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Artifact_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> KESUZO_RIDE_CHEMY_CARD = ITEMS.register("kesuzo_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Artifact_CHEMY).has_basic_model());

	public static final DeferredItem<Item> MITEMIRROR_RIDE_CHEMY_CARD = ITEMS.register("mitemirror_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Artifact_CHEMY).has_basic_model());

	public static final DeferredItem<Item> ENERGYL_RIDE_CHEMY_CARD = ITEMS.register("energyl_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),SASUKEMARU_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_EnergyMaru)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Artifact_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> PANPAKAPARKA_RIDE_CHEMY_CARD = ITEMS.register("panpakaparka_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Artifact_CHEMY).has_basic_model());

	public static final DeferredItem<Item> TELEVI_RIDE_CHEMY_CARD = ITEMS.register("televi_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Artifact_CHEMY).has_basic_model());

	public static final DeferredItem<Item> TIMELORD_RIDE_CHEMY_CARD = ITEMS.register("timelord_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Artifact_CHEMY).has_basic_model());

	public static final DeferredItem<Item> SMAPHONE_RIDE_CHEMY_CARD = ITEMS.register("smaphone_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),PIKAHOTARU_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_SmaHotaru)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Artifact_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> RENKINGROBO_RIDE_CHEMY_CARD = ITEMS.register("renkingrobo_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Artifact_CHEMY).has_basic_model());

	public static final DeferredItem<Item> X_FORTRESS_RIDE_CHEMY_CARD = ITEMS.register("x_fortress_ride_chemy_card",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> HAPPYCLOVER_RIDE_CHEMY_CARD = ITEMS.register("happyclover_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Plant_CHEMY).has_basic_model());
    
    public static final DeferredItem<Item> BURNINGNERO_RIDE_CHEMY_CARD = ITEMS.register("burningnero_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),GORILLASENSEI_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_BurningGorilla)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Plant_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> BAMBAMBOO_RIDE_CHEMY_CARD = ITEMS.register("bambamboo_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Plant_CHEMY).has_basic_model());
    
    public static final DeferredItem<Item> SABONEEDLE_RIDE_CHEMY_CARD = ITEMS.register("saboneedle_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),HAWKSTAR_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_NeedleHawk)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Plant_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
    public static final DeferredItem<Item> VENOMDAKE_RIDE_CHEMY_CARD = ITEMS.register("venomdake_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),DEEPMARINER_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_VenomMariner)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Plant_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> UTSUBOCCHAMA_RIDE_CHEMY_CARD = ITEMS.register("utsubocchama_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Plant_CHEMY).has_basic_model());
    
    public static final DeferredItem<Item> FLAYROSE_RIDE_CHEMY_CARD = ITEMS.register("flayrose_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),HIIKESCUE_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_HiikesuRose)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Plant_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> BUGLESIA_RIDE_CHEMY_CARD = ITEMS.register("buglesia_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Plant_CHEMY).has_basic_model());
    
    public static final DeferredItem<Item> JUNGLEJAN_RIDE_CHEMY_CARD = ITEMS.register("junglejan_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),RAIDENJI_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_LightningJungle)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Plant_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> XEGGDRASIL_RIDE_CHEMY_CARD = ITEMS.register("xeggdrasil_ride_chemy_card",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> CARERY_RIDE_CHEMY_CARD = ITEMS.register("carery_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Occult_CHEMY).has_basic_model());

	public static final DeferredItem<Item> BEROSOL_RIDE_CHEMY_CARD = ITEMS.register("berosol_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Occult_CHEMY).has_basic_model());

	public static final DeferredItem<Item> SAYZOMBIE_RIDE_CHEMY_CARD = ITEMS.register("sayzombie_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Occult_CHEMY).has_basic_model());

	public static final DeferredItem<Item> ANGELEAD_RIDE_CHEMY_CARD = ITEMS.register("angelead_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),GEKIOCOPTER_RIDE_CHEMY_CARD_V.get()).AddToList(NEED_ITEM_AngeCopter)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Occult_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ZUKYUMPIRE_RIDE_CHEMY_CARD = ITEMS.register("zukyumpire_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Occult_CHEMY).has_basic_model());

	public static final DeferredItem<Item> DAIOHNI_RIDE_CHEMY_CARD = ITEMS.register("daiohni_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),MACHWHEEL_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_Valvarad)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Occult_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> MACKRAKEN_RIDE_CHEMY_CARD = ITEMS.register("mackraken_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Occult_CHEMY).has_basic_model());

	public static final DeferredItem<Item> JYAMATANOOROCHI_RIDE_CHEMY_CARD = ITEMS.register("jyamatanoorochi_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),GUTSSHOVEL_RIDE_CHEMY_CARD_V.get()).AddToList(NEED_ITEM_OrochiShovel)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Occult_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> NINETAIL_RIDE_CHEMY_CARD = ITEMS.register("ninetail_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Occult_CHEMY).has_basic_model());

	public static final DeferredItem<Item> UFO_X_RIDE_CHEMY_CARD = ITEMS.register("ufo_x_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_super_cross_ufo_x","gotchard","gotchardriver_belt_s",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0, true, false),
					new MobEffectInstance(MobEffects.NIGHT_VISION,400,0,true,false))
					.AddCompatibilityList(Gotchards).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> NAMMONITE_RIDE_CHEMY_CARD = ITEMS.register("nammonite_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Ancient_CHEMY).has_basic_model());

	public static final DeferredItem<Item> AKUMANOCARIS_RIDE_CHEMY_CARD = ITEMS.register("akumanocaris_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Ancient_CHEMY).has_basic_model());

	public static final DeferredItem<Item> PAKURAPTOR_RIDE_CHEMY_CARD = ITEMS.register("pakuraptor_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Ancient_CHEMY).has_basic_model());

	public static final DeferredItem<Item> OJILACANTH_RIDE_CHEMY_CARD = ITEMS.register("ojilacanth_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Ancient_CHEMY).has_basic_model());

	public static final DeferredItem<Item> SABELIGER_RIDE_CHEMY_CARD = ITEMS.register("sabeliger_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Ancient_CHEMY).has_basic_model());

	public static final DeferredItem<Item> WARPTERA_RIDE_CHEMY_CARD = ITEMS.register("warptera_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Ancient_CHEMY).has_basic_model());

	public static final DeferredItem<Item> GIGALODON_RIDE_CHEMY_CARD = ITEMS.register("gigalodon_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Ancient_CHEMY).has_basic_model());

	public static final DeferredItem<Item> TRICERA_RIDE_CHEMY_CARD = ITEMS.register("tricera_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Ancient_CHEMY).has_basic_model());

	public static final DeferredItem<Item> BLIZZAMMOTH_RIDE_CHEMY_CARD = ITEMS.register("blizzammoth_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Ancient_CHEMY).has_basic_model());

	public static final DeferredItem<Item> X_REX_RIDE_CHEMY_CARD = ITEMS.register("x_rex_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_super_cross_x_rex","gotchard","gotchardriver_belt_s",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
					.AddCompatibilityList(Gotchards).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> MERCURIN_RIDE_CHEMY_CARD = ITEMS.register("mercurin_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Cosmic_CHEMY).has_basic_model());

	public static final DeferredItem<Item> KINKIRAVINA_RIDE_CHEMY_CARD = ITEMS.register("kinkiravina_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Cosmic_CHEMY).has_basic_model());

	public static final DeferredItem<Item> GOKIGENMETEON_RIDE_CHEMY_CARD = ITEMS.register("gokigenmeteon_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Cosmic_CHEMY).has_basic_model());

	public static final DeferredItem<Item> NEMINEMOON_RIDE_CHEMY_CARD = ITEMS.register("neminemoon_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_moon_cerberus","majade","alchemisdriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
					.AddNeedItemList(NEED_ITEM_MoonCerberus).AddToList(NEED_ITEM_MoonCerberus).AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Cosmic_CHEMY).has_basic_model());

	public static final DeferredItem<Item> FIREMARS_RIDE_CHEMY_CARD = ITEMS.register("firemars_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_mars_phoenix","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(Effect_core.FIRE_PUNCH, 40, 0,true,false)).AddNeedItemList(NEED_ITEM_MarsPhoenix)
					.AddCompatibilityList(Gotchards).AddToList(NEED_ITEM_MarsPhoenix).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).AddToList(ChemyRiserItem.Cosmic_CHEMY)
					.AddToList(ChemyRiserItem.ALL_CHEMY).has_basic_model());

	public static final DeferredItem<Item> GRANDSATURN_RIDE_CHEMY_CARD = ITEMS.register("grandsaturn_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Cosmic_CHEMY).has_basic_model());

	 public static final DeferredItem<Item> THE_SUN_RIDE_CHEMY_CARD = ITEMS.register("the_sun_ride_chemy_card",
			 () -> new RiderFormChangeItem(new Item.Properties(),0,"","majade","alchemisdriver_belt",
					 new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
					 .AddNeedItemList(NEED_ITEM_SunUnicorn).AddToList(NEED_ITEM_SunUnicorn).AddToList(ChemyRiserItem.ALL_CHEMY)
					 .AddToList(ChemyRiserItem.Cosmic_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> JUPITTA_RIDE_CHEMY_CARD = ITEMS.register("jupitta_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Cosmic_CHEMY).has_basic_model());

	public static final DeferredItem<Item> KUROANA_RIDE_CHEMY_CARD = ITEMS.register("kuroana_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","wind","alchemisdriver_belt_wind",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)).ChangeAnimation("default_cape.animation.json").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Cosmic_CHEMY).has_basic_model());

	public static final DeferredItem<Item> GAIARD_RIDE_CHEMY_CARD = ITEMS.register("gaiard_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GIGABAHAM_RIDE_CHEMY_CARD = ITEMS.register("gigabaham_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Fantastic_CHEMY).has_basic_model());

	public static final DeferredItem<Item> MACENTAURUS_RIDE_CHEMY_CARD = ITEMS.register("macentaurus_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Fantastic_CHEMY).has_basic_model());

	public static final DeferredItem<Item> UNICON_RIDE_CHEMY_CARD = ITEMS.register("unicon_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),THE_SUN_RIDE_CHEMY_CARD.get())
					.AddToList(NEED_ITEM_SunUnicorn).AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Fantastic_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> VANFENRIR_RIDE_CHEMY_CARD = ITEMS.register("vanfenrir_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Fantastic_CHEMY).has_basic_model());

	public static final DeferredItem<Item> INPHOENIX_RIDE_CHEMY_CARD = ITEMS.register("inphoenix_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),FIREMARS_RIDE_CHEMY_CARD.get()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Fantastic_CHEMY).has_basic_model());

	public static final DeferredItem<Item> YOACERBERUS_RIDE_CHEMY_CARD = ITEMS.register("yoacerberus_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),NEMINEMOON_RIDE_CHEMY_CARD.get())
					.AddToList(NEED_ITEM_MoonCerberus).AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Fantastic_CHEMY).has_basic_model());

	public static final DeferredItem<Item> HAODIN_RIDE_CHEMY_CARD = ITEMS.register("haodin_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Fantastic_CHEMY).has_basic_model());

	public static final DeferredItem<Item> GINGRIFFON_RIDE_CHEMY_CARD = ITEMS.register("gingriffon_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Fantastic_CHEMY).has_basic_model());

	public static final DeferredItem<Item> DONPOSEIDON_RIDE_CHEMY_CARD = ITEMS.register("donposeidon_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.ALL_CHEMY).AddToList(ChemyRiserItem.Fantastic_CHEMY).has_basic_model());

	public static final DeferredItem<Item> DRAGONALOS_RIDE_CHEMY_CARD = ITEMS.register("dragonalos_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"","","").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> TAMAGON_RIDE_CHEMY_CARD = ITEMS.register("tamagon_ride_chemy_card",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> NIJIGON_RIDE_CHEMY_CARD_EXTRA = ITEMS.register("nijigon_ride_chemy_card_extra",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_rainbow","gotchard","gotchardriver_belt_r",
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
					new MobEffectInstance(Effect_core.PUNCH, 40, 6,true,false))
                    .IsGlowing().AddNeedItemList(NEED_ITEM_Rainbow).AddToList(NEED_ITEM_Rainbow).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> NIJIGON_RIDE_CHEMY_CARD_SPECIAL = ITEMS.register("nijigon_ride_chemy_card_special",
			() -> new CopyFormChangeItem(new Item.Properties().rarity(Rarity.RARE), NIJIGON_RIDE_CHEMY_CARD_EXTRA.get()).AddToList(NEED_ITEM_Rainbow).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> TENLINER_RIDE_CHEMY_CARD = ITEMS.register("tenliner_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_iron","gotchard","gotchardriver_belt_i",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false),
					new MobEffectInstance(Effect_core.BOOST, 40, 2,true,false))
			.AddToList(NEED_ITEM_Platina).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> CROSSHOPPER_RIDE_CHEMY_CARD = ITEMS.register("crosshopper_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_platina","gotchard","gotchardriver_belt_p",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 6,true,false))
			.AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_Platina).AddToList(NEED_ITEM_Platina).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> HOPPER1_RIDE_CHEMY_CARD_ULTIMA = ITEMS.register("hopper1_ride_chemy_card_ultima",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC),0,"","gotchard","gotchardriver_belt_daybreak",
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
					new MobEffectInstance(Effect_core.PUNCH, 40, 9,true,false))
					.AddNeedItemList(NEED_ITEM_Ultima).AddToList(NEED_ITEM_Ultima).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> STEAMLINER_RIDE_CHEMY_CARD_ULTIMA = ITEMS.register("steamliner_ride_chemy_card_ultima",
			() -> new CopyFormChangeItem(new Item.Properties().rarity(Rarity.EPIC), HOPPER1_RIDE_CHEMY_CARD_ULTIMA.get()).AddToList(NEED_ITEM_Ultima).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> X_ASSEMBLE_RIDE_CHEMY_CARD = ITEMS.register("x_assemble_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_star","gotchard","gotchardriver_belt_star",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0, true, false),
					new MobEffectInstance(Effect_core.THUNDER_PUNCH, 40, 0, true, false),
					new MobEffectInstance(MobEffects.NIGHT_VISION,400,0,true,false)).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> FIREMARS_RIDE_CHEMY_CARD_TELEVIKUN = ITEMS.register("firemars_ride_chemy_card_televikun",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_mars_phoenix","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(Effect_core.FIRE_PUNCH, 40, 0,true,false)).AddNeedItemList(NEED_ITEM_MarsPhoenix2)
					.AddCompatibilityList(Gotchards).AddToList(NEED_ITEM_MarsPhoenix2).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> INPHOENIX_RIDE_CHEMY_CARD_TELEVIKUN = ITEMS.register("inphoenix_ride_chemy_card_televikun",
			() -> new CopyFormChangeItem(new Item.Properties(),FIREMARS_RIDE_CHEMY_CARD_TELEVIKUN.get()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> HOPPER1_RIDE_CHEMY_CARD_DAYBREAK = ITEMS.register("daybreak_hopper1_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","gotchard_daybreak","gotchardriver_belt_daybreak",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).AddNeedItemList(NEED_ITEM_SteamHopper_daybreak)
					.AddToList(ChemyRiserItem.Daybreak_CHEMY).AddToList(NEED_ITEM_SteamHopper_daybreak).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> STEAMLINER_RIDE_CHEMY_CARD_DAYBREAK = ITEMS.register("daybreak_steamliner_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),HOPPER1_RIDE_CHEMY_CARD_DAYBREAK.get()).AddToList(NEED_ITEM_SteamHopper_daybreak)
					.AddToList(ChemyRiserItem.Daybreak_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	//public static final DeferredItem<Item> TIMELORD_RIDE_CHEMY_CARD_DAYBREAK  = ITEMS.register("daybreak_timelord_ride_chemy_card",
	//		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));


	public static final DeferredItem<Item> DREAD_TYPE_THREE_CARDS = ITEMS.register("dread_type_three_cards",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_type_three","dread","dreadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
					.ChangeModel("dread_type_one.geo.json").AddNeedItemList(NEED_ITEM_TypeThree));

	public static final DeferredItem<Item> STEAMLINER_REPLI_CHEMY_CARD = ITEMS.register("steamliner_repli_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","dread","dreadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)).addShiftForm(DREAD_TYPE_THREE_CARDS.get())
					.AddToList(NEED_ITEM_TypeThree).AddToList(ChemyRiserItem.Repli_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> UNICON_REPLI_CHEMY_CARD = ITEMS.register("unicon_repli_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_type_one","dread","dreadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)).addShiftForm(DREAD_TYPE_THREE_CARDS.get())
					.AddToList(NEED_ITEM_TypeThree).AddToList(ChemyRiserItem.Repli_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> DAIOHNI_REPLI_CHEMY_CARD = ITEMS.register("daiohni_repli_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_type_two","dread","dreadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)).addShiftForm(DREAD_TYPE_THREE_CARDS.get())
					.AddToList(NEED_ITEM_TypeThree).AddToList(ChemyRiserItem.Repli_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> MADWHEEL_REPLI_CHEMY_CARD = ITEMS.register("madwheel_repli_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","valvarad_lachesis","valvaradraw_buckle_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
					.AddToList(ChemyRiserItem.Repli_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ANTROOPER_REPLI_CHEMY_CARD = ITEMS.register("antrooper_repli_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","dreatrooper","dreadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false))
			.AddToList(ChemyRiserItem.Repli_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> LEGEND_RIDE_CHEMY_CARD = ITEMS.register("legend_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
			.ResetFormToBase().AddToList(ChemyRiserItem.Legend_CHEMY,10).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> LEGENDARY_LEGEND = ITEMS.register("legendary_legend",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_legendary","legend","legendriver_belt_l")
					.ChangeSlot(2).model_has_different_name("legendary_legend_ride_chemy_card"));

	public static final DeferredItem<Item> LEGENDARY_LEGEND_RIDE_CHEMY_CARD = ITEMS.register("legendary_legend_ride_chemy_card", // TODO: Base/super form summoning
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_legendary","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> SANTACLAUS_RIDE_CHEMY_CARD = ITEMS.register("santaclaus_ride_chemy_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> TONAKAILINER_RIDE_CHEMY_CARD = ITEMS.register("tonakailiner_ride_chemy_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_RIDE_CHEMY_CARD_GOTCHARD = ITEMS.register("kuuga_ride_chemy_card_gotchard",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_exceed_mighty","gotchard","gotchardriver_belt",
					new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_ExceedMighty).model_has_different_name("kuuga_ride_chemy_card"));

	public static final DeferredItem<Item> KUUGA_RIDE_CHEMY_CARD = ITEMS.register("kuuga_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false),
					new MobEffectInstance(Effect_core.RIDER_KICK, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).IsGlowing().ChangeRiderName("kuuga").ChangeModel("kuuga.geo.json").addAlternative(KUUGA_RIDE_CHEMY_CARD_GOTCHARD.get())
					.AddToList(NEED_ITEM_ExceedMighty).AddToList(ChemyRiserItem.Legend_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_RIDE_CHEMY_CARD = ITEMS.register("agito_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).IsGlowing().ChangeRiderName("agito").ChangeModel("agito.geo.json").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());

	public static final DeferredItem<Item> RYUKI_RIDE_CHEMY_CARD = ITEMS.register("ryuki_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("ryuki").AddToList(ChemyRiserItem.Legend_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> FAIZ_RIDE_CHEMY_CARD = ITEMS.register("faiz_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).IsGlowing().ChangeRiderName("faiz").addAlternative(KUUGA_RIDE_CHEMY_CARD_GOTCHARD.get())
					.AddToList(NEED_ITEM_ExceedMighty).AddToList(ChemyRiserItem.Legend_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> BLADE_RIDE_CHEMY_CARD = ITEMS.register("blade_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("blade").AddToList(ChemyRiserItem.Legend_CHEMY)
					.AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> HIBIKI_RIDE_CHEMY_CARD = ITEMS.register("hibiki_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("hibiki").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());

	public static final DeferredItem<Item> KABUTO_RIDE_CHEMY_CARD = ITEMS.register("kabuto_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("kabuto").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());

	public static final DeferredItem<Item> DEN_O_RIDE_CHEMY_CARD = ITEMS.register("den_o_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("den_o").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());

	public static final DeferredItem<Item> KIVA_RIDE_CHEMY_CARD = ITEMS.register("kiva_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("kiva").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());

	public static final DeferredItem<Item> DECADE_RIDE_CHEMY_CARD = ITEMS.register("decade_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("decade").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());

	public static final DeferredItem<Item> W_RIDE_CHEMY_CARD_GOTCHARD = ITEMS.register("w_ride_chemy_card_gotchard",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cyclone_tatoba","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_CycloneTaToBa).model_has_different_name("w_ride_chemy_card"));

	public static final DeferredItem<Item> W_RIDE_CHEMY_CARD = ITEMS.register("w_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("decade_w").addAlternative(W_RIDE_CHEMY_CARD_GOTCHARD.get())
					.AddToList(NEED_ITEM_CycloneTaToBa).AddToList(ChemyRiserItem.Legend_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> OOO_RIDE_CHEMY_CARD = ITEMS.register("ooo_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("decade_ooo").addAlternative(W_RIDE_CHEMY_CARD_GOTCHARD.get())
					.AddToList(NEED_ITEM_CycloneTaToBa).AddToList(ChemyRiserItem.Legend_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> FOURZE_RIDE_CHEMY_CARD_GOTCHARD = ITEMS.register("fourze_ride_chemy_card_gotchard",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_full_full_rocket","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)).AddCompatibilityList(Gotchards).AddNeedItemList(NEED_ITEM_FullFullRocket).model_has_different_name("fourze_ride_chemy_card"));

	public static final DeferredItem<Item> FOURZE_RIDE_CHEMY_CARD = ITEMS.register("fourze_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("fourze").addAlternative(FOURZE_RIDE_CHEMY_CARD_GOTCHARD.get())
					.AddToList(NEED_ITEM_FullFullRocket).AddToList(ChemyRiserItem.Legend_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_RIDE_CHEMY_CARD = ITEMS.register("wizard_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("wizard").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());

	public static final DeferredItem<Item> GAIM_RIDE_CHEMY_CARD = ITEMS.register("gaim_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("decade_gaim").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());

	public static final DeferredItem<Item> DRIVE_RIDE_CHEMY_CARD = ITEMS.register("drive_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("decade_drive").ChangeModel("drive.geo.json").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());

	public static final DeferredItem<Item> GHOST_RIDE_CHEMY_CARD = ITEMS.register("ghost_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(Effect_core.GHOST, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("decade_ghost").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());

	public static final DeferredItem<Item> EX_AID_RIDE_CHEMY_CARD = ITEMS.register("ex_aid_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("ex_aid").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());

	public static final DeferredItem<Item> BUILD_RIDE_CHEMY_CARD = ITEMS.register("build_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("decade_build").addAlternative(FOURZE_RIDE_CHEMY_CARD_GOTCHARD.get())
					.AddToList(NEED_ITEM_FullFullRocket).AddToList(ChemyRiserItem.Legend_CHEMY).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ZI_O_RIDE_CHEMY_CARD = ITEMS.register("zi_o_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("zi_o").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());

	public static final DeferredItem<Item> ZERO_ONE_RIDE_CHEMY_CARD = ITEMS.register("zero_one_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("zero_one").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());

	public static final DeferredItem<Item> SABER_RIDE_CHEMY_CARD = ITEMS.register("saber_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_saber","legend","legendriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());

	public static final DeferredItem<Item> REVI_RIDE_CHEMY_CARD = ITEMS.register("revi_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("revi").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());

	public static final DeferredItem<Item> VICE_RIDE_CHEMY_CARD = ITEMS.register("vice_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("vice").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());

	public static final DeferredItem<Item> GEATS_RIDE_CHEMY_CARD = ITEMS.register("geats_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_geats","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(Effect_core.FIRE_SHOT, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(Effect_core.BOOST, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());

	public static final DeferredItem<Item> GOTCHARD_RIDE_CHEMY_CARD = ITEMS.register("gotchard_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
                    .alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).ChangeRiderName("gotchard").AddToList(RiderTabs.GOTCHARD_TAB_ITEM)
					.AddToList(ChemyRiserItem.Legend_CHEMY).has_basic_model());


	public static final DeferredItem<Item> KUUGA_ULTIMATE_RIDE_CHEMY_CARD = ITEMS.register("kuuga_ultimate_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false),
					new MobEffectInstance(Effect_core.FIRE_ARMOR, 40, 5,true,false),
					new MobEffectInstance(Effect_core.RIDER_KICK, 40, 0,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2).IsGlowing()
			.ChangeRiderName("kuuga_ultimate").ChangeModel("kuuga_ultimate.geo.json").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> AGITO_SHINING_RIDE_CHEMY_CARD = ITEMS.register("agito_shining_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2).IsGlowing()
			.ChangeRiderName("agito_shining").ChangeModel("agito_shining.geo.json").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> RYUKI_SURVIVE_RIDE_CHEMY_CARD = ITEMS.register("ryuki_survive_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2).IsGlowing()
			.ChangeRiderName("ryuki_survive").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> FAIZ_BLASTER_RIDE_CHEMY_CARD = ITEMS.register("faiz_blaster_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2).IsGlowing()
			.ChangeRiderName("faiz_blaster").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> BLADE_KING_RIDE_CHEMY_CARD = ITEMS.register("blade_king_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.ChangeRiderName("blade_king").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ARMED_HIBIKI_RIDE_CHEMY_CARD = ITEMS.register("armed_hibiki_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.ChangeRiderName("hibiki_armed").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> KABUTO_HYPER_RIDE_CHEMY_CARD = ITEMS.register("kabuto_hyper_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 7,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.ChangeRiderName("kabuto_hyper").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> DEN_O_LINER_RIDE_CHEMY_CARD = ITEMS.register("den_o_liner_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.ChangeRiderName("den_o_liner").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> KIVA_EMPEROR_RIDE_CHEMY_CARD = ITEMS.register("kiva_emperor_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.ChangeRiderName("kiva_emperor").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> DECADE_COMPLETE_RIDE_CHEMY_CARD = ITEMS.register("decade_complete_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.ChangeRiderName("decade_complete").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> W_CYCLONE_JOKER_XTREME_RIDE_CHEMY_CARD = ITEMS.register("w_cyclone_joker_xtreme_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_w_cyclone_joker_xtreme","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> OOO_PUTOTYRA_RIDE_CHEMY_CARD = ITEMS.register("ooo_putotyra_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_ooo_putotyra","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40	, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(Effect_core.FLYING,400,0,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> FOURZE_COSMIC_RIDE_CHEMY_CARD = ITEMS.register("fourze_cosmic_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.ChangeRiderName("fourze_cosmic").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> WIZARD_INFINITY_RIDE_CHEMY_CARD = ITEMS.register("wizard_infinity_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.ChangeRiderName("wizard_infinity").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GAIM_KIWAMI_RIDE_CHEMY_CARD = ITEMS.register("gaim_kiwami_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_gaim_kiwami","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> DRIVE_TRIDORON_RIDE_CHEMY_CARD = ITEMS.register("drive_tridoron_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).ChangeModel("drive_tridoron.geo.json").addNeedForm(LEGENDARY_LEGEND.get(),2)
			.ChangeRiderName("drive_tridoron").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GHOST_MUGEN_RIDE_CHEMY_CARD = ITEMS.register("ghost_mugen_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_ghost_mugen","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(Effect_core.GHOST, 40, 0,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> EX_AID_MUTEKI_RIDE_CHEMY_CARD = ITEMS.register("ex_aid_muteki_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 6,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(Effect_core.MUTEKI, 40, 0,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.ChangeRiderName("ex_aid_muteki").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> BUILD_GENIUS_RIDE_CHEMY_CARD = ITEMS.register("build_genius_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_build_genius","legend","legendriver_belt_l",
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
					new MobEffectInstance(Effect_core.FLYING, 40, 0, true, false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GRAND_ZI_O_RIDE_CHEMY_CARD = ITEMS.register("grand_zi_o_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.ChangeRiderName("zi_o_grand").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ZERO_TWO_RIDE_CHEMY_CARD = ITEMS.register("zero_two_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 8,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.ChangeRiderName("zero_two").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> XROSS_SABER_RIDE_CHEMY_CARD = ITEMS.register("xross_saber_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_xross_saber","legend","legendriver_belt_l",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ULTIMATE_REVI_RIDE_CHEMY_CARD = ITEMS.register("ultimate_revi_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 8,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).addNeedForm(LEGENDARY_LEGEND.get(),2)
			.ChangeRiderName("revi_ultimate").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ULTIMATE_VICE_RIDE_CHEMY_CARD = ITEMS.register("ultimate_vice_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 8,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get())	.addNeedForm(LEGENDARY_LEGEND.get(),2)
			.ChangeRiderName("vice_ultimate").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GEATS_IX_RIDE_CHEMY_CARD = ITEMS.register("geats_ix_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_geats_ix","legend","legendriver_belt_l",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.FIRE_PUNCH, 40, 4,true,false),
					new MobEffectInstance(Effect_core.BOOST, 40, 4,true,false))
			.alsoChange2ndSlot(LEGENDARY_LEGEND.get()).hasStaticWings().addNeedForm(LEGENDARY_LEGEND.get(),2)
			.AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());


	public static final DeferredItem<Item> ARK_ZERO_RIDE_CHEMY_CARD = ITEMS.register("ark_zero_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_outsiders","ark_zero","ark_driver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ARK_ONE_RIDE_CHEMY_CARD = ITEMS.register("ark_one_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_saigetsu","ark_zero","ark_driver_belt_1",
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false)).ChangeRiderName("ark_one").AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ETERNAL_RIDE_CHEMY_CARD = ITEMS.register("eternal_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_yellowed","eternal","lostdriver_belt_e",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 0.1);
                }
            }.AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());


	public static final DeferredItem<Item> GOTCHAR_IGNITER_DB = ITEMS.register("gotchar_igniter_db",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_fire","gotchard_daybreak","gotchardriver_belt_daybreak_fire",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BOOST,40,4,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE,40,0,true,false),
					new MobEffectInstance(Effect_core.FIRE_PUNCH,40,2,true,false))
					.ChangeModel("default_cape.geo.json").ChangeAnimation("default_cape.animation.json").model_has_different_name("gotchar_igniter").has_basic_model());

	public static final DeferredItem<Item> GOTCHAR_IGNITER_EM = ITEMS.register("gotchar_igniter_em",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_exceed_mighty_fire","gotchard","gotchardriver_belt_fire",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BOOST,40,2,true,false),
					new MobEffectInstance(Effect_core.FIRE_PUNCH,40,0,true,false))
					.addAlternative(GOTCHAR_IGNITER_DB.get()).addNeedForm(KUUGA_RIDE_CHEMY_CARD_GOTCHARD.get(),1).ChangeModel("gotchard_fire.geo.json").model_has_different_name("gotchar_igniter").has_basic_model());

	public static final DeferredItem<Item> GOTCHAR_IGNITER_AW = ITEMS.register("gotchar_igniter_aw",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ant_wrestler_fire","gotchard","gotchardriver_belt_fire",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BOOST,40,2,true,false),
					new MobEffectInstance(Effect_core.FIRE_PUNCH,40,1,true,false))
					.addAlternative(GOTCHAR_IGNITER_EM.get()).addNeedForm(ANTROOPER_RIDE_CHEMY_CARD.get(),1).ChangeModel("gotchard_fire.geo.json").model_has_different_name("gotchar_igniter").has_basic_model());

	public static final DeferredItem<Item> GOTCHAR_IGNITER_AS = ITEMS.register("gotchar_igniter_as",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_appare_skebow_fire","gotchard","gotchardriver_belt_fire",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BOOST,40,4,true,false),
					new MobEffectInstance(Effect_core.FIRE_PUNCH,40,1,true,false))
					.addAlternative(GOTCHAR_IGNITER_AW.get()).addNeedForm(APPAREBUSHIDO_RIDE_CHEMY_CARD.get(),1).ChangeModel("gotchard_fire.geo.json").model_has_different_name("gotchar_igniter").has_basic_model());

	public static final DeferredItem<Item> GOTCHAR_IGNITER = ITEMS.register("gotchar_igniter",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_fire","gotchard","gotchardriver_belt_fire",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BOOST,40,3,true,false),
					new MobEffectInstance(Effect_core.FIRE_PUNCH,40,1,true,false))
					.addAlternative(GOTCHAR_IGNITER_AS.get()).addNeedForm(HOPPER1_RIDE_CHEMY_CARD.get(),1).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GOTCHARD_HELMET = ITEMS.register("gotchard_head",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));
    public static final DeferredItem<Item> GOTCHARD_CHESTPLATE = ITEMS.register("gotchard_torso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));
    public static final DeferredItem<Item> GOTCHARD_LEGGINGS = ITEMS.register("gotchard_legs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

    
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
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

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
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> GOTCHARDRIVER_BROTHER = ITEMS.register("gotchardriver_brother", // TODO: Rainbow Breath! (summoning)
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
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

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
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

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
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()).has_basic_model());

	public static final DeferredItem<Item> VALVARADRIVER = ITEMS.register("valvaradriver",
			() -> new GotcharDriverItem(ArmorMaterials.DIAMOND,"valvarad_rider", MACHWHEEL_RIDE_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties())
					.AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()).has_basic_model());

	public static final DeferredItem<Item>  DREADRIVER = ITEMS.register("dreadriver",
			() -> new GotcharDriverItem(ArmorMaterials.DIAMOND,"dread", STEAMLINER_REPLI_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item>  DREADRIVER_TROOPER = ITEMS.register("dreadriver_trooper",
			() -> new GotcharDriverItem(ArmorMaterials.DIAMOND,"dreatrooper", ANTROOPER_REPLI_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));


	public static final DeferredItem<Item> LEGENDRIVER = ITEMS.register("legendriver",
			() -> new LegenDriverItem(ArmorMaterials.DIAMOND,"legend", LEGEND_RIDE_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties())
			.Add_Extra_Base_Form_Items(Modded_item_core.BLANK_FORM).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> VALVARADRAW_BUCKLE = ITEMS.register("valvaradraw_buckle",
			() -> new ValvaradItem(ArmorMaterials.DIAMOND,"valvarad", MADWHEEL_RIDE_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties())
					.AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> VALVARADRAW_BUCKLE_LACHESIS = ITEMS.register("valvaradraw_buckle_lachesis",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"valvarad_lachesis", MADWHEEL_REPLI_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> GOTCHANCOLLECTION_PANEL = ITEMS.register("gotchancollection_panel",
			() -> new GotchancollectionPanelItem().AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());


	public static final DeferredItem<Item> GOTCHARGE_GUN = ITEMS.register("gotcharge_gun",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));
	
	public static final DeferredItem<Item> GOTCHAR_TORNADO = ITEMS.register("gotchar_tornado",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> EXGOTCHALIBUR = ITEMS.register("exgotchalibur",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> VALVARUSHER = ITEMS.register("valvarusher",
			() -> new ValvarusherItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> LEGEND_RIDE_MAGNUM = ITEMS.register("legend_ride_magnum", // TODO: Diend-style summoning
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> LEGEND_KAMEN_RISER = ITEMS.register("legend_kamen_riser",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties().rarity(Rarity.RARE)).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> CHEMY_RISER = ITEMS.register("chemy_riser",
			() -> new ChemyRiserItem().AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
	
	public static final DeferredItem<Item> CHEMY_RISER_SUPANA = ITEMS.register("chemy_riser_supana",
			() -> new ChemyRiserItem().AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ALCHEMIST_RING_BLUE = ITEMS.register("alchemist_ring_blue",
			() -> new BaseItem(new Item.Properties()).KeepItem().has_basic_model().AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ALCHEMIST_RING_GREEN = ITEMS.register("alchemist_ring_green",
			() -> new BaseItem(new Item.Properties()).KeepItem().AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ALCHEMIST_RING_RED = ITEMS.register("alchemist_ring_red",
			() -> new BaseItem(new Item.Properties()).KeepItem().AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ALCHEMIST_RING_ORANGE = ITEMS.register("alchemist_ring_orange",
			() -> new BaseItem(new Item.Properties()).KeepItem().AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ALCHEMIST_RING_PURPLE = ITEMS.register("alchemist_ring_purple",
			() -> new BaseItem(new Item.Properties()).KeepItem().AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ALCHEMIST_RING_GOLD = ITEMS.register("alchemist_ring_gold",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).KeepItem().AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ALCHEMIST_RING_BLACK = ITEMS.register("alchemist_ring_black",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).KeepItem().AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> ALCHEMIST_RING_NO_GEM = ITEMS.register("alchemist_ring_no_gem",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}
