package com.kelco.kamenridercraft.item.showa;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
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


public class Super1RiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item>  SUPER_1_LOGO = ITEMS.register("super_1_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/super_1")), new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.SUPER1_TAB_ITEM));

    public static final DeferredItem<Item>  CYCLODE_CORE = ITEMS.register("cyclode_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","super_1","cyclode_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.hasSD().hasCape().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.SUPER1_TAB_ITEM));

    public static final DeferredItem<Item>  SUPER1HELMET = ITEMS.register("super_1head",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.SUPER1_TAB_ITEM));
    public static final DeferredItem<Item>  SUPER1CHESTPLATE = ITEMS.register("super_1troso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.SUPER1_TAB_ITEM));
    public static final DeferredItem<Item>  SUPER1LEGGINGS = ITEMS.register("super_1legs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.SUPER1_TAB_ITEM));

    public static final DeferredItem<Item>  CYCLODE = ITEMS.register("cyclode",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"super_1",CYCLODE_CORE ,SUPER1HELMET,SUPER1CHESTPLATE,SUPER1LEGGINGS , new Item.Properties())
                    .hasSDForm().isA1().hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.SUPER1_TAB_ITEM));

    public static final DeferredItem<Item>  ROBOT_CYCLODE = ITEMS.register("robot_cyclode",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"robot_super_1",CYCLODE_CORE ,SUPER1HELMET,SUPER1CHESTPLATE,SUPER1LEGGINGS , new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.SUPER1_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
