package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record SecondaryAbilityKeyPayload(int hand) implements CustomPacketPayload {
    public static final Type<SecondaryAbilityKeyPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "secondary_ability_key"));

    public static final StreamCodec<ByteBuf, SecondaryAbilityKeyPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, SecondaryAbilityKeyPayload::hand,
            SecondaryAbilityKeyPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
