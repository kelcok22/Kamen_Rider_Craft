package com.kelco.kamenridercraft.effect.cores;


import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.portal.DimensionTransition;
import java.util.HashSet;


public class ReturnEffect extends InstantenousMobEffect {


	public ReturnEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	public static void teleportToDimension(ServerLevel otherDim, ServerPlayer entity) {
		DimensionTransition respawn = entity.findRespawnPositionAndUseSpawnBlock(false, DimensionTransition.DO_NOTHING);
		if (entity.isPassenger()) entity.stopRiding();
		entity.teleportTo(otherDim, respawn.pos().x(), Mth.clamp(respawn.pos().y(), otherDim.getMinBuildHeight(), otherDim.getMinBuildHeight() + otherDim.getLogicalHeight() - 1), respawn.pos().z(), new HashSet<>(), 0, 0);
		while (!otherDim.noCollision(entity) || otherDim.containsAnyLiquid(entity.getBoundingBox())) entity.teleportRelative(0.0, 2.0, 0.0);
		entity.randomTeleport(entity.getX(), entity.getY(), entity.getZ(), false);
	}



	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide() && pLivingEntity.level() instanceof ServerLevel && pLivingEntity instanceof ServerPlayer player) {
			MinecraftServer Server = player.getServer();
			teleportToDimension(Server.overworld(),player);
		}
		return false;
	}
}


