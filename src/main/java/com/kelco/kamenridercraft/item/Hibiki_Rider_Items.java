package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.hibiki.ArmedSaberItem;
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

public class Hibiki_Rider_Items {

        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

        public static final DeferredItem<Item> HIBIKI_LOGO = ITEMS.register("hibiki_logo",
	    		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.HIBIKI_TAB_ITEM));
 
        public static final DeferredItem<Item> ONI_ORE = ITEMS.register("oni_ore",
		        () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.HIBIKI_TAB_ITEM));
        public static final DeferredItem<Item> ONI_OREHELL = ITEMS.register("oni_orehell",
                () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.HIBIKI_TAB_ITEM));
        public static final DeferredItem<Item> UNFINISHED_ARMED_SABER = ITEMS.register("unfinished_armed_saber",
                () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        
        public static final DeferredItem<Item> HENSHIN_ONSA = ITEMS.register("henshin_onsa",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","hibiki","hibikidriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_ONSA_KURENAI = ITEMS.register("henshin_onsa_kurenai",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_kurenai","hibiki","hibikidriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_ONSA_ARMED = ITEMS.register("henshin_onsa_armed",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_armed","hibiki","hibikidriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false)));

        public static final DeferredItem<Item> HENSHIN_ONSA_DANKI = ITEMS.register("henshin_onsa_danki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","danki","dankidriver_belt",
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_ONSA_EIKI = ITEMS.register("henshin_onsa_eiki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","eiki","eikidriver_belt",
                new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
                new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_ONSA_GOUKI = ITEMS.register("henshin_onsa_gouki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","gouki","goukidriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_ONSA_KYOKI = ITEMS.register("henshin_onsa_kyoki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","kyoki","kyosukedriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_ONSA_KABUKI = ITEMS.register("henshin_onsa_kabuki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","kabuki","kabukidriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
                new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_ONSA_TOUKI = ITEMS.register("henshin_onsa_touki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","touki_m","toukidriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
                new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_ONSA_HABATAKI = ITEMS.register("henshin_onsa_habataki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","habataki","habatakidriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_ONSA_KIRAMEKI = ITEMS.register("henshin_onsa_kirameki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","kirameki","kiramekidriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_ONSA_NISHIKI = ITEMS.register("henshin_onsa_nishiki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","nishiki","nishikidriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
                new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));


        public static final DeferredItem<Item> HENSHIN_ONIBUE_IBUKI = ITEMS.register("henshin_onibue_ibuki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","ibuki","ibukidriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_ONIBUE_TOKI = ITEMS.register("henshin_onibue_toki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","touki","tokidriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_ONIBUE_SHOUKI = ITEMS.register("henshin_onibue_shouki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","shouki","shoukidriver_belt",
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_ONIBUE_AMAKI = ITEMS.register("henshin_onibue_amaki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","amaki","amakidriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_ONIBUE_FUBUKI = ITEMS.register("henshin_onibue_fubuki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","fubuki","fubukidriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));
        

        public static final DeferredItem<Item> HENSHIN_KIGEN_TODOROKI = ITEMS.register("henshin_kigen_todoroki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","todoroki","todorokidriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_KIGEN_ZANKI = ITEMS.register("henshin_kigen_zanki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","zanki","zankidriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_KIGEN_SHUKI = ITEMS.register("henshin_kigen_shuki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","shuki","shukidriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_KIGEN_BANKI = ITEMS.register("henshin_kigen_banki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","banki","bankidriver_belt",
                new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));

        public static final DeferredItem<Item> HENSHIN_KIGEN_SABAKI = ITEMS.register("henshin_kigen_sabaki",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","sabaki","sabakidriver_belt",
                new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)).AddToList(RiderTabs.HIBIKI_TAB_ITEM));
        
        public static final DeferredItem<Item> HIBIKIHELMET = ITEMS.register("hibikihead",
                () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM));
        public static final DeferredItem<Item> HIBIKICHESTPLATE = ITEMS.register("hibikitroso",
                () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM));
        public static final DeferredItem<Item> HIBIKILEGGINGS = ITEMS.register("hibikilegs",
                () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM));

            
        public static final DeferredItem<Item> HIBIKIDRIVER = ITEMS.register("hibikidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"hibiki",HENSHIN_ONSA ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> IBUKIDRIVER = ITEMS.register("ibukidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ibuki",HENSHIN_ONIBUE_IBUKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> TODOROKIDRIVER = ITEMS.register("todorokidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"todoroki",HENSHIN_KIGEN_TODOROKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> ZANKIDRIVER = ITEMS.register("zankidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zanki",HENSHIN_KIGEN_ZANKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> EIKIDRIVER = ITEMS.register("eikidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"eiki",HENSHIN_ONSA_EIKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> DANKIDRIVER = ITEMS.register("dankidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"danki",HENSHIN_ONSA_DANKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> SABAKIDRIVER = ITEMS.register("sabakidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"sabaki",HENSHIN_KIGEN_SABAKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> SHUKIDRIVER = ITEMS.register("shukidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shuki",HENSHIN_KIGEN_SHUKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> GOUKIDRIVER = ITEMS.register("goukidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"gouki",HENSHIN_ONSA_GOUKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> TOKIDRIVER = ITEMS.register("tokidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"touki",HENSHIN_ONIBUE_TOKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> SHOUKIDRIVER = ITEMS.register("shoukidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shouki",HENSHIN_ONIBUE_SHOUKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> BANKIDRIVER = ITEMS.register("bankidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"banki",HENSHIN_KIGEN_BANKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> AMAKIDRIVER = ITEMS.register("amakidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"amaki",HENSHIN_ONIBUE_AMAKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> KYOSUKEDRIVER = ITEMS.register("kyosukedriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kyoki",HENSHIN_ONSA_KYOKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> KABUKIDRIVER = ITEMS.register("kabukidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kabuki",HENSHIN_ONSA_KABUKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> TOUKIDRIVER = ITEMS.register("toukidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"touki_m",HENSHIN_ONSA_TOUKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> KIRAMEKIDRIVER = ITEMS.register("kiramekidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kirameki",HENSHIN_ONSA_KIRAMEKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> NISHIKIDRIVER = ITEMS.register("nishikidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"nishiki",HENSHIN_ONSA_NISHIKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> HABATAKIDRIVER = ITEMS.register("habatakidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"habataki",HENSHIN_ONSA_HABATAKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> FUBUKIDRIVER = ITEMS.register("fubukidriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"fubuki",HENSHIN_ONIBUE_FUBUKI ,HIBIKIHELMET,HIBIKICHESTPLATE,HIBIKILEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        
        public static final DeferredItem<Item> ONGEKIBO_REKKA = ITEMS.register("ongekibo_rekka",
                () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> ARMED_SABER = ITEMS.register("armed_saber",
                () -> new ArmedSaberItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> ONGEKIBO_YAMASE = ITEMS.register("ongekibo_yamase",
                () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> ONGEKIBO_RAKURAI = ITEMS.register("ongekibo_rakurai",
                () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> ONGEKIBO_SHAKUBYOUSHI = ITEMS.register("ongekibo_shakubyoushi",
                () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> ONGEKIBO_NACHIGURO = ITEMS.register("ongekibo_nachiguro",
                () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> ONGEKIBO_ROKUSHOU = ITEMS.register("ongekibo_rokushou",
                () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> ONGEKIBO_GOURIKI = ITEMS.register("ongekibo_gouriki",
                () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> ONGEKIBO_RESSUI = ITEMS.register("ongekibo_ressui",
                () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
          
        public static final DeferredItem<Item> ONGEKIKAN_REPPUU = ITEMS.register("ongekikan_reppuu",
    		    () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));

        public static final DeferredItem<Item> ONGEKIGEN_RETSURAI = ITEMS.register("ongekigen_retsurai",
                () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> ONGEKI_SHINGEN_RETSUZAN = ITEMS.register("ongeki_shingen_retsuzan",
                () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> ONGEKIGEN_ENMA = ITEMS.register("ongekigen_enma",
                () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> ONGEKIGEN_TOGENKYO = ITEMS.register("ongekigen_togenkyo",
                () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        
        public static final DeferredItem<Item> ECHO_SWORD_ONSAKEN = ITEMS.register("echo_sword_onsaken",
                () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> ONGEKIKANABO_RETTO = ITEMS.register("ongekikanabo_retto",
                () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item>ONGEKISANKAKU_RESSETSU = ITEMS.register("ongekisankaku_ressetsu",
                () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));
        public static final DeferredItem<Item> ONGEKI_SHINCHO_RETSUBAN = ITEMS.register("ongeki_shincho_retsuban",
                () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.HIBIKI_TAB_ITEM).ChangeRepairItem(ONI_ORE.get()));


        public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
	    
	}