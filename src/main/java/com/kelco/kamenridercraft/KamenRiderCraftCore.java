// TODO: Re-balancing for all Riders
package com.kelco.kamenridercraft;

import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.block.entity.ModBlockEntities;
import com.kelco.kamenridercraft.block.entity.renderer.GochizoJarBlockEntityRenderer;
import com.kelco.kamenridercraft.block.entity.renderer.PandoraPanelBlockEntityRenderer;
import com.kelco.kamenridercraft.block.entity.renderer.PlinthBlockEntityRenderer;
import com.kelco.kamenridercraft.client.KeyBindings;
import com.kelco.kamenridercraft.client.gui.*;
import com.kelco.kamenridercraft.client.renderer.*;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.entity.mobs.villager.RiderVillagers;
import com.kelco.kamenridercraft.events.ModClientEvents;
import com.kelco.kamenridercraft.events.ModCommonEvents;
import com.kelco.kamenridercraft.events.ModServerEvents;
import com.kelco.kamenridercraft.init.ModMenus;
import com.kelco.kamenridercraft.init.RiderPotPattern;
import com.kelco.kamenridercraft.item.Modded_item_core;
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
import com.kelco.kamenridercraft.sounds.ModSounds;
import com.kelco.kamenridercraft.util.RegisterItemProperties;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes;
import com.kelco.kamenridercraft.world.level.CustomDimensionEffect;
import com.kelco.kamenridercraft.world.level.levelgen.feature.ModConfiguredFeatures;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.core.component.DataComponents;
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


@Mod(KamenRiderCraftCore.MOD_ID)
public class KamenRiderCraftCore {
    public static final String MOD_ID = "kamenridercraft";

    public static final int NEW_STRUCTURE_SIZE = 512;

    public static List<Item> CHANGE_SWORD_ITEM = new ArrayList<>();
    public static List<Item> SWORD_GUN_ITEM = new ArrayList<>();
    public static List<Item> KUUGA_CHANGING_ITEM = new ArrayList<>();
    public static List<Item> SHIELD_ITEM = new ArrayList<>();

    public KamenRiderCraftCore(IEventBus modEventBus, ModContainer modContainer) {

        // Register the commonSetup method for modloading
        //modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(new ModClientEvents.ClientEvents());
        NeoForge.EVENT_BUS.register(new ModCommonEvents.CommonEvents());

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);
        AttachmentTypes.register(modEventBus);
        EffectCore.register(modEventBus);
        ModMenus.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModSounds.register(modEventBus);
        RiderPotPattern.register(modEventBus);
        Modded_item_core.register(modEventBus);
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
        Fourze_Rider_Items.register(modEventBus);
        Wizard_Rider_Items.register(modEventBus);
        Gaim_Rider_Items.register(modEventBus);
        Drive_Rider_Items.register(modEventBus);
        Ghost_Rider_Items.register(modEventBus);
        Ex_Aid_Rider_Items.register(modEventBus);
        Build_Rider_Items.register(modEventBus);
        Zi_O_Rider_Items.register(modEventBus);
        Zero_One_Rider_Items.register(modEventBus);
        Saber_Rider_Items.register(modEventBus);
        Revice_Rider_Items.register(modEventBus);
        Geats_Rider_Items.register(modEventBus);
        Gotchard_Rider_Items.register(modEventBus);
        Gavv_Rider_Items.register(modEventBus);
        Zeztz_Rider_Items.register(modEventBus);
        CrossSeriesRiderItems.register(modEventBus);
        ExtraRiderItems.register(modEventBus);
        GoriderItems.register(modEventBus);
        GRiderItems.register(modEventBus);
        RideKamensItems.register(modEventBus);
        MusicDiscItems.register(modEventBus);
        Rider_Blocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        MobsCore.register(modEventBus);
        MobsCore.MOBLIST.register(modEventBus);
        Attributes.ATTRIBUTES.register(modEventBus);
        CreativeTabRegistry.register(modEventBus);
        RiderVillagers.register(modEventBus);
        ModParticles.register(modEventBus);
        ModGameRules.register(modEventBus);
        /*ModBlockEntities.REGISTRY.register(modEventBus);*/
        ModRecipes.register(modEventBus);

