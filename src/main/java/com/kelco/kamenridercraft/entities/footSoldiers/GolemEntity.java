package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class GolemEntity extends BaseHenchmenEntity {

    private BaseHenchmenEntity boss;

    public GolemEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="golem";
    }


	public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
			if (this.random.nextDouble() * 100.0 <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {
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