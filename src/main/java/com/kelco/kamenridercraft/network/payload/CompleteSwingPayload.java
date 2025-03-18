package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record CompleteSwingPayload(int hand) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<CompleteSwingPayload> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "complete_swing"));

    public static final StreamCodec<ByteBuf, CompleteSwingPayload> STREAM_CODEC = StreamCodec.composite(
        ByteBufCodecs.VAR_INT, CompleteSwingPayload::hand,
        CompleteSwingPayload::new
    );

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
