// TODO: Re-balancing for all Riders
package com.kelco.kamenridercraft;

import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.block.entity.ModBlockEntities;
import com.kelco.kamenridercraft.block.entity.renderer.PandoraPanelBlockEntityRenderer;
import com.kelco.kamenridercraft.block.entity.renderer.PlinthBlockEntityRenderer;
import com.kelco.kamenridercraft.client.KeyBindings;
import com.kelco.kamenridercraft.client.gui.*;
import com.kelco.kamenridercraft.client.renderer.*;
import com.kelco.kamenridercraft.compat.BetterCombatAttackListener;
import com.kelco.kamenridercraft.dimension.custom_dimension_effect;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.footSoldiers.ZuGumunBaEntity;
import com.kelco.kamenridercraft.entities.villager.RiderVillagers;
import com.kelco.kamenridercraft.events.ModClientEvents;
import com.kelco.kamenridercraft.events.ModCommonEvents;
import com.kelco.kamenridercraft.events.ModServerEvents;
import com.kelco.kamenridercraft.init.*;
import com.kelco.kamenridercraft.item.*;
import com.kelco.kamenridercraft.item.BaseItems.BaseSwordItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import com.kelco.kamenridercraft.loot.LootModifierCore;
import com.kelco.kamenridercraft.network.ClientPayloadHandler;
import com.kelco.kamenridercraft.network.ServerPayloadHandler;
import com.kelco.kamenridercraft.network.payload.*;
import com.kelco.kamenridercraft.particle.*;
import com.kelco.kamenridercraft.sounds.ModSounds;
import com.kelco.kamenridercraft.wordgen.ModConfiguredFeatures;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.client.event.*;

import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.registration.HandlerThread;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import java.util.ArrayList;
import java.util.List;


@Mod(KamenRiderCraftCore.MOD_ID)
public class KamenRiderCraftCore
{
     public static final String MOD_ID = "kamenridercraft";

    public static final int NEW_STRUCTURE_SIZE = 512;

