package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record EndPosePayload(int hand, String UUID) implements CustomPacketPayload {
    public static final Type<EndPosePayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "end_pose"));

    public static final StreamCodec<ByteBuf, EndPosePayload> STREAM_CODEC = StreamCodec.composite(
        ByteBufCodecs.VAR_INT, EndPosePayload::hand,
        ByteBufCodecs.STRING_UTF8, EndPosePayload::UUID,
        EndPosePayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
