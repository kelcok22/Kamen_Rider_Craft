package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record PoseKeyPayload(int hand) implements CustomPacketPayload {
    public static final Type<PoseKeyPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "pose_key"));

    public static final StreamCodec<ByteBuf, PoseKeyPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, PoseKeyPayload::hand,
            PoseKeyPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
