
package com.kelco.kamenridercraft.item.build;

import com.kelco.kamenridercraft.world.inventory.PandoraPanelGuiMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;

import java.util.Iterator;
import java.util.List;

public class PandoraPanelItem extends Item {
	private static final Component UNKNOWN_CONTENTS = Component.translatable("container.shulkerBox.unknownContents");

	public PandoraPanelItem() {
		super(new Properties().stacksTo(1).rarity(Rarity.COMMON).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
	}

	public PandoraPanelItem AddToTabList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}

	@Override
	public boolean hasCraftingRemainingItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		return new ItemStack(this);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		ItemStack itemstack = entity.getItemInHand(hand);

		if (!world.isClientSide && entity instanceof ServerPlayer serverPlayer) {
			serverPlayer.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Advent Deck");
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
		/*OpenAdventDeckProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);*/
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
