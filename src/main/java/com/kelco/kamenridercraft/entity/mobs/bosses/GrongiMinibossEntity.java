package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.heisei_phase_1.KuugaRiderItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GrongiMinibossEntity extends BaseHenchmenEntity {
    public GrongiMinibossEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "grongi";
        setItemSlot(EquipmentSlot.HEAD, new ItemStack(KuugaRiderItems.KUUGAHELMET.get()));
        setItemSlot(EquipmentSlot.CHEST, new ItemStack(KuugaRiderItems.KUUGACHESTPLATE.get()));
        setItemSlot(EquipmentSlot.LEGS, new ItemStack(KuugaRiderItems.KUUGALEGGINGS.get()));
        setItemSlot(EquipmentSlot.LEGS, new ItemStack(KuugaRiderItems.GRONGI_BELT.get()));
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.ATTACK_DAMAGE, 7.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 45.0D);
    }
}