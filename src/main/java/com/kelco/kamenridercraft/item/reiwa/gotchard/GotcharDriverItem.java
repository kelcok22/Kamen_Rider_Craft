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

public class GotcharDriverItem extends RiderDriverItem {

	public GotcharDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}

	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		if (getFormItem(itemstack,1) == GotchardRiderItems.TENLINER_RIDE_CHEMY_CARD.get())
		{
			if (!rider.getMainHandItem().isEmpty()|!rider.getOffhandItem().isEmpty()) return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/gotchard_iron_off.geo.json");
			else return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+ getFormItem(itemstack, 1).getModel(this.Rider));
		}
		if (getFormItem(itemstack, 1).hasWingsIfFlying() && rider.getAttribute(Attributes.WINGS_OUT).getBaseValue()==1){
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+ getFormItem(itemstack, 1).getFlyingModel(this.Rider));
		}
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+ getFormItem(itemstack, 1).getModel(this.Rider));
	}

	public ResourceLocation getBeltModelResource(ItemStack itemstack,RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        if (Objects.equals(getFormItem(itemstack, 1).getBeltModel(), "geo/gotchard_belt_big.geo.json")) {
            if (!isTransformed(rider)) return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/gotchard_belt.geo.json");
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/gotchard_belt_big.geo.json");
        }

        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/gotchard_belt.geo.json");
	}
}