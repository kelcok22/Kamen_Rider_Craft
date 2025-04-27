package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.variants.ReaperVariant;
import com.kelco.kamenridercraft.entities.variants.RoidmudeVariant;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class ReaperlegionEntity extends BaseHenchmenEntity {

    private BaseHenchmenEntity boss;

    private static final EntityDataAccessor<Integer> VARIANT =
        SynchedEntityData.defineId(ReaperlegionEntity.class, EntityDataSerializers.INT);

    public ReaperlegionEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="reaper_legion";
    }

    public void remove(RemovalReason p_149847_) {

        if ( this.isDeadOrDying()) {
            if (this.random.nextDouble() * 100.0 <= ServerConfig.bossSpawnRate) {
                int bossChoice = this.random.nextInt(3);
                switch (bossChoice) {
                    case 0:
                        boss = MobsCore.MEDIC_ROIDMUDE.get().create(this.level());
                        if (boss != null && this.getLastAttacker()instanceof Player playerIn) {
                            playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.medic_roidmude"));
                        }
                        break;
                    default:
                }
                if (boss != null) {
                    boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    this.level().addFreshEntity(boss);
                }
            }
        }
        super.remove(p_149847_);
    }

    //variants below

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT,0);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public ReaperVariant getVariant() {
        return ReaperVariant.byId(this.getTypeVariant() & 255);
    }

    private void setVariant(ReaperVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(VARIANT, compound.getInt("Variant"));
    }


    protected void defineSynchedData() {

    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty,
                                        MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        ReaperVariant variant = Util.getRandom(ReaperVariant.values(), this.random);
        this.setVariant(variant);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }
}