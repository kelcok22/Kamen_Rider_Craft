package com.kelco.kamenridercraft.item.BaseItems;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CopyFormChangeItem extends BaseItem {

	private  RiderFormChangeItem FORM_ITEM;
	
	public CopyFormChangeItem( Properties properties, Item form_item) {
		super( properties);
		if ( form_item instanceof RiderFormChangeItem form) FORM_ITEM=form;
	
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

		ItemStack itemstack = player.getItemInHand(usedHand);

		if (FORM_ITEM !=null)FORM_ITEM.use(level, player, usedHand);
		
		return InteractionResultHolder.sidedSuccess(itemstack,level.isClientSide());

	}
}
