package com.kelco.kamenridercraft;

import com.kelco.kamenridercraft.attachments.AttachmentTypes;
import com.kelco.kamenridercraft.block.RiderBlocks;
import com.kelco.kamenridercraft.blockentity.ModBlockEntities;
import com.kelco.kamenridercraft.client.KeyBindings;
import com.kelco.kamenridercraft.client.gui.driver.*;
import com.kelco.kamenridercraft.client.gui.item.LegendRideMagnumGuiScreen;
import com.kelco.kamenridercraft.client.gui.item.NeoDiendriverGuiScreen;
import com.kelco.kamenridercraft.client.gui.item.RideBookerGuiScreen;
import com.kelco.kamenridercraft.client.gui.machine_block.IxaMachineBlockGuiScreen;
import com.kelco.kamenridercraft.client.gui.overlays.AbilityHudOverlay;
import com.kelco.kamenridercraft.client.gui.storage_item.*;
import com.kelco.kamenridercraft.client.renderer.block.GochizoJarBlockEntityRenderer;
import com.kelco.kamenridercraft.client.renderer.block.MindDoorRenderer;
import com.kelco.kamenridercraft.client.renderer.block.PandoraPanelBlockEntityRenderer;
import com.kelco.kamenridercraft.client.renderer.block.PlinthBlockEntityRenderer;
import com.kelco.kamenridercraft.client.renderer.entity.*;
import com.kelco.kamenridercraft.client.renderer.entity.allies.*;
import com.kelco.kamenridercraft.client.renderer.entity.bikes.BikeRenderer;
import com.kelco.kamenridercraft.client.renderer.entity.bikes.BoostrikerRenderer;
import com.kelco.kamenridercraft.client.renderer.entity.mob.*;
import com.kelco.kamenridercraft.client.renderer.entity.projectile.*;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.entity.mobs.summons.BaseSummonEntity;
import com.kelco.kamenridercraft.entity.mobs.villager.RiderVillagers;
import com.kelco.kamenridercraft.events.ModClientEvents;
import com.kelco.kamenridercraft.events.ModCommonEvents;
import com.kelco.kamenridercraft.events.ModServerEvents;
import com.kelco.kamenridercraft.init.ModMenus;
import com.kelco.kamenridercraft.init.RiderPotPattern;
import com.kelco.kamenridercraft.item.KRCCreativeTabs;
import com.kelco.kamenridercraft.item.KRCItemLists;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.extra_riders.*;
import com.kelco.kamenridercraft.item.heisei_phase_1.*;
import com.kelco.kamenridercraft.item.heisei_phase_2.*;
import com.kelco.kamenridercraft.item.misc_items.MusicDiscItems;
import com.kelco.kamenridercraft.item.reboots.AmazonsRiderItems;
import com.kelco.kamenridercraft.item.reboots.BlackSunRiderItems;
import com.kelco.kamenridercraft.item.reboots.ShinIchigoRiderItems;
import com.kelco.kamenridercraft.item.reboots.TheSeriesRiderItems;
import com.kelco.kamenridercraft.item.reiwa.*;
import com.kelco.kamenridercraft.item.showa.*;
import com.kelco.kamenridercraft.level.AddStructuresToPools;
import com.kelco.kamenridercraft.level.ModGameRules;
import com.kelco.kamenridercraft.loot.LootModifierCore;
import com.kelco.kamenridercraft.network.ClientPayloadHandler;
import com.kelco.kamenridercraft.network.ServerPayloadHandler;
import com.kelco.kamenridercraft.network.payload.*;
import com.kelco.kamenridercraft.particle.*;
import com.kelco.kamenridercraft.recipe.ModRecipes;
import com.kelco.kamenridercraft.sounds.ModMusic;
import com.kelco.kamenridercraft.sounds.ModSounds;
import com.kelco.kamenridercraft.util.RegisterItemProperties;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import com.kelco.kamenridercraft.world.level.CustomDimensionEffect;
import com.kelco.kamenridercraft.world.level.levelgen.feature.ModConfiguredFeatures;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.registration.HandlerThread;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Mod(KamenRiderCraftCore.MOD_ID)
public class KamenRiderCraftCore {
    public static final String MOD_ID = "kamenridercraft";

    public static final int NEW_STRUCTURE_SIZE = 512;

