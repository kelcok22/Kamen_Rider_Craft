package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
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
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));
    	    
    public static final DeferredItem<Item> ZI_O_RIDEWATCH = ITEMS.register("zi_o_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","zi_o","ziku_driver_zi_o_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
            .AddToList(RiderTabs.ZI_O_TAB_ITEM));
	public static final DeferredItem<Item> GEIZ_RIDEWATCH = ITEMS.register("geiz_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","geiz","ziku_driver_geiz_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));
	public static final DeferredItem<Item> TSUKUYOMI_RIDEWATCH = ITEMS.register("tsukuyomi_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","tsukuyomi","ziku_driver_tsukuyomi_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));
	public static final DeferredItem<Item> WOZ_MIRIDEWATCH = ITEMS.register("woz_miridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","woz","beyondriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
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


	public static final DeferredItem<Item> W_RIDEWATCH = ITEMS.register("w_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_w","zi_o","ziku_driver_zi_o_belt_w",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));
	public static final DeferredItem<Item> OOO_RIDEWATCH = ITEMS.register("ooo_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ooo","zi_o","ziku_driver_zi_o_belt_ooo",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));
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
	public static final DeferredItem<Item> GHOST_RIDEWATCH_ZI_O = ITEMS.register("ghost_ridewatch_zi_o",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ghost","zi_o","ziku_driver_zi_o_belt_ghost",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)));
	public static final DeferredItem<Item> GHOST_RIDEWATCH = ITEMS.register("ghost_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ghost","geiz","ziku_driver_geiz_belt_ghost",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.addAlternative(GHOST_RIDEWATCH_ZI_O.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));
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
					.addAlternative(EX_AID_RIDEWATCH_GEIZ.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));
	public static final DeferredItem<Item> BUILD_RIDEWATCH_GEIZ = ITEMS.register("build_ridewatch_geiz",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_build","geiz","ziku_driver_geiz_belt_build",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)));
	public static final DeferredItem<Item> BUILD_RIDEWATCH = ITEMS.register("build_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_build","zi_o","ziku_driver_zi_o_belt_build",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.addAlternative(BUILD_RIDEWATCH_GEIZ.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));


	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}
