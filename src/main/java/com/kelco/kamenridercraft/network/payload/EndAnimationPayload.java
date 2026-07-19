package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record EndAnimationPayload(String UUID, String controller, boolean abruptStop) implements CustomPacketPayload {
    public static final Type<EndAnimationPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "end_animation"));

    public static final StreamCodec<ByteBuf, EndAnimationPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, EndAnimationPayload::UUID,
            ByteBufCodecs.STRING_UTF8, EndAnimationPayload::controller,
            ByteBufCodecs.BOOL, EndAnimationPayload::abruptStop,
            EndAnimationPayload::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}