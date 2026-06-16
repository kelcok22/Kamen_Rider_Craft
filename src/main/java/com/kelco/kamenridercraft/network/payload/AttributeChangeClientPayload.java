package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record AttributeChangeClientPayload(String id, String attributeName,
                                           Double valueChange) implements CustomPacketPayload {
    public static final Type<AttributeChangeClientPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "attribute_change_client"));

    public static final StreamCodec<ByteBuf, AttributeChangeClientPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, AttributeChangeClientPayload::id,
            ByteBufCodecs.STRING_UTF8, AttributeChangeClientPayload::attributeName,
            ByteBufCodecs.DOUBLE, AttributeChangeClientPayload::valueChange,
            AttributeChangeClientPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
