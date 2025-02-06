
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.kelco.kamenridercraft.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import com.kelco.kamenridercraft.client.gui.RingHolderGuiScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(ModMenus.RING_HOLDER_GUI.get(), RingHolderGuiScreen::new);
	}
}
