package com.kelco.kamenridercraft.entities.footSoldiers;


import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class PantherasLuteusEntity extends BaseHenchmenEntity {
	
    public PantherasLuteusEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="pantheras_luteus";
    }


    public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
			if (this.random.nextDouble() * 100.0 <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {
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