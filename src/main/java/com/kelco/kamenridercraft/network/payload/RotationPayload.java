package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record RotationPayload(int hand, String rotChanged, Float valueChange) implements CustomPacketPayload {
    public static final Type<RotationPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "player_rotations"));

    public static final StreamCodec<ByteBuf, RotationPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, RotationPayload::hand,
            ByteBufCodecs.STRING_UTF8, RotationPayload::rotChanged,
            ByteBufCodecs.FLOAT, RotationPayload::valueChange,
            RotationPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
