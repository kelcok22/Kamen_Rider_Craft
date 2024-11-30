package com.kelco.kamenridercraft.item.Fourze;

import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.DimensionTransition;
import net.neoforged.neoforge.server.ServerLifecycleHooks;

import java.util.HashSet;
import java.util.function.Consumer;


public class GateSwitchItem extends BaseItem {

	private int TIME = 500;

	public GateSwitchItem(Properties properties, int time)
	{
		super(properties);
		TIME=time;
	}

	public static void teleportToDimension(ItemStack itemstack,ServerLevel otherDim, ServerPlayer entity,int dim) {

		DimensionTransition respawn = entity.findRespawnPositionAndUseSpawnBlock(false, DimensionTransition.DO_NOTHING);
		if (entity.isPassenger()) entity.stopRiding();

	 if (dim==1) {
		 entity.teleportTo(otherDim, 40, Mth.clamp(respawn.pos().y(), (double)otherDim.getMinBuildHeight(), (double)(otherDim.getMinBuildHeight() + ((ServerLevel)otherDim).getLogicalHeight() - 1)), 40, new HashSet<>(), 0, 0);
		 while (!otherDim.noCollision(entity) || otherDim.containsAnyLiquid(entity.getBoundingBox())) entity.teleportRelative(0.0, 2.0, 0.0);
		 entity.randomTeleport(40, 60, 40, false);

		 }else {

		 double X=get_XYZ(itemstack,"x",respawn.pos().x());
		 double Y=get_XYZ(itemstack,"y",respawn.pos().y());
		 double Z=get_XYZ(itemstack,"z",respawn.pos().z());
		 entity.sendSystemMessage(Component.translatable("X"+X+",Y"+Y+",Z"+Z).withStyle(ChatFormatting.RED));
		 entity.teleportTo(otherDim, X,Y,Z, new HashSet<>(), 0, 0);
		 while (!otherDim.noCollision(entity) || otherDim.containsAnyLiquid(entity.getBoundingBox())) entity.teleportRelative(0.0, 2.0, 0.0);
		 entity.randomTeleport(X, Y, Z, false);
	 }
	}


	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

		ResourceKey<Level> MOON = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:moon"));
		MinecraftServer Server = ServerLifecycleHooks.getCurrentServer();
		if (p_41129_ instanceof ServerPlayer player) {
			if (!p_41128_.isClientSide()) {
				if (p_41128_.dimension() == MOON) {
					teleportToDimension(itemstack,Server.overworld(), player,0);
				} else {
					double X=player.position().x;
					double Y=player.position().y;
					double Z=player.position().z;
					player.sendSystemMessage(Component.translatable("X"+X+",Y"+Y+",Z"+Z).withStyle(ChatFormatting.RED));
					Save_XYZ(itemstack,X,Y,Z,p_41129_);
					teleportToDimension(itemstack,Server.getLevel(MOON), player,1);
				}
				p_41129_.getCooldowns().addCooldown(this, TIME);
			}
		}
		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}

	public static double get_XYZ(ItemStack itemstack, String slot,double respawn) {
		if (itemstack.getComponents().has(DataComponents.CUSTOM_DATA)) {
			CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
			return tag.getDouble(slot);
		}
		return respawn;
	}

	public static void Save_XYZ(ItemStack itemstack,double X,double Y,double Z,Player p_41129_ )
	{
		if (!itemstack.getComponents().has(DataComponents.CUSTOM_DATA)) {
			itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
		}
			CompoundTag tag = new CompoundTag();
			Consumer<CompoundTag> data = form ->
			{
				p_41129_.sendSystemMessage(Component.translatable("X"+X+",Y"+Y+",Z"+Z).withStyle(ChatFormatting.RED));

				form.putDouble("x", X);
				form.putDouble("y", Y);
				form.putDouble("z", Z);

			};
			data.accept(tag);
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);

	}

}