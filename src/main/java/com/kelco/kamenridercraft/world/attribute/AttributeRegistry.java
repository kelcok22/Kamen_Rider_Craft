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

@EventBusSubscriber(modid = KamenRiderCraftCore.MOD_ID, bus=EventBusSubscriber.Bus.MOD)
public class AttributeRegistry extends Event implements IModBusEvent {

    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(Registries.ATTRIBUTE, KamenRiderCraftCore.MOD_ID);



    public static final DeferredHolder<Attribute, Attribute> WINGS_OUT = ATTRIBUTES.register("wing_out",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.wings_out",
                    0,
                    0,
                    1
            ).setSyncable(true)
    );


    public static final DeferredHolder<Attribute, Attribute> IS_TRANSFORMING_OLD = ATTRIBUTES.register("is_transforming_old",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.is_transforming",
                    0,
                    0,
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

    public static final DeferredHolder<Attribute, Attribute> USING_ABILITY = ATTRIBUTES.register("using_ability",
            () -> new BooleanAttribute(
                    "attribute.kamenridercraftcore.using_ability",
                    false

            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> IS_TRANSFORMED = ATTRIBUTES.register("is_transformed",
            () -> new BooleanAttribute(
                    "attribute.kamenridercraftcore.is_transformed",
                    false

            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> POSING = ATTRIBUTES.register("posing",
            () -> new BooleanAttribute(
                    "attribute.kamenridercraftcore.posing",
                    false

            ).setSyncable(true)
    );


    public static final DeferredHolder<Attribute, Attribute> POSE_COOLDOWN = ATTRIBUTES.register("pose_cooldown",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.pose_cooldown",
                    0,
                    0,
                    9999
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
