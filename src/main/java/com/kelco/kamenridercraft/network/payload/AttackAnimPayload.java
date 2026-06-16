package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record AttackAnimPayload(String move, String UUID) implements CustomPacketPayload {
    public static final Type<AttackAnimPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "attack_anim_payload"));

    public static final StreamCodec<ByteBuf, AttackAnimPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, AttackAnimPayload::move,
            ByteBufCodecs.STRING_UTF8, AttackAnimPayload::UUID,
            AttackAnimPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
