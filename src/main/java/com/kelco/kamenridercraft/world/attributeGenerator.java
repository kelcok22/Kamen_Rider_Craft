package com.kelco.kamenridercraft.world;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(modid = KamenRiderCraftCore.MOD_ID, bus=EventBusSubscriber.Bus.MOD)
public class attributeGenerator extends Event implements IModBusEvent {

    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(Registries.ATTRIBUTE, KamenRiderCraftCore.MOD_ID);


//    public static final DeferredHolder<Attribute, Attribute> RIDER_KICK = ATTRIBUTES.register("rider_kicking",
//            () -> new RangedAttribute(
//                    "attribute.kamenridercraftcore.rider_kicking",
//                    0,
//                    0,
//                    1
//            ).setSyncable(true)
//    );

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
    }

//    @SubscribeEvent
//    public static void addAttributesToPlayer(EntityAttributeModificationEvent event) {
//        event.add(EntityType.PLAYER, RIDER_KICK);
//    }

}
