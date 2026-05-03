package com.kelco.kamenridercraft.item.base_items.component;

import net.minecraft.world.item.ItemStack;

public class SingleItemContainer extends BasicContainer {
    public SingleItemContainer(ItemStack stack, int slot) {
        super(stack, slot);
    }

    public int getMaxStackSize() {
        return 1;
    }
}