    public static List<Item> CHANGE_SWORD_ITEM = new ArrayList<>();
    public static List<Item> SWORD_GUN_ITEM = new ArrayList<>();
    public static List<Item> KUUGA_CHANGING_ITEM = new ArrayList<>();
    public static List<Item> SHIELD_ITEM = new ArrayList<>();

    public KamenRiderCraftCore(ModContainer modContainer, IEventBus modEventBus, Dist dist) {
        KRCAttributes.REGISTRY.register(modEventBus);
        AttachmentTypes.REGISTRY.register(modEventBus);

        NeoForge.EVENT_BUS.register(new ModClientEvents.ClientEvents());
        NeoForge.EVENT_BUS.register(new ModCommonEvents.CommonEvents());
        NeoForge.EVENT_BUS.register(this);

        ModSounds.register(modEventBus);
        ModMusic.register(modEventBus);

        RiderPotPattern.register(modEventBus);
        ModdedItemCore.register(modEventBus);
        TheSeriesRiderItems.register(modEventBus);
        ShinIchigoRiderItems.register(modEventBus);
        AmazonsRiderItems.register(modEventBus);
        BlackSunRiderItems.register(modEventBus);
        IchigoRiderItems.register(modEventBus);
        V3RiderItems.register(modEventBus);
        XRiderItems.register(modEventBus);
        AmazonRiderItems.register(modEventBus);
        StrongerRiderItems.register(modEventBus);
        SkyriderItems.register(modEventBus);
        Super1RiderItems.register(modEventBus);
        ZXRiderItems.register(modEventBus);
        BlackRiderItems.register(modEventBus);
        BlackRXRiderItems.register(modEventBus);
        ShinRiderItems.register(modEventBus);
        ZORiderItems.register(modEventBus);
        JRiderItems.register(modEventBus);
        KuugaRiderItems.register(modEventBus);
        AgitoRiderItems.register(modEventBus);
        RyukiRiderItems.register(modEventBus);
        FaizRiderItems.register(modEventBus);
        BladeRiderItems.register(modEventBus);
        HibikiRiderItems.register(modEventBus);
        KabutoRiderItems.register(modEventBus);
        DenORiderItems.register(modEventBus);
        KivaRiderItems.register(modEventBus);
        DecadeRiderItems.register(modEventBus);
        WRiderItems.register(modEventBus);
        OOORiderItems.register(modEventBus);
        FourzeRiderItems.register(modEventBus);
        WizardRiderItems.register(modEventBus);
        GaimRiderItems.register(modEventBus);
        DriveRiderItems.register(modEventBus);
        GhostRiderItems.register(modEventBus);
        ExAidRiderItems.register(modEventBus);
        BuildRiderItems.register(modEventBus);
        ZiORiderItems.register(modEventBus);
        ZeroOneRiderItems.register(modEventBus);
        SaberRiderItems.register(modEventBus);
        ReviceRiderItems.register(modEventBus);
        GeatsRiderItems.register(modEventBus);
        GotchardRiderItems.register(modEventBus);
        GavvRiderItems.register(modEventBus);
        ZeztzRiderItems.register(modEventBus);
        MyThRiderItems.register(modEventBus);
        CrossSeriesRiderItems.register(modEventBus);
        ExtraRiderItems.register(modEventBus);
        GoriderItems.register(modEventBus);
        GRiderItems.register(modEventBus);
        RideKamensItems.register(modEventBus);
        KRCCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        MusicDiscItems.ITEMS.register(modEventBus);
        RiderBlocks.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        MobsCore.register(modEventBus);
        MobsCore.MOBLIST.register(modEventBus);

        EffectCore.register(modEventBus);

        ModMenus.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        RiderVillagers.register(modEventBus);
        ModParticles.register(modEventBus);
        ModGameRules.register(modEventBus);
        ModRecipes.register(modEventBus);

        LootModifierCore.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(ModCommonEvents::registerLayers);
        modEventBus.addListener(ModCommonEvents::entityAttributeEvent);
        modEventBus.addListener(ModCommonEvents::entitySpawnRestriction);

        if (dist == Dist.CLIENT) {
            KamenRiderCraftCoreClient.clientInit(modEventBus);
        }

        modContainer.registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        KRCCreativeTabs.addItemsToTabs(event);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) throws NoSuchFieldException {
        AddStructuresToPools.addModStructures(event.getServer());
        NeoForge.EVENT_BUS.register(new ModServerEvents.ServerEvents());
    }

