package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.gaim.SengokuDriverItem;
import com.kelco.kamenridercraft.item.ghost.GhostDriverItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Gaim_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> GAIM_LOGO = ITEMS.register("gaim_logo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> HIMAWRI_LOCKSEED = ITEMS.register("himawari_lockseed",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));


	public static String[] Can_use_Basic_lockseed = new String[] {"gaim","baron","ryugen","zangetsu","gridon","kurokage"
			,"bravo","knuckle","bujin_gaim","fifteen","mars","kamuro","jam","kurokage_troopers","idunn","sengoku_duke","baron_black",
	"savior","maja","proto_gaim","proto_ryugen","proto_baron","proto_gridon","proto_bravo","sylphi","gaim_natsumikan"};

	public static String[] Can_use_Energy_lockseed = new String[] {"zangetsu_shin","baron_shin","ryugen_shin","duke","sigurd","marika","kurokage_shin"
	,"tyrant"};

	public static String[] Can_use_Legend_lockseed = new String[] {"gaim","baron","ryugen","zangetsu","gridon","kurokage"
			,"bravo","knuckle","bujin_gaim","fifteen","mars","kamuro","jam","kurokage_troopers","idunn","sengoku_duke","baron_black",
			"savior","maja","proto_gaim","proto_ryugen","proto_baron","proto_gridon","proto_bravo","sylphi","gaim_natsumikan"
	,"zangetsu_shin","baron_shin","ryugen_shin","duke","sigurd","marika","kurokage_shin"
			,"tyrant"};

	public static String[] Can_use_Jimber_Arms = new String[] {"gaim","ryugen","zangetsu","bravo","knuckle"};


	public static final DeferredItem<Item> MATSUBOKKURI_LOCKSEED = ITEMS.register("matsubokkuri_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"matsubokkuri_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> KURUMI_LOCKSEED = ITEMS.register("kurumi_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kurumi_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> DONGURI_LOCKSEED = ITEMS.register("donguri_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"donguri_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> MELON_LOCKSEED = ITEMS.register("melon_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"melon_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> PINE_LOCKSEED = ITEMS.register("pine_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"pine_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> ICHIGO_LOCKSEED = ITEMS.register("ichigo_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"ichigo_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> ORANGE_LOCKSEED = ITEMS.register("orange_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"orange_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> BANANA_LOCKSEED = ITEMS.register("banana_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"banana_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> BUDOU_LOCKSEED = ITEMS.register("budou_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"budou_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));
//suika_lockseed

	public static final DeferredItem<Item> MANGO_LOCKSEED = ITEMS.register("mango_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"mango_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> DURIAN_LOCKSEED = ITEMS.register("durian_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"durian_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> KIWI_LOCKSEED = ITEMS.register("kiwi_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kiwi_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> LEMON_LOCKSEED = ITEMS.register("lemon_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"lemon_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));


	public static final DeferredItem<Item> JIMBER_GAIM_CORE = ITEMS.register("jimber_gaim_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_jimber","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Jimber_Arms).ChangeSlot(2));

	public static final DeferredItem<Item> JIMBER_LEMON_ENERGY_LOCKSEED = ITEMS.register("jimber_lemon_energy",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"jimbar_lemon_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Jimber_Arms).ResetFormToBase().alsoChange2ndSlot(JIMBER_GAIM_CORE.get()));

	public static final DeferredItem<Item> LEMON_ENERGY_LOCKSEED = ITEMS.register("lemon_energy_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"energy_lemon_arms","zangetsu_shin","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Energy_lockseed).addAlternative(JIMBER_LEMON_ENERGY_LOCKSEED.get()).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> JIMBER_CHERRY_ENERGY_LOCKSEED = ITEMS.register("jimber_cherry_energy",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"jimbar_cherry_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Jimber_Arms).ResetFormToBase().alsoChange2ndSlot(JIMBER_GAIM_CORE.get()));

	public static final DeferredItem<Item> CHERRY_ENERGY_LOCKSEED = ITEMS.register("cherry_energy_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"energy_cherry_arms","zangetsu_shin","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Energy_lockseed).addAlternative(JIMBER_CHERRY_ENERGY_LOCKSEED.get()).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> JIMBER_PEACH_ENERGY_LOCKSEED = ITEMS.register("jimber_peach_energy",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"jimbar_peach_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Jimber_Arms).ResetFormToBase().alsoChange2ndSlot(JIMBER_GAIM_CORE.get()));

	public static final DeferredItem<Item> PEACH_ENERGY_LOCKSEED = ITEMS.register("peach_energy_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"energy_peach_arms","zangetsu_shin","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Energy_lockseed).ResetFormToBase().addAlternative(JIMBER_PEACH_ENERGY_LOCKSEED.get()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> JIMBER_MELON_ENERGY_LOCKSEED = ITEMS.register("jimber_melon_energy",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"jimbar_melon_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Jimber_Arms).ResetFormToBase().alsoChange2ndSlot(JIMBER_GAIM_CORE.get()));

	public static final DeferredItem<Item> MELON_ENERGY_LOCKSEED = ITEMS.register("melon_energy_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"energy_melon_arms","zangetsu_shin","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Energy_lockseed).ResetFormToBase().addAlternative(JIMBER_MELON_ENERGY_LOCKSEED.get()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> MATSUBOKKURI_ENERGY_LOCKSEED = ITEMS.register("matsubokkuri_energy_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"energy_matsubokkuri_arms","zangetsu_shin","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Energy_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> JIMBER_DRAGON_FRUITS_ENERGY_LOCKSEED = ITEMS.register("jimber_dragon_fruits_energy",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"jimbar_dragon_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Jimber_Arms).ResetFormToBase().alsoChange2ndSlot(JIMBER_GAIM_CORE.get()));

	public static final DeferredItem<Item> DRAGON_FRUITS_ENERGY_LOCKSEED = ITEMS.register("dragon_fruits_energy_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"energy_dragon_fruits_arms","zangetsu_shin","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Energy_lockseed).ResetFormToBase().addAlternative(JIMBER_DRAGON_FRUITS_ENERGY_LOCKSEED.get()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_DRAGON_FRUITS_ENERGY_LOCKSEED = ITEMS.register("proto_dragon_fruits_energy_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"energy_prototype_dragon_fruits_arms","zangetsu_shin","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Energy_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> MARRON_ENERGY_LOCKSEED = ITEMS.register("marron_energy_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"jimbar_marron_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Jimber_Arms).ResetFormToBase().alsoChange2ndSlot(JIMBER_GAIM_CORE.get()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	//kachidoki_lockseed
	//zangetsu_kachidoki_lockseed
	//kiwami_lockseed
	//yomotsu_heguri_lockseed

	public static final DeferredItem<Item> BLOOD_ORANGE_LOCKSEED = ITEMS.register("blood_orange_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"blood_orange_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> FIFTEEN_LOCKSEED = ITEMS.register("fifteen_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"fifteen_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> GOLDEN_RINGO_LOCKSEED = ITEMS.register("golden_ringo_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"golden_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> SILVER_RINGO_LOCKSEED = ITEMS.register("silver_ringo_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"silver_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_RINGO_LOCKSEED = ITEMS.register("black_ringo_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"darkness_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> FORBIBBEN_LOCKSEED_BASE = ITEMS.register("forbidden_ringo_lockseed_base",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"ringo_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase());

	public static final DeferredItem<Item> FORBIBBEN_LOCKSEED = ITEMS.register("forbidden_ringo_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"baron_ringo_arms","baron","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.addAlternative(FORBIBBEN_LOCKSEED_BASE.get()).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> WATERMELON_LOCKSEED = ITEMS.register("watermelon_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"watermelon_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> ZAKURO_LOCKSEED = ITEMS.register("zakuro_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"blood_zakuro_arms","saver","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.addNeedItem(BLOOD_ORANGE_LOCKSEED.get()).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> MAJA_LOCKSEED = ITEMS.register("maja_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"maja_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> BLCK_BARRON_LOCKSEED = ITEMS.register("black_baron_lockseed",
			() -> new CopyFormChangeItem(new Item.Properties(),BANANA_LOCKSEED.get()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> FRESH_ORANGE_LOCKSEED = ITEMS.register("fresh_orange_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"fresh_orange_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> FRESH_PINE_LOCKSEED = ITEMS.register("fresh_pine_lockseed",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> LYCHEE_LOCKSEED = ITEMS.register("lychee_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"lychee_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> KING_DURIAN_LOCKSEED = ITEMS.register("king_durian_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"king_durian_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	/**
	 king_durian_lockseed
	 helheim_lockseed

	dark_orange_lockseed
	dark_lemon_energy_lockseed

	natsumikan_lockseed

	drive_lockseed
	wizard_lockseed
	fourze_lockseed
	ooo_lockseed
	w_lockseed
	decade_lockseed
	kiva_lockseed
	den_o_lockseed
	kaubuto_lockseed
	hibiki_lockseed
	blade_lockseed
	faiz_lockseed
	ryuki_lockseed agito_lockseed
	kuuga_lockseed

	gaim_lockseed
	gaim_lockseed_movie_special

	rider_ichigo_lockseed

	showa_rider_lockseed
	heisei_rider_lockseed


	sakura_hurricane
	rose_attacker
	dandeliner
	tulip_hopper

	christmas_lockseed
	roulette_lockseed
	fake_donguri_lockseed
	sid_lockseed

	xiaolongbao_lockseed
	hsiao_lung_pao_lockseed
	tom_yum_kung_lockseed
	yummy_lockseed
	hero_lockseed
**/
	public static final DeferredItem<Item> GAIM_HELMET = ITEMS.register("gaimhead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));
	public static final DeferredItem<Item> GAIM_CHESTPLATE = ITEMS.register("gaimtroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));
	public static final DeferredItem<Item> GAIM_LEGGINGS = ITEMS.register("gaimlegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_GAIM_CORE = ITEMS.register("basic_gaim_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_GAIM = ITEMS.register("sengoku_driver_gaim",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"gaim",ORANGE_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_GAIM_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_BARON_CORE = ITEMS.register("basic_baron_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","baron","sengoku_driver_belt_baron",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_BARON = ITEMS.register("sengoku_driver_baron",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"baron",BANANA_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_BARON_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_RYUGEN_CORE= ITEMS.register("basic_ryugen_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","ryugen","sengoku_driver_belt_ryugen",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_RYUGEN = ITEMS.register("sengoku_driver_ryugen",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"ryugen",BUDOU_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_RYUGEN_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_ZENGETSU_CORE= ITEMS.register("basic_zangetsu_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","zangetsu","sengoku_driver_belt_zangetsu",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_ZENGETSU = ITEMS.register("sengoku_driver_zangetsu",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"zangetsu",MELON_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_ZENGETSU_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_GRIDON_CORE= ITEMS.register("basic_gridon_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","gridon","sengoku_driver_belt_gridon",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_GRIDON = ITEMS.register("sengoku_driver_gridon",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"gridon",DONGURI_LOCKSEED, GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_GRIDON_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_KUROKAGE_CORE= ITEMS.register("basic_kurokage_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","kurokage","sengoku_driver_belt_kurokage",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_KUROKAGE = ITEMS.register("sengoku_driver_kurokage",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"kurokage",MATSUBOKKURI_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_KUROKAGE_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_BRAVO_CORE= ITEMS.register("basic_bravo_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","bravo","sengoku_driver_belt_bravo",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_BRAVO_KUROKAGE = ITEMS.register("sengoku_driver_bravo",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"bravo",DURIAN_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_BRAVO_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_KNUCKLE_CORE= ITEMS.register("basic_knuckle_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","knuckle","sengoku_driver_belt_knuckle",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_KNUCKLE= ITEMS.register("sengoku_driver_knuckle",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"knuckle",KURUMI_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_KNUCKLE_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_BUJIN_GAIM_CORE= ITEMS.register("basic_bujin_gaim_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","bujin_gaim","sengoku_driver_belt_bujin_gaim",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_BUJIN_GAIM= ITEMS.register("sengoku_driver_bujin_gaim",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"bujin_gaim",BLOOD_ORANGE_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_BUJIN_GAIM_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_FIFTEEN_CORE= ITEMS.register("basic_fifteen_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","fifteen","sengoku_driver_belt_fifteen",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_FIFTEEN= ITEMS.register("sengoku_driver_fifteen",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"fifteen",FIFTEEN_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_FIFTEEN_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_MARS_CORE= ITEMS.register("basic_mars_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","mars","sengoku_driver_belt_mars",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_MARS= ITEMS.register("sengoku_driver_mars",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"mars",GOLDEN_RINGO_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_MARS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_KAMURO_CORE= ITEMS.register("basic_kamuro_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","kamuro","sengoku_driver_belt_kamuro",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_KAMURO= ITEMS.register("sengoku_driver_kamuro",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"kamuro",SILVER_RINGO_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_KAMURO_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_JAM_CORE= ITEMS.register("basic_jam_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","jam","sengoku_driver_belt_jam",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_JAM= ITEMS.register("sengoku_driver_jam",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"jam",BLACK_RINGO_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_JAM_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_KUROKAGE_TOOPERS_CORE= ITEMS.register("basic_kurokage_troopers_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","kurokage_troopers","sengoku_driver_belt_kurokage_trooper",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_KUROKAGE_TOOPERS= ITEMS.register("sengoku_driver_kurokage_troopers",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"kurokage_troopers",MATSUBOKKURI_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_KUROKAGE_TOOPERS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_IDUNN_CORE= ITEMS.register("basic_idunn_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","idunn","sengoku_driver_belt_idunn",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_IDUNN= ITEMS.register("sengoku_driver_idunn",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"idunn",FORBIBBEN_LOCKSEED_BASE , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_IDUNN_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_DUKE_CORE= ITEMS.register("basic_duke_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","duke_sengoku","sengoku_driver_belt_duke",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_DUKE= ITEMS.register("sengoku_driver_duke",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"duke_sengoku",LEMON_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_DUKE_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_BLACK_BARON_CORE = ITEMS.register("basic_black_baron_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","black_baron","sengoku_driver_belt_black_baron",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_BLACK_BARON = ITEMS.register("sengoku_driver_black_baron",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"black_baron",BANANA_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_BLACK_BARON_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_SAVIOR_CORE= ITEMS.register("basic_savior_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","saver","sengoku_driver_belt_saver",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_SAVIOR= ITEMS.register("sengoku_driver_savior",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"saver",ZAKURO_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_SAVIOR_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_MAJA_CORE= ITEMS.register("basic_maja_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","maja","sengoku_driver_belt_maja",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> SENGOKU_DRIVER_MAJA= ITEMS.register("sengoku_driver_maja",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"maja",MAJA_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_MAJA_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));


	/**
	sengoku_driver_proto_gaim
	sengoku_driver_proto_ryugen
	sengoku_driver_proto_baron
	sengoku_driver_proto_gridon
	sengoku_driver_proto_barvo

	sengoku_driver_sylphi
	sengoku_driver_gaim_natsumikan

		**/

	public static final DeferredItem<Item> GENESIS_CORE= ITEMS.register("genesis_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","duke","genesis_driver_belt",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> GENESIS_DRIVER_ZANGETSU_SHIN= ITEMS.register("genesis_driver_zangetsu_shin",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"zangetsu_shin",MELON_ENERGY_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(GENESIS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> GENESIS_DRIVER_DUKE= ITEMS.register("genesis_driver_duke",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"duke",LEMON_ENERGY_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(GENESIS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> GENESIS_DRIVER_SIGURD= ITEMS.register("genesis_driver_sigurd",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"sigurd",CHERRY_ENERGY_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(GENESIS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> GENESIS_DRIVER_MARIKA= ITEMS.register("genesis_driver_marika",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"marika",PEACH_ENERGY_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(GENESIS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> GENESIS_DRIVER_BARON_SHIN= ITEMS.register("genesis_driver_baron_shin",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"baron_shin",LEMON_ENERGY_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(GENESIS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> GENESIS_DRIVER_KUROKAGE_SHIN= ITEMS.register("genesis_driver_kurokage_shin",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"kurokage_shin",MATSUBOKKURI_ENERGY_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(GENESIS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> GENESIS_DRIVER_TYRANT= ITEMS.register("genesis_driver_tyrant",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"tyrant",PROTO_DRAGON_FRUITS_ENERGY_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(GENESIS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> GENESIS_DRIVER_RYUGEN= ITEMS.register("genesis_driver_ryugen_shin",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"ryugen_shin",MELON_ENERGY_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(GENESIS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
