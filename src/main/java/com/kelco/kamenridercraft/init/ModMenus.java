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
	public static final DeferredHolder<MenuType<?>, MenuType<LockseedHolderGuiMenu>> LOCKSEED_HOLDER_GUI = REGISTRY.register("lockseed_holder_gui", () -> IMenuTypeExtension.create(LockseedHolderGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ShiftCarHolderGuiMenu>> SHIFT_CAR_HOLDER_GUI = REGISTRY.register("shift_car_holder_gui", () -> IMenuTypeExtension.create(ShiftCarHolderGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<KimewazaSlotHolderGuiMenu>> KIMEWAZA_SLOT_HOLDER_GUI = REGISTRY.register("kimewaza_slot_holder_gui", () -> IMenuTypeExtension.create(KimewazaSlotHolderGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FullBottleHolderGuiMenu>> FULL_BOTTLE_HOLDER_GUI = REGISTRY.register("full_bottle_holder_gui", () -> IMenuTypeExtension.create(FullBottleHolderGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PandoraPanelGuiMenu>> PANDORA_PANEL_GUI = REGISTRY.register("pandora_panel_gui", () -> IMenuTypeExtension.create(PandoraPanelGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RidewatchHolderGuiMenu>> RIDEWATCH_HOLDER_GUI = REGISTRY.register("ridewatch_holder_gui", () -> IMenuTypeExtension.create(RidewatchHolderGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MiridewatchHolderGuiMenu>> MIRIDEWATCH_HOLDER_GUI = REGISTRY.register("miridewatch_holder_gui", () -> IMenuTypeExtension.create(MiridewatchHolderGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ProgriseHolderGuiMenu>> PROGRISE_HOLDER_GUI = REGISTRY.register("progrise_holder_gui", () -> IMenuTypeExtension.create(ProgriseHolderGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<IkazuchiProgriseHolderGuiMenu>> IKAZUCHI_PROGRISE_HOLDER_GUI = REGISTRY.register("ikazuchi_progrise_holder_gui", () -> IMenuTypeExtension.create(IkazuchiProgriseHolderGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HissatsuHolderGuiMenu>> HISSATSU_HOLDER_GUI = REGISTRY.register("hissatsu_holder_gui", () -> IMenuTypeExtension.create(HissatsuHolderGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<VistampHolderGuiMenu>> VISTAMP_HOLDER_GUI = REGISTRY.register("vistamp_holder_gui", () -> IMenuTypeExtension.create(VistampHolderGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RaiseBuckleHolderGuiMenu>> RAISE_BUCKLE_HOLDER_GUI = REGISTRY.register("raise_buckle_holder_gui", () -> IMenuTypeExtension.create(RaiseBuckleHolderGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GotchandrawHolderGuiMenu>> GOTCHANDRAW_HOLDER_GUI = REGISTRY.register("gotchandraw_holder_gui", () -> IMenuTypeExtension.create(GotchandrawHolderGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GotchancollectionPanelGuiMenu>> GOTCHANCOLLECTION_PANEL_GUI = REGISTRY.register("gotchancollection_panel_gui", () -> IMenuTypeExtension.create(GotchancollectionPanelGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GochizoHolderGuiMenu>> GOCHIZO_HOLDER_GUI = REGISTRY.register("gochizo_holder_gui", () -> IMenuTypeExtension.create(GochizoHolderGuiMenu::new));

	public static void register(IEventBus eventBus) {REGISTRY.register(eventBus);}

	public static AbstractContainerMenu ASTROSWITCH_PANEL_DOUBLE_GUI(int p51622, Inventory p51623) {
        return null;
    }
}
