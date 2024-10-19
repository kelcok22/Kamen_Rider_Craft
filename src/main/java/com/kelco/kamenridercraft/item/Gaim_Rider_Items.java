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
			,"bravo","knuckle"};



	public static final DeferredItem<Item> MATSUBOKKURI_LOCKSEED = ITEMS.register("matsubokkuri_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"matsubokkuri_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> KURUMI_LOCKSEED = ITEMS.register("kurumi_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kurumi_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> DONGURI_LOCKSEED = ITEMS.register("donguri_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"donguri_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> MELON_LOCKSEED = ITEMS.register("melon_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"melon_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> PINE_LOCKSEED = ITEMS.register("pine_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"pine_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> ICHIGO_LOCKSEED = ITEMS.register("ichigo_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"ichigo_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> ORANGE_LOCKSEED = ITEMS.register("orange_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"orange_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> BANANA_LOCKSEED = ITEMS.register("banana_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"banana_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> BUDOU_LOCKSEED = ITEMS.register("budou_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"budou_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));
//suika_lockseed

	public static final DeferredItem<Item> MANGO_LOCKSEED = ITEMS.register("mango_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"mango_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> DURIAN_LOCKSEED = ITEMS.register("durian_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"durian_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> KIWI_LOCKSEED = ITEMS.register("kiwi_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kiwi_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> LEMON_LOCKSEED = ITEMS.register("lemon_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"lemon_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> BLOOD_ORANGE_LOCKSEED = ITEMS.register("blood_orange_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"blood_orange_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	/**
	blood_orange_lockseed
	fifteen_lockseed
	golden_ringo_lockseed
	silver_ringo_lockseed
	black_ringo_lockseed
	watermelon_lockseed
	sengoku_driver_forbidden_ringo
	forbidden_ringo_lockseed
	zakuro_lockseed
	black_baron_lockseed

	 kachidoki_lockseed
	 kiwami_lockseed
	 yomotsu_heguri_lockseed
	 zangetsu_kachidoki_lockseed


	 lemon_energy_lockseed
	 cherry_energy_lockseed
	 peach_energy_lockseed
	 melon_energy_lockseed

	 matsubokkuri_energy_lockseed
	 dragon_fruits_energy_lockseed
	 marron_energy_lockseed

	dark_orange_lockseed
	dark_lemon_energy_lockseed

	fresh_orange_lockseed
	fresh_pine_lockseed

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

	kabi_orange_lockseed
	maja_lockseed
	lychee_lockseed
	king_durian_lockseed
	helheim_lockseed

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

	public static final DeferredItem<Item> SENGOKU_BRAVO_KNUCKLE= ITEMS.register("sengoku_driver_knuckle",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"knuckle",KURUMI_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_BRAVO_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	/**
	sengoku_driver_bujin_gaim
	sengoku_driver_fifteen
	sengoku_driver_mars
	sengoku_driver_kamuro
	sengoku_driver_jam

	sengoku_driver_kurokage_troopers
	sengoku_driver_idunn
	sengoku_driver_duke
	sengoku_driver_baron_black
	sengoku_driver_savior
	sengoku_driver_maja

	sengoku_driver_proto_gaim
	sengoku_driver_proto_ryugen
	sengoku_driver_proto_baron
	sengoku_driver_proto_gridon
	sengoku_driver_proto_barvo

	sengoku_driver_sylphi
	sengoku_driver_gaim_natsumikan

	genesis_driver_zangetsu_shin
	genesis_driver_duke
	genesis_driver_sigurd
	genesis_driver_marika
	genesis_driver_baron
	genesis_driver_kurokage_shin
	genesis_driver_tyrant
		genesis_driver_ryugen
		**/

	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
