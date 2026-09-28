package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.GhostRiderItems;
import com.kelco.kamenridercraft.item.reiwa.ZeztzRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

import static com.kelco.kamenridercraft.util.MiscUtil.canSpawnBoss;

public class NightmareEntity extends BaseHenchmenEntity {

    public NightmareEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "nightmare";
        setItemSlot(EquipmentSlot.HEAD, new ItemStack(ZeztzRiderItems.ZEZTZ_HELMET.get()));
        setItemSlot(EquipmentSlot.CHEST, new ItemStack(ZeztzRiderItems.ZEZTZ_CHESTPLATE.get()));
        setItemSlot(EquipmentSlot.LEGS, new ItemStack(ZeztzRiderItems.ZEZTZ_LEGGINGS.get()));
        setItemSlot(EquipmentSlot.FEET, new ItemStack(ZeztzRiderItems.GUN_NIGHTMARE_BELT.get()));
        RiderDriverItem.setUpdateForm(getItemBySlot(EquipmentSlot.FEET));
    }

    public void remove(RemovalReason p_149847_) {
        if (isDeadOrDying()) {
            ((ServerLevel) level()).sendParticles(ModParticles.BUTTERFLY_PARTICLES.get(), getX(), getY() + 1, getZ(), 10, 0, 0, 0, 1);

            double chance = random.nextDouble();
            int gamerule = level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE);

            if (chance * 100.0 <= gamerule && (lastHurtByPlayer != null && canSpawnBoss(lastHurtByPlayer) || !(getLastAttacker() instanceof Player) && chance * 200.0 <= gamerule)) {
                BaseHenchmenEntity boss = MobsCore.DAWN.get().create(level());
                if (boss != null && getLastAttacker() instanceof Player playerIn && level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) {
                    playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.dawn"));
                    if (boss != null) {
                        boss.moveTo(getX(), getY(), getZ(), getYRot(), 0.0F);
                        level().addFreshEntity(boss);
                    }
                }
            }
        }
        super.remove(p_149847_);
    }

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 35.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.23F)
                .add(Attributes.ATTACK_DAMAGE, 8.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34297_, DifficultyInstance p_34298_, MobSpawnType p_34299_, @Nullable SpawnGroupData p_34300_) {
        p_34300_ = super.finalizeSpawn(p_34297_, p_34298_, p_34299_, p_34300_);

        if (p_34297_.getRandom().nextInt(3) == 1) {
            setItemSlot(EquipmentSlot.FEET, new ItemStack(ZeztzRiderItems.WOLF_NIGHTMARE_BELT.get()));
        } else if (p_34297_.getRandom().nextInt(3) == 2) {
            setItemSlot(EquipmentSlot.FEET, new ItemStack(ZeztzRiderItems.CAT_NIGHTMARE_BELT.get()));
        }
        return p_34300_;
    }
}