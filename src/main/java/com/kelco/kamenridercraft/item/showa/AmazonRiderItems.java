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
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class AmazonRiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item> AMAZON_LOGO = ITEMS.register("amazon_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/amazon")), new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZON_TAB_ITEM));


    public static final DeferredItem<Item> CONDORER_WHEEL = ITEMS.register("condorer_wheel",
            () -> new RiderFormChangeItem(new Item.Properties(),"","amazon","condorer_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.REGENERATION,200, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.hasSD().changeModel("amazon.geo.json").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZON_TAB_ITEM));

    public static final DeferredItem<Item> GIGI_ARMLET = ITEMS.register("gigi_armlet",
            () -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZON_TAB_ITEM));

    public static final DeferredItem<Item> GAGA_ARMLET = ITEMS.register("gaga_armlet",
            () -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZON_TAB_ITEM));

    public static final DeferredItem<Item> AMAZONHELMET = ITEMS.register("amazonhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZON_TAB_ITEM));
    public static final DeferredItem<Item> AMAZONCHESTPLATE = ITEMS.register("amazontroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZON_TAB_ITEM));
    public static final DeferredItem<Item> AMAZONLEGGINGS = ITEMS.register("amazonlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZON_TAB_ITEM));

    public static final DeferredItem<Item> CONDORER = ITEMS.register("condorer",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"amazon",CONDORER_WHEEL ,AMAZONHELMET,AMAZONCHESTPLATE,AMAZONLEGGINGS , new Item.Properties())
                    .hasSDForm().isA1().addToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZON_TAB_ITEM));

    public static final DeferredItem<Item> DARK_CONDORER = ITEMS.register("dark_condorer",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_amazon",CONDORER_WHEEL ,AMAZONHELMET,AMAZONCHESTPLATE,AMAZONLEGGINGS , new Item.Properties()).hideBeltFormInfo()
                    .overrideBeltText("dark_condorer_belt").addToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZON_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
