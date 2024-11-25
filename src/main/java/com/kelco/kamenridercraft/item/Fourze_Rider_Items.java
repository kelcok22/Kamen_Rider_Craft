package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.Fourze.FourzeDriverItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Fourze_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);



	public static final DeferredItem<Item> FOURZE_LOGO = ITEMS.register("fourze_logo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> BLANK_ASTROSWITCH = ITEMS.register("astroswitch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.FOURZE_TAB_ITEM));


	public static final DeferredItem<Item> FOURZE_BASE_STATES = ITEMS.register("fourze_basestates",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.ChangeSlot(5));

	public static final DeferredItem<Item> FOURZE_ELEK_STATES = ITEMS.register("fourze_elekstates",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_elek","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.ChangeSlot(5));

	public static final DeferredItem<Item> FOURZE_FIRE_STATES = ITEMS.register("fourze_firestates",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_fire","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.ChangeSlot(5));

	public static final DeferredItem<Item> FOURZE_COSMIC_STATES = ITEMS.register("fourze_cosmicstates",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cosmic","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.ChangeSlot(5));

	public static final DeferredItem<Item> FOURZE_ROCKET_STATES = ITEMS.register("fourze_rocketstates",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_rocket","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.ChangeSlot(5));

	public static final DeferredItem<Item> BLANK_CIRCLE_ASTROSWITCH = ITEMS.register("circle_astroswitch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)));

	public static final DeferredItem<Item> BLANK_CROSS_ASTROSWITCH = ITEMS.register("cross_astroswitch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","fourze","fourze_driver_belt")
					.ChangeSlot(2));

	public static final DeferredItem<Item> BLANK_TRIANGLE_ASTROSWITCH = ITEMS.register("triangle_astroswitch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","fourze","fourze_driver_belt")
					.ChangeSlot(3));

	public static final DeferredItem<Item> BLANK_SPUARE_ASTROSWITCH = ITEMS.register("square_astroswitch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","fourze","fourze_driver_belt")
					.ChangeSlot(4));

	public static final DeferredItem<Item> ROCKET_ASTROSWITCH = ITEMS.register("rocket_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_rocket_module","fourze","fourze_driver_belt"
					,new MobEffectInstance(Effect_core.BOOST, 40, 0,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).alsoChange5thSlot(FOURZE_ELEK_STATES.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> LAUNCHER_ASTROSWITCH = ITEMS.register("launcher_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_launcher_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.CANNON, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> DRILL_ASTROSWITCH = ITEMS.register("drill_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_drill_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> RADAR_ASTROSWITCH = ITEMS.register("radar_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_radar_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.RADAR, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SPUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> MAGIC_HAND_ASTROSWITCH = ITEMS.register("magic_hand_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_magichand_module","fourze","fourze_driver_belt"
					,new MobEffectInstance(Effect_core.LONG_ARM, 40, 2,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> CAMERA_ASTROSWITCH = ITEMS.register("camera_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_camera_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SPUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> PARACHUTE_ASTROSWITCH = ITEMS.register("parachute_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_parachute_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.LOW_GRAVITY, 40, 6,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SPUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> CHAINSAW_ASTROSWITCH = ITEMS.register("chainsaw_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_chainsaw_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> HOPPING_ASTROSWITCH = ITEMS.register("hopping_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hopping_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> ELEK_ASTROSWITCH = ITEMS.register("elek_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_elek_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
					,new MobEffectInstance(Effect_core.BOOST, 40, 0,true,false))
					.alsoChange5thSlot(FOURZE_ELEK_STATES.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> SCISSORS_ASTROSWITCH = ITEMS.register("scissors_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_scissors_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SPUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> BEAT_ASTROSWITCH = ITEMS.register("beat_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_beat_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> CHAIN_ARRAY_ASTROSWITCH = ITEMS.register("chain_array_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_chain_array_module","fourze","fourze_driver_belt"
					,new MobEffectInstance(Effect_core.LONG_ARM, 40, 2,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> SMOKE_ASTROSWITCH = ITEMS.register("smoke_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_smoke_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> SPIKE_ASTROSWITCH = ITEMS.register("spike_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_spike_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.REFLECT, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> WINCH_ASTROSWITCH = ITEMS.register("winch_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_winch_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SPUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> FLASH_ASTROSWITCH = ITEMS.register("flash_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_flash_module","fourze","fourze_driver_belt"
					,new MobEffectInstance(Effect_core.LONG_ARM, 40, 2,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> SHIELD_ASTROSWITCH = ITEMS.register("shield_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_shield_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SPUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> GATLING_ASTROSWITCH = ITEMS.register("gatling_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_gatling_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.REFLECT, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> FIRE_ASTROSWITCH = ITEMS.register("fire_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_fire_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
					,new MobEffectInstance(Effect_core.BOOST, 40, 0,true,false))
					.alsoChange5thSlot(FOURZE_FIRE_STATES.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> STEALTH_ASTROSWITCH = ITEMS.register("stealth_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_stealth_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> HAMMER_ASTROSWITCH = ITEMS.register("hammer_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hammer_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SPUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> WATER_ASTROSWITCH = ITEMS.register("water_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_water_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> MEDICAL_ASTROSWITCH = ITEMS.register("medical_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_medical_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SPUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> PEN_ASTROSWITCH = ITEMS.register("pen_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_pen_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> WHEEL_ASTROSWITCH = ITEMS.register("wheel_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_wheel_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> SCREW_ASTROSWITCH = ITEMS.register("screw_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_screw_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> HAND_ASTROSWITCH = ITEMS.register("hand_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hand_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> SCHOOP_ASTROSWITCH = ITEMS.register("scoop_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_scoop_module","fourze","fourze_driver_belt"
					,new MobEffectInstance(Effect_core.LONG_ARM, 40, 2,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	/**
	magnet_swich_n
	magnet_swich_s
	 **/
	public static final DeferredItem<Item> FREEZE_ASTROSWITCH = ITEMS.register("freeze_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_freeze_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.BLIZZARD, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> CLAW_ASTROSWITCH = ITEMS.register("claw_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_claw_module","fourze","fourze_driver_belt"
					,new MobEffectInstance(Effect_core.LONG_ARM, 40, 2,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> BOARD_ASTROSWITCH = ITEMS.register("board_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_board_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> GIANTFOOT_ASTROSWITCH = ITEMS.register("giantfoot_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_giantfoot_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.BLIZZARD, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> AERO_ASTROSWITCH = ITEMS.register("aero_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_aero_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> GYRO_ASTROSWITCH = ITEMS.register("gyro_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_gyro_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SPUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> NET_ASTROSWITCH = ITEMS.register("net_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_net_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.BLIZZARD, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> STAMPER_ASTROSWITCH = ITEMS.register("stamper_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_stamper_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> COSMIC_ASTROSWITCH = ITEMS.register("cosmic_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cosmic_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
					,new MobEffectInstance(Effect_core.BOOST, 40, 0,true,false))
					.alsoChange5thSlot(FOURZE_COSMIC_STATES.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> SUPER_ROCKET_ASTROSWITCH = ITEMS.register("super_rocket_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_super_rocket_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.BLIZZARD, 40, 0,true,false))
					.ChangeSlot(2).alsoChange5thSlot(FOURZE_ROCKET_STATES.get()).alsoChange1stSlot(ROCKET_ASTROSWITCH.get()).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> SUPER_DRILL_ASTROSWITCH = ITEMS.register("super_drill_switch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	/**
	super_launcher_swich

	clear_drill_swich
	fusion_swich
	 **/

	public static final DeferredItem<Item> METEOR_ASTROSWITCH = ITEMS.register("meteor_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","meteor","meteor_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false))
					.AddToList(RiderTabs.FOURZE_TAB_ITEM));


	public static final DeferredItem<Item> METEOR_STORM_ASTROSWITCH = ITEMS.register("meteor_storm_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_storm","meteor","meteor_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)
					,new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false))
					.AddToList(RiderTabs.FOURZE_TAB_ITEM));


	public static final DeferredItem<Item> NADESHIKO_ASTROSWITCH = ITEMS.register("nadeshiko_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","nadeshiko","nadeshiko_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> IKAROS_ASTROSWITCH = ITEMS.register("ikaros_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","ikaros","ikaros_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> SOLU_ASTROSWITCH = ITEMS.register("solu_switch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> CORE_ASTROSWITCH = ITEMS.register("core_switch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> ROCKET_ASTROSWITCH_CHRISTMAS_VER = ITEMS.register("rocket_swich_christmas_ver",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.FOURZE_TAB_ITEM));


	//gate_switch

	public static final DeferredItem<Item> RIDER_1_ASTROSWITCH = ITEMS.register("rider1_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_rider1_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> RIDER_2_ASTROSWITCH = ITEMS.register("rider2_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_rider2_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SPUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));


	/**
	v3_switch
	riderman_switch
	x_switch
	amazon_switch
	stronger_switch
	skyrider_switch
	super_1_switch
	zx_switch
	black_switch
	rx_switch
	kuuga_switch
	agito_switch
	ryuki_switch
	faiz_switch
	blade_switch
	hibiki_switch
	kabuto_switch
	den_o_switch
	kiva_switch
	decade_switch
	double_switch
		ooo_switch
**/

	public static final DeferredItem<Item> FOURZE_HELMET = ITEMS.register("fourze_head",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.FOURZE_TAB_ITEM)
					.ChangeRepairItem(BLANK_ASTROSWITCH.get()));
	public static final DeferredItem<Item> FOURZE_CHESTPLATE = ITEMS.register("fourze_troso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.FOURZE_TAB_ITEM)
					.ChangeRepairItem(BLANK_ASTROSWITCH.get()));
	public static final DeferredItem<Item> FOURZE_LEGGINGS = ITEMS.register("fourze_legs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.FOURZE_TAB_ITEM)
					.ChangeRepairItem(BLANK_ASTROSWITCH.get()));

	public static final DeferredItem<Item> FOURZE_DRIVER = ITEMS.register("fourze_driver",
			() -> new FourzeDriverItem(ArmorMaterials.DIAMOND,"fourze",BLANK_CIRCLE_ASTROSWITCH ,FOURZE_HELMET,FOURZE_CHESTPLATE,FOURZE_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BLANK_CROSS_ASTROSWITCH,BLANK_TRIANGLE_ASTROSWITCH,BLANK_SPUARE_ASTROSWITCH).AddToTabList(RiderTabs.FOURZE_TAB_ITEM).ChangeRepairItem(BLANK_ASTROSWITCH.get()));

	public static final DeferredItem<Item> METEOR_DRIVER = ITEMS.register("meteor_driver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"meteor",METEOR_ASTROSWITCH ,FOURZE_HELMET,FOURZE_CHESTPLATE,FOURZE_LEGGINGS  ,
					new Item.Properties()).AddToTabList(RiderTabs.FOURZE_TAB_ITEM).ChangeRepairItem(BLANK_ASTROSWITCH.get()));

	public static final DeferredItem<Item> NADESHIKO_DRIVER = ITEMS.register("nadeshiko_driver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"nadeshiko",NADESHIKO_ASTROSWITCH ,FOURZE_HELMET,FOURZE_CHESTPLATE,FOURZE_LEGGINGS  ,
					new Item.Properties()).AddToTabList(RiderTabs.FOURZE_TAB_ITEM).ChangeRepairItem(BLANK_ASTROSWITCH.get()));

	public static final DeferredItem<Item> IKAROS_DRIVER = ITEMS.register("ikaros_driver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ikaros",IKAROS_ASTROSWITCH ,FOURZE_HELMET,FOURZE_CHESTPLATE,FOURZE_LEGGINGS  ,
					new Item.Properties()).AddToTabList(RiderTabs.FOURZE_TAB_ITEM).ChangeRepairItem(BLANK_ASTROSWITCH.get()));


	/**
		ginga_oh_driver
**/

	/**
	billytherod
	hee_hackgun
	barizun_sword
	shield_module
		meteor_storm_shaft
	**/

	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