    @SubscribeEvent
    public void addRenderLivingEvent(RenderLivingEvent.Pre<?, ?> event) {
        if (event.getRenderer().getModel() instanceof PlayerModel<?> model) {
            if (event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt && belt.isTransformed(event.getEntity())) {
                Double tf = belt.getHenshinTick(event.getEntity().getItemBySlot(EquipmentSlot.FEET),event.getEntity());
                double tag = belt.getRenderType(event.getEntity().getItemBySlot(EquipmentSlot.FEET),tf);
                if (tag != 0) {
                    model.setAllVisible(false);
                    if (tag != 1) {
                        model.head.visible = true;
                    } else if (event.getEntity() instanceof BaseHenchmenEntity||event.getEntity() instanceof BaseSummonEntity) {
                        model.head.visible = false;
                    }
                    if (tag == 3) {
                        model.leftLeg.visible = true;
                        model.rightLeg.visible = true;
                        model.leftArm.visible = true;
                        model.rightArm.visible = true;
                        model.body.visible = true;
                    } else if (event.getEntity() instanceof BaseHenchmenEntity||event.getEntity() instanceof BaseSummonEntity) {
                        model.leftLeg.visible = false;
                        model.rightLeg.visible = false;
                        model.leftArm.visible = false;
                        model.rightArm.visible = false;
                        model.body.visible = false;
                    }
                } else {
                    model.setAllVisible(true);
                }
            } else if (!event.getEntity().getItemBySlot(EquipmentSlot.FEET).toString().contains("supersentaicraft")&&
            !event.getEntity().getItemBySlot(EquipmentSlot.FEET).toString().contains("powerrangerscraft")&&
                    !event.getEntity().getItemBySlot(EquipmentSlot.FEET).toString().contains("ultracraft")&&
                    !event.getEntity().getItemBySlot(EquipmentSlot.FEET).toString().contains("tmntcraft")) {
                model.setAllVisible(true);
            }
        }

        if (event.getRenderer().getModel() instanceof HeadedModel model) {
            float sd = (float) Objects.requireNonNull(event.getEntity().getAttribute(KRCAttributes.HEAD_SIZE)).getValue();
            model.getHead().xScale = sd;
            model.getHead().yScale  = sd;
            model.getHead().zScale  = sd;
        }

        float sizeX = (float) Objects.requireNonNull(event.getEntity().getAttribute(KRCAttributes.PLAYER_SIZE_X)).getValue();
        float sizeY = (float) Objects.requireNonNull(event.getEntity().getAttribute(KRCAttributes.PLAYER_SIZE_Y)).getValue();
        float sizeZ = (float) Objects.requireNonNull(event.getEntity().getAttribute(KRCAttributes.PLAYER_SIZE_Z)).getValue();
        event.getPoseStack().scale(sizeX, sizeY, sizeZ);
    }

    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void RegisterDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent event) {
            event.register(CustomDimensionEffect.MOON_EFFECTS, new CustomDimensionEffect.MoonEffects());
        }

        @SubscribeEvent
        public static void registerOverlays(RegisterGuiLayersEvent event) {
            event.registerAbove(VanillaGuiLayers.AIR_LEVEL, ResourceLocation.fromNamespaceAndPath(MOD_ID, "ability_hud"), AbilityHudOverlay.instance);
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(RegisterItemProperties::addCustomItemProperties);
            event.enqueueWork(KamenRiderCraftCoreClient::registerPlayerAnimations);

        }

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.PANDORA_PANEL_BE.get(), PandoraPanelBlockEntityRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.PLINTH_BE.get(), PlinthBlockEntityRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.GOCHIZO_JAR_BE.get(), GochizoJarBlockEntityRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.MIND_DOOR_BE.get(), MindDoorRenderer::new);

        }

        @SubscribeEvent
        public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {

            event.registerEntityRenderer(MobsCore.SHOCKER_COMBATMAN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SHOCKER_RIDER.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.DESTRON_COMBATMAN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GOD_WARFARE_AGENT.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.APOLLOGEIST.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.RED_FOLLWER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.BLACK_SATAN_SOLDIER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GENERAL_SHADOW.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ARI_COMMANDO.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DOGMA_FIGHTER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.COMBAT_ROID.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CHAP.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CHAP_GREY.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SHADOWMOON.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.ZU_GUMUN_BA.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GO_CLASS_GRONGI.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.N_DAGUVA_ZEBA.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.PANTHERAS_LUTEUS.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.EL_OF_THE_WATER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ANGUIS_MASCULUS.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ANOTHER_AGITO.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.MIRROR_RIDER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ODIN.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.RIOTROOPER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ORGA.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MUEZ.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.FAIZ.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.AUTO_VAJIN_ROBO.get(), AutoVajinRenderer::new);

            event.registerEntityRenderer(MobsCore.UNDEAD.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ACE_UNDEAD.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.JACK_UNDEAD.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.QUEEN_UNDEAD.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.KING_UNDEAD.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.JOKER_UNDEAD.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ALBINO_JOKER_UNDEAD.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.BAKENEKO.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MIDAREDOUJI.get(), MidaredoujiRenderer::new);
            event.registerEntityRenderer(MobsCore.MAKAMOU_NINJA_GROUP.get(), MakamouNinjaGroupRenderer::new);
            event.registerEntityRenderer(MobsCore.KABUKI.get(), BasicEntityRenderer::new);

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

            event.registerEntityRenderer(MobsCore.ARC.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GARULU.get(), AllyEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.BASSHAA.get(), AllyEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DOGGA.get(), DoggaRenderer::new);
            event.registerEntityRenderer(MobsCore.MOOSE_FANGIRE.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.DECADE_VIOLENT.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.MASQUERADE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.WEATHER_DOPANT.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CLAYDOLL_DOPANT.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.TERROR_DOPANT.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.NASCA_DOPANT.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.TABOO_DOPANT.get(), TabooRenderer::new);
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
            event.registerEntityRenderer(MobsCore.KYORYU_GREEED.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SHOCKER_GREEED.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.POSEIDON.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CORE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.POWERED_UP_CORE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ANCIENT_OOO.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GODA.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.TAKA_CAN.get(), TakaCanRenderer::new);
            event.registerEntityRenderer(MobsCore.TAKO_CAN.get(), TakoCanRenderer::new);
            event.registerEntityRenderer(MobsCore.BATTA_CAN.get(), BattaCanRenderer::new);
            event.registerEntityRenderer(MobsCore.TORA_CAN.get(), ToraCanRenderer::new);
            event.registerEntityRenderer(MobsCore.DENKIUNAGI_CAN.get(), DenkiunagiCanRenderer::new);
            event.registerEntityRenderer(MobsCore.GORILLA_CAN.get(), GorillaCanRenderer::new);
            event.registerEntityRenderer(MobsCore.KUJAKU_CAN.get(), KujakuCanRenderer::new);
            event.registerEntityRenderer(MobsCore.PTERA_CAN.get(), PteraCanRenderer::new);
            event.registerEntityRenderer(MobsCore.TORIKERA_CAN.get(), TorikeraCanRenderer::new);

            event.registerEntityRenderer(MobsCore.SUPER_GINGAOH.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.GHOULS.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MEDUSA_PHANTOM.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.PHOENIX_PHANTOM.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GREMLIN_PHANTOM.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MAGE_FOOTSOLDIER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MAGE_CAPTAIN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SORCERER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.WISEMAN.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.ELEMENTARY_INVES_RED.get(), ElementaryInvesRenderer::new);
            event.registerEntityRenderer(MobsCore.KUROKAGE_TROOPER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ZANGETSU_SHIN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MARIKA.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DUKE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SIGURD.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ROSYUO.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.REDYUE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DEMUSHU.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.LORD_BARON.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MEGAHEX.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.ROIDMUDE.get(), RoidmudeRenderer::new);
            event.registerEntityRenderer(MobsCore.REAPER_LEGION.get(), ReaperRenderer::new);
            event.registerEntityRenderer(MobsCore.MASHIN_CHASER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.HEART_ROIDMUDE.get(), HeartRoidmudeRenderer::new);
            event.registerEntityRenderer(MobsCore.BRAIN_ROIDMUDE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MEDIC_ROIDMUDE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GORD_DRIVE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DARK_DRIVE.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.GAMMA_COMMANDO.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.IGOR.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.NECROM.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DARK_NECROM.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DARK_GHOST.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.BUGSTERVIRUS.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.NEBULA_BUGSTERVIRUS.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.GRAPHITE_BUGSTER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GENM.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.POPPY_RED.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.RIDEPLAYER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.PARADX.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CRONUS.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.TOUTOGUARDIAN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.HOKUTOGUARDIAN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SEITOGUARDIAN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.HARD_GUARDIAN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SMASH.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DOWNFALL_GUARDIAN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.PHANTOM_CRUSHER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.NIGHT_ROGUE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.BLOOD_STALK.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GREASE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.BUILD.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.EVOL.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.KILLBUS.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.STAG_LOST_SMASH.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.OWL_LOST_SMASH.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CASTLE_LOST_SMASH.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ENGINE_BROS.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.REMOCON_BROS.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MAD_ROGUE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.KAISER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.KAISER_REVERSE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.BIKAISER.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.KASSHINE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ANOTHER_ZI_O.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ANOTHER_DEN_O.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GINGA.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.WOZ.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.YAMININ.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.BARLCKXS.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ZONJIS.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ZAMONAS.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.TAKA_WATCHROID.get(), TakaWatchroidRenderer::new);
            event.registerEntityRenderer(MobsCore.KODAMA_SUIKA_ARMS.get(), KodamaSuikaArmsRenderer::new);

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
            event.registerEntityRenderer(MobsCore.ZEIN.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.SHIMI.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CALIBUR.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.FALCHION.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SABELA.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DURENDAL.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SOLOMON.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.STORIOUS_RIDER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.LEGEIEL.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.LEGEIEL_FORBIDDEN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ZOOOUS.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ZOOOUS_PREDATOR.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.STORIOUS.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DESAST.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CHARYBDIS.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CHARYBDIS_HERCULES.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.GIFF_JUNIOR.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.EVIL.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DAIOUIKA_DEADMAN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ANOMALOCARIS_DEADMAN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.QUEEN_BEE_DEADMAN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.WOLF_DEADMAN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CRIMSON_VAIL.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.PAWN_JYAMATO.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.JYAMATO_RIDER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GM_RIDER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GLARE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GLARE2.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GAZER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.END_RIDER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.PREMIUM_BEROBA.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.PREMIUM_KEKERA.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.MALGAM.get(), MalgamRenderer::new);
            event.registerEntityRenderer(MobsCore.DREAD.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GOLEM.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GIGIST.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GERMAIN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GAELIJAH.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ELD.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DREATROOPER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DREATROOPER_COMMANDER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DORADO.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.AGENT.get(), AgentRenderer::new);
            event.registerEntityRenderer(MobsCore.BITTER_GAVV.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.NYELV_STOMACH.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GLOTTA_STOMACH.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.JEEB_STOMACH.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SHIITA_STOMACH.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.LANGO_STOMACH.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.BOCCA_JALDAK.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CARIES.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.BABY_NIGHTMARE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.NIGHTMARE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SHADOW_NIGHTMARE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.NOX.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DAWN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.LORD_THREE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ZEZTZ_DARKNESS_NIGHTMARE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.PHANTOM_GORE_NIGHTMARE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CATASTROPHE_GORE_NIGHTMARE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.OBLIVION_GORE_NIGHTMARE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CODE_ZERO.get(), AllyEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.BATTA_AUGMENT.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SHIN_NO_0.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.BICYCLE.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.ACROBATTER.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.RIDORON.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.MACEHINE_TORADOR.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.AUTO_VAJIN.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.MACEHINE_DENBIRD.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.HARDBOILER.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.SKULLBOILER.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.ACCEL_BIKE_FORM.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.RIDEVENDOR_VENDING_MODE.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.RIDEVENDOR.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.TORIDEVENDOR.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.MACEHINE_MASSIGLER.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.SAKURA_HURRICANE.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.ROSE_ATTACKER.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.MACHINE_HOODIE.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.BIKE_GAMER.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.SPORTS_GAMER.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.PROTO_SPORTS_GAMER.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.MACEHINE_BUILDER.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.RIDESTRIKER.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.RISEHOPPER.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.DIAGOSPEEDY.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.VICE_BIKE.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.BOOSTRIKER.get(), BoostrikerRenderer::new);
            event.registerEntityRenderer(MobsCore.BOOSTRIKER_GEATS_MODE.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.BOOSTRIKER_TYCOON_MODE.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.BOOSTRIKER_NA_GO_MODE.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.BOOSTRIKER_BUFFA_MODE.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.CODE_ZEROIDER.get(), BikeRenderer::new);

            event.registerEntityRenderer(MobsCore.RIDER_SUMMON.get(), SummonedEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.COMPLETE_SUMMON.get(), SummonedEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GRAND_SUMMON.get(), SummonedEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.LEGENDARY_SUMMON.get(), SummonedEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ZEIN_SUMMON.get(), SummonedEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ENEMY_SUMMON.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ZEIN_ENEMY_SUMMON.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.PARADX_SUMMON.get(), SummonedEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DECADE_ARMOR_EX_AID.get(), SummonedEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.VICE.get(), SummonedEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.LOVEKOV.get(), SummonedEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.WHIPPED_SOLDIER.get(), WhippedSoldierRenderer::new);
            event.registerEntityRenderer(MobsCore.APOLLO.get(), ApolloRenderer::new);
            event.registerEntityRenderer(MobsCore.LIBRA.get(), LibraRenderer::new);
            event.registerEntityRenderer(MobsCore.TOJIMA_TAKOYAKI.get(), AllyEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.CHAIR_ENTITY.get(), ChairRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);

            event.registerEntityRenderer(MobsCore.WEAPON_PROJECTILE.get(), ThrownWeaponRenderer::new);
            event.registerEntityRenderer(MobsCore.SHURIKEN_PROJECTILE.get(), ThrownShurikenRenderer::new);
            event.registerEntityRenderer(MobsCore.ROUZE_CARD.get(), RouzeCardRenderer::new);
            event.registerEntityRenderer(MobsCore.BASE_PROJECTILE.get(), BaseProjectileRenderer::new);

            event.registerEntityRenderer(MobsCore.BASE_EFFECT.get(), BaseEffectRenderer::new);
            event.registerEntityRenderer(MobsCore.SEALING_EFFECT.get(), SealingRenderer::new);

        }

        @SubscribeEvent
        public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(ModParticles.WHITE_SPARK_PARTICLES.get(), WhiteSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.GREY_SPARK_PARTICLES.get(), GreySparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.RED_SPARK_PARTICLES.get(), RedSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.DARK_RED_SPARK_PARTICLES.get(), DarkRedSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.ORANGE_SPARK_PARTICLES.get(), OrangeSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.BLUE_SPARK_PARTICLES.get(), BlueSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(), DarkBlueSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.CYAN_SPARK_PARTICLES.get(), CyanSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.GREEN_SPARK_PARTICLES.get(), GreenSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.BROWN_SPARK_PARTICLES.get(), BrownSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(), DarkGreenSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.PURPLE_SPARK_PARTICLES.get(), PurpleSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.PINK_SPARK_PARTICLES.get(), PinkSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.YELLOW_SPARK_PARTICLES.get(), YellowSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.GOLD_SPARK_PARTICLES.get(), GoldSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.BLACK_SPARK_PARTICLES.get(), BlackSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.RANDOM_SPARK_PARTICLES.get(), RandomSparkParticles.Provider::new);

            event.registerSpriteSet(ModParticles.ELECTRIC_SPARK_PARTICLES.get(), ElectricSparkParticles.Provider::new);


            event.registerSpriteSet(ModParticles.GLASS_PARTICLES.get(), GlassParticles.Provider::new);
            event.registerSpriteSet(ModParticles.CHAIN_PARTICLES.get(), ChainParticles.Provider::new);
            event.registerSpriteSet(ModParticles.GOLD_BAT_PARTICLES.get(), GoldBatParticles.Provider::new);

            event.registerSpriteSet(ModParticles.RED_WIZARD_PARTICLES.get(), WizardParticles.Provider::new);
            event.registerSpriteSet(ModParticles.BLUE_WIZARD_PARTICLES.get(), BlueWizardParticles.Provider::new);
            event.registerSpriteSet(ModParticles.GREEN_WIZARD_PARTICLES.get(), GreenWizardParticles.Provider::new);
            event.registerSpriteSet(ModParticles.YELLOW_WIZARD_PARTICLES.get(), YellowWizardParticles.Provider::new);
            event.registerSpriteSet(ModParticles.WHITE_WIZARD_PARTICLES.get(), WhiteWizardParticles.Provider::new);
            event.registerSpriteSet(ModParticles.ORANGE_WIZARD_PARTICLES.get(), OrangeWizardParticles.Provider::new);
            event.registerSpriteSet(ModParticles.BLACK_WIZARD_PARTICLES.get(), BlackWizardParticles.Provider::new);
            event.registerSpriteSet(ModParticles.PURPLE_WIZARD_PARTICLES.get(), PurpleWizardParticles.Provider::new);
            event.registerSpriteSet(ModParticles.GOLD_WIZARD_PARTICLES.get(), GoldWizardParticles.Provider::new);

            event.registerSpriteSet(ModParticles.BEAST_PARTICLES.get(), GoldWizardParticles.Provider::new);
            event.registerSpriteSet(ModParticles.RED_BEAST_PARTICLES.get(), WizardParticles.Provider::new);
            event.registerSpriteSet(ModParticles.GREEN_BEAST_PARTICLES.get(), GreenWizardParticles.Provider::new);
            event.registerSpriteSet(ModParticles.ORANGE_BEAST_PARTICLES.get(), OrangeWizardParticles.Provider::new);
            event.registerSpriteSet(ModParticles.PURPLE_BEAST_PARTICLES.get(), PurpleWizardParticles.Provider::new);

            event.registerSpriteSet(ModParticles.HIT_PARTICLES.get(), HitParticles.Provider::new);
            event.registerSpriteSet(ModParticles.MISS_PARTICLES.get(), MissParticles.Provider::new);
            event.registerSpriteSet(ModParticles.GUMMI_PARTICLES.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.GUMMI_PARTICLES2.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.GUMMI_PARTICLES3.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.SNACK_PARTICLES.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.MARSHMALLOW_PARTICLES.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.CHOCO_PARTICLES.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.CANDY_PARTICLES.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.CANDY_PARTICLES2.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.CANDY_PARTICLES3.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.CANDY_PARTICLES4.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.PUDDING_PARTICLES.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.BUTTERFLY_PARTICLES.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.MY_TH_GEM_PARTICLES.get(), My_ThGemParticles.Provider::new);
            event.registerSpriteSet(ModParticles.MY_TH_GEM_TURTLE_PARTICLES.get(), My_ThGemTurtleParticles.Provider::new);
            event.registerSpriteSet(ModParticles.REALIZING_PARTICLES.get(), RealizingParticles.Provider::new);

        }

        @SubscribeEvent
        public static void registerKeys(RegisterKeyMappingsEvent event) {
            event.register(KeyBindings.INSTANCE.BeltKey);
            event.register(KeyBindings.INSTANCE.AbilityKeyOne);
            event.register(KeyBindings.INSTANCE.AbilityKeyTwo);
            event.register(KeyBindings.INSTANCE.PoseKey);
        }


        @SubscribeEvent
        public static void menuScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenus.RIDER_CASE_GUI.get(), RiderCaseGuiScreen::new);
            event.register(ModMenus.ADVENT_DECK_GUI.get(), AdventDeckGuiScreen::new);
            event.register(ModMenus.FUESLOT_GUI.get(), FueslotGuiScreen::new);
            event.register(ModMenus.RIDE_BOOKER_GUI.get(), RideBookerGuiScreen::new);
            event.register(ModMenus.DIENDRIVER_GUI.get(), DiendriverGuiScreen::new);
            event.register(ModMenus.NEO_DIENDRIVER_GUI.get(), NeoDiendriverGuiScreen::new);
            event.register(ModMenus.T2_MEMORY_CASE_GUI.get(), T2MemoryCaseGuiScreen::new);
            event.register(ModMenus.O_MEDAL_HOLDER_GUI.get(), OMedalHolderGuiScreen::new);
            event.register(ModMenus.O_MEDAL_NEST_GUI.get(), OMedalNestGuiScreen::new);
            event.register(ModMenus.ASTROSWITCH_CASE_GUI.get(), AstroswitchCaseGuiScreen::new);
            event.register(ModMenus.RING_HOLDER_GUI.get(), RingHolderGuiScreen::new);
            event.register(ModMenus.RING_HOLDER_GUI_BEAST.get(), RingHolderGuiScreenBeast::new);
            event.register(ModMenus.LOCKSEED_HOLDER_GUI.get(), LockseedHolderGuiScreen::new);
            event.register(ModMenus.SHIFT_CAR_HOLDER_GUI.get(), ShiftCarHolderGuiScreen::new);
            event.register(ModMenus.RIDER_GASHAT_CASE_GUI.get(), RiderGashatCaseGuiScreen::new);
            event.register(ModMenus.ENERGY_ITEM_HOLDER_GUI.get(), EnergyItemHolderGuiScreen::new);
            event.register(ModMenus.FULL_BOTTLE_HOLDER_GUI.get(), FullBottleHolderGuiScreen::new);
            event.register(ModMenus.PANDORA_PANEL_GUI.get(), PandoraPanelGuiScreen::new);
            event.register(ModMenus.RIDEWATCH_HOLDER_GUI.get(), RidewatchHolderGuiScreen::new);
            event.register(ModMenus.MIRIDEWATCH_HOLDER_GUI.get(), MiridewatchHolderGuiScreen::new);
            event.register(ModMenus.PROGRISE_HOLDER_GUI.get(), ProgriseHolderGuiScreen::new);
            event.register(ModMenus.HISSATSU_HOLDER_GUI.get(), HissatsuHolderGuiScreen::new);
            event.register(ModMenus.ROYAL_SWORD_OF_LOGOS_HOLDER_GUI.get(), RoyalSwordOfLogosHolderGuiScreen::new);
            event.register(ModMenus.VISTAMP_HOLDER_GUI.get(), VistampHolderGuiScreen::new);
            event.register(ModMenus.RAISE_BUCKLE_HOLDER_GUI.get(), RaiseBuckleHolderGuiScreen::new);
            event.register(ModMenus.GOTCHANDRAW_HOLDER_GUI.get(), GotchandrawHolderGuiScreen::new);
            event.register(ModMenus.GOTCHANCOLLECTION_PANEL_GUI.get(), GotchancollectionPanelGuiScreen::new);
            event.register(ModMenus.CHEMY_RISER_GUI.get(), ChemyRiserGuiScreen::new);
            event.register(ModMenus.LEGEND_RIDE_MAGNUM_GUI.get(), LegendRideMagnumGuiScreen::new);
            event.register(ModMenus.CAPSEM_CYLINDER_GUI.get(), CapsemCylinderGuiScreen::new);
            event.register(ModMenus.IXA_MACHINE_BLOCK_GUI.get(), IxaMachineBlockGuiScreen::new);
            // event.register(ModMenus.ASTROSWITCH_RACK_GUI.get(), AstroswitchRackGuiScreen::new);
        }
    }


    @EventBusSubscriber(modid = MOD_ID)
    public static class CommonModEvents {
        @SubscribeEvent
        public static void register(final RegisterPayloadHandlersEvent event) {
            PayloadRegistrar registrar = event.registrar("kamenridercraft");
            registrar = registrar.executesOn(HandlerThread.MAIN);

            registrar.playBidirectional(CompleteSwingPayload.TYPE,
            CompleteSwingPayload.STREAM_CODEC,
            new DirectionalPayloadHandler<>(ClientPayloadHandler::handleCompleteSwing, ServerPayloadHandler::handleCompleteSwing));

            registrar.commonToClient(EndAnimationPayload.TYPE,
            EndAnimationPayload.STREAM_CODEC,
            ClientPayloadHandler::endAnimations);

            registrar.commonToClient(StartPosePayload.TYPE,
            StartPosePayload.STREAM_CODEC,
            ClientPayloadHandler::startPoseAnimations);

            registrar.commonToClient(AnimPayload.TYPE,
            AnimPayload.STREAM_CODEC,
            ClientPayloadHandler::startAnim);

            registrar.playToServer(BeltKeyPayload.TYPE,
            BeltKeyPayload.STREAM_CODEC,
            ServerPayloadHandler::handleBeltKeyPress);

            registrar.playToClient(AttributeChangeClientPayload.TYPE,
            AttributeChangeClientPayload.STREAM_CODEC,
            ClientPayloadHandler::handleAttributeClientChange);

            registrar.playToServer(AttributeChangePayload.TYPE,
            AttributeChangePayload.STREAM_CODEC,
            ServerPayloadHandler::handleAttributeChange);

            registrar.playToServer(ClimbCollisionPayload.TYPE,
            ClimbCollisionPayload.STREAM_CODEC,
            ServerPayloadHandler::handleClimbing);

            registrar.playToServer(AbilityKeyPayload.TYPE,
            AbilityKeyPayload.STREAM_CODEC,
            ServerPayloadHandler::handleAbilityKeyPress);

            registrar.playToServer(PoseKeyPayload.TYPE,
            PoseKeyPayload.STREAM_CODEC,
            ServerPayloadHandler::handlePoseKeyPress);

            registrar.playToServer(BikeMovePayload.TYPE,
            BikeMovePayload.STREAM_CODEC,
            ServerPayloadHandler::handleBikeMove);
        }
    }
}