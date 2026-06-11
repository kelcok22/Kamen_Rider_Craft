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


public class BlackRXRiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item>  BLACK_RX_LOGO = ITEMS.register("black_rx_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/black_rx")), new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.RX_TAB_ITEM));

    public static final DeferredItem<Item>  SPLIT_KING_STONE = ITEMS.register("split_king_stone",
            () -> new BaseItem(new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.RX_TAB_ITEM));

    public static final DeferredItem<Item>  RX_CORE = ITEMS.register("rx_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","black_rx","sun_riser_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.hasSD().IsGlowing().IsA1().AddToList(KamenRiderCraftCore.CreativeTabRegistry.RX_TAB_ITEM));

    public static final DeferredItem<Item>  ROBO_CORE = ITEMS.register("robo_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"_robo","black_rx","sun_riser_belt_robo",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().IsA1().AddToList(KamenRiderCraftCore.CreativeTabRegistry.RX_TAB_ITEM));

    public static final DeferredItem<Item>  BIO_CORE = ITEMS.register("bio_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"_bio","black_rx","sun_riser_belt_bio",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.WATER_BREATHING,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 1,true,false)
                    ,new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().IsA1().AddToList(KamenRiderCraftCore.CreativeTabRegistry.RX_TAB_ITEM));

    public static final DeferredItem<Item>  MOON_RX_CORE = ITEMS.register("moon_rx_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","white_rx","moon_riser",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.RX_TAB_ITEM));


    public static final DeferredItem<Item> RXHELMET = ITEMS.register("rxhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.RX_TAB_ITEM));
    public static final DeferredItem<Item>  RXCHESTPLATE = ITEMS.register("rxtroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.RX_TAB_ITEM));
    public static final DeferredItem<Item>  RXLEGGINGS = ITEMS.register("rxlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.RX_TAB_ITEM));

    public static final DeferredItem<Item>  SUN_RISER = ITEMS.register("sun_riser",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"black_rx",RX_CORE ,RXHELMET,RXCHESTPLATE,RXLEGGINGS , new Item.Properties())
                    .HasAnSDForm().IsA1().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.RX_TAB_ITEM));

    public static final DeferredItem<Item>  MOON_RISER = ITEMS.register("moon_riser",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"white_rx",MOON_RX_CORE ,RXHELMET,RXCHESTPLATE,RXLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.RX_TAB_ITEM));


    public static final DeferredItem<Item>REVOLCANE = ITEMS.register("revolcane",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.RX_TAB_ITEM));

    public static final DeferredItem<Item> VORTECHSHOOTER = ITEMS.register("vortech_shooter",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.RX_TAB_ITEM));

    public static final DeferredItem<Item> BIOBLADE = ITEMS.register("bio_blade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.RX_TAB_ITEM));

    public static final DeferredItem<Item> SHADOWSABER = ITEMS.register("shadow_saber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.RX_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
