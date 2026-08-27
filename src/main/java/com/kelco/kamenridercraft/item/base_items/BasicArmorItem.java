package com.kelco.kamenridercraft.item.base_items;


import com.kelco.kamenridercraft.client.renderer.BasicArmorRenderer;
import com.kelco.kamenridercraft.data.ModItemModelProvider;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class BasicArmorItem extends net.minecraft.world.item.ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private Item changedRepairItem = ModdedItemCore.RIDER_CIRCUIT.get();

    public String name = "";
    public String model = "default";
    public Boolean glowing = false;

    private MobEffectInstance effect;

    public BasicArmorItem(Holder<ArmorMaterial> armorMaterial, Type type, Properties properties, String name, String model) {
        super(armorMaterial, type, properties.stacksTo(1));
        this.name = name;
        this.model = model;
    }

    public BasicArmorItem isGlowing() {
        glowing = true;
        return this;
    }

    public BasicArmorItem setEffect(MobEffectInstance effectInstance) {
        effect = effectInstance;
        return this;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof LivingEntity livingEntity && !level.isClientSide() && slotId >= 36 && slotId <= 39 && effect != null) {
            livingEntity.addEffect(effect);
        }
            super.inventoryTick(stack, level, entity, slotId, isSelected);
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private BasicArmorRenderer renderer;

            @Override
            public <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(@Nullable T livingEntity, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable HumanoidModel<T> original) {
                this.renderer = new BasicArmorRenderer(livingEntity, equipmentSlot);
                return this.renderer;
            }
        });
    }

    public BasicArmorItem addToList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        RawAnimation IDLE = RawAnimation.begin().thenLoop("idle");
        controllerRegistrar.add(new AnimationController<>(this, "riderAnim", 20, state -> {
            state.setAndContinue(IDLE);
            return PlayState.CONTINUE;
        }));
    }


    public BasicArmorItem changeRepairItem(Item item) {
        changedRepairItem = item;
        return this;
    }

    public boolean isValidRepairItem(@NotNull ItemStack itemStackOne, ItemStack repairItem) {
        return repairItem.getItem() == changedRepairItem;
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