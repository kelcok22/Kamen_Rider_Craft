
package com.kelco.kamenridercraft.item.build;

import com.kelco.kamenridercraft.block.entity.PandoraPanelBlockEntity;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.BaseSwordItem;
import com.kelco.kamenridercraft.world.inventory.PandoraPanelGuiMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.BlockItemStateProperties;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

public class PandoraPanelItem extends BlockItem {
	private static final Component UNKNOWN_CONTENTS = Component.translatable("container.shulkerBox.unknownContents");

	public PandoraPanelItem(Block block) {
		super(block,new Properties().stacksTo(1).rarity(Rarity.COMMON).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
	}

	public PandoraPanelItem AddToList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}


@Override
public InteractionResult place(BlockPlaceContext context) {
	if (!this.getBlock().isEnabled(context.getLevel().enabledFeatures())) {
		return InteractionResult.FAIL;
	} else if (!context.canPlace()) {
		return InteractionResult.FAIL;
	} else {
		BlockPlaceContext blockplacecontext = this.updatePlacementContext(context);
		if (blockplacecontext == null) {
			return InteractionResult.FAIL;
		} else {
			BlockState blockstate = this.getPlacementState(blockplacecontext);
			if (blockstate == null) {
				return InteractionResult.FAIL;
			} else if (!this.placeBlock(blockplacecontext, blockstate)) {
				return InteractionResult.FAIL;
			} else {
				BlockPos blockpos = blockplacecontext.getClickedPos();
				Level level = blockplacecontext.getLevel();
				Player player = blockplacecontext.getPlayer();
				ItemStack itemstack = blockplacecontext.getItemInHand();
				BlockState blockstate1 = level.getBlockState(blockpos);
				if (blockstate1.is(blockstate.getBlock())) {
					blockstate1 = this.updateBlockStateFromTag(blockpos, level, itemstack, blockstate1);
					this.updateCustomBlockEntityTag(blockpos, level, player, itemstack, blockstate1);
					updateBlockEntityComponents(level, blockpos, itemstack);
					blockstate1.getBlock().setPlacedBy(level, blockpos, blockstate1, player, itemstack);
					if (player instanceof ServerPlayer) {
						CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
					}
				}

				SoundType soundtype = blockstate1.getSoundType(level, blockpos, context.getPlayer());
				level.playSound(player, blockpos, this.getPlaceSound(blockstate1, level, blockpos, context.getPlayer()), SoundSource.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
				level.gameEvent(GameEvent.BLOCK_PLACE, blockpos, GameEvent.Context.of(player, blockstate1));
				itemstack.consume(1, player);
				return InteractionResult.sidedSuccess(level.isClientSide);
			}
		}
	}
}
	private static void updateBlockEntityComponents(Level level, BlockPos poa, ItemStack stack) {
		BlockEntity blockentity = level.getBlockEntity(poa);
		if (blockentity != null) {
			if (blockentity instanceof PandoraPanelBlockEntity panelBlock)
				panelBlock.inventory.insertItem(0, stack.copy(), false);
			blockentity.setChanged();
		}

	}

	private BlockState updateBlockStateFromTag(BlockPos pos, Level level, ItemStack stack, BlockState state) {
		BlockItemStateProperties blockitemstateproperties = (BlockItemStateProperties)stack.getOrDefault(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY);
		if (blockitemstateproperties.isEmpty()) {
			return state;
		} else {
			BlockState blockstate = blockitemstateproperties.apply(state);
			if (blockstate != state) {
				level.setBlock(pos, blockstate, 2);
			}

			return blockstate;
		}
	}


	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		ItemStack itemstack = entity.getItemInHand(hand);

		if (!world.isClientSide && entity instanceof ServerPlayer serverPlayer) {
			serverPlayer.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Pandora Panel");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
					packetBuffer.writeBlockPos(entity.blockPosition());
					packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
					return new PandoraPanelGuiMenu(id, inventory, packetBuffer,itemstack);
				}
			}, buf -> {
				buf.writeBlockPos(entity.blockPosition());
				buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
			});
		}
		return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
	}

	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
		if (stack.has(DataComponents.CONTAINER_LOOT)) {
			tooltipComponents.add(UNKNOWN_CONTENTS);
		}

		int i = 0;
		int j = 0;
		Iterator var7 = ((ItemContainerContents)stack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY)).nonEmptyItems().iterator();

		while(var7.hasNext()) {
			ItemStack itemstack = (ItemStack)var7.next();
			++j;
			if (i <= 4) {
				++i;
				tooltipComponents.add(Component.translatable("container.shulkerBox.itemCount", new Object[]{itemstack.getHoverName(), itemstack.getCount()}));
			}
		}

		if (j - i > 0) {
			tooltipComponents.add(Component.translatable("container.shulkerBox.more", new Object[]{j - i}).withStyle(ChatFormatting.ITALIC));
		}

	}
}
