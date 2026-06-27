package com.kelco.kamenridercraft.item.heisei_phase_2;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.*;
import com.kelco.kamenridercraft.item.heisei_phase_1.*;
import com.kelco.kamenridercraft.item.heisei_phase_2.zi_o.*;
import com.kelco.kamenridercraft.item.reboots.AmazonsRiderItems;
import com.kelco.kamenridercraft.item.showa.*;
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

public class ZiORiderItems {
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
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BLANK_RIDEWATCH = ITEMS.register("blank_watch",
            () -> new BaseDropItem(new Item.Properties(), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/blank_watch")).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZI_O_RIDEWATCH = ITEMS.register("zi_o_ridewatch",
            () -> new Zi_ORidewatchItem(new Item.Properties(), "", "zi_o", "ziku_driver_zi_o_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
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
                    .addAltForm("kamenridercraft:faiz_axel", "kamenridercraft:decade_faiz_ridewatch")
                    .addAltWeapon("kamenridercraft:faiz_axel", "kamenridercraft:ride_heisaber")
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
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_RIDEWATCH = ITEMS.register("decade_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_decade", "zi_o", "ziku_driver_zi_o_belt_decade",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) DecadeRiderItems.DECADRIVER.get())
                    .addSummonWeapon(DecadeRiderItems.RIDE_BOOKER.get())
                    .addAltBelt(DecadeRiderItems.NEO_DECADRIVER.get(), (RiderDriverItem) DecadeRiderItems.NEO_DECADRIVER.get())
                    .addAltBelt(DecadeRiderItems.W_CARD.get(), (RiderDriverItem) DecadeRiderItems.NEO_DECADRIVER.get())
                    .addAltBelt(DecadeRiderItems.OOO_CARD.get(), (RiderDriverItem) DecadeRiderItems.NEO_DECADRIVER.get())
                    .addAltBelt(DecadeRiderItems.FOURZE_CARD.get(), (RiderDriverItem) DecadeRiderItems.NEO_DECADRIVER.get())
                    .addAltBelt(DecadeRiderItems.WIZARD_CARD.get(), (RiderDriverItem) DecadeRiderItems.NEO_DECADRIVER.get())
                    .addAltBelt(DecadeRiderItems.GAIM_CARD.get(), (RiderDriverItem) DecadeRiderItems.NEO_DECADRIVER.get())
                    .addAltBelt(DecadeRiderItems.DRIVE_CARD.get(), (RiderDriverItem) DecadeRiderItems.NEO_DECADRIVER.get())
                    .addAltBelt(DecadeRiderItems.GHOST_CARD.get(), (RiderDriverItem) DecadeRiderItems.NEO_DECADRIVER.get())
                    .addAltBelt(DecadeRiderItems.EX_AID_CARD.get(), (RiderDriverItem) DecadeRiderItems.NEO_DECADRIVER.get())
                    .addAltBelt(DecadeRiderItems.BUILD_CARD.get(), (RiderDriverItem) DecadeRiderItems.NEO_DECADRIVER.get())
                    .addAltBelt(DecadeRiderItems.ZI_O_CARD.get(), (RiderDriverItem) DecadeRiderItems.NEO_DECADRIVER.get())
                    .addAltBelt(DecadeRiderItems.K_TOUCH_21.get(), (RiderDriverItem) DecadeRiderItems.NEO_DECADRIVER.get())
                    .addAltForm(DecadeRiderItems.REKKA_DAIZANTOU_CARD.get(), (RiderFormChangeItem) DecadeRiderItems.K_TOUCH.get())
                    .addAltForm(DecadeRiderItems.G4_GIGANT_CARD.get(), (RiderFormChangeItem) DecadeRiderItems.DECADE_VIOLENT_EMOTION_CARD.get())
                    .addAltForm(DecadeRiderItems.RYUKI_STRIKE_VENT_CARD.get(), (RiderFormChangeItem) DecadeRiderItems.RYUKI_CARD.get())
                    .addAltForm(DecadeRiderItems.HIBIKI_ONGEKIBOU_REKKA_CARD.get(), (RiderFormChangeItem) DecadeRiderItems.HIBIKI_CARD.get())
                    .addAltWeapon(HibikiRiderItems.ONGEKIBO_REKKA.get(), DecadeRiderItems.ONGEKIBO_REKKA_DECADE.get(), DecadeRiderItems.ONGEKIBO_REKKA_DECADE.get())
                    .addAltWeapon(DecadeRiderItems.DECADE_BLAST_CARD.get(), DecadeRiderItems.DECADE_BAZOOKA.get())
                    .addAltWeapon(DecadeRiderItems.REKKA_DAIZANTOU_CARD.get(), BuiltInRegistries.ITEM.get(ResourceLocation.parse("supersentaicraft:rekka_daizantou")))
                    .addAltWeapon(DecadeRiderItems.G4_GIGANT_CARD.get(), AgitoRiderItems.G4_GIGANT.get())
                    .addAltWeapon(DecadeRiderItems.RYUKI_STRIKE_VENT_CARD.get(), RyukiRiderItems.DRAG_CLAW.get())
                    .addAltWeapon(DecadeRiderItems.HIBIKI_ONGEKIBOU_REKKA_CARD.get(), HibikiRiderItems.ONGEKIBO_REKKA.get(), HibikiRiderItems.ONGEKIBO_REKKA.get())
                    .isGlowing().changeBeltModel("geo/zi_o_decade_riderbelt.geo.json").IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZI_O_II_RIDEWATCH = ITEMS.register("zi_o_ii_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), "_ii", "zi_o", "ziku_driver_zi_o_belt_zi_o_ii",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZI_O_TRINITY_RIDEWATCH = ITEMS.register("zi_o_trinity_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), "_trinity", "zi_o", "ziku_driver_zi_o_belt_trinity",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
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
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GRAND_ZI_O_RIDEWATCH = ITEMS.register("grand_zi_o_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE), "_grand", "zi_o", "ziku_driver_zi_o_belt_grand",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.SATURATION, 40, 0, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RANDOM_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .isGlowing().IsBeltGlowing().changeBeltModel("geo/zi_o_decade_riderbelt.geo.json").addToList(DecadeRiderItems.COMPLETE_21_FORMS).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> OHMA_ZI_O_RIDEWATCH = ITEMS.register("ohma_zi_o_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC), "_ohma", "zi_o", "ziku_driver_zi_o_belt_ohma",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 6, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 6, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 6, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 6, true, false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.SATURATION, 40, 0, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GEIZ_RIDEWATCH = ITEMS.register("geiz_ridewatch",
            () -> new GeizRidewatchItem(new Item.Properties(), "", "geiz", "ziku_driver_geiz_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GEIZ_REVIVE_SHIPPU_RIDEWATCH = ITEMS.register("geiz_revive_shippu_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), "_revive_shippu", "geiz", "ziku_driver_geiz_belt_revive",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().model_has_different_name("geiz_revive_ridewatch").has_basic_model());

    public static final DeferredItem<Item> GEIZ_REVIVE_RIDEWATCH = ITEMS.register("geiz_revive_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), "_revive_goretsu", "geiz", "ziku_driver_geiz_belt_revive",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().addSwitchForm(GEIZ_REVIVE_SHIPPU_RIDEWATCH.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GEIZ_MAJESTY_RIDEWATCH = ITEMS.register("geiz_majesty_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE), "_majesty", "geiz", "ziku_driver_geiz_belt_majesty",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.REGENERATION, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.SATURATION, 40, 0, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RANDOM_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().changeBeltModel("geo/zi_o_decade_riderbelt.geo.json").addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> TSUKUYOMI_RIDEWATCH = ITEMS.register("tsukuyomi_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), "", "tsukuyomi", "ziku_driver_tsukuyomi_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> WOZ_MIRIDEWATCH = ITEMS.register("woz_miridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "woz", "beyondriver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZI_O_MIRROR_RIDEWATCH = ITEMS.register("zi_o_mirror_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "zi_o_mirror", "ziku_driver_zi_o_mirror_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BARLCKXS_RIDEWATCH = ITEMS.register("barlckxs_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "barlckxs", "ziku_driver_barlckxs_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZONJIS_RIDEWATCH = ITEMS.register("zonjis_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "zonjis", "ziku_driver_zonjis_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZAMONAS_RIDEWATCH = ITEMS.register("zamonas_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "zamonas", "ziku_driver_zamonas_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));


    public static final DeferredItem<Item> KUUGA_RIDEWATCH = ITEMS.register("kuuga_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_kuuga", "zi_o", "ziku_driver_zi_o_belt_kuuga",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) KuugaRiderItems.ARCLE.get())
                    .addAltWeapon(KuugaRiderItems.KUUGA_DRAGON.get(), KuugaRiderItems.DRAGON_ROD.get())
                    .addAltWeapon(KuugaRiderItems.KUUGA_RISING_DRAGON.get(), KuugaRiderItems.DRAGON_ROD.get())
                    .addAltWeapon(KuugaRiderItems.KUUGA_PEGASUS.get(), KuugaRiderItems.PEGASUS_BOWGUN.get())
                    .addAltWeapon(KuugaRiderItems.KUUGA_RISING_PEGASUS.get(), KuugaRiderItems.PEGASUS_BOWGUN.get())
                    .addAltWeapon(KuugaRiderItems.KUUGA_TITAN.get(), KuugaRiderItems.TITAN_SWORD.get())
                    .addAltWeapon(KuugaRiderItems.KUUGA_RISING_TITAN.get(), KuugaRiderItems.TITAN_SWORD.get())
                    .addAltWeapon(ModdedItemCore.GRANDGOURAM.get(), ModdedItemCore.GRANDGOURAM_ROD.get())
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> AGITO_RIDEWATCH = ITEMS.register("agito_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_agito", "zi_o", "ziku_driver_zi_o_belt_agito",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) AgitoRiderItems.ALTERING.get())
                    .addAltWeapon(AgitoRiderItems.AGITO_FLAME.get(), AgitoRiderItems.FLAME_SABER.get())
                    .addAltWeapon(AgitoRiderItems.AGITO_STORM.get(), AgitoRiderItems.STORM_HALBERD.get())
                    .addAltWeapon(AgitoRiderItems.AGITO_TRINITY.get(), AgitoRiderItems.FLAME_SABER.get(), AgitoRiderItems.STORM_HALBERD.get())
                    .addAltWeapon(AgitoRiderItems.AGITO_BURNING.get(), AgitoRiderItems.SHINING_CALIBER.get())
                    .addAltWeapon(AgitoRiderItems.AGITO_SHINING.get(), AgitoRiderItems.SHINING_CALIBER_TWIN.get(), AgitoRiderItems.SHINING_CALIBER_TWIN.get())
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_RYUKI_RIDEWATCH = ITEMS.register("decade_ryuki_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), "_decade_ryuki", "zi_o", "ziku_driver_zi_o_belt_decade_ryuki",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .isGlowing().IsBeltGlowing().changeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

    public static final DeferredItem<Item> RYUKI_RIDEWATCH = ITEMS.register("ryuki_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_ryuki", "zi_o", "ziku_driver_zi_o_belt_ryuki",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) RyukiRiderItems.RYUKIDRIVER.get())
                    .addAltForm(RyukiRiderItems.RIDE_SABER_VENT.get(), (RiderFormChangeItem) RyukiRiderItems.ADVENT_CARD.get())
                    .addAltForm(RyukiRiderItems.DRAG_VISOR_ZWEI_VENT.get(), (RiderFormChangeItem) RyukiRiderItems.SURVIVE_REKKA.get())
                    .addAltForm(RyukiRiderItems.DRAG_BLADE_VENT.get(), (RiderFormChangeItem) RyukiRiderItems.SURVIVE_REKKA.get())
                    .addAltWeapon(RyukiRiderItems.RIDE_SABER_VENT.get(), RyukiRiderItems.RIDE_SABER.get())
                    .addAltWeapon(RyukiRiderItems.DRAG_SABER_VENT.get(), RyukiRiderItems.DRAG_SABER.get())
                    .addAltWeapon(RyukiRiderItems.DRAG_CLAW_VENT.get(), RyukiRiderItems.DRAG_CLAW.get())
                    .addAltWeapon(RyukiRiderItems.DRAG_SHIELD_VENT.get(), RyukiRiderItems.DRAG_SHIELD.get(), RyukiRiderItems.DRAG_SHIELD.get())
                    .addAltWeapon(RyukiRiderItems.DRAG_VISOR_ZWEI_VENT.get(), RyukiRiderItems.DRAG_VISOR_ZWEI.get())
                    .addAltWeapon(RyukiRiderItems.DRAG_BLADE_VENT.get(), RyukiRiderItems.DRAG_BLADE.get())
                    .isGlowing().IsBeltGlowing().addIncompatibleForm(DECADE_RIDEWATCH.asItem()).addAlternative(DECADE_RYUKI_RIDEWATCH.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_FAIZ_RIDEWATCH = ITEMS.register("decade_faiz_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), "_decade_faiz", "zi_o", "ziku_driver_zi_o_belt_decade_faiz",
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 7,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 6,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .isGlowing().IsBeltGlowing().addNeedForm(DECADE_RIDEWATCH.asItem(), 1).changeBeltModel("geo/zi_o_decade_riderbelt_faiz_axel.geo.json"));

    public static final DeferredItem<Item> FAIZ_RIDEWATCH = ITEMS.register("faiz_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_faiz", "geiz", "ziku_driver_geiz_belt_faiz",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) FaizRiderItems.FAIZ_DRIVER.get())
                    .addSummonWeapon(FaizRiderItems.FAIZ_EDGE.get())
                    .addAltWeapon(FaizRiderItems.FAIZ_PHONE.get(), FaizRiderItems.FAIZ_PHONE.get())
                    .addAltWeapon(FaizRiderItems.FAIZ_PHONE_POINTER.get(), FaizRiderItems.FAIZ_PHONE_POINTER.get())
                    .addAltWeapon(FaizRiderItems.FAIZ_SHOT.get(), FaizRiderItems.FAIZ_SHOT.get())
                    .addAltForm(FaizRiderItems.FAIZ_AXEL.get(), (RiderFormChangeItem) FaizRiderItems.FAIZ_AXEL_FORM.get())
                    .addAltWeapon(FaizRiderItems.FAIZ_AXEL.get(), Items.AIR)
                    .addAltWeapon(FaizRiderItems.FAIZ_BLASTER_MISSION_MEMORY.get(), FaizRiderItems.FAIZ_BLASTER.get())
                    .addAltWeapon(FaizRiderItems.FAIZ_GOLD_BLASTER_MISSION_MEMORY.get(), FaizRiderItems.FAIZ_BLASTER.get())
                    .addAltWeapon(ModdedItemCore.BAKUEN_NO_SENSHI.get(), FaizRiderItems.FAIZ_BLASTER.get())
                    .isGlowing().IsBeltGlowing().addIncompatibleForm(DECADE_RIDEWATCH.asItem()).addAlternative(DECADE_FAIZ_RIDEWATCH.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BLADE_RIDEWATCH = ITEMS.register("blade_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_blade", "zi_o", "ziku_driver_zi_o_belt_blade",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) BladeRiderItems.BLAYBUCKLE.get())
                    .addSummonWeapon(BladeRiderItems.BLAYROUZER.get())
                    .addAltWeapon(BladeRiderItems.EVOLUTION_CAUCASUS.get(), BladeRiderItems.KINGROUZER.get())
                    .addAltWeapon(BladeRiderItems.SILVER_EVOLUTION_CAUCASUS.get(), BladeRiderItems.KINGROUZER.get())
                    .addAltWeapon(ModdedItemCore.HERCULESPADER.get(), ModdedItemCore.HERCULESPADER_SWORD.get())
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> HIBIKI_RIDEWATCH = ITEMS.register("hibiki_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_hibiki", "zi_o", "ziku_driver_zi_o_belt_hibiki",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) HibikiRiderItems.HIBIKIDRIVER.get())
                    .addSummonWeapon(HibikiRiderItems.ONGEKIBO_REKKA.get())
                    .addSummonWeapon(HibikiRiderItems.ONGEKIBO_REKKA.get())
                    .addAltForm(HibikiRiderItems.ARMED_SABER.get(), (RiderFormChangeItem) HibikiRiderItems.HENSHIN_ONSA_ARMED.get())
                    .addAltWeapon(HibikiRiderItems.ARMED_SABER.get(), HibikiRiderItems.ARMED_SABER.get())
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> KABUTO_RIDEWATCH = ITEMS.register("kabuto_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_kabuto", "zi_o", "ziku_driver_zi_o_belt_kabuto",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) KabutoRiderItems.KABUTO_RIDER_BELT.get())
                    .setSummonForm((RiderFormChangeItem) KabutoRiderItems.KABUTO_ZECTER.get())
                    .addSummonWeapon(KabutoRiderItems.KABUTO_KUNAI.get())
                    .addAltForm(KabutoRiderItems.KABUTO_ZECTER.get(), (RiderFormChangeItem) KabutoRiderItems.KABUTO_ZECTER_MASK.get())
                    .addAltWeapon(KabutoRiderItems.HYPER_ZECTER.get(), KabutoRiderItems.PERFECT_ZECTER.get())
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_RIDEWATCH = ITEMS.register("den_o_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_den_o", "zi_o", "ziku_driver_zi_o_belt_den_o",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) DenORiderItems.DEN_O_BELT.get())
                    .addSummonWeapon(DenORiderItems.DEN_GASHER_SWORD.get())
                    .addAltForm(DenORiderItems.DENKAMEN_SWORD.get(), (RiderFormChangeItem) DenORiderItems.DEN_O_LINER_FORM.get())
                    .addAltWeapon(DenORiderItems.RIDER_TICKET.get(), Items.AIR)
                    .addAltWeapon(DenORiderItems.RIDER_TICKET_ROD.get(), DenORiderItems.DEN_GASHER_ROD.get())
                    .addAltWeapon(DenORiderItems.RIDER_TICKET_AX.get(), DenORiderItems.DEN_GASHER_AX.get())
                    .addAltWeapon(DenORiderItems.RIDER_TICKET_GUN.get(), DenORiderItems.DEN_GASHER_GUN.get())
                    .addAltWeapon(DenORiderItems.RIDER_TICKET_WING.get(), DenORiderItems.DEN_GASHER_HANDAX.get(), DenORiderItems.DEN_GASHER_BOOMERANG.get())
                    .addAltWeapon(DenORiderItems.DENKAMEN_SWORD.get(), DenORiderItems.DENKAMEN_SWORD.get())
                    .addAltWeapon(DenORiderItems.RIDER_TICKET_PUDDING.get(), DenORiderItems.DEN_GASHER_PUDDING.get())
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> KIVA_RIDEWATCH = ITEMS.register("kiva_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_kiva", "zi_o", "ziku_driver_zi_o_belt_kiva",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) KivaRiderItems.KIVAT_BELT.get())
                    .addAltWeapon(KivaRiderItems.GARULU_FUESTLE.get(), KivaRiderItems.GARULU_SABER.get())
                    .addAltWeapon(KivaRiderItems.BASSHAA_FUESTLE.get(), KivaRiderItems.BASSHAA_MAGNUM.get())
                    .addAltWeapon(KivaRiderItems.DOGGA_FUESTLE.get(), KivaRiderItems.DOGGA_HAMMER.get())
                    .addAltWeapon(KivaRiderItems.TATSULOT.get(), KivaRiderItems.ZANVAT_SWORD.get())
                    .addAltWeapon(KivaRiderItems.KIVATTE_FUESTLE.get(), KivaRiderItems.ZANVAT_SWORD.get())
                    .addAltForm(KivaRiderItems.WAKE_UP_FUESTLE_REY.get(), (RiderFormChangeItem) KivaRiderItems.FLIGHT_STYLE_FUESTLE.get())
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> W_RIDEWATCH = ITEMS.register("w_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_w", "zi_o", "ziku_driver_zi_o_belt_w",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.SLOW_FALLING, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) WRiderItems.WDRIVER.get())
                    .addAltForm(WRiderItems.HEAT_MEMORY.get(), (RiderFormChangeItem) WRiderItems.METAL_MEMORY.get())
                    .addAltForm(WRiderItems.METAL_MEMORY.get(), (RiderFormChangeItem) WRiderItems.HEAT_MEMORY.get())
                    .addAltForm(WRiderItems.LUNA_MEMORY.get(), (RiderFormChangeItem) WRiderItems.TRIGGER_MEMORY.get())
                    .addAltForm(WRiderItems.TRIGGER_MEMORY.get(), (RiderFormChangeItem) WRiderItems.LUNA_MEMORY.get())
                    .addAltWeapon(WRiderItems.HEAT_MEMORY.get(), WRiderItems.METAL_SHAFT.get())
                    .addAltWeapon(WRiderItems.METAL_MEMORY.get(), WRiderItems.METAL_SHAFT.get())
                    .addAltWeapon(WRiderItems.LUNA_MEMORY.get(), WRiderItems.TRIGGER_MAGNUM.get())
                    .addAltWeapon(WRiderItems.TRIGGER_MEMORY.get(), WRiderItems.TRIGGER_MAGNUM.get())
                    .addAltWeapon(WRiderItems.XTREME_MEMORY.get(), WRiderItems.PRISM_BICKER.get(), WRiderItems.SHIELD_PRISM_BICKER.get())
                    .addAltWeapon(WRiderItems.XTREME_GOLD_MEMORY.get(), WRiderItems.PRISM_BICKER.get(), WRiderItems.SHIELD_PRISM_BICKER.get())
                    .addAltWeapon(WRiderItems.XTREME_ACCEL_MEMORY.get(), WRiderItems.PRISM_BICKER.get(), WRiderItems.SHIELD_PRISM_BICKER.get())
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_OOO_RIDEWATCH = ITEMS.register("decade_ooo_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), "_decade_ooo", "zi_o", "ziku_driver_zi_o_belt_decade_ooo",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 800, 0,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().changeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

    public static final DeferredItem<Item> OOO_RIDEWATCH = ITEMS.register("ooo_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_ooo", "zi_o", "ziku_driver_zi_o_belt_ooo",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 800, 0,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
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
                    .setSummonBelt((RiderDriverItem) OOORiderItems.OOODRIVER.get())
                    .addSummonWeapon(OOORiderItems.MEDAJALIBUR.get())
                    .addAltForm(OOORiderItems.TAKA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KUJAKU_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.CONDOR_MEDAL.get())
                    .addAltForm(OOORiderItems.FOUNDATION_X_TAKA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KUJAKU_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.CONDOR_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_TAKA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KUJAKU_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.CONDOR_MEDAL.get())
                    .addAltForm(OOORiderItems.TAKA_ANKH_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KUJAKU_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.CONDOR_MEDAL.get())
                    .addAltForm(OOORiderItems.KUJAKU_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.CONDOR_MEDAL.get())
                    .addAltForm(OOORiderItems.FOUNDATION_X_KUJAKU_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.CONDOR_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_KUJAKU_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.CONDOR_MEDAL.get())
                    .addAltForm(OOORiderItems.CONDOR_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KUJAKU_MEDAL.get())
                    .addAltForm(OOORiderItems.FOUNDATION_X_CONDOR_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KUJAKU_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_CONDOR_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KUJAKU_MEDAL.get())
                    .addAltForm(OOORiderItems.LION_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.CHEETAH_MEDAL.get())
                    .addAltForm(OOORiderItems.FOUNDATION_X_LION_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.CHEETAH_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_LION_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.CHEETAH_MEDAL.get())
                    .addAltForm(OOORiderItems.TORA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.LION_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.CHEETAH_MEDAL.get())
                    .addAltForm(OOORiderItems.FOUNDATION_X_TORA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.LION_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.CHEETAH_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_TORA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.LION_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.CHEETAH_MEDAL.get())
                    .addAltForm(OOORiderItems.CHEETAH_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.LION_MEDAL.get())
                    .addAltForm(OOORiderItems.FOUNDATION_X_CHEETAH_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.LION_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_CHEETAH_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.LION_MEDAL.get())
                    .addAltForm(OOORiderItems.KUWAGATA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KAMAKIRI_MEDAL.get())
                    .addAltForm(OOORiderItems.FOUNDATION_X_KUWAGATA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KAMAKIRI_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_KUWAGATA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KAMAKIRI_MEDAL.get())
                    .addAltForm(OOORiderItems.KAMAKIRI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KUWAGATA_MEDAL.get())
                    .addAltForm(OOORiderItems.FOUNDATION_X_KAMAKIRI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KUWAGATA_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_KAMAKIRI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KUWAGATA_MEDAL.get())
                    .addAltForm(OOORiderItems.BATTA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KUWAGATA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KAMAKIRI_MEDAL.get())
                    .addAltForm(OOORiderItems.FOUNDATION_X_BATTA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KUWAGATA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KAMAKIRI_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_BATTA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KUWAGATA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KAMAKIRI_MEDAL.get())
                    .addAltForm(OOORiderItems.SAI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.GORILLA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.ZOU_MEDAL.get())
                    .addAltForm(OOORiderItems.FOUNDATION_X_SAI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.GORILLA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.ZOU_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_SAI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.GORILLA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.ZOU_MEDAL.get())
                    .addAltForm(OOORiderItems.GORILLA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SAI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.ZOU_MEDAL.get())
                    .addAltForm(OOORiderItems.FOUNDATION_X_GORILLA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SAI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.ZOU_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_GORILLA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SAI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.ZOU_MEDAL.get())
                    .addAltForm(OOORiderItems.ZOU_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SAI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.GORILLA_MEDAL.get())
                    .addAltForm(OOORiderItems.FOUNDATION_X_ZOU_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SAI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.GORILLA_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_ZOU_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SAI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.GORILLA_MEDAL.get())
                    .addAltForm(OOORiderItems.SHACHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.UNAGI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TAKO_MEDAL.get())
                    .addAltForm(OOORiderItems.FOUNDATION_X_SHACHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.UNAGI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TAKO_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_SHACHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.UNAGI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TAKO_MEDAL.get())
                    .addAltForm(OOORiderItems.UNAGI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SHACHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TAKO_MEDAL.get())
                    .addAltForm(OOORiderItems.FOUNDATION_X_UNAGI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SHACHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TAKO_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_UNAGI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SHACHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TAKO_MEDAL.get())
                    .addAltForm(OOORiderItems.TAKO_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SHACHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.UNAGI_MEDAL.get())
                    .addAltForm(OOORiderItems.FOUNDATION_X_TAKO_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SHACHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.UNAGI_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_TAKO_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SHACHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.UNAGI_MEDAL.get())
                    .addAltForm(OOORiderItems.PTERA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TRICERA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TYRANNO_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_PTERA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TRICERA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TYRANNO_MEDAL.get())
                    .addAltForm(OOORiderItems.TRICERA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.PTERA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TYRANNO_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_TRICERA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.PTERA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TYRANNO_MEDAL.get())
                    .addAltForm(OOORiderItems.TYRANNO_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.PTERA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TRICERA_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_TYRANNO_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.PTERA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TRICERA_MEDAL.get())
                    .addAltForm(OOORiderItems.COBRA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KAME_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.WANI_MEDAL.get())
                    .addAltForm(OOORiderItems.KAME_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.COBRA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.WANI_MEDAL.get())
                    .addAltForm(OOORiderItems.WANI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.COBRA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KAME_MEDAL.get())
                    .addAltForm(OOORiderItems.MUKADE_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.HACHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.ARI_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_MUKADE_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.HACHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.ARI_MEDAL.get())
                    .addAltForm(OOORiderItems.HACHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.ARI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.MUKADE_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_HACHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.ARI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.MUKADE_MEDAL.get())
                    .addAltForm(OOORiderItems.ARI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.HACHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.MUKADE_MEDAL.get())
                    .addAltForm(OOORiderItems.ZEUS_ARI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.HACHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.MUKADE_MEDAL.get())
                    .addAltForm(OOORiderItems.EBI_NEW_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KANI_NEW_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SASORI_NEW_MEDAL.get())
                    .addAltForm(OOORiderItems.KANI_NEW_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.EBI_NEW_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SASORI_NEW_MEDAL.get())
                    .addAltForm(OOORiderItems.SASORI_NEW_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.EBI_NEW_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KANI_NEW_MEDAL.get())
                    .addAltForm(OOORiderItems.SAME_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KUJIRA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.OOKAMIUO_MEDAL.get())
                    .addAltForm(OOORiderItems.KUJIRA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SAME_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.OOKAMIUO_MEDAL.get())
                    .addAltForm(OOORiderItems.OOKAMIUO_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SAME_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KUJIRA_MEDAL.get())
                    .addAltForm(OOORiderItems.SHIKA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.GAZELLE_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.USHI_MEDAL.get())
                    .addAltForm(OOORiderItems.GAZELLE_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SHIKA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.USHI_MEDAL.get())
                    .addAltForm(OOORiderItems.USHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SHIKA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.GAZELLE_MEDAL.get())
                    .addAltForm(OOORiderItems.SEIUCHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SHIROKUMA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.PENGUIN_MEDAL.get())
                    .addAltForm(OOORiderItems.SHIROKUMA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SEIUCHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.PENGUIN_MEDAL.get())
                    .addAltForm(OOORiderItems.PENGUIN_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SEIUCHI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SHIROKUMA_MEDAL.get())
                    .addAltForm(OOORiderItems.SUPER_TAKA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SUPER_TORA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SUPER_BATTA_MEDAL.get())
                    .addAltForm(OOORiderItems.SUPER_TORA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SUPER_TAKA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SUPER_BATTA_MEDAL.get())
                    .addAltForm(OOORiderItems.SUPER_BATTA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SUPER_TAKA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SUPER_TORA_MEDAL.get())
                    .addAltForm(OOORiderItems.TAKA_ETERNITY_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KUJAKU_ETERNITY_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.CONDOR_ETERNITY_MEDAL.get())
                    .addAltForm(OOORiderItems.KUJAKU_ETERNITY_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TAKA_ETERNITY_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.CONDOR_ETERNITY_MEDAL.get())
                    .addAltForm(OOORiderItems.CONDOR_ETERNITY_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TAKA_ETERNITY_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.KUJAKU_ETERNITY_MEDAL.get())
                    .addAltForm(OOORiderItems.LOVE_CORE_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.LOVE_CORE2_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.LOVE_CORE3_MEDAL.get())
                    .addAltForm(OOORiderItems.LOVE_CORE2_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.LOVE_CORE_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.LOVE_CORE3_MEDAL.get())
                    .addAltForm(OOORiderItems.LOVE_CORE3_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.LOVE_CORE_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.LOVE_CORE2_MEDAL.get())
                    .addAltForm(OOORiderItems.HABATAKI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TAIGA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.ICHIGO_MEDAL.get())
                    .addAltForm(OOORiderItems.TAIGA_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.HABATAKI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.ICHIGO_MEDAL.get())
                    .addAltForm(OOORiderItems.ICHIGO_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.HABATAKI_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.TAIGA_MEDAL.get())
                    .addAltForm(OOORiderItems.IMAGIN_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.SHOCKER_MEDAL.get())
                    .addAltForm(OOORiderItems.SHOCKER_MEDAL.get(), (RiderFormChangeItem) OOORiderItems.IMAGIN_MEDAL.get())
                    .addAltWeapon(OOORiderItems.TAKA_MEDAL.get(), OOORiderItems.TAJASPINNER.get())
                    .addAltWeapon(OOORiderItems.FOUNDATION_X_TAKA_MEDAL.get(), OOORiderItems.TAJASPINNER.get())
                    .addAltWeapon(OOORiderItems.ZEUS_TAKA_MEDAL.get(), OOORiderItems.TAJASPINNER.get())
                    .addAltWeapon(OOORiderItems.TAKA_ANKH_MEDAL.get(), OOORiderItems.TAJASPINNER.get())
                    .addAltWeapon(OOORiderItems.KUJAKU_MEDAL.get(), OOORiderItems.TAJASPINNER.get())
                    .addAltWeapon(OOORiderItems.FOUNDATION_X_KUJAKU_MEDAL.get(), OOORiderItems.TAJASPINNER.get())
                    .addAltWeapon(OOORiderItems.ZEUS_KUJAKU_MEDAL.get(), OOORiderItems.TAJASPINNER.get())
                    .addAltWeapon(OOORiderItems.CONDOR_MEDAL.get(), OOORiderItems.TAJASPINNER.get())
                    .addAltWeapon(OOORiderItems.FOUNDATION_X_CONDOR_MEDAL.get(), OOORiderItems.TAJASPINNER.get())
                    .addAltWeapon(OOORiderItems.ZEUS_CONDOR_MEDAL.get(), OOORiderItems.TAJASPINNER.get())
                    .addAltWeapon(OOORiderItems.PTERA_MEDAL.get(), OOORiderItems.MEDAGABURYU.get())
                    .addAltWeapon(OOORiderItems.ZEUS_PTERA_MEDAL.get(), OOORiderItems.MEDAGABURYU.get())
                    .addAltWeapon(OOORiderItems.TRICERA_MEDAL.get(), OOORiderItems.MEDAGABURYU.get())
                    .addAltWeapon(OOORiderItems.ZEUS_TRICERA_MEDAL.get(), OOORiderItems.MEDAGABURYU.get())
                    .addAltWeapon(OOORiderItems.TYRANNO_MEDAL.get(), OOORiderItems.MEDAGABURYU.get())
                    .addAltWeapon(OOORiderItems.ZEUS_TYRANNO_MEDAL.get(), OOORiderItems.MEDAGABURYU.get())
                    .addAltWeapon(OOORiderItems.TAKA_ETERNITY_MEDAL.get(), OOORiderItems.TAJASPINNER_ETERNITY.get())
                    .addAltWeapon(OOORiderItems.KUJAKU_ETERNITY_MEDAL.get(), OOORiderItems.TAJASPINNER_ETERNITY.get())
                    .addAltWeapon(OOORiderItems.CONDOR_ETERNITY_MEDAL.get(), OOORiderItems.TAJASPINNER_ETERNITY.get())
                    .isGlowing().IsBeltGlowing().addIncompatibleForm(DECADE_RIDEWATCH.asItem()).addAlternative(DECADE_OOO_RIDEWATCH.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> FOURZE_RIDEWATCH = ITEMS.register("fourze_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_fourze", "zi_o", "ziku_driver_zi_o_belt_fourze",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.BOOST, 40, 0, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) FourzeRiderItems.FOURZE_DRIVER.get())
                    .addAltForm(FourzeRiderItems.MAGNET_ASTROSWITCH_N.get(), (RiderFormChangeItem) FourzeRiderItems.MAGNET_ASTROSWITCH_S.get(), (RiderFormChangeItem) FourzeRiderItems.FOURZE_MAGNET_STATES.get())
                    .addAltForm(FourzeRiderItems.MAGNET_ASTROSWITCH_S.get(), (RiderFormChangeItem) FourzeRiderItems.MAGNET_ASTROSWITCH_N.get(), (RiderFormChangeItem) FourzeRiderItems.FOURZE_MAGNET_STATES.get())
                    .addAltWeapon(FourzeRiderItems.ELEK_ASTROSWITCH.get(), FourzeRiderItems.BILLY_THE_ROD.get())
                    .addAltWeapon(FourzeRiderItems.SHIELD_ASTROSWITCH.get(), FourzeRiderItems.SHIELD_MODULE.get())
                    .addAltWeapon(FourzeRiderItems.FIRE_ASTROSWITCH.get(), FourzeRiderItems.HEE_HACKGUN.get())
                    .addAltWeapon(FourzeRiderItems.COSMIC_ASTROSWITCH.get(), FourzeRiderItems.BARIZUN_SWORD.get())
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> WIZARD_RIDEWATCH = ITEMS.register("wizard_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_wizard", "geiz", "ziku_driver_geiz_belt_wizard",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) WizardRiderItems.WIZARDRIVER.get())
                    .addSummonWeapon(WizardRiderItems.WIZARSWORDSGUN.get())
                    .addAltForm(WizardRiderItems.DRAGO_TIMER.get(), (RiderFormChangeItem) WizardRiderItems.DRAGO_TIMER.get())
                    .addAltForm(WizardRiderItems.SPECIAL_RUSH_RING.get(), (RiderFormChangeItem) WizardRiderItems.SPECIAL_RUSH_RING.get())
                    .addAltForm(WizardRiderItems.FINISH_STRIKE_RING.get(), (RiderFormChangeItem) WizardRiderItems.FINISH_STRIKE_RING_NO_HOPE.get())
                    .addAltForm(WizardRiderItems.HOPE_RING.get(), (RiderFormChangeItem) WizardRiderItems.FINISH_STRIKE_RING.get())
                    .addAltForm(WizardRiderItems.FALCO_RING.get(), (RiderFormChangeItem) WizardRiderItems.FALCO_RING_WIZARD.get())
                    .addAltForm(WizardRiderItems.BUFFA_RING.get(), (RiderFormChangeItem) WizardRiderItems.BUFFA_RING_WIZARD.get())
                    .addAltWeapon(WizardRiderItems.INFINITY_WIZARD_RING.get(), WizardRiderItems.AXCALIBUR.get())
                    .addAltWeapon(WizardRiderItems.FINISH_STRIKE_RING.get(), WizardRiderItems.AXCALIBUR.get())
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GAIM_RIDEWATCH = ITEMS.register("gaim_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_gaim", "zi_o", "ziku_driver_zi_o_belt_gaim",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) GaimRiderItems.SENGOKU_DRIVER_GAIM.get())
                    .addSummonWeapon(GaimRiderItems.DAIDAIMARU.get())
                    .addSummonWeapon(GaimRiderItems.MUSOU_SABER.get())
                    .addAltWeapon(GaimRiderItems.MATSUBOKKURI_LOCKSEED.get(), GaimRiderItems.KAGEMATSU.get())
                    .addAltWeapon(GaimRiderItems.KURUMI_LOCKSEED.get(), Items.AIR)
                    .addAltWeapon(GaimRiderItems.DONGURI_LOCKSEED.get(), GaimRiderItems.DONKACHI.get())
                    .addAltWeapon(GaimRiderItems.MELON_LOCKSEED.get(), GaimRiderItems.MELON_DEFENDER.get())
                    .addAltWeapon(GaimRiderItems.PINE_LOCKSEED.get(), GaimRiderItems.PINE_IRON.get())
                    .addAltWeapon(GaimRiderItems.ICHIGO_LOCKSEED.get(), GaimRiderItems.ICHIGO_KUNAI.get(), GaimRiderItems.ICHIGO_KUNAI.get())
                    .addAltWeapon(GaimRiderItems.BANANA_LOCKSEED.get(), GaimRiderItems.BANA_SPEAR.get())
                    .addAltWeapon(GaimRiderItems.BUDOU_LOCKSEED.get(), GaimRiderItems.BUDOU_RYUHOU.get())
                    .addAltWeapon(GaimRiderItems.SUIKA_LOCKSEED.get(), GaimRiderItems.SUIKA_SOJINTO.get())
                    .addAltWeapon(GaimRiderItems.MANGO_LOCKSEED.get(), GaimRiderItems.MANGO_PUNISHER.get())
                    .addAltWeapon(GaimRiderItems.DURIAN_LOCKSEED.get(), GaimRiderItems.DURI_NOKO.get(), GaimRiderItems.DURI_NOKO.get())
                    .addAltWeapon(GaimRiderItems.KIWI_LOCKSEED.get(), GaimRiderItems.KIWI_GEKIRIN.get())
                    .addAltWeapon(GaimRiderItems.LEMON_LOCKSEED.get(), GaimRiderItems.LEMON_RAPIER.get())
                    .addAltWeapon(GaimRiderItems.LEMON_ENERGY_LOCKSEED.get(), GaimRiderItems.SONIC_ARROW.get())
                    .addAltWeapon(GaimRiderItems.CHERRY_ENERGY_LOCKSEED.get(), GaimRiderItems.SONIC_ARROW.get())
                    .addAltWeapon(GaimRiderItems.PEACH_ENERGY_LOCKSEED.get(), GaimRiderItems.SONIC_ARROW.get())
                    .addAltWeapon(GaimRiderItems.MELON_ENERGY_LOCKSEED.get(), GaimRiderItems.SONIC_ARROW.get())
                    .addAltWeapon(GaimRiderItems.DRAGON_FRUITS_ENERGY_LOCKSEED.get(), GaimRiderItems.SONIC_ARROW.get())
                    .addAltWeapon(GaimRiderItems.MARRON_ENERGY_LOCKSEED.get(), Items.AIR)
                    .addAltWeapon(GaimRiderItems.KACHIDOKI_LOCKSEED.get(), GaimRiderItems.DJ_GUN.get())
                    .addAltForm(GaimRiderItems.KIWAMI_LOCKSEED.get(), (RiderFormChangeItem) GaimRiderItems.KIWAMI_LOCKSEED.get())
                    .addAltWeapon(GaimRiderItems.KIWAMI_LOCKSEED.get(), GaimRiderItems.DJ_GUN_TAIKEN_MODE.get())
                    .addAltWeapon(GaimRiderItems.BLOOD_ORANGE_LOCKSEED.get(), GaimRiderItems.BLOOD_DAIDAIMARU.get())
                    .addAltWeapon(GaimRiderItems.FIFTEEN_LOCKSEED.get(), GaimRiderItems.YOMIMARU.get())
                    .addAltWeapon(GaimRiderItems.GOLDEN_RINGO_LOCKSEED.get(), GaimRiderItems.SWORD_BRINGER.get())
                    .addAltWeapon(GaimRiderItems.SILVER_RINGO_LOCKSEED.get(), GaimRiderItems.SOUGINJOU.get())
                    .addAltWeapon(GaimRiderItems.BLACK_RINGO_LOCKSEED.get(), GaimRiderItems.DARK_DAIDAIMARU.get())
                    .addAltWeapon(GaimRiderItems.FORBIBBEN_LOCKSEED.get(), GaimRiderItems.APPLE_REFLECTER.get())
                    .addAltWeapon(GaimRiderItems.MAJA_LOCKSEED.get(), GaimRiderItems.MAJAS_SWORD.get())
                    .addAltWeapon(GaimRiderItems.KABI_ORANGE_LOCKSEED.get(), GaimRiderItems.KABI_DAIDAIMARU.get())
                    .addAltWeapon(GaimRiderItems.FRESH_ORANGE_LOCKSEED.get(), GaimRiderItems.DAIDAIMARU.get(), GaimRiderItems.DAIDAIMARU.get())
                    .addAltWeapon(GaimRiderItems.HELEIM_LOCKSEED.get(), GaimRiderItems.HELLS_CANE.get())
                    .addAltWeapon(GaimRiderItems.NATSUMIKAN_LOCKSEED.get(), GaimRiderItems.MUSOU_SABER.get(), GaimRiderItems.DAIDAIMARU.get())
                    .addAltWeapon(GaimRiderItems.PROTO_DONGURI_LOCKSEED.get(), GaimRiderItems.DONKACHI.get())
                    .addAltWeapon(GaimRiderItems.PROTO_ORANGE_LOCKSEED.get(), GaimRiderItems.DAIDAIMARU.get(), GaimRiderItems.MUSOU_SABER.get())
                    .addAltWeapon(GaimRiderItems.PROTO_BANANA_LOCKSEED.get(), GaimRiderItems.BANA_SPEAR.get())
                    .addAltWeapon(GaimRiderItems.PROTO_BUDOU_LOCKSEED.get(), GaimRiderItems.BUDOU_RYUHOU.get())
                    .addAltWeapon(GaimRiderItems.PROTO_DURIAN_LOCKSEED.get(), GaimRiderItems.DURI_NOKO.get(), GaimRiderItems.DURI_NOKO.get())
                    .addAltForm(GaimRiderItems.DARK_LEMON_ENERGY_LOCKSEED.get(), (RiderFormChangeItem) GaimRiderItems.GAIM_YAMI_CORE.get())
                    .addAltWeapon(GaimRiderItems.DARK_LEMON_ENERGY_LOCKSEED.get(), GaimRiderItems.MUSOU_SABER.get())
                    .addAltWeapon(GaimRiderItems.DRIVE_LOCKSEED.get(), DriveRiderItems.HANDLE_KEN.get())
                    .addAltWeapon(GaimRiderItems.GAIM_LOCKSEED.get(), GaimRiderItems.MUSOU_SABER.get())
                    .addAltWeapon(GaimRiderItems.WIZARD_LOCKSEED.get(), WizardRiderItems.WIZARSWORDSGUN.get())
                    .addAltWeapon(GaimRiderItems.FOURZE_LOCKSEED.get(), FourzeRiderItems.BARIZUN_SWORD.get())
                    .addAltWeapon(GaimRiderItems.OOO_LOCKSEED.get(), OOORiderItems.MEDAJALIBUR.get())
                    .addAltWeapon(GaimRiderItems.W_LOCKSEED.get(), WRiderItems.TRIGGER_MAGNUM.get())
                    .addAltWeapon(GaimRiderItems.DECADE_LOCKSEED.get(), DecadeRiderItems.RIDE_BOOKER.get())
                    .addAltWeapon(GaimRiderItems.KIVA_LOCKSEED.get(), GaimRiderItems.MUSOU_SABER.get())
                    .addAltWeapon(GaimRiderItems.DEN_O_LOCKSEED.get(), DenORiderItems.DEN_GASHER_SWORD.get())
                    .addAltWeapon(GaimRiderItems.KABUTO_LOCKSEED.get(), KabutoRiderItems.KABUTO_KUNAI.get())
                    .addAltWeapon(GaimRiderItems.HIBIKI_LOCKSEED.get(), HibikiRiderItems.ONGEKIBO_REKKA.get(), HibikiRiderItems.ONGEKIBO_REKKA.get())
                    .addAltWeapon(GaimRiderItems.BLADE_LOCKSEED.get(), BladeRiderItems.BLAYROUZER.get())
                    .addAltWeapon(GaimRiderItems.FAIZ_LOCKSEED.get(), FaizRiderItems.FAIZ_EDGE.get())
                    .addAltWeapon(GaimRiderItems.RYUKI_LOCKSEED.get(), RyukiRiderItems.DRAG_SABER.get())
                    .addAltWeapon(GaimRiderItems.AGITO_LOCKSEED.get(), AgitoRiderItems.FLAME_SABER.get(), AgitoRiderItems.STORM_HALBERD.get())
                    .addAltWeapon(GaimRiderItems.KUUGA_LOCKSEED.get(), GaimRiderItems.MUSOU_SABER.get())
                    .addAltWeapon(GaimRiderItems.RIDER_ICHIGO_LOCKSEED.get(), GaimRiderItems.MUSOU_SABER.get())
                    .addAltWeapon(GaimRiderItems.SHOWA_RIDER_LOCKSEED.get(), GaimRiderItems.MUSOU_SABER.get())
                    .addAltWeapon(GaimRiderItems.HEISEI_RIDER_LOCKSEED.get(), GaimRiderItems.DAIDAIMARU.get(), GaimRiderItems.MUSOU_SABER.get())
                    .isGlowing().IsBeltGlowing().changeModel("default_rider_plusbelt_and_wings.geo.json").addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DRIVE_RIDEWATCH = ITEMS.register("drive_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_drive", "geiz", "ziku_driver_geiz_belt_drive",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) DriveRiderItems.DRIVE_DRIVER.get())
                    .addSummonWeapon(DriveRiderItems.HANDLE_KEN.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_PROTO_SPEED.get(), Items.AIR)
                    .addAltWeapon(DriveRiderItems.SHIFT_WILD.get(), Items.AIR)
                    .addAltWeapon(DriveRiderItems.SHIFT_TECHNIC.get(), DriveRiderItems.DOOR_JU.get())
                    .addAltBelt(DriveRiderItems.MACH_DRIVER_HONOH_DRIVE.get(), (RiderDriverItem) DriveRiderItems.MACH_DRIVER_HONOH_DRIVE.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_FORMULA.get(), DriveRiderItems.TRAILER_HOU.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_TRIDORON.get(), DriveRiderItems.TRAILER_HOU.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_SPECIAL.get(), DriveRiderItems.SHINGOU_AX.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_FRUITS.get(), GaimRiderItems.DAIDAIMARU.get(), GaimRiderItems.MUSOU_SABER.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_SPEED_WILD_TECHNIC.get(), Items.AIR)
                    .addAltWeapon(DriveRiderItems.SHIFT_JUSTICE_HUNTER.get(), DriveRiderItems.JUSTICE_CAGE.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_DREAM_VAGAS.get(), DriveRiderItems.DRUM_SHIELD_RED.get(), DriveRiderItems.DRUM_SHIELD_GREEN.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_MASSIVE_MONSTER.get(), DriveRiderItems.MONSTER_TOP.get(), DriveRiderItems.MONSTER_BOTTOM.get())
                    .addAltForm(DriveRiderItems.SHIFT_RUMBLE_DUMP.get(), (RiderFormChangeItem) DriveRiderItems.SHIFT_WILD.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_RUMBLE_DUMP.get(), DriveRiderItems.RUMBLE_SMASHER.get())
                    .addAltForm(DriveRiderItems.SHIFT_MAD_DOCTOR.get(), (RiderFormChangeItem) DriveRiderItems.SHIFT_WILD.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_MAD_DOCTOR.get(), DriveRiderItems.CURE_QUICKER.get())
                    .addAltForm(DriveRiderItems.SHIFT_HOOKING_WRECKER.get(), (RiderFormChangeItem) DriveRiderItems.SHIFT_WILD.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_HOOKING_WRECKER.get(), Items.AIR)
                    .addAltForm(DriveRiderItems.SHIFT_FIRE_BRAVER.get(), (RiderFormChangeItem) DriveRiderItems.SHIFT_TECHNIC.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_FIRE_BRAVER.get(), DriveRiderItems.DOOR_JU.get())
                    .addAltForm(DriveRiderItems.SHIFT_ROLLING_GRAVITY.get(), (RiderFormChangeItem) DriveRiderItems.SHIFT_TECHNIC.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_ROLLING_GRAVITY.get(), DriveRiderItems.TEN_TON_WEIGHT.get())
                    .addAltForm(DriveRiderItems.SHIFT_ROAD_WINTER.get(), (RiderFormChangeItem) DriveRiderItems.SHIFT_TECHNIC.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_ROAD_WINTER.get(), DriveRiderItems.DOOR_JU.get())
                    .addAltForm(DriveRiderItems.SHIFT_MANTARN_F01.get(), (RiderFormChangeItem) DriveRiderItems.SHIFT_FORMULA.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_MANTARN_F01.get(), DriveRiderItems.TRAILER_HOU.get())
                    .addAltForm(DriveRiderItems.SHIFT_JACKY_F02.get(), (RiderFormChangeItem) DriveRiderItems.SHIFT_FORMULA.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_JACKY_F02.get(), DriveRiderItems.TRAILER_HOU.get())
                    .addAltForm(DriveRiderItems.SHIFT_SPARNER_F03.get(), (RiderFormChangeItem) DriveRiderItems.SHIFT_FORMULA.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_SPARNER_F03.get(), DriveRiderItems.TRAILER_HOU.get())
                    .addAltForm(DriveRiderItems.SHIFT_MEGA_MAX_FLARE.get(), (RiderFormChangeItem) DriveRiderItems.SHIFT_HIGH_SPEED.get())
                    .addAltBelt(DriveRiderItems.TRIDORON_KEY.get(), (RiderDriverItem) DriveRiderItems.MACH_DRIVER_HONOH_DRIVE.get())
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_GHOST_RIDEWATCH = ITEMS.register("decade_ghost_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), "_decade_ghost", "zi_o", "ziku_driver_zi_o_belt_decade_ghost",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
                    new MobEffectInstance(EffectCore.GHOST, 40, 0,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().changeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

    public static final DeferredItem<Item> GHOST_RIDEWATCH_ZI_O = ITEMS.register("ghost_ridewatch_zi_o",
            () -> new RiderFormChangeItem(new Item.Properties(), "_ghost", "zi_o", "ziku_driver_zi_o_belt_ghost",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(EffectCore.GHOST, 40, 0,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addIncompatibleForm(DECADE_RIDEWATCH.asItem()).addAlternative(DECADE_GHOST_RIDEWATCH.get())
                    .isGlowing().IsBeltGlowing().model_has_different_name("ghost_ridewatch").has_basic_model());

    public static final DeferredItem<Item> GHOST_RIDEWATCH = ITEMS.register("ghost_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_ghost", "geiz", "ziku_driver_geiz_belt_ghost",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(EffectCore.GHOST, 40, 0,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) GhostRiderItems.GHOST_DRIVER.get())
                    .addSummonWeapon(GhostRiderItems.GAN_GUN_SABER_BLADE.get())
                    .addAltWeapon(GhostRiderItems.BOOST_GHOST_EYECON.get(), GhostRiderItems.SUNGLASSESLASHER.get())
                    .addAltForm(GhostRiderItems.TOUSAN_GHOST_EYECON.get(), (RiderFormChangeItem) GhostRiderItems.BOOST_GHOST_EYECON.get(), (RiderFormChangeItem) GhostRiderItems.BOOST_DAMASHII.get())
                    .addAltWeapon(GhostRiderItems.TOUSAN_GHOST_EYECON.get(), GhostRiderItems.SUNGLASSESLASHER.get())
                    .addAltBelt(GhostRiderItems.EYECON_DRIVER_G.get(), (RiderDriverItem) GhostRiderItems.EYECON_DRIVER_G.get())
                    .addAltWeapon(GhostRiderItems.MUSASHI_GHOST_EYECON.get(), GhostRiderItems.GAN_GUN_SABER_NITOURYU.get(), GhostRiderItems.GAN_GUN_SABER_NITOURYU_2.get())
                    .addAltWeapon(GhostRiderItems.EDISON_GHOST_EYECON.get(), GhostRiderItems.GAN_GUN_SABER_GUN.get())
                    .addAltWeapon(GhostRiderItems.ROBIN_GHOST_EYECON.get(), GhostRiderItems.GAN_GUN_SABER_CONDOR_DENWOR.get())
                    .addAltWeapon(GhostRiderItems.NEWTON_GHOST_EYECON.get(), GhostRiderItems.GAN_GUN_SABER_NAGINATA.get())
                    .addAltWeapon(GhostRiderItems.BILLY_THE_KID_GHOST_EYECON.get(), GhostRiderItems.GAN_GUN_SABER_RIFLE.get())
                    .addAltWeapon(GhostRiderItems.BEETHOVEN_GHOST_EYECON.get(), GhostRiderItems.GAN_GUN_SABER_NITOURYU.get(), GhostRiderItems.GAN_GUN_SABER_NITOURYU_2.get())
                    .addAltWeapon(GhostRiderItems.BENKEI_GHOST_EYECON.get(), GhostRiderItems.GAN_GUN_SABER_HAMMER.get())
                    .addAltForm(GhostRiderItems.GOEMON_GHOST_EYECON.get(), (RiderFormChangeItem) GhostRiderItems.BOOST_GHOST_EYECON.get())
                    .addAltWeapon(GhostRiderItems.GOEMON_GHOST_EYECON.get(), GhostRiderItems.SUNGLASSESLASHER.get())
                    .addAltForm(GhostRiderItems.RYOMA_GHOST_EYECON.get(), (RiderFormChangeItem) GhostRiderItems.BOOST_GHOST_EYECON.get())
                    .addAltWeapon(GhostRiderItems.RYOMA_GHOST_EYECON.get(), GhostRiderItems.SUNGLASSESLASHER.get())
                    .addAltForm(GhostRiderItems.HIMIKO_GHOST_EYECON.get(), (RiderFormChangeItem) GhostRiderItems.BOOST_GHOST_EYECON.get())
                    .addAltWeapon(GhostRiderItems.HIMIKO_GHOST_EYECON.get(), GhostRiderItems.SUNGLASSESLASHER.get())
                    .addAltForm(GhostRiderItems.DARWIN_GHOST_EYECON.get(), (RiderFormChangeItem) GhostRiderItems.BOOST_GHOST_EYECON.get())
                    .addAltWeapon(GhostRiderItems.DARWIN_GHOST_EYECON.get(), GhostRiderItems.SUNGLASSESLASHER.get())
                    .addAltWeapon(GhostRiderItems.RYUKI_GHOST_EYECON.get(), RyukiRiderItems.DRAG_SABER.get())
                    .addAltWeapon(GhostRiderItems.FAIZ_GHOST_EYECON.get(), FaizRiderItems.FAIZ_EDGE.get())
                    .addAltWeapon(GhostRiderItems.BLADE_GHOST_EYECON.get(), BladeRiderItems.BLAYROUZER.get())
                    .addAltWeapon(GhostRiderItems.HIBIKI_GHOST_EYECON.get(), HibikiRiderItems.ONGEKIBO_REKKA.get(), HibikiRiderItems.ONGEKIBO_REKKA.get())
                    .addAltWeapon(GhostRiderItems.KABUTO_GHOST_EYECON.get(), KabutoRiderItems.KABUTO_KUNAI.get())
                    .addAltWeapon(GhostRiderItems.DEN_O_GHOST_EYECON.get(), DenORiderItems.DEN_GASHER_SWORD.get())
                    .addAltWeapon(GhostRiderItems.DECADE_GHOST_EYECON.get(), DecadeRiderItems.RIDE_BOOKER.get())
                    .addAltWeapon(GhostRiderItems.OOO_GHOST_EYECON.get(), OOORiderItems.MEDAJALIBUR.get())
                    .addAltWeapon(GhostRiderItems.WIZARD_GHOST_EYECON.get(), WizardRiderItems.WIZARSWORDSGUN.get())
                    .addAltWeapon(GhostRiderItems.GAIM_GHOST_EYECON.get(), GaimRiderItems.DAIDAIMARU.get(), GaimRiderItems.MUSOU_SABER.get())
                    .addAltWeapon(GhostRiderItems.DRIVE_GHOST_EYECON.get(), DriveRiderItems.HANDLE_KEN.get(), DriveRiderItems.DOOR_JU.get())
                    .isGlowing().IsBeltGlowing().addAlternative(GHOST_RIDEWATCH_ZI_O.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_EX_AID_RIDEWATCH_R = ITEMS.register("decade_ex_aid_ridewatch_r",
            () -> new RiderFormChangeItem(new Item.Properties(), "_decade_ex_aid_r", "zi_o", "ziku_driver_zi_o_belt_decade_ex_aid",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().changeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

    public static final DeferredItem<Item> DECADE_EX_AID_RIDEWATCH_L = ITEMS.register("decade_ex_aid_ridewatch_l",
            () -> new RiderFormChangeItem(new Item.Properties(), "_decade_ex_aid_l", "zi_o", "ziku_driver_zi_o_belt_decade_ex_aid",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().addSwitchForm(DECADE_EX_AID_RIDEWATCH_R.get()).changeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

    public static final DeferredItem<Item> EX_AID_RIDEWATCH_GEIZ = ITEMS.register("ex_aid_ridewatch_geiz",
            () -> new RiderFormChangeItem(new Item.Properties(), "_ex_aid", "geiz", "ziku_driver_geiz_belt_ex_aid",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().model_has_different_name("ex_aid_ridewatch").has_basic_model());

    public static final DeferredItem<Item> EX_AID_RIDEWATCH = ITEMS.register("ex_aid_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_ex_aid", "zi_o", "ziku_driver_zi_o_belt_ex_aid",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) ExAidRiderItems.GAMER_DRIVER_EX_AID.get())
                    .setSummonForm((RiderFormChangeItem) ExAidRiderItems.MIGHTY_ACTION_X_GASHAT.get())
                    .addSummonWeapon(ExAidRiderItems.GASHACON_BREAKER.get())
                    .addAltForm(ExAidRiderItems.MIGHTY_ACTION_X_GASHAT.get(), (RiderFormChangeItem) ExAidRiderItems.MIGHTY_ACTION_X_GASHAT_LV_1.get())
                    .addAltWeapon(ExAidRiderItems.MIGHTY_ACTION_X_GASHAT.get(), Items.AIR)
                    .addAltWeapon(ExAidRiderItems.DRAGO_KNIGHT_HUNTER_Z_GASHAT.get(), Items.AIR)
                    .addAltForm(ExAidRiderItems.DRAGO_KNIGHT_HUNTER_Z_GASHA_TROPHY.get(), (RiderFormChangeItem) ExAidRiderItems.DRAGO_KNIGHT_HUNTER_Z_GASHAT.get())
                    .addAltForm(ExAidRiderItems.PROTO_DRAGO_KNIGHT_HUNTER_Z_GASHAT.get(), (RiderFormChangeItem) ExAidRiderItems.PROTO_DRAGO_KNIGHT_HUNTER_Z_GASHAT_FANG.get())
                    .addAltWeapon(ExAidRiderItems.MIGHTY_BROTHERS_XX_GASHAT.get(), ExAidRiderItems.GASHACON_KEY_SLASHER.get())
                    .addAltForm(ExAidRiderItems.MIGHTY_BROTHERS_XX_GASHAT.get(), (RiderFormChangeItem) ExAidRiderItems.MIGHTY_BROTHERS_XX_GASHAT.get())
                    .addAltForm(ExAidRiderItems.PERFECT_PUZZLE_GASHAT.get(), (RiderFormChangeItem) ExAidRiderItems.MIGHTY_BROTHERS_XX_GASHAT_L.get())
                    .addAltWeapon(ExAidRiderItems.PERFECT_PUZZLE_GASHAT.get(), ExAidRiderItems.GASHACON_KEY_SLASHER.get())
                    .addAltForm(ExAidRiderItems.KNOCK_OUT_FIGHTER_GASHAT.get(), (RiderFormChangeItem) ExAidRiderItems.MIGHTY_BROTHERS_XX_GASHAT_R.get())
                    .addAltWeapon(ExAidRiderItems.KNOCK_OUT_FIGHTER_GASHAT.get(), ExAidRiderItems.GASHACON_KEY_SLASHER.get())
                    .addAltWeapon(ExAidRiderItems.MAXIMUM_MIGHTY_X_GASHAT.get(), ExAidRiderItems.GASHACON_KEY_SLASHER.get())
                    .addAltForm(ExAidRiderItems.HYPER_MUTEKI_GASHAT.get(), (RiderFormChangeItem) ExAidRiderItems.HYPER_MUTEKI_GASHAT.get())
                    .addAltWeapon(ExAidRiderItems.HYPER_MUTEKI_GASHAT.get(), ExAidRiderItems.GASHACON_KEY_SLASHER.get())
                    .addAltWeapon(ExAidRiderItems.KAIGEN_GHOST_GASHAT.get(), GhostRiderItems.GAN_GUN_SABER_BLADE.get())
                    .addAltWeapon(ExAidRiderItems.FULL_THROTTLE_DRIVE_GASHAT.get(), DriveRiderItems.HANDLE_KEN.get())
                    .addAltWeapon(ExAidRiderItems.TOUKENDEN_GAIM_GASHAT.get(), GaimRiderItems.DAIDAIMARU.get())
                    .addAltWeapon(ExAidRiderItems.BERCODE_WARRIOR_DECADE_GASHAT.get(), DecadeRiderItems.RIDE_BOOKER.get())
                    .addAltWeapon(ExAidRiderItems.INSECT_WARS_KABUTO_GASHAT.get(), KabutoRiderItems.KABUTO_KUNAI.get())
                    .addAltWeapon(ExAidRiderItems.MIRROR_LABRYINTH_RYUKI_GASHAT.get(), RyukiRiderItems.DRAG_SABER.get())
                    .addIncompatibleForm(DECADE_RIDEWATCH.asItem()).addIncompatibleForm(DECADE_EX_AID_RIDEWATCH_L.asItem()).addIncompatibleForm(DECADE_EX_AID_RIDEWATCH_R.asItem())
                    .isGlowing().IsBeltGlowing().addAlternative(DECADE_EX_AID_RIDEWATCH_L.get()).addAlternative(EX_AID_RIDEWATCH_GEIZ.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_BUILD_RIDEWATCH = ITEMS.register("decade_build_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), "_decade_build", "zi_o", "ziku_driver_zi_o_belt_decade_build",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().changeBeltModel("geo/zi_o_decade_riderbelt.geo.json"));

    public static final DeferredItem<Item> BUILD_RIDEWATCH_GEIZ = ITEMS.register("build_ridewatch_geiz",
            () -> new RiderFormChangeItem(new Item.Properties(), "_build", "geiz", "ziku_driver_geiz_belt_build",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }
                    .addAlternative(DECADE_BUILD_RIDEWATCH.get())
                    .isGlowing().IsBeltGlowing().model_has_different_name("build_ridewatch").has_basic_model());

    public static final DeferredItem<Item> BUILD_RIDEWATCH = ITEMS.register("build_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_build", "zi_o", "ziku_driver_zi_o_belt_build",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) BuildRiderItems.BUILD_DRIVER.get()).addSummonWeapon(BuildRiderItems.DRILL_CRUSHER.get())
                    .addAltForm(BuildRiderItems.GORILLA_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.DIAMOND_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.DIAMOND_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.GORILLA_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.TAKA_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.GATLING_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.GATLING_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.TAKA_FULL_BOTTLE.get())
                    .addAltWeapon(BuildRiderItems.TAKA_FULL_BOTTLE.get(), BuildRiderItems.HAWK_GATLINGER.get())
                    .addAltWeapon(BuildRiderItems.GATLING_FULL_BOTTLE.get(), BuildRiderItems.HAWK_GATLINGER.get())
                    .addAltForm(BuildRiderItems.NINJA_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.COMIC_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.COMIC_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.NINJA_FULL_BOTTLE.get())
                    .addAltWeapon(BuildRiderItems.NINJA_FULL_BOTTLE.get(), BuildRiderItems.KOMA_NINPOUTOU.get())
                    .addAltWeapon(BuildRiderItems.COMIC_FULL_BOTTLE.get(), BuildRiderItems.KOMA_NINPOUTOU.get())
                    .addAltForm(BuildRiderItems.PANDA_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.ROCKET_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.ROCKET_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.PANDA_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.HARINEZUMI_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.SHOUBOUSHA_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.SHOUBOUSHA_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.HARINEZUMI_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.LION_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.SOUJIKI_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.SOUJIKI_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.LION_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.DRAGON_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.DRAGON_FULL_BOTTLE_BUILD.get(), (RiderFormChangeItem) BuildRiderItems.LOCK_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.LOCK_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.DRAGON_FULL_BOTTLE_BUILD.get())
                    .addAltForm(BuildRiderItems.KAIZOKU_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.DENSHA_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.DENSHA_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.KAIZOKU_FULL_BOTTLE.get())
                    .addAltWeapon(BuildRiderItems.KAIZOKU_FULL_BOTTLE.get(), BuildRiderItems.KAIZOKU_HASSYAR.get())
                    .addAltWeapon(BuildRiderItems.DENSHA_FULL_BOTTLE.get(), BuildRiderItems.KAIZOKU_HASSYAR.get())
                    .addAltForm(BuildRiderItems.OCTOPUS_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.LIGHT_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.LIGHT_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.OCTOPUS_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.PHOENIX_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.ROBOT_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.ROBOT_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.PHOENIX_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.WOLF_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.SMAPHO_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.SMAPHO_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.WOLF_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.UNICORN_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.KESHIGOMU_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.KESHIGOMU_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.UNICORN_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.ROSE_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.HELICOPTER_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.HELICOPTER_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.ROSE_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.TURTLE_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.WATCH_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.WATCH_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.TURTLE_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.KUMA_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.TELEVI_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.TELEVI_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.KUMA_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.KABUTOMUSHI_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.CAMERA_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.CAMERA_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.KABUTOMUSHI_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.SPIDER_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.REIZOUKO_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.REIZOUKO_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.SPIDER_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.DOG_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.MIC_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.MIC_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.DOG_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.SANTA_CLAUS_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.CAKE_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.CAKE_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.SANTA_CLAUS_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.TORA_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.UFO_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.UFO_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.TORA_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.KUJIRA_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.JET_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.JET_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.KUJIRA_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.SHIKA_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.PYRAMID_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.PYRAMID_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.SHIKA_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.KIRIN_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.SENPUUKI_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.SENPUUKI_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.KIRIN_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.PENGUIN_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.SKEBO_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.SKEBO_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.PENGUIN_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.SAME_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.BIKE_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.BIKE_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.SAME_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.HACHI_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.SENSUIKAN_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.SENSUIKAN_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.HACHI_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.SAI_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.DRYER_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.DRYER_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.SAI_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.BAT_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.ENGINE_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.ENGINE_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.BAT_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.OBAKE_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.MAGNET_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.MAGNET_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.OBAKE_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.SCORPION_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.GOLD_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.GOLD_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.SCORPION_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.LOW_RABBIT_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.FULLFULL_TANK_BOTTLE.get())
                    .addAltWeapon(BuildRiderItems.LOW_RABBIT_FULL_BOTTLE.get(), BuildRiderItems.FULLBOTTLE_BUSTER.get())
                    .addAltWeapon(BuildRiderItems.FULLFULL_RABBIT_TANK_BOTTLE.get(), BuildRiderItems.FULLBOTTLE_BUSTER.get())
                    .addAltWeapon(BuildRiderItems.GENIUS_FULL_BOTTLE.get(), BuildRiderItems.FULLBOTTLE_BUSTER.get())
                    .addAltWeapon(BuildRiderItems.CROSS_Z_BUILD_CAN.get(), BuildRiderItems.FULLBOTTLE_BUSTER.get())
                    .addAltForm(BuildRiderItems.GOLD_RABBIT_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.SILVER_DRAGON_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.SILVER_DRAGON_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.GOLD_RABBIT_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.MOMOTAROS_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.DENSHA_FULL_BOTTLE.get())
                    .addAltWeapon(BuildRiderItems.MOMOTAROS_FULL_BOTTLE.get(), DenORiderItems.DEN_GASHER_SWORD.get())
                    .addAltForm(BuildRiderItems.RIDER_CARD_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.CAMERA_FULL_BOTTLE.get())
                    .addAltWeapon(BuildRiderItems.RIDER_CARD_FULL_BOTTLE.get(), DecadeRiderItems.RIDE_BOOKER.get())
                    .addAltForm(BuildRiderItems.TANTEI_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.USB_MEMORY_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.USB_MEMORY_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.TANTEI_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.MEDAL_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.TAKA_FULL_BOTTLE.get())
                    .addAltWeapon(BuildRiderItems.MEDAL_FULL_BOTTLE.get(), OOORiderItems.MEDAJALIBUR.get(), OOORiderItems.MEDAGABURYU.get())
                    .addAltForm(BuildRiderItems.YUUJOU_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.ROCKET_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.MAHOUTSUKAI_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.DIAMOND_FULL_BOTTLE.get())
                    .addAltWeapon(BuildRiderItems.MAHOUTSUKAI_FULL_BOTTLE.get(), WizardRiderItems.WIZARSWORDSGUN.get())
                    .addAltForm(BuildRiderItems.ORANGE_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.LOCK_FULL_BOTTLE.get())
                    .addAltWeapon(BuildRiderItems.ORANGE_FULL_BOTTLE.get(), GaimRiderItems.DAIDAIMARU.get(), GaimRiderItems.MUSOU_SABER.get())
                    .addAltForm(BuildRiderItems.PARKA_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.OBAKE_FULL_BOTTLE.get())
                    .addAltWeapon(BuildRiderItems.PARKA_FULL_BOTTLE.get(), GhostRiderItems.GAN_GUN_SABER_BLADE.get())
                    .addAltForm(BuildRiderItems.DOCTOR_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.GAME_FULL_BOTTLE.get())
                    .addAltForm(BuildRiderItems.GAME_FULL_BOTTLE.get(), (RiderFormChangeItem) BuildRiderItems.DOCTOR_FULL_BOTTLE.get())
                    .addAltWeapon(BuildRiderItems.DOCTOR_FULL_BOTTLE.get(), ExAidRiderItems.GASHACON_BREAKER.get())
                    .addAltWeapon(BuildRiderItems.GAME_FULL_BOTTLE.get(), ExAidRiderItems.GASHACON_BREAKER.get())
                    .addIncompatibleForm(DECADE_RIDEWATCH.asItem()).addIncompatibleForm(DECADE_BUILD_RIDEWATCH.asItem())
                    .isGlowing().IsBeltGlowing().addAlternative(BUILD_RIDEWATCH_GEIZ.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZERO_ONE_RIDEWATCH = ITEMS.register("zero_one_ridewatch",
            () -> new ReiwaRidewatchItem(new Item.Properties(), "kamenridercraft:hiden_zero_one_driver")
                    .addSummonWeapon("kamenridercraft:attache_calibur")
                    .addAltWeapon("kamenridercraft:breaking_mammoth_progrisekey", "minecraft:air")
                    .addAltWeapon("kamenridercraft:shining_assault_hopper_progrisekey", "kamenridercraft:authorise_buster")
                    .addAltWeapon("kamenridercraft:metalcluster_hopper_progrisekey", "kamenridercraft:progrise_hopper_blade")
                    .addAltBelt("kamenridercraft:zero_two_progrisekey", "kamenridercraft:hiden_zero_two_driver")
                    .addAltWeapon("kamenridercraft:zero_two_progrisekey", "kamenridercraft:progrise_hopper_blade_naginata").addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SABER_RIDEWATCH = ITEMS.register("saber_ridewatch",
            () -> new SaberRidewatchItem(new Item.Properties(), "_decade_saber", "zi_o", "ziku_driver_zi_o_belt_decade_saber",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)
                    ,new MobEffectInstance(EffectCore.SLASH, 40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.addAltWeapon("kamenridercraft:king_of_arthur_wonder_ride_book", "kamenridercraft:kingexcalibur", "kamenridercraft:kaenken_rekka")
                    .addAltForm("kamenridercraft:storm_eagle_wonder_ride_book", "kamenridercraft:saiyuu_journey_wonder_ride_book")
                    .addAltForm("kamenridercraft:saiyuu_journey_wonder_ride_book", "kamenridercraft:storm_eagle_wonder_ride_book")
                    .addAltForm("kamenridercraft:elemental_dragon_wonder_ride_book", "kamenridercraft:elemental_dragon_wonder_ride_book")
                    .addAltForm("kamenridercraft:haouken_xross_saber", "kamenridercraft:brave_dragon_wonder_ride_book_xross")
                    .addAltWeapon("kamenridercraft:haouken_xross_saber", "kamenridercraft:haouken_xross_saber").isGlowing().IsBeltGlowing().changeBeltModel("geo/zi_o_decade_riderbelt.geo.json").addNeedItem(DECADE_RIDEWATCH.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

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
                    .addAltWeapon("kamenridercraft:kamakiri_vistamp", "kamenridercraft:kamakiric_arrow").addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> VICE_RIDEWATCH = ITEMS.register("vice_ridewatch",
            () -> new ReiwaRidewatchItem(new Item.Properties(), "kamenridercraft:vice_belt").addSummonWeapon("kamenridercraft:osutoderu_hammer_50")
                    .addAltWeapon("kamenridercraft:barid_rex_vistamp", "kamenridercraft:barid_shield")
                    .addAltWeapon("kamenridercraft:volcano_vistamp", "kamenridercraft:barid_shield")
                    .addAltWeapon("kamenridercraft:giffard_rex_vistamp", "kamenridercraft:revice_lasher")
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GEATS_RIDEWATCH = ITEMS.register("geats_ridewatch",
            () -> new ReiwaRidewatchItem(new Item.Properties(), "kamenridercraft:desire_driver_geats", "kamenridercraft:magnum_raise_buckle").addSummonWeapon("kamenridercraft:magnum_shooter_40x")
                    .addAltWeapon("kamenridercraft:geats_rider_core_id", "minecraft:air")
                    .addAltWeapon("kamenridercraft:boost_raise_buckle", "minecraft:air")
                    .addAltWeapon("kamenridercraft:ninja_raise_buckle", "kamenridercraft:ninja_dueler")
                    .addAltWeapon("kamenridercraft:beat_raise_buckle", "kamenridercraft:beat_axe")
                    .addAltWeapon("kamenridercraft:zombie_raise_buckle", "kamenridercraft:zombie_breaker")
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
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

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
                    .addAltForm("kamenridercraft:ganvhale_ride_chemy_card", "kamenridercraft:spicle_ride_chemy_card")
                    .addAltForm("kamenridercraft:renkingrobo_ride_chemy_card", "kamenridercraft:yamibat_ride_chemy_card")
                    .addAltForm("kamenridercraft:mitemirror_ride_chemy_card", "kamenridercraft:stagvine_ride_chemy_card")
                    .addAltForm("kamenridercraft:bussasorry_ride_chemy_card", "kamenridercraft:greatonbo_ride_chemy_card")
                    .addAltForm("kamenridercraft:panpakaparka_ride_chemy_card", "kamenridercraft:bountybunny_ride_chemy_card")
                    .addAltForm("kamenridercraft:tsupparihebi_ride_chemy_card", "kamenridercraft:doctorkozo_ride_chemy_card")
                    .addAltForm("kamenridercraft:televi_ride_chemy_card", "kamenridercraft:bakuonzemi_ride_chemy_card")
                    .addAltForm("kamenridercraft:daiohni_ride_chemy_card", "kamenridercraft:gekiocopter_ride_chemy_card_g")
                    .addAltForm("kamenridercraft:gekiocopter_ride_chemy_card", "kamenridercraft:gekiocopter_ride_chemy_card_g")
                    .addAltForm("kamenridercraft:unicon_ride_chemy_card", "kamenridercraft:the_sun_ride_chemy_card_g")
                    .addAltForm("kamenridercraft:the_sun_ride_chemy_card", "kamenridercraft:the_sun_ride_chemy_card_g")
                    .addAltForm("kamenridercraft:yoacerberus_ride_chemy_card", "kamenridercraft:neminemoon_ride_chemy_card_g")
                    .addAltForm("kamenridercraft:neminemoon_ride_chemy_card", "kamenridercraft:neminemoon_ride_chemy_card_g")
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
                    .addAltWeapon("kamenridercraft:tenliner_ride_chemy_card", "minecraft:air").addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

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
                    .addAltWeapon("kamenridercraft:partea_gochizo", "minecraft:air").addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZEZTZ_RIDEWATCH = ITEMS.register("zeztz_ridewatch",
            () -> new ReiwaRidewatchItem(new Item.Properties(), "kamenridercraft:zeztz_driver").addSummonWeapon("kamenridercraft:breakam_zeztzer_sword")
                    .addAltWeapon("kamenridercraft:stream_capsem", "kamenridercraft:breakam_zeztzer_gun")
                    .addAltWeapon("kamenridercraft:machinery_capsem", "kamenridercraft:breakam_zeztzer_gun")
                    .addAltWeapon("kamenridercraft:projection_capsem", "kamenridercraft:breakam_zeztzer_gun")
                    .addAltWeapon("kamenridercraft:recovery_capsem", "kamenridercraft:breakam_zeztzer_axe")
                    .addAltWeapon("kamenridercraft:barrier_capsem", "kamenridercraft:breakam_zeztzer_axe")
                    .addAltWeapon("kamenridercraft:wonder_capsem", "kamenridercraft:breakam_zeztzer_scythe")
                    .addAltWeapon("kamenridercraft:gravity_capsem", "kamenridercraft:breakam_zeztzer_scythe")
                    .addAltWeapon("kamenridercraft:plasma_capsem", "kamenridercraft:inazuma_blaster")
                    .addAltWeapon("kamenridercraft:booster_capsem", "kamenridercraft:inazuma_blaster_greatsword")
                    .addAltWeapon("kamenridercraft:dualmare_capsem", "kamenridercraft:triple_zeztzer")
                    .addAltBelt("kamenridercraft:exdreamrise_capsem", "kamenridercraft:zeztz_exdream_driver").addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> AMAZON_ALPHA_RIDEWATCH = ITEMS.register("amazon_alpha_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) AmazonsRiderItems.AMAZONS_DRIVER_ALPHA.get())
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));
    public static final DeferredItem<Item> AMAZON_OMEGA_RIDEWATCH = ITEMS.register("amazon_omega_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) AmazonsRiderItems.AMAZONS_DRIVER_OMEGA.get())
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));
    public static final DeferredItem<Item> AMAZON_NEO_RIDEWATCH = ITEMS.register("amazon_neo_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) AmazonsRiderItems.NEO_AMAZONS_DRIVER_NEO.get())
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GENM_RIDEWATCH = ITEMS.register("genm_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_genm", "geiz", "ziku_driver_geiz_belt_genm",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) ExAidRiderItems.GAMER_DRIVER_GENM.get())
                    .setSummonForm((RiderFormChangeItem) ExAidRiderItems.PROTO_MIGHTY_ACTION_X_GASHAT.get())
                    .addSummonWeapon(ExAidRiderItems.GASHACON_BUGVISOR.get())
                    .addAltWeapon(ExAidRiderItems.DRAGO_KNIGHT_HUNTER_Z_GASHAT.get(), Items.AIR)
                    .addAltWeapon(ExAidRiderItems.PROTO_DRAGO_KNIGHT_HUNTER_Z_GASHAT.get(), Items.AIR)
                    .addAltBelt(ExAidRiderItems.GASHACON_BUGVISOR.get(), (RiderDriverItem) ExAidRiderItems.GASHACON_BUGVISOR_GENM.get())
                    .addAltForm(ExAidRiderItems.GASHACON_BUGVISOR.get(), (RiderFormChangeItem) ExAidRiderItems.DANGEROUS_ZOBIE_GASHAT_BD.get())
                    .addAltWeapon(ExAidRiderItems.GASHACON_BUGVISOR.get(), Items.AIR)
                    .addAltBelt(ExAidRiderItems.THE_UNBEATABLE_GAME.get(), (RiderDriverItem) ExAidRiderItems.GASHACON_BUGVISOR_GENM.get())
                    .addAltWeapon(ExAidRiderItems.THE_UNBEATABLE_GAME.get(), Items.AIR)
                    .addAltWeapon(ExAidRiderItems.MAGIC_THE_WIZARD_GASHAT.get(), WizardRiderItems.WIZARSWORDSGUN.get())
                    .addAltWeapon(ExAidRiderItems.JUNGLE_OOO_GASHAT.get(), OOORiderItems.MEDAJALIBUR.get())
                    .addAltWeapon(ExAidRiderItems.BERCODE_WARRIOR_DECADE_GASHAT.get(), DecadeRiderItems.RIDE_BOOKER.get())
                    .addAltWeapon(ExAidRiderItems.TIME_EXPRESS_DEN_O_GASHAT.get(), DenORiderItems.DEN_GASHER_SWORD.get())
                    .addAltWeapon(ExAidRiderItems.TAIKO_MASTER_HIBIKI_GASHAT.get(), HibikiRiderItems.ONGEKIBO_REKKA.get(), HibikiRiderItems.ONGEKIBO_REKKA.get())
                    .addAltWeapon(ExAidRiderItems.KING_OF_POKER_BLADE_GASHAT.get(), BladeRiderItems.BLAYROUZER.get())
                    .addAltWeapon(ExAidRiderItems.MOSHI_MOSHI_FAIZ_GASHAT.get(), FaizRiderItems.FAIZ_EDGE.get())
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> WOZ_RIDEWATCH = ITEMS.register("woz_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), "_woz", "zi_o", "ziku_driver_zi_o_belt_woz",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false),
                    new MobEffectInstance(EffectCore.BOOST, 40, 0, true, false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BIBIRU_GEIZ_RIDEWATCH = ITEMS.register("bibiru_geiz_ridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), "_bibiru", "geiz", "ziku_driver_geiz_belt_bibiru",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_ULTIMATE_RIDEWATCH = ITEMS.register("kuuga_ultimate_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> AGITO_SHINING_RIDEWATCH = ITEMS.register("agito_shining_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> RYUKI_SURVIVE_RIDEWATCH = ITEMS.register("ryuki_survive_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> FAIZ_BLASTER_RIDEWATCH = ITEMS.register("faiz_blaster_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BLADE_KING_RIDEWATCH = ITEMS.register("blade_king_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> HIBIKI_ARMED_RIDEWATCH = ITEMS.register("hibiki_armed_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> KABUTO_HYPER_RIDEWATCH = ITEMS.register("kabuto_hyper_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_LINER_RIDEWATCH = ITEMS.register("den_o_liner_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> KIVA_EMPEROR_RIDEWATCH = ITEMS.register("kiva_emperor_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_COMPLETE_RIDEWATCH = ITEMS.register("decade_complete_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> W_XTREME_RIDEWATCH = ITEMS.register("w_xtreme_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> OOO_PUTOTYRA_RIDEWATCH = ITEMS.register("ooo_putotyra_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> FOURZE_COSMIC_RIDEWATCH = ITEMS.register("fourze_cosmic_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> WIZARD_INFINITY_RIDEWATCH = ITEMS.register("wizard_infinity_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GAIM_KIWAMI_RIDEWATCH = ITEMS.register("gaim_kiwami_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DRIVE_TRIDORON_RIDEWATCH = ITEMS.register("drive_tridoron_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GHOST_MUGEN_RIDEWATCH = ITEMS.register("ghost_mugen_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> EX_AID_MUTEKI_RIDEWATCH = ITEMS.register("ex_aid_muteki_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BUILD_GENIUS_RIDEWATCH = ITEMS.register("build_genius_ridewatch",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> RYUSOULGER_RIDEWATCH = ITEMS.register("ryusoulger_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ICHIGO_RIDEWATCH = ITEMS.register("ichigo_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) IchigoRiderItems.TYPHOON_ICHIGO.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> NIGO_RIDEWATCH = ITEMS.register("nigo_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) IchigoRiderItems.TYPHOON_NIGO.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> V3_RIDEWATCH = ITEMS.register("v3_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) V3RiderItems.DOUBLE_TYPHOON.get()).addAltWeapon(ModdedItemCore.FLARESALAMANDER.get(), ModdedItemCore.FLARESALAMANDER_SWORD.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> RIDERMAN_RIDEWATCH = ITEMS.register("riderman_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) V3RiderItems.RIDERMAN_BELT.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> X_RIDEWATCH = ITEMS.register("x_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) XRiderItems.RIDOL.get()).addSummonWeapon(XRiderItems.RIDOL_STICK.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> AMAZON_RIDEWATCH = ITEMS.register("amazon_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) AmazonRiderItems.CONDORER.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> STRONGER_RIDEWATCH = ITEMS.register("stronger_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) StrongerRiderItems.ELECTRER.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SKYRIDER_RIDEWATCH = ITEMS.register("skyrider_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) SkyriderItems.TORNADO.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SUPER_1_RIDEWATCH = ITEMS.register("super_1_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) Super1RiderItems.CYCLODE.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZX_RIDEWATCH = ITEMS.register("zx_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) ZXRiderItems.ZX_BELT.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BLACK_RIDEWATCH = ITEMS.register("black_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) BlackRiderItems.VITAL_CHARGER.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SHADOW_MOON_RIDEWATCH = ITEMS.register("shadow_moon_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) BlackRiderItems.SHADOW_CHARGER.get()).addSummonWeapon(BlackRiderItems.SATANSABER.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BLACK_RX_RIDEWATCH = ITEMS.register("black_rx_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) BlackRXRiderItems.SUN_RISER.get()).addSummonWeapon(BlackRXRiderItems.REVOLCANE.get()).addAltForm(BlackRXRiderItems.ROBO_CORE.get(), (RiderFormChangeItem) BlackRXRiderItems.RX_CORE.get()).addAltForm(BlackRXRiderItems.BIO_CORE.get(), (RiderFormChangeItem) BlackRXRiderItems.RX_CORE.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ROBO_RIDER_RIDEWATCH = ITEMS.register("robo_rider_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) BlackRXRiderItems.SUN_RISER.get()).setSummonForm((RiderFormChangeItem) BlackRXRiderItems.ROBO_CORE.get()).addSummonWeapon(BlackRXRiderItems.VORTECHSHOOTER.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BIO_RIDER_RIDEWATCH = ITEMS.register("bio_rider_ridewatch",
            () -> new RidewatchItem(new Item.Properties(), "_biorider", "barlckxs", "ziku_driver_barlckxs_belt_biorider",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(EffectCore.BIG, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 200, 0, 0, 0, 1);
                }
            }
                    .setSummonBelt((RiderDriverItem) BlackRXRiderItems.SUN_RISER.get()).setSummonForm((RiderFormChangeItem) BlackRXRiderItems.BIO_CORE.get()).addSummonWeapon(BlackRXRiderItems.BIOBLADE.get())
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SHIN_RIDEWATCH = ITEMS.register("shin_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) ShinRiderItems.GRASSHOPPER_DNA.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ZO_RIDEWATCH = ITEMS.register("zo_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) ZORiderItems.ZO_CORE.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> J_RIDEWATCH = ITEMS.register("j_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) JRiderItems.J_SPIRIT.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> KNIGHT_RIDEWATCH = ITEMS.register("knight_ridewatch",
            () -> ((MajestyRidewatchItem) new MajestyRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) RyukiRiderItems.KNIGHTDRIVER.get())
                    .addSummonWeapon(RyukiRiderItems.DARK_VISOR.get())
                    .addAltForm(RyukiRiderItems.RIDE_SABER_VENT.get(), (RiderFormChangeItem) RyukiRiderItems.ADVENT_CARD.get())
                    .addAltForm(RyukiRiderItems.DARK_VISOR_ZWEI_VENT.get(), (RiderFormChangeItem) RyukiRiderItems.SURVIVE_SHIPPU.get())
                    .addAltForm(RyukiRiderItems.DARK_BLADE_VENT.get(), (RiderFormChangeItem) RyukiRiderItems.SURVIVE_SHIPPU.get())
                    .addAltForm(RyukiRiderItems.DARK_ARROW_VENT.get(), (RiderFormChangeItem) RyukiRiderItems.SURVIVE_SHIPPU.get())
                    .addAltWeapon(RyukiRiderItems.RIDE_SABER_VENT.get(), RyukiRiderItems.RIDE_SABER.get())
                    .addAltWeapon(RyukiRiderItems.WING_LANCER_VENT.get(), RyukiRiderItems.WING_LANCER.get())
                    .addAltWeapon(RyukiRiderItems.SURVIVE_SHIPPU.get(), RyukiRiderItems.DARK_BLADE.get(), RyukiRiderItems.DARK_SHIELD.get())
                    .addAltWeapon(RyukiRiderItems.DARK_VISOR_ZWEI_VENT.get(), RyukiRiderItems.DARK_BLADE.get(), RyukiRiderItems.DARK_SHIELD.get())
                    .addAltWeapon(RyukiRiderItems.DARK_BLADE_VENT.get(), RyukiRiderItems.DARK_BLADE.get(), RyukiRiderItems.DARK_SHIELD.get())
                    .addAltWeapon(RyukiRiderItems.DARK_ARROW_VENT.get(), RyukiRiderItems.DARK_ARROW.get())
                    .addAltWeapon(ModdedItemCore.DARKWING.get(), ModdedItemCore.DARKWING_SWORD.get()))
                    .addMajestyWeapon(RyukiRiderItems.WING_LANCER.get())
                    .addAltMajestyWeapon(RyukiRiderItems.RIDE_SABER_VENT.get(), RyukiRiderItems.RIDE_SABER.get())
                    .addAltMajestyWeapon(RyukiRiderItems.SURVIVE_SHIPPU.get(), RyukiRiderItems.DARK_BLADE.get(), RyukiRiderItems.DARK_SHIELD.get())
                    .addAltMajestyWeapon(RyukiRiderItems.DARK_VISOR_ZWEI_VENT.get(), RyukiRiderItems.DARK_BLADE.get(), RyukiRiderItems.DARK_SHIELD.get())
                    .addAltMajestyWeapon(RyukiRiderItems.DARK_BLADE_VENT.get(), RyukiRiderItems.DARK_BLADE.get(), RyukiRiderItems.DARK_SHIELD.get())
                    .addAltMajestyWeapon(RyukiRiderItems.DARK_ARROW_VENT.get(), RyukiRiderItems.DARK_ARROW.get())
                    .addAltMajestyWeapon(ModdedItemCore.DARKWING.get(), ModdedItemCore.DARKWING_SWORD.get())
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> CHALICE_RIDEWATCH = ITEMS.register("chalice_ridewatch",
            () -> new OhmaRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) BladeRiderItems.CHALICEROUZER.get()).addSummonWeapon(BladeRiderItems.CHALICE_ARROW.get())
                    .addAltWeapon(BladeRiderItems.EVOLUTION_PARADOXA.get(), BladeRiderItems.WILD_SLASHER.get(), BladeRiderItems.WILD_SLASHER.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> DIEND_RIDEWATCH = ITEMS.register("diend_ridewatch",
            () -> ((MajestyRidewatchItem) new MajestyRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) DecadeRiderItems.DIEND_BELT.get())
                    .addSummonWeapon(DecadeRiderItems.DIENDRIVER.get())
                    .addAltForm(DecadeRiderItems.DECADE_CARD.get(), (RiderFormChangeItem) DecadeRiderItems.DIEND_GREEN_CARD.get()))
                    .addMajestyWeapon(DecadeRiderItems.DIENDRIVER.get())
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> BEAST_RIDEWATCH = ITEMS.register("beast_ridewatch",
            () -> ((MajestyRidewatchItem) new MajestyRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) WizardRiderItems.BEAST_DRIVER.get()).addSummonWeapon(WizardRiderItems.DICE_SABER.get())
                    .addAltWeapon(WizardRiderItems.HYPER_RING.get(), WizardRiderItems.MIRAGE_MAGNUM.get()))
                    .addMajestyWeapon(WizardRiderItems.DICE_SABER.get())
                    .addAltMajestyWeapon(WizardRiderItems.HYPER_RING.get(), WizardRiderItems.MIRAGE_MAGNUM.get())
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> MACH_RIDEWATCH = ITEMS.register("mach_ridewatch",
            () -> ((MajestyRidewatchItem) new MajestyRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) DriveRiderItems.MACH_DRIVER_HONOH.get()).addSummonWeapon(DriveRiderItems.ZENRIN_SHOOTER.get())
                    .addAltWeapon(DriveRiderItems.SHIFT_RUMBLE_DUMP.get(), DriveRiderItems.RUMBLE_SMASHER.get())
                    .addAltForm(DriveRiderItems.SHIFT_DEAD_HEAT.get(), (RiderFormChangeItem) DriveRiderItems.SHIFT_DEAD_HEAT_MACH.get())
                    .addAltForm(DriveRiderItems.SHIFT_MAD_DOCTOR.get(), (RiderFormChangeItem) DriveRiderItems.SHIFT_DEAD_HEAT_MACH.get())
                    .addAltWeapon(DriveRiderItems.SIGNAL_CHASER.get(), DriveRiderItems.SHINGOU_AX.get()))
                    .addMajestyWeapon(DriveRiderItems.ZENRIN_SHOOTER.get())
                    .addAltMajestyWeapon(DriveRiderItems.SHIFT_RUMBLE_DUMP.get(), DriveRiderItems.RUMBLE_SMASHER.get())
                    .addAltMajestyWeapon(DriveRiderItems.SIGNAL_CHASER.get(), DriveRiderItems.SHINGOU_AX.get())
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> CROSS_Z_RIDEWATCH = ITEMS.register("cross_z_ridewatch",
            () -> ((MajestyRidewatchItem) new MajestyRidewatchItem(new Item.Properties()).setSummonBelt((RiderDriverItem) BuildRiderItems.BUILD_DRIVER_CROSS_Z.get()).addSummonWeapon(BuildRiderItems.BEAT_CROSSER.get())
                    .addAltBelt(BuildRiderItems.DRAGON_SCLASH_JELLY.get(), (RiderDriverItem) BuildRiderItems.SCLASH_DRIVER.get())
                    .addAltWeapon(BuildRiderItems.DRAGON_SCLASH_JELLY.get(), BuildRiderItems.TWIN_BREAKER.get())
                    .addAltBelt(BuildRiderItems.TAKA_FULL_BOTTLE.get(), (RiderDriverItem) BuildRiderItems.SCLASH_DRIVER.get())
                    .addAltWeapon(BuildRiderItems.TAKA_FULL_BOTTLE.get(), BuildRiderItems.TWIN_BREAKER.get())
                    .addAltWeapon(BuildRiderItems.DRAGON_MAGMA_FULL_BOTTLE.get(), BuildRiderItems.MAGMA_KNUCKLE.get()))
                    .addMajestyWeapon(BuildRiderItems.BEAT_CROSSER.get())
                    .addAltMajestyWeapon(BuildRiderItems.DRAGON_SCLASH_JELLY.get(), BuildRiderItems.TWIN_BREAKER.get())
                    .addAltMajestyWeapon(BuildRiderItems.TAKA_FULL_BOTTLE.get(), BuildRiderItems.TWIN_BREAKER.get())
                    .addAltMajestyWeapon(BuildRiderItems.DRAGON_MAGMA_FULL_BOTTLE.get(), BuildRiderItems.MAGMA_KNUCKLE.get())
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SHINOBI_MIRIDEWATCH = ITEMS.register("shinobi_miridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), "_shinobi", "woz", "beyondriver_belt",
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> QUIZ_MIRIDEWATCH = ITEMS.register("quiz_miridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), "_quiz", "woz", "beyondriver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> KIKAI_MIRIDEWATCH = ITEMS.register("kikai_miridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), "_kikai", "woz", "beyondriver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GINGA_FINALY_MIRIDEWATCH = ITEMS.register("ginga_finaly_miridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), "_ginga_finaly", "woz", "beyondriver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().model_has_different_name("ginga_miridewatch").has_basic_model());

    public static final DeferredItem<Item> GINGA_TAIYO_MIRIDEWATCH = ITEMS.register("ginga_taiyo_miridewatch",
            () -> new RiderFormChangeItem(new Item.Properties(), "_ginga_taiyo", "woz", "beyondriver_belt",
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.addNeedForm(GINGA_FINALY_MIRIDEWATCH.get(), 1).addAlternative(GINGA_FINALY_MIRIDEWATCH.get())
                    .isGlowing().IsBeltGlowing().model_has_different_name("ginga_miridewatch").has_basic_model());

    public static final DeferredItem<Item> GINGA_MIRIDEWATCH = ITEMS.register("ginga_miridewatch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), "_ginga_wakusei", "woz", "beyondriver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().addNeedForm(GINGA_TAIYO_MIRIDEWATCH.get(), 1).addAlternative(GINGA_TAIYO_MIRIDEWATCH.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> CHRISTMAS_RIDEWATCH = ITEMS.register("christmas_ridewatch",
            () -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> UNFINISHED_GRAND_ZI_O_RIDEWATCH_L = ITEMS.register("unfinished_grand_zi_o_ridewatch_l",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> UNFINISHED_GRAND_ZI_O_RIDEWATCH_R = ITEMS.register("unfinished_grand_zi_o_ridewatch_r",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> UNFINISHED_GEIZ_MAJESTY_RIDEWATCH_L = ITEMS.register("unfinished_geiz_majesty_ridewatch_l",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> UNFINISHED_GEIZ_MAJESTY_RIDEWATCH_R = ITEMS.register("unfinished_geiz_majesty_ridewatch_r",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> UNFINISHED_OHMA_ZI_O_DRIVER_L = ITEMS.register("unfinished_ohma_zi_o_driver_l",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE), "", "ohma_zi_o", "ohma_zi_o_driver_belt",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 6, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 6, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 6, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.REGENERATION, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 6, true, false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.SATURATION, 40, 0, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().hasStaticWings().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> UNFINISHED_OHMA_ZI_O_DRIVER_R = ITEMS.register("unfinished_ohma_zi_o_driver_r",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_KUUGA_WATCH = ITEMS.register("another_kuuga_watch",
            () -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_AGITO_WATCH = ITEMS.register("another_agito_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "another_agito_zio", "another_altering_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeModel("another_agito.geo.json").hasCape().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_RYUKI_WATCH = ITEMS.register("another_ryuki_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "another_ryuki", "another_v_buckle_belt_ryuki",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_RYUGA_WATCH = ITEMS.register("another_ryuga_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "another_ryuga", "another_v_buckle_belt_ryuga",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_FAIZ_WATCH = ITEMS.register("another_faiz_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "another_faiz", "another_faiz_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_BLADE_WATCH = ITEMS.register("another_blade_watch",
            () -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_HIBIKI_WATCH = ITEMS.register("another_hibiki_watch",
            () -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_KABUTO_WATCH = ITEMS.register("another_kabuto_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "another_kabuto", "another_rider_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_DEN_O_WATCH = ITEMS.register("another_den_o_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "another_den_o", "another_den_o_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_KIVA_WATCH = ITEMS.register("another_kiva_watch",
            () -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_DECADE_WATCH = ITEMS.register("another_decade_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "another_decade", "another_decadriver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_DIEND_WATCH = ITEMS.register("another_diend_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "another_diend", "another_diendriver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_W_WATCH = ITEMS.register("another_w_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "another_w", "another_w_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 0, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_OOO_WATCH = ITEMS.register("another_ooo_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "another_ooo", "another_ooo_driver_belt",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_FOURZE_WATCH = ITEMS.register("another_fourze_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "another_fourze", "another_fourze_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_WIZARD_WATCH = ITEMS.register("another_wizard_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "another_wizard", "another_wizard_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_GAIM_WATCH = ITEMS.register("another_gaim_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "another_gaim", "another_gaim_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_DRIVE_WATCH = ITEMS.register("another_drive_watch",
            () -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_GHOST_WATCH = ITEMS.register("another_ghost_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "another_ghost", "another_ghost_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
                    new MobEffectInstance(EffectCore.GHOST, 40, 0, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_EX_AID_WATCH = ITEMS.register("another_ex_aid_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "another_ex_aid", "another_ex_aid_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.FALLING_SPORE_BLOSSOM,
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_BUILD_WATCH = ITEMS.register("another_build_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "another_build", "another_build_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 0, true, false))
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_ZI_O_WATCH = ITEMS.register("another_zi_o_watch",
            () -> new Zi_ORidewatchItem(new Item.Properties(), "", "another_zi_o", "another_ziku_driver_zi_o_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_ZI_O_II_WATCH = ITEMS.register("another_zi_o_ii_watch",
            () -> new Zi_ORidewatchItem(new Item.Properties(), "_ii", "another_zi_o", "another_ziku_driver_zi_o_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_ZERO_ONE_WATCH = ITEMS.register("another_zero_one_watch",
            () -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_ICHIGO_WATCH = ITEMS.register("another_ichigo_watch",
            () -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_SHINOBI_WATCH = ITEMS.register("another_shinobi_watch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "another_shinobi", "another_shinobi_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_QUIZ_WATCH = ITEMS.register("another_quiz_watch",
            () -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> ANOTHER_KIKAI_WATCH = ITEMS.register("another_kikai_watch",
            () -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SHURIKEN_STARTER = ITEMS.register("shuriken_starter",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "shinobi", "shinobi_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SHURIKEN_STARTER_HATTARI = ITEMS.register("shuriken_starter_hattari",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "hattari", "hattari_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SHURIKEN_STARTER_YAMININ = ITEMS.register("shuriken_starter_yaminin",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "yaminin", "yaminin_belt_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));


    public static final DeferredItem<Item> QUIZ_TOPPER = ITEMS.register("quiz_topper",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "quiz", "quiz_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> SPANNERDER_SCREWDER = ITEMS.register("spannerder_screwder",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "kikai", "kikai_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> GINGA_SCOPE = ITEMS.register("ginga_scope",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "ginga", "ginga_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> RIDESTRIKER_RIDEWATCH = ITEMS.register("ridestriker_ridewatch",
            () -> new SummonBikeItem(new Item.Properties(), MobsCore.RIDESTRIKER)
                    .has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));


    public static final DeferredItem<Item> WOZ_TIME_MAJIN_RIDEWATCH = ITEMS.register("woz_time_majin_ridewatch",
            () -> new BaseCityItem(new Item.Properties().rarity(Rarity.UNCOMMON), 10).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).has_basic_model());

    public static final DeferredItem<Item> OHMA_ADVENT_CALENDAR = ITEMS.register("ohma_advent_calendar",
            () -> new OhmaAdventCalendarItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));


    public static final DeferredItem<Item> ZI_O_HELMET = ITEMS.register("zi_o_head",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZI_O_CHESTPLATE = ITEMS.register("zi_o_troso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZI_O_LEGGINGS = ITEMS.register("zi_o_legs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));


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
            }.hasInventoryGui().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).AddToTabList(DecadeRiderItems.NEO_DIEND_SUMMON_BELTS).ChangeRepairItem(BLANK_RIDEWATCH.get()));

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
            }.hasInventoryGui().hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

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
            }.hasInventoryGui().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).AddToTabList(DecadeRiderItems.NEO_DIEND_SUMMON_BELTS).ChangeRepairItem(BLANK_RIDEWATCH.get()));

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
            }.hasInventoryGui().hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

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
            }.hasInventoryGui().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

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
            }.hasInventoryGui().hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

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
            }.hasInventoryGui().hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

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
            }.hasInventoryGui().hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

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
            }.hasInventoryGui().hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> SHINOBIDRIVER = ITEMS.register("shinobi_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "shinobi", SHURIKEN_STARTER, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> HATTARIDRIVER = ITEMS.register("hattari_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "hattari", SHURIKEN_STARTER_HATTARI, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> YAMININ_BELT = ITEMS.register("yaminin_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "yaminin", SHURIKEN_STARTER_YAMININ, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().has_basic_model().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> QUIZDRIVER = ITEMS.register("quiz_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "quiz", QUIZ_TOPPER, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> KIKAIDRIVER = ITEMS.register("kikai_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "kikai", SPANNERDER_SCREWDER, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> GINGADRIVER = ITEMS.register("ginga_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "ginga", GINGA_SCOPE, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_ALTERING = ITEMS.register("another_altering",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_agito_zio", ANOTHER_AGITO_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_V_BUCKLE_RYUKI = ITEMS.register("another_v_buckle_ryuki",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_ryuki", ANOTHER_RYUKI_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_V_BUCKLE_RYUGA = ITEMS.register("another_v_buckle_ryuga",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_ryuga", ANOTHER_RYUGA_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_FAIZ_DRIVER = ITEMS.register("another_faiz_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_faiz", ANOTHER_FAIZ_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_RIDER_BELT = ITEMS.register("another_rider_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_kabuto", ANOTHER_KABUTO_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_DEN_O_BELT = ITEMS.register("another_den_o_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_den_o", ANOTHER_DEN_O_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_DECADRIVER = ITEMS.register("another_decadriver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_decade", ANOTHER_DECADE_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_DIENDRIVER = ITEMS.register("another_diendriver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_diend", ANOTHER_DIEND_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_W_DRIVER = ITEMS.register("another_w_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_w", ANOTHER_W_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_OOO_DRIVER = ITEMS.register("another_ooo_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_ooo", ANOTHER_OOO_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_FOURZE_DRIVER = ITEMS.register("another_fourze_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_fourze", ANOTHER_FOURZE_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_WIZARD_DRIVER = ITEMS.register("another_wizard_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_wizard", ANOTHER_WIZARD_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_GAIM_DRIVER = ITEMS.register("another_gaim_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_gaim", ANOTHER_GAIM_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_GHOST_DRIVER = ITEMS.register("another_ghost_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_ghost", ANOTHER_GHOST_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_EX_AID_DRIVER = ITEMS.register("another_ex_aid_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_ex_aid", ANOTHER_EX_AID_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_BUILD_DRIVER = ITEMS.register("another_build_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_build", ANOTHER_BUILD_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_ZIKU_DRIVER_ZI_O = ITEMS.register("another_ziku_driver_zi_o",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_zi_o", ANOTHER_ZI_O_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).has_basic_model().ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_SHINOBI_DRIVER = ITEMS.register("another_shinobi_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "another_shinobi", ANOTHER_SHINOBI_WATCH, ZI_O_HELMET, ZI_O_CHESTPLATE, ZI_O_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));


    public static final DeferredItem<Item> ZIKAN_GIRADE = ITEMS.register("zikan_girade",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).addToList(DecadeRiderItems.NEO_DIEND_SUMMON_WEAPONS).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZIKAN_ZAX = ITEMS.register("zikan_zax",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).addToList(DecadeRiderItems.NEO_DIEND_SUMMON_WEAPONS).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> DRILL_CRUSHER_CRUSHER = ITEMS.register("drill_crusher_crusher",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> FAIZPHONE_X = ITEMS.register("faiz_phone_x",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> RIDE_HEISABER = ITEMS.register("ride_heisaber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> SAIKYO_GIRADE = ITEMS.register("saikyo_girade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> SAIKYO_ZIKAN_GIRADE = ITEMS.register("saikyo_zikan_girade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).addToList(DecadeRiderItems.COMPLETE_21_WEAPONS).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZIKAN_DESPEAR = ITEMS.register("zikan_despear",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZIKAN_DESPEAR_KAMA = ITEMS.register("zikan_despear_kama",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZIKAN_DESPEAR_TSUE = ITEMS.register("zikan_despear_tsue",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZIKAN_JACLAW = ITEMS.register("zikan_jaclaw",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).IsChangeSword().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ZAMONAS_BOW = ITEMS.register("zamonas_bow",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> BARLCKXS_SWORD = ITEMS.register("barlckxs_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_DRAG_SABER = ITEMS.register("another_drag_saber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> ANOTHER_DRAG_SABER_RYUGA = ITEMS.register("another_drag_saber_ryuga",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> KASSHINE_TRIDENT = ITEMS.register("kasshine_trident",
            () -> new BaseSwordItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM)
                    .ChangeRepairItem(BLANK_RIDEWATCH.get()));

    public static final DeferredItem<Item> TAKA_RIDEWATCH = ITEMS.register("taka_ridewatch",
            () -> new RideGadgetItem(new Item.Properties(),Component.translatable("ridegadget.kamenridercraft.taka"), MobsCore.TAKA_WATCHROID).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).has_basic_model());

    public static final DeferredItem<Item> KODAMA_RIDEWATCH = ITEMS.register("kodama_ridewatch",
            () -> new RideGadgetItem(new Item.Properties(),Component.translatable("ridegadget.kamenridercraft.kodama"), MobsCore.KODAMA_SUIKA_ARMS).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).has_basic_model());

    public static final DeferredItem<Item> QUESTIOABLE_WATCH = ITEMS.register("questionable_watch",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<Item> TOY_ROBOT = ITEMS.register("toy_robot",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM));

    public static final DeferredItem<BaseThrowableItem> MANHOLE_COVER = ITEMS.register("manhole_cover",
            () -> new BaseThrowableItem(Tiers.DIAMOND, 4, -4.4F, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZI_O_TAB_ITEM).ChangeRepairItem(Items.IRON_INGOT));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
