package com.kelco.kamenridercraft.item.gotchard;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Gotchard_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
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
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
		String belt = ((RiderDriverItem)itemstack.getItem()).BELT_TEXT;

		boolean fly = rider instanceof Player player && player.getAbilities().flying;

		if (equipmentSlot == EquipmentSlot.FEET) {
			if (((RiderDriverItem)itemstack.getItem()).BELT_TEXT==null) {
				belt = get_Form_Item(itemstack,1).getBeltTex();
			}
			if(Objects.equals(get_Form_Item(itemstack, 1).get_Belt_Model(), "geo/gotchard_belt_big.geo.json")) {
				if (!isTransformed(rider)) belt = "gotchardriver_belt";
			}
			return "belts/"+belt;
		}
		else if (equipmentSlot == EquipmentSlot.CHEST) {
			if (get_Form_Item(itemstack,1)==Gotchard_Rider_Items.HAWKSTAR_RIDE_CHEMY_CARD.get() && !fly) return "gotchar_brothers_part_nh";
			if (get_Form_Item(itemstack,1)==Gotchard_Rider_Items.X_REX_RIDE_CHEMY_CARD.get()|get_Form_Item(itemstack,1)==Gotchard_Rider_Items.UFO_X_RIDE_CHEMY_CARD.get()) return "gotchar_brothers_part_s";
			if (get_Form_Item(itemstack,1)==Gotchard_Rider_Items.CROSSHOPPER_RIDE_CHEMY_CARD.get()) return "gotchar_brothers_part_p";
			return "gotchar_brothers_part";
		}
		else return "gotchar_brothers/gotchard"+get_Form_Item(itemstack,1).getFormName(fly);
	}

	public ResourceLocation getBeltModelResource(ItemStack itemstack,RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		if(Objects.equals(get_Form_Item(itemstack, 1).get_Belt_Model(), "geo/gotchard_belt_big.geo.json")) {
			if (!isTransformed(rider)) return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"geo/gotchard_belt.geo.json");
			else return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"geo/gotchard_belt_big.geo.json");
		}

		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/gotchard_belt.geo.json");
	}

	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        if (Objects.requireNonNull(slot) == EquipmentSlot.CHEST) {
            if (get_Form_Item(itemstack, 1) == Gotchard_Rider_Items.GOLDDASH_RIDE_CHEMY_CARD.get() || get_Form_Item(itemstack, 1) == Gotchard_Rider_Items.RAIDENJI_RIDE_CHEMY_CARD.get()) {
                return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/gotchar_brothers_big.geo.json");
            }
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/gotchar_brothers.geo.json");
        }
        if (get_Form_Item(itemstack, 1).HasWingsIfFlying() && rider instanceof Player player && player.getAbilities().flying) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + get_Form_Item(itemstack, 1).get_FlyingModel("gotchard"));
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + get_Form_Item(itemstack, 1).get_Model("gotchard"));
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