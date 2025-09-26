
package com.kelco.kamenridercraft.item.gotchard;

import com.kelco.kamenridercraft.item.BaseItems.BaseBlasterItem;
import com.kelco.kamenridercraft.world.inventory.LegendRideMagnumGuiMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class LegendRideMagnumItem extends BaseBlasterItem {
	private static final Component UNKNOWN_CONTENTS = Component.translatable("container.shulkerBox.unknownContents");

	public LegendRideMagnumItem(Tier toolTier, int Atk, float Spd, Properties prop) {
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
						return Component.translatable("container.kamenridercraft.legend_ride_magnum");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
						packetBuffer.writeBlockPos(entity.blockPosition());
						packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
						return new LegendRideMagnumGuiMenu(id, inventory, packetBuffer,itemstack);
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

	@Override
	public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof Player player && stack.has(DataComponents.CONTAINER) && stack.get(DataComponents.CONTAINER).nonEmptyStream().count() != 0
		&& player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof LegenDriverItem legend && legend.isTransformed(player)) {
			ItemContainerContents contents = stack.get(DataComponents.CONTAINER);

			if (contents.nonEmptyStream().anyMatch(item -> (item.getItem() instanceof LegendChemyCardItem || item.getItem() instanceof LegendSummonCardItem))) {
                int cardCount = (int)contents.nonEmptyStream().filter(item -> (item.getItem() instanceof LegendChemyCardItem || item.getItem() instanceof LegendSummonCardItem)).count();
				if (!player.isCreative()) player.getCooldowns().addCooldown(this.asItem(), 200*cardCount);
                switch (cardCount) {
                    case 1:
                        player.displayClientMessage(Component.translatable("attack.kamenridercraft.legendride_solo"), true);
                        break;
                    case 2:
                        player.displayClientMessage(Component.translatable("attack.kamenridercraft.legendride", Component.translatable("attack.kamenridercraft.legendride_duo")), true);
                        break;
                    case 3:
                        player.displayClientMessage(Component.translatable("attack.kamenridercraft.legendride", Component.translatable("attack.kamenridercraft.legendride_trio")), true);
                        break;
                    default:
                        player.displayClientMessage(Component.translatable("attack.kamenridercraft.legendride", Component.translatable("attack.kamenridercraft.legendride_massimo")), true);
                }

                contents.nonEmptyItems().forEach(card -> {
                    if (card.getItem() instanceof LegendChemyCardItem summonCard) summonCard.summon(card, level, player);
                    else if (card.getItem() instanceof LegendSummonCardItem summonCard) summonCard.summon(card, level, player);
				});
			}

			stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
			level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);
			player.awardStat(Stats.ITEM_USED.get(this));
		} else super.releaseUsing(stack, level, entityLiving, timeLeft);
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
