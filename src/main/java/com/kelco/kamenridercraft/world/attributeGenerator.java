package com.kelco.kamenridercraft.world;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
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
public class attributeGenerator extends Event implements IModBusEvent {

    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(Registries.ATTRIBUTE, KamenRiderCraftCore.MOD_ID);


    public static final DeferredHolder<Attribute, Attribute> WHEEL_ROT = ATTRIBUTES.register("wheel_rotation",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.wheel_rotation",
                    0,
                    0,
                    360
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> ABILITY_ONE_CD = ATTRIBUTES.register("ability_one_cd",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.ability_one_cd",
                    0,
                    0,
                    10000
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> ABILITY_ONE_TOGGLE = ATTRIBUTES.register("ability_one_toggle",
            () -> new BooleanAttribute(
                    "attribute.kamenridercraftcore.ability_one_toggle",
                    false

            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> ABILITY_TWO_CD = ATTRIBUTES.register("ability_two_cd",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.ability_two_cd",
                    0,
                    0,
                    10000
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> ABILITY_TWO_TOGGLE = ATTRIBUTES.register("ability_two_toggle",
            () -> new BooleanAttribute(
                    "attribute.kamenridercraftcore.ability_two_toggle",
                    false

            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> ABILITY_THREE_CD = ATTRIBUTES.register("ability_three_cd",
            () -> new RangedAttribute(
                    "attribute.kamenridercraftcore.ability_three_cd",
                    0,
                    0,
                    10000
            ).setSyncable(true)
    );

    public static final DeferredHolder<Attribute, Attribute> ABILITY_THREE_TOGGLE = ATTRIBUTES.register("ability_three_toggle",
            () -> new BooleanAttribute(
                    "attribute.kamenridercraftcore.ability_three_toggle",
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

    public static final DeferredHolder<Attribute, Attribute> IS_REINFORCEMENT = ATTRIBUTES.register("is_reinforcement",
            () -> new BooleanAttribute(
                    "attribute.kamenridercraftcore.is_reinforcement",
                    false

            ).setSyncable(true)
    );

//    @SubscribeEvent
//    public static void modifyEntityAttributes(EntityAttributeModificationEvent eMod) {
//        eMod.getTypes().forEach(entity -> ATTRIBUTES.getEntries().forEach(attribute -> eMod.add(entity, attribute)));
//    }

    @SubscribeEvent
    public static void addAttributes(EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER, ABILITY_ONE_TOGGLE);
        event.add(EntityType.PLAYER, ABILITY_ONE_CD);
        event.add(EntityType.PLAYER, ABILITY_TWO_TOGGLE);
        event.add(EntityType.PLAYER, ABILITY_TWO_CD);
        event.add(EntityType.PLAYER, ABILITY_THREE_TOGGLE);
        event.add(EntityType.PLAYER, ABILITY_THREE_CD);
        event.add(EntityType.PLAYER, HAZARD_LEVEL);
    }

}
