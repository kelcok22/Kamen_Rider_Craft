package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record StartPosePayload(String poseName, String UUID) implements CustomPacketPayload {
    public static final Type<StartPosePayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "start_pose"));

    public static final StreamCodec<ByteBuf, StartPosePayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, StartPosePayload::poseName,
            ByteBufCodecs.STRING_UTF8, StartPosePayload::UUID,
            StartPosePayload::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}