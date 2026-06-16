package com.kelco.kamenridercraft.item.reiwa.revice;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.ReviceRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

public class CyclotronDriverItem  extends RiderDriverItem {


	public CyclotronDriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		
	}

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        Has_basic_belt_info=false;
        Item formItem = getFormItem(stack, 1);

        if(formItem== ReviceRiderItems.CYCLOTRON_DRIVER_CORE.get()) tooltipComponents.add(Component.translatable("kamenridercraft.name.century"));
        else tooltipComponents.add(Component.translatable("kamenridercraft.name.century_break"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

}