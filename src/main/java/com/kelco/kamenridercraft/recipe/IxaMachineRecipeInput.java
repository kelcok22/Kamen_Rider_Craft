package com.kelco.kamenridercraft.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record IxaMachineRecipeInput(ItemStack input, ItemStack modifier) implements RecipeInput {
    public IxaMachineRecipeInput(ItemStack input, ItemStack modifier) {
        this.input = input;
        this.modifier = modifier;
    }

    @Override
    public ItemStack getItem(int p_346205_) {
        ItemStack var10000;
        switch (p_346205_) {
            case 0 -> var10000 = this.input;
            case 1 -> var10000 = this.modifier;
            default -> throw new IllegalArgumentException("Recipe does not contain slot " + p_346205_);
        }

        return var10000;
    }
    @Override
    public int size() {
        return 2;
    }
    public boolean isEmpty() {
        return this.input.isEmpty() && this.modifier.isEmpty();
    }

    public ItemStack input() {
        return this.input;
    }

    public ItemStack modifier () {return this.modifier; }
}
