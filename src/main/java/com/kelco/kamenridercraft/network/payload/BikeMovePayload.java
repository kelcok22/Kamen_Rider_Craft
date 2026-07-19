package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record BikeMovePayload(int id, float yBody ,float yHead,float wheelRot) implements CustomPacketPayload {
    public static final Type<BikeMovePayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "bike_move"));

    public static final StreamCodec<ByteBuf, BikeMovePayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, BikeMovePayload::id,
            ByteBufCodecs.FLOAT, BikeMovePayload::yBody,
            ByteBufCodecs.FLOAT, BikeMovePayload::yHead,
            ByteBufCodecs.FLOAT, BikeMovePayload::wheelRot,
            BikeMovePayload::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}