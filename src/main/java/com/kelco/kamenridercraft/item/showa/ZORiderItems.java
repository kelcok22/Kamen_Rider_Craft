package com.kelco.kamenridercraft.item.showa;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
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


public class ZORiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item>  ZO_LOGO = ITEMS.register("zo_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/zo")), new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.ZO_TAB_ITEM));

    public static final DeferredItem<Item>  ZO_STONE = ITEMS.register("zo_stone",
            () -> new RiderFormChangeItem(new Item.Properties(),"","zo","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.hasSD().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ZO_TAB_ITEM).KeepItem());

    public static final DeferredItem<Item>  NEONOID_CORE = ITEMS.register("neonoid_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","doras","doras_core",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().HasCape().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ZO_TAB_ITEM));

    public static final DeferredItem<Item>  POWER_UP_NEONOID_CORE = ITEMS.register("power_up_neonoid_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"_red","doras","red_doras_core",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(EffectCore.PUNCH, 40, 3,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().HasCape().AddToList(KamenRiderCraftCore.CreativeTabRegistry.ZO_TAB_ITEM));

    public static final DeferredItem<Item>  ZOHELMET = ITEMS.register("zohead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZO_TAB_ITEM));
    public static final DeferredItem<Item>  ZOCHESTPLATE = ITEMS.register("zotroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZO_TAB_ITEM));
    public static final DeferredItem<Item>  ZOLEGGINGS = ITEMS.register("zolegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZO_TAB_ITEM));

    public static final DeferredItem<Item>  ZO_CORE = ITEMS.register("zo_core",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zo",ZO_STONE ,ZOHELMET,ZOCHESTPLATE,ZOLEGGINGS , new Item.Properties())
                    .HasAnSDForm().Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZO_TAB_ITEM));
    public static final DeferredItem<Item>  DORAS_CORE = ITEMS.register("doras_core",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"doras",NEONOID_CORE ,ZOHELMET,ZOCHESTPLATE,ZOLEGGINGS , new Item.Properties())
                    .AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.ZO_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
