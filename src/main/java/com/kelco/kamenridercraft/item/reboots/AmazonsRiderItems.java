package com.kelco.kamenridercraft.item.reboots;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machineBlocks.AmazonCellExtractor;
import com.kelco.kamenridercraft.block.machineBlocks.AmazonCellMutator;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.*;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;



public class AmazonsRiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

    public static final DeferredItem<Item> EMPTY_VIAL = ITEMS.register("empty_vial",
            () -> new BaseItem(new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> AMAZON_CELL_VIAL = ITEMS.register("amazon_cell_vial",
            () -> new BaseItem(new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM).AddToList(AmazonCellExtractor.CELL_EXTRACTOR, 5).KeepDifItem(EMPTY_VIAL.get()));

    public static final DeferredItem<Item> OMEGA_AMAZON_CELL_VIAL = ITEMS.register("omega_amazon_cell_vial",
            () -> new RiderFormChangeItem(new Item.Properties(),"_origin","amazon_omega","blank",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeModel("amazon_sigma.geo.json").AddToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM).AddToList(AmazonCellMutator.AMAZON_CELL, 5).KeepDifItem(EMPTY_VIAL.get()));

    public static final DeferredItem<Item> ALPHA_AMAZON_CELL_VIAL = ITEMS.register("alpha_amazon_cell_vial",
            () -> new RiderFormChangeItem(new Item.Properties(),"_origin","amazon_alpha","blank",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeModel("amazon_alpha.geo.json").AddToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM).AddToList(AmazonCellMutator.AMAZON_CELL, 5).KeepDifItem(EMPTY_VIAL.get()));

    public static final DeferredItem<Item> SIGMA_AMAZON_CELL_VIAL = ITEMS.register("sigma_amazon_cell_vial",
            () -> new RiderFormChangeItem(new Item.Properties(),"_origin","amazon_sigma","blank",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeModel("amazon_sigma.geo.json").AddToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM).AddToList(AmazonCellMutator.AMAZON_CELL, 2).KeepDifItem(EMPTY_VIAL.get()));

    public static final DeferredItem<Item> NEO_AMAZON_CELL_VIAL = ITEMS.register("neo_amazon_cell_vial",
            () -> new BaseItem(new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM).AddToList(AmazonCellMutator.AMAZON_CELL, 1).KeepDifItem(EMPTY_VIAL.get()));

    public static final DeferredItem<Item> CONDORER_CORE_ALPHA = ITEMS.register("condorer_core_alpha",
            () -> new RiderFormChangeItem(new Item.Properties(),"","amazon_alpha","amazons_driver_alpha_belt",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 4,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,200, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsBeltGlowing().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM));

    public static final DeferredItem<Item> CONDORER_CORE_ALPHA_BLIND = ITEMS.register("condorer_core_alpha_blind",
            () -> new RiderFormChangeItem(new Item.Properties(),"_blind","amazon_alpha","amazons_driver_alpha_belt",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 6,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,200, 2,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.BLINDNESS, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeModel("amazon_alpha.geo.json").IsBeltGlowing().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM));

    public static final DeferredItem<Item> CONDORER_CORE_OMEGA = ITEMS.register("condorer_core_omega",
            () -> new RiderFormChangeItem(new Item.Properties(),"","amazon_omega","amazons_driver_omega_belt",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 3,true,false)
                    ,new MobEffectInstance(MobEffects.REGENERATION,200, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsBeltGlowing().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM));

    public static final DeferredItem<Item> CONDORER_CORE_SIGMA = ITEMS.register("condorer_core_sigma",
            () -> new RiderFormChangeItem(new Item.Properties(),"","amazon_sigma","amazons_driver_sigma_belt",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 6,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,200, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsBeltGlowing().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM));

    public static final DeferredItem<Item> AMAZON_INJECTOR_NEO = ITEMS.register("amazon_injector_neo",
            () -> new RiderFormChangeItem(new Item.Properties(),"","amazon_neo","neo_amazons_driver_neo_belt",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 6,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,200, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)
                    ,new MobEffectInstance(MobEffects.REGENERATION,200, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsBeltGlowing().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM));

    public static final DeferredItem<Item> AMAZON_INJECTOR_NEW_OMEGA = ITEMS.register("amazon_injector_new_omega",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"","amazon_alpha","neo_amazons_driver_omega_belt",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 7,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,200, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.REGENERATION,200, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 30, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 70, 0, 0, 0, 1);
                }
            }.IsBeltGlowing().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM));

    public static final DeferredItem<Item> AMAZON_INJECTOR_NEO_ALPHA = ITEMS.register("amazon_injector_neo_alpha",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"","amazon_neo_alpha","neo_amazons_driver_neo_belt",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 7,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,200, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.REGENERATION,200, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsBeltGlowing().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM));


    public static final DeferredItem<Item> AMAZONSHELMET = ITEMS.register("amazonshead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM));
    public static final DeferredItem<Item> AMAZONSCHESTPLATE = ITEMS.register("amazonstroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM));
    public static final DeferredItem<Item> AMAZONSLEGGINGS = ITEMS.register("amazonslegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM));

    public static final DeferredItem<Item> AMAZONS_DRIVER_ALPHA = ITEMS.register("amazons_driver_alpha",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"amazon_alpha",CONDORER_CORE_ALPHA ,AMAZONSHELMET,AMAZONSCHESTPLATE,AMAZONSLEGGINGS , new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM));

    public static final DeferredItem<Item> AMAZONS_DRIVER_OMEGA = ITEMS.register("amazons_driver_omega",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"amazon_omega",CONDORER_CORE_OMEGA ,AMAZONSHELMET,AMAZONSCHESTPLATE,AMAZONSLEGGINGS , new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM));

    public static final DeferredItem<Item> AMAZONS_DRIVER_SIGMA = ITEMS.register("amazons_driver_sigma",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"amazon_sigma",CONDORER_CORE_SIGMA ,AMAZONSHELMET,AMAZONSCHESTPLATE,AMAZONSLEGGINGS , new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM));

    public static final DeferredItem<Item> NEO_AMAZONS_DRIVER_OMEGA = ITEMS.register("neo_amazons_driver_omega",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"amazon_new_omega",AMAZON_INJECTOR_NEW_OMEGA ,AMAZONSHELMET,AMAZONSCHESTPLATE,AMAZONSLEGGINGS , new Item.Properties()).Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM));

    public static final DeferredItem<Item> NEO_AMAZONS_DRIVER_NEO = ITEMS.register("neo_amazons_driver_neo",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"amazon_neo",AMAZON_INJECTOR_NEO ,AMAZONSHELMET,AMAZONSCHESTPLATE,AMAZONSLEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON)).Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM));

    public static final DeferredItem<Item> NEO_AMAZONS_DRIVER_NEO_ALPHA = ITEMS.register("neo_amazons_driver_neo_alpha",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"amazon_neo_alpha",AMAZON_INJECTOR_NEO_ALPHA ,AMAZONSHELMET,AMAZONSCHESTPLATE,AMAZONSLEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON)).Dont_show_belt_form_info().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM));

    public static final DeferredItem<Item> AMAZON_BLADE = ITEMS.register("amazon_blade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM).ChangeRepairItem(AMAZON_CELL_VIAL.get()));
    public static final DeferredItem<Item> AMAZON_SCYTHE = ITEMS.register("amazon_scythe",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM).ChangeRepairItem(AMAZON_CELL_VIAL.get()));
    public static final DeferredItem<Item> AMAZON_WHIP = ITEMS.register("amazon_whip",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2F, new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM).ChangeRepairItem(AMAZON_CELL_VIAL.get()));
    public static final DeferredItem<Item> AMAZON_SPEAR = ITEMS.register("amazon_spear",
            () -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.AMAZONS_TAB_ITEM).ChangeRepairItem(AMAZON_CELL_VIAL.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
