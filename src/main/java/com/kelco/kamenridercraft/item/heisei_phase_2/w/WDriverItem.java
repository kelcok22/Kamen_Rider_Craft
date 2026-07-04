package com.kelco.kamenridercraft.item.heisei_phase_2.w;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.WRiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
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
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class WDriverItem extends RiderDriverItem {


	public WDriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		hasBasicBeltInfo =false;
        unlimitedBeltTextures = 1;
	}

    @Override
    public String getUnlimitedBeltTextures(ItemStack itemstack, LivingEntity rider, String riderName ,int num) {
        if(riderName!="w") return "blank";
        else  return "wdriver_belt"+ getFormItem(itemstack,2).getFormName(false);
    }

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

		tooltipComponents.add(Component.translatable("kamenridercraft.name."+ riderName));


		Item formItem = getFormItem(stack, 1);
		Item formItem2 = getFormItem(stack, 2);
		if(formItem== WRiderItems.XTREME_MEMORY.get()||formItem== WRiderItems.XTREME_GOLD_MEMORY.get()||formItem== WRiderItems.XTREME_ACCEL_MEMORY.get()) tooltipComponents.add(Component.translatable(formItem + ".form"));
		else{
			tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString() + " "
			+ Component.translatable(formItem.toString() + ".form").getString()
			+ Component.translatable(formItem2.toString() + ".form").getString()));
		}
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}


	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		super.inventoryTick(stack,level,entity,slotId,isSelected);
		if (entity instanceof Player player) {
		if (RiderDriverItem.getFormItem(stack, 1)== WRiderItems.XTREME_MEMORY.get()&player.fallDistance>10) {
			RiderFormChangeItem alternativeItem_form_change = (RiderFormChangeItem) WRiderItems.XTREME_GOLD_MEMORY.get();
			alternativeItem_form_change.use(level, player, InteractionHand.MAIN_HAND);
		}
			}
	}

    public ResourceLocation getBeltModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/w_riderbelt.geo.json");
    }
	@Override
    public void setExtraFormItem(ItemStack belt, Item ITEM, int SLOT, CompoundTag  tag)
    {
		if (getFormItem(belt, 1)== WRiderItems.XTREME_MEMORY.get()|| getFormItem(belt, 1)== WRiderItems.XTREME_GOLD_MEMORY.get()|| getFormItem(belt, 1)== WRiderItems.XTREME_ACCEL_MEMORY.get()) {
			if (getFormItem(belt, 2)!= WRiderItems.JOKER_MEMORY.get()) {
            	Consumer<CompoundTag> data = form -> form.putString("slot_tex1", (WRiderItems.CYCLONE_MEMORY.get()).toString());

            	CustomData.update(DataComponents.CUSTOM_DATA, belt, data);
			}
		}
		if (getFormItem(belt, 2)== WRiderItems.CYCLONE_SKULL_MEMORY.get() && getFormItem(belt, 1)!= WRiderItems.CYCLONE_MEMORY.get()) {
            Consumer<CompoundTag> data = form -> {
				form.putString("slot_tex2", (WRiderItems.JOKER_MEMORY.get()).toString());
            	form.putBoolean("Update_form", true);
            	form.putDouble("render_type", getRenderType(belt));
            };

            CustomData.update(DataComponents.CUSTOM_DATA, belt, data);
		}
	}

	@Override
	public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
        boolean fly = rider.getAttribute(Attributes.WINGS_OUT).getBaseValue()==1;
		if (equipmentSlot == EquipmentSlot.FEET) {
			
			return "belts/"+ getFormItem(itemstack,1).getBeltTex();
		}
		else if (equipmentSlot == EquipmentSlot.HEAD){
			if (Objects.equals(getFormItem(itemstack, 2,rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).getFormName(fly), "_skull")) return riderName+ getFormItem(itemstack,1,rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).getFormName(fly)+"_skull";
			else return riderName+ getFormItem(itemstack,1,rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).getFormName(fly);
		}
			
		
		else {
			if (Objects.equals(getFormItem(itemstack, 1,rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).getFormName(fly), "_fang")) return riderName+"_fang"+ getFormItem(itemstack,2,rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).getFormName(fly);
			else if (Objects.equals(getFormItem(itemstack, 1,rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).getFormName(fly), "_cyclone_xtreme")) return riderName+ getFormItem(itemstack,2,rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).getFormName(fly)+"_xtreme";
			else if (Objects.equals(getFormItem(itemstack, 1,rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).getFormName(fly), "_cyclone_xtreme_gold")) return riderName+ getFormItem(itemstack,2,rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).getFormName(fly)+"_xtreme_gold";
			else if (Objects.equals(getFormItem(itemstack, 1,rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).getFormName(fly), "_cyclone_xtreme_accel")) return riderName+"_accel_xtreme";
			else return riderName+ getFormItem(itemstack,2,rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).getFormName(fly);
		}
	}

	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		
		if (slot!= EquipmentSlot.HEAD) {
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/w_joker.geo.json");
		}else return super.getModelResource(itemstack, animatable, slot,rider);
	}
	
	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
		case HEAD ->{ 
			if (Objects.equals(part, "head")) return true;
			if (Objects.equals(part, "body")) return true;
			if (Objects.equals(part, "rightArm")) return true;
			if (Objects.equals(part, "rightLeg")) return true;
			
		}
		case CHEST -> {
			if (Objects.equals(part, "body")) return true;

		}
		case LEGS -> {
			if (Objects.equals(part, "head")) return true;
			if (Objects.equals(part, "leftLeg")) return true;
			if (Objects.equals(part, "leftArm")) return true;
		
		}
		default -> {}
		}
		return false;
	}



}