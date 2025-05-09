package com.kelco.kamenridercraft.item.tabs;


import java.util.ArrayList;
import java.util.List;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.bosses.DemushuEntity;
import com.kelco.kamenridercraft.entities.bosses.LordBaronEntity;
import com.kelco.kamenridercraft.entities.bosses.RedyueEntity;
import com.kelco.kamenridercraft.entities.bosses.RosyuoEntity;
import com.kelco.kamenridercraft.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.bus.api.IEventBus;


public class RiderTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            KamenRiderCraftCore.MOD_ID) ;

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> RiderMiscTab = CREATIVE_MODE_TABS.register("krc_997_misc_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Modded_item_core.RIDER_CIRCUIT.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.misc_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab>  RiderblockTab = CREATIVE_MODE_TABS.register("krc_998_blocks_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Rider_Blocks.MONITOR.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.rider_blocks")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab>  RiderdecorTab = CREATIVE_MODE_TABS.register("krc_999_blocks_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Rider_Blocks.PLANKS_LIGHT_BLUE.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.rider_blocks_decor")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> IchigoTab = CREATIVE_MODE_TABS.register("krc_010_ichigo_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Ichigo_Rider_Items.ICHIGOHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.ichigo_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> ShinIchigoTab = CREATIVE_MODE_TABS.register("krc_011_shin_ichigo_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Reboot_Rider_Items.SHIN_ICHIGO_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.shin_ichigo_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> V3Tab = CREATIVE_MODE_TABS.register("krc_020_v3_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Ichigo_Rider_Items.V3HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.v3_items")).build());
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> XTab = CREATIVE_MODE_TABS.register("krc_030_x_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Ichigo_Rider_Items.XHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.x_items")).build());
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> AMAZONTab = CREATIVE_MODE_TABS.register("krc_040_amazon_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Ichigo_Rider_Items.AMAZONHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.amazon_items")).build());
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> STRONGERTab = CREATIVE_MODE_TABS.register("krc_050_stronger_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Ichigo_Rider_Items.STRONGERHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.stronger_items")).build());
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> SKYRIDERTab = CREATIVE_MODE_TABS.register("krc_060_skyrider_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Ichigo_Rider_Items.SKYRIDERHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.skyrider_items")).build());
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> SUPER1Tab = CREATIVE_MODE_TABS.register("krc_070_super_1_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Ichigo_Rider_Items.SUPER1HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.super_1_items")).build());
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> ZXTab = CREATIVE_MODE_TABS.register("krc_090_zx_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Ichigo_Rider_Items.ZXHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.zx_items")).build());
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> BLACKTab = CREATIVE_MODE_TABS.register("krc_100_black_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Ichigo_Rider_Items.BLACKHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.black_items")).build());
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> RXTab = CREATIVE_MODE_TABS.register("krc_101_rx_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Ichigo_Rider_Items.RXHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.rx_items")).build());
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> SHINTab = CREATIVE_MODE_TABS.register("krc_110_shin_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Ichigo_Rider_Items.SHINHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.shin_items")).build());
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> ZOTab = CREATIVE_MODE_TABS.register("krc_120_zo_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Ichigo_Rider_Items.ZOHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.zo_items")).build());
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> JTab = CREATIVE_MODE_TABS.register("krc_130_j_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Ichigo_Rider_Items.JHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.j_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> KuugaTab = CREATIVE_MODE_TABS.register("krc_210_kuuga_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Kuuga_Rider_Items.KUUGAHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_kuuga_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.kuuga_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> AgitoTab = CREATIVE_MODE_TABS.register("krc_220_agito_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Agito_Rider_Items.AGITOHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_agito_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.agito_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> RyukiTab = CREATIVE_MODE_TABS.register("krc_230_ryuki_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Ryuki_Rider_Items.RYUKIHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_ryuki_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.ryuki_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> FaizTab = CREATIVE_MODE_TABS.register("krc_240_faiz_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Faiz_Rider_Items.FAIZHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_faiz_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.faiz_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab>  BladeTab = CREATIVE_MODE_TABS.register("krc_250_blade_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Blade_Rider_Items.BLADEHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_blade_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.blade_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab>  HibikiTab = CREATIVE_MODE_TABS.register("krc_260_hibiki_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Hibiki_Rider_Items.HIBIKIHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_hibiki_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.hibiki_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab>  KabutoTab = CREATIVE_MODE_TABS.register("krc_270_kabuto_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Kabuto_Rider_Items.KABUTOHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_kabuto_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.kabuto_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab>  DenOTab = CREATIVE_MODE_TABS.register("krc_280_den_o_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Den_O_Rider_Items.DEN_OHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_den_o_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.den_o_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab>  KivaTab = CREATIVE_MODE_TABS.register("krc_290_kiva_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Kiva_Rider_Items.KIVAHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_kiva_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.kiva_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab>  DecadeTab = CREATIVE_MODE_TABS.register("krc_300_decade_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Decade_Rider_Items.DECADEHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_decade_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.decade_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab>  WTab = CREATIVE_MODE_TABS.register("krc_310_w_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(W_Rider_Items.WHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_w_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.w_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> OOOTab = CREATIVE_MODE_TABS.register("krc_320_ooo_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(OOO_Rider_Items.OOOHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_ooo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.ooo_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> FOURZETab = CREATIVE_MODE_TABS.register("krc_330_fourze_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Fourze_Rider_Items.FOURZE_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_fourze_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.fourze_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> WIZARDTab = CREATIVE_MODE_TABS.register("krc_340_wizard_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Wizard_Rider_Items.WIZARD_HEAD.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_wizard_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.wizard_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> GAIMTab = CREATIVE_MODE_TABS.register("krc_350_gaim_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Gaim_Rider_Items.GAIM_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_gaim_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.gaim_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> DRIVETab = CREATIVE_MODE_TABS.register("krc_360_drive_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Drive_Rider_Items.DRIVE_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_drive_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.drive_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> GHOSTTab = CREATIVE_MODE_TABS.register("krc_370_ghost_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Ghost_Rider_Items.GHOST_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_ghost_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.ghost_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> EX_AIDTab = CREATIVE_MODE_TABS.register("krc_380_exaid_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Ex_Aid_Rider_Items.EX_AIDHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_ex_aid_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.ex_aid_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> BUILDTab = CREATIVE_MODE_TABS.register("krc_390_build_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Build_Rider_Items.BUILD_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_build_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.build_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> ZI_OTab = CREATIVE_MODE_TABS.register("krc_400_zi_o_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Zi_O_Rider_Items.ZI_O_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_zi_o_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.zi_o_items")).build());


    public static DeferredHolder<CreativeModeTab, CreativeModeTab> Zero_OneTab = CREATIVE_MODE_TABS.register("krc_410_zero_one_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Zero_One_Rider_Items.ZERO_ONE_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_zero_one_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.zero_one_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> SABERTab = CREATIVE_MODE_TABS.register("krc_420_saber_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Saber_Rider_Items.SABER_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_saber_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.saber_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> ReviceTab = CREATIVE_MODE_TABS.register("krc_430_geats_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Revice_Rider_Items.REVICE_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_revice_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.revice_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> GeatsTab = CREATIVE_MODE_TABS.register("krc_440_geats_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Geats_Rider_Items.GEATS_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_geats_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.geats_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> GotchardTab = CREATIVE_MODE_TABS.register("krc_450_gotchard_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Gotchard_Rider_Items.GOTCHARD_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_gotchard_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.gotchard_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> GavvTab = CREATIVE_MODE_TABS.register("krc_460_gavv_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Gavv_Rider_Items.GAVV_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_gavv_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.gavv_items")).build());


    public static DeferredHolder<CreativeModeTab, CreativeModeTab> GTab = CREATIVE_MODE_TABS.register("krc_800_g_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Miscellaneous_Rider_Items.GHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_g_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.g_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> GoriderTab = CREATIVE_MODE_TABS.register("krc_810_gorider_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Miscellaneous_Rider_Items.AKARIDERHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_gorider_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.gorider_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> RideKamensTab = CREATIVE_MODE_TABS.register("krc_830_ride_kamens_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Miscellaneous_Rider_Items.RIDE_KAMENS_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_ride_kamens_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.ride_kamens_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> AMAZONSTab = CREATIVE_MODE_TABS.register("krc_041_amazons_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Reboot_Rider_Items.AMAZONSHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_amazons_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.amazons_items")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> BLACKSUNTab = CREATIVE_MODE_TABS.register("krc_102_black_sun_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Reboot_Rider_Items.BLACKSUNHELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/tab_black_sun_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.black_sun_items")).build());

    public static List<Item> ICHIGO_TAB_ITEM= new ArrayList<Item>();

    public static List<Item> V3_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> X_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> AMAZON_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> STRONGER_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> SKYRIDER_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> SUPER1_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> ZX_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> BLACK_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> RX_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> SHIN_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> ZO_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> J_TAB_ITEM= new ArrayList<Item>();

    public static List<Item> KUUGA_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> AGITO_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> RYUKI_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> FAIZ_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> BLADE_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> HIBIKI_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> KABUTO_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> DEN_O_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> KIVA_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> DECADE_TAB_ITEM= new ArrayList<Item>();

     public static List<Item> W_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> OOO_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> FOURZE_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> WIZARD_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> GAIM_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> DRIVE_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> EX_AID_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> GHOST_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> BUILD_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> ZI_O_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> ZERO_ONE_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> SABER_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> REVICE_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> GEATS_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> GOTCHARD_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> GAVV_TAB_ITEM= new ArrayList<Item>();

    public static List<Item> G_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> GORIDER_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> RIDE_KAMENS_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> AMAZONS_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> BLACK_SUN_TAB_ITEM= new ArrayList<Item>();
    public static List<Item> SHIN_ICHIGO_TAB_ITEM= new ArrayList<Item>();

    public static List<Block> RIDER_BLOCK= new ArrayList<Block>();
    public static List<Block> RIDER_DECOR= new ArrayList<Block>();


    public static List<Item> Misc_TAB_ITEM= new ArrayList<Item>();

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static void AddItemsToTabs(BuildCreativeModeTabContentsEvent event){

        if(event.getTab() == RiderTabs.IchigoTab.get()) {
            for (int i = 0; i < RiderTabs.ICHIGO_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.ICHIGO_TAB_ITEM.get(i));
            }

        }else   if(event.getTab() == RiderTabs.ShinIchigoTab.get()) {
            for (int i = 0; i < RiderTabs.SHIN_ICHIGO_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.SHIN_ICHIGO_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.V3Tab.get()) {
            for (int i = 0; i < RiderTabs.V3_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.V3_TAB_ITEM.get(i));
            }
        }else if(event.getTab() == RiderTabs.XTab.get()) {
            for (int i = 0; i < RiderTabs.X_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.X_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.AMAZONTab.get()) {
            for (int i = 0; i < RiderTabs.AMAZON_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.AMAZON_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.STRONGERTab.get()) {
            for (int i = 0; i < RiderTabs.STRONGER_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.STRONGER_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.SKYRIDERTab.get()) {
            for (int i = 0; i < RiderTabs.SKYRIDER_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.SKYRIDER_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.SUPER1Tab.get()) {
            for (int i = 0; i < RiderTabs.SUPER1_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.SUPER1_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.ZXTab.get()) {
            for (int i = 0; i < RiderTabs.ZX_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.ZX_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.BLACKTab.get()) {
            for (int i = 0; i < RiderTabs.BLACK_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.BLACK_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.RXTab.get()) {
            for (int i = 0; i < RiderTabs.RX_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.RX_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.SHINTab.get()) {
            for (int i = 0; i < RiderTabs.SHIN_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.SHIN_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.ZOTab.get()) {
            for (int i = 0; i < RiderTabs.ZO_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.ZO_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.JTab.get()) {
            for (int i = 0; i < RiderTabs.J_TAB_ITEM.size(); i++) {
                event.accept(RiderTabs.J_TAB_ITEM.get(i));
            }


        }else if(event.getTab() == RiderTabs.KuugaTab.get()) {
            for (int i = 0; i < RiderTabs.KUUGA_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.KUUGA_TAB_ITEM.get(i));
            }
         }else if(event.getTab() == RiderTabs.AgitoTab.get()) {
            for (int i = 0; i < RiderTabs.AGITO_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.AGITO_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.RyukiTab.get()) {
            for (int i = 0; i < RiderTabs.RYUKI_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.RYUKI_TAB_ITEM.get(i));
            }
        }else if(event.getTab() == RiderTabs.FaizTab.get()) {
            for (int i = 0; i < RiderTabs.FAIZ_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.FAIZ_TAB_ITEM.get(i));
            }
        }else if(event.getTab() == RiderTabs.BladeTab.get()) {
            for (int i = 0; i < RiderTabs.BLADE_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.BLADE_TAB_ITEM.get(i));
            }
        }else if(event.getTab() == RiderTabs.HibikiTab.get()) {
            for (int i = 0; i < RiderTabs.HIBIKI_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.HIBIKI_TAB_ITEM.get(i));
            }
        }else if(event.getTab() == RiderTabs.KabutoTab.get()) {
            for (int i = 0; i < RiderTabs.KABUTO_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.KABUTO_TAB_ITEM.get(i));
            }
        }else if(event.getTab() == RiderTabs.DenOTab.get()) {
            for (int i = 0; i < RiderTabs.DEN_O_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.DEN_O_TAB_ITEM.get(i));
            }
        }else if(event.getTab() == RiderTabs.KivaTab.get()) {
            for (int i = 0; i < RiderTabs.KIVA_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.KIVA_TAB_ITEM.get(i));
            }
        }else if(event.getTab() == RiderTabs.DecadeTab.get()) {
            for (int i = 0; i < RiderTabs.DECADE_TAB_ITEM.size(); i++) {
                event.accept(RiderTabs.DECADE_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.WTab.get()) {
            for (int i = 0; i < RiderTabs.W_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.W_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.OOOTab.get()) {
            for (int i = 0; i < RiderTabs.OOO_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.OOO_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.FOURZETab.get()) {
            for (int i = 0; i < RiderTabs.FOURZE_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.FOURZE_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.GHOSTTab.get()) {
            for (int i = 0; i < RiderTabs.GHOST_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.GHOST_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.EX_AIDTab.get()) {
            for (int i = 0; i < RiderTabs.EX_AID_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.EX_AID_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.WIZARDTab.get()) {
            for (int i = 0; i < RiderTabs.WIZARD_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.WIZARD_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.GAIMTab.get()) {
            for (int i = 0; i < RiderTabs.GAIM_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.GAIM_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.DRIVETab.get()) {
            for (int i = 0; i < RiderTabs.DRIVE_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.DRIVE_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.BUILDTab.get()) {
            for (int i = 0; i < RiderTabs.BUILD_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.BUILD_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.ZI_OTab.get()) {
            for (int i = 0; i < RiderTabs.ZI_O_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.ZI_O_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.Zero_OneTab.get()) {
            for (int i = 0; i < RiderTabs.ZERO_ONE_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.ZERO_ONE_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.SABERTab.get()) {
            for (int i = 0; i < RiderTabs.SABER_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.SABER_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.ReviceTab.get()) {
            for (int i = 0; i < RiderTabs.REVICE_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.REVICE_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.GeatsTab.get()) {
            for (int i = 0; i < RiderTabs.GEATS_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.GEATS_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.GotchardTab.get()) {
            for (int i = 0; i < RiderTabs.GOTCHARD_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.GOTCHARD_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.GavvTab.get()) {
            for (int i = 0; i < RiderTabs.GAVV_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.GAVV_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.AMAZONSTab.get()) {
            for (int i = 0; i < RiderTabs.AMAZONS_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.AMAZONS_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.BLACKSUNTab.get()) {
            for (int i = 0; i < RiderTabs.BLACK_SUN_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.BLACK_SUN_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.GTab.get()) {
            for (int i = 0; i < RiderTabs.G_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.G_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.GoriderTab.get()) {
            for (int i = 0; i < RiderTabs.GORIDER_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.GORIDER_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.RideKamensTab.get()) {
            for (int i = 0; i < RiderTabs.RIDE_KAMENS_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.RIDE_KAMENS_TAB_ITEM.get(i));
            }

        }else if(event.getTab() == RiderTabs.RiderblockTab.get()) {
            for (int i = 0; i < RiderTabs.RIDER_BLOCK.size(); i++)
            {
                event.accept( RiderTabs.RIDER_BLOCK.get(i));
            }
            event.accept(Rider_Blocks.RABBIT_HUTCH_DOOR);
           // event.accept(Rider_Blocks.BLUE_ROSE.get());

        }else if(event.getTab() == RiderTabs.RiderdecorTab.get()) {
            for (int i = 0; i < RiderTabs.RIDER_DECOR.size(); i++)
            {
                event.accept( RiderTabs.RIDER_DECOR.get(i));
            }
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

            event.accept(Rider_Blocks.DRIVE_PIT_LOGO);
            event.accept(Rider_Blocks.DRIVE_PIT_LADDER);
            event.accept(Rider_Blocks.WALLPLATE_GRATE);
            event.accept(Rider_Blocks.WHITE_WALLPLATE_STAIRS);
            event.accept(Rider_Blocks.WHITE_WALLPLATE_SLAB);
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
            event.accept(Rider_Blocks.YELLOW_WALLPLATE_GRATE_STAIRS);
            event.accept(Rider_Blocks.LIGHT_GREEN_WALLPLATE_GRATE_SLAB);


            event.accept(Rider_Blocks.GLASS_DOOR);


        }else if(event.getTab() == RiderTabs.RiderMiscTab.get()) {

            event.accept(MobsCore.SHOCKER_COMBATMAN_SPAWN_EGG);
            event.accept(MobsCore.SHOCKER_RIDER_SPAWN_EGG);

            event.accept(MobsCore.DESTRON_COMBATMAN_SPAWN_EGG);
            event.accept(MobsCore.GOD_WARFARE_AGENT_SPAWN_EGG);
            event.accept(MobsCore.RED_FOLLWER_SPAWN_EGG);
            event.accept(MobsCore.BLACK_SATAN_SOLDIER_SPAWN_EGG);
            event.accept(MobsCore.ARI_COMMANDO_SPAWN_EGG);
            event.accept(MobsCore.DOGMA_FIGHTER_SPAWN_EGG);
            event.accept(MobsCore.COMBAT_ROID_SPAWN_EGG);
            event.accept(MobsCore.CHAP_SPAWN_EGG);
            event.accept(MobsCore.CHAP_GREY_SPAWN_EGG);
            event.accept(MobsCore.SHADOWMOON_SPAWN_EGG);

            event.accept(MobsCore.ZU_GUMUN_BA_SPAWN_EGG);

            event.accept(MobsCore.PANTHERAS_LUTEUS_SPAWN_EGG);
            event.accept(MobsCore.EL_OF_THE_WATER_SPAWN_EGG);
            event.accept(MobsCore.ANGUIS_MASCULUS_SPAWN_EGG);
            event.accept(MobsCore.ANOTHER_AGITO_SPAWN_EGG);

            event.accept(MobsCore.RIOTROOPER_SPAWN_EGG);
            event.accept(MobsCore.ORGA_SPAWN_EGG);
            event.accept(MobsCore.MUEZ_SPAWN_EGG);

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

            event.accept(MobsCore.MASQUERADE_SPAWN_EGG);
            event.accept(MobsCore.CLAYDOLL_DOPANT_SPAWN_EGG);
            event.accept(MobsCore.TERROR_DOPANT_SPAWN_EGG);
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
            event.accept(MobsCore.MUCHIRI_SPAWN_EGG);
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

            event.accept(MobsCore.ROIDMUDE_SPAWN_EGG);
            event.accept(MobsCore.MASHIN_CHASER_SPAWN_EGG);
            event.accept(MobsCore.HEART_ROIDMUDE_SPAWN_EGG);
            event.accept(MobsCore.BRAIN_ROIDMUDE_SPAWN_EGG);
            event.accept(MobsCore.REAPER_LEGION_SPAWN_EGG);
            event.accept(MobsCore.MEDIC_ROIDMUDE_SPAWN_EGG);
            event.accept(MobsCore.GORD_DRIVE_SPAWN_EGG);
            event.accept(MobsCore.DARK_DRIVE_SPAWN_EGG);

            event.accept(MobsCore.GAMMA_COMMANDO_SPAWN_EGG);

            event.accept(MobsCore.BUGSTERVIRUS_SPAWN_EGG);
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

            event.accept(MobsCore.GINGA_SPAWN_EGG);
            event.accept(MobsCore.WOZ_SPAWN_EGG);

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

            event.accept(MobsCore.PAWN_JYAMATO_SPAWN_EGG);
            event.accept(MobsCore.JYAMATO_RIDER_SPAWN_EGG);
            event.accept(MobsCore.GM_RIDER_SPAWN_EGG);

            event.accept(MobsCore.AGENT_SPAWN_EGG);

            event.accept(MobsCore.MACEHINE_TORADOR_SPAWN_EGG);
            event.accept(MobsCore.HARDBOILER_SPAWN_EGG);
            event.accept(MobsCore.SKULLBOILER_SPAWN_EGG);
            event.accept(MobsCore.BIKE_GAMER_SPAWN_EGG);

            for (int i = 0; i < RiderTabs.Misc_TAB_ITEM.size(); i++)
            {
                event.accept( RiderTabs.Misc_TAB_ITEM.get(i));
            }
            event.accept(Modded_item_core.LETS_GO_RIDER_MUSIC_DISC);
            event.accept(Modded_item_core.TATAKAE_KAMEN_RIDER_V3_MUSIC_DISC);
            event.accept(Modded_item_core.DRAGON_ROAD_MUSIC_DISC);
            event.accept(Modded_item_core.KAMEN_RIDER_BLACK_MUSIC_DISC);
            event.accept(Modded_item_core.KAMEN_RIDER_BLACK_RX_MUSIC_DISC);
            event.accept(Modded_item_core.KAMEN_RIDER_KUUGA_MUSIC_DISC);
            event.accept(Modded_item_core.KAMEN_RIDER_AGITO_MUSIC_DISC);
            event.accept(Modded_item_core.ALIVE_A_LIFE_MUSIC_DISC);
            event.accept(Modded_item_core.JUSTIFAIZ_MUSIC_DISC);
            event.accept(Modded_item_core.REBIRTH_MUSIC_DISC);
            event.accept(Modded_item_core.NEXT_LEVEL_MUSIC_DISC);
            event.accept(Modded_item_core.JOURNEY_THROUGH_THE_DECADE_MUSIC_DISC);
            event.accept(Modded_item_core.WBX_MUSIC_DISC);
            event.accept(Modded_item_core.ANYTHING_GOES_MUSIC_DISC);
            event.accept(Modded_item_core.JUST_LIVE_MORE_MUSIC_DISC);
            event.accept(Modded_item_core.SURPRISE_DRIVE_MUSIC_DISC);
            event.accept(Modded_item_core.EXCITE_KEY_MUSIC_DISC);
            event.accept(Modded_item_core.BE_THE_ONE_MUSIC_DISC);
            event.accept(Modded_item_core.OVER_QUARTZER_MUSIC_DISC);
            event.accept(Modded_item_core.REAL_X_EYEZ_MUSIC_DISC);
            event.accept(Modded_item_core.ALMIGHTY_MUSIC_DISC);
            event.accept(Modded_item_core.CHEMY_X_STORY_MUSIC_DISC);
            event.accept(Modded_item_core.CHEMY_X_STORY_FLOW_MUSIC_DISC);
            event.accept(Modded_item_core.GOT_BOOST_MUSIC_DISC);

            event.accept(Modded_item_core.MASKED_RIDER_MUSIC_DISC);
        }



    }

}