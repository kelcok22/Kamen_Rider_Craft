package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.block.RiderBlocks;
import com.kelco.kamenridercraft.entity.ai.FlyingBossControl;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.extra_riders.CrossSeriesRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_1.FaizRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

import static com.kelco.kamenridercraft.item.base_items.RiderDriverItem.setFormItem;
import static com.kelco.kamenridercraft.util.MiscUtil.canSpawnBoss;

public class RiotrooperEntity extends BaseHenchmenEntity {

    private BaseHenchmenEntity boss;

    public RiotrooperEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "riotrooper";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(FaizRiderItems.FAIZHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(FaizRiderItems.FAIZCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(FaizRiderItems.FAIZLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(FaizRiderItems.SMARTBUCKLE.get()));
    }

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        if (!this.level().isClientSide() && source.getEntity() instanceof Player playerIn
                && playerIn.getInventory().countItem(CrossSeriesRiderItems.KUUGA_AMAZING_MIGHTY_ARTIST.get()) > 0
                && !this.getItemBySlot(EquipmentSlot.FEET).is(FaizRiderItems.SMARTBUCKLE_V2.get())) {
            List<LivingEntity> nearbyAllies = this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(8), entity ->
                    (entity instanceof RiotrooperEntity));
            for (LivingEntity ally : nearbyAllies)
                ally.setItemSlot(EquipmentSlot.FEET, new ItemStack(FaizRiderItems.SMARTBUCKLE_V2.get()));
        }
        super.actuallyHurt(source, amount);
    }


    public void remove(RemovalReason p_149847_) {

        if (this.isDeadOrDying()) {
            if (this.level() instanceof ServerLevel serverlevel) {
                BlockParticleOption sand = new BlockParticleOption(ParticleTypes.BLOCK, RiderBlocks.IMAGIN_SAND_BLOCK.get().defaultBlockState());
                serverlevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.getX(), this.getY(), this.getZ(), 20, 0, 0, 0, 0.05);
                serverlevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.getX(), this.getY() + 1, this.getZ(), 20, 0, 0, 0, 0.05);
                serverlevel.sendParticles(sand, this.getX(), this.getY(), this.getZ(), 30, 0, 0, 0, 0.05);
                serverlevel.sendParticles(sand, this.getX(), this.getY() + 1, this.getZ(), 30, 0, 0, 0, 0.05);
            }
            double chance = this.random.nextDouble();
            int gamerule = this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE);

            if (chance * 100.0 <= gamerule && (this.lastHurtByPlayer != null && canSpawnBoss(this.lastHurtByPlayer) || !(this.getLastAttacker() instanceof Player) && chance * 200.0 <= gamerule)) {
                int bossChoice = this.random.nextInt(2);
                switch (bossChoice) {
                    case 0:
                        boss = MobsCore.ORGA.get().create(this.level());
                        if (boss != null && this.getLastAttacker() instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) {
                            playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.horse_orphnoch"));
                        }
                        break;
                    case 1:
                        boss = MobsCore.MUEZ.get().create(this.level());
                        if (boss != null && this.getLastAttacker() instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) {
                            playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.muez"));
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

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34297_, DifficultyInstance p_34298_, MobSpawnType p_34299_, @Nullable SpawnGroupData p_34300_) {
        p_34300_ = super.finalizeSpawn(p_34297_, p_34298_, p_34299_, p_34300_);

        switch (p_34297_.getRandom().nextInt(7)) {
            case 0, 1:
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(FaizRiderItems.AXEL_RAY_GUN.get()));
                this.setMeleeOnSpawn(100.0D);
                break;
            case 2:
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(FaizRiderItems.AXEL_RAY_GUN.get()));
                break;
            case 3:
                if (this.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem) {
                    RiderDriverItem.setUpdateForm(this.getItemBySlot(EquipmentSlot.FEET));
                    setFormItem(this.getItemBySlot(EquipmentSlot.FEET), FaizRiderItems.FLYING_ATTACKER_RIOTROOPER.get(), 1);
                    Objects.requireNonNull(this.getAttribute(Attributes.FLYING_SPEED)).setBaseValue(0.5);
                    this.moveControl = new FlyingBossControl(this, 20);
                }
                break;
        }
        return p_34300_;
    }

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
                .add(Attributes.FLYING_SPEED, 0.0F)
                .add(Attributes.FOLLOW_RANGE, 35.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.23F)
                .add(Attributes.ATTACK_DAMAGE, 4.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 45.0D);
    }
}