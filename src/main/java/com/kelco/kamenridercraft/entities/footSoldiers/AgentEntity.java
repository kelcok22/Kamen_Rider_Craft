package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.variants.AgentVariant;
import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;
import com.kelco.kamenridercraft.item.Gavv_Rider_Items;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

import static com.kelco.kamenridercraft.entities.variants.AgentVariant.ORANGE_A;
import static com.kelco.kamenridercraft.entities.variants.AgentVariant.ORANGE_B;

public class AgentEntity extends BaseHenchmenEntity {

    private BaseHenchmenEntity boss;

    private static final EntityDataAccessor<Integer> VARIANT =
        SynchedEntityData.defineId(AgentEntity.class, EntityDataSerializers.INT);

    public AgentEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="agent";
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Gavv_Rider_Items.AGENT_BLASTER.get()));
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

    public AgentVariant getVariant() {
        return AgentVariant.byId(this.getTypeVariant() & 255);
    }

    private void setVariant(AgentVariant variant) {
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
        AgentVariant variant = Util.getRandom(AgentVariant.values(), this.random);
        this.setVariant(variant);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    public void remove(Entity.RemovalReason p_149847_) {

        if ( this.isDeadOrDying()) {
            if (this.random.nextDouble() * 100.0 <= ServerConfig.bossSpawnRate) {
                int bossChoice = this.random.nextInt(2);
                switch (bossChoice) {
                    case 0:
                        boss = MobsCore.BITTER_GAVV.get().create(this.level());
                        if (boss != null && this.getLastAttacker()instanceof Player playerIn) {
                            playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.bitter_gavv"));
                        }
                        break;
                    case 1:
                        if (getVariant() == ORANGE_A) {
                            boss = MobsCore.NYELV_STOMACH.get().create(this.level());
                            if (boss != null && this.getLastAttacker()instanceof Player playerIn) {
                                playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.nyelv"));
                        }}
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
}