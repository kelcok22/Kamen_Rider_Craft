package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.footSoldiers.ShockerCombatmanEntity;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;

import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;


public class Ichigo_Rider_Items {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item> KAMEN_RIDER_LOGO = ITEMS.register("kamen_rider_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/ichigo")), new Item.Properties()).AddToList(RiderTabs.ICHIGO_TAB_ITEM));



    public static final DeferredItem<Item> TYPHOON_CORE = ITEMS.register("typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","ichigo","typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }

                public void OnRiderKickHit(ItemStack itemstack, LivingEntity pLivingEntity, LivingEntity enemy) {
                    if (enemy.isDeadOrDying() && enemy instanceof ShockerCombatmanEntity && !pLivingEntity.level().isClientSide())
                        enemy.spawnAtLocation(new ItemStack(Modded_item_core.LETS_GO_RIDER_MUSIC_DISC.get()));
                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_CORE_NIGO = ITEMS.register("typhoon_core_nigo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","nigo","typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> ORIGINAL_TYPHOON_CORE_NIGO = ITEMS.register("original_typhoon_core_nigo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_original","nigo","typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing());

    public static final DeferredItem<Item> ORIGINAL_TYPHOON_CORE = ITEMS.register("original_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_original","ichigo","typhoon_belt_original",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }

                public void OnRiderKickHit(ItemStack itemstack, LivingEntity pLivingEntity, LivingEntity enemy) {
                    if (enemy.isDeadOrDying() && enemy instanceof ShockerCombatmanEntity && !pLivingEntity.level().isClientSide())
                        enemy.spawnAtLocation(new ItemStack(Modded_item_core.LETS_GO_RIDER_MUSIC_DISC.get()));
                }
            }.allowRiderKick().IsGlowing().addAlternative(ORIGINAL_TYPHOON_CORE_NIGO.get()).AddToList(RiderTabs.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> SAKURAJIMA_TYPHOON_CORE = ITEMS.register("sakurajima_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_sakurajima","ichigo","typhoon_belt_original",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }

                public void OnRiderKickHit(ItemStack itemstack, LivingEntity pLivingEntity, LivingEntity enemy) {
                    if (enemy.isDeadOrDying() && enemy instanceof ShockerCombatmanEntity && !pLivingEntity.level().isClientSide())
                        enemy.spawnAtLocation(new ItemStack(Modded_item_core.LETS_GO_RIDER_MUSIC_DISC.get()));
                }}.allowRiderKick().IsGlowing().AddToList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_CORE_SANGO = ITEMS.register("typhoon_core_sango",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","sango","typhoon_belt_sango",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> RIDER3_VS_THE_DEMON_OF_GENERAL_BLACK = ITEMS.register("rider3_vs_the_demon_of_general_black",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_manga","sango","typhoon_belt_original",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_CORE_YONGO = ITEMS.register("typhoon_core_yongo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","yongo","typhoon_belt_yongo",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> NEW_TYPHOON_CORE = ITEMS.register("new_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_new","ichigo","new_typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 150, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 150, 0, 0, 0, 1);
                }

                public void OnRiderKickHit(ItemStack itemstack, LivingEntity pLivingEntity, LivingEntity enemy) {
                    if (enemy.isDeadOrDying() && enemy instanceof ShockerCombatmanEntity && !pLivingEntity.level().isClientSide())
                        enemy.spawnAtLocation(new ItemStack(Modded_item_core.LETS_GO_RIDER_MUSIC_DISC.get()));
                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TAKI_VAMPIRE_CORE = ITEMS.register("taki_vampire_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","taki_rider","taki_rider_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
                    .allowRiderKick().has_basic_model().AddToList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> GAIA_CORE = ITEMS.register("gaia_core",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"","gaia","gaia_belt_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().IsBeltGlowing().has_basic_model().AddToList(RiderTabs.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> SHOCKER_RIDER_TYPHOON_CORE = ITEMS.register("shocker_rider_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","shocker_rider","typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> NOPHOON_CORE = ITEMS.register("nophoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","kamen_norider","nophoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)).SetShowFace().AddToList(RiderTabs.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> ICHIGOHELMET = ITEMS.register("ichigohead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)).AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));
    public static final DeferredItem<Item> ICHIGOCHESTPLATE = ITEMS.register("ichigotroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)).AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));
    public static final DeferredItem<Item> ICHIGOLEGGINGS = ITEMS.register("ichigolegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)).AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_ICHIGO = ITEMS.register("typhoon_ichigo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ichigo",TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).IsA1().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_NIGO = ITEMS.register("typhoon_nigo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"nigo",TYPHOON_CORE,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).IsA1().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_SANGO = ITEMS.register("typhoon_sango",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"sango",TYPHOON_CORE_SANGO,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_YONGO = ITEMS.register("typhoon_yongo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"yongo",TYPHOON_CORE_YONGO,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_1 = ITEMS.register("typhoon_shocker_rider_1",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_1",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_2 = ITEMS.register("typhoon_shocker_rider_2",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_2",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_3 = ITEMS.register("typhoon_shocker_rider_3",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_3",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_4 = ITEMS.register("typhoon_shocker_rider_4",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_4",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_5 = ITEMS.register("typhoon_shocker_rider_5",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_5",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_6 = ITEMS.register("typhoon_shocker_rider_6",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_6",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_7 = ITEMS.register("typhoon_shocker_rider_7",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_7",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_8 = ITEMS.register("typhoon_shocker_rider_8",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_8",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_9 = ITEMS.register("typhoon_shocker_rider_9",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_9",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_10 = ITEMS.register("typhoon_shocker_rider_10",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_10",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_11 = ITEMS.register("typhoon_shocker_rider_11",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_11",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_12 = ITEMS.register("typhoon_shocker_rider_12",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_12",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> NOPHOON_KAMEN_NORIDER = ITEMS.register("nophoon_kamen_norider",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kamen_norider",NOPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_DARK_ICHIGO = ITEMS.register("typhoon_dark_ichigo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_ichigo",TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info()
                    .Override_belt_text("dark_typhoon_belt").AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_DARK_NIGO = ITEMS.register("typhoon_dark_nigo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_nigo",TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info()
                    .Override_belt_text("dark_typhoon_belt").AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_FAKE_ICHIGO = ITEMS.register("typhoon_fake_ichigo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"fake_ichigo",TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties())
                    .Dont_show_belt_form_info().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TAKI_BELT = ITEMS.register("taki_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"taki_rider",TAKI_VAMPIRE_CORE,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().has_basic_model().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> GAIA_BELT = ITEMS.register("gaia_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"gaia",GAIA_CORE,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON)).has_basic_model().AddToTabList(RiderTabs.ICHIGO_TAB_ITEM));

    //V3

    public static final DeferredItem<Item> V3_LOGO = ITEMS.register("v3_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/v3")), new Item.Properties()).AddToList(RiderTabs.V3_TAB_ITEM));
    public static final DeferredItem<Item> RIDERMAN_LOGO = ITEMS.register("riderman_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/riderman")), new Item.Properties()).AddToList(RiderTabs.V3_TAB_ITEM));

    public static final DeferredItem<Item> DOUBLE_TYPHOON_CORE = ITEMS.register("double_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","v3","double_typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.V3_TAB_ITEM));

    public static final DeferredItem<Item> BLUE_DOUBLE_TYPHOON_CORE = ITEMS.register("blue_double_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_blue","v3","double_typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT,player.level());
                    thunder.setVisualOnly(true);
                    thunder.setPos( player.getX(),  -1 + player.getY(),  player.getZ() );
                    player.level().addFreshEntity(thunder);

                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.V3_TAB_ITEM));

    public static final DeferredItem<Item> RIDERMAN_BELT_CORE = ITEMS.register("riderman_belt_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","riderman","riderman_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().SetShowFace().AddToList(RiderTabs.V3_TAB_ITEM));

    public static final DeferredItem<Item> V3HELMET = ITEMS.register("v3head",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.V3_TAB_ITEM));
    public static final DeferredItem<Item> V3CHESTPLATE = ITEMS.register("v3troso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.V3_TAB_ITEM));
    public static final DeferredItem<Item> V3LEGGINGS = ITEMS.register("v3legs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.V3_TAB_ITEM));

    public static final DeferredItem<Item> DOUBLE_TYPHOON = ITEMS.register("double_typhoon",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"v3",DOUBLE_TYPHOON_CORE ,V3HELMET,V3CHESTPLATE,V3LEGGINGS , new Item.Properties()).IsA1().AddToTabList(RiderTabs.V3_TAB_ITEM));

    public static final DeferredItem<Item> RIDERMAN_BELT = ITEMS.register("riderman_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"riderman",RIDERMAN_BELT_CORE ,V3HELMET,V3CHESTPLATE,V3LEGGINGS , new Item.Properties()).IsA1()
                    .Override_belt_text("riderman_belt").AddToTabList(RiderTabs.V3_TAB_ITEM));

    public static final DeferredItem<Item> DARK_DOUBLE_TYPHOON = ITEMS.register("dark_double_typhoon",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_v3",DOUBLE_TYPHOON_CORE ,V3HELMET,V3CHESTPLATE,V3LEGGINGS , new Item.Properties()).Dont_show_belt_form_info()
                    .Override_belt_text("dark_double_typhoon_belt").AddToTabList(RiderTabs.V3_TAB_ITEM));

    public static final DeferredItem<Item> DARK_RIDERMAN_BELT = ITEMS.register("dark_riderman_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_riderman",RIDERMAN_BELT_CORE ,V3HELMET,V3CHESTPLATE,V3LEGGINGS , new Item.Properties()).Dont_show_belt_form_info()
                    .Override_belt_text("dark_riderman_belt").AddToTabList(RiderTabs.V3_TAB_ITEM));

    public static final DeferredItem<Item> FAKE_DOUBLE_TYPHOON = ITEMS.register("fake_double_typhoon",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"fake_v3",DOUBLE_TYPHOON_CORE ,V3HELMET,V3CHESTPLATE,V3LEGGINGS , new Item.Properties()).IsA1().AddToTabList(RiderTabs.V3_TAB_ITEM).has_basic_model());


    //X
    public static final DeferredItem<Item> X_LOGO = ITEMS.register("x_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/x")), new Item.Properties()).AddToList(RiderTabs.X_TAB_ITEM));

    public static final DeferredItem<Item> RIDOL_CORE = ITEMS.register("ridol_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","x","ridol_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.X_TAB_ITEM));

    public static final DeferredItem<Item> PREFECTER = ITEMS.register("perfecter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_perfector","riderman","tackle_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().SetShowUnder().AddCompatibilityList(new String[] {"tackle"}).AddToList(RiderTabs.X_TAB_ITEM));

    public static final DeferredItem<Item> XHELMET = ITEMS.register("xhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.X_TAB_ITEM));
    public static final DeferredItem<Item> XCHESTPLATE = ITEMS.register("xtroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.X_TAB_ITEM));
    public static final DeferredItem<Item> XLEGGINGS = ITEMS.register("xlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.X_TAB_ITEM));

    public static final DeferredItem<Item> RIDOL = ITEMS.register("ridol",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"x",RIDOL_CORE ,XHELMET,XCHESTPLATE,XLEGGINGS , new Item.Properties()).IsA1().Dont_show_belt_form_info().AddToTabList(RiderTabs.X_TAB_ITEM));

    public static final DeferredItem<Item> DARK_RIDOL = ITEMS.register("dark_ridol",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_x",RIDOL_CORE ,XHELMET,XCHESTPLATE,XLEGGINGS , new Item.Properties()).Dont_show_belt_form_info()
                    .Override_belt_text("dark_ridol_belt").AddToTabList(RiderTabs.X_TAB_ITEM));

    public static final DeferredItem<Item> FAKE_RIDOL = ITEMS.register("fake_ridol",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"fake_x",RIDOL_CORE ,XHELMET,XCHESTPLATE,XLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.X_TAB_ITEM));

    public static final DeferredItem<Item> RIDOL_STICK = ITEMS.register("ridol_stick",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.X_TAB_ITEM));


    //Amazon

    public static final DeferredItem<Item> AMAZON_LOGO = ITEMS.register("amazon_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/amazon")), new Item.Properties()).AddToList(RiderTabs.AMAZON_TAB_ITEM));


    public static final DeferredItem<Item> CONDORER_WHEEL = ITEMS.register("condorer_wheel",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","amazon","condorer_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.REGENERATION,200, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.AMAZON_TAB_ITEM));

    public static final DeferredItem<Item> GIGI_ARMLET = ITEMS.register("gigi_armlet",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.AMAZON_TAB_ITEM));

    public static final DeferredItem<Item> GAGA_ARMLET = ITEMS.register("gaga_armlet",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.AMAZON_TAB_ITEM));

    public static final DeferredItem<Item> AMAZONHELMET = ITEMS.register("amazonhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.AMAZON_TAB_ITEM));
    public static final DeferredItem<Item> AMAZONCHESTPLATE = ITEMS.register("amazontroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.AMAZON_TAB_ITEM));
    public static final DeferredItem<Item> AMAZONLEGGINGS = ITEMS.register("amazonlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.AMAZON_TAB_ITEM));

    public static final DeferredItem<Item> CONDORER = ITEMS.register("condorer",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"amazon",CONDORER_WHEEL ,AMAZONHELMET,AMAZONCHESTPLATE,AMAZONLEGGINGS , new Item.Properties()).IsA1().AddToTabList(RiderTabs.AMAZON_TAB_ITEM));

    public static final DeferredItem<Item> DARK_CONDORER = ITEMS.register("dark_condorer",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_amazon",CONDORER_WHEEL ,AMAZONHELMET,AMAZONCHESTPLATE,AMAZONLEGGINGS , new Item.Properties()).Dont_show_belt_form_info()
                    .Override_belt_text("dark_condorer_belt").AddToTabList(RiderTabs.AMAZON_TAB_ITEM));


    //Stronger
    public static final DeferredItem<Item> STRONGER_LOGO = ITEMS.register("stronger_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/stronger")), new Item.Properties()).AddToList(RiderTabs.STRONGER_TAB_ITEM));


    public static final DeferredItem<Item> ELECTRER_CORE = ITEMS.register("electrer_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","stronger","electrer_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.FIREWORK,
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.STRONGER_TAB_ITEM));

    public static final DeferredItem<Item> CHARGE_UP = ITEMS.register("charge_up",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_charge_up","stronger","electrer_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
                    ,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT,player.level());
                    thunder.setVisualOnly(true);
                    thunder.setPos( player.getX(),  -1 + player.getY(),  player.getZ() );
                    player.level().addFreshEntity(thunder);

                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.FIREWORK,
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.STRONGER_TAB_ITEM));

    public static final DeferredItem<Item> TACKLE_CORE = ITEMS.register("tackle_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","tackle","tackle_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
                    .IsGlowing().SetShowUnder().AddToList(RiderTabs.STRONGER_TAB_ITEM));



    public static final DeferredItem<Item> STRONGERHELMET = ITEMS.register("strongerhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.STRONGER_TAB_ITEM));
    public static final DeferredItem<Item> STRONGERCHESTPLATE = ITEMS.register("strongertroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.STRONGER_TAB_ITEM));
    public static final DeferredItem<Item> STRONGERLEGGINGS = ITEMS.register("strongerlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.STRONGER_TAB_ITEM));

    public static final DeferredItem<Item> ELECTRER = ITEMS.register("electrer",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"stronger",ELECTRER_CORE ,STRONGERHELMET,STRONGERCHESTPLATE,STRONGERLEGGINGS , new Item.Properties()).IsA1().AddToTabList(RiderTabs.STRONGER_TAB_ITEM));

    public static final DeferredItem<Item> DARK_ELECTRER = ITEMS.register("dark_electrer",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_stronger",ELECTRER_CORE ,STRONGERHELMET,STRONGERCHESTPLATE,STRONGERLEGGINGS , new Item.Properties()).Dont_show_belt_form_info()
                    .Override_belt_text("dark_electrer_belt").AddToTabList(RiderTabs.STRONGER_TAB_ITEM));

    public static final DeferredItem<Item> TACKLE_BELT = ITEMS.register("tackle_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"tackle",TACKLE_CORE ,STRONGERHELMET,STRONGERCHESTPLATE,STRONGERLEGGINGS , new Item.Properties())
                    .AddToTabList(RiderTabs.STRONGER_TAB_ITEM));

    public static final DeferredItem<Item> BLACK_TACKLE_BELT = ITEMS.register("black_tackle_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"black_tackle",TACKLE_CORE ,STRONGERHELMET,STRONGERCHESTPLATE,STRONGERLEGGINGS , new Item.Properties())
                    .Override_belt_text("black_tackle_belt").Dont_show_belt_form_info().has_basic_model().AddToTabList(RiderTabs.STRONGER_TAB_ITEM));

    //Skyrider
    public static final DeferredItem<Item> SKYRIDER_LOGO = ITEMS.register("skyrider_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/skyrider")), new Item.Properties()).AddToList(RiderTabs.SKYRIDER_TAB_ITEM));

    public static final DeferredItem<Item> TORNADO_CORE = ITEMS.register("tornado_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","skyrider","tornado_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false)
                    ,new MobEffectInstance(Effect_core.FLYING, 40, 4,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 34, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 34, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 34, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.SKYRIDER_TAB_ITEM));

    public static final DeferredItem<Item> ORIGINAL_TORNADO_CORE = ITEMS.register("original_tornado_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_original","skyrider","tornado_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false)
                    ,new MobEffectInstance(Effect_core.FLYING, 40, 4,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 34, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 34, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 34, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.SKYRIDER_TAB_ITEM).has_basic_model());

    public static final DeferredItem<Item> GG_CORE = ITEMS.register("gg_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","gangan_g","gangan_g_belt_belt")
                    .has_basic_model().AddToList(RiderTabs.SKYRIDER_TAB_ITEM));

    public static final DeferredItem<Item>  SKYRIDERHELMET = ITEMS.register("skyriderhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.SKYRIDER_TAB_ITEM));
    public static final DeferredItem<Item>  SKYRIDERCHESTPLATE = ITEMS.register("skyridertroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.SKYRIDER_TAB_ITEM));
    public static final DeferredItem<Item>  SKYRIDERLEGGINGS = ITEMS.register("skyriderlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.SKYRIDER_TAB_ITEM));

    public static final DeferredItem<Item>  TORNADO = ITEMS.register("tornado",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"skyrider",TORNADO_CORE ,SKYRIDERHELMET,SKYRIDERCHESTPLATE,SKYRIDERLEGGINGS , new Item.Properties()).IsA1().AddToTabList(RiderTabs.SKYRIDER_TAB_ITEM));

    public static final DeferredItem<Item>  GANGAN_G_BELT = ITEMS.register("gangan_g_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"gangan_g",GG_CORE ,SKYRIDERHELMET,SKYRIDERCHESTPLATE,SKYRIDERLEGGINGS , new Item.Properties()).IsA1().Dont_show_belt_form_info().has_basic_model().AddToTabList(RiderTabs.SKYRIDER_TAB_ITEM));

    public static final DeferredItem<Item>  FAKE_TORNADO = ITEMS.register("fake_tornado",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"fake_skyrider",TORNADO_CORE ,SKYRIDERHELMET,SKYRIDERCHESTPLATE,SKYRIDERLEGGINGS , new Item.Properties()).IsA1().Dont_show_belt_form_info().AddToTabList(RiderTabs.SKYRIDER_TAB_ITEM).has_basic_model());


    //Super 1
    public static final DeferredItem<Item>  SUPER_1_LOGO = ITEMS.register("super_1_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/super_1")), new Item.Properties()).AddToList(RiderTabs.SUPER1_TAB_ITEM));


    public static final DeferredItem<Item>  CYCLODE_CORE = ITEMS.register("cyclode_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","super_1","cyclode_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.SUPER1_TAB_ITEM));

    public static final DeferredItem<Item>  SUPER1HELMET = ITEMS.register("super_1head",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.SUPER1_TAB_ITEM));
    public static final DeferredItem<Item>  SUPER1CHESTPLATE = ITEMS.register("super_1troso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.SUPER1_TAB_ITEM));
    public static final DeferredItem<Item>  SUPER1LEGGINGS = ITEMS.register("super_1legs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.SUPER1_TAB_ITEM));

    public static final DeferredItem<Item>  CYCLODE = ITEMS.register("cyclode",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"super_1",CYCLODE_CORE ,SUPER1HELMET,SUPER1CHESTPLATE,SUPER1LEGGINGS , new Item.Properties()).IsA1().Dont_show_belt_form_info().AddToTabList(RiderTabs.SUPER1_TAB_ITEM));

    public static final DeferredItem<Item>  ROBOT_CYCLODE = ITEMS.register("robot_cyclode",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"robot_super_1",CYCLODE_CORE ,SUPER1HELMET,SUPER1CHESTPLATE,SUPER1LEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.SUPER1_TAB_ITEM));

    //ZX
    public static final DeferredItem<Item>  ZX_LOGO = ITEMS.register("zx_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/zx")), new Item.Properties()).AddToList(RiderTabs.ZX_TAB_ITEM));


    public static final DeferredItem<Item>  ZX_BELT_CORE = ITEMS.register("zx_belt_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","zx","zx_belt_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.ZX_TAB_ITEM));

    public static final DeferredItem<Item>  ZXHELMET = ITEMS.register("zxhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.ZX_TAB_ITEM));
    public static final DeferredItem<Item>  ZXCHESTPLATE = ITEMS.register("zxtroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.ZX_TAB_ITEM));
    public static final DeferredItem<Item>  ZXLEGGINGS = ITEMS.register("zxlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZX_TAB_ITEM));


    public static final DeferredItem<Item>  ZX_BELT = ITEMS.register("zx_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zx",ZX_BELT_CORE ,ZXHELMET,ZXCHESTPLATE,ZXLEGGINGS , new Item.Properties()).IsA1().Dont_show_belt_form_info().AddToTabList(RiderTabs.ZX_TAB_ITEM));

    public static final DeferredItem<Item>  SUSANOO_BELT = ITEMS.register("susanoo_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"susanoo_zx",ZX_BELT_CORE ,ZXHELMET,ZXCHESTPLATE,ZXLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZX_TAB_ITEM));

    public static final DeferredItem<Item>  TSUKUYOMI_BELT = ITEMS.register("tsukuyomi_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"tsukuyomi_zx",ZX_BELT_CORE ,ZXHELMET,ZXCHESTPLATE,ZXLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZX_TAB_ITEM));

    public static final DeferredItem<Item>  AMATERASU_BELT = ITEMS.register("amaterasu_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"amaterasu_zx",ZX_BELT_CORE ,ZXHELMET,ZXCHESTPLATE,ZXLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZX_TAB_ITEM));

    //Black

    public static final DeferredItem<Item>  BLACK_LOGO = ITEMS.register("black_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/black")), new Item.Properties()).AddToList(RiderTabs.BLACK_TAB_ITEM));


    public static final DeferredItem<Item>  RED_KING_STONE = ITEMS.register("red_king_stone",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","black","vital_charger_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.BLACK_TAB_ITEM));


    public static final DeferredItem<Item>  BATTA_MAN_KING_STONE = ITEMS.register("batta_man_king_stone",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_batta_man","black","vital_charger_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.BLACK_TAB_ITEM));


    public static final DeferredItem<Item>  GREEN_KING_STONE = ITEMS.register("green_king_stone",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","shadow_moon","shadow_charger_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.BLACK_TAB_ITEM));

    public static final DeferredItem<Item>  CREATION_KING_STONE = ITEMS.register("creation_king_stone",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_red","shadow_moon","shadow_charger_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.BLACK_TAB_ITEM));

    public static final DeferredItem<Item>  ANOTHER_KING_STONE = ITEMS.register("another_king_stone",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_another","shadow_moon","shadow_charger_another_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().ChangeAnimation("default_cape.animation.json").has_basic_model().AddToList(RiderTabs.BLACK_TAB_ITEM));

    public static final DeferredItem<Item>  GREEN_KING_STONE_HAJIME_SORAYAMA = ITEMS.register("green_king_stone_hajime_sorayama",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_hajime_sorayama","shadow_moon","shadow_charger_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.BLACK_TAB_ITEM));


    public static final DeferredItem<Item>  BLACKHELMET = ITEMS.register("blackhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.BLACK_TAB_ITEM));
    public static final DeferredItem<Item>  BLACKCHESTPLATE = ITEMS.register("blacktorso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.BLACK_TAB_ITEM));
    public static final DeferredItem<Item>  BLACKLEGGINGS = ITEMS.register("blacklegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BLACK_TAB_ITEM));

    public static final DeferredItem<Item>  VITAL_CHARGER = ITEMS.register("vital_charger",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"black",RED_KING_STONE ,BLACKHELMET,BLACKCHESTPLATE,BLACKLEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.BLACK_TAB_ITEM));

    public static final DeferredItem<Item> SHADOW_CHARGER = ITEMS.register("shadow_charger",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shadow_moon",GREEN_KING_STONE ,BLACKHELMET,BLACKCHESTPLATE,BLACKLEGGINGS , new Item.Properties()).IsA1().AddToTabList(RiderTabs.BLACK_TAB_ITEM));

    public static final DeferredItem<Item> SATANSABER = ITEMS.register("satansaber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BLACK_TAB_ITEM));


    //Black RX
    public static final DeferredItem<Item>  BLACK_RX_LOGO = ITEMS.register("black_rx_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/black_rx")), new Item.Properties()).AddToList(RiderTabs.RX_TAB_ITEM));

    public static final DeferredItem<Item>  SPLIT_KING_STONE = ITEMS.register("split_king_stone",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.RX_TAB_ITEM));

    public static final DeferredItem<Item>  RX_CORE = ITEMS.register("rx_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","black_rx","sun_riser_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().IsA1().AddToList(RiderTabs.RX_TAB_ITEM));

    public static final DeferredItem<Item>  ROBO_CORE = ITEMS.register("robo_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_robo","black_rx","sun_riser_belt_robo",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().IsA1().AddToList(RiderTabs.RX_TAB_ITEM));

    public static final DeferredItem<Item>  BIO_CORE = ITEMS.register("bio_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_bio","black_rx","sun_riser_belt_bio",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.WATER_BREATHING,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 1,true,false)
                    ,new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().IsA1().AddToList(RiderTabs.RX_TAB_ITEM));

    public static final DeferredItem<Item>  MOON_RX_CORE = ITEMS.register("moon_rx_core",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","white_rx","moon_riser",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.RX_TAB_ITEM));


    public static final DeferredItem<Item> RXHELMET = ITEMS.register("rxhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.RX_TAB_ITEM));
    public static final DeferredItem<Item>  RXCHESTPLATE = ITEMS.register("rxtroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.RX_TAB_ITEM));
    public static final DeferredItem<Item>  RXLEGGINGS = ITEMS.register("rxlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.RX_TAB_ITEM));

    public static final DeferredItem<Item>  SUN_RISER = ITEMS.register("sun_riser",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"black_rx",RX_CORE ,RXHELMET,RXCHESTPLATE,RXLEGGINGS , new Item.Properties(){
            }).IsA1().AddToTabList(RiderTabs.RX_TAB_ITEM));

    public static final DeferredItem<Item>  MOON_RISER = ITEMS.register("moon_riser",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"white_rx",MOON_RX_CORE ,RXHELMET,RXCHESTPLATE,RXLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.RX_TAB_ITEM));


    public static final DeferredItem<Item>REVOLCANE = ITEMS.register("revolcane",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RX_TAB_ITEM));

    public static final DeferredItem<Item> VORTECHSHOOTER = ITEMS.register("vortech_shooter",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RX_TAB_ITEM));

    public static final DeferredItem<Item> BIOBLADE = ITEMS.register("bio_blade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RX_TAB_ITEM));

    public static final DeferredItem<Item> SHADOWSABER = ITEMS.register("shadow_saber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.RX_TAB_ITEM));

    // Shin

    public static final DeferredItem<Item>  SHIN_LOGO = ITEMS.register("shin_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/shin")), new Item.Properties()).AddToList(RiderTabs.SHIN_TAB_ITEM));

    public static final DeferredItem<Item>  SHIN_STONE = ITEMS.register("shin_stone",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","shin","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.SHIN_TAB_ITEM).KeepItem());


    public static final DeferredItem<Item>  SHINHELMET = ITEMS.register("shinhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.SHIN_TAB_ITEM));
    public static final DeferredItem<Item>  SHINCHESTPLATE = ITEMS.register("shintroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.SHIN_TAB_ITEM));
    public static final DeferredItem<Item>  SHINLEGGINGS = ITEMS.register("shinlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.SHIN_TAB_ITEM));

    public static final DeferredItem<Item>  GRASSHOPPER_DNA = ITEMS.register("grasshopper_dna",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shin",SHIN_STONE ,SHINHELMET,SHINCHESTPLATE,SHINLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.SHIN_TAB_ITEM));

    // ZO
    public static final DeferredItem<Item>  ZO_LOGO = ITEMS.register("zo_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/zo")), new Item.Properties()).AddToList(RiderTabs.ZO_TAB_ITEM));

    public static final DeferredItem<Item>  ZO_STONE = ITEMS.register("zo_stone",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","zo","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.ZO_TAB_ITEM).KeepItem());


    public static final DeferredItem<Item>  ZOHELMET = ITEMS.register("zohead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.ZO_TAB_ITEM));
    public static final DeferredItem<Item>  ZOCHESTPLATE = ITEMS.register("zotroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.ZO_TAB_ITEM));
    public static final DeferredItem<Item>  ZOLEGGINGS = ITEMS.register("zolegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZO_TAB_ITEM));

    public static final DeferredItem<Item>  ZO_CORE = ITEMS.register("zo_core",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zo",ZO_STONE ,ZOHELMET,ZOCHESTPLATE,ZOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.ZO_TAB_ITEM));

    // J
    public static final DeferredItem<Item>  J_LOGO = ITEMS.register("j_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/j")), new Item.Properties()).AddToList(RiderTabs.J_TAB_ITEM));

    public static final DeferredItem<Item>  J_STONE_JUMBO_FORMATION = ITEMS.register("j_stone_jumbo_formation",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","j","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false)
                    ,new MobEffectInstance(Effect_core.BIG, 40, 2,true,false))
                    .IsGlowing().model_has_different_name("j_stone").has_basic_model());

    public static final DeferredItem<Item>  J_STONE = ITEMS.register("j_stone",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","j","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().addSwitchForm(J_STONE_JUMBO_FORMATION.get()).AddToList(RiderTabs.J_TAB_ITEM).KeepItem());


    public static final DeferredItem<Item>  JHELMET = ITEMS.register("jhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.J_TAB_ITEM));
    public static final DeferredItem<Item>  JCHESTPLATE = ITEMS.register("jtroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.J_TAB_ITEM));
    public static final DeferredItem<Item>  JLEGGINGS = ITEMS.register("jlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.J_TAB_ITEM));

    public static final DeferredItem<Item>  J_SPIRIT = ITEMS.register("j_spirit",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"j",J_STONE ,JHELMET,JCHESTPLATE,JLEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.J_TAB_ITEM));



public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
}

}
