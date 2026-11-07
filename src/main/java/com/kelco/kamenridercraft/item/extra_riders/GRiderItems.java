package com.kelco.kamenridercraft.item.extra_riders;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom.HenshinLineRenderLayerInfo;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.*;
import com.kelco.kamenridercraft.particle.ModParticles;
import com.kelco.kamenridercraft.util.AnimationUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class GRiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item> G_LOGO = ITEMS.register("g_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/g")), new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.G_TAB_ITEM));

    public static final DeferredItem<Item> GORO_WINE_BOTTLE = ITEMS.register("goro_wine_bottle",
            () -> new RiderFormChangeItem(new Item.Properties(),"","kamen_rider_g","g_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick) {
                    super.transformationEffect(itemstack, player, tick);
                    if (tick == 59d&RiderDriverItem.isTransformingFromBlank(itemstack,player)){
                        //AnimationUtil.playPose(player, riderName+".henshin");
                        AnimationUtil.playPose(player, "ryuki.henshin");
                    }
                    if (tick == 34d) player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.PLAYERS, 1.0F, 1F);
                    if (tick == 1d) {
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }}
            }.setFormDelay(1).isGlowing().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.G_TAB_ITEM).keepItem());

    public static final DeferredItem<Item> GHELMET = ITEMS.register("ghead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.G_TAB_ITEM));
    public static final DeferredItem<Item> GCHESTPLATE = ITEMS.register("gtroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.G_TAB_ITEM));
    public static final DeferredItem<Item> GLEGGINGS = ITEMS.register("glegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.G_TAB_ITEM));

    public static final DeferredItem<Item> G_BELT = ITEMS.register("g_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kamen_rider_g",GORO_WINE_BOTTLE ,GHELMET,GCHESTPLATE,GLEGGINGS , new Item.Properties()){
                public double getBaseHenshinTick(ItemStack stack, LivingEntity rider){
                    return 60;
                }
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    super.SetUnlimitedModels(layerInfo, itemStack, rider, slot);
                    if (slot == EquipmentSlot.HEAD) {
                        double henshin_tick = getHenshinTick(itemStack, rider);
                        if (RiderDriverItem.isTransforming(rider)&&henshin_tick<31) {
                            layerInfo.add(new HenshinLineRenderLayerInfo("g_henshin","g_henshin"));
                        }
                    }
                }
            }.hideBeltFormInfo().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.G_TAB_ITEM));

    public static final DeferredItem<Item> G_SOMMELIER_KNIFE = ITEMS.register("g_sommelier_knife",
            () -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.G_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
