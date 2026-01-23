package com.kelco.kamenridercraft.item.ooo;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.item.OOO_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.Objects;

public class BirthDriverItem extends RiderDriverItem {


	public BirthDriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);

		Extra_Base_Form_Item= Lists.newArrayList((RiderFormChangeItem) Modded_item_core.BLANK_FORM.get(),(RiderFormChangeItem)Modded_item_core.BLANK_FORM.get(),(RiderFormChangeItem)Modded_item_core.BLANK_FORM.get(),(RiderFormChangeItem)Modded_item_core.BLANK_FORM.get(),(RiderFormChangeItem)Modded_item_core.BLANK_FORM.get(),(RiderFormChangeItem)Modded_item_core.BLANK_FORM.get(),(RiderFormChangeItem)Modded_item_core.BLANK_FORM.get());
		Num_Base_Form_Item=7;
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		Has_basic_belt_info=false;
		tooltipComponents.add(Component.translatable("kamenridercraft.name."+Rider));

		if (get_Form_Item(stack, 2)== OOO_Rider_Items.BIRTH_CORE_BREAST_CANNON.get()&get_Form_Item(stack, 3)
				==OOO_Rider_Items.BIRTH_CORE_CRANE_ARM.get()&get_Form_Item(stack, 4)
				==OOO_Rider_Items.BIRTH_CORE_SHOVEL_ARM.get()&get_Form_Item(stack, 5)
				==OOO_Rider_Items.BIRTH_CORE_CATERPILLAR_LEG.get()&get_Form_Item(stack, 6)
				==OOO_Rider_Items.BIRTH_CORE_DRILL_ARM.get()&get_Form_Item(stack, 7)
				==OOO_Rider_Items.BIRTH_CORE_CUTTER_WING.get()) tooltipComponents.add(Component.translatable( "kamenridercraft:birthday.form"));

		else {
			tooltipComponents.add(Component.translatable( "kamenridercraft:claws.form"));

			if (get_Form_Item(stack, 2) == OOO_Rider_Items.BIRTH_CORE_BREAST_CANNON.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:birth_core_breast_cannon.form"));
			if (get_Form_Item(stack, 3) == OOO_Rider_Items.BIRTH_CORE_CRANE_ARM.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:birth_core_crane_arm.form"));
			if (get_Form_Item(stack, 4) == OOO_Rider_Items.BIRTH_CORE_SHOVEL_ARM.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:birth_core_shovel_arm.form"));
			if (get_Form_Item(stack, 5) == OOO_Rider_Items.BIRTH_CORE_CATERPILLAR_LEG.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:birth_core_catepillar_leg.form"));
			if (get_Form_Item(stack, 6) == OOO_Rider_Items.BIRTH_CORE_DRILL_ARM.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:birth_core_drill_arm.form"));
			if (get_Form_Item(stack, 7) == OOO_Rider_Items.BIRTH_CORE_CUTTER_WING.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:birth_core_cutter_wing.form"));
		}
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
	{
		if (equipmentSlot == EquipmentSlot.FEET) {


			String belt = ((RiderDriverItem)itemstack.getItem()).BELT_TEXT;
			if (((RiderDriverItem)itemstack.getItem()).BELT_TEXT==null) {
				belt = get_Form_Item(itemstack,1).getBeltTex();
			}
			return "belts/"+belt;

		}

		else if (equipmentSlot == EquipmentSlot.CHEST) return "birth_claws_1";
		else if (equipmentSlot == EquipmentSlot.LEGS) return "birth_claws_2";
		else return riderName+get_Form_Item(itemstack,1).getFormName(false);

	}

	public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {

		if (currentSlot== EquipmentSlot.FEET) {
			return get_Form_Item(itemstack, 1).get_Is_Belt_Glowing();
		}
		if (isTransformed(livingEntity) && currentSlot==EquipmentSlot.HEAD) return get_Form_Item(itemstack, 1).get_Is_Glowing();
		return false;
	}

	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		switch (slot) {
			case CHEST -> {
				return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/claws_1.geo.json");
			}
			case LEGS -> {
				if (get_Form_Item(itemstack, 3)==OOO_Rider_Items.BIRTH_CORE_CRANE_ARM.get())
					return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/claws_2_crane.geo.json");
				else return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/claws_2.geo.json");
			}
			default -> {
				return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, 1).get_Model(this.Rider));
			}
		}
	}

	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
			case HEAD ->{
				if (Objects.equals(part, "head")) return true;
				if (Objects.equals(part, "body")) return true;
				if (Objects.equals(part, "rightArm")) return true;
				if (Objects.equals(part, "leftArm")) return true;
				if (Objects.equals(part, "leftLeg")) return true;
				if (Objects.equals(part, "rightLeg")) return true;

			}
			case CHEST -> {
				if (Objects.equals(part, "body")) return get_Form_Item(itemstack, 2)== OOO_Rider_Items.BIRTH_CORE_BREAST_CANNON.get();
				if (Objects.equals(part, "rightArm")) return get_Form_Item(itemstack, 3)==OOO_Rider_Items.BIRTH_CORE_CRANE_ARM.get();
				if (Objects.equals(part, "leftArm")) return get_Form_Item(itemstack, 4)==OOO_Rider_Items.BIRTH_CORE_SHOVEL_ARM.get();
				if (Objects.equals(part, "leftLeg") || Objects.equals(part, "rightLeg")) return get_Form_Item(itemstack, 5)==OOO_Rider_Items.BIRTH_CORE_CATERPILLAR_LEG.get();

			}
			case LEGS -> {
				if (Objects.equals(part, "rightArm")) return get_Form_Item(itemstack, 6)==OOO_Rider_Items.BIRTH_CORE_DRILL_ARM.get();
				if (Objects.equals(part, "body")) return get_Form_Item(itemstack, 7)==OOO_Rider_Items.BIRTH_CORE_CUTTER_WING.get();
			}
			default -> {}
		}
		return false;
	}

}