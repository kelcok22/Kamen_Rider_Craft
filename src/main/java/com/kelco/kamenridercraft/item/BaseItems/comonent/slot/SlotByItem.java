package com.kelco.kamenridercraft.item.BaseItems.comonent.slot;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SlotByItem extends Slot {


    private static Item ITEM;

    public SlotByItem(Container container, int slot, int x, int y, Item item) {
        super(container, slot, x, y);
        ITEM=item;
    }

    public boolean mayPlace(ItemStack stack) {
        return stack.getItem()==ITEM;
 }
}
