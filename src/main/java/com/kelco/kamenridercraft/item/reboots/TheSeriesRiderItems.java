package com.kelco.kamenridercraft.item.reboots;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
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


public class TheSeriesRiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item> THE_TYPHOON_CORE = ITEMS.register("the_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"_first","ichigo_the","typhoon_belt_the_first",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeModel("ichigo.geo.json").allowRiderKick().isGlowing().has_basic_model().model_has_different_name("typhoon_core").addToList(KamenRiderCraftCore.CreativeTabRegistry.THE_TAB_ITEM));

    public static final DeferredItem<Item> THE_TYPHOON_CORE_NEXT = ITEMS.register("the_next_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"_next","ichigo_the","typhoon_belt_the_first",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeModel("ichigo.geo.json").allowRiderKick().isGlowing().has_basic_model().model_has_different_name("typhoon_core").addToList(KamenRiderCraftCore.CreativeTabRegistry.THE_TAB_ITEM));

    public static final DeferredItem<Item> THE_TYPHOON_CORE_NIGO = ITEMS.register("the_typhoon_core_nigo",
            () -> new RiderFormChangeItem(new Item.Properties(),"","nigo_the_first","typhoon_belt_the_first_nigo",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.THE_TAB_ITEM));

    public static final DeferredItem<Item> THE_DOUBLE_TYPHOON_CORE = ITEMS.register("the_double_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","v3_the_next","double_typhoon_belt_the_next",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().isGlowing().hasCape().addToList(KamenRiderCraftCore.CreativeTabRegistry.THE_TAB_ITEM));

    public static final DeferredItem<Item> THE_ICHIGO_HELMET = ITEMS.register("the_ichigo_head",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.THE_TAB_ITEM));
    public static final DeferredItem<Item> THE_ICHIGO_CHESTPLATE = ITEMS.register("the_ichigo_troso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.THE_TAB_ITEM));
    public static final DeferredItem<Item> THE_ICHIGO_LEGGINGS = ITEMS.register("the_ichigo_legs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.THE_TAB_ITEM));


    public static final DeferredItem<Item> THE_TYPHOON_ICHIGO = ITEMS.register("the_typhoon_ichigo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ichigo_the",THE_TYPHOON_CORE ,THE_ICHIGO_HELMET, THE_ICHIGO_CHESTPLATE,THE_ICHIGO_LEGGINGS , new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.THE_TAB_ITEM));

    public static final DeferredItem<Item> THE_TYPHOON_NIGO = ITEMS.register("the_typhoon_nigo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"nigo_the_first",THE_TYPHOON_CORE_NIGO ,THE_ICHIGO_HELMET, THE_ICHIGO_CHESTPLATE,THE_ICHIGO_LEGGINGS , new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.THE_TAB_ITEM));

    public static final DeferredItem<Item> THE_DOUBLE_TYPHOON = ITEMS.register("the_double_typhoon",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"v3_the_next",THE_DOUBLE_TYPHOON_CORE ,THE_ICHIGO_HELMET, THE_ICHIGO_CHESTPLATE,THE_ICHIGO_LEGGINGS , new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.THE_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
