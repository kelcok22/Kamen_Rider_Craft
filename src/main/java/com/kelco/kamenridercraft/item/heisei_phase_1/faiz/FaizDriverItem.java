package com.kelco.kamenridercraft.item.heisei_phase_1.faiz;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.FaizRiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class FaizDriverItem extends RiderDriverItem {

	public FaizDriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		unlimitedBeltTextures = 3;
	}

    @Override
    public String getUnlimitedBeltTextures(ItemStack itemstack, LivingEntity rider, String riderName ,int num) {
		if((getFormItem(itemstack, 1)== FaizRiderItems.FAIZ_MISSION_MEMORY.get()
				|| getFormItem(itemstack, 1)== FaizRiderItems.FAIZ_AXEL_FORM.get()
				|| getFormItem(itemstack, 1)== FaizRiderItems.FAIZ_BLASTER_MISSION_MEMORY.get()
				|| getFormItem(itemstack, 1)== FaizRiderItems.FAIZ_BLASTER_BLOODY_CANNONS.get())) {
            if (num==1&&!rider.isHolding(FaizRiderItems.FAIZ_PHONE_POINTER.get())) return "faiz_pointer";
            else if (num==2&&!rider.isHolding(FaizRiderItems.FAIZ_SHOT.get())) return "faiz_shot";
			else if (num==3&& getFormItem(itemstack, 1)== FaizRiderItems.FAIZ_AXEL_FORM.get()&&isTransformed(rider)) return "faiz_axel";
        } else if(getFormItem(itemstack, 1)== FaizRiderItems.FAIZ_GOLD_BLASTER_MISSION_MEMORY.get()|| getFormItem(itemstack, 1)== FaizRiderItems.FAIZ_GOLD_BLASTER_BLOODY_CANNONS.get()) {
			if (num==1&&!rider.isHolding(FaizRiderItems.FAIZ_PHONE_POINTER.get())) return "faiz_pointer_g_b";
			else if (num==2&&!rider.isHolding(FaizRiderItems.FAIZ_SHOT.get())) return "faiz_shot_g_b";
		}
        return "blank";
    }

	@Override
	public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
        boolean fly = rider.getAttribute(Attributes.WINGS_OUT).getBaseValue()==1;

		if (equipmentSlot == EquipmentSlot.FEET && itemstack.getItem()== FaizRiderItems.FAIZ_DRIVER.get()) {
			if((getFormItem(itemstack, 1)== FaizRiderItems.FAIZ_MISSION_MEMORY.get()
			|| getFormItem(itemstack, 1)== FaizRiderItems.FAIZ_AXEL_FORM.get())
				&&((rider.isHolding(FaizRiderItems.FAIZ_PHONE.get())||(rider.isHolding(FaizRiderItems.FAIZ_PHONE_POINTER.get()))))) return "belts/faiz_driver_belt_b";
		}
		return super.getText(itemstack, equipmentSlot, rider, riderName);

	}

}
