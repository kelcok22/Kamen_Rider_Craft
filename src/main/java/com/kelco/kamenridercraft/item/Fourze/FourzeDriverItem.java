package com.kelco.kamenridercraft.item.Fourze;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Fourze_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.item.W_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;

	public class FourzeDriverItem extends RiderDriverItem {



		public FourzeDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
		{
			super(material, rider, baseFormItem, head, torso, legs, properties);
			Unlimited_Textures=4;
		}

		@Override
		public String getUnlimitedTextures(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName, int num)
		{
			boolean fly = rider instanceof Player player && player.getAbilities().flying;
			if (num == 1){
				if (get_Form_Item(itemstack,1)!= Fourze_Rider_Items.BLANK_CIRCLE_ASTROSWITCH.get()){
					return riderName + get_Form_Item(itemstack, 1).getFormName(fly);
				}else return"blank";
			}if (num == 2){
				if (get_Form_Item(itemstack,2)!= Fourze_Rider_Items.BLANK_CROSS_ASTROSWITCH.get()){
					return riderName + get_Form_Item(itemstack, 2).getFormName(fly);
				}else return"blank";
			}else 	if (num == 3){
				if (get_Form_Item(itemstack,3)!= Fourze_Rider_Items.BLANK_TRIANGLE_ASTROSWITCH.get()){
					return riderName + get_Form_Item(itemstack, 3).getFormName(fly);
				}else return"blank";
			} else 	if (num == 4){
				if (get_Form_Item(itemstack,4)!= Fourze_Rider_Items.BLANK_SPUARE_ASTROSWITCH.get()){
					return riderName + get_Form_Item(itemstack, 4).getFormName(fly);
				}else return"blank";
			}
			return  "blank";
		}

		@Override
		public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
			super.inventoryTick(stack,level,entity,slotId,isSelected);

		}

		@Override
		public void Extra_set_Form_Item(ItemStack belt, Item ITEM,int SLOT,CompoundTag  tag)
		{
			if (get_Form_Item(belt, 5)==Fourze_Rider_Items.FOURZE_ELEK_STATES.get()) {
				if (get_Form_Item(belt, 1)!=Fourze_Rider_Items.ELEK_ASTROSWITCH.get()) {
					tag.putString("slot_tex" + 5, (Fourze_Rider_Items.FOURZE_BASE_STATES.get()).toString());
					tag.putInt("slot" + 5, Item.getId(Fourze_Rider_Items.FOURZE_BASE_STATES.get()));
					CustomData.set(DataComponents.CUSTOM_DATA, belt, tag);
				}
			}
		}

		@Override
		public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
		{
			boolean fly = rider instanceof Player player && player.getAbilities().flying;
			if (equipmentSlot == EquipmentSlot.FEET) {
				return "belts/"+get_Form_Item(itemstack,5).getBeltTex();
			}
			if (equipmentSlot != EquipmentSlot.HEAD) return"blank";

			else return riderName + get_Form_Item(itemstack,5).getFormName(fly);
		}




		public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {

			return super.getModelResource(itemstack, animatable, slot,rider);
		}

		@Override
		public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

			switch (currentSlot) {
				case HEAD ->{
					return true;

				}
				case CHEST -> {
					if (part =="rightLeg") return true;
					if (part =="leftLeg") return true;
					if (part =="rightArm") return true;
					if (part =="leftArm") return true;
				}

				default -> {}
			}
			return false;
		}
	}