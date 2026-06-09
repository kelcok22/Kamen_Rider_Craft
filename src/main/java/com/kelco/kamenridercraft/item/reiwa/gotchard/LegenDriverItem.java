package com.kelco.kamenridercraft.item.reiwa.gotchard;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.Hibiki_Rider_Items;
import com.kelco.kamenridercraft.item.reiwa.Gotchard_Rider_Items;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Objects;

public class LegenDriverItem extends RiderDriverItem {

	public LegenDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
		super(material, rider, baseFormItem, head, torso, legs, properties);
		Unlimited_Textures = 2;
	}

	@Override
	public String getUnlimitedTextures(ItemStack itemstack, LivingEntity rider, String riderName ,int num) {
		if (get_Form_Item(itemstack, 1) == Gotchard_Rider_Items.ARMED_HIBIKI_RIDE_CHEMY_CARD.get()) {
			if ((rider instanceof Player || rider instanceof Mob) && rider.getMainArm() == HumanoidArm.LEFT) {
				if (num == 1 && rider.getMainHandItem().getItem() != Hibiki_Rider_Items.ONGEKIBO_REKKA.get())
					return "ongekibo_rekka_l";
				else if (num == 2 && rider.getOffhandItem().getItem() != Hibiki_Rider_Items.ONGEKIBO_REKKA.get())
					return "ongekibo_rekka_r";
			} else {
				if (num == 1 && rider.getOffhandItem().getItem() != Hibiki_Rider_Items.ONGEKIBO_REKKA.get())
					return "ongekibo_rekka_l";
				else if (num == 2 && rider.getMainHandItem().getItem() != Hibiki_Rider_Items.ONGEKIBO_REKKA.get())
					return "ongekibo_rekka_r";
			}
		}
		return "blank";
	}

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
		String belt = ((RiderDriverItem)itemstack.getItem()).BELT_TEXT;

        boolean fly = rider.getAttribute(Attributes.WINGS_OUT).getBaseValue()==1;

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
