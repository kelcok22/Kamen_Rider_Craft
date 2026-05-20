package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record StartKickPayload(String move, String UUID) implements CustomPacketPayload {
    public static final Type<StartKickPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "start_kick_anim"));

    public static final StreamCodec<ByteBuf, StartKickPayload> STREAM_CODEC = StreamCodec.composite(
        ByteBufCodecs.STRING_UTF8, StartKickPayload::move,
        ByteBufCodecs.STRING_UTF8, StartKickPayload::UUID,
        StartKickPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
