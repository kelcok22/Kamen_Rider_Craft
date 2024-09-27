package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machineBlocks.GaiaMemoryRefinerBlock;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.build.BuildDriverItem;
import com.kelco.kamenridercraft.item.build.FullBottleItem;
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

	public static final DeferredItem<Item> BUILD_HELMET = ITEMS.register("buildhead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));
	public static final DeferredItem<Item> BUILD_CHESTPLATE = ITEMS.register("buildtroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));
	public static final DeferredItem<Item> BUILD_LEGGINGS = ITEMS.register("buildlegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));


	public static final DeferredItem<Item> BUILD_DRIVER = ITEMS.register("build_driver",
			() -> new BuildDriverItem(ArmorMaterials.DIAMOND,"build",RABBIT_FULL_BOTTLE ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS , new Item.Properties())
			.Add_Extra_Base_Form_Items(TANK_FULL_BOTTLE).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));


	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}