package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.zi_o.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import com.kelco.kamenridercraft.particle.ModParticles;
import com.kelco.kamenridercraft.world.inventory.MiridewatchHolderGuiMenu;
import com.kelco.kamenridercraft.world.inventory.RidewatchHolderGuiMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Zi_O_Rider_Items {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

    public static final DeferredItem<Item> ZI_O_LOGO = ITEMS.register("zi_o_logo",
            () -> new Zi_OLogoItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/zi_o")), new Item.Properties())
                    .addBelt("kamenridercraft:kuuga_manga", "kamenridercraft:manga_arcle")
                    .addBelt("kamenridercraft:zangetsu_kachidoki_lockseed", "kamenridercraft:sengoku_driver_zangetsu")
                    .addWeapon("kamenridercraft:zangetsu_kachidoki_lockseed", "kamenridercraft:zangetsu_dj_gun")
                    .addBelt("kamenridercraft:roidmude_core_003", "kamenridercraft:brain_driver")
                    .addWeapon("kamenridercraft:roidmude_core_003", "kamenridercraft:brain_sword")
                    .addBelt("kamenridercraft:goro_wine_bottle", "kamenridercraft:g_belt")
                    .addBelt("kamenridercraft:akarider_card", "kamenridercraft:typhoon_akarider")
                    .addBelt("kamenridercraft:aorider_card", "kamenridercraft:typhoon_aorider")
                    .addBelt("kamenridercraft:kirider_card", "kamenridercraft:typhoon_kirider")
                    .addBelt("kamenridercraft:momorider_card", "kamenridercraft:typhoon_momorider")
                    .addBelt("kamenridercraft:midorider_card", "kamenridercraft:typhoon_midorider")
                    .AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BLANK_RIDEWATCH = ITEMS.register("blank_watch",
            () -> new BaseDropItem(new Item.Properties(), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/blank_watch")).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZI_O_RIDEWATCH = ITEMS.register("zi_o_ridewatch",
            () -> new Zi_ORidewatchItem(new Item.Properties(), 0, "", "zi_o", "ziku_driver_zi_o_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .addSummonWeapon("kamenridercraft:zikan_girade")
                    .addAltWeapon("kamenridercraft:build_ridewatch", "kamenridercraft:drill_crusher_crusher")
                    .addAltWeapon("kamenridercraft:decade_ridewatch", "kamenridercraft:ride_heisaber")
                    .addAltForm("kamenridercraft:survive_rekka", "kamenridercraft:decade_ryuki_ridewatch")
                    .addAltWeapon("kamenridercraft:survive_rekka", "kamenridercraft:drag_visor_zwei", "kamenridercraft:ride_heisaber")
                    .addAltForm("kamenridercraft:faiz_axel_mission_memory", "kamenridercraft:decade_faiz_ridewatch")
                    .addAltWeapon("kamenridercraft:faiz_axel_mission_memory", "kamenridercraft:ride_heisaber")
                    .addAltForm("kamenridercraft:kujaku_medal", "kamenridercraft:decade_ooo_ridewatch")
                    .addAltWeapon("kamenridercraft:kujaku_medal", "kamenridercraft:tajaspinner", "kamenridercraft:ride_heisaber")
                    .addAltForm("kamenridercraft:condor_medal", "kamenridercraft:decade_ooo_ridewatch")
                    .addAltWeapon("kamenridercraft:condor_medal", "kamenridercraft:tajaspinner", "kamenridercraft:ride_heisaber")
                    .addAltForm("kamenridercraft:foundation_x_kujaku_medal", "kamenridercraft:decade_ooo_ridewatch")
                    .addAltWeapon("kamenridercraft:foundation_x_kujaku_medal", "kamenridercraft:tajaspinner", "kamenridercraft:ride_heisaber")
                    .addAltForm("kamenridercraft:foundation_x_condor_medal", "kamenridercraft:decade_ooo_ridewatch")
                    .addAltWeapon("kamenridercraft:foundation_x_condor_medal", "kamenridercraft:tajaspinner", "kamenridercraft:ride_heisaber")
                    .addAltForm("kamenridercraft:zeus_kujaku_medal", "kamenridercraft:decade_ooo_ridewatch")
                    .addAltWeapon("kamenridercraft:zeus_kujaku_medal", "kamenridercraft:tajaspinner", "kamenridercraft:ride_heisaber")
                    .addAltForm("kamenridercraft:zeus_condor_medal", "kamenridercraft:decade_ooo_ridewatch")
                    .addAltWeapon("kamenridercraft:zeus_condor_medal", "kamenridercraft:tajaspinner", "kamenridercraft:ride_heisaber")
                    .addAltForm("kamenridercraft:taka_ankh_medal", "kamenridercraft:decade_ooo_ridewatch")
                    .addAltWeapon("kamenridercraft:taka_ankh_medal", "kamenridercraft:tajaspinner", "kamenridercraft:ride_heisaber")
                    .addAltForm("kamenridercraft:eyecon_driver_g", "kamenridercraft:decade_ghost_ridewatch")
                    .addAltWeapon("kamenridercraft:eyecon_driver_g", "kamenridercraft:ride_heisaber")
                    .addAltForm("kamenridercraft:mighty_brothers_xx_gashat", "kamenridercraft:decade_ex_aid_ridewatch_r")
                    .addAltWeapon("kamenridercraft:mighty_brothers_xx_gashat", "kamenridercraft:ride_heisaber")
                    .addAltForm("kamenridercraft:rabbittank_sparkling_full_bottle", "kamenridercraft:decade_build_ridewatch")
                    .addAltWeapon("kamenridercraft:rabbittank_sparkling_full_bottle", "kamenridercraft:drill_crusher_crusher", "kamenridercraft:ride_heisaber")
                    .addAltWeapon("kamenridercraft:zi_o_ii_ridewatch", "kamenridercraft:saikyo_girade")
                    .addAltWeapon("kamenridercraft:zi_o_trinity_ridewatch", "kamenridercraft:zikan_zax", "kamenridercraft:zikan_despear")
                    .IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_RIDEWATCH = ITEMS.register("decade_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_decade", "zi_o", "ziku_driver_zi_o_belt_decade",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Decade_Rider_Items.DECADRIVER.get())
                    .addSummonWeapon(Decade_Rider_Items.RIDE_BOOKER.get())
                    .addAltBelt(Decade_Rider_Items.NEO_DECADRIVER.get(), (RiderDriverItem) Decade_Rider_Items.NEO_DECADRIVER.get())
                    .addAltBelt(Decade_Rider_Items.W_CARD.get(), (RiderDriverItem) Decade_Rider_Items.NEO_DECADRIVER.get())
                    .addAltBelt(Decade_Rider_Items.OOO_CARD.get(), (RiderDriverItem) Decade_Rider_Items.NEO_DECADRIVER.get())
                    .addAltBelt(Decade_Rider_Items.FOURZE_CARD.get(), (RiderDriverItem) Decade_Rider_Items.NEO_DECADRIVER.get())
                    .addAltBelt(Decade_Rider_Items.WIZARD_CARD.get(), (RiderDriverItem) Decade_Rider_Items.NEO_DECADRIVER.get())
                    .addAltBelt(Decade_Rider_Items.GAIM_CARD.get(), (RiderDriverItem) Decade_Rider_Items.NEO_DECADRIVER.get())
                    .addAltBelt(Decade_Rider_Items.DRIVE_CARD.get(), (RiderDriverItem) Decade_Rider_Items.NEO_DECADRIVER.get())
                    .addAltBelt(Decade_Rider_Items.GHOST_CARD.get(), (RiderDriverItem) Decade_Rider_Items.NEO_DECADRIVER.get())
                    .addAltBelt(Decade_Rider_Items.EX_AID_CARD.get(), (RiderDriverItem) Decade_Rider_Items.NEO_DECADRIVER.get())
                    .addAltBelt(Decade_Rider_Items.BUILD_CARD.get(), (RiderDriverItem) Decade_Rider_Items.NEO_DECADRIVER.get())
                    .addAltBelt(Decade_Rider_Items.ZI_O_CARD.get(), (RiderDriverItem) Decade_Rider_Items.NEO_DECADRIVER.get())
                    .addAltBelt(Decade_Rider_Items.K_TOUCH_21.get(), (RiderDriverItem) Decade_Rider_Items.NEO_DECADRIVER.get())
                    .addAltForm(Decade_Rider_Items.DIEND_CARD.get(), (RiderFormChangeItem) Decade_Rider_Items.DECADE_CYAN_CARD.get())
                    .addAltForm(Decade_Rider_Items.REKKA_DAIZANTOU_CARD.get(), (RiderFormChangeItem) Decade_Rider_Items.K_TOUCH.get())
                    .addAltForm(Decade_Rider_Items.G4_GIGANT_CARD.get(), (RiderFormChangeItem) Decade_Rider_Items.DECADE_VIOLENT_EMOTION_CARD.get())
                    .addAltForm(Decade_Rider_Items.RYUKI_STRIKE_VENT_CARD.get(), (RiderFormChangeItem) Decade_Rider_Items.RYUKI_CARD.get())
                    .addAltForm(Decade_Rider_Items.HIBIKI_ONGEKIBOU_REKKA_CARD.get(), (RiderFormChangeItem) Decade_Rider_Items.HIBIKI_CARD.get())
                    .addAltWeapon(Hibiki_Rider_Items.ONGEKIBO_REKKA.get(), Decade_Rider_Items.ONGEKIBO_REKKA_DECADE.get(), Decade_Rider_Items.ONGEKIBO_REKKA_DECADE.get())
                    .addAltWeapon(Decade_Rider_Items.DECADE_BLAST_CARD.get(), Decade_Rider_Items.DECADE_BAZOOKA.get())
                    .addAltWeapon(Decade_Rider_Items.REKKA_DAIZANTOU_CARD.get(), BuiltInRegistries.ITEM.get(ResourceLocation.parse("supersentaicraft:rekka_daizantou")))
                    .addAltWeapon(Decade_Rider_Items.G4_GIGANT_CARD.get(), Agito_Rider_Items.G4_GIGANT.get())
                    .addAltWeapon(Decade_Rider_Items.RYUKI_STRIKE_VENT_CARD.get(), Ryuki_Rider_Items.DRAG_CLAW.get())
                    .addAltWeapon(Decade_Rider_Items.HIBIKI_ONGEKIBOU_REKKA_CARD.get(), Hibiki_Rider_Items.ONGEKIBO_REKKA.get(), Hibiki_Rider_Items.ONGEKIBO_REKKA.get())
                    .IsGlowing().ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json").IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZI_O_II_RIDEWATCH = ITEMS.register("zi_o_ii_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), 0, "_ii", "zi_o", "ziku_driver_zi_o_belt_zi_o_ii",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZI_O_TRINITY_RIDEWATCH = ITEMS.register("zi_o_trinity_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), 0, "_trinity", "zi_o", "ziku_driver_zi_o_belt_trinity",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GRAND_ZI_O_RIDEWATCH = ITEMS.register("grand_zi_o_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE), 0, "_grand", "zi_o", "ziku_driver_zi_o_belt_grand",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.SATURATION, 40, 0, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RANDOM_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().IsBeltGlowing().ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json").AddToList(Decade_Rider_Items.COMPLETE_21_FORMS).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> OHMA_ZI_O_RIDEWATCH = ITEMS.register("ohma_zi_o_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC), 0, "_ohma", "zi_o", "ziku_driver_zi_o_belt_ohma",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 6, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 6, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 6, true, false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 6, true, false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.SATURATION, 40, 0, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GEIZ_RIDEWATCH = ITEMS.register("geiz_ridewatch",
            () -> new GeizRidewatchItem(new Item.Properties(), 0, "", "geiz", "ziku_driver_geiz_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GEIZ_REVIVE_SHIPPU_RIDEWATCH = ITEMS.register("geiz_revive_shippu_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "_revive_shippu", "geiz", "ziku_driver_geiz_belt_revive",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().model_has_different_name("geiz_revive_ridewatch").has_basic_model());

    public static final DeferredItem<Item> GEIZ_REVIVE_RIDEWATCH = ITEMS.register("geiz_revive_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), 0, "_revive_goretsu", "geiz", "ziku_driver_geiz_belt_revive",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().addSwitchForm(GEIZ_REVIVE_SHIPPU_RIDEWATCH.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GEIZ_MAJESTY_RIDEWATCH = ITEMS.register("geiz_majesty_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE), 0, "_majesty", "geiz", "ziku_driver_geiz_belt_majesty",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.REGENERATION, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.SATURATION, 40, 0, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RANDOM_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json").AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> TSUKUYOMI_RIDEWATCH = ITEMS.register("tsukuyomi_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), 0, "", "tsukuyomi", "ziku_driver_tsukuyomi_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> WOZ_MIRIDEWATCH = ITEMS.register("woz_miridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "woz", "beyondriver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZI_O_MIRROR_RIDEWATCH = ITEMS.register("zi_o_mirror_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "zi_o_mirror", "ziku_driver_zi_o_mirror_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BARLCKXS_RIDEWATCH = ITEMS.register("barlckxs_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "barlckxs", "ziku_driver_barlckxs_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZONJIS_RIDEWATCH = ITEMS.register("zonjis_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "zonjis", "ziku_driver_zonjis_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZAMONAS_RIDEWATCH = ITEMS.register("zamonas_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "zamonas", "ziku_driver_zamonas_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));


    public static final DeferredItem<Item> KUUGA_RIDEWATCH = ITEMS.register("kuuga_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_kuuga", "zi_o", "ziku_driver_zi_o_belt_kuuga",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Kuuga_Rider_Items.ARCLE.get())
                    .addAltForm(Decade_Rider_Items.KUUGA_GROWING_CARD.get(), (RiderFormChangeItem) Decade_Rider_Items.KUUGA_GROWING_AR.get())
                    .addAltWeapon(Kuuga_Rider_Items.KUUGA_DRAGON.get(), Kuuga_Rider_Items.DRAGON_ROD.get())
                    .addAltWeapon(Kuuga_Rider_Items.KUUGA_RISING_DRAGON.get(), Kuuga_Rider_Items.DRAGON_ROD.get())
                    .addAltWeapon(Kuuga_Rider_Items.KUUGA_PEGASUS.get(), Kuuga_Rider_Items.PEGASUS_BOWGUN.get())
                    .addAltWeapon(Kuuga_Rider_Items.KUUGA_RISING_PEGASUS.get(), Kuuga_Rider_Items.PEGASUS_BOWGUN.get())
                    .addAltWeapon(Kuuga_Rider_Items.KUUGA_TITAN.get(), Kuuga_Rider_Items.TITAN_SWORD.get())
                    .addAltWeapon(Kuuga_Rider_Items.KUUGA_RISING_TITAN.get(), Kuuga_Rider_Items.TITAN_SWORD.get())
                    .addAltWeapon(Modded_item_core.GRANDGOURAM.get(), Modded_item_core.GRANDGOURAM_ROD.get())
                    .IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> AGITO_RIDEWATCH = ITEMS.register("agito_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_agito", "zi_o", "ziku_driver_zi_o_belt_agito",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Agito_Rider_Items.ALTERING.get())
                    .addAltWeapon(Agito_Rider_Items.AGITO_FLAME.get(), Agito_Rider_Items.FLAME_SABER.get())
                    .addAltWeapon(Agito_Rider_Items.AGITO_STORM.get(), Agito_Rider_Items.STORM_HALBERD.get())
                    .addAltWeapon(Agito_Rider_Items.AGITO_TRINITY.get(), Agito_Rider_Items.FLAME_SABER.get(), Agito_Rider_Items.STORM_HALBERD.get())
                    .addAltWeapon(Agito_Rider_Items.AGITO_BURNING.get(), Agito_Rider_Items.SHINING_CALIBER.get())
                    .addAltWeapon(Agito_Rider_Items.AGITO_SHINING.get(), Agito_Rider_Items.SHINING_CALIBER_TWIN.get(), Agito_Rider_Items.SHINING_CALIBER_TWIN.get())
                    .IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_RYUKI_RIDEWATCH = ITEMS.register("decade_ryuki_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "_decade_ryuki", "zi_o", "ziku_driver_zi_o_belt_decade_ryuki",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().IsBeltGlowing().ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

    public static final DeferredItem<Item> RYUKI_RIDEWATCH = ITEMS.register("ryuki_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_ryuki", "zi_o", "ziku_driver_zi_o_belt_ryuki",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false),
                    new MobEffectInstance(Effect_core.BOOST, 40, 0, true, false),
                    new MobEffectInstance(Effect_core.PUNCH, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Ryuki_Rider_Items.RYUKIDRIVER.get())
                    .addAltForm(Ryuki_Rider_Items.RIDE_SABER_VENT.get(), (RiderFormChangeItem) Ryuki_Rider_Items.ADVENT_CARD.get())
                    .addAltForm(Ryuki_Rider_Items.DRAG_VISOR_ZWEI_VENT.get(), (RiderFormChangeItem) Ryuki_Rider_Items.SURVIVE_REKKA.get())
                    .addAltForm(Ryuki_Rider_Items.DRAG_BLADE_VENT.get(), (RiderFormChangeItem) Ryuki_Rider_Items.SURVIVE_REKKA.get())
                    .addAltWeapon(Ryuki_Rider_Items.RIDE_SABER_VENT.get(), Ryuki_Rider_Items.RIDE_SABER.get())
                    .addAltWeapon(Ryuki_Rider_Items.DRAG_SABER_VENT.get(), Ryuki_Rider_Items.DRAG_SABER.get())
                    .addAltWeapon(Ryuki_Rider_Items.DRAG_CLAW_VENT.get(), Ryuki_Rider_Items.DRAG_CLAW.get())
                    .addAltWeapon(Ryuki_Rider_Items.DRAG_SHIELD_VENT.get(), Ryuki_Rider_Items.DRAG_SHIELD.get(), Ryuki_Rider_Items.DRAG_SHIELD.get())
                    .addAltWeapon(Ryuki_Rider_Items.DRAG_VISOR_ZWEI_VENT.get(), Ryuki_Rider_Items.DRAG_VISOR_ZWEI.get())
                    .addAltWeapon(Ryuki_Rider_Items.DRAG_BLADE_VENT.get(), Ryuki_Rider_Items.DRAG_BLADE.get())
                    .IsGlowing().IsBeltGlowing().AddIncompatibleForm(DECADE_RIDEWATCH.asItem()).addAlternative(DECADE_RYUKI_RIDEWATCH.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_FAIZ_RIDEWATCH = ITEMS.register("decade_faiz_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "_decade_faiz", "zi_o", "ziku_driver_zi_o_belt_decade_faiz",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().IsBeltGlowing().addNeedForm(DECADE_RIDEWATCH.asItem(), 1).ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

    public static final DeferredItem<Item> FAIZ_RIDEWATCH = ITEMS.register("faiz_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_faiz", "geiz", "ziku_driver_geiz_belt_faiz",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Faiz_Rider_Items.FAIZ_DRIVER.get())
                    .addSummonWeapon(Faiz_Rider_Items.FAIZ_EDGE.get())
                    .addAltWeapon(Faiz_Rider_Items.FAIZ_PHONE.get(), Faiz_Rider_Items.FAIZ_PHONE.get())
                    .addAltWeapon(Faiz_Rider_Items.FAIZ_PHONE_POINTER.get(), Faiz_Rider_Items.FAIZ_PHONE_POINTER.get())
                    .addAltWeapon(Faiz_Rider_Items.FAIZ_SHOT.get(), Faiz_Rider_Items.FAIZ_SHOT.get())
                    .addAltWeapon(Faiz_Rider_Items.FAIZ_AXEL_MISSION_MEMORY.get(), Items.AIR)
                    .addAltWeapon(Faiz_Rider_Items.FAIZ_BLASTER_MISSION_MEMORY.get(), Faiz_Rider_Items.FAIZ_BLASTER.get())
                    .addAltWeapon(Faiz_Rider_Items.FAIZ_GOLD_BLASTER_MISSION_MEMORY.get(), Faiz_Rider_Items.FAIZ_BLASTER.get())
                    .addAltWeapon(Modded_item_core.BAKUEN_NO_SENSHI.get(), Faiz_Rider_Items.FAIZ_BLASTER.get())
                    .IsGlowing().IsBeltGlowing().AddIncompatibleForm(DECADE_RIDEWATCH.asItem()).addAlternative(DECADE_FAIZ_RIDEWATCH.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BLADE_RIDEWATCH = ITEMS.register("blade_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_blade", "zi_o", "ziku_driver_zi_o_belt_blade",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.SATURATION, 40, 5, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Blade_Rider_Items.BLAYBUCKLE.get())
                    .addSummonWeapon(Blade_Rider_Items.BLAYROUZER.get())
                    .addAltForm(Modded_item_core.JINRAI_NO_SENSHI.get(), (RiderFormChangeItem) Modded_item_core.JINRAI_NO_SENSHI_BLADE.get())
                    .addAltWeapon(Blade_Rider_Items.EVOLUTION_CAUCASUS.get(), Blade_Rider_Items.KINGROUZER.get())
                    .addAltWeapon(Blade_Rider_Items.SILVER_EVOLUTION_CAUCASUS.get(), Blade_Rider_Items.KINGROUZER.get())
                    .addAltWeapon(Modded_item_core.HERCULESPADER.get(), Modded_item_core.HERCULESPADER_SWORD.get())
                    .IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> HIBIKI_RIDEWATCH = ITEMS.register("hibiki_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_hibiki", "zi_o", "ziku_driver_zi_o_belt_hibiki",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Hibiki_Rider_Items.HIBIKIDRIVER.get())
                    .addSummonWeapon(Hibiki_Rider_Items.ONGEKIBO_REKKA.get())
                    .addSummonWeapon(Hibiki_Rider_Items.ONGEKIBO_REKKA.get())
                    .addAltForm(Modded_item_core.BAKUEN_NO_SENSHI.get(), (RiderFormChangeItem) Modded_item_core.BAKUEN_NO_SENSHI_HIBIKI.get())
                    .addAltForm(Hibiki_Rider_Items.ARMED_SABER.get(), (RiderFormChangeItem) Hibiki_Rider_Items.HENSHIN_ONSA_ARMED.get())
                    .addAltWeapon(Hibiki_Rider_Items.ARMED_SABER.get(), Hibiki_Rider_Items.ARMED_SABER.get())
                    .IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> KABUTO_RIDEWATCH = ITEMS.register("kabuto_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_kabuto", "zi_o", "ziku_driver_zi_o_belt_kabuto",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Kabuto_Rider_Items.KABUTO_RIDER_BELT.get())
                    .setSummonForm((RiderFormChangeItem) Kabuto_Rider_Items.KABUTO_ZECTER.get())
                    .addSummonWeapon(Kabuto_Rider_Items.KABUTO_KUNAI.get())
                    .addAltForm(Kabuto_Rider_Items.KABUTO_ZECTER.get(), (RiderFormChangeItem) Kabuto_Rider_Items.KABUTO_ZECTER_MASK.get())
                    .addAltWeapon(Kabuto_Rider_Items.HYPER_ZECTER.get(), Kabuto_Rider_Items.PERFECT_ZECTER.get())
                    .IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_RIDEWATCH = ITEMS.register("den_o_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_den_o", "zi_o", "ziku_driver_zi_o_belt_den_o",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false),
                    new MobEffectInstance(Effect_core.PUNCH, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Den_O_Rider_Items.DEN_O_BELT.get())
                    .addSummonWeapon(Den_O_Rider_Items.DEN_GASHER_SWORD.get())
                    .addAltForm(Den_O_Rider_Items.DENKAMEN_SWORD.get(), (RiderFormChangeItem) Den_O_Rider_Items.DEN_O_LINER_FORM.get())
                    .addAltForm(Decade_Rider_Items.DEN_O_CLIMAX_CARD.get(), (RiderFormChangeItem) Den_O_Rider_Items.SUPER_KTAROS.get())
                    .addAltWeapon(Den_O_Rider_Items.RIDER_TICKET.get(), Items.AIR)
                    .addAltWeapon(Den_O_Rider_Items.RIDER_TICKET_ROD.get(), Den_O_Rider_Items.DEN_GASHER_ROD.get())
                    .addAltWeapon(Den_O_Rider_Items.RIDER_TICKET_AX.get(), Den_O_Rider_Items.DEN_GASHER_AX.get())
                    .addAltWeapon(Den_O_Rider_Items.RIDER_TICKET_GUN.get(), Den_O_Rider_Items.DEN_GASHER_GUN.get())
                    .addAltWeapon(Den_O_Rider_Items.RIDER_TICKET_WING.get(), Den_O_Rider_Items.DEN_GASHER_HANDAX.get(), Den_O_Rider_Items.DEN_GASHER_BOOMERANG.get())
                    .addAltWeapon(Den_O_Rider_Items.DENKAMEN_SWORD.get(), Den_O_Rider_Items.DENKAMEN_SWORD.get())
                    .addAltWeapon(Den_O_Rider_Items.RIDER_TICKET_PUDDING.get(), Den_O_Rider_Items.DEN_GASHER_PUDDING.get())
                    .IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> KIVA_RIDEWATCH = ITEMS.register("kiva_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_kiva", "zi_o", "ziku_driver_zi_o_belt_kiva",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Kiva_Rider_Items.KIVAT_BELT.get())
                    .addAltForm(Decade_Rider_Items.KIVA_DOGABAKI_CARD.get(), (RiderFormChangeItem) Kiva_Rider_Items.DOGABAKI.get())
                    .addAltForm(Kiva_Rider_Items.ZANVAT_SWORD.get(), (RiderFormChangeItem) Kiva_Rider_Items.DOGABAKI_EMPEROR.get())
                    .addAltWeapon(Kiva_Rider_Items.GARULU_FUESTLE.get(), Kiva_Rider_Items.GARULU_SABER.get())
                    .addAltWeapon(Kiva_Rider_Items.BASSHAA_FUESTLE.get(), Kiva_Rider_Items.BASSHAA_MAGNUM.get())
                    .addAltWeapon(Kiva_Rider_Items.DOGGA_FUESTLE.get(), Kiva_Rider_Items.DOGGA_HAMMER.get())
                    .addAltWeapon(Decade_Rider_Items.KIVA_DOGABAKI_CARD.get(), Kiva_Rider_Items.BASSHAA_MAGNUM.get(), Kiva_Rider_Items.GARULU_SABER.get())
                    .addAltWeapon(Kiva_Rider_Items.TATSULOT.get(), Kiva_Rider_Items.ZANVAT_SWORD.get())
                    .addAltWeapon(Kiva_Rider_Items.KIVATTE_FUESTLE.get(), Kiva_Rider_Items.ZANVAT_SWORD.get())
                    .addAltWeapon(Kiva_Rider_Items.ZANVAT_SWORD.get(), Kiva_Rider_Items.BASSHAA_MAGNUM.get(), Kiva_Rider_Items.GARULU_SABER.get())
                    .IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> W_RIDEWATCH = ITEMS.register("w_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_w", "zi_o", "ziku_driver_zi_o_belt_w",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) W_Rider_Items.WDRIVER.get())
                    .addAltForm(W_Rider_Items.HEAT_MEMORY.get(), (RiderFormChangeItem) W_Rider_Items.METAL_MEMORY.get())
                    .addAltForm(W_Rider_Items.METAL_MEMORY.get(), (RiderFormChangeItem) W_Rider_Items.HEAT_MEMORY.get())
                    .addAltForm(W_Rider_Items.LUNA_MEMORY.get(), (RiderFormChangeItem) W_Rider_Items.TRIGGER_MEMORY.get())
                    .addAltForm(W_Rider_Items.TRIGGER_MEMORY.get(), (RiderFormChangeItem) W_Rider_Items.LUNA_MEMORY.get())
                    .addAltForm(W_Rider_Items.SKULL_MEMORY.get(), (RiderFormChangeItem) W_Rider_Items.CYCLONE_SKULL_MEMORY.get())
                    .addAltWeapon(W_Rider_Items.HEAT_MEMORY.get(), W_Rider_Items.METAL_SHAFT.get())
                    .addAltWeapon(W_Rider_Items.METAL_MEMORY.get(), W_Rider_Items.METAL_SHAFT.get())
                    .addAltWeapon(W_Rider_Items.LUNA_MEMORY.get(), W_Rider_Items.TRIGGER_MAGNUM.get())
                    .addAltWeapon(W_Rider_Items.TRIGGER_MEMORY.get(), W_Rider_Items.TRIGGER_MAGNUM.get())
                    .addAltWeapon(W_Rider_Items.XTREME_MEMORY.get(), W_Rider_Items.PRISM_BICKER.get(), W_Rider_Items.SHIELD_PRISM_BICKER.get())
                    .addAltWeapon(W_Rider_Items.XTREME_GOLD_MEMORY.get(), W_Rider_Items.PRISM_BICKER.get(), W_Rider_Items.SHIELD_PRISM_BICKER.get())
                    .addAltWeapon(W_Rider_Items.XTREME_ACCEL_MEMORY.get(), W_Rider_Items.PRISM_BICKER.get(), W_Rider_Items.SHIELD_PRISM_BICKER.get())
                    .IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_OOO_RIDEWATCH = ITEMS.register("decade_ooo_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "_decade_ooo", "zi_o", "ziku_driver_zi_o_belt_decade_ooo",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

    public static final DeferredItem<Item> OOO_RIDEWATCH = ITEMS.register("ooo_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_ooo", "zi_o", "ziku_driver_zi_o_belt_ooo",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 30, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 30, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 30, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) OOO_Rider_Items.OOODRIVER.get())
                    .addSummonWeapon(OOO_Rider_Items.MEDAJALIBUR.get())
                    .addAltForm(OOO_Rider_Items.TAKA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KUJAKU_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.CONDOR_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.FOUNDATION_X_TAKA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KUJAKU_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.CONDOR_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_TAKA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KUJAKU_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.CONDOR_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.TAKA_ANKH_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KUJAKU_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.CONDOR_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.KUJAKU_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.CONDOR_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.FOUNDATION_X_KUJAKU_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.CONDOR_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_KUJAKU_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.CONDOR_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.CONDOR_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KUJAKU_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.FOUNDATION_X_CONDOR_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KUJAKU_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_CONDOR_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KUJAKU_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.LION_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.CHEETAH_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.FOUNDATION_X_LION_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.CHEETAH_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_LION_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.CHEETAH_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.TORA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.LION_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.CHEETAH_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.FOUNDATION_X_TORA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.LION_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.CHEETAH_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_TORA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.LION_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.CHEETAH_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.CHEETAH_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.LION_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.FOUNDATION_X_CHEETAH_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.LION_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_CHEETAH_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.LION_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.KUWAGATA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KAMAKIRI_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.FOUNDATION_X_KUWAGATA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KAMAKIRI_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_KUWAGATA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KAMAKIRI_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.KAMAKIRI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KUWAGATA_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.FOUNDATION_X_KAMAKIRI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KUWAGATA_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_KAMAKIRI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KUWAGATA_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.BATTA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KUWAGATA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KAMAKIRI_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.FOUNDATION_X_BATTA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KUWAGATA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KAMAKIRI_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_BATTA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KUWAGATA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KAMAKIRI_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.SAI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.GORILLA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.ZOU_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.FOUNDATION_X_SAI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.GORILLA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.ZOU_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_SAI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.GORILLA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.ZOU_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.GORILLA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SAI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.ZOU_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.FOUNDATION_X_GORILLA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SAI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.ZOU_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_GORILLA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SAI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.ZOU_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZOU_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SAI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.GORILLA_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.FOUNDATION_X_ZOU_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SAI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.GORILLA_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_ZOU_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SAI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.GORILLA_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.SHACHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.UNAGI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TAKO_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.FOUNDATION_X_SHACHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.UNAGI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TAKO_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_SHACHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.UNAGI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TAKO_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.UNAGI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SHACHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TAKO_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.FOUNDATION_X_UNAGI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SHACHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TAKO_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_UNAGI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SHACHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TAKO_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.TAKO_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SHACHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.UNAGI_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.FOUNDATION_X_TAKO_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SHACHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.UNAGI_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_TAKO_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SHACHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.UNAGI_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.PTERA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TRICERA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TYRANNO_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_PTERA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TRICERA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TYRANNO_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.TRICERA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.PTERA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TYRANNO_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_TRICERA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.PTERA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TYRANNO_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.TYRANNO_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.PTERA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TRICERA_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_TYRANNO_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.PTERA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TRICERA_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.COBRA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KAME_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.WANI_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.KAME_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.COBRA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.WANI_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.WANI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.COBRA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KAME_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.MUKADE_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.HACHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.ARI_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_MUKADE_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.HACHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.ARI_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.HACHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.ARI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.MUKADE_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_HACHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.ARI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.MUKADE_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ARI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.HACHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.MUKADE_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ZEUS_ARI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.HACHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.MUKADE_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.EBI_NEW_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KANI_NEW_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SASORI_NEW_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.KANI_NEW_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.EBI_NEW_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SASORI_NEW_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.SASORI_NEW_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.EBI_NEW_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KANI_NEW_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.SAME_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KUJIRA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.OOKAMIUO_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.KUJIRA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SAME_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.OOKAMIUO_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.OOKAMIUO_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SAME_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KUJIRA_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.SHIKA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.GAZELLE_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.USHI_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.GAZELLE_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SHIKA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.USHI_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.USHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SHIKA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.GAZELLE_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.SEIUCHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SHIROKUMA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.PENGUIN_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.SHIROKUMA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SEIUCHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.PENGUIN_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.PENGUIN_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SEIUCHI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SHIROKUMA_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.SUPER_TAKA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SUPER_TORA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SUPER_BATTA_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.SUPER_TORA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SUPER_TAKA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SUPER_BATTA_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.SUPER_BATTA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SUPER_TAKA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SUPER_TORA_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.TAKA_ETERNITY_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KUJAKU_ETERNITY_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.CONDOR_ETERNITY_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.KUJAKU_ETERNITY_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TAKA_ETERNITY_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.CONDOR_ETERNITY_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.CONDOR_ETERNITY_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TAKA_ETERNITY_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.KUJAKU_ETERNITY_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.LOVE_CORE_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.LOVE_CORE2_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.LOVE_CORE3_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.LOVE_CORE2_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.LOVE_CORE_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.LOVE_CORE3_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.LOVE_CORE3_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.LOVE_CORE_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.LOVE_CORE2_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.HABATAKI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TAIGA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.ICHIGO_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.TAIGA_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.HABATAKI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.ICHIGO_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.ICHIGO_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.HABATAKI_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.TAIGA_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.IMAGIN_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.SHOCKER_MEDAL.get())
                    .addAltForm(OOO_Rider_Items.SHOCKER_MEDAL.get(), (RiderFormChangeItem) OOO_Rider_Items.IMAGIN_MEDAL.get())
                    .addAltWeapon(OOO_Rider_Items.TAKA_MEDAL.get(), OOO_Rider_Items.TAJASPINNER.get())
                    .addAltWeapon(OOO_Rider_Items.FOUNDATION_X_TAKA_MEDAL.get(), OOO_Rider_Items.TAJASPINNER.get())
                    .addAltWeapon(OOO_Rider_Items.ZEUS_TAKA_MEDAL.get(), OOO_Rider_Items.TAJASPINNER.get())
                    .addAltWeapon(OOO_Rider_Items.TAKA_ANKH_MEDAL.get(), OOO_Rider_Items.TAJASPINNER.get())
                    .addAltWeapon(OOO_Rider_Items.KUJAKU_MEDAL.get(), OOO_Rider_Items.TAJASPINNER.get())
                    .addAltWeapon(OOO_Rider_Items.FOUNDATION_X_KUJAKU_MEDAL.get(), OOO_Rider_Items.TAJASPINNER.get())
                    .addAltWeapon(OOO_Rider_Items.ZEUS_KUJAKU_MEDAL.get(), OOO_Rider_Items.TAJASPINNER.get())
                    .addAltWeapon(OOO_Rider_Items.CONDOR_MEDAL.get(), OOO_Rider_Items.TAJASPINNER.get())
                    .addAltWeapon(OOO_Rider_Items.FOUNDATION_X_CONDOR_MEDAL.get(), OOO_Rider_Items.TAJASPINNER.get())
                    .addAltWeapon(OOO_Rider_Items.ZEUS_CONDOR_MEDAL.get(), OOO_Rider_Items.TAJASPINNER.get())
                    .addAltWeapon(OOO_Rider_Items.PTERA_MEDAL.get(), OOO_Rider_Items.MEDAGABURYU.get())
                    .addAltWeapon(OOO_Rider_Items.ZEUS_PTERA_MEDAL.get(), OOO_Rider_Items.MEDAGABURYU.get())
                    .addAltWeapon(OOO_Rider_Items.TRICERA_MEDAL.get(), OOO_Rider_Items.MEDAGABURYU.get())
                    .addAltWeapon(OOO_Rider_Items.ZEUS_TRICERA_MEDAL.get(), OOO_Rider_Items.MEDAGABURYU.get())
                    .addAltWeapon(OOO_Rider_Items.TYRANNO_MEDAL.get(), OOO_Rider_Items.MEDAGABURYU.get())
                    .addAltWeapon(OOO_Rider_Items.ZEUS_TYRANNO_MEDAL.get(), OOO_Rider_Items.MEDAGABURYU.get())
                    .addAltWeapon(OOO_Rider_Items.TAKA_ETERNITY_MEDAL.get(), OOO_Rider_Items.TAJASPINNER_ETERNITY.get())
                    .addAltWeapon(OOO_Rider_Items.KUJAKU_ETERNITY_MEDAL.get(), OOO_Rider_Items.TAJASPINNER_ETERNITY.get())
                    .addAltWeapon(OOO_Rider_Items.CONDOR_ETERNITY_MEDAL.get(), OOO_Rider_Items.TAJASPINNER_ETERNITY.get())
                    .IsGlowing().IsBeltGlowing().AddIncompatibleForm(DECADE_RIDEWATCH.asItem()).addAlternative(DECADE_OOO_RIDEWATCH.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> FOURZE_RIDEWATCH = ITEMS.register("fourze_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_fourze", "zi_o", "ziku_driver_zi_o_belt_fourze",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false),
                    new MobEffectInstance(Effect_core.BOOST, 40, 0, true, false),
                    new MobEffectInstance(Effect_core.PUNCH, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Fourze_Rider_Items.FOURZE_DRIVER.get())
                    .addAltForm(Fourze_Rider_Items.ELEK_ASTROSWITCH.get(), (RiderFormChangeItem) Fourze_Rider_Items.FOURZE_ELEK_STATES.get())
                    .addAltForm(Fourze_Rider_Items.FIRE_ASTROSWITCH.get(), (RiderFormChangeItem) Fourze_Rider_Items.FOURZE_FIRE_STATES.get())
                    .addAltForm(Fourze_Rider_Items.MAGNET_ASTROSWITCH_N.get(), (RiderFormChangeItem) Fourze_Rider_Items.MAGNET_ASTROSWITCH_S.get(), (RiderFormChangeItem) Fourze_Rider_Items.FOURZE_MAGNET_STATES.get())
                    .addAltForm(Fourze_Rider_Items.MAGNET_ASTROSWITCH_S.get(), (RiderFormChangeItem) Fourze_Rider_Items.MAGNET_ASTROSWITCH_N.get(), (RiderFormChangeItem) Fourze_Rider_Items.FOURZE_MAGNET_STATES.get())
                    .addAltForm(Fourze_Rider_Items.COSMIC_ASTROSWITCH.get(), (RiderFormChangeItem) Fourze_Rider_Items.FOURZE_COSMIC_STATES.get())
                    .addAltForm(Fourze_Rider_Items.SUPER_ROCKET_ASTROSWITCH.get(), (RiderFormChangeItem) Fourze_Rider_Items.ROCKET_ASTROSWITCH.get(), (RiderFormChangeItem) Fourze_Rider_Items.SUPER_ROCKET_ASTROSWITCH.get(), (RiderFormChangeItem) Fourze_Rider_Items.FOURZE_ROCKET_STATES.get())
                    .addAltForm(Fourze_Rider_Items.SUPER_LAUNCHER_ASTROSWITCH.get(), (RiderFormChangeItem) Fourze_Rider_Items.FOURZE_LAUNCHER_STATES.get())
                    .addAltForm(Fourze_Rider_Items.CLEAR_DRILL_ASTROSWITCH.get(), (RiderFormChangeItem) Fourze_Rider_Items.FOURZE_ROCKET_DRILL_STATES.get())
                    .addAltForm(Fourze_Rider_Items.FUSION_ASTROSWITCH.get(), (RiderFormChangeItem) Fourze_Rider_Items.FUSION_ASTROSWITCH_OG.get(), (RiderFormChangeItem) Fourze_Rider_Items.FOURZE_FUSION_STATES.get())
                    .addAltForm(Fourze_Rider_Items.NADESHIKO_ASTROSWITCH.get(), (RiderFormChangeItem) Fourze_Rider_Items.FUSION_ASTROSWITCH.get(), (RiderFormChangeItem) Fourze_Rider_Items.FOURZE_METEOR_NADESHIKO_FUSION_STATES.get())
                    .addAltWeapon(Fourze_Rider_Items.ELEK_ASTROSWITCH.get(), Fourze_Rider_Items.BILLY_THE_ROD.get())
                    .addAltWeapon(Fourze_Rider_Items.SHIELD_ASTROSWITCH.get(), Fourze_Rider_Items.SHIELD_MODULE.get())
                    .addAltWeapon(Fourze_Rider_Items.FIRE_ASTROSWITCH.get(), Fourze_Rider_Items.HEE_HACKGUN.get())
                    .addAltWeapon(Fourze_Rider_Items.COSMIC_ASTROSWITCH.get(), Fourze_Rider_Items.BARIZUN_SWORD.get())
                    .IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> WIZARD_RIDEWATCH = ITEMS.register("wizard_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_wizard", "geiz", "ziku_driver_geiz_belt_wizard",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Wizard_Rider_Items.WIZARDRIVER.get())
                    .addSummonWeapon(Wizard_Rider_Items.WIZARSWORDSGUN.get())
                    .addAltForm(Wizard_Rider_Items.FINISH_STRIKE_RING.get(), (RiderFormChangeItem) Wizard_Rider_Items.FINISH_STRIKE_RING_NO_HOPE.get())
                    .addAltForm(Wizard_Rider_Items.HOPE_RING.get(), (RiderFormChangeItem) Wizard_Rider_Items.FINISH_STRIKE_RING.get())
                    .addAltForm(Wizard_Rider_Items.FALCO_RING.get(), (RiderFormChangeItem) Wizard_Rider_Items.FALCO_RING_WIZARD.get())
                    .addAltForm(Wizard_Rider_Items.BUFFA_RING.get(), (RiderFormChangeItem) Wizard_Rider_Items.BUFFA_RING_WIZARD.get())
                    .addAltWeapon(Wizard_Rider_Items.INFINITY_WIZARD_RING.get(), Wizard_Rider_Items.AXCALIBUR.get())
                    .IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GAIM_RIDEWATCH = ITEMS.register("gaim_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_gaim", "zi_o", "ziku_driver_zi_o_belt_gaim",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.SATURATION, 40, 5, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Gaim_Rider_Items.SENGOKU_DRIVER_GAIM.get())
                    .addSummonWeapon(Gaim_Rider_Items.DAIDAIMARU.get())
                    .addSummonWeapon(Gaim_Rider_Items.MUSOU_SABER.get())
                    .addAltWeapon(Gaim_Rider_Items.MATSUBOKKURI_LOCKSEED.get(), Gaim_Rider_Items.KAGEMATSU.get())
                    .addAltWeapon(Gaim_Rider_Items.KURUMI_LOCKSEED.get(), Items.AIR)
                    .addAltWeapon(Gaim_Rider_Items.DONGURI_LOCKSEED.get(), Gaim_Rider_Items.DONKACHI.get())
                    .addAltWeapon(Gaim_Rider_Items.MELON_LOCKSEED.get(), Gaim_Rider_Items.MELON_DEFENDER.get())
                    .addAltWeapon(Gaim_Rider_Items.PINE_LOCKSEED.get(), Gaim_Rider_Items.PINE_IRON.get())
                    .addAltWeapon(Gaim_Rider_Items.ICHIGO_LOCKSEED.get(), Gaim_Rider_Items.ICHIGO_KUNAI.get(), Gaim_Rider_Items.ICHIGO_KUNAI.get())
                    .addAltWeapon(Gaim_Rider_Items.BANANA_LOCKSEED.get(), Gaim_Rider_Items.BANA_SPEAR.get())
                    .addAltWeapon(Gaim_Rider_Items.BUDOU_LOCKSEED.get(), Gaim_Rider_Items.BUDOU_RYUHOU.get())
                    .addAltWeapon(Gaim_Rider_Items.SUIKA_LOCKSEED.get(), Gaim_Rider_Items.SUIKA_SOJINTO.get())
                    .addAltWeapon(Gaim_Rider_Items.MANGO_LOCKSEED.get(), Gaim_Rider_Items.MANGO_PUNISHER.get())
                    .addAltWeapon(Gaim_Rider_Items.DURIAN_LOCKSEED.get(), Gaim_Rider_Items.DURI_NOKO.get(), Gaim_Rider_Items.DURI_NOKO.get())
                    .addAltWeapon(Gaim_Rider_Items.KIWI_LOCKSEED.get(), Gaim_Rider_Items.KIWI_GEKIRIN.get())
                    .addAltWeapon(Gaim_Rider_Items.LEMON_LOCKSEED.get(), Gaim_Rider_Items.LEMON_RAPIER.get())
                    .addAltForm(Gaim_Rider_Items.LEMON_ENERGY_LOCKSEED.get(), (RiderFormChangeItem) Gaim_Rider_Items.JIMBER_LEMON_ENERGY_LOCKSEED.get(), (RiderFormChangeItem) Gaim_Rider_Items.JIMBER_GAIM_CORE.get())
                    .addAltWeapon(Gaim_Rider_Items.LEMON_ENERGY_LOCKSEED.get(), Gaim_Rider_Items.SONIC_ARROW.get())
                    .addAltForm(Gaim_Rider_Items.CHERRY_ENERGY_LOCKSEED.get(), (RiderFormChangeItem) Gaim_Rider_Items.JIMBER_CHERRY_ENERGY_LOCKSEED.get(), (RiderFormChangeItem) Gaim_Rider_Items.JIMBER_GAIM_CORE.get())
                    .addAltWeapon(Gaim_Rider_Items.CHERRY_ENERGY_LOCKSEED.get(), Gaim_Rider_Items.SONIC_ARROW.get())
                    .addAltForm(Gaim_Rider_Items.PEACH_ENERGY_LOCKSEED.get(), (RiderFormChangeItem) Gaim_Rider_Items.JIMBER_PEACH_ENERGY_LOCKSEED.get(), (RiderFormChangeItem) Gaim_Rider_Items.JIMBER_GAIM_CORE.get())
                    .addAltWeapon(Gaim_Rider_Items.PEACH_ENERGY_LOCKSEED.get(), Gaim_Rider_Items.SONIC_ARROW.get())
                    .addAltForm(Gaim_Rider_Items.MELON_ENERGY_LOCKSEED.get(), (RiderFormChangeItem) Gaim_Rider_Items.JIMBER_MELON_ENERGY_LOCKSEED.get(), (RiderFormChangeItem) Gaim_Rider_Items.JIMBER_GAIM_CORE.get())
                    .addAltWeapon(Gaim_Rider_Items.MELON_ENERGY_LOCKSEED.get(), Gaim_Rider_Items.SONIC_ARROW.get())
                    .addAltForm(Gaim_Rider_Items.DRAGON_FRUITS_ENERGY_LOCKSEED.get(), (RiderFormChangeItem) Gaim_Rider_Items.JIMBER_DRAGON_FRUITS_ENERGY_LOCKSEED.get(), (RiderFormChangeItem) Gaim_Rider_Items.JIMBER_GAIM_CORE.get())
                    .addAltWeapon(Gaim_Rider_Items.DRAGON_FRUITS_ENERGY_LOCKSEED.get(), Gaim_Rider_Items.SONIC_ARROW.get())
                    .addAltForm(Gaim_Rider_Items.MARRON_ENERGY_LOCKSEED.get(), (RiderFormChangeItem) Gaim_Rider_Items.JIMBER_GAIM_CORE.get())
                    .addAltWeapon(Gaim_Rider_Items.MARRON_ENERGY_LOCKSEED.get(), Items.AIR)
                    .addAltWeapon(Gaim_Rider_Items.KACHIDOKI_LOCKSEED.get(), Gaim_Rider_Items.DJ_GUN.get())
                    .addAltWeapon(Gaim_Rider_Items.KIWAMI_LOCKSEED.get(), Gaim_Rider_Items.DJ_GUN_TAIKEN_MODE.get())
                    .addAltWeapon(Gaim_Rider_Items.BLOOD_ORANGE_LOCKSEED.get(), Gaim_Rider_Items.BLOOD_DAIDAIMARU.get())
                    .addAltWeapon(Gaim_Rider_Items.FIFTEEN_LOCKSEED.get(), Gaim_Rider_Items.YOMIMARU.get())
                    .addAltWeapon(Gaim_Rider_Items.GOLDEN_RINGO_LOCKSEED.get(), Gaim_Rider_Items.SWORD_BRINGER.get())
                    .addAltWeapon(Gaim_Rider_Items.SILVER_RINGO_LOCKSEED.get(), Gaim_Rider_Items.SOUGINJOU.get())
                    .addAltWeapon(Gaim_Rider_Items.BLACK_RINGO_LOCKSEED.get(), Gaim_Rider_Items.DARK_DAIDAIMARU.get())
                    .addAltForm(Gaim_Rider_Items.FORBIBBEN_LOCKSEED.get(), (RiderFormChangeItem) Gaim_Rider_Items.FORBIBBEN_LOCKSEED_BASE.get())
                    .addAltWeapon(Gaim_Rider_Items.FORBIBBEN_LOCKSEED.get(), Gaim_Rider_Items.APPLE_REFLECTER.get())
                    .addAltWeapon(Gaim_Rider_Items.MAJA_LOCKSEED.get(), Gaim_Rider_Items.MAJAS_SWORD.get())
                    .addAltWeapon(Gaim_Rider_Items.KABI_ORANGE_LOCKSEED.get(), Gaim_Rider_Items.KABI_DAIDAIMARU.get())
                    .addAltWeapon(Gaim_Rider_Items.FRESH_ORANGE_LOCKSEED.get(), Gaim_Rider_Items.DAIDAIMARU.get(), Gaim_Rider_Items.DAIDAIMARU.get())
                    .addAltWeapon(Gaim_Rider_Items.HELEIM_LOCKSEED.get(), Gaim_Rider_Items.HELLS_CANE.get())
                    .addAltWeapon(Gaim_Rider_Items.NATSUMIKAN_LOCKSEED.get(), Gaim_Rider_Items.MUSOU_SABER.get(), Gaim_Rider_Items.DAIDAIMARU.get())
                    .addAltWeapon(Gaim_Rider_Items.PROTO_DONGURI_LOCKSEED.get(), Gaim_Rider_Items.DONKACHI.get())
                    .addAltWeapon(Gaim_Rider_Items.PROTO_ORANGE_LOCKSEED.get(), Gaim_Rider_Items.DAIDAIMARU.get(), Gaim_Rider_Items.MUSOU_SABER.get())
                    .addAltWeapon(Gaim_Rider_Items.PROTO_BANANA_LOCKSEED.get(), Gaim_Rider_Items.BANA_SPEAR.get())
                    .addAltWeapon(Gaim_Rider_Items.PROTO_BUDOU_LOCKSEED.get(), Gaim_Rider_Items.BUDOU_RYUHOU.get())
                    .addAltWeapon(Gaim_Rider_Items.PROTO_DURIAN_LOCKSEED.get(), Gaim_Rider_Items.DURI_NOKO.get(), Gaim_Rider_Items.DURI_NOKO.get())
                    .addAltForm(Gaim_Rider_Items.DARK_LEMON_ENERGY_LOCKSEED.get(), (RiderFormChangeItem) Gaim_Rider_Items.GAIM_YAMI_CORE.get())
                    .addAltWeapon(Gaim_Rider_Items.DARK_LEMON_ENERGY_LOCKSEED.get(), Gaim_Rider_Items.MUSOU_SABER.get())
                    .addAltWeapon(Gaim_Rider_Items.DRIVE_LOCKSEED.get(), Drive_Rider_Items.HANDLE_KEN.get())
                    .addAltWeapon(Gaim_Rider_Items.GAIM_LOCKSEED.get(), Gaim_Rider_Items.MUSOU_SABER.get())
                    .addAltWeapon(Gaim_Rider_Items.WIZARD_LOCKSEED.get(), Wizard_Rider_Items.WIZARSWORDSGUN.get())
                    .addAltWeapon(Gaim_Rider_Items.FOURZE_LOCKSEED.get(), Fourze_Rider_Items.BARIZUN_SWORD.get())
                    .addAltWeapon(Gaim_Rider_Items.OOO_LOCKSEED.get(), OOO_Rider_Items.MEDAJALIBUR.get())
                    .addAltWeapon(Gaim_Rider_Items.W_LOCKSEED.get(), W_Rider_Items.TRIGGER_MAGNUM.get())
                    .addAltWeapon(Gaim_Rider_Items.DECADE_LOCKSEED.get(), Decade_Rider_Items.RIDE_BOOKER.get())
                    .addAltWeapon(Gaim_Rider_Items.KIVA_LOCKSEED.get(), Gaim_Rider_Items.MUSOU_SABER.get())
                    .addAltWeapon(Gaim_Rider_Items.DEN_O_LOCKSEED.get(), Den_O_Rider_Items.DEN_GASHER_SWORD.get())
                    .addAltWeapon(Gaim_Rider_Items.KABUTO_LOCKSEED.get(), Kabuto_Rider_Items.KABUTO_KUNAI.get())
                    .addAltWeapon(Gaim_Rider_Items.HIBIKI_LOCKSEED.get(), Hibiki_Rider_Items.ONGEKIBO_REKKA.get(), Hibiki_Rider_Items.ONGEKIBO_REKKA.get())
                    .addAltWeapon(Gaim_Rider_Items.BLADE_LOCKSEED.get(), Blade_Rider_Items.BLAYROUZER.get())
                    .addAltWeapon(Gaim_Rider_Items.FAIZ_LOCKSEED.get(), Faiz_Rider_Items.FAIZ_EDGE.get())
                    .addAltWeapon(Gaim_Rider_Items.RYUKI_LOCKSEED.get(), Ryuki_Rider_Items.DRAG_SABER.get())
                    .addAltWeapon(Gaim_Rider_Items.AGITO_LOCKSEED.get(), Agito_Rider_Items.FLAME_SABER.get(), Agito_Rider_Items.STORM_HALBERD.get())
                    .addAltWeapon(Gaim_Rider_Items.KUUGA_LOCKSEED.get(), Gaim_Rider_Items.MUSOU_SABER.get())
                    .addAltWeapon(Gaim_Rider_Items.RIDER_ICHIGO_LOCKSEED.get(), Gaim_Rider_Items.MUSOU_SABER.get())
                    .addAltWeapon(Gaim_Rider_Items.SHOWA_RIDER_LOCKSEED.get(), Gaim_Rider_Items.MUSOU_SABER.get())
                    .addAltWeapon(Gaim_Rider_Items.HEISEI_RIDER_LOCKSEED.get(), Gaim_Rider_Items.DAIDAIMARU.get(), Gaim_Rider_Items.MUSOU_SABER.get())
                    .IsGlowing().IsBeltGlowing().ChangeModel("default_rider_plusbelt_and_wings.geo.json").AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DRIVE_RIDEWATCH = ITEMS.register("drive_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_drive", "geiz", "ziku_driver_geiz_belt_drive",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Drive_Rider_Items.DRIVE_DRIVER.get())
                    .addSummonWeapon(Drive_Rider_Items.HANDLE_KEN.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_PROTO_SPEED.get(), Items.AIR)
                    .addAltWeapon(Drive_Rider_Items.SHIFT_WILD.get(), Items.AIR)
                    .addAltWeapon(Drive_Rider_Items.SHIFT_TECHNIC.get(), Drive_Rider_Items.DOOR_JU.get())
                    .addAltBelt(Drive_Rider_Items.MACH_DRIVER_HONOH_DRIVE.get(), (RiderDriverItem) Drive_Rider_Items.MACH_DRIVER_HONOH_DRIVE.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_FORMULA.get(), Drive_Rider_Items.TRAILER_HOU.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_TRIDORON.get(), Drive_Rider_Items.TRAILER_HOU.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_SPECIAL.get(), Drive_Rider_Items.SHINGOU_AX.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_FRUITS.get(), Gaim_Rider_Items.DAIDAIMARU.get(), Gaim_Rider_Items.MUSOU_SABER.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_SPEED_WILD_TECHNIC.get(), Items.AIR)
                    .addAltWeapon(Drive_Rider_Items.SHIFT_JUSTICE_HUNTER.get(), Drive_Rider_Items.JUSTICE_CAGE.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_DREAM_VAGAS.get(), Drive_Rider_Items.DRUM_SHIELD_RED.get(), Drive_Rider_Items.DRUM_SHIELD_GREEN.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_MASSIVE_MONSTER.get(), Drive_Rider_Items.MONSTER_TOP.get(), Drive_Rider_Items.MONSTER_BOTTOM.get())
                    .addAltForm(Drive_Rider_Items.SHIFT_RUMBLE_DUMP.get(), (RiderFormChangeItem) Drive_Rider_Items.SHIFT_WILD.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_RUMBLE_DUMP.get(), Drive_Rider_Items.RUMBLE_SMASHER.get())
                    .addAltForm(Drive_Rider_Items.SHIFT_MAD_DOCTOR.get(), (RiderFormChangeItem) Drive_Rider_Items.SHIFT_WILD.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_MAD_DOCTOR.get(), Drive_Rider_Items.CURE_QUICKER.get())
                    .addAltForm(Drive_Rider_Items.SHIFT_HOOKING_WRECKER.get(), (RiderFormChangeItem) Drive_Rider_Items.SHIFT_WILD.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_HOOKING_WRECKER.get(), Items.AIR)
                    .addAltForm(Drive_Rider_Items.SHIFT_FIRE_BRAVER.get(), (RiderFormChangeItem) Drive_Rider_Items.SHIFT_TECHNIC.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_FIRE_BRAVER.get(), Drive_Rider_Items.DOOR_JU.get())
                    .addAltForm(Drive_Rider_Items.SHIFT_ROLLING_GRAVITY.get(), (RiderFormChangeItem) Drive_Rider_Items.SHIFT_TECHNIC.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_ROLLING_GRAVITY.get(), Drive_Rider_Items.TEN_TON_WEIGHT.get())
                    .addAltForm(Drive_Rider_Items.SHIFT_ROAD_WINTER.get(), (RiderFormChangeItem) Drive_Rider_Items.SHIFT_TECHNIC.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_ROAD_WINTER.get(), Drive_Rider_Items.DOOR_JU.get())
                    .addAltForm(Drive_Rider_Items.SHIFT_MANTARN_F01.get(), (RiderFormChangeItem) Drive_Rider_Items.SHIFT_FORMULA.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_MANTARN_F01.get(), Drive_Rider_Items.TRAILER_HOU.get())
                    .addAltForm(Drive_Rider_Items.SHIFT_JACKY_F02.get(), (RiderFormChangeItem) Drive_Rider_Items.SHIFT_FORMULA.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_JACKY_F02.get(), Drive_Rider_Items.TRAILER_HOU.get())
                    .addAltForm(Drive_Rider_Items.SHIFT_SPARNER_F03.get(), (RiderFormChangeItem) Drive_Rider_Items.SHIFT_FORMULA.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_SPARNER_F03.get(), Drive_Rider_Items.TRAILER_HOU.get())
                    .addAltForm(Drive_Rider_Items.SHIFT_MEGA_MAX_FLARE.get(), (RiderFormChangeItem) Drive_Rider_Items.SHIFT_HIGH_SPEED.get())
                    .addAltBelt(Drive_Rider_Items.TRIDORON_KEY.get(), (RiderDriverItem) Drive_Rider_Items.MACH_DRIVER_HONOH_DRIVE.get())
                    .IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_GHOST_RIDEWATCH = ITEMS.register("decade_ghost_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "_decade_ghost", "zi_o", "ziku_driver_zi_o_belt_decade_ghost",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

    public static final DeferredItem<Item> GHOST_RIDEWATCH_ZI_O = ITEMS.register("ghost_ridewatch_zi_o",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "_ghost", "zi_o", "ziku_driver_zi_o_belt_ghost",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.AddIncompatibleForm(DECADE_RIDEWATCH.asItem()).addAlternative(DECADE_GHOST_RIDEWATCH.get())
                    .IsGlowing().IsBeltGlowing().model_has_different_name("ghost_ridewatch").has_basic_model());

    public static final DeferredItem<Item> GHOST_RIDEWATCH = ITEMS.register("ghost_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_ghost", "geiz", "ziku_driver_geiz_belt_ghost",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Ghost_Rider_Items.GHOST_DRIVER.get())
                    .addSummonWeapon(Ghost_Rider_Items.GAN_GUN_SABER_BLADE.get())
                    .addAltForm(Ghost_Rider_Items.BOOST_GHOST_EYECON.get(), (RiderFormChangeItem) Ghost_Rider_Items.BOOST_DAMASHII.get())
                    .addAltWeapon(Ghost_Rider_Items.BOOST_GHOST_EYECON.get(), Ghost_Rider_Items.SUNGLASSESLASHER.get())
                    .addAltForm(Ghost_Rider_Items.TOUSAN_GHOST_EYECON.get(), (RiderFormChangeItem) Ghost_Rider_Items.BOOST_GHOST_EYECON.get(), (RiderFormChangeItem) Ghost_Rider_Items.BOOST_DAMASHII.get())
                    .addAltWeapon(Ghost_Rider_Items.TOUSAN_GHOST_EYECON.get(), Ghost_Rider_Items.SUNGLASSESLASHER.get())
                    .addAltBelt(Ghost_Rider_Items.EYECON_DRIVER_G.get(), (RiderDriverItem) Ghost_Rider_Items.EYECON_DRIVER_G.get())
                    .addAltForm(Ghost_Rider_Items.MUGEN_GHOST_EYECON.get(), (RiderFormChangeItem) Ghost_Rider_Items.MUGEN_DAMASHII.get(), (RiderFormChangeItem) Ghost_Rider_Items.MUGEN_GHOST_EYECON.get())
                    .addAltForm(Ghost_Rider_Items.SPECTER_GHOST_EYECON.get(), (RiderFormChangeItem) Ghost_Rider_Items.SPECTER_DAMASHII.get())
                    .addAltForm(Ghost_Rider_Items.NECROM_GHOST_EYECON.get(), (RiderFormChangeItem) Ghost_Rider_Items.NECROM_DAMASHII.get())
                    .addAltForm(Ghost_Rider_Items.DARK_GHOST_EYECON.get(), (RiderFormChangeItem) Ghost_Rider_Items.DARK_DAMASHII.get())
                    .addAltForm(Ghost_Rider_Items.ZERO_SPECTER_GHOST_EYECON.get(), (RiderFormChangeItem) Ghost_Rider_Items.ZERO_SPECTER_DAMASHII.get())
                    .addAltForm(Ghost_Rider_Items.PROTO_ORE_GHOST_EYECON.get(), (RiderFormChangeItem) Ghost_Rider_Items.PROTO_ORE_DAMASHII.get())
                    .addAltForm(Ghost_Rider_Items.KANON_SPECTER_GHOST_EYECON.get(), (RiderFormChangeItem) Ghost_Rider_Items.KANON_SPECTER_DAMASHII.get())
                    .addAltWeapon(Ghost_Rider_Items.MUSASHI_GHOST_EYECON.get(), Ghost_Rider_Items.GAN_GUN_SABER_NITOURYU.get(), Ghost_Rider_Items.GAN_GUN_SABER_NITOURYU_2.get())
                    .addAltWeapon(Ghost_Rider_Items.EDISON_GHOST_EYECON.get(), Ghost_Rider_Items.GAN_GUN_SABER_GUN.get())
                    .addAltWeapon(Ghost_Rider_Items.ROBIN_GHOST_EYECON.get(), Ghost_Rider_Items.GAN_GUN_SABER_CONDOR_DENWOR.get())
                    .addAltWeapon(Ghost_Rider_Items.NEWTON_GHOST_EYECON.get(), Ghost_Rider_Items.GAN_GUN_SABER_NAGINATA.get())
                    .addAltWeapon(Ghost_Rider_Items.BILLY_THE_KID_GHOST_EYECON.get(), Ghost_Rider_Items.GAN_GUN_SABER_RIFLE.get())
                    .addAltWeapon(Ghost_Rider_Items.BEETHOVEN_GHOST_EYECON.get(), Ghost_Rider_Items.GAN_GUN_SABER_NITOURYU.get(), Ghost_Rider_Items.GAN_GUN_SABER_NITOURYU_2.get())
                    .addAltWeapon(Ghost_Rider_Items.BENKEI_GHOST_EYECON.get(), Ghost_Rider_Items.GAN_GUN_SABER_HAMMER.get())
                    .addAltForm(Ghost_Rider_Items.GOEMON_GHOST_EYECON.get(), (RiderFormChangeItem) Ghost_Rider_Items.BOOST_GHOST_EYECON.get())
                    .addAltWeapon(Ghost_Rider_Items.GOEMON_GHOST_EYECON.get(), Ghost_Rider_Items.SUNGLASSESLASHER.get())
                    .addAltForm(Ghost_Rider_Items.RYOMA_GHOST_EYECON.get(), (RiderFormChangeItem) Ghost_Rider_Items.BOOST_GHOST_EYECON.get())
                    .addAltWeapon(Ghost_Rider_Items.RYOMA_GHOST_EYECON.get(), Ghost_Rider_Items.SUNGLASSESLASHER.get())
                    .addAltForm(Ghost_Rider_Items.HIMIKO_GHOST_EYECON.get(), (RiderFormChangeItem) Ghost_Rider_Items.BOOST_GHOST_EYECON.get())
                    .addAltWeapon(Ghost_Rider_Items.HIMIKO_GHOST_EYECON.get(), Ghost_Rider_Items.SUNGLASSESLASHER.get())
                    .addAltForm(Ghost_Rider_Items.DARWIN_GHOST_EYECON.get(), (RiderFormChangeItem) Ghost_Rider_Items.BOOST_GHOST_EYECON.get())
                    .addAltWeapon(Ghost_Rider_Items.DARWIN_GHOST_EYECON.get(), Ghost_Rider_Items.SUNGLASSESLASHER.get())
                    .addAltWeapon(Ghost_Rider_Items.RYUKI_GHOST_EYECON.get(), Ryuki_Rider_Items.DRAG_SABER.get())
                    .addAltWeapon(Ghost_Rider_Items.FAIZ_GHOST_EYECON.get(), Faiz_Rider_Items.FAIZ_EDGE.get())
                    .addAltWeapon(Ghost_Rider_Items.BLADE_GHOST_EYECON.get(), Blade_Rider_Items.BLAYROUZER.get())
                    .addAltWeapon(Ghost_Rider_Items.HIBIKI_GHOST_EYECON.get(), Hibiki_Rider_Items.ONGEKIBO_REKKA.get(), Hibiki_Rider_Items.ONGEKIBO_REKKA.get())
                    .addAltWeapon(Ghost_Rider_Items.KABUTO_GHOST_EYECON.get(), Kabuto_Rider_Items.KABUTO_KUNAI.get())
                    .addAltWeapon(Ghost_Rider_Items.DEN_O_GHOST_EYECON.get(), Den_O_Rider_Items.DEN_GASHER_SWORD.get())
                    .addAltWeapon(Ghost_Rider_Items.DECADE_GHOST_EYECON.get(), Decade_Rider_Items.RIDE_BOOKER.get())
                    .addAltWeapon(Ghost_Rider_Items.OOO_GHOST_EYECON.get(), OOO_Rider_Items.MEDAJALIBUR.get())
                    .addAltWeapon(Ghost_Rider_Items.WIZARD_GHOST_EYECON.get(), Wizard_Rider_Items.WIZARSWORDSGUN.get())
                    .addAltWeapon(Ghost_Rider_Items.GAIM_GHOST_EYECON.get(), Gaim_Rider_Items.DAIDAIMARU.get(), Gaim_Rider_Items.MUSOU_SABER.get())
                    .addAltWeapon(Ghost_Rider_Items.DRIVE_GHOST_EYECON.get(), Drive_Rider_Items.HANDLE_KEN.get(), Drive_Rider_Items.DOOR_JU.get())
                    .addAltForm(Ghost_Rider_Items.FOURTYFIVE_HEISEI_GHOST_EYECON.get(), (RiderFormChangeItem) Ghost_Rider_Items.FOURTYFIVE_HEISEI_DAMASHII.get(), (RiderFormChangeItem) Ghost_Rider_Items.FOURTYFIVE_HEISEI_GHOST_EYECON.get())
                    .IsGlowing().IsBeltGlowing().addAlternative(GHOST_RIDEWATCH_ZI_O.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_EX_AID_RIDEWATCH_R = ITEMS.register("decade_ex_aid_ridewatch_r",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "_decade_ex_aid_r", "zi_o", "ziku_driver_zi_o_belt_decade_ex_aid",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

    public static final DeferredItem<Item> DECADE_EX_AID_RIDEWATCH_L = ITEMS.register("decade_ex_aid_ridewatch_l",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "_decade_ex_aid_l", "zi_o", "ziku_driver_zi_o_belt_decade_ex_aid",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().addSwitchForm(DECADE_EX_AID_RIDEWATCH_R.get()).ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

    public static final DeferredItem<Item> EX_AID_RIDEWATCH_GEIZ = ITEMS.register("ex_aid_ridewatch_geiz",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "_ex_aid", "geiz", "ziku_driver_geiz_belt_ex_aid",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(Effect_core.PUNCH, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().model_has_different_name("ex_aid_ridewatch").has_basic_model());

    public static final DeferredItem<Item> EX_AID_RIDEWATCH = ITEMS.register("ex_aid_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_ex_aid", "zi_o", "ziku_driver_zi_o_belt_ex_aid",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false),
                    new MobEffectInstance(Effect_core.PUNCH, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Ex_Aid_Rider_Items.GAMER_DRIVER_EX_AID.get())
                    .setSummonForm((RiderFormChangeItem) Ex_Aid_Rider_Items.MIGHTY_ACTION_X_GASHAT.get())
                    .addSummonWeapon(Ex_Aid_Rider_Items.GASHACON_BREAKER.get())
                    .addAltForm(Ex_Aid_Rider_Items.MIGHTY_ACTION_X_GASHAT.get(), (RiderFormChangeItem) Ex_Aid_Rider_Items.MIGHTY_ACTION_X_GASHAT_LV_1.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.MIGHTY_ACTION_X_GASHAT.get(), Items.AIR)
                    .addAltWeapon(Ex_Aid_Rider_Items.DRAGO_KNIGHT_HUNTER_Z_GASHAT.get(), Items.AIR)
                    .addAltForm(Ex_Aid_Rider_Items.DRAGO_KNIGHT_HUNTER_Z_GASHA_TROPHY.get(), (RiderFormChangeItem) Ex_Aid_Rider_Items.DRAGO_KNIGHT_HUNTER_Z_GASHAT_FANG.get())
                    .addAltForm(Ex_Aid_Rider_Items.PROTO_DRAGO_KNIGHT_HUNTER_Z_GASHAT.get(), (RiderFormChangeItem) Ex_Aid_Rider_Items.PROTO_DRAGO_KNIGHT_HUNTER_Z_GASHAT_FANG.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.MIGHTY_BROTHERS_XX_GASHAT.get(), Ex_Aid_Rider_Items.GASHACON_KEY_SLASHER.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.MAXIMUM_MIGHTY_X_GASHAT.get(), Ex_Aid_Rider_Items.GASHACON_KEY_SLASHER.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.HYPER_MUTEKI_GASHAT.get(), Ex_Aid_Rider_Items.GASHACON_KEY_SLASHER.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.KAIGEN_GHOST_GASHAT.get(), Ghost_Rider_Items.GAN_GUN_SABER_BLADE.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.FULL_THROTTLE_DRIVE_GASHAT.get(), Drive_Rider_Items.HANDLE_KEN.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.TOUKENDEN_GAIM_GASHAT.get(), Gaim_Rider_Items.DAIDAIMARU.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.BERCODE_WARRIOR_DECADE_GASHAT.get(), Decade_Rider_Items.RIDE_BOOKER.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.INSECT_WARS_KABUTO_GASHAT.get(), Kabuto_Rider_Items.KABUTO_KUNAI.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.MIRROR_LABRYINTH_RYUKI_GASHAT.get(), Ryuki_Rider_Items.DRAG_SABER.get())
                    .AddIncompatibleForm(DECADE_RIDEWATCH.asItem()).AddIncompatibleForm(DECADE_EX_AID_RIDEWATCH_L.asItem()).AddIncompatibleForm(DECADE_EX_AID_RIDEWATCH_R.asItem())
                    .IsGlowing().IsBeltGlowing().addAlternative(DECADE_EX_AID_RIDEWATCH_L.get()).addAlternative(EX_AID_RIDEWATCH_GEIZ.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_BUILD_RIDEWATCH = ITEMS.register("decade_build_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "_decade_build", "zi_o", "ziku_driver_zi_o_belt_decade_build",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

    public static final DeferredItem<Item> BUILD_RIDEWATCH_GEIZ = ITEMS.register("build_ridewatch_geiz",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "_build", "geiz", "ziku_driver_geiz_belt_build",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }
                    .addAlternative(DECADE_BUILD_RIDEWATCH.get())
                    .IsGlowing().IsBeltGlowing().model_has_different_name("build_ridewatch").has_basic_model());

    public static final DeferredItem<Item> BUILD_RIDEWATCH = ITEMS.register("build_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_build", "zi_o", "ziku_driver_zi_o_belt_build",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Build_Rider_Items.BUILD_DRIVER.get()).addSummonWeapon(Build_Rider_Items.DRILL_CRUSHER.get())
                    .addAltForm(Build_Rider_Items.GORILLA_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.DIAMOND_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.DIAMOND_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.GORILLA_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.TAKA_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.GATLING_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.GATLING_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.TAKA_FULL_BOTTLE.get())
                    .addAltWeapon(Build_Rider_Items.TAKA_FULL_BOTTLE.get(), Build_Rider_Items.HAWK_GATLINGER.get())
                    .addAltWeapon(Build_Rider_Items.GATLING_FULL_BOTTLE.get(), Build_Rider_Items.HAWK_GATLINGER.get())
                    .addAltForm(Build_Rider_Items.NINJA_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.COMIC_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.COMIC_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.NINJA_FULL_BOTTLE.get())
                    .addAltWeapon(Build_Rider_Items.NINJA_FULL_BOTTLE.get(), Build_Rider_Items.KOMA_NINPOUTOU.get())
                    .addAltWeapon(Build_Rider_Items.COMIC_FULL_BOTTLE.get(), Build_Rider_Items.KOMA_NINPOUTOU.get())
                    .addAltForm(Build_Rider_Items.PANDA_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.ROCKET_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.ROCKET_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.PANDA_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.HARINEZUMI_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.SHOUBOUSHA_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.SHOUBOUSHA_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.HARINEZUMI_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.LION_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.SOUJIKI_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.SOUJIKI_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.LION_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.DRAGON_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.DRAGON_FULL_BOTTLE_BUILD.get(), (RiderFormChangeItem) Build_Rider_Items.LOCK_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.LOCK_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.DRAGON_FULL_BOTTLE_BUILD.get())
                    .addAltForm(Build_Rider_Items.KAIZOKU_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.DENSHA_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.DENSHA_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.KAIZOKU_FULL_BOTTLE.get())
                    .addAltWeapon(Build_Rider_Items.KAIZOKU_FULL_BOTTLE.get(), Build_Rider_Items.KAIZOKU_HASSYAR.get())
                    .addAltWeapon(Build_Rider_Items.DENSHA_FULL_BOTTLE.get(), Build_Rider_Items.KAIZOKU_HASSYAR.get())
                    .addAltForm(Build_Rider_Items.OCTOPUS_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.LIGHT_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.LIGHT_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.OCTOPUS_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.PHOENIX_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.ROBOT_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.ROBOT_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.PHOENIX_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.WOLF_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.SMAPHO_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.SMAPHO_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.WOLF_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.UNICORN_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.KESHIGOMU_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.KESHIGOMU_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.UNICORN_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.ROSE_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.HELICOPTER_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.HELICOPTER_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.ROSE_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.TURTLE_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.WATCH_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.WATCH_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.TURTLE_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.KUMA_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.TELEVI_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.TELEVI_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.KUMA_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.KABUTOMUSHI_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.CAMERA_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.CAMERA_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.KABUTOMUSHI_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.SPIDER_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.REIZOUKO_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.REIZOUKO_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.SPIDER_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.DOG_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.MIC_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.MIC_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.DOG_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.SANTA_CLAUS_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.CAKE_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.CAKE_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.SANTA_CLAUS_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.TORA_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.UFO_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.UFO_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.TORA_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.KUJIRA_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.JET_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.JET_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.KUJIRA_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.SHIKA_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.PYRAMID_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.PYRAMID_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.SHIKA_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.KIRIN_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.SENPUUKI_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.SENPUUKI_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.KIRIN_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.PENGUIN_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.SKEBO_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.SKEBO_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.PENGUIN_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.SAME_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.BIKE_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.BIKE_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.SAME_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.HACHI_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.SENSUIKAN_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.SENSUIKAN_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.HACHI_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.SAI_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.DRYER_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.DRYER_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.SAI_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.BAT_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.ENGINE_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.ENGINE_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.BAT_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.OBAKE_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.MAGNET_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.MAGNET_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.OBAKE_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.SCORPION_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.GOLD_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.GOLD_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.SCORPION_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.LOW_RABBIT_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.FULLFULL_TANK_BOTTLE.get())
                    .addAltWeapon(Build_Rider_Items.LOW_RABBIT_FULL_BOTTLE.get(), Build_Rider_Items.FULLBOTTLE_BUSTER.get())
                    .addAltWeapon(Build_Rider_Items.FULLFULL_RABBIT_TANK_BOTTLE.get(), Build_Rider_Items.FULLBOTTLE_BUSTER.get())
                    .addAltWeapon(Build_Rider_Items.GENIUS_FULL_BOTTLE.get(), Build_Rider_Items.FULLBOTTLE_BUSTER.get())
                    .addAltWeapon(Build_Rider_Items.CROSS_Z_BUILD_CAN.get(), Build_Rider_Items.FULLBOTTLE_BUSTER.get())
                    .addAltForm(Build_Rider_Items.GOLD_RABBIT_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.SILVER_DRAGON_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.SILVER_DRAGON_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.GOLD_RABBIT_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.MOMOTAROS_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.DENSHA_FULL_BOTTLE.get())
                    .addAltWeapon(Build_Rider_Items.MOMOTAROS_FULL_BOTTLE.get(), Den_O_Rider_Items.DEN_GASHER_SWORD.get())
                    .addAltForm(Build_Rider_Items.RIDER_CARD_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.CAMERA_FULL_BOTTLE.get())
                    .addAltWeapon(Build_Rider_Items.RIDER_CARD_FULL_BOTTLE.get(), Decade_Rider_Items.RIDE_BOOKER.get())
                    .addAltForm(Build_Rider_Items.TANTEI_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.USB_MEMORY_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.USB_MEMORY_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.TANTEI_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.MEDAL_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.TAKA_FULL_BOTTLE.get())
                    .addAltWeapon(Build_Rider_Items.MEDAL_FULL_BOTTLE.get(), OOO_Rider_Items.MEDAJALIBUR.get(), OOO_Rider_Items.MEDAGABURYU.get())
                    .addAltForm(Build_Rider_Items.YUUJOU_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.ROCKET_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.MAHOUTSUKAI_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.DIAMOND_FULL_BOTTLE.get())
                    .addAltWeapon(Build_Rider_Items.MAHOUTSUKAI_FULL_BOTTLE.get(), Wizard_Rider_Items.WIZARSWORDSGUN.get())
                    .addAltForm(Build_Rider_Items.ORANGE_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.LOCK_FULL_BOTTLE.get())
                    .addAltWeapon(Build_Rider_Items.ORANGE_FULL_BOTTLE.get(), Gaim_Rider_Items.DAIDAIMARU.get(), Gaim_Rider_Items.MUSOU_SABER.get())
                    .addAltForm(Build_Rider_Items.PARKA_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.OBAKE_FULL_BOTTLE.get())
                    .addAltWeapon(Build_Rider_Items.PARKA_FULL_BOTTLE.get(), Ghost_Rider_Items.GAN_GUN_SABER_BLADE.get())
                    .addAltForm(Build_Rider_Items.DOCTOR_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.GAME_FULL_BOTTLE.get())
                    .addAltForm(Build_Rider_Items.GAME_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.DOCTOR_FULL_BOTTLE.get())
                    .addAltWeapon(Build_Rider_Items.DOCTOR_FULL_BOTTLE.get(), Ex_Aid_Rider_Items.GASHACON_BREAKER.get())
                    .addAltWeapon(Build_Rider_Items.GAME_FULL_BOTTLE.get(), Ex_Aid_Rider_Items.GASHACON_BREAKER.get())
                    .AddIncompatibleForm(DECADE_RIDEWATCH.asItem()).AddIncompatibleForm(DECADE_BUILD_RIDEWATCH.asItem())
                    .IsGlowing().IsBeltGlowing().addAlternative(BUILD_RIDEWATCH_GEIZ.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZERO_ONE_RIDEWATCH = ITEMS.register("zero_one_ridewatch",
            () -> new ReiwaRidewatchItem(new Item.Properties(), "kamenridercraft:hiden_zero_one_driver")
                    .addSummonWeapon("kamenridercraft:attache_calibur")
                    .addAltWeapon("kamenridercraft:breaking_mammoth_progrisekey", "minecraft:air")
                    .addAltWeapon("kamenridercraft:shining_assault_hopper_progrisekey", "kamenridercraft:authorise_buster")
                    .addAltWeapon("kamenridercraft:metalcluster_hopper_progrisekey", "kamenridercraft:progrise_hopper_blade")
                    .addAltBelt("kamenridercraft:zero_two_progrisekey", "kamenridercraft:hiden_zero_two_driver")
                    .addAltWeapon("kamenridercraft:zero_two_progrisekey", "kamenridercraft:progrise_hopper_blade_naginata")
                    .addAltForm("kamenridercraft:crushing_buffalo_progrisekey", "kamenridercraft:crushing_buffalo_progrisekey_zero_one")
                    .addAltForm("kamenridercraft:storming_penguin_progrisekey", "kamenridercraft:storming_penguin_progrisekey_zero_one")
                    .addAltForm("kamenridercraft:splashing_whale_progrisekey", "kamenridercraft:splashing_whale_progrisekey_zero_one")
                    .addAltForm("kamenridercraft:dynamaiting_lion_progrisekey", "kamenridercraft:dynamaiting_lion_progrisekey_zero_one")
                    .addAltForm("kamenridercraft:scouting_panda_progrisekey", "kamenridercraft:scouting_panda_progrisekey_zero_one")
                    .addAltForm("kamenridercraft:invading_horseshoe_crab_progrisekey", "kamenridercraft:invading_horseshoe_crab_progrisekey_zero_one")
                    .addAltForm("kamenridercraft:shooting_wolf_progrisekey", "kamenridercraft:shooting_wolf_progrisekey_zero_one")
                    .addAltForm("kamenridercraft:punching_kong_progrisekey", "kamenridercraft:punching_kong_progrisekey_zero_one")
                    .addAltForm("kamenridercraft:rushing_cheetah_progrisekey", "kamenridercraft:rushing_cheetah_progrisekey_zero_one")
                    .addAltForm("kamenridercraft:lightning_hornet_progrisekey", "kamenridercraft:lightning_hornet_progrisekey_zero_one")
                    .addAltForm("kamenridercraft:fighting_jackal_progrisekey", "kamenridercraft:fighting_jackal_progrisekey_zero_one")
                    .addAltForm("kamenridercraft:sting_scorpion_progrisekey", "kamenridercraft:sting_scorpion_progrisekey_zero_one")
                    .addAltForm("kamenridercraft:flying_falcon_progrisekey", "kamenridercraft:flying_falcon_progrisekey_zero_one")
                    .addAltForm("kamenridercraft:burning_falcon_progrisekey", "kamenridercraft:burning_falcon_progrisekey_zero_one")
                    .addAltForm("kamenridercraft:amazing_caucasus_progrisekey", "kamenridercraft:amazing_caucasus_progrisekey_zero_one").AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SABER_RIDEWATCH = ITEMS.register("saber_ridewatch",
            () -> new SaberRidewatchItem(new Item.Properties(), 0, "_decade_saber", "zi_o", "ziku_driver_zi_o_belt_decade_saber",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.addAltWeapon("kamenridercraft:king_of_arthur_wonder_ride_book", "kamenridercraft:kingexcalibur", "kamenridercraft:kaenken_rekka")
                    .addAltForm("kamenridercraft:storm_eagle_wonder_ride_book", "kamenridercraft:saiyuu_journey_wonder_ride_book")
                    .addAltForm("kamenridercraft:saiyuu_journey_wonder_ride_book", "kamenridercraft:storm_eagle_wonder_ride_book")
                    .addAltForm("kamenridercraft:haouken_xross_saber", "kamenridercraft:brave_dragon_wonder_ride_book_xross")
                    .addAltWeapon("kamenridercraft:haouken_xross_saber", "kamenridercraft:haouken_xross_saber").IsGlowing().IsBeltGlowing().ChangeBeltModel("geo/zi_o_decade_riderbelt.geo.json").addNeedItem(DECADE_RIDEWATCH.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> REVI_RIDEWATCH = ITEMS.register("revi_ridewatch",
            () -> new ReiwaRidewatchItem(new Item.Properties(), "kamenridercraft:revice_driver").addSummonWeapon("kamenridercraft:ohin_buster_50")
                    .addAltWeapon("kamenridercraft:barid_rex_vistamp", "kamenridercraft:revice_lasher")
                    .addAltWeapon("kamenridercraft:volcano_vistamp", "kamenridercraft:revice_lasher")
                    .addAltWeapon("kamenridercraft:rolling_vistamp", "kamenridercraft:rolling_vistamp")
                    .addAltWeapon("kamenridercraft:thunder_gale_vistamp", "kamenridercraft:revice_lasher")
                    .addAltWeapon("kamenridercraft:giffard_rex_vistamp", "kamenridercraft:revice_lasher")
                    .addAltWeapon("kamenridercraft:fifty_gale_vistamp", "kamenridercraft:revice_lasher")
                    .addAltWeapon("kamenridercraft:true_rex_vistamp", "kamenridercraft:revice_lasher")
                    .addAltWeapon("kamenridercraft:mammoth_vistamp", "kamenridercraft:mammoth_gasher", "kamenridercraft:mammoth_gasher")
                    .addAltWeapon("kamenridercraft:kamakiri_vistamp", "kamenridercraft:kamakiric_arrow").AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> VICE_RIDEWATCH = ITEMS.register("vice_ridewatch",
            () -> new ReiwaRidewatchItem(new Item.Properties(), "kamenridercraft:vice_belt").addSummonWeapon("kamenridercraft:osutoderu_hammer_50")
                    .addAltForm("kamenridercraft:barid_rex_vistamp", "kamenridercraft:barid_rex_vistamp_vice")
                    .addAltWeapon("kamenridercraft:barid_rex_vistamp", "kamenridercraft:barid_shield")
                    .addAltForm("kamenridercraft:volcano_vistamp", "kamenridercraft:volcano_vistamp_vice")
                    .addAltWeapon("kamenridercraft:volcano_vistamp", "kamenridercraft:barid_shield")
                    .addAltForm("kamenridercraft:giffard_rex_vistamp", "kamenridercraft:giffard_rex_vistamp_vice")
                    .addAltWeapon("kamenridercraft:giffard_rex_vistamp", "kamenridercraft:revice_lasher")
                    .addAltForm("kamenridercraft:gold_spino_vistamp", "kamenridercraft:gold_spino_vistamp_vice")
                    .addAltForm("kamenridercraft:eagle_vistamp", "kamenridercraft:eagle_vistamp_vice")
                    .addAltForm("kamenridercraft:mammoth_vistamp", "kamenridercraft:mammoth_vistamp_vice")
                    .addAltForm("kamenridercraft:megalodon_vistamp", "kamenridercraft:megalodon_vistamp_vice")
                    .addAltForm("kamenridercraft:lion_vistamp", "kamenridercraft:lion_vistamp_vice")
                    .addAltForm("kamenridercraft:jackal_vistamp", "kamenridercraft:jackal_vistamp_vice")
                    .addAltForm("kamenridercraft:kong_vistamp", "kamenridercraft:kong_vistamp_vice")
                    .addAltForm("kamenridercraft:kamakiri_vistamp", "kamenridercraft:kamakiri_vistamp_vice")
                    .addAltForm("kamenridercraft:brachio_vistamp", "kamenridercraft:brachio_vistamp_vice")
                    .addAltForm("kamenridercraft:neo_batta_vistamp", "kamenridercraft:neo_batta_vistamp_vice")
                    .addAltForm("kamenridercraft:kangaroo_vistamp", "kamenridercraft:kangaroo_vistamp_vice")
                    .addAltForm("kamenridercraft:kirin_vistamp", "kamenridercraft:kirin_vistamp_vice")
                    .addAltForm("kamenridercraft:niwatori_vistamp", "kamenridercraft:niwatori_vistamp_vice")
                    .addAltForm("kamenridercraft:funkorogashi_vistamp", "kamenridercraft:funkorogashi_vistamp_vice")
                    .addAltForm("kamenridercraft:condor_vistamp", "kamenridercraft:condor_vistamp_vice")
                    .addAltForm("kamenridercraft:white_leo_vistamp", "kamenridercraft:white_leo_vistamp_vice")
                    .AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GEATS_RIDEWATCH = ITEMS.register("geats_ridewatch",
            () -> new ReiwaRidewatchItem(new Item.Properties(), "kamenridercraft:desire_driver_geats", "kamenridercraft:magnum_raise_buckle").addSummonWeapon("kamenridercraft:magnum_shooter_40x")
                    .addAltWeapon("kamenridercraft:geats_rider_core_id", "minecraft:air")
                    .addAltWeapon("kamenridercraft:boost_raise_buckle", "minecraft:air")
                    .addAltWeapon("kamenridercraft:ninja_raise_buckle", "kamenridercraft:ninja_dueler")
                    .addAltWeapon("kamenridercraft:beat_raise_buckle", "kamenridercraft:beat_axe")
                    .addAltWeapon("kamenridercraft:zombie_raise_buckle", "kamenridercraft:zombie_breaker")
                    .addAltForm("kamenridercraft:fantasy_raise_buckle", "kamenridercraft:fantasy_raise_buckle_gya_go")
                    .addAltWeapon("kamenridercraft:fantasy_raise_buckle", "minecraft:air")
                    .addAltWeapon("kamenridercraft:arrow_raise_buckle", "kamenridercraft:raise_arrow")
                    .addAltWeapon("kamenridercraft:water_raise_buckle", "kamenridercraft:raise_water")
                    .addAltWeapon("kamenridercraft:hammer_raise_buckle", "kamenridercraft:raise_hammer")
                    .addAltWeapon("kamenridercraft:shield_raise_buckle", "kamenridercraft:raise_shield")
                    .addAltWeapon("kamenridercraft:chain_array_raise_buckle", "kamenridercraft:raise_chain_array")
                    .addAltWeapon("kamenridercraft:claw_raise_buckle", "kamenridercraft:raise_claw")
                    .addAltWeapon("kamenridercraft:drill_raise_buckle", "kamenridercraft:raise_drill")
                    .addAltWeapon("kamenridercraft:propeller_raise_buckle", "kamenridercraft:raise_propeller")
                    .addAltWeapon("kamenridercraft:fever_slot_raise_buckle", "kamenridercraft:magnum_shooter_40x_rifle")
                    .addAltForm("kamenridercraft:fever_slot_raise_buckle", "kamenridercraft:magnum_raise_buckle_fever")
                    .addAltWeapon("kamenridercraft:powered_builder_raise_buckle", "kamenridercraft:gigant_blaster")
                    .addAltForm("kamenridercraft:powered_builder_raise_buckle", "kamenridercraft:powered_builder_raise_buckle_geats")
                    .addAltWeapon("kamenridercraft:command_twin_buckle_jet", "kamenridercraft:raising_sword")
                    .addAltWeapon("kamenridercraft:command_twin_buckle_cannon", "kamenridercraft:raising_sword")
                    .addAltWeapon("kamenridercraft:boost_mkii_raise_buckle", "minecraft:air")
                    .addAltWeapon("kamenridercraft:unite_grip", "kamenridercraft:laser_raise_riser")
                    .addAltWeapon("kamenridercraft:boost_mkiii_raise_buckle", "kamenridercraft:geats_buckle_qb9")
                    .addAltWeapon("kamenridercraft:oneness_raise_buckle", "kamenridercraft:geats_buckle_qb9")
                    .addAltWeapon("kamenridercraft:revice_driver_raise_buckle", "kamenridercraft:ohin_buster_50")
                    .addAltWeapon("kamenridercraft:two_si_driver_raise_buckle", "kamenridercraft:livegun")
                    .addAltWeapon("kamenridercraft:libera_driver_raise_buckle", "kamenridercraft:lovekov_kujaku", "kamenridercraft:lovekov_kujaku")
                    .addAltWeapon("kamenridercraft:demons_driver_raise_buckle", "minecraft:air")
                    .addAltWeapon("kamenridercraft:seiken_swordriver_raise_buckle", "kamenridercraft:kaenken_rekka")
                    .addAltWeapon("kamenridercraft:zero_one_driver_raise_buckle", "kamenridercraft:attache_calibur")
                    .addAltWeapon("kamenridercraft:zikuu_driver_raise_buckle", "kamenridercraft:zikan_girade")
                    .addAltWeapon("kamenridercraft:build_driver_raise_buckle", "kamenridercraft:drill_crusher")
                    .addAltWeapon("kamenridercraft:gamer_driver_raise_buckle", "kamenridercraft:gashacon_breaker")
                    .addAltWeapon("kamenridercraft:ghost_driver_raise_buckle", "kamenridercraft:gan_gun_saber_blade")
                    .addAltWeapon("kamenridercraft:drive_driver_raise_buckle", "kamenridercraft:handle_sword")
                    .addAltWeapon("kamenridercraft:sengoku_driver_raise_buckle", "kamenridercraft:daidaimaru")
                    .addAltWeapon("kamenridercraft:wizardriver_raise_buckle", "kamenridercraft:wizarswordgun")
                    .addAltWeapon("kamenridercraft:fourze_driver_raise_buckle", "minecraft:air")
                    .addAltWeapon("kamenridercraft:ooo_driver_raise_buckle", "kamenridercraft:medajalibur")
                    .addAltWeapon("kamenridercraft:double_driver_raise_buckle", "minecraft:air")
                    .addAltWeapon("kamenridercraft:deca_driver_raise_buckle", "kamenridercraft:ride_booker")
                    .addAltWeapon("kamenridercraft:kivat_belt_raise_buckle", "minecraft:air")
                    .addAltWeapon("kamenridercraft:den_o_belt_raise_buckle", "kamenridercraft:den_gasher_sword")
                    .addAltWeapon("kamenridercraft:kabuto_zector_raise_buckle", "minecraft:air")
                    .addAltWeapon("kamenridercraft:ongekiko_kaentsuzumi_raise_buckle", "kamenridercraft:ongekibo_rekka", "kamenridercraft:ongekibo_rekka")
                    .addAltWeapon("kamenridercraft:blay_buckle_raise_buckle", "kamenridercraft:blayrouzer")
                    .addAltWeapon("kamenridercraft:faiz_driver_raise_buckle", "kamenridercraft:faiz_edge")
                    .addAltWeapon("kamenridercraft:v_buckle_raise_buckle", "kamenridercraft:drag_saber", "kamenridercraft:drag_claw")
                    .addAltWeapon("kamenridercraft:ouja_v_buckle_raise_buckle", "kamenridercraft:veno_saber")
                    .addAltWeapon("kamenridercraft:alter_ring_raise_buckle", "minecraft:air")
                    .addAltWeapon("kamenridercraft:arcle_raise_buckle", "minecraft:air")
                    .addAltWeapon("kamenridercraft:king_stone_raise_buckle", "minecraft:air")
                    .addAltWeapon("kamenridercraft:double_typhoon_raise_buckle", "minecraft:air")
                    .addAltWeapon("kamenridercraft:typhoon_raise_buckle", "minecraft:air")
                    .AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GOTCHARD_RIDEWATCH = ITEMS.register("gotchard_ridewatch",
            () -> new ReiwaRidewatchItem(new Item.Properties(), "kamenridercraft:gotchardriver").addSummonWeapon("kamenridercraft:gotcharge_gun")
                    .addAltWeapon("kamenridercraft:apparebushido_ride_chemy_card", "kamenridercraft:gotchar_tornado")
                    .addAltWeapon("kamenridercraft:skebows_ride_chemy_card", "kamenridercraft:gotchar_tornado")
                    .addAltForm("kamenridercraft:skebows_ride_chemy_card", "kamenridercraft:apparebushido_ride_chemy_card")
                    .addAltForm("kamenridercraft:smaphone_ride_chemy_card", "kamenridercraft:pikahotaru_ride_chemy_card")
                    .addAltForm("kamenridercraft:bulletbaang_ride_chemy_card", "kamenridercraft:gengenchoucho_ride_chemy_card")
                    .addAltForm("kamenridercraft:wrestler_g_ride_chemy_card", "kamenridercraft:antrooper_ride_chemy_card")
                    .addAltForm("kamenridercraft:odorippa_ride_chemy_card", "kamenridercraft:kamantis_ride_chemy_card")
                    .addAltForm("kamenridercraft:gutsshovel_ride_chemy_card", "kamenridercraft:dokkirimajin_ride_chemy_card")
                    .addAltForm("kamenridercraft:madwheel_ride_chemy_card", "kamenridercraft:pilets_ride_chemy_card")
                    .addAltForm("kamenridercraft:energyl_ride_chemy_card", "kamenridercraft:sasukemaru_ride_chemy_card")
                    .addAltForm("kamenridercraft:flayrose_ride_chemy_card", "kamenridercraft:hiikescue_ride_chemy_card")
                    .addAltForm("kamenridercraft:venomdake_ride_chemy_card", "kamenridercraft:deepmariner_ride_chemy_card")
                    .addAltForm("kamenridercraft:mechanichani_ride_chemy_card", "kamenridercraft:golddash_ride_chemy_card")
                    .addAltForm("kamenridercraft:saboneedle_ride_chemy_card", "kamenridercraft:hawkstar_ride_chemy_card")
                    .addAltForm("kamenridercraft:burningnero_ride_chemy_card", "kamenridercraft:gorillasensei_ride_chemy_card")
                    .addAltForm("kamenridercraft:junglejan_ride_chemy_card", "kamenridercraft:raidenji_ride_chemy_card")
                    .addAltForm("kamenridercraft:inphoenix_ride_chemy_card", "kamenridercraft:firemars_ride_chemy_card")
                    .addAltForm("kamenridercraft:nijigon_ride_chemy_card_special", "kamenridercraft:nijigon_ride_chemy_card_extra")
                    .addAltForm("kamenridercraft:steamliner_ride_chemy_card_ultima", "kamenridercraft:hopper1_ride_chemy_card_ultima")
                    .addAltForm("kamenridercraft:gigantliner_ride_chemy_card", "kamenridercraft:hopper101_ride_chemy_card")
                    .addAltForm("kamenridercraft:inphoenix_ride_chemy_card_televikun", "kamenridercraft:firemars_ride_chemy_card_televikun")
                    .addAltForm("kamenridercraft:kuuga_ride_chemy_card", "kamenridercraft:kuuga_ride_chemy_card_gotchard")
                    .addAltForm("kamenridercraft:faiz_ride_chemy_card", "kamenridercraft:kuuga_ride_chemy_card_gotchard")
                    .addAltForm("kamenridercraft:w_ride_chemy_card", "kamenridercraft:w_ride_chemy_card_gotchard")
                    .addAltForm("kamenridercraft:ooo_ride_chemy_card", "kamenridercraft:w_ride_chemy_card_gotchard")
                    .addAltForm("kamenridercraft:fourze_ride_chemy_card", "kamenridercraft:fourze_ride_chemy_card_gotchard")
                    .addAltForm("kamenridercraft:build_ride_chemy_card", "kamenridercraft:fourze_ride_chemy_card_gotchard")
                    .addAltWeapon("kamenridercraft:tenliner_ride_chemy_card", "minecraft:air").AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GAVV_RIDEWATCH = ITEMS.register("gavv_ridewatch",
            () -> new ReiwaRidewatchItem(new Item.Properties(), "kamenridercraft:henshin_belt_gavv").addSummonWeapon("kamenridercraft:gavvgablade")
                    .addAltWeapon("kamenridercraft:zakuzakuchips_gochizo", "kamenridercraft:zakuzakuchipslasher", "kamenridercraft:zakuzakuchipslasher")
                    .addAltWeapon("kamenridercraft:hirihirichips_gochizo", "kamenridercraft:zakuzakuchipslasher", "kamenridercraft:zakuzakuchipslasher")
                    .addAltWeapon("kamenridercraft:chocodan_gochizo", "kamenridercraft:chocodangun")
                    .addAltForm("kamenridercraft:chocodon_gochizo", "kamenridercraft:chocodan_gochizo")
                    .addAltWeapon("kamenridercraft:chocodon_gochizo", "kamenridercraft:chocodongun", "kamenridercraft:chocodangun")
                    .addAltWeapon("kamenridercraft:marumallow_gochizo", "minecraft:air")
                    .addAltWeapon("kamenridercraft:gurucan_gochizo", "minecraft:air")
                    .addAltWeapon("kamenridercraft:bakucan_gochizo", "minecraft:air")
                    .addAltWeapon("kamenridercraft:bushel_gochizo", "kamenridercraft:xmax_gavv")
                    .addAltWeapon("kamenridercraft:caking_gochizo", "kamenridercraft:gavvwhipir")
                    .addAltWeapon("kamenridercraft:blizzardsorbei_gochizo", "kamenridercraft:gavvwhipir")
                    .addAltForm("kamenridercraft:gochipod_empty", "kamenridercraft:gochipod")
                    .addAltWeapon("kamenridercraft:gochipod_empty", "minecraft:air")
                    .addAltForm("kamenridercraft:gochipod", "kamenridercraft:gochipod_master")
                    .addAltWeapon("kamenridercraft:amazingummy_gochizo", "minecraft:air")
                    .addAltWeapon("kamenridercraft:kungfu_ramen_gochizo", "kamenridercraft:shield_snack_shield")
                    .addAltWeapon("kamenridercraft:choco_treasure_gochizo", "kamenridercraft:shield_snack_shield_choco")
                    .addAltWeapon("kamenridercraft:charapaki_gochizo", "kamenridercraft:chocodangun")
                    .addAltWeapon("kamenridercraft:charapaki_gochizo_special", "kamenridercraft:chocodangun")
                    .addAltWeapon("kamenridercraft:tirolchocolate_gochizo_variety", "kamenridercraft:chocodangun")
                    .addAltWeapon("kamenridercraft:umaibo_gochizo", "minecraft:air")
                    .addAltWeapon("kamenridercraft:partea_gochizo", "minecraft:air").AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZEZTZ_RIDEWATCH = ITEMS.register("zeztz_ridewatch",
            () -> new ReiwaRidewatchItem(new Item.Properties(), "kamenridercraft:zeztz_driver").addSummonWeapon("kamenridercraft:breakam_zeztzer_sword")
                    .addAltWeapon("kamenridercraft:stream_capsem", "kamenridercraft:breakam_zeztzer_gun")
                    .addAltWeapon("kamenridercraft:recovery_capsem", "kamenridercraft:breakam_zeztzer_axe")
                    .addAltWeapon("kamenridercraft:wonder_capsem", "kamenridercraft:breakam_zeztzer_scythe").AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> AMAZON_ALPHA_RIDEWATCH = ITEMS.register("amazon_alpha_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Reboot_Rider_Items.AMAZONS_DRIVER_ALPHA.get())
                    .AddToList(RiderTabs.ZI_O_TAB_ITEM));
    public static final DeferredItem<Item> AMAZON_OMEGA_RIDEWATCH = ITEMS.register("amazon_omega_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Reboot_Rider_Items.AMAZONS_DRIVER_OMEGA.get())
                    .AddToList(RiderTabs.ZI_O_TAB_ITEM));
    public static final DeferredItem<Item> AMAZON_NEO_RIDEWATCH = ITEMS.register("amazon_neo_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Reboot_Rider_Items.NEO_AMAZONS_DRIVER_NEO.get())
                    .AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GENM_RIDEWATCH = ITEMS.register("genm_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_genm", "geiz", "ziku_driver_geiz_belt_genm",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Ex_Aid_Rider_Items.GAMER_DRIVER_GENM.get())
                    .setSummonForm((RiderFormChangeItem) Ex_Aid_Rider_Items.PROTO_MIGHTY_ACTION_X_GASHAT.get())
                    .addSummonWeapon(Ex_Aid_Rider_Items.GASHACON_BUGVISOR.get())
                    .addAltForm(Ex_Aid_Rider_Items.PROTO_MIGHTY_ACTION_X_GASHAT.get(), (RiderFormChangeItem) Ex_Aid_Rider_Items.PROTO_MIGHTY_ACTION_X_GASHAT_LV_1.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.DRAGO_KNIGHT_HUNTER_Z_GASHAT.get(), Items.AIR)
                    .addAltWeapon(Ex_Aid_Rider_Items.PROTO_DRAGO_KNIGHT_HUNTER_Z_GASHAT.get(), Items.AIR)
                    .addAltBelt(Ex_Aid_Rider_Items.GASHACON_BUGVISOR.get(), (RiderDriverItem) Ex_Aid_Rider_Items.GASHACON_BUGVISOR_GENM.get())
                    .addAltForm(Ex_Aid_Rider_Items.GASHACON_BUGVISOR.get(), (RiderFormChangeItem) Ex_Aid_Rider_Items.DANGEROUS_ZOBIE_GASHAT_BD.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.GASHACON_BUGVISOR.get(), Items.AIR)
                    .addAltBelt(Ex_Aid_Rider_Items.THE_UNBEATABLE_GAME.get(), (RiderDriverItem) Ex_Aid_Rider_Items.GASHACON_BUGVISOR_GENM.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.THE_UNBEATABLE_GAME.get(), Items.AIR)
                    .addAltWeapon(Ex_Aid_Rider_Items.MAGIC_THE_WIZARD_GASHAT.get(), Wizard_Rider_Items.WIZARSWORDSGUN.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.JUNGLE_OOO_GASHAT.get(), OOO_Rider_Items.MEDAJALIBUR.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.BERCODE_WARRIOR_DECADE_GASHAT.get(), Decade_Rider_Items.RIDE_BOOKER.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.TIME_EXPRESS_DEN_O_GASHAT.get(), Den_O_Rider_Items.DEN_GASHER_SWORD.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.TAIKO_MASTER_HIBIKI_GASHAT.get(), Hibiki_Rider_Items.ONGEKIBO_REKKA.get(), Hibiki_Rider_Items.ONGEKIBO_REKKA.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.KING_OF_POKER_BLADE_GASHAT.get(), Blade_Rider_Items.BLAYROUZER.get())
                    .addAltWeapon(Ex_Aid_Rider_Items.MOSHI_MOSHI_FAIZ_GASHAT.get(), Faiz_Rider_Items.FAIZ_EDGE.get())
                    .IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> WOZ_RIDEWATCH = ITEMS.register("woz_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), 0, "_woz", "zi_o", "ziku_driver_zi_o_belt_woz",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false),
                    new MobEffectInstance(Effect_core.BOOST, 40, 0, true, false),
                    new MobEffectInstance(Effect_core.PUNCH, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BIBIRU_GEIZ_RIDEWATCH = ITEMS.register("bibiru_geiz_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "_bibiru", "geiz", "ziku_driver_geiz_belt_bibiru",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_ULTIMATE_RIDEWATCH = ITEMS.register("kuuga_ultimate_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> AGITO_SHINING_RIDEWATCH = ITEMS.register("agito_shining_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> RYUKI_SURVIVE_RIDEWATCH = ITEMS.register("ryuki_survive_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> FAIZ_BLASTER_RIDEWATCH = ITEMS.register("faiz_blaster_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BLADE_KING_RIDEWATCH = ITEMS.register("blade_king_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> HIBIKI_ARMED_RIDEWATCH = ITEMS.register("hibiki_armed_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> KABUTO_HYPER_RIDEWATCH = ITEMS.register("kabuto_hyper_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_LINER_RIDEWATCH = ITEMS.register("den_o_liner_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> KIVA_EMPEROR_RIDEWATCH = ITEMS.register("kiva_emperor_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_COMPLETE_RIDEWATCH = ITEMS.register("decade_complete_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> W_XTREME_RIDEWATCH = ITEMS.register("w_xtreme_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> OOO_PUTOTYRA_RIDEWATCH = ITEMS.register("ooo_putotyra_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> FOURZE_COSMIC_RIDEWATCH = ITEMS.register("fourze_cosmic_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> WIZARD_INFINITY_RIDEWATCH = ITEMS.register("wizard_infinity_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GAIM_KIWAMI_RIDEWATCH = ITEMS.register("gaim_kiwami_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DRIVE_TRIDORON_RIDEWATCH = ITEMS.register("drive_tridoron_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GHOST_MUGEN_RIDEWATCH = ITEMS.register("ghost_mugen_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> EX_AID_MUTEKI_RIDEWATCH = ITEMS.register("ex_aid_muteki_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BUILD_GENIUS_RIDEWATCH = ITEMS.register("build_genius_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> RYUSOULGER_RIDEWATCH = ITEMS.register("ryusoulger_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ICHIGO_RIDEWATCH = ITEMS.register("ichigo_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.TYPHOON_ICHIGO.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> NIGO_RIDEWATCH = ITEMS.register("nigo_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.TYPHOON_NIGO.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> V3_RIDEWATCH = ITEMS.register("v3_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.DOUBLE_TYPHOON.get()).addAltWeapon(Modded_item_core.FLARESALAMANDER.get(), Modded_item_core.FLARESALAMANDER_SWORD.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> RIDERMAN_RIDEWATCH = ITEMS.register("riderman_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.RIDERMAN_BELT.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> X_RIDEWATCH = ITEMS.register("x_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.RIDOL.get()).addSummonWeapon(Ichigo_Rider_Items.RIDOL_STICK.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> AMAZON_RIDEWATCH = ITEMS.register("amazon_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.CONDORER.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> STRONGER_RIDEWATCH = ITEMS.register("stronger_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.ELECTRER.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SKYRIDER_RIDEWATCH = ITEMS.register("skyrider_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.TORNADO.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SUPER_1_RIDEWATCH = ITEMS.register("super_1_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.CYCLODE.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZX_RIDEWATCH = ITEMS.register("zx_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.ZX_BELT.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BLACK_RIDEWATCH = ITEMS.register("black_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.VITAL_CHARGER.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SHADOW_MOON_RIDEWATCH = ITEMS.register("shadow_moon_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.SHADOW_CHARGER.get()).addSummonWeapon(Ichigo_Rider_Items.SATANSABER.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BLACK_RX_RIDEWATCH = ITEMS.register("black_rx_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.SUN_RISER.get()).addSummonWeapon(Ichigo_Rider_Items.REVOLCANE.get()).addAltForm(Ichigo_Rider_Items.ROBO_CORE.get(), (RiderFormChangeItem) Ichigo_Rider_Items.RX_CORE.get()).addAltForm(Ichigo_Rider_Items.BIO_CORE.get(), (RiderFormChangeItem) Ichigo_Rider_Items.RX_CORE.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ROBO_RIDER_RIDEWATCH = ITEMS.register("robo_rider_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.SUN_RISER.get()).setSummonForm((RiderFormChangeItem) Ichigo_Rider_Items.ROBO_CORE.get()).addSummonWeapon(Ichigo_Rider_Items.VORTECHSHOOTER.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BIO_RIDER_RIDEWATCH = ITEMS.register("bio_rider_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), 0, "_biorider", "barlckxs", "ziku_driver_barlckxs_belt_biorider",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(Effect_core.BIG, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 200, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.SUN_RISER.get()).setSummonForm((RiderFormChangeItem) Ichigo_Rider_Items.BIO_CORE.get()).addSummonWeapon(Ichigo_Rider_Items.BIOBLADE.get())
                    .IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SHIN_RIDEWATCH = ITEMS.register("shin_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.GRASSHOPPER_DNA.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZO_RIDEWATCH = ITEMS.register("zo_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.ZO_CORE.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> J_RIDEWATCH = ITEMS.register("j_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ichigo_Rider_Items.J_SPIRIT.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> KNIGHT_RIDEWATCH = ITEMS.register("knight_ridewatch",
            () -> ((MajestyRidewatchItem) new MajestyRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Ryuki_Rider_Items.KNIGHTDRIVER.get())
                    .addSummonWeapon(Ryuki_Rider_Items.DARK_VISOR.get())
                    .addAltForm(Ryuki_Rider_Items.RIDE_SABER_VENT.get(), (RiderFormChangeItem) Ryuki_Rider_Items.ADVENT_CARD.get())
                    .addAltForm(Ryuki_Rider_Items.DARK_VISOR_ZWEI_VENT.get(), (RiderFormChangeItem) Ryuki_Rider_Items.SURVIVE_SHIPPU.get())
                    .addAltForm(Ryuki_Rider_Items.DARK_BLADE_VENT.get(), (RiderFormChangeItem) Ryuki_Rider_Items.SURVIVE_SHIPPU.get())
                    .addAltForm(Ryuki_Rider_Items.DARK_ARROW_VENT.get(), (RiderFormChangeItem) Ryuki_Rider_Items.SURVIVE_SHIPPU.get())
                    .addAltWeapon(Ryuki_Rider_Items.RIDE_SABER_VENT.get(), Ryuki_Rider_Items.RIDE_SABER.get())
                    .addAltWeapon(Ryuki_Rider_Items.WING_LANCER_VENT.get(), Ryuki_Rider_Items.WING_LANCER.get())
                    .addAltWeapon(Ryuki_Rider_Items.SURVIVE_SHIPPU.get(), Ryuki_Rider_Items.DARK_BLADE.get(), Ryuki_Rider_Items.DARK_SHIELD.get())
                    .addAltWeapon(Ryuki_Rider_Items.DARK_VISOR_ZWEI_VENT.get(), Ryuki_Rider_Items.DARK_BLADE.get(), Ryuki_Rider_Items.DARK_SHIELD.get())
                    .addAltWeapon(Ryuki_Rider_Items.DARK_BLADE_VENT.get(), Ryuki_Rider_Items.DARK_BLADE.get(), Ryuki_Rider_Items.DARK_SHIELD.get())
                    .addAltWeapon(Ryuki_Rider_Items.DARK_ARROW_VENT.get(), Ryuki_Rider_Items.DARK_ARROW.get())
                    .addAltWeapon(Modded_item_core.DARKWING.get(), Modded_item_core.DARKWING_SWORD.get()))
                    .addMajestyWeapon(Ryuki_Rider_Items.WING_LANCER.get())
                    .addAltMajestyWeapon(Ryuki_Rider_Items.RIDE_SABER_VENT.get(), Ryuki_Rider_Items.RIDE_SABER.get())
                    .addAltMajestyWeapon(Ryuki_Rider_Items.SURVIVE_SHIPPU.get(), Ryuki_Rider_Items.DARK_BLADE.get(), Ryuki_Rider_Items.DARK_SHIELD.get())
                    .addAltMajestyWeapon(Ryuki_Rider_Items.DARK_VISOR_ZWEI_VENT.get(), Ryuki_Rider_Items.DARK_BLADE.get(), Ryuki_Rider_Items.DARK_SHIELD.get())
                    .addAltMajestyWeapon(Ryuki_Rider_Items.DARK_BLADE_VENT.get(), Ryuki_Rider_Items.DARK_BLADE.get(), Ryuki_Rider_Items.DARK_SHIELD.get())
                    .addAltMajestyWeapon(Ryuki_Rider_Items.DARK_ARROW_VENT.get(), Ryuki_Rider_Items.DARK_ARROW.get())
                    .addAltMajestyWeapon(Modded_item_core.DARKWING.get(), Modded_item_core.DARKWING_SWORD.get())
                    .AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> CHALICE_RIDEWATCH = ITEMS.register("chalice_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Blade_Rider_Items.CHALICEROUZER.get()).addSummonWeapon(Blade_Rider_Items.CHALICE_ARROW.get())
                    .addAltWeapon(Blade_Rider_Items.EVOLUTION_PARADOXA.get(), Blade_Rider_Items.WILD_SLASHER.get(), Blade_Rider_Items.WILD_SLASHER.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DIEND_RIDEWATCH = ITEMS.register("diend_ridewatch",
            () -> ((MajestyRidewatchItem) new MajestyRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Decade_Rider_Items.DIEND_BELT.get())
                    .addSummonWeapon(Decade_Rider_Items.DIENDRIVER.get())
                    .addAltForm(Decade_Rider_Items.DECADE_CARD.get(), (RiderFormChangeItem) Decade_Rider_Items.DIEND_GREEN_CARD.get()))
                    .addMajestyWeapon(Decade_Rider_Items.DIENDRIVER.get())
                    .AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BEAST_RIDEWATCH = ITEMS.register("beast_ridewatch",
            () -> ((MajestyRidewatchItem) new MajestyRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Wizard_Rider_Items.BEAST_DRIVER.get()).addSummonWeapon(Wizard_Rider_Items.DICE_SABER.get())
                    .addAltForm(Wizard_Rider_Items.LAND_DRAGON_WIZARD_RING.get(), (RiderFormChangeItem) Wizard_Rider_Items.LAND_DRAGON_WIZARD_RING_BEAST.get())
                    .addAltWeapon(Wizard_Rider_Items.HYPER_RING.get(), Wizard_Rider_Items.MIRAGE_MAGNUM.get()))
                    .addMajestyWeapon(Wizard_Rider_Items.DICE_SABER.get())
                    .addAltMajestyWeapon(Wizard_Rider_Items.HYPER_RING.get(), Wizard_Rider_Items.MIRAGE_MAGNUM.get())
                    .AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> MACH_RIDEWATCH = ITEMS.register("mach_ridewatch",
            () -> ((MajestyRidewatchItem) new MajestyRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Drive_Rider_Items.MACH_DRIVER_HONOH.get()).addSummonWeapon(Drive_Rider_Items.ZENRIN_SHOOTER.get())
                    .addAltWeapon(Drive_Rider_Items.SHIFT_RUMBLE_DUMP.get(), Drive_Rider_Items.RUMBLE_SMASHER.get())
                    .addAltForm(Drive_Rider_Items.SHIFT_DEAD_HEAT.get(), (RiderFormChangeItem) Drive_Rider_Items.SHIFT_DEAD_HEAT_MACH.get())
                    .addAltForm(Drive_Rider_Items.SHIFT_MAD_DOCTOR.get(), (RiderFormChangeItem) Drive_Rider_Items.SHIFT_DEAD_HEAT_MACH.get())
                    .addAltForm(Drive_Rider_Items.SIGNAL_CHASER.get(), (RiderFormChangeItem) Drive_Rider_Items.SIGNAL_CHASER_MACH.get())
                    .addAltWeapon(Drive_Rider_Items.SIGNAL_CHASER.get(), Drive_Rider_Items.SHINGOU_AX.get())
                    .addAltForm(Drive_Rider_Items.RHINO_SUPER_VIRAL_CORE.get(), (RiderFormChangeItem) Drive_Rider_Items.SHIFT_VIRAL_CORE.get()))
                    .addMajestyWeapon(Drive_Rider_Items.ZENRIN_SHOOTER.get())
                    .addAltMajestyWeapon(Drive_Rider_Items.SHIFT_RUMBLE_DUMP.get(), Drive_Rider_Items.RUMBLE_SMASHER.get())
                    .addAltMajestyWeapon(Drive_Rider_Items.SIGNAL_CHASER.get(), Drive_Rider_Items.SHINGOU_AX.get())
                    .AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> CROSS_Z_RIDEWATCH = ITEMS.register("cross_z_ridewatch",
            () -> ((MajestyRidewatchItem) new MajestyRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Build_Rider_Items.BUILD_DRIVER_CROSS_Z.get()).addSummonWeapon(Build_Rider_Items.BEAT_CROSSER.get())
                    .addAltBelt(Build_Rider_Items.DRAGON_SCLASH_JELLY.get(), (RiderDriverItem) Build_Rider_Items.SCLASH_DRIVER.get())
                    .addAltWeapon(Build_Rider_Items.DRAGON_SCLASH_JELLY.get(), Build_Rider_Items.TWIN_BREAKER.get())
                    .addAltBelt(Build_Rider_Items.TAKA_FULL_BOTTLE.get(), (RiderDriverItem) Build_Rider_Items.SCLASH_DRIVER.get())
                    .addAltForm(Build_Rider_Items.TAKA_FULL_BOTTLE.get(), (RiderFormChangeItem) Build_Rider_Items.TAKA_FULL_BOTTLE_CROSS_Z.get())
                    .addAltWeapon(Build_Rider_Items.TAKA_FULL_BOTTLE.get(), Build_Rider_Items.TWIN_BREAKER.get())
                    .addAltWeapon(Build_Rider_Items.DRAGON_MAGMA_FULL_BOTTLE.get(), Build_Rider_Items.MAGMA_KNUCKLE.get()))
                    .addMajestyWeapon(Build_Rider_Items.BEAT_CROSSER.get())
                    .addAltMajestyWeapon(Build_Rider_Items.DRAGON_SCLASH_JELLY.get(), Build_Rider_Items.TWIN_BREAKER.get())
                    .addAltMajestyWeapon(Build_Rider_Items.TAKA_FULL_BOTTLE.get(), Build_Rider_Items.TWIN_BREAKER.get())
                    .addAltMajestyWeapon(Build_Rider_Items.DRAGON_MAGMA_FULL_BOTTLE.get(), Build_Rider_Items.MAGMA_KNUCKLE.get())
                    .AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SHINOBI_MIRIDEWATCH = ITEMS.register("shinobi_miridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "_shinobi", "woz", "beyondriver_belt",
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> QUIZ_MIRIDEWATCH = ITEMS.register("quiz_miridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "_quiz", "woz", "beyondriver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> KIKAI_MIRIDEWATCH = ITEMS.register("kikai_miridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "_kikai", "woz", "beyondriver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GINGA_FINALY_MIRIDEWATCH = ITEMS.register("ginga_finaly_miridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "_ginga_finaly", "woz", "beyondriver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().model_has_different_name("ginga_miridewatch").has_basic_model());

    public static final DeferredItem<Item> GINGA_TAIYO_MIRIDEWATCH = ITEMS.register("ginga_taiyo_miridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "_ginga_taiyo", "woz", "beyondriver_belt",
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.addNeedForm(GINGA_FINALY_MIRIDEWATCH.get(), 1).addAlternative(GINGA_FINALY_MIRIDEWATCH.get())
                    .IsGlowing().IsBeltGlowing().model_has_different_name("ginga_miridewatch").has_basic_model());

    public static final DeferredItem<Item> GINGA_MIRIDEWATCH = ITEMS.register("ginga_miridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), 0, "_ginga_wakusei", "woz", "beyondriver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().addNeedForm(GINGA_TAIYO_MIRIDEWATCH.get(), 1).addAlternative(GINGA_TAIYO_MIRIDEWATCH.get()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> CHRISTMAS_RIDEWATCH = ITEMS.register("christmas_ridewatch",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> UNFINISHED_GRAND_ZI_O_RIDEWATCH_L = ITEMS.register("unfinished_grand_zi_o_ridewatch_l",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> UNFINISHED_GRAND_ZI_O_RIDEWATCH_R = ITEMS.register("unfinished_grand_zi_o_ridewatch_r",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> UNFINISHED_GEIZ_MAJESTY_RIDEWATCH_L = ITEMS.register("unfinished_geiz_majesty_ridewatch_l",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> UNFINISHED_GEIZ_MAJESTY_RIDEWATCH_R = ITEMS.register("unfinished_geiz_majesty_ridewatch_r",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> UNFINISHED_OHMA_ZI_O_DRIVER_L = ITEMS.register("unfinished_ohma_zi_o_driver_l",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE), 0, "", "ohma_zi_o", "ohma_zi_o_driver_belt",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 6, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 6, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 6, true, false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.REGENERATION, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 6, true, false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.SATURATION, 40, 0, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().hasStaticWings().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> UNFINISHED_OHMA_ZI_O_DRIVER_R = ITEMS.register("unfinished_ohma_zi_o_driver_r",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_KUUGA_WATCH = ITEMS.register("another_kuuga_watch",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_AGITO_WATCH = ITEMS.register("another_agito_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "another_agito_zio", "another_altering_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_RYUKI_WATCH = ITEMS.register("another_ryuki_watch",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_RYUGA_WATCH = ITEMS.register("another_ryuga_watch",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_FAIZ_WATCH = ITEMS.register("another_faiz_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "another_faiz", "another_faiz_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_BLADE_WATCH = ITEMS.register("another_blade_watch",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_HIBIKI_WATCH = ITEMS.register("another_hibiki_watch",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_KABUTO_WATCH = ITEMS.register("another_kabuto_watch",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_DEN_O_WATCH = ITEMS.register("another_den_o_watch",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_KIVA_WATCH = ITEMS.register("another_kiva_watch",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_DECADE_WATCH = ITEMS.register("another_decade_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "another_decade", "another_decadriver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_DIEND_WATCH = ITEMS.register("another_diend_watch",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_W_WATCH = ITEMS.register("another_w_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "another_w", "another_w_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(Effect_core.PUNCH, 40, 0, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_OOO_WATCH = ITEMS.register("another_ooo_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "another_ooo", "another_ooo_driver_belt",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_FOURZE_WATCH = ITEMS.register("another_fourze_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "another_fourze", "another_fourze_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_WIZARD_WATCH = ITEMS.register("another_wizard_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "another_wizard", "another_wizard_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_GAIM_WATCH = ITEMS.register("another_gaim_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "another_gaim", "another_gaim_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_DRIVE_WATCH = ITEMS.register("another_drive_watch",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_GHOST_WATCH = ITEMS.register("another_ghost_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "another_ghost", "another_ghost_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
                    new MobEffectInstance(Effect_core.GHOST, 40, 0, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_EX_AID_WATCH = ITEMS.register("another_ex_aid_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "another_ex_aid", "another_ex_aid_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.FALLING_SPORE_BLOSSOM,
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_BUILD_WATCH = ITEMS.register("another_build_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "another_build", "another_build_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(Effect_core.PUNCH, 40, 0, true, false))
                    .AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_ZI_O_WATCH = ITEMS.register("another_zi_o_watch",
            () -> new Zi_ORidewatchItem(new Item.Properties(), 0, "", "another_zi_o", "another_ziku_driver_zi_o_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false))
                    .AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_ZI_O_II_WATCH = ITEMS.register("another_zi_o_ii_watch",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_ZERO_ONE_WATCH = ITEMS.register("another_zero_one_watch",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_ICHIGO_WATCH = ITEMS.register("another_ichigo_watch",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_SHINOBI_WATCH = ITEMS.register("another_shinobi_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "another_shinobi", "another_shinobi_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_QUIZ_WATCH = ITEMS.register("another_quiz_watch",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_KIKAI_WATCH = ITEMS.register("another_kikai_watch",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SHURIKEN_STARTER = ITEMS.register("shuriken_starter",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "shinobi", "shinobi_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SHURIKEN_STARTER_HATTARI = ITEMS.register("shuriken_starter_hattari",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "hattari", "hattari_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> QUIZ_TOPPER = ITEMS.register("quiz_topper",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "quiz", "quiz_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SPANNERDER_SCREWDER = ITEMS.register("spannerder_screwder",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "kikai", "kikai_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GINGA_SCOPE = ITEMS.register("ginga_scope",
            () -> new RiderFormChangeItem(new Item.Properties(), 0, "", "ginga", "ginga_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> RIDESTRIKER_RIDEWATCH = ITEMS.register("ridestriker_ridewatch",
            () -> new SummonBikeItem(new Item.Properties(), MobsCore.RIDESTRIKER)
                    .has_basic_model().AddToList(RiderTabs.ZI_O_TAB_ITEM));


    public static final DeferredItem<Item> WOZ_TIME_MAJIN_RIDEWATCH = ITEMS.register("woz_time_majin_ridewatch",
            () -> new BaseCityItem(new Item.Properties().rarity(Rarity.UNCOMMON), 10).AddToList(RiderTabs.ZI_O_TAB_ITEM).has_basic_model());

    public static final DeferredItem<Item> OHMA_ADVENT_CALENDAR = ITEMS.register("ohma_advent_calendar",
            () -> new OhmaAdventCalendarItem(new Item.Properties()).AddToList(RiderTabs.ZI_O_TAB_ITEM));


    public static final DeferredItem<Item> ZI_O_HELMET = ITEMS.register("zi_o_head",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZI_O_CHESTPLATE = ITEMS.register("zi_o_troso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZI_O_LEGGINGS = ITEMS.register("zi_o_legs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));


    public static final DeferredItem<Item> ZIKU_DRIVER_ZI_O = ITEMS.register("ziku_driver_zi_o",
            () -> new ZikuDriverItem(ArmorMaterials.DIAMOND, "zi_o", ZI_O_RIDEWATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)) {
                @Override
                public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
                    player.openMenu(new MenuProvider() {
                        @Override
                        public Component getDisplayName() {
                            return Component.translatable("ridewatch_holder.text");
                        }

                        @Override
                        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                            FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                            packetBuffer.writeBlockPos(player.blockPosition());
                            packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                            return new RidewatchHolderGuiMenu(id, inventory, packetBuffer, itemstack);
                        }
                    }, buf -> buf.writeBlockPos(player.blockPosition()));
                }
            }.Has_Inventory_Gui().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_BELTS).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> OHMA_ZI_O_DRIVER = ITEMS.register("ohma_zi_o_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "ohma_zi_o", UNFINISHED_OHMA_ZI_O_DRIVER_L, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties().rarity(Rarity.EPIC).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)) {
                @Override
                public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
                    player.openMenu(new MenuProvider() {
                        @Override
                        public Component getDisplayName() {
                            return Component.translatable("ridewatch_holder.text");
                        }

                        @Override
                        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                            FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                            packetBuffer.writeBlockPos(player.blockPosition());
                            packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                            return new RidewatchHolderGuiMenu(id, inventory, packetBuffer, itemstack);
                        }
                    }, buf -> buf.writeBlockPos(player.blockPosition()));
                }
            }.Has_Inventory_Gui().Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZIKU_DRIVER_GEIZ = ITEMS.register("ziku_driver_geiz",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "geiz", GEIZ_RIDEWATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)) {
                @Override
                public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
                    player.openMenu(new MenuProvider() {
                        @Override
                        public Component getDisplayName() {
                            return Component.translatable("ridewatch_holder.text");
                        }

                        @Override
                        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                            FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                            packetBuffer.writeBlockPos(player.blockPosition());
                            packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                            return new RidewatchHolderGuiMenu(id, inventory, packetBuffer, itemstack);
                        }
                    }, buf -> buf.writeBlockPos(player.blockPosition()));
                }
            }.Has_Inventory_Gui().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_BELTS).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZIKU_DRIVER_TSUKUYOMI = ITEMS.register("ziku_driver_tsukuyomi",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "tsukuyomi", TSUKUYOMI_RIDEWATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties().rarity(Rarity.UNCOMMON).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)) {
                @Override
                public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
                    player.openMenu(new MenuProvider() {
                        @Override
                        public Component getDisplayName() {
                            return Component.translatable("ridewatch_holder.text");
                        }

                        @Override
                        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                            FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                            packetBuffer.writeBlockPos(player.blockPosition());
                            packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                            return new RidewatchHolderGuiMenu(id, inventory, packetBuffer, itemstack);
                        }
                    }, buf -> buf.writeBlockPos(player.blockPosition()));
                }
            }.Has_Inventory_Gui().Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> BEYONDRIVER = ITEMS.register("beyondriver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "woz", WOZ_MIRIDEWATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)) {
                @Override
                public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
                    player.openMenu(new MenuProvider() {
                        @Override
                        public Component getDisplayName() {
                            return Component.translatable("miridewatch_holder.text");
                        }

                        @Override
                        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                            FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                            packetBuffer.writeBlockPos(player.blockPosition());
                            packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                            return new MiridewatchHolderGuiMenu(id, inventory, packetBuffer, itemstack);
                        }
                    }, buf -> buf.writeBlockPos(player.blockPosition()));
                }
            }.Has_Inventory_Gui().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZIKU_DRIVER_ZI_O_MIRROR = ITEMS.register("ziku_driver_zi_o_mirror",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "zi_o_mirror", ZI_O_MIRROR_RIDEWATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)) {
                @Override
                public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
                    player.openMenu(new MenuProvider() {
                        @Override
                        public Component getDisplayName() {
                            return Component.translatable("ridewatch_holder.text");
                        }

                        @Override
                        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                            FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                            packetBuffer.writeBlockPos(player.blockPosition());
                            packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                            return new RidewatchHolderGuiMenu(id, inventory, packetBuffer, itemstack);
                        }
                    }, buf -> buf.writeBlockPos(player.blockPosition()));
                }
            }.Has_Inventory_Gui().Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZIKU_DRIVER_BARLCKXS = ITEMS.register("ziku_driver_barlckxs",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "barlckxs", BARLCKXS_RIDEWATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)) {
                @Override
                public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
                    player.openMenu(new MenuProvider() {
                        @Override
                        public Component getDisplayName() {
                            return Component.translatable("ridewatch_holder.text");
                        }

                        @Override
                        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                            FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                            packetBuffer.writeBlockPos(player.blockPosition());
                            packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                            return new RidewatchHolderGuiMenu(id, inventory, packetBuffer, itemstack);
                        }
                    }, buf -> buf.writeBlockPos(player.blockPosition()));
                }
            }.Has_Inventory_Gui().Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZIKU_DRIVER_ZONJIS = ITEMS.register("ziku_driver_zonjis",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "zonjis", ZONJIS_RIDEWATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)) {
                @Override
                public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
                    player.openMenu(new MenuProvider() {
                        @Override
                        public Component getDisplayName() {
                            return Component.translatable("ridewatch_holder.text");
                        }

                        @Override
                        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                            FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                            packetBuffer.writeBlockPos(player.blockPosition());
                            packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                            return new RidewatchHolderGuiMenu(id, inventory, packetBuffer, itemstack);
                        }
                    }, buf -> buf.writeBlockPos(player.blockPosition()));
                }
            }.Has_Inventory_Gui().Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZIKU_DRIVER_ZAMONAS = ITEMS.register("ziku_driver_zamonas",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "zamonas", ZAMONAS_RIDEWATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)) {
                @Override
                public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
                    player.openMenu(new MenuProvider() {
                        @Override
                        public Component getDisplayName() {
                            return Component.translatable("ridewatch_holder.text");
                        }

                        @Override
                        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                            FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                            packetBuffer.writeBlockPos(player.blockPosition());
                            packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                            return new RidewatchHolderGuiMenu(id, inventory, packetBuffer, itemstack);
                        }
                    }, buf -> buf.writeBlockPos(player.blockPosition()));
                }
            }.Has_Inventory_Gui().Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> SHINOBIDRIVER = ITEMS.register("shinobi_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "shinobi", SHURIKEN_STARTER, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> HATTARIDRIVER = ITEMS.register("hattari_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "hattari", SHURIKEN_STARTER_HATTARI, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> QUIZDRIVER = ITEMS.register("quiz_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "quiz", QUIZ_TOPPER, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> KIKAIDRIVER = ITEMS.register("kikai_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "kikai", SPANNERDER_SCREWDER, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> GINGADRIVER = ITEMS.register("ginga_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "ginga", GINGA_SCOPE, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_ALTERING = ITEMS.register("another_altering",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_agito_zio", ANOTHER_AGITO_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_FAIZ_DRIVER = ITEMS.register("another_faiz_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_faiz", ANOTHER_FAIZ_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_DECADRIVER = ITEMS.register("another_decadriver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_decade", ANOTHER_DECADE_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_W_DRIVER = ITEMS.register("another_w_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_w", ANOTHER_W_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_OOO_DRIVER = ITEMS.register("another_ooo_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_ooo", ANOTHER_OOO_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_FOURZE_DRIVER = ITEMS.register("another_fourze_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_fourze", ANOTHER_FOURZE_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_WIZARD_DRIVER = ITEMS.register("another_wizard_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_wizard", ANOTHER_WIZARD_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_GAIM_DRIVER = ITEMS.register("another_gaim_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_gaim", ANOTHER_GAIM_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_GHOST_DRIVER = ITEMS.register("another_ghost_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_ghost", ANOTHER_GHOST_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_EX_AID_DRIVER = ITEMS.register("another_ex_aid_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_ex_aid", ANOTHER_EX_AID_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_BUILD_DRIVER = ITEMS.register("another_build_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_build", ANOTHER_BUILD_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_ZIKU_DRIVER_ZI_O = ITEMS.register("another_ziku_driver_zi_o",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_zi_o", ANOTHER_ZI_O_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).has_basic_model().ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_SHINOBI_DRIVER = ITEMS.register("another_shinobi_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_shinobi", ANOTHER_SHINOBI_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));


    public static final DeferredItem<Item> ZIKAN_GIRADE = ITEMS.register("zikan_girade",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_WEAPONS).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZIKAN_ZAX = ITEMS.register("zikan_zax",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_WEAPONS).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> DRILL_CRUSHER_CRUSHER = ITEMS.register("drill_crusher_crusher",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> FAIZPHONE_X = ITEMS.register("faiz_phone_x",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> RIDE_HEISABER = ITEMS.register("ride_heisaber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> SAIKYO_GIRADE = ITEMS.register("saikyo_girade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> SAIKYO_ZIKAN_GIRADE = ITEMS.register("saikyo_zikan_girade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).AddToTabList(Decade_Rider_Items.COMPLETE_21_WEAPONS).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZIKAN_DESPEAR = ITEMS.register("zikan_despear",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZIKAN_DESPEAR_KAMA = ITEMS.register("zikan_despear_kama",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZIKAN_DESPEAR_TSUE = ITEMS.register("zikan_despear_tsue",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZIKAN_JACLAW = ITEMS.register("zikan_jaclaw",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).IsChangeSword().AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZAMONAS_BOW = ITEMS.register("zamonas_bow",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> BARLCKXS_SWORD = ITEMS.register("barlckxs_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> TAKA_RIDEWATCH = ITEMS.register("taka_ridewatch",
            () -> new RideGadgetItem(new Item.Properties(),Component.translatable("ridegadget.kamenridercraft.taka"), MobsCore.TAKA_WATCHROID).AddToList(RiderTabs.ZI_O_TAB_ITEM).has_basic_model());

    public static final DeferredItem<Item> KODAMA_RIDEWATCH = ITEMS.register("kodama_ridewatch",
            () -> new RideGadgetItem(new Item.Properties(),Component.translatable("ridegadget.kamenridercraft.kodama"), MobsCore.KODAMA_SUIKA_ARMS).AddToList(RiderTabs.ZI_O_TAB_ITEM).has_basic_model());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
