package com.kelco.kamenridercraft.item.reiwa;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom.WolfFrameRenderLayerInfo;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.*;
import com.kelco.kamenridercraft.particle.ModParticles;
import com.kelco.kamenridercraft.util.AnimationUtil;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.Objects;

public class MyThRiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

    public static final DeferredItem<Item> RIDE_X_EGGS_1_RID = ITEMS.register("ride_x_eggs_1_rid",
            () -> new RiderFormChangeItem(new Item.Properties(),"","rid","my_th_driver_belt_rid",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().hasCape().setModelName("ride_x_eggs_1").useBasicModel());

    public static final DeferredItem<Item> RIDE_X_EGGS_1 = ITEMS.register("ride_x_eggs_1",
            () -> new RiderFormChangeItem(new Item.Properties(),"","my_th","my_th_driver_belt",
                    new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.CLIMBING, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick) {
                    super.transformationEffect(itemstack, player, tick);
                    if (tick == 30d) {
                        player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.OMINOUS_BOTTLE_DISPOSE, SoundSource.PLAYERS, 1.0F, 1F);
                        AnimationUtil.playPose(player, "my_th.pose");
                        ((ServerLevel) player.level()).sendParticles(ModParticles.MY_TH_GEM_PARTICLES.get(),
                                player.getX(), player.getY() + 1,
                                player.getZ(), 100, 0, 0, 0, 1);
                    }
                    if (tick == 10d) {
                        ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(), player.getX(), player.getY() + 1, player.getZ(), 100, 0, 0, 0, 1);
                    }
                }
            }.isGlowing().IsBeltGlowing().addAlternative(RIDE_X_EGGS_1_RID.get()).changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").hasCape().useBasicModel().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> RIDE_X_EGGS_1_ORIGIN = ITEMS.register("ride_x_eggs_1_origin",
            () -> new RiderFormChangeItem(new Item.Properties(),"","black_my_th","my_th_driver_belt_black_my_th",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().hasCape().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> RIDE_X_EGGS_1_MAOU = ITEMS.register("ride_x_eggs_1_maou",
            () -> new RiderFormChangeItem(new Item.Properties(),"","maou","maou_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().hasCape().useBasicModel().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> RIDE_X_EGGS_4_DATT = ITEMS.register("ride_x_eggs_4_datt",
            () -> new RiderFormChangeItem(new Item.Properties(),"","datt","my_th_driver_belt_datt",
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().hasCape().setModelName("ride_x_eggs_4").useBasicModel());

    public static final DeferredItem<Item> RIDE_X_EGGS_4 = ITEMS.register("ride_x_eggs_4",
            () -> new RiderFormChangeItem(new Item.Properties(),"_turtle_frame","my_th","my_th_driver_belt_turtle",
                    new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)){
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                        Item back = MyThRiderItems.FRAME_MY_TH_BACK.get();
                        if (rider.getMainHandItem().getItem()!= back&&rider.getOffhandItem().getItem()!= back&&slot==EquipmentSlot.HEAD) layerInfo.add(new RenderLayerInfo("my_th_turtle_frame_back",null));
                }
                public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick) {
                    super.transformationEffect(itemstack, player, tick);
                    if (tick == 30d) {
                        player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.OMINOUS_BOTTLE_DISPOSE, SoundSource.PLAYERS, 1.0F, 1F);
                        ((ServerLevel) player.level()).sendParticles(ModParticles.MY_TH_GEM_TURTLE_PARTICLES.get(),
                                player.getX(), player.getY() + 1,
                                player.getZ(), 100, 0, 0, 0, 1);
                    }
                    if (tick == 10d) {
                        ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(), player.getX(), player.getY() + 1, player.getZ(), 100, 0, 0, 0, 1);
                    }
                }
            }.isGlowing().IsBeltGlowing().addAlternative(RIDE_X_EGGS_4_DATT.get()).changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").hasCape().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> RIDE_X_EGGS_6_JYAO = ITEMS.register("ride_x_eggs_6_jyao",
            () -> new RiderFormChangeItem(new Item.Properties(),"","jyao","my_th_driver_belt_jyao",
                    new MobEffectInstance(EffectCore.SLASH, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.LONG_ARM, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().hasCape().setModelName("ride_x_egg_6"));

    public static final DeferredItem<Item> RIDE_X_EGGS_6 = ITEMS.register("ride_x_eggs_6",
            () -> new RiderFormChangeItem(new Item.Properties(),"","empty","my_th_driver_belt_turtle",
                    new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)){
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    Item back = MyThRiderItems.FRAME_MY_TH_BACK.get();
                    if (rider.getMainHandItem().getItem()!= back&&rider.getOffhandItem().getItem()!= back&&slot==EquipmentSlot.HEAD) layerInfo.add(new RenderLayerInfo("my_th_turtle_frame_back",null));
                }
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.OMINOUS_BOTTLE_DISPOSE, SoundSource.PLAYERS, 1.0F, 1F);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.MY_TH_GEM_TURTLE_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().addAlternative(RIDE_X_EGGS_6_JYAO.get()).changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").hasCape().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> RIDE_X_EGGS_8_MUTN = ITEMS.register("ride_x_eggs_8_mutn",
            () -> new RiderFormChangeItem(new Item.Properties(),"","mutn","my_th_driver_belt_mutn",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().setModelName("ride_x_eggs_8").useBasicModel());

    public static final DeferredItem<Item> RIDE_X_EGGS_8 = ITEMS.register("ride_x_eggs_8",
            () -> new RiderFormChangeItem(new Item.Properties(),"_wolf_frame","my_th","my_th_driver_belt_wolf",
                    new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        layerInfo.add(new WolfFrameRenderLayerInfo("my_th_wolf_frame_muzzle", "my_th_wolf_frame_muzzle"));
                    }
                }
                public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick) {
                    super.transformationEffect(itemstack, player, tick);
                    if (tick == 30d) {
                        player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.OMINOUS_BOTTLE_DISPOSE, SoundSource.PLAYERS, 1.0F, 1F);
                        ((ServerLevel) player.level()).sendParticles(ModParticles.MY_TH_GEM_WOLF_PARTICLES.get(),
                                player.getX(), player.getY() + 1,
                                player.getZ(), 100, 0, 0, 0, 1);
                    }
                    if (tick == 10d) {
                        ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(), player.getX(), player.getY() + 1, player.getZ(), 100, 0, 0, 0, 1);
                    }
                }
            }.isGlowing().IsBeltGlowing().addAlternative(RIDE_X_EGGS_8_MUTN.get()).changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").hasCape().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> RIDE_X_EGGS_11_VANKEN = ITEMS.register("ride_x_eggs_11_vanken",
            () -> new RiderFormChangeItem(new Item.Properties(),"","vanken","my_th_driver_belt_vanken",
                    new MobEffectInstance(EffectCore.SHOT_BOOST, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.RADAR, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BROWN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().hasCape().setModelName("ride_x_eggs_11").useBasicModel());

    public static final DeferredItem<Item> RIDE_X_EGGS_11 = ITEMS.register("ride_x_eggs_11",
            () -> new RiderFormChangeItem(new Item.Properties(),"_eagle_frame","my_th","my_th_driver_belt_eagle",
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.GLIDE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
        public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick) {
                    super.transformationEffect(itemstack, player, tick);
                    if (tick == 30d) {
                        player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.OMINOUS_BOTTLE_DISPOSE, SoundSource.PLAYERS, 1.0F, 1F);
                        ((ServerLevel) player.level()).sendParticles(ModParticles.MY_TH_GEM_EAGLE_PARTICLES.get(),
                                player.getX(), player.getY() + 1,
                                player.getZ(), 100, 0, 0, 0, 1);
                    }
                    if (tick == 10d) {
                        ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(), player.getX(), player.getY() + 1, player.getZ(), 100, 0, 0, 0, 1);
                    }
                }
            }.isGlowing().IsBeltGlowing().addAlternative(RIDE_X_EGGS_11_VANKEN.get()).changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").hasCape().setSlotOneAbility("flight_boost", 1).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> HARINEZUMI_SEED_X_EGGS = ITEMS.register("harinezumi_seed_x_egg",
            () -> new RiderFormChangeItem(new Item.Properties(),"_hedgehog","my_th","my_th_driver_belt_hedgehog",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.REFLECT, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").hasCape().useBasicModel().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> ZEZTZ_RIDE_X_EGGS = ITEMS.register("zeztz_ride_x_eggs",
            () -> new BaseItem(new Item.Properties()).useBasicModel().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> MY_TH_HELMET = ITEMS.register("my_th_head",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).useBasicModel().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));
    public static final DeferredItem<Item> MY_TH_CHESTPLATE = ITEMS.register("my_th_troso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).useBasicModel().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));
    public static final DeferredItem<Item> MY_TH_LEGGINGS = ITEMS.register("my_th_legs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).useBasicModel().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> MY_TH_DRIVER = ITEMS.register("my_th_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"my_th",RIDE_X_EGGS_1 ,MY_TH_HELMET,MY_TH_CHESTPLATE,MY_TH_LEGGINGS , new Item.Properties()) {
                public String getText(ItemStack itemStack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
                    if (rider.getAttribute(KRCAttributes.IS_TRANSFORMING).getBaseValue()!=0){
                        if(equipmentSlot != EquipmentSlot.FEET&&getFormItem(itemStack, 1).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/my_th_henshin_forms")))&&(rider.getAttribute(KRCAttributes.IS_TRANSFORMING).getBaseValue()<30)&(rider.getAttribute(KRCAttributes.IS_TRANSFORMING).getBaseValue()>10))return "my_th_henshin";
                    }
                    return super.getText(itemStack,equipmentSlot,rider,riderName);
                }
                public ResourceLocation getModelResource(ItemStack itemStack, RiderArmorItem animatable, EquipmentSlot equipmentSlot, LivingEntity rider) {
                    double transformingTick = getHenshinTick(itemStack, rider);
                    if (equipmentSlot != EquipmentSlot.FEET&&getFormItem(itemStack, 1).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/my_th_henshin_forms")))&&(rider.getAttribute(KRCAttributes.IS_TRANSFORMING).getBaseValue()<30)&(rider.getAttribute(KRCAttributes.IS_TRANSFORMING).getBaseValue()>10)) {
                        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/armor/default.geo.json");
                    }
                    return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/armor/" + getFormItem(itemStack, 1, transformingTick).getModel(this.riderName));
                }
            }.useBasicModel().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> MY_TH_DRIVER_HAMMER_ON_BLACK = ITEMS.register("my_th_driver_hammer_on_black",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"black_my_th",RIDE_X_EGGS_1_ORIGIN ,MY_TH_HELMET,MY_TH_CHESTPLATE,MY_TH_LEGGINGS , new Item.Properties()).hideBeltFormInfo().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> MY_TH_DRIVER_HAMMER_ON = ITEMS.register("my_th_driver_hammer_on",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"rid",RIDE_X_EGGS_1_RID ,MY_TH_HELMET,MY_TH_CHESTPLATE,MY_TH_LEGGINGS , new Item.Properties()).hideBeltFormInfo().useBasicModel().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> MY_TH_DRIVER_SLASH_ON = ITEMS.register("my_th_driver_slash_on",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"datt",RIDE_X_EGGS_4_DATT ,MY_TH_HELMET,MY_TH_CHESTPLATE,MY_TH_LEGGINGS , new Item.Properties()).hideBeltFormInfo().useBasicModel().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> MY_TH_DRIVER_SHOT_ON = ITEMS.register("my_th_driver_shot_on",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"vanken",RIDE_X_EGGS_11_VANKEN ,MY_TH_HELMET,MY_TH_CHESTPLATE,MY_TH_LEGGINGS , new Item.Properties()).hideBeltFormInfo().useBasicModel().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> MY_TH_DRIVER_BITE_ON = ITEMS.register("my_th_driver_bite_on",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"jyao",RIDE_X_EGGS_6_JYAO ,MY_TH_HELMET,MY_TH_CHESTPLATE,MY_TH_LEGGINGS , new Item.Properties()).hideBeltFormInfo().useBasicModel().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> MY_TH_DRIVER_BITE_ON_MUTN = ITEMS.register("my_th_driver_bite_on_mutn",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"mutn",RIDE_X_EGGS_8_MUTN ,MY_TH_HELMET,MY_TH_CHESTPLATE,MY_TH_LEGGINGS , new Item.Properties()).hideBeltFormInfo().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> MAOU_DRIVER = ITEMS.register("maou_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"maou",RIDE_X_EGGS_1_MAOU ,MY_TH_HELMET,MY_TH_CHESTPLATE,MY_TH_LEGGINGS , new Item.Properties()).hideBeltFormInfo().useBasicModel().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> MY_TH_EDGE = ITEMS.register("my_th_edge",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2F, new Item.Properties()).IsSwordGun().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> FRAME_MY_TH_BACK = ITEMS.register("frame_my_th_back",
            () -> new BaseShieldItem(new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> RABBIT_SWORD = ITEMS.register("rabbit_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2F, new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> SNAKE_SCYTHE = ITEMS.register("snake_scythe",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2F, new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> DOG_GUN = ITEMS.register("dog_gun",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2F, new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.MY_TH_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
