package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.heisei_phase_2.WizardRiderItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.BossEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.damagesource.DamageContainer;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Random;

public class WisemanEntity extends BaseHenchmenEntity {
    private final ServerBossEvent bossEvent = new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(WisemanEntity.class, EntityDataSerializers.BYTE);
    private int timeSinceLastAttack = 0;


    public WisemanEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "wiseman";
        setItemSlot(EquipmentSlot.HEAD, new ItemStack(WizardRiderItems.WIZARD_HEAD.get()));
        setItemSlot(EquipmentSlot.CHEST, new ItemStack(WizardRiderItems.WIZARD_CHESTPLATE.get()));
        setItemSlot(EquipmentSlot.LEGS, new ItemStack(WizardRiderItems.WIZARD_LEGGINGS.get()));
        setItemSlot(EquipmentSlot.FEET, new ItemStack(WizardRiderItems.WHITE_WIZARD_DRIVER.get()));
        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(WizardRiderItems.HAMMELCANE.get()));
    }

    @Override
    public void onDamageTaken(DamageContainer damageContainer) {

        super.onDamageTaken(damageContainer);
    }

    @Override
    public void tick() {
        super.tick();
        if (level() instanceof ServerLevel && getLastAttacker() instanceof Player player && getTarget() == player && getHealth() < 150) {
            Random rand = new Random();
            int attackChance = rand.nextInt(50);
            ++timeSinceLastAttack;

            if (attackChance == 1 && timeSinceLastAttack >= 200) {
                teleport();
                player.displayClientMessage(Component.translatable("message.kamenridercraft.wiseman_teleport"), true);
                timeSinceLastAttack = 0;
            }

            if (attackChance == 3 && timeSinceLastAttack >= 200 && distanceTo(player) < 10) {
                player.addEffect(new MobEffectInstance(EffectCore.EXPLODE, 20, 1, true, true));
                player.displayClientMessage(Component.translatable("message.kamenridercraft.wiseman_explode"), true);
                timeSinceLastAttack = 0;
            } else if (attackChance == 3 && timeSinceLastAttack >= 200) {
                SmallFireball smallfireball = new SmallFireball(level(), this, getDeltaMovement());
                smallfireball.setPos(smallfireball.getX(), getY(0.5) + 0.5, smallfireball.getZ());
                level().addFreshEntity(smallfireball);
                timeSinceLastAttack = 0;
            }
        }
    }

    protected boolean teleport() {
        if (!level().isClientSide() && isAlive()) {
            double d0 = getX() + (random.nextDouble() - (double) 0.5F) * (double) 64.0F;
            double d1 = getY() + (double) (random.nextInt(64) - 32);
            double d2 = getZ() + (random.nextDouble() - (double) 0.5F) * (double) 64.0F;
            return teleport(d0, d1, d2);
        }
        return  false;
    }

    private boolean teleport(double x, double y, double z) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(x, y, z);

        while (blockpos$mutableblockpos.getY() > level().getMinBuildHeight() && !level().getBlockState(blockpos$mutableblockpos).blocksMotion()) {
            blockpos$mutableblockpos.move(Direction.DOWN);
        }

        BlockState blockstate = level().getBlockState(blockpos$mutableblockpos);
        boolean flag = blockstate.blocksMotion();
        boolean flag1 = blockstate.getFluidState().is(FluidTags.WATER);
        if (flag && !flag1) {
            EntityTeleportEvent.EnderEntity event = EventHooks.onEnderTeleport(this, x, y, z);
            if (event.isCanceled()) {
                return false;
            } else {
                Vec3 vec3 = position();
                boolean flag2 = randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
                if (flag2) {
                    level().gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(this));
                    if (!isSilent()) {
                        level().playSound((Player) null, xo, yo, zo, SoundEvents.ENDERMAN_TELEPORT, getSoundSource(), 1.0F, 1.0F);
                        playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                    }
                }
                return flag2;
            }
        } else {
            return false;
        }
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        bossEvent.setProgress(getHealth() / getMaxHealth());
    }

    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_FLAGS_ID, (byte) 0);
    }

    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (hasCustomName()) {
            bossEvent.setName(getDisplayName());
        }
    }

    public void setCustomName(@Nullable Component component) {
        super.setCustomName(component);
        bossEvent.setName(getDisplayName());
    }

    public void startSeenByPlayer(@NotNull ServerPlayer serverPlayer) {
        super.startSeenByPlayer(serverPlayer);
        bossEvent.addPlayer(serverPlayer);
    }

    public void stopSeenByPlayer(@NotNull ServerPlayer serverPlayer) {
        super.stopSeenByPlayer(serverPlayer);
        bossEvent.removePlayer(serverPlayer);
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
