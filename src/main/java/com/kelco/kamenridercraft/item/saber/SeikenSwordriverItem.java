package com.kelco.kamenridercraft.item.saber;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;

public class SeikenSwordriverItem extends RiderDriverItem {



    public SeikenSwordriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
    {
        super(material, rider, baseFormItem, head, torso, legs, properties);
        Unlimited_Textures=4;
    }

    @Override
    public String getUnlimitedTextures(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName, int num)
    {
        boolean fly = rider instanceof Player player && player.getAbilities().flying;
        //return riderName + get_Form_Item(itemstack, 4).getFormName(fly);

        if(num==2) return get_Form_Item(itemstack,1).getFormName(fly);
        else if(num==3) return get_Form_Item(itemstack,2).getFormName(fly);
        else if(num==4) return get_Form_Item(itemstack,3).getFormName(fly);
        else return riderName + "_base";
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack,level,entity,slotId,isSelected);

    }


    public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/rider_plusbelt.geo.json");
    }


    @Override
    public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
    {
        boolean fly = rider instanceof Player player && player.getAbilities().flying;
        if (equipmentSlot == EquipmentSlot.FEET) {
            return "belts/"+get_Form_Item(itemstack,1).getBeltTex();
        }
        if (equipmentSlot == EquipmentSlot.HEAD) return get_Form_Item(itemstack,1).getFormName(fly);
        else if (equipmentSlot == EquipmentSlot.CHEST) return get_Form_Item(itemstack,2).getFormName(fly);
        else if (equipmentSlot == EquipmentSlot.LEGS) return get_Form_Item(itemstack,3).getFormName(fly);
        else return get_Form_Item(itemstack,3).getFormName(fly);
    }


    @Override
    public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

        switch (currentSlot) {
            case HEAD,LEGS,CHEST ->{
                return true;

            }

            default -> {}
        }
        return false;
    }
}