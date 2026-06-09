package com.kelco.kamenridercraft.recipe;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.MOD_ID;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<IxaMachineRecipe>> IXA_MACHINE_BLOCK_SERIALIZER =
            SERIALIZERS.register("ixa_machine_block", IxaMachineRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<IxaMachineRecipe>> IXA_MACHINE_BLOCK_TYPE =
            TYPES.register("ixa_machine_block", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "ixa_machine_block";
                }
            });


    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, MOD_ID);

    public static final Supplier<RecipeType<NeoIxaMachineRecipe>> NEO_IXA_RECIPE =
            RECIPE_TYPES.register(
                    "neo_ixa_recipe",
                    () -> RecipeType.<NeoIxaMachineRecipe>simple(ResourceLocation.fromNamespaceAndPath(MOD_ID, "neo_ixa_recipe"))
            );

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, MOD_ID);

    public static final Supplier<RecipeSerializer<NeoIxaMachineRecipe>> NEO_IXA_SERIALIZER =
            RECIPE_SERIALIZERS.register("neo_ixa_serializer", NeoIxaSerializer::new);


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
        RECIPE_TYPES.register(eventBus);
        RECIPE_SERIALIZERS.register(eventBus);
    }
}
