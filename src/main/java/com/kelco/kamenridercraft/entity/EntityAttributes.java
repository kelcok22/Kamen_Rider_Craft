package com.kelco.kamenridercraft.entity;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.allies.*;
import com.kelco.kamenridercraft.entity.mobs.bosses.*;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.*;
import com.kelco.kamenridercraft.entity.mobs.summons.*;
import com.kelco.kamenridercraft.entity.vehicles.RidoronEntity;
import com.kelco.kamenridercraft.entity.vehicles.baseBikeEntity;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

public class EntityAttributes {
    public static void addEntityAttributes (EntityAttributeCreationEvent event) {
        showaAttributes(event);
        heiseiPhaseOneAttributes(event);
        heiseiPhaseTwoAttributes(event);
        reiwaAttributes(event);
        vehicleAttributes(event);
        allyAttributes(event);
    }


    private static void showaAttributes (EntityAttributeCreationEvent event) {
        event.put(MobsCore.SHOCKER_COMBATMAN.get(), ShockerCombatmanEntity.setAttributes().build());
        event.put(MobsCore.SHOCKER_RIDER.get(), ShockerRidersEntity.setAttributes().build());
        event.put(MobsCore.DESTRON_COMBATMAN.get(), DestronCombatmanEntity.setAttributes().build());
        event.put(MobsCore.GOD_WARFARE_AGENT.get(), GODWarfareAgentEntity.setAttributes().build());
        event.put(MobsCore.APOLLOGIST.get(), ApollogeistEntity.setAttributes().build());
        event.put(MobsCore.RED_FOLLWER.get(), RedFollowerEntity.setAttributes().build());
        event.put(MobsCore.BLACK_SATAN_SOLDIER.get(), BlackSatanSoldierEntity.setAttributes().build());
        event.put(MobsCore.ARI_COMMANDO.get(), AriCommandoEntity.setAttributes().build());
        event.put(MobsCore.DOGMA_FIGHTER.get(), DogmaFighterEntity.setAttributes().build());
        event.put(MobsCore.COMBAT_ROID.get(), CombatRoidEntity.setAttributes().build());
        event.put(MobsCore.CHAP.get(), ChapEntity.setAttributes().build());
        event.put(MobsCore.CHAP_GREY.get(), ChapGreyEntity.setAttributes().build());
        event.put(MobsCore.SHADOWMOON.get(), ShadowmoonEntity.setAttributes().build());

        event.put(MobsCore.BATTA_AUGMENT.get(), BattaAugmentEntity.setAttributes().build());
        event.put(MobsCore.SHIN_NO_0.get(), ShinNo0Entity.setAttributes().build());
    }


