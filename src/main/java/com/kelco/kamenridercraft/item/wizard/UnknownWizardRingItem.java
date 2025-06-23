package com.kelco.kamenridercraft.item.wizard;

import com.kelco.kamenridercraft.item.BaseItems.BaseDropItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class UnknownWizardRingItem extends BaseDropItem {
	public UnknownWizardRingItem(Properties properties, ResourceLocation lootTable)
	{
		super(properties, lootTable);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int num, boolean flag) {
		if (entity instanceof Player playerIn) {
			if (world instanceof ServerLevel server) this.dropItem(server, playerIn);
			itemstack.shrink(1);
		}
	}

	}