package com.kelco.kamenridercraft.item.heisei_phase_1.faiz;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.FaizRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class KaixaDriverItem extends RiderDriverItem {

	public KaixaDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		unlimitedBeltTextures = 2;
	}

    @Override
    public String getUnlimitedBeltTextures(ItemStack itemstack, LivingEntity rider, String riderName ,int num) {
		if (getFormItem(itemstack, 1)== FaizRiderItems.KAIXA_MISSION_MEMORY.get()) {
			if (num==1&&!rider.isHolding(FaizRiderItems.KAIXA_BLAYGUN.get())) return "kaixa_blaygun";
			else if (num==2&&!rider.isHolding(FaizRiderItems.KAIXA_SHOT.get())) return "faiz_shot";
		}
        return "blank";
    }

	@Override
	public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
		if (equipmentSlot == EquipmentSlot.FEET && itemstack.getItem()== FaizRiderItems.KAIXA_DRIVER.get()
			&&rider.isHolding(FaizRiderItems.KAIXA_PHONE.get())) return "belts/kaixa_driver_belt_empty";

		return super.getText(itemstack, equipmentSlot, rider, riderName);
	}

}