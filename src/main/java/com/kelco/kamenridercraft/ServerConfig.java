package com.kelco.kamenridercraft;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = KamenRiderCraftCore.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ServerConfig
{
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

    /*public static final ModConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
            .comment("What you want the introduction message to be for the magic number")
            .define("magicNumberIntroduction", "The magic number is... ");

     a list of strings that are treated as resource locations for items
    private static final ModConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
            .comment("A list of items to log on common setup.")
            .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), Config::validateItemName);*/

    static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean mightyBrotherSpawning;
    public static boolean decadeExAidSpawning;
    public static boolean viceSpawning;
    public static boolean lovekovSpawning;
    /*public static String magicNumberIntroduction;
    public static Set<Item> items;

    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }*/

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        mightyBrotherSpawning = MIGHTY_BROTHER_SPAWNING.get();
        decadeExAidSpawning = DECADE_ARMOR_EX_AID_SPAWNING.get();
        viceSpawning = VICE_SPAWNING.get();
        lovekovSpawning = LOVEKOV_SPAWNING.get();

        /* convert the list of strings into a set of items
        items = ITEM_STRINGS.get().stream()
                .map(itemName -> BuiltInRegistries.ITEM.get(ResourceLocation.parse(itemName)))
                .collect(Collectors.toSet());*/
    }
}
