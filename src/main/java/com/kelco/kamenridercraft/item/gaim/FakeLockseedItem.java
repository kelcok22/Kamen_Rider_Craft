package com.kelco.kamenridercraft.item.gaim;


import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;


public class FakeLockseedItem extends BaseItem {



	public FakeLockseedItem(Properties properties)
	{
		super(properties);
	}

	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

		if (!p_41128_.isClientSide()) {
			if (p_41129_.level() instanceof ServerLevel) {
				Vec3 look = p_41129_.getLookAngle();
				BlockPos pos = new BlockPos((int) (p_41129_.getX()+ look.x), (int) (p_41129_.getY() +5), (int) (p_41129_.getZ() + look.z));

				if (p_41129_.level().isEmptyBlock(pos)) {
					p_41129_.level().setBlockAndUpdate(pos, Blocks.ANVIL.defaultBlockState());
					p_41129_.sendSystemMessage(Component.translatable("message.kamenridercraft.fake"));
					itemstack.consume(1,p_41129_);
				}
				p_41129_.awardStat(Stats.ITEM_USED.get(this));
			}

		}

		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}

}