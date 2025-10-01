package com.kelco.kamenridercraft.item.zero_one;

import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
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
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
	{
		if (equipmentSlot == EquipmentSlot.FEET) {
			if (itemstack.getItem()==Zero_One_Rider_Items.SHOTRISER_VULCAN.get() || itemstack.getItem()== Zero_One_Rider_Items.SHOTRISER_VALKYRIE.get()) {
				if(rider.isHolding(Zero_One_Rider_Items.SHOTRISER.get()) ) return "belts/z_con_band_belt";
			} else if (itemstack.getItem()==Zero_One_Rider_Items.ZAIA_SLASHRISER.get()) {
				if(rider.isHolding(Zero_One_Rider_Items.SLASHRISER.get()) ) return "belts/s_con_band_belt";
			} else if (itemstack.getItem()==Zero_One_Rider_Items.SHOT_ABADDO_RISER.get() || itemstack.getItem()==Zero_One_Rider_Items.SHOT_ABADDO_RISER_B.get() || itemstack.getItem()==Zero_One_Rider_Items.SHOT_ABADDO_RISER_G.get()) {
				if(rider.isHolding(Zero_One_Rider_Items.SHOTABADDORISER_GUN.get()) ) return "belts/abaddo_riser_belt";
			} else if (itemstack.getItem()==Zero_One_Rider_Items.SLASH_ABADDO_RISER.get() || itemstack.getItem()==Zero_One_Rider_Items.SLASH_ABADDO_RISER_O.get() || itemstack.getItem()==Zero_One_Rider_Items.SLASH_ABADDO_RISER_R.get()) {
				if(rider.isHolding(Zero_One_Rider_Items.SLASHABADDORISER_SWORD.get()) ) return "belts/abaddo_riser_belt";
			}
		}
		return super.GET_TEXT(itemstack, equipmentSlot, rider, riderName);

	}
}