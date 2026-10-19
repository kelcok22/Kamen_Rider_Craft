package com.kelco.kamenridercraft.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

import java.util.List;
import java.util.Objects;

public record IxaMachineRecipeInput(ItemStack primary, ItemStack modifier) implements RecipeInput {

        @Override
        public ItemStack getItem(int index) {
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
            if (!(obj instanceof IxaMachineRecipeInput other)) return false;
            return ItemStack.isSameItemSameComponents(this.primary, other.primary)
                    && ItemStack.isSameItemSameComponents(this.modifier, other.modifier);
        }

        @Override
        public int hashCode() {
            int result = ItemStack.hashItemAndComponents(primary);
            result = 31 * result + ItemStack.hashItemAndComponents(modifier);
            return result;
        }
    }