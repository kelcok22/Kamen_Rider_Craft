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
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

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
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> LAUNCHER_ASTROSWITCH = ITEMS.register("launcher_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_launcher_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ChangeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> DRILL_ASTROSWITCH = ITEMS.register("drill_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_drill_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.ChangeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> RADAR_ASTROSWITCH = ITEMS.register("radar_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_radar_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SPUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> MAGIC_HAND_ASTROSWITCH = ITEMS.register("magic_hand_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_magichand_module","fourze","fourze_driver_belt"
					,new MobEffectInstance(Effect_core.BOOST, 40, 0,true,false))
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> CAMERA_ASTROSWITCH = ITEMS.register("camera_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_camera_module","fourze","fourze_driver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 40, 0,true,false))
					.ChangeSlot(4).addSwitchForm(BLANK_SPUARE_ASTROSWITCH.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));

	public static final DeferredItem<Item> PARACHUTE_ASTROSWITCH = ITEMS.register("parachute_switch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_parachute_module","fourze","fourze_driver_belt",
					new MobEffectInstance(Effect_core.LOW_GRAVITY, 40, 3,true,false))
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
					.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).alsoChange5thSlot(FOURZE_ELEK_STATES.get()).AddToList(RiderTabs.FOURZE_TAB_ITEM));



	/**
	scissors_switch
	beat_switch
	chain_array_switch
	smoke_switch
	spike_switch
	winch_switch
	flash_switch
	shield_switch
	gatling_switch

	fire_swich
	stealth_switch
	hammer_switch
	water_switch
	medical_switch
	pen_switch
	wheel_switch
	screw_switch
	hand_switch
	schop_switch

	magnet_swich_n
	magnet_swich_s
	freeze_switch
	claw_switch
	board_switch
	giantfoot_switch
	aero_switch
	gyro_switch
	net_switch
	stamper_switch

	cosmic_swich

	super_rocket_swich
	super_launcher_swich
	super_drill_swich

	clear_drill_swich
	fusion_swich
	meteor_swich
	meteor_storm_swich

	nadeshiko_switch

	solu_switch
	core_switch
	gate_switch
	rocket_swich_christmas_ver

	rider1_switch
	rider2_switch
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

	/**
Fourzedriver
	meteor_driver
	nadeshikodriver
	ikarosdriver
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
