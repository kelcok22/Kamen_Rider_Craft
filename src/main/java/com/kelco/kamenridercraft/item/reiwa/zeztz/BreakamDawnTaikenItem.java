package com.kelco.kamenridercraft.item.reiwa.zeztz;


import com.kelco.kamenridercraft.item.KRCTiers;
import com.kelco.kamenridercraft.item.reiwa.ZeztzRiderItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.kelco.kamenridercraft.item.reiwa.ZeztzRiderItems.BREAKAM_DAWN_SOUKEN_L;
import static com.kelco.kamenridercraft.item.reiwa.ZeztzRiderItems.BREAKAM_DAWN_SOUKEN_R;

public class BreakamDawnTaikenItem extends SwordItem {
    private Item craftingRemainingItem = null;

    public BreakamDawnTaikenItem(Tier toolTier, int Atk, float Spd, Properties prop) {
        super(KRCTiers.SPLITTING_SWORD, prop.durability(1560));
    }

    public boolean isValidRepairItem(@NotNull ItemStack itemStackOne, ItemStack repairItem) {
        return repairItem.getItem() == ZeztzRiderItems.CODE_CAPSEM.get();
    }

    public BreakamDawnTaikenItem addToList(List<Item> TabList, int num) {
        for (int i = 0; i < num; i++) {
            TabList.add(this);
        }
        return this;
    }

    public BreakamDawnTaikenItem addToList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }

    public @NotNull ItemStack getCraftingRemainingItem(ItemStack stack) {
        if (stack.getItem() instanceof BreakamDawnTaikenItem) {
            if (!hasCraftingRemainingItem(stack)) {
                return ItemStack.EMPTY;
            }
            return new ItemStack(craftingRemainingItem);
        } else return new ItemStack(this.getCraftingRemainingItem());
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack sword = player.getItemInHand(interactionHand);
        if (player instanceof ServerPlayer serverPlayer && serverPlayer.getOffhandItem().isEmpty()
                && (sword.getMaxDamage() - sword.getDamageValue()) > 1) {

            ItemStack leftSword = new ItemStack(BREAKAM_DAWN_SOUKEN_L.get());
            ItemStack rightSword = new ItemStack(BREAKAM_DAWN_SOUKEN_R.get());
            System.out.println(sword.getMaxDamage() - sword.getDamageValue());

            if ((sword.getMaxDamage() - sword.getDamageValue()) == 2) {
                leftSword.setDamageValue(779);
                rightSword.setDamageValue(779);
            } else {
                if ((1560 - sword.getDamageValue()) % 2 == 1) {
                    sword.setDamageValue(sword.getDamageValue() - 1);
                    leftSword.setDamageValue(sword.getDamageValue() / 2);
                    rightSword.setDamageValue((sword.getDamageValue() / 2) - 1);
                } else {
                    leftSword.setDamageValue(sword.getDamageValue() / 2);
                    rightSword.setDamageValue(sword.getDamageValue() / 2);
                }
            }

            if ((!(serverPlayer.getItemBySlot(EquipmentSlot.FEET).getItem() == ZeztzRiderItems.DAWN_BELT.get()))
                    && serverPlayer.getItemBySlot(EquipmentSlot.LEGS).getItem() == ZeztzRiderItems.ZEZTZ_LEGGINGS.get()
                    && serverPlayer.getItemBySlot(EquipmentSlot.CHEST).getItem() == ZeztzRiderItems.ZEZTZ_CHESTPLATE.get()
                    && serverPlayer.getItemBySlot(EquipmentSlot.HEAD).getItem() == ZeztzRiderItems.ZEZTZ_HELMET.get()
            ) {
                serverPlayer.setItemSlot(EquipmentSlot.FEET, new ItemStack(ZeztzRiderItems.DAWN_BELT.get()));
            }

            serverPlayer.getItemInHand(interactionHand).shrink(1);
            serverPlayer.setItemInHand(InteractionHand.OFF_HAND, leftSword);
            serverPlayer.setItemInHand(InteractionHand.MAIN_HAND, rightSword);
            serverPlayer.getCooldowns().addCooldown(BREAKAM_DAWN_SOUKEN_L.get(), 60);
            serverPlayer.getCooldowns().addCooldown(BREAKAM_DAWN_SOUKEN_R.get(), 60);
        }
        return InteractionResultHolder.pass(player.getItemInHand(interactionHand));
    }
}