package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record AttributeChangePayload(String id, String attributeName,
                                     Double valueChange) implements CustomPacketPayload {
    public static final Type<AttributeChangePayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "attribute_change"));

    public static final StreamCodec<ByteBuf, AttributeChangePayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, AttributeChangePayload::id,
            ByteBufCodecs.STRING_UTF8, AttributeChangePayload::attributeName,
            ByteBufCodecs.DOUBLE, AttributeChangePayload::valueChange,
            AttributeChangePayload::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}