    private static void heiseiPhaseOneAttributes (EntityAttributeCreationEvent event) {
        event.put(MobsCore.ZU_GUMUN_BA.get(), ZuGumunBaEntity.setAttributes().build());
        event.put(MobsCore.N_DAGUVA_ZEBA.get(), NDaguvaZebaEntity.setAttributes().build());

        event.put(MobsCore.PANTHERAS_LUTEUS.get(), PantherasLuteusEntity.setAttributes().build());
        event.put(MobsCore.EL_OF_THE_WATER.get(), ElOfTheWaterEntity.setAttributes().build());
        event.put(MobsCore.ANGUIS_MASCULUS.get(), AnguisMasculusEntity.setAttributes().build());
        event.put(MobsCore.ANOTHER_AGITO.get(), AnotherAgitoEntity.setAttributes().build());

        event.put(MobsCore.MIRROR_RIDER.get(), MirrorRiderEntity.setAttributes().build());
        event.put(MobsCore.ODIN.get(), OdinEntity.setAttributes().build());

        event.put(MobsCore.RIOTROOPER.get(), RiotrooperEntity.setAttributes().build());
        event.put(MobsCore.ORGA.get(), OrgaEntity.setAttributes().build());
        event.put(MobsCore.MUEZ.get(), MuezEntity.setAttributes().build());
        event.put(MobsCore.FAIZ.get(), FaizEntity.setAttributes().build());
        event.put(MobsCore.AUTO_VAJIN_ROBO.get(), AutoVajinRoboEntity.setAttributes().build());

        event.put(MobsCore.BAKENEKO.get(), BakenekoEntity.setAttributes().build());
        event.put(MobsCore.MIDAREDOUJI.get(), MidaredoujiEntity.setAttributes().build());
        event.put(MobsCore.MAKAMOU_NINJA_GROUP.get(), MakamouNinjaGroupEntity.setAttributes().build());
        event.put(MobsCore.KABUKI.get(), KabukiEntity.setAttributes().build());

        event.put(MobsCore.ZECTROOPER.get(), ZectrooperEntity.setAttributes().build());
        event.put(MobsCore.SHADOW_TROOPER.get(), ShadowTrooperEntity.setAttributes().build());
        event.put(MobsCore.NEOTROOPER.get(), NeotrooperEntity.setAttributes().build());
        event.put(MobsCore.CAUCASUS.get(), CaucasusEntity.setAttributes().build());

        event.put(MobsCore.NEW_MOLE_IMAGIN.get(), NewMoleImaginEntity.setAttributes().build());
        event.put(MobsCore.NEW_MOLE_IMAGIN_SAND.get(), NewMoleImaginSandEntity.setAttributes().build());
        event.put(MobsCore.GAOH.get(), GaohEntity.setAttributes().build());
        event.put(MobsCore.MOMOTAROS.get(), MomotarosEntity.setAttributes().build());
        event.put(MobsCore.URATAROS.get(), UratarosEntity.setAttributes().build());
        event.put(MobsCore.KINTAROS.get(), KintarosEntity.setAttributes().build());
        event.put(MobsCore.RYUTAROS.get(), RyutarosEntity.setAttributes().build());

        event.put(MobsCore.ARC.get(), ArcEntity.setAttributes().build());
        event.put(MobsCore.GARULU.get(), GaruluEntity.setAttributes().build());
        event.put(MobsCore.BASSHAA.get(), BasshaaEntity.setAttributes().build());
        event.put(MobsCore.DOGGA.get(), DoggaEntity.setAttributes().build());
        event.put(MobsCore.MOOSE_FANGIRE.get(), MooseFangireEntity.setAttributes().build());

        event.put(MobsCore.DECADE_VIOLENT.get(), DecadeViolentEntity.setAttributes().build());
    }


