package com.kelco.kamenridercraft.item.base_items;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;


public class BaseDropItem extends BaseItem {
    public ResourceLocation lootTablePath;

    public BaseDropItem(Properties properties, ResourceLocation lootTable) {
        super(properties);
        lootTablePath = lootTable;
    }

    public void dropItem(ServerLevel world, Player player) {
        ResourceKey<LootTable> loot = ResourceKey.create(Registries.LOOT_TABLE, lootTablePath);
        LootTable loottable = world.getServer().reloadableRegistries().getLootTable(loot);
        LootParams.Builder lootparams$builder = new LootParams.Builder(world)
                .withParameter(LootContextParams.THIS_ENTITY, player)
                .withParameter(LootContextParams.ORIGIN, player.position());

        LootParams lootparams = lootparams$builder.create(LootContextParamSets.EQUIPMENT);
        loottable.getRandomItems(lootparams, 0L, player::spawnAtLocation);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);

        if (world instanceof ServerLevel server) {
            this.dropItem(server, player);
            if (!player.hasInfiniteMaterials()) itemStack.shrink(1);

        }
        return InteractionResultHolder.consume(itemStack);
    }
}