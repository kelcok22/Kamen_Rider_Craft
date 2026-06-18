package com.kelco.kamenridercraft;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = KamenRiderCraftCore.MOD_ID)
public class ServerConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue MIGHTY_BROTHER_SPAWNING = BUILDER
            .comment(" (default: true) Should Parado spawn when using the Mighty Brothers XX and Knock Out Fighter 2 Gashats?")
            .define("mightyBrotherSpawning", true);

    private static final ModConfigSpec.BooleanValue DECADE_ARMOR_EX_AID_SPAWNING = BUILDER
            .comment(" (default: true) Should using a DecadeArmor Ex-Aid form spawn the other side?")
            .define("decadeExAidSpawning", true);

    private static final ModConfigSpec.BooleanValue VICE_SPAWNING = BUILDER
            .comment(" (default: true) Should Vice spawn if you are playing as Kamen Rider Revi?")
            .define("viceSpawning", true);

    private static final ModConfigSpec.BooleanValue LOVEKOV_SPAWNING = BUILDER
            .comment(" (default: true) Should Lovekov spawn if you are playing as Kamen Rider Jeanne?")
            .define("lovekovSpawning", true);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean mightyBrotherSpawning;
    public static boolean decadeExAidSpawning;
    public static boolean viceSpawning;
    public static boolean lovekovSpawning;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent.Loading event) {
        mightyBrotherSpawning = MIGHTY_BROTHER_SPAWNING.get();
        decadeExAidSpawning = DECADE_ARMOR_EX_AID_SPAWNING.get();
        viceSpawning = VICE_SPAWNING.get();
        lovekovSpawning = LOVEKOV_SPAWNING.get();
    }
}
