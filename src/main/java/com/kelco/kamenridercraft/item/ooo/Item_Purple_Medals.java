package com.kelco.kamenridercraft.item.ooo;

import java.util.Random;

import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.OOO_Rider_Items;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Item_Purple_Medals extends BaseItem
{



	public Item_Purple_Medals(Properties properties)
	{
		super(properties);

	}


	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int i, boolean flag) {
				Random generator = new Random();
				int rand1 = generator.nextInt(3);
				int rand = generator.nextInt(3);
				int rand2 = generator.nextInt(4);
				if (entity instanceof Player ) {
					Player playerIn = ((Player)entity);
					if(world.isClientSide) {
					playerIn.sendSystemMessage(Component.translatable("loot.kamenridercraft.purple_medals"));
					}
					playerIn.drop(new ItemStack(OOO_Rider_Items.PURPLE_MEDALS_EMPTY.get(), 1), false);
					playerIn.drop(new ItemStack(OOO_Rider_Items.PTERA_MEDAL.get(), rand2), false);
					playerIn.drop(new ItemStack(OOO_Rider_Items.TRICERA_MEDAL.get(), rand), false);
					playerIn.drop(new ItemStack(OOO_Rider_Items.TYRANNO_MEDAL.get(), rand1), false);
					itemstack.shrink(1);	
		}
	}
}
