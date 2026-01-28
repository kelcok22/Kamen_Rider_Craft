package com.kelco.kamenridercraft.world.damagesource;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class RiderDamageTypes {

    public static   ResourceKey<DamageType> RIDER_KICK = registerKey("rider_kick");
    public static   ResourceKey<DamageType> MEDAL = registerKey("medal");

    public  static void bootstrap(BootstrapContext<DamageType> context) {
        context.register(RIDER_KICK, new DamageType("rider_kick", 0.1F));
        context.register(MEDAL, new DamageType("medal", 0.1F));
    }
    private static ResourceKey<DamageType> registerKey(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, name));
    }
}
