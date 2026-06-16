package com.kelco.kamenridercraft.item.extra_riders;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
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

public class GoriderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item> AKARIDER_CARD = ITEMS.register("akarider_card",
            () -> new RiderFormChangeItem(new Item.Properties(),"","aka_rider","typhoon_belt_akarider",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED,40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 4,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GORIDER_TAB_ITEM).KeepItem());

    public static final DeferredItem<Item> AORIDER_CARD = ITEMS.register("aorider_card",
            () -> new RiderFormChangeItem(new Item.Properties(),"","ao_rider","typhoon_belt_aorider",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED,40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 4,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GORIDER_TAB_ITEM).KeepItem());

    public static final DeferredItem<Item> KIRIDER_CARD = ITEMS.register("kirider_card",
            () -> new RiderFormChangeItem(new Item.Properties(),"","ki_rider","typhoon_belt_kirider",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED,40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 4,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GORIDER_TAB_ITEM).KeepItem());

    public static final DeferredItem<Item> MOMORIDER_CARD = ITEMS.register("momorider_card",
            () -> new RiderFormChangeItem(new Item.Properties(),"","momo_rider","typhoon_belt_momorider",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED,40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 4,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GORIDER_TAB_ITEM).KeepItem());

    public static final DeferredItem<Item> MIDORIDER_CARD = ITEMS.register("midorider_card",
            () -> new RiderFormChangeItem(new Item.Properties(),"","mido_rider","typhoon_belt_midorider",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED,40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 4,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GORIDER_TAB_ITEM).KeepItem());


    public static final DeferredItem<Item> AKARIDERHELMET = ITEMS.register("akariderhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GORIDER_TAB_ITEM));
    public static final DeferredItem<Item> AKARIDERCHESTPLATE = ITEMS.register("akaridertroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GORIDER_TAB_ITEM));
    public static final DeferredItem<Item> AKARIDERLEGGINGS = ITEMS.register("akariderlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GORIDER_TAB_ITEM));

    public static final DeferredItem<Item> TYPHOON_AKARIDER = ITEMS.register("typhoon_akarider",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"aka_rider",AKARIDER_CARD ,AKARIDERHELMET,AKARIDERCHESTPLATE,AKARIDERLEGGINGS , new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GORIDER_TAB_ITEM));
    public static final DeferredItem<Item> TYPHOON_AORIDER = ITEMS.register("typhoon_aorider",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ao_rider",AORIDER_CARD ,AKARIDERHELMET,AKARIDERCHESTPLATE,AKARIDERLEGGINGS , new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GORIDER_TAB_ITEM));
    public static final DeferredItem<Item> TYPHOON_KIRIDER = ITEMS.register("typhoon_kirider",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ki_rider",KIRIDER_CARD ,AKARIDERHELMET,AKARIDERCHESTPLATE,AKARIDERLEGGINGS , new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GORIDER_TAB_ITEM));
    public static final DeferredItem<Item> TYPHOON_MOMORIDER = ITEMS.register("typhoon_momorider",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"momo_rider",MOMORIDER_CARD ,AKARIDERHELMET,AKARIDERCHESTPLATE,AKARIDERLEGGINGS , new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GORIDER_TAB_ITEM));
    public static final DeferredItem<Item> TYPHOON_MIDORIDER = ITEMS.register("typhoon_midorider",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"mido_rider",MIDORIDER_CARD ,AKARIDERHELMET,AKARIDERCHESTPLATE,AKARIDERLEGGINGS , new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GORIDER_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
