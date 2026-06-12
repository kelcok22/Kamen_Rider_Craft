package com.kelco.kamenridercraft.effects.beneficial;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;


public class GatlingEffect extends InstantenousMobEffect {


    public GatlingEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.level().isClientSide() && livingEntity instanceof Player player) {
            ItemStack stack = livingEntity.getItemBySlot(EquipmentSlot.FEET);
            if (stack.getItem() instanceof RiderDriverItem && stack.has(DataComponents.CUSTOM_DATA)) {
                CompoundTag tag = stack.get(DataComponents.CUSTOM_DATA).getUnsafe();
                if (tag.getDouble("use_ability") != 0 & amplifier != 9) {
                    Arrow arrow = new Arrow(player.level(), player, new ItemStack(Items.ARROW), null);
                    arrow.pickup = AbstractArrow.Pickup.DISALLOWED;
                    arrow.setPos(arrow.getX(), player.getY(0.5) + 0.5, arrow.getZ());
                    arrow.addDeltaMovement(player.getLookAngle().scale(3));
                    player.level().addFreshEntity(arrow);
                }
            }
        }
        return true;
    }
}


