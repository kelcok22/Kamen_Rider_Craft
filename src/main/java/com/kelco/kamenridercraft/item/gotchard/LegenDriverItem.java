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

import java.util.Objects;

public class LegenDriverItem extends RiderDriverItem {

	public LegenDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
		String belt = ((RiderDriverItem)itemstack.getItem()).BELT_TEXT;

		boolean fly = !rider.onGround();

		if (equipmentSlot == EquipmentSlot.FEET) {
			if (((RiderDriverItem)itemstack.getItem()).BELT_TEXT==null) {
				belt = get_Form_Item(itemstack,1).getBeltTex();
			}
			return "belts/"+belt;
		}
		else if (equipmentSlot == EquipmentSlot.CHEST) {
			if (get_Form_Item(itemstack,1)==Gotchard_Rider_Items.LEGEND_RIDE_CHEMY_CARD.get()) return "blank";
			else if (get_Form_Item(itemstack,1)==Gotchard_Rider_Items.LEGENDARY_LEGEND_RIDE_CHEMY_CARD.get()||get_Form_Item(itemstack,1)==Gotchard_Rider_Items.RYUKI_SURVIVE_RIDE_CHEMY_CARD.get()) return "blank";
			else if (Objects.equals(get_Form_Item(itemstack, 1).getBeltTex(), "legendriver_belt_l")) return "legend_ride_final";
			else return "legend_ride";
		}

		else return get_Form_Item(itemstack,1).getRiderName(riderName)+get_Form_Item(itemstack,1).getFormName(fly);
	}

	public ResourceLocation getBeltModelResource(ItemStack itemstack,RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/legend_belt.geo.json");
	}

	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        if (Objects.requireNonNull(slot) == EquipmentSlot.CHEST) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/legend_ride.geo.json");
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + get_Form_Item(itemstack, 1).get_Model(this.Rider));
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
