package com.kelco.kamenridercraft.data;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType HELHEIM = WoodType.register(new WoodType(KamenRiderCraftCore.MOD_ID + ":helheim", BlockSetType.OAK));
}
