package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.ryuki.AdventCardItem;
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

public class Ryuki_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> RYUKI_LOGO = ITEMS.register("ryuki_logo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.RYUKI_TAB_ITEM));

	public static final DeferredItem<Item> ADVENT_CARD = ITEMS.register("advent_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_blank","ryuki","v_buckle_belt",
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false)).AddCompatibilityList(new String[] {"ouja","knight"}).AddToList(RiderTabs.RYUKI_TAB_ITEM));

	public static final DeferredItem<Item> DRAGREDER_ADVENT = ITEMS.register("dragreder_advent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","ryuki","v_buckle_belt_ryuki",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
			.AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
	public static final DeferredItem<Item> DARKWING_ADVENT = ITEMS.register("darkwing_advent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","knight","v_buckle_belt_knight",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	
	public static final DeferredItem<Item> VOLCANCER_ADVENT = ITEMS.register("volcancer_advent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","scissors","v_buckle_belt_scissors",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
	public static final DeferredItem<Item> MAGNUGIGA_ADVENT = ITEMS.register("magnugiga_advent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","zolda","v_buckle_belt_zolda",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
	public static final DeferredItem<Item> EVILDIVER_ADVENT = ITEMS.register("evildiver_advent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","raia","v_buckle_belt_raia",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
	public static final DeferredItem<Item> METALGELAS_ADVENT = ITEMS.register("metalgelas_advent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","gai","v_buckle_belt_gai",
					new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
	public static final DeferredItem<Item> VENOSNAKER_ADVENT = ITEMS.register("venosnaker_advent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","ouja","v_buckle_belt_ouja",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
	public static final DeferredItem<Item> GOLDPHOENIX_ADVENT = ITEMS.register("goldphoenix_advent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","odin","v_buckle_belt_odin",
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance (MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
	public static final DeferredItem<Item> DESTWILDER_ADVENT = ITEMS.register("destwilder_advent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","tiger","v_buckle_belt_tiger",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
	public static final DeferredItem<Item> GIGAZELLE_ADVENT = ITEMS.register("gigazelle_advent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","imperer","v_buckle_belt_imperer",
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
	public static final DeferredItem<Item> BLANCWING_ADVENT = ITEMS.register("blancwing_advent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","femme","v_buckle_belt_femme",
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
	public static final DeferredItem<Item> DRAGBLACKER_ADVENT = ITEMS.register("dragblacker_advent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","ryuga","v_buckle_belt_ryuga",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
			.AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
	public static final DeferredItem<Item> BIOGREEZA_ADVENT = ITEMS.register("biogreeza_advent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","verde","v_buckle_belt_verde",
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
	public static final DeferredItem<Item> ABYSSLASHER_ADVENT = ITEMS.register("abysslasher_advent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","abyss","v_buckle_belt_abyss",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
	public static final DeferredItem<Item> PSYCOROGUE_ADVENT = ITEMS.register("psycorogue_advent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","alternative","v_buckle_alternative_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
	public static final DeferredItem<Item> SURVIVE_REKKA_RYUGA = ITEMS.register("survive_rekka_ryuga",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_survive","ryuga","v_buckle_belt_ryuga_s",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false))
			);

	public static final DeferredItem<Item> SURVIVE_REKKA = ITEMS.register("survive_rekka",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_survive","ryuki","v_buckle_belt_ryuki_s",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)).addAlternative(SURVIVE_REKKA_RYUGA.get())
			.AddToList(RiderTabs.RYUKI_TAB_ITEM));


	public static final DeferredItem<Item> SURVIVE_SHIPPU_RAIA = ITEMS.register("survive_shippu_raia",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_survive","raia","v_buckle_belt_raia_s",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)));

	public static final DeferredItem<Item> SURVIVE_SHIPPU_OUJA = ITEMS.register("survive_shippu_ouja",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_survive","ouja","v_buckle_belt_ouja",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)).addAlternative(SURVIVE_SHIPPU_RAIA.get()));
	  
	public static final DeferredItem<Item> SURVIVE_SHIPPU = ITEMS.register("survive_shippu",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_survive","knight","v_buckle_belt_knight_s",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)).addAlternative(SURVIVE_SHIPPU_OUJA.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));

	public static final DeferredItem<Item> SURVIVE_MUGEN = ITEMS.register("survive_mugen",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_survive_mugen","ouja","v_buckle_belt_ouja_s",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
	public static final DeferredItem<Item> SURVIVE_BLACK = ITEMS.register("survive_black",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_survive_black","ryuki","v_buckle_belt_ryuki",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false))
			.AddToList(RiderTabs.RYUKI_TAB_ITEM));

	  
	public static final DeferredItem<Item> RYUKIHELMET = ITEMS.register("ryukihead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	public static final DeferredItem<Item> RYUKICHESTPLATE = ITEMS.register("ryukitroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	public static final DeferredItem<Item> RYUKILEGGINGS = ITEMS.register("ryukilegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));

	public static final DeferredItem<Item> RYUKIDRIVER = ITEMS.register("v_buckle_ryuki",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ryuki",DRAGREDER_ADVENT ,RYUKIHELMET,RYUKICHESTPLATE,RYUKILEGGINGS , new Item.Properties())
			.ChangeRepairItem(ADVENT_CARD.get()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM));

	public static final DeferredItem<Item> KNIGHTDRIVER = ITEMS.register("v_buckle_knight",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"knight",DARKWING_ADVENT ,RYUKIHELMET,RYUKICHESTPLATE,RYUKILEGGINGS , new Item.Properties())
			.ChangeRepairItem(ADVENT_CARD.get()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM));
	
	public static final DeferredItem<Item> SCISSORSDRIVER = ITEMS.register("v_buckle_scissors",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"scissors",VOLCANCER_ADVENT ,RYUKIHELMET,RYUKICHESTPLATE,RYUKILEGGINGS , new Item.Properties())
			.ChangeRepairItem(ADVENT_CARD.get()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM));
	
	public static final DeferredItem<Item> ZOLDADRIVER = ITEMS.register("v_buckle_zolda",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zolda",MAGNUGIGA_ADVENT ,RYUKIHELMET,RYUKICHESTPLATE,RYUKILEGGINGS , new Item.Properties())
			.ChangeRepairItem(ADVENT_CARD.get()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM));
	
	public static final DeferredItem<Item> RAIADRIVER = ITEMS.register("v_buckle_raia",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"raia",EVILDIVER_ADVENT ,RYUKIHELMET,RYUKICHESTPLATE,RYUKILEGGINGS , new Item.Properties())
			.ChangeRepairItem(ADVENT_CARD.get()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM));
	
	public static final DeferredItem<Item> GAIDRIVER = ITEMS.register("v_buckle_gai",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"gai",METALGELAS_ADVENT ,RYUKIHELMET,RYUKICHESTPLATE,RYUKILEGGINGS , new Item.Properties())
			.ChangeRepairItem(ADVENT_CARD.get()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM));
	
	public static final DeferredItem<Item> OUJADRIVER = ITEMS.register("v_buckle_ouja",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ouja",VENOSNAKER_ADVENT ,RYUKIHELMET,RYUKICHESTPLATE,RYUKILEGGINGS , new Item.Properties())
			.ChangeRepairItem(ADVENT_CARD.get()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM));
	
	public static final DeferredItem<Item> ODINDRIVER = ITEMS.register("v_buckle_odin",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"odin",GOLDPHOENIX_ADVENT ,RYUKIHELMET,RYUKICHESTPLATE,RYUKILEGGINGS , new Item.Properties())
			.ChangeRepairItem(ADVENT_CARD.get()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM));
	
	public static final DeferredItem<Item> TIGERDRIVER = ITEMS.register("v_buckle_tiger",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"tiger",DESTWILDER_ADVENT ,RYUKIHELMET,RYUKICHESTPLATE,RYUKILEGGINGS , new Item.Properties())
			.ChangeRepairItem(ADVENT_CARD.get()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM));
	
	public static final DeferredItem<Item> IMPERERDRIVER = ITEMS.register("v_buckle_imperer",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"imperer",GIGAZELLE_ADVENT ,RYUKIHELMET,RYUKICHESTPLATE,RYUKILEGGINGS , new Item.Properties())
			.ChangeRepairItem(ADVENT_CARD.get()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM));
	
	public static final DeferredItem<Item> FEMMEDRIVER = ITEMS.register("v_buckle_femme",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"femme",BLANCWING_ADVENT ,RYUKIHELMET,RYUKICHESTPLATE,RYUKILEGGINGS , new Item.Properties())
			.ChangeRepairItem(ADVENT_CARD.get()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM));
	
	public static final DeferredItem<Item> RYUGADRIVER = ITEMS.register("v_buckle_ryuga",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ryuga",DRAGBLACKER_ADVENT ,RYUKIHELMET,RYUKICHESTPLATE,RYUKILEGGINGS , new Item.Properties())
			.ChangeRepairItem(ADVENT_CARD.get()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM));
	
	public static final DeferredItem<Item> VERDEDRIVER = ITEMS.register("v_buckle_verde",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"verde",BIOGREEZA_ADVENT ,RYUKIHELMET,RYUKICHESTPLATE,RYUKILEGGINGS , new Item.Properties())
			.ChangeRepairItem(ADVENT_CARD.get()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM));
	
	public static final DeferredItem<Item> ABYSSDRIVER = ITEMS.register("v_buckle_abyss",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"abyss",ABYSSLASHER_ADVENT ,RYUKIHELMET,RYUKICHESTPLATE,RYUKILEGGINGS , new Item.Properties())
			.ChangeRepairItem(ADVENT_CARD.get()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM));
	
	public static final DeferredItem<Item> ALTERNATIVEDRIVER = ITEMS.register("alternative_v_buckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"alternative",PSYCOROGUE_ADVENT ,RYUKIHELMET,RYUKICHESTPLATE,RYUKILEGGINGS , new Item.Properties())
			.ChangeRepairItem(ADVENT_CARD.get()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM));
	
	public static final DeferredItem<Item> ALTERNATIVEZERODRIVER = ITEMS.register("alternative_zero_v_buckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"alternative_zero",PSYCOROGUE_ADVENT ,RYUKIHELMET,RYUKICHESTPLATE,RYUKILEGGINGS , new Item.Properties())
			.ChangeRepairItem(ADVENT_CARD.get()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM));

	
	public static final DeferredItem<Item> RIDE_VISOR = ITEMS.register("ride_visor",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	
    public static final DeferredItem<Item> RIDE_SABER = ITEMS.register("ride_saber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 1, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> DRAG_VISOR = ITEMS.register("drag_visor",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> DRAG_SABER = ITEMS.register("drag_saber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> DRAG_CLAW = ITEMS.register("drag_claw",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).setProjectileFireball().AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
        	
	public static final DeferredItem<Item> DRAG_SHIELD = ITEMS.register("drag_shield",
            () -> new BaseShieldItem(new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem( ADVENT_CARD.get()));
    
    public static final DeferredItem<Item> DRAG_VISOR_ZWEI = ITEMS.register("drag_visor_zwei",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).setProjectileLargeFireball(1).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> DRAG_BLADE = ITEMS.register("drag_blade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 11, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> DARK_VISOR = ITEMS.register("dark_visor",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> WING_LANCER = ITEMS.register("wing_lancer",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -3F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> DARK_BLADE = ITEMS.register("dark_blade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 11, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> DARK_SHIELD = ITEMS.register("dark_visor_zwei",
            () -> new BaseShieldItem(new Item.Properties()).AddToTabList(KamenRiderCraftCore.DARK_SHIELD_ITEM).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> DARK_ARROW = ITEMS.register("dark_arrow",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 11, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> SCISSORS_VISOR = ITEMS.register("scissors_visor",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> SCISSORS_PINCH = ITEMS.register("scissors_pinch",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -3F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> SHELL_DEFENSE = ITEMS.register("shell_defense",
            () -> new BaseShieldItem(new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> MAGNA_VISOR = ITEMS.register("magna_visor",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> GIGA_HORN = ITEMS.register("giga_horn",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -3F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> GIGA_LAUNCHER = ITEMS.register("giga_launcher",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -3F, new Item.Properties()).setProjectileLargeFireball(3).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> GIGA_ARMOR = ITEMS.register("giga_armor",
            () -> new BaseShieldItem(new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> EVIL_VISOR = ITEMS.register("evil_visor",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> EVIL_WHIP = ITEMS.register("evil_whip",
            () -> new BaseSwordItem(Tiers.DIAMOND, 2, -2F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> EVIL_VISOR_ZWEI = ITEMS.register("evil_visor_zwei",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> METAL_VISOR = ITEMS.register("metal_visor",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> METAL_HORN = ITEMS.register("metal_horn",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -3.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> VENO_VISOR = ITEMS.register("veno_visor",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -3F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> VENO_SABER = ITEMS.register("veno_saber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> VENO_VISOR_ZWEI = ITEMS.register("veno_visor_zwei",
            () -> new BaseSwordItem(Tiers.DIAMOND, 14, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> GOLD_VISOR = ITEMS.register("gold_visor",
            () -> new BaseSwordItem(Tiers.DIAMOND, 10, -3F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> GOLD_SABER = ITEMS.register("gold_saber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> GOLD_SHIELD = ITEMS.register("gold_shield",
            () -> new BaseShieldItem(new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> DEST_VISOR = ITEMS.register("dest_visor",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> DEST_CLAW = ITEMS.register("dest_claw",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.6F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> DEST_CLAW1 = ITEMS.register("dest_claw1",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.6F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> GAZELLE_VISOR = ITEMS.register("gazelle_visor",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> GAZELLE_STAB = ITEMS.register("gazelle_stab",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> BLANC_VISOR = ITEMS.register("blanc_visor",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> WING_SLASHER = ITEMS.register("wing_slasher",
            () -> new BaseSwordItem(Tiers.DIAMOND,  6, -3F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> WING_SHIELD = ITEMS.register("wing_shield",
            () -> new BaseShieldItem(new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> BLACK_DRAG_VISOR = ITEMS.register("black_drag_visor",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> DRAG_SABER_RYUGA = ITEMS.register("drag_saber_ryuga",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> DRAG_CLAW_RYUGA = ITEMS.register("drag_claw_ryuga",
    	    () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).setProjectileFireball().AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
	public static final DeferredItem<Item> DRAG_SHIELD_RYUGA = ITEMS.register("drag_shield_ryuga",
            () -> new BaseShieldItem(new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem( ADVENT_CARD.get()));
    
    public static final DeferredItem<Item> BLACK_DRAG_VISOR_ZWEI = ITEMS.register("black_drag_visor_zwei",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 14, -2.4F, new Item.Properties()).setProjectileLargeFireball(1).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> BIO_VISOR = ITEMS.register("bio_visor",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> BIO_WINDER = ITEMS.register("bio_winder",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> SLASH_VISOR = ITEMS.register("slash_visor",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> SLASH_DAGGER = ITEMS.register("slash_dagger",
            () -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> ABYSS_VISOR = ITEMS.register("abyss_visor",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> ABYSS_SABER = ITEMS.register("abyss_saber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
    
    public static final DeferredItem<Item> ABYSS_CLAW = ITEMS.register("abyss_claw",
            () -> new BaseSwordItem(Tiers.DIAMOND, 7, -3F, new Item.Properties()).AddToTabList(RiderTabs.RYUKI_TAB_ITEM).ChangeRepairItem(ADVENT_CARD.get()));
	
    public static final DeferredItem<Item> RIDE_SABER_VENT = ITEMS.register("ride_saber_vent",
			() -> new AdventCardItem(new Item.Properties(), "ryuki", RIDE_VISOR.get(), RIDE_SABER.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> DRAG_SABER_VENT = ITEMS.register("drag_saber_vent",
			() -> new AdventCardItem(new Item.Properties(), "ryuki", DRAG_VISOR.get(), DRAG_SABER.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> DRAG_CLAW_VENT = ITEMS.register("drag_claw_vent",
			() -> new AdventCardItem(new Item.Properties(), "ryuki", DRAG_VISOR.get(), DRAG_CLAW.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> DRAG_SHIELD_VENT = ITEMS.register("drag_shield_vent",
			() -> new AdventCardItem(new Item.Properties(), "ryuki", DRAG_VISOR.get(), DRAG_SHIELD.get(), DRAG_SHIELD.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> DRAG_SHIELD_VENT_FORM = ITEMS.register("drag_shield_vent_form",
    		() -> new RiderFormChangeItem(new Item.Properties(),0,"_drag_shield","ryuki","v_buckle_belt_ryuki",
    				new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
    				new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
    				new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
    				new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
    		.AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
    public static final DeferredItem<Item> DRAG_VISOR_ZWEI_VENT = ITEMS.register("drag_visor_zwei_vent",
			() -> new AdventCardItem(new Item.Properties(), "ryuki", DRAG_VISOR.get(), DRAG_VISOR_ZWEI.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> DRAG_BLADE_VENT = ITEMS.register("drag_blade_vent",
			() -> new AdventCardItem(new Item.Properties(), "ryuki", DRAG_VISOR.get(), DRAG_BLADE.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));

    public static final DeferredItem<Item> RYUKI_TRICK_VENT = ITEMS.register("ryuki_trick_vent",
			() -> new AdventCardItem(new Item.Properties(), "ryuki", DRAG_VISOR.get(), "trick_vent").AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> WING_LANCER_VENT = ITEMS.register("wing_lancer_vent",
			() -> new AdventCardItem(new Item.Properties(), "knight", DARK_VISOR.get(), WING_LANCER.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> WING_WALL_VENT = ITEMS.register("wing_wall_vent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_wing_wall","knight","v_buckle_belt_knight",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
			.AddToList(RiderTabs.RYUKI_TAB_ITEM));

    public static final DeferredItem<Item> KNIGHT_TRICK_VENT = ITEMS.register("knight_trick_vent",
			() -> new AdventCardItem(new Item.Properties(), "knight", DARK_VISOR.get(), "trick_vent_knight").AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
    public static final DeferredItem<Item> DARK_BLADE_VENT = ITEMS.register("dark_blade_vent",
			() -> new AdventCardItem(new Item.Properties(), "knight", DARK_VISOR.get(), DARK_BLADE.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> DARK_VISOR_ZWEI_VENT = ITEMS.register("dark_visor_zwei_vent",
			() -> new AdventCardItem(new Item.Properties(), "knight", DARK_VISOR.get(), DARK_SHIELD.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> DARK_ARROW_VENT = ITEMS.register("dark_arrow_vent",
			() -> new AdventCardItem(new Item.Properties(), "knight", DARK_VISOR.get(), DARK_ARROW.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> SCISSORS_PINCH_VENT = ITEMS.register("scissors_pinch_vent",
			() -> new AdventCardItem(new Item.Properties(), "scissors", SCISSORS_VISOR.get(), SCISSORS_PINCH.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> SHELL_DEFENSE_VENT = ITEMS.register("shell_defense_vent",
			() -> new AdventCardItem(new Item.Properties(), "scissors", SCISSORS_VISOR.get(), SHELL_DEFENSE.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> GIGA_HORN_VENT = ITEMS.register("giga_horn_vent",
			() -> new AdventCardItem(new Item.Properties(), "zolda", MAGNA_VISOR.get(), GIGA_HORN.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> GIGA_LAUNCHER_VENT = ITEMS.register("giga_launcher_vent",
			() -> new AdventCardItem(new Item.Properties(), "zolda", MAGNA_VISOR.get(), GIGA_LAUNCHER.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> GIGA_CANNON_VENT = ITEMS.register("giga_cannon_vent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_giga_cannon","zolda","v_buckle_belt_zolda",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
			.AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> GIGA_ARMOR_VENT = ITEMS.register("giga_armor_vent",
			() -> new AdventCardItem(new Item.Properties(), "zolda", MAGNA_VISOR.get(), GIGA_ARMOR.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	  
	public static final DeferredItem<Item> GIGA_TECTOR_VENT = ITEMS.register("giga_tector_vent",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_giga_tector","zolda","v_buckle_belt_zolda",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> EVIL_WHIP_VENT = ITEMS.register("evil_whip_vent",
			() -> new AdventCardItem(new Item.Properties(), "raia", EVIL_VISOR.get(), EVIL_WHIP.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> EVIL_VISOR_ZWEI_VENT = ITEMS.register("evil_visor_zwei_vent",
			() -> new AdventCardItem(new Item.Properties(), "raia", EVIL_VISOR.get(), EVIL_VISOR_ZWEI.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> METAL_HORN_VENT = ITEMS.register("metal_horn_vent",
			() -> new AdventCardItem(new Item.Properties(), "gai", METAL_VISOR.get(), METAL_HORN.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> VENO_SABER_VENT = ITEMS.register("veno_saber_vent",
			() -> new AdventCardItem(new Item.Properties(), "ouja", VENO_VISOR.get(), VENO_SABER.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> VENO_VISOR_ZWEI_VENT = ITEMS.register("veno_visor_zwei_vent",
			() -> new AdventCardItem(new Item.Properties(), "ouja", VENO_VISOR.get(), VENO_VISOR_ZWEI.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> GOLD_SABER_VENT = ITEMS.register("gold_saber_vent",
			() -> new AdventCardItem(new Item.Properties(), "odin", GOLD_VISOR.get(), GOLD_SABER.get(), GOLD_SABER.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> GOLD_SHIELD_VENT = ITEMS.register("gold_shield_vent",
			() -> new AdventCardItem(new Item.Properties(), "odin", GOLD_VISOR.get(), GOLD_SHIELD.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> DEST_CLAW_VENT = ITEMS.register("dest_claw_vent",
			() -> new AdventCardItem(new Item.Properties(), "tiger", DEST_VISOR.get(), DEST_CLAW.get(), DEST_CLAW1.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> GAZELLE_STAB_VENT = ITEMS.register("gazelle_stab_vent",
			() -> new AdventCardItem(new Item.Properties(), "imperer", GAZELLE_VISOR.get(), GAZELLE_STAB.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> WING_SLASHER_VENT = ITEMS.register("wing_slasher_vent",
			() -> new AdventCardItem(new Item.Properties(), "femme", BLANC_VISOR.get(), WING_SLASHER.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> WING_SHIELD_VENT = ITEMS.register("wing_shield_vent",
			() -> new AdventCardItem(new Item.Properties(), "femme", BLANC_VISOR.get(), WING_SHIELD.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> DRAG_SABER_VENT_RYUGA = ITEMS.register("drag_saber_vent_ryuga",
			() -> new AdventCardItem(new Item.Properties(), "ryuga", BLACK_DRAG_VISOR.get(), DRAG_SABER_RYUGA.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> DRAG_CLAW_VENT_RYUGA = ITEMS.register("drag_claw_vent_ryuga",
			() -> new AdventCardItem(new Item.Properties(), "ryuga", BLACK_DRAG_VISOR.get(), DRAG_CLAW_RYUGA.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> DRAG_SHIELD_VENT_RYUGA = ITEMS.register("drag_shield_vent_ryuga",
			() -> new AdventCardItem(new Item.Properties(), "ryuga", BLACK_DRAG_VISOR.get(), DRAG_SHIELD_RYUGA.get(), DRAG_SHIELD_RYUGA.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	   
	public static final DeferredItem<Item> DRAG_SHIELD_VENT_FORM_RYUGA = ITEMS.register("drag_shield_vent_form_ryuga",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_drag_shield","ryuga","v_buckle_belt_ryuga",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
			.AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> BLACK_DRAG_VISOR_ZWEI_VENT = ITEMS.register("black_drag_visor_zwei_vent",
			() -> new AdventCardItem(new Item.Properties(), "ryuga", BLACK_DRAG_VISOR.get(), BLACK_DRAG_VISOR_ZWEI.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> BIO_WINDER_VENT = ITEMS.register("bio_winder_vent",
			() -> new AdventCardItem(new Item.Properties(), "verde", BIO_VISOR.get(), BIO_WINDER.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> SLASH_DAGGER_VENT = ITEMS.register("slash_dagger_vent",
			() -> new AdventCardItem(new Item.Properties(), "alternative", SLASH_VISOR.get(), SLASH_DAGGER.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> ABYSS_SABER_VENT = ITEMS.register("abyss_saber_vent",
			() -> new AdventCardItem(new Item.Properties(), "abyss", ABYSS_VISOR.get(), ABYSS_SABER.get(), ABYSS_SABER.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
    
    public static final DeferredItem<Item> ABYSS_CLAW_VENT = ITEMS.register("abyss_claw_vent",
			() -> new AdventCardItem(new Item.Properties(), "abyss", ABYSS_VISOR.get(), ABYSS_CLAW.get()).AddToList(RiderTabs.RYUKI_TAB_ITEM));
	
	
     /**
	abyssmash
	**/
	 public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
