package com.kelco.kamenridercraft.item.showa;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.*;
import com.kelco.kamenridercraft.item.showa.V3.DrillArmItem;
import com.kelco.kamenridercraft.item.showa.V3.V3HopperItem;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class V3RiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item> V3_LOGO = ITEMS.register("v3_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/v3")), new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));
    public static final DeferredItem<Item> RIDERMAN_LOGO = ITEMS.register("riderman_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/riderman")), new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));

    public static final DeferredItem<Item> DOUBLE_TYPHOON_CORE = ITEMS.register("double_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","v3","double_typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.hasSD().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));

    public static final DeferredItem<Item> BLUE_DOUBLE_TYPHOON_CORE = ITEMS.register("blue_double_typhoon_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"_blue","v3","double_typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT,player.level());
                    thunder.setVisualOnly(true);
                    thunder.setPos( player.getX(),  -1 + player.getY(),  player.getZ() );
                    player.level().addFreshEntity(thunder);

                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeModel("v3.geo.json").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));

    public static final DeferredItem<Item> RIDERMAN_BELT_CORE = ITEMS.register("riderman_belt_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","riderman","riderman_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.hasSD().isGlowing().setShowFace().addToList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));

    public static final DeferredItem<Item> V3HELMET = ITEMS.register("v3head",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));
    public static final DeferredItem<Item> V3CHESTPLATE = ITEMS.register("v3troso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));
    public static final DeferredItem<Item> V3LEGGINGS = ITEMS.register("v3legs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));

    public static final DeferredItem<Item> DOUBLE_TYPHOON = ITEMS.register("double_typhoon",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"v3",DOUBLE_TYPHOON_CORE ,V3HELMET,V3CHESTPLATE,V3LEGGINGS , new Item.Properties())
                    .hasSDForm().isA1().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));

    public static final DeferredItem<Item> RIDERMAN_BELT = ITEMS.register("riderman_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"riderman",RIDERMAN_BELT_CORE ,V3HELMET,V3CHESTPLATE,V3LEGGINGS , new Item.Properties()).isA1()
                    .hasSDForm().overrideBeltText("riderman_belt").AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));

    public static final DeferredItem<Item> DARK_DOUBLE_TYPHOON = ITEMS.register("dark_double_typhoon",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_v3",DOUBLE_TYPHOON_CORE ,V3HELMET,V3CHESTPLATE,V3LEGGINGS , new Item.Properties()).hideBeltFormInfo()
                    .overrideBeltText("dark_double_typhoon_belt").AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));

    public static final DeferredItem<Item> DARK_RIDERMAN_BELT = ITEMS.register("dark_riderman_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_riderman",RIDERMAN_BELT_CORE ,V3HELMET,V3CHESTPLATE,V3LEGGINGS , new Item.Properties()).hideBeltFormInfo()
                    .overrideBeltText("dark_riderman_belt").AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));

    public static final DeferredItem<Item> FAKE_DOUBLE_TYPHOON = ITEMS.register("fake_double_typhoon",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"fake_v3",DOUBLE_TYPHOON_CORE ,V3HELMET,V3CHESTPLATE,V3LEGGINGS , new Item.Properties()).isA1().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM).has_basic_model());

    public static final DeferredItem<Item> ROPE_ARM = ITEMS.register("rope_arm",
            () -> new BaseSwordItem(Tiers.DIAMOND, 2, -2.6F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));

    public static final DeferredItem<Item> POWER_ARM = ITEMS.register("power_arm",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.0F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));

    public static final DeferredItem<Item> DRILL_ARM = ITEMS.register("drill_arm",
            () -> new DrillArmItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));

    public static final DeferredItem<Item> MACHINE_GUN_ARM = ITEMS.register("machine_gun_arm",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));

    public static final DeferredItem<Item> CUTTER_ARM = ITEMS.register("cutter_arm",
            () -> new BaseSwordItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));

    public static final DeferredItem<Item> V3_HOPPER = ITEMS.register("v3_hopper",
            () -> new V3HopperItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.V3_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
