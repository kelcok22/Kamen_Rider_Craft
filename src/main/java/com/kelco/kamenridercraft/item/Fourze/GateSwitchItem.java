package com.kelco.kamenridercraft.item.Fourze;

import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.portal.DimensionTransition;
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

		 while (!otherDim.noCollision(entity) || otherDim.containsAnyLiquid(entity.getBoundingBox())) entity.teleportRelative(0.0, 2.0, 0.0);
		 BlockPos blockpos= new BlockPos(40, 60, 40);

		 if (get_has_moon(itemstack)){
			 int X = (int) get_XYZ(itemstack, "x1", respawn.pos().x());
			 double Y = get_XYZ(itemstack, "y1", respawn.pos().y());
			 int Z = (int) get_XYZ(itemstack, "z1", respawn.pos().z());
			 blockpos= new BlockPos( X, 60, Z);
		 }
		 else{
			 TagKey<Structure>tag = TagKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath("kamenridercraft","rabbit_hutch"));
			 blockpos = otherDim.findNearestMapStructure(tag, entity.blockPosition(), 100, false);

			 double X=blockpos.getX();
			 double Y=blockpos.getY();
			 double Z=blockpos.getZ();
			 Save_XYZ(itemstack,X,Y,Z,1);
			 }


		 entity.teleportTo(otherDim, blockpos.getX(),60, blockpos.getZ(), new HashSet<>(), 0, 0);


		 }else {

		 double X=get_XYZ(itemstack,"x0",respawn.pos().x());
		 double Y=get_XYZ(itemstack,"y0",respawn.pos().y());
		 double Z=get_XYZ(itemstack,"z0",respawn.pos().z());
		 entity.teleportTo(otherDim, X,Y,Z, new HashSet<>(), 0, 0);
		 while (!otherDim.noCollision(entity) || otherDim.containsAnyLiquid(entity.getBoundingBox())) entity.teleportRelative(0.0, 2.0, 0.0);
		 entity.randomTeleport(X, Y, Z, false);
	 }
	}


	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

		ResourceKey<Level> MOON = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:moon"));
		if (p_41129_ instanceof ServerPlayer player && !p_41128_.isClientSide()) {
			MinecraftServer Server = player.getServer();
			if (p_41128_.dimension() == MOON) {
				teleportToDimension(itemstack,Server.overworld(), player,0);
			} else {
				double X=player.position().x;
				double Y=player.position().y;
				double Z=player.position().z;
				Save_XYZ(itemstack,X,Y,Z,0);
				teleportToDimension(itemstack,Server.getLevel(MOON), player,1);
			}
			p_41129_.getCooldowns().addCooldown(this, TIME);
		}
		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}

	public static boolean get_has_moon(ItemStack itemstack) {
		if (itemstack.has(DataComponents.CUSTOM_DATA)) {
			CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
			return tag.getBoolean("has_moon");
		}
		return false;
	}

	public static double get_XYZ(ItemStack itemstack, String slot,double respawn) {
		if (itemstack.has(DataComponents.CUSTOM_DATA)) {
			CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
			return tag.getDouble(slot);
		}
		return respawn;
	}

	public static void Save_XYZ(ItemStack itemstack,double X,double Y,double Z,int num)
	{
		if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
			itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
		}
			CompoundTag tag = new CompoundTag();
			Consumer<CompoundTag> data = form ->
			{
				form.putDouble("x"+num, X);
				form.putDouble("y"+num, Y);
				form.putDouble("z"+num, Z);
				if(num==1)form.putBoolean("has_moon", true);
			};
			data.accept(tag);
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);

	}

}