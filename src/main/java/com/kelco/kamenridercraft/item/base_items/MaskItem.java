package com.kelco.kamenridercraft.item.base_items;


import com.kelco.kamenridercraft.effects.effect_core.EffectCore;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static net.minecraft.core.Direction.Axis.X;
import static net.minecraft.core.Direction.Axis.Z;

public class MaskItem extends BaseItem implements Equipable {

    public MaskItem(Properties prop) {
        super(prop);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);
        if (slotId == 39 && this.toString().equals("kamenridercraft:ichigo_mask") && level instanceof ServerLevel serverLevel && ((LivingEntity) entity).hasEffect(EffectCore.RIDER_SPIRIT)) {
            serverLevel.sendParticles(ParticleTypes.RAIN, entity.getX() + (entity.getLookAngle().get(X) * 0.2), entity.getEyeY() + 0.15, entity.getZ() + (entity.getLookAngle().get(Z) * 0.2), 2,0, 0,0, 0.05);

        }
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}