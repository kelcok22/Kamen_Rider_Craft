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


	public static String[] Can_use_Basic_lockseed = new String[] {"gaim","baron"};

	public static final DeferredItem<Item> BASIC_GAIM_CORE = ITEMS.register("basic-gaim_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Basic_lockseed).ChangeSlot(2));

	public static final DeferredItem<Item> ORANGE_LOCKSEED = ITEMS.register("orange_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"orange_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.alsoChange2ndSlot(BASIC_GAIM_CORE.get()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> BANANA_LOCKSEED = ITEMS.register("banana_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"banana_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.alsoChange2ndSlot(BASIC_GAIM_CORE.get()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> GAIM_HELMET = ITEMS.register("gaimhead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));
	public static final DeferredItem<Item> GAIM_CHESTPLATE = ITEMS.register("gaimtroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));
	public static final DeferredItem<Item> GAIM_LEGGINGS = ITEMS.register("gaimlegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> SENGOKU_DRIVER_GAIM = ITEMS.register("sengoku_driver_gaim",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"gaim",ORANGE_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_GAIM_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> SENGOKU_DRIVER_BARON = ITEMS.register("sengoku_driver_baron",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"baron",BANANA_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Override_belt_text("sengoku_driver_baron_belt").Add_Extra_Base_Form_Items(BASIC_GAIM_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));


	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
