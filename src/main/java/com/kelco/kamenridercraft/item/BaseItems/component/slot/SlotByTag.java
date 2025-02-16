package com.kelco.kamenridercraft.item.BaseItems.component.slot;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class SlotByTag extends Slot {


    private static String TAG = "";

    public SlotByTag(Container container, int slot, int x, int y, String tag) {
        super(container, slot, x, y);
        TAG=tag;
    }

    public boolean mayPlace(ItemStack stack) {
        return stack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, TAG)));
 }
}
