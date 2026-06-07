package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;


import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import static com.kelco.kamenridercraft.util.MiscUtil.canSpawnBoss;

public class PantherasLuteusEntity extends BaseHenchmenEntity {

    public PantherasLuteusEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "pantheras_luteus";
    }


    public void remove(RemovalReason p_149847_) {

        if (this.isDeadOrDying()) {
            double chance = this.random.nextDouble();
            int gamerule = this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE);

            if (chance * 100.0 <= gamerule && (this.lastHurtByPlayer != null && canSpawnBoss(this.lastHurtByPlayer) || !(this.getLastAttacker() instanceof Player) && chance * 200.0 <= gamerule)) {
                BaseHenchmenEntity boss = MobsCore.EL_OF_THE_WATER.get().create(this.level());
                if (boss != null) {
                    boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    this.level().addFreshEntity(boss);
                }
            }
        }
        super.remove(p_149847_);
    }
}