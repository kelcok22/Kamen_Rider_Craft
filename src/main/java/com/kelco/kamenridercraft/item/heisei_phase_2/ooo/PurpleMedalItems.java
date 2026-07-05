package com.kelco.kamenridercraft.item.heisei_phase_2.ooo;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

public class PurpleMedalItems extends BaseItem {
    public PurpleMedalItems(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean flag) {
        if (entity instanceof Player player && level instanceof ServerLevel server) {
            ResourceKey<LootTable> loot = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/purple_medals_opened"));
            LootTable loottable = server.getServer().reloadableRegistries().getLootTable(loot);
            LootParams.Builder lootparams$builder = new LootParams.Builder(server)
                    .withParameter(LootContextParams.THIS_ENTITY, player)
                    .withParameter(LootContextParams.ORIGIN, player.position());

            LootParams lootparams = lootparams$builder.create(LootContextParamSets.EQUIPMENT);
            loottable.getRandomItems(lootparams, 0L, player::spawnAtLocation);
            player.sendSystemMessage(Component.translatable("loot.kamenridercraft.purple_medals"));
        }
        itemStack.shrink(1);
    }
}