    private static void heiseiPhaseTwoAttributes (EntityAttributeCreationEvent event) {
        event.put(MobsCore.MASQUERADE.get(), MasqueradeEntity.setAttributes().build());
        event.put(MobsCore.CLAYDOLL_DOPANT.get(), ClayDollDopantEntity.setAttributes().build());
        event.put(MobsCore.TERROR_DOPANT.get(), TerrorDopantEntity.setAttributes().build());
        event.put(MobsCore.NASCA_DOPANT.get(), NazcaDopantEntity.setAttributes().build());
        event.put(MobsCore.SMILODON_DOPANT.get(), SmilodonDopantEntity.setAttributes().build());
        event.put(MobsCore.WEATHER_DOPANT.get(), WeatherDopantEntity.setAttributes().build());
        event.put(MobsCore.TABOO_DOPANT.get(), TabooDopantEntity.setAttributes().build());

        event.put(MobsCore.FOUNDATION_X_MASQUERADE.get(), FoundationXMasqueradeEntity.setAttributes().build());
        event.put(MobsCore.COMMANDER_DOPANT.get(), CommanderDopantEntity.setAttributes().build());
        event.put(MobsCore.ETERNAL.get(), EternalEntity.setAttributes().build());

        event.put(MobsCore.MUCHIRI.get(), MuchiriEntity.setAttributes().build());
        event.put(MobsCore.YUMMY.get(), YummyEntity.setAttributes().build());
        event.put(MobsCore.KNIGHT_SOLDIER.get(), KnightSoldierEntity.setAttributes().build());
        event.put(MobsCore.ANKH.get(), AnkhEntity.setAttributes().build());

        event.put(MobsCore.ANKHCOMPLETE.get(), AnkhCompleteEntity.setAttributes().build());
        event.put(MobsCore.ANKH_LOST.get(), AnkhLostEntity.setAttributes().build());
        event.put(MobsCore.UVA.get(), UvaEntity.setAttributes().build());
        event.put(MobsCore.KAZARI.get(), KazariEntity.setAttributes().build());
        event.put(MobsCore.MEZOOL.get(), MezoolEntity.setAttributes().build());
        event.put(MobsCore.GAMEL.get(), GamelEntity.setAttributes().build());
        event.put(MobsCore.KYORYU_GREEED.get(), KyoryuGreeedEntity.setAttributes().build());
        event.put(MobsCore.SHOCKER_GREEED.get(), ShockerGreeedEntity.setAttributes().build());
        event.put(MobsCore.POSEIDON.get(), PoseidonEntity.setAttributes().build());
        event.put(MobsCore.CORE.get(), CoreEntity.setAttributes().build());
        event.put(MobsCore.POWERED_UP_CORE.get(), PoweredUpCoreEntity.setAttributes().build());
        event.put(MobsCore.ANCIENT_OOO.get(), AncientOOOEntity.setAttributes().build());
        event.put(MobsCore.GODA.get(), GodaEntity.setAttributes().build());
        event.put(MobsCore.SUPER_GINGAOH.get(), SuperGingaOhEntity.setAttributes().build());

        event.put(MobsCore.GHOULS.get(), GhoulsEntity.setAttributes().build());
        event.put(MobsCore.MEDUSA_PHANTOM.get(), MedusaPhantomEntity.setAttributes().build());
        event.put(MobsCore.PHOENIX_PHANTOM.get(), PhoenixPhantomEntity.setAttributes().build());
        event.put(MobsCore.GREMLIN_PHANTOM.get(), GremlinPhantomEntity.setAttributes().build());
        event.put(MobsCore.MAGE_FOOTSOLDIER.get(), MageFootsoldierEntity.setAttributes().build());
        event.put(MobsCore.MAGE_CAPTAIN.get(), MageCaptainEntity.setAttributes().build());
        event.put(MobsCore.SORCERER.get(), SorcererEntity.setAttributes().build());
        event.put(MobsCore.WISEMAN.get(), WisemanEntity.setAttributes().build());

        event.put(MobsCore.ELEMENTARY_INVES_RED.get(), ElementaryInvesRedEntity.setAttributes().build());
        event.put(MobsCore.KUROKAGE_TROOPER.get(), KurokageTrooperEntity.setAttributes().build());
        event.put(MobsCore.ZANGETSU_SHIN.get(), ZangetsuShinEntity.setAttributes().build());
        event.put(MobsCore.MARIKA.get(), MarikaEntity.setAttributes().build());
        event.put(MobsCore.DUKE.get(), DukeEntity.setAttributes().build());
        event.put(MobsCore.SIGURD.get(), SigurdEntity.setAttributes().build());
        event.put(MobsCore.ROSYUO.get(), RosyuoEntity.setAttributes().build());
        event.put(MobsCore.REDYUE.get(), RedyueEntity.setAttributes().build());
        event.put(MobsCore.DEMUSHU.get(), DemushuEntity.setAttributes().build());
        event.put(MobsCore.LORD_BARON.get(), LordBaronEntity.setAttributes().build());
        event.put(MobsCore.MEGAHEX.get(), MegahexEntity.setAttributes().build());

        event.put(MobsCore.ROIDMUDE.get(), RoidmudeEntity.setAttributes().build());
        event.put(MobsCore.REAPER_LEGION.get(), ReaperlegionEntity.setAttributes().build());
        event.put(MobsCore.MASHIN_CHASER.get(), MashinChaserEntity.setAttributes().build());
        event.put(MobsCore.HEART_ROIDMUDE.get(), HeartRoidmudeEntity.setAttributes().build());
        event.put(MobsCore.BRAIN_ROIDMUDE.get(), BrainRoidmudeEntity.setAttributes().build());
        event.put(MobsCore.MEDIC_ROIDMUDE.get(), MedicRoidmudeEntity.setAttributes().build());
        event.put(MobsCore.GORD_DRIVE.get(), GordDriveEntity.setAttributes().build());
        event.put(MobsCore.DARK_DRIVE.get(), DarkDriveEntity.setAttributes().build());

        event.put(MobsCore.GAMMA_COMMANDO.get(), GammaCommandoEntity.setAttributes().build());
        event.put(MobsCore.IGOR.get(), IgorEntity.setAttributes().build());
        event.put(MobsCore.NECROM.get(), NecromEntity.setAttributes().build());
        event.put(MobsCore.DARK_NECROM.get(), DarkNecromEntity.setAttributes().build());
        event.put(MobsCore.DARK_GHOST.get(), DarkGhostEntity.setAttributes().build());

        event.put(MobsCore.BUGSTERVIRUS.get(), BugsterVirusEntity.setAttributes().build());
        event.put(MobsCore.NEBULA_BUGSTERVIRUS.get(), NebulaBugsterVirusEntity.setAttributes().build());
        event.put(MobsCore.GRAPHITE_BUGSTER.get(), GraphiteBugsterEntity.setAttributes().build());
        event.put(MobsCore.GENM.get(), GenmEntity.setAttributes().build());
        event.put(MobsCore.POPPY_RED.get(), PoppyRedEntity.setAttributes().build());
        event.put(MobsCore.RIDEPLAYER.get(), RideplayerEntity.setAttributes().build());
        event.put(MobsCore.PARADX.get(), ParaDxEntity.setAttributes().build());
        event.put(MobsCore.CRONUS.get(), CronusEntity.setAttributes().build());

        event.put(MobsCore.HOKUTOGUARDIAN.get(), HokutoGuardianEntity.setAttributes().build());
        event.put(MobsCore.TOUTOGUARDIAN.get(), GuardianEntity.setAttributes().build());
        event.put(MobsCore.SEITOGUARDIAN.get(), SeitoGuardianEntity.setAttributes().build());
        event.put(MobsCore.HARD_GUARDIAN.get(), HardGuardianEntity.setAttributes().build());
        event.put(MobsCore.DOWNFALL_GUARDIAN.get(), DownfallGuardianEntity.setAttributes().build());
        event.put(MobsCore.PHANTOM_CRUSHER.get(), PhantomCrusherEntity.setAttributes().build());
        event.put(MobsCore.SMASH.get(), SmashEntity.setAttributes().build());
        event.put(MobsCore.BLOOD_STALK.get(), BloodStalkEntity.setAttributes().build());
        event.put(MobsCore.NIGHT_ROGUE.get(), NightRogueEntity.setAttributes().build());
        event.put(MobsCore.GREASE.get(), GreaseEntity.setAttributes().build());
        event.put(MobsCore.BUILD.get(), BuildEntity.setAttributes().build());
        event.put(MobsCore.EVOL.get(), EvolEntity.setAttributes().build());
        event.put(MobsCore.KILLBUS.get(), KillbusEntity.setAttributes().build());
        event.put(MobsCore.STAG_LOST_SMASH.get(), StagLostSmashEntity.setAttributes().build());
        event.put(MobsCore.OWL_LOST_SMASH.get(), OwlLostSmashEntity.setAttributes().build());
        event.put(MobsCore.CASTLE_LOST_SMASH.get(), CastleLostSmashEntity.setAttributes().build());
        event.put(MobsCore.ENGINE_BROS.get(), EngineBrosEntity.setAttributes().build());
        event.put(MobsCore.REMOCON_BROS.get(), RemoconBrosEntity.setAttributes().build());
        event.put(MobsCore.MAD_ROGUE.get(), MadRogueEntity.setAttributes().build());
        event.put(MobsCore.KAISER.get(), KaiserEntity.setAttributes().build());
        event.put(MobsCore.KAISER_REVERSE.get(), KaiserReverseEntity.setAttributes().build());
        event.put(MobsCore.BIKAISER.get(), KaiserEntity.setAttributes().build());

        event.put(MobsCore.KASSHINE.get(), KasshineEntity.setAttributes().build());
        event.put(MobsCore.ANOTHER_ZI_O.get(), AnotherZiOEntity.setAttributes().build());
        event.put(MobsCore.ANOTHER_DEN_O.get(), AnotherZiOEntity.setAttributes().build());
        event.put(MobsCore.GINGA.get(), GingaEntity.setAttributes().build());
        event.put(MobsCore.WOZ.get(), WozEntity.setAttributes().build());
        event.put(MobsCore.YAMININ.get(), YamininEntity.setAttributes().build());
        event.put(MobsCore.BARLCKXS.get(), BarlckxsEntity.setAttributes().build());
        event.put(MobsCore.ZONJIS.get(), ZonjisEntity.setAttributes().build());
        event.put(MobsCore.ZAMONAS.get(), ZamonasEntity.setAttributes().build());
        event.put(MobsCore.TAKA_WATCHROID.get(), TakaWatchroidEntity.setAttributes().build());
        event.put(MobsCore.KODAMA_SUIKA_ARMS.get(), KodamaSuikaArmsEntity.setAttributes().build());
    }


