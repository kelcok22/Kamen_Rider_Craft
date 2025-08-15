package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
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

public class Zeztz_Rider_Items {

        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

       // public static final DeferredItem<Item> ZEZTZ_LOGO = ITEMS.register("zeztz_logo",() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/hibiki")), new Item.Properties()).AddToList(RiderTabs.ZEZTZ_TAB_ITEM));
        
        public static final DeferredItem<Item> IMPACT_CAPSEM = ITEMS.register("impact_capsem",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","zeztz","zeztz_driver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                        super.OnTransformation(itemstack, player);
                        ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                                player.getX(), player.getY()+1,
                                player.getZ(), 100, 0, 0, 0, 1);
                }
        } .ChangeBeltModel("geo/zeztz_riderbelt.geo.json").IsBeltGlowing().IsGlowing().has_basic_model().AddToList(RiderTabs.ZEZTZ_TAB_ITEM));

        public static final DeferredItem<Item> STREAM_CAPSEM = ITEMS.register("stream_capsem",
                () -> new RiderFormChangeItem(new Item.Properties(),0,"_technolom_stream","zeztz","zeztz_driver_belt_technolom_stream",
                        new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                        new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                        new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
                        public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                                super.OnTransformation(itemstack, player);
                                ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                                        player.getX(), player.getY()+1,
                                        player.getZ(), 100, 0, 0, 0, 1);
                        }
                } .ChangeBeltModel("geo/zeztz_riderbelt.geo.json").IsBeltGlowing().IsGlowing().has_basic_model().AddToList(RiderTabs.ZEZTZ_TAB_ITEM));

        public static final DeferredItem<Item> RECOVERY_CAPSEM = ITEMS.register("recovery_capsem",
                () -> new RiderFormChangeItem(new Item.Properties(),0,"_esprim_recovery","zeztz","zeztz_driver_belt_esprim_recovery",
                        new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                        new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                        new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)) {
                        public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                                super.OnTransformation(itemstack, player);
                                ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                                        player.getX(), player.getY()+1,
                                        player.getZ(), 100, 0, 0, 0, 1);
                        }
                }.ChangeBeltModel("geo/zeztz_riderbelt.geo.json").IsBeltGlowing().IsGlowing().has_basic_model().AddToList(RiderTabs.ZEZTZ_TAB_ITEM));

        public static final DeferredItem<Item> WONDER_CAPSEM = ITEMS.register("wonder_capsem",
                () -> new RiderFormChangeItem(new Item.Properties(),0,"_paradigm_wonder","zeztz","zeztz_driver_belt_paradigm_wonder",
                        new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                        new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                        new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
                        public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                                super.OnTransformation(itemstack, player);
                                ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                                        player.getX(), player.getY()+1,
                                        player.getZ(), 100, 0, 0, 0, 1);
                        }
                }.ChangeBeltModel("geo/zeztz_riderbelt.geo.json").IsBeltGlowing().IsGlowing().has_basic_model().AddToList(RiderTabs.ZEZTZ_TAB_ITEM));

        public static final DeferredItem<Item> ZEZTZ_HELMET = ITEMS.register("zeztz_head",
                () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).has_basic_model().AddToTabList(RiderTabs.ZEZTZ_TAB_ITEM));
        public static final DeferredItem<Item> ZEZTZ_CHESTPLATE = ITEMS.register("zeztz_troso",
                () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).has_basic_model().AddToTabList(RiderTabs.ZEZTZ_TAB_ITEM));
        public static final DeferredItem<Item> ZEZTZ_LEGGINGS = ITEMS.register("zeztz_legs",
                () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).has_basic_model().AddToTabList(RiderTabs.ZEZTZ_TAB_ITEM));

            
        public static final DeferredItem<Item> ZEZTZ_DRIVER = ITEMS.register("zeztz_driver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zeztz", IMPACT_CAPSEM,ZEZTZ_HELMET,ZEZTZ_CHESTPLATE,ZEZTZ_LEGGINGS, new Item.Properties())
                        .has_basic_model().AddToTabList(RiderTabs.ZEZTZ_TAB_ITEM));

        public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
	    
	}