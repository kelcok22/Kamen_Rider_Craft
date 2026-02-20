package com.kelco.kamenridercraft.item.faiz;

import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Faiz_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class DeltaDriverItem extends RiderDriverItem {

	public DeltaDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		Unlimited_Belt_Textures = 1;
	}

    @Override
    public String getUnlimitedTextures(ItemStack itemstack, LivingEntity rider, String riderName ,int num) {
		if (num==1&&!rider.isHolding(Faiz_Rider_Items.DELTA_BLASTER.get())) return isTransformed(rider)?"delta_blaster":"delta_mover";
        return "blank";
    }

}