package com.kelco.kamenridercraft.item.reiwa.gotchard;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.base_items.CopyFormChangeItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.reiwa.GotchardRiderItems;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CopyChemyCardItem extends CopyFormChangeItem {
    private RiderFormChangeItem formItem = null;

    public CopyChemyCardItem(Properties properties, Item form_item) {
        super(properties, form_item);
        if (form_item instanceof RiderFormChangeItem form) formItem = form;
    }

    public boolean inventoryOrHolderContains(Player player, Item item) {
        NonNullList<ItemStack> inv = NonNullList.create();
        inv.addAll(player.getInventory().items);
        inv.addAll(player.getInventory().armor);
        inv.add(player.getInventory().offhand.getFirst());

        if (player.getInventory().countItem(item) != 0) return true;
        else for (ItemStack itemStack : inv) {
            if (itemStack.has(DataComponents.CONTAINER)) {
                for (ItemStack stack : Objects.requireNonNull(itemStack.getComponents().get(DataComponents.CONTAINER)).nonEmptyItems())
                    if (stack.getItem() == item) return true;
            } else if (itemStack.has(DataComponents.BUNDLE_CONTENTS))
                for (ItemStack stack : Objects.requireNonNull(itemStack.getComponents().get(DataComponents.BUNDLE_CONTENTS)).items())
                    if (stack.getItem() == item) return true;
        }
        return false;
    }

    public boolean canSummonGotcharbrothers(Player player) {
        if (!formItem.needItemList.isEmpty()) {
            for (Item item : formItem.needItemList) {
                if (!inventoryOrHolderContains(player, item)) return false;
            }
        }
        return player.isShiftKeyDown() && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof GotcharDriverItem driver && driver.isTransformed(player)
                && RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1) == GotchardRiderItems.NIJIGON_RIDE_CHEMY_CARD_EXTRA.get();
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        ItemStack itemstack = player.getItemInHand(usedHand);

        if (canSummonGotcharbrothers(player) && formItem != null) {
            RiderSummonEntity summon = MobsCore.RIDER_SUMMON.get().create(level);
            if (summon != null) {
                summon.moveTo(player.getX(), player.getY() + 1, player.getZ(), player.getYRot(), player.getXRot());
                summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(GotchardRiderItems.GOTCHARD_HELMET.get()));
                summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(GotchardRiderItems.GOTCHARD_CHESTPLATE.get()));
                summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(GotchardRiderItems.GOTCHARD_LEGGINGS.get()));
                summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(GotchardRiderItems.GOTCHARDRIVER_BROTHER.get()));
                RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), formItem, 1);

                level.addFreshEntity(summon);
                summon.bindToPlayer(player);
                summon.addRequiredForm((RiderFormChangeItem) GotchardRiderItems.NIJIGON_RIDE_CHEMY_CARD_EXTRA.get(), 1);
                if (!player.isCreative()) {
                    summon.takeSummonItem(itemstack);
                    for (Item item : formItem.needItemList) player.getCooldowns().addCooldown(item, 750);
                }
                player.awardStat(Stats.ITEM_USED.get(this));
            }
            return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
        }
        if (formItem != null) formItem.use(level, player, usedHand);
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}