package com.kelco.kamenridercraft;

import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.client.renderer.AllyEntityRenderer;
import com.kelco.kamenridercraft.client.renderer.AnkhRenderer;
import com.kelco.kamenridercraft.client.renderer.BasicEntityRenderer;
import com.kelco.kamenridercraft.client.renderer.BikeRenderer;
import com.kelco.kamenridercraft.client.renderer.NewMoleImaginSandRenderer;
import com.kelco.kamenridercraft.client.renderer.SummonedEntityRenderer;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.allies.*;
import com.kelco.kamenridercraft.entities.bikes.*;
import com.kelco.kamenridercraft.entities.bosses.*;
import com.kelco.kamenridercraft.entities.footSoldiers.*;
import com.kelco.kamenridercraft.entities.summons.*;
import com.kelco.kamenridercraft.entities.villager.RiderVillagers;
import com.kelco.kamenridercraft.events.ModClientEvents;
import com.kelco.kamenridercraft.events.ModCommonEvents;
import com.kelco.kamenridercraft.item.*;
import com.kelco.kamenridercraft.item.BaseItems.BaseSwordItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import com.kelco.kamenridercraft.loot.LootModifierCore;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import java.util.ArrayList;
import java.util.List;


@Mod(KamenRiderCraftCore.MOD_ID)
public class KamenRiderCraftCore
{
     public static final String MOD_ID = "kamenridercraft";
    private static final Logger LOGGER = LogUtils.getLogger();

