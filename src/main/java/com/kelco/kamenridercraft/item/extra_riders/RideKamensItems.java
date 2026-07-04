package com.kelco.kamenridercraft.item.extra_riders;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.summons.ApolloEntity;
import com.kelco.kamenridercraft.entity.mobs.summons.LibraEntity;
import com.kelco.kamenridercraft.item.base_items.*;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RideKamensItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item> CONTRACT_CHAOSTONE = ITEMS.register("contract_chaostone",
            () -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM));

    public static final DeferredItem<Item> CHAOS_RING_SAIGO = ITEMS.register("chaos_ring_saigo",
            () -> new RiderFormChangeItem(new Item.Properties(),"","saigo","chaos_driver_saigo_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsBeltGlowing().setShowFace().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM).KeepItem());

    public static final DeferredItem<Item> CHAOS_RING_HARUMA = ITEMS.register("chaos_ring_haruma",
            () -> new RiderFormChangeItem(new Item.Properties(),"","haruma","chaos_driver_haruma_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsBeltGlowing().setShowFace().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM).KeepItem());

    public static final DeferredItem<Item> CHAOS_RING_SHION = ITEMS.register("chaos_ring_shion",
            () -> new RiderFormChangeItem(new Item.Properties(),"","shion","chaos_driver_shion_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsBeltGlowing().setShowFace().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM).KeepItem());

    public static final DeferredItem<Item> CHAOS_RING_JIGEN = ITEMS.register("chaos_ring_jigen",
            () -> new RiderFormChangeItem(new Item.Properties(),"","jigen","chaos_driver_jigen_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsBeltGlowing().setShowFace().changeModel("haruma.geo.json").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM).KeepItem());

    public static final DeferredItem<Item> CHAOS_RING_ARAKI = ITEMS.register("chaos_ring_araki",
            () -> new RiderFormChangeItem(new Item.Properties(),"","araki","chaos_driver_araki_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 75, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 25, 0, 0, 0, 1);
                }
            }.IsBeltGlowing().setShowFace().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM).KeepItem());

    public static final DeferredItem<Item> CHAOS_RING_KAMUI = ITEMS.register("chaos_ring_kamui",
            () -> new RiderFormChangeItem(new Item.Properties(),"","kamui","chaos_driver_kamui_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsBeltGlowing().setShowFace().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM).KeepItem());

    public static final DeferredItem<Item> CHAOS_RING_AGATA = ITEMS.register("chaos_ring_agata",
            () -> new RiderFormChangeItem(new Item.Properties(),"","agata","chaos_driver_agata_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsBeltGlowing().setShowFace().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM).KeepItem());

    public static final DeferredItem<Item> CHAOS_RING_LOQ_Q = ITEMS.register("chaos_ring_loq_q",
            () -> new RiderFormChangeItem(new Item.Properties(),"_q","loq","chaos_driver_loq_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.setShowFace().isGlowing().IsBeltGlowing().has_basic_model().model_has_different_name("chaos_ring_loq"));

    public static final DeferredItem<Item> CHAOS_RING_LOQ = ITEMS.register("chaos_ring_loq",
            () -> new RiderFormChangeItem(new Item.Properties(),"","loq","chaos_driver_loq_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);

                    if (player instanceof Player play) {
                        ApolloEntity apollo = MobsCore.APOLLO.get().create(player.level());
                        if (apollo != null) {
                            apollo.moveTo(player.getX()-1, player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
                            player.level().addFreshEntity(apollo);
                            apollo.bindToPlayer(play);
                            apollo.addRequiredForm(this, 1);
                        }
                        LibraEntity libra = MobsCore.LIBRA.get().create(player.level());
                        if (libra != null) {
                            libra.moveTo(player.getX()+1, player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
                            player.level().addFreshEntity(libra);
                            libra.bindToPlayer(play);
                            libra.addRequiredForm(this, 1);
                        }
                    }
                }
            }.addSwitchForm(RideKamensItems.CHAOS_RING_LOQ_Q.get()).setShowFace().isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM).KeepItem());


    public static final DeferredItem<Item> RIDE_KAMENS_HELMET = ITEMS.register("ride_kamens_head",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM));
    public static final DeferredItem<Item> RIDE_KAMENS_CHESTPLATE = ITEMS.register("ride_kamens_troso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM));
    public static final DeferredItem<Item> RIDE_KAMENS_LEGGINGS = ITEMS.register("ride_kamens_legs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM));

    public static final DeferredItem<Item> CHAOS_DRIVER_SAIGO = ITEMS.register("chaos_driver_saigo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"saigo",CHAOS_RING_SAIGO ,RIDE_KAMENS_HELMET,RIDE_KAMENS_CHESTPLATE,RIDE_KAMENS_LEGGINGS , new Item.Properties())
                    .hideBeltFormInfo().addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM));

    public static final DeferredItem<Item> CHAOS_DRIVER_HARUMA = ITEMS.register("chaos_driver_haruma",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"haruma",CHAOS_RING_HARUMA ,RIDE_KAMENS_HELMET,RIDE_KAMENS_CHESTPLATE,RIDE_KAMENS_LEGGINGS , new Item.Properties())
                    .hideBeltFormInfo().addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM));

    public static final DeferredItem<Item> CHAOS_DRIVER_SHION = ITEMS.register("chaos_driver_shion",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shion",CHAOS_RING_SHION ,RIDE_KAMENS_HELMET,RIDE_KAMENS_CHESTPLATE,RIDE_KAMENS_LEGGINGS , new Item.Properties())
                    .hideBeltFormInfo().addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM));

    public static final DeferredItem<Item> CHAOS_DRIVER_JIGEN = ITEMS.register("chaos_driver_jigen",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"jigen",CHAOS_RING_JIGEN ,RIDE_KAMENS_HELMET,RIDE_KAMENS_CHESTPLATE,RIDE_KAMENS_LEGGINGS , new Item.Properties())
                    .hideBeltFormInfo().addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM));

    public static final DeferredItem<Item> CHAOS_DRIVER_ARAKI = ITEMS.register("chaos_driver_araki",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"araki",CHAOS_RING_ARAKI ,RIDE_KAMENS_HELMET,RIDE_KAMENS_CHESTPLATE,RIDE_KAMENS_LEGGINGS , new Item.Properties())
                    .hideBeltFormInfo().addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM));

    public static final DeferredItem<Item> CHAOS_DRIVER_KAMUI = ITEMS.register("chaos_driver_kamui",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kamui",CHAOS_RING_KAMUI ,RIDE_KAMENS_HELMET,RIDE_KAMENS_CHESTPLATE,RIDE_KAMENS_LEGGINGS , new Item.Properties())
                    .hideBeltFormInfo().addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM));

    public static final DeferredItem<Item> CHAOS_DRIVER_AGATA = ITEMS.register("chaos_driver_agata",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"agata",CHAOS_RING_AGATA ,RIDE_KAMENS_HELMET,RIDE_KAMENS_CHESTPLATE,RIDE_KAMENS_LEGGINGS , new Item.Properties())
                    .hideBeltFormInfo().addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM));

    public static final DeferredItem<Item> CHAOS_DRIVER_LOQ = ITEMS.register("chaos_driver_loq",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"loq",CHAOS_RING_LOQ ,RIDE_KAMENS_HELMET,RIDE_KAMENS_CHESTPLATE,RIDE_KAMENS_LEGGINGS , new Item.Properties())
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM));

    public static final DeferredItem<Item> GASHA_TICKET = ITEMS.register("gasha_ticket",
            () -> new BaseDropItem(new Item.Properties(), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/gasha_ticket")).addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM));

    public static final DeferredItem<Item> CANDY = ITEMS.register("candy",
            () -> new BaseItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).fast().saturationModifier(0.8f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 500, 0), 1.0F).build()))
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM));

    public static final DeferredItem<Item> ENERGY_DRINK = ITEMS.register("energy_drink",
            () -> new BaseItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).fast().saturationModifier(0.8f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 2), 1.0F).build()))
                    .SetItemAnimation(UseAnim.DRINK).addToList(KamenRiderCraftCore.CreativeTabRegistry.RIDE_KAMENS_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
