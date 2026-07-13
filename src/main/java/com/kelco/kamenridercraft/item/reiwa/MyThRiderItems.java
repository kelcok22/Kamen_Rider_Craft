package com.kelco.kamenridercraft.item.reiwa;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
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

public class MyThRiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item> RIDEGG_1 = ITEMS.register("ridegg_1",
            () -> new RiderFormChangeItem(new Item.Properties(),"","my_th","my_th_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().IsBeltGlowing().changeBeltModel("geo/zeztz_riderbelt.geo.json").hasCape().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> MY_TH_HELMET = ITEMS.register("my_th_head",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.MY_TH_TAB_ITEM));
    public static final DeferredItem<Item> MY_TH_CHESTPLATE = ITEMS.register("my_th_troso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.MY_TH_TAB_ITEM));
    public static final DeferredItem<Item> MY_TH_LEGGINGS = ITEMS.register("my_th_legs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.MY_TH_TAB_ITEM));

    public static final DeferredItem<Item> MY_TH_DRIVER = ITEMS.register("my_th_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"my_th",RIDEGG_1 ,MY_TH_HELMET,MY_TH_CHESTPLATE,MY_TH_LEGGINGS , new Item.Properties()).hideBeltFormInfo().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.MY_TH_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
