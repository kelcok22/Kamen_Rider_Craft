package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record AttributeChangePayload(String id, Double valueChange, float x, float z ) implements CustomPacketPayload {
    public static final Type<AttributeChangePayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "attribute_change"));

    public static final StreamCodec<ByteBuf, AttributeChangePayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, AttributeChangePayload::id,
            ByteBufCodecs.DOUBLE, AttributeChangePayload::valueChange,
            ByteBufCodecs.FLOAT, AttributeChangePayload::x,
            ByteBufCodecs.FLOAT, AttributeChangePayload::z,
            AttributeChangePayload::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}