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

public record GameCreatorRecipe(Ingredient primaryInput, Optional<Ingredient> optionalInput,
                                List<WeightedOutput> outputs) implements Recipe<GameCreatorRecipeInput> {
    public static final MapCodec<GameCreatorRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("primary_input").forGetter(GameCreatorRecipe::primaryInput),

            Ingredient.CODEC.optionalFieldOf("optional_input").forGetter(GameCreatorRecipe::optionalInput),

            WeightedOutput.CODEC.listOf().fieldOf("outputs").forGetter(GameCreatorRecipe::outputs)
    ).apply(inst, GameCreatorRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, GameCreatorRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, GameCreatorRecipe::primaryInput,
            ByteBufCodecs.optional(Ingredient.CONTENTS_STREAM_CODEC), GameCreatorRecipe::optionalInput,
            WeightedOutput.STREAM_CODEC.apply(ByteBufCodecs.list()), GameCreatorRecipe::outputs,
            GameCreatorRecipe::new
    );

    @Override
    public boolean matches(GameCreatorRecipeInput input, @NotNull Level level) {
        if (input.size() < 2) return false;
        ItemStack slot0 = input.getItem(0);
        ItemStack slot1 = input.getItem(1);

        if (!primaryInput.test(slot0)) return false;

        return optionalInput.map(ingredient -> ingredient.test(slot1)).orElseGet(slot1::isEmpty);
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull GameCreatorRecipeInput input, HolderLookup.@NotNull Provider provider) {
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
        return ModRecipes.GAME_CREATOR_SERIALIZER.get();
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return ModRecipes.GAME_CREATOR_TYPE.get();
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