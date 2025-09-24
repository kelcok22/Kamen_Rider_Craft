package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machineBlocks.ShiftChassisAssembler;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.bosses.GordDriveEntity;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.drive.DriveDriverItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class Drive_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> DRIVE_LOGO = ITEMS.register("drive_logo",
			() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/drive")), new Item.Properties()).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_ALLOY = ITEMS.register("shift_alloy",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> DRIVE_SYSTEM_CAR = ITEMS.register("drive_system_car",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> NEXT_SYSTEM_BIKE = ITEMS.register("next_system_bike",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> NEXT_SYSTEM_CAR = ITEMS.register("next_system_car",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> BASIC_TIRE = ITEMS.register("basic_tire",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"no_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.ChangeSlot(2).model_has_different_name("speedshift").has_basic_model());

	public static final DeferredItem<Item> SHIFT_PROTO_SPEED_CHASER = ITEMS.register("proto_speedshift_chaser",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","chaser","mach_driver_honoh_belt_chaser",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 8,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.ChangeModel("chaser.geo.json").ChangeAnimation("chaser_hayai.animation.json").alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing()
					.model_has_different_name("proto_speedshift").has_basic_model());

	public static final DeferredItem<Item> SHIFT_PROTO_SPEED = ITEMS.register("proto_speedshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_zero","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.ChangeModel("drive.geo.json")
					.alsoChange2ndSlot(BASIC_TIRE.get()).addAlternative(SHIFT_PROTO_SPEED_CHASER.get()).IsGlowing().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_SPEED = ITEMS.register("speedshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
                    .IsGlowing().alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing().AddToList(ShiftChassisAssembler.DRIVE_CAR,15).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_WILD = ITEMS.register("wildshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_wild","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
					.alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing().AddToList(ShiftChassisAssembler.DRIVE_CAR,6).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_TECHNIC = ITEMS.register("technicshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_technic","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing().AddToList(ShiftChassisAssembler.DRIVE_CAR,5).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_DEAD_HEAT_CAR = ITEMS.register("deadheat_car",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(ShiftChassisAssembler.DRIVE_CAR,3).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_DEAD_HEAT_BIKE = ITEMS.register("deadheat_bike",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(ShiftChassisAssembler.NEXT_BIKE,2).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_DEAD_HEAT_DRIVE_MACH = ITEMS.register("deadheatshift_drive_mach",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","drive_dead_heat","mach_driver_honoh_belt",
					new MobEffectInstance(MobEffects.CONFUSION, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing().model_has_different_name("dead_heat").has_basic_model());


	public static final DeferredItem<Item> SHIFT_DEAD_HEAT_MACH = ITEMS.register("deadheatshift_mach",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_dead_heat","mach","mach_driver_honoh_belt",
					new MobEffectInstance(MobEffects.CONFUSION, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.addAlternative(SHIFT_DEAD_HEAT_DRIVE_MACH.get()).alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing()
					.model_has_different_name("dead_heat").has_basic_model());


	public static final DeferredItem<Item> SHIFT_DEAD_HEAT = ITEMS.register("deadheatshift",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_dead_heat","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.CONFUSION, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.addAlternative(SHIFT_DEAD_HEAT_MACH.get()).IsGlowing().alsoChange2ndSlot(BASIC_TIRE.get()).AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> SHIFT_FORMULA= ITEMS.register("formulashift",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_formula","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)).alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_TRIDORON_CORE = ITEMS.register("tridoronshift_core",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(ShiftChassisAssembler.DRIVE_CAR,5).has_basic_model()
					.AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static List<Item> NEED_ITEM_TRIDORON_ALL_TIRE= new ArrayList<Item>();

	public static final DeferredItem<Item> TRIDORON_ALL_TIRE = ITEMS.register("tridoron_all_tire",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"tridoron_all_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 8,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.REGENERATION, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.SATURATION, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
					,new MobEffectInstance(Effect_core.CANNON, 40, 0,true,false))
					.addAlternative(BASIC_TIRE.get()).AddIncompatibleForm(SHIFT_FORMULA.asItem()).ChangeSlot(2)
					.model_has_different_name("tridoronshift").has_basic_model());

	public static final DeferredItem<Item> SHIFT_TRIDORON_NOT_ALL = ITEMS.register("tridoronshift_not_all",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_tridoron","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false))
					.alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing().model_has_different_name("tridoronshift").has_basic_model().AddToList(Decade_Rider_Items.COMPLETE_21_FORMS));

	public static final DeferredItem<Item> SHIFT_TRIDORON = ITEMS.register("tridoronshift",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_tridoron","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false))
					.addAlternative(SHIFT_TRIDORON_NOT_ALL.get()).AddNeedItemList(NEED_ITEM_TRIDORON_ALL_TIRE).alsoChange2ndSlot(TRIDORON_ALL_TIRE.get()).IsGlowing().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_HEARTRON = ITEMS.register("heartronshift",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","heart","drivedriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)
					,new MobEffectInstance(Effect_core.BOOST, 40, 1,true,false))
					.ChangeModel("drive_tridoron.geo.json").alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing().AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> SHIFT_HIGH_SPEED = ITEMS.register("high_speedshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_high_speed","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
					.ChangeModel("drive.geo.json").alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_NEXT = ITEMS.register("nextshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","dark_drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.ChangeModel("drive.geo.json").alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing().AddToList(ShiftChassisAssembler.NEXT_CAR).AddToList(RiderTabs.DRIVE_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> SHIFT_SPECIAL = ITEMS.register("specialshift",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_special","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.ChangeModel("drive.geo.json").alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing().AddToList(ShiftChassisAssembler.NEXT_CAR)
					.AddToList(RiderTabs.DRIVE_TAB_ITEM).has_basic_model());


	public static final DeferredItem<Item> SHIFT_FRUITS = ITEMS.register("fruitsshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_fruits","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.ChangeModel("drive.geo.json").alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_SPEED_WILD_TECHNIC = ITEMS.register("speedwildtechnicshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_speed_wild_technic","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
					.ChangeModel("drive.geo.json").alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing()
					.AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static List<Item> NEED_ITEM_ATTACK_123= new ArrayList<Item>();

	public static final DeferredItem<Item> ATTACK_123 = ITEMS.register("attack123_tire",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"attack123_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(Effect_core.CANNON, 40, 0,true,false))
					.addNeedForm(SHIFT_TRIDORON_NOT_ALL.get(),1).AddNeedItemList(NEED_ITEM_ATTACK_123)
					.ChangeSlot(2).model_has_different_name("tridoronshift").has_basic_model());

	public static List<Item> NEED_ITEM_PEOPLE_SAVER= new ArrayList<Item>();

	public static final DeferredItem<Item> PEOPLE_SAVER = ITEMS.register("people_saver_tire",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"people_saver_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.REGENERATION, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.SATURATION, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
					.addNeedForm(SHIFT_TRIDORON_NOT_ALL.get(),1).AddNeedItemList(NEED_ITEM_PEOPLE_SAVER)
					.ChangeSlot(2).model_has_different_name("tridoronshift").has_basic_model());

	public static List<Item> NEED_ITEM_KOUJI_GENBAR= new ArrayList<Item>();

	public static final DeferredItem<Item> KOUJI_GENBAR = ITEMS.register("kouji_genbar_tire",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kouji_genbar_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 5, 5,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 2,true,false)
					,new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 5, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 4,true,false))
					.addNeedForm(SHIFT_TRIDORON_NOT_ALL.get(),1).AddNeedItemList(NEED_ITEM_KOUJI_GENBAR)
					.ChangeSlot(2).model_has_different_name("tridoronshift").has_basic_model());

	public static final DeferredItem<Item> SHIFT_MAX_FLARE = ITEMS.register("maxflare",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"max_flare_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).AddIncompatibleForm(SHIFT_TRIDORON_NOT_ALL.asItem())
					.addAlternative(ATTACK_123.get()).ChangeSlot(2).AddToList(NEED_ITEM_ATTACK_123).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE)
					.AddToList(ShiftChassisAssembler.DRIVE_CAR,7).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_FUNKY_SPIKE = ITEMS.register("funkyspike",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"funky_spike_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).AddIncompatibleForm(SHIFT_TRIDORON_NOT_ALL.asItem())
					.addAlternative(ATTACK_123.get()).ChangeSlot(2).AddToList(NEED_ITEM_ATTACK_123).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE)
					.AddToList(ShiftChassisAssembler.DRIVE_CAR,7).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_MIDNIGHT_SHADOW = ITEMS.register("midnightshadow",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"midnight_shadow_tire","drive","drivedriver_belt",
					new MobEffectInstance(Effect_core.CANNON, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).AddIncompatibleForm(SHIFT_TRIDORON_NOT_ALL.asItem())
					.addAlternative(ATTACK_123.get()).ChangeSlot(2).AddToList(NEED_ITEM_ATTACK_123).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE)
					.AddToList(ShiftChassisAssembler.DRIVE_CAR,7).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_JUSTICE_HUNTER = ITEMS.register("justice_hunter",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"justice_hunter_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).AddIncompatibleForm(SHIFT_TRIDORON_NOT_ALL.asItem())
					.addAlternative(PEOPLE_SAVER.get()).ChangeSlot(2).AddToList(NEED_ITEM_PEOPLE_SAVER).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE)
					.AddToList(ShiftChassisAssembler.DRIVE_CAR,6).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_DREAM_VAGAS = ITEMS.register("dream_vegas",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"dream_vegas_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.LUCK, 40, 0,true,false)).AddIncompatibleForm(SHIFT_TRIDORON_NOT_ALL.asItem())
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).ChangeSlot(2).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE)
					.AddToList(ShiftChassisAssembler.DRIVE_CAR,6).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_DIMENSION_CAB = ITEMS.register("dimension_cab",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"dimension_cab_tire","drive","drivedriver_belt",
					new MobEffectInstance(Effect_core.WARP, 40, 0,true,false)).AddIncompatibleForm(SHIFT_TRIDORON_NOT_ALL.asItem())
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).ChangeSlot(2).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE)
					.AddToList(ShiftChassisAssembler.DRIVE_CAR,6).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_MASSIVE_MONSTER = ITEMS.register("massive_monster",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"massive_monster_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)).AddIncompatibleForm(SHIFT_TRIDORON_NOT_ALL.asItem())
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).ChangeSlot(2).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE)
					.AddToList(ShiftChassisAssembler.DRIVE_CAR,6).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_SPIN_MIXER = ITEMS.register("spin_mixer",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"spin_mixer_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem())
					.AddIncompatibleForm(SHIFT_TRIDORON_NOT_ALL.asItem()).addAlternative(KOUJI_GENBAR.get()).ChangeSlot(2)
					.AddToList(NEED_ITEM_KOUJI_GENBAR).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE)
					.AddToList(ShiftChassisAssembler.DRIVE_CAR,6).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_RUMBLE_DUMP = ITEMS.register("rumble_dump",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"rumble_dump_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem())
					.AddIncompatibleForm(SHIFT_TRIDORON_NOT_ALL.asItem()).addAlternative(KOUJI_GENBAR.get()).ChangeSlot(2).AddToList(NEED_ITEM_KOUJI_GENBAR)
					.AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(ShiftChassisAssembler.DRIVE_CAR,5).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_MAD_DOCTOR_MACH = ITEMS.register("mad_doctor_mach",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"mad_doctor_tire","mach","drivedriver_belt",
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false))
					.addAlternative(PEOPLE_SAVER.get()).addNeedForm(SHIFT_DEAD_HEAT_MACH.get(),1).ChangeSlot(2)
					.alsoChange2ndSlot(BASIC_TIRE.get()).model_has_different_name("mad_doctor").has_basic_model());

	public static final DeferredItem<Item> SHIFT_MAD_DOCTOR = ITEMS.register("mad_doctor",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"mad_doctor_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem())
					.AddIncompatibleForm(SHIFT_TRIDORON_NOT_ALL.asItem()).addAlternative(SHIFT_MAD_DOCTOR_MACH.get()).ChangeSlot(2).AddToList(NEED_ITEM_PEOPLE_SAVER).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE)
					.AddToList(ShiftChassisAssembler.DRIVE_CAR,5).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_HOOKING_WRECKER = ITEMS.register("hooking_wrecker",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"hooking_wrecker_tire","drive","drivedriver_belt",
					new MobEffectInstance(Effect_core.LONG_ARM, 40, 1,true,false)).AddIncompatibleForm(SHIFT_TRIDORON_NOT_ALL.asItem())
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).ChangeSlot(2).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE)
					.AddToList(ShiftChassisAssembler.DRIVE_CAR,5).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_BURNING_SOLAR = ITEMS.register("burning_solar",
			() -> new BaseItem(new Item.Properties()).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM)
					.AddToList(ShiftChassisAssembler.DRIVE_CAR,4).has_basic_model());

	public static final DeferredItem<Item> SHIFT_COLOR_COMMERCIAL = ITEMS.register("colorful_commercial",
			() -> new BaseItem(new Item.Properties()).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM)
					.AddToList(ShiftChassisAssembler.DRIVE_CAR,4).has_basic_model());


	public static final DeferredItem<Item> SHIFT_FIRE_BRAVER = ITEMS.register("fire_braver",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"fire_braver_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).AddIncompatibleForm(SHIFT_TRIDORON_NOT_ALL.asItem())
					.addAlternative(PEOPLE_SAVER.get()).ChangeSlot(2).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).AddToList(NEED_ITEM_PEOPLE_SAVER)
					.AddToList(ShiftChassisAssembler.DRIVE_CAR,4).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_ROLLING_GRAVITY = ITEMS.register("rolling_gravity",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"rolling_gravity_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).AddIncompatibleForm(SHIFT_TRIDORON_NOT_ALL.asItem())
					.addAlternative(KOUJI_GENBAR.get()).ChangeSlot(2).AddToList(NEED_ITEM_KOUJI_GENBAR).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE)
					.AddToList(ShiftChassisAssembler.DRIVE_CAR,4).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_DECO_TRAVELLER = ITEMS.register("deco_traveller",
			() -> new BaseItem(new Item.Properties()).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM)
					.AddToList(ShiftChassisAssembler.DRIVE_CAR,4).has_basic_model());


	public static final DeferredItem<Item> SHIFT_ROAD_WINTER = ITEMS.register("road_winter",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"road_winter_tire","drive","drivedriver_belt",
					new MobEffectInstance(Effect_core.BLIZZARD, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).ChangeSlot(2).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE)
					.AddToList(ShiftChassisAssembler.DRIVE_CAR,3).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_AMAZING_CIRCUS= ITEMS.register("amazing_circus",
			() -> new BaseItem(new Item.Properties()).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(RiderTabs.DRIVE_TAB_ITEM)
					.AddToList(ShiftChassisAssembler.DRIVE_CAR,3).has_basic_model());

	public static final DeferredItem<Item> SHIFT_MANTARN_F01 = ITEMS.register("mantarn_f01",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"f01_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 39,true,false))
					.addNeedForm(SHIFT_FORMULA.get(),1).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).AddIncompatibleForm(SHIFT_TRIDORON_NOT_ALL.asItem())
					.ChangeSlot(2).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(ShiftChassisAssembler.DRIVE_CAR,1).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_JACKY_F02 = ITEMS.register("jacky_f02",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"f02_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false))
					.addNeedForm(SHIFT_FORMULA.get(),1).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).AddIncompatibleForm(SHIFT_TRIDORON_NOT_ALL.asItem())
					.ChangeSlot(2).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(ShiftChassisAssembler.DRIVE_CAR,1).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_SPARNER_F03 = ITEMS.register("sparner_f03",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"f03_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false))
					.addNeedForm(SHIFT_FORMULA.get(),1).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).AddIncompatibleForm(SHIFT_TRIDORON_NOT_ALL.asItem())
					.ChangeSlot(2).AddToList(NEED_ITEM_TRIDORON_ALL_TIRE).AddToList(ShiftChassisAssembler.DRIVE_CAR,1).AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> SHIFT_MEGA_MAX_FLARE = ITEMS.register("mega_maxflare",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"mega_maxflare_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddIncompatibleForm(SHIFT_FORMULA.asItem()).AddIncompatibleForm(SHIFT_TRIDORON.asItem()).AddIncompatibleForm(SHIFT_TRIDORON_NOT_ALL.asItem())
					.ChangeSlot(2).AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> SHIFT_SPEED_GOLD = ITEMS.register("speedshift_gold",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_WILD_GOLD  = ITEMS.register("wildshift_gold",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_NEXT_HUNTER = ITEMS.register("next_hunter",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(ShiftChassisAssembler.NEXT_CAR).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_NEXT_TRAVELLER = ITEMS.register("next_traveller",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(ShiftChassisAssembler.NEXT_CAR).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_NEXT_BUILDER = ITEMS.register("next_builder",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(ShiftChassisAssembler.NEXT_CAR).AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> SHIFT_HOLY_CHRISTMAS = ITEMS.register("holy_christmas",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> SIGNAL_MACH = ITEMS.register("signal_mach",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","mach","mach_driver_honoh_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing().AddToList(RiderTabs.DRIVE_TAB_ITEM).AddToList(ShiftChassisAssembler.NEXT_BIKE,10).has_basic_model());

	public static final DeferredItem<Item> SIGNAL_MAGARL = ITEMS.register("signal_magarl",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kourin_magarl_tire","mach","mach_driver_honoh_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.ChangeSlot(2).AddToList(ShiftChassisAssembler.NEXT_BIKE,5).AddToList(RiderTabs.DRIVE_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> SIGNAL_KAKSARN = ITEMS.register("signal_kaksarn",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kourin_kaksarn_tire","mach","mach_driver_honoh_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
					.ChangeSlot(2).AddToList(RiderTabs.DRIVE_TAB_ITEM).AddToList(ShiftChassisAssembler.NEXT_BIKE,5).has_basic_model());

	public static final DeferredItem<Item> SIGNAL_TOMARLE = ITEMS.register("signal_tomarle",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kourin_tomarle_tire","mach","mach_driver_honoh_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 9,true,false))
					.ChangeSlot(2).AddToList(RiderTabs.DRIVE_TAB_ITEM).AddToList(ShiftChassisAssembler.NEXT_BIKE,5).has_basic_model());

	public static final DeferredItem<Item> SIGNAL_KIKERN= ITEMS.register("signal_kikern",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kourin_kikern_tire","mach","mach_driver_honoh_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
					.ChangeSlot(2).AddToList(RiderTabs.DRIVE_TAB_ITEM).AddToList(ShiftChassisAssembler.NEXT_BIKE,5).has_basic_model());

	public static final DeferredItem<Item> SIGNAL_CHASER_MACH= ITEMS.register("signal_chaser_mach",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_chaser","mach","mach_driver_honoh_belt_chaser",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.ChangeModel("mach.geo.json").IsGlowing().alsoChange2ndSlot(BASIC_TIRE.get()).model_has_different_name("signal_chaser").has_basic_model());

	public static final DeferredItem<Item> SIGNAL_CHASER= ITEMS.register("signal_chaser",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","chaser","mach_driver_honoh_belt_chaser",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.addAlternative(SIGNAL_CHASER_MACH.get()).IsGlowing().alsoChange2ndSlot(BASIC_TIRE.get()).AddToList(RiderTabs.DRIVE_TAB_ITEM)
					.AddToList(ShiftChassisAssembler.NEXT_BIKE,3).has_basic_model());

	public static final DeferredItem<Item> SHIFT_RIDE_CROSSER= ITEMS.register("shift_ride_crosser",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_mach_chaser","mach","mach_driver_honoh_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.ChangeModel("mach.geo.json").IsGlowing().alsoChange2ndSlot(BASIC_TIRE.get()).AddToList(RiderTabs.DRIVE_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> TRIDORON_KEY= ITEMS.register("tridoron_key",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_super","drive_dead_heat","mach_driver_honoh_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.ChangeModel("default.geo.json").IsGlowing().alsoChange2ndSlot(BASIC_TIRE.get()).AddToList(RiderTabs.DRIVE_TAB_ITEM).has_basic_model());



	public static final DeferredItem<Item> VIRAL_CORE_COBARA = ITEMS.register("viral_core_cobara",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> VIRAL_CORE_SPIDER = ITEMS.register("viral_core_spider",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> VIRAL_CORE_BAT = ITEMS.register("viral_core_bat",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> VIRAL_CORE_CHASER_COBARA = ITEMS.register("viral_core_chaser_cobara",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> VIRAL_CORE_CHASER_SPIDER = ITEMS.register("viral_core_chaser_spider",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> VIRAL_CORE_CHASER_BAT = ITEMS.register("viral_core_chaser_bat",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> VIRAL_CORE_NEO_COBARA = ITEMS.register("viral_core_neo_cobara",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> VIRAL_CORE_NEO_SPIDER = ITEMS.register("viral_core_neo_spider",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> VIRAL_CORE_NEO_BAT = ITEMS.register("viral_core_neo_bat",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_VIRAL_CORE = ITEMS.register("shift_viral_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_super_deadheat","mach","mach_driver_honoh_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.ChangeModel("chaser.geo.json").alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing()
					.model_has_different_name("rhino_super_viral_core").has_basic_model());

	public static final DeferredItem<Item> RHINO_SUPER_VIRAL_CORE = ITEMS.register("rhino_super_viral_core",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_chou","mashin_chaser","blank",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false))
					.addAlternative(SHIFT_VIRAL_CORE.get()).IsGlowing().has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

    public static final DeferredItem<Item> MEGAHEX_VIRAL_CORE  = ITEMS.register("megahex_viral_core",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_zzz","megahex","blank",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
                    .has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> TOKUJOKA_KEY = ITEMS.register("tokujoka_key",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","mach_metro_pd","metro_pd_driver_honoh_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing().has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> BANNO_TABLET = ITEMS.register("banno_tablet",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","gold_drive","banno_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.ChangeModel("drive.geo.json").alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing()
					.has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> ROIDMUDE_CORE_002 = ITEMS.register("roidmude_core_002",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> ROIDMUDE_CORE_003 = ITEMS.register("roidmude_core_003",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","brain","banno_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
					,new MobEffectInstance(Effect_core.RIDER_POISON_HAND, 40, 0,true,false))
					.ChangeModel("drive.geo.json").alsoChange2ndSlot(BASIC_TIRE.get()).IsGlowing()
					.has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> ROIDMUDE_CORE_009 = ITEMS.register("roidmude_core_009",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> PROTOZERO_CORE = ITEMS.register("protozero_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","mashin_chaser","blank",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)).IsGlowing()
                    .IsGlowing().has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> CYBEROID_ZZZ_CORE = ITEMS.register("cyberoid_zzz_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","lupin","lupin_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
                    .IsGlowing().has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> ROIDMUDE_CORE_108 = ITEMS.register("roidmude_core_108",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> DRIVE_HELMET = ITEMS.register("drive_head",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));
	public static final DeferredItem<Item> DRIVE_CHESTPLATE = ITEMS.register("drive_troso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));
	public static final DeferredItem<Item> DRIVE_LEGGINGS = ITEMS.register("drive_legs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> DRIVE_DRIVER = ITEMS.register("drivedriver",
			() -> new DriveDriverItem(ArmorMaterials.DIAMOND,"drive",SHIFT_SPEED , DRIVE_HELMET,DRIVE_CHESTPLATE,DRIVE_LEGGINGS , new Item.Properties())
					.Has_Inventory_Gui().Add_Extra_Base_Form_Items(BASIC_TIRE).ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_BELTS));

	public static final DeferredItem<Item> MACH_DRIVER_HONOH = ITEMS.register("mach_driver_honoh",
			() -> new DriveDriverItem(ArmorMaterials.DIAMOND,"mach",SIGNAL_MACH , DRIVE_HELMET,DRIVE_CHESTPLATE,DRIVE_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_TIRE).ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_BELTS));

	public static final DeferredItem<Item> MACH_DRIVER_HONOH_CHASER = ITEMS.register("mach_driver_honoh_chaser",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"chaser",SIGNAL_CHASER , DRIVE_HELMET,DRIVE_CHESTPLATE,DRIVE_LEGGINGS , new Item.Properties())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> MACH_DRIVER_HONOH_DRIVE = ITEMS.register("mach_driver_honoh_drive",
			() -> new DriveDriverItem(ArmorMaterials.DIAMOND,"drive_dead_heat",SHIFT_DEAD_HEAT_DRIVE_MACH , DRIVE_HELMET,DRIVE_CHESTPLATE,DRIVE_LEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.Add_Extra_Base_Form_Items(BASIC_TIRE).ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> DRIVE_DRIVER_PROTO_DRIVE = ITEMS.register("drivedriver_protodrive",
			() -> new DriveDriverItem(ArmorMaterials.DIAMOND,"protodrive",SHIFT_PROTO_SPEED , DRIVE_HELMET,DRIVE_CHESTPLATE,DRIVE_LEGGINGS , new Item.Properties())
					.Has_Inventory_Gui().Add_Extra_Base_Form_Items(BASIC_TIRE).ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> BREAK_GUNNER_BELT = ITEMS.register("break_gunner_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"mashin_chaser",PROTOZERO_CORE , DRIVE_HELMET,DRIVE_CHESTPLATE,DRIVE_LEGGINGS , new Item.Properties())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> LUPIN_BELT = ITEMS.register("lupin_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"lupin",CYBEROID_ZZZ_CORE , DRIVE_HELMET,DRIVE_CHESTPLATE,DRIVE_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> DRIVE_DRIVER_HEART = ITEMS.register("drivedriver_heart",
			() -> new DriveDriverItem(ArmorMaterials.DIAMOND,"heart",SHIFT_HEARTRON , DRIVE_HELMET,DRIVE_CHESTPLATE,DRIVE_LEGGINGS , new Item.Properties().rarity(Rarity.RARE))
					.Add_Extra_Base_Form_Items(BASIC_TIRE).ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> DRIVE_DRIVER_DARK_DRIVE = ITEMS.register("drivedriver_darkdrive",
			() -> new DriveDriverItem(ArmorMaterials.DIAMOND,"dark_drive",SHIFT_NEXT , DRIVE_HELMET,DRIVE_CHESTPLATE,DRIVE_LEGGINGS , new Item.Properties())
					.Has_Inventory_Gui().Add_Extra_Base_Form_Items(BASIC_TIRE).ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> BANNO_DRIVER_GORD_DRIVE = ITEMS.register("banno_driver_gord_drive",
			() -> new DriveDriverItem(ArmorMaterials.DIAMOND,"gold_drive", BANNO_TABLET, DRIVE_HELMET,DRIVE_CHESTPLATE,DRIVE_LEGGINGS , new Item.Properties())
					.IsA1().Add_Extra_Base_Form_Items(BASIC_TIRE).Dont_show_belt_form_info().ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> BANNO_DRIVER_BRONZE_DRIVE = ITEMS.register("banno_driver_bronze_drive",
			() -> new DriveDriverItem(ArmorMaterials.DIAMOND,"bronze_drive", BANNO_TABLET, DRIVE_HELMET,DRIVE_CHESTPLATE,DRIVE_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_TIRE).Dont_show_belt_form_info().ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> METRO_PD_DRIVER_HONOH = ITEMS.register("metro_pd_driver_honoh",
			() -> new DriveDriverItem(ArmorMaterials.DIAMOND,"mach_metro_pd", TOKUJOKA_KEY, DRIVE_HELMET,DRIVE_CHESTPLATE,DRIVE_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_TIRE).Dont_show_belt_form_info().ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> BRAIN_DRIVER = ITEMS.register("brain_driver",
			() -> new DriveDriverItem(ArmorMaterials.DIAMOND,"brain", ROIDMUDE_CORE_003, DRIVE_HELMET,DRIVE_CHESTPLATE,DRIVE_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_TIRE).Dont_show_belt_form_info().ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> FAKE_DRIVE_DRIVER = ITEMS.register("fake_drivedriver",
			() -> new DriveDriverItem(ArmorMaterials.DIAMOND,"fake_drive", SHIFT_SPEED, DRIVE_HELMET,DRIVE_CHESTPLATE,DRIVE_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_TIRE).Dont_show_belt_form_info().ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> HANDLE_KEN = ITEMS.register("handle_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(GordDriveEntity.THINGS_AND_STUFF).AddToTabList(RiderTabs.DRIVE_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_WEAPONS));

	public static final DeferredItem<Item> DOOR_JU = ITEMS.register("door_ju",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(GordDriveEntity.THINGS_AND_STUFF).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> TRAILER_HOU = ITEMS.register("trailer_hou",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON))
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> ZENRIN_SHOOTER = ITEMS.register("zenrin_shooter",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(GordDriveEntity.THINGS_AND_STUFF).AddToTabList(RiderTabs.DRIVE_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_WEAPONS));

	public static final DeferredItem<Item> BREAK_GUNNER = ITEMS.register("break_gunner",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsHenshinItem(BREAK_GUNNER_BELT.get())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(GordDriveEntity.THINGS_AND_STUFF).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHINGOU_AX = ITEMS.register("shingouax",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(GordDriveEntity.THINGS_AND_STUFF).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> LUPIN_GUNNER = ITEMS.register("lupin_gunner",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsHenshinItem(LUPIN_BELT.get())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> BLADE_GUNNER = ITEMS.register("blade_gunner",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> BRAIN_MEGANE_BLADE = ITEMS.register("brain_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> JUSTICE_CAGE = ITEMS.register("justice_cage",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> DRUM_SHIELD_RED = ITEMS.register("drum_shield_red",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> DRUM_SHIELD_GREEN = ITEMS.register("drum_shield_green",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> MONSTER_TOP = ITEMS.register("monster_top",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> MONSTER_BOTTOM = ITEMS.register("monster_bottom",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> RUMBLE_SMASHER = ITEMS.register("rumble_smasher",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> CURE_QUICKER = ITEMS.register("cure_quicker",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> TEN_TON_WEIGHT = ITEMS.register("ten_ton_weight",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties())
					.ChangeRepairItem(SHIFT_ALLOY.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));


	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
