package com.kelco.kamenridercraft;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
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

    private static final ModConfigSpec.IntValue SUMMONED_ITEM_DAMAGE = BUILDER.push("General Settings")
            .comment(" (default: 100) How much durability should a weapon/tool have when summoned rather than obtained normally? Set to 0 for the tool's normal durability.")
            .defineInRange("summonedItemDurability", 100, 0, Integer.MAX_VALUE);

    private static final ModConfigSpec.DoubleValue BOSS_SPAWN_RATE = BUILDER
            .comment(" (default: 10.0%) How often should the mobs spawn bosses when killed?")
            .defineInRange("bossSpawnRate", 10.0, 0.0, 100.0);

    private static final ModConfigSpec.BooleanValue KINTAROS_TISSUE_DROP = BUILDER.pop().push("Series-Specific Settings")
            .comment(" (default: true) Should Kintaros drop paper (tissues) when transformed into his Den-O form?")
            .define("kintarosTissueDrop", true);

    private static final ModConfigSpec.BooleanValue MIGHTY_BROTHER_SPAWNING = BUILDER
            .comment(" (default: true) Should Parado spawn when using the Mighty Brothers XX and Knock Out Fighter 2 Gashats?")
            .define("mightyBrotherSpawning", true);

    private static final ModConfigSpec.BooleanValue DECADE_ARMOR_EX_AID_SPAWNING = BUILDER
            .comment(" (default: true) Should using a DecadeArmor Ex-Aid form spawn the other side?")
            .define("decadeExAidSpawning", true);

    private static final ModConfigSpec.BooleanValue VICE_SPAWNING = BUILDER
            .comment(" (default: true) Should Vice spawn if you are playing as Kamen Rider Revi?")
            .define("viceSpawning", true);

    /*public static final ModConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
            .comment("What you want the introduction message to be for the magic number")
            .define("magicNumberIntroduction", "The magic number is... ");

     a list of strings that are treated as resource locations for items
    private static final ModConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
            .comment("A list of items to log on common setup.")
            .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), Config::validateItemName);*/

    static final ModConfigSpec SPEC = BUILDER.build();

    public static int summonedItemDurability;
    public static double bossSpawnRate;
    public static boolean kintarosTissueDrop;
    public static boolean mightyBrotherSpawning;
    public static boolean decadeExAidSpawning;
    public static boolean viceSpawning;
    /*public static String magicNumberIntroduction;
    public static Set<Item> items;

    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }*/

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        summonedItemDurability = SUMMONED_ITEM_DAMAGE.get();
        bossSpawnRate = BOSS_SPAWN_RATE.get();
        kintarosTissueDrop = KINTAROS_TISSUE_DROP.get();
        mightyBrotherSpawning = MIGHTY_BROTHER_SPAWNING.get();
        decadeExAidSpawning = DECADE_ARMOR_EX_AID_SPAWNING.get();
        viceSpawning = VICE_SPAWNING.get();

        /* convert the list of strings into a set of items
        items = ITEM_STRINGS.get().stream()
                .map(itemName -> BuiltInRegistries.ITEM.get(ResourceLocation.parse(itemName)))
                .collect(Collectors.toSet());*/
    }
}
