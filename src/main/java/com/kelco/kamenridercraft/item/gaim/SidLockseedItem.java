package com.kelco.kamenridercraft.item.gaim;

import java.util.HashSet;
import java.util.List;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.server.ServerLifecycleHooks;


public class SidLockseedItem extends BaseItem {

	private int TIME = 500;

	public SidLockseedItem (Properties properties, int time)
	{
		super(properties);
		TIME=time;
	}

	public static void teleportToDimension(ServerLevel otherDim, LivingEntity entity) {
		if (entity.isPassenger()) entity.stopRiding();
		entity.teleportTo(otherDim, entity.getX(), Mth.clamp(entity.getY(), (double)otherDim.getMinBuildHeight(), (double)(otherDim.getMinBuildHeight() + ((ServerLevel)otherDim).getLogicalHeight() - 1)), entity.getZ(), new HashSet<>(), 0, 0);
		while (!otherDim.noCollision(entity) || otherDim.containsAnyLiquid(entity.getBoundingBox())) entity.teleportRelative(0.0, 2.0, 0.0);
		entity.randomTeleport(entity.getX(), entity.getY(), entity.getZ(), false);
	}

	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

		ResourceKey<Level> HELHEIM = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:helheim"));
		MinecraftServer Server = ServerLifecycleHooks.getCurrentServer();

		if (!p_41128_.isClientSide() && p_41129_.getItemBySlot(EquipmentSlot.FEET).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "belts/gaim_armor")))) {
			List<TamableAnimal> nearbyAllies = p_41128_.getEntitiesOfClass(TamableAnimal.class, p_41129_.getBoundingBox().inflate(30), entity ->
															(entity.getOwner() == p_41129_ && !entity.isOrderedToSit()));
			if (p_41128_.dimension() == HELHEIM) {
				for (LivingEntity ally : nearbyAllies) teleportToDimension(Server.overworld(), ally);
				teleportToDimension(Server.overworld(), p_41129_);
			} else {
				for (LivingEntity ally : nearbyAllies) teleportToDimension(Server.getLevel(HELHEIM), ally);
				teleportToDimension(Server.getLevel(HELHEIM), p_41129_);
			}
			p_41129_.getCooldowns().addCooldown(this, TIME);
		}
		
		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}

}