    private static void reiwaAttributes (EntityAttributeCreationEvent event) {
        event.put(MobsCore.TRILOBITE_MAGIA.get(), TrilobiteMagiaEntity.setAttributes().build());
        event.put(MobsCore.DODO_MAGIA_CHICK.get(), DodoMagiaChickEntity.setAttributes().build());
        event.put(MobsCore.BATTLE_RAIDER.get(), BattleRaiderEntity.setAttributes().build());
        event.put(MobsCore.ABADDON.get(), AbaddonEntity.setAttributes().build());
        event.put(MobsCore.MAGIA.get(), MagiaEntity.setAttributes().build());
        event.put(MobsCore.GIGER.get(), GigerEntity.setAttributes().build());
        event.put(MobsCore.HOROBI.get(), HorobiEntity.setAttributes().build());
        event.put(MobsCore.JIN.get(), JinEntity.setAttributes().build());
        event.put(MobsCore.IKAZUCHI.get(), IkazuchiEntity.setAttributes().build());
        event.put(MobsCore.NAKI.get(), NakiEntity.setAttributes().build());
        event.put(MobsCore.DODO_MAGIA.get(), DodoMagiaEntity.setAttributes().build());
        event.put(MobsCore.RAIDER.get(), RaiderEntity.setAttributes().build());
        event.put(MobsCore.ARK_ZERO.get(), ArkZeroEntity.setAttributes().build());
        event.put(MobsCore.ABADDON_COMMANDER.get(), AbaddonCommanderEntity.setAttributes().build());
        event.put(MobsCore.EDEN.get(), EdenEntity.setAttributes().build());
        event.put(MobsCore.ZAIA.get(), ZaiaEntity.setAttributes().build());
        event.put(MobsCore.DIRE_WOLF_SOLD_MAGIA.get(), DireWolfSoldMagiaEntity.setAttributes().build());
        event.put(MobsCore.SERVAL_TIGER_SOLD_MAGIA.get(), ServalTigerSoldMagiaEntity.setAttributes().build());
        event.put(MobsCore.ZEIN.get(), ZeinEntity.setAttributes().build());

        event.put(MobsCore.SHIMI.get(), ShimiEntity.setAttributes().build());
        event.put(MobsCore.CALIBUR.get(), CaliburEntity.setAttributes().build());
        event.put(MobsCore.FALCHION.get(), FalchionEntity.setAttributes().build());
        event.put(MobsCore.SABELA.get(), SabelaEntity.setAttributes().build());
        event.put(MobsCore.DURENDAL.get(), DurendalEntity.setAttributes().build());
        event.put(MobsCore.SOLOMON.get(), SolomonEntity.setAttributes().build());
        event.put(MobsCore.STORIOUS_RIDER.get(), StoriousRiderEntity.setAttributes().build());
        event.put(MobsCore.LEGEIEL.get(), LegeielEntity.setAttributes().build());
        event.put(MobsCore.LEGEIEL_FORBIDDEN.get(), LegeielForbiddenEntity.setAttributes().build());
        event.put(MobsCore.ZOOOUS.get(), ZooousEntity.setAttributes().build());
        event.put(MobsCore.ZOOOUS_PREDATOR.get(), ZooousPredatorEntity.setAttributes().build());
        event.put(MobsCore.STORIOUS.get(), StoriousEntity.setAttributes().build());
        event.put(MobsCore.DESAST.get(), DesastEntity.setAttributes().build());
        event.put(MobsCore.CHARYBDIS.get(), CharybdisEntity.setAttributes().build());
        event.put(MobsCore.CHARYBDIS_HERCULES.get(), CharybdisHerculesEntity.setAttributes().build());

        event.put(MobsCore.GIFF_JUNIOR.get(), GiffJuniorEntity.setAttributes().build());
        event.put(MobsCore.EVIL.get(), EvilEntity.setAttributes().build());
        event.put(MobsCore.DAIOUIKA_DEADMAN.get(), DaiouikaDeadmanEntity.setAttributes().build());
        event.put(MobsCore.ANOMALOCARIS_DEADMAN.get(), AnomalocarisDeadmanEntity.setAttributes().build());
        event.put(MobsCore.QUEEN_BEE_DEADMAN.get(), QueenBeeDeadmanEntity.setAttributes().build());
        event.put(MobsCore.WOLF_DEADMAN.get(), WolfDeadmanEntity.setAttributes().build());
        event.put(MobsCore.CRIMSON_VAIL.get(), VailEntity.setAttributes().build());

        event.put(MobsCore.PAWN_JYAMATO.get(), PawnJyamatoEntity.setAttributes().build());
        event.put(MobsCore.JYAMATO_RIDER.get(), JyamatoRiderEntity.setAttributes().build());
        event.put(MobsCore.GM_RIDER.get(), GmRiderEntity.setAttributes().build());
        event.put(MobsCore.GLARE.get(), GlareEntity.setAttributes().build());
        event.put(MobsCore.GLARE2.get(), Glare2Entity.setAttributes().build());
        event.put(MobsCore.GAZER.get(), GazerEntity.setAttributes().build());
        event.put(MobsCore.END_RIDER.get(), EndRiderEntity.setAttributes().build());
        event.put(MobsCore.PREMIUM_BEROBA.get(), PremiumBerobaEntity.setAttributes().build());
        event.put(MobsCore.PREMIUM_KEKERA.get(), PremiumKekeraEntity.setAttributes().build());

        event.put(MobsCore.MALGAM.get(), MalgamEntity.setAttributes().build());
        event.put(MobsCore.DREAD.get(), DreadEntity.setAttributes().build());
        event.put(MobsCore.GOLEM.get(), GolemEntity.setAttributes().build());
        event.put(MobsCore.GIGIST.get(), GigistEntity.setAttributes().build());
        event.put(MobsCore.GERMAIN.get(), GermainEntity.setAttributes().build());
        event.put(MobsCore.GAELIJAH.get(), GaelijahEntity.setAttributes().build());
        event.put(MobsCore.ELD.get(), EldEntity.setAttributes().build());
        event.put(MobsCore.DREATROOPER.get(), DreaTrooperEntity.setAttributes().build());
        event.put(MobsCore.DREATROOPER_COMMANDER.get(), DreaTrooperCommanderEntity.setAttributes().build());
        event.put(MobsCore.DORADO.get(), DoradoEntity.setAttributes().build());

        event.put(MobsCore.AGENT.get(), AgentEntity.setAttributes().build());
        event.put(MobsCore.BITTER_GAVV.get(), BitterGavvEntity.setAttributes().build());
        event.put(MobsCore.NYELV_STOMACH.get(), NyelvEntity.setAttributes().build());
        event.put(MobsCore.GLOTTA_STOMACH.get(), GlottaEntity.setAttributes().build());
        event.put(MobsCore.JEEB_STOMACH.get(), JeebEntity.setAttributes().build());
        event.put(MobsCore.SHIITA_STOMACH.get(), ShiitaEntity.setAttributes().build());
        event.put(MobsCore.LANGO_STOMACH.get(), LangoEntity.setAttributes().build());
        event.put(MobsCore.BOCCA_JALDAK.get(), BoccaEntity.setAttributes().build());
        event.put(MobsCore.CARIES.get(), CariesEntity.setAttributes().build());

        event.put(MobsCore.NOX.get(), NoxEntity.setAttributes().build());
    }


