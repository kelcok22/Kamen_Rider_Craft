package com.kelco.kamenridercraft.item.misc;

import com.kelco.kamenridercraft.item.BaseItems.BaseItem;

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


public class GiftItem extends BaseItem {

	public GiftItem(Properties properties) {
		super(properties);
	}

	public void  useEnergyItem (ItemStack itemstack, Level world,Player playerIn) {
		if (!world.isClientSide()) {
			ResourceKey<LootTable> loot = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("kamenridercraft", "items/gift"));
        	LootTable loottable = world.getServer().reloadableRegistries().getLootTable(loot);
        	LootParams.Builder lootparams$builder = new LootParams.Builder((ServerLevel)world)
            	.withParameter(LootContextParams.THIS_ENTITY, playerIn)
            	.withParameter(LootContextParams.ORIGIN, playerIn.position());

        	LootParams lootparams = lootparams$builder.create(LootContextParamSets.GIFT);
        	loottable.getRandomItems(lootparams, 0L, stack -> {
				playerIn.spawnAtLocation(stack);
			});
		}
			
		if (!playerIn.isCreative()) itemstack.shrink(1);
	}


	@Override
		public InteractionResultHolder<ItemStack> use(Level world, Player playerIn, InteractionHand p_41434_) {
			ItemStack itemstack = playerIn.getItemInHand(p_41434_);

			this.useEnergyItem(itemstack,world, playerIn);
			return InteractionResultHolder.consume(itemstack);
		}

	}