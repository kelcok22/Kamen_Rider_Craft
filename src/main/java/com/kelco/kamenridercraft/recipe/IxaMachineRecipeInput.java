package com.kelco.kamenridercraft.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jetbrains.annotations.NotNull;

public record IxaMachineRecipeInput(ItemStack primary, ItemStack modifier) implements RecipeInput {
    @Override
    public @NotNull ItemStack getItem(int index) {
        return index == 0 ? primary : (index == 1 ? modifier : ItemStack.EMPTY);
    }

    @Override
    public int size() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        return primary.isEmpty() && modifier.isEmpty();
    }

    // CRITICAL FIX: Explicitly enforce value-based equivalence checks.
    // Minecraft's recipe manager cache checks this heavily during the server tick loop!
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof IxaMachineRecipeInput(ItemStack primary1, ItemStack modifier1))) return false;
        return ItemStack.isSameItemSameComponents(this.primary, primary1)
                && ItemStack.isSameItemSameComponents(this.modifier, modifier1);
    }

    @Override
    public int hashCode() {
        int result = ItemStack.hashItemAndComponents(primary);
        result = 31 * result + ItemStack.hashItemAndComponents(modifier);
        return result;
    }
}