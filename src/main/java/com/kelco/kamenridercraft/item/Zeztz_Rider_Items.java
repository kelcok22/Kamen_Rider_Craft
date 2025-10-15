package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machineBlocks.CapsemDropper;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.TechnolomProjectionEntity;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import com.kelco.kamenridercraft.item.zeztz.CapsemCylinderItem;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Zeztz_Rider_Items {

        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

        public static final DeferredItem<Item> ZEZTZ_LOGO = ITEMS.register("zeztz_logo",() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/zeztz")), new Item.Properties()).AddToList(RiderTabs.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> CODE_CAPSEM = ITEMS.register("code_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","none","zeztz_driver_belt")
                    .has_basic_model().AddToList(RiderTabs.ZEZTZ_TAB_ITEM));


    public static final DeferredItem<Item> IMPACT_CAPSEM = ITEMS.register("impact_capsem",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","zeztz","zeztz_driver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                        super.OnTransformation(itemstack, player);
                        ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                                player.getX(), player.getY()+1,
                                player.getZ(), 100, 0, 0, 0, 1);
                }
        } .ChangeBeltModel("geo/zeztz_riderbelt.geo.json").IsBeltGlowing().IsGlowing().has_basic_model().AddToList(CapsemDropper.CAPSEM,10).AddToList(RiderTabs.ZEZTZ_TAB_ITEM));


    public static final DeferredItem<Item> TRANSFORM_CAPSEM = ITEMS.register("transform_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_physicam_transform","zeztz","zeztz_driver_belt_physicam_transform",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false),
                    new MobEffectInstance(Effect_core.LONG_ARM, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            } .ChangeBeltModel("geo/zeztz_riderbelt.geo.json").IsBeltGlowing().IsGlowing().AddToList(CapsemDropper.CAPSEM,5).has_basic_model().AddToList(RiderTabs.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> WING_CAPSEM = ITEMS.register("wing_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_physicam_wing","zeztz","zeztz_driver_belt_wing",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            } .ChangeBeltModel("geo/zeztz_riderbelt.geo.json").hasStaticWings().IsGlowing().IsBeltGlowing().AddToList(CapsemDropper.CAPSEM,5).has_basic_model().AddToList(RiderTabs.ZEZTZ_TAB_ITEM));


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
                } .ChangeBeltModel("geo/zeztz_riderbelt.geo.json").IsBeltGlowing().IsGlowing().has_basic_model().AddToList(CapsemDropper.CAPSEM,7).AddToList(RiderTabs.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> MACHINERY_CAPSEM = ITEMS.register("machinery_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_technolom_machinery","zeztz","zeztz_driver_belt_technolom_machinery",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            } .ChangeBeltModel("geo/zeztz_riderbelt.geo.json").IsBeltGlowing().IsGlowing().has_basic_model().AddToList(CapsemDropper.CAPSEM,5).AddToList(RiderTabs.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> PROJECTION_CAPSEM = ITEMS.register("projection_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_technolom_projection","zeztz","zeztz_driver_belt_technolom_projection",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                    if (player instanceof Player play) {
                        TechnolomProjectionEntity projection = MobsCore.TECHNOLOM_PROJECTION.get().create(player.level());
                        if (projection != null) {
                            projection.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
                            player.level().addFreshEntity(projection);
                            projection.bindToPlayer(play);
                            projection.addRequiredForm(this, 1);
                        }
                    }
                }
            } .ChangeBeltModel("geo/zeztz_riderbelt.geo.json").IsBeltGlowing().IsGlowing().has_basic_model().AddToList(CapsemDropper.CAPSEM,5).AddToList(RiderTabs.ZEZTZ_TAB_ITEM));


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
                }.ChangeBeltModel("geo/zeztz_riderbelt.geo.json").IsBeltGlowing().IsGlowing().has_basic_model().AddToList(CapsemDropper.CAPSEM,7).AddToList(RiderTabs.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> BARRIER_CAPSEM = ITEMS.register("barrier_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_esprim_barrier","zeztz","zeztz_driver_belt_esprim_barrier",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeBeltModel("geo/zeztz_riderbelt.geo.json").IsBeltGlowing().IsGlowing().has_basic_model().AddToList(CapsemDropper.CAPSEM,5).AddToList(RiderTabs.ZEZTZ_TAB_ITEM));

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
                }.ChangeBeltModel("geo/zeztz_riderbelt.geo.json").IsBeltGlowing().IsGlowing().has_basic_model().AddToList(CapsemDropper.CAPSEM,7).AddToList(RiderTabs.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> GRAVITY_CAPSEM = ITEMS.register("gravity_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_paradigm_gravity","zeztz","zeztz_driver_belt_paradigm_gravity",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeBeltModel("geo/zeztz_riderbelt.geo.json").IsBeltGlowing().IsGlowing().has_basic_model().AddToList(CapsemDropper.CAPSEM,5).AddToList(RiderTabs.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> CAPSEM_CYLINDER = ITEMS.register("capsem_cylinder",
            () -> new CapsemCylinderItem().has_basic_model().AddToList(RiderTabs.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> ZEZTZ_HELMET = ITEMS.register("zeztz_head",
                () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).has_basic_model().ChangeRepairItem(CODE_CAPSEM.get()).AddToTabList(RiderTabs.ZEZTZ_TAB_ITEM));
        public static final DeferredItem<Item> ZEZTZ_CHESTPLATE = ITEMS.register("zeztz_troso",
                () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).has_basic_model().ChangeRepairItem(CODE_CAPSEM.get()).AddToTabList(RiderTabs.ZEZTZ_TAB_ITEM));
        public static final DeferredItem<Item> ZEZTZ_LEGGINGS = ITEMS.register("zeztz_legs",
                () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).has_basic_model().ChangeRepairItem(CODE_CAPSEM.get()).AddToTabList(RiderTabs.ZEZTZ_TAB_ITEM));

            
        public static final DeferredItem<Item> ZEZTZ_DRIVER = ITEMS.register("zeztz_driver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zeztz", IMPACT_CAPSEM,ZEZTZ_HELMET,ZEZTZ_CHESTPLATE,ZEZTZ_LEGGINGS, new Item.Properties())
                        .has_basic_model().ChangeRepairItem(CODE_CAPSEM.get()).AddToTabList(RiderTabs.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> BREAKAM_ZEZTZER_SWORD = ITEMS.register("breakam_zeztzer_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.2F, new Item.Properties()).AddToTabList(RiderTabs.ZEZTZ_TAB_ITEM)
                    .ChangeRepairItem(CODE_CAPSEM.get()));

    public static final DeferredItem<Item> BREAKAM_ZEZTZER_GUN = ITEMS.register("breakam_zeztzer_gun",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZEZTZ_TAB_ITEM)
                    .ChangeRepairItem(CODE_CAPSEM.get()));

    public static final DeferredItem<Item> BREAKAM_ZEZTZER_AXE = ITEMS.register("breakam_zeztzer_axe",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -3.0F, new Item.Properties()).AddToTabList(RiderTabs.ZEZTZ_TAB_ITEM)
                    .ChangeRepairItem(CODE_CAPSEM.get()));

    public static final DeferredItem<Item> BREAKAM_ZEZTZER_SCYTHE = ITEMS.register("breakam_zeztzer_scythe",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.0F, new Item.Properties()).AddToTabList(RiderTabs.ZEZTZ_TAB_ITEM)
                    .ChangeRepairItem(CODE_CAPSEM.get()));

        public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
	    
	}