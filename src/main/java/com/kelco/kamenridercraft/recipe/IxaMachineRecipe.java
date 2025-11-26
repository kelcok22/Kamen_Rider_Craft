package com.kelco.kamenridercraft.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record IxaMachineRecipe(Ingredient inputItem, Ingredient modifier, ItemStack output) implements Recipe<IxaMachineRecipeInput> {

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        list.add(modifier);
        return list;
    }

    @Override
    public boolean matches(IxaMachineRecipeInput ixaMachineRecipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(ixaMachineRecipeInput.getItem(0)) && modifier.test(ixaMachineRecipeInput.getItem(1));
    }

    @Override
    public ItemStack assemble(IxaMachineRecipeInput ixaMachineRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public RecipeSerializer<?  extends Recipe<IxaMachineRecipeInput>> getSerializer() {
        return ModRecipes.IXA_MACHINE_BLOCK_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<IxaMachineRecipeInput>> getType() {
        return ModRecipes.IXA_MACHINE_BLOCK_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<IxaMachineRecipe> {
        public static final MapCodec<IxaMachineRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(IxaMachineRecipe::inputItem),
                Ingredient.CODEC_NONEMPTY.fieldOf("modifier").forGetter(IxaMachineRecipe::modifier),
                ItemStack.CODEC.fieldOf("result").forGetter(IxaMachineRecipe::output)
        ).apply(inst, IxaMachineRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, IxaMachineRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, IxaMachineRecipe::inputItem,
                        Ingredient.CONTENTS_STREAM_CODEC, IxaMachineRecipe::modifier,
                        ItemStack.STREAM_CODEC, IxaMachineRecipe::output,
                        IxaMachineRecipe::new);

        @Override
        public MapCodec<IxaMachineRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, IxaMachineRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
