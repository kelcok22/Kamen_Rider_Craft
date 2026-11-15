package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record AttributeChangeClientPayload(String id, double ball, double wheel , double cape) implements CustomPacketPayload {
    public static final Type<AttributeChangeClientPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "attribute_change_client"));

    public static final StreamCodec<ByteBuf, AttributeChangeClientPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, AttributeChangeClientPayload::id,
            ByteBufCodecs.DOUBLE, AttributeChangeClientPayload::ball,
            ByteBufCodecs.DOUBLE, AttributeChangeClientPayload::wheel,
            ByteBufCodecs.DOUBLE, AttributeChangeClientPayload::cape,
            AttributeChangeClientPayload::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}