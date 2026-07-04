package com.kelco.kamenridercraft.item.base_items;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BaseAnimalArmorItem extends AnimalArmorItem {

    String Name;

    public BaseAnimalArmorItem(Holder<ArmorMaterial> armorMaterial, BodyType bodyType, boolean hasOverlay, Item.Properties properties, String name) {
        super(armorMaterial, bodyType, hasOverlay, properties);
        Name = name;
    }

    public @NotNull ResourceLocation getTexture() {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/horse/armor/" + Name + ".png");
    }

    public BaseAnimalArmorItem addToList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }
}