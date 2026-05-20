package com.kelco.kamenridercraft.item.showa;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.effect_core.EffectCore;
import com.kelco.kamenridercraft.item.base_items.*;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.core.particles.ParticleTypes;
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

import static com.kelco.kamenridercraft.item.Modded_item_core.SHOCKER_EMBLEM;


public class IchigoRiderItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item> KAMEN_RIDER_LOGO = ITEMS.register("kamen_rider_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/ichigo")), new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> GRASSHOPPER_MAN_CORE = ITEMS.register("grasshopper_man_core",
            () -> new RiderFormChangeItem(new Item.Properties(), "_chinese_grasshopper_man", "shocker_combatman", "shocker_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().has_basic_model().model_has_different_name("typhoon_core"));

    public static final DeferredItem<Item> TYPHOON_CORE = ITEMS.register("typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","ichigo","typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addAlternative(GRASSHOPPER_MAN_CORE.get()).hasSD().allowRiderKick().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_CORE_NIGO = ITEMS.register("typhoon_core_nigo",
            () -> new RiderFormChangeItem(new Item.Properties(),"","nigo","typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.hasSD().allowRiderKick().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> ORIGINAL_TYPHOON_CORE_NIGO = ITEMS.register("original_typhoon_core_nigo",
            () -> new RiderFormChangeItem(new Item.Properties(),"_original","nigo","typhoon_belt",
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
            () -> new RiderFormChangeItem(new Item.Properties(),"_original","ichigo","typhoon_belt_original",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeModel("ichigo.geo.json").allowRiderKick().IsGlowing().addAlternative(ORIGINAL_TYPHOON_CORE_NIGO.get()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> SAKURAJIMA_TYPHOON_CORE = ITEMS.register("sakurajima_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"_sakurajima","ichigo","typhoon_belt_original",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeModel("ichigo.geo.json").allowRiderKick().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TAKOYAKI_TYPHOON_CORE = ITEMS.register("takoyaki_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"_takoyaki","ichigo","blank",
                    new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)
                    ,new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false)
                    ,new MobEffectInstance(EffectCore.FORM_LOCK, 40, 10,true,false)
                    ,new MobEffectInstance(EffectCore.SMALL, 40, 10,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.SMALL_GUST,
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_CORE_SANGO = ITEMS.register("typhoon_core_sango",
            () -> new RiderFormChangeItem(new Item.Properties(),"","sango","typhoon_belt_sango",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeModel("ichigo.geo.json").allowRiderKick().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_CORE_YONGO = ITEMS.register("typhoon_core_yongo",
            () -> new RiderFormChangeItem(new Item.Properties(),"","yongo","typhoon_belt_yongo",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeModel("ichigo.geo.json").allowRiderKick().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> NEW_TYPHOON_CORE = ITEMS.register("new_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_new","ichigo","new_typhoon_belt",
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
            }.ChangeModel("ichigo.geo.json").allowRiderKick().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> ULTRAMAN_TYPHOON_CORE = ITEMS.register("ultraman_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),"","ichigo","typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)
                    ,new MobEffectInstance(EffectCore.BIG, 40, 2,true,false)
                    ,new MobEffectInstance(EffectCore.FLYING, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.hasSD().ChangeModel("ichigo.geo.json").allowRiderKick().IsGlowing().has_basic_model().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TAKI_VAMPIRE_CORE = ITEMS.register("taki_vampire_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","taki_rider","taki_rider_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
                    .allowRiderKick().has_basic_model().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> GAIA_CORE = ITEMS.register("gaia_core",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"","gaia","gaia_belt_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().IsBeltGlowing().has_basic_model().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> CYBORG_SUPER_ENERGY_CONVERTER_CORE = ITEMS.register("cyborg_super_energy_converter_core",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"","eins","cyborg_super_energy_converter_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.ChangeBeltModel("geo/eins_belt.geo.json").IsGlowing().IsBeltGlowing().SetShowFace().has_basic_model().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> SHOCKER_RIDER_TYPHOON_CORE = ITEMS.register("shocker_rider_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","shocker_rider_1","typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.hasSD().ChangeModel("ichigo.geo.json").allowRiderKick().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> SAIKYO_KAIJIN_TYPHOON_CORE = ITEMS.register("saikyo_kaijin_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"_saikyo_kaijin","shocker_rider_1","typhoon_belt_saikyo_kaijin",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 0.1);
                }
            }.ChangeModel("ichigo.geo.json").allowRiderKick().IsGlowing().has_basic_model().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> NOPHOON_CORE = ITEMS.register("nophoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","kamen_norider","nophoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
                    .ChangeModel("ichigo.geo.json").SetShowFace().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));



    public static final DeferredItem<Item> ICHIGOHELMET = ITEMS.register("ichigohead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));
    public static final DeferredItem<Item> ICHIGOCHESTPLATE = ITEMS.register("ichigotroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));
    public static final DeferredItem<Item> ICHIGOLEGGINGS = ITEMS.register("ichigolegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_ICHIGO = ITEMS.register("typhoon_ichigo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ichigo",TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).HasAnSDForm().IsA1().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_NIGO = ITEMS.register("typhoon_nigo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"nigo",TYPHOON_CORE,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).HasAnSDForm().IsA1().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_SANGO = ITEMS.register("typhoon_sango",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"sango",TYPHOON_CORE_SANGO,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_YONGO = ITEMS.register("typhoon_yongo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"yongo",TYPHOON_CORE_YONGO,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_1 = ITEMS.register("typhoon_shocker_rider_1",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_1",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).HasAnSDForm().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_2 = ITEMS.register("typhoon_shocker_rider_2",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_2",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).HasAnSDForm().Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_3 = ITEMS.register("typhoon_shocker_rider_3",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_3",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).HasAnSDForm().Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_4 = ITEMS.register("typhoon_shocker_rider_4",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_4",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).HasAnSDForm().Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_5 = ITEMS.register("typhoon_shocker_rider_5",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_5",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).HasAnSDForm().Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_6 = ITEMS.register("typhoon_shocker_rider_6",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_6",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).HasAnSDForm().Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_7 = ITEMS.register("typhoon_shocker_rider_7",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_7",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_8 = ITEMS.register("typhoon_shocker_rider_8",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_8",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_9 = ITEMS.register("typhoon_shocker_rider_9",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_9",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_10 = ITEMS.register("typhoon_shocker_rider_10",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_10",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_11 = ITEMS.register("typhoon_shocker_rider_11",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_11",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_SHOCKER_RIDER_12 = ITEMS.register("typhoon_shocker_rider_12",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_rider_12",SHOCKER_RIDER_TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> NOPHOON_KAMEN_NORIDER = ITEMS.register("nophoon_kamen_norider",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kamen_norider",NOPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_DARK_ICHIGO = ITEMS.register("typhoon_dark_ichigo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_ichigo",TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info()
                    .Override_belt_text("dark_typhoon_belt").AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_DARK_NIGO = ITEMS.register("typhoon_dark_nigo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_nigo",TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info()
                    .Override_belt_text("dark_typhoon_belt").AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_FAKE_ICHIGO = ITEMS.register("typhoon_fake_ichigo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"fake_ichigo",TYPHOON_CORE ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties())
                    .Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> TAKI_BELT = ITEMS.register("taki_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"taki_rider",TAKI_VAMPIRE_CORE,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().has_basic_model().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> GAIA_BELT = ITEMS.register("gaia_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"gaia",GAIA_CORE,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON)).has_basic_model().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> CYBORG_SUPER_ENERGY_CONVERTER = ITEMS.register("cyborg_super_energy_converter",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"eins",CYBORG_SUPER_ENERGY_CONVERTER_CORE,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON)).Dont_show_belt_form_info().has_basic_model().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> SHOCKER_BELT = ITEMS.register("shocker_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shocker_combatman",SHOCKER_EMBLEM ,ICHIGOHELMET, ICHIGOCHESTPLATE,ICHIGOLEGGINGS , new Item.Properties()).HasAnSDForm().has_basic_model().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> ICHIGO_MANGA = ITEMS.register("ichigo_manga",
            () -> new RiderFormChangeItem(new Item.Properties(),"_manga","ichigo","typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)
                    ,new MobEffectInstance(EffectCore.FLAT, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeModel("ichigo.geo.json").allowRiderKick().IsGlowing().has_basic_model().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> RIDER3_VS_THE_DEMON_OF_GENERAL_BLACK = ITEMS.register("rider3_vs_the_demon_of_general_black",
            () -> new RiderFormChangeItem(new Item.Properties(),"_manga","sango","typhoon_belt_original",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeModel("ichigo.geo.json").allowRiderKick().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ICHIGO_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
