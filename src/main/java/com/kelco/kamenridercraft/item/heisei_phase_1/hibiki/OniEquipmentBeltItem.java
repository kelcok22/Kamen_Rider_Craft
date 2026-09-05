package com.kelco.kamenridercraft.item.heisei_phase_1.hibiki;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class OniEquipmentBeltItem extends RiderDriverItem {
    private Item beltItem;
    private final String beltItemTex;

    public OniEquipmentBeltItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties, DeferredItem<Item> henshinItem, String henshinItemTexture) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
        unlimitedBeltTextures = 1;
        beltItem = henshinItem.get();
        beltItemTex = henshinItemTexture;
    }

    @Override
    public String getUnlimitedBeltTextures(ItemStack itemStack, LivingEntity rider, String riderName, int num) {
        if (!rider.isHolding(beltItem)) return beltItemTex;
        return "blank";
    }
}
