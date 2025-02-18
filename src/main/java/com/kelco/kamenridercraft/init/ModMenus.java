package com.kelco.kamenridercraft.init;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.world.inventory.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import java.util.function.Supplier;

public class ModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, KamenRiderCraftCore.MOD_ID);



	public static final Supplier<MenuType<AdventDeckGuiMenu>> ADVENT_DECK_GUI = REGISTRY.register("advent_deck_gui",
			() -> IMenuTypeExtension.create(AdventDeckGuiMenu::new));

	public static final DeferredHolder<MenuType<?>, MenuType<RouseBankGuiMenu>> ROUSE_BANK_GUI = REGISTRY.register("rouse_bank_gui", () -> IMenuTypeExtension.create(RouseBankGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FueslotGuiMenu>> FUESLOT_GUI = REGISTRY.register("fueslot_gui", () -> IMenuTypeExtension.create(FueslotGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RideBookerGuiMenu>> RIDE_BOOKER_GUI = REGISTRY.register("ride_booker_gui", () -> IMenuTypeExtension.create(RideBookerGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AstroswitchPanelGuiMenu>> ASTROSWITCH_PANEL_GUI = REGISTRY.register("astroswitch_panel_gui", () -> IMenuTypeExtension.create(AstroswitchPanelGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AstroswitchPanelDoubleGuiMenu>> ASTROSWITCH_PANEL_DOUBLE_GUI = REGISTRY.register("astroswitch_panel_double_gui", () -> IMenuTypeExtension.create(AstroswitchPanelDoubleGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RingHolderGuiMenu>> RING_HOLDER_GUI = REGISTRY.register("ring_holder_gui", () -> IMenuTypeExtension.create(RingHolderGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PandoraPanelGuiMenu>> PANDORA_PANEL_GUI = REGISTRY.register("pandora_panel_gui", () -> IMenuTypeExtension.create(PandoraPanelGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GotchandrawHolderGuiMenu>> GOTCHANDRAW_HOLDER_GUI = REGISTRY.register("gotchandraw_holder_gui", () -> IMenuTypeExtension.create(GotchandrawHolderGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GotchancollectionPanelGuiMenu>> GOTCHANCOLLECTION_PANEL_GUI = REGISTRY.register("gotchancollection_panel_gui", () -> IMenuTypeExtension.create(GotchancollectionPanelGuiMenu::new));

	public static void register(IEventBus eventBus) {REGISTRY.register(eventBus);}

	public static AbstractContainerMenu ASTROSWITCH_PANEL_DOUBLE_GUI(int p51622, Inventory p51623) {
        return null;
    }
}
