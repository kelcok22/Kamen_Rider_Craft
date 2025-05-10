package com.kelco.kamenridercraft.particle;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, KamenRiderCraftCore.MOD_ID);

    public static final Supplier<SimpleParticleType> HIT_PARTICLES =
            PARTICLE_TYPES.register("hit_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> WIZARD_PARTICLES =
            PARTICLE_TYPES.register("wizard_particles", () -> new SimpleParticleType(true));


    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}