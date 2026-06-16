package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record PrimaryAbilityKeyPayload(int hand) implements CustomPacketPayload {
    public static final Type<PrimaryAbilityKeyPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "primary_ability_key"));

    public static final StreamCodec<ByteBuf, PrimaryAbilityKeyPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, PrimaryAbilityKeyPayload::hand,
            PrimaryAbilityKeyPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
