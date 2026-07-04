package com.kelco.kamenridercraft.item.reiwa.revice;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.reiwa.ReviceRiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class DemonsDriverItem extends RiderDriverItem {


	public DemonsDriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);

		extraBaseFormItem = Lists.newArrayList((RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get(),(RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get(),(RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get(),(RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get());
		numBaseFormItems =5;
	}
	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		hasBasicBeltInfo =false;
		tooltipComponents.add(Component.translatable("kamenridercraft.name."+ riderName));

		if (getFormItem(stack, 2)== ReviceRiderItems.ANOMALOCARIS_VISTAMP.get()& getFormItem(stack, 5)
				== ReviceRiderItems.BATTA_VISTAMP.get()& getFormItem(stack, 4)
				== ReviceRiderItems.SCORPION_VISTAMP.get()) tooltipComponents.add(Component.translatable( "kamenridercraft:full_genomix.form"));

		else if (getFormItem(stack, 1)== ReviceRiderItems.GIANT_SPIDER_VISTAMP.get()) tooltipComponents.add(Component.translatable( "kamenridercraft:giant_genomix.form"));

		else {
			tooltipComponents.add(Component.translatable( "kamenridercraft:genomix.form"));

			if (getFormItem(stack, 2) == ReviceRiderItems.ANOMALOCARIS_VISTAMP.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:anomalocaris_vistamp.form"));
			if (getFormItem(stack, 2) == ReviceRiderItems.KOMODO_DRAGON_VISTAMP.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:komodo_dragon_vistamp.form"));
			if (getFormItem(stack, 2) == ReviceRiderItems.KOMODO_DRAGON_VISTAMP_DEMONS.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:komodo_dragon_vistamp.form"));
			if (getFormItem(stack, 2) == ReviceRiderItems.MOGURA_VISTAMP.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:mogura_vistamp.form"));
			if (getFormItem(stack, 3) == ReviceRiderItems.BATTA_VISTAMP.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:batta_vistamp.form"));
			if (getFormItem(stack, 3) == ReviceRiderItems.CONDOR_VISTAMP_DEMONS.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:condor_vistamp_demons.form"));
			if (getFormItem(stack, 3) == ReviceRiderItems.CROCODILE_VISTAMP.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:crocodile_vistamp.form"));
			if (getFormItem(stack, 3) == ReviceRiderItems.CROCODILE_VISTAMP_DEMONS.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:crocodile_vistamp_demons.form"));
			if (getFormItem(stack, 4) == ReviceRiderItems.SCORPION_VISTAMP.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:scorpion_vistamp.form"));
			if (getFormItem(stack, 5) == ReviceRiderItems.BATTA_VISTAMP.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:batta_vistamp.form"));
		}
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}
	@Override
	public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
        boolean fly = rider.getAttribute(Attributes.WINGS_OUT).getBaseValue()==1;
		switch (equipmentSlot) {
			case EquipmentSlot.FEET:
				String belt = ((RiderDriverItem)itemstack.getItem()).beltText;
				if (((RiderDriverItem)itemstack.getItem()).beltText ==null) {
					belt = getFormItem(itemstack,1).getBeltTex();
				}
				return "belts/"+belt;
			case EquipmentSlot.CHEST:
				return getFormItem(itemstack,1).getFormName(fly)+"_genomix_1";
			case EquipmentSlot.LEGS:
				return "_genomix_2";
			default:
				return riderName+ getFormItem(itemstack,1).getFormName(fly);
		}

	}
	public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {

		if (currentSlot== EquipmentSlot.FEET) {
			return getFormItem(itemstack, 1).getIsBeltGlowing();
		}
		if (isTransformed(livingEntity)){
			switch (currentSlot) {
				case LEGS, CHEST ->{
					return false;
				}
				case  HEAD-> {
					return true;
				}
				default -> {}
			}
			return false;
		}
		return false;
	}

	public ResourceLocation getModelResource(ItemStack itemstack,RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		int num = 1;
		if (slot == EquipmentSlot.CHEST||slot == EquipmentSlot.LEGS) return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"geo/default_wings_armor.geo.json");

		if (getFormItem(itemstack, num).hasWingsIfFlying() && rider.getAttribute(Attributes.WINGS_OUT).getBaseValue()==1){
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+ getFormItem(itemstack, num).getFlyingModel(this.riderName));
		}
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+ getFormItem(itemstack, num).getModel(this.riderName));

	}

	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
			case HEAD ->{
				if (Objects.equals(part, "head")) return true;
				if (Objects.equals(part, "body")) return true;
				if (Objects.equals(part, "rightArm")) return true;
				if (Objects.equals(part, "leftArm")) return true;
				if (Objects.equals(part, "rightLeg")) return true;
				if (Objects.equals(part, "leftLeg")) return true;
			}
			case CHEST -> {
				if (Objects.equals(part, "body")) return getFormItem(itemstack, 4)== ReviceRiderItems.SCORPION_VISTAMP.get();

				if (getFormItem(itemstack, 1)== ReviceRiderItems.GIANT_SPIDER_VISTAMP.get()){
					if (Objects.equals(part, "rightArm")) return getFormItem(itemstack, 2) == ReviceRiderItems.KOMODO_DRAGON_VISTAMP_DEMONS.get();
					if (Objects.equals(part, "leftArm")) return getFormItem(itemstack, 3) == ReviceRiderItems.CROCODILE_VISTAMP_DEMONS.get();

				}else {
					if (Objects.equals(part, "rightArm")) return getFormItem(itemstack, 2) == ReviceRiderItems.ANOMALOCARIS_VISTAMP.get();
					if (Objects.equals(part, "leftArm")) return getFormItem(itemstack, 2) == ReviceRiderItems.ANOMALOCARIS_VISTAMP.get();
				}
				if (Objects.equals(part, "rightLeg")) return getFormItem(itemstack, 5)== ReviceRiderItems.BATTA_VISTAMP.get();
				if (Objects.equals(part, "leftLeg")) return getFormItem(itemstack, 5)== ReviceRiderItems.BATTA_VISTAMP.get();
			}
			case LEGS -> {
				if (Objects.equals(part, "body")) return getFormItem(itemstack, 3)== ReviceRiderItems.CONDOR_VISTAMP_DEMONS.get();

				if (Objects.equals(part, "rightArm")) return getFormItem(itemstack, 2)== ReviceRiderItems.MOGURA_VISTAMP.get();


			}
			default -> {}
		}
		return false;
	}

	@Override
	public void setExtraFormItem(ItemStack belt, Item ITEM, int SLOT, CompoundTag  tag)
	{
		if (((RiderFormChangeItem) ITEM).getSlot()==1& ModdedItemCore.BLANK_FORM.get()!=ITEM) {
			Consumer<CompoundTag> data = form -> {
				for (int n = 2; n < 6; n++) form.putString("slot_tex" + n, (ModdedItemCore.BLANK_FORM.get()).toString());
			};

			CustomData.update(DataComponents.CUSTOM_DATA, belt, data);
		}
	}
}