package com.kelco.kamenridercraft.item.gaim;

import java.util.HashSet;
import java.util.List;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.server.ServerLifecycleHooks;


public class SidLockseedItem extends BaseItem {

	private int TIME = 900;

	public SidLockseedItem (Properties properties, int time)
	{
		super(properties);
		TIME=time;
	}

	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

		ResourceKey<Level> HELHEIM = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:helheim"));

		if (!p_41128_.isClientSide()) {

			if (p_41129_.level() instanceof ServerLevel level) {
				if (p_41128_.dimension()==HELHEIM||p_41128_.dimension()==Level.OVERWORLD ){
				Vec3 look = p_41129_.getLookAngle();
				BlockPos pos = new BlockPos((int) (p_41129_.getX()+ look.x * 3), (int) (p_41129_.getY() ), (int) (p_41129_.getZ() + look.z * 3));

				if (p_41129_.level().isEmptyBlock(pos)) {
					p_41129_.level().setBlockAndUpdate(pos, Rider_Blocks.HELHEIM_CRACK.get().defaultBlockState());
					p_41129_.getCooldowns().addCooldown(this, TIME);
				}
				}
			}

		}

		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}

}