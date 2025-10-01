package com.kelco.kamenridercraft.item.gaim;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Gaim_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Objects;

public class SengokuDriverItem extends RiderDriverItem {



	public SengokuDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
	{
		boolean fly = rider instanceof Player player && player.getAbilities().flying;
		if (equipmentSlot == EquipmentSlot.FEET) {
			if (Objects.equals(riderName, "zangetsu") &get_Form_Item(itemstack,1)== Gaim_Rider_Items.WATERMELON_LOCKSEED.get()) return "belts/sengoku_driver_belt_zangetsu_w";
			if (Objects.equals(riderName, "ryugen") &get_Form_Item(itemstack,1)== Gaim_Rider_Items.YOMOTSU_HEGURI_LOCKSEED.get()) return "belts/sengoku_driver_belt_ryugen_y";
			return "belts/"+get_Form_Item(itemstack,2).getBeltTex();
		}
		else if (equipmentSlot == EquipmentSlot.HEAD) {
			if (Objects.equals(riderName, "ryugen") &get_Form_Item(itemstack,1)== Gaim_Rider_Items.YOMOTSU_HEGURI_LOCKSEED.get()) return "ryugen_yomi";
			else if (Objects.equals(riderName, "duke") &get_Form_Item(itemstack,1)== Gaim_Rider_Items.DRAGON_FRUITS_ENERGY_LOCKSEED.get()) return "duke_hex";
			else if (Objects.equals(riderName, "zangetsu") &get_Form_Item(itemstack,1)== Gaim_Rider_Items.WATERMELON_LOCKSEED.get()) return "zangetsu_watermelon";
			else if (Objects.equals(riderName, "zangetsu") &get_Form_Item(itemstack,1)== Gaim_Rider_Items.ZANGETSU_KACHIDOKI_LOCKSEED.get()) return "zangetsu_kachidoki";
			else if (Objects.equals(riderName, "gridon") &get_Form_Item(itemstack,1)== Gaim_Rider_Items.LYCHEE_LOCKSEED.get()) return "gridon_lychee";
			else if (Objects.equals(riderName, "gaim") &get_Form_Item(itemstack,1)== Gaim_Rider_Items.FRESH_ORANGE_LOCKSEED.get()) return "gaim_fresh";
			else if (Objects.equals(riderName, "gaim") &get_Form_Item(itemstack,1)== Gaim_Rider_Items.DRIVE_LOCKSEED.get()) return "gaim_drive";
			else if (Objects.equals(riderName, "gaim") &get_Form_Item(itemstack,1)== Gaim_Rider_Items.KACHIDOKI_LOCKSEED.get()) return "gaim_kachidoki";
			else if (Objects.equals(riderName, "gaim") &get_Form_Item(itemstack,1)== Gaim_Rider_Items.KIWAMI_LOCKSEED.get()) return "gaim_kiwami";
			else if (Objects.equals(riderName, "bravo") &get_Form_Item(itemstack,1)== Gaim_Rider_Items.KING_DURIAN_LOCKSEED.get()) return "bravo_king";
			else if (Objects.equals(riderName, "bujin_gaim") &get_Form_Item(itemstack,1)== Gaim_Rider_Items.OCHIMUSHA_LOCKSEED.get()) return "bujin_gaim_ochimusha";
			else return riderName + get_Form_Item(itemstack, 2).getFormName(fly);
		}
		else if (equipmentSlot == EquipmentSlot.CHEST)
			if (get_Form_Item(itemstack,2)== Gaim_Rider_Items.JIMBER_GAIM_CORE.get()){
				return"jimbar_arms_"+riderName;
			}else return"blank";

		else return get_Form_Item(itemstack,1).getFormName(fly);
	}

    public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {

        if (currentSlot== EquipmentSlot.FEET) {
            return get_Form_Item(itemstack, 1).get_Is_Belt_Glowing();
        }
        if (isTransformed(livingEntity)){
            switch (currentSlot) {
                case HEAD->{
                    return false;
                }
                case LEGS, CHEST -> {
                    return true;
                }
                default -> {}
            }
            return false;
        }
        return false;
    }


	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {

		if (slot== EquipmentSlot.LEGS||slot== EquipmentSlot.CHEST) {
			if (get_Form_Item(itemstack, 1) == Gaim_Rider_Items.KACHIDOKI_LOCKSEED.get() | get_Form_Item(itemstack, 1) == Gaim_Rider_Items.ZANGETSU_KACHIDOKI_LOCKSEED.get()) {
				return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/gaim_kachidoki_arms.geo.json");
			}
			else if (Objects.equals(get_Form_Item(itemstack, 1).get_Model(this.Rider), "default.geo.json")) {
				 return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/lockseed_arms.geo.json");
 			}
		}
		return super.getModelResource(itemstack, animatable, slot,rider);
	}

	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
			case HEAD, LEGS ->{
			 return true;
			}
			case CHEST -> {
				if (Objects.equals(part, "head")) return true;
				if (Objects.equals(part, "body")) return true;
			}
            default -> {}
		}
		return false;
	}
}