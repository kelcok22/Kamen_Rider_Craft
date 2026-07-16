package com.kelco.kamenridercraft.item.reiwa.gotchard;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.GotchardRiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Objects;

public class GotcharDriverBrothersItem extends RiderDriverItem {

	public GotcharDriverBrothersItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}

	@Override
	public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
		String belt = ((RiderDriverItem)itemstack.getItem()).beltText;

        boolean fly = rider.getAttribute(Attributes.WINGS_OUT).getBaseValue()==1;

		if (equipmentSlot == EquipmentSlot.FEET) {
			if (((RiderDriverItem)itemstack.getItem()).beltText ==null) {
				belt = getFormItem(itemstack,1).getBeltTex();
			}
			if(Objects.equals(getFormItem(itemstack, 1).getBeltModel(), "geo/gotchard_belt_big.geo.json")) {
				if (!isTransformed(rider)) belt = "gotchardriver_belt";
			}
			return "belts/"+belt;
		}
		else if (equipmentSlot == EquipmentSlot.CHEST) {
			if (getFormItem(itemstack,1)== GotchardRiderItems.HAWKSTAR_RIDE_CHEMY_CARD.get() && !fly) return "gotchar_brothers_part_nh";
			if (getFormItem(itemstack,1)== GotchardRiderItems.X_REX_RIDE_CHEMY_CARD.get()| getFormItem(itemstack,1)== GotchardRiderItems.UFO_X_RIDE_CHEMY_CARD.get()) return "gotchar_brothers_part_s";
			if (getFormItem(itemstack,1)== GotchardRiderItems.CROSSHOPPER_RIDE_CHEMY_CARD.get()) return "gotchar_brothers_part_p";
			return "gotchar_brothers_part";
		}
		else return "gotchar_brothers/gotchard"+ getFormItem(itemstack,1).getFormName(fly);
	}

	public ResourceLocation getBeltModelResource(ItemStack itemstack,RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		if(Objects.equals(getFormItem(itemstack, 1).getBeltModel(), "geo/belts/gotchard_belt_big.geo.json")) {
			if (!isTransformed(rider)) return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"geo/belts/gotchard_belt.geo.json");
			else return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"geo/belts/gotchard_belt_big.geo.json");
		}

		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/belts/gotchard_belt.geo.json");
	}

	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        if (Objects.requireNonNull(slot) == EquipmentSlot.CHEST) {
            if (Objects.equals(getFormItem(itemstack,1).getBeltModel(), "geo/gotchard_belt_big.geo.json")) {
                return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/gotchar_brothers_big.geo.json");
            }
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/gotchar_brothers.geo.json");
        }
        if (getFormItem(itemstack, 1).hasWingsIfFlying() && rider.getAttribute(Attributes.WINGS_OUT).getBaseValue()==1) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/armor/" + getFormItem(itemstack, 1).getFlyingModel("gotchard"));
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/armor/" + getFormItem(itemstack, 1).getModel("gotchard"));
    }


	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
			case HEAD,LEGS,CHEST ->{
				return true;

			}

			default -> {}
		}
		return false;
	}
}