package com.kelco.kamenridercraft.entity.mobs.bosses;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.GaimRiderItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class RosyuoEntity extends BaseHenchmenEntity {
    private final ServerBossEvent bossEvent = new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(RosyuoEntity.class, EntityDataSerializers.BYTE);


    public RosyuoEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "rosyuo";
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GaimRiderItems.JOESHUIMU.get()));
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_FLAGS_ID, (byte) 0);
    }

    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
    }

    public void setCustomName(@Nullable Component component) {
        super.setCustomName(component);
        this.bossEvent.setName(this.getDisplayName());
    }

    public void startSeenByPlayer(ServerPlayer serverPlayer) {
        super.startSeenByPlayer(serverPlayer);
        this.bossEvent.addPlayer(serverPlayer);
    }

    public void stopSeenByPlayer(ServerPlayer serverPlayer) {
        super.stopSeenByPlayer(serverPlayer);
        this.bossEvent.removePlayer(serverPlayer);
    }

    public void remove(RemovalReason removalReason) {
        if (this.isDeadOrDying()) {
            ItemStack attackerBelt;
            if (!this.level().isClientSide() && this.getLastAttacker() != null && this.getLastAttacker().getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem) {
                attackerBelt = this.getLastAttacker().getItemBySlot(EquipmentSlot.FEET);
                if (RiderDriverItem.getFormItem(attackerBelt, 1).is(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/lockseeds/kachidoki")))) {
                    ItemEntity kiwamiLockseed = new ItemEntity(level(), getX(), getY(), getZ(), new ItemStack(GaimRiderItems.KIWAMI_LOCKSEED.get(), 1), 0, 0, 0);
                    kiwamiLockseed.setPickUpDelay(0);
                    level().addFreshEntity(kiwamiLockseed);
                    if (this.getLastAttacker() != null) {
                    }
                }
            }
        }
        super.remove(removalReason);
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.ATTACK_DAMAGE, 2D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.SCALE, 1.3D)
                .add(Attributes.MAX_HEALTH, 250.0D);
    }
}

