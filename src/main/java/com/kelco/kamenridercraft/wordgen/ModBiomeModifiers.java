package com.kelco.kamenridercraft.wordgen;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {
       public static final ResourceKey<BiomeModifier> ADD_HELHEIM_TREE = registerKey("helheim_tree");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);


/*
        context.register(ADD_HELHEIM_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"helheim")))),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeature.HELHEIM_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
*/
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, name));
    }
}