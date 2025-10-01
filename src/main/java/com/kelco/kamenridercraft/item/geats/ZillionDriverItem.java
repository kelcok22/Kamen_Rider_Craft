package com.kelco.kamenridercraft.item.geats;

import java.util.List;

import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Geats_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;

public class ZillionDriverItem  extends RiderDriverItem {


	public ZillionDriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		
	}

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        Has_basic_belt_info=false;
        Item formItem = get_Form_Item(stack, 1);

        if(formItem==Geats_Rider_Items.SIRIUS_CARD.get()) tooltipComponents.add(Component.translatable("kamenridercraft.name.regad"));
        else tooltipComponents.add(Component.translatable("kamenridercraft.name.regad_omega"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

}