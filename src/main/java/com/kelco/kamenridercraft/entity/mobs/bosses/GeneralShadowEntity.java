package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.showa.StrongerRiderItems;
import com.kelco.kamenridercraft.item.showa.XRiderItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GeneralShadowEntity extends BaseHenchmenEntity {
    public GeneralShadowEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="general_shadow";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(StrongerRiderItems.STRONGERHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(StrongerRiderItems.STRONGERCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(StrongerRiderItems.STRONGERLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(StrongerRiderItems.GENERAL_SHADOW_BELT.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(StrongerRiderItems.SHADOW_SWORD.get()));
    }


        public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED,0.23F)
                .add(Attributes.ATTACK_DAMAGE, 6.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 45.0D);
    }
}