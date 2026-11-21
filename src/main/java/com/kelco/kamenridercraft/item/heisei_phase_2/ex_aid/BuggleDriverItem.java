package com.kelco.kamenridercraft.item.heisei_phase_2.ex_aid;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ExAidRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class BuggleDriverItem extends RiderDriverItem {
    public BuggleDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);

        extraBaseFormItem = Lists.newArrayList((RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get(), (RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get());
        numBaseFormItems = 2;
        unlimitedBeltTextures = 1;
    }

    @Override
    public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        double henshinTick = getHenshinTick(itemstack, rider);
        if (equipmentSlot == EquipmentSlot.FEET) {
            String belt = ((RiderDriverItem) itemstack.getItem()).beltText;
            if (((RiderDriverItem) itemstack.getItem()).beltText == null) {
                belt = getFormItem(itemstack, 1).getBeltTex();
            }
            if (itemstack.getItem() == ExAidRiderItems.GASHACON_BUGVISOR_GENM.get() && rider.isHolding(ExAidRiderItems.GASHACON_BUGVISOR.get()))
                belt = "bugster_buckle";
            if ((itemstack.getItem() == ExAidRiderItems.GASHACON_BUGVISOR_II_CHRONOS.get() || itemstack.getItem() == ExAidRiderItems.GASHACON_BUGVISOR_II_CHRONICLE_BUGTER.get()
                    || itemstack.getItem() == ExAidRiderItems.GASHACON_BUGVISOR_II_POPPY.get() || itemstack.getItem() == ExAidRiderItems.GASHACON_BUGVISOR_II_LAZER.get())
                    && rider.isHolding(ExAidRiderItems.GASHACON_BUGVISOR_II.get())) belt = "bugster_buckle_ii";

            return "belts/" + belt;
        }
        return super.getText(itemstack, equipmentSlot, rider, riderName);
    }
}