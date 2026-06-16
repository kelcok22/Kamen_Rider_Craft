package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.item.reiwa.ZeroOneRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

import static com.kelco.kamenridercraft.util.MiscUtil.canSpawnBoss;

public class AbaddonEntity extends BaseHenchmenEntity {

    private BaseHenchmenEntity boss;

    public AbaddonEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "abaddon";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ZeroOneRiderItems.ZERO_ONE_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ZeroOneRiderItems.ZERO_ONE_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ZeroOneRiderItems.ZERO_ONE_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ZeroOneRiderItems.SHOT_ABADDO_RISER.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ZeroOneRiderItems.SHOTABADDORISER_GUN.get()));
    }


    public void remove(Entity.RemovalReason p_149847_) {

        if (this.isDeadOrDying()) {
            double chance = this.random.nextDouble();
            int gamerule = this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE);

            if (chance * 100.0 <= gamerule && (this.lastHurtByPlayer != null && canSpawnBoss(this.lastHurtByPlayer) || !(this.getLastAttacker() instanceof Player) && chance * 200.0 <= gamerule)) {
                int bossChoice = this.random.nextInt(2);
                switch (bossChoice) {
                    case 0:
                        boss = MobsCore.ABADDON_COMMANDER.get().create(this.level());
                        if (boss != null && this.getLastAttacker() instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
                            playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.abaddon"));
                        }
                        break;
                    case 1:
                        boss = MobsCore.EDEN.get().create(this.level());
                        if (boss != null && this.getLastAttacker() instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
                            playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.eden"));
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

        if (p_34297_.getRandom().nextInt(2) == 1) {
            this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ZeroOneRiderItems.SLASH_ABADDO_RISER.get()));
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ZeroOneRiderItems.SLASHABADDORISER_SWORD.get()));
        }
        return p_34300_;
    }
}