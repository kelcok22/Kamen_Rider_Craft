package com.kelco.kamenridercraft.entity.mobs.bosses;


import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.heisei_phase_1.Kiva_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MooseFangireEntity extends BaseHenchmenEntity {



    public MooseFangireEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="moose_fangire";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Kiva_Rider_Items.KIVAHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Kiva_Rider_Items.KIVACHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Kiva_Rider_Items.KIVALEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Kiva_Rider_Items.MOOSE_FANGIRE_BELT.get()));
    }


    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2F)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.ARMOR, 0.0D)
                .add(Attributes.MAX_HEALTH, 10.0D);
    }
}