package com.kelco.kamenridercraft.item.reiwa.zeztz;


import com.kelco.kamenridercraft.item.KRCTiers;
import com.kelco.kamenridercraft.item.reiwa.ZeztzRiderItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.kelco.kamenridercraft.item.reiwa.ZeztzRiderItems.*;

public class BreakamDawnSoukenItem extends SwordItem {
    private Item craftingRemainingItem = null;

    public BreakamDawnSoukenItem(Tier toolTier, int Atk, float Spd, Properties prop) {
        super(KRCTiers.SPLIT_SWORD, prop.durability(780));
    }

    public boolean isValidRepairItem(@NotNull ItemStack itemStackOne, ItemStack repairItem) {
        return repairItem.getItem() == ZeztzRiderItems.CODE_CAPSEM.get();
    }

    public BreakamDawnSoukenItem addToList(List<Item> TabList, int num) {
        for (int i = 0; i < num; i++) {
            TabList.add(this);
        }
        return this;
    }

    public BreakamDawnSoukenItem addToList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }

    public @NotNull ItemStack getCraftingRemainingItem(ItemStack stack) {
        if (stack.getItem() instanceof BreakamDawnSoukenItem) {
            if (!hasCraftingRemainingItem(stack)) {
                return ItemStack.EMPTY;
            }
            return new ItemStack(craftingRemainingItem);
        } else return new ItemStack(this.getCraftingRemainingItem());
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack sword = player.getItemInHand(interactionHand);
        if (player instanceof ServerPlayer serverPlayer &&
                (serverPlayer.getOffhandItem().is(BREAKAM_DAWN_SOUKEN_L.get()) && sword.is(BREAKAM_DAWN_SOUKEN_R.get())
                        || serverPlayer.getOffhandItem().is(BREAKAM_DAWN_SOUKEN_L.get()) && sword.is(BREAKAM_DAWN_SOUKEN_R.get()))) {

            ItemStack combinedSword = new ItemStack(BREAKAM_DAWN_TAIKEN.get());
            combinedSword.setDamageValue(serverPlayer.getOffhandItem().getDamageValue() + sword.getDamageValue());

            serverPlayer.getItemInHand(interactionHand).shrink(1);
            serverPlayer.getOffhandItem().shrink(1);
            serverPlayer.setItemInHand(InteractionHand.MAIN_HAND, combinedSword);
            serverPlayer.getCooldowns().addCooldown(BREAKAM_DAWN_TAIKEN.get(), 60);
        }
        return InteractionResultHolder.pass(player.getItemInHand(interactionHand));
    }
}