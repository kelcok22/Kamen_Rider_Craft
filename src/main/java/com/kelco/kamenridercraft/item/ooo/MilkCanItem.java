package com.kelco.kamenridercraft.item.ooo;


import com.kelco.kamenridercraft.data.ModItemModelProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import org.apache.commons.lang3.math.Fraction;

import java.util.Iterator;
import java.util.List;

public class MilkCanItem extends BundleItem {


    public MilkCanItem(Properties prop) {
        super(prop);
    }

    public MilkCanItem has_basic_model() {
        ModItemModelProvider.BASIC_ITEM_MODEL2.add(this);
        return this;
    }

    public MilkCanItem AddToList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }

    public boolean overrideStackedOnOther(ItemStack stack, Slot slot, ClickAction action, Player player) {
        if (stack.getCount() == 1 && action == ClickAction.SECONDARY) {
            BundleContents bundlecontents = (BundleContents)stack.get(DataComponents.BUNDLE_CONTENTS);
            if (bundlecontents == null) {
                return false;
            } else {
                ItemStack itemstack = slot.getItem();
                BundleContents.Mutable bundlecontents$mutable = new BundleContents.Mutable(bundlecontents);
                if (itemstack.isEmpty()) {
                    this.playRemoveOneSound(player);
                    ItemStack itemstack1 = bundlecontents$mutable.removeOne();
                    if (itemstack1 != null) {
                        ItemStack itemstack2 = slot.safeInsert(itemstack1);
                        bundlecontents$mutable.tryInsert(itemstack2);
                    }
                } else if (itemstack.getItem().canFitInsideContainerItems()) {
                    int i = bundlecontents$mutable.tryTransfer(slot, player);
                    if (i > 0) {
                        this.playInsertSound(player);
                    }
                }

                stack.set(DataComponents.BUNDLE_CONTENTS, bundlecontents$mutable.toImmutable());
                return true;
            }
        } else {
            return false;
        }
    }


    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        BundleContents bundlecontents = stack.get(DataComponents.BUNDLE_CONTENTS);
        if (bundlecontents != null) {
            int i = Mth.mulAndTruncate(bundlecontents.weight(), 64);
            tooltipComponents.add(Component.translatable("item.minecraft.bundle.fullness", i, 640).withStyle(ChatFormatting.GRAY));
        }
    }


    private void playRemoveOneSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_REMOVE_ONE, 0.8F, 0.8F + entity.level().getRandom().nextFloat() * 0.4F);
    }

    private void playInsertSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_INSERT, 0.8F, 0.8F + entity.level().getRandom().nextFloat() * 0.4F);
    }

    private void playDropContentsSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_DROP_CONTENTS, 0.8F, 0.8F + entity.level().getRandom().nextFloat() * 0.4F);
    }
}