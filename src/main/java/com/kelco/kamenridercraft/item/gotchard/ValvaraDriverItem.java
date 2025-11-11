package com.kelco.kamenridercraft.item.gotchard;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Gotchard_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class ValvaraDriverItem extends RiderDriverItem {

	public ValvaraDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}

	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		if (get_Form_Item(itemstack,1) == Gotchard_Rider_Items.DAIOHNI_GT_RIDE_CHEMY_CARD.get())
		{
			if (!rider.getMainHandItem().isEmpty()|!rider.getOffhandItem().isEmpty()) return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/valvarad_rider_gt_off.geo.json");
			else return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, 1).get_Model(this.Rider));
		}
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, 1).get_Model(this.Rider));
	}

    public ResourceLocation getBeltModelResource(ItemStack itemstack,RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/gotchard_belt.geo.json");
    }
}