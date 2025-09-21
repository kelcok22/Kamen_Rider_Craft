package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record AbilityKeyPayload(int hand) implements CustomPacketPayload {
    public static final Type<AbilityKeyPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "ability_key"));

    public static final StreamCodec<ByteBuf, AbilityKeyPayload> STREAM_CODEC = StreamCodec.composite(
        ByteBufCodecs.VAR_INT, AbilityKeyPayload::hand,
        AbilityKeyPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
