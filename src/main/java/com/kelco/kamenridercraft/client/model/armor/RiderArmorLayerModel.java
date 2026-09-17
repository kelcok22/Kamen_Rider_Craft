package com.kelco.kamenridercraft.client.model.armor;


import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoRenderer;

public class RiderArmorLayerModel<T extends RiderArmorItem> extends RiderArmorModel<T> {
    public RiderArmorLayerModel() {
    }

    @Override
    public ResourceLocation getModelResource(T animatable, @Nullable GeoRenderer<T> renderer) {
        return getModelResource(animatable);
    }
}