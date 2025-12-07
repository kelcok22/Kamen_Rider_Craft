package com.kelco.kamenridercraft.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

import java.util.List;
import java.util.Objects;

public record IxaMachineRecipeInput(List<ItemStack> inputs) implements RecipeInput {

    public IxaMachineRecipeInput {
        Objects.requireNonNull(inputs, "inputItem");
        ItemStack first = Objects.requireNonNullElse(inputs.get(0), ItemStack.EMPTY);
        ItemStack second = Objects.requireNonNullElse(inputs.get(1), ItemStack.EMPTY);
        inputs = List.of(first, second);
    }

    public IxaMachineRecipeInput(ItemStack first, ItemStack second) {
        this(List.of(first, second));
    }

    @Override
    public ItemStack getItem(int i) {
        return inputs.get(i);
    }

    @Override
    public int size() {
        return inputs.size();
    }
}
