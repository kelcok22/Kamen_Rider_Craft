package com.kelco.kamenridercraft.init;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.world.inventory.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

public class ModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, KamenRiderCraftCore.MOD_ID);
	public static final DeferredHolder<MenuType<?>, MenuType<RingHolderGuiMenu>> RING_HOLDER_GUI = REGISTRY.register("ring_holder_gui", () -> IMenuTypeExtension.create(RingHolderGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdventDeckGuiMenu>> ADVENT_DECK_GUI = REGISTRY.register("advent_deck_gui", () -> IMenuTypeExtension.create(AdventDeckGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RouseBankGuiMenu>> ROUSE_BANK_GUI = REGISTRY.register("rouse_bank_gui", () -> IMenuTypeExtension.create(RouseBankGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FueslotGuiMenu>> FUESLOT_GUI = REGISTRY.register("fueslot_gui", () -> IMenuTypeExtension.create(FueslotGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RideBookerGuiMenu>> RIDE_BOOKER_GUI = REGISTRY.register("ride_booker_gui", () -> IMenuTypeExtension.create(RideBookerGuiMenu::new));



	public static void register(IEventBus eventBus) {REGISTRY.register(eventBus);}
}
