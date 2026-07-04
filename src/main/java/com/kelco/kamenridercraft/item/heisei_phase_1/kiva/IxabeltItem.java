package com.kelco.kamenridercraft.item.heisei_phase_1.kiva;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.KivaRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class IxabeltItem extends RiderDriverItem {

    public IxabeltItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);

    }

    @Override
    public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        if (equipmentSlot == EquipmentSlot.FEET && (itemstack.getItem() == KivaRiderItems.IXA_BELT.get() || itemstack.getItem() == KivaRiderItems.PROTO_IXA_BELT.get())) {
            if (rider.isHolding(KivaRiderItems.IXA_KNUCKLE.get())) {
                return "belts/empty_ixa_belt";
            }
        }
        return super.getText(itemstack, equipmentSlot, rider, riderName);
    }
}