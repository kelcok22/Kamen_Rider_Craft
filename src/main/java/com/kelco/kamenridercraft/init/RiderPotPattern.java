package com.kelco.kamenridercraft.init;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.world.inventory.*;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import java.util.function.Supplier;

public class RiderPotPattern{
    public static final DeferredRegister<DecoratedPotPattern> REGISTRY = DeferredRegister.create(Registries.DECORATED_POT_PATTERN, KamenRiderCraftCore.MOD_ID);

    public static final Holder<DecoratedPotPattern> WARRIOR = REGISTRY.register("warrior",
            () -> new DecoratedPotPattern(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"warrior")));

    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);}


}
