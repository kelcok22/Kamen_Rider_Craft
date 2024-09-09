package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Wizard_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> WIZARD_LOGO = ITEMS.register("wizard_logo",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GEM= ITEMS.register("wizardgem",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GEM_RED= ITEMS.register("wizardgem_red",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GEM_BLUE= ITEMS.register("wizardgem_blue",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GEM_GREEN= ITEMS.register("wizardgem_green",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GEM_YELLOW= ITEMS.register("wizardgem_yellow",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GEM_VIOLET= ITEMS.register("wizardgem_violet",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GEM_BLACK= ITEMS.register("wizardgem_black",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GEM_CYAN= ITEMS.register("wizardgem_cyan",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> PHILOSOPHERS_STONE= ITEMS.register("philosophers_stone",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> FLAME_WIZARD_RING = ITEMS.register("flame_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WATER_WIZARD_RING = ITEMS.register("water_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_water","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> HURRICANE_WIZARD_RING = ITEMS.register("hurricane_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hurricane","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> LAND_WIZARD_RING = ITEMS.register("land_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_land","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> FLAME_DRAGON_WIZARD_RING = ITEMS.register("flame_ring_dragon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_flame_dragon","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WATER_DRAGON_WIZARD_RING = ITEMS.register("water_ring_dragon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_water_dragon","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> HURRICANE_DRAGON_WIZARD_RING = ITEMS.register("hurricane_ring_dragon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hurricane_dragon","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> LAND_DRAGON_WIZARD_RING_BEAST = ITEMS.register("land_ring_dragon_beast",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_wizard","beast","beast_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.ChangeModel("geo/wizard_all_dragon.geo.json"));

	public static final DeferredItem<Item> LAND_DRAGON_WIZARD_RING = ITEMS.register("land_ring_dragon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_land_dragon","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.addAlternative(LAND_DRAGON_WIZARD_RING_BEAST.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> INFINITY_WIZARD_RING = ITEMS.register("infinity_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_infinity","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));


	public static final DeferredItem<Item> DRAGO_TIMER = ITEMS.register("drago_timer",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_flame_dragon_all_dragon","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.addNeedForm(FLAME_DRAGON_WIZARD_RING.get(),1).ChangeModel("geo/wizard_all_dragon.geo.json").AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WATER_DRAGON_WIZARD_SPECIAL_RING = ITEMS.register("water_ring_dragon_special_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_water_dragon_special","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.addNeedForm(WATER_DRAGON_WIZARD_RING.get(),1).ChangeModel("geo/wizard_all_dragon.geo.json"));

	public static final DeferredItem<Item> HURRICANE_DRAGON_WIZARD_SPECIAL_RING = ITEMS.register("hurricane_ring_dragon_special_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hurricane_dragon_special","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.addNeedForm(HURRICANE_DRAGON_WIZARD_RING.get(),1).addAlternative(WATER_DRAGON_WIZARD_SPECIAL_RING.get()).ChangeModel("geo/wizard_all_dragon.geo.json"));

	public static final DeferredItem<Item> LAND_DRAGON_WIZARD_SPECIAL_RING = ITEMS.register("land_ring_dragon_special_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_land_dragon_special","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.addNeedForm(LAND_DRAGON_WIZARD_RING.get(),1).addAlternative(HURRICANE_DRAGON_WIZARD_SPECIAL_RING.get()).ChangeModel("geo/wizard_all_dragon.geo.json"));

	public static final DeferredItem<Item> SPECIAL_RING = ITEMS.register("special_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_flame_dragon_special","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.ChangeModel("geo/wizard_all_dragon.geo.json").addAlternative(LAND_DRAGON_WIZARD_SPECIAL_RING.get())
					.addNeedForm(FLAME_DRAGON_WIZARD_RING.get(),1).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> HOPE_RING = ITEMS.register("hope_ring",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> FINISH_STRIKE_RING_NO_HOPE  = ITEMS.register("finish_strike_ring_no_hope",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_infinity_dragon","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.addNeedForm(INFINITY_WIZARD_RING.get(),1).ChangeModel("geo/wizard_all_dragon.geo.json"));

	public static final DeferredItem<Item> FINISH_STRIKE_RING  = ITEMS.register("finish_strike_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_infinity_gold","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.addNeedForm(INFINITY_WIZARD_RING.get(),1).ChangeModel("geo/wizard_all_dragon.geo.json")
					.addNeedItem(HOPE_RING.get()).addAlternative(FINISH_STRIKE_RING_NO_HOPE.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> SPECIAL_RUSH_RING = ITEMS.register("special_rush_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_flame_dragon_special_rush","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.addNeedForm(FLAME_DRAGON_WIZARD_RING.get(),1).ChangeModel("geo/wizard_all_dragon.geo.json").AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> BEAST_RING = ITEMS.register("beast_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","beast","beast_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> FALCO_RING_WIZARD = ITEMS.register("falco_ring_wizard",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_falco","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.addNeedForm(FLAME_DRAGON_WIZARD_RING.get(),1));

	public static final DeferredItem<Item> FALCO_RING = ITEMS.register("falco_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_falco","beast","beast_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.addAlternative(FALCO_RING_WIZARD.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> CHAMELEO_RING = ITEMS.register("chameleo_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_chameleo","beast","beast_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));


	public static final DeferredItem<Item> BUFFA_RING_WIZARD = ITEMS.register("buffa_ring_wizard",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_beast","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.addNeedForm(FALCO_RING_WIZARD.get(),1));

	public static final DeferredItem<Item> BUFFA_RING = ITEMS.register("buffa_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_buffa","beast","beast_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.addAlternative(BUFFA_RING_WIZARD.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> DOLPHI_RING = ITEMS.register("dolphi_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_dolphi","beast","beast_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> HYPER_RING = ITEMS.register("hyper_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hyper","beast","beast_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WISEMAN_RING = ITEMS.register("wiseman_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","wiseman","wise_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> MAGE_O_RING = ITEMS.register("mage_o_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","mage","wise_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> MAGE_B_RING = ITEMS.register("mage_b_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","mage_blue","wise_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> MAGE_G_RING = ITEMS.register("mage_g_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","mage_green","wise_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> SORCERER_RING = ITEMS.register("sorcerer_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","sorcerer","wise_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_WIZARD_RING = ITEMS.register("black_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","black_wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> DARK_WIZARD_RING = ITEMS.register("dark_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","dark_wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	/*

	light_ring
	excite_ring
	defend_ring
	thunder_ring
	explosion_ring
	sleep_ring
	bind_ring
	teleport_ring
	fall_ring
	connect_ring
	kick_strike_ring
	eclipse_ring
	liquid_ring
	drill_ring
	big_ring
	small_ring
	*/
	public static final DeferredItem<Item> DRESS_UP_RING = ITEMS.register("dress_up_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_dressup","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.addNeedForm(FLAME_WIZARD_RING.get(),1).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));


/*
	engage_ring
	please_ring
	driver_on_ring
	driver_on_ring_white_wizard
	common_wizard_ring
	chichin_pui_pui_ring
	create_ring
	copy_ring
	smell_ring
	extend_ring
	merry_christmas_ring
	blizzard_ring
	gravity_ring
	miracle_ring
	flower_ring
	dance_ring
	time_ring
	holy_ring

	beast_engage_ring
	chimarise_ring
	beast_driver_on_ring
	fourze_engage_ring
	super_sentai_ring
*/
	public static final DeferredItem<Item> WIZARD_LOGO_HELMET = ITEMS.register("wizard_head",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));
	public static final DeferredItem<Item> WIZARD_LOGO_CHESTPLATE = ITEMS.register("wizard_troso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));
	public static final DeferredItem<Item> WIZARD_LOGO_LEGGINGS = ITEMS.register("wizard_legs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARDRIVER = ITEMS.register("wizardriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"wizard",FLAME_WIZARD_RING , WIZARD_LOGO_HELMET, WIZARD_LOGO_CHESTPLATE, WIZARD_LOGO_LEGGINGS, new Item.Properties())
			.AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> BEAST_DRIVER = ITEMS.register("beastdriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"beast",BEAST_RING , WIZARD_LOGO_HELMET, WIZARD_LOGO_CHESTPLATE, WIZARD_LOGO_LEGGINGS, new Item.Properties())
					.AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WHITE_WIZARD_DRIVER = ITEMS.register("whitewizardriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"wiseman",WISEMAN_RING , WIZARD_LOGO_HELMET, WIZARD_LOGO_CHESTPLATE, WIZARD_LOGO_LEGGINGS, new Item.Properties())
					.AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> MAGE_DRIVER = ITEMS.register("magewizardriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"mage",MAGE_O_RING , WIZARD_LOGO_HELMET, WIZARD_LOGO_CHESTPLATE, WIZARD_LOGO_LEGGINGS, new Item.Properties())
					.AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> MAGE_DRIVER_B = ITEMS.register("magewizardriver_b",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"mage_blue",MAGE_B_RING , WIZARD_LOGO_HELMET, WIZARD_LOGO_CHESTPLATE, WIZARD_LOGO_LEGGINGS, new Item.Properties())
					.AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> MAGE_DRIVER_G = ITEMS.register("magewizardriver_g",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"mage_green",MAGE_G_RING , WIZARD_LOGO_HELMET, WIZARD_LOGO_CHESTPLATE, WIZARD_LOGO_LEGGINGS, new Item.Properties())
					.AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> MAGE_DRIVER_FOOT_SOLDIERS = ITEMS.register("magewizardriver_foot_soldiers",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"mage_foot_soldiers",MAGE_O_RING , WIZARD_LOGO_HELMET, WIZARD_LOGO_CHESTPLATE, WIZARD_LOGO_LEGGINGS, new Item.Properties())
					.AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> MAGE_DRIVER_CAPTAIN = ITEMS.register("magewizardriver_captain",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"mage_captain",MAGE_O_RING , WIZARD_LOGO_HELMET, WIZARD_LOGO_CHESTPLATE, WIZARD_LOGO_LEGGINGS, new Item.Properties())
					.AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> SORCERER_DRIVER = ITEMS.register("sorcererdriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"sorcerer",SORCERER_RING , WIZARD_LOGO_HELMET, WIZARD_LOGO_CHESTPLATE, WIZARD_LOGO_LEGGINGS, new Item.Properties())
					.AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WHITE_WIZARD_DRIVER_F = ITEMS.register("whitewizardriver_f",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"wiseman_female",WISEMAN_RING , WIZARD_LOGO_HELMET, WIZARD_LOGO_CHESTPLATE, WIZARD_LOGO_LEGGINGS, new Item.Properties())
					.AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> DARK_WIZARDRIVER = ITEMS.register("dark_wizardriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_wizard",DARK_WIZARD_RING , WIZARD_LOGO_HELMET, WIZARD_LOGO_CHESTPLATE, WIZARD_LOGO_LEGGINGS, new Item.Properties())
					.AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_WIZARDRIVER = ITEMS.register("black_wizardriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"black_wizard",BLACK_WIZARD_RING , WIZARD_LOGO_HELMET, WIZARD_LOGO_CHESTPLATE, WIZARD_LOGO_LEGGINGS, new Item.Properties())
					.AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GEM_CRAFTING_CHISEL= ITEMS.register("wizard_gem_crafting_chisel",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

/*
	wizarswordgun
	axcalibur
	wizarswordgun_mage
	hammelcane
	dis_halberd
	mirage_magnum
	dice_saber
*/

	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
