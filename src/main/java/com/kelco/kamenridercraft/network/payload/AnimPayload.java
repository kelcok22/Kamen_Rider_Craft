package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record AnimPayload(String move, String controller, boolean forceNextPose, String UUID) implements CustomPacketPayload {
    public static final Type<AnimPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "attack_anim_payload"));

    public static final StreamCodec<ByteBuf, AnimPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, AnimPayload::move,
            ByteBufCodecs.STRING_UTF8, AnimPayload::controller,
            ByteBufCodecs.BOOL, AnimPayload::forceNextPose,
            ByteBufCodecs.STRING_UTF8, AnimPayload::UUID,
            AnimPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
