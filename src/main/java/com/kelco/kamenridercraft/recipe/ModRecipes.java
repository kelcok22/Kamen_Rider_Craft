package com.kelco.kamenridercraft.recipe;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, KamenRiderCraftCore.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, KamenRiderCraftCore.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<AmazonCellExtractorRecipe>> AMAZON_CELL_EXTRACTOR_SERIALIZER =
            SERIALIZERS.register("dna_extractor", () -> new RecipeSerializer<AmazonCellExtractorRecipe>() {
                @Override
                public com.mojang.serialization.@NotNull MapCodec<AmazonCellExtractorRecipe> codec() {
                    return AmazonCellExtractorRecipe.CODEC;
                }

                @Override
                public net.minecraft.network.codec.@NotNull StreamCodec<net.minecraft.network.RegistryFriendlyByteBuf,
                        AmazonCellExtractorRecipe> streamCodec() {
                    return AmazonCellExtractorRecipe.STREAM_CODEC;
                }
            });

    public static final DeferredHolder<RecipeType<?>, RecipeType<AmazonCellExtractorRecipe>> AMAZON_CELL_EXTRACTOR_TYPE =
            TYPES.register("dna_extractor", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "dna_extractor";
                }
            });


    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<IxaMachineRecipe>> IXA_MACHINE_BLOCK_SERIALIZER =
            SERIALIZERS.register("fuestle_replicator", () -> new RecipeSerializer<IxaMachineRecipe>() {
                @Override
                public com.mojang.serialization.@NotNull MapCodec<IxaMachineRecipe> codec() {
                    return IxaMachineRecipe.CODEC;
                }

                @Override
                public net.minecraft.network.codec.@NotNull StreamCodec<net.minecraft.network.RegistryFriendlyByteBuf, IxaMachineRecipe> streamCodec() {
                    return IxaMachineRecipe.STREAM_CODEC;
                }
            });


    public static final DeferredHolder<RecipeType<?>, RecipeType<IxaMachineRecipe>> IXA_MACHINE_BLOCK_TYPE =
            TYPES.register("fuestle_replicator", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "fuestle_replicator";
                }
            });


    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<AstroswitchProgrammerRecipe>> ASTROSWITCH_PROGRAMMER_SERIALIZER =
            SERIALIZERS.register("astroswitch_programmer", () -> new RecipeSerializer<AstroswitchProgrammerRecipe>() {
                @Override
                public com.mojang.serialization.@NotNull MapCodec<AstroswitchProgrammerRecipe> codec() {
                    return AstroswitchProgrammerRecipe.CODEC;
                }

                @Override
                public net.minecraft.network.codec.@NotNull StreamCodec<net.minecraft.network.RegistryFriendlyByteBuf,
                        AstroswitchProgrammerRecipe> streamCodec() {
                    return AstroswitchProgrammerRecipe.STREAM_CODEC;
                }
            });

    public static final DeferredHolder<RecipeType<?>, RecipeType<AstroswitchProgrammerRecipe>> ASTROSWITCH_PROGRAMMER_TYPE =
            TYPES.register("astroswitch_programmer", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "astroswitch_programmer";
                }
            });

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
