package com.kelco.kamenridercraft;

import com.kelco.kamenridercraft.client.gui.*;
import com.kelco.kamenridercraft.client.renderer.*;
import com.kelco.kamenridercraft.item.*;
import com.kelco.kamenridercraft.particle.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = KamenRiderCraftCore.MOD_ID, dist = Dist.CLIENT)
public class KamenRiderCraftCoreClient {
    public KamenRiderCraftCoreClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}


