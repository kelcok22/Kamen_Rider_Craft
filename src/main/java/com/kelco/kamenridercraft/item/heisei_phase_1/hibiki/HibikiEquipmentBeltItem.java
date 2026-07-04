package com.kelco.kamenridercraft.item.heisei_phase_1.hibiki;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.HibikiRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class HibikiEquipmentBeltItem extends RiderDriverItem {

	public HibikiEquipmentBeltItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		unlimitedTextures = 2;
		unlimitedBeltTextures = 3;
	}

	@Override
	public String getUnlimitedTextures(ItemStack itemstack, LivingEntity livingEntity, String riderName , int num) {
		if (getFormItem(itemstack, 1) == HibikiRiderItems.HENSHIN_ONSA_ARMED.get()) {
            if ((livingEntity instanceof Player || livingEntity instanceof Mob) && livingEntity.getMainArm() == HumanoidArm.LEFT) {
                if (num == 1 && livingEntity.getMainHandItem().getItem() != HibikiRiderItems.ONGEKIBO_REKKA.get())
                    return "ongekibo_rekka_l";
                else if (num == 2 && livingEntity.getOffhandItem().getItem() != HibikiRiderItems.ONGEKIBO_REKKA.get())
                    return "ongekibo_rekka_r";
            } else {
                if (num == 1 && livingEntity.getOffhandItem().getItem() != HibikiRiderItems.ONGEKIBO_REKKA.get())
                    return "ongekibo_rekka_l";
                else if (num == 2 && livingEntity.getMainHandItem().getItem() != HibikiRiderItems.ONGEKIBO_REKKA.get())
                    return "ongekibo_rekka_r";
            }
        }
		return "blank";
	}

	@Override
	public String getUnlimitedBeltTextures(ItemStack itemstack, LivingEntity rider, String riderName ,int num) {
		if (num == 1 && !rider.isHolding(HibikiRiderItems.HENSHIN_ONSA.get())) return "henshin_onsa";
		else if (getFormItem(itemstack, 1) != HibikiRiderItems.HENSHIN_ONSA_ARMED.get()) {
			if ((rider instanceof Player || rider instanceof Mob) && rider.getMainArm() == HumanoidArm.LEFT) {
				if (num==2&&rider.getMainHandItem().getItem()!= HibikiRiderItems.ONGEKIBO_REKKA.get()) return "ongekibo_rekka_l";
				else if (num==3&&rider.getOffhandItem().getItem()!= HibikiRiderItems.ONGEKIBO_REKKA.get()) return "ongekibo_rekka_r";
			} else {
				if (num==2&&rider.getOffhandItem().getItem()!= HibikiRiderItems.ONGEKIBO_REKKA.get()) return "ongekibo_rekka_l";
				else if (num==3&&rider.getMainHandItem().getItem()!= HibikiRiderItems.ONGEKIBO_REKKA.get()) return "ongekibo_rekka_r";
			}
		} else if (num == 2 && !rider.isHolding(HibikiRiderItems.ARMED_SABER.get())) return "armed_saber";

		return "blank";
	}

    @Override
    public  boolean getPartsForSlot(ItemStack itemstack, EquipmentSlot currentSlot, String  part) {

        switch (currentSlot) {
            case HEAD,LEGS,CHEST ->{
                return true;

            }

            default -> {}
        }
        return false;
    }
}
