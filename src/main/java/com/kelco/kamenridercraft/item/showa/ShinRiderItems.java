package com.kelco.kamenridercraft.item.showa;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.BaseBannerPatternItem;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.reboots.AmazonsRiderItems;
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


public class ShinRiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item>  SHIN_LOGO = ITEMS.register("shin_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/shin")), new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_TAB_ITEM));

    public static final DeferredItem<Item>  SHIN_STONE = ITEMS.register("shin_stone",
            () -> new RiderFormChangeItem(new Item.Properties(),"","shin","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.hasSD().changeModel("ichigo.geo.json").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_TAB_ITEM).KeepItem());

    public static final DeferredItem<Item>  CYBORG_SOLDIER_LEVEL_3_CELL_SAMPLE = ITEMS.register("cyborg_soldier_level_3_cell_sample",
            () -> new RiderFormChangeItem(new Item.Properties(),"","cyborg_soldier_level_3","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeModel("ichigo.geo.json").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_TAB_ITEM).KeepDifItem(AmazonsRiderItems.EMPTY_VIAL.get()));

    public static final DeferredItem<Item>  CYBORG_SOLDIER_LEVEL_2_CORE = ITEMS.register("cyborg_soldier_level_2_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","cyborg_soldier_level_2","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
                    ,new MobEffectInstance(EffectCore.PUNCH, 40, 3,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addToList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_TAB_ITEM));


    public static final DeferredItem<Item>  SHINHELMET = ITEMS.register("shinhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_TAB_ITEM));
    public static final DeferredItem<Item>  SHINCHESTPLATE = ITEMS.register("shintroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_TAB_ITEM));
    public static final DeferredItem<Item>  SHINLEGGINGS = ITEMS.register("shinlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_TAB_ITEM));

    public static final DeferredItem<Item>  GRASSHOPPER_DNA = ITEMS.register("grasshopper_dna",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shin",SHIN_STONE ,SHINHELMET,SHINCHESTPLATE,SHINLEGGINGS , new Item.Properties())
                    .hasSDForm().hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_TAB_ITEM));
    public static final DeferredItem<Item>  CYBORG_SOLDIER_LEVEL_3_DNA = ITEMS.register("cyborg_soldier_level_3_dna",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"cyborg_soldier_level_3",CYBORG_SOLDIER_LEVEL_3_CELL_SAMPLE ,SHINHELMET,SHINCHESTPLATE,SHINLEGGINGS , new Item.Properties())
                    .hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_TAB_ITEM));
    public static final DeferredItem<Item>  CYBORG_SOLDIER_LEVEL_2_DNA = ITEMS.register("cyborg_soldier_level_2_dna",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"cyborg_soldier_level_2",CYBORG_SOLDIER_LEVEL_2_CORE ,SHINHELMET,SHINCHESTPLATE,SHINLEGGINGS , new Item.Properties())
                    .hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.SHIN_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
