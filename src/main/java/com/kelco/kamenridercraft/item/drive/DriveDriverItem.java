package com.kelco.kamenridercraft.item.drive;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.W_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;

public class DriveDriverItem extends RiderDriverItem {


	public DriveDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}


	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		super.inventoryTick(stack,level,entity,slotId,isSelected);

	}

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
	{
		boolean fly = rider instanceof Player player && player.getAbilities().flying;
		if (equipmentSlot == EquipmentSlot.FEET) {

			return "belts/"+get_Form_Item(itemstack,1).getBeltTex();
		}
		else if (equipmentSlot == EquipmentSlot.HEAD) return "tire/"+get_Form_Item(itemstack,2).getFormName(fly);

		else {
			return riderName + get_Form_Item(itemstack, 1).getFormName(fly);
		}
	}


	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {

		if (slot!= EquipmentSlot.HEAD) {
			if (get_Form_Item(itemstack, 1).HasWingsIfFlying() && rider instanceof Player player && player.getAbilities().flying){
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, 2).get_FlyingModel());
		}else return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, 2).get_Model());

		}else
			return super.getModelResource(itemstack, animatable, slot,rider);
	}

	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
			case HEAD, LEGS ->{
			 return true;

			}
			case CHEST -> {

			}
            default -> {}
		}
		return false;
	}


	public void Extra_set_Form_Item(ItemStack itemstack, Item ITEM, int SLOT, CompoundTag tag)
	{
		if (get_Form_Item(itemstack, 1)==W_Rider_Items.XTREME_MEMORY.get()||get_Form_Item(itemstack, 1)==W_Rider_Items.XTREME_GOLD_MEMORY.get()||get_Form_Item(itemstack, 1)==W_Rider_Items.XTREME_ACCEL_MEMORY.get()) {
			tag.putString("slot_tex"+1, (W_Rider_Items.CYCLONE_MEMORY.get()).toString());
			tag.putInt("slot"+1, Item.getId(W_Rider_Items.CYCLONE_MEMORY.get()));
		}
	}

}