package com.kelco.kamenridercraft.item.revice;

import java.util.List;

import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Revice_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;

public class CyclotronDriverItem  extends RiderDriverItem {


	public CyclotronDriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		
	}

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        Has_basic_belt_info=false;
        Item formItem = get_Form_Item(stack, 1);

        if(formItem==Revice_Rider_Items.CYCLOTRON_DRIVER_CORE.get()) tooltipComponents.add(Component.translatable("kamenridercraft.name.century"));
        else tooltipComponents.add(Component.translatable("kamenridercraft.name.century_break"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

}