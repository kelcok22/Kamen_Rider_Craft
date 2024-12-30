package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machineBlocks.SwordOfLogosBookAnalyzer;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.misc.GiftItem;
import com.kelco.kamenridercraft.item.saber.BookGateItem;
import com.kelco.kamenridercraft.item.saber.SeikenSwordriverItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
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
					.ResetFormToBaseIfMain().AddCompatibilityList(new String[] {"blades","espada"}).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 30));


	public static final DeferredItem<Item> STORM_EAGLE_WONDER_RIDE_BOOK = ITEMS.register("storm_eagle_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"storm_eagle","saber","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.AddCompatibilityList(new String[] {"espada"}).ChangeSlot(2).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 15));

	public static final DeferredItem<Item> SAIYUU_JOURNEY_WONDER_RIDE_BOOK = ITEMS.register("saiyuu_journey_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"saiyuu_journey","saber","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 5));

	public static final DeferredItem<Item> TENKUU_NO_PEGASUS_WONDER_RIDE_BOOK = ITEMS.register("tenkuu_no_pegasus_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"tenkuu_no_pegasus","blades","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.AddCompatibilityList(new String[] {"blades","espada"}).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 5));

	public static final DeferredItem<Item> LION_SENKI_WONDER_RIDE_BOOK = ITEMS.register("lion_senki_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"lion_senki","blades","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ResetFormToBaseIfMain().AddCompatibilityList(new String[] {"saber","espada"}).ChangeSlot(2).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 25));

	public static final DeferredItem<Item> PETER_FANTASISTA_WONDER_RIDE_BOOK = ITEMS.register("peter_fantasista_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"peter_fantasista","saber","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 15));

	public static final DeferredItem<Item> TRI_CERBERUS_WONDER_RIDE_BOOK = ITEMS.register("tri_cerberus_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"tri_cerberus","blades","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.AddCompatibilityList(new String[] {"espada"}).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 5));

	public static final DeferredItem<Item> NEEDLE_HEDGEHOG_WONDER_RIDE_BOOK = ITEMS.register("needle_hedgehog_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"needle_hedgehog","saber","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.AddCompatibilityList(new String[] {"espada"}).ChangeSlot(2).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 15));

	public static final DeferredItem<Item> LAMP_DO_ALNGINA_WONDER_RIDE_BOOK = ITEMS.register("lamp_do_alngina_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"lamp_do_alngina","espada","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.ResetFormToBaseIfMain().AddCompatibilityList(new String[] {"blades","saber"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 25));

	public static final DeferredItem<Item> GENBU_SHINWA_WONDER_RIDE_BOOK_BUSTER = ITEMS.register("genbu_shinwa_wonder_ride_book_buster",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","buster","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)));

	public static final DeferredItem<Item> GENBU_SHINWA_WONDER_RIDE_BOOK = ITEMS.register("genbu_shinwa_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"genbu_shinwa","blades","seiken_saikou_driver_belt"
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.addAlternative(GENBU_SHINWA_WONDER_RIDE_BOOK_BUSTER.get()).AddCompatibilityList(new String[] {"espada"}).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 10));

	public static final DeferredItem<Item> JACKUN_TO_DOMAMENOKI_WONDER_RIDE_BOOK_KENZAN = ITEMS.register("jackun_to_domamenoki_wonder_ride_book_kenzan",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_jackun","kenzan","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)));

	public static final DeferredItem<Item> JACKUN_TO_DOMAMENOKI_WONDER_RIDE_BOOK_BUSTER = ITEMS.register("jackun_to_domamenoki_wonder_ride_book_buster",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_jackun","buster","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
					.addAlternative(JACKUN_TO_DOMAMENOKI_WONDER_RIDE_BOOK_KENZAN.get()));

	public static final DeferredItem<Item> JACKUN_TO_DOMAMENOKI_WONDER_RIDE_BOOK = ITEMS.register("jackun_to_domamenoki_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"jackun_to_domamenoki","saber","seiken_saikou_driver_belt"
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
					.addAlternative(JACKUN_TO_DOMAMENOKI_WONDER_RIDE_BOOK_BUSTER.get()).AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 15));

	public static final DeferredItem<Item> SARUTOBI_NINJADEN_WONDER_RIDE_BOOK_KENZAN = ITEMS.register("sarutobi_ninjaden_wonder_ride_book_kenzan",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","kenzan","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)));

	public static final DeferredItem<Item> SARUTOBI_NINJADEN_WONDER_RIDE_BOOK = ITEMS.register("sarutobi_ninjaden_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"sarutobi_ninjaden","saber","seiken_saikou_driver_belt"
					,new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
					.addAlternative(SARUTOBI_NINJADEN_WONDER_RIDE_BOOK_KENZAN.get()).AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 10));

	public static final DeferredItem<Item> KOBUTA_3KYOUDAI_WONDER_RIDE_BOOK_SLASH = ITEMS.register("kobuta_3_kyoudai_wonder_ride_book_slash",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kobuta_3_kyoudai","slash","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)));

	public static final DeferredItem<Item> KOBUTA_3KYOUDAI_WONDER_RIDE_BOOK_KENZAN = ITEMS.register("kobuta_3_kyoudai_wonder_ride_book_kenzan",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kobuta_3_kyoudai","kenzan","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.addAlternative(KOBUTA_3KYOUDAI_WONDER_RIDE_BOOK_SLASH.get()));

	public static final DeferredItem<Item> KOBUTA_3KYOUDAI_WONDER_RIDE_BOOK = ITEMS.register("kobuta_3_kyoudai_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kobuta_3_kyoudai","saber","seiken_saikou_driver_belt"
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.addAlternative(KOBUTA_3KYOUDAI_WONDER_RIDE_BOOK_KENZAN.get()).AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 15));

	public static final DeferredItem<Item> HANSELNUTS_TO_GRETEL_WONDER_RIDE_BOOK_SLASH = ITEMS.register("hanselnuts_to_gretel_wonder_ride_book_slash",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","slash","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)));

	public static final DeferredItem<Item> HANSELNUTS_TO_GRETEL_WONDER_RIDE_BOOK = ITEMS.register("hanselnuts_to_gretel_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"hanselnuts_to_gretel","saber","seiken_saikou_driver_belt"
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
					.addAlternative(HANSELNUTS_TO_GRETEL_WONDER_RIDE_BOOK_SLASH.get()).AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 10));

	public static final DeferredItem<Item> BREMEN_NO_ROCK_BAND_WONDER_RIDE_BOOK_BUSTER = ITEMS.register("bremen_no_rock_band_wonder_ride_book_buster",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_bremen_no_rock_band","buster","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false)));

	public static final DeferredItem<Item> BREMEN_NO_ROCK_BAND_WONDER_RIDE_BOOK_SLASH = ITEMS.register("bremen_no_rock_band_wonder_ride_book_slash",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_bremen_no_rock_band","slash","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
					.addAlternative(BREMEN_NO_ROCK_BAND_WONDER_RIDE_BOOK_BUSTER.get()));

	public static final DeferredItem<Item> BREMEN_NO_ROCK_BAND_WONDER_RIDE_BOOK = ITEMS.register("bremen_no_rock_band_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"bremen_no_rock_band","saber","seiken_saikou_driver_belt"
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false))
					.addAlternative(BREMEN_NO_ROCK_BAND_WONDER_RIDE_BOOK_SLASH.get()).AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 15));

	public static final DeferredItem<Item> JAAKU_DRAGON_WONDER_RIDE_BOOK_CALIBUR = ITEMS.register("jaaku_dragon_wonder_ride_book_calibur",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","calibur","jaken_caliburdriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)));

	public static final DeferredItem<Item> JAAKU_DRAGON_WONDER_RIDE_BOOK = ITEMS.register("jaaku_dragon_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"jaaku_dragon","blades","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.addAlternative(JAAKU_DRAGON_WONDER_RIDE_BOOK_CALIBUR.get()).AddCompatibilityList(new String[] {"espada"}).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> ETERNAL_PHOENIX_WONDER_RIDE_BOOK = ITEMS.register("eternal_phoenix_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"eternal_phoenix","blades","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.AddCompatibilityList(new String[] {"espada"}).AddToList(RiderTabs.SABER_TAB_ITEM));

	// gaikotsu_ninjaden_wonder_ride_book

	public static final DeferredItem<Item> KING_OF_ARTHUR_WONDER_RIDE_BOOK = ITEMS.register("king_of_arthur_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"king_of_arthur","saber","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 3));

	public static final DeferredItem<Item> DRAGONIC_KNIGHT_WONDER_RIDE_BOOK = ITEMS.register("dragonic_knight_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"saber_dragonic_knight","saber","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.AddNum(2).ResetFormToBase().AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> TELEVI_KUN_WONDER_RIDE_BOOK = ITEMS.register("televi_kun_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"televi_kun","saber","seiken_saikou_driver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK));

	public static final DeferredItem<Item> HAPPY_BRAVE_DRAGON_WONDER_RIDE_BOOK = ITEMS.register("happy_brave_dragon_wonder_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(GiftItem.GIFTS).AddToList(RiderTabs.SABER_TAB_ITEM));

	//public static final DeferredItem<Item> BOOK_GATE_WONDER_RIDE_BOOK = ITEMS.register("book_gate_wonder_ride_book",
	//		() -> new BookGateItem(new Item.Properties(),10).AddToList(RiderTabs.SABER_TAB_ITEM));


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
					.Add_Extra_Base_Form_Items(SABER_BLANK_2,LAMP_DO_ALNGINA_WONDER_RIDE_BOOK).AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> SWORD_OF_LOGOS_BUCKLE_BUSTER = ITEMS.register("sword_of_logos_buckle_buster",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"buster",GENBU_SHINWA_WONDER_RIDE_BOOK_BUSTER ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS , new Item.Properties())
					.AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> SWORD_OF_LOGOS_BUCKLE_KENZAN = ITEMS.register("sword_of_logos_buckle_kenzan",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kenzan",SARUTOBI_NINJADEN_WONDER_RIDE_BOOK_KENZAN ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS , new Item.Properties())
					.AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> SWORD_OF_LOGOS_BUCKLE_SLASH = ITEMS.register("sword_of_logos_buckle_slash",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"slash",HANSELNUTS_TO_GRETEL_WONDER_RIDE_BOOK_SLASH ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS , new Item.Properties())
					.AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> JAKEN_CALIBURDRIVER = ITEMS.register("jaken_caliburdriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"calibur",JAAKU_DRAGON_WONDER_RIDE_BOOK_CALIBUR ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS , new Item.Properties())
					.AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	// seiken_swordriver_desast


	public static final DeferredItem<Item> KAENKEN_REKKA = ITEMS.register("kaenken_rekka",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> KINGEXCALIBUR = ITEMS.register("kingexcalibur",
			() -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> SUISEIKEN_NAGARE = ITEMS.register("suiseiken_nagare",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> RAIMEIKEN_IKAZUCHI = ITEMS.register("raimeiken_ikazuchi",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> DOGOUKEN_GEKIDO = ITEMS.register("dogouken_gekido",
			() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> FUUSOUKEN_HAYATE_NITOURYU = ITEMS.register("fuusouken_hayate_nitouryu",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> FUUSOUKEN_HAYATE_NITOURYU_2 = ITEMS.register("fuusouken_hayate_nitouryu2",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> FUUSOUKEN_HAYATE_SHURIKEN = ITEMS.register("fuusouken_hayate_shuriken",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()).KeepDifItem(FUUSOUKEN_HAYATE_NITOURYU_2.get()));

	public static final DeferredItem<Item> FUUSOUKEN_HAYATE_ITTOURYU = ITEMS.register("fuusouken_hayate_ittouryu",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()).KeepDifItem(FUUSOUKEN_HAYATE_NITOURYU_2.get()));

    public static final DeferredItem<Item> ONJUUKEN_SUZUNE = ITEMS.register("onjuuken_suzune",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties())
			.IsSwordGun().AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> ANKOKUKEN_KURAYAMI = ITEMS.register("ankokuken_kurayami",
			() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	// kokuranken_shikkoku


	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
