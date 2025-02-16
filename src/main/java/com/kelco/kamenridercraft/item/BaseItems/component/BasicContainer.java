package com.kelco.kamenridercraft.item.BaseItems.component;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;

public class BasicContainer extends SimpleContainer {

    // The item stack this container is for. Passed into and set in the constructor.
    private final ItemStack stack;

    public BasicContainer(ItemStack stack,int slot) {
        super(slot);
        this.stack = stack;
        ItemContainerContents contents = stack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
        contents.copyInto(this.getItems());
    }


    @Override
    public void setChanged() {
        super.setChanged();
        this.stack.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(this.getItems()));
    }
}