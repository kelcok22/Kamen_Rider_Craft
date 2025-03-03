package com.kelco.kamenridercraft.item.drive;

import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Drive_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Objects;
import java.util.jar.Attributes;

public class DriveDriverItem extends RiderDriverItem {


	public DriveDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		Unlimited_Textures=1;
	}


	@Override
	public String getUnlimitedTextures(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName, int num)
	{
		boolean fly = rider instanceof Player player && player.getAbilities().flying;

		if (riderName=="mach"&get_Form_Item(itemstack,2)== Drive_Rider_Items.BASIC_TIRE.get()&&get_Form_Item(itemstack,1)== Drive_Rider_Items.SHIFT_DEAD_HEAT_MACH.get()
		||riderName=="drive"&get_Form_Item(itemstack,2)== Drive_Rider_Items.BASIC_TIRE.get()&&get_Form_Item(itemstack,1)== Drive_Rider_Items.SHIFT_DEAD_HEAT.get()){
			if(rider.getHealth()<7) {
				return "tire/dead_heat_burst_tire";
			}
		}else if (riderName=="mach"&get_Form_Item(itemstack,2)== Drive_Rider_Items.SHIFT_MAX_FLARE.get()&&get_Form_Item(itemstack,1)!= Drive_Rider_Items.SHIFT_DEAD_HEAT_MACH.get()){
			return "tire/kourin_moerl_tire";
		}else if (riderName=="mach"&get_Form_Item(itemstack,2)== Drive_Rider_Items.SHIFT_RUMBLE_DUMP.get()&&get_Form_Item(itemstack,1)!= Drive_Rider_Items.SHIFT_DEAD_HEAT_MACH.get()){
			return "tire/kourin_arabull_tire";
		}else if (riderName=="mach"&get_Form_Item(itemstack,2)== Drive_Rider_Items.SHIFT_SPIN_MIXER.get()&&get_Form_Item(itemstack,1)!= Drive_Rider_Items.SHIFT_DEAD_HEAT_MACH.get()){
			return "tire/kourin_mazerl_tire";
		}
		return "tire/"+get_Form_Item(itemstack,2).getFormName(fly);
	}

	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {
        return Objects.requireNonNull(currentSlot) == EquipmentSlot.HEAD;
    }


}