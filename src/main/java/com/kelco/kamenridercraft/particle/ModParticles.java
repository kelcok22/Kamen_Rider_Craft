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

    public static final Supplier<SimpleParticleType> WHITE_SPARK_PARTICLES =
            PARTICLE_TYPES.register("white_spark_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> GREY_SPARK_PARTICLES =
            PARTICLE_TYPES.register("grey_spark_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> RED_SPARK_PARTICLES =
            PARTICLE_TYPES.register("red_spark_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> DARK_RED_SPARK_PARTICLES =
            PARTICLE_TYPES.register("dark_red_spark_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> ORANGE_SPARK_PARTICLES =
            PARTICLE_TYPES.register("orange_spark_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> BLUE_SPARK_PARTICLES =
            PARTICLE_TYPES.register("blue_spark_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> DARK_BLUE_SPARK_PARTICLES =
            PARTICLE_TYPES.register("dark_blue_spark_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> CYAN_SPARK_PARTICLES =
            PARTICLE_TYPES.register("cyan_spark_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> BROWN_SPARK_PARTICLES =
            PARTICLE_TYPES.register("brown_spark_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> GREEN_SPARK_PARTICLES =
            PARTICLE_TYPES.register("green_spark_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> DARK_GREEN_SPARK_PARTICLES =
            PARTICLE_TYPES.register("dark_green_spark_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> PURPLE_SPARK_PARTICLES =
            PARTICLE_TYPES.register("purple_spark_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> YELLOW_SPARK_PARTICLES =
            PARTICLE_TYPES.register("yellow_spark_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> PINK_SPARK_PARTICLES =
            PARTICLE_TYPES.register("pink_spark_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> GOLD_SPARK_PARTICLES =
            PARTICLE_TYPES.register("gold_spark_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> BLACK_SPARK_PARTICLES =
            PARTICLE_TYPES.register("black_spark_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> RANDOM_SPARK_PARTICLES =
            PARTICLE_TYPES.register("random_spark_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> GLASS_PARTICLES =
            PARTICLE_TYPES.register("glass_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> CHAIN_PARTICLES =
            PARTICLE_TYPES.register("chain_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> GOLD_BAT_PARTICLES =
            PARTICLE_TYPES.register("gold_bat_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> RED_WIZARD_PARTICLES =
            PARTICLE_TYPES.register("wizard_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> BLUE_WIZARD_PARTICLES =
            PARTICLE_TYPES.register("blue_wizard_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> GREEN_WIZARD_PARTICLES =
            PARTICLE_TYPES.register("green_wizard_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> YELLOW_WIZARD_PARTICLES =
            PARTICLE_TYPES.register("yellow_wizard_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> WHITE_WIZARD_PARTICLES =
            PARTICLE_TYPES.register("white_wizard_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> BLACK_WIZARD_PARTICLES =
            PARTICLE_TYPES.register("black_wizard_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> PURPLE_WIZARD_PARTICLES =
            PARTICLE_TYPES.register("purple_wizard_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> ORANGE_WIZARD_PARTICLES =
            PARTICLE_TYPES.register("orange_wizard_particles", () -> new SimpleParticleType(true));


    public static final Supplier<SimpleParticleType> HIT_PARTICLES =
            PARTICLE_TYPES.register("hit_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> REALIZING_PARTICLES =
            PARTICLE_TYPES.register("realize_hopper_lines", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> GUMMI_PARTICLES =
            PARTICLE_TYPES.register("gummi_particles_1", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> GUMMI_PARTICLES2 =
            PARTICLE_TYPES.register("gummi_particles_2", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> GUMMI_PARTICLES3 =
            PARTICLE_TYPES.register("gummi_particles_3", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> SNACK_PARTICLES =
            PARTICLE_TYPES.register("snack_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> CHOCO_PARTICLES =
            PARTICLE_TYPES.register("choco_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> CANDY_PARTICLES =
            PARTICLE_TYPES.register("candy_particles", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> CANDY_PARTICLES2 =
            PARTICLE_TYPES.register("candy_2_particles", () -> new SimpleParticleType(true));


    public static final Supplier<SimpleParticleType> CANDY_PARTICLES3 =
            PARTICLE_TYPES.register("candy_3_particles", () -> new SimpleParticleType(true));


    public static final Supplier<SimpleParticleType> CANDY_PARTICLES4 =
            PARTICLE_TYPES.register("candy_4_particles", () -> new SimpleParticleType(true));


    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}