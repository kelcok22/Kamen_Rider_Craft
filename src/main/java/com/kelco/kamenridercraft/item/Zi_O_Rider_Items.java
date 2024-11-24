package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
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
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
            .AddToList(RiderTabs.ZI_O_TAB_ITEM));
	public static final DeferredItem<Item> GEIZ_RIDEWATCH = ITEMS.register("geiz_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","geiz","ziku_driver_geiz_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
					.AddToList(RiderTabs.ZI_O_TAB_ITEM));
	public static final DeferredItem<Item> TSUKUYOMI_RIDEWATCH = ITEMS.register("tsukuyomi_ridewatch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","tsukuyomi","ziku_driver_tsukuyomi_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
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
    

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}
