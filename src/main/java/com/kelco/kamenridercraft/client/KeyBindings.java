package com.kelco.kamenridercraft.client;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.settings.KeyConflictContext;

public class KeyBindings {
    public static final KeyBindings INSTANCE = new KeyBindings();

    private static final String CATEGORY = "key.categories." + KamenRiderCraftCore.MOD_ID;

    public final KeyMapping BeltKey = new KeyMapping(
            "key."+ KamenRiderCraftCore.MOD_ID +".belt",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_V, -1),
            CATEGORY
    );

}


