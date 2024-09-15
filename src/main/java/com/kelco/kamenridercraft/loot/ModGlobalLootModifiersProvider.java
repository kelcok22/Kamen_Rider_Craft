package com.kelco.kamenridercraft.loot;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.OOO_Rider_Items;
import com.kelco.kamenridercraft.item.Wizard_Rider_Items;
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
        add("purple_medals_nether",new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build()},
                OOO_Rider_Items.PURPLE_MEDALS_SEALED.get()));

        add("beast_rings_pyramid",new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/desert_pyramid")).build(),
                LootItemRandomChanceCondition.randomChance(0.9f).build()},
                Wizard_Rider_Items.UNKNOWN_BEAST_RING.get()));

        add("beast_rings_jungle",new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/jungle_temple")).build(),
                LootItemRandomChanceCondition.randomChance(0.9f).build()},
                Wizard_Rider_Items.UNKNOWN_BEAST_RING.get()));
    }
}
