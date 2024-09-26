package com.kelco.kamenridercraft.item.zero_one;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;

public class ThousandriverItem extends RiderDriverItem {


	public ThousandriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		
	}

	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		super.inventoryTick(stack, level, entity,slotId, isSelected);

		if (entity instanceof Player player && !level.isClientSide) {
			if (isTransformed(player) && player.getItemBySlot(EquipmentSlot.FEET).getItem() == this
			&& player.hasEffect(Effect_core.BUGSTER)
        	&& player.getInventory().countItem(Zero_One_Rider_Items.ARK_ONE_PROGRISEKEY.get())!=0
        	&& player.getInventory().countItem(Zero_One_Rider_Items.HUMAGEAR_PROGRISEKEY.get())!=0) {
        	    player.getInventory().clearOrCountMatchingItems(ItemStack -> ItemStack.getItem() == Zero_One_Rider_Items.HUMAGEAR_PROGRISEKEY.get(), 1, player.getInventory());
				ItemEntity key = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), new ItemStack(Zero_One_Rider_Items.PRESIDENT_DAN_KUROTO_PROGRISEKEY.get(), 1), 0, 0, 0);
				key.setPickUpDelay(0);
				level.addFreshEntity(key);
        	    player.sendSystemMessage(Component.translatable("President Dan Kuroto!").withStyle(ChatFormatting.LIGHT_PURPLE));
        	    player.removeEffect(Effect_core.BUGSTER);
			}
		}
	}

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
	{
		boolean fly = rider instanceof Player player && player.getAbilities().flying;
		if (equipmentSlot == EquipmentSlot.FEET) {
			
			
				String belt = ((RiderDriverItem)itemstack.getItem()).BELT_TEXT;
				if (((RiderDriverItem)itemstack.getItem()).BELT_TEXT==null) {
					belt = get_Form_Item(itemstack,1).getBeltTex();
				}
				return "belts/"+belt;
			
		}
	
		else if (rider.hasEffect(Effect_core.BUGSTER))return "zaia";
		else return riderName+ get_Form_Item(itemstack,1).getFormName(fly);

	}

}