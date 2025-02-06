
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.kelco.kamenridercraft.init;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import com.kelco.kamenridercraft.world.inventory.RingHolderGuiMenu;
import com.kelco.kamenridercraft.KamenRiderCraftCore;

public class KamenridercraftModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, KamenRiderCraftCore.MOD_ID);
	public static final DeferredHolder<MenuType<?>, MenuType<RingHolderGuiMenu>> RING_HOLDER_GUI = REGISTRY.register("ring_holder_gui", () -> IMenuTypeExtension.create(RingHolderGuiMenu::new));
}
