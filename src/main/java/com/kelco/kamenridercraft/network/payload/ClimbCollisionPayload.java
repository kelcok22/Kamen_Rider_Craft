package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record ClimbCollisionPayload(int hand) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ClimbCollisionPayload> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "climb_collision"));

    public static final StreamCodec<ByteBuf, ClimbCollisionPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, ClimbCollisionPayload::hand,
            ClimbCollisionPayload::new
    );

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
