package com.kelco.kamenridercraft.entities.bosses;


import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Gavv_Rider_Items;
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

public class ShiitaEntity extends BaseHenchmenEntity {



    public ShiitaEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="shiita_stomach";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Gavv_Rider_Items.GAVV_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Gavv_Rider_Items.GAVV_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Gavv_Rider_Items.GAVV_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Gavv_Rider_Items.SHIITA_MIMICDEVISER.get()));
     //   this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Gavv_Rider_Items.GLOTTA_SCYTHE.get()));
    }
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {

        BaseHenchmenEntity boss = MobsCore.JEEB_STOMACH.get().create(this.level());
        if (boss != null) {
            boss.moveTo(this.getX(), this.getY(), this.getZ()-1, this.getYRot(), 0.0F);
            this.level().addFreshEntity(boss);
        }
        spawnGroupData =  super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
        return spawnGroupData;
    }

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 200.0D);
    }


}