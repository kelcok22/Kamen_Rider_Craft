package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.entities.MobsCore;

import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CharybdisEntity extends BaseHenchmenEntity {

    public CharybdisEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="charybdis";
    }


	public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
			if (this.random.nextDouble() * 100.0 <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {
                BaseHenchmenEntity boss = MobsCore.CHARYBDIS_HERCULES.get().create(this.level());
				if (boss != null) {
                    if (this.getLastAttacker()instanceof Player playerIn) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.charybdis"));
					boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
					this.level().addFreshEntity(boss);
				}
			}
		}
		super.remove(p_149847_);
	}


}