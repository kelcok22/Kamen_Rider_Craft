package com.kelco.kamenridercraft.item.showa;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.effect_core.EffectCore;
import com.kelco.kamenridercraft.item.base_items.BaseBannerPatternItem;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
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


public class SkyriderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item> SKYRIDER_LOGO = ITEMS.register("skyrider_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/skyrider")), new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.SKYRIDER_TAB_ITEM));

    public static final DeferredItem<Item> TORNADO_CORE = ITEMS.register("tornado_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","skyrider","tornado_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false)
                    ,new MobEffectInstance(EffectCore.FLYING, 40, 4,true,false)){
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
            }.hasSD().ChangeModel("skyrider.geo.json").HasCape().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.SKYRIDER_TAB_ITEM));

    public static final DeferredItem<Item> ORIGINAL_TORNADO_CORE = ITEMS.register("original_tornado_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"_original","skyrider","tornado_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false)
                    ,new MobEffectInstance(EffectCore.FLYING, 40, 4,true,false)){
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
            }.hasSD().ChangeModel("skyrider.geo.json").HasCape().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.SKYRIDER_TAB_ITEM).has_basic_model());

    public static final DeferredItem<Item> GG_CORE = ITEMS.register("gg_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","gangan_g","gangan_g_belt_belt")
                    .has_basic_model().AddToList(KamenRiderCraftCore.CreativeTabRegistry.SKYRIDER_TAB_ITEM));

    public static final DeferredItem<Item>  SKYRIDERHELMET = ITEMS.register("skyriderhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.SKYRIDER_TAB_ITEM));
    public static final DeferredItem<Item>  SKYRIDERCHESTPLATE = ITEMS.register("skyridertroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.SKYRIDER_TAB_ITEM));
    public static final DeferredItem<Item>  SKYRIDERLEGGINGS = ITEMS.register("skyriderlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.SKYRIDER_TAB_ITEM));

    public static final DeferredItem<Item>  TORNADO = ITEMS.register("tornado",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"skyrider",TORNADO_CORE ,SKYRIDERHELMET,SKYRIDERCHESTPLATE,SKYRIDERLEGGINGS , new Item.Properties())
                    .HasAnSDForm().IsA1().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.SKYRIDER_TAB_ITEM));

    public static final DeferredItem<Item>  GANGAN_G_BELT = ITEMS.register("gangan_g_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"gangan_g",GG_CORE ,SKYRIDERHELMET,SKYRIDERCHESTPLATE,SKYRIDERLEGGINGS , new Item.Properties()).IsA1().Dont_show_belt_form_info().has_basic_model().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.SKYRIDER_TAB_ITEM));

    public static final DeferredItem<Item>  FAKE_TORNADO = ITEMS.register("fake_tornado",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"fake_skyrider",TORNADO_CORE ,SKYRIDERHELMET,SKYRIDERCHESTPLATE,SKYRIDERLEGGINGS , new Item.Properties()).IsA1().Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.SKYRIDER_TAB_ITEM).has_basic_model());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
