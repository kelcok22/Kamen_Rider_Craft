package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.saber.SeikenSwordriverItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Saber_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);



	public static final DeferredItem<Item> SABER_LOGO = ITEMS.register("saber_logo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> BLANK_WONDER_RIDE_BOOK = ITEMS.register("blank_wonder_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM));



	public static final DeferredItem<Item> SABER_BLANK_1 = ITEMS.register("saber_blank_1",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"blank","saber","seiken_saikou_driver_belt"));

	public static final DeferredItem<Item> SABER_BLANK_2 = ITEMS.register("saber_blank_2",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"blank","saber","seiken_saikou_driver_belt"));

	public static final DeferredItem<Item> SABER_BLANK_3 = ITEMS.register("saber_blank_3",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"blank","saber","seiken_saikou_driver_belt"));


	public static final DeferredItem<Item> BRAVE_DRAGON_WONDER_RIDE_BOOK = ITEMS.register("brave_dragon_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"brave_dragon","saber","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> STORM_EAGLE_WONDER_RIDE_BOOK = ITEMS.register("storm_eagle_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"storm_eagle","saber","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(2).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> SAIYUU_JOURNEY_WONDER_RIDE_BOOK = ITEMS.register("saiyuu_journey_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"saiyuu_journey","saber","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM));


	public static final DeferredItem<Item> LION_SENKI_WONDER_RIDE_BOOK = ITEMS.register("lion_senki_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"lion_senki","saber","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(2).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> LAMP_DO_ALNGINA_WONDER_RIDE_BOOK = ITEMS.register("lamp_do_alngina_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"lamp_do_alngina","saber","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> SABER_HELMET = ITEMS.register("saberhead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));
	public static final DeferredItem<Item> SABER_CHESTPLATE = ITEMS.register("sabertroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));
	public static final DeferredItem<Item> SABER_LEGGINGS = ITEMS.register("saberlegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> SEIKEN_SWORDRIVER_DRIVER_SABER = ITEMS.register("seiken_swordriver_saber",
			() -> new SeikenSwordriverItem(ArmorMaterials.DIAMOND,"saber",BRAVE_DRAGON_WONDER_RIDE_BOOK ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(SABER_BLANK_2,SABER_BLANK_3).AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> SEIKEN_SWORDRIVER_DRIVER_BLADES = ITEMS.register("seiken_swordriver_blades",
			() -> new SeikenSwordriverItem(ArmorMaterials.DIAMOND,"blades",SABER_BLANK_1 ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(LION_SENKI_WONDER_RIDE_BOOK,SABER_BLANK_3).AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> SEIKEN_SWORDRIVER_DRIVER_ESPADA = ITEMS.register("seiken_swordriver_espada",
			() -> new SeikenSwordriverItem(ArmorMaterials.DIAMOND,"espada",SABER_BLANK_1 ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(SABER_BLANK_3,LAMP_DO_ALNGINA_WONDER_RIDE_BOOK).AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));


	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
