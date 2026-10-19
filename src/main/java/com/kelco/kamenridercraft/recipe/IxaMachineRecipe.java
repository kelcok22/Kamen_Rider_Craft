package com.kelco.kamenridercraft.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public record IxaMachineRecipe(Ingredient primaryInput, Optional<Ingredient> optionalInput, List<WeightedOutput> outputs) implements Recipe<IxaMachineRecipeInput> {


    public static final MapCodec<IxaMachineRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("primary_input").forGetter(IxaMachineRecipe::primaryInput),

            Ingredient.CODEC.optionalFieldOf("optional_input").forGetter(IxaMachineRecipe::optionalInput),

            WeightedOutput.CODEC.listOf().fieldOf("outputs").forGetter(IxaMachineRecipe::outputs)
    ).apply(inst, IxaMachineRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, IxaMachineRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, IxaMachineRecipe::primaryInput,
            ByteBufCodecs.optional(Ingredient.CONTENTS_STREAM_CODEC), IxaMachineRecipe::optionalInput,
            WeightedOutput.STREAM_CODEC.apply(ByteBufCodecs.list()), IxaMachineRecipe::outputs,
            IxaMachineRecipe::new
    );

    @Override
    public boolean matches(IxaMachineRecipeInput input, Level level) {
        if (input.size() < 2) return false;
        ItemStack slot0 = input.getItem(0);
        ItemStack slot1 = input.getItem(1);

        if (!this.primaryInput.test(slot0)) return false;

        if (this.optionalInput.isPresent()) {
            return this.optionalInput.get().test(slot1);
        } else {
            return slot1.isEmpty();
        }
    }

    @Override
    public ItemStack assemble(IxaMachineRecipeInput input, HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.IXA_MACHINE_BLOCK_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.IXA_MACHINE_BLOCK_TYPE.get();
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