    private static final ResourceLocation BLOCKING_PROPERTY_RESLOC =  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "blocking");

    public static List<Item> CHANGE_SWORD_ITEM= new ArrayList<Item>();

    public static List<Item> SWORD_GUN_ITEM= new ArrayList<Item>();

    public static List<Item> KUUGA_CHANGING_ITEM= new ArrayList<Item>();

    public static List<Item> RAISE_RISER_ITEM= new ArrayList<Item>();

    public static List<Item> SHIELD_ITEM= new ArrayList<Item>();

    public static List<Item> DARK_SHIELD_ITEM= new ArrayList<Item>();


    public KamenRiderCraftCore(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
       NeoForge.EVENT_BUS.register(new ModCommonEvents.CommonEvents());
        NeoForge.EVENT_BUS.register(new ModCommonEvents.EventHandler());

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);
        Effect_core.register(modEventBus);



        Modded_item_core.register(modEventBus);
        Ichigo_Rider_Items.register(modEventBus);
        Kuuga_Rider_Items.register(modEventBus);
        Agito_Rider_Items.register(modEventBus);
        Ryuki_Rider_Items.register(modEventBus);
        Faiz_Rider_Items.register(modEventBus);
        Blade_Rider_Items.register(modEventBus);
        Hibiki_Rider_Items.register(modEventBus);
        Kabuto_Rider_Items.register(modEventBus);
        Den_O_Rider_Items.register(modEventBus);
        Kiva_Rider_Items.register(modEventBus);
        Decade_Rider_Items.register(modEventBus);
        W_Rider_Items.register(modEventBus);
        OOO_Rider_Items.register(modEventBus);
        Wizard_Rider_Items.register(modEventBus);
        Drive_Rider_Items.register(modEventBus);
        Ghost_Rider_Items.register(modEventBus);
        Ex_Aid_Rider_Items.register(modEventBus);
        Build_Rider_Items.register(modEventBus);
        Zero_One_Rider_Items.register(modEventBus);
        Revice_Rider_Items.register(modEventBus);
        Geats_Rider_Items.register(modEventBus);
        Gotchard_Rider_Items.register(modEventBus);
        Gavv_Rider_Items.register(modEventBus);
        Reboot_Rider_Items.register(modEventBus);
        Miscellaneous_Rider_Items.register(modEventBus);
        Rider_Blocks.register(modEventBus);
        MobsCore.register(modEventBus);
        MobsCore.MOBLIST.register(modEventBus);
        RiderTabs.register(modEventBus);
        RiderVillagers.register(modEventBus);

        LootModifierCore.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(KamenRiderCraftCore::entityAttributeEvent);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }


    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

	private static void entityAttributeEvent(EntityAttributeCreationEvent event) {
		event.put(MobsCore.SHOCKER_COMBATMAN.get(), ShockerCombatmanEntity.setAttributes().build());
		event.put(MobsCore.SHOCKER_RIDER.get(), ShockerRidersEntity.setAttributes().build());
		event.put(MobsCore.DESTRON_COMBATMAN.get(), DestronCombatmanEntity.setAttributes().build());
		event.put(MobsCore.GOD_WARFARE_AGENT.get(), GODWarfareAgentEntity.setAttributes().build());
		event.put(MobsCore.RED_FOLLWER.get(), RedFollowerEntity.setAttributes().build());
		event.put(MobsCore.BLACK_SATAN_SOLDIER.get(), BlackSatanSoldierEntity.setAttributes().build());
		event.put(MobsCore.ARI_COMMANDO.get(), AriCommandoEntity.setAttributes().build());
		event.put(MobsCore.DOGMA_FIGHTER.get(), DogmaFighterEntity.setAttributes().build());
		event.put(MobsCore.COMBAT_ROID.get(), CombatRoidEntity.setAttributes().build());
		event.put(MobsCore.CHAP.get(), ChapEntity.setAttributes().build());
		event.put(MobsCore.CHAP_GREY.get(), ChapGreyEntity.setAttributes().build());
		event.put(MobsCore.SHADOWMOON.get(), ShadowmoonEntity.setAttributes().build());

		event.put(MobsCore.ZU_GUMUN_BA.get(), ZuGumunBaEntity.setAttributes().build());

		event.put(MobsCore.PANTHERAS_LUTEUS.get(), PantherasLuteusEntity.setAttributes().build());
		event.put(MobsCore.EL_OF_THE_WATER.get(), ElOfTheWaterEntity.setAttributes().build());
		event.put(MobsCore.ANGUIS_MASCULUS.get(), AnguisMasculusEntity.setAttributes().build());
		event.put(MobsCore.ANOTHER_AGITO.get(), AnotherAgitoEntity.setAttributes().build());

		event.put(MobsCore.RIOTROOPER.get(), RiotrooperEntity.setAttributes().build());
		event.put(MobsCore.ORGA.get(), OrgaEntity.setAttributes().build());

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

		event.put(MobsCore.MASQUERADE.get(), MasqueradeEntity.setAttributes().build());
		event.put(MobsCore.CLAYDOLL_DOPANT.get(), ClayDollDopantEntity.setAttributes().build());
		event.put(MobsCore.TERROR_DOPANT.get(), TerrorDopantEntity.setAttributes().build());
		event.put(MobsCore.NASCA_DOPANT.get(), NazcaDopantEntity.setAttributes().build());
		// event.put(MobsCore.RED_NASCA_DOPANT.get(),RedNazcaDopantEntity.setAttributes().build());
		event.put(MobsCore.SMILODON_DOPANT.get(), SmilodonDopantEntity.setAttributes().build());
		event.put(MobsCore.WEATHER_DOPANT.get(), WeatherDopantEntity.setAttributes().build());

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
		event.put(MobsCore.POSEIDON.get(), PoseidonEntity.setAttributes().build());
		event.put(MobsCore.CORE.get(), CoreEntity.setAttributes().build());
		event.put(MobsCore.POWERED_UP_CORE.get(), PoweredUpCoreEntity.setAttributes().build());
		event.put(MobsCore.ANCIENT_OOO.get(), AncientOOOEntity.setAttributes().build());
		event.put(MobsCore.GODA.get(), GodaEntity.setAttributes().build());

        event.put(MobsCore.GHOULS.get(), GhoulsEntity.setAttributes().build());
        event.put(MobsCore.MEDUSA_PHANTOM.get(), MedusaPhantomEntity.setAttributes().build());
        event.put(MobsCore.PHOENIX_PHANTOM.get(), PhoenixPhantomEntity.setAttributes().build());
        event.put(MobsCore.GREMLIN_PHANTOM.get(), GremlinPhantomEntity.setAttributes().build());
        event.put(MobsCore.MAGE_FOOTSOLDIER.get(), MageFootsoldierEntity.setAttributes().build());
        event.put(MobsCore.MAGE_CAPTAIN.get(), MageCaptainEntity.setAttributes().build());
        event.put(MobsCore.SORCERER.get(), SorcererEntity.setAttributes().build());
        event.put(MobsCore.WISEMAN.get(), WisemanEntity.setAttributes().build());

		event.put(MobsCore.GAMMA_COMMANDO.get(), GammaCommandoEntity.setAttributes().build());

		event.put(MobsCore.BUGSTERVIRUS.get(), BugsterVirusEntity.setAttributes().build());
		//event.put(MobsCore.MIGHTY_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.TADDLE_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.BANG_BANG_BUGSTER.get(), GodaEntity.setAttributes().build());
	//	event.put(MobsCore.LOVELY_BUGSTER.get(), LovelyBugsterEntity.setAttributes().build());
		//event.put(MobsCore.SALTY_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.CHARLIE_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.VERNIER_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.GATTON_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.KAIDEN_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.MOTORS_BUGSTER.get(), GodaEntity.setAttributes().build());
		event.put(MobsCore.GRAPHITE_BUGSTER.get(), GraphiteBugsterEntity.setAttributes().build());
		//event.put(MobsCore.ARANBURA_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.REVOL_BUGSTER.get(), GodaEntity.setAttributes().build());
		//event.put(MobsCore.LOVELICA_BUGSTER.get(), LovelicaBugsterEntity.setAttributes().build());
		event.put(MobsCore.GENM.get(), GenmEntity.setAttributes().build());
		event.put(MobsCore.POPPY_RED.get(), PoppyRedEntity.setAttributes().build());
		event.put(MobsCore.RIDEPLAYER.get(), RideplayerEntity.setAttributes().build());
		event.put(MobsCore.PARADX.get(), ParaDxEntity.setAttributes().build());
		event.put(MobsCore.CRONUS.get(), CronusEntity.setAttributes().build());

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

		event.put(MobsCore.GIFF_JUNIOR.get(), GiffJuniorEntity.setAttributes().build());
		event.put(MobsCore.EVIL.get(), EvilEntity.setAttributes().build());
		event.put(MobsCore.DAIOUIKA_DEADMAN.get(), DaiouikaDeadmanEntity.setAttributes().build());
        event.put(MobsCore.ANOMALOCARIS_DEADMAN.get(), DaiouikaDeadmanEntity.setAttributes().build());

		event.put(MobsCore.PAWN_JYAMATO.get(), PawnJyamatoEntity.setAttributes().build());
		event.put(MobsCore.JYAMATO_RIDER.get(), JyamatoRiderEntity.setAttributes().build());
		event.put(MobsCore.GM_RIDER.get(), GmRiderEntity.setAttributes().build());

		event.put(MobsCore.MACEHINE_TORADOR.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.HARDBOILER.get(), baseBikeEntity.setAttributes().build());
		event.put(MobsCore.SKULLBOILER.get(), baseBikeEntity.setAttributes().build());

		event.put(MobsCore.RIDER_SUMMON.get(), RiderSummonEntity.setAttributes().build());
		event.put(MobsCore.PARADX_SUMMON.get(), ParaDXSummonEntity.setAttributes().build());

	}

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        RiderTabs.AddItemsToTabs(event);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            NeoForge.EVENT_BUS.register(new ModClientEvents.ClientEvents());



                for (int i = 0; i < SHIELD_ITEM.size(); i++)
                {

                    ItemProperties.register(SHIELD_ITEM.get(i), BLOCKING_PROPERTY_RESLOC, ($itemStack, $level, $entity, $seed) -> {
                        return $entity != null && $entity.isUsingItem() && $entity.getUseItem() == $itemStack ? 1.0F : 0.0F;
                    });
                }


            for (Item item : KUUGA_CHANGING_ITEM) {
                ItemProperties.register(item, ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                            if (p_174637_ == null) {
                                return 0.0F;
                            } else if (p_174637_.getItemBySlot(EquipmentSlot.FEET) != null) {

                                if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == Kuuga_Rider_Items.ARCLE.get()) {
                                    ItemStack belt = p_174637_.getItemBySlot(EquipmentSlot.FEET);
                                    if (RiderDriverItem.get_Form_Item(belt, 1).getBeltTex() == "arcle_belt_r") return 1;
                                    if (RiderDriverItem.get_Form_Item(belt, 1).getBeltTex() == "arcle_belt_u") return 2;
                                    if (RiderDriverItem.get_Form_Item(belt, 1).getBeltTex() == "arcle_belt_ru") return 2;
                                } else {
                                    return 0;
                                }
                                return 0;
                            }
                            return 0;
                            //return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 1.0F;
                        }
                );
            }



 for (int i = 0; i < RAISE_RISER_ITEM.size(); i++)
 {
 ItemProperties.register(RAISE_RISER_ITEM.get(i), ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
 if (p_174637_ == null) {
 return 0.0F;
 }
 else if (p_174637_.getItemBySlot(EquipmentSlot.FEET)!= null){
 if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == Geats_Rider_Items.RAISE_RISER_BELT_ZIIN.get()) {
 return 1;
 } else if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == Geats_Rider_Items.RAISE_RISER_BELT_KEKERA.get()) {
 return 2;
 } else if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == Geats_Rider_Items.RAISE_RISER_BELT_KYUUN.get()) {
 return 3;
 } else if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == Geats_Rider_Items.RAISE_RISER_BELT_BEROBA.get()) {
 return 4;
 }
 return 0;
 }
 return 0;
 }
 );
 }



                for (int i = 0; i < SWORD_GUN_ITEM.size(); i++)
                {
                    ItemProperties.register(SWORD_GUN_ITEM.get(i),  ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                        if (p_174637_ == null) {
                            return 0.0F;
                        } else {
                            return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration(p_174637_) - p_174637_.getUseItemRemainingTicks()) / 1.0F;
                        }
                    });
                }

                for (int i = 0; i < CHANGE_SWORD_ITEM.size(); i++)
                {
                    ItemProperties.register(CHANGE_SWORD_ITEM.get(i), ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                        return BaseSwordItem.Get_Mode(p_174635_);

                    });
                }

                 for (int i = 0; i < DARK_SHIELD_ITEM.size(); i++)
                 {
                 ItemProperties.register(DARK_SHIELD_ITEM.get(i), ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                 if (p_174637_ == null) {
                 return 0.0F;
                 }
                 else if (p_174637_.getItemBySlot(EquipmentSlot.FEET)!= null){
                 if (p_174637_.getMainHandItem().getItem() == Ryuki_Rider_Items.DARK_BLADE.get()){
                 return 1;
                 }else {
                 return 0;
                 }
                 }
                 return 0;

                 });
                 }


        }


        @SubscribeEvent
        public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {

            event.registerEntityRenderer(MobsCore.SHOCKER_COMBATMAN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SHOCKER_RIDER.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.DESTRON_COMBATMAN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GOD_WARFARE_AGENT.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.RED_FOLLWER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.BLACK_SATAN_SOLDIER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ARI_COMMANDO.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DOGMA_FIGHTER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.COMBAT_ROID.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CHAP.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CHAP_GREY.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SHADOWMOON.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.ZU_GUMUN_BA.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.PANTHERAS_LUTEUS.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.EL_OF_THE_WATER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ANGUIS_MASCULUS.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ANOTHER_AGITO.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.RIOTROOPER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ORGA.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.ZECTROOPER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SHADOW_TROOPER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.NEOTROOPER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CAUCASUS.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.NEW_MOLE_IMAGIN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.NEW_MOLE_IMAGIN_SAND.get(), NewMoleImaginSandRenderer::new);
            event.registerEntityRenderer(MobsCore.GAOH.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MOMOTAROS.get(), AllyEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.URATAROS.get(), AllyEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.KINTAROS.get(), AllyEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.RYUTAROS.get(), AllyEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.MASQUERADE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.WEATHER_DOPANT.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CLAYDOLL_DOPANT.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.TERROR_DOPANT.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.NASCA_DOPANT.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.RED_NASCA_DOPANT.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SMILODON_DOPANT.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.FOUNDATION_X_MASQUERADE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ETERNAL.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.COMMANDER_DOPANT.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MUCHIRI.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.YUMMY.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.KNIGHT_SOLDIER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ANKHCOMPLETE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.UVA.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.KAZARI.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MEZOOL.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GAMEL.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ANKH_LOST.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ANKH.get(), AnkhRenderer::new);
            event.registerEntityRenderer(MobsCore.POSEIDON.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CORE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.POWERED_UP_CORE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ANCIENT_OOO.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GODA.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.GHOULS.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MEDUSA_PHANTOM.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.PHOENIX_PHANTOM.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GREMLIN_PHANTOM.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MAGE_FOOTSOLDIER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MAGE_CAPTAIN .get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SORCERER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.WISEMAN.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.GAMMA_COMMANDO.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.BUGSTERVIRUS.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.MIGHTY_BUGSTER.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.TADDLE_BUGSTER.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.BANG_BANG_BUGSTER.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.LOVELY_BUGSTER.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.SALTY_BUGSTER.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.CHARLIE_BUGSTER.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.VERNIER_BUGSTER.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.GATTON_BUGSTER.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.KAIDEN_BUGSTER.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.MOTORS_BUGSTER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GRAPHITE_BUGSTER.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.ARANBURA_BUGSTER.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.REVOL_BUGSTER.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.LOVELICA_BUGSTER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GENM.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.POPPY_RED.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.RIDEPLAYER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.PARADX.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CRONUS.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.TRILOBITE_MAGIA.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DODO_MAGIA_CHICK.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.BATTLE_RAIDER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ABADDON.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MAGIA.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GIGER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.HOROBI.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.JIN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.IKAZUCHI.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.NAKI.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DODO_MAGIA.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.RAIDER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ARK_ZERO.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ABADDON_COMMANDER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.EDEN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ZAIA.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DIRE_WOLF_SOLD_MAGIA.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SERVAL_TIGER_SOLD_MAGIA.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.GIFF_JUNIOR.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.EVIL.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DAIOUIKA_DEADMAN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ANOMALOCARIS_DEADMAN.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.PAWN_JYAMATO.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.JYAMATO_RIDER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GM_RIDER.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.MACEHINE_TORADOR.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.HARDBOILER.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.SKULLBOILER.get(), BikeRenderer::new);

            event.registerEntityRenderer(MobsCore.RIDER_SUMMON.get(), SummonedEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.PARADX_SUMMON.get(), SummonedEntityRenderer::new);

        }
    }
}


