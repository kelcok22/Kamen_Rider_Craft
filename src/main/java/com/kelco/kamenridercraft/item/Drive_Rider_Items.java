package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.drive.DriveDriverItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Drive_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> DRIVE_LOGO = ITEMS.register("drive_logo",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_SPEED_TIRE = ITEMS.register("speed_tire",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"type_speed_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false))
					.ChangeSlot(2));

	public static final DeferredItem<Item> SHIFT_SPEED = ITEMS.register("speedshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.ChangeModel("geo/type_speed.geo.json").alsoChange2ndSlot(SHIFT_SPEED_TIRE.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_WILD_TIRE = ITEMS.register("wild_tire",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"wild_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false))
					.ChangeSlot(2));

	public static final DeferredItem<Item> SHIFT_WILD = ITEMS.register("wildshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_wild","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.ChangeModel("geo/type_wild.geo.json").alsoChange2ndSlot(SHIFT_WILD_TIRE.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_HIGH_SPEED_TIRE = ITEMS.register("high_speed_tire",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"type_high_speed_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false))
					.ChangeSlot(2));

	public static final DeferredItem<Item> SHIFT_HIGH_SPEED = ITEMS.register("high_speedshift",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_high_speed","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 400, 1,true,false))
					.ChangeModel("geo/type_speed.geo.json").alsoChange2ndSlot(SHIFT_HIGH_SPEED_TIRE.get()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> SHIFT_MAX_FLARE = ITEMS.register("maxflare",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"max_flare_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0,true,false))
					.ChangeSlot(2).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_FUNKY_SPIKE = ITEMS.register("funkyspike",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"funky_spike_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0,true,false))
					.ChangeSlot(2).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_MIDNIGHT_SHADOW = ITEMS.register("midnightshadow",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"midnight_shadow_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0,true,false))
					.ChangeSlot(2).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_JUSTICE_HUNTER = ITEMS.register("justice_hunter",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"justice_hunter_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0,true,false))
					.ChangeSlot(2).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_DREAM_VAGAS = ITEMS.register("dream_vegas",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"dream_vegas_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0,true,false))
					.ChangeSlot(2).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_DIMENSION_CAB = ITEMS.register("dimension_cab",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"dimension_cab_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0,true,false))
					.ChangeSlot(2).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_MASSIVE_MONSTER = ITEMS.register("massive_monster",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"massive_monster_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0,true,false))
					.ChangeSlot(2).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_SPIN_MIXER = ITEMS.register("spin_mixer",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"spin_mixer_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0,true,false))
					.ChangeSlot(2).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_RUMBLE_DUMP = ITEMS.register("rumble_dump",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"rumble_dump_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0,true,false))
					.ChangeSlot(2).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_MAD_DOCTOR = ITEMS.register("mad_doctor",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"mad_doctor_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0,true,false))
					.ChangeSlot(2).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_HOOKING_WRECKER = ITEMS.register("hooking_wrecker",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"hooking_wrecker_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0,true,false))
					.ChangeSlot(2).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_FIRE_BRAVER = ITEMS.register("fire_braver",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"fire_braver_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0,true,false))
					.ChangeSlot(2).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_ROLLING_GRAVITY = ITEMS.register("rolling_gravity",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"rolling_gravity_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0,true,false))
					.ChangeSlot(2).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_ROAD_WINTER = ITEMS.register("road_winter",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"road_winter_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0,true,false))
					.ChangeSlot(2).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> SHIFT_MEGA_MAX_FLARE = ITEMS.register("mega_maxflare",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"mega_maxflare_tire","drive","drivedriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0,true,false))
					.ChangeSlot(2).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));


	public static final DeferredItem<Item> DRIVE_HELMET = ITEMS.register("drive_head",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));
	public static final DeferredItem<Item> DRIVE_CHESTPLATE = ITEMS.register("drive_troso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));
	public static final DeferredItem<Item> DRIVE_LEGGINGS = ITEMS.register("drive_legs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));

	public static final DeferredItem<Item> DRIVE_DRIVER = ITEMS.register("drivedriver",
			() -> new DriveDriverItem(ArmorMaterials.DIAMOND,"drive",SHIFT_SPEED , DRIVE_HELMET,DRIVE_CHESTPLATE,DRIVE_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(SHIFT_SPEED_TIRE).AddToTabList(RiderTabs.DRIVE_TAB_ITEM));



	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}