package com.kelco.kamenridercraft.item.revice;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.item.Revice_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class DemonsDriverItem extends RiderDriverItem {


	public DemonsDriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
 
		Extra_Base_Form_Item= Lists.newArrayList((RiderFormChangeItem) Modded_item_core.BLANK_FORM.get(),(RiderFormChangeItem)Modded_item_core.BLANK_FORM.get(),(RiderFormChangeItem)Modded_item_core.BLANK_FORM.get(),(RiderFormChangeItem)Modded_item_core.BLANK_FORM.get());
		Num_Base_Form_Item=5;
	}
	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		Has_basic_belt_info=false;
		tooltipComponents.add(Component.translatable("kamenridercraft.name."+Rider));

		if (get_Form_Item(stack, 2)== Revice_Rider_Items.ANOMALOCARIS_VISTAMP.get()&get_Form_Item(stack, 5)
				==Revice_Rider_Items.BATTA_VISTAMP.get()&get_Form_Item(stack, 4)
				==Revice_Rider_Items.SCORPION_VISTAMP.get()) tooltipComponents.add(Component.translatable( "kamenridercraft:full_genomix.form"));

		else if (get_Form_Item(stack, 1)== Revice_Rider_Items.GIANT_SPIDER_VISTAMP.get()) tooltipComponents.add(Component.translatable( "kamenridercraft:giant_genomix.form"));

		else {
			tooltipComponents.add(Component.translatable( "kamenridercraft:genomix.form"));

			if (get_Form_Item(stack, 2) == Revice_Rider_Items.ANOMALOCARIS_VISTAMP.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:anomalocaris_vistamp.form"));
			if (get_Form_Item(stack, 2) == Revice_Rider_Items.KOMODO_DRAGON_VISTAMP.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:komodo_dragon_vistamp.form"));
			if (get_Form_Item(stack, 2) == Revice_Rider_Items.KOMODO_DRAGON_VISTAMP_DEMONS.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:komodo_dragon_vistamp.form"));
			if (get_Form_Item(stack, 2) == Revice_Rider_Items.MOGURA_VISTAMP.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:mogura_vistamp.form"));
			if (get_Form_Item(stack, 3) == Revice_Rider_Items.BATTA_VISTAMP.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:batta_vistamp.form"));
			if (get_Form_Item(stack, 3) == Revice_Rider_Items.CONDOR_VISTAMP_DEMONS.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:condor_vistamp_demons.form"));
			if (get_Form_Item(stack, 3) == Revice_Rider_Items.CROCODILE_VISTAMP.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:crocodile_vistamp.form"));
			if (get_Form_Item(stack, 3) == Revice_Rider_Items.CROCODILE_VISTAMP_DEMONS.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:crocodile_vistamp_demons.form"));
			if (get_Form_Item(stack, 4) == Revice_Rider_Items.SCORPION_VISTAMP.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:scorpion_vistamp.form"));
			if (get_Form_Item(stack, 5) == Revice_Rider_Items.BATTA_VISTAMP.get())
				tooltipComponents.add(Component.translatable("kamenridercraft:batta_vistamp.form"));
		}
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}
	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
	{
		boolean fly = rider instanceof Player player && player.getAbilities().flying;
		switch (equipmentSlot) {
			case EquipmentSlot.FEET:
				String belt = ((RiderDriverItem)itemstack.getItem()).BELT_TEXT;
				if (((RiderDriverItem)itemstack.getItem()).BELT_TEXT==null) {
					belt = get_Form_Item(itemstack,1).getBeltTex();
				}
				return "belts/"+belt;
			case EquipmentSlot.CHEST:
				return get_Form_Item(itemstack,1).getFormName(fly)+"_genomix_1";
			case EquipmentSlot.LEGS:
				return "_genomix_2";
			default:
				return riderName+ get_Form_Item(itemstack,1).getFormName(fly);
		}	

	}
    public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {

        if (currentSlot== EquipmentSlot.FEET) {
            return get_Form_Item(itemstack, 1).get_Is_Belt_Glowing();
        }
        if (isTransformed(livingEntity)){
            switch (currentSlot) {
                case LEGS, CHEST ->{
                    return false;
                }
                case  HEAD-> {
                    return true;
                }
                default -> {}
            }
            return false;
        }
        return false;
    }

	public ResourceLocation getModelResource(ItemStack itemstack,RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		int num = 1;
		if (slot == EquipmentSlot.CHEST||slot == EquipmentSlot.LEGS) return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"geo/default_wings_armor.geo.json");
		
		if (get_Form_Item(itemstack, num).HasWingsIfFlying() && rider instanceof Player player && player.getAbilities().flying){
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, num).get_FlyingModel(this.Rider));
		}
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, num).get_Model(this.Rider));

	}

	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
			case HEAD ->{
				if (Objects.equals(part, "head")) return true;
				if (Objects.equals(part, "body")) return true;
				if (Objects.equals(part, "rightArm")) return true;
				if (Objects.equals(part, "leftArm")) return true;
				if (Objects.equals(part, "rightLeg")) return true;
				if (Objects.equals(part, "leftLeg")) return true;
			}
			case CHEST -> {
				if (Objects.equals(part, "body")) return get_Form_Item(itemstack, 4)== Revice_Rider_Items.SCORPION_VISTAMP.get();

				if (get_Form_Item(itemstack, 1)== Revice_Rider_Items.GIANT_SPIDER_VISTAMP.get()){
					if (Objects.equals(part, "rightArm")) return get_Form_Item(itemstack, 2) == Revice_Rider_Items.KOMODO_DRAGON_VISTAMP_DEMONS.get();
					if (Objects.equals(part, "leftArm")) return get_Form_Item(itemstack, 3) == Revice_Rider_Items.CROCODILE_VISTAMP_DEMONS.get();

				}else {
					if (Objects.equals(part, "rightArm")) return get_Form_Item(itemstack, 2) == Revice_Rider_Items.ANOMALOCARIS_VISTAMP.get();
					if (Objects.equals(part, "leftArm")) return get_Form_Item(itemstack, 2) == Revice_Rider_Items.ANOMALOCARIS_VISTAMP.get();
				}
				if (Objects.equals(part, "rightLeg")) return get_Form_Item(itemstack, 5)== Revice_Rider_Items.BATTA_VISTAMP.get();
				if (Objects.equals(part, "leftLeg")) return get_Form_Item(itemstack, 5)== Revice_Rider_Items.BATTA_VISTAMP.get();
			}
			case LEGS -> {
				if (Objects.equals(part, "body")) return get_Form_Item(itemstack, 3)== Revice_Rider_Items.CONDOR_VISTAMP_DEMONS.get();

				if (Objects.equals(part, "rightArm")) return get_Form_Item(itemstack, 2)== Revice_Rider_Items.MOGURA_VISTAMP.get();


			}
			default -> {}
		}
		return false;
	}

	@Override
    public void Extra_set_Form_Item(ItemStack belt, Item ITEM,int SLOT,CompoundTag  tag)
    {
		if (((RiderFormChangeItem) ITEM).getSlot()==1&Modded_item_core.BLANK_FORM.get()!=ITEM) {
            Consumer<CompoundTag> data = form -> {
				for (int n = 2; n < 6; n++) form.putString("slot_tex" + n, (Modded_item_core.BLANK_FORM.get()).toString());
            };

            CustomData.update(DataComponents.CUSTOM_DATA, belt, data);
		}
	}
}