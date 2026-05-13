package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record AttributeChangePayload(int hand, String attributeName, Double valueChange) implements CustomPacketPayload {
    public static final Type<AttributeChangePayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "attribute_change"));

    public static final StreamCodec<ByteBuf, AttributeChangePayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, AttributeChangePayload::hand,
            ByteBufCodecs.STRING_UTF8, AttributeChangePayload::attributeName,
            ByteBufCodecs.DOUBLE, AttributeChangePayload::valueChange,
            AttributeChangePayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
