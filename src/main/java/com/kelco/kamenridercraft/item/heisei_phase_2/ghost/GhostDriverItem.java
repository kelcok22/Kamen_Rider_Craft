package com.kelco.kamenridercraft.item.heisei_phase_2.ghost;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.GhostRiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class GhostDriverItem extends RiderDriverItem {

	private int Wisp_Horn =1;

	public GhostDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem,int wisp_horn, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		Wisp_Horn=wisp_horn;
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		this.Has_basic_belt_info = false;
		Item formItem = getFormItem(stack, 1);
		Item formItem2 = getFormItem(stack, 2);
		String rider=Rider;
		if (stack.getItem()== GhostRiderItems.NEW_GHOST_DRIVER.get())rider="new_ghost";
		tooltipComponents.add(Component.translatable("kamenridercraft.name." + rider));
		if (Objects.equals(Rider, "ghost") || Objects.equals(Rider, "specter") || Objects.equals(Rider, "necrom")) {
			tooltipComponents.add(Component.translatable(formItem.toString() + ".form"));
		}

		tooltipComponents.add(Component.translatable(formItem2.toString() + ".form"));

		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}


	@Override
	public void setExtraFormItem(ItemStack belt, Item ITEM, int SLOT, CompoundTag  tag)
	{
		if (getFormItem(belt, 1)== GhostRiderItems.FOURTYFIVE_HEISEI_GHOST_EYECON.get()& getFormItem(belt, 2)!= GhostRiderItems.FOURTYFIVE_HEISEI_DAMASHII.get()
				|| getFormItem(belt, 1)== GhostRiderItems.MUGEN_GHOST_EYECON.get()& getFormItem(belt, 2)!= GhostRiderItems.MUGEN_DAMASHII.get()
				|| getFormItem(belt, 1)== GhostRiderItems.SIN_SPECTER_GHOST_EYECON.get()& getFormItem(belt, 2)!= GhostRiderItems.SIN_SPECTER_DAMASHII.get()
		) {
			Consumer<CompoundTag> data = form -> form.putString("slot_tex" + 1, (this.Base_Form_Item).toString());

			CustomData.update(DataComponents.CUSTOM_DATA, belt, data);
		}
	}

	@Override
	public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
        boolean fly = rider.getAttribute(Attributes.WINGS_OUT).getBaseValue()==1;
		if (equipmentSlot == EquipmentSlot.FEET) {

			return "belts/"+ getFormItem(itemstack,1).getBeltTex()+"_"+getFormItem(itemstack,2).getFormName(false);
		}
		else if (equipmentSlot == EquipmentSlot.HEAD&itemstack.getItem()== GhostRiderItems.PROTO_MEGA_ULORDER_IGOR.asItem()) return getFormItem(itemstack,2).getFormName(fly)+"_igor";
		else if (equipmentSlot == EquipmentSlot.HEAD) {

           if (isTransforming(rider)) return getFormItem(itemstack,2).getFormName(fly)+"_parka_ghost";
           else return getFormItem(itemstack,2).getFormName(fly);
}
		else {
            if (isTransforming(rider)) return riderName + getFormItem(itemstack, 1).getFormName(fly)+"_transient";
            else return riderName + getFormItem(itemstack, 1).getFormName(fly)+Get_Wisp_Horn(getFormItem(itemstack, 2),itemstack);
		}
	}

	public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {

		if (currentSlot== EquipmentSlot.FEET) {
			return getFormItem(itemstack, 1).getIsBeltGlowing();
		}
		if (isTransformed(livingEntity)){
			switch (currentSlot) {
				case CHEST, LEGS ->{
					return true;
				}
				default -> {}
			}
			return false;
		}
		return false;
	}

	public String Get_Wisp_Horn(RiderFormChangeItem item,ItemStack itemstack)
	{
		String rider = ((GhostDriverItem) itemstack.getItem()).Rider;

		if (Wisp_Horn==item.getStoredNum()){
			return "_base";
		}else if (Objects.equals(rider, "gamma_superior")){
			return "_base";
		}else if (Objects.equals(rider, "ghost") & getFormItem(itemstack,1)== GhostRiderItems.ORE_GHOST_EYECON.get()&item.getStoredNum()==2||
				Objects.equals(rider, "ghost") & getFormItem(itemstack,1)== GhostRiderItems.MUGEN_GHOST_EYECON.get()
				|| Objects.equals(rider, "specter") & getFormItem(itemstack,1)== GhostRiderItems.SIN_SPECTER_GHOST_EYECON.get()
				|| Objects.equals(rider, "necrom") & getFormItem(itemstack,1)== GhostRiderItems.YUJOU_BURST_GHOST_EYECON.get()
				|| Objects.equals(rider, "specter") &item.getStoredNum()!=0|| Objects.equals(rider, "zero_specter") &item.getStoredNum()!=0
				|| Objects.equals(rider, "kanon_specter") &item.getStoredNum()!=0||Objects.equals(rider, "zero_ghost") &item.getStoredNum()!=0){
			return "_base";
		}

		return "_base_"+item.getStoredNum();
	}

	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {

		if (slot== EquipmentSlot.HEAD) {
			if (getFormItem(itemstack, 2).hasWingsIfFlying() && rider.getAttribute(Attributes.WINGS_OUT).getBaseValue()==1){
				return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+ getFormItem(itemstack, 2).getFlyingModel(this.Rider));
			}else return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+ getFormItem(itemstack, 2).getModel(this.Rider));

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