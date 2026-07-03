package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record EndAnimationPayload(String UUID, String controller) implements CustomPacketPayload {
    public static final Type<EndAnimationPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "end_animation"));

    public static final StreamCodec<ByteBuf, EndAnimationPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, EndAnimationPayload::UUID,
            ByteBufCodecs.STRING_UTF8, EndAnimationPayload::controller,
            EndAnimationPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
