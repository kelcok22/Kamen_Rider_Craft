package com.kelco.kamenridercraft.item.extra_riders;

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

public class GRiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item> G_LOGO = ITEMS.register("g_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/g")), new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.G_TAB_ITEM));

    public static final DeferredItem<Item> GORO_WINE_BOTTLE = ITEMS.register("goro_wine_bottle",
            () -> new RiderFormChangeItem(new Item.Properties(),"","kamen_rider_g","g_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.G_TAB_ITEM).KeepItem());

    public static final DeferredItem<Item> GHELMET = ITEMS.register("ghead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.G_TAB_ITEM));
    public static final DeferredItem<Item> GCHESTPLATE = ITEMS.register("gtroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.G_TAB_ITEM));
    public static final DeferredItem<Item> GLEGGINGS = ITEMS.register("glegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.G_TAB_ITEM));

    public static final DeferredItem<Item> G_BELT = ITEMS.register("g_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kamen_rider_g",GORO_WINE_BOTTLE ,GHELMET,GCHESTPLATE,GLEGGINGS , new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.G_TAB_ITEM));

    public static final DeferredItem<Item> G_SOMMELIER_KNIFE = ITEMS.register("g_sommelier_knife",
            () -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.G_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
