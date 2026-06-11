package com.kelco.kamenridercraft.item.showa;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
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

import static com.kelco.kamenridercraft.item.Modded_item_core.RIDER_CIRCUIT;


public class ZXRiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item>  ZX_LOGO = ITEMS.register("zx_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/zx")), new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.ZX_TAB_ITEM));


    public static final DeferredItem<Item>  ZX_BELT_CORE = ITEMS.register("zx_belt_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","zx","zx_belt_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.hasSD().allowRiderKick().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ZX_TAB_ITEM));

    public static final DeferredItem<Item>  SUSANOO_BELT_CORE = ITEMS.register("susanoo_belt_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","susunaoo_zx","susanoo_belt_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().HasCape().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ZX_TAB_ITEM));

    public static final DeferredItem<Item>  TSUKUYOMI_BELT_CORE = ITEMS.register("tsukuyomi_belt_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","tsukuyomi_zx","tsukuyomi_belt_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ZX_TAB_ITEM));

    public static final DeferredItem<Item>  AMATERASU_BELT_CORE = ITEMS.register("amaterasu_belt_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","amaterasu_zx","amaterasu_belt_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ZX_TAB_ITEM));

    public static final DeferredItem<Item>  ZXHELMET = ITEMS.register("zxhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZX_TAB_ITEM));
    public static final DeferredItem<Item>  ZXCHESTPLATE = ITEMS.register("zxtroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZX_TAB_ITEM));
    public static final DeferredItem<Item>  ZXLEGGINGS = ITEMS.register("zxlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZX_TAB_ITEM));


    public static final DeferredItem<Item>  ZX_BELT = ITEMS.register("zx_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zx",ZX_BELT_CORE ,ZXHELMET,ZXCHESTPLATE,ZXLEGGINGS , new Item.Properties())
                    .HasAnSDForm().IsA1().Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZX_TAB_ITEM));

    public static final DeferredItem<Item>  SUSANOO_BELT = ITEMS.register("susanoo_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"susanoo_zx",SUSANOO_BELT_CORE ,ZXHELMET,ZXCHESTPLATE,ZXLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZX_TAB_ITEM));
    public static final DeferredItem<Item>  TSUKUYOMI_BELT = ITEMS.register("tsukuyomi_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"tsukuyomi_zx",TSUKUYOMI_BELT_CORE ,ZXHELMET,ZXCHESTPLATE,ZXLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZX_TAB_ITEM));
    public static final DeferredItem<Item>  AMATERASU_BELT = ITEMS.register("amaterasu_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"amaterasu_zx",AMATERASU_BELT_CORE ,ZXHELMET,ZXCHESTPLATE,ZXLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZX_TAB_ITEM));

    public static final DeferredItem<Item> MICRO_CHAIN = ITEMS.register("micro_chain",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2F, new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.ZX_TAB_ITEM).ChangeRepairItem(RIDER_CIRCUIT.get()));
    public static final DeferredItem<SwordItem> CROSS_SHURIKEN = ITEMS.register("cross_shuriken",
            () -> new BaseThrowableItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZX_TAB_ITEM).ChangeRepairItem(RIDER_CIRCUIT.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
