package com.kelco.kamenridercraft.item.faiz;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Faiz_Rider_Items;

import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;

public class MuezDriverItem extends RiderDriverItem {



    public MuezDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
    {
        super(material, rider, baseFormItem, head, torso, legs, properties);
        Unlimited_Textures=2;
    }

    @Override
    public String getUnlimitedTextures(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName ,int num) {
        if ((rider instanceof Player || rider instanceof Mob) && rider.getMainArm() == HumanoidArm.LEFT) {
            if (num==1&&rider.getOffhandItem().getItem()!=Faiz_Rider_Items.MUEZ_EDGE.get()) return "muez_edge_l";
            else if (num==2&&rider.getMainHandItem().getItem()!=Faiz_Rider_Items.MUEZ_EDGE.get()) return "muez_edge_r";
        } else {
            if (num==1&&rider.getMainHandItem().getItem()!=Faiz_Rider_Items.MUEZ_EDGE.get()) return "muez_edge_l";
            else if (num==2&&rider.getOffhandItem().getItem()!=Faiz_Rider_Items.MUEZ_EDGE.get()) return "muez_edge_r";
        }
        return "blank";
    }


    public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/muez.geo.json");
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