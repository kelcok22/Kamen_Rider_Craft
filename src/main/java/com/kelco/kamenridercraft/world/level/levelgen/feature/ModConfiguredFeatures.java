package com.kelco.kamenridercraft.world.level.levelgen.feature;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.RiderBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModConfiguredFeatures {
    public static final DeferredRegister<Feature<?>> FEATURE = DeferredRegister.create(BuiltInRegistries.FEATURE, KamenRiderCraftCore.MOD_ID);
    public static final Holder<Feature<?>> HELHEIM_VINES = FEATURE.register("helheim_vines", () ->
            new HelheimVineFeature(NoneFeatureConfiguration.CODEC));
    public static final ResourceKey<ConfiguredFeature<?, ?>> HELHEIM_TREE_KEY = registerKey("helheim_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_HELHEIM_TREE_KEY = registerKey("warped_helheim_tree");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        register(context, HELHEIM_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(RiderBlocks.HELHEIM_LOG.get()),
                new StraightTrunkPlacer(7, 4, 3),

                BlockStateProvider.simple(RiderBlocks.HELHEIM_LEAVES.get()),
                new SpruceFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2), UniformInt.of(3, 4)),
                new TwoLayersFeatureSize(2, 0, 4))
                .build());
        register(context, WARPED_HELHEIM_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(RiderBlocks.HELHEIM_LOG.get()),
                new CherryTrunkPlacer(
                        5,
                        4,
                        3,
                        new WeightedListInt(
                                SimpleWeightedRandomList.<IntProvider>builder().add(ConstantInt.of(1), 1)
                                        .add(ConstantInt.of(2), 1).add(ConstantInt.of(3), 1).build()
                        ),
                        UniformInt.of(2, 4),
                        UniformInt.of(-5, -3),
                        UniformInt.of(-1, 0)
                ),
                BlockStateProvider.simple(RiderBlocks.HELHEIM_LEAVES.get()),
                new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5),
                        0.25F, 0.5F,
                        0.16666667F, 0.33333334F),
                new TwoLayersFeatureSize(3, 0, 5)).build());
    }

    public static void register(IEventBus eventBus) {
        FEATURE.register(eventBus);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}