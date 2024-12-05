package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.zi_o.BlankRidewatchItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Zi_O_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> ZI_O_LOGO = ITEMS.register("zi_o_logo",
    		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));
 
	public static final DeferredItem<Item> BLANK_RIDEWATCH = ITEMS.register("blank_watch",
			() -> new BlankRidewatchItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));
    	    
    public static final DeferredItem<Item> ZI_O_RIDEWATCH = ITEMS.register("zi_o_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","zi_o","ziku_driver_zi_o_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM).AddToList(BlankRidewatchItem.RIDEWATCH, 30));

	public static final DeferredItem<Item> GEIZ_RIDEWATCH = ITEMS.register("geiz_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","geiz","ziku_driver_geiz_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM).AddToList(BlankRidewatchItem.RIDEWATCH, 20));

	public static final DeferredItem<Item> TSUKUYOMI_RIDEWATCH = ITEMS.register("tsukuyomi_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","tsukuyomi","ziku_driver_tsukuyomi_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM).AddToList(BlankRidewatchItem.RIDEWATCH, 1));

	public static final DeferredItem<Item> WOZ_MIRIDEWATCH = ITEMS.register("woz_miridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","woz","beyondriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> ZI_O_MIRROR_RIDEWATCH = ITEMS.register("zi_o_mirror_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","zi_o_mirror","ziku_driver_zi_o_mirror_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> BARLCKXS_RIDEWATCH = ITEMS.register("barlckxs_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","barlckxs","ziku_driver_barlckxs_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> ZONJIS_RIDEWATCH = ITEMS.register("zonjis_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","zonjis","ziku_driver_zonjis_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> ZAMONAS_RIDEWATCH = ITEMS.register("zamonas_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","zamonas","ziku_driver_zamonas_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));


	public static final DeferredItem<Item> KUUGA_RIDEWATCH = ITEMS.register("kuuga_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kuuga","zi_o","ziku_driver_zi_o_belt_kuuga",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_RIDEWATCH = ITEMS.register("agito_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_agito","zi_o","ziku_driver_zi_o_belt_agito",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> RYUKI_RIDEWATCH = ITEMS.register("ryuki_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ryuki","zi_o","ziku_driver_zi_o_belt_ryuki",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(Effect_core.BOOST, 40, 0,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> FAIZ_RIDEWATCH = ITEMS.register("faiz_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_faiz","geiz","ziku_driver_geiz_belt_faiz",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> BLADE_RIDEWATCH = ITEMS.register("blade_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_blade","zi_o","ziku_driver_zi_o_belt_blade",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> HIBIKI_RIDEWATCH = ITEMS.register("hibiki_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hibiki","zi_o","ziku_driver_zi_o_belt_hibiki",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> KABUTO_RIDEWATCH = ITEMS.register("kabuto_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kabuto","zi_o","ziku_driver_zi_o_belt_kabuto",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_RIDEWATCH = ITEMS.register("den_o_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_den_o","zi_o","ziku_driver_zi_o_belt_den_o",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> KIVA_RIDEWATCH = ITEMS.register("kiva_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kiva","zi_o","ziku_driver_zi_o_belt_kiva",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_RIDEWATCH = ITEMS.register("decade_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_decade","zi_o","ziku_driver_zi_o_belt_decade",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json").AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> W_RIDEWATCH = ITEMS.register("w_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_w","zi_o","ziku_driver_zi_o_belt_w",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
							new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
							new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
							.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_OOO_RIDEWATCH = ITEMS.register("decade_ooo_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_decade_ooo","zi_o","ziku_driver_zi_o_belt_decade_ooo",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

	public static final DeferredItem<Item> OOO_RIDEWATCH = ITEMS.register("ooo_ridewatch",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_ooo","zi_o","ziku_driver_zi_o_belt_ooo",
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
							new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
							new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
							new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
							.AddIncompatibleForm(DECADE_RIDEWATCH.asItem()).addAlternative(DECADE_OOO_RIDEWATCH.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> FOURZE_RIDEWATCH = ITEMS.register("fourze_ridewatch",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_fourze","zi_o","ziku_driver_zi_o_belt_fourze",
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
							new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
							new MobEffectInstance(Effect_core.BOOST, 40, 0,true,false),
							new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false))
							.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_RIDEWATCH = ITEMS.register("wizard_ridewatch",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_wizard","geiz","ziku_driver_geiz_belt_wizard",
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
							new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
							new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
							.AddToList(RiderTabs.ZI_O_TAB_ITEM));

			public static final DeferredItem<Item> GAIM_RIDEWATCH = ITEMS.register("gaim_ridewatch",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_gaim","zi_o","ziku_driver_zi_o_belt_gaim",
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
							new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
							new MobEffectInstance(MobEffects.SATURATION, 40, 5,true,false),
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
							.ChangeModel("default_rider_plusbelt_and_wings.geo.json").AddToList(RiderTabs.ZI_O_TAB_ITEM));

			public static final DeferredItem<Item> DRIVE_RIDEWATCH = ITEMS.register("drive_ridewatch",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_drive","geiz","ziku_driver_geiz_belt_drive",
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
							new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
							.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_GHOST_RIDEWATCH = ITEMS.register("decade_ghost_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_decade_ghost","zi_o","ziku_driver_zi_o_belt_decade_ghost",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

			public static final DeferredItem<Item> GHOST_RIDEWATCH_ZI_O = ITEMS.register("ghost_ridewatch_zi_o",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_ghost","zi_o","ziku_driver_zi_o_belt_ghost",
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
							new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
							new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
							.AddIncompatibleForm(DECADE_RIDEWATCH.asItem()).addAlternative(DECADE_GHOST_RIDEWATCH.get()));

			public static final DeferredItem<Item> GHOST_RIDEWATCH = ITEMS.register("ghost_ridewatch",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_ghost","geiz","ziku_driver_geiz_belt_ghost",
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
							new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
							new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
							.addAlternative(GHOST_RIDEWATCH_ZI_O.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_EX_AID_RIDEWATCH_L = ITEMS.register("decade_ex_aid_ridewatch_l",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_decade_ex_aid_l","zi_o","ziku_driver_zi_o_belt_decade_ex_aid",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

	public static final DeferredItem<Item> DECADE_EX_AID_RIDEWATCH_R = ITEMS.register("decade_ex_aid_ridewatch_r",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_decade_ex_aid_r","zi_o","ziku_driver_zi_o_belt_decade_ex_aid",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.addSwitchForm(DECADE_EX_AID_RIDEWATCH_L.get()).ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

			public static final DeferredItem<Item> EX_AID_RIDEWATCH_GEIZ = ITEMS.register("ex_aid_ridewatch_geiz",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_ex_aid","geiz","ziku_driver_geiz_belt_ex_aid",
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
							new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
							new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false)));

			public static final DeferredItem<Item> EX_AID_RIDEWATCH = ITEMS.register("ex_aid_ridewatch",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_ex_aid","zi_o","ziku_driver_zi_o_belt_ex_aid",
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
							new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
							new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false))
							.AddIncompatibleForm(DECADE_RIDEWATCH.asItem()).addAlternative(DECADE_EX_AID_RIDEWATCH_L.get()).addAlternative(EX_AID_RIDEWATCH_GEIZ.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_BUILD_RIDEWATCH = ITEMS.register("decade_build_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_decade_build","zi_o","ziku_driver_zi_o_belt_decade_build",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

	public static final DeferredItem<Item> BUILD_RIDEWATCH_GEIZ = ITEMS.register("build_ridewatch_geiz",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_build","geiz","ziku_driver_geiz_belt_build",
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
							new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
							new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
							.addAlternative(DECADE_BUILD_RIDEWATCH.get()));

			public static final DeferredItem<Item> BUILD_RIDEWATCH = ITEMS.register("build_ridewatch",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_build","zi_o","ziku_driver_zi_o_belt_build",
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
							new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
							new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
							.AddIncompatibleForm(DECADE_RIDEWATCH.asItem()).AddIncompatibleForm(DECADE_BUILD_RIDEWATCH.asItem())
							.addAlternative(BUILD_RIDEWATCH_GEIZ.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> ZERO_ONE_RIDEWATCH = ITEMS.register("zero_one_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> SABER_RIDEWATCH = ITEMS.register("saber_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_decade_saber","zi_o","ziku_driver_zi_o_belt_decade_saber",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json").addNeedItem(DECADE_RIDEWATCH.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> REVI_RIDEWATCH = ITEMS.register("revi_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> VICE_RIDEWATCH = ITEMS.register("vice_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> GEATS_RIDEWATCH = ITEMS.register("geats_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> GOTCHARD_RIDEWATCH = ITEMS.register("gotchard_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> AMAZON_ALPHA_RIDEWATCH = ITEMS.register("amazon_alpha_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));
	public static final DeferredItem<Item> AMAZON_OMEGA_RIDEWATCH = ITEMS.register("amazon_omega_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));
	public static final DeferredItem<Item> AMAZON_NEO_RIDEWATCH = ITEMS.register("amazon_neo_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> GENM_RIDEWATCH = ITEMS.register("genm_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_genm","geiz","ziku_driver_geiz_belt_genm",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> WOZ_RIDEWATCH = ITEMS.register("woz_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_woz","zi_o","ziku_driver_zi_o_belt_woz",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(Effect_core.BOOST, 40, 0,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> BIBIRU_GEIZ_RIDEWATCH = ITEMS.register("bibiru_geiz_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_bibiru","geiz","ziku_driver_geiz_belt_bibiru",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_ULTIMATE_RIDEWATCH = ITEMS.register("kuuga_ultimate_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_SHINING_RIDEWATCH = ITEMS.register("agito_shining_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> RYUKI_SURVIVE_RIDEWATCH = ITEMS.register("ryuki_survive_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> FAIZ_BLASTER_RIDEWATCH = ITEMS.register("faiz_blaster_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> BLADE_KING_RIDEWATCH = ITEMS.register("blade_king_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> HIBIKI_ARMED_RIDEWATCH = ITEMS.register("hibiki_armed_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> KABUTO_HYPER_RIDEWATCH = ITEMS.register("kabuto_hyper_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_LINER_RIDEWATCH = ITEMS.register("den_o_liner_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> KIVA_EMPEROR_RIDEWATCH = ITEMS.register("kiva_emperor_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_COMPLETE_RIDEWATCH = ITEMS.register("decade_complete_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> W_XTREME_RIDEWATCH = ITEMS.register("w_xtreme_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> OOO_PUTOTYRA_RIDEWATCH = ITEMS.register("ooo_putotyra_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> FOURZE_COSMIC_RIDEWATCH = ITEMS.register("fourze_cosmic_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_INFINITY_RIDEWATCH = ITEMS.register("wizard_infinity_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> GAIM_KIWAMI_RIDEWATCH = ITEMS.register("gaim_kiwami_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> DRIVE_TRIDORON_RIDEWATCH = ITEMS.register("drive_tridoron_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> GHOST_MUGEN_RIDEWATCH = ITEMS.register("ghost_mugen_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> EX_AID_MUTEKI_RIDEWATCH = ITEMS.register("ex_aid_muteki_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> BUILD_GENIUS_RIDEWATCH = ITEMS.register("build_genius_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> RYUSOULGER_RIDEWATCH = ITEMS.register("ryusoulger_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> ICHIGO_RIDEWATCH = ITEMS.register("ichigo_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> NIGO_RIDEWATCH = ITEMS.register("nigo_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> V3_RIDEWATCH = ITEMS.register("v3_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> RIDERMAN_RIDEWATCH = ITEMS.register("riderman_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> X_RIDEWATCH = ITEMS.register("x_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> AMAZON_RIDEWATCH = ITEMS.register("amazon_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> STRONGER_RIDEWATCH = ITEMS.register("stronger_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_RX_RIDEWATCH = ITEMS.register("black_rx_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> BIO_RIDER_RIDEWATCH = ITEMS.register("bio_rider_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_biorider","barlckxs","ziku_driver_barlckxs_belt_biorider",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(Effect_core.BIG, 40, 2,true,false))
					.SetPalyerModelInvisible().IsGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> ROBO_RIDER_RIDEWATCH = ITEMS.register("robo_rider_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> SHIN_RIDEWATCH = ITEMS.register("shin_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> ZO_RIDEWATCH = ITEMS.register("zo_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> J_RIDEWATCH = ITEMS.register("j_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> CHRISTMAS_RIDEWATCH = ITEMS.register("christmas_ridewatch",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> SHURIKEN_STARTER = ITEMS.register("shuriken_starter",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","shinobi","shinobi_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> SHURIKEN_STARTER_HATTARI = ITEMS.register("shuriken_starter_hattari",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","hattari","hattari_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> QUIZ_TOPPER = ITEMS.register("quiz_topper",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","quiz","quiz_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> SPANNERDER_SCREWDER = ITEMS.register("spannerder_screwder",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","kikai","kikai_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));

	public static final DeferredItem<Item> GINGA_SCOPE = ITEMS.register("ginga_scope",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","ginga","ginga_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));
		
		
	public static final DeferredItem<Item> ZI_O_HELMET = ITEMS.register("zi_o_head",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

	public static final DeferredItem<Item> ZI_O_CHESTPLATE = ITEMS.register("zi_o_troso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

	public static final DeferredItem<Item> ZI_O_LEGGINGS = ITEMS.register("zi_o_legs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    
    public static final DeferredItem<Item> ZIKU_DRIVER_ZI_O = ITEMS.register("ziku_driver_zi_o",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zi_o",ZI_O_RIDEWATCH ,ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

	public static final DeferredItem<Item> ZIKU_DRIVER_GEIZ = ITEMS.register("ziku_driver_geiz",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"geiz",GEIZ_RIDEWATCH ,ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

	public static final DeferredItem<Item> ZIKU_DRIVER_TSUKUYOMI = ITEMS.register("ziku_driver_tsukuyomi",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"tsukuyomi",TSUKUYOMI_RIDEWATCH ,ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

	public static final DeferredItem<Item> BEYONDRIVER = ITEMS.register("beyondriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"woz",WOZ_MIRIDEWATCH ,ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

	public static final DeferredItem<Item> ZIKU_DRIVER_ZI_O_MIRROR = ITEMS.register("ziku_driver_zi_o_mirror",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zi_o_mirror",ZI_O_MIRROR_RIDEWATCH ,ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

	public static final DeferredItem<Item> ZIKU_DRIVER_BARLCKXS = ITEMS.register("ziku_driver_barlckxs",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"barlckxs",BARLCKXS_RIDEWATCH ,ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

	public static final DeferredItem<Item> ZIKU_DRIVER_ZONJIS = ITEMS.register("ziku_driver_zonjis",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zonjis",ZONJIS_RIDEWATCH ,ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

	public static final DeferredItem<Item> ZIKU_DRIVER_ZAMONAS = ITEMS.register("ziku_driver_zamonas",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zamonas",ZAMONAS_RIDEWATCH ,ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

	public static final DeferredItem<Item> SHINOBIDRIVER = ITEMS.register("shinobi_driver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shinobi",SHURIKEN_STARTER ,ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

	public static final DeferredItem<Item> HATTARIDRIVER = ITEMS.register("hattari_driver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"hattari",SHURIKEN_STARTER_HATTARI ,ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

	public static final DeferredItem<Item> QUIZDRIVER = ITEMS.register("quiz_driver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"quiz",QUIZ_TOPPER ,ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

	public static final DeferredItem<Item> KIKAIDRIVER = ITEMS.register("kikai_driver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kikai",SPANNERDER_SCREWDER ,ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

	public static final DeferredItem<Item> GINGADRIVER = ITEMS.register("ginga_driver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ginga",GINGA_SCOPE ,ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));


	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}
