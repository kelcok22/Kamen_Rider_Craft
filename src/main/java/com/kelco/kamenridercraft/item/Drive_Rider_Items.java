package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.drive.DriveDriverItem;
import com.kelco.kamenridercraft.item.misc.GiftItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class Drive_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> DRIVE_LOGO = ITEMS.register("drive_logo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> BASIC_TIRE = ITEMS.register("basic_tire",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"no_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ChangeSlot(2));

	public static final DeferredItem<Item> SHIFT_SPEED = ITEMS.register("speedshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.alsoChange2ndSlot(BASIC_TIRE.get()).AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> SHIFT_WILD = ITEMS.register("wildshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_wild","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.alsoChange2ndSlot(BASIC_TIRE.get()).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_TECHNIC = ITEMS.register("techniqueshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_technic","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.alsoChange2ndSlot(BASIC_TIRE.get()).AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> SHIFT_DEAD_HEAT_MACH = ITEMS.register("deadheatshift_mach",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_dead_heat","mach","mach_driver_honoh_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.alsoChange2ndSlot(BASIC_TIRE.get()));


	public static final DeferredItem<Item> SHIFT_DEAD_HEAT = ITEMS.register("deadheatshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_dead_heat","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.addAlternative(SHIFT_DEAD_HEAT_MACH.get()).alsoChange2ndSlot(BASIC_TIRE.get()).AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> SHIFT_FORMULA= ITEMS.register("formulashift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_formula","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.ChangeModel("drive_formula.geo.json").alsoChange2ndSlot(BASIC_TIRE.get()).AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static List<Item> NEED_ITEM_TRIDORON_ALL_TIRE= new ArrayList<Item>();

	public static final DeferredItem<Item> TRIDORON_ALL_TIRE = ITEMS.register("tridoron_all_tire",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"tridoron_all_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.addAlternative(BASIC_TIRE.get()).AddIncompatibleForm(SHIFT_FORMULA.asItem()).ChangeSlot(2));

	public static final DeferredItem<Item> SHIFT_TRIDORON_NOT_ALL = ITEMS.register("tridoronshift_not_all",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_tridoron","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.alsoChange2ndSlot(BASIC_TIRE.get()));

	public static final DeferredItem<Item> SHIFT_TRIDORON = ITEMS.register("tridoronshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_tridoron","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.addAlternative(SHIFT_TRIDORON_NOT_ALL.get()).AddNeedItemList(NEED_ITEM_TRIDORON_ALL_TIRE).alsoChange2ndSlot(TRIDORON_ALL_TIRE.get()).AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> SHIFT_HIGH_SPEED = ITEMS.register("high_speedshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_high_speed","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.ChangeModel("drive.geo.json").alsoChange2ndSlot(BASIC_TIRE.get()).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_SPECIAL = ITEMS.register("specialshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_special","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.ChangeModel("drive.geo.json").alsoChange2ndSlot(BASIC_TIRE.get()).AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> SHIFT_FRUITS = ITEMS.register("fruitsshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_fruits","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.ChangeModel("drive.geo.json").alsoChange2ndSlot(BASIC_TIRE.get()).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_SPEED_WILD_TECHNIC = ITEMS.register("speedwildtechnicshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_speed_wild_technic","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.ChangeModel("drive.geo.json").alsoChange2ndSlot(BASIC_TIRE.get()).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static List<Item> NEED_ITEM_ATTACK_123= new ArrayList<Item>();

	public static final DeferredItem<Item> ATTACK_123 = ITEMS.register("attack123_tire",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"attack123_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddNeedItemList(NEED_ITEM_ATTACK_123).ChangeSlot(2));

	public static List<Item> NEED_ITEM_PEOPLE_SAVER= new ArrayList<Item>();

	public static final DeferredItem<Item> PEOPLE_SAVER = ITEMS.register("people_saver_tire",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"people_saver_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddNeedItemList(NEED_ITEM_PEOPLE_SAVER).ChangeSlot(2));

	public static List<Item> NEED_ITEM_KOUJI_GENBAR= new ArrayList<Item>();

	public static final DeferredItem<Item> KOUJI_GENBAR = ITEMS.register("kouji_genbar_tire",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kouji_genbar_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddNeedItemList(NEED_ITEM_KOUJI_GENBAR).ChangeSlot(2));


	public static final DeferredItem<Item> SHIFT_MAX_FLARE = ITEMS.register("maxflare",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"max_flare_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem())
					.addAlternative(ATTACK_123.get()).ChangeSlot(2).AddToList(NEED_ITEM_ATTACK_123).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_FUNKY_SPIKE = ITEMS.register("funkyspike",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"funky_spike_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem())
					.addAlternative(ATTACK_123.get()).ChangeSlot(2).AddToList(NEED_ITEM_ATTACK_123).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_MIDNIGHT_SHADOW = ITEMS.register("midnightshadow",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"midnight_shadow_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem())
					.addAlternative(ATTACK_123.get()).ChangeSlot(2).AddToList(NEED_ITEM_ATTACK_123).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_JUSTICE_HUNTER = ITEMS.register("justice_hunter",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"justice_hunter_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem())
					.addAlternative(PEOPLE_SAVER.get()).ChangeSlot(2).AddToList(NEED_ITEM_PEOPLE_SAVER).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_DREAM_VAGAS = ITEMS.register("dream_vegas",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"dream_vegas_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).ChangeSlot(2).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_DIMENSION_CAB = ITEMS.register("dimension_cab",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"dimension_cab_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).ChangeSlot(2).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_MASSIVE_MONSTER = ITEMS.register("massive_monster",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"massive_monster_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).ChangeSlot(2).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_SPIN_MIXER = ITEMS.register("spin_mixer",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"spin_mixer_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem())
					.addAlternative(KOUJI_GENBAR.get()).ChangeSlot(2).AddToList(NEED_ITEM_KOUJI_GENBAR).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_RUMBLE_DUMP = ITEMS.register("rumble_dump",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"rumble_dump_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem())
					.addAlternative(KOUJI_GENBAR.get()).ChangeSlot(2).AddToList(NEED_ITEM_KOUJI_GENBAR).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_MAD_DOCTOR = ITEMS.register("mad_doctor",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"mad_doctor_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem())
					.addAlternative(PEOPLE_SAVER.get()).ChangeSlot(2).AddToList(NEED_ITEM_PEOPLE_SAVER).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_HOOKING_WRECKER = ITEMS.register("hooking_wrecker",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"hooking_wrecker_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).ChangeSlot(2).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_BURNING_SOLAR = ITEMS.register("burning_solar",
			() -> new BaseItem(new Item.Properties()).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_COLOR_COMMERCIAL = ITEMS.register("colorful_commercial",
			() -> new BaseItem(new Item.Properties()).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> SHIFT_FIRE_BRAVER = ITEMS.register("fire_braver",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"fire_braver_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem())
					.addAlternative(PEOPLE_SAVER.get()).ChangeSlot(2).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).AddToList(NEED_ITEM_PEOPLE_SAVER).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_ROLLING_GRAVITY = ITEMS.register("rolling_gravity",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"rolling_gravity_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem())
					.addAlternative(KOUJI_GENBAR.get()).ChangeSlot(2).AddToList(NEED_ITEM_KOUJI_GENBAR).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_DECO_TRAVELLER = ITEMS.register("deco_traveller",
			() -> new BaseItem(new Item.Properties()).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> SHIFT_ROAD_WINTER = ITEMS.register("road_winter",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"road_winter_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).ChangeSlot(2).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_AMAZING_CIRCUS= ITEMS.register("amazing_circus",
			() -> new BaseItem(new Item.Properties()).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_MANTARN_F01 = ITEMS.register("mantarn_f01",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"f01_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.addNeedForm(SHIFT_FORMULA.get(),1).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).ChangeSlot(2).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_JACKY_F02 = ITEMS.register("jacky_f02",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"f02_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.addNeedForm(SHIFT_FORMULA.get(),1).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).ChangeSlot(2).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_SPARNER_F03 = ITEMS.register("sparner_f03",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"f03_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.addNeedForm(SHIFT_FORMULA.get(),1).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).ChangeSlot(2).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> SHIFT_MEGA_MAX_FLARE = ITEMS.register("mega_maxflare",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"mega_maxflare_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).ChangeSlot(2).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_HOLY_CHRISTMAS = ITEMS.register("holy_christmas",
			() -> new BaseItem(new Item.Properties()).AddToList(GiftItem.GIFTS).AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> SIGNAL_MACH = ITEMS.register("signal_mach",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","mach","mach_driver_honoh_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.alsoChange2ndSlot(BASIC_TIRE.get()).AddToList(RiderTabs.DRIVE_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> SIGNAL_MAGARL = ITEMS.register("signal_magarl",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kourin_magarl_tire","mach","mach_driver_honoh_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).ChangeSlot(2).AddToList(RiderTabs.DRIVE_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> SIGNAL_KAKSARN = ITEMS.register("signal_kaksarn",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kourin_kaksarn_tire","mach","mach_driver_honoh_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).ChangeSlot(2).AddToList(RiderTabs.DRIVE_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> SIGNAL_TOMARLE = ITEMS.register("signal_tomarle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kourin_tomarle_tire","mach","mach_driver_honoh_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).ChangeSlot(2).AddToList(RiderTabs.DRIVE_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> SIGNAL_KIKERN= ITEMS.register("signal_kikern",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kourin_kikern_tire","mach","mach_driver_honoh_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).ChangeSlot(2).AddToList(RiderTabs.DRIVE_TAB_ITEM).has_basic_model());


	public static final DeferredItem<Item> DRIVE_HELMET = ITEMS.register("drive_head",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));
	public static final DeferredItem<Item> DRIVE_CHESTPLATE = ITEMS.register("drive_troso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));
	public static final DeferredItem<Item> DRIVE_LEGGINGS = ITEMS.register("drive_legs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> DRIVE_DRIVER = ITEMS.register("drivedriver",
			() -> new DriveDriverItem(ArmorMaterials.DIAMOND,"drive",SHIFT_SPEED , DRIVE_HELMET,DRIVE_CHESTPLATE,DRIVE_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_TIRE).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> MACH_DRIVER_HONOH = ITEMS.register("mach_driver_honoh",
			() -> new DriveDriverItem(ArmorMaterials.DIAMOND,"mach",SIGNAL_MACH , DRIVE_HELMET,DRIVE_CHESTPLATE,DRIVE_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_TIRE).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));


	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
