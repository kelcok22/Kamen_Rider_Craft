package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.block.RiderBlocks;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.item.extra_riders.ExtraRiderItems;
import com.kelco.kamenridercraft.item.extra_riders.GRiderItems;
import com.kelco.kamenridercraft.item.extra_riders.GoriderItems;
import com.kelco.kamenridercraft.item.extra_riders.RideKamensItems;
import com.kelco.kamenridercraft.item.heisei_phase_1.*;
import com.kelco.kamenridercraft.item.heisei_phase_2.*;
import com.kelco.kamenridercraft.item.misc_items.MusicDiscItems;
import com.kelco.kamenridercraft.item.reboots.AmazonsRiderItems;
import com.kelco.kamenridercraft.item.reboots.BlackSunRiderItems;
import com.kelco.kamenridercraft.item.reboots.ShinIchigoRiderItems;
import com.kelco.kamenridercraft.item.reboots.TheSeriesRiderItems;
import com.kelco.kamenridercraft.item.reiwa.*;
import com.kelco.kamenridercraft.item.showa.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.MOD_ID;

public class KRCCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RiderEggTab = CREATIVE_MODE_TABS.register("krc_996_egg_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(MobsCore.SHOCKER_RIDER_SPAWN_EGG.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.egg_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RiderMiscTab = CREATIVE_MODE_TABS.register("krc_997_misc_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModdedItemCore.RIDER_CIRCUIT.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.misc_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RiderblockTab = CREATIVE_MODE_TABS.register("krc_998_blocks_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(RiderBlocks.MONITOR.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.rider_blocks")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RiderdecorTab = CREATIVE_MODE_TABS.register("krc_999_blocks_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(RiderBlocks.PLANKS_LIGHT_BLUE.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.rider_blocks_decor")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> IchigoTab = CREATIVE_MODE_TABS.register("krc_010_ichigo_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(IchigoRiderItems.ICHIGOHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.ichigo_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TheIchigoTab = CREATIVE_MODE_TABS.register("krc_011_the_ichigo_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(TheSeriesRiderItems.THE_ICHIGO_HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.the_ichigo_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ShinIchigoTab = CREATIVE_MODE_TABS.register("krc_012_shin_ichigo_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ShinIchigoRiderItems.SHIN_ICHIGO_HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.shin_ichigo_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> V3Tab = CREATIVE_MODE_TABS.register("krc_020_v3_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(V3RiderItems.V3HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.v3_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> XTab = CREATIVE_MODE_TABS.register("krc_030_x_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(XRiderItems.XHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.x_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> AMAZONTab = CREATIVE_MODE_TABS.register("krc_040_amazon_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(AmazonRiderItems.AMAZONHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.amazon_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> STRONGERTab = CREATIVE_MODE_TABS.register("krc_050_stronger_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(StrongerRiderItems.STRONGERHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.stronger_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SKYRIDERTab = CREATIVE_MODE_TABS.register("krc_060_skyrider_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(SkyriderItems.SKYRIDERHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.skyrider_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SUPER1Tab = CREATIVE_MODE_TABS.register("krc_070_super_1_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Super1RiderItems.SUPER1HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.super_1_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ZXTab = CREATIVE_MODE_TABS.register("krc_090_zx_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ZXRiderItems.ZXHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.zx_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BLACKTab = CREATIVE_MODE_TABS.register("krc_100_black_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(BlackRiderItems.BLACKHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.black_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RXTab = CREATIVE_MODE_TABS.register("krc_101_rx_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(BlackRXRiderItems.RXHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.rx_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SHINTab = CREATIVE_MODE_TABS.register("krc_110_shin_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ShinRiderItems.SHINHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.shin_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ZOTab = CREATIVE_MODE_TABS.register("krc_120_zo_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ZORiderItems.ZOHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.zo_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> JTab = CREATIVE_MODE_TABS.register("krc_130_j_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(JRiderItems.JHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.j_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> KuugaTab = CREATIVE_MODE_TABS.register("krc_210_kuuga_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(KuugaRiderItems.KUUGAHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_kuuga_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.kuuga_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> AgitoTab = CREATIVE_MODE_TABS.register("krc_220_agito_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(AgitoRiderItems.AGITOHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_agito_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.agito_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RyukiTab = CREATIVE_MODE_TABS.register("krc_230_ryuki_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(RyukiRiderItems.RYUKIHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_ryuki_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.ryuki_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FaizTab = CREATIVE_MODE_TABS.register("krc_240_faiz_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(FaizRiderItems.FAIZHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_faiz_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.faiz_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BladeTab = CREATIVE_MODE_TABS.register("krc_250_blade_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(BladeRiderItems.BLADEHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_blade_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.blade_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HibikiTab = CREATIVE_MODE_TABS.register("krc_260_hibiki_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(HibikiRiderItems.HIBIKIHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_hibiki_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.hibiki_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> KabutoTab = CREATIVE_MODE_TABS.register("krc_270_kabuto_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(KabutoRiderItems.KABUTOHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_kabuto_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.kabuto_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> DenOTab = CREATIVE_MODE_TABS.register("krc_280_den_o_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(DenORiderItems.DEN_OHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_den_o_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.den_o_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> KivaTab = CREATIVE_MODE_TABS.register("krc_290_kiva_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(KivaRiderItems.KIVAHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_kiva_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.kiva_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> DecadeTab = CREATIVE_MODE_TABS.register("krc_300_decade_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(DecadeRiderItems.DECADEHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_decade_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.decade_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WTab = CREATIVE_MODE_TABS.register("krc_310_w_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(WRiderItems.WHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_w_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.w_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> OOOTab = CREATIVE_MODE_TABS.register("krc_320_ooo_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(OOORiderItems.OOOHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_ooo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.ooo_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FOURZETab = CREATIVE_MODE_TABS.register("krc_330_fourze_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(FourzeRiderItems.FOURZE_HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_fourze_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.fourze_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WIZARDTab = CREATIVE_MODE_TABS.register("krc_340_wizard_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(WizardRiderItems.WIZARD_HEAD.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_wizard_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.wizard_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GAIMTab = CREATIVE_MODE_TABS.register("krc_350_gaim_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(GaimRiderItems.GAIM_HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_gaim_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.gaim_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> DRIVETab = CREATIVE_MODE_TABS.register("krc_360_drive_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(DriveRiderItems.DRIVE_HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_drive_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.drive_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GHOSTTab = CREATIVE_MODE_TABS.register("krc_370_ghost_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(GhostRiderItems.GHOST_HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_ghost_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.ghost_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EX_AIDTab = CREATIVE_MODE_TABS.register("krc_380_exaid_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ExAidRiderItems.EX_AIDHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_ex_aid_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.ex_aid_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BUILDTab = CREATIVE_MODE_TABS.register("krc_390_build_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(BuildRiderItems.BUILD_HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_build_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.build_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ZI_OTab = CREATIVE_MODE_TABS.register("krc_400_zi_o_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ZiORiderItems.ZI_O_HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_zi_o_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.zi_o_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> Zero_OneTab = CREATIVE_MODE_TABS.register("krc_410_zero_one_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ZeroOneRiderItems.ZERO_ONE_HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_zero_one_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.zero_one_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SABERTab = CREATIVE_MODE_TABS.register("krc_420_saber_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(SaberRiderItems.SABER_HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_saber_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.saber_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ReviceTab = CREATIVE_MODE_TABS.register("krc_430_geats_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ReviceRiderItems.REVICE_HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_revice_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.revice_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GeatsTab = CREATIVE_MODE_TABS.register("krc_440_geats_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(GeatsRiderItems.GEATS_HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_geats_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.geats_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GotchardTab = CREATIVE_MODE_TABS.register("krc_450_gotchard_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(GotchardRiderItems.GOTCHARD_HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_gotchard_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.gotchard_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GavvTab = CREATIVE_MODE_TABS.register("krc_460_gavv_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(GavvRiderItems.GAVV_HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_gavv_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.gavv_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ZeztzTab = CREATIVE_MODE_TABS.register("krc_470_zeztz_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ZeztzRiderItems.ZEZTZ_HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_zeztz_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.zeztz_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> My_thTab = CREATIVE_MODE_TABS.register("krc_480_my_th_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(MyThRiderItems.MY_TH_HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.my_th_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GTab = CREATIVE_MODE_TABS.register("krc_800_g_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(GRiderItems.GHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_g_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.g_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GoriderTab = CREATIVE_MODE_TABS.register("krc_810_gorider_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(GoriderItems.AKARIDERHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_gorider_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.gorider_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RideKamensTab = CREATIVE_MODE_TABS.register("krc_830_ride_kamens_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(RideKamensItems.RIDE_KAMENS_HELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_ride_kamens_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.ride_kamens_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> AMAZONSTab = CREATIVE_MODE_TABS.register("krc_041_amazons_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(AmazonsRiderItems.AMAZONSHELMET.get()))
                    .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_amazons_items.png"))
                    .title(Component.translatable("tab.kamenridercraft.amazons_items")).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BLACKSUNTab = CREATIVE_MODE_TABS.register("krc_102_black_sun_tab", ()
            -> CreativeModeTab.builder().icon(() -> new ItemStack(BlackSunRiderItems.BLACKSUNHELMET.get()))
            .backgroundTexture(ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/tab_black_sun_items.png"))
            .title(Component.translatable("tab.kamenridercraft.black_sun_items")).build());


    public static final List<Item> ICHIGO_TAB_ITEM = new ArrayList<>();
    public static final List<Item> THE_TAB_ITEM = new ArrayList<>();

    public static final List<Item> V3_TAB_ITEM = new ArrayList<>();
    public static final List<Item> X_TAB_ITEM = new ArrayList<>();
    public static final List<Item> AMAZON_TAB_ITEM = new ArrayList<>();
    public static final List<Item> STRONGER_TAB_ITEM = new ArrayList<>();
    public static final List<Item> SKYRIDER_TAB_ITEM = new ArrayList<>();
    public static final List<Item> SUPER1_TAB_ITEM = new ArrayList<>();
    public static final List<Item> ZX_TAB_ITEM = new ArrayList<>();
    public static final List<Item> BLACK_TAB_ITEM = new ArrayList<>();
    public static final List<Item> RX_TAB_ITEM = new ArrayList<>();
    public static final List<Item> SHIN_TAB_ITEM = new ArrayList<>();
    public static final List<Item> ZO_TAB_ITEM = new ArrayList<>();
    public static final List<Item> J_TAB_ITEM = new ArrayList<>();

    public static final List<Item> KUUGA_TAB_ITEM = new ArrayList<>();
    public static final List<Item> AGITO_TAB_ITEM = new ArrayList<>();
    public static final List<Item> RYUKI_TAB_ITEM = new ArrayList<>();
    public static final List<Item> FAIZ_TAB_ITEM = new ArrayList<>();
    public static final List<Item> BLADE_TAB_ITEM = new ArrayList<>();
    public static final List<Item> HIBIKI_TAB_ITEM = new ArrayList<>();
    public static final List<Item> KABUTO_TAB_ITEM = new ArrayList<>();
    public static final List<Item> DEN_O_TAB_ITEM = new ArrayList<>();
    public static final List<Item> KIVA_TAB_ITEM = new ArrayList<>();
    public static final List<Item> DECADE_TAB_ITEM = new ArrayList<>();

    public static final List<Item> W_TAB_ITEM = new ArrayList<>();
    public static final List<Item> OOO_TAB_ITEM = new ArrayList<>();
    public static final List<Item> FOURZE_TAB_ITEM = new ArrayList<>();
    public static final List<Item> WIZARD_TAB_ITEM = new ArrayList<>();
    public static final List<Item> GAIM_TAB_ITEM = new ArrayList<>();
    public static final List<Item> DRIVE_TAB_ITEM = new ArrayList<>();
    public static final List<Item> EX_AID_TAB_ITEM = new ArrayList<>();
    public static final List<Item> GHOST_TAB_ITEM = new ArrayList<>();
    public static final List<Item> BUILD_TAB_ITEM = new ArrayList<>();
    public static final List<Item> ZI_O_TAB_ITEM = new ArrayList<>();
    public static final List<Item> ZERO_ONE_TAB_ITEM = new ArrayList<>();
    public static final List<Item> SABER_TAB_ITEM = new ArrayList<>();
    public static final List<Item> REVICE_TAB_ITEM = new ArrayList<>();
    public static final List<Item> GEATS_TAB_ITEM = new ArrayList<>();
    public static final List<Item> GOTCHARD_TAB_ITEM = new ArrayList<>();
    public static final List<Item> GAVV_TAB_ITEM = new ArrayList<>();
    public static final List<Item> ZEZTZ_TAB_ITEM = new ArrayList<>();
    public static final List<Item> MY_TH_TAB_ITEM = new ArrayList<>();

    public static final List<Item> G_TAB_ITEM = new ArrayList<>();
    public static final List<Item> GORIDER_TAB_ITEM = new ArrayList<>();
    public static final List<Item> RIDE_KAMENS_TAB_ITEM = new ArrayList<>();
    public static final List<Item> AMAZONS_TAB_ITEM = new ArrayList<>();
    public static final List<Item> BLACK_SUN_TAB_ITEM = new ArrayList<>();
    public static final List<Item> SHIN_ICHIGO_TAB_ITEM = new ArrayList<>();

    public static final List<Block> RIDER_BLOCK = new ArrayList<>();
    public static final List<Block> RIDER_DECOR = new ArrayList<>();


    public static final List<Item> MISC_TAB_ITEMS = new ArrayList<>();

    public static void addItemsToTabs(BuildCreativeModeTabContentsEvent event) {

        if (event.getTab() == IchigoTab.get()) {
            for (int i = 0; i < ICHIGO_TAB_ITEM.size(); ++i) {
                event.accept(ICHIGO_TAB_ITEM.get(i));
            }
            event.accept(ModdedItemCore.RIDER_CIRCUIT);
            event.accept(ModdedItemCore.CYCLONEHOPPER);
            event.accept(ExtraRiderItems.ICHIGO_MASK);
            event.accept(ModdedItemCore.SINISTER_PACHINKO_BALL);
            event.accept(ModdedItemCore.TAKOYAKI);
            event.accept(ExtraRiderItems.TOJIMA_TAKOYAKI);
            event.accept(MusicDiscItems.LETS_GO_RIDER_MUSIC_DISC);
            event.accept(MobsCore.SHOCKER_COMBATMAN_SPAWN_EGG);
            event.accept(MobsCore.SHOCKER_RIDER_SPAWN_EGG);
            event.accept(RiderBlocks.ICHIGO_CHAIR);
            event.accept(RiderBlocks.RED_ICHIGO_CHAIR);
            event.accept(RiderBlocks.SHOCKER_LOGO);
            event.accept(RiderBlocks.SHOCKER_MONITOR);

        } else if (event.getTab() == TheIchigoTab.get()) {
            for (int i = 0; i < THE_TAB_ITEM.size(); ++i) {
                event.accept(THE_TAB_ITEM.get(i));
            }

        } else if (event.getTab() == ShinIchigoTab.get()) {
            for (int i = 0; i < SHIN_ICHIGO_TAB_ITEM.size(); ++i) {
                event.accept(SHIN_ICHIGO_TAB_ITEM.get(i));
            }
            event.accept(MobsCore.BATTA_AUGMENT_SPAWN_EGG);
            event.accept(MobsCore.SHIN_NO_0_SPAWN_EGG);

        } else if (event.getTab() == V3Tab.get()) {
            for (int i = 0; i < V3_TAB_ITEM.size(); ++i) {
                event.accept(V3_TAB_ITEM.get(i));
            }
            event.accept(ModdedItemCore.FLARESALAMANDER);
            event.accept(ModdedItemCore.FLARESALAMANDER_SWORD);
            event.accept(ExtraRiderItems.V3_MASK);
            event.accept(ExtraRiderItems.RIDERMAN_HELMET);
            event.accept(MusicDiscItems.TATAKAE_KAMEN_RIDER_V3_MUSIC_DISC);
            event.accept(MobsCore.DESTRON_COMBATMAN_SPAWN_EGG);

        } else if (event.getTab() == XTab.get()) {
            for (int i = 0; i < X_TAB_ITEM.size(); ++i) {
                event.accept(X_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.SET_UP_KAMEN_RIDER_X_MUSIC_DISC);
            event.accept(MobsCore.GOD_WARFARE_AGENT_SPAWN_EGG);
            event.accept(MobsCore.APOLLOGEIST_SPAWN_EGG);

        } else if (event.getTab() == AMAZONTab.get()) {
            for (int i = 0; i < AMAZON_TAB_ITEM.size(); ++i) {
                event.accept(AMAZON_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.AMAZON_RIDER_KOKO_NI_ARI_MUSIC_DISC);
            event.accept(MobsCore.RED_FOLLWER_SPAWN_EGG);

        } else if (event.getTab() == STRONGERTab.get()) {
            for (int i = 0; i < STRONGER_TAB_ITEM.size(); ++i) {
                event.accept(STRONGER_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.KAMEN_RIDER_STRONGER_NO_UTA_MUSIC_DISC);
            event.accept(MobsCore.BLACK_SATAN_SOLDIER_SPAWN_EGG);
            event.accept(MobsCore.GENERAL_SHADOW_SPAWN_EGG);


        } else if (event.getTab() == SKYRIDERTab.get()) {
            for (int i = 0; i < SKYRIDER_TAB_ITEM.size(); ++i) {
                event.accept(SKYRIDER_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.MOERO_KAMEN_RIDER_MUSIC_DISC);
            event.accept(MobsCore.ARI_COMMANDO_SPAWN_EGG);

        } else if (event.getTab() == SUPER1Tab.get()) {
            for (int i = 0; i < SUPER1_TAB_ITEM.size(); ++i) {
                event.accept(SUPER1_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.KAMEN_RIDER_SUPER_1_MUSIC_DISC);
            event.accept(MobsCore.DOGMA_FIGHTER_SPAWN_EGG);

        } else if (event.getTab() == ZXTab.get()) {
            for (int i = 0; i < ZX_TAB_ITEM.size(); ++i) {
                event.accept(ZX_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.DRAGON_ROAD_MUSIC_DISC);
            event.accept(MobsCore.COMBAT_ROID_SPAWN_EGG);

        } else if (event.getTab() == BLACKTab.get()) {
            for (int i = 0; i < BLACK_TAB_ITEM.size(); ++i) {
                event.accept(BLACK_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.KAMEN_RIDER_BLACK_MUSIC_DISC);
            event.accept(MobsCore.CHAP_SPAWN_EGG);
            event.accept(MobsCore.SHADOWMOON_SPAWN_EGG);

        } else if (event.getTab() == RXTab.get()) {
            for (int i = 0; i < RX_TAB_ITEM.size(); ++i) {
                event.accept(RX_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.KAMEN_RIDER_BLACK_RX_MUSIC_DISC);
            event.accept(MusicDiscItems.MASKED_RIDER_MUSIC_DISC);
            event.accept(MobsCore.ACROBATTER_SPAWN_EGG);
            event.accept(MobsCore.RIDORON_SPAWN_EGG);
            event.accept(MobsCore.CHAP_GREY_SPAWN_EGG);
            event.accept(RiderBlocks.FERBUS);

        } else if (event.getTab() == SHINTab.get()) {
            for (int i = 0; i < SHIN_TAB_ITEM.size(); ++i) {
                event.accept(SHIN_TAB_ITEM.get(i));
            }

        } else if (event.getTab() == ZOTab.get()) {
            for (int i = 0; i < ZO_TAB_ITEM.size(); ++i) {
                event.accept(ZO_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.AI_GA_TOMARANAI_MUSIC_DISC);

        } else if (event.getTab() == JTab.get()) {
            for (int i = 0; i < J_TAB_ITEM.size(); ++i) {
                event.accept(J_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.KOKORO_TSUNAGU_AI_MUSIC_DISC);

        } else if (event.getTab() == KuugaTab.get()) {
            for (int i = 0; i < KUUGA_TAB_ITEM.size(); ++i) {
                event.accept(KUUGA_TAB_ITEM.get(i));
            }
            event.accept(ModdedItemCore.GRANDGOURAM);
            event.accept(ModdedItemCore.GRANDGOURAM_ROD);
            event.accept(ModdedItemCore.JINRAI_NO_SENSHI);
            event.accept(MusicDiscItems.KAMEN_RIDER_KUUGA_MUSIC_DISC);
            event.accept(MobsCore.ZU_GUMUN_BA_SPAWN_EGG);
            event.accept(MobsCore.GO_CLASS_GRONGI_SPAWN_EGG);
            event.accept(MobsCore.N_DAGUVA_ZEBA_SPAWN_EGG);
            event.accept(RiderBlocks.N_DAGUVA_ZEBA_BOSS_BLOCK);
            event.accept(RiderBlocks.KUUGA_TOMB);
            event.accept(RiderBlocks.KUUGA_ORE);
            event.accept(RiderBlocks.DEEPSLATE_KUUGA_ORE);

        } else if (event.getTab() == AgitoTab.get()) {
            for (int i = 0; i < AGITO_TAB_ITEM.size(); ++i) {
                event.accept(AGITO_TAB_ITEM.get(i));
            }
            event.accept(ModdedItemCore.STAGTORNADOR);
            event.accept(ModdedItemCore.LEATHERAIDER);
            event.accept(MusicDiscItems.KAMEN_RIDER_AGITO_MUSIC_DISC);
            event.accept(MobsCore.MACEHINE_TORADOR_SPAWN_EGG);
            event.accept(MobsCore.PANTHERAS_LUTEUS_SPAWN_EGG);
            event.accept(MobsCore.EL_OF_THE_WATER_SPAWN_EGG);
            event.accept(MobsCore.ANGUIS_MASCULUS_SPAWN_EGG);
            event.accept(MobsCore.ANOTHER_AGITO_SPAWN_EGG);
            event.accept(RiderBlocks.G_SYSTEM_CHIP_PROGRAMMER);

        } else if (event.getTab() == RyukiTab.get()) {
            for (int i = 0; i < RYUKI_TAB_ITEM.size(); ++i) {
                event.accept(RYUKI_TAB_ITEM.get(i));
            }
            event.accept(ModdedItemCore.DRAGREDER);
            event.accept(ModdedItemCore.DRAGRANZER);
            event.accept(ModdedItemCore.BAKUEN_NO_SENSHI);
            event.accept(ModdedItemCore.DARKWING);
            event.accept(ModdedItemCore.DARKWING_SWORD);
            event.accept(MusicDiscItems.ALIVE_A_LIFE_MUSIC_DISC);
            event.accept(MobsCore.MIRROR_RIDER_SPAWN_EGG);
            event.accept(MobsCore.ODIN_SPAWN_EGG);
            event.accept(RiderBlocks.ODIN_BOSS_BLOCK);
            event.accept(RiderBlocks.GLASS_RYUKI);
            event.accept(RiderBlocks.DEEPSLATE_GLASS_RYUKI);

        } else if (event.getTab() == FaizTab.get()) {
            for (int i = 0; i < FAIZ_TAB_ITEM.size(); ++i) {
                event.accept(FAIZ_TAB_ITEM.get(i));
            }
            event.accept(ModdedItemCore.GREYWOLCH);
            event.accept(ModdedItemCore.BAKUEN_NO_SENSHI);
            event.accept(ModdedItemCore.CHAOSDILE);
            event.accept(ModdedItemCore.TRANSFORM_ONE_SHOT);
            event.accept(MusicDiscItems.JUSTIFAIZ_MUSIC_DISC);
            event.accept(MobsCore.AUTO_VAJIN_SPAWN_EGG);
            event.accept(MobsCore.RIOTROOPER_SPAWN_EGG);
            event.accept(MobsCore.ORGA_SPAWN_EGG);
            event.accept(MobsCore.MUEZ_SPAWN_EGG);
            event.accept(MobsCore.FAIZ_SPAWN_EGG);
            event.accept(RiderBlocks.FAIZ_BOSS_BLOCK);

        } else if (event.getTab() == BladeTab.get()) {
            for (int i = 0; i < BLADE_TAB_ITEM.size(); ++i) {
                event.accept(BLADE_TAB_ITEM.get(i));
            }
            event.accept(ModdedItemCore.HERCULESPADER);
            event.accept(ModdedItemCore.HERCULESPADER_SWORD);
            event.accept(ModdedItemCore.SHADOWMANTIS);
            event.accept(ModdedItemCore.JINRAI_NO_SENSHI);
            event.accept(ModdedItemCore.TAIYAKI);
            event.accept(ModdedItemCore.MILK_BOTTLE);
            event.accept(ModdedItemCore.PUZZLE_PIECE);
            event.accept(MusicDiscItems.ROUND_ZERO_BLADE_BRAVE_MUSIC_DISC);
            event.accept(MusicDiscItems.ELEMENTS_MUSIC_DISC);
            event.accept(MusicDiscItems.REBIRTH_MUSIC_DISC);
            for (int i = 0; i < KRCItemLists.BLADE_SPAWN_EGG.size(); ++i) {
                event.accept(KRCItemLists.BLADE_SPAWN_EGG.get(i));
            }
            event.accept(RiderBlocks.BLADE_ORE);
            event.accept(RiderBlocks.DEEPSLATE_BLADE_ORE);

        } else if (event.getTab() == HibikiTab.get()) {
            for (int i = 0; i < HIBIKI_TAB_ITEM.size(); ++i) {
                event.accept(HIBIKI_TAB_ITEM.get(i));
            }
            event.accept(ModdedItemCore.AKANETAKA);
            event.accept(ModdedItemCore.BAKUEN_NO_SENSHI);
            event.accept(MusicDiscItems.KAGAYAKI_MUSIC_DISC);
            event.accept(MusicDiscItems.HAJIMARI_NO_KIMI_E_MUSIC_DISC);
            event.accept(MobsCore.BAKENEKO_SPAWN_EGG);
            event.accept(MobsCore.MIDAREDOUJI_SPAWN_EGG);
            event.accept(MobsCore.MAKAMOU_NINJA_GROUP_SPAWN_EGG);
            event.accept(MobsCore.KABUKI_SPAWN_EGG);
            event.accept(RiderBlocks.HIBIKI_ORE);
            event.accept(RiderBlocks.DEEPSLATE_HIBIKI_ORE);

        } else if (event.getTab() == KabutoTab.get()) {
            for (int i = 0; i < KABUTO_TAB_ITEM.size(); ++i) {
                event.accept(KABUTO_TAB_ITEM.get(i));
            }
            event.accept(ModdedItemCore.EXBEETER);
            event.accept(ModdedItemCore.JINRAI_NO_SENSHI);
            event.accept(ModdedItemCore.SCISSORBEETER);
            event.accept(MusicDiscItems.NEXT_LEVEL_MUSIC_DISC);
            event.accept(MobsCore.ZECTROOPER_SPAWN_EGG);
            event.accept(MobsCore.SHADOW_TROOPER_SPAWN_EGG);
            event.accept(MobsCore.NEOTROOPER_SPAWN_EGG);
            event.accept(MobsCore.CAUCASUS_SPAWN_EGG);

        } else if (event.getTab() == DenOTab.get()) {
            for (int i = 0; i < DEN_O_TAB_ITEM.size(); ++i) {
                event.accept(DEN_O_TAB_ITEM.get(i));
            }
            event.accept(ModdedItemCore.COFFEE);
            event.accept(ModdedItemCore.VIENNA_COFFEE);
            event.accept(ModdedItemCore.PUDDING);
            event.accept(MusicDiscItems.CLIMAX_JUMP_MUSIC_DISC);
            event.accept(MobsCore.MACEHINE_DENBIRD_SPAWN_EGG);
            event.accept(MobsCore.NEW_MOLE_IMAGIN_SPAWN_EGG);
            event.accept(MobsCore.NEW_MOLE_IMAGIN_SAND_SPAWN_EGG);
            event.accept(MobsCore.GAOH_SPAWN_EGG);
            event.accept(MobsCore.MOMOTAROS_SPAWN_EGG);
            event.accept(MobsCore.URATAROS_SPAWN_EGG);
            event.accept(MobsCore.KINTAROS_SPAWN_EGG);
            event.accept(MobsCore.RYUTAROS_SPAWN_EGG);
            event.accept(RiderBlocks.GAOH_BOSS_BLOCK);
            event.accept(RiderBlocks.ANOTHER_DEN_O_BOSS_BLOCK);

        } else if (event.getTab() == KivaTab.get()) {
            for (int i = 0; i < KIVA_TAB_ITEM.size(); ++i) {
                event.accept(KIVA_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.BREAK_THE_CHAIN_MUSIC_DISC);
            event.accept(MobsCore.ARC_SPAWN_EGG);
            event.accept(MobsCore.MOOSE_FANGIRE_SPAWN_EGG);
            event.accept(RiderBlocks.ARC_BOSS_BLOCK);
            event.accept(RiderBlocks.KIVA_ORE);
            event.accept(RiderBlocks.DEEPSLATE_KIVA_ORE);
            event.accept(RiderBlocks.FANGIRE_GLASS);
            event.accept(RiderBlocks.IXA_MACHINE_BLOCK);


        } else if (event.getTab() == DecadeTab.get()) {
            for (int i = 0; i < DECADE_TAB_ITEM.size(); ++i) {
                event.accept(DECADE_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.JOURNEY_THROUGH_THE_DECADE_MUSIC_DISC);
            event.accept(MobsCore.DECADE_VIOLENT_SPAWN_EGG);
            event.accept(RiderBlocks.DECADE_VIOLENT_BLOCK);

        } else if (event.getTab() == WTab.get()) {
            for (int i = 0; i < W_TAB_ITEM.size(); ++i) {
                event.accept(W_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.WBX_MUSIC_DISC);
            event.accept(MobsCore.HARDBOILER_SPAWN_EGG);
            event.accept(MobsCore.SKULLBOILER_SPAWN_EGG);
            event.accept(MobsCore.ACCEL_BIKE_FORM_SPAWN_EGG);
            event.accept(MobsCore.MASQUERADE_SPAWN_EGG);
            event.accept(MobsCore.CLAYDOLL_DOPANT_SPAWN_EGG);
            event.accept(MobsCore.TERROR_DOPANT_SPAWN_EGG);
            event.accept(MobsCore.TABOO_DOPANT_SPAWN_EGG);
            event.accept(MobsCore.NASCA_DOPANT_SPAWN_EGG);
            event.accept(MobsCore.SMILODON_DOPANT_SPAWN_EGG);
            event.accept(MobsCore.WEATHER_DOPANT_SPAWN_EGG);
            event.accept(MobsCore.FOUNDATION_X_MASQUERADE_SPAWN_EGG);
            event.accept(MobsCore.COMMANDER_DOPANT_SPAWN_EGG);
            event.accept(MobsCore.ETERNAL_SPAWN_EGG);
            event.accept(RiderBlocks.TABOO_BOSS_BLOCK);
            event.accept(RiderBlocks.TERROR_BOSS_BLOCK);
            event.accept(RiderBlocks.PURE_GAIA_MEMORY_BLOCK);
            event.accept(RiderBlocks.GAIA_MEMORY_ORE);
            event.accept(RiderBlocks.DEEPSLATE_GAIA_MEMORY_ORE);
            event.accept(RiderBlocks.GAIA_MEMORY_REFINER);

        } else if (event.getTab() == OOOTab.get()) {
            for (int i = 0; i < OOO_TAB_ITEM.size(); ++i) {
                event.accept(OOO_TAB_ITEM.get(i));
            }
            event.accept(ModdedItemCore.ICE_POP);
            event.accept(ModdedItemCore.ICE_POP2);
            event.accept(ModdedItemCore.ICE_POP3);
            event.accept(MusicDiscItems.ANYTHING_GOES_MUSIC_DISC);
            event.accept(MobsCore.RIDEVENDOR_SPAWN_EGG);
            event.accept(MobsCore.TORIDEVENDOR_SPAWN_EGG);
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
            event.accept(RiderBlocks.POSEIDON_BOSS_BLOCK);
            event.accept(RiderBlocks.CORE_BOSS_BLOCK);
            event.accept(RiderBlocks.POWERED_UP_CORE_BOSS_BLOCK);
            event.accept(RiderBlocks.ANCIENT_OOO_BOSS_BLOCK);
            event.accept(RiderBlocks.GODA_BOSS_BLOCK);
            event.accept(RiderBlocks.CELL_ALLOY_BLOCK);
            event.accept(RiderBlocks.CELL_MEDAL_PROGRAMMER);

        } else if (event.getTab() == FOURZETab.get()) {
            for (int i = 0; i < FOURZE_TAB_ITEM.size(); ++i) {
                event.accept(FOURZE_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.SWITCH_ON_MUSIC_DISC);
            event.accept(MobsCore.MACEHINE_MASSIGLER_SPAWN_EGG);
            event.accept(MobsCore.SUPER_GINGAOH_SPAWN_EGG);
            event.accept(RiderBlocks.SUPER_GINGAOH_BOSS_BLOCK);
            event.accept(RiderBlocks.HAYABUSA_KUN);
            event.accept(RiderBlocks.ARTIFICIAL_GRAVITY_BLOCK);
            event.accept(RiderBlocks.GINGA_METEOR);
            event.accept(RiderBlocks.ASTROSWITCH_PROGRAMMER);

        } else if (event.getTab() == WIZARDTab.get()) {
            for (int i = 0; i < WIZARD_TAB_ITEM.size(); ++i) {
                event.accept(WIZARD_TAB_ITEM.get(i));
            }
            event.accept(ModdedItemCore.DONUT);
            event.accept(ModdedItemCore.MAYO);
            event.accept(ModdedItemCore.MAYO_DONUT);
            event.accept(MusicDiscItems.LIFE_IS_SHOWTIME_MUSIC_DISC);
            event.accept(MobsCore.GHOULS_SPAWN_EGG);
            event.accept(MobsCore.MEDUSA_PHANTOM_SPAWN_EGG);
            event.accept(MobsCore.PHOENIX_PHANTOM_SPAWN_EGG);
            event.accept(MobsCore.GREMLIN_PHANTOM_SPAWN_EGG);
            event.accept(MobsCore.MAGE_FOOTSOLDIER_SPAWN_EGG);
            event.accept(MobsCore.MAGE_CAPTAIN_SPAWN_EGG);
            event.accept(MobsCore.SORCERER_SPAWN_EGG);
            event.accept(MobsCore.WISEMAN_SPAWN_EGG);
            event.accept(RiderBlocks.WISEMAN_BOSS_BLOCK);
            event.accept(RiderBlocks.WIZARD_GEM_ORE);
            event.accept(RiderBlocks.DEEPSLATE_WIZARD_GEM_ORE);

        } else if (event.getTab() == GAIMTab.get()) {
            for (int i = 0; i < GAIM_TAB_ITEM.size(); ++i) {
                event.accept(GAIM_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.JUST_LIVE_MORE_MUSIC_DISC);
            event.accept(MobsCore.SAKURA_HURRICANE_SPAWN_EGG);
            event.accept(MobsCore.ROSE_ATTACKER_SPAWN_EGG);
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
            event.accept(RiderBlocks.ROSYUO_BOSS_BLOCK);
            event.accept(RiderBlocks.REDYUE_BOSS_BLOCK);
            event.accept(RiderBlocks.DEMUSHU_BOSS_BLOCK);
            event.accept(RiderBlocks.LORD_BARON_BOSS_BLOCK);
            event.accept(RiderBlocks.MEGAHEX_BOSS_BLOCK);
            event.accept(RiderBlocks.HELHEIM_CRACK);

        } else if (event.getTab() == DRIVETab.get()) {
            for (int i = 0; i < DRIVE_TAB_ITEM.size(); ++i) {
                event.accept(DRIVE_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.SURPRISE_DRIVE_MUSIC_DISC);
            event.accept(MobsCore.ROIDMUDE_SPAWN_EGG);
            event.accept(MobsCore.MASHIN_CHASER_SPAWN_EGG);
            event.accept(MobsCore.HEART_ROIDMUDE_SPAWN_EGG);
            event.accept(MobsCore.BRAIN_ROIDMUDE_SPAWN_EGG);
            event.accept(MobsCore.REAPER_LEGION_SPAWN_EGG);
            event.accept(MobsCore.MEDIC_ROIDMUDE_SPAWN_EGG);
            event.accept(MobsCore.GORD_DRIVE_SPAWN_EGG);
            event.accept(MobsCore.DARK_DRIVE_SPAWN_EGG);
            event.accept(RiderBlocks.GORD_DRIVE_BOSS_BLOCK);
            event.accept(RiderBlocks.MEGAHEX_BOSS_BLOCK);
            event.accept(RiderBlocks.SHIFT_CHASSIS_ASSEMBLER);

        } else if (event.getTab() == GHOSTTab.get()) {
            for (int i = 0; i < GHOST_TAB_ITEM.size(); ++i) {
                event.accept(GHOST_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.WARERA_OMOU_YUE_NI_WARERA_ARI_MUSIC_DISC);
            event.accept(ModdedItemCore.TAKOYAKI);
            event.accept(MobsCore.MACHINE_HOODIE_SPAWN_EGG);
            event.accept(MobsCore.GAMMA_COMMANDO_SPAWN_EGG);
            event.accept(MobsCore.NECROM_SPAWN_EGG);
            event.accept(MobsCore.IGOR_SPAWN_EGG);
            event.accept(MobsCore.DARK_NECROM_SPAWN_EGG);
            event.accept(MobsCore.DARK_GHOST_SPAWN_EGG);
            event.accept(RiderBlocks.GHOST_ORE);
            event.accept(RiderBlocks.DEEPSLATE_GHOST_ORE);
            event.accept(RiderBlocks.MONOLITH);

        } else if (event.getTab() == EX_AIDTab.get()) {
            for (int i = 0; i < EX_AID_TAB_ITEM.size(); ++i) {
                event.accept(EX_AID_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.EXCITE_KEY_MUSIC_DISC);
            event.accept(MobsCore.BIKE_GAMER_SPAWN_EGG);
            event.accept(MobsCore.SPORTS_GAMER_SPAWN_EGG);
            event.accept(MobsCore.PROTO_SPORTS_GAMER_SPAWN_EGG);
            event.accept(MobsCore.BUGSTERVIRUS_SPAWN_EGG);
            event.accept(MobsCore.NEBULA_BUGSTERVIRUS_SPAWN_EGG);
            event.accept(MobsCore.RIDEPLAYER_SPAWN_EGG);
            event.accept(MobsCore.GENM_SPAWN_EGG);
            event.accept(MobsCore.GRAPHITE_BUGSTER_SPAWN_EGG);
            event.accept(MobsCore.POPPY_RED_SPAWN_EGG);
            event.accept(MobsCore.PARADX_SPAWN_EGG);
            event.accept(MobsCore.CRONUS_SPAWN_EGG);
            event.accept(RiderBlocks.CRONUS_BOSS_BLOCK);
            event.accept(RiderBlocks.MIGHTY_BLOCK);
            event.accept(RiderBlocks.BANG_BANG_DRUM);
            event.accept(RiderBlocks.BAKUSOU_TROPHY);
            event.accept(RiderBlocks.GENM_CONTINUE);
            event.accept(RiderBlocks.GAME_CREATOR);
            event.accept(RiderBlocks.GANBERIZING_MACHINE);

        } else if (event.getTab() == BUILDTab.get()) {
            for (int i = 0; i < BUILD_TAB_ITEM.size(); ++i) {
                event.accept(BUILD_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.BE_THE_ONE_MUSIC_DISC);
            event.accept(MobsCore.MACEHINE_BUILDER_SPAWN_EGG);
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
            event.accept(RiderBlocks.NIGHT_ROGUE_BOSS_BLOCK);
            event.accept(RiderBlocks.HOKUTO_TRIO_BOSS_BLOCK);
            event.accept(RiderBlocks.HELL_BROS_BOSS_BLOCK);
            event.accept(RiderBlocks.MAD_ROGUE_BOSS_BLOCK);
            event.accept(RiderBlocks.EVOL_BOSS_BLOCK);
            event.accept(RiderBlocks.BIKAISER_BOSS_BLOCK);
            event.accept(RiderBlocks.UTAN);
            event.accept(RiderBlocks.PANDORA_BOX);
            event.accept(RiderBlocks.FULLBOTTLE_PURIFIER);
            event.accept(RiderBlocks.FULLBOTTLE_SOLIDIFIER);

        } else if (event.getTab() == ZI_OTab.get()) {
            for (int i = 0; i < ZI_O_TAB_ITEM.size(); ++i) {
                event.accept(ZI_O_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.OVER_QUARTZER_MUSIC_DISC);
            event.accept(MusicDiscItems.IZANAGI_MUSIC_DISC);
            event.accept(MusicDiscItems.P_A_R_T_Y_UNIVERSE_FESTIVAL_MUSIC_DISC);
            event.accept(MobsCore.RIDESTRIKER_SPAWN_EGG);
            event.accept(MobsCore.KASSHINE_SPAWN_EGG);
            event.accept(MobsCore.ANOTHER_ZI_O_SPAWN_EGG);
            event.accept(MobsCore.ANOTHER_DEN_O_SPAWN_EGG);
            event.accept(MobsCore.WOZ_SPAWN_EGG);
            event.accept(MobsCore.GINGA_SPAWN_EGG);
            event.accept(MobsCore.YAMININ_SPAWN_EGG);
            event.accept(MobsCore.BARLCKXS_SPAWN_EGG);
            event.accept(MobsCore.ZONJIS_SPAWN_EGG);
            event.accept(MobsCore.ZAMONAS_SPAWN_EGG);
            event.accept(RiderBlocks.WOZ_BOSS_BLOCK);
            event.accept(RiderBlocks.ANOTHER_DEN_O_BOSS_BLOCK);
            event.accept(RiderBlocks.YAMININ_BOSS_BLOCK);
            event.accept(RiderBlocks.GINGA_BOSS_BLOCK);
            event.accept(RiderBlocks.QUARTZER_BOSS_BLOCK);

        } else if (event.getTab() == Zero_OneTab.get()) {
            for (int i = 0; i < ZERO_ONE_TAB_ITEM.size(); ++i) {
                event.accept(ZERO_ONE_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.REAL_X_EYEZ_MUSIC_DISC);
            event.accept(MobsCore.RISEHOPPER_SPAWN_EGG);
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
            event.accept(RiderBlocks.HOROBI_BOSS_BLOCK);
            event.accept(RiderBlocks.IKAZUCHI_BOSS_BLOCK);
            event.accept(RiderBlocks.ARK_ONE_BOSS_BLOCK);
            event.accept(RiderBlocks.ZEIN_BOSS_BLOCK);
            event.accept(RiderBlocks.HIDEN_METAL_BLOCK);
            event.accept(RiderBlocks.HIDEN_3D_PRINTER);
            event.accept(RiderBlocks.ZAIA_3D_PRINTER);

        } else if (event.getTab() == SABERTab.get()) {
            for (int i = 0; i < SABER_TAB_ITEM.size(); ++i) {
                event.accept(SABER_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.ALMIGHTY_MUSIC_DISC);
            event.accept(MobsCore.DIAGOSPEEDY_SPAWN_EGG);
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
            event.accept(RiderBlocks.SABELA_BOSS_BLOCK);
            event.accept(RiderBlocks.DURENDAL_BOSS_BLOCK);
            event.accept(RiderBlocks.SOLOMON_BOSS_BLOCK);
            event.accept(RiderBlocks.STORIOUS_BOSS_BLOCK);
            event.accept(RiderBlocks.SWORD_OF_LOGOS_BOOK_ANALYZER);

        } else if (event.getTab() == ReviceTab.get()) {
            for (int i = 0; i < REVICE_TAB_ITEM.size(); ++i) {
                event.accept(REVICE_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.LIVEDEVIL_MUSIC_DISC);
            event.accept(MusicDiscItems.GEORGE_KARIZAKIS_RIDER_SYSTEM_MUSIC_DISC);
            event.accept(MobsCore.VICE_BIKE_SPAWN_EGG);
            event.accept(MobsCore.GIFF_JUNIOR_SPAWN_EGG);
            event.accept(MobsCore.EVIL_SPAWN_EGG);
            event.accept(MobsCore.DAIOUIKA_DEADMAN_SPAWN_EGG);
            event.accept(MobsCore.ANOMALOCARIS_DEADMAN_SPAWN_EGG);
            event.accept(MobsCore.QUEEN_BEE_DEADMAN_SPAWN_EGG);
            event.accept(MobsCore.WOLF_DEADMAN_SPAWN_EGG);
            event.accept(MobsCore.VAIL_SPAWN_EGG);
            event.accept(RiderBlocks.VICE_DUCKY);
            event.accept(RiderBlocks.LOVEKOV_PLUSH);
            event.accept(RiderBlocks.VISTAMP_BAR);

        } else if (event.getTab() == GeatsTab.get()) {
            for (int i = 0; i < GEATS_TAB_ITEM.size(); ++i) {
                event.accept(GEATS_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.TRUST_LAST_MUSIC_DISC);
            event.accept(MobsCore.BOOSTRIKER_SPAWN_EGG);
            event.accept(MobsCore.BOOSTRIKER_GEATS_MODE_SPAWN_EGG);
            event.accept(MobsCore.BOOSTRIKER_TYCOON_MODE_SPAWN_EGG);
            event.accept(MobsCore.BOOSTRIKER_NA_GO_MODE_SPAWN_EGG);
            event.accept(MobsCore.BOOSTRIKER_BUFFA_MODE_SPAWN_EGG);
            event.accept(MobsCore.PAWN_JYAMATO_SPAWN_EGG);
            event.accept(MobsCore.JYAMATO_RIDER_SPAWN_EGG);
            event.accept(MobsCore.GM_RIDER_SPAWN_EGG);
            event.accept(MobsCore.GLARE_SPAWN_EGG);
            event.accept(MobsCore.GLARE2_SPAWN_EGG);
            event.accept(MobsCore.GAZER_SPAWN_EGG);
            event.accept(MobsCore.END_RIDER_SPAWN_EGG);
            event.accept(MobsCore.PREMIUM_BEROBA_SPAWN_EGG);
            event.accept(MobsCore.PREMIUM_KEKERA_SPAWN_EGG);
            event.accept(RiderBlocks.PUNKJACKOLANTERN);

        } else if (event.getTab() == GotchardTab.get()) {
            for (int i = 0; i < GOTCHARD_TAB_ITEM.size(); ++i) {
                event.accept(GOTCHARD_TAB_ITEM.get(i));
            }
            event.accept(MusicDiscItems.CHEMY_X_STORY_MUSIC_DISC);
            event.accept(MusicDiscItems.CHEMY_X_STORY_FLOW_MUSIC_DISC);
            event.accept(MobsCore.MALGAM_SPAWN_EGG);
            event.accept(MobsCore.DREAD_SPAWN_EGG);
            event.accept(MobsCore.GOLEM_SPAWN_EGG);
            event.accept(MobsCore.GIGIST_SPAWN_EGG);
            event.accept(MobsCore.GERMAIN_SPAWN_EGG);
            event.accept(MobsCore.GAELIJAH_SPAWN_EGG);
            event.accept(MobsCore.ELD_SPAWN_EGG);
            event.accept(MobsCore.DREATROOPER_SPAWN_EGG);
            event.accept(MobsCore.DREATROOPER_COMMANDER_SPAWN_EGG);
            event.accept(MobsCore.DORADO_SPAWN_EGG);
            event.accept(RiderBlocks.ELD_BOSS_BLOCK);

        } else if (event.getTab() == GavvTab.get()) {
            for (int i = 0; i < GAVV_TAB_ITEM.size(); ++i) {
                event.accept(GAVV_TAB_ITEM.get(i));
            }
            event.accept(ModdedItemCore.CANDY_WRAPPER);
            event.accept(ModdedItemCore.GUMMI_CANDY);
            event.accept(ModdedItemCore.POTATO_SNACKS);
            event.accept(ModdedItemCore.LOLLIPOP);
            event.accept(ModdedItemCore.CHOCOLATE_BAR);
            event.accept(ModdedItemCore.MARSHMALLOW);
            event.accept(ModdedItemCore.ICE_POP);
            event.accept(ModdedItemCore.ICE_POP2);
            event.accept(ModdedItemCore.ICE_POP3);
            event.accept(ModdedItemCore.PUDDING);
            event.accept(ModdedItemCore.PANCAKE);
            event.accept(ModdedItemCore.CORN_SNACK);
            event.accept(ModdedItemCore.DANGO);
            event.accept(ModdedItemCore.COFFEE);
            event.accept(ModdedItemCore.VIENNA_COFFEE);
            event.accept(MusicDiscItems.GOT_BOOST_MUSIC_DISC);
            event.accept(MobsCore.AGENT_SPAWN_EGG);
            event.accept(MobsCore.BITTER_GAVV_SPAWN_EGG);
            event.accept(MobsCore.JEEB_STOMACH_SPAWN_EGG);
            event.accept(MobsCore.SHIITA_STOMACH_SPAWN_EGG);
            event.accept(MobsCore.NYELV_STOMACH_SPAWN_EGG);
            event.accept(MobsCore.GLOTTA_STOMACH_SPAWN_EGG);
            event.accept(MobsCore.LANGO_STOMACH_SPAWN_EGG);
            event.accept(MobsCore.BOCCA_JALDAK_SPAWN_EGG);
            event.accept(MobsCore.CARIES_SPAWN_EGG);
            event.accept(RiderBlocks.BOCCA_BOSS_BLOCK);
            event.accept(RiderBlocks.CARIES_BOSS_BLOCK);
            event.accept(RiderBlocks.GOCHIZO_JAR);
            event.accept(RiderBlocks.DARK_TREAT_GLASS);
            event.accept(RiderBlocks.CANDY_SHOP);
            event.accept(RiderBlocks.HEATPRESS_EXTRACTOR);

        } else if (event.getTab() == ZeztzTab.get()) {
            for (int i = 0; i < ZEZTZ_TAB_ITEM.size(); ++i) {
                event.accept(ZEZTZ_TAB_ITEM.get(i));
            }
            event.accept(MobsCore.CODE_ZEROIDER_SPAWN_EGG);
            event.accept(MobsCore.BABY_NIGHTMARE_SPAWN_EGG);
            event.accept(MobsCore.NIGHTMARE_SPAWN_EGG);
            event.accept(MobsCore.SHADOW_NIGHTMARE_SPAWN_EGG);
            event.accept(MobsCore.NOX_SPAWN_EGG);
            event.accept(MobsCore.DAWN_SPAWN_EGG);
            event.accept(MobsCore.LORD_THREE_SPAWN_EGG);
            event.accept(MobsCore.ZEZTZ_DARKNESS_NIGHTMARE_SPAWN_EGG);
            event.accept(MobsCore.CATASTROPHE_GORE_NIGHTMARE_SPAWN_EGG);
            event.accept(MobsCore.PHANTOM_GORE_NIGHTMARE_SPAWN_EGG);
            event.accept(MobsCore.OBLIVION_GORE_NIGHTMARE_SPAWN_EGG);
            event.accept(RiderBlocks.LORD_THREE_BOSS_BLOCK);
            event.accept(RiderBlocks.CAPSEM_DROPPER);
            event.accept(RiderBlocks.MIND_DOOR);


        } else if (event.getTab() == My_thTab.get()) {
            for (int i = 0; i < MY_TH_TAB_ITEM.size(); ++i) {
                event.accept(MY_TH_TAB_ITEM.get(i));
            }

        } else if (event.getTab() == AMAZONSTab.get()) {
            event.accept(AmazonsRiderItems.EMPTY_VIAL);
            for (int i = 0; i < AMAZONS_TAB_ITEM.size(); ++i) {
                event.accept(AMAZONS_TAB_ITEM.get(i));
            }
            event.accept(RiderBlocks.AMAZON_CELL_EXTRACTOR);
            event.accept(RiderBlocks.AMAZON_CELL_MUTATOR);

        } else if (event.getTab() == BLACKSUNTab.get()) {
            for (int i = 0; i < BLACK_SUN_TAB_ITEM.size(); ++i) {
                event.accept(BLACK_SUN_TAB_ITEM.get(i));
            }
            event.accept(RiderBlocks.KAIJIN_STONE_GENERATOR);

        } else if (event.getTab() == GTab.get()) {
            for (int i = 0; i < G_TAB_ITEM.size(); ++i) {
                event.accept(G_TAB_ITEM.get(i));
            }

        } else if (event.getTab() == GoriderTab.get()) {
            for (int i = 0; i < GORIDER_TAB_ITEM.size(); ++i) {
                event.accept(GORIDER_TAB_ITEM.get(i));
            }

        } else if (event.getTab() == RideKamensTab.get()) {
            for (int i = 0; i < RIDE_KAMENS_TAB_ITEM.size(); ++i) {
                event.accept(RIDE_KAMENS_TAB_ITEM.get(i));
            }

        } else if (event.getTab() == RiderblockTab.get()) {
            for (int i = 0; i < RIDER_BLOCK.size(); ++i) {
                event.accept(RIDER_BLOCK.get(i));
            }
            // event.accept(RiderBlocks.BLUE_ROSE.get());

        } else if (event.getTab() == RiderdecorTab.get()) {
            for (int i = 0; i < RIDER_DECOR.size(); ++i) {
                event.accept(RIDER_DECOR.get(i));
            }
            event.accept(RiderBlocks.SHOCKER_LOGO);
            event.accept(RiderBlocks.BLUE_ROSE);

            event.accept(RiderBlocks.HELHEIM_PLANT);
            event.accept(RiderBlocks.HELHEIM_PLANT_2);
            event.accept(RiderBlocks.HELHEIM_PLANT_3);
            event.accept(RiderBlocks.HELHEIM_PLANT_4);
            event.accept(RiderBlocks.HELHEIM_STAIRS);
            event.accept(RiderBlocks.HELHEIM_SLAB);
            event.accept(RiderBlocks.HELHEIM_PRESSURE_PLATE);
            event.accept(RiderBlocks.HELHEIM_BUTTON);
            event.accept(RiderBlocks.HELHEIM_FENCE);
            event.accept(RiderBlocks.HELHEIM_FENCE_GATE);
            event.accept(RiderBlocks.HELHEIM_DOOR);
            event.accept(RiderBlocks.HELHEIM_TRAPDOOR);
            event.accept(ModdedItemCore.HELHEIM_SIGN_ITEM);
            event.accept(ModdedItemCore.HELHEIM_HANGING_SIGN_ITEM);
            event.accept(RiderBlocks.HELHEIM_SAPLING);
            event.accept(RiderBlocks.HELHEIM_LEAVES);
            event.accept(RiderBlocks.HELHEIM_VINE);

            event.accept(RiderBlocks.WONDERWOOD_DOOR);

            event.accept(RiderBlocks.WHITE_FENCE);

            event.accept(RiderBlocks.STEEL_LADDER);
            event.accept(RiderBlocks.RABBIT_HUTCH_LADDER);

            event.accept(RiderBlocks.JAIL_DOOR);
            event.accept(RiderBlocks.GOLD_DOOR);
            event.accept(RiderBlocks.RABBIT_HUTCH_DOOR);

            event.accept(RiderBlocks.WINDOW_PLANKS);
            event.accept(RiderBlocks.CASTLE_DORAN_LOGO);
            event.accept(RiderBlocks.DRIVE_PIT_LOGO);
            event.accept(RiderBlocks.DRIVE_PIT_LADDER);

            event.accept(RiderBlocks.WHITEBOARD);

            event.accept(RiderBlocks.GRANUTE_GLASS_PANE);

            event.accept(RiderBlocks.GHOST_LINER_WHEEL);
            event.accept(RiderBlocks.WHITE_WALLPLATE_STAIRS);
            event.accept(RiderBlocks.WHITE_WALLPLATE_SLAB);
            event.accept(RiderBlocks.WALLPLATE_GRATE);
            event.accept(RiderBlocks.WHITE_WALLPLATE_WALL);
            event.accept(RiderBlocks.GREY_WALLPLATE_STAIRS);
            event.accept(RiderBlocks.GREY_WALLPLATE_SLAB);
            event.accept(RiderBlocks.GREY_WALLPLATE_WALL);
            event.accept(RiderBlocks.WALLPLATE_STAIRS);
            event.accept(RiderBlocks.WALLPLATE_SLAB);
            event.accept(RiderBlocks.WALLPLATE_WALL);
            event.accept(RiderBlocks.BLACK_WALLPLATE_STAIRS);
            event.accept(RiderBlocks.BLACK_WALLPLATE_SLAB);
            event.accept(RiderBlocks.BLACK_WALLPLATE_WALL);
            event.accept(RiderBlocks.RED_WALLPLATE_STAIRS);
            event.accept(RiderBlocks.RED_WALLPLATE_SLAB);
            event.accept(RiderBlocks.RED_WALLPLATE_WALL);
            event.accept(RiderBlocks.YELLOW_WALLPLATE_STAIRS);
            event.accept(RiderBlocks.YELLOW_WALLPLATE_GRATE_STAIRS);
            event.accept(RiderBlocks.YELLOW_WALLPLATE_SLAB);
            event.accept(RiderBlocks.YELLOW_WALLPLATE_WALL);
            event.accept(RiderBlocks.LIGHT_GREEN_WALLPLATE_STAIRS);
            event.accept(RiderBlocks.LIGHT_GREEN_WALLPLATE_SLAB);
            event.accept(RiderBlocks.LIGHT_GREEN_WALLPLATE_GRATE_SLAB);
            event.accept(RiderBlocks.LIGHT_GREEN_WALLPLATE_WALL);
            event.accept(RiderBlocks.GREEN_WALLPLATE_STAIRS);
            event.accept(RiderBlocks.GREEN_WALLPLATE_SLAB);
            event.accept(RiderBlocks.GREEN_WALLPLATE_WALL);
            event.accept(RiderBlocks.CYAN_WALLPLATE_STAIRS);
            event.accept(RiderBlocks.CYAN_WALLPLATE_SLAB);
            event.accept(RiderBlocks.CYAN_WALLPLATE_WALL);
            event.accept(RiderBlocks.LIGHT_BLUE_WALLPLATE_STAIRS);
            event.accept(RiderBlocks.LIGHT_BLUE_WALLPLATE_SLAB);
            event.accept(RiderBlocks.LIGHT_BLUE_WALLPLATE_WALL);
            event.accept(RiderBlocks.BLUE_WALLPLATE_STAIRS);
            event.accept(RiderBlocks.BLUE_WALLPLATE_SLAB);
            event.accept(RiderBlocks.BLUE_WALLPLATE_WALL);


            event.accept(RiderBlocks.GLASS_DOOR);
            event.accept(RiderBlocks.PLINTH);
            event.accept(RiderBlocks.GOCHIZO_JAR);


        } else if (event.getTab() == RiderEggTab.get()) {

            event.accept(MobsCore.SHOCKER_COMBATMAN_SPAWN_EGG);
            event.accept(MobsCore.SHOCKER_RIDER_SPAWN_EGG);

            event.accept(MobsCore.BATTA_AUGMENT_SPAWN_EGG);
            event.accept(MobsCore.SHIN_NO_0_SPAWN_EGG);

            event.accept(MobsCore.DESTRON_COMBATMAN_SPAWN_EGG);
            event.accept(MobsCore.GOD_WARFARE_AGENT_SPAWN_EGG);
            event.accept(MobsCore.APOLLOGEIST_SPAWN_EGG);
            event.accept(MobsCore.RED_FOLLWER_SPAWN_EGG);
            event.accept(MobsCore.BLACK_SATAN_SOLDIER_SPAWN_EGG);
            event.accept(MobsCore.ARI_COMMANDO_SPAWN_EGG);
            event.accept(MobsCore.DOGMA_FIGHTER_SPAWN_EGG);
            event.accept(MobsCore.COMBAT_ROID_SPAWN_EGG);
            event.accept(MobsCore.CHAP_SPAWN_EGG);
            event.accept(MobsCore.CHAP_GREY_SPAWN_EGG);
            event.accept(MobsCore.SHADOWMOON_SPAWN_EGG);

            event.accept(MobsCore.ZU_GUMUN_BA_SPAWN_EGG);
            event.accept(MobsCore.GO_CLASS_GRONGI_SPAWN_EGG);
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

            event.accept(MobsCore.UNDEAD_SPAWN_EGG);
            event.accept(MobsCore.ACE_UNDEAD_SPAWN_EGG);
            event.accept(MobsCore.JACK_UNDEAD_SPAWN_EGG);
            event.accept(MobsCore.QUEEN_UNDEAD_SPAWN_EGG);
            event.accept(MobsCore.KING_UNDEAD_SPAWN_EGG);
            event.accept(MobsCore.JOKER_UNDEAD_SPAWN_EGG);
            event.accept(MobsCore.ALBINO_JOKER_UNDEAD_SPAWN_EGG);

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
            event.accept(MobsCore.RIDEPLAYER_SPAWN_EGG);
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
            event.accept(MobsCore.DREATROOPER_SPAWN_EGG);
            event.accept(MobsCore.DREATROOPER_COMMANDER_SPAWN_EGG);
            event.accept(MobsCore.DORADO_SPAWN_EGG);

            event.accept(MobsCore.AGENT_SPAWN_EGG);
            event.accept(MobsCore.BITTER_GAVV_SPAWN_EGG);
            event.accept(MobsCore.JEEB_STOMACH_SPAWN_EGG);
            event.accept(MobsCore.SHIITA_STOMACH_SPAWN_EGG);
            event.accept(MobsCore.NYELV_STOMACH_SPAWN_EGG);
            event.accept(MobsCore.GLOTTA_STOMACH_SPAWN_EGG);
            event.accept(MobsCore.LANGO_STOMACH_SPAWN_EGG);
            event.accept(MobsCore.BOCCA_JALDAK_SPAWN_EGG);
            event.accept(MobsCore.CARIES_SPAWN_EGG);

            event.accept(MobsCore.BABY_NIGHTMARE_SPAWN_EGG);
            event.accept(MobsCore.NIGHTMARE_SPAWN_EGG);
            event.accept(MobsCore.SHADOW_NIGHTMARE_SPAWN_EGG);
            event.accept(MobsCore.NOX_SPAWN_EGG);
            event.accept(MobsCore.DAWN_SPAWN_EGG);
            event.accept(MobsCore.LORD_THREE_SPAWN_EGG);
            event.accept(MobsCore.ZEZTZ_DARKNESS_NIGHTMARE_SPAWN_EGG);
            event.accept(MobsCore.PHANTOM_GORE_NIGHTMARE_SPAWN_EGG);
            event.accept(MobsCore.CATASTROPHE_GORE_NIGHTMARE_SPAWN_EGG);
            event.accept(MobsCore.OBLIVION_GORE_NIGHTMARE_SPAWN_EGG);
        } else if (event.getTab() == RiderMiscTab.get()) {

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
            event.accept(MobsCore.MACHINE_HOODIE_SPAWN_EGG);
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
            event.accept(MobsCore.CODE_ZEROIDER_SPAWN_EGG);

            for (int i = 0; i < MISC_TAB_ITEMS.size(); ++i) {
                event.accept(MISC_TAB_ITEMS.get(i));
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
            event.accept(MusicDiscItems.AI_GA_TOMARANAI_MUSIC_DISC);
            event.accept(MusicDiscItems.KOKORO_TSUNAGU_AI_MUSIC_DISC);
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
            event.accept(MusicDiscItems.DREAM_MAZE_MUSIC_DISC);
            event.accept(MusicDiscItems.ONE_SHOT_MUSIC_DISC);
            event.accept(MusicDiscItems.MASKED_RIDER_MUSIC_DISC);
        }
    }
}