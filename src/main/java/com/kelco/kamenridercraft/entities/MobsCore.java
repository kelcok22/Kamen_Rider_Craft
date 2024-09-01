package com.kelco.kamenridercraft.entities;


import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.entities.bosses.ShockerRidersEntity;
import com.kelco.kamenridercraft.entities.footSoldiers.ShockerCombatmanEntity;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MobsCore {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);
	//public static final DeferredRegister<EntityType<?>> MOBLIST = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, KamenRiderCraftCore.MODID);
    public static final DeferredRegister<EntityType<?>> MOBLIST  = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE,KamenRiderCraftCore.MOD_ID);


    public static final DeferredHolder<EntityType<?>, EntityType<ShockerCombatmanEntity>> SHOCKER_COMBATMAN = MOBLIST.register("shocker_combatman",
            () -> EntityType.Builder.of(ShockerCombatmanEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":shocker_combatman"));
    
    public static final DeferredItem<DeferredSpawnEggItem> SHOCKER_COMBATMAN_SPAWN_EGG = ITEMS.register("shocker_combatman_spawn_egg",
            () -> new DeferredSpawnEggItem(SHOCKER_COMBATMAN, 000000,0xFFFFFF, new Item.Properties()));
 
    public static final DeferredHolder<EntityType<?>, EntityType<ShockerRidersEntity>> SHOCKER_RIDER = MOBLIST.register("shocker_riders",
            () -> EntityType.Builder.of(ShockerRidersEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":shocker_riders"));
    
    public static final DeferredItem<DeferredSpawnEggItem> SHOCKER_RIDER_SPAWN_EGG = ITEMS.register("shocker_riders_spawn_egg",
            () -> new DeferredSpawnEggItem(SHOCKER_RIDER, 0x53aa8e,0xd6b500, new Item.Properties()));
 
    /**
    
    public static final RegistryObject<EntityType<DestronCombatmanEntity>> DESTRON_COMBATMAN = MOBLIST.register("destron_combatman",
            () -> EntityType.Builder.of(DestronCombatmanEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":destron_combatman"));
    
    public static final DeferredItem<DeferredSpawnEggItem> DESTRON_COMBATMAN_SPAWN_EGG = ITEMS.register("destron_combatman_spawn_egg",
            () -> new DeferredSpawnEggItem(DESTRON_COMBATMAN, 000000,0xFFFFFF, new Item.Properties()));
 
    

    public static final RegistryObject<EntityType<GODWarfareAgentEntity>> GOD_WARFARE_AGENT = MOBLIST.register("god_warfare_agent",
            () -> EntityType.Builder.of(GODWarfareAgentEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":god_warfare_agent"));
    
    public static final DeferredItem<DeferredSpawnEggItem> GOD_WARFARE_AGENT_SPAWN_EGG = ITEMS.register("god_warfare_agent_spawn_egg",
            () -> new DeferredSpawnEggItem(GOD_WARFARE_AGENT, 000000,0x7e0000, new Item.Properties()));
 
    
    
    public static final RegistryObject<EntityType<RedFollowerEntity>> RED_FOLLWER = MOBLIST.register("red_follower",
            () -> EntityType.Builder.of(RedFollowerEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":red_follower"));
    
    public static final DeferredItem<DeferredSpawnEggItem> RED_FOLLWER_SPAWN_EGG = ITEMS.register("red_follower_spawn_egg",
            () -> new DeferredSpawnEggItem(RED_FOLLWER,  0x7e0000,0xcacaca, new Item.Properties()));

    
    
    public static final RegistryObject<EntityType<BlackSatanSoldierEntity>> BLACK_SATAN_SOLDIER = MOBLIST.register("black_satan_soldier",
            () -> EntityType.Builder.of(BlackSatanSoldierEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":black_satan_soldier"));
    
    public static final DeferredItem<DeferredSpawnEggItem> BLACK_SATAN_SOLDIER_SPAWN_EGG = ITEMS.register("black_satan_soldier_spawn_egg",
            () -> new DeferredSpawnEggItem(BLACK_SATAN_SOLDIER, 000000,0x7e0000, new Item.Properties()));

    
    
    public static final RegistryObject<EntityType<AriCommandoEntity>> ARI_COMMANDO = MOBLIST.register("ari_commando",
            () -> EntityType.Builder.of(AriCommandoEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":ari_commando"));
    
    public static final DeferredItem<DeferredSpawnEggItem> ARI_COMMANDO_SPAWN_EGG = ITEMS.register("ari_commando_spawn_egg",
            () -> new DeferredSpawnEggItem(ARI_COMMANDO, 000000,0x121212, new Item.Properties()));

    
    
    public static final RegistryObject<EntityType<DogmaFighterEntity>> DOGMA_FIGHTER = MOBLIST.register("dogma_fighter",
            () -> EntityType.Builder.of(DogmaFighterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":dogma_fighter"));
    
    public static final DeferredItem<DeferredSpawnEggItem> DOGMA_FIGHTER_SPAWN_EGG = ITEMS.register("dogma_fighter_spawn_egg",
            () -> new DeferredSpawnEggItem(DOGMA_FIGHTER, 0x730000,0xa5a5a5, new Item.Properties()));
 
    
    
    public static final RegistryObject<EntityType<CombatRoidEntity>> COMBAT_ROID = MOBLIST.register("combat_roid",
            () -> EntityType.Builder.of(CombatRoidEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":combat_roid"));
    
    public static final DeferredItem<DeferredSpawnEggItem> COMBAT_ROID_SPAWN_EGG = ITEMS.register("combat_roid_spawn_egg",
            () -> new DeferredSpawnEggItem(COMBAT_ROID, 0xa5a5a5,0x8c0000, new Item.Properties()));
 

    
    public static final RegistryObject<EntityType<ChapEntity>> CHAP = MOBLIST.register("chap",
           () -> EntityType.Builder.of(ChapEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":chap"));
    
    public static final DeferredItem<DeferredSpawnEggItem> CHAP_SPAWN_EGG = ITEMS.register("chap_spawn_egg",
           () -> new DeferredSpawnEggItem(CHAP,  000000,0xFFFFFF, new Item.Properties()));
 
    public static final RegistryObject<EntityType<ShadowmoonEntity>> SHADOWMOON = MOBLIST.register("shadowmoon",
            () -> EntityType.Builder.of(ShadowmoonEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":shadowmoon"));
     
     public static final DeferredItem<DeferredSpawnEggItem> SHADOWMOON_SPAWN_EGG = ITEMS.register("shadowmoon_spawn_egg",
            () -> new DeferredSpawnEggItem(SHADOWMOON,  0xbabab6,0x00a01c, new Item.Properties()));
     
     public static final RegistryObject<EntityType<ChapGreyEntity>> CHAP_GREY = MOBLIST.register("chap_grey",
             () -> EntityType.Builder.of(ChapGreyEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":chap_grey"));
      
      public static final DeferredItem<DeferredSpawnEggItem> CHAP_GREY_SPAWN_EGG = ITEMS.register("chap_grey_spawn_egg",
             () -> new DeferredSpawnEggItem(CHAP_GREY,  0x919191,0xFFFFFF, new Item.Properties()));
     
     
     
     public static final RegistryObject<EntityType<ZuGumunBaEntity>> ZU_GUMUN_BA = MOBLIST.register("zu_gumun_ba",
             () -> EntityType.Builder.of(ZuGumunBaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":zu_gumun_ba"));

     public static final DeferredItem<DeferredSpawnEggItem> ZU_GUMUN_BA_SPAWN_EGG = ITEMS.register("zu_gumun_ba_spawn_egg",
             () -> new DeferredSpawnEggItem(ZU_GUMUN_BA,  0xf8ba57,0xaf8e59, new Item.Properties()));
     
     
     public static final RegistryObject<EntityType<PantherasLuteusEntity>> PANTHERAS_LUTEUS = MOBLIST.register("pantheras_luteus",
             () -> EntityType.Builder.of(PantherasLuteusEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":pantheras_luteus"));

     public static final DeferredItem<DeferredSpawnEggItem> PANTHERAS_LUTEUS_SPAWN_EGG = ITEMS.register("pantheras_luteus_spawn_egg",
             () -> new DeferredSpawnEggItem(PANTHERAS_LUTEUS,  0xffbe2e, 0xff3333, new Item.Properties()));
     
     public static final RegistryObject<EntityType<ElOfTheWaterEntity>> EL_OF_THE_WATER = MOBLIST.register("el_of_the_water",
             () -> EntityType.Builder.of(ElOfTheWaterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":el_of_the_water"));

     public static final DeferredItem<DeferredSpawnEggItem> EL_OF_THE_WATER_SPAWN_EGG = ITEMS.register("el_of_the_water_spawn_egg",
             () -> new DeferredSpawnEggItem(EL_OF_THE_WATER,  0x27262d, 0xd1cfda, new Item.Properties()));
     
     public static final RegistryObject<EntityType<AnguisMasculusEntity>> ANGUIS_MASCULUS = MOBLIST.register("anguis_masculus",
             () -> EntityType.Builder.of(AnguisMasculusEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":anguis_masculus"));

     public static final DeferredItem<DeferredSpawnEggItem> ANGUIS_MASCULUS_SPAWN_EGG = ITEMS.register("anguis_masculus_spawn_egg",
             () -> new DeferredSpawnEggItem(ANGUIS_MASCULUS,  0x445a94, 0xceb42b, new Item.Properties()));
     
     public static final RegistryObject<EntityType<AnotherAgitoEntity>> ANOTHER_AGITO = MOBLIST.register("another_agito",
             () -> EntityType.Builder.of(AnotherAgitoEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":another_agito"));

     public static final DeferredItem<DeferredSpawnEggItem> ANOTHER_AGITO_SPAWN_EGG = ITEMS.register("another_agito_spawn_egg",
             () -> new DeferredSpawnEggItem(ANOTHER_AGITO,  0x273d31, 0x131313, new Item.Properties()));
     
     
     public static final RegistryObject<EntityType<RiotrooperEntity>> RIOTROOPER = MOBLIST.register("riotrooper",
             () -> EntityType.Builder.of(RiotrooperEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":riotrooper"));

     public static final DeferredItem<DeferredSpawnEggItem> RIOTROOPER_SPAWN_EGG = ITEMS.register("riotrooper_spawn_egg",
             () -> new DeferredSpawnEggItem(RIOTROOPER,  0x11110e,0xfc911e, new Item.Properties()));
     
     public static final RegistryObject<EntityType<OrgaEntity>> ORGA = MOBLIST.register("orga",
             () -> EntityType.Builder.of(OrgaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":orga"));

     public static final DeferredItem<DeferredSpawnEggItem> ORGA_SPAWN_EGG = ITEMS.register("orga_spawn_egg",
             () -> new DeferredSpawnEggItem(ORGA,  0x11110e,0xd5ba4c, new Item.Properties()));
     

     public static final RegistryObject<EntityType<ZectrooperEntity>> ZECTROOPER = MOBLIST.register("zectrooper",
             () -> EntityType.Builder.of(ZectrooperEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":zectrooper"));

     public static final DeferredItem<DeferredSpawnEggItem> ZECTROOPER_SPAWN_EGG = ITEMS.register("zectrooper_spawn_egg",
             () -> new DeferredSpawnEggItem(ZECTROOPER,  0x1d1d1d,0x1d1d1d, new Item.Properties()));
     
     public static final RegistryObject<EntityType<ShadowTrooperEntity>> SHADOW_TROOPER = MOBLIST.register("shadow_trooper",
             () -> EntityType.Builder.of(ShadowTrooperEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":shadow_trooper"));

     public static final DeferredItem<DeferredSpawnEggItem> SHADOW_TROOPER_SPAWN_EGG = ITEMS.register("shadow_trooper_spawn_egg",
             () -> new DeferredSpawnEggItem(SHADOW_TROOPER,  0x1d1d1d,0x1d1d1d, new Item.Properties()));
     
     public static final RegistryObject<EntityType<NeotrooperEntity>> NEOTROOPER = MOBLIST.register("neotrooper",
             () -> EntityType.Builder.of(NeotrooperEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":neotrooper"));

     public static final DeferredItem<DeferredSpawnEggItem> NEOTROOPER_SPAWN_EGG = ITEMS.register("neotrooper_spawn_egg",
             () -> new DeferredSpawnEggItem(NEOTROOPER,  0x1d1d1d,0x1d1d1d, new Item.Properties()));
     
     public static final RegistryObject<EntityType<CaucasusEntity>> CAUCASUS = MOBLIST.register("caucasus",
             () -> EntityType.Builder.of(CaucasusEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":caucasus"));

     public static final DeferredItem<DeferredSpawnEggItem> CAUCASUS_SPAWN_EGG = ITEMS.register("caucasus_spawn_egg",
             () -> new DeferredSpawnEggItem(CAUCASUS,  0x999999,0xf4c600, new Item.Properties()));


     public static final RegistryObject<EntityType<NewMoleImaginEntity>> NEW_MOLE_IMAGIN = MOBLIST.register("new_mole_imagin",
             () -> EntityType.Builder.of(NewMoleImaginEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":new_mole_imagin"));

     public static final DeferredItem<DeferredSpawnEggItem> NEW_MOLE_IMAGIN_SPAWN_EGG = ITEMS.register("new_mole_imagin_spawn_egg",
             () -> new DeferredSpawnEggItem(NEW_MOLE_IMAGIN,  0xb7b7b1,0x92908b, new Item.Properties()));

     public static final RegistryObject<EntityType<NewMoleImaginSandEntity>> NEW_MOLE_IMAGIN_SAND = MOBLIST.register("new_mole_imagin_sand",
             () -> EntityType.Builder.of(NewMoleImaginSandEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":new_mole_imagin_sand"));

     public static final DeferredItem<DeferredSpawnEggItem> NEW_MOLE_IMAGIN_SAND_SPAWN_EGG = ITEMS.register("new_mole_imagin_sand_spawn_egg",
             () -> new DeferredSpawnEggItem(NEW_MOLE_IMAGIN_SAND,  0xb7b7b1,0x92908b, new Item.Properties()));

     public static final RegistryObject<EntityType<GaohEntity>> GAOH = MOBLIST.register("gaoh",
             () -> EntityType.Builder.of(GaohEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":gaoh"));

     public static final DeferredItem<DeferredSpawnEggItem> GAOH_SPAWN_EGG = ITEMS.register("gaoh_spawn_egg",
             () -> new DeferredSpawnEggItem(GAOH,  0x1d1d1d,0xdea302, new Item.Properties()));

     public static final RegistryObject<EntityType<MomotarosEntity>> MOMOTAROS = MOBLIST.register("momotaros",
             () -> EntityType.Builder.of(MomotarosEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":momotaros"));

     public static final DeferredItem<DeferredSpawnEggItem> MOMOTAROS_SPAWN_EGG = ITEMS.register("momotaros_spawn_egg",
             () -> new DeferredSpawnEggItem(MOMOTAROS,  0x790000,0xef0000, new Item.Properties()));

     public static final RegistryObject<EntityType<UratarosEntity>> URATAROS = MOBLIST.register("urataros",
             () -> EntityType.Builder.of(UratarosEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":urataros"));

     public static final DeferredItem<DeferredSpawnEggItem> URATAROS_SPAWN_EGG = ITEMS.register("urataros_spawn_egg",
             () -> new DeferredSpawnEggItem(URATAROS,  0x0075ec,0x003d7d, new Item.Properties()));

     public static final RegistryObject<EntityType<KintarosEntity>> KINTAROS = MOBLIST.register("kintaros",
             () -> EntityType.Builder.of(KintarosEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":kintaros"));

     public static final DeferredItem<DeferredSpawnEggItem> KINTAROS_SPAWN_EGG = ITEMS.register("kintaros_spawn_egg",
             () -> new DeferredSpawnEggItem(KINTAROS,  0x212121,0xd2a900, new Item.Properties()));

     public static final RegistryObject<EntityType<RyutarosEntity>> RYUTAROS = MOBLIST.register("ryutaros",
             () -> EntityType.Builder.of(RyutarosEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":ryutaros"));

     public static final DeferredItem<DeferredSpawnEggItem> RYUTAROS_SPAWN_EGG = ITEMS.register("ryutaros_spawn_egg",
             () -> new DeferredSpawnEggItem(RYUTAROS,  0x3b114e,0x2a0b38, new Item.Properties()));


     public static final RegistryObject<EntityType<MasqueradeEntity>> MASQUERADE = MOBLIST.register("masquerade",
             () -> EntityType.Builder.of(MasqueradeEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":masquerade"));

     public static final DeferredItem<DeferredSpawnEggItem> MASQUERADE_SPAWN_EGG = ITEMS.register("masquerade_spawn_egg",
             () -> new DeferredSpawnEggItem(MASQUERADE,  000000,0xFFFFFF, new Item.Properties()));
      
     public static final RegistryObject<EntityType<FoundationXMasqueradeEntity>> FOUNDATION_X_MASQUERADE = MOBLIST.register("foundation_x_masquerade",
             () -> EntityType.Builder.of(FoundationXMasqueradeEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":foundation_x_masquerade"));

     public static final DeferredItem<DeferredSpawnEggItem> FOUNDATION_X_MASQUERADE_SPAWN_EGG = ITEMS.register("foundation_x_masquerade_spawn_egg",
             () -> new DeferredSpawnEggItem(FOUNDATION_X_MASQUERADE,  000000,0xFFFFFF, new Item.Properties()));

   
     public static final RegistryObject<EntityType<ClayDollDopantEntity>> CLAYDOLL_DOPANT = MOBLIST.register("claydoll_dopant",
            () -> EntityType.Builder.of(ClayDollDopantEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":claydoll_dopant"));

     public static final DeferredItem<DeferredSpawnEggItem> CLAYDOLL_DOPANT_SPAWN_EGG = ITEMS.register("claydoll_dopant_spawn_egg",
             () -> new DeferredSpawnEggItem(CLAYDOLL_DOPANT, 0x783f04,0xf7dabc, new Item.Properties()));

     public static final RegistryObject<EntityType<NazcaDopantEntity>> NASCA_DOPANT = MOBLIST.register("nazca_dopant",
             () -> EntityType.Builder.of(NazcaDopantEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":nazca_dopant"));

      public static final DeferredItem<DeferredSpawnEggItem> NASCA_DOPANT_SPAWN_EGG = ITEMS.register("nazca_dopant_spawn_egg",
              () -> new DeferredSpawnEggItem(NASCA_DOPANT, 0x0092BB,0xff9f00, new Item.Properties()));

      /**
      public static final RegistryObject<EntityType<RedNazcaDopantEntity>> RED_NASCA_DOPANT = MOBLIST.register("red_nazca_dopant",
              () -> EntityType.Builder.of(RedNazcaDopantEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":red_nazca_dopant"));

       public static final DeferredItem<DeferredSpawnEggItem> RED_NASCA_DOPANT_SPAWN_EGG = ITEMS.register("red_nazca_dopant_spawn_egg",
               () -> new DeferredSpawnEggItem(RED_NASCA_DOPANT, 0x161616,0x0092BB, new Item.Properties()));


       public static final RegistryObject<EntityType<TabooDopantEntity>> TABOO_DOPANT = MOBLIST.register("taboo_dopant",
               () -> EntityType.Builder.of(TabooDopantEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":taboo_dopant"));

        public static final DeferredItem<DeferredSpawnEggItem> TABOO_DOPANT_SPAWN_EGG = ITEMS.register("taboo_dopant_spawn_egg",
                () -> new DeferredSpawnEggItem(TABOO_DOPANT_MASQUERADE, 0x161616,0x0092BB, new Item.Properties()));

        public static final RegistryObject<EntityType<WeatherDopantEntity>> WEATHER_DOPANT = MOBLIST.register("weather_dopant",
                () -> EntityType.Builder.of(WeatherDopantEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":weather_dopant"));

         public static final DeferredItem<DeferredSpawnEggItem> WEATHER_DOPANT_SPAWN_EGG = ITEMS.register("weather_dopant_spawn_egg",
                 () -> new DeferredSpawnEggItem(WEATHER_DOPANT, 0xffffff,0xc1c1c1, new Item.Properties()));

         public static final RegistryObject<EntityType<SmilodonDopantEntity>> SMILODON_DOPANT = MOBLIST.register("smilodon_dopant",
                 () -> EntityType.Builder.of(SmilodonDopantEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":smilodon_dopant"));

          public static final DeferredItem<DeferredSpawnEggItem> SMILODON_DOPANT_SPAWN_EGG = ITEMS.register("smilodon_dopant_spawn_egg",
                  () -> new DeferredSpawnEggItem(SMILODON_DOPANT, 0xc7b372,0x727272, new Item.Properties()));

           public static final RegistryObject<EntityType<TerrorDopantEntity>> TERROR_DOPANT = MOBLIST.register("terror_dopant",
                   () -> EntityType.Builder.of(TerrorDopantEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":terror_dopant"));

            public static final DeferredItem<DeferredSpawnEggItem> TERROR_DOPANT_SPAWN_EGG = ITEMS.register("terror_dopant_spawn_egg",
                    () -> new DeferredSpawnEggItem(TERROR_DOPANT, 0x161616,0x0092BB, new Item.Properties()));


     public static final RegistryObject<EntityType<CommanderDopantEntity>> COMMANDER_DOPANT = MOBLIST.register("commander_dopant",
             () -> EntityType.Builder.of(CommanderDopantEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":commander_dopant"));

      public static final DeferredItem<DeferredSpawnEggItem> COMMANDER_DOPANT_SPAWN_EGG = ITEMS.register("commander_dopant_spawn_egg",
              () -> new DeferredSpawnEggItem(COMMANDER_DOPANT, 0xc7b372,0x727272, new Item.Properties()));

     
     public static final RegistryObject<EntityType<EternalEntity>> ETERNAL = MOBLIST.register("eternal_mob",
             () -> EntityType.Builder.of(EternalEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":eternal_mob"));

      public static final DeferredItem<DeferredSpawnEggItem> ETERNAL_SPAWN_EGG = ITEMS.register("eternal_spawn_egg",
              () -> new DeferredSpawnEggItem(ETERNAL, 0xFFFFFF, 0x0092BB, new Item.Properties()));

      //Eternal 0xffe892, 0xFFFFFF
      
      public static final RegistryObject<EntityType<YummyEntity>> YUMMY = MOBLIST.register("yummy_mob",
              () -> EntityType.Builder.of(YummyEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":yummy_mob"));

       public static final DeferredItem<DeferredSpawnEggItem> YUMMY_SPAWN_EGG = ITEMS.register("yummy_spawn_egg",
               () -> new DeferredSpawnEggItem(YUMMY, 0xE7E6B2, 0x959586, new Item.Properties()));

       public static final RegistryObject<EntityType<KnightSoldierEntity>> KNIGHT_SOLDIER = MOBLIST.register("knight_soldier_mob",
               () -> EntityType.Builder.of(KnightSoldierEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":knight_soldier_mob"));

        public static final DeferredItem<DeferredSpawnEggItem> KNIGHT_SOLDIER_SPAWN_EGG = ITEMS.register("knight_soldier_spawn_egg",
                () -> new DeferredSpawnEggItem(KNIGHT_SOLDIER, 0xca570f,0x919191, new Item.Properties()));

    
       public static final RegistryObject<EntityType<AnkhEntity>> ANKH = MOBLIST.register("ankh_mob",
              () -> EntityType.Builder.of(AnkhEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":ankh_mob"));

       public static final DeferredItem<DeferredSpawnEggItem> ANKH_SPAWN_EGG = ITEMS.register("ankh_spawn_egg",
                () -> new DeferredSpawnEggItem(ANKH, 0xFF2300, 0x42FF00, new Item.Properties()));
       
       public static final RegistryObject<EntityType<AnkhCompleteEntity>> ANKHCOMPLETE = MOBLIST.register("ankh_complete_mob",
               () -> EntityType.Builder.of(AnkhCompleteEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":ankh_complete_mob"));

        public static final DeferredItem<DeferredSpawnEggItem> ANKH_COMPLETE_SPAWN_EGG = ITEMS.register("ankh_complete_spawn_egg",
                () -> new DeferredSpawnEggItem(ANKHCOMPLETE, 0x000000, 0xFF0000, new Item.Properties()));
        
        public static final RegistryObject<EntityType<AnkhLostEntity>> ANKH_LOST = MOBLIST.register("ankh_lost_mob",
                () -> EntityType.Builder.of(AnkhLostEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":ankh_lost_mob"));

        public static final DeferredItem<DeferredSpawnEggItem> ANKH_LOST_SPAWN_EGG = ITEMS.register("ankh_lost_spawn_egg",
                 () -> new DeferredSpawnEggItem(ANKH_LOST, 0x000000, 0xC61500, new Item.Properties()));
         
        
        public static final RegistryObject<EntityType<UvaEntity>> UVA = MOBLIST.register("uva_mob",
                () -> EntityType.Builder.of(UvaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":uva_mob"));

         public static final DeferredItem<DeferredSpawnEggItem> UVA_SPAWN_EGG = ITEMS.register("uva_spawn_egg",
                 () -> new DeferredSpawnEggItem(UVA, 0x000000, 0x00FF1F, new Item.Properties()));
        
         
         public static final RegistryObject<EntityType<KazariEntity>> KAZARI = MOBLIST.register("kazari_mob",
                 () -> EntityType.Builder.of(KazariEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":kazari_mob"));

          public static final DeferredItem<DeferredSpawnEggItem> KAZARI_SPAWN_EGG = ITEMS.register("kazari_spawn_egg",
                  () -> new DeferredSpawnEggItem(KAZARI, 0x000000, 0xFFDC00, new Item.Properties()));
          
         
          public static final RegistryObject<EntityType<MezoolEntity>> MEZOOL = MOBLIST.register("mezool_mob",
                  () -> EntityType.Builder.of(MezoolEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":mezool_mob"));

          public static final DeferredItem<DeferredSpawnEggItem> MEZOOL_SPAWN_EGG = ITEMS.register("mezool_spawn_egg",
                   () -> new DeferredSpawnEggItem(MEZOOL, 0x000000, 0x0000FF, new Item.Properties()));
          
          
          public static final RegistryObject<EntityType<GamelEntity>> GAMEL = MOBLIST.register("gamel_mob",
                  () -> EntityType.Builder.of(GamelEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":gamel_mob"));

          public static final DeferredItem<DeferredSpawnEggItem> GAMEL_SPAWN_EGG = ITEMS.register("gamel_spawn_egg",
                   () -> new DeferredSpawnEggItem(GAMEL, 0x000000, 0xBFBFBF, new Item.Properties()));
          
          
          public static final RegistryObject<EntityType<MuchiriEntity>> MUCHIRI = MOBLIST.register("muchiri_mob",
                  () -> EntityType.Builder.of(MuchiriEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":muchiri_mob"));

          public static final DeferredItem<DeferredSpawnEggItem> MUCHIRI_SPAWN_EGG = ITEMS.register("muchiri_spawn_egg",
                   () -> new DeferredSpawnEggItem(MUCHIRI, 0x000000, 0xFF9E00, new Item.Properties()));
          
          public static final RegistryObject<EntityType<PoseidonEntity>> POSEIDON = MOBLIST.register("poseidon",
                  () -> EntityType.Builder.of(PoseidonEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":poseidon"));

          public static final DeferredItem<DeferredSpawnEggItem> POSEIDON_SPAWN_EGG = ITEMS.register("poseidon_spawn_egg",
                   () -> new DeferredSpawnEggItem(POSEIDON, 0xD11B1E, 0x30BBEC, new Item.Properties()));
         
          public static final RegistryObject<EntityType<CoreEntity>> CORE = MOBLIST.register("core",
                  () -> EntityType.Builder.of(CoreEntity::new, MobCategory.MONSTER).sized(1.8F, 5.85F).fireImmune().clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":core"));

          public static final DeferredItem<DeferredSpawnEggItem> CORE_SPAWN_EGG = ITEMS.register("core_spawn_egg",
                   () -> new DeferredSpawnEggItem(CORE, 0x312511, 0xF97012, new Item.Properties()));
         
          
          public static final RegistryObject<EntityType<PoweredUpCoreEntity>> POWERED_UP_CORE = MOBLIST.register("powered_up_core",
                  () -> EntityType.Builder.of(PoweredUpCoreEntity::new, MobCategory.MONSTER).sized(1.8F, 5.85F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":powered_up_core"));

          public static final DeferredItem<DeferredSpawnEggItem> POWERED_UP_CORE_SPAWN_EGG = ITEMS.register("powered_up_core_spawn_egg",
                   () -> new DeferredSpawnEggItem(POWERED_UP_CORE, 0x51115D, 0xB419D1, new Item.Properties()));
          
          public static final RegistryObject<EntityType<AncientOOOEntity>> ANCIENT_OOO = MOBLIST.register("ancient_ooo",
                  () -> EntityType.Builder.of(AncientOOOEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":ancient_ooo"));

          public static final DeferredItem<DeferredSpawnEggItem> ANCIENT_OOO_SPAWN_EGG = ITEMS.register("ancient_ooo_spawn_egg",
                   () -> new DeferredSpawnEggItem(ANCIENT_OOO, 0x262320, 0xE5B216, new Item.Properties()));
          
          public static final RegistryObject<EntityType<GodaEntity>> GODA = MOBLIST.register("goda",
                  () -> EntityType.Builder.of(GodaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":goda"));

          public static final DeferredItem<DeferredSpawnEggItem> GODA_SPAWN_EGG = ITEMS.register("goda_spawn_egg",
                   () -> new DeferredSpawnEggItem(GODA, 0x000000, 0xB200FF, new Item.Properties()));
          
          
          public static final RegistryObject<EntityType<BugsterVirusEntity>> BUGSTERVIRUS = MOBLIST.register("bugstervirus_mob",
                  () -> EntityType.Builder.of(BugsterVirusEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":bugster_mob"));
          
          public static final DeferredItem<DeferredSpawnEggItem> BUGSTERVIRUS_SPAWN_EGG = ITEMS.register("bugstervirus_spawn_egg",
                  () -> new DeferredSpawnEggItem(BUGSTERVIRUS, 0xFF7400, 0x150E08, new Item.Properties()));
          

          public static final RegistryObject<EntityType<MightyBugsterEntity>> MIGHTY_BUGSTER = MOBLIST.register("mighty_bugster_mob",
                  () -> EntityType.Builder.of(MightyBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":mighty_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> MIGHTY_BUGSTER_SPAWN_EGG = ITEMS.register("mighty_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(MIGHTY_BUGSTER, 0xFF7400, 0xFF0EFB, new Item.Properties()));
          
          public static final RegistryObject<EntityType<TaddleBugsterEntity>> TADDLE_BUGSTER = MOBLIST.register("taddle_bugster_mob",
                  () -> EntityType.Builder.of(TaddleBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":taddle_bugster_mob"));
          
          public static final DeferredItem<DeferredSpawnEggItem> TADDLE_BUGSTER_SPAWN_EGG = ITEMS.register("taddle_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(TADDLE_BUGSTER, 0xFF7400, 0x0EF0FF, new Item.Properties()));
          
          public static final RegistryObject<EntityType<BangBangBugsterEntity>> BANG_BANG_BUGSTER = MOBLIST.register("bang_bang_bugster_mob",
                  () -> EntityType.Builder.of(BangBangBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":bang_bang_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> BANG_BANG_BUGSTER_SPAWN_EGG = ITEMS.register("bang_bang_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(BANG_BANG_BUGSTER, 0xFF7400, 0x442AD5, new Item.Properties()));
         
          public static final RegistryObject<EntityType<LovelyBugsterEntity>> LOVELY_BUGSTER = MOBLIST.register("lovely_bugster_mob",
                  () -> EntityType.Builder.of(LovelyBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":lovely_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> LOVELY_BUGSTER_SPAWN_EGG = ITEMS.register("lovely_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(LOVELY_BUGSTER, 0xFF7400, 0xE479FA, new Item.Properties()));
          
          public static final RegistryObject<EntityType<SaltyBugsterEntity>> SALTY_BUGSTER = MOBLIST.register("salty_bugster_mob",
                  () -> EntityType.Builder.of(SaltyBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":salty_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> SALTY_BUGSTER_SPAWN_EGG = ITEMS.register("salty_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(SALTY_BUGSTER, 0x1C15E5, 0x131315, new Item.Properties()));

          public static final RegistryObject<EntityType<CharlieBugsterEntity>> CHARLIE_BUGSTER = MOBLIST.register("charlie_bugster_mob",
                  () -> EntityType.Builder.of(CharlieBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":charlie_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> CHARLIE_BUGSTER_SPAWN_EGG = ITEMS.register("charlie_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(CHARLIE_BUGSTER, 0x1C15E5, 0x79B6EC, new Item.Properties()));
          
          public static final RegistryObject<EntityType<GattonBugsterEntity>> GATTON_BUGSTER = MOBLIST.register("gatton_bugster_mob",
                  () -> EntityType.Builder.of(GattonBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":gatton_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> GATTON_BUGSTER_SPAWN_EGG = ITEMS.register("gatton_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(GATTON_BUGSTER, 0x1C15E5, 0xF71D0B, new Item.Properties()));
          
          public static final RegistryObject<EntityType<KaidenBugsterEntity>> KAIDEN_BUGSTER = MOBLIST.register("kaiden_bugster_mob",
                  () -> EntityType.Builder.of(KaidenBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":kaiden_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> KAIDEN_BUGSTER_SPAWN_EGG = ITEMS.register("kaiden_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(KAIDEN_BUGSTER, 0x1C15E5, 0x9C1408, new Item.Properties()));
          
          public static final RegistryObject<EntityType<MotorsBugsterEntity>> MOTORS_BUGSTER = MOBLIST.register("motors_bugster_mob",
                  () -> EntityType.Builder.of(MotorsBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":motors_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> MOTORS_BUGSTER_SPAWN_EGG = ITEMS.register("motors_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(MOTORS_BUGSTER, 0x1C15E5, 0xF5C40C, new Item.Properties()));
          
          public static final RegistryObject<EntityType<VernierBugsterEntity>> VERNIER_BUGSTER = MOBLIST.register("vernier_bugster_mob",
                  () -> EntityType.Builder.of(VernierBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":vernier_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> VERNIER_BUGSTER_SPAWN_EGG = ITEMS.register("vernier_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(VERNIER_BUGSTER, 0x1C15E5, 0xF58B0C, new Item.Properties()));

          public static final RegistryObject<EntityType<GraphiteBugsterEntity>> GRAPHITE_BUGSTER = MOBLIST.register("graphite_bugster_mob",
                  () -> EntityType.Builder.of(GraphiteBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":graphite_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> GRAPHITE_BUGSTER_SPAWN_EGG = ITEMS.register("graphite_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(GRAPHITE_BUGSTER, 0x1C15E5, 0x127120, new Item.Properties()));
          

          public static final RegistryObject<EntityType<AranburaBugsterEntity>> ARANBURA_BUGSTER = MOBLIST.register("aranbura_bugster_mob",
                  () -> EntityType.Builder.of(AranburaBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":aranbura_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> ARANBURA_BUGSTER_SPAWN_EGG = ITEMS.register("aranbura_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(ARANBURA_BUGSTER, 0x1C15E5, 0xF52B0B, new Item.Properties()));
          
          public static final RegistryObject<EntityType<RevolBugsterEntity>> REVOL_BUGSTER = MOBLIST.register("revol_bugster_mob",
                  () -> EntityType.Builder.of(RevolBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":revol_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> REVOL_BUGSTER_SPAWN_EGG = ITEMS.register("revol_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(REVOL_BUGSTER, 0x1C15E5, 0x8AB2E0, new Item.Properties()));
       
          
          public static final RegistryObject<EntityType<LovelicaBugsterEntity>> LOVELICA_BUGSTER = MOBLIST.register("lovelica_bugster_mob",
                  () -> EntityType.Builder.of(LovelicaBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":lovelica_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> LOVELICA_BUGSTER_SPAWN_EGG = ITEMS.register("lovelica_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(LOVELICA_BUGSTER, 0x1C15E5, 0xC865F3, new Item.Properties()));
          

          
          public static final RegistryObject<EntityType<GenmEntity>> GENM = MOBLIST.register("genm_mob",
                  () -> EntityType.Builder.of(GenmEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":genm_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> GENM_SPAWN_EGG = ITEMS.register("genm_spawn_egg",
                  () -> new DeferredSpawnEggItem(GENM, 0x201F20, 0x8629F6, new Item.Properties()));
          
          public static final RegistryObject<EntityType<PoppyRedEntity>> POPPY_RED = MOBLIST.register("poppy_red_mob",
                  () -> EntityType.Builder.of(PoppyRedEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":poppy_red_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> POPPY_RED_SPAWN_EGG = ITEMS.register("poppy_red_spawn_egg",
                  () -> new DeferredSpawnEggItem(POPPY_RED, 0xE0C819, 0xC865F3, new Item.Properties()));
          
          public static final RegistryObject<EntityType<RideplayerEntity>> RIDEPLAYER = MOBLIST.register("rideplayer",
                  () -> EntityType.Builder.of(RideplayerEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":rideplayer_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> RIDEPLAYER_SPAWN_EGG = ITEMS.register("rideplayer_spawn_egg",
                  () -> new DeferredSpawnEggItem(RIDEPLAYER, 0xf1c192, 0x854303, new Item.Properties()));
          
          public static final RegistryObject<EntityType<ParaDxEntity>> PARADX = MOBLIST.register("para-dx",
                  () -> EntityType.Builder.of(ParaDxEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":paradx_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> PARADX_SPAWN_EGG = ITEMS.register("paradx_spawn_egg",
                  () -> new DeferredSpawnEggItem(PARADX, 0xff0000, 0x2a00ff, new Item.Properties()));
          
          public static final RegistryObject<EntityType<CronusEntity>> CRONUS = MOBLIST.register("cronus",
                  () -> EntityType.Builder.of(CronusEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":cronus_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> CRONUS_SPAWN_EGG = ITEMS.register("cronus_spawn_egg",
                  () -> new DeferredSpawnEggItem(CRONUS, 0x000000, 0x44df00, new Item.Properties()));
          
          
          public static final RegistryObject<EntityType<TrilobiteMagiaEntity>> TRILOBITE_MAGIA = MOBLIST.register("trilobite_magia",
                  () -> EntityType.Builder.of(TrilobiteMagiaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":trilobite_magia"));
 
          public static final DeferredItem<DeferredSpawnEggItem> TRILOBITE_MAGIA_SPAWN_EGG = ITEMS.register("trilobite_magia_spawn_egg",
                  () -> new DeferredSpawnEggItem(TRILOBITE_MAGIA, 0x060606, 0xa2a2a2, new Item.Properties()));

          public static final RegistryObject<EntityType<DodoMagiaChickEntity>> DODO_MAGIA_CHICK = MOBLIST.register("dodo_magia_chick",
                  () -> EntityType.Builder.of(DodoMagiaChickEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":dodo_magia_chick"));
 
          public static final DeferredItem<DeferredSpawnEggItem> DODO_MAGIA_CHICK_SPAWN_EGG = ITEMS.register("dodo_magia_chick_spawn_egg",
                  () -> new DeferredSpawnEggItem(DODO_MAGIA_CHICK, 0x7d0b0a, 0x242424, new Item.Properties()));

          public static final RegistryObject<EntityType<BattleRaiderEntity>> BATTLE_RAIDER = MOBLIST.register("battle_raider",
                  () -> EntityType.Builder.of(BattleRaiderEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":battle_raider"));
 
          public static final DeferredItem<DeferredSpawnEggItem> BATTLE_RAIDER_SPAWN_EGG = ITEMS.register("battle_raider_spawn_egg",
                  () -> new DeferredSpawnEggItem(BATTLE_RAIDER, 0x1d1d1d, 0x000000, new Item.Properties()));

          public static final RegistryObject<EntityType<AbaddonEntity>> ABADDON = MOBLIST.register("abaddon",
                  () -> EntityType.Builder.of(AbaddonEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":abaddon"));
 
          public static final DeferredItem<DeferredSpawnEggItem> ABADDON_SPAWN_EGG = ITEMS.register("abaddon_spawn_egg",
                  () -> new DeferredSpawnEggItem(ABADDON, 0x5d6837, 0xc1b810, new Item.Properties()));

          public static final RegistryObject<EntityType<MagiaEntity>> MAGIA = MOBLIST.register("magia",
                  () -> EntityType.Builder.of(MagiaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":magia"));
 
          public static final DeferredItem<DeferredSpawnEggItem> MAGIA_SPAWN_EGG = ITEMS.register("magia_spawn_egg",
                  () -> new DeferredSpawnEggItem(MAGIA, 0x060606, 0xa2a2a2, new Item.Properties()));

          public static final RegistryObject<EntityType<GigerEntity>> GIGER = MOBLIST.register("giger",
                  () -> EntityType.Builder.of(GigerEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":giger"));
 
          public static final DeferredItem<DeferredSpawnEggItem> GIGER_SPAWN_EGG = ITEMS.register("giger_spawn_egg",
                  () -> new DeferredSpawnEggItem(GIGER, 0x9c00b2, 0x1f1f1f, new Item.Properties()));

          public static final RegistryObject<EntityType<JinEntity>> JIN = MOBLIST.register("jin",
                  () -> EntityType.Builder.of(JinEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":jin"));
 
          public static final DeferredItem<DeferredSpawnEggItem> JIN_SPAWN_EGG = ITEMS.register("jin_spawn_egg",
                  () -> new DeferredSpawnEggItem(JIN, 0xff65b9, 0xd5d5d5, new Item.Properties()));

          public static final RegistryObject<EntityType<DodoMagiaEntity>> DODO_MAGIA = MOBLIST.register("dodo_magia",
                  () -> EntityType.Builder.of(DodoMagiaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":dodo_magia"));
 
          public static final DeferredItem<DeferredSpawnEggItem> DODO_MAGIA_SPAWN_EGG = ITEMS.register("dodo_magia_spawn_egg",
                  () -> new DeferredSpawnEggItem(DODO_MAGIA, 0x7d0b0a, 0x242424, new Item.Properties()));

          public static final RegistryObject<EntityType<RaiderEntity>> RAIDER = MOBLIST.register("raider",
                  () -> EntityType.Builder.of(RaiderEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":raider"));
 
          public static final DeferredItem<DeferredSpawnEggItem> RAIDER_SPAWN_EGG = ITEMS.register("raider_spawn_egg",
                  () -> new DeferredSpawnEggItem(RAIDER, 0x1d1d1d, 0x000000, new Item.Properties()));

          public static final RegistryObject<EntityType<NakiEntity>> NAKI = MOBLIST.register("naki",
                  () -> EntityType.Builder.of(NakiEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":naki"));
 
          public static final DeferredItem<DeferredSpawnEggItem> NAKI_SPAWN_EGG = ITEMS.register("naki_spawn_egg",
                  () -> new DeferredSpawnEggItem(NAKI, 0xcbcbcb, 0x0024fe, new Item.Properties()));

          public static final RegistryObject<EntityType<ZaiaEntity>> ZAIA = MOBLIST.register("zaia",
                  () -> EntityType.Builder.of(ZaiaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":zaia"));
 
          public static final DeferredItem<DeferredSpawnEggItem> ZAIA_SPAWN_EGG = ITEMS.register("zaia_spawn_egg",
                  () -> new DeferredSpawnEggItem(ZAIA, 0x161616, 0xc2c2c2, new Item.Properties()));

          public static final RegistryObject<EntityType<DireWolfSoldMagiaEntity>> DIRE_WOLF_SOLD_MAGIA = MOBLIST.register("dire_wolf_sold_magia",
                  () -> EntityType.Builder.of(DireWolfSoldMagiaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":dire_wolf_sold_magia"));
 
          public static final DeferredItem<DeferredSpawnEggItem> DIRE_WOLF_SOLD_MAGIA_SPAWN_EGG = ITEMS.register("dire_wolf_sold_magia_spawn_egg",
                  () -> new DeferredSpawnEggItem(DIRE_WOLF_SOLD_MAGIA, 0x454b4b, 0x0033c4, new Item.Properties()));

          public static final RegistryObject<EntityType<ServalTigerSoldMagiaEntity>> SERVAL_TIGER_SOLD_MAGIA = MOBLIST.register("serval_tiger_sold_magia",
                  () -> EntityType.Builder.of(ServalTigerSoldMagiaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":serval_tiger_sold_magia"));
 
          public static final DeferredItem<DeferredSpawnEggItem> SERVAL_TIGER_SOLD_MAGIA_SPAWN_EGG = ITEMS.register("serval_tiger_sold_magia_spawn_egg",
                  () -> new DeferredSpawnEggItem(SERVAL_TIGER_SOLD_MAGIA, 0x454b4b, 0xce7100, new Item.Properties()));

          public static final RegistryObject<EntityType<AbaddonCommanderEntity>> ABADDON_COMMANDER = MOBLIST.register("abaddon_commander",
                  () -> EntityType.Builder.of(AbaddonCommanderEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":abaddon_commander"));
 
          public static final DeferredItem<DeferredSpawnEggItem> ABADDON_COMMANDER_SPAWN_EGG = ITEMS.register("abaddon_commander_spawn_egg",
                  () -> new DeferredSpawnEggItem(ABADDON_COMMANDER, 0x5d6837, 0xc30000, new Item.Properties()));

          public static final RegistryObject<EntityType<EdenEntity>> EDEN = MOBLIST.register("eden",
                  () -> EntityType.Builder.of(EdenEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":eden"));
 
          public static final DeferredItem<DeferredSpawnEggItem> EDEN_SPAWN_EGG = ITEMS.register("eden_spawn_egg",
                  () -> new DeferredSpawnEggItem(EDEN, 0x0e1257, 0x910101, new Item.Properties()));

          public static final RegistryObject<EntityType<HorobiEntity>> HOROBI = MOBLIST.register("horobi",
                  () -> EntityType.Builder.of(HorobiEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":horobi"));
 
          public static final DeferredItem<DeferredSpawnEggItem> HOROBI_SPAWN_EGG = ITEMS.register("horobi_spawn_egg",
                  () -> new DeferredSpawnEggItem(HOROBI, 0x8a00c3, 0x383838, new Item.Properties()));

          public static final RegistryObject<EntityType<IkazuchiEntity>> IKAZUCHI = MOBLIST.register("ikazuchi",
                  () -> EntityType.Builder.of(IkazuchiEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":ikazuchi"));
 
          public static final DeferredItem<DeferredSpawnEggItem> IKAZUCHI_SPAWN_EGG = ITEMS.register("ikazuchi_spawn_egg",
                  () -> new DeferredSpawnEggItem(IKAZUCHI, 0x7d0b0a, 0x242424, new Item.Properties()));

          public static final RegistryObject<EntityType<ArkZeroEntity>> ARK_ZERO = MOBLIST.register("ark_zero",
                  () -> EntityType.Builder.of(ArkZeroEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":ark_zero"));
 
          public static final DeferredItem<DeferredSpawnEggItem> ARK_ZERO_SPAWN_EGG = ITEMS.register("ark_zero_spawn_egg",
                  () -> new DeferredSpawnEggItem(ARK_ZERO, 0x161616, 0xC40000, new Item.Properties()));


          public static final RegistryObject<EntityType<PawnJyamatoEntity>> PAWN_JYAMATO = MOBLIST.register("pawnjyamato_mob",
                  () -> EntityType.Builder.of(PawnJyamatoEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":pawnjyamato_mob"));
          
          public static final DeferredItem<DeferredSpawnEggItem> PAWN_JYAMATO_SPAWN_EGG = ITEMS.register("pawnjyamato_spawn_egg",
                  () -> new DeferredSpawnEggItem(PAWN_JYAMATO, 0xDBD39B, 0x22A215, new Item.Properties()));
          
          public static final RegistryObject<EntityType<JyamatoRiderEntity>> JYAMATO_RIDER = MOBLIST.register("jyamatorider",
                  () -> EntityType.Builder.of(JyamatoRiderEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":jyamatorider"));
 
          public static final DeferredItem<DeferredSpawnEggItem> JYAMATO_RIDER_SPAWN_EGG = ITEMS.register("jyamatorider_spawn_egg",
                  () -> new DeferredSpawnEggItem(JYAMATO_RIDER, 0x0F100F, 0x22A215, new Item.Properties()));
          
          public static final RegistryObject<EntityType<GmRiderEntity>> GM_RIDER = MOBLIST.register("gmrider",
                  () -> EntityType.Builder.of(GmRiderEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":jyamatorider"));
 
          public static final DeferredItem<DeferredSpawnEggItem> GM_RIDER_SPAWN_EGG = ITEMS.register("gmrider_spawn_egg",
                  () -> new DeferredSpawnEggItem(GM_RIDER, 0x0F100F, 0x9B0E52, new Item.Properties()));
          
          
          public static final RegistryObject<EntityType<MachineTornadorEntity>> MACEHINE_TORADOR = MOBLIST.register("machine_tornador",
                  () -> EntityType.Builder.of(MachineTornadorEntity::new, MobCategory.MONSTER).clientTrackingRange(8).sized(0.6F, 1.95F).build( KamenRiderCraftCore.MODID + ":machine_tornador"));

          public static final DeferredItem<DeferredSpawnEggItem> MACEHINE_TORADOR_SPAWN_EGG = ITEMS.register("machine_tornador_spawn_egg",
                  () -> new DeferredSpawnEggItem(MACEHINE_TORADOR, 0xffffff, 0xffe300, new Item.Properties()));

          public static final RegistryObject<EntityType<HardboilderEntity>> HARDBOILER = MOBLIST.register("hardboilder",
                  () -> EntityType.Builder.of(HardboilderEntity::new, MobCategory.MONSTER).clientTrackingRange(8).sized(0.6F, 1.95F).build( KamenRiderCraftCore.MODID + ":hardboilder"));

          public static final DeferredItem<DeferredSpawnEggItem> HARDBOILER_SPAWN_EGG = ITEMS.register("hardboilder_spawn_egg",
                  () -> new DeferredSpawnEggItem(HARDBOILER,  0xffffff, 0x222222, new Item.Properties()));
      
          public static final RegistryObject<EntityType<SkullboilderEntity>> SKULLBOILER = MOBLIST.register("skullboilder",
                  () -> EntityType.Builder.of(SkullboilderEntity::new, MobCategory.MONSTER).clientTrackingRange(8).sized(0.6F, 1.95F).build( KamenRiderCraftCore.MODID + ":skullboilder"));

          public static final DeferredItem<DeferredSpawnEggItem> SKULLBOILER_SPAWN_EGG = ITEMS.register("skullboilder_spawn_egg",
                  () -> new DeferredSpawnEggItem(SKULLBOILER, 0xffffff, 0x151515, new Item.Properties()));
      
                  
          public static final RegistryObject<EntityType<RiderSummonEntity>> RIDER_SUMMON = MOBLIST.register("rider_summon",
                  () -> EntityType.Builder.of(RiderSummonEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":rider_summon"));

          public static final DeferredItem<DeferredSpawnEggItem> RIDER_SUMMON_SPAWN_EGG = ITEMS.register("rider_summon_spawn_egg",
                  () -> new DeferredSpawnEggItem(RIDER_SUMMON, 0xEC008C, 0x222222, new Item.Properties()));
          
          public static final RegistryObject<EntityType<ParaDXSummonEntity>> PARADX_SUMMON = MOBLIST.register("paradx_summon",
                  () -> EntityType.Builder.of(ParaDXSummonEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MODID + ":paradx_summon"));

          public static final DeferredItem<DeferredSpawnEggItem> PARADX_SUMMON_SPAWN_EGG = ITEMS.register("paradx_summon_spawn_egg",
                  () -> new DeferredSpawnEggItem(PARADX_SUMMON, 0xffa500, 0x00bccf, new Item.Properties()));
      **/

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
