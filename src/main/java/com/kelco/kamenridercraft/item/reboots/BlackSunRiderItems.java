package com.kelco.kamenridercraft.item.reboots;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machineBlocks.KaijinStoneGenerator;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.*;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class BlackSunRiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item> KAIJIN_STONE = ITEMS.register("kaijin_stone",
            () -> new BaseItem(new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_SUN_TAB_ITEM).AddToList(KaijinStoneGenerator.KING_STONE, 20));

    public static final DeferredItem<Item> CREATION_KING_EXTRACT_VIAL = ITEMS.register("creation_king_extract_vial",
            () -> new BaseItem(new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_SUN_TAB_ITEM).KeepDifItem(AmazonsRiderItems.EMPTY_VIAL.get()));

    public static final DeferredItem<Item> HEAT_HEAVEN = ITEMS.register("heat_heaven",
            () -> new BaseItem(new Item.Properties().food(Foods.CARROT)).AddToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_SUN_TAB_ITEM));


    public static final DeferredItem<Item> KING_STONE_SUN = ITEMS.register("king_stone_sun",
            () -> new RiderFormChangeItem(new Item.Properties(),"","black_sun","century_king_sun_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                            player.getX(), player.getY()+1,
                            player.getZ(), 300, 0, 0, 0, 0.1);
                }
            }.IsBeltGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_SUN_TAB_ITEM).AddToList(KaijinStoneGenerator.KING_STONE, 10));

    public static final DeferredItem<Item> GLOWING_KING_STONE_SUN = ITEMS.register("glowing_king_stone_sun",
            () -> new RiderFormChangeItem(new Item.Properties(),"_revived","black_sun","century_king_sun_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 0.1);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                            player.getX(), player.getY()+1,
                            player.getZ(), 300, 0, 0, 0, 0.1);
                }
            }.IsBeltGlowing().IsGlowing().ChangeModel("black_sun.geo.json").AddToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_SUN_TAB_ITEM).AddToList(KaijinStoneGenerator.KING_STONE, 1));

    public static final DeferredItem<Item> KING_STONE_MOON = ITEMS.register("king_stone_moon",
            () -> new RiderFormChangeItem(new Item.Properties(),"","shadowmoon","century_king_moon_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                            player.getX(), player.getY()+1,
                            player.getZ(), 300, 0, 0, 0, 0.1);
                }
            }.IsBeltGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_SUN_TAB_ITEM).AddToList(KaijinStoneGenerator.KING_STONE, 5));

    public static final DeferredItem<Item> GLOWING_KING_STONE_MOON = ITEMS.register("glowing_king_stone_moon",
            () -> new RiderFormChangeItem(new Item.Properties(),"_revived","shadowmoon","century_king_moon_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 0.1);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                            player.getX(), player.getY()+1,
                            player.getZ(), 300, 0, 0, 0, 0.1);
                }
            }.IsBeltGlowing().IsGlowing().ChangeModel("shadowmoon.geo.json").AddToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_SUN_TAB_ITEM).AddToList(KaijinStoneGenerator.KING_STONE, 1));


    public static final DeferredItem<Item> BLACKSUNHELMET = ITEMS.register("blacksunhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_SUN_TAB_ITEM));
    public static final DeferredItem<Item> BLACKSUNCHESTPLATE = ITEMS.register("blacksuntroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_SUN_TAB_ITEM));
    public static final DeferredItem<Item> BLACKSUNLEGGINGS = ITEMS.register("blacksunlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_SUN_TAB_ITEM));


    public static final DeferredItem<Item> CENTURY_KING_SUN_DRIVER = ITEMS.register("century_king_sun_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"black_sun",KING_STONE_SUN ,BLACKSUNHELMET,BLACKSUNCHESTPLATE,BLACKSUNLEGGINGS , new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_SUN_TAB_ITEM));

    public static final DeferredItem<Item> CENTURY_KING_MOON_DRIVER = ITEMS.register("century_king_moon_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shadowmoon",KING_STONE_MOON ,BLACKSUNHELMET,BLACKSUNCHESTPLATE,BLACKSUNLEGGINGS , new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_SUN_TAB_ITEM));

    public static final DeferredItem<Item> CENTURY_KING_BLACK_BLADE = ITEMS.register("century_king_black_blade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_SUN_TAB_ITEM));
    public static final DeferredItem<Item> CENTURY_KING_SHADOW_BLADE = ITEMS.register("century_king_shadow_blade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_SUN_TAB_ITEM));
    public static final DeferredItem<Item> SATANSABRE = ITEMS.register("satansabre",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.BLACK_SUN_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
