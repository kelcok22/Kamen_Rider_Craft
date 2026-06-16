package com.kelco.kamenridercraft.item.reiwa.zero_one;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.ZeroOneRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class ShotriserItem extends RiderDriverItem {

	public ShotriserItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);

	}

	@Override
	public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
		if (equipmentSlot == EquipmentSlot.FEET) {
			if (itemstack.getItem()== ZeroOneRiderItems.SHOTRISER_VULCAN.get() || itemstack.getItem()== ZeroOneRiderItems.SHOTRISER_VALKYRIE.get()) {
				if(rider.isHolding(ZeroOneRiderItems.SHOTRISER.get()) ) return "belts/z_con_band_belt";
			} else if (itemstack.getItem()== ZeroOneRiderItems.ZAIA_SLASHRISER.get()) {
				if(rider.isHolding(ZeroOneRiderItems.SLASHRISER.get()) ) return "belts/s_con_band_belt";
			} else if (itemstack.getItem()== ZeroOneRiderItems.SHOT_ABADDO_RISER.get() || itemstack.getItem()== ZeroOneRiderItems.SHOT_ABADDO_RISER_B.get() || itemstack.getItem()== ZeroOneRiderItems.SHOT_ABADDO_RISER_G.get()) {
				if(rider.isHolding(ZeroOneRiderItems.SHOTABADDORISER_GUN.get()) ) return "belts/abaddo_riser_belt";
			} else if (itemstack.getItem()== ZeroOneRiderItems.SLASH_ABADDO_RISER.get() || itemstack.getItem()== ZeroOneRiderItems.SLASH_ABADDO_RISER_O.get() || itemstack.getItem()== ZeroOneRiderItems.SLASH_ABADDO_RISER_R.get()) {
				if(rider.isHolding(ZeroOneRiderItems.SLASHABADDORISER_SWORD.get()) ) return "belts/abaddo_riser_belt";
			}
		}
		return super.getText(itemstack, equipmentSlot, rider, riderName);

	}
}