    private static final ResourceLocation BLOCKING_PROPERTY_RESLOC =  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "blocking");

    public static List<Item> CHANGE_SWORD_ITEM= new ArrayList<Item>();

    public static List<Item> SWORD_GUN_ITEM= new ArrayList<Item>();

    public static List<Item> KUUGA_CHANGING_ITEM= new ArrayList<Item>();
    public static List<Item> KUUGA_PHONE= new ArrayList<Item>();

    public static List<Item> RAISE_RISER_ITEM= new ArrayList<Item>();

    public static List<Item> SHIELD_ITEM= new ArrayList<Item>();

    public static List<Item> DARK_SHIELD_ITEM= new ArrayList<Item>();

    public static List<Item> CHEMY_CARD= new ArrayList<Item>();

    public KamenRiderCraftCore(IEventBus modEventBus, ModContainer modContainer)
    {

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
       NeoForge.EVENT_BUS.register(new ModClientEvents.ClientEvents());
       NeoForge.EVENT_BUS.register(new ModCommonEvents.CommonEvents());
        NeoForge.EVENT_BUS.register(new ModCommonEvents.EventHandler());

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);
        Effect_core.register(modEventBus);
        ModMenus.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModSounds.register(modEventBus);
        RiderPotPattern.register(modEventBus);
        Modded_item_core.register(modEventBus);
        Reboot_Rider_Items.register(modEventBus);
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
        Zeztz_Rider_Items.register(modEventBus);
        Miscellaneous_Rider_Items.register(modEventBus);
        Rider_Blocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        MobsCore.register(modEventBus);
        MobsCore.MOBLIST.register(modEventBus);
        RiderTabs.register(modEventBus);
        RiderVillagers.register(modEventBus);
        ModParticles.register(modEventBus);
        /*ModBlockEntities.REGISTRY.register(modEventBus);*/

        LootModifierCore.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(ModCommonEvents::registerLayers);
        modEventBus.addListener(ModCommonEvents::entityAttributeEvent);
        modEventBus.addListener(ModCommonEvents::entitySpawnRestriction);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC);
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
        NeoForge.EVENT_BUS.register(new ModServerEvents.ServerEvents());
    }

    @SubscribeEvent
    public void addRenderLivingEvent(RenderLivingEvent.Pre event) {

if (event.getRenderer().getModel()instanceof PlayerModel model) {

    if (event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() instanceof ArmorItem belt) {
     if (belt instanceof RiderDriverItem driver && driver.isTransformed(event.getEntity())) {
        double tag = RiderDriverItem.getRenderType(event.getEntity().getItemBySlot(EquipmentSlot.FEET));
        if (tag != 0) {
            if (tag != 2) {
                model.head.visible = false;
            } else {
                model.head.visible = true;
            }

            if (tag != 3) {
                model.leftLeg.visible = false;
                model.rightLeg.visible = false;
                model.leftArm.visible = false;
                model.rightArm.visible = false;
                model.body.visible = false;
            } else {
                model.head.visible = true;
                model.leftLeg.visible = true;
                model.rightLeg.visible = true;
                model.leftArm.visible = true;
                model.rightArm.visible = true;
                model.body.visible = true;
            }

            model.hat.visible = false;
            model.leftSleeve.visible = false;
            model.rightSleeve.visible = false;
            model.leftPants.visible = false;
            model.rightPants.visible = false;
            model.jacket.visible = false;
        } else {
            model.head.visible = true;
            model.hat.visible = true;
            model.leftLeg.visible = true;
            model.rightLeg.visible = true;
            model.leftArm.visible = true;
            model.rightArm.visible = true;
            model.body.visible = true;
            model.leftSleeve.visible = true;
            model.rightSleeve.visible = true;
            model.leftPants.visible = true;
            model.rightPants.visible = true;
            model.jacket.visible = true;
        }
    } else if (event.getEntity().getItemBySlot(EquipmentSlot.FEET).has(DataComponents.CUSTOM_DATA)) {
        CompoundTag tag = event.getEntity().getItemBySlot(EquipmentSlot.FEET).get(DataComponents.CUSTOM_DATA).getUnsafe();
        if (tag.getDouble("render_type") != 0) {
            if (tag.getDouble("render_type") != 2) {
                model.head.visible = false;
            } else {
                model.head.visible = true;
            }

            if (tag.getDouble("render_type") != 3) {
                model.leftLeg.visible = false;
                model.rightLeg.visible = false;
                model.leftArm.visible = false;
                model.rightArm.visible = false;
                model.body.visible = false;
            } else {
                model.head.visible = true;
                model.leftLeg.visible = true;
                model.rightLeg.visible = true;
                model.leftArm.visible = true;
                model.rightArm.visible = true;
                model.body.visible = true;
            }

            model.hat.visible = false;
            model.leftSleeve.visible = false;
            model.rightSleeve.visible = false;
            model.leftPants.visible = false;
            model.rightPants.visible = false;
            model.jacket.visible = false;
        } else {
            model.head.visible = true;
            model.hat.visible = true;
            model.leftLeg.visible = true;
            model.rightLeg.visible = true;
            model.leftArm.visible = true;
            model.rightArm.visible = true;
            model.body.visible = true;
            model.leftSleeve.visible = true;
            model.rightSleeve.visible = true;
            model.leftPants.visible = true;
            model.rightPants.visible = true;
            model.jacket.visible = true;
        }


    }else {
         {
             model.head.visible = true;
             model.hat.visible = true;
             model.leftLeg.visible = true;
             model.rightLeg.visible = true;
             model.leftArm.visible = true;
             model.rightArm.visible = true;
             model.body.visible = true;
             model.leftSleeve.visible = true;
             model.rightSleeve.visible = true;
             model.leftPants.visible = true;
             model.rightPants.visible = true;
             model.jacket.visible = true;
         }}}
     else {
            {
                model.head.visible = true;
                model.hat.visible = true;
                model.leftLeg.visible = true;
                model.rightLeg.visible = true;
                model.leftArm.visible = true;
                model.rightArm.visible = true;
                model.body.visible = true;
                model.leftSleeve.visible = true;
                model.rightSleeve.visible = true;
                model.leftPants.visible = true;
                model.rightPants.visible = true;
                model.jacket.visible = true;
            }
    }
}

        float size = 1;

        if (event.getEntity().hasEffect(Effect_core.STRETCH)) {
            size = size + ((event.getEntity().getEffect(Effect_core.STRETCH).getAmplifier()) +1f);
        }

        float size2 = event.getEntity().hasEffect(Effect_core.STRETCH) ? 1 : size;

        if (event.getEntity().hasEffect(Effect_core.FLAT)) {
            size2 = 0.04f;
        }
        float size3 = event.getEntity().hasEffect(Effect_core.STRETCH) ? 1 : size;
        if (event.getEntity().hasEffect(Effect_core.WIDE)) {
            size2 = (float) (size2 * 3);
            size3 = (float) (size3 * 3);
        }
        event.getPoseStack().scale(size3, size, size2);
    }


    @SubscribeEvent
    public void addRenderPlayerEvent(RenderPlayerEvent.Pre event) {

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
            for (Item item : KUUGA_PHONE) {
                ItemProperties.register(item, ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                            if (p_174637_ == null) {
                                return 0.0F;
                            } else if (p_174637_.getItemBySlot(EquipmentSlot.FEET) != null) {

                                if (p_174637_ instanceof Player player) {

                                    List<LivingEntity> nearbyEnemies = player.level().getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(15), entity ->
                                            (entity instanceof ZuGumunBaEntity));
                                    for (LivingEntity enemy : nearbyEnemies) {
                                        if (enemy!=null) {
                                            return 1;
                                        } else {
                                            return 0;
                                        }
                                    }

                                    return 0;
                                }
                                return 0;
                            }
                            return 0;
                            //return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 1.0F;
                        }
                );
            }

            for (Item item : CHEMY_CARD) {
                ItemProperties.register(item, ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                            if (p_174637_ == null) {
                                return 0.0F;
                            } else if (p_174637_ instanceof Player player) {
                                ResourceKey<Level> CITY = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:city"));
                                if (player.level().dimension() == CITY){
                                    return 1;
                                }else if (player.level().getBiome(player.blockPosition()).is(BiomeTags.IS_NETHER)){
                                    return 2;
                                }else return 0;
                                }
                                return 0;
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
 if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == Geats_Rider_Items.RAISE_RISER_BELT_ZIIN.get()||p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == Geats_Rider_Items.LASER_RISE_DRIVER_GAZER_ZERO.get()) {
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

            if (ModList.get().isLoaded("bettercombat")) BetterCombatAttackListener.register();
        }

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.PANDORA_PANEL_BE.get(), PandoraPanelBlockEntityRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.PLINTH_BE.get(), PlinthBlockEntityRenderer::new);
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
            event.registerEntityRenderer(MobsCore.MUEZ.get(), BasicEntityRenderer::new);

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
            event.registerEntityRenderer(MobsCore.MAGE_CAPTAIN .get(), BasicEntityRenderer::new);
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

            event.registerEntityRenderer(MobsCore.ROIDMUDE.get(), RoidmudeRenderer::new);
            event.registerEntityRenderer(MobsCore.REAPER_LEGION.get(), ReaperRenderer::new);
            event.registerEntityRenderer(MobsCore.MASHIN_CHASER.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.HEART_ROIDMUDE.get(), HeartRoidmudeRenderer::new);
            event.registerEntityRenderer(MobsCore.BRAIN_ROIDMUDE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.MEDIC_ROIDMUDE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GORD_DRIVE.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DARK_DRIVE.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.GAMMA_COMMANDO.get(), BasicEntityRenderer::new);

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

            event.registerEntityRenderer(MobsCore.AGENT.get(), AgentRenderer::new);
            event.registerEntityRenderer(MobsCore.BITTER_GAVV.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.NYELV_STOMACH.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GLOTTA_STOMACH.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.JEEB_STOMACH.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.SHIITA_STOMACH.get(), BasicEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.LANGO_STOMACH.get(), BasicEntityRenderer::new);

            event.registerEntityRenderer(MobsCore.ACROBATTER.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.RIDORON.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.MACEHINE_TORADOR.get(), BikeRenderer::new);
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
            event.registerEntityRenderer(MobsCore.MACEHINE_BUILDER.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.RIDESTRIKER.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.RISEHOPPER.get(), BikeRenderer::new);
            event.registerEntityRenderer(MobsCore.DIAGOSPEEDY.get(), BikeRenderer::new);

            event.registerEntityRenderer(MobsCore.RIDER_SUMMON.get(), SummonedEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.COMPLETE_SUMMON.get(), SummonedEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.GRAND_SUMMON.get(), SummonedEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.PARADX_SUMMON.get(), SummonedEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.DECADE_ARMOR_EX_AID.get(), SummonedEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.VICE.get(), SummonedEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.LOVEKOV.get(), SummonedEntityRenderer::new);
            event.registerEntityRenderer(MobsCore.WHIPPED_SOLDIER.get(), WhippedSoldierRenderer::new);
            
            event.registerEntityRenderer(MobsCore.CHAIR_ENTITY.get(), ChairRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);

            event.registerEntityRenderer(MobsCore.WEAPON_PROJECTILE.get(), ThrownWeaponRenderer::new);
            event.registerEntityRenderer(MobsCore.SHURIKEN_PROJECTILE.get(), ThrownShurikenRenderer::new);

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
            event.registerSpriteSet(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(), DarkGreenSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.PURPLE_SPARK_PARTICLES.get(), PurpleSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.PINK_SPARK_PARTICLES.get(), PinkSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.YELLOW_SPARK_PARTICLES.get(), YellowSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.GOLD_SPARK_PARTICLES.get(), GoldSparkParticles.Provider::new);
            event.registerSpriteSet(ModParticles.BLACK_SPARK_PARTICLES.get(), BlackSparkParticles.Provider::new);

            event.registerSpriteSet(ModParticles.HIT_PARTICLES.get(), HitParticles.Provider::new);
            event.registerSpriteSet(ModParticles.GUMMI_PARTICLES.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.GUMMI_PARTICLES2.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.GUMMI_PARTICLES3.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.SNACK_PARTICLES.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.CHOCO_PARTICLES.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.CANDY_PARTICLES.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.CANDY_PARTICLES2.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.CANDY_PARTICLES3.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.CANDY_PARTICLES4.get(), GummiParticles.Provider::new);
            event.registerSpriteSet(ModParticles.REALIZING_PARTICLES.get(), realizingParticles.Provider::new);
            event.registerSpriteSet(ModParticles.WIZARD_PARTICLES.get(), WizardParticles.Provider::new);
        }
        
        @SubscribeEvent
        public static void registerKeys(RegisterKeyMappingsEvent event) {
            event.register(KeyBindings.INSTANCE.BeltKey);
            event.register(KeyBindings.INSTANCE.AbilityKey);
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
            event.register(ModMenus.VISTAMP_HOLDER_GUI.get(), VistampHolderGuiScreen::new);
            event.register(ModMenus.RAISE_BUCKLE_HOLDER_GUI.get(), RaiseBuckleHolderGuiScreen::new);
            event.register(ModMenus.GOTCHANDRAW_HOLDER_GUI.get(), GotchandrawHolderGuiScreen::new);
            event.register(ModMenus.GOTCHANCOLLECTION_PANEL_GUI.get(), GotchancollectionPanelGuiScreen::new);
            event.register(ModMenus.CHEMY_RISER_GUI.get(), ChemyRiserGuiScreen::new);
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
		    registrar.playToServer(
		        BeltKeyPayload.TYPE,
		        BeltKeyPayload.STREAM_CODEC,
		        ServerPayloadHandler::handleBeltKeyPress
		    );

            registrar.playToServer(
                    AbilityKeyPayload.TYPE,
                    AbilityKeyPayload.STREAM_CODEC,
                    ServerPayloadHandler::handleAbilityKeyPress
            );
		}
    }
}