    private static void vehicleAttributes (EntityAttributeCreationEvent event) {
        event.put(MobsCore.BICYCLE.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.ACROBATTER.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.RIDORON.get(), RidoronEntity.setAttributes().build());
        event.put(MobsCore.MACEHINE_TORADOR.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.AUTO_VAJIN.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.MACEHINE_DENBIRD.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.HARDBOILER.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.SKULLBOILER.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.ACCEL_BIKE_FORM.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.RIDEVENDOR.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.RIDEVENDOR_VENDING_MODE.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.MACEHINE_MASSIGLER.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.TORIDEVENDOR.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.BIKE_GAMER.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.SPORTS_GAMER.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.PROTO_SPORTS_GAMER.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.SAKURA_HURRICANE.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.ROSE_ATTACKER.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.MACEHINE_BUILDER.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.RIDESTRIKER.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.RISEHOPPER.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.DIAGOSPEEDY.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.VICE_BIKE.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.BOOSTRIKER.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.BOOSTRIKER_GEATS_MODE.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.BOOSTRIKER_TYCOON_MODE.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.BOOSTRIKER_NA_GO_MODE.get(), baseBikeEntity.setAttributes().build());
        event.put(MobsCore.BOOSTRIKER_BUFFA_MODE.get(), baseBikeEntity.setAttributes().build());
    }


