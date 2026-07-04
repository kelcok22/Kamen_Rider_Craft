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


public class JRiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item>  J_LOGO = ITEMS.register("j_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/j")), new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.J_TAB_ITEM));


    public static final DeferredItem<Item>  J_STONE_JUMBO_FORMATION = ITEMS.register("j_stone_jumbo_formation",
            () -> new RiderFormChangeItem(new Item.Properties(),"","j","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)
                    ,new MobEffectInstance(EffectCore.BIG, 40, 2,true,false))
                    .isGlowing().model_has_different_name("j_stone").has_basic_model());

    public static final DeferredItem<Item>  J_STONE = ITEMS.register("j_stone",
            () -> new RiderFormChangeItem(new Item.Properties(),"","j","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false))
            {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.isGlowing().setSlotOneAbility("grow", 2).setSlotTwoAbility("rider_kick", 1).addToList(KamenRiderCraftCore.CreativeTabRegistry.J_TAB_ITEM).KeepItem());


    public static final DeferredItem<Item>  JHELMET = ITEMS.register("jhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.J_TAB_ITEM));
    public static final DeferredItem<Item>  JCHESTPLATE = ITEMS.register("jtroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.J_TAB_ITEM));
    public static final DeferredItem<Item>  JLEGGINGS = ITEMS.register("jlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.J_TAB_ITEM));

    public static final DeferredItem<Item>  J_SPIRIT = ITEMS.register("j_spirit",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"j",J_STONE ,JHELMET,JCHESTPLATE,JLEGGINGS , new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.J_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
