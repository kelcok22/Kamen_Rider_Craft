package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record StartPosePayload(int hand, String UUID) implements CustomPacketPayload {
    public static final Type<StartPosePayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "start_pose"));

    public static final StreamCodec<ByteBuf, StartPosePayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, StartPosePayload::hand,
            ByteBufCodecs.STRING_UTF8, StartPosePayload::UUID,
            StartPosePayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
