package com.kelco.kamenridercraft;

import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.events.ModClientEvents;
import com.kelco.kamenridercraft.events.ModCommonEvents;
import com.kelco.kamenridercraft.item.*;
import com.kelco.kamenridercraft.item.BaseItems.BaseSwordItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
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
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
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
       // NeoForge.EVENT_BUS.register(new ModCommonEvents.ForgeCommonEvents());
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
        //W_Rider_Items.register(modEventBus);
       // OOO_Rider_Items.register(modEventBus);
        Ex_Aid_Rider_Items.register(modEventBus);
        Zero_One_Rider_Items.register(modEventBus);
        //Geats_Rider_Items.register(modEventBus);
        //Gotchard_Rider_Items.register(modEventBus);
        Gavv_Rider_Items.register(modEventBus);
        Reboot_Rider_Items.register(modEventBus);
        Miscellaneous_Rider_Items.register(modEventBus);
        Rider_Blocks.register(modEventBus);

        RiderTabs.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

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
/**


 for (int i = 0; i < RAISE_RISER_ITEM.size(); i++)
 {
 ItemProperties.register(RAISE_RISER_ITEM.get(i), new ResourceLocation("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
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

 **/

                for (int i = 0; i < SWORD_GUN_ITEM.size(); i++)
                {
                    ItemProperties.register(SWORD_GUN_ITEM.get(i),  ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                        if (p_174637_ == null) {
                            return 0.0F;
                        } else {
                            return 1.0F;
                            //return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 1.0F;
                        }
                    });
                }

                for (int i = 0; i < CHANGE_SWORD_ITEM.size(); i++)
                {
                    ItemProperties.register(CHANGE_SWORD_ITEM.get(i), ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                        return BaseSwordItem.Get_Mode(p_174635_);

                    });
                }
                /**
                 for (int i = 0; i < DARK_SHIELD_ITEM.size(); i++)
                 {
                 ItemProperties.register(DARK_SHIELD_ITEM.get(i), new ResourceLocation("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
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
                 });
                 **/
        }
    }
}


