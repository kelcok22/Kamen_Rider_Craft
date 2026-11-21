package com.kelco.kamenridercraft.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public record CellMedalProgrammerRecipe(Ingredient primaryInput, Optional<Ingredient> optionalInput,
                                        List<WeightedOutput> outputs) implements Recipe<CellMedalProgrammerRecipeInput> {
    public static final MapCodec<CellMedalProgrammerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("primary_input").forGetter(CellMedalProgrammerRecipe::primaryInput),

            Ingredient.CODEC.optionalFieldOf("optional_input").forGetter(CellMedalProgrammerRecipe::optionalInput),

            WeightedOutput.CODEC.listOf().fieldOf("outputs").forGetter(CellMedalProgrammerRecipe::outputs)
    ).apply(inst, CellMedalProgrammerRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, CellMedalProgrammerRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, CellMedalProgrammerRecipe::primaryInput,
            ByteBufCodecs.optional(Ingredient.CONTENTS_STREAM_CODEC), CellMedalProgrammerRecipe::optionalInput,
            WeightedOutput.STREAM_CODEC.apply(ByteBufCodecs.list()), CellMedalProgrammerRecipe::outputs,
            CellMedalProgrammerRecipe::new
    );

    @Override
    public boolean matches(CellMedalProgrammerRecipeInput input, @NotNull Level level) {
        if (input.size() < 2) return false;
        ItemStack slot0 = input.getItem(0);
        ItemStack slot1 = input.getItem(1);

        if (!primaryInput.test(slot0)) return false;

        return optionalInput.map(ingredient -> ingredient.test(slot1)).orElseGet(slot1::isEmpty);
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull CellMedalProgrammerRecipeInput input, HolderLookup.@NotNull Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(HolderLookup.@NotNull Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return ModRecipes.CELL_MEDAL_PROGRAMMER_SERIALIZER.get();
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return ModRecipes.CELL_MEDAL_PROGRAMMER_TYPE.get();
    }

    public record WeightedOutput(ItemStack stack, int weight) {
        public static final Codec<WeightedOutput> CODEC = RecordCodecBuilder.create(inst -> inst.group(
                ItemStack.STRICT_CODEC.fieldOf("result").forGetter(WeightedOutput::stack),
                Codec.INT.fieldOf("weight").forGetter(WeightedOutput::weight)
        ).apply(inst, WeightedOutput::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, WeightedOutput> STREAM_CODEC = StreamCodec.composite(
                ItemStack.STREAM_CODEC, WeightedOutput::stack,
                ByteBufCodecs.INT, WeightedOutput::weight,
                WeightedOutput::new
        );
    }
}