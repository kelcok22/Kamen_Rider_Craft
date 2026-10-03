package com.kelco.kamenridercraft.item.heisei_phase_2;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machine.AstroswitchProgrammer;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom.*;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.*;
import com.kelco.kamenridercraft.item.heisei_phase_1.DecadeRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.Fourze.AstroswitchCaseItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.Fourze.FourzeDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.Fourze.GateSwitchItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.Fourze.ShowaSwitchItem;
import com.kelco.kamenridercraft.item.showa.IchigoRiderItems;
import com.kelco.kamenridercraft.item.showa.V3RiderItems;
import com.kelco.kamenridercraft.particle.ModParticles;
import com.kelco.kamenridercraft.util.AnimationUtil;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class FourzeRiderItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item> FOURZE_LOGO = ITEMS.register("fourze_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/fourze")), new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> BLANK_ASTROSWITCH = ITEMS.register("astroswitch",
            () -> new BaseItem(new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));


    public static final DeferredItem<Item> FOURZE_BASE_STATES = ITEMS.register("fourze_basestates",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick) {
                    super.transformationEffect(itemstack, player, tick);
                    if(RiderDriverItem.isTransformingFromBlank(itemstack,player)){
                    if (tick == 30d) {
                        AnimationUtil.playPose(player, "fourze.henshin");
                        player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.STONE_STEP, SoundSource.PLAYERS, 1.0F, 8F);
                    } else if (tick == 10d) {
                        ((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                                player.getX(), player.getY() + 0.5,
                                player.getZ(), 100, 0, 0, 0, 0.05);
                        ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                                player.getX(), player.getY() + 1,
                                player.getZ(), 7, 0, 0, 0, 0.05);
                        ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                                player.getX(), player.getY() + 1,
                                player.getZ(), 7, 0, 0, 0, 0.05);
                        ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                                player.getX(), player.getY() + 1,
                                player.getZ(), 7, 0, 0, 0, 0.05);
                        ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                                player.getX(), player.getY() + 1,
                                player.getZ(), 7, 0, 0, 0, 0.05);
                    }
                    }
                }
            }.setFormDelay(10).changeSlot(5).setModelName("astroswitch").useBasicModel());

    public static final DeferredItem<Item> FOURZE_ELEK_STATES = ITEMS.register("fourze_elekstates",
            () -> new RiderFormChangeItem(new Item.Properties(), "_elek", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false)
                    , new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 0.1);
                    LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT, player.level());
                    thunder.setVisualOnly(true);
                    thunder.setPos(player.getX(), -1 + player.getY(), player.getZ());
                    player.level().addFreshEntity(thunder);

                }
            }.isGold().changeSlot(5).setModelName("astroswitch").useBasicModel());

    public static final DeferredItem<Item> FOURZE_FIRE_STATES = ITEMS.register("fourze_firestates",
            () -> new RiderFormChangeItem(new Item.Properties(), "_fire", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false)
                    , new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false)
                    , new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 0.1);
                }
            }.changeSlot(5).setModelName("astroswitch").useBasicModel());

    public static final DeferredItem<Item> FOURZE_MAGNET_STATES = ITEMS.register("fourze_magnetstates",
            () -> new RiderFormChangeItem(new Item.Properties(), "_magnet", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2, true, false)) {

                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new MagnetCannonRenderLayerInfo("fourze_magnet", "module/fourze_magnet_cannon"));
                }

                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 0.1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 50, 0, 0, 0, 0.1);

                }
            }.setSlotOneAbility("cannon", 1).changeSlot(5).setModelName("astroswitch").useBasicModel());

    public static final DeferredItem<Item> FOURZE_COSMIC_STATES = ITEMS.register("fourze_cosmicstates",
            () -> new RiderFormChangeItem(new Item.Properties(), "_cosmic", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.COSMIC_ENERGY, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1, true, false)
                    , new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 300, 0, 0, 0, 0.1);

                }
            }.changeSlot(5).setModelName("astroswitch").useBasicModel());

    public static final DeferredItem<Item> FOURZE_ROCKET_STATES = ITEMS.register("fourze_rocketstates",
            () -> new RiderFormChangeItem(new Item.Properties(), "_rocket", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                            player.getX(), player.getY() + 0.5,
                            player.getZ(), 100, 0, 0, 0, 0.05);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 0.05);

                }
            }.changeSlot(5).setModelName("astroswitch").useBasicModel());

    public static final DeferredItem<Item> FOURZE_LAUNCHER_STATES = ITEMS.register("fourze_launcherstates",
            () -> new RiderFormChangeItem(new Item.Properties(), "_launcher", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false)) {

                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                            player.getX(), player.getY() + 0.5,
                            player.getZ(), 100, 0, 0, 0, 0.05);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 0.05);

                }
            }.changeSlot(5).setModelName("astroswitch").useBasicModel());

    public static final DeferredItem<Item> FOURZE_FUSION_STATES = ITEMS.register("fourze_meteor_fusionstates",
            () -> new RiderFormChangeItem(new Item.Properties(), "_meteor_fusion", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.COSMIC_ENERGY, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2, true, false)
                    , new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 150, 0, 0, 0, 0.05);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 150, 0, 0, 0, 0.05);
                }
            }.changeSlot(5).setModelName("astroswitch").useBasicModel());

    public static final DeferredItem<Item> FOURZE_METEOR_NADESHIKO_FUSION_STATES = ITEMS.register("fourze_meteor_nadeshiko_fusionstates",
            () -> new RiderFormChangeItem(new Item.Properties(), "_meteor_nadeshiko_fusion", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.COSMIC_ENERGY, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2, true, false)
                    , new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 150, 0, 0, 0, 0.05);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 150, 0, 0, 0, 0.05);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RANDOM_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 0.05);

                }
            }
                    .changeSlot(5).setModelName("astroswitch").useBasicModel());

    public static final DeferredItem<Item> FOURZE_ROCKET_DRILL_STATES = ITEMS.register("fourze_rocketdrillstates",
            () -> new RiderFormChangeItem(new Item.Properties(), "_rocket_drill", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 0.05);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 0.05);

                }
            }.changeSlot(5).setModelName("astroswitch").useBasicModel());

    public static final DeferredItem<Item> BLANK_CIRCLE_ASTROSWITCH = ITEMS.register("circle_astroswitch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt") {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_module_circle", "default"));
                }
            }.setModelName("astroswitch").useBasicModel());

    public static final DeferredItem<Item> BLANK_CROSS_ASTROSWITCH = ITEMS.register("cross_astroswitch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt")
                    .changeSlot(2).setModelName("astroswitch").useBasicModel());

    public static final DeferredItem<Item> BLANK_TRIANGLE_ASTROSWITCH = ITEMS.register("triangle_astroswitch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt")
                    .changeSlot(3).setModelName("astroswitch").useBasicModel());

    public static final DeferredItem<Item> BLANK_SQUARE_ASTROSWITCH = ITEMS.register("square_astroswitch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt") {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        if (RiderDriverItem.getFormItem(itemStack, 5) == FOURZE_COSMIC_STATES.asItem())
                            layerInfo.add(new RenderLayerInfo("module/fourze_cosmic_module_square", "default"));
                        else layerInfo.add(new RenderLayerInfo("module/fourze_module_square", "default"));
                    }
                }
            }.changeSlot(4).setModelName("astroswitch").useBasicModel());


    public static final DeferredItem<Item> NADESHIKO_ROCKET_ASTROSWITCH = ITEMS.register("rocket_nadeshiko_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "nadeshiko", "nadeshiko_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)
                    , new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false)
                    , new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false)
                    , new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)
                    , new MobEffectInstance(EffectCore.BOOST, 40, 0, true, false)){
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        layerInfo.add(new RocketRenderLayerInfo("module/fourze_rocket_module", "module/fourze_rocket_module"));
                    }
                }
            }.changeBeltModel("geo/belts/eins_belt.geo.json").isGlowing().setModelName("rocket_switch").useBasicModel());

    public static final DeferredItem<Item> ROCKET_ASTROSWITCH = ITEMS.register("rocket_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt"
                    , new MobEffectInstance(EffectCore.BOOST, 40, 0, true, false)) {

                public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick) {
                    super.transformationEffect(itemstack, player, tick);
                    if(RiderDriverItem.wasSlotChanged(itemstack,1)){
                        if (tick == 30d) {
                            AnimationUtil.playPose(player, "kabuto.pose");
                            player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.UI_BUTTON_CLICK, SoundSource.PLAYERS, 1.0F, 8F);
                            ((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                                    player.getX(), player.getY() + 0.5,
                                    player.getZ(), 100, 0, 0, 0, 0.05);
                            ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                                    player.getX(), player.getY() + 1,
                                    player.getZ(), 7, 0, 0, 0, 0.05);
                        }
                    }
                }
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        layerInfo.add(new RocketRenderLayerInfo("module/fourze_rocket_module", "module/fourze_rocket_module"));
                    }
                }
            }.setSlotTwoAbility("fourze_kick", 0).addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).addAlternative(NADESHIKO_ROCKET_ASTROSWITCH.get())
                    .addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM)
                    .addToList(AstroswitchProgrammer.ASTROSWITCH, 20));


    public static final DeferredItem<Item> LAUNCHER_ASTROSWITCH = ITEMS.register("launcher_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt") {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_launcher_module", "default"));
                }
            }.setSlotTwoAbility("cannon", 1).changeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 20));

    public static final DeferredItem<Item> DRILL_ASTROSWITCH = ITEMS.register("drill_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.DRILL, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD){
                        layerInfo.add(new DrillRenderLayerInfo("module/fourze_drill_module", "module/fourze_drill_module"));
                    }
                }
            }.changeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 20));

    public static final DeferredItem<Item> RADAR_ASTROSWITCH = ITEMS.register("radar_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.RADAR, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        if (RiderDriverItem.getFormItem(itemStack, 5) == FOURZE_COSMIC_STATES.asItem())
                            layerInfo.add(new RenderLayerInfo("module/fourze_cosmic_module_square", "default"));
                        else layerInfo.add(new RenderLayerInfo("module/fourze_module_square", "default"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_radar_module", "default"));
                    }
                }
            }.changeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 20));

    public static final DeferredItem<Item> MAGIC_HAND_ASTROSWITCH = ITEMS.register("magic_hand_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt"
                    , new MobEffectInstance(EffectCore.LONG_ARM, 40, 2, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        layerInfo.add(new MagichandRenderLayerInfo("module/fourze_magichand_module", "module/fourze_magichand_module"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_module_circle", "default"));
                    }
                }
            }.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 15));

    public static final DeferredItem<Item> CAMERA_ASTROSWITCH = ITEMS.register("camera_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        layerInfo.add(new RenderLayerInfo("module/fourze_camera_module", "default"));
                        if (RiderDriverItem.getFormItem(itemStack, 5) == FOURZE_COSMIC_STATES.asItem())
                            layerInfo.add(new RenderLayerInfo("module/fourze_cosmic_module_square", "default"));
                        else layerInfo.add(new RenderLayerInfo("module/fourze_module_square", "default"));
                    }
                }
            }.changeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 15));

    public static final DeferredItem<Item> PARACHUTE_ASTROSWITCH = ITEMS.register("parachute_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.SLOW_FALLING, 40, 6, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        if (RiderDriverItem.getFormItem(itemStack, 5) == FOURZE_COSMIC_STATES.asItem())
                            layerInfo.add(new RenderLayerInfo("module/fourze_cosmic_module_square", "default"));
                        else layerInfo.add(new RenderLayerInfo("module/fourze_module_square", "default"));
                        layerInfo.add(new ParachuteRenderLayerInfo("module/fourze_parachute_module", "module/fourze_parachute_module"));
                    }
                }
            }.changeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 15));

    public static final DeferredItem<Item> CHAINSAW_ASTROSWITCH = ITEMS.register("chainsaw_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_chainsaw_module", "module/fourze_chainsaw_module"));
                }
            }.changeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 15));

    public static final DeferredItem<Item> HOPPING_ASTROSWITCH = ITEMS.register("hopping_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.JUMP, 40, 5, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_hopping_module", "default"));
                }
            }.changeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 15));

    public static final DeferredItem<Item> ELEK_ASTROSWITCH = ITEMS.register("elek_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "_elek_module", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.THUNDER_SLASH, 40, 0, true, false))
                    .alsoChange5thSlot(FOURZE_ELEK_STATES.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 15));

    public static final DeferredItem<Item> SCISSORS_ASTROSWITCH = ITEMS.register("scissors_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.SLASH, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        if (RiderDriverItem.getFormItem(itemStack, 5) == FOURZE_COSMIC_STATES.asItem())
                            layerInfo.add(new RenderLayerInfo("module/fourze_cosmic_module_square", "default"));
                        else layerInfo.add(new RenderLayerInfo("module/fourze_module_square", "default"));
                        layerInfo.add(new ScissorsRenderLayerInfo("module/fourze_scissors_module", "module/fourze_scissors_module"));
                    }
                }
            }.changeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 10));

    public static final DeferredItem<Item> BEAT_ASTROSWITCH = ITEMS.register("beat_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.NOTE, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_beat_module", "default"));
                }
            }.changeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 10));

    public static final DeferredItem<Item> CHAIN_ARRAY_ASTROSWITCH = ITEMS.register("chain_array_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt"
                    , new MobEffectInstance(EffectCore.PUNCH, 40, 5, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        layerInfo.add(new ChainArrayRenderLayerInfo("module/fourze_chain_array_module", "module/fourze_chain_array_module"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_module_circle", "default"));
                    }
                }
            }.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 10));

    public static final DeferredItem<Item> SMOKE_ASTROSWITCH = ITEMS.register("smoke_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.SMOKE, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_smoke_module", "default"));
                }
            }.changeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 10));

    public static final DeferredItem<Item> SPIKE_ASTROSWITCH = ITEMS.register("spike_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.REFLECT, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_spike_module", "module/fourze_spike_module"));
                }
            }.changeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 10));

    public static final DeferredItem<Item> WINCH_ASTROSWITCH = ITEMS.register("winch_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.LONG_ARM, 40, 3, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        if (RiderDriverItem.getFormItem(itemStack, 5) == FOURZE_COSMIC_STATES.asItem())
                            layerInfo.add(new RenderLayerInfo("module/fourze_cosmic_module_square", "default"));
                        else layerInfo.add(new RenderLayerInfo("module/fourze_module_square", "default"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_winch_module", "module/fourze_winch_module"));
                    }
                }
            }.changeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 10));

    public static final DeferredItem<Item> FLASH_ASTROSWITCH = ITEMS.register("flash_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt"
                    , new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        layerInfo.add(new RenderLayerInfo("module/fourze_flash_module", "module/fourze_flash_module", "module/fourze_flash_module_glowmask"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_module_circle", "default"));
                    }
                }
            }.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 10));

    public static final DeferredItem<Item> SHIELD_ASTROSWITCH = ITEMS.register("shield_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        if (RiderDriverItem.getFormItem(itemStack, 5) == FOURZE_COSMIC_STATES.asItem())
                            layerInfo.add(new RenderLayerInfo("module/fourze_cosmic_module_square", "default"));
                        else layerInfo.add(new RenderLayerInfo("module/fourze_module_square", "default"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_shield_module", "default"));
                    }
                }
            }.changeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 10));

    public static final DeferredItem<Item> GATLING_ASTROSWITCH = ITEMS.register("gatling_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt") {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_gatling_module", "module/fourze_gatling_module"));
                }
            }.setSlotOneAbility("gatling", 1).changeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 10));

    public static final DeferredItem<Item> FIRE_ASTROSWITCH = ITEMS.register("fire_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.FIRE_SHOT, 40, 0, true, false))
                    .alsoChange5thSlot(FOURZE_FIRE_STATES.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 10));

    public static final DeferredItem<Item> STEALTH_ASTROSWITCH = ITEMS.register("stealth_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.STEALTH, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_stealth_module", "default"));
                }
            }.changeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 5));

    public static final DeferredItem<Item> HAMMER_ASTROSWITCH = ITEMS.register("hammer_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.SLASH, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        if (RiderDriverItem.getFormItem(itemStack, 5) == FOURZE_COSMIC_STATES.asItem())
                            layerInfo.add(new RenderLayerInfo("module/fourze_cosmic_module_square", "default"));
                        else layerInfo.add(new RenderLayerInfo("module/fourze_module_square", "default"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_hammer_module", "default"));
                    }
                }
            }.changeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 5));

    public static final DeferredItem<Item> WATER_ASTROSWITCH = ITEMS.register("water_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_water_module", "default"));
                }
            }.changeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 5));

    public static final DeferredItem<Item> MEDICAL_ASTROSWITCH = ITEMS.register("medical_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.ANTIPOISON, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        if (RiderDriverItem.getFormItem(itemStack, 5) == FOURZE_COSMIC_STATES.asItem())
                            layerInfo.add(new RenderLayerInfo("module/fourze_cosmic_module_square", "default"));
                        else layerInfo.add(new RenderLayerInfo("module/fourze_module_square", "default"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_medical_module", "default"));
                    }
                }
            }.changeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 5));

    public static final DeferredItem<Item> PEN_ASTROSWITCH = ITEMS.register("pen_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.SMOKE, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_pen_module", "default"));
                }
            }.changeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 5));

    public static final DeferredItem<Item> WHEEL_ASTROSWITCH = ITEMS.register("wheel_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new WheelRenderLayerInfo("module/fourze_wheel_module", "module/fourze_wheel_module"));
                }
            }.changeSlot(3).isBike().addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 5));

    public static final DeferredItem<Item> SCREW_ASTROSWITCH = ITEMS.register("screw_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.SWIFT_SWIM, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new ScrewRenderLayerInfo("module/fourze_screw_module", "module/fourze_screw_module"));
                }
            }.changeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 5));

    public static final DeferredItem<Item> HAND_ASTROSWITCH = ITEMS.register("hand_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.LONG_ARM, 40, 5, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new HandRenderLayerInfo("module/fourze_hand_module", "module/fourze_hand_module"));
                }
            }.changeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 5));

    public static final DeferredItem<Item> SCHOOP_ASTROSWITCH = ITEMS.register("scoop_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt"
                    , new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        layerInfo.add(new RenderLayerInfo("module/fourze_scoop_module", "default"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_module_circle", "default"));
                    }
                }
            }.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 5));

    public static final DeferredItem<Item> MAGNET_ASTROSWITCH_N = ITEMS.register("magnet_switch_n",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), "", "fourze", "fourze_driver_belt"
                    , new MobEffectInstance(EffectCore.PULL, 40, 2, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_magnet_n_module", "default"));
                }
            }.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 5));

    public static final DeferredItem<Item> MAGNET_ASTROSWITCH_S = ITEMS.register("magnet_switch_s",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), "", "fourze", "fourze_driver_belt"
                    , new MobEffectInstance(EffectCore.PUSH, 40, 2, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_magnet_s_module", "default"));
                }
            }.changeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 5));

    public static final DeferredItem<Item> FREEZE_ASTROSWITCH = ITEMS.register("freeze_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.BLIZZARD, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new FreezeRenderLayerInfo("module/fourze_freeze_module", "module/fourze_freeze_module"));
                }
            }.changeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 2));

    public static final DeferredItem<Item> CLAW_ASTROSWITCH = ITEMS.register("claw_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt"
                    , new MobEffectInstance(EffectCore.PUNCH, 40, 4, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        layerInfo.add(new RenderLayerInfo("module/fourze_claw_module", "module/fourze_claw_module"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_module_circle", "default"));
                    }
                }
            }.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 2));

    public static final DeferredItem<Item> BOARD_ASTROSWITCH = ITEMS.register("board_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_board_module", "default"));
                }
            }.changeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 2));

    public static final DeferredItem<Item> GIANTFOOT_ASTROSWITCH = ITEMS.register("giantfoot_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.GRAVITY, 40, 1, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_giantfoot_module", "module/fourze_giantfoot_module"));
                }
            }.changeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 2));

    public static final DeferredItem<Item> AERO_ASTROSWITCH = ITEMS.register("aero_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "_aero_module", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.JUMP, 40, 5, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_aero_module", "module/fourze_aero_module"));
                }
            }.changeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 2));

    public static final DeferredItem<Item> GYRO_ASTROSWITCH = ITEMS.register("gyro_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.FLYING, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        if (RiderDriverItem.getFormItem(itemStack, 5) == FOURZE_COSMIC_STATES.asItem())
                            layerInfo.add(new RenderLayerInfo("module/fourze_cosmic_module_square", "default"));
                        else layerInfo.add(new RenderLayerInfo("module/fourze_module_square", "default"));
                        layerInfo.add(new GyroRenderLayerInfo("module/fourze_gyro_module", "module/fourze_gyro_module"));
                    }
                }
            }.changeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 2));

    public static final DeferredItem<Item> NET_ASTROSWITCH = ITEMS.register("net_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt") {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new NetRenderLayerInfo("module/fourze_net_module", "module/fourze_net_module"));
                }
            }.setSlotOneAbility("fish", 1).changeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 2));

    public static final DeferredItem<Item> STAMPER_ASTROSWITCH = ITEMS.register("stamper_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_stamper_module", "default"));
                }
            }.changeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(AstroswitchProgrammer.ASTROSWITCH, 2));

    public static final DeferredItem<Item> COSMIC_ASTROSWITCH = ITEMS.register("cosmic_switch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.SLASH, 40, 2, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_cosmic_module_circle", "default"));
                }
            }.alsoChange5thSlot(FOURZE_COSMIC_STATES.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(DecadeRiderItems.COMPLETE_21_FORMS).addToList(AstroswitchProgrammer.ASTROSWITCH, 1));

    public static final DeferredItem<Item> SUPER_ROCKET_ASTROSWITCH = ITEMS.register("super_rocket_switch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.BOOST, 40, 1, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_super_rocket_module", "default"));
                }
            }.changeSlot(4).alsoChange5thSlot(FOURZE_ROCKET_STATES.get()).alsoChange1stSlot(ROCKET_ASTROSWITCH.get()).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> SUPER_LAUNCHER_ASTROSWITCH = ITEMS.register("super_launcher_switch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), "", "fourze", "fourze_driver_belt") {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_super_launcher_module", "default"));
                }
            }.setSlotTwoAbility("cannon", 1).changeSlot(2).alsoChange5thSlot(FOURZE_LAUNCHER_STATES.get()).resetFormToBase().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> SUPER_DRILL_ASTROSWITCH = ITEMS.register("super_drill_switch",
            () -> new BaseItem(new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));


    public static final DeferredItem<Item> CLEAR_DRILL_ASTROSWITCH = ITEMS.register("clear_drill_switch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false)
                    , new MobEffectInstance(EffectCore.BOOST, 40, 1, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_rocket_drill_module", "default"));
                }
            }.addNeedItem(ROCKET_ASTROSWITCH.get()).addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).alsoChange5thSlot(FOURZE_ROCKET_DRILL_STATES.get()).alsoChange3rdSlot(BLANK_TRIANGLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> METEOR_ASTROSWITCH = ITEMS.register("meteor_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "meteor", "meteor_driver_belt",
            new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false)
                    , new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false)
                    , new MobEffectInstance(EffectCore.PUNCH, 40, 3, true, false)) {
        public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick) {
            super.transformationEffect(itemstack, player, tick);
            if (tick == 30d) {
                AnimationUtil.playPose(player, "meteor.henshin");
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.STONE_STEP, SoundSource.PLAYERS, 1.0F, 8F);

            } else if (tick == 2d) {
                ((ServerLevel) player.level()).sendParticles(ParticleTypes.SOUL_FIRE_FLAME,
                        player.getX(), player.getY() + 1,
                        player.getZ(), 200, 0, 0, 0, 0.1);
            }
        }
    }.setHenshinTick(35).setFormDelay(1).isGlowing().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));


    public static final DeferredItem<Item> METEOR_STORM_ASTROSWITCH = ITEMS.register("meteor_storm_switch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), "_storm", "meteor", "meteor_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)
                    , new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false)
                    , new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false)
                    , new MobEffectInstance(EffectCore.PUNCH, 40, 5, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 0.05);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 0.05);

                }
            }.isGlowing().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));


    public static final DeferredItem<Item> NADESHIKO_ASTROSWITCH = ITEMS.register("nadeshiko_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "nadeshiko", "nadeshiko_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)
                    , new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false)
                    , new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false)
                    , new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                            player.getX(), player.getY() + 0.5,
                            player.getZ(), 100, 0, 0, 0, 0.05);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 30, 0, 0, 0, 0.05);
                }
            }.changeBeltModel("geo/belts/eins_belt.geo.json").isGlowing().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> IKAROS_ASTROSWITCH = ITEMS.register("ikaros_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "ikaros", "ikaros_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)
                    , new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false)
                    , new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2, true, false)
                    , new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 0.05);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 0.05);

                }
            }.isGlowing().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> SOLU_ASTROSWITCH = ITEMS.register("solu_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "super_gingaoh", "blank",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false)
                    , new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false)
                    , new MobEffectInstance(EffectCore.PUNCH, 40, 3, true, false))
                    .addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> FUSION_ASTROSWITCH_OG = ITEMS.register("fusion_switch_og",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.SLASH, 40, 2, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_fusion_module", "default"));
                }
            }.changeSlot(4).resetFormToBase().alsoChange5thSlot(FOURZE_FUSION_STATES.get())
                    .setModelName("fusion_switch").useBasicModel());

    public static final DeferredItem<Item> FUSION_ASTROSWITCH = ITEMS.register("fusion_switch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.SLASH, 40, 2, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_fusion_nadeshiko_module", "default"));
                }
            }.changeSlot(4).resetFormToBase()
                    .alsoChange5thSlot(FOURZE_METEOR_NADESHIKO_FUSION_STATES.get())
                    .addNeedItem(METEOR_ASTROSWITCH.get())
                    .addNeedItem(NADESHIKO_ASTROSWITCH.get())
                    .addAlternative(FUSION_ASTROSWITCH_OG.get())
                    .addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));


    public static final DeferredItem<Item> CORE_ASTROSWITCH = ITEMS.register("core_switch",
            () -> new BaseItem(new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> ROCKET_ASTROSWITCH_CHRISTMAS_VER = ITEMS.register("rocket_switch_christmas_ver",
            () -> new BaseItem(new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> GATE_SWITCH = ITEMS.register("gate_switch",
            () -> new GateSwitchItem(new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));


    public static final DeferredItem<Item> RIDER_1_ASTROSWITCH = ITEMS.register("rider1_switch",
            () -> new ShowaSwitchItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_ichigo_module", "module/fourze_ichigo_module", "module/fourze_ichigo_module_glowmask"));
                }
            }.setSummonBelt((RiderDriverItem) IchigoRiderItems.TYPHOON_ICHIGO.get()).changeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> RIDER_2_ASTROSWITCH = ITEMS.register("rider2_switch",
            () -> new ShowaSwitchItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 3, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        if (RiderDriverItem.getFormItem(itemStack, 5) == FOURZE_COSMIC_STATES.asItem())
                            layerInfo.add(new RenderLayerInfo("module/fourze_cosmic_module_square", "default"));
                        else layerInfo.add(new RenderLayerInfo("module/fourze_module_square", "default"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_nigo_module", "module/fourze_nigo_module", "module/fourze_nigo_module_glowmask"));
                    }
                }
            }.setSummonBelt((RiderDriverItem) IchigoRiderItems.TYPHOON_NIGO.get()).setSummonForm((RiderFormChangeItem) IchigoRiderItems.ORIGINAL_TYPHOON_CORE_NIGO.get()).changeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> V3_ASTROSWITCH = ITEMS.register("v3_switch",
            () -> new ShowaSwitchItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_v3_module", "module/fourze_v3_module", "module/fourze_v3_module_glowmask"));
                }
            }.setSummonBelt((RiderDriverItem) V3RiderItems.DOUBLE_TYPHOON.get()).changeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> RIDERMAN_ASTROSWITCH = ITEMS.register("riderman_switch",
            () -> new ShowaSwitchItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.LONG_ARM, 40, 4, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        layerInfo.add(new RenderLayerInfo("module/fourze_module_circle", "default"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_riderman_module", "module/fourze_riderman_module", "module/fourze_riderman_module_glowmask"));
                    }
                }
            }.setSummonBelt((RiderDriverItem) V3RiderItems.RIDERMAN_BELT.get()).addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> X_ASTROSWITCH = ITEMS.register("x_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.SLASH, 40, 3, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_x_module", "module/fourze_x_module", "module/fourze_x_module_glowmask"));
                }
            }.changeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> AMAZON_ASTROSWITCH = ITEMS.register("amazon_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 3, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        if (RiderDriverItem.getFormItem(itemStack, 5) == FOURZE_COSMIC_STATES.asItem())
                            layerInfo.add(new RenderLayerInfo("module/fourze_cosmic_module_square", "default"));
                        else layerInfo.add(new RenderLayerInfo("module/fourze_module_square", "default"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_amazon_module", "module/fourze_amazon_module", "module/fourze_amazon_module_glowmask"));
                    }
                }
            }.changeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> STRONGER_ASTROSWITCH = ITEMS.register("stronger_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.THUNDER_PUNCH, 40, 3, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        layerInfo.add(new RenderLayerInfo("module/fourze_module_circle", "default"));
                        layerInfo.add(new StrongerModuleRenderLayerInfo("module/fourze_stronger_module", "module/fourze_stronger_module", "module/fourze_stronger_module_glowmask"));
                    }
                }
            }.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> SKYRIDER_ASTROSWITCH = ITEMS.register("skyrider_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.BOOST, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_skyrider_module", "module/fourze_skyrider_module", "module/fourze_skyrider_module_glowmask"));
                }
            }.changeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> SUPER_1_ASTROSWITCH = ITEMS.register("super_1_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 3, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        if (RiderDriverItem.getFormItem(itemStack, 5) == FOURZE_COSMIC_STATES.asItem())
                            layerInfo.add(new RenderLayerInfo("module/fourze_cosmic_module_square", "default"));
                        else layerInfo.add(new RenderLayerInfo("module/fourze_module_square", "default"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_super_1_module", "module/fourze_super_1_module", "module/fourze_super_1_module_glowmask"));
                    }
                }
            }.changeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> ZX_ASTROSWITCH = ITEMS.register("zx_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt") {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        layerInfo.add(new RenderLayerInfo("module/fourze_module_circle", "default"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_zx_module", "module/fourze_zx_module", "module/fourze_zx_module_glowmask"));
                    }
                }
            }.setSlotTwoAbility("cannon", 1).addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> BLACK_ASTROSWITCH = ITEMS.register("black_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 3, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_black_module", "module/fourze_black_module", "module/fourze_black_module_glowmask"));
                }
            }.changeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> BLACK_RX_ASTROSWITCH = ITEMS.register("rx_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.SLASH, 40, 2, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        layerInfo.add(new RenderLayerInfo("module/fourze_module_circle", "default"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_black_rx_module", "module/fourze_black_rx_module", "module/fourze_black_rx_module_glowmask"));
                    }
                }
            }.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_ASTROSWITCH = ITEMS.register("kuuga_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 3, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_kuuga_module", "module/fourze_kuuga_module", "module/fourze_kuuga_module_glowmask"));
                }
            }.changeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> AGITO_ASTROSWITCH = ITEMS.register("agito_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 3, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_agito_module", "module/fourze_agito_module", "module/fourze_agito_module_glowmask"));
                }
            }.changeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> RYUKI_ASTROSWITCH = ITEMS.register("ryuki_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.FIRE_PUNCH, 40, 3, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        layerInfo.add(new RenderLayerInfo("module/fourze_module_circle", "default"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_ryuki_module", "module/fourze_ryuki_module", "module/fourze_ryuki_module_glowmask"));
                    }
                }
            }.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> FAIZ_ASTROSWITCH = ITEMS.register("faiz_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 3, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_faiz_module", "module/fourze_faiz_module", "module/fourze_faiz_module_glowmask"));
                }
            }.changeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> BLADE_ASTROSWITCH = ITEMS.register("blade_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.THUNDER_SLASH, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_blade_module", "module/fourze_blade_module", "module/fourze_blade_module_glowmask"));
                }
            }.changeSlot(2).addSwitchForm(BLANK_CROSS_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> HIBIKI_ASTROSWITCH = ITEMS.register("hibiki_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.NOTE, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        if (RiderDriverItem.getFormItem(itemStack, 5) == FOURZE_COSMIC_STATES.asItem())
                            layerInfo.add(new RenderLayerInfo("module/fourze_cosmic_module_square", "default"));
                        else layerInfo.add(new RenderLayerInfo("module/fourze_module_square", "default"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_hibiki_module", "module/fourze_hibiki_module", "module/fourze_hibiki_module_glowmask"));
                    }
                }
            }.changeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> KABUTO_ASTROSWITCH = ITEMS.register("kabuto_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_kabuto_module", "module/fourze_kabuto_module", "module/fourze_kabuto_module_glowmask"));
                }
            }.changeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_ASTROSWITCH = ITEMS.register("den_o_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 3, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        layerInfo.add(new RenderLayerInfo("module/fourze_module_circle", "default"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_den_o_module", "module/fourze_den_o_module", "module/fourze_den_o_module_glowmask"));
                    }
                }
            }.addSwitchForm(BLANK_CIRCLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> KIVA_ASTROSWITCH = ITEMS.register("kiva_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(MobEffects.JUMP, 40, 7, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_kiva_module", "module/fourze_kiva_module", "module/fourze_kiva_module_glowmask"));
                }
            }.changeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_ASTROSWITCH = ITEMS.register("decade_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.REFLECT, 40, 0, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD)
                        layerInfo.add(new RenderLayerInfo("module/fourze_decade_module", "module/fourze_decade_module", "module/fourze_decade_module_glowmask"));
                }
            }.changeSlot(3).addSwitchForm(BLANK_TRIANGLE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> DOUBLE_ASTROSWITCH = ITEMS.register("double_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.PUNCH, 40, 3, true, false)) {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        if (RiderDriverItem.getFormItem(itemStack, 5) == FOURZE_COSMIC_STATES.asItem())
                            layerInfo.add(new RenderLayerInfo("module/fourze_cosmic_module_square", "default"));
                        else layerInfo.add(new RenderLayerInfo("module/fourze_module_square", "default"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_double_module", "module/fourze_double_module", "module/fourze_double_module_glowmask"));
                    }
                }
            }.changeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> OOO_ASTROSWITCH = ITEMS.register("ooo_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "fourze", "fourze_driver_belt") {
                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    if (slot == EquipmentSlot.HEAD) {
                        if (RiderDriverItem.getFormItem(itemStack, 5) == FOURZE_COSMIC_STATES.asItem())
                            layerInfo.add(new RenderLayerInfo("module/fourze_cosmic_module_square", "default"));
                        else layerInfo.add(new RenderLayerInfo("module/fourze_module_square", "default"));
                        layerInfo.add(new RenderLayerInfo("module/fourze_ooo_module", "module/fourze_ooo_module", "module/fourze_ooo_module_glowmask"));
                    }
                }
            }.setSlotTwoAbility("cannon", 1).changeSlot(4).addSwitchForm(BLANK_SQUARE_ASTROSWITCH.get()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> SHIN_CHAN_ASTROSWITCH = ITEMS.register("shin_chan_switch",
            () -> new RiderFormChangeItem(new Item.Properties(), "_shin_chan", "fourze", "fourze_driver_belt",
                    new MobEffectInstance(EffectCore.BOOST, 40, 1, true, false),
                    new MobEffectInstance(EffectCore.FLAT, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false)
                    , new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false),
                    new MobEffectInstance(EffectCore.HAPPY_MODE, 40, 4, true, false)) {

                public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
                    // if (slot==EquipmentSlot.HEAD)layerInfo.add(new RenderLayerInfo("fourze_shin_chan_module","default"));
                }

                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 0.05);

                }
            }.changeSlot(5).alsoChange4thSlot(BLANK_SQUARE_ASTROSWITCH.get())
                    .resetFormToBase().addSwitchForm(FOURZE_BASE_STATES.get())
                    .addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));

    public static final DeferredItem<Item> ZODIARTS_SWITCH = ITEMS.register("zodiarts_switch",
            () -> new BaseItem(new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));


    public static final DeferredItem<Item> FOURZE_HELMET = ITEMS.register("fourze_head",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM)
                    .changeRepairItem(BLANK_ASTROSWITCH.get()));
    public static final DeferredItem<Item> FOURZE_CHESTPLATE = ITEMS.register("fourze_troso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM)
                    .changeRepairItem(BLANK_ASTROSWITCH.get()));
    public static final DeferredItem<Item> FOURZE_LEGGINGS = ITEMS.register("fourze_legs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM)
                    .changeRepairItem(BLANK_ASTROSWITCH.get()));

    public static final DeferredItem<Item> FOURZE_DRIVER = ITEMS.register("fourze_driver",
            () -> new FourzeDriverItem(ArmorMaterials.DIAMOND, "fourze", BLANK_CIRCLE_ASTROSWITCH, FOURZE_HELMET, FOURZE_CHESTPLATE, FOURZE_LEGGINGS, new Item.Properties())
                    .addExtraBaseFormItems(BLANK_CROSS_ASTROSWITCH, BLANK_TRIANGLE_ASTROSWITCH, BLANK_SQUARE_ASTROSWITCH, FOURZE_BASE_STATES).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(DecadeRiderItems.NEO_DIEND_SUMMON_BELTS).changeRepairItem(BLANK_ASTROSWITCH.get()));

    public static final DeferredItem<Item> METEOR_DRIVER = ITEMS.register("meteor_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "meteor", METEOR_ASTROSWITCH, FOURZE_HELMET, FOURZE_CHESTPLATE, FOURZE_LEGGINGS,
                    new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(DecadeRiderItems.NEO_DIEND_SUMMON_BELTS).changeRepairItem(BLANK_ASTROSWITCH.get()));

    public static final DeferredItem<Item> NADESHIKO_DRIVER = ITEMS.register("nadeshiko_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "nadeshiko", NADESHIKO_ASTROSWITCH, FOURZE_HELMET, FOURZE_CHESTPLATE, FOURZE_LEGGINGS,
                    new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).changeRepairItem(BLANK_ASTROSWITCH.get()));

    public static final DeferredItem<Item> IKAROS_DRIVER = ITEMS.register("ikaros_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "ikaros", IKAROS_ASTROSWITCH, FOURZE_HELMET, FOURZE_CHESTPLATE, FOURZE_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).changeRepairItem(BLANK_ASTROSWITCH.get()));


    public static final DeferredItem<Item> GINGA_OH_DRIVER = ITEMS.register("ginga_oh_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND, "super_gingaoh", SOLU_ASTROSWITCH, FOURZE_HELMET, FOURZE_CHESTPLATE, FOURZE_LEGGINGS,
                    new Item.Properties()).hideBeltFormInfo().addExtraBaseFormItems(OOORiderItems.SAME_MEDAL, OOORiderItems.KUJIRA_MEDAL, OOORiderItems.OOKAMIUO_MEDAL).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).changeRepairItem(BLANK_ASTROSWITCH.get()));


    public static final DeferredItem<Item> ASTROSWITCH_CASE = ITEMS.register("astroswitch_case",
            () -> new AstroswitchCaseItem().useBasicModel().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM));


    public static final DeferredItem<Item> BILLY_THE_ROD = ITEMS.register("billy_the_rod",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).changeRepairItem(BLANK_ASTROSWITCH.get()));

    public static final DeferredItem<Item> HEE_HACKGUN = ITEMS.register("hee_hackgun",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.SMALL_FIREBALL).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).changeRepairItem(BLANK_ASTROSWITCH.get()));

    public static final DeferredItem<Item> BARIZUN_SWORD = ITEMS.register("barizun_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).isChangeSword().addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).addToList(DecadeRiderItems.COMPLETE_21_WEAPONS).changeRepairItem(BLANK_ASTROSWITCH.get()));

    public static final DeferredItem<Item> SHIELD_MODULE = ITEMS.register("shield_module",
            () -> new BaseShieldItem(new Item.Properties()).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM)
                    .changeRepairItem(BLANK_ASTROSWITCH.get()));

    public static final DeferredItem<Item> METEOR_STORM_SHAFT = ITEMS.register("meteor_storm_shaft",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(com.kelco.kamenridercraft.item.KRCCreativeTabs.FOURZE_TAB_ITEM).changeRepairItem(BLANK_ASTROSWITCH.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}