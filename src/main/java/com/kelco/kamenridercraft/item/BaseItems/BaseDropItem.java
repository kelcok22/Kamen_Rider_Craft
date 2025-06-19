package com.kelco.kamenridercraft.item.BaseItems;

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


public class BaseDropItem extends BaseItem {
	public ResourceLocation LOOT_TABLE_PATH;
	public BaseDropItem(Properties properties, ResourceLocation lootTable)
	{
		super(properties);
		LOOT_TABLE_PATH = lootTable;
	}
    
    public void dropItem(ServerLevel world, Player player) {
		ResourceKey<LootTable> loot = ResourceKey.create(Registries.LOOT_TABLE, LOOT_TABLE_PATH);
        LootTable loottable = world.getServer().reloadableRegistries().getLootTable(loot);
        LootParams.Builder lootparams$builder = new LootParams.Builder((ServerLevel)world)
        	.withParameter(LootContextParams.THIS_ENTITY, player)
        	.withParameter(LootContextParams.ORIGIN, player.position());

        LootParams lootparams = lootparams$builder.create(LootContextParamSets.EQUIPMENT);
        loottable.getRandomItems(lootparams, 0L, player::spawnAtLocation);
    }

	@Override
		public InteractionResultHolder<ItemStack> use(Level world, Player playerIn, InteractionHand p_41434_) {
			ItemStack itemstack = playerIn.getItemInHand(p_41434_);

			if (world instanceof ServerLevel server) this.dropItem(server, playerIn);
			if (!playerIn.hasInfiniteMaterials()) itemstack.shrink(1);
			return InteractionResultHolder.consume(itemstack);
		}

	}