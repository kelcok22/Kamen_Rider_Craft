package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.variants.MakamouNinjaGroupVariant;
import com.kelco.kamenridercraft.item.Hibiki_Rider_Items;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

import static com.kelco.kamenridercraft.entities.variants.MakamouNinjaGroupVariant.*;

public class MakamouNinjaGroupEntity extends BaseHenchmenEntity {

    private BaseHenchmenEntity boss;

    private static final EntityDataAccessor<Integer> VARIANT =
        SynchedEntityData.defineId(MakamouNinjaGroupEntity.class, EntityDataSerializers.INT);

    public MakamouNinjaGroupEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="byakko";
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Hibiki_Rider_Items.MAKAMOU_NINJA_SICKLE.get()));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT,0);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public MakamouNinjaGroupVariant getVariant() {
        return MakamouNinjaGroupVariant.byId(this.getTypeVariant() & 255);
    }

    private void setVariant(MakamouNinjaGroupVariant variant) {
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


    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty,
                                        MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        MakamouNinjaGroupVariant variant = Util.getRandom(MakamouNinjaGroupVariant.values(), this.random);
        this.setVariant(variant);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    public void remove(RemovalReason p_149847_) {
        if (this.isDeadOrDying() && this.random.nextDouble() * 100.0 <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {
            boss = MobsCore.KABUKI.get().create(this.level());
            if (boss != null) {
                if (this.getLastAttacker() instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
                    playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.kabuki"));
                }
                boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                this.level().addFreshEntity(boss);
            }
        }
        super.remove(p_149847_);
    }
}