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

	public static final DeferredItem<Item> LAND_DRAGON_WIZARD_RING = ITEMS.register("land_ring_dragon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_land_dragon","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> INFINITY_WIZARD_RING = ITEMS.register("infinity_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_infinity","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false)).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));


	public static final DeferredItem<Item> DRAGO_TIMER = ITEMS.register("drago_timer",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_flame_dragon_all_dragon","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.addNeedForm(FLAME_DRAGON_WIZARD_RING.get(),1).ChangeModel("geo/wizard_all_dragon.geo.json").AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	/*
	special_ring
	finish_strike_ring
	hope_ring
	special_rush_ring

	beast_ring
	falco_ring
	chameleo_ring
	buffa_ring
	dolphi_ring
	hyper_ring

	wiseman_ring
	mage_o_ring
	mage_b_ring
	mage_g_ring
	sorcerer_ring
	black_ring
	dark_ring

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
	dress_up_ring

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


	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
