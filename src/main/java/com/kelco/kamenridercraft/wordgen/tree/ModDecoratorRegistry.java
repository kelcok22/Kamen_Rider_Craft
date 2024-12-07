package com.kelco.kamenridercraft.wordgen.tree;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModDecoratorRegistry {
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATOR_TYPE_DEFERRED_REGISTER =
            DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, KamenRiderCraftCore.MOD_ID);

//    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<HelheimvineTrunkDecorator>> HELHEIM_VINE_TRUNK_DECORATOR =
//            TREE_DECORATOR_TYPE_DEFERRED_REGISTER.register("helheim_vine_trunk_decorator", () -> new TreeDecoratorType<>(HelheimvineTrunkDecorator.CODEC));

    public static void register(IEventBus eventBus) {
        TREE_DECORATOR_TYPE_DEFERRED_REGISTER.register(eventBus);
    }

}
