package com.kelco.kamenridercraft.item.heisei_phase_1.den_o;

import com.kelco.kamenridercraft.item.base_items.BaseItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;

import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;


public class RiderPassItem extends BaseItem {

	private int TIME;

	public RiderPassItem (Properties properties, int time)
	{
		super(properties);
		TIME=time;
	}

	public static void teleportToDimension(ServerLevel otherDim, LivingEntity entity) {
		if (entity.isPassenger()) entity.stopRiding();
		Vec3 position = PortalShape.findCollisionFreePosition(entity.getPosition(0), otherDim, entity, entity.getDimensions(entity.getPose()));
		BlockPos pos = new BlockPos((int)position.x, (int)position.y, (int)position.z);

		int y = otherDim.getChunkAt(pos).getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, pos.getX(), pos.getZ()) + 1;
		entity.teleportTo(otherDim, position.x, y, position.z, new HashSet<>(), 0, 0);
	}

	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);
		ResourceKey<Level> SANDS_OF_TIME = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:sands_of_time"));

		if (!p_41128_.isClientSide()) {
			MinecraftServer Server = p_41129_.getServer();
			List<TamableAnimal> nearbyAllies = p_41128_.getEntitiesOfClass(TamableAnimal.class, p_41129_.getBoundingBox().inflate(30), entity ->
				(entity.getOwner() == p_41129_ && !entity.isOrderedToSit() && !entity.isSleeping()));
			if (p_41128_.dimension() == SANDS_OF_TIME) {
				if (p_41129_.isShiftKeyDown()) {
					teleportToDimension(Server.overworld(), p_41129_);
					for (LivingEntity ally : nearbyAllies) ally.teleportTo(Server.overworld(), p_41129_.getX(), p_41129_.getY()+1, p_41129_.getZ(), new HashSet<>(), 0, 0);
				} else {
					teleportToDimension(Server.getLevel(getReturnDimension(itemstack)), p_41129_);
					for (LivingEntity ally : nearbyAllies) ally.teleportTo(Server.getLevel(getReturnDimension(itemstack)), p_41129_.getX(), p_41129_.getY() + 1, p_41129_.getZ(), new HashSet<>(), 0, 0);
				}
			} else {
				saveReturnDimension(itemstack, p_41128_.dimension());
				teleportToDimension(Server.getLevel(SANDS_OF_TIME), p_41129_);
				for (LivingEntity ally : nearbyAllies) ally.teleportTo(Server.getLevel(SANDS_OF_TIME), p_41129_.getX(), p_41129_.getY()+1, p_41129_.getZ(), new HashSet<>(), 0, 0);
			}
			if (!p_41129_.isCreative()) p_41129_.getCooldowns().addCooldown(this, TIME);
		}
		
		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}

	public static ResourceKey<Level> getReturnDimension(ItemStack itemstack) {
		if (itemstack.has(DataComponents.CUSTOM_DATA)) {
			CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
			ResourceKey<Level> level = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse(tag.getString("return_dimension")));
			return level;
		}
		return Level.OVERWORLD;
	}

	public static void saveReturnDimension(ItemStack itemstack, ResourceKey<Level> dimension)
	{
		if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
			itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
		}
		CompoundTag tag = new CompoundTag();
		Consumer<CompoundTag> data = form -> form.putString("return_dimension", dimension.location().toString());
		data.accept(tag);
		CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);

	}

}
