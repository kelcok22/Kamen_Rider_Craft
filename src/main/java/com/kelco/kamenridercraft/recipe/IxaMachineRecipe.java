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

public record IxaMachineRecipe(NonNullList<Ingredient> inputs, ItemStack output, java.util.Map<ResourceLocation, Integer> weights
) implements Recipe<IxaMachineRecipeInput> {

    public IxaMachineRecipe(Ingredient first, Ingredient second, ItemStack output) {
        this(NonNullList.create(), output, java.util.Map.of());
        this.inputs.add(first);
        this.inputs.add(second);
    }
    public IxaMachineRecipe(NonNullList<Ingredient> inputs, ItemStack output) {
        this(inputs, output, java.util.Map.of());
    }

    public IxaMachineRecipe(NonNullList<Ingredient> inputs, ItemStack output, java.util.Map<ResourceLocation, Integer> weights) {
        this.inputs = inputs;
        this.output = output;
        this.weights = java.util.Map.copyOf(weights);
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return ModRecipes.IXA_MACHINE_BLOCK_SERIALIZER.get();
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> ingredients = NonNullList.copyOf(inputs);
        return ingredients;
    }


    @Override
    public boolean matches(@NotNull IxaMachineRecipeInput recipeInput, Level level) {
        if (level.isClientSide) return false;
        if (recipeInput.size() < 2 || inputs.size() < 2) return false;

        ItemStack in0 = recipeInput.getItem(0);
        ItemStack in1 = recipeInput.getItem(1);
        Ingredient a = inputs.get(0);
        Ingredient b = inputs.get(1);

        return (a.test(in0) && b.test(in1)) || (a.test(in1) && b.test(in0));
    }


    @Override
    public ItemStack assemble(@NotNull IxaMachineRecipeInput ixaMachineRecipeInput, HolderLookup.@NotNull Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public RecipeType<? extends Recipe<IxaMachineRecipeInput>> getType() {
        return ModRecipes.IXA_MACHINE_BLOCK_TYPE.get();
    }

    public int getWeightFor(net.minecraft.world.item.Item item) {
        ResourceLocation key = BuiltInRegistries.ITEM.getKey(item);
        if (key == null) return 1;
        return Math.max(0, weights.getOrDefault(key, 1));
    }

    public java.util.Map<ResourceLocation, Integer> weights() {
        return this.weights;
    }

    public static class Serializer implements RecipeSerializer<IxaMachineRecipe> {

        // Store weights as a simple map of item ids -> int
        private static final Codec<Map<ResourceLocation, Integer>> WEIGHTS_CODEC =
                Codec.unboundedMap(ResourceLocation.CODEC, Codec.INT);


    public static final MapCodec<IxaMachineRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients")
                            .flatXmap(list -> {
                                        NonNullList<Ingredient> nnl = NonNullList.create();
                                        nnl.addAll(list);
                                        return DataResult.success(nnl);
                                    },
                                    (NonNullList<Ingredient> nnl) -> DataResult.success(List.copyOf(nnl)))
                            .forGetter(IxaMachineRecipe::inputs),

                    ItemStack.CODEC.fieldOf("result").forGetter(IxaMachineRecipe::output),

                    WEIGHTS_CODEC.optionalFieldOf("weights", java.util.Map.of())
                            .forGetter(IxaMachineRecipe::weights)
            ).apply(instance, IxaMachineRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, IxaMachineRecipe> STREAM_CODEC = StreamCodec.of(
            // encode
            (buf, recipe) -> {
                ByteBufCodecs.collection(NonNullList::createWithCapacity, Ingredient.CONTENTS_STREAM_CODEC)
                        .encode((RegistryFriendlyByteBuf) buf, recipe.inputs);
                ItemStack.STREAM_CODEC.encode((RegistryFriendlyByteBuf) buf, recipe.output());
                var weights = recipe.weights();
                ((RegistryFriendlyByteBuf) buf).writeVarInt(weights.size());
                for (var e : weights.entrySet()) {
                    ((RegistryFriendlyByteBuf) buf).writeResourceLocation(e.getKey());
                    ((RegistryFriendlyByteBuf) buf).writeVarInt(e.getValue());
                }
            },
            buf -> {
                NonNullList<Ingredient> decodedInputs =
                        ByteBufCodecs.collection(NonNullList::createWithCapacity, Ingredient.CONTENTS_STREAM_CODEC).decode((RegistryFriendlyByteBuf) buf);
                ItemStack result = ItemStack.STREAM_CODEC.decode((RegistryFriendlyByteBuf) buf);
                int size = ((RegistryFriendlyByteBuf) buf).readVarInt();
                java.util.Map<ResourceLocation, Integer> weights = new java.util.HashMap<>();
                for (int i = 0; i < size; i++) {
                    ResourceLocation id = ((RegistryFriendlyByteBuf) buf).readResourceLocation();
                    int w = ((RegistryFriendlyByteBuf) buf).readVarInt();
                    weights.put(id, w);
                }
                return new IxaMachineRecipe(decodedInputs, result, weights);
            }
    );

        @Override
        public @NotNull MapCodec<IxaMachineRecipe> codec() {
            return CODEC;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, IxaMachineRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
