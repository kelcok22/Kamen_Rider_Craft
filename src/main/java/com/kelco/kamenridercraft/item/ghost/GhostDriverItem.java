package com.kelco.kamenridercraft.item.ghost;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.Drive_Rider_Items;
import com.kelco.kamenridercraft.item.Ghost_Rider_Items;
import com.kelco.kamenridercraft.item.W_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

public class GhostDriverItem extends RiderDriverItem {

	private int Wisp_Horn =1;

	public GhostDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}

	public GhostDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem,int wisp_horn, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		Wisp_Horn=wisp_horn;
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
			this.Has_basic_belt_info = false;
			Item formItem = this.get_Form_Item(stack, 1);
			Item formItem2 = this.get_Form_Item(stack, 2);
			String rider=Rider;
if (stack.getItem()==Ghost_Rider_Items.NEW_GHOST_DRIVER.get())rider="new_ghost";
		tooltipComponents.add(Component.translatable("kamenridercraft.name." + rider));
		if (Rider=="ghost"||Rider=="specter"||Rider=="necrom") {
			tooltipComponents.add(Component.translatable(formItem.toString() + ".form"));
		}

		 tooltipComponents.add(Component.translatable(formItem2.toString() + ".form"));

		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}
	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		super.inventoryTick(stack,level,entity,slotId,isSelected);

	}

	@Override
	public void Extra_set_Form_Item(ItemStack belt, Item ITEM,int SLOT,CompoundTag  tag)
	{
		if (get_Form_Item(belt, 1)==Ghost_Rider_Items.FOURTYFIVE_HEISEI_GHOST_EYECON.get()&get_Form_Item(belt, 2)!=Ghost_Rider_Items.FOURTYFIVE_HEISEI_DAMASHII.get()
		||get_Form_Item(belt, 1)==Ghost_Rider_Items.MUGEN_GHOST_EYECON.get()&get_Form_Item(belt, 2)!=Ghost_Rider_Items.MUGEN_DAMASHII.get()
				||get_Form_Item(belt, 1)==Ghost_Rider_Items.SIN_SPECTER_GHOST_EYECON.get()&get_Form_Item(belt, 2)!=Ghost_Rider_Items.SIN_SPECTER_DAMASHII.get()
		) {

				tag.putString("slot_tex" + 1, (this.Base_Form_Item).toString());
				tag.putInt("slot" + 1, Item.getId(this.Base_Form_Item));
				CustomData.set(DataComponents.CUSTOM_DATA, belt, tag);

		}
	}

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
	{
		boolean fly = rider instanceof Player player && player.getAbilities().flying;
		if (equipmentSlot == EquipmentSlot.FEET) {

			return "belts/"+get_Form_Item(itemstack,1).getBeltTex();
		}
		else if (equipmentSlot == EquipmentSlot.HEAD) return get_Form_Item(itemstack,2).getFormName(fly);

		else {
			return riderName + get_Form_Item(itemstack, 1).getFormName(fly)+Get_Wisp_Horn(get_Form_Item(itemstack, 2),itemstack);
		}
	}


	public String Get_Wisp_Horn(RiderFormChangeItem item,ItemStack itemstack)
	{
		String rider = ((GhostDriverItem) itemstack.getItem()).Rider;

		if (Wisp_Horn==item.get_Stored_num()){
			return "_base";
		}else if (rider=="ghost"&get_Form_Item(itemstack,1)==Ghost_Rider_Items.ORE_GHOST_EYECON.get()&item.get_Stored_num()==2||
				rider=="ghost"&get_Form_Item(itemstack,1)==Ghost_Rider_Items.MUGEN_GHOST_EYECON.get()
		||rider=="specter"&get_Form_Item(itemstack,1)==Ghost_Rider_Items.SIN_SPECTER_GHOST_EYECON.get()
				||rider=="necrom"&get_Form_Item(itemstack,1)==Ghost_Rider_Items.YUJOU_BURST_GHOST_EYECON.get()
		||rider=="specter"&item.get_Stored_num()!=0||rider=="zero_specter"&item.get_Stored_num()!=0
				||rider=="kanon_specter"&item.get_Stored_num()!=0){
			return "_base";
		}

		return "_base_"+item.get_Stored_num();
	}

	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {

		if (slot== EquipmentSlot.HEAD) {
			if (get_Form_Item(itemstack, 2).HasWingsIfFlying() && rider instanceof Player player && player.getAbilities().flying){
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, 2).get_FlyingModel());
		}else return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, 2).get_Model());

		}else
			return super.getModelResource(itemstack, animatable, slot,rider);
	}

	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
			case HEAD, LEGS ->{
			 return true;

			}
			case CHEST -> {

			}
            default -> {}
		}
		return false;
	}
}