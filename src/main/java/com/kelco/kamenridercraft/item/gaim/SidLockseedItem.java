package com.kelco.kamenridercraft.item.gaim;

import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


public class SidLockseedItem extends BaseItem {

	private int TIME;

	public SidLockseedItem (Properties properties, int time)
	{
		super(properties);
		TIME=time;
	}

	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

		ResourceKey<Level> HELHEIM = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:helheim"));

		if (!p_41128_.isClientSide() && p_41129_.level() instanceof ServerLevel level && (p_41128_.dimension()==HELHEIM||p_41128_.dimension()==Level.OVERWORLD)){
			Vec3 look = p_41129_.getLookAngle().scale(3);
			BlockPos pos = new BlockPos((int)(Math.floor(p_41129_.getX()+ look.x)), (int)(p_41129_.getY()), (int)(Math.floor(p_41129_.getZ() + look.z)));
			
			if (p_41128_.getBlockState(pos).getDestroySpeed(p_41128_, pos) < 0.2) p_41128_.destroyBlock(pos, true);
			if (p_41129_.level().isEmptyBlock(pos)) {
				p_41129_.level().setBlockAndUpdate(pos, Rider_Blocks.HELHEIM_CRACK.get().defaultBlockState());
				p_41129_.getCooldowns().addCooldown(this, TIME);
			}
		}

		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}

}