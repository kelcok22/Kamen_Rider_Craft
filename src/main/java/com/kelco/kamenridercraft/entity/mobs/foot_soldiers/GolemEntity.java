package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import static com.kelco.kamenridercraft.util.MiscUtil.canSpawnBoss;

public class GolemEntity extends BaseHenchmenEntity {

    private BaseHenchmenEntity boss;

    public GolemEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "golem";
    }


    public void remove(RemovalReason p_149847_) {

        if (this.isDeadOrDying()) {
            double chance = this.random.nextDouble();
            int gamerule = this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE);

            if (chance * 100.0 <= gamerule && (this.lastHurtByPlayer != null && canSpawnBoss(this.lastHurtByPlayer) || !(this.getLastAttacker() instanceof Player) && chance * 200.0 <= gamerule)) {
                int bossChoice = this.random.nextInt(3);
                switch (bossChoice) {
                    case 0:
                        boss = MobsCore.GIGIST.get().create(this.level());
                        break;
                    case 1:
                        boss = MobsCore.GERMAIN.get().create(this.level());
                        break;
                    case 2:
                        boss = MobsCore.GAELIJAH.get().create(this.level());
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