package com.kelco.kamenridercraft.item.reiwa.my_th;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.HibikiRiderItems;
import com.kelco.kamenridercraft.item.reiwa.MyThRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class MyThDriverItem extends RiderDriverItem {
    public MyThDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
        unlimitedTextures = 2;
    }

    @Override
    public String getUnlimitedTextures(ItemStack itemStack, LivingEntity livingEntity, String riderName, int num) {
        if (getFormItem(itemStack, 1) != MyThRiderItems.RIDE_X_EGGS_4.get()) {
            Item back = MyThRiderItems.FRAME_MY_TH_BACK.get();
            Item handItem = ((livingEntity.getMainArm() == HumanoidArm.LEFT) || (livingEntity.getMainArm() == HumanoidArm.RIGHT) ? livingEntity.getMainHandItem().getItem() : livingEntity.getOffhandItem().getItem());

            if (num == 1 && handItem != back) return "my_th_turtle_frame_back";
        }
        return "blank";
    }

    @Override
    public boolean getPartsForSlot(ItemStack itemStack, EquipmentSlot currentSlot, String part) {
        return currentSlot != EquipmentSlot.FEET;
    }
}