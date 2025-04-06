package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.block.machineBlocks.AmazonCellExtractor;
import com.kelco.kamenridercraft.block.machineBlocks.AmazonCellMutator;
import com.kelco.kamenridercraft.block.machineBlocks.KaijinStoneGenerator;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Reboot_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);
	  
		//Amazon
	  	public static final DeferredItem<Item> EMPTY_VIAL = ITEMS.register("empty_vial",
	    		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.Misc_TAB_ITEM));
	    
	    public static final DeferredItem<Item> AMAZON_CELL_VIAL = ITEMS.register("amazon_cell_vial",
	    		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.AMAZONS_TAB_ITEM).AddToList(AmazonCellExtractor.CELL_EXTRACTOR, 5).KeepDifItem(EMPTY_VIAL.get()));
	    
	    public static final DeferredItem<Item> OMEGA_AMAZON_CELL_VIAL = ITEMS.register("omega_amazon_cell_vial",
	    		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.AMAZONS_TAB_ITEM).AddToList(AmazonCellMutator.AMAZON_CELL, 5).KeepDifItem(EMPTY_VIAL.get()));
	    
	    public static final DeferredItem<Item> ALPHA_AMAZON_CELL_VIAL = ITEMS.register("alpha_amazon_cell_vial",
	    		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.AMAZONS_TAB_ITEM).AddToList(AmazonCellMutator.AMAZON_CELL, 5).KeepDifItem(EMPTY_VIAL.get()));

	    public static final DeferredItem<Item> SIGMA_AMAZON_CELL_VIAL = ITEMS.register("sigma_amazon_cell_vial",
	    		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.AMAZONS_TAB_ITEM).AddToList(AmazonCellMutator.AMAZON_CELL, 2).KeepDifItem(EMPTY_VIAL.get()));
	    
	    public static final DeferredItem<Item> NEO_AMAZON_CELL_VIAL = ITEMS.register("neo_amazon_cell_vial",
	    		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.AMAZONS_TAB_ITEM).AddToList(AmazonCellMutator.AMAZON_CELL, 1).KeepDifItem(EMPTY_VIAL.get()));
	    
	    public static final DeferredItem<Item> CONDORER_CORE_ALPHA = ITEMS.register("condorer_core_alpha",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"","amazon_alpha","amazons_driver_alpha_belt",
	            		new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false)
						,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,200, 1,true,false)
	            		,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
						,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
	            .AddToList(RiderTabs.AMAZONS_TAB_ITEM));
	 
	    public static final DeferredItem<Item> CONDORER_CORE_ALPHA_BLIND = ITEMS.register("condorer_core_alpha_blind",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"_blind","amazon_alpha","amazons_driver_alpha_belt",
	            		new MobEffectInstance(Effect_core.PUNCH, 40, 6,true,false)
						,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,200, 2,true,false)
	            		,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
						,new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)
	            		,new MobEffectInstance(MobEffects.BLINDNESS, 40, 0,true,false))
	            .AddToList(RiderTabs.AMAZONS_TAB_ITEM));
	
	    public static final DeferredItem<Item> CONDORER_CORE_OMEGA = ITEMS.register("condorer_core_omega",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"","amazon_omega","amazons_driver_omega_belt",
	            		new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false)
						,new MobEffectInstance(MobEffects.REGENERATION,200, 1,true,false)
	            		,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
						,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
	            .AddToList(RiderTabs.AMAZONS_TAB_ITEM));
	 
	    public static final DeferredItem<Item> CONDORER_CORE_SIGMA = ITEMS.register("condorer_core_sigma",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"","amazon_sigma","amazons_driver_sigma_belt",
	            		new MobEffectInstance(Effect_core.PUNCH, 40, 6,true,false)
						,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,200, 1,true,false)
	            		,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
						,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
	            .AddToList(RiderTabs.AMAZONS_TAB_ITEM));
	 
	    public static final DeferredItem<Item> AMAZON_INJECTOR_NEO = ITEMS.register("amazon_injector_neo",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"","amazon_neo","neo_amazons_driver_neo_belt",
	            		new MobEffectInstance(Effect_core.PUNCH, 40, 6,true,false)
						,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,200, 1,true,false)
	            		,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
						,new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)
	            		,new MobEffectInstance(MobEffects.REGENERATION,200, 1,true,false))
	            .AddToList(RiderTabs.AMAZONS_TAB_ITEM));
	 
	    public static final DeferredItem<Item> AMAZON_INJECTOR_NEW_OMEGA = ITEMS.register("amazon_injector_new_omega",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"","amazon_alpha","neo_amazons_driver_omega_belt",
	             		new MobEffectInstance(Effect_core.PUNCH, 40, 7,true,false)
						,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,200, 1,true,false)
	            		,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
						,new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)
	            		,new MobEffectInstance(MobEffects.REGENERATION,200, 2,true,false))
	            .AddToList(RiderTabs.AMAZONS_TAB_ITEM));
	 
	    public static final DeferredItem<Item> AMAZON_INJECTOR_NEO_ALPHA = ITEMS.register("amazon_injector_neo_alpha",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"","amazon_neo_alpha","neo_amazons_driver_neo_belt",
	            		new MobEffectInstance(Effect_core.PUNCH, 40, 7,true,false)
						,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,200, 1,true,false)
	            		,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
						,new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)
	            		,new MobEffectInstance(MobEffects.REGENERATION,200, 2,true,false))
	            .AddToList(RiderTabs.AMAZONS_TAB_ITEM));
	 
	    
	    public static final DeferredItem<Item> AMAZONSHELMET = ITEMS.register("amazonshead",
	            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.AMAZONS_TAB_ITEM));
	    public static final DeferredItem<Item> AMAZONSCHESTPLATE = ITEMS.register("amazonstroso",
	            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.AMAZONS_TAB_ITEM));
	    public static final DeferredItem<Item> AMAZONSLEGGINGS = ITEMS.register("amazonslegs",
	            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.AMAZONS_TAB_ITEM));

	    public static final DeferredItem<Item> AMAZONS_DRIVER_ALPHA = ITEMS.register("amazons_driver_alpha",
		           () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"amazon_alpha",CONDORER_CORE_ALPHA ,AMAZONSHELMET,AMAZONSCHESTPLATE,AMAZONSLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.AMAZONS_TAB_ITEM));

	    public static final DeferredItem<Item> AMAZONS_DRIVER_OMEGA = ITEMS.register("amazons_driver_omega",
		           () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"amazon_omega",CONDORER_CORE_OMEGA ,AMAZONSHELMET,AMAZONSCHESTPLATE,AMAZONSLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.AMAZONS_TAB_ITEM));

	    public static final DeferredItem<Item> AMAZONS_DRIVER_SIGMA = ITEMS.register("amazons_driver_sigma",
		           () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"amazon_sigma",CONDORER_CORE_SIGMA ,AMAZONSHELMET,AMAZONSCHESTPLATE,AMAZONSLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.AMAZONS_TAB_ITEM));

	    public static final DeferredItem<Item> NEO_AMAZONS_DRIVER_OMEGA = ITEMS.register("neo_amazons_driver_omega",
		           () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"amazon_new_omega",AMAZON_INJECTOR_NEW_OMEGA ,AMAZONSHELMET,AMAZONSCHESTPLATE,AMAZONSLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.AMAZONS_TAB_ITEM));

	    public static final DeferredItem<Item> NEO_AMAZONS_DRIVER_NEO = ITEMS.register("neo_amazons_driver_neo",
		           () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"amazon_neo",AMAZON_INJECTOR_NEO ,AMAZONSHELMET,AMAZONSCHESTPLATE,AMAZONSLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.AMAZONS_TAB_ITEM));

	    public static final DeferredItem<Item> NEO_AMAZONS_DRIVER_NEO_ALPHA = ITEMS.register("neo_amazons_driver_neo_alpha",
		           () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"amazon_neo_alpha",AMAZON_INJECTOR_NEO_ALPHA ,AMAZONSHELMET,AMAZONSCHESTPLATE,AMAZONSLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.AMAZONS_TAB_ITEM));

	    
	    // BLack Sun
	    
	    public static final DeferredItem<Item> KAIJIN_STONE = ITEMS.register("kaijin_stone",
	    		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLACK_SUN_TAB_ITEM).AddToList(KaijinStoneGenerator.KING_STONE, 20));
	    
	    public static final DeferredItem<Item> CREATION_KING_EXTRACT_VIAL = ITEMS.register("creation_king_extract_vial",
	    		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.BLACK_SUN_TAB_ITEM).KeepDifItem(EMPTY_VIAL.get()));
	    
		public static final DeferredItem<Item> HEAT_HEAVEN = ITEMS.register("heat_heaven",
				() -> new BaseItem(new Item.Properties().food(Foods.CARROT)).AddToList(RiderTabs.BLACK_SUN_TAB_ITEM));
		
		
		public static final DeferredItem<Item> KING_STONE_SUN = ITEMS.register("king_stone_sun",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"","black_sun","century_king_sun_driver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
						,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
	            		,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
						,new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
						.IsBeltGlowing().AddToList(RiderTabs.BLACK_SUN_TAB_ITEM).AddToList(KaijinStoneGenerator.KING_STONE, 10));

	    public static final DeferredItem<Item> GLOWING_KING_STONE_SUN = ITEMS.register("glowing_king_stone_sun",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"_revived","black_sun","century_king_sun_driver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
						,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
	            		,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
						,new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
						.IsBeltGlowing().IsGlowing().AddToList(RiderTabs.BLACK_SUN_TAB_ITEM).AddToList(KaijinStoneGenerator.KING_STONE, 1));

	    public static final DeferredItem<Item> KING_STONE_MOON = ITEMS.register("king_stone_moon",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"","shadowmoon","century_king_moon_driver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
						,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
	            		,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
	            .AddToList(RiderTabs.BLACK_SUN_TAB_ITEM).AddToList(KaijinStoneGenerator.KING_STONE, 5));
	
	    public static final DeferredItem<Item> GLOWING_KING_STONE_MOON = ITEMS.register("glowing_king_stone_moon",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"_revived","shadowmoon","century_king_moon_driver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
						,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
	            		,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
	            .IsBeltGlowing().IsGlowing().AddToList(RiderTabs.BLACK_SUN_TAB_ITEM).AddToList(KaijinStoneGenerator.KING_STONE, 1));

	    
	    public static final DeferredItem<Item> BLACKSUNHELMET = ITEMS.register("blacksunhead",
	            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.BLACK_SUN_TAB_ITEM));
	    public static final DeferredItem<Item> BLACKSUNCHESTPLATE = ITEMS.register("blacksuntroso",
	            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.BLACK_SUN_TAB_ITEM));
	    public static final DeferredItem<Item> BLACKSUNLEGGINGS = ITEMS.register("blacksunlegs",
	            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BLACK_SUN_TAB_ITEM));
	    

	    public static final DeferredItem<Item> CENTURY_KING_SUN_DRIVER = ITEMS.register("century_king_sun_driver",
		           () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"black_sun",KING_STONE_SUN ,BLACKSUNHELMET,BLACKSUNCHESTPLATE,BLACKSUNLEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.BLACK_SUN_TAB_ITEM));

	    public static final DeferredItem<Item> CENTURY_KING_MOON_DRIVER = ITEMS.register("century_king_moon_driver",
		           () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shadowmoon",KING_STONE_MOON ,BLACKSUNHELMET,BLACKSUNCHESTPLATE,BLACKSUNLEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.BLACK_SUN_TAB_ITEM));

	    public static final DeferredItem<Item> CENTURY_KING_BLACK_BLADE = ITEMS.register("century_king_black_blade",
	            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BLACK_SUN_TAB_ITEM));
	    public static final DeferredItem<Item> CENTURY_KING_SHADOW_BLADE = ITEMS.register("century_king_shadow_blade",
	            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BLACK_SUN_TAB_ITEM));
	    public static final DeferredItem<Item> SATANSABRE = ITEMS.register("satansabre",
	            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BLACK_SUN_TAB_ITEM));



	public static final DeferredItem<Item> SHIN_TYPHOON_CORE = ITEMS.register("shin_typhoon_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","shin_ichigo","shin_typhoon_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.has_basic_model().AddToList(RiderTabs.SHIN_ICHIGO_TAB_ITEM));

	public static final DeferredItem<Item> SHIN_TYPHOON_CORE_2 = ITEMS.register("shin_typhoon_core2",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","shin_nigo","shin_typhoon_belt2",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.has_basic_model().model_has_different_name("shin_typhoon_core").AddToList(RiderTabs.SHIN_ICHIGO_TAB_ITEM));

	public static final DeferredItem<Item> SHIN_TYPHOON_CORE_2_1 = ITEMS.register("shin_typhoon_core_2_1",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","shin_2_1","shin_typhoon_belt2",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.has_basic_model().model_has_different_name("shin_typhoon_core").AddToList(RiderTabs.SHIN_ICHIGO_TAB_ITEM));

	public static final DeferredItem<Item> SHIN_ICHIGO_HELMET = ITEMS.register("shin_ichigohead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1))
					.has_basic_model().AddToTabList(RiderTabs.SHIN_ICHIGO_TAB_ITEM));

	public static final DeferredItem<Item> SHIN_ICHIGO_CHESTPLATE = ITEMS.register("shin_ichigotroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1))
					.has_basic_model().AddToTabList(RiderTabs.SHIN_ICHIGO_TAB_ITEM));

	public static final DeferredItem<Item> SHIN_ICHIGO_LEGGINGS = ITEMS.register("shin_ichigolegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1))
					.has_basic_model().AddToTabList(RiderTabs.SHIN_ICHIGO_TAB_ITEM));


	public static final DeferredItem<Item> TYPHOON_1 = ITEMS.register("shin_typhoon_ichigo",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shin_ichigo", SHIN_TYPHOON_CORE,SHIN_ICHIGO_HELMET, SHIN_ICHIGO_CHESTPLATE,SHIN_ICHIGO_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().has_basic_model().AddToTabList(RiderTabs.SHIN_ICHIGO_TAB_ITEM));

	public static final DeferredItem<Item> TYPHOON_2 = ITEMS.register("shin_typhoon_nigo",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shin_nigo", SHIN_TYPHOON_CORE_2,SHIN_ICHIGO_HELMET, SHIN_ICHIGO_CHESTPLATE,SHIN_ICHIGO_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().has_basic_model().AddToTabList(RiderTabs.SHIN_ICHIGO_TAB_ITEM));

	public static final DeferredItem<Item> TYPHOON_2_1 = ITEMS.register("shin_typhoon_2_1",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shin_2_1", SHIN_TYPHOON_CORE_2_1,SHIN_ICHIGO_HELMET, SHIN_ICHIGO_CHESTPLATE,SHIN_ICHIGO_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().has_basic_model().AddToTabList(RiderTabs.SHIN_ICHIGO_TAB_ITEM));


	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}

	}