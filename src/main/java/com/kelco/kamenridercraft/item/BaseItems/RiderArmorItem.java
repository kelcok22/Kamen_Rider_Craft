package com.kelco.kamenridercraft.item.BaseItems;


import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.item.client.RiderArmorRenderer;
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

public class RiderArmorItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private Item RepairItem = Modded_item_core.RIDER_CIRCUIT.get();

    public RiderArmorItem(Holder<ArmorMaterial> armorMaterial, Type type, Properties properties) {
        super(armorMaterial, type, properties.stacksTo(1));

    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private RiderArmorRenderer renderer;

            @Override
            public <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(@Nullable T livingEntity, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable HumanoidModel<T> original) {
               this.renderer = new RiderArmorRenderer(livingEntity, equipmentSlot);

                return this.renderer;
            }
        });
    }

    public RiderArmorItem AddToTabList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        RawAnimation IDLE = RawAnimation.begin().thenLoop("idle");
        RawAnimation WALK = RawAnimation.begin().thenLoop("walk");
        RawAnimation SNEAK = RawAnimation.begin().thenLoop("sneak");

        controllerRegistrar.add(new AnimationController<RiderArmorItem>(this, "Walk/Idle", 20, state -> {
            Entity entity = state.getData(DataTickets.ENTITY);

            Boolean IsWaking = false;
            if (entity instanceof Player player) {

                if(player.getDeltaMovement().x!=0||player.getDeltaMovement().z!=0)IsWaking=true;
            }

            state.setAndContinue(IsWaking ? WALK:IDLE);

            state.setAndContinue(entity.isShiftKeyDown() ? SNEAK:IsWaking ? WALK:IDLE);
            return PlayState.CONTINUE;
        }));

    }

    public RiderArmorItem ChangeRepairItem(Item item) {
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






}