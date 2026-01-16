package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Ichigo_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ApollogeistEntity extends BaseHenchmenEntity {
    public ApollogeistEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="apollogeist";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Ichigo_Rider_Items.XHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Ichigo_Rider_Items.XCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Ichigo_Rider_Items.XLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ichigo_Rider_Items.APOLLOGIST_BELT.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Ichigo_Rider_Items.APOLLO_SHOT.get()));
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Ichigo_Rider_Items.GEIST_CUTTER.get()));
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