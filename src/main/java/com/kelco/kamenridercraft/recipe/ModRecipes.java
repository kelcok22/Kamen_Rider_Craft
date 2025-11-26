package com.kelco.kamenridercraft.recipe;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, KamenRiderCraftCore.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, KamenRiderCraftCore.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<IxaMachineRecipe>> IXA_MACHINE_BLOCK_SERIALIZER =
            SERIALIZERS.register("ixa_machine_block", IxaMachineRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<IxaMachineRecipe>> IXA_MACHINE_BLOCK_TYPE =
            TYPES.register("ixa_machine_block", () -> new RecipeType<IxaMachineRecipe>() {
                @Override
                public String toString() {
                    return "ixa_machine_block";
                }
            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
