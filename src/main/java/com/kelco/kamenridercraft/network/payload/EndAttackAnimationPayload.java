package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record EndAttackAnimationPayload(String UUID) implements CustomPacketPayload {
    public static final Type<EndAttackAnimationPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "end_attack_animation"));

    public static final StreamCodec<ByteBuf, EndAttackAnimationPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, EndAttackAnimationPayload::UUID,
            EndAttackAnimationPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
