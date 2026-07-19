package com.kelco.kamenridercraft.loot;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.heisei_phase_1.RyukiRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.OOORiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.WRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.WizardRiderItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, KamenRiderCraftCore.MOD_ID);
    }

    @Override
    protected void start() {
        add("egg_chicken_memory",new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("entities/chicken")).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()},
                WRiderItems.EGG_CHICKEN_MEMORY.get()));

        add("wizard_stone",new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("entities/phantom")).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()},
                WizardRiderItems.WIZARD_GEM.get()));

        add("purple_medals_nether",new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()},
                OOORiderItems.PURPLE_MEDALS_SEALED.get()));

        add("beast_rings_pyramid",new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/desert_pyramid")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()},
                WizardRiderItems.UNKNOWN_BEAST_RING.get()));

        add("beast_rings_jungle",new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/jungle_temple")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()},
                WizardRiderItems.UNKNOWN_BEAST_RING.get()));

        add("beast_rings_pyramid_archeology",new AddSusSandItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("archaeology/desert_pyramid")).build()},
                WizardRiderItems.UNKNOWN_BEAST_RING.get()));

        add("blank_deck_ruined_portal",new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/ruined_portal")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()},
                RyukiRiderItems.BLANK_DECK.get()));

        add("blank_deck_simple_dungeon",new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()},
                RyukiRiderItems.BLANK_DECK.get()));

        add("mayo",new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("gameplay/fishing")).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build()},
                ModdedItemCore.MAYO.get()));
    }
}