package com.kelco.kamenridercraft.item.reiwa.geats;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.GeatsRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

public class ZillionDriverItem  extends RiderDriverItem {


	public ZillionDriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		
	}

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        hasBasicBeltInfo =false;
        Item formItem = getFormItem(stack, 1);

        if(formItem== GeatsRiderItems.SIRIUS_CARD.get()) tooltipComponents.add(Component.translatable("kamenridercraft.name.regad"));
        else tooltipComponents.add(Component.translatable("kamenridercraft.name.regad_omega"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

}