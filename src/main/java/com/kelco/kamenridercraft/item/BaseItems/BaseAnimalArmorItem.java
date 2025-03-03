package com.kelco.kamenridercraft.item.BaseItems;

import java.util.List;
import java.util.function.Function;
import javax.annotation.Nullable;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

public class BaseAnimalArmorItem extends AnimalArmorItem {

    public BaseAnimalArmorItem(Holder<ArmorMaterial> armorMaterial, BodyType bodyType, boolean hasOverlay, Item.Properties properties) {
        super(armorMaterial, bodyType,  hasOverlay,  properties);
    }

    public ResourceLocation getTexture() {return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/entity/horse/armor/horse_armor_gaim.png");}

    public BaseAnimalArmorItem AddToList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }
}
