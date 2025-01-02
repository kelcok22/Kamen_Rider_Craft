package com.kelco.kamenridercraft.entities;


import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.entities.allies.*;
import com.kelco.kamenridercraft.entities.bikes.*;
import com.kelco.kamenridercraft.entities.bosses.*;
import com.kelco.kamenridercraft.entities.footSoldiers.*;
import com.kelco.kamenridercraft.entities.summons.*;

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
	//public static final DeferredRegister<EntityType<?>> MOBLIST = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, KamenRiderCraftCore.MOD_ID);
    public static final DeferredRegister<EntityType<?>> MOBLIST  = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE,KamenRiderCraftCore.MOD_ID);


    public static final DeferredHolder<EntityType<?>, EntityType<ShockerCombatmanEntity>> SHOCKER_COMBATMAN = MOBLIST.register("shocker_combatman",
            () -> EntityType.Builder.of(ShockerCombatmanEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":shocker_combatman"));
    
    public static final DeferredItem<DeferredSpawnEggItem> SHOCKER_COMBATMAN_SPAWN_EGG = ITEMS.register("shocker_combatman_spawn_egg",
            () -> new DeferredSpawnEggItem(SHOCKER_COMBATMAN, 000000,0xFFFFFF, new Item.Properties()));
 
    public static final DeferredHolder<EntityType<?>, EntityType<ShockerRidersEntity>> SHOCKER_RIDER = MOBLIST.register("shocker_riders",
            () -> EntityType.Builder.of(ShockerRidersEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":shocker_riders"));
    
    public static final DeferredItem<DeferredSpawnEggItem> SHOCKER_RIDER_SPAWN_EGG = ITEMS.register("shocker_riders_spawn_egg",
            () -> new DeferredSpawnEggItem(SHOCKER_RIDER, 0x53aa8e,0xd6b500, new Item.Properties()));
 

    
    public static final  DeferredHolder<EntityType<?>, EntityType<DestronCombatmanEntity>> DESTRON_COMBATMAN = MOBLIST.register("destron_combatman",
            () -> EntityType.Builder.of(DestronCombatmanEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":destron_combatman"));
    
    public static final DeferredItem<DeferredSpawnEggItem> DESTRON_COMBATMAN_SPAWN_EGG = ITEMS.register("destron_combatman_spawn_egg",
            () -> new DeferredSpawnEggItem(DESTRON_COMBATMAN, 000000,0xFFFFFF, new Item.Properties()));
 
    

    public static final DeferredHolder<EntityType<?>, EntityType<GODWarfareAgentEntity>> GOD_WARFARE_AGENT = MOBLIST.register("god_warfare_agent",
            () -> EntityType.Builder.of(GODWarfareAgentEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":god_warfare_agent"));
    
    public static final DeferredItem<DeferredSpawnEggItem> GOD_WARFARE_AGENT_SPAWN_EGG = ITEMS.register("god_warfare_agent_spawn_egg",
            () -> new DeferredSpawnEggItem(GOD_WARFARE_AGENT, 000000,0x7e0000, new Item.Properties()));
 
    
    
    public static final DeferredHolder<EntityType<?>, EntityType<RedFollowerEntity>> RED_FOLLWER = MOBLIST.register("red_follower",
            () -> EntityType.Builder.of(RedFollowerEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":red_follower"));
    
    public static final DeferredItem<DeferredSpawnEggItem> RED_FOLLWER_SPAWN_EGG = ITEMS.register("red_follower_spawn_egg",
            () -> new DeferredSpawnEggItem(RED_FOLLWER,  0x7e0000,0xcacaca, new Item.Properties()));

    
    
    public static final DeferredHolder<EntityType<?>, EntityType<BlackSatanSoldierEntity>> BLACK_SATAN_SOLDIER = MOBLIST.register("black_satan_soldier",
            () -> EntityType.Builder.of(BlackSatanSoldierEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":black_satan_soldier"));
    
    public static final DeferredItem<DeferredSpawnEggItem> BLACK_SATAN_SOLDIER_SPAWN_EGG = ITEMS.register("black_satan_soldier_spawn_egg",
            () -> new DeferredSpawnEggItem(BLACK_SATAN_SOLDIER, 000000,0x7e0000, new Item.Properties()));

    
    
    public static final DeferredHolder<EntityType<?>, EntityType<AriCommandoEntity>> ARI_COMMANDO = MOBLIST.register("ari_commando",
            () -> EntityType.Builder.of(AriCommandoEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":ari_commando"));
    
    public static final DeferredItem<DeferredSpawnEggItem> ARI_COMMANDO_SPAWN_EGG = ITEMS.register("ari_commando_spawn_egg",
            () -> new DeferredSpawnEggItem(ARI_COMMANDO, 000000,0x121212, new Item.Properties()));

    
    
    public static final DeferredHolder<EntityType<?>, EntityType<DogmaFighterEntity>> DOGMA_FIGHTER = MOBLIST.register("dogma_fighter",
            () -> EntityType.Builder.of(DogmaFighterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":dogma_fighter"));
    
    public static final DeferredItem<DeferredSpawnEggItem> DOGMA_FIGHTER_SPAWN_EGG = ITEMS.register("dogma_fighter_spawn_egg",
            () -> new DeferredSpawnEggItem(DOGMA_FIGHTER, 0x730000,0xa5a5a5, new Item.Properties()));
 
    
    
    public static final DeferredHolder<EntityType<?>, EntityType<CombatRoidEntity>> COMBAT_ROID = MOBLIST.register("combat_roid",
            () -> EntityType.Builder.of(CombatRoidEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":combat_roid"));
    
    public static final DeferredItem<DeferredSpawnEggItem> COMBAT_ROID_SPAWN_EGG = ITEMS.register("combat_roid_spawn_egg",
            () -> new DeferredSpawnEggItem(COMBAT_ROID, 0xa5a5a5,0x8c0000, new Item.Properties()));



    public static final DeferredHolder<EntityType<?>, EntityType<ChapEntity>> CHAP = MOBLIST.register("chap",
           () -> EntityType.Builder.of(ChapEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":chap"));
    
    public static final DeferredItem<DeferredSpawnEggItem> CHAP_SPAWN_EGG = ITEMS.register("chap_spawn_egg",
           () -> new DeferredSpawnEggItem(CHAP,  000000,0xFFFFFF, new Item.Properties()));
 
    public static final DeferredHolder<EntityType<?>, EntityType<ShadowmoonEntity>> SHADOWMOON = MOBLIST.register("shadowmoon",
            () -> EntityType.Builder.of(ShadowmoonEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":shadowmoon"));
     
     public static final DeferredItem<DeferredSpawnEggItem> SHADOWMOON_SPAWN_EGG = ITEMS.register("shadowmoon_spawn_egg",
            () -> new DeferredSpawnEggItem(SHADOWMOON,  0xbabab6,0x00a01c, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<ChapGreyEntity>> CHAP_GREY = MOBLIST.register("chap_grey",
             () -> EntityType.Builder.of(ChapGreyEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":chap_grey"));
      
      public static final DeferredItem<DeferredSpawnEggItem> CHAP_GREY_SPAWN_EGG = ITEMS.register("chap_grey_spawn_egg",
             () -> new DeferredSpawnEggItem(CHAP_GREY,  0x919191,0xFFFFFF, new Item.Properties()));
     
     
     
     public static final DeferredHolder<EntityType<?>, EntityType<ZuGumunBaEntity>> ZU_GUMUN_BA = MOBLIST.register("zu_gumun_ba",
             () -> EntityType.Builder.of(ZuGumunBaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":zu_gumun_ba"));

     public static final DeferredItem<DeferredSpawnEggItem> ZU_GUMUN_BA_SPAWN_EGG = ITEMS.register("zu_gumun_ba_spawn_egg",
             () -> new DeferredSpawnEggItem(ZU_GUMUN_BA,  0xf8ba57,0xaf8e59, new Item.Properties()));


     public static final DeferredHolder<EntityType<?>, EntityType<PantherasLuteusEntity>> PANTHERAS_LUTEUS = MOBLIST.register("pantheras_luteus",
             () -> EntityType.Builder.of(PantherasLuteusEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":pantheras_luteus"));

     public static final DeferredItem<DeferredSpawnEggItem> PANTHERAS_LUTEUS_SPAWN_EGG = ITEMS.register("pantheras_luteus_spawn_egg",
             () -> new DeferredSpawnEggItem(PANTHERAS_LUTEUS,  0xffbe2e, 0xff3333, new Item.Properties()));
     
     public static final DeferredHolder<EntityType<?>, EntityType<ElOfTheWaterEntity>> EL_OF_THE_WATER = MOBLIST.register("el_of_the_water",
             () -> EntityType.Builder.of(ElOfTheWaterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":el_of_the_water"));

     public static final DeferredItem<DeferredSpawnEggItem> EL_OF_THE_WATER_SPAWN_EGG = ITEMS.register("el_of_the_water_spawn_egg",
             () -> new DeferredSpawnEggItem(EL_OF_THE_WATER,  0x27262d, 0xd1cfda, new Item.Properties()));
     
     public static final DeferredHolder<EntityType<?>, EntityType<AnguisMasculusEntity>> ANGUIS_MASCULUS = MOBLIST.register("anguis_masculus",
             () -> EntityType.Builder.of(AnguisMasculusEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":anguis_masculus"));

     public static final DeferredItem<DeferredSpawnEggItem> ANGUIS_MASCULUS_SPAWN_EGG = ITEMS.register("anguis_masculus_spawn_egg",
             () -> new DeferredSpawnEggItem(ANGUIS_MASCULUS,  0x445a94, 0xceb42b, new Item.Properties()));
     
     public static final DeferredHolder<EntityType<?>, EntityType<AnotherAgitoEntity>> ANOTHER_AGITO = MOBLIST.register("another_agito",
             () -> EntityType.Builder.of(AnotherAgitoEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":another_agito"));

     public static final DeferredItem<DeferredSpawnEggItem> ANOTHER_AGITO_SPAWN_EGG = ITEMS.register("another_agito_spawn_egg",
             () -> new DeferredSpawnEggItem(ANOTHER_AGITO,  0x273d31, 0x131313, new Item.Properties()));


     public static final DeferredHolder<EntityType<?>, EntityType<RiotrooperEntity>> RIOTROOPER = MOBLIST.register("riotrooper",
             () -> EntityType.Builder.of(RiotrooperEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":riotrooper"));

     public static final DeferredItem<DeferredSpawnEggItem> RIOTROOPER_SPAWN_EGG = ITEMS.register("riotrooper_spawn_egg",
             () -> new DeferredSpawnEggItem(RIOTROOPER,  0x11110e,0xfc911e, new Item.Properties()));
     
     public static final DeferredHolder<EntityType<?>, EntityType<OrgaEntity>> ORGA = MOBLIST.register("orga",
             () -> EntityType.Builder.of(OrgaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":orga"));

     public static final DeferredItem<DeferredSpawnEggItem> ORGA_SPAWN_EGG = ITEMS.register("orga_spawn_egg",
             () -> new DeferredSpawnEggItem(ORGA,  0x11110e,0xd5ba4c, new Item.Properties()));


     public static final DeferredHolder<EntityType<?>, EntityType<ZectrooperEntity>> ZECTROOPER = MOBLIST.register("zectrooper",
             () -> EntityType.Builder.of(ZectrooperEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":zectrooper"));

     public static final DeferredItem<DeferredSpawnEggItem> ZECTROOPER_SPAWN_EGG = ITEMS.register("zectrooper_spawn_egg",
             () -> new DeferredSpawnEggItem(ZECTROOPER,  0x1d1d1d,0x1d1d1d, new Item.Properties()));
     
     public static final DeferredHolder<EntityType<?>, EntityType<ShadowTrooperEntity>> SHADOW_TROOPER = MOBLIST.register("shadow_trooper",
             () -> EntityType.Builder.of(ShadowTrooperEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":shadow_trooper"));

     public static final DeferredItem<DeferredSpawnEggItem> SHADOW_TROOPER_SPAWN_EGG = ITEMS.register("shadow_trooper_spawn_egg",
             () -> new DeferredSpawnEggItem(SHADOW_TROOPER,  0x1d1d1d,0x1d1d1d, new Item.Properties()));
     
     public static final DeferredHolder<EntityType<?>, EntityType<NeotrooperEntity>> NEOTROOPER = MOBLIST.register("neotrooper",
             () -> EntityType.Builder.of(NeotrooperEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":neotrooper"));

     public static final DeferredItem<DeferredSpawnEggItem> NEOTROOPER_SPAWN_EGG = ITEMS.register("neotrooper_spawn_egg",
             () -> new DeferredSpawnEggItem(NEOTROOPER,  0x1d1d1d,0x1d1d1d, new Item.Properties()));
     
     public static final DeferredHolder<EntityType<?>, EntityType<CaucasusEntity>> CAUCASUS = MOBLIST.register("caucasus",
             () -> EntityType.Builder.of(CaucasusEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":caucasus"));

     public static final DeferredItem<DeferredSpawnEggItem> CAUCASUS_SPAWN_EGG = ITEMS.register("caucasus_spawn_egg",
             () -> new DeferredSpawnEggItem(CAUCASUS,  0x999999,0xf4c600, new Item.Properties()));


     public static final DeferredHolder<EntityType<?>, EntityType<NewMoleImaginEntity>> NEW_MOLE_IMAGIN = MOBLIST.register("new_mole_imagin",
             () -> EntityType.Builder.of(NewMoleImaginEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":new_mole_imagin"));

     public static final DeferredItem<DeferredSpawnEggItem> NEW_MOLE_IMAGIN_SPAWN_EGG = ITEMS.register("new_mole_imagin_spawn_egg",
             () -> new DeferredSpawnEggItem(NEW_MOLE_IMAGIN,  0xb7b7b1,0x92908b, new Item.Properties()));

     public static final DeferredHolder<EntityType<?>, EntityType<NewMoleImaginSandEntity>> NEW_MOLE_IMAGIN_SAND = MOBLIST.register("new_mole_imagin_sand",
             () -> EntityType.Builder.of(NewMoleImaginSandEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":new_mole_imagin_sand"));

     public static final DeferredItem<DeferredSpawnEggItem> NEW_MOLE_IMAGIN_SAND_SPAWN_EGG = ITEMS.register("new_mole_imagin_sand_spawn_egg",
             () -> new DeferredSpawnEggItem(NEW_MOLE_IMAGIN_SAND,  0xb7b7b1,0x92908b, new Item.Properties()));

     public static final DeferredHolder<EntityType<?>, EntityType<GaohEntity>> GAOH = MOBLIST.register("gaoh",
             () -> EntityType.Builder.of(GaohEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":gaoh"));

     public static final DeferredItem<DeferredSpawnEggItem> GAOH_SPAWN_EGG = ITEMS.register("gaoh_spawn_egg",
             () -> new DeferredSpawnEggItem(GAOH,  0x1d1d1d,0xdea302, new Item.Properties()));

     public static final DeferredHolder<EntityType<?>, EntityType<MomotarosEntity>> MOMOTAROS = MOBLIST.register("momotaros",
             () -> EntityType.Builder.of(MomotarosEntity::new, MobCategory.CREATURE).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":momotaros"));

     public static final DeferredItem<DeferredSpawnEggItem> MOMOTAROS_SPAWN_EGG = ITEMS.register("momotaros_spawn_egg",
             () -> new DeferredSpawnEggItem(MOMOTAROS,  0x790000,0xef0000, new Item.Properties()));

     public static final DeferredHolder<EntityType<?>, EntityType<UratarosEntity>> URATAROS = MOBLIST.register("urataros",
             () -> EntityType.Builder.of(UratarosEntity::new, MobCategory.CREATURE).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":urataros"));

     public static final DeferredItem<DeferredSpawnEggItem> URATAROS_SPAWN_EGG = ITEMS.register("urataros_spawn_egg",
             () -> new DeferredSpawnEggItem(URATAROS,  0x0075ec,0x003d7d, new Item.Properties()));

     public static final DeferredHolder<EntityType<?>, EntityType<KintarosEntity>> KINTAROS = MOBLIST.register("kintaros",
             () -> EntityType.Builder.of(KintarosEntity::new, MobCategory.CREATURE).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":kintaros"));

     public static final DeferredItem<DeferredSpawnEggItem> KINTAROS_SPAWN_EGG = ITEMS.register("kintaros_spawn_egg",
             () -> new DeferredSpawnEggItem(KINTAROS,  0x212121,0xd2a900, new Item.Properties()));

     public static final DeferredHolder<EntityType<?>, EntityType<RyutarosEntity>> RYUTAROS = MOBLIST.register("ryutaros",
             () -> EntityType.Builder.of(RyutarosEntity::new, MobCategory.CREATURE).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":ryutaros"));

     public static final DeferredItem<DeferredSpawnEggItem> RYUTAROS_SPAWN_EGG = ITEMS.register("ryutaros_spawn_egg",
             () -> new DeferredSpawnEggItem(RYUTAROS,  0x3b114e,0x2a0b38, new Item.Properties()));


     public static final DeferredHolder<EntityType<?>, EntityType<MasqueradeEntity>> MASQUERADE = MOBLIST.register("masquerade",
             () -> EntityType.Builder.of(MasqueradeEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":masquerade"));

     public static final DeferredItem<DeferredSpawnEggItem> MASQUERADE_SPAWN_EGG = ITEMS.register("masquerade_spawn_egg",
             () -> new DeferredSpawnEggItem(MASQUERADE,  000000,0xFFFFFF, new Item.Properties()));
      
     public static final DeferredHolder<EntityType<?>, EntityType<FoundationXMasqueradeEntity>> FOUNDATION_X_MASQUERADE = MOBLIST.register("foundation_x_masquerade",
             () -> EntityType.Builder.of(FoundationXMasqueradeEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":foundation_x_masquerade"));

     public static final DeferredItem<DeferredSpawnEggItem> FOUNDATION_X_MASQUERADE_SPAWN_EGG = ITEMS.register("foundation_x_masquerade_spawn_egg",
             () -> new DeferredSpawnEggItem(FOUNDATION_X_MASQUERADE,  000000,0xFFFFFF, new Item.Properties()));

   
     public static final DeferredHolder<EntityType<?>, EntityType<ClayDollDopantEntity>> CLAYDOLL_DOPANT = MOBLIST.register("claydoll_dopant",
            () -> EntityType.Builder.of(ClayDollDopantEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":claydoll_dopant"));

     public static final DeferredItem<DeferredSpawnEggItem> CLAYDOLL_DOPANT_SPAWN_EGG = ITEMS.register("claydoll_dopant_spawn_egg",
             () -> new DeferredSpawnEggItem(CLAYDOLL_DOPANT, 0x783f04,0xf7dabc, new Item.Properties()));

     public static final DeferredHolder<EntityType<?>, EntityType<NazcaDopantEntity>> NASCA_DOPANT = MOBLIST.register("nazca_dopant",
             () -> EntityType.Builder.of(NazcaDopantEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":nazca_dopant"));

      public static final DeferredItem<DeferredSpawnEggItem> NASCA_DOPANT_SPAWN_EGG = ITEMS.register("nazca_dopant_spawn_egg",
              () -> new DeferredSpawnEggItem(NASCA_DOPANT, 0x0092BB,0xff9f00, new Item.Properties()));

      /**
      public static final DeferredHolder<EntityType<?>, EntityType<RedNazcaDopantEntity>> RED_NASCA_DOPANT = MOBLIST.register("red_nazca_dopant",
              () -> EntityType.Builder.of(RedNazcaDopantEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":red_nazca_dopant"));

       public static final DeferredItem<DeferredSpawnEggItem> RED_NASCA_DOPANT_SPAWN_EGG = ITEMS.register("red_nazca_dopant_spawn_egg",
               () -> new DeferredSpawnEggItem(RED_NASCA_DOPANT, 0x161616,0x0092BB, new Item.Properties()));


       public static final DeferredHolder<EntityType<?>, EntityType<TabooDopantEntity>> TABOO_DOPANT = MOBLIST.register("taboo_dopant",
               () -> EntityType.Builder.of(TabooDopantEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":taboo_dopant"));

        public static final DeferredItem<DeferredSpawnEggItem> TABOO_DOPANT_SPAWN_EGG = ITEMS.register("taboo_dopant_spawn_egg",
                () -> new DeferredSpawnEggItem(TABOO_DOPANT_MASQUERADE, 0x161616,0x0092BB, new Item.Properties()));
        **/

        public static final DeferredHolder<EntityType<?>, EntityType<WeatherDopantEntity>> WEATHER_DOPANT = MOBLIST.register("weather_dopant",
                () -> EntityType.Builder.of(WeatherDopantEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":weather_dopant"));

         public static final DeferredItem<DeferredSpawnEggItem> WEATHER_DOPANT_SPAWN_EGG = ITEMS.register("weather_dopant_spawn_egg",
                 () -> new DeferredSpawnEggItem(WEATHER_DOPANT, 0xffffff,0xc1c1c1, new Item.Properties()));

         public static final DeferredHolder<EntityType<?>, EntityType<SmilodonDopantEntity>> SMILODON_DOPANT = MOBLIST.register("smilodon_dopant",
                 () -> EntityType.Builder.of(SmilodonDopantEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":smilodon_dopant"));

          public static final DeferredItem<DeferredSpawnEggItem> SMILODON_DOPANT_SPAWN_EGG = ITEMS.register("smilodon_dopant_spawn_egg",
                  () -> new DeferredSpawnEggItem(SMILODON_DOPANT, 0xc7b372,0x727272, new Item.Properties()));

           public static final DeferredHolder<EntityType<?>, EntityType<TerrorDopantEntity>> TERROR_DOPANT = MOBLIST.register("terror_dopant",
                   () -> EntityType.Builder.of(TerrorDopantEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":terror_dopant"));

            public static final DeferredItem<DeferredSpawnEggItem> TERROR_DOPANT_SPAWN_EGG = ITEMS.register("terror_dopant_spawn_egg",
                    () -> new DeferredSpawnEggItem(TERROR_DOPANT, 0x161616,0x0092BB, new Item.Properties()));


     public static final DeferredHolder<EntityType<?>, EntityType<CommanderDopantEntity>> COMMANDER_DOPANT = MOBLIST.register("commander_dopant",
             () -> EntityType.Builder.of(CommanderDopantEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":commander_dopant"));

      public static final DeferredItem<DeferredSpawnEggItem> COMMANDER_DOPANT_SPAWN_EGG = ITEMS.register("commander_dopant_spawn_egg",
              () -> new DeferredSpawnEggItem(COMMANDER_DOPANT, 0xc7b372,0x727272, new Item.Properties()));

     
     public static final DeferredHolder<EntityType<?>, EntityType<EternalEntity>> ETERNAL = MOBLIST.register("eternal_mob",
             () -> EntityType.Builder.of(EternalEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":eternal_mob"));

      public static final DeferredItem<DeferredSpawnEggItem> ETERNAL_SPAWN_EGG = ITEMS.register("eternal_spawn_egg",
              () -> new DeferredSpawnEggItem(ETERNAL, 0xFFFFFF, 0x0092BB, new Item.Properties()));


      public static final DeferredHolder<EntityType<?>, EntityType<YummyEntity>> YUMMY = MOBLIST.register("yummy_mob",
              () -> EntityType.Builder.of(YummyEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":yummy_mob"));

       public static final DeferredItem<DeferredSpawnEggItem> YUMMY_SPAWN_EGG = ITEMS.register("yummy_spawn_egg",
               () -> new DeferredSpawnEggItem(YUMMY, 0xE7E6B2, 0x959586, new Item.Properties()));

       public static final  DeferredHolder<EntityType<?>, EntityType<KnightSoldierEntity>> KNIGHT_SOLDIER = MOBLIST.register("knight_soldier_mob",
               () -> EntityType.Builder.of(KnightSoldierEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":knight_soldier_mob"));

        public static final DeferredItem<DeferredSpawnEggItem> KNIGHT_SOLDIER_SPAWN_EGG = ITEMS.register("knight_soldier_spawn_egg",
                () -> new DeferredSpawnEggItem(KNIGHT_SOLDIER, 0xca570f,0x919191, new Item.Properties()));

    
       public static final DeferredHolder<EntityType<?>, EntityType<AnkhEntity>> ANKH = MOBLIST.register("ankh_mob",
              () -> EntityType.Builder.of(AnkhEntity::new, MobCategory.CREATURE).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":ankh_mob"));

       public static final DeferredItem<DeferredSpawnEggItem> ANKH_SPAWN_EGG = ITEMS.register("ankh_spawn_egg",
                () -> new DeferredSpawnEggItem(ANKH, 0xFF2300, 0x42FF00, new Item.Properties()));

       public static final DeferredHolder<EntityType<?>, EntityType<AnkhCompleteEntity>> ANKHCOMPLETE = MOBLIST.register("ankh_complete_mob",
               () -> EntityType.Builder.of(AnkhCompleteEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":ankh_complete_mob"));

        public static final DeferredItem<DeferredSpawnEggItem> ANKH_COMPLETE_SPAWN_EGG = ITEMS.register("ankh_complete_spawn_egg",
                () -> new DeferredSpawnEggItem(ANKHCOMPLETE, 0x000000, 0xFF0000, new Item.Properties()));
        
        public static final DeferredHolder<EntityType<?>, EntityType<AnkhLostEntity>> ANKH_LOST = MOBLIST.register("ankh_lost_mob",
                () -> EntityType.Builder.of(AnkhLostEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":ankh_lost_mob"));

        public static final DeferredItem<DeferredSpawnEggItem> ANKH_LOST_SPAWN_EGG = ITEMS.register("ankh_lost_spawn_egg",
                 () -> new DeferredSpawnEggItem(ANKH_LOST, 0x000000, 0xC61500, new Item.Properties()));
         
        
        public static final DeferredHolder<EntityType<?>, EntityType<UvaEntity>> UVA = MOBLIST.register("uva_mob",
                () -> EntityType.Builder.of(UvaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":uva_mob"));

         public static final DeferredItem<DeferredSpawnEggItem> UVA_SPAWN_EGG = ITEMS.register("uva_spawn_egg",
                 () -> new DeferredSpawnEggItem(UVA, 0x000000, 0x00FF1F, new Item.Properties()));
        
         
         public static final DeferredHolder<EntityType<?>, EntityType<KazariEntity>> KAZARI = MOBLIST.register("kazari_mob",
                 () -> EntityType.Builder.of(KazariEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":kazari_mob"));

          public static final DeferredItem<DeferredSpawnEggItem> KAZARI_SPAWN_EGG = ITEMS.register("kazari_spawn_egg",
                  () -> new DeferredSpawnEggItem(KAZARI, 0x000000, 0xFFDC00, new Item.Properties()));
          
         
          public static final DeferredHolder<EntityType<?>, EntityType<MezoolEntity>> MEZOOL = MOBLIST.register("mezool_mob",
                  () -> EntityType.Builder.of(MezoolEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":mezool_mob"));

          public static final DeferredItem<DeferredSpawnEggItem> MEZOOL_SPAWN_EGG = ITEMS.register("mezool_spawn_egg",
                   () -> new DeferredSpawnEggItem(MEZOOL, 0x000000, 0x0000FF, new Item.Properties()));
          
          
          public static final DeferredHolder<EntityType<?>, EntityType<GamelEntity>> GAMEL = MOBLIST.register("gamel_mob",
                  () -> EntityType.Builder.of(GamelEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":gamel_mob"));

          public static final DeferredItem<DeferredSpawnEggItem> GAMEL_SPAWN_EGG = ITEMS.register("gamel_spawn_egg",
                   () -> new DeferredSpawnEggItem(GAMEL, 0x000000, 0xBFBFBF, new Item.Properties()));
          
          
          public static final DeferredHolder<EntityType<?>, EntityType<MuchiriEntity>> MUCHIRI = MOBLIST.register("muchiri_mob",
                  () -> EntityType.Builder.of(MuchiriEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":muchiri_mob"));

          public static final DeferredItem<DeferredSpawnEggItem> MUCHIRI_SPAWN_EGG = ITEMS.register("muchiri_spawn_egg",
                   () -> new DeferredSpawnEggItem(MUCHIRI, 0x000000, 0xFF9E00, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<PoseidonEntity>> POSEIDON = MOBLIST.register("poseidon",
                  () -> EntityType.Builder.of(PoseidonEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":poseidon"));

          public static final DeferredItem<DeferredSpawnEggItem> POSEIDON_SPAWN_EGG = ITEMS.register("poseidon_spawn_egg",
                   () -> new DeferredSpawnEggItem(POSEIDON, 0xD11B1E, 0x30BBEC, new Item.Properties()));
         
          public static final DeferredHolder<EntityType<?>, EntityType<CoreEntity>> CORE = MOBLIST.register("core",
                  () -> EntityType.Builder.of(CoreEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).fireImmune().clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":core"));

          public static final DeferredItem<DeferredSpawnEggItem> CORE_SPAWN_EGG = ITEMS.register("core_spawn_egg",
                   () -> new DeferredSpawnEggItem(CORE, 0x312511, 0xF97012, new Item.Properties()));
         
          
          public static final DeferredHolder<EntityType<?>, EntityType<PoweredUpCoreEntity>> POWERED_UP_CORE = MOBLIST.register("powered_up_core",
                  () -> EntityType.Builder.of(PoweredUpCoreEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":powered_up_core"));

          public static final DeferredItem<DeferredSpawnEggItem> POWERED_UP_CORE_SPAWN_EGG = ITEMS.register("powered_up_core_spawn_egg",
                   () -> new DeferredSpawnEggItem(POWERED_UP_CORE, 0x51115D, 0xB419D1, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<AncientOOOEntity>> ANCIENT_OOO = MOBLIST.register("ancient_ooo",
                  () -> EntityType.Builder.of(AncientOOOEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":ancient_ooo"));

          public static final DeferredItem<DeferredSpawnEggItem> ANCIENT_OOO_SPAWN_EGG = ITEMS.register("ancient_ooo_spawn_egg",
                   () -> new DeferredSpawnEggItem(ANCIENT_OOO, 0x262320, 0xE5B216, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<GodaEntity>> GODA = MOBLIST.register("goda",
                  () -> EntityType.Builder.of(GodaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":goda"));

          public static final DeferredItem<DeferredSpawnEggItem> GODA_SPAWN_EGG = ITEMS.register("goda_spawn_egg",
                   () -> new DeferredSpawnEggItem(GODA, 0x000000, 0xB200FF, new Item.Properties()));

          
          public static final DeferredHolder<EntityType<?>, EntityType<SuperGingaOhEntity>> SUPER_GINGAOH = MOBLIST.register("super_gingaoh",
                  () -> EntityType.Builder.of(SuperGingaOhEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":super_gingaoh"));

          public static final DeferredItem<DeferredSpawnEggItem> SUPER_GINGAOH_SPAWN_EGG = ITEMS.register("super_gingaoh_spawn_egg",
                   () -> new DeferredSpawnEggItem(SUPER_GINGAOH, 0x191b32, 0x9e6f00, new Item.Properties()));


    public static final DeferredHolder<EntityType<?>, EntityType<GhoulsEntity>> GHOULS = MOBLIST.register("ghouls",
            () -> EntityType.Builder.of(GhoulsEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":ghouls"));

    public static final DeferredItem<DeferredSpawnEggItem> GHOULS_SPAWN_EGG = ITEMS.register("ghouls_spawn_egg",
            () -> new DeferredSpawnEggItem(GHOULS,  0x9f9789,0x161616, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<MedusaPhantomEntity>> MEDUSA_PHANTOM = MOBLIST.register("medusa_phantom",
            () -> EntityType.Builder.of(MedusaPhantomEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":medusa_phantom"));

    public static final DeferredItem<DeferredSpawnEggItem> MEDUSA_PHANTOM_SPAWN_EGG = ITEMS.register("medusa_phantom_spawn_egg",
            () -> new DeferredSpawnEggItem(MEDUSA_PHANTOM,  0xe28ce2,0x2da623, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<PhoenixPhantomEntity>> PHOENIX_PHANTOM = MOBLIST.register("phoenix_phantom",
            () -> EntityType.Builder.of(PhoenixPhantomEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":phoenix_phantom"));

    public static final DeferredItem<DeferredSpawnEggItem> PHOENIX_PHANTOM_SPAWN_EGG = ITEMS.register("phoenix_phantom_spawn_egg",
            () -> new DeferredSpawnEggItem(PHOENIX_PHANTOM,  0xb00000,0xeaa413, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<GremlinPhantomEntity>> GREMLIN_PHANTOM = MOBLIST.register("gremlin_phantom",
            () -> EntityType.Builder.of(GremlinPhantomEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":gremlin_phantom"));

    public static final DeferredItem<DeferredSpawnEggItem> GREMLIN_PHANTOM_SPAWN_EGG = ITEMS.register("gremlin_phantom_spawn_egg",
            () -> new DeferredSpawnEggItem(GREMLIN_PHANTOM,  0xb20834c,0x222222, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<MageFootsoldierEntity>> MAGE_FOOTSOLDIER = MOBLIST.register("mage_footsoldier",
            () -> EntityType.Builder.of(MageFootsoldierEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":mage_footsoldier"));

    public static final DeferredItem<DeferredSpawnEggItem> MAGE_FOOTSOLDIER_SPAWN_EGG = ITEMS.register("mage_footsoldier_spawn_egg",
            () -> new DeferredSpawnEggItem(MAGE_FOOTSOLDIER,  0xbb9548,0x050505, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<MageCaptainEntity>> MAGE_CAPTAIN = MOBLIST.register("mage_captain",
            () -> EntityType.Builder.of(MageCaptainEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":mage-captain"));

    public static final DeferredItem<DeferredSpawnEggItem> MAGE_CAPTAIN_SPAWN_EGG = ITEMS.register("mage_captain_spawn_egg",
            () -> new DeferredSpawnEggItem(MAGE_CAPTAIN,  0xbb9548,0x050505, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<SorcererEntity>> SORCERER = MOBLIST.register("sorcerer",
            () -> EntityType.Builder.of(SorcererEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":sorcerer"));

    public static final DeferredItem<DeferredSpawnEggItem> SORCERER_SPAWN_EGG = ITEMS.register("sorcerer_spawn_egg",
            () -> new DeferredSpawnEggItem(SORCERER,  0x050505,0xebc256, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<WisemanEntity>> WISEMAN = MOBLIST.register("wiseman",
            () -> EntityType.Builder.of(WisemanEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":wiseman"));

    public static final DeferredItem<DeferredSpawnEggItem> WISEMAN_SPAWN_EGG = ITEMS.register("wiseman_spawn_egg",
            () -> new DeferredSpawnEggItem(WISEMAN,  0xffffff,0xd79e0b, new Item.Properties()));


    public static final DeferredHolder<EntityType<?>, EntityType<ElementaryInvesRedEntity>> ELEMENTARY_INVES_RED = MOBLIST.register("elementary_inves_red",
            () -> EntityType.Builder.of(ElementaryInvesRedEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":elementary_inves_red"));

    public static final DeferredItem<DeferredSpawnEggItem> ELEMENTARY_INVES_RED_SPAWN_EGG = ITEMS.register("elementary_inves_red_spawn_egg",
            () -> new DeferredSpawnEggItem(ELEMENTARY_INVES_RED, 0xd6d5d0, 0xfc4130, new Item.Properties()));


    public static final DeferredHolder<EntityType<?>, EntityType<KurokageTrooperEntity>> KUROKAGE_TROOPER = MOBLIST.register("kurokage_trooper",
                  () -> EntityType.Builder.of(KurokageTrooperEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":kurokage_trooper"));
          
          public static final DeferredItem<DeferredSpawnEggItem> KUROKAGE_TROOPER_SPAWN_EGG = ITEMS.register("kurokage_trooper_spawn_egg",
                  () -> new DeferredSpawnEggItem(KUROKAGE_TROOPER, 0x6a4916, 0x333333, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<ZangetsuShinEntity>> ZANGETSU_SHIN = MOBLIST.register("zangetsu_shin",
                  () -> EntityType.Builder.of(ZangetsuShinEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":zangetsu_shin"));
          
          public static final DeferredItem<DeferredSpawnEggItem> ZANGETSU_SHIN_SPAWN_EGG = ITEMS.register("zangetsu_shin_spawn_egg",
                  () -> new DeferredSpawnEggItem(ZANGETSU_SHIN, 0xa0ffa9, 0xfefefe, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<MarikaEntity>> MARIKA = MOBLIST.register("marika",
                  () -> EntityType.Builder.of(MarikaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":marika"));
          
          public static final DeferredItem<DeferredSpawnEggItem> MARIKA_SPAWN_EGG = ITEMS.register("marika_spawn_egg",
                  () -> new DeferredSpawnEggItem(MARIKA, 0xfcfb81, 0xff84ac, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<DukeEntity>> DUKE = MOBLIST.register("duke",
                  () -> EntityType.Builder.of(DukeEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":duke"));
          
          public static final DeferredItem<DeferredSpawnEggItem> DUKE_SPAWN_EGG = ITEMS.register("duke_spawn_egg",
                  () -> new DeferredSpawnEggItem(DUKE, 0xe5ec25, 0x25c1ec, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<SigurdEntity>> SIGURD = MOBLIST.register("sigurd",
                  () -> EntityType.Builder.of(SigurdEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":sigurd"));
          
          public static final DeferredItem<DeferredSpawnEggItem> SIGURD_SPAWN_EGG = ITEMS.register("sigurd_spawn_egg",
                  () -> new DeferredSpawnEggItem(SIGURD, 0xff0000, 0xd2f3e8, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<RosyuoEntity>> ROSYUO = MOBLIST.register("rosyuo",
                  () -> EntityType.Builder.of(RosyuoEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":rosyuo"));
          
          public static final DeferredItem<DeferredSpawnEggItem> ROSYUO_SPAWN_EGG = ITEMS.register("rosyuo_spawn_egg",
                  () -> new DeferredSpawnEggItem(ROSYUO, 0xefefef, 0x97c3c5, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<RedyueEntity>> REDYUE = MOBLIST.register("redyue",
                  () -> EntityType.Builder.of(RedyueEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":redyue"));
          
          public static final DeferredItem<DeferredSpawnEggItem> REDYUE_SPAWN_EGG = ITEMS.register("redyue_spawn_egg",
                  () -> new DeferredSpawnEggItem(REDYUE, 0xb69d02, 0x277a44, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<DemushuEntity>> DEMUSHU = MOBLIST.register("demushu",
                  () -> EntityType.Builder.of(DemushuEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":demushu"));
          
          public static final DeferredItem<DeferredSpawnEggItem> DEMUSHU_SPAWN_EGG = ITEMS.register("demushu_spawn_egg",
                  () -> new DeferredSpawnEggItem(DEMUSHU, 0xb50000, 0x790000, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<LordBaronEntity>> LORD_BARON = MOBLIST.register("lord_baron",
                  () -> EntityType.Builder.of(LordBaronEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":lord_baron"));
          
          public static final DeferredItem<DeferredSpawnEggItem> LORD_BARON_SPAWN_EGG = ITEMS.register("lord_baron_spawn_egg",
                  () -> new DeferredSpawnEggItem(LORD_BARON, 0x970000, 0xb3a500, new Item.Properties()));


    public static final DeferredHolder<EntityType<?>, EntityType<GammaCommandoEntity>> GAMMA_COMMANDO = MOBLIST.register("gamma_commandos",
                  () -> EntityType.Builder.of(GammaCommandoEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":gamma_commandos"));
          
          public static final DeferredItem<DeferredSpawnEggItem> GAMMA_COMMANDO_SPAWN_EGG = ITEMS.register("gamma_commandos_spawn_egg",
                  () -> new DeferredSpawnEggItem(GAMMA_COMMANDO, 0x000000, 0x6f6f6f, new Item.Properties()));


    public static final DeferredHolder<EntityType<?>, EntityType<BugsterVirusEntity>> BUGSTERVIRUS = MOBLIST.register("bugstervirus_mob",
                  () -> EntityType.Builder.of(BugsterVirusEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":bugster_mob"));
          
          public static final DeferredItem<DeferredSpawnEggItem> BUGSTERVIRUS_SPAWN_EGG = ITEMS.register("bugstervirus_spawn_egg",
                  () -> new DeferredSpawnEggItem(BUGSTERVIRUS, 0xFF7400, 0x150E08, new Item.Properties()));
          
    /**
          public static final DeferredHolder<EntityType<?>, EntityType<MightyBugsterEntity>> MIGHTY_BUGSTER = MOBLIST.register("mighty_bugster_mob",
                  () -> EntityType.Builder.of(MightyBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":mighty_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> MIGHTY_BUGSTER_SPAWN_EGG = ITEMS.register("mighty_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(MIGHTY_BUGSTER, 0xFF7400, 0xFF0EFB, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<TaddleBugsterEntity>> TADDLE_BUGSTER = MOBLIST.register("taddle_bugster_mob",
                  () -> EntityType.Builder.of(TaddleBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":taddle_bugster_mob"));
          
          public static final DeferredItem<DeferredSpawnEggItem> TADDLE_BUGSTER_SPAWN_EGG = ITEMS.register("taddle_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(TADDLE_BUGSTER, 0xFF7400, 0x0EF0FF, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<BangBangBugsterEntity>> BANG_BANG_BUGSTER = MOBLIST.register("bang_bang_bugster_mob",
                  () -> EntityType.Builder.of(BangBangBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":bang_bang_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> BANG_BANG_BUGSTER_SPAWN_EGG = ITEMS.register("bang_bang_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(BANG_BANG_BUGSTER, 0xFF7400, 0x442AD5, new Item.Properties()));
         
          public static final DeferredHolder<EntityType<?>, EntityType<LovelyBugsterEntity>> LOVELY_BUGSTER = MOBLIST.register("lovely_bugster_mob",
                  () -> EntityType.Builder.of(LovelyBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":lovely_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> LOVELY_BUGSTER_SPAWN_EGG = ITEMS.register("lovely_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(LOVELY_BUGSTER, 0xFF7400, 0xE479FA, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<SaltyBugsterEntity>> SALTY_BUGSTER = MOBLIST.register("salty_bugster_mob",
                  () -> EntityType.Builder.of(SaltyBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":salty_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> SALTY_BUGSTER_SPAWN_EGG = ITEMS.register("salty_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(SALTY_BUGSTER, 0x1C15E5, 0x131315, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<CharlieBugsterEntity>> CHARLIE_BUGSTER = MOBLIST.register("charlie_bugster_mob",
                  () -> EntityType.Builder.of(CharlieBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":charlie_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> CHARLIE_BUGSTER_SPAWN_EGG = ITEMS.register("charlie_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(CHARLIE_BUGSTER, 0x1C15E5, 0x79B6EC, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<GattonBugsterEntity>> GATTON_BUGSTER = MOBLIST.register("gatton_bugster_mob",
                  () -> EntityType.Builder.of(GattonBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":gatton_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> GATTON_BUGSTER_SPAWN_EGG = ITEMS.register("gatton_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(GATTON_BUGSTER, 0x1C15E5, 0xF71D0B, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<KaidenBugsterEntity>> KAIDEN_BUGSTER = MOBLIST.register("kaiden_bugster_mob",
                  () -> EntityType.Builder.of(KaidenBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":kaiden_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> KAIDEN_BUGSTER_SPAWN_EGG = ITEMS.register("kaiden_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(KAIDEN_BUGSTER, 0x1C15E5, 0x9C1408, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<MotorsBugsterEntity>> MOTORS_BUGSTER = MOBLIST.register("motors_bugster_mob",
                  () -> EntityType.Builder.of(MotorsBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":motors_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> MOTORS_BUGSTER_SPAWN_EGG = ITEMS.register("motors_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(MOTORS_BUGSTER, 0x1C15E5, 0xF5C40C, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<VernierBugsterEntity>> VERNIER_BUGSTER = MOBLIST.register("vernier_bugster_mob",
                  () -> EntityType.Builder.of(VernierBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":vernier_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> VERNIER_BUGSTER_SPAWN_EGG = ITEMS.register("vernier_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(VERNIER_BUGSTER, 0x1C15E5, 0xF58B0C, new Item.Properties()));
        **/
          public static final DeferredHolder<EntityType<?>, EntityType<GraphiteBugsterEntity>> GRAPHITE_BUGSTER = MOBLIST.register("graphite_bugster_mob",
                  () -> EntityType.Builder.of(GraphiteBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":graphite_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> GRAPHITE_BUGSTER_SPAWN_EGG = ITEMS.register("graphite_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(GRAPHITE_BUGSTER, 0x1C15E5, 0x127120, new Item.Properties()));
          
        /**
          public static final DeferredHolder<EntityType<?>, EntityType<AranburaBugsterEntity>> ARANBURA_BUGSTER = MOBLIST.register("aranbura_bugster_mob",
                  () -> EntityType.Builder.of(AranburaBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":aranbura_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> ARANBURA_BUGSTER_SPAWN_EGG = ITEMS.register("aranbura_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(ARANBURA_BUGSTER, 0x1C15E5, 0xF52B0B, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<RevolBugsterEntity>> REVOL_BUGSTER = MOBLIST.register("revol_bugster_mob",
                  () -> EntityType.Builder.of(RevolBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":revol_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> REVOL_BUGSTER_SPAWN_EGG = ITEMS.register("revol_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(REVOL_BUGSTER, 0x1C15E5, 0x8AB2E0, new Item.Properties()));
       
          
          public static final DeferredHolder<EntityType<?>, EntityType<LovelicaBugsterEntity>> LOVELICA_BUGSTER = MOBLIST.register("lovelica_bugster_mob",
                  () -> EntityType.Builder.of(LovelicaBugsterEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":lovelica_bugster_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> LOVELICA_BUGSTER_SPAWN_EGG = ITEMS.register("lovelica_bugster_spawn_egg",
                  () -> new DeferredSpawnEggItem(LOVELICA_BUGSTER, 0x1C15E5, 0xC865F3, new Item.Properties()));
          

          **/
          public static final DeferredHolder<EntityType<?>, EntityType<GenmEntity>> GENM = MOBLIST.register("genm_mob",
                  () -> EntityType.Builder.of(GenmEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":genm_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> GENM_SPAWN_EGG = ITEMS.register("genm_spawn_egg",
                  () -> new DeferredSpawnEggItem(GENM, 0x201F20, 0x8629F6, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<PoppyRedEntity>> POPPY_RED = MOBLIST.register("poppy_red_mob",
                  () -> EntityType.Builder.of(PoppyRedEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":poppy_red_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> POPPY_RED_SPAWN_EGG = ITEMS.register("poppy_red_spawn_egg",
                  () -> new DeferredSpawnEggItem(POPPY_RED, 0xE0C819, 0xC865F3, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<RideplayerEntity>> RIDEPLAYER = MOBLIST.register("rideplayer",
                  () -> EntityType.Builder.of(RideplayerEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":rideplayer_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> RIDEPLAYER_SPAWN_EGG = ITEMS.register("rideplayer_spawn_egg",
                  () -> new DeferredSpawnEggItem(RIDEPLAYER, 0xf1c192, 0x854303, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<ParaDxEntity>> PARADX = MOBLIST.register("para-dx",
                  () -> EntityType.Builder.of(ParaDxEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":paradx_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> PARADX_SPAWN_EGG = ITEMS.register("paradx_spawn_egg",
                  () -> new DeferredSpawnEggItem(PARADX, 0xff0000, 0x2a00ff, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<CronusEntity>> CRONUS = MOBLIST.register("cronus",
                  () -> EntityType.Builder.of(CronusEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":cronus_mob"));
 
          public static final DeferredItem<DeferredSpawnEggItem> CRONUS_SPAWN_EGG = ITEMS.register("cronus_spawn_egg",
                  () -> new DeferredSpawnEggItem(CRONUS, 0x000000, 0x44df00, new Item.Properties()));


    public static final DeferredHolder<EntityType<?>, EntityType<GuardianEntity>> TOUTOGUARDIAN = MOBLIST.register("touto_guardian",
            () -> EntityType.Builder.of(GuardianEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":touto_guardian"));

    public static final DeferredItem<DeferredSpawnEggItem> GUARDIAN_SPAWN_EGG = ITEMS.register("touto_guardian_spawn_egg",
            () -> new DeferredSpawnEggItem(TOUTOGUARDIAN, 0xa6a6a6, 0x398782, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<HokutoGuardianEntity>> HOKUTOGUARDIAN = MOBLIST.register("hokuto_guardian",
            () -> EntityType.Builder.of(HokutoGuardianEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":hokuto_guardian"));

    public static final DeferredItem<DeferredSpawnEggItem> HOKUTO_GUARDIAN_SPAWN_EGG = ITEMS.register("hokuto_guardian_spawn_egg",
            () -> new DeferredSpawnEggItem(HOKUTOGUARDIAN, 0xa6a6a6, 0x1b23c2, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<SeitoGuardianEntity>> SEITOGUARDIAN = MOBLIST.register("seito_guardian",
            () -> EntityType.Builder.of(SeitoGuardianEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":seito_guardian"));

    public static final DeferredItem<DeferredSpawnEggItem> SEITO_GUARDIAN_SPAWN_EGG = ITEMS.register("seito_guardian_spawn_egg",
            () -> new DeferredSpawnEggItem(SEITOGUARDIAN, 0xa6a6a6, 0xd10f25, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<SmashEntity>> SMASH = MOBLIST.register("needle_smash",
            () -> EntityType.Builder.of(SmashEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":needle_smash"));

    public static final DeferredItem<DeferredSpawnEggItem> SMASH_SPAWN_EGG = ITEMS.register("needle_smash_spawn_egg",
            () -> new DeferredSpawnEggItem(SMASH, 0xa6a6a6, 0xa1bfba, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<HardGuardianEntity>> HARD_GUARDIAN = MOBLIST.register("hard_guardian",
            () -> EntityType.Builder.of(HardGuardianEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":hard_guardian"));

    public static final DeferredItem<DeferredSpawnEggItem> HARD_GUARDIAN_SPAWN_EGG = ITEMS.register("hard_guardian_spawn_egg",
            () -> new DeferredSpawnEggItem(HARD_GUARDIAN, 0x0c9132, 0xe5f22e, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<DownfallGuardianEntity>> DOWNFALL_GUARDIAN = MOBLIST.register("downfall_guardian",
            () -> EntityType.Builder.of(DownfallGuardianEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":downfall_guardian"));

    public static final DeferredItem<DeferredSpawnEggItem> DOWNFALL_GUARDIAN_SPAWN_EGG = ITEMS.register("downfall_guardian_spawn_egg",
            () -> new DeferredSpawnEggItem(DOWNFALL_GUARDIAN, 0x0f03fc, 0xe5f22e, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<PhantomCrusherEntity>> PHANTOM_CRUSHER = MOBLIST.register("phantom_crusher",
            () -> EntityType.Builder.of(PhantomCrusherEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":phantom_crusher"));

    public static final DeferredItem<DeferredSpawnEggItem> PHANTOM_CRUSHER_SPAWN_EGG = ITEMS.register("phantom_crusher_spawn_egg",
            () -> new DeferredSpawnEggItem(PHANTOM_CRUSHER, 0x0c9132, 0xcdcdd1, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<BloodStalkEntity>> BLOOD_STALK = MOBLIST.register("blood_stalk",
            () -> EntityType.Builder.of(BloodStalkEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":blood_stalk_mob"));

    public static final DeferredItem<DeferredSpawnEggItem> BLOOD_STALK_SPAWN_EGG = ITEMS.register("blood_stalk_spawn_egg",
            () -> new DeferredSpawnEggItem(BLOOD_STALK, 0x7a0714, 0x49f2bd, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<NightRogueEntity>> NIGHT_ROGUE = MOBLIST.register("night_rogue",
            () -> EntityType.Builder.of(NightRogueEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":night_rogue_mob"));

    public static final DeferredItem<DeferredSpawnEggItem> NIGHT_ROGUE_SPAWN_EGG = ITEMS.register("night_rogue_spawn_egg",
            () -> new DeferredSpawnEggItem(NIGHT_ROGUE, 0x3d3d36, 0xe5f22e, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<GreaseEntity>> GREASE = MOBLIST.register("grease",
            () -> EntityType.Builder.of(GreaseEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":grease_mob"));

    public static final DeferredItem<DeferredSpawnEggItem> GREASE_SPAWN_EGG = ITEMS.register("grease_spawn_egg",
            () -> new DeferredSpawnEggItem(GREASE, 0xc2a723, 0x454440, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<BuildEntity>> BUILD = MOBLIST.register("build",
            () -> EntityType.Builder.of(BuildEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":build_mob"));

    public static final DeferredItem<DeferredSpawnEggItem> BUILD_SPAWN_EGG = ITEMS.register("build_spawn_egg",
            () -> new DeferredSpawnEggItem(BUILD, 0xff0000, 0x2a00ff, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<EvolEntity>> EVOL = MOBLIST.register("evol",
            () -> EntityType.Builder.of(EvolEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":evol_mob"));

    public static final DeferredItem<DeferredSpawnEggItem> EVOL_SPAWN_EGG = ITEMS.register("evol_spawn_egg",
            () -> new DeferredSpawnEggItem(EVOL, 0x8f091f, 0xe8c70c, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<KillbusEntity>> KILLBUS = MOBLIST.register("killbus",
            () -> EntityType.Builder.of(KillbusEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":killbus_mob"));

    public static final DeferredItem<DeferredSpawnEggItem> KILLBUS_SPAWN_EGG = ITEMS.register("killbus_spawn_egg",
            () -> new DeferredSpawnEggItem(KILLBUS, 0xed220c, 0x000000, new Item.Properties()));


    public static final DeferredHolder<EntityType<?>, EntityType<GingaEntity>> GINGA = MOBLIST.register("ginga",
            () -> EntityType.Builder.of(GingaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":ginga_mob"));

    public static final DeferredItem<DeferredSpawnEggItem> GINGA_SPAWN_EGG = ITEMS.register("ginga_spawn_egg",
            () -> new DeferredSpawnEggItem(GINGA, 0x5e36a3, 0x969696, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<WozEntity>> WOZ = MOBLIST.register("woz",
            () -> EntityType.Builder.of(WozEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":woz_mob"));

    public static final DeferredItem<DeferredSpawnEggItem> WOZ_SPAWN_EGG = ITEMS.register("woz_spawn_egg",
            () -> new DeferredSpawnEggItem(WOZ, 0xffffff, 0x05ff09, new Item.Properties()));


    public static final DeferredHolder<EntityType<?>, EntityType<TrilobiteMagiaEntity>> TRILOBITE_MAGIA = MOBLIST.register("trilobite_magia",
                  () -> EntityType.Builder.of(TrilobiteMagiaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":trilobite_magia"));
 
          public static final DeferredItem<DeferredSpawnEggItem> TRILOBITE_MAGIA_SPAWN_EGG = ITEMS.register("trilobite_magia_spawn_egg",
                  () -> new DeferredSpawnEggItem(TRILOBITE_MAGIA, 0x060606, 0xa2a2a2, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<DodoMagiaChickEntity>> DODO_MAGIA_CHICK = MOBLIST.register("dodo_magia_chick",
                  () -> EntityType.Builder.of(DodoMagiaChickEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":dodo_magia_chick"));
 
          public static final DeferredItem<DeferredSpawnEggItem> DODO_MAGIA_CHICK_SPAWN_EGG = ITEMS.register("dodo_magia_chick_spawn_egg",
                  () -> new DeferredSpawnEggItem(DODO_MAGIA_CHICK, 0x7d0b0a, 0x242424, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<BattleRaiderEntity>> BATTLE_RAIDER = MOBLIST.register("battle_raider",
                  () -> EntityType.Builder.of(BattleRaiderEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":battle_raider"));
 
          public static final DeferredItem<DeferredSpawnEggItem> BATTLE_RAIDER_SPAWN_EGG = ITEMS.register("battle_raider_spawn_egg",
                  () -> new DeferredSpawnEggItem(BATTLE_RAIDER, 0x1d1d1d, 0x000000, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<AbaddonEntity>> ABADDON = MOBLIST.register("abaddon",
                  () -> EntityType.Builder.of(AbaddonEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":abaddon"));
 
          public static final DeferredItem<DeferredSpawnEggItem> ABADDON_SPAWN_EGG = ITEMS.register("abaddon_spawn_egg",
                  () -> new DeferredSpawnEggItem(ABADDON, 0x5d6837, 0xc1b810, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<MagiaEntity>> MAGIA = MOBLIST.register("magia",
                  () -> EntityType.Builder.of(MagiaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":magia"));
 
          public static final DeferredItem<DeferredSpawnEggItem> MAGIA_SPAWN_EGG = ITEMS.register("magia_spawn_egg",
                  () -> new DeferredSpawnEggItem(MAGIA, 0x060606, 0xa2a2a2, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<GigerEntity>> GIGER = MOBLIST.register("giger",
                  () -> EntityType.Builder.of(GigerEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":giger"));
 
          public static final DeferredItem<DeferredSpawnEggItem> GIGER_SPAWN_EGG = ITEMS.register("giger_spawn_egg",
                  () -> new DeferredSpawnEggItem(GIGER, 0x9c00b2, 0x1f1f1f, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<JinEntity>> JIN = MOBLIST.register("jin",
                  () -> EntityType.Builder.of(JinEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":jin"));
 
          public static final DeferredItem<DeferredSpawnEggItem> JIN_SPAWN_EGG = ITEMS.register("jin_spawn_egg",
                  () -> new DeferredSpawnEggItem(JIN, 0xff65b9, 0xd5d5d5, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<DodoMagiaEntity>> DODO_MAGIA = MOBLIST.register("dodo_magia",
                  () -> EntityType.Builder.of(DodoMagiaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":dodo_magia"));
 
          public static final DeferredItem<DeferredSpawnEggItem> DODO_MAGIA_SPAWN_EGG = ITEMS.register("dodo_magia_spawn_egg",
                  () -> new DeferredSpawnEggItem(DODO_MAGIA, 0x7d0b0a, 0x242424, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<RaiderEntity>> RAIDER = MOBLIST.register("raider",
                  () -> EntityType.Builder.of(RaiderEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":raider"));
 
          public static final DeferredItem<DeferredSpawnEggItem> RAIDER_SPAWN_EGG = ITEMS.register("raider_spawn_egg",
                  () -> new DeferredSpawnEggItem(RAIDER, 0x1d1d1d, 0x000000, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<NakiEntity>> NAKI = MOBLIST.register("naki",
                  () -> EntityType.Builder.of(NakiEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":naki"));
 
          public static final DeferredItem<DeferredSpawnEggItem> NAKI_SPAWN_EGG = ITEMS.register("naki_spawn_egg",
                  () -> new DeferredSpawnEggItem(NAKI, 0xcbcbcb, 0x0024fe, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<ZaiaEntity>> ZAIA = MOBLIST.register("zaia",
                  () -> EntityType.Builder.of(ZaiaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":zaia"));
 
          public static final DeferredItem<DeferredSpawnEggItem> ZAIA_SPAWN_EGG = ITEMS.register("zaia_spawn_egg",
                  () -> new DeferredSpawnEggItem(ZAIA, 0x161616, 0xc2c2c2, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<DireWolfSoldMagiaEntity>> DIRE_WOLF_SOLD_MAGIA = MOBLIST.register("dire_wolf_sold_magia",
                  () -> EntityType.Builder.of(DireWolfSoldMagiaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":dire_wolf_sold_magia"));
 
          public static final DeferredItem<DeferredSpawnEggItem> DIRE_WOLF_SOLD_MAGIA_SPAWN_EGG = ITEMS.register("dire_wolf_sold_magia_spawn_egg",
                  () -> new DeferredSpawnEggItem(DIRE_WOLF_SOLD_MAGIA, 0x454b4b, 0x0033c4, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<ServalTigerSoldMagiaEntity>> SERVAL_TIGER_SOLD_MAGIA = MOBLIST.register("serval_tiger_sold_magia",
                  () -> EntityType.Builder.of(ServalTigerSoldMagiaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":serval_tiger_sold_magia"));
 
          public static final DeferredItem<DeferredSpawnEggItem> SERVAL_TIGER_SOLD_MAGIA_SPAWN_EGG = ITEMS.register("serval_tiger_sold_magia_spawn_egg",
                  () -> new DeferredSpawnEggItem(SERVAL_TIGER_SOLD_MAGIA, 0x454b4b, 0xce7100, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<AbaddonCommanderEntity>> ABADDON_COMMANDER = MOBLIST.register("abaddon_commander",
                  () -> EntityType.Builder.of(AbaddonCommanderEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":abaddon_commander"));
 
          public static final DeferredItem<DeferredSpawnEggItem> ABADDON_COMMANDER_SPAWN_EGG = ITEMS.register("abaddon_commander_spawn_egg",
                  () -> new DeferredSpawnEggItem(ABADDON_COMMANDER, 0x5d6837, 0xc30000, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<EdenEntity>> EDEN = MOBLIST.register("eden",
                  () -> EntityType.Builder.of(EdenEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":eden"));
 
          public static final DeferredItem<DeferredSpawnEggItem> EDEN_SPAWN_EGG = ITEMS.register("eden_spawn_egg",
                  () -> new DeferredSpawnEggItem(EDEN, 0x0e1257, 0x910101, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<HorobiEntity>> HOROBI = MOBLIST.register("horobi",
                  () -> EntityType.Builder.of(HorobiEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":horobi"));
 
          public static final DeferredItem<DeferredSpawnEggItem> HOROBI_SPAWN_EGG = ITEMS.register("horobi_spawn_egg",
                  () -> new DeferredSpawnEggItem(HOROBI, 0x8a00c3, 0x383838, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<IkazuchiEntity>> IKAZUCHI = MOBLIST.register("ikazuchi",
                  () -> EntityType.Builder.of(IkazuchiEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":ikazuchi"));
 
          public static final DeferredItem<DeferredSpawnEggItem> IKAZUCHI_SPAWN_EGG = ITEMS.register("ikazuchi_spawn_egg",
                  () -> new DeferredSpawnEggItem(IKAZUCHI, 0x7d0b0a, 0x242424, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<ArkZeroEntity>> ARK_ZERO = MOBLIST.register("ark_zero",
                  () -> EntityType.Builder.of(ArkZeroEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":ark_zero"));
 
          public static final DeferredItem<DeferredSpawnEggItem> ARK_ZERO_SPAWN_EGG = ITEMS.register("ark_zero_spawn_egg",
                  () -> new DeferredSpawnEggItem(ARK_ZERO, 0x161616, 0xC40000, new Item.Properties()));


          public static final DeferredHolder<EntityType<?>, EntityType<GiffJuniorEntity>> GIFF_JUNIOR = MOBLIST.register("giff_junior",
                  () -> EntityType.Builder.of(GiffJuniorEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":giff_junior"));
          
          public static final DeferredItem<DeferredSpawnEggItem> GIFF_JUNIOR_SPAWN_EGG = ITEMS.register("giff_junior_spawn_egg",
                  () -> new DeferredSpawnEggItem(GIFF_JUNIOR, 0x282828, 0xe2e2e2, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<EvilEntity>> EVIL = MOBLIST.register("evil",
                  () -> EntityType.Builder.of(EvilEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":evil"));
          
          public static final DeferredItem<DeferredSpawnEggItem> EVIL_SPAWN_EGG = ITEMS.register("evil_spawn_egg",
                  () -> new DeferredSpawnEggItem(EVIL, 0x03c8a9, 0xa7a7a7, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<DaiouikaDeadmanEntity>> DAIOUIKA_DEADMAN = MOBLIST.register("daiouika_deadman",
                  () -> EntityType.Builder.of(DaiouikaDeadmanEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":daiouika_deadman"));
          
          public static final DeferredItem<DeferredSpawnEggItem> DAIOUIKA_DEADMAN_SPAWN_EGG = ITEMS.register("daiouika_deadman_spawn_egg",
                  () -> new DeferredSpawnEggItem(DAIOUIKA_DEADMAN, 0x00a8b8, 0xd8d8d8, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<AnomalocarisDeadmanEntity>> ANOMALOCARIS_DEADMAN = MOBLIST.register("anomalocaris_deadman",
                  () -> EntityType.Builder.of(AnomalocarisDeadmanEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":anomalocaris_deadman"));

          public static final DeferredItem<DeferredSpawnEggItem> ANOMALOCARIS_DEADMAN_SPAWN_EGG = ITEMS.register("anomalocaris_deadman_spawn_egg",
                  () -> new DeferredSpawnEggItem(ANOMALOCARIS_DEADMAN, 0x084b16, 0xf7eb2f, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<QueenBeeDeadmanEntity>> QUEEN_BEE_DEADMAN = MOBLIST.register("queen_bee_deadman",
            () -> EntityType.Builder.of(QueenBeeDeadmanEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":queen_bee_deadman"));

    public static final DeferredItem<DeferredSpawnEggItem> QUEEN_BEE_DEADMAN_SPAWN_EGG = ITEMS.register("queen_bee_deadman_spawn_egg",
            () -> new DeferredSpawnEggItem(QUEEN_BEE_DEADMAN, 0xf290f8, 0xfda215, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<WolfDeadmanEntity>> WOLF_DEADMAN = MOBLIST.register("wolf_deadman",
            () -> EntityType.Builder.of(WolfDeadmanEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":wolf_deadman"));

    public static final DeferredItem<DeferredSpawnEggItem> WOLF_DEADMAN_SPAWN_EGG = ITEMS.register("wolf_deadman_spawn_egg",
            () -> new DeferredSpawnEggItem(WOLF_DEADMAN, 0x60451a, 0xeb2916, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<PawnJyamatoEntity>> PAWN_JYAMATO = MOBLIST.register("pawnjyamato_mob",
                  () -> EntityType.Builder.of(PawnJyamatoEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":pawnjyamato_mob"));
          
          public static final DeferredItem<DeferredSpawnEggItem> PAWN_JYAMATO_SPAWN_EGG = ITEMS.register("pawnjyamato_spawn_egg",
                  () -> new DeferredSpawnEggItem(PAWN_JYAMATO, 0xDBD39B, 0x22A215, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<JyamatoRiderEntity>> JYAMATO_RIDER = MOBLIST.register("jyamatorider",
                  () -> EntityType.Builder.of(JyamatoRiderEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":jyamatorider"));
 
          public static final DeferredItem<DeferredSpawnEggItem> JYAMATO_RIDER_SPAWN_EGG = ITEMS.register("jyamatorider_spawn_egg",
                  () -> new DeferredSpawnEggItem(JYAMATO_RIDER, 0x0F100F, 0x22A215, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<GmRiderEntity>> GM_RIDER = MOBLIST.register("gmrider",
                  () -> EntityType.Builder.of(GmRiderEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":jyamatorider"));
 
          public static final DeferredItem<DeferredSpawnEggItem> GM_RIDER_SPAWN_EGG = ITEMS.register("gmrider_spawn_egg",
                  () -> new DeferredSpawnEggItem(GM_RIDER, 0x0F100F, 0x9B0E52, new Item.Properties()));
          

          public static final DeferredHolder<EntityType<?>, EntityType<MachineTornadorEntity>> MACEHINE_TORADOR = MOBLIST.register("machine_tornador",
                  () -> EntityType.Builder.of(MachineTornadorEntity::new, MobCategory.MONSTER).clientTrackingRange(8).sized(0.6F, 1.25F).build( KamenRiderCraftCore.MOD_ID + ":machine_tornador"));

          public static final DeferredItem<DeferredSpawnEggItem> MACEHINE_TORADOR_SPAWN_EGG = ITEMS.register("machine_tornador_spawn_egg",
                  () -> new DeferredSpawnEggItem(MACEHINE_TORADOR, 0xffffff, 0xffe300, new Item.Properties()));

          public static final DeferredHolder<EntityType<?>, EntityType<HardboilderEntity>> HARDBOILER = MOBLIST.register("hardboilder",
                  () -> EntityType.Builder.of(HardboilderEntity::new, MobCategory.MONSTER).clientTrackingRange(8).sized(0.6F, 1.25F).build( KamenRiderCraftCore.MOD_ID + ":hardboilder"));

          public static final DeferredItem<DeferredSpawnEggItem> HARDBOILER_SPAWN_EGG = ITEMS.register("hardboilder_spawn_egg",
                  () -> new DeferredSpawnEggItem(HARDBOILER,  0xffffff, 0x222222, new Item.Properties()));
      
          public static final DeferredHolder<EntityType<?>, EntityType<SkullboilderEntity>> SKULLBOILER = MOBLIST.register("skullboilder",
                  () -> EntityType.Builder.of(SkullboilderEntity::new, MobCategory.MONSTER).clientTrackingRange(8).sized(0.6F, 1.2F).build( KamenRiderCraftCore.MOD_ID + ":skullboilder"));

          public static final DeferredItem<DeferredSpawnEggItem> SKULLBOILER_SPAWN_EGG = ITEMS.register("skullboilder_spawn_egg",
                 () -> new DeferredSpawnEggItem(SKULLBOILER, 0xffffff, 0x151515, new Item.Properties()));

                  
          public static final DeferredHolder<EntityType<?>, EntityType<RiderSummonEntity>> RIDER_SUMMON = MOBLIST.register("rider_summon",
                  () -> EntityType.Builder.of(RiderSummonEntity::new, MobCategory.CREATURE).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":rider_summon"));

          public static final DeferredItem<DeferredSpawnEggItem> RIDER_SUMMON_SPAWN_EGG = ITEMS.register("rider_summon_spawn_egg",
                  () -> new DeferredSpawnEggItem(RIDER_SUMMON, 0xEC008C, 0x222222, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<ParaDXSummonEntity>> PARADX_SUMMON = MOBLIST.register("paradx_summon",
                  () -> EntityType.Builder.of(ParaDXSummonEntity::new, MobCategory.CREATURE).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":paradx_summon"));

          public static final DeferredItem<DeferredSpawnEggItem> PARADX_SUMMON_SPAWN_EGG = ITEMS.register("paradx_summon_spawn_egg",
                  () -> new DeferredSpawnEggItem(PARADX_SUMMON, 0xffa500, 0x00bccf, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<DecadeArmorExAidEntity>> DECADE_ARMOR_EX_AID = MOBLIST.register("decade_armor_ex_aid",
                  () -> EntityType.Builder.of(DecadeArmorExAidEntity::new, MobCategory.CREATURE).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":decade_armor_ex_aid"));

          public static final DeferredItem<DeferredSpawnEggItem> DECADE_ARMOR_EX_AID_SPAWN_EGG = ITEMS.register("decade_armor_ex_aid_spawn_egg",
                  () -> new DeferredSpawnEggItem(DECADE_ARMOR_EX_AID, 0xffa500, 0x00bccf, new Item.Properties()));
          
          public static final DeferredHolder<EntityType<?>, EntityType<ViceEntity>> VICE = MOBLIST.register("vice",
                  () -> EntityType.Builder.of(ViceEntity::new, MobCategory.CREATURE).sized(0.6F, 1.95F).clientTrackingRange(8).build( KamenRiderCraftCore.MOD_ID + ":vice"));

          public static final DeferredItem<DeferredSpawnEggItem> VICE_SPAWN_EGG = ITEMS.register("vice_spawn_egg",
                  () -> new DeferredSpawnEggItem(VICE, 0xeaeaea, 0xd9a900, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
