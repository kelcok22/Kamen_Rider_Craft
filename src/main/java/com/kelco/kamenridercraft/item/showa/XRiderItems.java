package com.kelco.kamenridercraft.item.showa;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.*;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class XRiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item> X_LOGO = ITEMS.register("x_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/x")), new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.X_TAB_ITEM));

    public static final DeferredItem<Item> RIDOL_CORE = ITEMS.register("ridol_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","x","ridol_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.hasSD().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.X_TAB_ITEM));

    public static final DeferredItem<Item> PERFECTER_TACKLE = ITEMS.register("perfecter_tackle",
            () -> new RiderFormChangeItem(new Item.Properties(),"_perfector","tackle","tackle_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.changeModel("tackle.geo.json").hasCape().isGlowing().setShowUnder());

    public static final DeferredItem<Item> PERFECTER = ITEMS.register("perfecter",
            () -> new RiderFormChangeItem(new Item.Properties(),"_perfector","riderman","riderman_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.addAlternative(PERFECTER_TACKLE.get()).isGlowing().setShowUnder().addToList(KamenRiderCraftCore.CreativeTabRegistry.X_TAB_ITEM));

    public static final DeferredItem<Item> APOLLOGIST_CORE = ITEMS.register("apollogeist_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","apollogeist","apollogeist_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.FIRE_RESISTANCE,200, 0,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                }
            }.hasSD().hasCape().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.X_TAB_ITEM));

    public static final DeferredItem<Item> APOLLOGIST_REBORN_CORE = ITEMS.register("apollogeist_reborn_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"_reborn","apollogeist","apollogeist_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.FIRE_RESISTANCE,200, 0,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)
                    ,new MobEffectInstance(EffectCore.FIRE_ARMOR, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 0.1);
                }
            }.hasCape().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.X_TAB_ITEM));


    public static final DeferredItem<Item> XHELMET = ITEMS.register("xhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.X_TAB_ITEM));
    public static final DeferredItem<Item> XCHESTPLATE = ITEMS.register("xtroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.X_TAB_ITEM));
    public static final DeferredItem<Item> XLEGGINGS = ITEMS.register("xlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.X_TAB_ITEM));

    public static final DeferredItem<Item> RIDOL = ITEMS.register("ridol",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"x",RIDOL_CORE ,XHELMET,XCHESTPLATE,XLEGGINGS , new Item.Properties())
                    .hasSDForm().isA1().hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.X_TAB_ITEM));

    public static final DeferredItem<Item> DARK_RIDOL = ITEMS.register("dark_ridol",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_x",RIDOL_CORE ,XHELMET,XCHESTPLATE,XLEGGINGS , new Item.Properties()).hideBeltFormInfo()
                    .overrideBeltText("dark_ridol_belt").AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.X_TAB_ITEM));

    public static final DeferredItem<Item> FAKE_RIDOL = ITEMS.register("fake_ridol",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"fake_x",RIDOL_CORE ,XHELMET,XCHESTPLATE,XLEGGINGS , new Item.Properties()).hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.X_TAB_ITEM));

    public static final DeferredItem<Item> APOLLOGIST_BELT = ITEMS.register("apollogeist_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"apollogeist",APOLLOGIST_CORE ,XHELMET,XCHESTPLATE,XLEGGINGS , new Item.Properties()).hasSDForm().has_basic_model().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.X_TAB_ITEM));


    public static final DeferredItem<Item> RIDOL_STICK = ITEMS.register("ridol_stick",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.X_TAB_ITEM));

    public static final DeferredItem<Item> APOLLO_SHOT = ITEMS.register("apollo_shot",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.X_TAB_ITEM));

    public static final DeferredItem<Item> GEIST_CUTTER = ITEMS.register("geist_cutter",
            () -> new BaseShieldItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.X_TAB_ITEM));

    public static final DeferredItem<Item> GEIST_DOUBLE_CUTTER = ITEMS.register("geist_double_cutter",
            () -> new BaseShieldItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.X_TAB_ITEM));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