        LootModifierCore.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(ModCommonEvents::registerLayers);
        modEventBus.addListener(ModCommonEvents::entityAttributeEvent);
        modEventBus.addListener(ModCommonEvents::entitySpawnRestriction);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC);
    }

    //private void commonSetup(final FMLCommonSetupEvent event) {
    //}

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        CreativeTabRegistry.AddItemsToTabs(event);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) throws NoSuchFieldException {
        AddStructuresToPools.addModStructures(event.getServer());
        NeoForge.EVENT_BUS.register(new ModServerEvents.ServerEvents());
    }

    @SubscribeEvent
    public void addRenderLivingEvent(RenderLivingEvent.Pre<?, ?> event) {

        if (event.getRenderer().getModel() instanceof HeadedModel model) {
            float sd = (float) event.getEntity().getAttribute(Attributes.HEAD_SIZE).getValue();
            model.getHead().xScale = sd;
            model.getHead().yScale = sd;
            model.getHead().zScale = sd;
        }

        if (event.getRenderer().getModel() instanceof PlayerModel<?> model) {
            if (event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem
                    && event.getEntity().getItemBySlot(EquipmentSlot.FEET).has(DataComponents.CUSTOM_DATA)) {
                double tag = event.getEntity().getItemBySlot(EquipmentSlot.FEET).get(DataComponents.CUSTOM_DATA).copyTag().getDouble("render_type");
                if (tag != 0) {
                    model.setAllVisible(false);
                    if (tag != 1) model.head.visible = true;
                    else if (event.getEntity() instanceof BaseHenchmenEntity) model.head.visible = false;
                    if (tag == 3) {
                        model.leftLeg.visible = true;
                        model.rightLeg.visible = true;
                        model.leftArm.visible = true;
                        model.rightArm.visible = true;
                        model.body.visible = true;
                    } else if (event.getEntity() instanceof BaseHenchmenEntity) {
                        model.leftLeg.visible = false;
                        model.rightLeg.visible = false;
                        model.leftArm.visible = false;
                        model.rightArm.visible = false;
                        model.body.visible = false;
                    }
                } else if (event.getEntity() instanceof BaseHenchmenEntity) model.setAllVisible(true);
            } else if (event.getEntity() instanceof BaseHenchmenEntity) model.setAllVisible(true);
        }

        float sizeX = (float) event.getEntity().getAttribute(Attributes.PLAYER_SIZE_X).getValue();
        float sizeY = (float) event.getEntity().getAttribute(Attributes.PLAYER_SIZE_Y).getValue();
        float sizeZ = (float) event.getEntity().getAttribute(Attributes.PLAYER_SIZE_Z).getValue();
        event.getPoseStack().scale(sizeX, sizeY, sizeZ);
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void RegisterDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent event) {
            event.register(CustomDimensionEffect.MOON_EFFECTS, new CustomDimensionEffect.MoonEffects());
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
        }

        @SubscribeEvent
        public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {

            event.registerEntityRenderer(MobsCore.SHOCKER_COMBATMAN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SHOCKER_RIDER.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.DESTRON_COMBATMAN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GOD_WARFARE_AGENT.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.APOLLOGIST.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.RED_FOLLWER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.BLACK_SATAN_SOLDIER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ARI_COMMANDO.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DOGMA_FIGHTER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.COMBAT_ROID.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CHAP.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.CHAP_GREY.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SHADOWMOON.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.ZU_GUMUN_BA.get(), BasicEntityRenderer::new);
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

            event.registerEntityRenderer(MobsCore.NOX.get(), BasicEntityRenderer::new);

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
            event.registerEntityRenderer(MobsCore.LASER_PROJECTILE.get(), LaserProjectileRenderer::new);
            event.registerEntityRenderer(MobsCore.CELL_MEDAL_PROJECTILE.get(), CellMedalProjectileRenderer::new);
            event.registerEntityRenderer(MobsCore.ROCKET_PROJECTILE.get(), RocketProjectileRenderer::new);
            event.registerEntityRenderer(MobsCore.BASE_PROJECTILE.get(), BaseProjectileRenderer::new);


        }

        @SubscribeEvent
        public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(ModParticles.WHITE_SPARK_PARTICLES.get(), WhiteSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.GREY_SPARK_PARTICLES.get(), GreySparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.RED_SPARK_PARTICLES.get(), Red2SparkParticles.Provider::new);
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
            event.registerSpriteSet(ModParticles.REALIZING_PARTICLES.get(), realizingParticles.Provider::new);

        }

        @SubscribeEvent
        public static void registerKeys(RegisterKeyMappingsEvent event) {
            event.register(KeyBindings.INSTANCE.BeltKey);
            event.register(KeyBindings.INSTANCE.AbilityKey);
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

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class CommonModEvents {
        @SubscribeEvent
        public static void register(final RegisterPayloadHandlersEvent event) {
            PayloadRegistrar registrar = event.registrar("kamenridercraft");
            registrar = registrar.executesOn(HandlerThread.MAIN);
            registrar.playBidirectional(
                    CompleteSwingPayload.TYPE,
                    CompleteSwingPayload.STREAM_CODEC,
                    new DirectionalPayloadHandler<>(
                            ClientPayloadHandler::handleCompleteSwing,
                            ServerPayloadHandler::handleCompleteSwing
                    )
            );

            registrar.playToClient(
                    EndPosePayload.TYPE,
                    EndPosePayload.STREAM_CODEC,
                    ClientPayloadHandler::endPoseAnimations
            );

            registrar.playToClient(
                    StartPosePayload.TYPE,
                    StartPosePayload.STREAM_CODEC,
                    ClientPayloadHandler::startPoseAnimations
            );

            registrar.playToClient(
                    StartKickPayload.TYPE,
                    StartKickPayload.STREAM_CODEC,
                    ClientPayloadHandler::startKickAnimation
            );

            registrar.playToServer(
                    BeltKeyPayload.TYPE,
                    BeltKeyPayload.STREAM_CODEC,
                    ServerPayloadHandler::handleBeltKeyPress
            );

            registrar.playToClient(
                    AttributeChangeClientPayload.TYPE,
                    AttributeChangeClientPayload.STREAM_CODEC,
                    ClientPayloadHandler::handleAttributeCLientChange
            );

            registrar.playToServer(
                    AttributeChangePayload.TYPE,
                    AttributeChangePayload.STREAM_CODEC,
                    ServerPayloadHandler::handleAttributeChange
            );

            registrar.playToServer(
                    ClimbCollisionPayload.TYPE,
                    ClimbCollisionPayload.STREAM_CODEC,
                    ServerPayloadHandler::handleClimbing
            );

            registrar.playToServer(
                    AbilityKeyPayload.TYPE,
                    AbilityKeyPayload.STREAM_CODEC,
                    ServerPayloadHandler::handleAbilityKeyPress
            );

            registrar.playToServer(
                    PoseKeyPayload.TYPE,
                    PoseKeyPayload.STREAM_CODEC,
                    ServerPayloadHandler::handlePoseKeyPress
            );
        }
    }

    public static class CreativeTabRegistry {

        public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
                MOD_ID);

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> RiderEggTab = CREATIVE_MODE_TABS.register("krc_996_egg_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(MobsCore.SHOCKER_RIDER_SPAWN_EGG.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.egg_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> RiderMiscTab = CREATIVE_MODE_TABS.register("krc_997_misc_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Modded_item_core.RIDER_CIRCUIT.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.misc_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> RiderblockTab = CREATIVE_MODE_TABS.register("krc_998_blocks_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Rider_Blocks.MONITOR.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.rider_blocks")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> RiderdecorTab = CREATIVE_MODE_TABS.register("krc_999_blocks_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Rider_Blocks.PLANKS_LIGHT_BLUE.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.rider_blocks_decor")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> IchigoTab = CREATIVE_MODE_TABS.register("krc_010_ichigo_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(IchigoRiderItems.ICHIGOHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.ichigo_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> TheIchigoTab = CREATIVE_MODE_TABS.register("krc_011_the_ichigo_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(TheSeriesRiderItems.THE_ICHIGO_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.the_ichigo_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> ShinIchigoTab = CREATIVE_MODE_TABS.register("krc_012_shin_ichigo_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(ShinIchigoRiderItems.SHIN_ICHIGO_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.shin_ichigo_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> V3Tab = CREATIVE_MODE_TABS.register("krc_020_v3_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(V3RiderItems.V3HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.v3_items")).build());
        public static DeferredHolder<CreativeModeTab, CreativeModeTab> XTab = CREATIVE_MODE_TABS.register("krc_030_x_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(XRiderItems.XHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.x_items")).build());
        public static DeferredHolder<CreativeModeTab, CreativeModeTab> AMAZONTab = CREATIVE_MODE_TABS.register("krc_040_amazon_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(AmazonRiderItems.AMAZONHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.amazon_items")).build());
        public static DeferredHolder<CreativeModeTab, CreativeModeTab> STRONGERTab = CREATIVE_MODE_TABS.register("krc_050_stronger_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(StrongerRiderItems.STRONGERHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.stronger_items")).build());
        public static DeferredHolder<CreativeModeTab, CreativeModeTab> SKYRIDERTab = CREATIVE_MODE_TABS.register("krc_060_skyrider_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(SkyriderItems.SKYRIDERHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.skyrider_items")).build());
        public static DeferredHolder<CreativeModeTab, CreativeModeTab> SUPER1Tab = CREATIVE_MODE_TABS.register("krc_070_super_1_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Super1RiderItems.SUPER1HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.super_1_items")).build());
        public static DeferredHolder<CreativeModeTab, CreativeModeTab> ZXTab = CREATIVE_MODE_TABS.register("krc_090_zx_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(ZXRiderItems.ZXHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.zx_items")).build());
        public static DeferredHolder<CreativeModeTab, CreativeModeTab> BLACKTab = CREATIVE_MODE_TABS.register("krc_100_black_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(BlackRiderItems.BLACKHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.black_items")).build());
        public static DeferredHolder<CreativeModeTab, CreativeModeTab> RXTab = CREATIVE_MODE_TABS.register("krc_101_rx_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(BlackRXRiderItems.RXHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.rx_items")).build());
        public static DeferredHolder<CreativeModeTab, CreativeModeTab> SHINTab = CREATIVE_MODE_TABS.register("krc_110_shin_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(ShinRiderItems.SHINHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.shin_items")).build());
        public static DeferredHolder<CreativeModeTab, CreativeModeTab> ZOTab = CREATIVE_MODE_TABS.register("krc_120_zo_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(ZORiderItems.ZOHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.zo_items")).build());
        public static DeferredHolder<CreativeModeTab, CreativeModeTab> JTab = CREATIVE_MODE_TABS.register("krc_130_j_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(JRiderItems.JHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.j_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> KuugaTab = CREATIVE_MODE_TABS.register("krc_210_kuuga_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Kuuga_Rider_Items.KUUGAHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_kuuga_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.kuuga_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> AgitoTab = CREATIVE_MODE_TABS.register("krc_220_agito_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Agito_Rider_Items.AGITOHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_agito_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.agito_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> RyukiTab = CREATIVE_MODE_TABS.register("krc_230_ryuki_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Ryuki_Rider_Items.RYUKIHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_ryuki_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.ryuki_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> FaizTab = CREATIVE_MODE_TABS.register("krc_240_faiz_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Faiz_Rider_Items.FAIZHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_faiz_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.faiz_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> BladeTab = CREATIVE_MODE_TABS.register("krc_250_blade_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Blade_Rider_Items.BLADEHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_blade_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.blade_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> HibikiTab = CREATIVE_MODE_TABS.register("krc_260_hibiki_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Hibiki_Rider_Items.HIBIKIHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_hibiki_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.hibiki_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> KabutoTab = CREATIVE_MODE_TABS.register("krc_270_kabuto_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Kabuto_Rider_Items.KABUTOHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_kabuto_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.kabuto_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> DenOTab = CREATIVE_MODE_TABS.register("krc_280_den_o_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Den_O_Rider_Items.DEN_OHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_den_o_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.den_o_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> KivaTab = CREATIVE_MODE_TABS.register("krc_290_kiva_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Kiva_Rider_Items.KIVAHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_kiva_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.kiva_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> DecadeTab = CREATIVE_MODE_TABS.register("krc_300_decade_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Decade_Rider_Items.DECADEHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_decade_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.decade_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> WTab = CREATIVE_MODE_TABS.register("krc_310_w_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(W_Rider_Items.WHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_w_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.w_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> OOOTab = CREATIVE_MODE_TABS.register("krc_320_ooo_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(OOO_Rider_Items.OOOHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_ooo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.ooo_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> FOURZETab = CREATIVE_MODE_TABS.register("krc_330_fourze_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Fourze_Rider_Items.FOURZE_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_fourze_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.fourze_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> WIZARDTab = CREATIVE_MODE_TABS.register("krc_340_wizard_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Wizard_Rider_Items.WIZARD_HEAD.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_wizard_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.wizard_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> GAIMTab = CREATIVE_MODE_TABS.register("krc_350_gaim_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Gaim_Rider_Items.GAIM_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_gaim_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.gaim_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> DRIVETab = CREATIVE_MODE_TABS.register("krc_360_drive_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Drive_Rider_Items.DRIVE_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_drive_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.drive_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> GHOSTTab = CREATIVE_MODE_TABS.register("krc_370_ghost_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Ghost_Rider_Items.GHOST_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_ghost_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.ghost_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> EX_AIDTab = CREATIVE_MODE_TABS.register("krc_380_exaid_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Ex_Aid_Rider_Items.EX_AIDHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_ex_aid_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.ex_aid_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> BUILDTab = CREATIVE_MODE_TABS.register("krc_390_build_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Build_Rider_Items.BUILD_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_build_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.build_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> ZI_OTab = CREATIVE_MODE_TABS.register("krc_400_zi_o_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Zi_O_Rider_Items.ZI_O_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_zi_o_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.zi_o_items")).build());


        public static DeferredHolder<CreativeModeTab, CreativeModeTab> Zero_OneTab = CREATIVE_MODE_TABS.register("krc_410_zero_one_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Zero_One_Rider_Items.ZERO_ONE_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_zero_one_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.zero_one_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> SABERTab = CREATIVE_MODE_TABS.register("krc_420_saber_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Saber_Rider_Items.SABER_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_saber_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.saber_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> ReviceTab = CREATIVE_MODE_TABS.register("krc_430_geats_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Revice_Rider_Items.REVICE_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_revice_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.revice_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> GeatsTab = CREATIVE_MODE_TABS.register("krc_440_geats_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Geats_Rider_Items.GEATS_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_geats_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.geats_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> GotchardTab = CREATIVE_MODE_TABS.register("krc_450_gotchard_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Gotchard_Rider_Items.GOTCHARD_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_gotchard_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.gotchard_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> GavvTab = CREATIVE_MODE_TABS.register("krc_460_gavv_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Gavv_Rider_Items.GAVV_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_gavv_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.gavv_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> ZeztzTab = CREATIVE_MODE_TABS.register("krc_470_zeztz_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Zeztz_Rider_Items.ZEZTZ_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_zeztz_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.zeztz_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> My_thTab = CREATIVE_MODE_TABS.register("krc_480_my_th_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(Modded_item_core.MY_TH_HEAD.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.my_th_items")).build());


        public static DeferredHolder<CreativeModeTab, CreativeModeTab> GTab = CREATIVE_MODE_TABS.register("krc_800_g_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(GRiderItems.GHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_g_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.g_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> GoriderTab = CREATIVE_MODE_TABS.register("krc_810_gorider_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(GoriderItems.AKARIDERHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_gorider_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.gorider_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> RideKamensTab = CREATIVE_MODE_TABS.register("krc_830_ride_kamens_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(RideKamensItems.RIDE_KAMENS_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_ride_kamens_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.ride_kamens_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> AMAZONSTab = CREATIVE_MODE_TABS.register("krc_041_amazons_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(AmazonsRiderItems.AMAZONSHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_amazons_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.amazons_items")).build());

        public static DeferredHolder<CreativeModeTab, CreativeModeTab> BLACKSUNTab = CREATIVE_MODE_TABS.register("krc_102_black_sun_tab", () ->
                CreativeModeTab.builder().icon(() -> new ItemStack(BlackSunRiderItems.BLACKSUNHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_black_sun_items.png"))
                        .title(Component.translatable("tab.kamenridercraft.black_sun_items")).build());

        public static List<Item> ICHIGO_TAB_ITEM = new ArrayList<>();
        public static List<Item> THE_TAB_ITEM = new ArrayList<>();

        public static List<Item> V3_TAB_ITEM = new ArrayList<>();
        public static List<Item> X_TAB_ITEM = new ArrayList<>();
        public static List<Item> AMAZON_TAB_ITEM = new ArrayList<>();
        public static List<Item> STRONGER_TAB_ITEM = new ArrayList<>();
        public static List<Item> SKYRIDER_TAB_ITEM = new ArrayList<>();
        public static List<Item> SUPER1_TAB_ITEM = new ArrayList<>();
        public static List<Item> ZX_TAB_ITEM = new ArrayList<>();
        public static List<Item> BLACK_TAB_ITEM = new ArrayList<>();
        public static List<Item> RX_TAB_ITEM = new ArrayList<>();
        public static List<Item> SHIN_TAB_ITEM = new ArrayList<>();
        public static List<Item> ZO_TAB_ITEM = new ArrayList<>();
        public static List<Item> J_TAB_ITEM = new ArrayList<>();

        public static List<Item> KUUGA_TAB_ITEM = new ArrayList<>();
        public static List<Item> AGITO_TAB_ITEM = new ArrayList<>();
        public static List<Item> RYUKI_TAB_ITEM = new ArrayList<>();
        public static List<Item> FAIZ_TAB_ITEM = new ArrayList<>();
        public static List<Item> BLADE_TAB_ITEM = new ArrayList<>();
        public static List<Item> HIBIKI_TAB_ITEM = new ArrayList<>();
        public static List<Item> KABUTO_TAB_ITEM = new ArrayList<>();
        public static List<Item> DEN_O_TAB_ITEM = new ArrayList<>();
        public static List<Item> KIVA_TAB_ITEM = new ArrayList<>();
        public static List<Item> DECADE_TAB_ITEM = new ArrayList<>();

        public static List<Item> W_TAB_ITEM = new ArrayList<>();
        public static List<Item> OOO_TAB_ITEM = new ArrayList<>();
        public static List<Item> FOURZE_TAB_ITEM = new ArrayList<>();
        public static List<Item> WIZARD_TAB_ITEM = new ArrayList<>();
        public static List<Item> GAIM_TAB_ITEM = new ArrayList<>();
        public static List<Item> DRIVE_TAB_ITEM = new ArrayList<>();
        public static List<Item> EX_AID_TAB_ITEM = new ArrayList<>();
        public static List<Item> GHOST_TAB_ITEM = new ArrayList<>();
        public static List<Item> BUILD_TAB_ITEM = new ArrayList<>();
        public static List<Item> ZI_O_TAB_ITEM = new ArrayList<>();
        public static List<Item> ZERO_ONE_TAB_ITEM = new ArrayList<>();
        public static List<Item> SABER_TAB_ITEM = new ArrayList<>();
        public static List<Item> REVICE_TAB_ITEM = new ArrayList<>();
        public static List<Item> GEATS_TAB_ITEM = new ArrayList<>();
        public static List<Item> GOTCHARD_TAB_ITEM = new ArrayList<>();
        public static List<Item> GAVV_TAB_ITEM = new ArrayList<>();
        public static List<Item> ZEZTZ_TAB_ITEM = new ArrayList<>();
        public static List<Item> MY_TH_TAB_ITEM = new ArrayList<>();

        public static List<Item> G_TAB_ITEM = new ArrayList<>();
        public static List<Item> GORIDER_TAB_ITEM = new ArrayList<>();
        public static List<Item> RIDE_KAMENS_TAB_ITEM = new ArrayList<>();
        public static List<Item> AMAZONS_TAB_ITEM = new ArrayList<>();
        public static List<Item> BLACK_SUN_TAB_ITEM = new ArrayList<>();
        public static List<Item> SHIN_ICHIGO_TAB_ITEM = new ArrayList<>();

        public static List<Block> RIDER_BLOCK = new ArrayList<>();
        public static List<Block> RIDER_DECOR = new ArrayList<>();


        public static List<Item> Misc_TAB_ITEM = new ArrayList<>();

        public static void register(IEventBus eventBus) {
            CREATIVE_MODE_TABS.register(eventBus);
        }

        public static void AddItemsToTabs(BuildCreativeModeTabContentsEvent event) {

            if (event.getTab() == CreativeTabRegistry.IchigoTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.ICHIGO_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.ICHIGO_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.TheIchigoTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.THE_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.THE_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.ShinIchigoTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.SHIN_ICHIGO_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.SHIN_ICHIGO_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.V3Tab.get()) {
                for (int i = 0; i < CreativeTabRegistry.V3_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.V3_TAB_ITEM.get(i));
                }
            } else if (event.getTab() == CreativeTabRegistry.XTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.X_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.X_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.AMAZONTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.AMAZON_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.AMAZON_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.STRONGERTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.STRONGER_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.STRONGER_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.SKYRIDERTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.SKYRIDER_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.SKYRIDER_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.SUPER1Tab.get()) {
                for (int i = 0; i < CreativeTabRegistry.SUPER1_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.SUPER1_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.ZXTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.ZX_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.ZX_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.BLACKTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.BLACK_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.BLACK_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.RXTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.RX_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.RX_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.SHINTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.SHIN_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.SHIN_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.ZOTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.ZO_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.ZO_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.JTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.J_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.J_TAB_ITEM.get(i));
                }


            } else if (event.getTab() == CreativeTabRegistry.KuugaTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.KUUGA_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.KUUGA_TAB_ITEM.get(i));
                }
            } else if (event.getTab() == CreativeTabRegistry.AgitoTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.AGITO_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.AGITO_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.RyukiTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.RYUKI_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.RYUKI_TAB_ITEM.get(i));
                }
            } else if (event.getTab() == CreativeTabRegistry.FaizTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.FAIZ_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.FAIZ_TAB_ITEM.get(i));
                }
            } else if (event.getTab() == CreativeTabRegistry.BladeTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.BLADE_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.BLADE_TAB_ITEM.get(i));
                }
            } else if (event.getTab() == CreativeTabRegistry.HibikiTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.HIBIKI_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.HIBIKI_TAB_ITEM.get(i));
                }
            } else if (event.getTab() == CreativeTabRegistry.KabutoTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.KABUTO_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.KABUTO_TAB_ITEM.get(i));
                }
            } else if (event.getTab() == CreativeTabRegistry.DenOTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.DEN_O_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.DEN_O_TAB_ITEM.get(i));
                }
            } else if (event.getTab() == CreativeTabRegistry.KivaTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.KIVA_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.KIVA_TAB_ITEM.get(i));
                }
            } else if (event.getTab() == CreativeTabRegistry.DecadeTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.DECADE_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.DECADE_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.WTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.W_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.W_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.OOOTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.OOO_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.OOO_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.FOURZETab.get()) {
                for (int i = 0; i < CreativeTabRegistry.FOURZE_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.FOURZE_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.GHOSTTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.GHOST_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.GHOST_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.EX_AIDTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.EX_AID_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.EX_AID_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.WIZARDTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.WIZARD_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.WIZARD_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.GAIMTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.GAIM_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.GAIM_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.DRIVETab.get()) {
                for (int i = 0; i < CreativeTabRegistry.DRIVE_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.DRIVE_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.BUILDTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.BUILD_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.BUILD_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.ZI_OTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.ZI_O_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.ZI_O_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.Zero_OneTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.ZERO_ONE_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.ZERO_ONE_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.SABERTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.SABER_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.SABER_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.ReviceTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.REVICE_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.REVICE_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.GeatsTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.GEATS_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.GEATS_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.GotchardTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.GOTCHARD_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.GOTCHARD_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.GavvTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.GAVV_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.GAVV_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.ZeztzTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.ZEZTZ_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.ZEZTZ_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.My_thTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.MY_TH_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.MY_TH_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.AMAZONSTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.AMAZONS_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.AMAZONS_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.BLACKSUNTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.BLACK_SUN_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.BLACK_SUN_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.GTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.G_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.G_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.GoriderTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.GORIDER_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.GORIDER_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.RideKamensTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM.get(i));
                }

            } else if (event.getTab() == CreativeTabRegistry.RiderblockTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.RIDER_BLOCK.size(); i++) {
                    event.accept(CreativeTabRegistry.RIDER_BLOCK.get(i));
                }
                // event.accept(Rider_Blocks.BLUE_ROSE.get());

            } else if (event.getTab() == CreativeTabRegistry.RiderdecorTab.get()) {
                for (int i = 0; i < CreativeTabRegistry.RIDER_DECOR.size(); i++) {
                    event.accept(CreativeTabRegistry.RIDER_DECOR.get(i));
                }
                event.accept(Rider_Blocks.SHOCKER_LOGO);
                event.accept(Rider_Blocks.BLUE_ROSE);

                event.accept(Rider_Blocks.HELHEIM_PLANT);
                event.accept(Rider_Blocks.HELHEIM_PLANT_2);
                event.accept(Rider_Blocks.HELHEIM_PLANT_3);
                event.accept(Rider_Blocks.HELHEIM_PLANT_4);
                event.accept(Rider_Blocks.HELHEIM_STAIRS);
                event.accept(Rider_Blocks.HELHEIM_SLAB);
                event.accept(Rider_Blocks.HELHEIM_PRESSURE_PLATE);
                event.accept(Rider_Blocks.HELHEIM_BUTTON);
                event.accept(Rider_Blocks.HELHEIM_FENCE);
                event.accept(Rider_Blocks.HELHEIM_FENCE_GATE);
                event.accept(Rider_Blocks.HELHEIM_DOOR);
                event.accept(Rider_Blocks.HELHEIM_TRAPDOOR);
                event.accept(Modded_item_core.HELHEIM_SIGN_ITEM);
                event.accept(Modded_item_core.HELHEIM_HANGING_SIGN_ITEM);
                event.accept(Rider_Blocks.HELHEIM_SAPLING);
                event.accept(Rider_Blocks.HELHEIM_LEAVES);
                event.accept(Rider_Blocks.HELHEIM_VINE);

                event.accept(Rider_Blocks.WONDERWOOD_DOOR);

                event.accept(Rider_Blocks.WHITE_FENCE);

                event.accept(Rider_Blocks.STEEL_LADDER);
                event.accept(Rider_Blocks.RABBIT_HUTCH_LADDER);

                event.accept(Rider_Blocks.JAIL_DOOR);
                event.accept(Rider_Blocks.GOLD_DOOR);
                event.accept(Rider_Blocks.RABBIT_HUTCH_DOOR);

                event.accept(Rider_Blocks.WINDOW_PLANKS);
                event.accept(Rider_Blocks.CASTLE_DORAN_LOGO);
                event.accept(Rider_Blocks.DRIVE_PIT_LOGO);
                event.accept(Rider_Blocks.DRIVE_PIT_LADDER);

                event.accept(Rider_Blocks.WHITEBOARD);

                event.accept(Rider_Blocks.GRANUTE_GLASS_PANE);

                event.accept(Rider_Blocks.WALLPLATE_GRATE);
                event.accept(Rider_Blocks.WHITE_WALLPLATE_STAIRS);
                event.accept(Rider_Blocks.WHITE_WALLPLATE_SLAB);
                event.accept(Rider_Blocks.WHITE_WALLPLATE_WALL);
                event.accept(Rider_Blocks.GREY_WALLPLATE_STAIRS);
                event.accept(Rider_Blocks.GREY_WALLPLATE_SLAB);
                event.accept(Rider_Blocks.WALLPLATE_STAIRS);
                event.accept(Rider_Blocks.WALLPLATE_SLAB);
                event.accept(Rider_Blocks.BLACK_WALLPLATE_STAIRS);
                event.accept(Rider_Blocks.BLACK_WALLPLATE_SLAB);
                event.accept(Rider_Blocks.RED_WALLPLATE_STAIRS);
                event.accept(Rider_Blocks.RED_WALLPLATE_SLAB);
                event.accept(Rider_Blocks.YELLOW_WALLPLATE_STAIRS);
                event.accept(Rider_Blocks.YELLOW_WALLPLATE_SLAB);
                event.accept(Rider_Blocks.YELLOW_WALLPLATE_WALL);
                event.accept(Rider_Blocks.LIGHT_GREEN_WALLPLATE_STAIRS);
                event.accept(Rider_Blocks.LIGHT_GREEN_WALLPLATE_SLAB);
                event.accept(Rider_Blocks.GREEN_WALLPLATE_STAIRS);
                event.accept(Rider_Blocks.GREEN_WALLPLATE_SLAB);
                event.accept(Rider_Blocks.CYAN_WALLPLATE_STAIRS);
                event.accept(Rider_Blocks.CYAN_WALLPLATE_SLAB);
                event.accept(Rider_Blocks.CYAN_WALLPLATE_WALL);
                event.accept(Rider_Blocks.LIGHT_BLUE_WALLPLATE_STAIRS);
                event.accept(Rider_Blocks.LIGHT_BLUE_WALLPLATE_SLAB);
                event.accept(Rider_Blocks.LIGHT_BLUE_WALLPLATE_WALL);
                event.accept(Rider_Blocks.BLUE_WALLPLATE_STAIRS);
                event.accept(Rider_Blocks.BLUE_WALLPLATE_SLAB);
                event.accept(Rider_Blocks.BLUE_WALLPLATE_WALL);
                event.accept(Rider_Blocks.YELLOW_WALLPLATE_GRATE_STAIRS);
                event.accept(Rider_Blocks.LIGHT_GREEN_WALLPLATE_GRATE_SLAB);


                event.accept(Rider_Blocks.GLASS_DOOR);
                event.accept(Rider_Blocks.PLINTH);
                event.accept(Rider_Blocks.GOCHIZO_JAR);


            } else if (event.getTab() == CreativeTabRegistry.RiderEggTab.get()) {

                event.accept(MobsCore.SHOCKER_COMBATMAN_SPAWN_EGG);
                event.accept(MobsCore.SHOCKER_RIDER_SPAWN_EGG);

                event.accept(MobsCore.BATTA_AUGMENT_SPAWN_EGG);
                event.accept(MobsCore.SHIN_NO_0_SPAWN_EGG);

                event.accept(MobsCore.DESTRON_COMBATMAN_SPAWN_EGG);
                event.accept(MobsCore.GOD_WARFARE_AGENT_SPAWN_EGG);
                event.accept(MobsCore.APOLLOGIST_SPAWN_EGG);
                event.accept(MobsCore.RED_FOLLWER_SPAWN_EGG);
                event.accept(MobsCore.BLACK_SATAN_SOLDIER_SPAWN_EGG);
                event.accept(MobsCore.ARI_COMMANDO_SPAWN_EGG);
                event.accept(MobsCore.DOGMA_FIGHTER_SPAWN_EGG);
                event.accept(MobsCore.COMBAT_ROID_SPAWN_EGG);
                event.accept(MobsCore.CHAP_SPAWN_EGG);
                event.accept(MobsCore.CHAP_GREY_SPAWN_EGG);
                event.accept(MobsCore.SHADOWMOON_SPAWN_EGG);

                event.accept(MobsCore.ZU_GUMUN_BA_SPAWN_EGG);
                event.accept(MobsCore.N_DAGUVA_ZEBA_SPAWN_EGG);

                event.accept(MobsCore.PANTHERAS_LUTEUS_SPAWN_EGG);
                event.accept(MobsCore.EL_OF_THE_WATER_SPAWN_EGG);
                event.accept(MobsCore.ANGUIS_MASCULUS_SPAWN_EGG);
                event.accept(MobsCore.ANOTHER_AGITO_SPAWN_EGG);

                event.accept(MobsCore.MIRROR_RIDER_SPAWN_EGG);
                event.accept(MobsCore.ODIN_SPAWN_EGG);

                event.accept(MobsCore.RIOTROOPER_SPAWN_EGG);
                event.accept(MobsCore.ORGA_SPAWN_EGG);
                event.accept(MobsCore.MUEZ_SPAWN_EGG);
                event.accept(MobsCore.FAIZ_SPAWN_EGG);

                event.accept(MobsCore.BAKENEKO_SPAWN_EGG);
                event.accept(MobsCore.MIDAREDOUJI_SPAWN_EGG);
                event.accept(MobsCore.MAKAMOU_NINJA_GROUP_SPAWN_EGG);
                event.accept(MobsCore.KABUKI_SPAWN_EGG);

                event.accept(MobsCore.ZECTROOPER_SPAWN_EGG);
                event.accept(MobsCore.SHADOW_TROOPER_SPAWN_EGG);
                event.accept(MobsCore.NEOTROOPER_SPAWN_EGG);
                event.accept(MobsCore.CAUCASUS_SPAWN_EGG);

                event.accept(MobsCore.NEW_MOLE_IMAGIN_SPAWN_EGG);
                event.accept(MobsCore.NEW_MOLE_IMAGIN_SAND_SPAWN_EGG);
                event.accept(MobsCore.GAOH_SPAWN_EGG);
                event.accept(MobsCore.MOMOTAROS_SPAWN_EGG);
                event.accept(MobsCore.URATAROS_SPAWN_EGG);
                event.accept(MobsCore.KINTAROS_SPAWN_EGG);
                event.accept(MobsCore.RYUTAROS_SPAWN_EGG);

                event.accept(MobsCore.ARC_SPAWN_EGG);
                event.accept(MobsCore.MOOSE_FANGIRE_SPAWN_EGG);

                event.accept(MobsCore.DECADE_VIOLENT_SPAWN_EGG);

                event.accept(MobsCore.MASQUERADE_SPAWN_EGG);
                event.accept(MobsCore.CLAYDOLL_DOPANT_SPAWN_EGG);
                event.accept(MobsCore.TERROR_DOPANT_SPAWN_EGG);
                event.accept(MobsCore.TABOO_DOPANT_SPAWN_EGG);
                event.accept(MobsCore.NASCA_DOPANT_SPAWN_EGG);
                //event.accept(MobsCore.RED_NASCA_DOPANT_SPAWN_EGG);
                event.accept(MobsCore.SMILODON_DOPANT_SPAWN_EGG);
                event.accept(MobsCore.WEATHER_DOPANT_SPAWN_EGG);

                event.accept(MobsCore.FOUNDATION_X_MASQUERADE_SPAWN_EGG);
                event.accept(MobsCore.COMMANDER_DOPANT_SPAWN_EGG);
                event.accept(MobsCore.ETERNAL_SPAWN_EGG);

                event.accept(MobsCore.YUMMY_SPAWN_EGG);
                event.accept(MobsCore.KNIGHT_SOLDIER_SPAWN_EGG);
                event.accept(MobsCore.ANKH_SPAWN_EGG);
                event.accept(MobsCore.ANKH_COMPLETE_SPAWN_EGG);
                event.accept(MobsCore.ANKH_LOST_SPAWN_EGG);
                event.accept(MobsCore.UVA_SPAWN_EGG);
                event.accept(MobsCore.KAZARI_SPAWN_EGG);
                event.accept(MobsCore.MEZOOL_SPAWN_EGG);
                event.accept(MobsCore.GAMEL_SPAWN_EGG);
                event.accept(MobsCore.KYORYU_GREEED_SPAWN_EGG);
                event.accept(MobsCore.MUCHIRI_SPAWN_EGG);
                event.accept(MobsCore.SHOCKER_GREEED_SPAWN_EGG);
                event.accept(MobsCore.POSEIDON_SPAWN_EGG);
                event.accept(MobsCore.CORE_SPAWN_EGG);
                event.accept(MobsCore.POWERED_UP_CORE_SPAWN_EGG);
                event.accept(MobsCore.ANCIENT_OOO_SPAWN_EGG);
                event.accept(MobsCore.GODA_SPAWN_EGG);

                event.accept(MobsCore.SUPER_GINGAOH_SPAWN_EGG);

                event.accept(MobsCore.GHOULS_SPAWN_EGG);
                event.accept(MobsCore.MEDUSA_PHANTOM_SPAWN_EGG);
                event.accept(MobsCore.PHOENIX_PHANTOM_SPAWN_EGG);
                event.accept(MobsCore.GREMLIN_PHANTOM_SPAWN_EGG);
                event.accept(MobsCore.MAGE_FOOTSOLDIER_SPAWN_EGG);
                event.accept(MobsCore.MAGE_CAPTAIN_SPAWN_EGG);
                event.accept(MobsCore.SORCERER_SPAWN_EGG);
                event.accept(MobsCore.WISEMAN_SPAWN_EGG);

                event.accept(MobsCore.ELEMENTARY_INVES_RED_SPAWN_EGG);
                event.accept(MobsCore.KUROKAGE_TROOPER_SPAWN_EGG);
                event.accept(MobsCore.ZANGETSU_SHIN_SPAWN_EGG);
                event.accept(MobsCore.MARIKA_SPAWN_EGG);
                event.accept(MobsCore.DUKE_SPAWN_EGG);
                event.accept(MobsCore.SIGURD_SPAWN_EGG);
                event.accept(MobsCore.ROSYUO_SPAWN_EGG);
                event.accept(MobsCore.REDYUE_SPAWN_EGG);
                event.accept(MobsCore.DEMUSHU_SPAWN_EGG);
                event.accept(MobsCore.LORD_BARON_SPAWN_EGG);
                event.accept(MobsCore.MEGAHEX_SPAWN_EGG);


                event.accept(MobsCore.ROIDMUDE_SPAWN_EGG);
                event.accept(MobsCore.MASHIN_CHASER_SPAWN_EGG);
                event.accept(MobsCore.HEART_ROIDMUDE_SPAWN_EGG);
                event.accept(MobsCore.BRAIN_ROIDMUDE_SPAWN_EGG);
                event.accept(MobsCore.REAPER_LEGION_SPAWN_EGG);
                event.accept(MobsCore.MEDIC_ROIDMUDE_SPAWN_EGG);
                event.accept(MobsCore.GORD_DRIVE_SPAWN_EGG);
                event.accept(MobsCore.DARK_DRIVE_SPAWN_EGG);

                event.accept(MobsCore.GAMMA_COMMANDO_SPAWN_EGG);
                event.accept(MobsCore.NECROM_SPAWN_EGG);
                event.accept(MobsCore.IGOR_SPAWN_EGG);
                event.accept(MobsCore.DARK_NECROM_SPAWN_EGG);
                event.accept(MobsCore.DARK_GHOST_SPAWN_EGG);

                event.accept(MobsCore.BUGSTERVIRUS_SPAWN_EGG);
                event.accept(MobsCore.NEBULA_BUGSTERVIRUS_SPAWN_EGG);
                //event.accept(MobsCore.MIGHTY_BUGSTER_SPAWN_EGG);
                //event.accept(MobsCore.TADDLE_BUGSTER_SPAWN_EGG);
                //event.accept(MobsCore.BANG_BANG_BUGSTER_SPAWN_EGG);
                event.accept(MobsCore.RIDEPLAYER_SPAWN_EGG);
                //event.accept(MobsCore.LOVELY_BUGSTER_SPAWN_EGG);
                //event.accept(MobsCore.LOVELICA_BUGSTER_SPAWN_EGG);
                event.accept(MobsCore.GENM_SPAWN_EGG);
                event.accept(MobsCore.GRAPHITE_BUGSTER_SPAWN_EGG);
                event.accept(MobsCore.POPPY_RED_SPAWN_EGG);
                event.accept(MobsCore.PARADX_SPAWN_EGG);
                event.accept(MobsCore.CRONUS_SPAWN_EGG);

                event.accept(MobsCore.GUARDIAN_SPAWN_EGG);
                event.accept(MobsCore.HOKUTO_GUARDIAN_SPAWN_EGG);
                event.accept(MobsCore.SEITO_GUARDIAN_SPAWN_EGG);
                event.accept(MobsCore.HARD_GUARDIAN_SPAWN_EGG);
                event.accept(MobsCore.BLOOD_STALK_SPAWN_EGG);
                event.accept(MobsCore.NIGHT_ROGUE_SPAWN_EGG);
                event.accept(MobsCore.SMASH_SPAWN_EGG);
                event.accept(MobsCore.GREASE_SPAWN_EGG);
                event.accept(MobsCore.BUILD_SPAWN_EGG);
                event.accept(MobsCore.EVOL_SPAWN_EGG);
                event.accept(MobsCore.KILLBUS_SPAWN_EGG);
                event.accept(MobsCore.DOWNFALL_GUARDIAN_SPAWN_EGG);
                event.accept(MobsCore.PHANTOM_CRUSHER_SPAWN_EGG);
                event.accept(MobsCore.STAG_LOST_SMASH_SPAWN_EGG);
                event.accept(MobsCore.HELL_BROS_SPAWN_EGG);
                event.accept(MobsCore.MAD_ROGUE_SPAWN_EGG);
                event.accept(MobsCore.KAISER_SPAWN_EGG);
                event.accept(MobsCore.KAISER_REVERSE_SPAWN_EGG);
                event.accept(MobsCore.BIKAISER_SPAWN_EGG);

                event.accept(MobsCore.KASSHINE_SPAWN_EGG);
                event.accept(MobsCore.ANOTHER_ZI_O_SPAWN_EGG);
                event.accept(MobsCore.ANOTHER_DEN_O_SPAWN_EGG);
                event.accept(MobsCore.WOZ_SPAWN_EGG);
                event.accept(MobsCore.GINGA_SPAWN_EGG);
                event.accept(MobsCore.YAMININ_SPAWN_EGG);
                event.accept(MobsCore.BARLCKXS_SPAWN_EGG);
                event.accept(MobsCore.ZONJIS_SPAWN_EGG);
                event.accept(MobsCore.ZAMONAS_SPAWN_EGG);

                event.accept(MobsCore.TRILOBITE_MAGIA_SPAWN_EGG);
                event.accept(MobsCore.DODO_MAGIA_CHICK_SPAWN_EGG);
                event.accept(MobsCore.BATTLE_RAIDER_SPAWN_EGG);
                event.accept(MobsCore.ABADDON_SPAWN_EGG);
                event.accept(MobsCore.MAGIA_SPAWN_EGG);
                event.accept(MobsCore.GIGER_SPAWN_EGG);
                event.accept(MobsCore.HOROBI_SPAWN_EGG);
                event.accept(MobsCore.JIN_SPAWN_EGG);
                event.accept(MobsCore.IKAZUCHI_SPAWN_EGG);
                event.accept(MobsCore.NAKI_SPAWN_EGG);
                event.accept(MobsCore.DODO_MAGIA_SPAWN_EGG);
                event.accept(MobsCore.RAIDER_SPAWN_EGG);
                event.accept(MobsCore.ARK_ZERO_SPAWN_EGG);
                event.accept(MobsCore.ABADDON_COMMANDER_SPAWN_EGG);
                event.accept(MobsCore.EDEN_SPAWN_EGG);
                event.accept(MobsCore.ZAIA_SPAWN_EGG);
                event.accept(MobsCore.DIRE_WOLF_SOLD_MAGIA_SPAWN_EGG);
                event.accept(MobsCore.SERVAL_TIGER_SOLD_MAGIA_SPAWN_EGG);
                event.accept(MobsCore.ZEIN_SPAWN_EGG);

                event.accept(MobsCore.SHIMI_SPAWN_EGG);
                event.accept(MobsCore.CALIBUR_SPAWN_EGG);
                event.accept(MobsCore.FALCHION_SPAWN_EGG);
                event.accept(MobsCore.SABELA_SPAWN_EGG);
                event.accept(MobsCore.DURENDAL_SPAWN_EGG);
                event.accept(MobsCore.SOLOMON_SPAWN_EGG);
                event.accept(MobsCore.STORIOUS_RIDER_SPAWN_EGG);
                event.accept(MobsCore.LEGEIEL_SPAWN_EGG);
                event.accept(MobsCore.LEGEIEL_FORBIDDEN_SPAWN_EGG);
                event.accept(MobsCore.ZOOOUS_SPAWN_EGG);
                event.accept(MobsCore.ZOOOUS_PREDATOR_SPAWN_EGG);
                event.accept(MobsCore.STORIOUS_SPAWN_EGG);
                event.accept(MobsCore.DESAST_SPAWN_EGG);
                event.accept(MobsCore.CHARYBDIS_SPAWN_EGG);
                event.accept(MobsCore.CHARYBDIS_HERCULES_SPAWN_EGG);

                event.accept(MobsCore.GIFF_JUNIOR_SPAWN_EGG);
                event.accept(MobsCore.EVIL_SPAWN_EGG);
                event.accept(MobsCore.DAIOUIKA_DEADMAN_SPAWN_EGG);
                event.accept(MobsCore.ANOMALOCARIS_DEADMAN_SPAWN_EGG);
                event.accept(MobsCore.QUEEN_BEE_DEADMAN_SPAWN_EGG);
                event.accept(MobsCore.WOLF_DEADMAN_SPAWN_EGG);
                event.accept(MobsCore.VAIL_SPAWN_EGG);

                event.accept(MobsCore.PAWN_JYAMATO_SPAWN_EGG);
                event.accept(MobsCore.JYAMATO_RIDER_SPAWN_EGG);
                event.accept(MobsCore.GM_RIDER_SPAWN_EGG);
                event.accept(MobsCore.GLARE_SPAWN_EGG);
                event.accept(MobsCore.GLARE2_SPAWN_EGG);
                event.accept(MobsCore.GAZER_SPAWN_EGG);
                event.accept(MobsCore.END_RIDER_SPAWN_EGG);
                event.accept(MobsCore.PREMIUM_BEROBA_SPAWN_EGG);
                event.accept(MobsCore.PREMIUM_KEKERA_SPAWN_EGG);

                event.accept(MobsCore.MALGAM_SPAWN_EGG);
                event.accept(MobsCore.DREAD_SPAWN_EGG);
                event.accept(MobsCore.GOLEM_SPAWN_EGG);
                event.accept(MobsCore.GIGIST_SPAWN_EGG);
                event.accept(MobsCore.GERMAIN_SPAWN_EGG);
                event.accept(MobsCore.GAELIJAH_SPAWN_EGG);
                event.accept(MobsCore.ELD_SPAWN_EGG);

                event.accept(MobsCore.AGENT_SPAWN_EGG);
                event.accept(MobsCore.BITTER_GAVV_SPAWN_EGG);
                event.accept(MobsCore.JEEB_STOMACH_SPAWN_EGG);
                event.accept(MobsCore.SHIITA_STOMACH_SPAWN_EGG);
                event.accept(MobsCore.NYELV_STOMACH_SPAWN_EGG);
                event.accept(MobsCore.GLOTTA_STOMACH_SPAWN_EGG);
                event.accept(MobsCore.LANGO_STOMACH_SPAWN_EGG);
                event.accept(MobsCore.BOCCA_JALDAK_SPAWN_EGG);
                event.accept(MobsCore.CARIES_SPAWN_EGG);

                event.accept(MobsCore.NOX_SPAWN_EGG);


            } else if (event.getTab() == CreativeTabRegistry.RiderMiscTab.get()) {

                event.accept(MobsCore.BICYCLE_SPAWN_EGG);
                event.accept(MobsCore.ACROBATTER_SPAWN_EGG);
                event.accept(MobsCore.RIDORON_SPAWN_EGG);
                event.accept(MobsCore.MACEHINE_TORADOR_SPAWN_EGG);
                event.accept(MobsCore.AUTO_VAJIN_SPAWN_EGG);
                event.accept(MobsCore.MACEHINE_DENBIRD_SPAWN_EGG);
                event.accept(MobsCore.HARDBOILER_SPAWN_EGG);
                event.accept(MobsCore.SKULLBOILER_SPAWN_EGG);
                event.accept(MobsCore.ACCEL_BIKE_FORM_SPAWN_EGG);
                event.accept(MobsCore.RIDEVENDOR_SPAWN_EGG);
                event.accept(MobsCore.TORIDEVENDOR_SPAWN_EGG);
                event.accept(MobsCore.MACEHINE_MASSIGLER_SPAWN_EGG);
                event.accept(MobsCore.SAKURA_HURRICANE_SPAWN_EGG);
                event.accept(MobsCore.ROSE_ATTACKER_SPAWN_EGG);
                event.accept(MobsCore.BIKE_GAMER_SPAWN_EGG);
                event.accept(MobsCore.SPORTS_GAMER_SPAWN_EGG);
                event.accept(MobsCore.PROTO_SPORTS_GAMER_SPAWN_EGG);
                event.accept(MobsCore.MACEHINE_BUILDER_SPAWN_EGG);
                event.accept(MobsCore.RIDESTRIKER_SPAWN_EGG);
                event.accept(MobsCore.RISEHOPPER_SPAWN_EGG);
                event.accept(MobsCore.DIAGOSPEEDY_SPAWN_EGG);
                event.accept(MobsCore.VICE_BIKE_SPAWN_EGG);
                event.accept(MobsCore.BOOSTRIKER_SPAWN_EGG);
                event.accept(MobsCore.BOOSTRIKER_GEATS_MODE_SPAWN_EGG);
                event.accept(MobsCore.BOOSTRIKER_TYCOON_MODE_SPAWN_EGG);
                event.accept(MobsCore.BOOSTRIKER_NA_GO_MODE_SPAWN_EGG);
                event.accept(MobsCore.BOOSTRIKER_BUFFA_MODE_SPAWN_EGG);

                for (int i = 0; i < CreativeTabRegistry.Misc_TAB_ITEM.size(); i++) {
                    event.accept(CreativeTabRegistry.Misc_TAB_ITEM.get(i));
                }
                event.accept(MusicDiscItems.LETS_GO_RIDER_MUSIC_DISC);
                event.accept(MusicDiscItems.TATAKAE_KAMEN_RIDER_V3_MUSIC_DISC);
                event.accept(MusicDiscItems.AMAZON_RIDER_KOKO_NI_ARI_MUSIC_DISC);
                event.accept(MusicDiscItems.SET_UP_KAMEN_RIDER_X_MUSIC_DISC);
                event.accept(MusicDiscItems.KAMEN_RIDER_STRONGER_NO_UTA_MUSIC_DISC);
                event.accept(MusicDiscItems.MOERO_KAMEN_RIDER_MUSIC_DISC);
                event.accept(MusicDiscItems.DRAGON_ROAD_MUSIC_DISC);
                event.accept(MusicDiscItems.KAMEN_RIDER_SUPER_1_MUSIC_DISC);
                event.accept(MusicDiscItems.KAMEN_RIDER_BLACK_MUSIC_DISC);
                event.accept(MusicDiscItems.KAMEN_RIDER_BLACK_RX_MUSIC_DISC);
                event.accept(MusicDiscItems.KAMEN_RIDER_KUUGA_MUSIC_DISC);
                event.accept(MusicDiscItems.KAMEN_RIDER_AGITO_MUSIC_DISC);
                event.accept(MusicDiscItems.ALIVE_A_LIFE_MUSIC_DISC);
                event.accept(MusicDiscItems.JUSTIFAIZ_MUSIC_DISC);
                event.accept(MusicDiscItems.ROUND_ZERO_BLADE_BRAVE_MUSIC_DISC);
                event.accept(MusicDiscItems.ELEMENTS_MUSIC_DISC);
                event.accept(MusicDiscItems.REBIRTH_MUSIC_DISC);
                event.accept(MusicDiscItems.KAGAYAKI_MUSIC_DISC);
                event.accept(MusicDiscItems.HAJIMARI_NO_KIMI_E_MUSIC_DISC);
                event.accept(MusicDiscItems.NEXT_LEVEL_MUSIC_DISC);
                event.accept(MusicDiscItems.CLIMAX_JUMP_MUSIC_DISC);
                event.accept(MusicDiscItems.BREAK_THE_CHAIN_MUSIC_DISC);
                event.accept(MusicDiscItems.JOURNEY_THROUGH_THE_DECADE_MUSIC_DISC);
                event.accept(MusicDiscItems.WBX_MUSIC_DISC);
                event.accept(MusicDiscItems.ANYTHING_GOES_MUSIC_DISC);
                event.accept(MusicDiscItems.SWITCH_ON_MUSIC_DISC);
                event.accept(MusicDiscItems.LIFE_IS_SHOWTIME_MUSIC_DISC);
                event.accept(MusicDiscItems.JUST_LIVE_MORE_MUSIC_DISC);
                event.accept(MusicDiscItems.SURPRISE_DRIVE_MUSIC_DISC);
                event.accept(MusicDiscItems.WARERA_OMOU_YUE_NI_WARERA_ARI_MUSIC_DISC);
                event.accept(MusicDiscItems.EXCITE_KEY_MUSIC_DISC);
                event.accept(MusicDiscItems.BE_THE_ONE_MUSIC_DISC);
                event.accept(MusicDiscItems.OVER_QUARTZER_MUSIC_DISC);
                event.accept(MusicDiscItems.IZANAGI_MUSIC_DISC);
                event.accept(MusicDiscItems.P_A_R_T_Y_UNIVERSE_FESTIVAL_MUSIC_DISC);
                event.accept(MusicDiscItems.REAL_X_EYEZ_MUSIC_DISC);
                event.accept(MusicDiscItems.ALMIGHTY_MUSIC_DISC);
                event.accept(MusicDiscItems.LIVEDEVIL_MUSIC_DISC);
                event.accept(MusicDiscItems.GEORGE_KARIZAKIS_RIDER_SYSTEM_MUSIC_DISC);
                event.accept(MusicDiscItems.TRUST_LAST_MUSIC_DISC);
                event.accept(MusicDiscItems.CHEMY_X_STORY_MUSIC_DISC);
                event.accept(MusicDiscItems.CHEMY_X_STORY_FLOW_MUSIC_DISC);
                event.accept(MusicDiscItems.GOT_BOOST_MUSIC_DISC);
                event.accept(MusicDiscItems.VISIONS_MUSIC_DISC);
                event.accept(MusicDiscItems.PLAY_BACK_MUSIC_DISC);

                event.accept(MusicDiscItems.MASKED_RIDER_MUSIC_DISC);
            }
        }

    }
}


