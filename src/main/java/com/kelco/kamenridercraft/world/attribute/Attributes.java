package com.kelco.kamenridercraft.world.attribute;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.common.BooleanAttribute;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(modid = KamenRiderCraftCore.MOD_ID)
public class Attributes extends Event implements IModBusEvent {

    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(Registries.ATTRIBUTE, KamenRiderCraftCore.MOD_ID);


    public static final DeferredHolder<Attribute, Attribute> TOJIMA = ATTRIBUTES.register("tojima",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.tojima",
                    0,
                    0,
                    100
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> WIND = ATTRIBUTES.register("wind",
            () -> new BooleanAttribute(
                    "attribute.kamenridercraftcore.wind",
                    false
            ).setSyncable(true)
    );


    public static final DeferredHolder<Attribute, Attribute> WINGS_OUT = ATTRIBUTES.register("wing_out",
            () -> new BooleanAttribute(
                    "attribute.kamenridercraftcore.wings_out",
                    false
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> POSE_MODEL_MODIFIER = ATTRIBUTES.register("pose_model_modifier",
            () -> new BooleanAttribute(
                    "attribute.kamenridercraftcore.pose_model_modifier",
                    false
            ).setSyncable(true)
    );


    public static final DeferredHolder<Attribute, Attribute> CHANGE_KICK_MODEL = ATTRIBUTES.register("change_kick_model",
            () -> new BooleanAttribute(
                    "attribute.kamenridercraftcore.change_kick_model",
                    false
            ).setSyncable(true)
    );


    public static final DeferredHolder<Attribute, Attribute> CAPE_ROT_OLD = ATTRIBUTES.register("cape_rotation_old",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.cape_rotation_old",
                    0,
                    -30,
                    30
            ).setSyncable(true)
    );


    public static final DeferredHolder<Attribute, Attribute> CAPE_ROT = ATTRIBUTES.register("cape_rotation",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.cape_rotation",
                    0,
                    -30,
                    30
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> WHEEL_ROT_OLD = ATTRIBUTES.register("wheel_rotation_old",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.wheel_rotation_old",
                    0,
                    -30,
                    30
            ).setSyncable(true)
    );


    public static final DeferredHolder<Attribute, Attribute> WHEEL_ROT = ATTRIBUTES.register("wheel_rotation",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.wheel_rotation",
                    0,
                    -30,
                    30
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> BALL_ROT_OLD = ATTRIBUTES.register("ball_rotation_old",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.cape_rotation_old",
                    0,
                    -30,
                    30
            ).setSyncable(true)
    );


    public static final DeferredHolder<Attribute, Attribute> BALL_ROT = ATTRIBUTES.register("ball_rotation",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.ball_rotation",
                    0,
                    -30,
                    30
            ).setSyncable(true)
    );


    public static final DeferredHolder<Attribute, Attribute> IS_TRANSFORMING = ATTRIBUTES.register("is_transforming",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.is_transforming",
                    0,
                    0,
                    30
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> REINFORCEMENT_CHANCE = ATTRIBUTES.register("reinforcement_chance",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.reinforcement_chance",
                    0,
                    0,
                    100
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> CLIMBING = ATTRIBUTES.register("climbing",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.climbing",
                    0,
                    0,
                    255
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> HAS_TIME = ATTRIBUTES.register("has_time",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.has_time",
                    0,
                    0,
                    1
            ).setSyncable(true)
    );
    public static final DeferredHolder<Attribute, Attribute> HAS_BUG = ATTRIBUTES.register("has_bug",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.has_bug",
                    0,
                    0,
                    1
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> HEAD_SIZE = ATTRIBUTES.register("head_size",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.head_size",
                    1,
                    0,
                    255
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> PLAYER_SIZE_X = ATTRIBUTES.register("player_size_x",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.player_size",
                    1,
                    0,
                    255
            ).setSyncable(true)
    );
    public static final DeferredHolder<Attribute, Attribute> PLAYER_SIZE_Y = ATTRIBUTES.register("player_size_y",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.player_size",
                    1,
                    0,
                    255
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> PLAYER_SIZE_Z = ATTRIBUTES.register("player_size_z",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.player_size",
                    1,
                    0,
                    255
            ).setSyncable(true)
    );


    public static final DeferredHolder<Attribute, Attribute> ABILITY_METER = ATTRIBUTES.register("ability_meter",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.ability_meter",
                    0,
                    0,
                    300
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> MAX_ABILITY_METER = ATTRIBUTES.register("max_ability_meter",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore._max_ability_meter",
                    300,
                    0,
                    1000
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> HELD_ABILITY_KEY_ONE = ATTRIBUTES.register("held_ability_key_one",
            () -> new BooleanAttribute(
                    "attribute.kamenridercraftcore.held_ability_key_one",
                    false
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> HELD_ABILITY_KEY_TWO = ATTRIBUTES.register("held_ability_key_two",
            () -> new BooleanAttribute(
                    "attribute.kamenridercraftcore.held_ability_key_two",
                    false
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> HAZARD_LEVEL = ATTRIBUTES.register("hazard_level",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.hazard_level",
                    0,
                    0,
                    10
            ).setSyncable(true)
    );

    @SubscribeEvent
    public static void modifyEntityAttributes(EntityAttributeModificationEvent eMod) {
        eMod.getTypes().forEach(entity -> ATTRIBUTES.getEntries().forEach(attribute -> eMod.add(entity, attribute)));
        // eMod.getTypes().forEach(entity -> eMod.add(entity, HEAD_SIZE));
    }

//    @SubscribeEvent
//    public static void addAttributes(EntityAttributeModificationEvent event) {
//        event.add(EntityType.PLAYER, POSING);
//        event.add(EntityType.PLAYER, POSE_COOLDOWN);
//        event.add(EntityType.PLAYER, HAZARD_LEVEL);
//    }

}
