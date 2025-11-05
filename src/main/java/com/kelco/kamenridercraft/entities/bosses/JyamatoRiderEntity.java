package com.kelco.kamenridercraft.entities.bosses;


import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Geats_Rider_Items;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class JyamatoRiderEntity extends BaseHenchmenEntity {


	
    public JyamatoRiderEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="pawnjyamato_mob";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Geats_Rider_Items.GEATS_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Geats_Rider_Items.GEATS_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Geats_Rider_Items.GEATS_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Geats_Rider_Items.DESIRE_DRIVER_JYAMATO.get()));

        if (this.random.nextInt(4)==0) {
            NAME="gm_rider";
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Geats_Rider_Items.JYAMATO_RIDER_SCYTHE.get()));
        }

    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34297_, DifficultyInstance p_34298_, MobSpawnType p_34299_, @Nullable SpawnGroupData p_34300_) {
        p_34300_ = super.finalizeSpawn(p_34297_, p_34298_, p_34299_, p_34300_);

        switch (p_34297_.getRandom().nextInt(10)) {
            case 0:
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.MAGNUM_RAISE_BUCKLE_FEVER.get(), 2);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Geats_Rider_Items.MAGNUM_SHOOTER_40X.get()));
                break;
            case 1:
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.BOOST_RAISE_BUCKLE_FEVER.get(), 2);
                break;
            case 2:
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.MONSTER_RAISE_BUCKLE_FEVER.get(), 2);
                break;
        }
        return p_34300_;
    }

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 35.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.2F)
        		.add(Attributes.ATTACK_DAMAGE, 1.0D)
        		.add(Attributes.ARMOR, 4.0D)
        		.add(Attributes.MAX_HEALTH, 60.0D);
     }
}