package com.kelco.kamenridercraft.item.base_items;


import com.kelco.kamenridercraft.effects.EffectCore;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MaskItem extends BaseItem implements Equipable {

    public MaskItem(Properties prop) {
        super(prop);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);
        if (slotId == 39 && this.toString().equals("kamenridercraft:ichigo_mask") && ((LivingEntity) entity).hasEffect(EffectCore.KNOCKBACK_BOOST) && level instanceof  ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.RAIN, entity.getX(), entity.getEyeY(), entity.getZ(), 1, 0, 0, 0, 0.05);

        }
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}