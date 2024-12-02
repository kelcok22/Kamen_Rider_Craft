package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machineBlocks.AstroswitchProgrammer;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.Fourze.FourzeDriverItem;
import com.kelco.kamenridercraft.item.Fourze.GateSwitchItem;
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

	public static final DeferredItem<Item> FOURZE_MAGNET_STATES = ITEMS.register("fourze_magnetstates",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_magnet","fourze","fourze_driver_belt",
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

	public static final DeferredItem<Item> BLANK_SQUARE_ASTROSWITCH = ITEMS.register("square_astroswitch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","fourze","fourze_driver_belt")
					.ChangeSlot(4));

	public static final DeferredItem<Item> ROCKET_ASTROSWITCH = ITEMS.register("rocket_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_rocket_module","fourze","fourze_driver_belt"
					,new MobEffectInstance(Effect_core.BOOST, 40, 0,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).alsoChange5thSlot(FOURZE_ELEK_STATES.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 20));

	public static final DeferredItem<Item> LAUNCHER_ASTROSWITCH = ITEMS.register("launcher_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_launcher_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.CANNON, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 20));

	public static final DeferredItem<Item> DRILL_ASTROSWITCH = ITEMS.register("drill_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_drill_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 20));

	public static final DeferredItem<Item> RADAR_ASTROSWITCH = ITEMS.register("radar_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_radar_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.RADAR, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 20));

	public static final DeferredItem<Item> MAGIC_HAND_ASTROSWITCH = ITEMS.register("magic_hand_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_magichand_module","fourze","fourze_driver_belt"
					,new MobEffectInstance(Effect_core.LONG_ARM, 40, 2,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 15));

	public static final DeferredItem<Item> CAMERA_ASTROSWITCH = ITEMS.register("camera_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_camera_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 15));

	public static final DeferredItem<Item> PARACHUTE_ASTROSWITCH = ITEMS.register("parachute_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_parachute_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.LOW_GRAVITY, 40, 6,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 15));

	public static final DeferredItem<Item> CHAINSAW_ASTROSWITCH = ITEMS.register("chainsaw_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_chainsaw_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 15));

	public static final DeferredItem<Item> HOPPING_ASTROSWITCH = ITEMS.register("hopping_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hopping_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 15));

	public static final DeferredItem<Item> ELEK_ASTROSWITCH = ITEMS.register("elek_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_elek_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
					,new MobEffectInstance(Effect_core.BOOST, 40, 0,true,false))
					.alsoChange5thSlot(FOURZE_ELEK_STATES.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 15));

	public static final DeferredItem<Item> SCISSORS_ASTROSWITCH = ITEMS.register("scissors_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_scissors_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 10));

	public static final DeferredItem<Item> BEAT_ASTROSWITCH = ITEMS.register("beat_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_beat_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.NOTE, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 10));

	public static final DeferredItem<Item> CHAIN_ARRAY_ASTROSWITCH = ITEMS.register("chain_array_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_chain_array_module","fourze","fourze_driver_belt"
					,new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 10));

	public static final DeferredItem<Item> SMOKE_ASTROSWITCH = ITEMS.register("smoke_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_smoke_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SMOKE, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 10));

	public static final DeferredItem<Item> SPIKE_ASTROSWITCH = ITEMS.register("spike_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_spike_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.REFLECT, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 10));

	public static final DeferredItem<Item> WINCH_ASTROSWITCH = ITEMS.register("winch_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_winch_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 10));

	public static final DeferredItem<Item> FLASH_ASTROSWITCH = ITEMS.register("flash_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_flash_module","fourze","fourze_driver_belt"
					,new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 10));

	public static final DeferredItem<Item> SHIELD_ASTROSWITCH = ITEMS.register("shield_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_shield_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 10));

	public static final DeferredItem<Item> GATLING_ASTROSWITCH = ITEMS.register("gatling_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_gatling_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.REFLECT, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 10));

	public static final DeferredItem<Item> FIRE_ASTROSWITCH = ITEMS.register("fire_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_fire_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
					,new MobEffectInstance(Effect_core.BOOST, 40, 0,true,false))
					.alsoChange5thSlot(FOURZE_FIRE_STATES.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 10));

	public static final DeferredItem<Item> STEALTH_ASTROSWITCH = ITEMS.register("stealth_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_stealth_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.STEALTH, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 5));

	public static final DeferredItem<Item> HAMMER_ASTROSWITCH = ITEMS.register("hammer_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hammer_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 5));

	public static final DeferredItem<Item> WATER_ASTROSWITCH = ITEMS.register("water_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_water_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 5));

	public static final DeferredItem<Item> MEDICAL_ASTROSWITCH = ITEMS.register("medical_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_medical_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 5));

	public static final DeferredItem<Item> PEN_ASTROSWITCH = ITEMS.register("pen_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_pen_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 5));

	public static final DeferredItem<Item> WHEEL_ASTROSWITCH = ITEMS.register("wheel_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_wheel_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 5));

	public static final DeferredItem<Item> SCREW_ASTROSWITCH = ITEMS.register("screw_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_screw_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 5));

	public static final DeferredItem<Item> HAND_ASTROSWITCH = ITEMS.register("hand_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hand_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 5));

	public static final DeferredItem<Item> SCHOOP_ASTROSWITCH = ITEMS.register("scoop_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_scoop_module","fourze","fourze_driver_belt"
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 5));

	public static final DeferredItem<Item> MAGNET_ASTROSWITCH_N = ITEMS.register("magnet_swich_n",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_magnet_n_module","fourze","fourze_driver_belt"
					,new MobEffectInstance(Effect_core.PULL, 40, 2,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 5));

	public static final DeferredItem<Item> MAGNET_ASTROSWITCH_S = ITEMS.register("magnet_swich_s",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_magnet_s_module","fourze","fourze_driver_belt"
					,new MobEffectInstance(Effect_core.PUSH, 40, 2,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 5));


	public static final DeferredItem<Item> FREEZE_ASTROSWITCH = ITEMS.register("freeze_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_freeze_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.BLIZZARD, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 2));

	public static final DeferredItem<Item> CLAW_ASTROSWITCH = ITEMS.register("claw_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_claw_module","fourze","fourze_driver_belt"
					,new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 2));

	public static final DeferredItem<Item> BOARD_ASTROSWITCH = ITEMS.register("board_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_board_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 2));

	public static final DeferredItem<Item> GIANTFOOT_ASTROSWITCH = ITEMS.register("giantfoot_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_giantfoot_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.GRAVITY, 40, 4,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 2));

	public static final DeferredItem<Item> AERO_ASTROSWITCH = ITEMS.register("aero_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_aero_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 2));

	public static final DeferredItem<Item> GYRO_ASTROSWITCH = ITEMS.register("gyro_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_gyro_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 2));

	public static final DeferredItem<Item> NET_ASTROSWITCH = ITEMS.register("net_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_net_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.BLIZZARD, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 2));

	public static final DeferredItem<Item> STAMPER_ASTROSWITCH = ITEMS.register("stamper_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_stamper_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 2));

	public static final DeferredItem<Item> COSMIC_ASTROSWITCH = ITEMS.register("cosmic_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cosmic_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
					,new MobEffectInstance(Effect_core.BOOST, 40, 0,true,false))
					.alsoChange5thSlot(FOURZE_COSMIC_STATES.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM).AddToList(AstroswitchProgrammer.ASTROSWITCH, 1));

	public static final DeferredItem<Item> SUPER_ROCKET_ASTROSWITCH = ITEMS.register("super_rocket_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_super_rocket_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.BLIZZARD, 40, 0,true,false))
					.ChangeSlot(4).alsoChange5thSlot(FOURZE_ROCKET_STATES.get()).alsoChange1stSlot(ROCKET_ASTROSWITCH.get()).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

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

	public static final DeferredItem<Item> GATE_SWITCH = ITEMS.register("gate_switch",
			() -> new GateSwitchItem(new Item.Properties(),10).AddToList(RiderTabs.FOURZE_TAB_ITEM));


	public static final DeferredItem<Item> RIDER_1_ASTROSWITCH = ITEMS.register("rider1_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_rider1_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> RIDER_2_ASTROSWITCH = ITEMS.register("rider2_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_rider2_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> V3_ASTROSWITCH = ITEMS.register("v3_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_v3_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.REFLECT, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> RIDERMAN_ASTROSWITCH = ITEMS.register("riderman_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_riderman_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> X_ASTROSWITCH = ITEMS.register("x_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_x_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> AMAZON_ASTROSWITCH = ITEMS.register("amazon_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_amazon_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> STRONGER_ASTROSWITCH = ITEMS.register("stronger_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_stronger_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> SKYRIDER_ASTROSWITCH = ITEMS.register("skyrider_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_skyrider_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> SUPER_1_ASTROSWITCH = ITEMS.register("super_1_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_super_1_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> ZX_ASTROSWITCH = ITEMS.register("zx_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_zx_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_ASTROSWITCH = ITEMS.register("black_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_black_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.REFLECT, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_RX_ASTROSWITCH = ITEMS.register("rx_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_rx_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.REFLECT, 40, 0,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_ASTROSWITCH = ITEMS.register("kuuga_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kuuga_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_ASTROSWITCH = ITEMS.register("agito_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_agito_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.REFLECT, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> RYUKI_ASTROSWITCH = ITEMS.register("ryuki_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ryuki_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> FAIZ_ASTROSWITCH = ITEMS.register("faiz_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_faiz_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> BLADE_ASTROSWITCH = ITEMS.register("blade_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_blade_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> HIBIKI_ASTROSWITCH = ITEMS.register("hibiki_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"hibiki_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> KABUTO_ASTROSWITCH = ITEMS.register("kabuto_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kabuto_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.REFLECT, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_ASTROSWITCH = ITEMS.register("den_o_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_den_o_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> KIVA_ASTROSWITCH = ITEMS.register("kiva_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kiva_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.REFLECT, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_ASTROSWITCH = ITEMS.register("decade_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_decade_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.REFLECT, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> DOUBLE_ASTROSWITCH = ITEMS.register("double_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_double_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> OOO_ASTROSWITCH = ITEMS.register("ooo_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ooo_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> ZODIARTS_SWITCH = ITEMS.register("zodiarts_switch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.FOURZE_TAB_ITEM));


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
					.Add_Extra_Base_Form_Items(BLANK_CROSS_ASTROSWITCH,BLANK_TRIANGLE_ASTROSWITCH,BLANK_SQUARE_ASTROSWITCH).AddToTabList(RiderTabs.FOURZE_TAB_ITEM).ChangeRepairItem(BLANK_ASTROSWITCH.get()));

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
