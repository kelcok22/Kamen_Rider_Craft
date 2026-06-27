package com.kelco.kamenridercraft.item.showa;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.*;
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


public class BlackRiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item>  BLACK_LOGO = ITEMS.register("black_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/black")), new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_TAB_ITEM));


    public static final DeferredItem<Item>  RED_KING_STONE = ITEMS.register("red_king_stone",
            () -> new RiderFormChangeItem(new Item.Properties(),"","black","vital_charger_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.hasSD().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_TAB_ITEM));


    public static final DeferredItem<Item>  BATTA_MAN_KING_STONE = ITEMS.register("batta_man_king_stone",
            () -> new RiderFormChangeItem(new Item.Properties(),"_batta_man","black","vital_charger_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_TAB_ITEM));


    public static final DeferredItem<Item>  GREEN_KING_STONE = ITEMS.register("green_king_stone",
            () -> new RiderFormChangeItem(new Item.Properties(),"","shadow_moon","shadow_charger_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(EffectCore.DARK_AURA,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.hasSD().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_TAB_ITEM));

    public static final DeferredItem<Item>  CREATION_KING_STONE = ITEMS.register("creation_king_stone",
            () -> new RiderFormChangeItem(new Item.Properties(),"_red","shadow_moon","shadow_charger_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_TAB_ITEM));

    public static final DeferredItem<Item>  ANOTHER_KING_STONE = ITEMS.register("another_king_stone",
            () -> new RiderFormChangeItem(new Item.Properties(),"_another","shadow_moon","shadow_charger_another_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.isGlowing().hasCape().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_TAB_ITEM));

    public static final DeferredItem<Item>  GREEN_KING_STONE_HAJIME_SORAYAMA = ITEMS.register("green_king_stone_hajime_sorayama",
            () -> new RiderFormChangeItem(new Item.Properties(),"_hajime_sorayama","shadow_moon","shadow_charger_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_TAB_ITEM));


    public static final DeferredItem<Item>  BLACKHELMET = ITEMS.register("blackhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_TAB_ITEM));
    public static final DeferredItem<Item>  BLACKCHESTPLATE = ITEMS.register("blacktorso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_TAB_ITEM));
    public static final DeferredItem<Item>  BLACKLEGGINGS = ITEMS.register("blacklegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_TAB_ITEM));

    public static final DeferredItem<Item>  VITAL_CHARGER = ITEMS.register("vital_charger",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"black",RED_KING_STONE ,BLACKHELMET,BLACKCHESTPLATE,BLACKLEGGINGS , new Item.Properties())
                    .hasSDForm().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_TAB_ITEM));

    public static final DeferredItem<Item> SHADOW_CHARGER = ITEMS.register("shadow_charger",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shadow_moon",GREEN_KING_STONE ,BLACKHELMET,BLACKCHESTPLATE,BLACKLEGGINGS , new Item.Properties())
                    .hasSDForm().isA1().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_TAB_ITEM));

    public static final DeferredItem<Item> SATANSABER = ITEMS.register("satansaber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
