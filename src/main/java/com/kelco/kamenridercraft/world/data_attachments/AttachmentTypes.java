package com.kelco.kamenridercraft.world.data_attachments;

import com.mojang.serialization.Codec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.MOD_ID;

public class AttachmentTypes {
    private static final DeferredRegister<AttachmentType<?>> REGISTRY = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MOD_ID);

    public static final Supplier<AttachmentType<Integer>> ABILITY_METER = REGISTRY.register(
            "ability_meter", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );

    public static final Supplier<AttachmentType<String>> STRING_TEST = REGISTRY.register(
            "string_test", () -> AttachmentType.builder(() -> "failed_test").serialize(Codec.STRING).build()
    );

    public static final Supplier<AttachmentType<Boolean>> IS_POSING = REGISTRY.register(
            "is_posing", () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL).build()
    );

    public static final Supplier<AttachmentType<Integer>> POSE_COOLDOWN = REGISTRY.register(
            "pose_cooldown", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );

    public static final Supplier<AttachmentType<Integer>> ABILITY_COOLDOWN = REGISTRY.register(
            "ability_cooldown", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );

    public static final Supplier<AttachmentType<Integer>> ABILITY_TICK = REGISTRY.register(
            "ability_tick", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );

    public static final Supplier<AttachmentType<String>> USED_ABILITY = REGISTRY.register(
            "used_ability", () -> AttachmentType.builder(() -> "").serialize(Codec.STRING).build()
    );

    public static final Supplier<AttachmentType<String>> ACTIVE_ABILITY = REGISTRY.register(
            "active_ability", () -> AttachmentType.builder(() -> "").serialize(Codec.STRING).build()
    );

    public static final Supplier<AttachmentType<String>> PASSIVE_ABILITY = REGISTRY.register(
            "passive_ability", () -> AttachmentType.builder(() -> "").serialize(Codec.STRING).build()
    );

    public static final Supplier<AttachmentType<Boolean>> MOB_TRANSFORMED = REGISTRY.register(
            "mob_transformed", () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL).build()
    );

    public static final Supplier<AttachmentType<Boolean>> WINGS_OUT = REGISTRY.register(
            "wings_out", () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL).build()
    );

    public static final Supplier<AttachmentType<Boolean>> DELAY_ANIMATION_END = REGISTRY.register(
            "delay_animation_end", () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL).build()
    );

    public static final Supplier<AttachmentType<Integer>> DELAY_ANIMATION_END_TICKS = REGISTRY.register(
            "delay_animation_end_ticks", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );

    public static void register(IEventBus eventBus) {REGISTRY.register(eventBus);}
}
