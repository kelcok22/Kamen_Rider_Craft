package com.kelco.kamenridercraft.item.heisei_phase_1.hibiki;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.HibikiRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class IbukiEquipmentBeltItem extends RiderDriverItem {
    public IbukiEquipmentBeltItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
        unlimitedBeltTextures = 1;
    }

    @Override
    public String getUnlimitedBeltTextures(ItemStack itemStack, LivingEntity rider, String riderName, int num) {
        if (this == HibikiRiderItems.IBUKIDRIVER.get() && !rider.isHolding(HibikiRiderItems.HENSHIN_ONIBUE_IBUKI.get())) {
            return "henshin_onibue_ibuki";
        } else if (this == HibikiRiderItems.AMAKIDRIVER.get() && !rider.isHolding(HibikiRiderItems.HENSHIN_ONIBUE_AMAKI.get())) {
            return "henshin_onibue_amaki";
        }
        return "blank";
    }
}
