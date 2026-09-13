package com.kelco.kamenridercraft.item.heisei_phase_1.hibiki;

import com.kelco.kamenridercraft.item.heisei_phase_1.HibikiRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class KabukiEquipmentBeltItem extends OniEquipmentBeltItem {
    public KabukiEquipmentBeltItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties, DeferredItem<Item> henshinItem, String henshinItemTexture) {
        super(material, rider, baseFormItem, head, torso, legs, properties, henshinItem, henshinItemTexture);
        unlimitedBeltTextures = 3;
    }

    @Override
    public String getUnlimitedBeltTextures(ItemStack itemStack, LivingEntity rider, String riderName, int num) {
        Item ongeki = HibikiRiderItems.ONGEKIBO_RESSUI.get();
        Item leftHandItem = rider.getMainArm() == HumanoidArm.LEFT? rider.getMainHandItem().getItem() : rider.getOffhandItem().getItem();
        Item rightHandItem = rider.getMainArm() == HumanoidArm.LEFT? rider.getOffhandItem().getItem() : rider.getMainHandItem().getItem();

        if (num == 2 && leftHandItem != ongeki) return "ongekibo_ressui_l";
        else if (num == 3 && rightHandItem != ongeki) return "ongekibo_ressui_r";

        return super.getUnlimitedBeltTextures(itemStack, rider, riderName, num);
    }
}
