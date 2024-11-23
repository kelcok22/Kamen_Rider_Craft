package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machineBlocks.GaiaMemoryRefinerBlock;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.build.BuildDriverItem;
import com.kelco.kamenridercraft.item.build.FullBottleItem;
import com.kelco.kamenridercraft.item.build.HazardTriggerItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import com.kelco.kamenridercraft.item.w.MetalShaftItem;
import com.kelco.kamenridercraft.item.w.WDriverItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Build_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> BUILD_LOGO = ITEMS.register("build_logo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));


	public static final DeferredItem<Item> FULL_BOTTLE= ITEMS.register("full_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","build_driver_belt")
					.AddToList(RiderTabs.BUILD_TAB_ITEM));


	public static final DeferredItem<Item> RABBIT_FULL_BOTTLE = ITEMS.register("rabbit_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_rabbit","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
			.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> TANK_FULL_BOTTLE = ITEMS.register("tank_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_tank","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false))
					.CanHazard().BestMatch(RABBIT_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> GORILLA_FULL_BOTTLE = ITEMS.register("gorilla_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_gorilla","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> DIAMOND_FULL_BOTTLE = ITEMS.register("diamond_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_diamond","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false))
					.BestMatch(GORILLA_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> TAKA_FULL_BOTTLE = ITEMS.register("taka_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_taka","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
					.ChangeModel("default_rider_plusbelt_and_wings.geo.json").AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> GATLING_FULL_BOTTLE = ITEMS.register("gatling_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_gatling","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false))
					.CanHazard().BestMatch(TAKA_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> NINJA_FULL_BOTTLE = ITEMS.register("ninja_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_ninja","build","build_driver_belt",
					new MobEffectInstance(MobEffects.INVISIBILITY, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> COMIC_FULL_BOTTLE = ITEMS.register("comic_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_comic","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false))
					.BestMatch(NINJA_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> PANDA_FULL_BOTTLE = ITEMS.register("panda_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_panda","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> ROCKET_FULL_BOTTLE = ITEMS.register("rocket_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_rocket","build","build_driver_belt",
					new MobEffectInstance(Effect_core.BOOST, 40, 0,true,false))
					.BestMatch(PANDA_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> HARINEZUMI_FULL_BOTTLE = ITEMS.register("harinezumi_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_harinezumi","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> SHOUBOUSHA_FULL_BOTTLE = ITEMS.register("shoubousha_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_shoubousha","build","build_driver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.BestMatch(HARINEZUMI_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> LION_FULL_BOTTLE = ITEMS.register("lion_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_lion","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> SOUJIKI_FULL_BOTTLE = ITEMS.register("soujiki_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_soujiki","build","build_driver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.BestMatch(LION_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> DRAGON_FULL_BOTTLE_BUILD = ITEMS.register("dragon_full_bottle_build",
			() -> new FullBottleItem(new Item.Properties(),0,"_dragon","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.WITHER, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)));

	public static final DeferredItem<Item> DRAGON_FULL_BOTTLE = ITEMS.register("dragon_full_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","cross_z","build_driver_belt_cross_z",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false))
					.addAlternative(DRAGON_FULL_BOTTLE_BUILD.get()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> LOCK_FULL_BOTTLE = ITEMS.register("lock_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_lock","build","build_driver_belt")
					.CanHazard().BestMatch(DRAGON_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> MEDAL_FULL_BOTTLE = ITEMS.register("medal_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_medal","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false))
					.IsLegend("ooo").BestMatch(TAKA_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> MAHOUTSUKAI_FULL_BOTTLE = ITEMS.register("mahoutsukai_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_mahoutskai","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false))
					.IsLegend("wizard").BestMatch(DIAMOND_FULL_BOTTLE.get()).ChangeSlot(1).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> RABBIT_TANK_SPARKLING = ITEMS.register("rabbittank_sparkling_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_sparkling","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
					.alsoChange1stSlot(RABBIT_FULL_BOTTLE.get()).alsoChange2ndSlot(TANK_FULL_BOTTLE.get()).ChangeSlot(3).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> HAZARD_TRIGGER = ITEMS.register("hazard_trigger",
			() -> new HazardTriggerItem(new Item.Properties(),0,"_hazard","build","build_driver_belt_hazard",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
					.ChangeSlot(3).AddToList(RiderTabs.BUILD_TAB_ITEM));


	public static final DeferredItem<Item> BUILD_HELMET = ITEMS.register("buildhead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));
	public static final DeferredItem<Item> BUILD_CHESTPLATE = ITEMS.register("buildtroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));
	public static final DeferredItem<Item> BUILD_LEGGINGS = ITEMS.register("buildlegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));


	public static final DeferredItem<Item> BUILD_DRIVER = ITEMS.register("build_driver",
			() -> new BuildDriverItem(ArmorMaterials.DIAMOND,"build",RABBIT_FULL_BOTTLE ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS , new Item.Properties())
			.Add_Extra_Base_Form_Items(TANK_FULL_BOTTLE,FULL_BOTTLE).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));
	public static final DeferredItem<Item> BUILD_DRIVER_CROSS_Z = ITEMS.register("build_driver_cross_z",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "cross_z", DRAGON_FULL_BOTTLE ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));


	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}