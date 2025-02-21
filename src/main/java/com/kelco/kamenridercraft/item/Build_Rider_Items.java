package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machineBlocks.FullbottlePurifier;
import com.kelco.kamenridercraft.block.machineBlocks.FullbottleSolidifier;
import com.kelco.kamenridercraft.block.machineBlocks.PandoraBox;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.build.*;
import com.kelco.kamenridercraft.item.misc.GiftItem;
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

import java.util.ArrayList;
import java.util.List;

import static com.kelco.kamenridercraft.item.Reboot_Rider_Items.EMPTY_VIAL;

public class Build_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static List<Item> NEED_ITEM_BI_KAISER= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_HELL_BROS= new ArrayList<Item>();

	public static final DeferredItem<Item> BUILD_LOGO = ITEMS.register("build_logo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> NEBULA_GAS_SAMPLE = ITEMS.register("nebula_gas_sample",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> FULL_BOTTLE= ITEMS.register("full_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","","build_driver_belt")
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> SCLASH_JELLY= ITEMS.register("sclash_jelly",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottleSolidifier.BOTTLE_SOLIDIFIED));

	public static final DeferredItem<Item> SMASH_BOTTLE = ITEMS.register("smash_bottle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> GOLDEN_BANGLE= ITEMS.register("golden_bangle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));


	public static final DeferredItem<Item> RABBIT_FULL_BOTTLE = ITEMS.register("rabbit_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_rabbit","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
		.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> TANK_FULL_BOTTLE = ITEMS.register("tank_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_tank","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false))
					.CanHazard().BestMatch(RABBIT_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> GORILLA_FULL_BOTTLE = ITEMS.register("gorilla_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_gorilla","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> DIAMOND_FULL_BOTTLE = ITEMS.register("diamond_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_diamond","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.BestMatch(GORILLA_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> TAKA_FULL_BOTTLE_CROSS_Z = ITEMS.register("taka_full_bottle_cross_z",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_taka","cross_z_charge","sclash_driver_belt_taka",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0, true, false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.ChangeModel("default_wings_armor.geo.json").model_has_different_name("taka_full_bottle").has_basic_model());

	public static final DeferredItem<Item> TAKA_FULL_BOTTLE = ITEMS.register("taka_full_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_taka","build","build_driver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.addAlternative(TAKA_FULL_BOTTLE_CROSS_Z.get()).ChangeModel("default_rider_plusbelt_and_wings.geo.json").AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> GATLING_FULL_BOTTLE = ITEMS.register("gatling_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_gatling","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
					.CanHazard().BestMatch(TAKA_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> NINJA_FULL_BOTTLE = ITEMS.register("ninja_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_ninja","build","build_driver_belt",
					new MobEffectInstance(Effect_core.STEALTH, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> COMIC_FULL_BOTTLE = ITEMS.register("comic_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_comic","build","build_driver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.BestMatch(NINJA_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> PANDA_FULL_BOTTLE = ITEMS.register("panda_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_panda","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> ROCKET_FULL_BOTTLE = ITEMS.register("rocket_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_rocket","build","build_driver_belt",
					new MobEffectInstance(Effect_core.BOOST, 40, 0,true,false))
					.BestMatch(PANDA_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> HARINEZUMI_FULL_BOTTLE = ITEMS.register("harinezumi_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_harinezumi","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> SHOUBOUSHA_FULL_BOTTLE = ITEMS.register("shoubousha_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_shoubousha","build","build_driver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.BestMatch(HARINEZUMI_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> LION_FULL_BOTTLE = ITEMS.register("lion_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_lion","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> SOUJIKI_FULL_BOTTLE = ITEMS.register("soujiki_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_soujiki","build","build_driver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.BestMatch(LION_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> DRAGON_FULL_BOTTLE_BUILD = ITEMS.register("dragon_full_bottle_build",
			() -> new FullBottleItem(new Item.Properties(),0,"_dragon","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.WITHER, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
					.model_has_different_name("dragon_full_bottle").has_basic_model());

	public static final DeferredItem<Item> DRAGON_FULL_BOTTLE = ITEMS.register("dragon_full_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","cross_z","build_driver_belt_cross_z",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false))
					.addAlternative(DRAGON_FULL_BOTTLE_BUILD.get()).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> LOCK_FULL_BOTTLE = ITEMS.register("lock_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_lock","build","build_driver_belt")
					.CanHazard().BestMatch(DRAGON_FULL_BOTTLE_BUILD.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> KAIZOKU_FULL_BOTTLE = ITEMS.register("kaizoku_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_kaizoku","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> DENSHA_FULL_BOTTLE = ITEMS.register("densha_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_densha","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false))
					.CanHazard().BestMatch(KAIZOKU_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> OCTOPUS_FULL_BOTTLE = ITEMS.register("octopus_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_octopus","build","build_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> LIGHT_FULL_BOTTLE = ITEMS.register("light_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_light","build","build_driver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.BestMatch(OCTOPUS_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> PHOENIX_FULL_BOTTLE = ITEMS.register("phoenix_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_phoenix","build","build_driver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.ChangeModel("default_rider_plusbelt_and_wings.geo.json").AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> ROBOT_FULL_BOTTLE = ITEMS.register("robot_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_robot","build","build_driver_belt",
					new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false))
					.BestMatch(PHOENIX_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> WOLF_FULL_BOTTLE = ITEMS.register("wolf_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_wolf","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> SMAPHO_FULL_BOTTLE = ITEMS.register("smapho_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_smapho","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.CanHazard().BestMatch(WOLF_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> UNICORN_FULL_BOTTLE = ITEMS.register("unicorn_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_unicorn","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> KESHIGOMU_FULL_BOTTLE = ITEMS.register("keshigomu_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_keshigomu","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
					.BestMatch(UNICORN_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> ROSE_FULL_BOTTLE = ITEMS.register("rose_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_rose","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> HELICOPTER_FULL_BOTTLE = ITEMS.register("helicopter_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_helicopter","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.BestMatch(ROSE_FULL_BOTTLE.get()).ChangeModel("default_rider_plusbelt_and_wings.geo.json").ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> TURTLE_FULL_BOTTLE = ITEMS.register("turtle_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_turtle","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> WATCH_FULL_BOTTLE = ITEMS.register("watch_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_watch","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
					.BestMatch(TURTLE_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> KUMA_FULL_BOTTLE = ITEMS.register("kuma_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_kuma","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> TELEVI_FULL_BOTTLE = ITEMS.register("televi_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_televi","build","build_driver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.BestMatch(KUMA_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> KABUTOMUSHI_FULL_BOTTLE = ITEMS.register("kabutomushi_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_kabutomushi","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> CAMERA_FULL_BOTTLE = ITEMS.register("camera_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_camera","build","build_driver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.BestMatch(KABUTOMUSHI_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> SPIDER_FULL_BOTTLE = ITEMS.register("spider_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_spider","build","build_driver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> REIZOUKO_FULL_BOTTLE = ITEMS.register("reizouko_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_reizouko","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.BestMatch(SPIDER_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> DOG_FULL_BOTTLE = ITEMS.register("dog_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_dog","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> MIC_FULL_BOTTLE = ITEMS.register("mic_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_mic","build","build_driver_belt",
					new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
					.BestMatch(DOG_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> SANTA_CLAUS_FULL_BOTTLE = ITEMS.register("santa_claus_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_santa_claus","build","build_driver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
					.AddToList(GiftItem.GIFTS).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> CAKE_FULL_BOTTLE = ITEMS.register("cake_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_cake","build","build_driver_belt",
					new MobEffectInstance(MobEffects.SATURATION, 40, 1,true,false))
					.BestMatch(SANTA_CLAUS_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(GiftItem.GIFTS).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> TORA_FULL_BOTTLE = ITEMS.register("tora_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_tora","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> UFO_FULL_BOTTLE = ITEMS.register("ufo_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_ufo","build","build_driver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.BestMatch(TORA_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> KUJIRA_FULL_BOTTLE = ITEMS.register("kujira_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_kujira","build","build_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 0,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> JET_FULL_BOTTLE = ITEMS.register("jet_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_jet","build","build_driver_belt",
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.BestMatch(KUJIRA_FULL_BOTTLE.get()).ChangeModel("default_rider_plusbelt_and_wings.geo.json").ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> SHIKA_FULL_BOTTLE = ITEMS.register("shika_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_shika","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> PYRAMID_FULL_BOTTLE = ITEMS.register("pyramid_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_pyramid","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.BestMatch(SHIKA_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> KIRIN_FULL_BOTTLE = ITEMS.register("kirin_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_kirin","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> SENPUUKI_FULL_BOTTLE = ITEMS.register("senpuuki_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_senpuuki","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.BestMatch(KIRIN_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> PENGUIN_FULL_BOTTLE = ITEMS.register("penguin_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_penguin","build","build_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 0,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> SKEBO_FULL_BOTTLE = ITEMS.register("skebo_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_skebo","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
					.BestMatch(PENGUIN_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> SAME_FULL_BOTTLE = ITEMS.register("same_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_same","build","build_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 0,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> BIKE_FULL_BOTTLE = ITEMS.register("bike_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_bike","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
					.BestMatch(SAME_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> HACHI_FULL_BOTTLE = ITEMS.register("hachi_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_hachi","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> SENSUIKAN_FULL_BOTTLE = ITEMS.register("sensuikan_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_sensuikan","build","build_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 0,true,false))
					.BestMatch(HACHI_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> SAI_FULL_BOTTLE = ITEMS.register("sai_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_sai","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> DRYER_FULL_BOTTLE = ITEMS.register("dryer_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_dryer","build","build_driver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.BestMatch(SAI_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> BAT_FULL_BOTTLE = ITEMS.register("bat_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_bat","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> ENGINE_FULL_BOTTLE = ITEMS.register("engine_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_engine","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
					.BestMatch(BAT_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> OBAKE_FULL_BOTTLE = ITEMS.register("obake_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_obake","build","build_driver_belt",
					new MobEffectInstance(Effect_core.GHOST, 40, 0,true,false),
					new MobEffectInstance(Effect_core.STEALTH, 40, 0,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> MAGNET_FULL_BOTTLE = ITEMS.register("magnet_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_magnet","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
					.BestMatch(OBAKE_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> SCORPION_FULL_BOTTLE = ITEMS.register("scorpion_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_scorpion","build","build_driver_belt",
					new MobEffectInstance(Effect_core.ANTIPOISON, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> GOLD_FULL_BOTTLE = ITEMS.register("gold_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_gold","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
					.BestMatch(SCORPION_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> PANDORA_BOTTLE = ITEMS.register("pandora_bottle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(PandoraBox.PANDORA_BOTTLE).has_basic_model());

	public static final DeferredItem<Item> RABBIT_TANK_SPARKLING = ITEMS.register("rabbittank_sparkling_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_sparkling","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.alsoChange1stSlot(RABBIT_FULL_BOTTLE.get()).alsoChange2ndSlot(TANK_FULL_BOTTLE.get()).ChangeSlot(3).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> HAZARD_TRIGGER = ITEMS.register("hazard_trigger",
			() -> new HazardTriggerItem(new Item.Properties(),0,"_hazard","build","build_driver_belt_hazard",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.HUNGER, 40, 1,true,false))
					.ChangeSlot(3).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> LOW_RABBIT_FULL_BOTTLE = ITEMS.register("low_rabbit_full_bottle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.BANGLE_REFINED));

	public static final DeferredItem<Item> FULLFULL_TANK_BOTTLE = ITEMS.register("fullfull_tank_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_tank","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false))
					.alsoChange1stSlot(RABBIT_FULL_BOTTLE.get()).alsoChange2ndSlot(TANK_FULL_BOTTLE.get()).ChangeSlot(3)
					.model_has_different_name("fullfull_rabbit_tank_bottle").has_basic_model());

	public static final DeferredItem<Item> FULLFULL_RABBIT_TANK_BOTTLE = ITEMS.register("fullfull_rabbit_tank_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_rabbit","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false))
					.addSwitchForm(FULLFULL_TANK_BOTTLE.get()).alsoChange1stSlot(RABBIT_FULL_BOTTLE.get()).alsoChange2ndSlot(TANK_FULL_BOTTLE.get()).ChangeSlot(3).addNeedItem(HAZARD_TRIGGER.get()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> UNFINISHED_GENIUS_FULL_BOTTLE = ITEMS.register("unfinished_genius_full_bottle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> GENIUS_FULL_BOTTLE = ITEMS.register("genius_full_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_genius","build","build_driver_belt",
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
					.alsoChange1stSlot(RABBIT_FULL_BOTTLE.get()).alsoChange2ndSlot(TANK_FULL_BOTTLE.get()).ChangeSlot(3).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> GOLD_RABBIT_FULL_BOTTLE = ITEMS.register("gold_rabbit_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_gold_rabbit","build","build_driver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> SILVER_DRAGON_FULL_BOTTLE = ITEMS.register("silver_dragon_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_silver_dragon","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
					.BestMatch(GOLD_RABBIT_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottlePurifier.FULLBOTTLE_PURIFIER));

	public static final DeferredItem<Item> CROSS_Z_BUILD_CAN = ITEMS.register("cross_z_build_can",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cross_z","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 1,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0, true, false))
					.alsoChange1stSlot(RABBIT_FULL_BOTTLE.get()).alsoChange2ndSlot(TANK_FULL_BOTTLE.get()).ChangeSlot(3).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> MOMOTAROS_FULL_BOTTLE = ITEMS.register("momotaros_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_momotaros","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.IsLegend("den_o").BestMatch(DENSHA_FULL_BOTTLE.get()).ChangeSlot(1).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> RIDER_CARD_FULL_BOTTLE = ITEMS.register("rider_card_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_rider_card","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
					.IsLegend("decade").BestMatch(CAMERA_FULL_BOTTLE.get()).ChangeSlot(1).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> TANTEI_FULL_BOTTLE = ITEMS.register("tantei_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_tantei","build","build_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> USB_MEMORY_FULL_BOTTLE = ITEMS.register("usb_memory_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_usb_memory","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
					.IsLegend("w").BestMatch(TANTEI_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> MEDAL_FULL_BOTTLE = ITEMS.register("medal_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_medal","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
					.IsLegend("ooo").BestMatch(TAKA_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> YUUJOU_FULL_BOTTLE = ITEMS.register("yuujou_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_yuujou","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.IsLegend("fourze").BestMatch(ROCKET_FULL_BOTTLE.get()).ChangeSlot(1).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> MAHOUTSUKAI_FULL_BOTTLE = ITEMS.register("mahoutsukai_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_mahoutsukai","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.IsLegend("wizard").BestMatch(DIAMOND_FULL_BOTTLE.get()).ChangeSlot(1).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> ORANGE_FULL_BOTTLE = ITEMS.register("orange_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_orange","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
					.IsLegend("gaim").BestMatch(LOCK_FULL_BOTTLE.get()).ChangeSlot(1).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> PARKA_FULL_BOTTLE = ITEMS.register("parka_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_parka","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.IsLegend("ghost").BestMatch(OBAKE_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> DOCTOR_FULL_BOTTLE = ITEMS.register("doctor_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_doctor","build","build_driver_belt",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> GAME_FULL_BOTTLE = ITEMS.register("game_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"_game","build","build_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.IsLegend("ex_aid").BestMatch(DOCTOR_FULL_BOTTLE.get()).ChangeSlot(2).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> DRAGON_SCLASH_JELLY = ITEMS.register("dragon_sclash_jelly",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","cross_z_charge","sclash_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottleSolidifier.CROSSZ_SOLIDIFIED));

	public static final DeferredItem<Item> DRAGON_MAGMA_FULL_BOTTLE = ITEMS.register("dragon_magma_full_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_magma","cross_z","build_driver_belt_magma",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> GREAT_DRAGON_EVOL_BOTTLE = ITEMS.register("great_dragon_evol_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_great","cross_z","build_driver_belt_great",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> MUSCLE_GALAXY_FULL_BOTTLE = ITEMS.register("muscle_galaxy_full_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_evol","cross_z","build_driver_belt_evol",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> ROBOT_SCLASH_JELLY = ITEMS.register("robot_sclash_jelly",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","grease","sclash_driver_belt_grease",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottleSolidifier.GREASE_SOLIDIFIED));

	public static final DeferredItem<Item> NORTH_BLIZZARD_FULL_BOTTLE = ITEMS.register("north_blizzard_full_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","grease_blizzard","build_driver_belt_blizzard",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> GREASE_FULL_BOTTLE = ITEMS.register("grease_full_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_perfect_kingdom","grease_blizzard","build_driver_belt_perfect_kingdom",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> CROCODILE_CRACK_FULL_BOTTLE = ITEMS.register("crocodile_crack_full_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","rogue","sclash_driver_belt_rogue",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM).AddToList(FullbottleSolidifier.ROGUE_SOLIDIFIED));

	public static final DeferredItem<Item> PRIME_ROGUE_FULL_BOTTLE = ITEMS.register("prime_rogue_full_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","prime_rogue","build_driver_belt_prime",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> COBRA_EVOL_BOTTLE = ITEMS.register("cobra_evol_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","evol","evol_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> RIDER_SYSTEM_EVOL_BOTTLE = ITEMS.register("rider_system_evol_bottle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> DRAGON_EVOL_BOTTLE = ITEMS.register("dragon_evol_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_dragon","evol","evol_driver_belt_d",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> RABBIT_EVOL_BOTTLE = ITEMS.register("rabbit_evol_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_rabbit","evol","evol_driver_belt_r",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> EVOL_TRIGGER_KAIJIN = ITEMS.register("evol_trigger_kaijin",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kaijin","evol","evol_driver_belt_b",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.model_has_different_name("evol_trigger").has_basic_model());

	public static final DeferredItem<Item> EVOL_TRIGGER = ITEMS.register("evol_trigger",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_black_hole","evol","evol_driver_belt_b",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.addShiftForm(EVOL_TRIGGER_KAIJIN.get()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> EVOL_X_FULL_BOTTLE = ITEMS.register("evol_x_full_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_x","evol","evol_driver_belt_evol_x",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.has_basic_model().AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> MAD_ROGUE_BOTTLES = ITEMS.register("mad_rogue_bottles",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","mad_rogue","evol_driver_belt_mad_rogue",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.hasFlyingWings(null));

	public static final DeferredItem<Item> KILLBUS_SPIDER_FULL_BOTTLE = ITEMS.register("killbus_spider_full_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","killbus","build_driver_belt_killbus",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> METAL_TANK_TANK_FULL_BOTTLE = ITEMS.register("metal_tank_tank_full_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","metal_build","build_driver_belt_metal",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> METAL_FULL_BOTTLE = ITEMS.register("metal_full_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","phantom_build","build_driver_belt_metal",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> LOST_BAT_FULL_BOTTLE = ITEMS.register("lost_bat_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"","night_rogue","blank",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.hasFlyingWings(null).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> LOST_COBRA_FULL_BOTTLE = ITEMS.register("lost_cobra_full_bottle",
			() -> new FullBottleItem(new Item.Properties(),0,"","blood_stalk","blank",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_LOST_COBRA_FULL_BOTTLE = ITEMS.register("black_lost_cobra_full_bottle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","blood","build_driver_belt_blood",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_LOST_BAT_FULL_BOTTLE= ITEMS.register("black_lost_bat_full_bottle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_LOST_CD_FULL_BOTTLE= ITEMS.register("black_lost_cd_full_bottle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_LOST_CASTLE_FULL_BOTTLE= ITEMS.register("black_lost_castle_full_bottle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_LOST_KUWAGATA_FULL_BOTTLE= ITEMS.register("black_lost_kuwagata_full_bottle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_LOST_FUKUROU_FULL_BOTTLE= ITEMS.register("black_lost_fukurou_full_bottle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_LOST_SHIMAUMA_FULL_BOTTLE= ITEMS.register("black_lost_shimauma_full_bottle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_LOST_SPANNER_FULL_BOTTLE= ITEMS.register("black_lost_spanner_full_bottle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_LOST_HAMMER_FULL_BOTTLE= ITEMS.register("black_lost_hammer_full_bottle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_LOST_HASAMI_FULL_BOTTLE= ITEMS.register("black_lost_hasami_full_bottle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> LOST_CASTLE_FULL_BOTTLE= ITEMS.register("lost_castle_full_bottle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> LOST_KUWAGATA_FULL_BOTTLE= ITEMS.register("lost_kuwagata_full_bottle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> LOST_FUKUROU_FULL_BOTTLE= ITEMS.register("lost_fukurou_full_bottle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> GEAR_BI_KAISER = ITEMS.register("gear_bi_kaiser",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_bi","kaiser","blank",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(Effect_core.FIRE_PUNCH, 40, 4,true,false))
					.AddNeedItemList(NEED_ITEM_BI_KAISER).model_has_different_name("gear_engine_red").has_basic_model());

	public static final DeferredItem<Item> GEAR_ENGINE_RED = ITEMS.register("gear_engine_red",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_reverse","kaiser","blank",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.addShiftForm(GEAR_BI_KAISER.get()).AddToList(NEED_ITEM_BI_KAISER).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> GEAR_REMOCON_BLUE = ITEMS.register("gear_remocon_blue",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","kaiser","blank",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
					.addShiftForm(GEAR_BI_KAISER.get()).AddToList(NEED_ITEM_BI_KAISER).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> GEAR_HELL_BROS = ITEMS.register("gear_hell_bros",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","hell_bros","blank",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
					.AddNeedItemList(NEED_ITEM_HELL_BROS).model_has_different_name("gear_engine").has_basic_model());

	public static final DeferredItem<Item> GEAR_ENGINE = ITEMS.register("gear_engine",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_engine","hell_bros","blank",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.addShiftForm(GEAR_HELL_BROS.get()).AddToList(NEED_ITEM_HELL_BROS).AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static final DeferredItem<Item> GEAR_REMOCON = ITEMS.register("gear_remocon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_remocon","hell_bros","blank",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
					.addShiftForm(GEAR_HELL_BROS.get()).AddToList(NEED_ITEM_HELL_BROS).AddToList(RiderTabs.BUILD_TAB_ITEM));

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
	public static final DeferredItem<Item> BUILD_DRIVER_GREASE = ITEMS.register("build_driver_grease",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "grease_blizzard", NORTH_BLIZZARD_FULL_BOTTLE ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));
	public static final DeferredItem<Item> BUILD_DRIVER_ROGUE = ITEMS.register("build_driver_rogue",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "prime_rogue", PRIME_ROGUE_FULL_BOTTLE ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));
	public static final DeferredItem<Item> BUILD_DRIVER_BLOOD = ITEMS.register("build_driver_blood",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "blood", BLACK_LOST_COBRA_FULL_BOTTLE ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));
	public static final DeferredItem<Item> BUILD_DRIVER_KILLBUS = ITEMS.register("build_driver_killbus",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "killbus", KILLBUS_SPIDER_FULL_BOTTLE ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));
	public static final DeferredItem<Item> BUILD_DRIVER_METAL = ITEMS.register("build_driver_metal",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "metal_build", METAL_TANK_TANK_FULL_BOTTLE ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));
	public static final DeferredItem<Item> BUILD_DRIVER_PHANTOM = ITEMS.register("build_driver_phantom",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "phantom_build", METAL_FULL_BOTTLE ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));

	public static final DeferredItem<Item> SCLASH_DRIVER = ITEMS.register("sclash_driver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "cross_z_charge", DRAGON_SCLASH_JELLY ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));
	public static final DeferredItem<Item> SCLASH_DRIVER_GREASE = ITEMS.register("sclash_driver_grease",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "grease", ROBOT_SCLASH_JELLY ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));
	public static final DeferredItem<Item> SCLASH_DRIVER_ROGUE = ITEMS.register("sclash_driver_rogue",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "rogue", CROCODILE_CRACK_FULL_BOTTLE ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));

	public static final DeferredItem<Item> EVOL_DRIVER = ITEMS.register("evol_driver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "evol", COBRA_EVOL_BOTTLE ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));
	public static final DeferredItem<Item> EVOL_DRIVER_MAD_ROGUE = ITEMS.register("evol_driver_mad_rogue",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "mad_rogue", MAD_ROGUE_BOTTLES ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));

	public static final DeferredItem<Item> TRANSTEAM_GUN_NIGHT_ROGUE = ITEMS.register("transteam_gun_night_rogue",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"night_rogue",LOST_BAT_FULL_BOTTLE ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));
	public static final DeferredItem<Item> TRANSTEAM_GUN_BLOOD_STALK = ITEMS.register("transteam_gun_blood_stalk",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"blood_stalk",LOST_COBRA_FULL_BOTTLE ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));

	public static final DeferredItem<Item> NEBULA_STEAM_GUN_KAISER = ITEMS.register("nebula_steam_gun_kaiser",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kaiser",GEAR_REMOCON_BLUE ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));
	public static final DeferredItem<Item> NEBULA_STEAM_GUN_HELL_BROS = ITEMS.register("nebula_steam_gun_hell_bros",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"hell_bros",GEAR_REMOCON ,BUILD_HELMET,BUILD_CHESTPLATE,BUILD_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));


	public static final DeferredItem<Item> FULLBOTTLE_HOLDER = ITEMS.register("fullbottle_holder",
			() -> new FullBottleHolderItem().AddToList(RiderTabs.BUILD_TAB_ITEM));

    public static final DeferredItem<Item> DRILL_CRUSHER = ITEMS.register("drill_crusher",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));

    public static final DeferredItem<Item> HAWK_GATLINGER = ITEMS.register("hawk_gatlinger",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));

	public static final DeferredItem<Item> KOMA_NINPOUTOU = ITEMS.register("4koma_ninpoutou",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));

    public static final DeferredItem<Item> KAIZOKU_HASSYAR = ITEMS.register("kaizoku_hassyar",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));

    public static final DeferredItem<Item> TWIN_BREAKER = ITEMS.register("twin_breaker",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));

	public static final DeferredItem<Item> BEAT_CROSSER = ITEMS.register("beat_crosser",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));

    public static final DeferredItem<Item> FULLBOTTLE_BUSTER = ITEMS.register("fullbottle_buster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));

	public static final DeferredItem<Item> MAGMA_KNUCKLE = ITEMS.register("magma_knuckle",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));

	public static final DeferredItem<Item> BLIZZARD_KNUCKLE = ITEMS.register("blizzard_knuckle",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));

	public static final DeferredItem<Item> TRANSTEAM_GUN = ITEMS.register("transteam_gun",
			() -> new TransteamGunItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM)
			.ChangeRepairItem(FULL_BOTTLE.get()));

    public static final DeferredItem<Item> TRANSTEAM_GUN_RIFLE_MODE = ITEMS.register("transteam_gun_rifle",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));

	public static final DeferredItem<Item> STEAM_BLADE = ITEMS.register("steam_blade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));

	public static final DeferredItem<Item> NEBULASTEAM_GUN = ITEMS.register("nebulasteam_gun",
			() -> new NebulasteamGunItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM)
			.ChangeRepairItem(FULL_BOTTLE.get()));

    public static final DeferredItem<Item> NEBULASTEAM_GUN_RIFLE_MODE = ITEMS.register("nebulasteam_gun_rifle",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));

	public static final DeferredItem<Item> NANBA_WALKING_STICK = ITEMS.register("nanba_walking_stick",
			() -> new BaseSwordItem(Tiers.DIAMOND, 1, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BUILD_TAB_ITEM).ChangeRepairItem(FULL_BOTTLE.get()));

	public static final DeferredItem<Item> PANDORA_PANEL_TOUTO = ITEMS.register("pandora_panel_touto", () -> new PandoraPanelItem().AddToList(RiderTabs.BUILD_TAB_ITEM));
	public static final DeferredItem<Item> PANDORA_PANEL_HOKUTO = ITEMS.register("pandora_panel_hokuto", () -> new PandoraPanelItem().AddToList(RiderTabs.BUILD_TAB_ITEM));
	public static final DeferredItem<Item> PANDORA_PANEL_SEITO = ITEMS.register("pandora_panel_seito", () -> new PandoraPanelItem().AddToList(RiderTabs.BUILD_TAB_ITEM));
	public static final DeferredItem<Item> LAST_PANDORA_PANEL_BLACK = ITEMS.register("last_pandora_panel_black", () -> new PandoraPanelItem().AddToList(RiderTabs.BUILD_TAB_ITEM));
	public static final DeferredItem<Item> LAST_PANDORA_PANEL_WHITE = ITEMS.register("last_pandora_panel_white", () -> new PandoraPanelItem().AddToList(RiderTabs.BUILD_TAB_ITEM));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}