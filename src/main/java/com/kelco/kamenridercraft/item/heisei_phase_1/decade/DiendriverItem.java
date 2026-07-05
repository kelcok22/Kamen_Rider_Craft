
package com.kelco.kamenridercraft.item.heisei_phase_1.decade;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.BaseBlasterItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.DecadeRiderItems;
import com.kelco.kamenridercraft.world.inventory.DiendriverGuiMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class DiendriverItem extends BaseBlasterItem {
    private static final Component UNKNOWN_CONTENTS = Component.translatable("container.shulkerBox.unknownContents");

    public DiendriverItem(Tier toolTier, int Atk, float Spd, Properties prop) {
        super(toolTier, Atk, Spd, prop.stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack itemStack, int amount, @Nullable T entity, @NotNull Consumer<Item> onBroken) {
        if (itemStack.has(DataComponents.CONTAINER) && itemStack.getDamageValue() == itemStack.getMaxDamage() - 1) {
            for (ItemStack card : Objects.requireNonNull(itemStack.get(DataComponents.CONTAINER)).nonEmptyItemsCopy()) {
                assert entity != null;
                entity.spawnAtLocation(card);
            }
            if (entity instanceof ServerPlayer player) player.closeContainer();
            itemStack.set(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
        }
        return amount;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);

        if (player.isShiftKeyDown()) {
            if (!world.isClientSide && player instanceof ServerPlayer serverPlayer) {
                serverPlayer.openMenu(new MenuProvider() {
                    @Override
                    public @NotNull Component getDisplayName() {
                        return Component.translatable("container.kamenridercraft.diendriver");
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
                        FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                        packetBuffer.writeBlockPos(player.blockPosition());
                        packetBuffer.writeByte(interactionHand == InteractionHand.MAIN_HAND ? 0 : 1);
                        return new DiendriverGuiMenu(id, inventory, packetBuffer, itemstack);
                    }
                }, buf -> {
                    buf.writeBlockPos(player.blockPosition());
                    buf.writeByte(interactionHand == InteractionHand.MAIN_HAND ? 0 : 1);
                });
            }
            return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
        }
        return super.use(world, player, interactionHand);
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int timeLeft) {
        if (livingEntity instanceof Player player && itemStack.has(DataComponents.CONTAINER) && Objects.requireNonNull(itemStack.get(DataComponents.CONTAINER)).nonEmptyStream().findAny().isPresent()
                && player.getItemBySlot(EquipmentSlot.FEET).getItem() == DecadeRiderItems.DIEND_BELT.get() && ((RiderDriverItem) player.getItemBySlot(EquipmentSlot.FEET).getItem()).isTransformed(player)) {
            ItemContainerContents contents = itemStack.get(DataComponents.CONTAINER);

            assert contents != null;
            if (contents.nonEmptyStream().anyMatch(item -> (item.getItem() instanceof RiderSummonCardItem && item.is(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/rider_cards/kaijinride")))))) {
                if (!player.isCreative())
                    player.getCooldowns().addCooldown(this.asItem(), 200 * (int) contents.nonEmptyStream().filter(item -> (!item.isDamaged() && (item.getItem() instanceof RiderCardItem || item.getItem() instanceof RiderSummonCardItem))).count());
                List<String> cardNames = new ArrayList<>();

                contents.nonEmptyItems().forEach(card -> {
                    if (card.getItem() instanceof RiderSummonCardItem summonCard && card.is(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/rider_cards/kaijinride")))) {
                        cardNames.add(Component.translatable(card.getItem() + ".name").getString());
                        summonCard.summon(card, level, player);
                    }
                });

                switch (cardNames.size()) {
                    case 1:
                        player.displayClientMessage(Component.translatable("attack.kamenridercraft.kaijinride", cardNames.getFirst()), true);
                        break;
                    case 2:
                        player.displayClientMessage(Component.translatable("attack.kamenridercraft.kaijinride_2", cardNames.get(0), cardNames.get(1)), true);
                        break;
                    default:
                        player.displayClientMessage(Component.translatable("attack.kamenridercraft.kaijinride_3", cardNames.get(0), cardNames.get(1), cardNames.get(2)), true);
                }
            } else if (contents.nonEmptyStream().anyMatch(item -> (!item.isDamaged() && (item.getItem() instanceof RiderCardItem || item.getItem() instanceof RiderSummonCardItem)))) {
                if (!player.isCreative())
                    player.getCooldowns().addCooldown(this.asItem(), 200 * (int) contents.nonEmptyStream().filter(item -> (!item.isDamaged() && (item.getItem() instanceof RiderCardItem || item.getItem() instanceof RiderSummonCardItem))).count());
                List<String> cardNames = new ArrayList<>();

                contents.nonEmptyItems().forEach(card -> {
                    if (card.getItem() instanceof RiderCardItem summonCard && !card.isDamaged()) {
                        cardNames.add(Component.translatable(card.getItem() + ".name").getString());
                        summonCard.summon(card, level, player);
                    } else if (card.getItem() instanceof RiderSummonCardItem summonCard) {
                        cardNames.add(Component.translatable(card.getItem() + ".name").getString());
                        summonCard.summon(card, level, player);
                    }
                });

                switch (cardNames.size()) {
                    case 1:
                        player.displayClientMessage(Component.translatable("attack.kamenridercraft.kamenride", cardNames.getFirst()), true);
                        break;
                    case 2:
                        player.displayClientMessage(Component.translatable("attack.kamenridercraft.kamenride_2", cardNames.get(0), cardNames.get(1)), true);
                        break;
                    default:
                        player.displayClientMessage(Component.translatable("attack.kamenridercraft.kamenride_3", cardNames.get(0), cardNames.get(1), cardNames.get(2)), true);
                }
            } else {
                if (!player.isCreative()) player.getCooldowns().addCooldown(this.asItem(), 200);

                ItemStack card = contents.nonEmptyItems().iterator().next();
                if (card.getItem() instanceof AttackRideCardItem attack) {
                    player.displayClientMessage(Component.translatable("attack.kamenridercraft.attackride_diend", Component.translatable(card.getItem() + ".name").getString()), true);
                    if (!level.isClientSide()) attack.attackride(level, player);
                    card.shrink(1);
                }
            }

            itemStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);
            player.awardStat(Stats.ITEM_USED.get(this));
        } else super.releaseUsing(itemStack, level, livingEntity, timeLeft);
    }

    public void appendHoverText(@NotNull ItemStack itemStack, Item.@NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, context, tooltipComponents, tooltipFlag);
        if (itemStack.has(DataComponents.CONTAINER_LOOT)) {
            tooltipComponents.add(UNKNOWN_CONTENTS);
        }

        int i = 0;
        int j = 0;

        for (ItemStack itemstack : itemStack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).nonEmptyItems()) {
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