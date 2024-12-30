package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.entities.MobsCore;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class GhoulsEntity extends BaseHenchmenEntity {
	
	private BaseHenchmenEntity boss;

    public GhoulsEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="ghouls";
    }

    public void remove(Entity.RemovalReason removalReason) {

        if ( this.isDeadOrDying()) {
			if (this.random.nextDouble() * 100.0 <= ServerConfig.bossSpawnRate) {
				int bossChoice = this.random.nextInt(3);
				switch (bossChoice) {
			    	case 0:
                        boss = MobsCore.GREMLIN_PHANTOM.get().create(this.level());
			    		break;
			    	case 1:
                        boss = MobsCore.MEDUSA_PHANTOM.get().create(this.level());
			    		break;
                    case 2:
                        boss = MobsCore.PHOENIX_PHANTOM.get().create(this.level());
			    		break;
			    	default:
			    }
				if (boss != null) {
					boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
					this.level().addFreshEntity(boss);
				}
			}
        }
        super.remove(removalReason);
    }
}