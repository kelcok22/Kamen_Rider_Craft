package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.item.heisei_phase_1.BladeRiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class UndeadEntity extends BaseHenchmenEntity {
    public UndeadEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "undead";
        getAttribute(Attributes.REINFORCEMENT_CHANCE).setBaseValue(12D);
        setItemSlot(EquipmentSlot.HEAD, new ItemStack(BladeRiderItems.BLADEHELMET.get()));
        setItemSlot(EquipmentSlot.CHEST, new ItemStack(BladeRiderItems.BLADECHESTPLATE.get()));
        setItemSlot(EquipmentSlot.LEGS, new ItemStack(BladeRiderItems.BLADELEGGINGS.get()));
        setItemSlot(EquipmentSlot.FEET, new ItemStack(BladeRiderItems.UNDEAD_BUCKLE.get()));
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
                .add(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE, 35.0D)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED, 0.23F)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE, 4.0D)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR, -17.0D)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH, 45.0D);
    }


//    public void remove(RemovalReason removalReason) {
//        if (removalReason == RemovalReason.KILLED) {
//        super.remove(removalReason);
//    }
}