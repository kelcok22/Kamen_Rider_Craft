package com.kelco.kamenridercraft.network.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record ServerVehicleControlPayload(boolean forwards, boolean backwards, boolean left, boolean right, boolean jumping, boolean drifting) implements CustomPacketPayload {
    public static final Type<ServerVehicleControlPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("kamenridercraft", "vehicle_controls_server"));

    public static final StreamCodec<ByteBuf, ServerVehicleControlPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL, ServerVehicleControlPayload::forwards,
            ByteBufCodecs.BOOL, ServerVehicleControlPayload::backwards,
            ByteBufCodecs.BOOL, ServerVehicleControlPayload::left,
            ByteBufCodecs.BOOL, ServerVehicleControlPayload::right,
            ByteBufCodecs.BOOL, ServerVehicleControlPayload::jumping,
            ByteBufCodecs.BOOL, ServerVehicleControlPayload::drifting,
            ServerVehicleControlPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
