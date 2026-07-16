package com.kelco.kamenridercraft.item.reiwa;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machine.CapsemDropper;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.base_items.*;
import com.kelco.kamenridercraft.item.reiwa.zeztz.CapsemCylinderItem;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ZeztzRiderItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

    public static final DeferredItem<Item> ZEZTZ_LOGO = ITEMS.register("zeztz_logo",() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/zeztz")), new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> CODE_CAPSEM = ITEMS.register("code_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"","knight_seventeen","knight_invoker_belt_seventeen",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            } .changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> CODE_CAPSEM_SEVENTEEN = ITEMS.register("code_capsem_seventeen",
            () -> new RiderFormChangeItem(new Item.Properties(),"","lord_seventeen","lord_invoker_seventeen_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            } .changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model());


    public static final DeferredItem<Item> IMPACT_CAPSEM = ITEMS.register("impact_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"","zeztz","zeztz_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            } .changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(CapsemDropper.CAPSEM,10).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));


    public static final DeferredItem<Item> TRANSFORM_CAPSEM = ITEMS.register("transform_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"_physicam_transform","zeztz","zeztz_driver_belt_physicam_transform",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.LONG_ARM, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            } .changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().addToList(CapsemDropper.CAPSEM,5).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> WING_CAPSEM = ITEMS.register("wing_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"_physicam_wing","zeztz","zeztz_driver_belt_wing",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.GLIDE, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            } .changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").isGlowing().IsBeltGlowing().addToList(CapsemDropper.CAPSEM,5).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> STREAM_CAPSEM = ITEMS.register("stream_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"_technolom_stream","zeztz","zeztz_driver_belt_technolom_stream",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            } .changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(CapsemDropper.CAPSEM,7).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> MACHINERY_CAPSEM = ITEMS.register("machinery_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"_technolom_machinery","zeztz","zeztz_driver_belt_technolom_machinery",
                    new MobEffectInstance(EffectCore.DRILL, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            } .changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(CapsemDropper.CAPSEM,5).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> PROJECTION_CAPSEM_METAMATERIAM = ITEMS.register("projection_capsem_metamateriam",
            () -> new RiderFormChangeItem(new Item.Properties(),"","metamateriam","metamateriam_belt",
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeModel("zeztz.geo.json").changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").isGlowing());

    public static final DeferredItem<Item> PROJECTION_CAPSEM = ITEMS.register("projection_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"_technolom_projection","zeztz","zeztz_driver_belt_technolom_projection",
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                    if (player instanceof Player play) {
                        RiderSummonEntity meta = MobsCore.RIDER_SUMMON.get().create(player.level());
                        if (meta != null) {
                            meta.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
                            meta.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ZeztzRiderItems.ZEZTZ_HELMET.get()));
                            meta.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ZeztzRiderItems.ZEZTZ_CHESTPLATE.get()));
                            meta.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ZeztzRiderItems.ZEZTZ_LEGGINGS.get()));
                            meta.setItemSlot(EquipmentSlot.FEET, new ItemStack(ZeztzRiderItems.METAMATERIAM_BELT.get()));
                            meta.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ZeztzRiderItems.BREAKAM_ZEZTZER_GUN.get()));
                            player.level().addFreshEntity(meta);
                            meta.bindToPlayer(play);
                            meta.addRequiredForm(this, 1);
                        }
                    }
                }
            }.addAlternative(PROJECTION_CAPSEM_METAMATERIAM.get()).changeModel("zeztz.geo.json").changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(CapsemDropper.CAPSEM,5).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));


    public static final DeferredItem<Item> RECOVERY_CAPSEM = ITEMS.register("recovery_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"_esprim_recovery","zeztz","zeztz_driver_belt_esprim_recovery",
                    new MobEffectInstance(EffectCore.ANTIPOISON, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.SELF_MENDING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeModel("zeztz.geo.json").changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(CapsemDropper.CAPSEM,7).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> BARRIER_CAPSEM = ITEMS.register("barrier_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"_esprim_barrier","zeztz","zeztz_driver_belt_esprim_barrier",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(CapsemDropper.CAPSEM,5).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> WONDER_CAPSEM = ITEMS.register("wonder_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"_paradigm_wonder","zeztz","zeztz_driver_belt_paradigm_wonder",
                    new MobEffectInstance(EffectCore.WONDER, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeModel("zeztz.geo.json").changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(CapsemDropper.CAPSEM,7).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> GRAVITY_CAPSEM = ITEMS.register("gravity_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"_paradigm_gravity","zeztz","zeztz_driver_belt_paradigm_gravity",
                    new MobEffectInstance(EffectCore.LOW_GRAVITY, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(CapsemDropper.CAPSEM,5).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> PLASMA_CAPSEM_METAMATERIAM = ITEMS.register("plasma_capsem_metamateriam",
            () -> new RiderFormChangeItem(new Item.Properties(),"_inazuma_plasma","metamateriam","metamateriam_belt_inazuma_plasma",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.THUNDER_PUNCH, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT,player.level());
                    thunder.setVisualOnly(true);
                    thunder.setPos( player.getX(),  -1 + player.getY(),  player.getZ() );
                    player.level().addFreshEntity(thunder);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeModel("zeztz.geo.json").changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").isGlowing());

    public static final DeferredItem<Item> PLASMA_CAPSEM = ITEMS.register("plasma_capsem",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_inazuma_plasma","zeztz","zeztz_driver_belt_inazuma_plasma",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.THUNDER_PUNCH, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT,player.level());
                    thunder.setVisualOnly(true);
                    thunder.setPos( player.getX(),  -1 + player.getY(),  player.getZ() );
                    player.level().addFreshEntity(thunder);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addAlternative(PLASMA_CAPSEM_METAMATERIAM.get()).changeModel("zeztz.geo.json").changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> BOOSTER_CAPSEM = ITEMS.register("booster_capsem",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_plasma_booster","zeztz","zeztz_driver_belt_plasma_booster",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.THUNDER_PUNCH, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.BOOST, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT,player.level());
                    thunder.setVisualOnly(true);
                    thunder.setPos( player.getX(),  -1 + player.getY(),  player.getZ() );
                    player.level().addFreshEntity(thunder);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.changeModel("zeztz.geo.json").changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> DUALMARE_CAPSEM_ORDERM = ITEMS.register("dualmare_capsem_orderm",
            () -> new RiderFormChangeItem(new Item.Properties(),"_orderm","zeztz","zeztz_driver_belt_orderm",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing());

    public static final DeferredItem<Item> DUALMARE_CAPSEM = ITEMS.register("dualmare_capsem",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_catastrom","zeztz","zeztz_driver_belt_catastrom",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.addSwitchForm(DUALMARE_CAPSEM_ORDERM.get()).changeModel("zeztz.geo.json").changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> EXDREAMRISE_CAPSEM = ITEMS.register("exdreamrise_capsem",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),"","zeztz_exdream","zeztz_exdream_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> ZEZTZ_AND_CODE_ZEROIDER_CAPSEM = ITEMS.register("zeztz_and_code_zeroider_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"_impact_zeroider","zeztz","zeztz_driver_belt_impact_zeroider",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.BOOST, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeModel("zeztz.geo.json").changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> CHARGE_CAPSEM = ITEMS.register("charge_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"_charge","zeztz","zeztz_driver_belt_charge",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.HAPPY_MODE, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));


    public static final DeferredItem<Item> ERASE_CAPSEM = ITEMS.register("erase_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"","nox_knight","knight_invoker_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            } .changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));


    public static final DeferredItem<Item> EXTRA_CAPSEM = ITEMS.register("extra_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"","lord_three","lord_invoker_three_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            } .changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").changeModel("lord_three.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));




    public static final DeferredItem<Item> IMPACT_CAPSEM_SHOCK = ITEMS.register("impact_capsem_shock",
            () -> new RiderFormChangeItem(new Item.Properties(),"","zeztz","zeztz_driver_belt_shock",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.ELECTRIC_PUNCH, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            } .changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().model_has_different_name("shock_capsem"));

    public static final DeferredItem<Item> SHOCK_CAPSEM = ITEMS.register("shock_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"","lord_five","lord_invoker_five_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.ELECTRIC_PUNCH, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addAlternative(IMPACT_CAPSEM_SHOCK.asItem()).changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));


    public static final DeferredItem<Item> PANIC_CAPSEM = ITEMS.register("panic_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"","lord_six","lord_invoker_six_belt",
                    new MobEffectInstance(MobEffects.HEALTH_BOOST, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.SHOT_BOOST, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            } .changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> CLEAR_CAPSEM = ITEMS.register("clear_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> LORD_BOOSTER_CAPSEM = ITEMS.register("lord_booster_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"_booster","lord_three","lord_invoker_three_belt_booster",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.POISON_PUNCH, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 3,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            } .changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));


    public static final DeferredItem<Item> PUNISH_CAPSEM = ITEMS.register("punish_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"","dawn","dawn_belt_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            } .changeBeltModel("geo/belts/dawn_riderbelt.geo.json").isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> SHADOW_CAPSEM = ITEMS.register("shadow_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"","nox","nox_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> GUN_CAPSEM = ITEMS.register("gun_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"_gun","nox","nox_driver_belt_gun",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.GATLING, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> WOLF_CAPSEM = ITEMS.register("wolf_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"_wolf","nox","nox_driver_belt_wolf",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.LONG_ARM, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> MIDNIGHT_SHADOW_CAPSEM = ITEMS.register("midnight_shadow_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"_midnight_shadow","nox","nox_driver_belt_midnight_shadow",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 3,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing().isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> DARKNESS_CAPSEM_DRIVER = ITEMS.register("darkness_capsem_driver",
            () -> new RiderFormChangeItem(new Item.Properties(),"","zeztz_darkness","zeztz_driver_belt_darkness",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.changeModel("zeztz.geo.json").changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").IsBeltGlowing());

    public static final DeferredItem<Item> DARKNESS_CAPSEM = ITEMS.register("darkness_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"","zeztz_darkness","metamateriam_belt_inazuma_plasma",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.changeModel("zeztz.geo.json").changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").addSwitchForm(DARKNESS_CAPSEM_DRIVER.get()).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> DAYDREAM_CAPSEM = ITEMS.register("daydream_capsem",
            () -> new RiderFormChangeItem(new Item.Properties(),"","mugen","mugen_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.changeModel("mugen.geo.json").changeBeltModel("geo/belts/zeztz_riderbelt.geo.json").addSwitchForm(DARKNESS_CAPSEM_DRIVER.get()).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> VOID_CAPSEM = ITEMS.register("void_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> SONG_CAPSEM = ITEMS.register("song_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> SWEETS_CAPSEM = ITEMS.register("sweets_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> CHARADECO_CAPSEM = ITEMS.register("charadeco_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> GOCHIZO_CAPSEM = ITEMS.register("gochizo_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> IMPACT_CAPSEM_GOLD = ITEMS.register("impact_capsem_gold",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> TRANSFORM_CAPSEM_GOLD = ITEMS.register("transform_capsem_gold",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> WING_CAPSEM_GOLD = ITEMS.register("wing_capsem_gold",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_CAPSEM = ITEMS.register("kuuga_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> AGITO_CAPSEM = ITEMS.register("agito_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> RYUKI_CAPSEM = ITEMS.register("ryuki_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> FAIZ_CAPSEM = ITEMS.register("faiz_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> BLADE_CAPSEM = ITEMS.register("blade_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> HIBIKI_CAPSEM = ITEMS.register("hibiki_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> KABUTO_CAPSEM = ITEMS.register("kabuto_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_CAPSEM = ITEMS.register("den_o_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> KIVA_CAPSEM = ITEMS.register("kiva_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_CAPSEM = ITEMS.register("decade_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> W_CAPSEM = ITEMS.register("w_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> OOO_CAPSEM = ITEMS.register("ooo_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> FOURZE_CAPSEM = ITEMS.register("fourze_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> WIZARD_CAPSEM = ITEMS.register("wizard_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> GAIM_CAPSEM = ITEMS.register("gaim_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> DRIVE_CAPSEM = ITEMS.register("drive_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> GHOST_CAPSEM = ITEMS.register("ghost_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> EX_AID_CAPSEM = ITEMS.register("ex_aid_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> BUILD_CAPSEM = ITEMS.register("build_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> ZI_O_CAPSEM = ITEMS.register("zi_o_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> ZERO_ONE_CAPSEM = ITEMS.register("zero_one_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> SABER_CAPSEM = ITEMS.register("saber_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> REVICE_CAPSEM = ITEMS.register("revice_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> GEATS_CAPSEM = ITEMS.register("geats_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> GOTCHARD_CAPSEM = ITEMS.register("gotchard_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> GAVV_CAPSEM = ITEMS.register("gavv_capsem",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(CapsemDropper.LEGEND_CAPSEM).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> ZEZTZ_EXDREAM_DRIVER_BUCKLE = ITEMS.register("zeztz_exdream_driver_buckle",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> CAPSEM_CYLINDER = ITEMS.register("capsem_cylinder",
            () -> new CapsemCylinderItem().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> ZEZTZ_HELMET = ITEMS.register("zeztz_head",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).has_basic_model().changeRepairItem(CODE_CAPSEM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));
    public static final DeferredItem<Item> ZEZTZ_CHESTPLATE = ITEMS.register("zeztz_troso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).has_basic_model().changeRepairItem(CODE_CAPSEM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));
    public static final DeferredItem<Item> ZEZTZ_LEGGINGS = ITEMS.register("zeztz_legs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).has_basic_model().changeRepairItem(CODE_CAPSEM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));


    public static final DeferredItem<Item> ZEZTZ_DRIVER = ITEMS.register("zeztz_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zeztz", IMPACT_CAPSEM,ZEZTZ_HELMET,ZEZTZ_CHESTPLATE,ZEZTZ_LEGGINGS, new Item.Properties())
                    .has_basic_model().changeRepairItem(CODE_CAPSEM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> ZEZTZ_EXDREAM_DRIVER = ITEMS.register("zeztz_exdream_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zeztz_exdream", EXDREAMRISE_CAPSEM,ZEZTZ_HELMET,ZEZTZ_CHESTPLATE,ZEZTZ_LEGGINGS, new Item.Properties())
                    .hideBeltFormInfo().has_basic_model().changeRepairItem(CODE_CAPSEM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> NOX_DRIVER = ITEMS.register("nox_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"nox", SHADOW_CAPSEM,ZEZTZ_HELMET,ZEZTZ_CHESTPLATE,ZEZTZ_LEGGINGS, new Item.Properties())
                    .has_basic_model().changeRepairItem(CODE_CAPSEM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> DAWN_BELT = ITEMS.register("dawn_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dawn", PUNISH_CAPSEM,ZEZTZ_HELMET,ZEZTZ_CHESTPLATE,ZEZTZ_LEGGINGS, new Item.Properties())
                    .hideBeltFormInfo().has_basic_model().changeRepairItem(CODE_CAPSEM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> KIGHT_INVOKER = ITEMS.register("knight_invoker",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"nox_knight", ERASE_CAPSEM,ZEZTZ_HELMET,ZEZTZ_CHESTPLATE,ZEZTZ_LEGGINGS, new Item.Properties())
                    .hideBeltFormInfo().has_basic_model().changeRepairItem(CODE_CAPSEM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> LORD_INVOKER_THREE = ITEMS.register("lord_invoker_three",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"lord_three", EXTRA_CAPSEM,ZEZTZ_HELMET,ZEZTZ_CHESTPLATE,ZEZTZ_LEGGINGS, new Item.Properties())
                    .has_basic_model().changeRepairItem(CODE_CAPSEM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> LORD_INVOKER_FIVE = ITEMS.register("lord_invoker_five",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"lord_five", SHOCK_CAPSEM,ZEZTZ_HELMET,ZEZTZ_CHESTPLATE,ZEZTZ_LEGGINGS, new Item.Properties())
                    .hideBeltFormInfo().has_basic_model().changeRepairItem(CODE_CAPSEM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> LORD_INVOKER_SIX = ITEMS.register("lord_invoker_six",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"lord_six", PANIC_CAPSEM,ZEZTZ_HELMET,ZEZTZ_CHESTPLATE,ZEZTZ_LEGGINGS, new Item.Properties())
                    .hideBeltFormInfo().has_basic_model().changeRepairItem(CODE_CAPSEM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> METAMATERIAM_BELT = ITEMS.register("metamateriam_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"metamateriam", PROJECTION_CAPSEM_METAMATERIAM,ZEZTZ_HELMET,ZEZTZ_CHESTPLATE,ZEZTZ_LEGGINGS, new Item.Properties())
                    .has_basic_model().changeRepairItem(CODE_CAPSEM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> ZEZTZ_DARKNESS_BELT = ITEMS.register("zeztz_darkness_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zeztz_darkness", DARKNESS_CAPSEM,ZEZTZ_HELMET,ZEZTZ_CHESTPLATE,ZEZTZ_LEGGINGS, new Item.Properties())
                    .has_basic_model().changeRepairItem(CODE_CAPSEM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> MUGEN_DRIVER = ITEMS.register("mugen_driver",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"mugen", DAYDREAM_CAPSEM,ZEZTZ_HELMET,ZEZTZ_CHESTPLATE,ZEZTZ_LEGGINGS, new Item.Properties())
                    .hideBeltFormInfo().has_basic_model().changeRepairItem(CODE_CAPSEM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> KIGHT_INVOKER_SEVENTEEN = ITEMS.register("knight_invoker_seventeen",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"knight_seventeen", CODE_CAPSEM,ZEZTZ_HELMET,ZEZTZ_CHESTPLATE,ZEZTZ_LEGGINGS, new Item.Properties())
                    .hideBeltFormInfo().has_basic_model().changeRepairItem(CODE_CAPSEM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> LORD_INVOKER_SEVENTEEN = ITEMS.register("lord_invoker_seventeen",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"lord_seventeen", CODE_CAPSEM_SEVENTEEN,ZEZTZ_HELMET,ZEZTZ_CHESTPLATE,ZEZTZ_LEGGINGS, new Item.Properties())
                    .hideBeltFormInfo().has_basic_model().changeRepairItem(CODE_CAPSEM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> LORD_INVOKER_THIRTEEN = ITEMS.register("lord_invoker_thirteen",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"lord_thirteen", EXTRA_CAPSEM,ZEZTZ_HELMET,ZEZTZ_CHESTPLATE,ZEZTZ_LEGGINGS, new Item.Properties())
                    .hideBeltFormInfo().has_basic_model().changeRepairItem(CODE_CAPSEM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));


    public static final DeferredItem<Item> BREAKAM_ZEZTZER_SWORD = ITEMS.register("breakam_zeztzer_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.2F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM)
                    .changeRepairItem(CODE_CAPSEM.get()));

    public static final DeferredItem<Item> BREAKAM_ZEZTZER_GUN = ITEMS.register("breakam_zeztzer_gun",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM)
                    .changeRepairItem(CODE_CAPSEM.get()));

    public static final DeferredItem<Item> BREAKAM_ZEZTZER_AXE = ITEMS.register("breakam_zeztzer_axe",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -3.0F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM)
                    .changeRepairItem(CODE_CAPSEM.get()));

    public static final DeferredItem<Item> BREAKAM_ZEZTZER_SCYTHE = ITEMS.register("breakam_zeztzer_scythe",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.0F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM)
                    .changeRepairItem(CODE_CAPSEM.get()));

    public static final DeferredItem<Item> INAZUMA_BLASTER = ITEMS.register("inazuma_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 6, -2F, new Item.Properties()).IsSwordGun().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM)
                    .changeRepairItem(CODE_CAPSEM.get()));

    public static final DeferredItem<Item> INAZUMA_BLASTER_GREATSWORD = ITEMS.register("inazuma_blaster_greatsword",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 9, -2F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM)
                    .changeRepairItem(CODE_CAPSEM.get()));

    public static final DeferredItem<Item> TRIPLE_ZEZTZER = ITEMS.register("triple_zeztzer",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 9, -2F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM)
                    .changeRepairItem(CODE_CAPSEM.get()));

    public static final DeferredItem<Item> BREAKAM_BUSTER = ITEMS.register("breakam_buster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2F, new Item.Properties()).IsSwordGun().addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM)
                    .changeRepairItem(CODE_CAPSEM.get()));

    public static final DeferredItem<Item> BREAKAM_DAWN_TAIKEN = ITEMS.register("breakam_dawn_taiken",
            () -> new BaseSwordItem(Tiers.DIAMOND, 11, -2.2F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM)
                    .isHenshinItem(DAWN_BELT.get()).changeRepairItem(CODE_CAPSEM.get()));

    public static final DeferredItem<Item> BREAKAM_DAWN_SOUKEN_L = ITEMS.register("breakam_dawn_souken_l",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.2F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM)
                    .changeRepairItem(CODE_CAPSEM.get()));

    public static final DeferredItem<Item> BREAKAM_DAWN_SOUKEN_R = ITEMS.register("breakam_dawn_souken_r",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.2F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM)
                    .changeRepairItem(CODE_CAPSEM.get()));

    public static final DeferredItem<Item> BREAKAM_BREAKER_BLADE = ITEMS.register("breakam_breaker_blade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM)
                    .changeRepairItem(CODE_CAPSEM.get()));

    public static final DeferredItem<Item> BREAKAM_BREAKER_KNUCKLE = ITEMS.register("breakam_breaker_knuckle",
            () -> new BaseSwordItem(Tiers.DIAMOND, 10, -3.0F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM)
                    .changeRepairItem(CODE_CAPSEM.get()));

    public static final DeferredItem<Item> BREAKAM_BREAKER_SHOOT = ITEMS.register("breakam_breaker_shoot",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM)
                    .changeRepairItem(CODE_CAPSEM.get()));

    public static final DeferredItem<Item> ZEZTZ_HORSE_ARMOR = ITEMS.register("zeztz_horse_armor",
            () -> new  BaseAnimalArmorItem(ArmorMaterials.DIAMOND, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties().stacksTo(1),"zeztz_horse_armor").addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM));

    public static final DeferredItem<Item> MUGEN_SWORD = ITEMS.register("mugen_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.ZEZTZ_TAB_ITEM)
                    .changeRepairItem(CODE_CAPSEM.get()));

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}

}
