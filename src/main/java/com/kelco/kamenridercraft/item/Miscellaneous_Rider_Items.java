package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;

import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Miscellaneous_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    //tojima wants to be a kamen rider
    public static final DeferredItem<Item> ICHIGO_MASK = ITEMS.register("ichigo_mask",
            () -> new MaskItem(new Item.Properties().stacksTo(1)).AddToList(RiderTabs.Misc_TAB_ITEM));


    //G
	    public static final DeferredItem<Item> G_LOGO = ITEMS.register("g_logo",
	    		() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/g")), new Item.Properties()).AddToList(RiderTabs.G_TAB_ITEM));

	    public static final DeferredItem<Item> GORO_WINE_BOTTLE = ITEMS.register("goro_wine_bottle",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"","kamen_rider_g","g_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
						,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
	            		,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
						,new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false)){
                    public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                        super.OnTransformation(itemstack, player);
                        ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                                player.getX(), player.getY()+1,
                                player.getZ(), 100, 0, 0, 0, 1);
                    }
                }.IsGlowing().AddToList(RiderTabs.G_TAB_ITEM).KeepItem());

	public static final DeferredItem<Item> GHELMET = ITEMS.register("ghead",
	            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.G_TAB_ITEM));
	    public static final DeferredItem<Item> GCHESTPLATE = ITEMS.register("gtroso",
	            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.G_TAB_ITEM));
	    public static final DeferredItem<Item> GLEGGINGS = ITEMS.register("glegs",
	            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.G_TAB_ITEM));
	    
	    public static final DeferredItem<Item> G_BELT = ITEMS.register("g_belt",
		           () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kamen_rider_g",GORO_WINE_BOTTLE ,GHELMET,GCHESTPLATE,GLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.G_TAB_ITEM));

//Gorider
		public static final DeferredItem<Item> AKARIDER_CARD = ITEMS.register("akarider_card",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"","aka_rider","typhoon_belt_akarider",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED,40, 1,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
						new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false)){
                    public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                        super.OnTransformation(itemstack, player);
                        ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                                player.getX(), player.getY()+1,
                                player.getZ(), 100, 0, 0, 0, 1);
                    }
                }.IsGlowing().AddToList(RiderTabs.GORIDER_TAB_ITEM).KeepItem());
		
		public static final DeferredItem<Item> AORIDER_CARD = ITEMS.register("aorider_card",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"","ao_rider","typhoon_belt_aorider",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED,40, 1,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
						new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false)){
                    public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                        super.OnTransformation(itemstack, player);
                        ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                                player.getX(), player.getY()+1,
                                player.getZ(), 100, 0, 0, 0, 1);
                    }
                }.IsGlowing().AddToList(RiderTabs.GORIDER_TAB_ITEM).KeepItem());
		
		public static final DeferredItem<Item> KIRIDER_CARD = ITEMS.register("kirider_card",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"","ki_rider","typhoon_belt_kirider",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED,40, 1,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
						new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false)){
                    public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                        super.OnTransformation(itemstack, player);
                        ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                                player.getX(), player.getY()+1,
                                player.getZ(), 100, 0, 0, 0, 1);
                    }
                }.IsGlowing().AddToList(RiderTabs.GORIDER_TAB_ITEM).KeepItem());
		
		public static final DeferredItem<Item> MOMORIDER_CARD = ITEMS.register("momorider_card",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"","momo_rider","typhoon_belt_momorider",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED,40, 1,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
						new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false)){
                    public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                        super.OnTransformation(itemstack, player);
                        ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                                player.getX(), player.getY()+1,
                                player.getZ(), 100, 0, 0, 0, 1);
                    }
                }.IsGlowing().AddToList(RiderTabs.GORIDER_TAB_ITEM).KeepItem());
		
		public static final DeferredItem<Item> MIDORIDER_CARD = ITEMS.register("midorider_card",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"","mido_rider","typhoon_belt_midorider",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED,40, 1,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
						new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false)){
                    public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                        super.OnTransformation(itemstack, player);
                        ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                                player.getX(), player.getY()+1,
                                player.getZ(), 100, 0, 0, 0, 1);
                    }
                }.IsGlowing().AddToList(RiderTabs.GORIDER_TAB_ITEM).KeepItem());


		public static final DeferredItem<Item> AKARIDERHELMET = ITEMS.register("akariderhead",
	            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.GORIDER_TAB_ITEM));
	    public static final DeferredItem<Item> AKARIDERCHESTPLATE = ITEMS.register("akaridertroso",
	            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.GORIDER_TAB_ITEM));
	    public static final DeferredItem<Item> AKARIDERLEGGINGS = ITEMS.register("akariderlegs",
	            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.GORIDER_TAB_ITEM));

		public static final DeferredItem<Item> TYPHOON_AKARIDER = ITEMS.register("typhoon_akarider",
				() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"aka_rider",AKARIDER_CARD ,AKARIDERHELMET,AKARIDERCHESTPLATE,AKARIDERLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.GORIDER_TAB_ITEM));
		public static final DeferredItem<Item> TYPHOON_AORIDER = ITEMS.register("typhoon_aorider",
				() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ao_rider",AORIDER_CARD ,AKARIDERHELMET,AKARIDERCHESTPLATE,AKARIDERLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.GORIDER_TAB_ITEM));
		public static final DeferredItem<Item> TYPHOON_KIRIDER = ITEMS.register("typhoon_kirider",
				() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ki_rider",KIRIDER_CARD ,AKARIDERHELMET,AKARIDERCHESTPLATE,AKARIDERLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.GORIDER_TAB_ITEM));
		public static final DeferredItem<Item> TYPHOON_MOMORIDER = ITEMS.register("typhoon_momorider",
				() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"momo_rider",MOMORIDER_CARD ,AKARIDERHELMET,AKARIDERCHESTPLATE,AKARIDERLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.GORIDER_TAB_ITEM));
		public static final DeferredItem<Item> TYPHOON_MIDORIDER = ITEMS.register("typhoon_midorider",
				() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"mido_rider",MIDORIDER_CARD ,AKARIDERHELMET,AKARIDERCHESTPLATE,AKARIDERLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.GORIDER_TAB_ITEM));
			 
		
		//SIC artist
		
	    public static final DeferredItem<Item> TYPHOON_CORE_ARTIST = ITEMS.register("typhoon_core_artist",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"_artist","ichigo","typhoon_belt_artist",
						new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
						,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
						new MobEffectInstance(Effect_core.RIDER_KICK, 40, 0,true,false))
                        .IsGlowing());
		
	    public static final DeferredItem<Item> DOUBLE_TYPHOON_CORE_ARTIST = ITEMS.register("double_typhoon_core_artist",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"_artist","v3","double_typhoon_belt_artist",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
	            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
	            		,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)
	            		,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
                        .IsGlowing().addAlternative(TYPHOON_CORE_ARTIST.get()));
		
	    public static final DeferredItem<Item> RIDERMAN_BELT_CORE_ARTIST = ITEMS.register("riderman_belt_core_artist",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"_artist","riderman","riderman_belt",
						new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
						,new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false)
						,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
                        .IsGlowing().SetShowFace().addAlternative(DOUBLE_TYPHOON_CORE_ARTIST.get()));
	    
	    public static final DeferredItem<Item> CONDORER_WHEEL_PRE_AMAZON = ITEMS.register("condorer_wheel_pre_amazon",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"_pre","amazon","condorer_belt",
						new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false),
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
                        .IsGlowing().addAlternative(RIDERMAN_BELT_CORE_ARTIST.get()));
	    
	    public static final DeferredItem<Item> ELECTRER_CORE_ARTIST = ITEMS.register("electrer_core_artist",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"_artist","stronger","electrer_belt_artist",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
	            		,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false)
	            		,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
	            		,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
                        .IsGlowing().addAlternative(CONDORER_WHEEL_PRE_AMAZON.get()));
	 
	    public static final DeferredItem<Item> TACKLE_CORE_ARTIST = ITEMS.register("tackle_core_artist",
	            () -> new RiderFormChangeItem(new Item.Properties(),0,"_artist","tackle","tackle_belt_artist",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
	            		,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false)
	            		,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
	            		,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
                        .IsGlowing().SetShowUnder().addAlternative(ELECTRER_CORE_ARTIST.get()));
	 
	    public static final DeferredItem<Item> KUUGA_AMAZING_MIGHTY_ARTIST = ITEMS.register("kuuga_amazing_mighty_artist",
	            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_artist","kuuga","arcle_belt_r",
	            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
	            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
	            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
	            		new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false),
						new MobEffectInstance(Effect_core.RIDER_KICK, 40, 0,true,false)){
					public void OnTransformation(ItemStack itemstack, LivingEntity player) {
						super.OnTransformation(itemstack, player);
						((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
								player.getX(), player.getY()+1,
								player.getZ(), 100, 0, 0, 0, 1);
					}
				}.IsBeltGlowing().IsGlowing().addNeedForm(Kuuga_Rider_Items.KUUGA_AMAZING_MIGHTY.get(),1).addAlternative(TACKLE_CORE_ARTIST.get())
						.AddToList(RiderTabs.Misc_TAB_ITEM));
		
		//Ride Kamens
		
		public static final DeferredItem<Item> CONTRACT_CHAOSTONE = ITEMS.register("contract_chaostone",
				() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.RIDE_KAMENS_TAB_ITEM));
		
		  public static final DeferredItem<Item> CHAOS_RING_SAIGO = ITEMS.register("chaos_ring_saigo",
		            () -> new RiderFormChangeItem(new Item.Properties(),0,"","saigo","chaos_driver_saigo_belt",
		            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
		            		,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
                            .IsBeltGlowing().SetShowFace().IsGlowing().AddToList(RiderTabs.RIDE_KAMENS_TAB_ITEM).KeepItem());

		  public static final DeferredItem<Item> CHAOS_RING_HARUMA = ITEMS.register("chaos_ring_haruma",
		            () -> new RiderFormChangeItem(new Item.Properties(),0,"","haruma","chaos_driver_haruma_belt",
		            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
		            		,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
                            .IsBeltGlowing().SetShowFace().IsGlowing().AddToList(RiderTabs.RIDE_KAMENS_TAB_ITEM).KeepItem());

		  public static final DeferredItem<Item> CHAOS_RING_SHION = ITEMS.register("chaos_ring_shion",
		            () -> new RiderFormChangeItem(new Item.Properties(),0,"","shion","chaos_driver_shion_belt",
		            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
		            		,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
                            .IsBeltGlowing().SetShowFace().IsGlowing().AddToList(RiderTabs.RIDE_KAMENS_TAB_ITEM).KeepItem());

		  public static final DeferredItem<Item> CHAOS_RING_JIGEN = ITEMS.register("chaos_ring_jigen",
		            () -> new RiderFormChangeItem(new Item.Properties(),0,"","jigen","chaos_driver_jigen_belt",
		            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
		            		,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
                            .IsBeltGlowing().SetShowFace().ChangeModel("haruma.geo.json").IsGlowing().AddToList(RiderTabs.RIDE_KAMENS_TAB_ITEM).KeepItem());

	public static final DeferredItem<Item> CHAOS_RING_ARAKI = ITEMS.register("chaos_ring_araki",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","araki","chaos_driver_araki_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
                    .IsBeltGlowing().SetShowFace().IsGlowing().AddToList(RiderTabs.RIDE_KAMENS_TAB_ITEM).KeepItem());

	public static final DeferredItem<Item> CHAOS_RING_KAMUI = ITEMS.register("chaos_ring_kamui",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","kamui","chaos_driver_kamui_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
                    .IsBeltGlowing().SetShowFace().IsGlowing().AddToList(RiderTabs.RIDE_KAMENS_TAB_ITEM).KeepItem());

	public static final DeferredItem<Item> CHAOS_RING_AGATA = ITEMS.register("chaos_ring_agata",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","agata","chaos_driver_agata_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
                    .IsBeltGlowing().SetShowFace().IsGlowing().AddToList(RiderTabs.RIDE_KAMENS_TAB_ITEM).KeepItem());

    public static final DeferredItem<Item> CHAOS_RING_LOQ = ITEMS.register("chaos_ring_loq",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","loq","chaos_driver_loq_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
                    .IsBeltGlowing().SetShowFace().IsGlowing().AddToList(RiderTabs.RIDE_KAMENS_TAB_ITEM).KeepItem());


    public static final DeferredItem<Item> RIDE_KAMENS_HELMET = ITEMS.register("ride_kamens_head",
		            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.RIDE_KAMENS_TAB_ITEM));
		    public static final DeferredItem<Item> RIDE_KAMENS_CHESTPLATE = ITEMS.register("ride_kamens_troso",
		            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.RIDE_KAMENS_TAB_ITEM));
		    public static final DeferredItem<Item> RIDE_KAMENS_LEGGINGS = ITEMS.register("ride_kamens_legs",
		            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.RIDE_KAMENS_TAB_ITEM));
		    
		    public static final DeferredItem<Item> CHAOS_DRIVER_SAIGO = ITEMS.register("chaos_driver_saigo",
			           () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"saigo",CHAOS_RING_SAIGO ,RIDE_KAMENS_HELMET,RIDE_KAMENS_CHESTPLATE,RIDE_KAMENS_LEGGINGS , new Item.Properties())
							   .Dont_show_belt_form_info().AddToTabList(RiderTabs.RIDE_KAMENS_TAB_ITEM));

		    public static final DeferredItem<Item> CHAOS_DRIVER_HARUMA = ITEMS.register("chaos_driver_haruma",
			           () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"haruma",CHAOS_RING_HARUMA ,RIDE_KAMENS_HELMET,RIDE_KAMENS_CHESTPLATE,RIDE_KAMENS_LEGGINGS , new Item.Properties())
							   .Dont_show_belt_form_info().AddToTabList(RiderTabs.RIDE_KAMENS_TAB_ITEM));

		    public static final DeferredItem<Item> CHAOS_DRIVER_SHION = ITEMS.register("chaos_driver_shion",
			           () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shion",CHAOS_RING_SHION ,RIDE_KAMENS_HELMET,RIDE_KAMENS_CHESTPLATE,RIDE_KAMENS_LEGGINGS , new Item.Properties())
							   .Dont_show_belt_form_info().AddToTabList(RiderTabs.RIDE_KAMENS_TAB_ITEM));

		    public static final DeferredItem<Item> CHAOS_DRIVER_JIGEN = ITEMS.register("chaos_driver_jigen",
			           () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"jigen",CHAOS_RING_JIGEN ,RIDE_KAMENS_HELMET,RIDE_KAMENS_CHESTPLATE,RIDE_KAMENS_LEGGINGS , new Item.Properties())
							   .Dont_show_belt_form_info().AddToTabList(RiderTabs.RIDE_KAMENS_TAB_ITEM));

	public static final DeferredItem<Item> CHAOS_DRIVER_ARAKI = ITEMS.register("chaos_driver_araki",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"araki",CHAOS_RING_ARAKI ,RIDE_KAMENS_HELMET,RIDE_KAMENS_CHESTPLATE,RIDE_KAMENS_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.RIDE_KAMENS_TAB_ITEM));

	public static final DeferredItem<Item> CHAOS_DRIVER_KAMUI = ITEMS.register("chaos_driver_kamui",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kamui",CHAOS_RING_KAMUI ,RIDE_KAMENS_HELMET,RIDE_KAMENS_CHESTPLATE,RIDE_KAMENS_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.RIDE_KAMENS_TAB_ITEM));

	public static final DeferredItem<Item> CHAOS_DRIVER_AGATA = ITEMS.register("chaos_driver_agata",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"agata",CHAOS_RING_AGATA ,RIDE_KAMENS_HELMET,RIDE_KAMENS_CHESTPLATE,RIDE_KAMENS_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.RIDE_KAMENS_TAB_ITEM));

    public static final DeferredItem<Item> CHAOS_DRIVER_LOQ = ITEMS.register("chaos_driver_lqo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"loq",CHAOS_RING_LOQ ,RIDE_KAMENS_HELMET,RIDE_KAMENS_CHESTPLATE,RIDE_KAMENS_LEGGINGS , new Item.Properties())
                    .Dont_show_belt_form_info().AddToTabList(RiderTabs.RIDE_KAMENS_TAB_ITEM));


    // TODO: Add Catboy Double, and also WeHn PaLyEr AnIaMtOnS
    // TODO: you do 2, I'll make 1!

		    public static final DeferredItem<Item> GASHA_TICKET = ITEMS.register("gasha_ticket",
		    		() -> new BaseDropItem(new Item.Properties(), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/gasha_ticket")).AddToList(RiderTabs.RIDE_KAMENS_TAB_ITEM));

		    public static final DeferredItem<Item> CANDY = ITEMS.register("candy",
					() -> new BaseItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).fast().saturationModifier(0.8f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 500, 0), 1.0F).build()))
					.AddToList(RiderTabs.RIDE_KAMENS_TAB_ITEM));
		    
		    public static final DeferredItem<Item> ENERGY_DRINK = ITEMS.register("energy_drink",
					() -> new BaseItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).fast().saturationModifier(0.8f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 2), 1.0F).build()))
							.SetItemAnimation(UseAnim.DRINK).AddToList(RiderTabs.RIDE_KAMENS_TAB_ITEM));


	public static final DeferredItem<Item> GIFT = ITEMS.register("gift",
			() -> new BaseDropItem(new Item.Properties().rarity(Rarity.UNCOMMON), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/gift")).AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item> GASHAPON_CAPSULE = ITEMS.register("gashapon_capsule",
            () -> new BaseDropItem(new Item.Properties().rarity(Rarity.UNCOMMON), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/gashapon_capsule")).has_basic_model().AddToList(RiderTabs.Misc_TAB_ITEM));


    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
	    
	}