package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.entities.MobsCore;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class GhoulsEntity extends BaseHenchmenEntity {

    public GhoulsEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="ghouls";
    }

    public void remove(Entity.RemovalReason removalReason) {

        if ( this.isDeadOrDying()) {
			int bossChance = this.random.nextInt(30);
			switch (bossChance) {
				case 0:
                    BaseHenchmenEntity boss = MobsCore.GREMLIN_PHANTOM.get().create(this.level());
                    if (boss != null) {
                        boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        this.level().addFreshEntity(boss);
                    }
					break;
				case 1:
                    BaseHenchmenEntity boss2 = MobsCore.MEDUSA_PHANTOM.get().create(this.level());
                    if (boss2 != null) {
                        boss2.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        this.level().addFreshEntity(boss2);
                    }
					break;
                case 2:
                    BaseHenchmenEntity boss3 = MobsCore.PHOENIX_PHANTOM.get().create(this.level());
                    if (boss3 != null) {
                        boss3.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        this.level().addFreshEntity(boss3);
                    }
					break;
				default:
			}
        }
        super.remove(removalReason);
    }
}