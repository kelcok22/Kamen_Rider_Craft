package com.kelco.kamenridercraft.level;

import net.minecraft.world.level.GameRules;
import net.neoforged.bus.api.IEventBus;

public class ModGameRules {
    public static GameRules.Key<GameRules.BooleanValue> RULE_REIWA_RIDEWATCHES;
    public static GameRules.Key<GameRules.IntegerValue> RULE_SUMMONED_ITEM_DURABILITY;
    public static GameRules.Key<GameRules.BooleanValue> RULE_GOLD_DRIVE_WEAPON_STEAL;
    public static GameRules.Key<GameRules.IntegerValue> RULE_BOSS_SPAWN_PERCENTAGE;
    public static GameRules.Key<GameRules.BooleanValue> RULE_BOSS_HENSHIN_ANNOUCEMENTS;

    public static void register(IEventBus eventBus) {
        RULE_REIWA_RIDEWATCHES = GameRules.register(
                "reiwaRidewatches", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));

        RULE_SUMMONED_ITEM_DURABILITY = GameRules.register(
                "summonedItemDurability", GameRules.Category.PLAYER, GameRules.IntegerValue.create(100));

        RULE_GOLD_DRIVE_WEAPON_STEAL = GameRules.register(
                "gordDriveWeaponYoink", GameRules.Category.MOBS, GameRules.BooleanValue.create(false));

        RULE_BOSS_SPAWN_PERCENTAGE = GameRules.register(
                "bossSpawnPercentage", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(10));

        RULE_BOSS_HENSHIN_ANNOUCEMENTS = GameRules.register(
                "bossHenshinAnnouncements", GameRules.Category.CHAT, GameRules.BooleanValue.create(true)
        );
    }
}
