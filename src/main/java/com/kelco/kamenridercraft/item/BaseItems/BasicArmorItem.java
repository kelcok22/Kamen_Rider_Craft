package com.kelco.kamenridercraft.item.BaseItems;


import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.data.ModItemModelProvider;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.item.client.BasicArmorRenderer;
import com.kelco.kamenridercraft.item.client.RiderArmorRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class BasicArmorItem extends net.minecraft.world.item.ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private Item RepairItem = Modded_item_core.RIDER_CIRCUIT.get();

    public String NAME ="";
    public String MODEL ="default";
    public Boolean Glow =false;

    public BasicArmorItem(Holder<ArmorMaterial> armorMaterial, Type type, Properties properties, String name, String model) {
        super(armorMaterial, type, properties.stacksTo(1));
        NAME=name;
        MODEL=model;
    }

    public BasicArmorItem isGlowing() {
      Glow=true;
        return this;
    }


    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private BasicArmorRenderer renderer;
            @Override
            public <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(@Nullable T livingEntity, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable HumanoidModel<T> original) {
                //if(this.renderer == null)
                    this.renderer = new BasicArmorRenderer(livingEntity, equipmentSlot);
                return this.renderer;
            }
        });
    }

    public BasicArmorItem AddToList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        RawAnimation IDLE = RawAnimation.begin().thenLoop("idle");
        controllerRegistrar.add(new AnimationController<>(this, "riderAnim", 20, state -> {
            Entity entity = state.getData(DataTickets.ENTITY);
           state.setAndContinue(IDLE);
            return PlayState.CONTINUE;
        }));
    }

    public BasicArmorItem ChangeRepairItem(Item item) {
        RepairItem = item;
        return this;
    }

    public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
        return p_40393_.getItem()== RepairItem;
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    public BasicArmorItem has_basic_model() {
        ModItemModelProvider.BASIC_ITEM_MODEL2.add(this);
        return this;
    }
}