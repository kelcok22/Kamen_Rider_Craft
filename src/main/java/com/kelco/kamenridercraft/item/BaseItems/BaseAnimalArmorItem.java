package com.kelco.kamenridercraft.item.BaseItems;

import java.util.List;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

public class BaseAnimalArmorItem extends AnimalArmorItem {

    String Name;

    public BaseAnimalArmorItem(Holder<ArmorMaterial> armorMaterial, BodyType bodyType, boolean hasOverlay, Item.Properties properties,String name) {
        super(armorMaterial, bodyType,  hasOverlay,  properties);
        Name=name;
    }

    public ResourceLocation getTexture() {return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/entity/horse/armor/"+Name+".png");}

    public BaseAnimalArmorItem AddToList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }
}
