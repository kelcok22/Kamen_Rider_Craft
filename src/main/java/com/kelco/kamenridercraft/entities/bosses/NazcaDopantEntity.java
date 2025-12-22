package com.kelco.kamenridercraft.entities.bosses;


import com.kelco.kamenridercraft.entities.ai.FlyingBossControl;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.W_Rider_Items;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NazcaDopantEntity extends BaseHenchmenEntity {


	
    public NazcaDopantEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="nazca_dopant";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(W_Rider_Items.WHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(W_Rider_Items.WCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(W_Rider_Items.WLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(W_Rider_Items.GAIA_DRIVER_NASCA.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(W_Rider_Items.NASCA_BLADE.get()));
        this.moveControl = new FlyingBossControl(this, 20);
    }


    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 35.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.2F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 4.0D)
        		.add(Attributes.MAX_HEALTH, 110.0D)
                .add(Attributes.FLYING_SPEED, 0.2F);
     }
}