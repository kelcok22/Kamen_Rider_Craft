package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.item.heisei_phase_1.KabutoRiderItems;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class ZectrooperEntity extends BaseHenchmenEntity {


    public ZectrooperEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "zectrooper";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KabutoRiderItems.KABUTOHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KabutoRiderItems.KABUTOCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(KabutoRiderItems.KABUTOLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(KabutoRiderItems.ZECTROOPER_BELT.get()));
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34297_, DifficultyInstance p_34298_, MobSpawnType p_34299_, @Nullable SpawnGroupData p_34300_) {
        p_34300_ = super.finalizeSpawn(p_34297_, p_34298_, p_34299_, p_34300_);

        switch (p_34297_.getRandom().nextInt(7)) {
            case 0:
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(KabutoRiderItems.MACHINEGUN_BLADE.get()));
                this.setMeleeOnSpawn(100.0D);
                break;
            case 1:
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(KabutoRiderItems.POWER_ARM_UNIT.get()));
                break;
            case 2:
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(KabutoRiderItems.MACHINEGUN_BLADE.get()));
                break;
            case 3:

                break;
        }
        return p_34300_;
    }
}