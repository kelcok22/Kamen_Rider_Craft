package com.kelco.kamenridercraft.item.reboots;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ShinIchigoRiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item> PRANA_INFUSED_RIDER_CIRCUIT = ITEMS.register("prana_infused_rider_circuit",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> SHIN_TYPHOON_CORE = ITEMS.register("shin_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","shin_ichigo","shin_typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeModel("ichigo.geo.json").isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> SHIN_TYPHOON_CORE_2 = ITEMS.register("shin_typhoon_core2",
            () -> new RiderFormChangeItem(new Item.Properties(),"","shin_nigo","shin_typhoon_belt2",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeModel("ichigo.geo.json").isGlowing().has_basic_model().model_has_different_name("shin_typhoon_core").addToList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> SHIN_TYPHOON_CORE_2_1 = ITEMS.register("shin_typhoon_core_2_1",
            () -> new RiderFormChangeItem(new Item.Properties(),"","shin_2_1","shin_typhoon_belt2",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeModel("ichigo.geo.json").isGlowing().has_basic_model().model_has_different_name("shin_typhoon_core").addToList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_ICHIGO_TAB_ITEM));

    public static final DeferredItem<Item> ULTIMATE_HALF_TYPHOON_CORE = ITEMS.register("ultimate_half_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","shin_no_0","ultimate_half_typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().changeModel("shin_no_0.geo.json").hasCape().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_ICHIGO_TAB_ITEM));


    public static final DeferredItem<Item> SHIN_ICHIGO_HELMET = ITEMS.register("shin_ichigohead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1))
                    .has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_ICHIGO_TAB_ITEM).changeRepairItem(PRANA_INFUSED_RIDER_CIRCUIT.get()));

    public static final DeferredItem<Item> SHIN_ICHIGO_CHESTPLATE = ITEMS.register("shin_ichigotroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1))
                    .has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_ICHIGO_TAB_ITEM).changeRepairItem(PRANA_INFUSED_RIDER_CIRCUIT.get()));

    public static final DeferredItem<Item> SHIN_ICHIGO_LEGGINGS = ITEMS.register("shin_ichigolegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1))
                    .has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_ICHIGO_TAB_ITEM).changeRepairItem(PRANA_INFUSED_RIDER_CIRCUIT.get()));


    public static final DeferredItem<Item> TYPHOON_1 = ITEMS.register("shin_typhoon_ichigo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shin_ichigo", SHIN_TYPHOON_CORE,SHIN_ICHIGO_HELMET, SHIN_ICHIGO_CHESTPLATE,SHIN_ICHIGO_LEGGINGS , new Item.Properties())
                    .hideBeltFormInfo().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_ICHIGO_TAB_ITEM).changeRepairItem(PRANA_INFUSED_RIDER_CIRCUIT.get()));

    public static final DeferredItem<Item> TYPHOON_2 = ITEMS.register("shin_typhoon_nigo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shin_nigo", SHIN_TYPHOON_CORE_2,SHIN_ICHIGO_HELMET, SHIN_ICHIGO_CHESTPLATE,SHIN_ICHIGO_LEGGINGS , new Item.Properties())
                    .hideBeltFormInfo().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_ICHIGO_TAB_ITEM).changeRepairItem(PRANA_INFUSED_RIDER_CIRCUIT.get()));

    public static final DeferredItem<Item> TYPHOON_2_1 = ITEMS.register("shin_typhoon_2_1",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shin_2_1", SHIN_TYPHOON_CORE_2_1,SHIN_ICHIGO_HELMET, SHIN_ICHIGO_CHESTPLATE,SHIN_ICHIGO_LEGGINGS , new Item.Properties())
                    .hideBeltFormInfo().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_ICHIGO_TAB_ITEM).changeRepairItem(PRANA_INFUSED_RIDER_CIRCUIT.get()));

    public static final DeferredItem<Item> ULTIMATE_HALF_TYPHOON = ITEMS.register("ultimate_half_typhoon",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shin_no_0", ULTIMATE_HALF_TYPHOON_CORE,SHIN_ICHIGO_HELMET, SHIN_ICHIGO_CHESTPLATE,SHIN_ICHIGO_LEGGINGS , new Item.Properties())
                    .hideBeltFormInfo().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_ICHIGO_TAB_ITEM).changeRepairItem(PRANA_INFUSED_RIDER_CIRCUIT.get()));

    public static final DeferredItem<Item> SIMPLIFIED_TYPHOON = ITEMS.register("simplified_typhoon",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"phase_variation_batta_augments", SHIN_TYPHOON_CORE,SHIN_ICHIGO_HELMET, SHIN_ICHIGO_CHESTPLATE,SHIN_ICHIGO_LEGGINGS , new Item.Properties())
                    .overrideBeltText("simplified_typhoon_belt").hideBeltFormInfo().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_ICHIGO_TAB_ITEM).changeRepairItem(PRANA_INFUSED_RIDER_CIRCUIT.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
