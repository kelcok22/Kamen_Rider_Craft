package com.kelco.kamenridercraft.item.saber;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Saber_Rider_Items;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class SwordOfLogosBuckleItem extends RiderDriverItem {



    public SwordOfLogosBuckleItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
    {
        super(material, rider, baseFormItem, head, torso, legs, properties);
        Unlimited_Textures=1;
    }

    @Override
    public String getUnlimitedTextures(ItemStack itemstack, LivingEntity rider, String riderName ,int num) {
        if (rider.getMainHandItem().getItem()==Saber_Rider_Items.DOGOUKEN_GEKIDO.get()||rider.getOffhandItem().getItem()==Saber_Rider_Items.DOGOUKEN_GEKIDO.get()) return "blank";
        return "dogouken_gekido";
    }


    public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/buster.geo.json");
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