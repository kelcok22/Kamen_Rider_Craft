package com.kelco.kamenridercraft;

import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.client.renderer.AllyEntityRenderer;
import com.kelco.kamenridercraft.client.renderer.AnkhRenderer;
import com.kelco.kamenridercraft.client.renderer.BasicEntityRenderer;
import com.kelco.kamenridercraft.client.renderer.BikeRenderer;
import com.kelco.kamenridercraft.client.renderer.NewMoleImaginSandRenderer;
import com.kelco.kamenridercraft.client.renderer.SummonedEntityRenderer;
import com.kelco.kamenridercraft.dimension.custom_dimension_effect;
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
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;
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

    public static final int NEW_STRUCTURE_SIZE = 512;

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
        modEventBus.addListener(ModCommonEvents::entityAttributeEvent);
        modEventBus.addListener(ModCommonEvents::entitySpawnRestriction);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }


    private void commonSetup(final FMLCommonSetupEvent event)
    {

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
        public static void RegisterDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent event) {
            event.register(custom_dimension_effect.MOON_EFFECTS,new custom_dimension_effect.MoonEffects());
        }


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

            event.registerEntityRenderer(MobsCore.KUROKAGE_TROOPER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.ZANGETSU_SHIN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MARIKA.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DUKE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SIGURD.get(), BasicEntityRenderer::new);

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

            event.registerEntityRenderer(MobsCore.GINGA.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.WOZ.get(), BasicEntityRenderer::new);

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
            event.registerEntityRenderer(MobsCore.QUEEN_BEE_DEADMAN.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.WOLF_DEADMAN.get(), BasicEntityRenderer::new);

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


