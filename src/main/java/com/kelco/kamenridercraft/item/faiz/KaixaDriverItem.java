package com.kelco.kamenridercraft.item.faiz;

import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Faiz_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class KaixaDriverItem extends RiderDriverItem {

	public KaixaDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		Unlimited_Belt_Textures = 2;
	}

    @Override
    public String getUnlimitedTextures(ItemStack itemstack, LivingEntity rider, String riderName ,int num) {
		if (get_Form_Item(itemstack, 1)==Faiz_Rider_Items.KAIXA_MISSION_MEMORY.get()) {
			if (num==1&&!rider.isHolding(Faiz_Rider_Items.KAIXA_BLAYGUN.get())) return "kaixa_blaygun";
			else if (num==2&&!rider.isHolding(Faiz_Rider_Items.KAIXA_SHOT.get())) return "faiz_shot";
		}
        return "blank";
    }

}