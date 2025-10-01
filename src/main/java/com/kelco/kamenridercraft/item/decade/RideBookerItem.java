
package com.kelco.kamenridercraft.item.decade;

import com.kelco.kamenridercraft.item.BaseItems.BaseBlasterItem;
import com.kelco.kamenridercraft.world.inventory.RideBookerGuiMenu;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;

import io.netty.buffer.Unpooled;

import java.util.List;
import java.util.function.Consumer;

import org.jetbrains.annotations.Nullable;

public class RideBookerItem extends BaseBlasterItem {
	private static final Component UNKNOWN_CONTENTS = Component.translatable("container.shulkerBox.unknownContents");

	public RideBookerItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, Atk, Spd, prop.stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
	}

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, @Nullable T entity, Consumer<Item> onBroken) {
        if (stack.has(DataComponents.CONTAINER) && stack.getDamageValue()==stack.getMaxDamage()-1) {
            for (ItemStack card : stack.get(DataComponents.CONTAINER).nonEmptyItemsCopy()) entity.spawnAtLocation(card);
            if (entity instanceof ServerPlayer player) player.closeContainer();
            stack.set(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
        }
        return amount;
    }

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		ItemStack itemstack = entity.getItemInHand(hand);

		if (entity.isShiftKeyDown()) {
			if (!world.isClientSide && entity instanceof ServerPlayer serverPlayer) {
				serverPlayer.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
                        return Component.translatable("container.kamenridercraft.ride_booker");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
						packetBuffer.writeBlockPos(entity.blockPosition());
						packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
						return new RideBookerGuiMenu(id, inventory, packetBuffer,itemstack);
					}
				}, buf -> {
					buf.writeBlockPos(entity.blockPosition());
					buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
				});
			}
			/*OpenAdventDeckProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);*/
			return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
		}
		return super.use(world, entity, hand);
	}

	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
		if (stack.has(DataComponents.CONTAINER_LOOT)) {
			tooltipComponents.add(UNKNOWN_CONTENTS);
		}

		int i = 0;
		int j = 0;

        for (ItemStack itemstack : stack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).nonEmptyItems()) {
            ++j;
            if (i <= 4) {
                ++i;
                tooltipComponents.add(Component.translatable("container.shulkerBox.itemCount", itemstack.getHoverName(), itemstack.getCount()));
            }
        }

		if (j - i > 0) {
			tooltipComponents.add(Component.translatable("container.shulkerBox.more", j - i).withStyle(ChatFormatting.ITALIC));
		}

	}
}
