package com.kelco.kamenridercraft.attachments;

import com.mojang.serialization.Codec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.MOD_ID;

public class AbilityAttachments {
    private static final DeferredRegister<AttachmentType<?>> REGISTRY = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MOD_ID);

    public static final Supplier<AttachmentType<Integer>> ABILITY_METER = REGISTRY.register(
            "ability_meter", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );

    public static final Supplier<AttachmentType<Integer>> MAX_ABILITY_METER = REGISTRY.register(
            "max_ability_meter", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );

    public static final Supplier<AttachmentType<Float>> ABILITY_METER_MULTIPLIER = REGISTRY.register(
            "ability_meter_multiplier", () -> AttachmentType.builder(() -> 1F).serialize(Codec.FLOAT).build()
    );


    public static final Supplier<AttachmentType<Integer>> GLOBAL_ABILITY_CD = REGISTRY.register(
            "global_ability_cd", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );

    public static final Supplier<AttachmentType<Integer>> ACTIVE_ABILITY_CD  = REGISTRY.register(
            "active_ability_cd", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );
    public static final Supplier<AttachmentType<Integer>> PASSIVE_ABILITY_CD  = REGISTRY.register(
            "passive_ability_cd", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );



    public static final Supplier<AttachmentType<Integer>> ACTIVE_ABILITY_TICK = REGISTRY.register(
            "active_ability_tick", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );

    public static final Supplier<AttachmentType<Integer>> PASSIVE_ABILITY_TICK = REGISTRY.register(
            "passive_ability_tick", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );

    public static final Supplier<AttachmentType<String>> ABILITY_ONE = REGISTRY.register(
            "used_ability", () -> AttachmentType.builder(() -> "").serialize(Codec.STRING).build()
    );

    public static final Supplier<AttachmentType<String>> ACTIVE_ABILITY = REGISTRY.register(
            "active_ability", () -> AttachmentType.builder(() -> "").serialize(Codec.STRING).build()
    );

    public static final Supplier<AttachmentType<String>> PASSIVE_ABILITY = REGISTRY.register(
            "passive_ability", () -> AttachmentType.builder(() -> "").serialize(Codec.STRING).build()
    );

    public static void register(IEventBus eventBus) {REGISTRY.register(eventBus);}
}
