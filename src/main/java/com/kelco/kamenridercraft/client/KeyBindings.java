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
            InputConstants.getKey(InputConstants.KEY_B, 48),
            CATEGORY
    );

    public final KeyMapping PrimaryAbilityKey = new KeyMapping(
            "key."+ KamenRiderCraftCore.MOD_ID +".primary_ability",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_C, 46),
            CATEGORY
    );

    public final KeyMapping SecondaryAbilityKey = new KeyMapping(
            "key."+ KamenRiderCraftCore.MOD_ID +".secondary_ability",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_V, 47),
            CATEGORY
    );

    public final KeyMapping PoseKey = new KeyMapping(
            "key."+ KamenRiderCraftCore.MOD_ID +".pose",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_G, 34),
            CATEGORY
    );

    public final KeyMapping VehicleForwardsKey = new KeyMapping(
            "key."+ KamenRiderCraftCore.MOD_ID +".vehicle_forwards",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_W, 17),
            CATEGORY
    );

    public final KeyMapping VehicleBackwardsKey = new KeyMapping(
            "key."+ KamenRiderCraftCore.MOD_ID +".vehicle_backwards",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_S, 31),
            CATEGORY
    );

    public final KeyMapping VehicleLeftKey = new KeyMapping(
            "key."+ KamenRiderCraftCore.MOD_ID +".vehicle_left",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_A, 30),
            CATEGORY
    );

    public final KeyMapping VehicleRightKey = new KeyMapping(
            "key."+ KamenRiderCraftCore.MOD_ID +".vehicle_right",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_D, 32),
            CATEGORY
    );

    public final KeyMapping VehicleJumpKey = new KeyMapping(
            "key."+ KamenRiderCraftCore.MOD_ID +".vehicle_jump",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_SPACE, 57),
            CATEGORY
    );

    public final KeyMapping VehicleDriftKey = new KeyMapping(
            "key."+ KamenRiderCraftCore.MOD_ID +".vehicle_drift",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_X, 45),
            CATEGORY
    );

}


