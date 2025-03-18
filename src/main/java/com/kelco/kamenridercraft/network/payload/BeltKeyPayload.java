package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record BeltKeyPayload(int hand) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<BeltKeyPayload> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "belt_key"));

    public static final StreamCodec<ByteBuf, BeltKeyPayload> STREAM_CODEC = StreamCodec.composite(
        ByteBufCodecs.VAR_INT, BeltKeyPayload::hand,
        BeltKeyPayload::new
    );

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
