package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.kabuto.ClockUpPadItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;

import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Kabuto_Rider_Items {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

    public static final DeferredItem<Item> KABUTO_LOGO = ITEMS.register("kabuto_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/kabuto")), new Item.Properties()).AddToList(RiderTabs.KABUTO_TAB_ITEM));

    public static final DeferredItem<Item> MINI_ZECTER = ITEMS.register("mini_zecter",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.KABUTO_TAB_ITEM));

    public static final DeferredItem<Item> UNFINISHED_KABUTICK_ZECTER = ITEMS.register("unfinished_kabutick_zecter",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.KABUTO_TAB_ITEM));
    public static final DeferredItem<Item> PERFECT_THEBEE_ZECTER = ITEMS.register("perfectthebee_zecter",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.KABUTO_TAB_ITEM));
    public static final DeferredItem<Item> PERFECT_DRAKE_ZECTER = ITEMS.register("perfectdrake_zecter",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.KABUTO_TAB_ITEM));
    public static final DeferredItem<Item> PERFECT_SASWORD_ZECTER = ITEMS.register("perfectsasword_zecter",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.KABUTO_TAB_ITEM));

    public static final DeferredItem<Item> KABUTO_ZECTER_MASK = ITEMS.register("kabuto_zecter_mask",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_masked","kabuto","kabuto_rider_belt_m",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                }
            }.IsGlowing());

    public static final DeferredItem<Item> KABUTO_ZECTER = ITEMS.register("kabuto_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","kabuto","kabuto_rider_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().addSwitchForm(KABUTO_ZECTER_MASK.get()).AddToList(RiderTabs.KABUTO_TAB_ITEM));

    public static final DeferredItem<Item> THEBEE_ZECTER_MASK = ITEMS.register("thebee_zecter_mask",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_masked","thebee","zect_buckle_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                }
            });

    public static final DeferredItem<Item> THEBEE_ZECTER = ITEMS.register("thebee_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","thebee","zect_buckle_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().addSwitchForm(THEBEE_ZECTER_MASK.get()).AddToList(RiderTabs.KABUTO_TAB_ITEM));

    public static final DeferredItem<Item> DRAKE_ZECTER_MASK = ITEMS.register("drake_zecter_mask",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_masked","drake","zect_buckle_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                }
            }.IsGlowing());

    public static final DeferredItem<Item> DRAKE_ZECTER = ITEMS.register("drake_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","drake","zect_buckle_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().addSwitchForm(DRAKE_ZECTER_MASK.get()).AddToList(RiderTabs.KABUTO_TAB_ITEM));

    public static final DeferredItem<Item> SASWORD_ZECTER_MASK = ITEMS.register("sasword_zecter_mask",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_masked","sasword","zect_buckle_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                }
            }.IsGlowing());

    public static final DeferredItem<Item> SASWORD_ZECTER = ITEMS.register("sasword_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","sasword","zect_buckle_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().addSwitchForm(SASWORD_ZECTER_MASK.get()).AddToList(RiderTabs.KABUTO_TAB_ITEM));

    public static final DeferredItem<Item> GATACK_ZECTER_MASK = ITEMS.register("gatack_zecter_mask",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_masked","gatack","gatack_rider_belt_m",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                }
            }.IsGlowing());

    public static final DeferredItem<Item> GATACK_ZECTER = ITEMS.register("gatack_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","gatack","gatack_rider_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().addSwitchForm(GATACK_ZECTER_MASK.get()).AddToList(RiderTabs.KABUTO_TAB_ITEM));

    public static final DeferredItem<Item> GATACK_HYPER_ZECTER = ITEMS.register("gatack_hyper_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),1,"_hyper","gatack","gatack_rider_belt",
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 7,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 30, 0, 0, 0, 1);
                }
            }.IsGlowing());

    public static final DeferredItem<Item> KICKHOPPER_ZECTER = ITEMS.register("kickhopper_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","kickhopper","kickhopper_zect_buckle_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 7,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.KABUTO_TAB_ITEM));

    public static final DeferredItem<Item> PUNCHHOPPER_ZECTER = ITEMS.register("punchhopper_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","punchhopper","punchhopper_zect_buckle_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.KABUTO_TAB_ITEM));

    public static final DeferredItem<Item> DARK_KABUTO_ZECTER_MASK = ITEMS.register("dark_kabuto_zecter_mask",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_masked","dark_kabuto","dark_kabuto_rider_belt_m",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                }
            }.IsGlowing());

    public static final DeferredItem<Item> DARK_KABUTO_ZECTER = ITEMS.register("dark_kabuto_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","dark_kabuto","dark_kabuto_rider_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().addSwitchForm(DARK_KABUTO_ZECTER_MASK.get()).AddToList(RiderTabs.KABUTO_TAB_ITEM));

    public static final DeferredItem<Item> DARK_HYPER_ZECTER = ITEMS.register("dark_hyper_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_hyper","dark_kabuto","dark_kabuto_rider_belt",
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 7,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().addAlternative(GATACK_HYPER_ZECTER.get()));

    public static final DeferredItem<Item> CAUCASUS_ZECTER_MASK = ITEMS.register("caucasus_zecter_mask",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_masked","caucasus","zect_buckle_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                }
            }.IsGlowing());

    public static final DeferredItem<Item> CAUCASUS_ZECTER = ITEMS.register("caucasus_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","caucasus","zect_buckle_belt",
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 7,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().addSwitchForm(CAUCASUS_ZECTER_MASK.get()).AddToList(RiderTabs.KABUTO_TAB_ITEM));

    public static final DeferredItem<Item> HERCUS_ZECTER_MASK = ITEMS.register("hercus_zecter_mask",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_masked","hercus","zect_buckle_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                }
            }.IsGlowing());

    public static final DeferredItem<Item> HERCUS_ZECTER = ITEMS.register("hercus_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","hercus","zect_buckle_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().addSwitchForm(HERCUS_ZECTER_MASK.get()).AddToList(RiderTabs.KABUTO_TAB_ITEM));

    public static final DeferredItem<Item> KETAROS_ZECTER_MASK = ITEMS.register("ketaros_zecter_mask",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_masked","ketaros","zect_buckle_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                }
            }.IsGlowing());

    public static final DeferredItem<Item> KETAROS_ZECTER = ITEMS.register("ketaros_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","ketaros","zect_buckle_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().addSwitchForm(KETAROS_ZECTER_MASK.get()).AddToList(RiderTabs.KABUTO_TAB_ITEM));

    public static final DeferredItem<Item> LADY_ZECTER = ITEMS.register("lady_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","lady","zect_buckle_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.KABUTO_TAB_ITEM));

    public static final DeferredItem<Item> HYPER_ZECTER = ITEMS.register("hyper_zecter",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),1,"_hyper","kabuto","kabuto_rider_belt",
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 7,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().addAlternative(DARK_HYPER_ZECTER.get()).AddToList(RiderTabs.KABUTO_TAB_ITEM));

    public static final DeferredItem<Item> GATACK_HYPER_ZECTER_CLOCK_UP = ITEMS.register("gatack_hyper_zecter_clock_up",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_hyper_clock_up","gatack","gatack_rider_belt",
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 7,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 30, 0, 0, 0, 1);
                }
            }.IsGlowing().has_basic_model().model_has_different_name("hyper_zecter"));


    public static final DeferredItem<Item> HYPER_ZECTER_CLOCK_UP = ITEMS.register("hyper_zecter_clock_up",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_hyper_clock_up","kabuto","kabuto_rider_belt",
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 30,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RANDOM_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 500, 0, 0, 0, 1);
                }
            }.IsGlowing().allowRiderKick().hasTimeout(400, 1200, (RiderFormChangeItem)HYPER_ZECTER.get()).addAlternative(GATACK_HYPER_ZECTER_CLOCK_UP.asItem()).has_basic_model().model_has_different_name("hyper_zecter"));


    public static final DeferredItem<Item> ZECTROOPER_ZECTER = ITEMS.register("zectrooper_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","zectrooper","zectrooper_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)));

    public static final DeferredItem<Item> BRIGHTROOPER_ZECTER = ITEMS.register("brightrooper_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","brightrooper","brightrooper_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)));

    public static final DeferredItem<Item> NEOTROOPER_ZECTER = ITEMS.register("neotrooper_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","neotrooper","neotrooper_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)));

    public static final DeferredItem<Item> CHOPHOPPER_ZECTER = ITEMS.register("chophopper_zecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","chophopper","chophopper_zect_buckle_belt",
                    new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
                    .has_basic_model().model_has_different_name("kickhopper_zecter"));


    public static final DeferredItem<Item> KABUTOHELMET = ITEMS.register("kabutohead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> KABUTOCHESTPLATE = ITEMS.register("kabutotroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> KABUTOLEGGINGS = ITEMS.register("kabutolegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));


    public static final DeferredItem<Item> KABUTO_RIDER_BELT = ITEMS.register("kabuto_rider_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kabuto",KABUTO_ZECTER_MASK ,KABUTOHELMET,KABUTOCHESTPLATE,KABUTOLEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> GATACK_RIDER_BELT = ITEMS.register("gatack_rider_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"gatack",GATACK_ZECTER_MASK ,KABUTOHELMET,KABUTOCHESTPLATE,KABUTOLEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> THEBEE_RIDER_BELT = ITEMS.register("thebee_rider_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"thebee",THEBEE_ZECTER_MASK ,KABUTOHELMET,KABUTOCHESTPLATE,KABUTOLEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> DRAKE_RIDER_BELT = ITEMS.register("drake_rider_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"drake",DRAKE_ZECTER_MASK ,KABUTOHELMET,KABUTOCHESTPLATE,KABUTOLEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> SASWORD_RIDER_BELT = ITEMS.register("sasword_rider_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"sasword",SASWORD_ZECTER_MASK ,KABUTOHELMET,KABUTOCHESTPLATE,KABUTOLEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> KICKHOPPER_RIDER_BELT = ITEMS.register("kickhopper_rider_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kickhopper",KICKHOPPER_ZECTER ,KABUTOHELMET,KABUTOCHESTPLATE,KABUTOLEGGINGS, new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> PUNCHHOPPER_RIDER_BELT = ITEMS.register("puchhopper_rider_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"punchhopper",PUNCHHOPPER_ZECTER ,KABUTOHELMET,KABUTOCHESTPLATE,KABUTOLEGGINGS, new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> DARK_KABUTO_RIDER_BELT = ITEMS.register("dark_kabuto_rider_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_kabuto",DARK_KABUTO_ZECTER_MASK ,KABUTOHELMET,KABUTOCHESTPLATE,KABUTOLEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> CAUCASUS_RIDER_BELT = ITEMS.register("caucasus_rider_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"caucasus",CAUCASUS_ZECTER ,KABUTOHELMET,KABUTOCHESTPLATE,KABUTOLEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> HERCUS_RIDER_BELT = ITEMS.register("hercus_rider_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"hercus",HERCUS_ZECTER ,KABUTOHELMET,KABUTOCHESTPLATE,KABUTOLEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> KETAROS_RIDER_BELT = ITEMS.register("ketaros_rider_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ketaros",KETAROS_ZECTER ,KABUTOHELMET,KABUTOCHESTPLATE,KABUTOLEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> LADY_RIDER_BELT = ITEMS.register("lady_rider_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"lady",LADY_ZECTER ,KABUTOHELMET,KABUTOCHESTPLATE,KABUTOLEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> ZECTROOPER_BELT = ITEMS.register("zectrooper_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zectrooper",ZECTROOPER_ZECTER ,KABUTOHELMET,KABUTOCHESTPLATE,KABUTOLEGGINGS, new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> SHADOW_TROOPER_BELT = ITEMS.register("shadow_trooper_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shadow_trooper",ZECTROOPER_ZECTER ,KABUTOHELMET,KABUTOCHESTPLATE,KABUTOLEGGINGS, new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> BRIGHTROOPER_BELT = ITEMS.register("brightrooper_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"brightrooper",BRIGHTROOPER_ZECTER ,KABUTOHELMET,KABUTOCHESTPLATE,KABUTOLEGGINGS, new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> NEOTROOPER_BELT = ITEMS.register("neotrooper_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"neotrooper",NEOTROOPER_ZECTER ,KABUTOHELMET,KABUTOCHESTPLATE,KABUTOLEGGINGS, new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> CHOPHOPPER_RIDER_BELT = ITEMS.register("chophopper_rider_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"chophopper",CHOPHOPPER_ZECTER ,KABUTOHELMET,KABUTOCHESTPLATE,KABUTOLEGGINGS, new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.KABUTO_TAB_ITEM).ChangeRepairItem(MINI_ZECTER.get()).has_basic_model());

    public static final DeferredItem<Item> CLOCK_UP_PAD = ITEMS.register("clock_up_pad",
            () -> new ClockUpPadItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(KamenRiderCraftCore.CLOCK_UP_ITEM).AddToList(RiderTabs.KABUTO_TAB_ITEM));

    public static final DeferredItem<Item> KABUTO_KUNAI = ITEMS.register("kabuto_kunai",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.KABUTO_TAB_ITEM)
                    .ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> KABUTO_KUNAI_KUNAI = ITEMS.register("kabuto_kunai_kunai",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToList(RiderTabs.KABUTO_TAB_ITEM)
                    .ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> ZECT_MIZER = ITEMS.register("zect_mizer",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.SMALL_FIREBALL).AddToTabList(RiderTabs.KABUTO_TAB_ITEM)
                    .ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> PERFECT_ZECTER = ITEMS.register("perfect_zecter",
            () -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.KABUTO_TAB_ITEM)
                    .ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> DRAKE_GLIP = ITEMS.register("drake_grip",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.KABUTO_TAB_ITEM)
                    .IsHenshinItem(DRAKE_RIDER_BELT.get()).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> SASWORD_YAIVER = ITEMS.register("sasword_yaiver",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToList(RiderTabs.KABUTO_TAB_ITEM)
                    .IsHenshinItem(SASWORD_RIDER_BELT.get()).ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> GATACK_DOUBLE_CALIBUR = ITEMS.register("gatack_double_calibur",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToList(RiderTabs.KABUTO_TAB_ITEM)
                    .ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> GATACK_DOUBLE_CALIBUR_MINUS = ITEMS.register("gatack_double_calibur_minus",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToList(RiderTabs.KABUTO_TAB_ITEM)
                    .ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> GATACK_DOUBLE_CALIBUR_TWIN = ITEMS.register("gatack_double_calibur_twin",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToList(RiderTabs.KABUTO_TAB_ITEM)
                    .ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> ZECT_KUNAI = ITEMS.register("zect_kunai",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.KABUTO_TAB_ITEM)
                    .ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> ZECT_KUNAI_KUNAI = ITEMS.register("zect_kunai_kunai",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToList(RiderTabs.KABUTO_TAB_ITEM)
                    .ChangeRepairItem(MINI_ZECTER.get()));
    public static final DeferredItem<Item> MACHINEGUN_BLADE = ITEMS.register("machinegun_blade",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 6, -3F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.KABUTO_TAB_ITEM)
                    .ChangeRepairItem(MINI_ZECTER.get()));

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}

}