    private static void allyAttributes (EntityAttributeCreationEvent event) {
        event.put(MobsCore.TAKA_CAN.get(), TakaCanEntity.setAttributes().build());
        event.put(MobsCore.TAKO_CAN.get(), TakoCanEntity.setAttributes().build());
        event.put(MobsCore.BATTA_CAN.get(), BattaCanEntity.setAttributes().build());
        event.put(MobsCore.TORA_CAN.get(), ToraCanEntity.setAttributes().build());
        event.put(MobsCore.DENKIUNAGI_CAN.get(), DenkiunagiCanEntity.setAttributes().build());
        event.put(MobsCore.GORILLA_CAN.get(), GorillaCanEntity.setAttributes().build());
        event.put(MobsCore.KUJAKU_CAN.get(), KujakuCanEntity.setAttributes().build());
        event.put(MobsCore.PTERA_CAN.get(), PteraCanEntity.setAttributes().build());
        event.put(MobsCore.TORIKERA_CAN.get(), TorikeraCanEntity.setAttributes().build());

        event.put(MobsCore.RIDER_SUMMON.get(), RiderSummonEntity.setAttributes().build());
        event.put(MobsCore.COMPLETE_SUMMON.get(), CompleteSummonEntity.setAttributes().build());
        event.put(MobsCore.GRAND_SUMMON.get(), GrandSummonEntity.setAttributes().build());
        event.put(MobsCore.LEGENDARY_SUMMON.get(), LegendarySummonEntity.setAttributes().build());
        event.put(MobsCore.ZEIN_SUMMON.get(), ZeinSummonEntity.setAttributes().build());
        event.put(MobsCore.ENEMY_SUMMON.get(), EnemySummonEntity.setAttributes().build());
        event.put(MobsCore.ZEIN_ENEMY_SUMMON.get(), ZeinEnemySummonEntity.setAttributes().build());
        event.put(MobsCore.PARADX_SUMMON.get(), ParaDXSummonEntity.setAttributes().build());
        event.put(MobsCore.DECADE_ARMOR_EX_AID.get(), DecadeArmorExAidEntity.setAttributes().build());
        event.put(MobsCore.VICE.get(), ViceEntity.setAttributes().build());
        event.put(MobsCore.LOVEKOV.get(), LovekovEntity.setAttributes().build());
        event.put(MobsCore.WHIPPED_SOLDIER.get(), WhippedSoldierEntity.setAttributes().build());
        event.put(MobsCore.APOLLO.get(), ApolloEntity.setAttributes().build());
        event.put(MobsCore.LIBRA.get(), LibraEntity.setAttributes().build());
        event.put(MobsCore.TOJIMA_TAKOYAKI.get(), TojimaTakoyakiEntity.setAttributes().build());
    }
}
