package com.kelco.kamenridercraft.effect;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.effect.cores.*;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.xml.sax.ext.Attributes2;

public class Effect_core {

    public static final DeferredRegister<MobEffect> EFFECT = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT,KamenRiderCraftCore.MOD_ID);


    public static final Holder<MobEffect>BOOST = EFFECT.register("boost",
            () -> new BoostEffect(MobEffectCategory.BENEFICIAL, 0xff0015));

    public static final Holder<MobEffect>SWIFT_SWIM = EFFECT.register("swift_swim",
            () -> new SwiftSwimEffect(MobEffectCategory.BENEFICIAL, 0x00ffff));

    public static final Holder<MobEffect> ANTIPOISON = EFFECT.register("anti_poison",
            () -> new AntiPoisonEffect(MobEffectCategory.BENEFICIAL, 0x8532a8));

    public static final Holder<MobEffect>SLASH= EFFECT.register("slash",
            () -> new SlashEffect(MobEffectCategory.BENEFICIAL, 0x21daff));

    public static final Holder<MobEffect> SHOT_BOOST= EFFECT.register("shot_boost",
            () -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0x21daff));

    public static final Holder<MobEffect> PUNCH= EFFECT.register("punch",
            () -> new PunchEffect(MobEffectCategory.BENEFICIAL, 0x1d8519));

    public static final Holder<MobEffect> FLYING= EFFECT.register("flying",
            () -> new 	BasicEffect(MobEffectCategory.BENEFICIAL, 0xffffff)
            .addAttributeModifier(NeoForgeMod.CREATIVE_FLIGHT, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "effect.flying"), 1F, AttributeModifier.Operation.ADD_VALUE) );

    public static final Holder<MobEffect> PULL= EFFECT.register("pull",
            () -> new 	PullEffect(MobEffectCategory.BENEFICIAL, 0xcb3e3e) );

    public static final Holder<MobEffect> PUSH= EFFECT.register("push",
            () -> new 	PushEffect(MobEffectCategory.BENEFICIAL, 0x3ecbcb) );

    public static final Holder<MobEffect> NOTE= EFFECT.register("note",
            () -> new 	NoteEffect(MobEffectCategory.BENEFICIAL, 0x2d2d2d) );

    public static final Holder<MobEffect> DRILL= EFFECT.register("drill",
            () -> new 	DrillEffect(MobEffectCategory.BENEFICIAL, 0xe5d90e) );

    public static final Holder<MobEffect> STEP= EFFECT.register("step",
            () -> new BasicEffect(MobEffectCategory.NEUTRAL, 0x9d3443)
                    .addAttributeModifier(Attributes.STEP_HEIGHT, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "effect.step"), 1F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final Holder<MobEffect> GRAVITY= EFFECT.register("gravity",
            () -> new BasicEffect(MobEffectCategory.NEUTRAL, 0x1d8519)
                    .addAttributeModifier(Attributes.GRAVITY, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "effect.gravity"), 1F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final Holder<MobEffect> LOW_GRAVITY= EFFECT.register("low_gravity",
            () -> new LowGravityEffect(MobEffectCategory.NEUTRAL, 0x1d8519)
                    .addAttributeModifier(Attributes.GRAVITY, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "effect.low_gravity"), -0.1F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final Holder<MobEffect> LONG_ARM= EFFECT.register("long_arm",
            () -> new LowGravityEffect(MobEffectCategory.NEUTRAL, 0xe60052)
                    .addAttributeModifier(Attributes.BLOCK_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "effect.long_arm"), 1F, AttributeModifier.Operation.ADD_VALUE));

    public static final Holder<MobEffect> RADAR= EFFECT.register("radar",
            () -> new RadarEffect(MobEffectCategory.NEUTRAL, 0x1d8519));

    public static final Holder<MobEffect>  SMOKE= EFFECT.register("smoke",
            () -> new SmokeEffect(MobEffectCategory.NEUTRAL, 0x292929) );

    public static final Holder<MobEffect> SMALL= EFFECT.register("small",
            () -> new BasicEffect(MobEffectCategory.NEUTRAL, 0x1d8519)
                    .addAttributeModifier(Attributes.SCALE, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "effect.small"), -0.1F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final Holder<MobEffect> BIG= EFFECT.register("big",
            () -> new BasicEffect(MobEffectCategory.NEUTRAL, 0x1d8519)
                    .addAttributeModifier(Attributes.SCALE, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "effect.big"), 1F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final Holder<MobEffect> FLAT= EFFECT.register("flat",
            () -> new BasicEffect(MobEffectCategory.NEUTRAL, 0xf7fada));

    public static final Holder<MobEffect>  STRETCH= EFFECT.register("stretch",
            () -> new BasicEffect(MobEffectCategory.NEUTRAL, 0xf78d95));

    public static final Holder<MobEffect>  WIDE= EFFECT.register("wide",
            () -> new 	WideEffect(MobEffectCategory.NEUTRAL, 0x87ce87));

    public static final Holder<MobEffect>  EXPLODE= EFFECT.register("explode",
            () -> new 	ExplodeEffect(MobEffectCategory.HARMFUL, 0x565656));

    public static final Holder<MobEffect>  EXPLOSION= EFFECT.register("explosion",
            () -> new ExplosionEffect(MobEffectCategory.HARMFUL, 0x565656));

    public static final Holder<MobEffect>  BIND= EFFECT.register("bind",
            () -> new BindEffect(MobEffectCategory.HARMFUL, 0xffffff));

    public static final Holder<MobEffect>  FALL= EFFECT.register("fall",
            () -> new FallEffect(MobEffectCategory.HARMFUL, 0xffffff));

    public static final Holder<MobEffect>  SMELL= EFFECT.register("smell",
            () -> new SmellEffect(MobEffectCategory.HARMFUL, 0x853d1b));

    public static final Holder<MobEffect>  CHRISTMAS= EFFECT.register("christmas",
            () -> new ChristmasEffect(MobEffectCategory.BENEFICIAL,0x4eff00));

    public static final Holder<MobEffect>  FIRE_PUNCH= EFFECT.register("fire_punch",
            () -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0xf7c208));

    public static final Holder<MobEffect>  FIRE_SLASH= EFFECT.register("fire_slash",
            () -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0xf7c208));

    public static final Holder<MobEffect>  EXPLOSION_PUNCH= EFFECT.register("explosion_punch",
            () -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0xf7c208));

    public static final Holder<MobEffect>  EXPLOSION_SLASH= EFFECT.register("explosion_slash",
            () -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0xf7c208));

    public static final Holder<MobEffect>  FIRE_SHOT= EFFECT.register("fire_shot",
            () -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0xf7c208));

    public static final Holder<MobEffect>  EXPLOSION_SHOT= EFFECT.register("explosion_shot",
            () -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0xf7c208));

    public static final Holder<MobEffect>  FIRE_ARMOR= EFFECT.register("fire_armor",
            () -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0xf7c208));

    public static final Holder<MobEffect> RIDER_POISON_HAND = EFFECT.register("rider_poison_hand",
            () -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0x00b969));


    public static final Holder<MobEffect> GATLING= EFFECT.register("gatling",
            () -> new GatlingEffect(MobEffectCategory.NEUTRAL, 0x1d8519));

    public static final Holder<MobEffect> CANNON= EFFECT.register("cannon",
            () -> new CannonEffect(MobEffectCategory.NEUTRAL, 0x1d8519));

    public static final Holder<MobEffect> WARP= EFFECT.register("warp",
            () -> new WarpEffect(MobEffectCategory.NEUTRAL, 0x267d07));

    public static final Holder<MobEffect> STEALTH= EFFECT.register("stealth",
            () -> new StealthEffect(MobEffectCategory.BENEFICIAL, 0x8f62e8));

    public static final Holder<MobEffect> FISH= EFFECT.register("fish",
            () -> new FishEffect(MobEffectCategory.NEUTRAL, 0x267d07));


    public static final Holder<MobEffect>  REFLECT= EFFECT.register("reflect",
            () -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0xd1d1d1));

    public static final Holder<MobEffect> RETURN= EFFECT.register("return",
            () -> new ReturnEffect(MobEffectCategory.BENEFICIAL, 0xb3b3b3));

    public static final Holder<MobEffect>  SLEEP= EFFECT.register("sleep",
            () -> new 	SleepEffect(MobEffectCategory.NEUTRAL, 0xffce00));

    public static final Holder<MobEffect>  NIGHT= EFFECT.register("night",
            () -> new 	NightEffect(MobEffectCategory.HARMFUL, 0xffed9e));

    public static final Holder<MobEffect>  TIME= EFFECT.register("time",
            () -> new 	TimeEffect(MobEffectCategory.HARMFUL, 0xffed9e));

    public static final Holder<MobEffect>  BLIZZARD= EFFECT.register("blizzard",
            () -> new BlizzardEffect(MobEffectCategory.HARMFUL, 0x5feaff));

    public static final Holder<MobEffect>  THUNDER= EFFECT.register("thunder",
            () -> new ThunderEffect(MobEffectCategory.HARMFUL, 0x76ecff));

    public static final Holder<MobEffect>  THUNDER_PUNCH= EFFECT.register("thunder_punch",
            () -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0x76ecff));

    public static final Holder<MobEffect>  THUNDER_SLASH= EFFECT.register("thunder_slash",
            () -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0x76ecff));

    public static final Holder<MobEffect>  THUNDER_SHOT= EFFECT.register("thunder_shot",
            () -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0x76ecff));

    public static final Holder<MobEffect> CLIMBING= EFFECT.register("climbing",
            () -> new BasicEffect(MobEffectCategory.NEUTRAL, 0xffffff));


    public static final Holder<MobEffect>  FORM_TIMEOUT= EFFECT.register("form_timeout",
            () -> new UncurableEffect(MobEffectCategory.HARMFUL, 0xffffff));

    public static final Holder<MobEffect>  FORM_LOCK= EFFECT.register("form_lock",
            () -> new UncurableEffect(MobEffectCategory.HARMFUL, 0xffffff));

    public static final Holder<MobEffect>  GREEED= EFFECT.register("greeed",
            () -> new 	GreeedEffect(MobEffectCategory.HARMFUL, 0xc9c6c1));

    public static final Holder<MobEffect>  COSMIC_ENERGY= EFFECT.register("cosmic_energy",
            () -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0x55FFFF));

    public static final Holder<MobEffect>  HAPPY_MODE= EFFECT.register("happy_mode",
            () -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0xfff764));

    public static final Holder<MobEffect>  FLOWER= EFFECT.register("flower",
            () -> new FlowerEffect(MobEffectCategory.BENEFICIAL, 0xff0028));

    public static final Holder<MobEffect> CONNECT= EFFECT.register("connect",
            () -> new ConnectEffect(MobEffectCategory.BENEFICIAL, 0xad16d5));

    public static final Holder<MobEffect>  HEAVY_ACCELERATION= EFFECT.register("heavy_acceleration",
            () -> new 	HeavyAccelerationEffect(MobEffectCategory.BENEFICIAL, 0xc38edb));

    public static final Holder<MobEffect>  GHOST= EFFECT.register("ghost",
            () -> new 	GhostEffect(MobEffectCategory.BENEFICIAL, 0xf59b14));

    public static final Holder<MobEffect>  BUGSTER= EFFECT.register("bug",
            () -> new 	BugEffect(MobEffectCategory.HARMFUL, 0xe8842e));

    public static final Holder<MobEffect>  HAZARD_LEVEL= EFFECT.register("hazard_level",
            () -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0xff0000));

    public static final Holder<MobEffect>  RESET= EFFECT.register("reset",
            () -> new 	ResetEffect(MobEffectCategory.HARMFUL, 0x4eff00));

    public static final Holder<MobEffect>  MUTEKI= EFFECT.register("muteki",
            () -> new 	SaveEffect(MobEffectCategory.BENEFICIAL, 0xffce00));

    public static final Holder<MobEffect>  MIRROR_NOISES= EFFECT.register("mirror_noises",
            () -> new 	MirrorNoisesEffect(MobEffectCategory.HARMFUL, 0xc4c4c4));

    public static final Holder<MobEffect>  PAUSE= EFFECT.register("pause",
            () -> new BasicEffect(MobEffectCategory.HARMFUL, 0x4eff00)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "effect.pause"), -100F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(Attributes.GRAVITY, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "effect.pause"), 100F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static final Holder<MobEffect> WONDER = EFFECT.register("wonder",
            () -> new 	WonderEffect(MobEffectCategory.BENEFICIAL, 0x9d2cf3));



    public static final Holder<MobEffect>  PORTAL_COOLDOWN= EFFECT.register("portal_cooldown",
            () -> new UncurableEffect(MobEffectCategory.NEUTRAL, 0x6300e6));

    public static void register(IEventBus eventBus) {
        EFFECT.register(eventBus);
    }

}
