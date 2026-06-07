package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.time.LocalDate;

import static com.kelco.kamenridercraft.util.MiscUtil.canSpawnBoss;

public class GODWarfareAgentEntity extends BaseHenchmenEntity {

    public GODWarfareAgentEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "god_warfare_agents";
    }

    public void remove(RemovalReason reason) {
        if (reason == RemovalReason.KILLED) {
            double chance = this.random.nextDouble();
            int gamerule = this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE);

            if (chance * 100.0 <= gamerule && (this.lastHurtByPlayer != null && canSpawnBoss(this.lastHurtByPlayer) || !(this.getLastAttacker() instanceof Player) && chance * 200.0 <= gamerule)) {
                BaseHenchmenEntity boss = MobsCore.APOLLOGIST.get().create(this.level());
                if (boss != null) {
                    boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    this.level().addFreshEntity(boss);

                    if (this.getLastAttacker() instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
                        LocalDate localdate = LocalDate.now();
                        playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.apollogeist"));
                    }
                }
            }
        }
        super.remove(reason);
    }
}