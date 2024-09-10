package com.kelco.kamenridercraft.effect;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.effect.cores.*;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class Effect_core {

    public static final DeferredRegister<MobEffect> EFFECT = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT,KamenRiderCraftCore.MOD_ID);


    public static final Holder<MobEffect>BOOST = EFFECT.register("boost",
            () -> new BoostEffect(MobEffectCategory.BENEFICIAL, 0xff0015));

    public static final Holder<MobEffect> ANTIPOISON = EFFECT.register("anti_poison",
            () -> new AntiPoisonEffect(MobEffectCategory.BENEFICIAL, 0x8532a8));

    public static final Holder<MobEffect>SLASH= EFFECT.register("slash",
            () -> new SlashEffect(MobEffectCategory.BENEFICIAL, 0x21daff));

    public static final Holder<MobEffect> SHOT_BOOST= EFFECT.register("shot_boost",
            () -> new ShotBoostEffect(MobEffectCategory.BENEFICIAL, 0x21daff));

    public static final Holder<MobEffect> PUNCH= EFFECT.register("punch",
            () -> new PunchEffect(MobEffectCategory.BENEFICIAL, 0x1d8519));

    public static final Holder<MobEffect> FLYING= EFFECT.register("flying",
            () -> new 	FlyingEffect(MobEffectCategory.BENEFICIAL, 0x1d8519) );

    public static final Holder<MobEffect> SMALL= EFFECT.register("small",
            () -> new 	SmallEffect(MobEffectCategory.NEUTRAL, 0x1d8519)
                    .addAttributeModifier(Attributes.SCALE, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "effect.small"), -0.1F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));


    public static final Holder<MobEffect> BIG= EFFECT.register("big",
            () -> new 	BigEffect(MobEffectCategory.NEUTRAL, 0x1d8519)
                    .addAttributeModifier(Attributes.SCALE, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "effect.big"), 1F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));


    public static final Holder<MobEffect> FLAT= EFFECT.register("flat",
            () -> new 	FlatEffect(MobEffectCategory.NEUTRAL, 0xf7fada));

    public static final Holder<MobEffect>  STRETCH= EFFECT.register("stretch",
            () -> new 	StretchEffect(MobEffectCategory.NEUTRAL, 0xf78d95));

    public static final Holder<MobEffect>  WIDE= EFFECT.register("wide",
            () -> new 	WideEffect(MobEffectCategory.NEUTRAL, 0x87ce87));

    public static final Holder<MobEffect>  EXPLODE= EFFECT.register("explode",
            () -> new 	ExplodeEffect(MobEffectCategory.HARMFUL, 0x565656));

    public static final Holder<MobEffect>  FIRE_PUNCH= EFFECT.register("fire_punch",
            () -> new 	FirePunchEffect(MobEffectCategory.BENEFICIAL, 0xf7c208));

    public static final Holder<MobEffect>  EXPLOSION_PUNCH= EFFECT.register("explosion_punch",
            () -> new 	ExplosionPunchEffect(MobEffectCategory.BENEFICIAL, 0xf7c208));

    public static final Holder<MobEffect>  FIRE_SHOT= EFFECT.register("fire_shot",
            () -> new 	FireShotEffect(MobEffectCategory.BENEFICIAL, 0xf7c208));

    public static final Holder<MobEffect>  EXPLOSION_SHOT= EFFECT.register("explosion_shot",
            () -> new 	ExplosionShotEffect(MobEffectCategory.BENEFICIAL, 0xf7c208));

    public static final Holder<MobEffect>  FIRE_ARMOR= EFFECT.register("fire_armor",
            () -> new 	FireArmorEffect(MobEffectCategory.BENEFICIAL, 0xf7c208));

    public static final Holder<MobEffect>  REFLECT= EFFECT.register("reflect",
            () -> new 	ReflectEffect(MobEffectCategory.BENEFICIAL, 0xd1d1d1));

    public static final Holder<MobEffect>  SLEEP= EFFECT.register("sleep",
            () -> new 	SleepEffect(MobEffectCategory.NEUTRAL, 0xffce00));

    public static final Holder<MobEffect>  NIGHT= EFFECT.register("night",
            () -> new 	NightEffect(MobEffectCategory.HARMFUL, 0xffed9e));

    public static final Holder<MobEffect>  THUNDER= EFFECT.register("thunder",
            () -> new ThunderEffect(MobEffectCategory.HARMFUL, 0x76ecff));


    public static final Holder<MobEffect>  FORM_LOCK= EFFECT.register("form_lock",
            () -> new 	FormLockEffect(MobEffectCategory.HARMFUL, 0xffffff));

    public static final Holder<MobEffect>  GREEED= EFFECT.register("greeed",
            () -> new 	GreeedEffect(MobEffectCategory.HARMFUL, 0xc9c6c1));

    public static final Holder<MobEffect>  BUGSTER= EFFECT.register("bug",
            () -> new 	BugEffect(MobEffectCategory.HARMFUL, 0xe8842e));

    public static final Holder<MobEffect>  RESET= EFFECT.register("reset",
            () -> new 	ResetEffect(MobEffectCategory.HARMFUL, 0x4eff00));

    public static final Holder<MobEffect>  MUTEKI= EFFECT.register("muteki",
            () -> new 	SaveEffect(MobEffectCategory.BENEFICIAL, 0xffce00));

    public static final Holder<MobEffect>  PAUSE= EFFECT.register("pause",
            () -> new 	PauseEffect(MobEffectCategory.HARMFUL, 0x4eff00)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "effect.pause"), (double)-100F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(Attributes.GRAVITY, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "effect.pause"), (double)100F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );


    public static void register(IEventBus eventBus) {
        EFFECT.register(eventBus);
    }

}
