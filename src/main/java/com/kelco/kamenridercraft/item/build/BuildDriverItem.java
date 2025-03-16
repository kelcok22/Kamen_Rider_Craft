package com.kelco.kamenridercraft.item.build;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.Build_Rider_Items;
import com.kelco.kamenridercraft.item.Drive_Rider_Items;
import com.kelco.kamenridercraft.item.W_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

public class BuildDriverItem extends RiderDriverItem {


	public BuildDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		Item belt= stack.getItem();
		if (belt!= Drive_Rider_Items.BANNO_DRIVER_BRONZE_DRIVE.get()&
				belt!=Drive_Rider_Items.BANNO_DRIVER_GORD_DRIVE.get()&
				belt!=Drive_Rider_Items.METRO_PD_DRIVER_HONOH.get()&
				belt!=Drive_Rider_Items.BRAIN_DRIVER.get()) {

			this.Has_basic_belt_info = false;
			Item formItem = this.get_Form_Item(stack, 1);
			Item formItem2 = this.get_Form_Item(stack, 2);
			Item formItem3 = this.get_Form_Item(stack, 3);

			tooltipComponents.add(Component.translatable("kamenridercraft.name." + Rider));

			if (isBestMatch(stack)&formItem3== Build_Rider_Items.HAZARD_TRIGGER.get())tooltipComponents.add(Component.translatable("kamenridercraft.name.best_match_hazard"));
			else if (isBestMatch(stack))tooltipComponents.add(Component.translatable("kamenridercraft.name.best_match"));

			if(formItem3!= Build_Rider_Items.HAZARD_TRIGGER.get()&formItem3!= Build_Rider_Items.FULL_BOTTLE.get()){
				tooltipComponents.add(Component.translatable(formItem3.toString() + ".form"));
			}else {
				tooltipComponents.add(Component.translatable(formItem.toString() + ".form"));
				tooltipComponents.add(Component.translatable(formItem2.toString() + ".form"));
				if (get_Form_Item(stack, 3) == Build_Rider_Items.HAZARD_TRIGGER.get())
					tooltipComponents.add(Component.translatable("kamenridercraft.name.hazard"));
			}
			}
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}
	
	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		super.inventoryTick(stack,level,entity,slotId,isSelected);
	}

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
	{
		boolean fly = rider instanceof Player player && player.getAbilities().flying;
		if (equipmentSlot == EquipmentSlot.FEET) {
			
			return "belts/"+get_Form_Item(itemstack,3).getBeltTex();
		}
		else if (isBestMatch(itemstack)&isLegend(itemstack)) return riderName+"_"+((FullBottleItem)get_Form_Item(itemstack,Legend_Slot(itemstack))).get_Is_Legend_Name();
		else if (equipmentSlot == EquipmentSlot.HEAD) return riderName+get_Form_Item(itemstack,1).getFormName(fly)+get_Form_Item(itemstack,3).getFormName(fly);
		else { return riderName+get_Form_Item(itemstack,2).getFormName(fly)+get_Form_Item(itemstack,3).getFormName(fly);
		}
	}

	public int Legend_Slot(ItemStack itemstack) {

		if (get_Form_Item(itemstack, 1) instanceof FullBottleItem form) {
			if (form.get_Is_Legend()) return 1;
		}
		return 2;
	}

	public boolean isLegend(ItemStack itemstack) {

		if (get_Form_Item(itemstack,1) instanceof FullBottleItem form){
			if (form.get_Is_Legend()){return true;}
		}if (get_Form_Item(itemstack,2) instanceof FullBottleItem form){
			if (form.get_Is_Legend()){return true;}
		}
		return false;
	}
	public static boolean isBestMatch(ItemStack itemstack) {

		if (get_Form_Item(itemstack,1) instanceof FullBottleItem form){
			if (form.get_Is_Legend()){
				return form.get_Best_Match()==get_Form_Item(itemstack,2);
			}

		}if (get_Form_Item(itemstack,2) instanceof FullBottleItem form){
			return form.get_Best_Match()==get_Form_Item(itemstack,1);
		}
		return false;
	}

	public static boolean CanHazard(ItemStack itemstack) {
		if (get_Form_Item(itemstack,1) instanceof FullBottleItem form) {
			if (form.get_Is_Legend())return false;
		}
				if (isBestMatch(itemstack)){
			if (get_Form_Item(itemstack,2) instanceof FullBottleItem form){
				if (!form.get_Is_Legend()){
					return form.Get_Can_Hazard();
				}
			}
		}
		return false;
	}
	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {

		int num = 1;
		if (slot == EquipmentSlot.LEGS)num=2;

	 if (isBestMatch(itemstack)&isLegend(itemstack)) return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/rider_plusbelt.geo.json");
		else if (get_Form_Item(itemstack, num).get_Model()=="default.geo.json") {
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/rider_plusbelt.geo.json");
		}
		if (get_Form_Item(itemstack, num).HasWingsIfFlying() && rider instanceof Player player && player.getAbilities().flying){
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, num).get_FlyingModel());
		}else return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, num).get_Model());
	}
	
	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
		case HEAD ->{ 
			if (part =="head") return true;
			if (part =="body") return true;
			if (part =="rightArm") return true;
			if (part =="leftLeg") return true;
			
		}
		case CHEST -> {

		}
		case LEGS -> {
			if (part =="head") return true;
			if (part =="body") return true;
			if (part =="leftArm") return true;
			if (part =="rightLeg") return true;
		
		}
		default -> {}
		}
		return false;
	}



}