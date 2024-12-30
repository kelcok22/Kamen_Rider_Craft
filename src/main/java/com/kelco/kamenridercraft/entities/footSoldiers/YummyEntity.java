package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.entities.MobsCore;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class YummyEntity extends BaseHenchmenEntity {
	
	private BaseHenchmenEntity boss;

    public YummyEntity(EntityType<? extends BaseHenchmenEntity > type, Level level) {
        super(type, level);
        NAME="yummy";
    }


    public void remove(Entity.RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
			if (this.random.nextDouble() * 100.0 <= ServerConfig.bossSpawnRate) {
				int bossChoice = this.random.nextInt(5);
				switch (bossChoice) {
					case 0:
						boss = MobsCore.KAZARI.get().create(this.level());
						break;
					case 1:
						boss = MobsCore.UVA.get().create(this.level());
						break;
					case 2:
						boss = MobsCore.GAMEL.get().create(this.level());
						break;
					case 3:
						boss = MobsCore.MEZOOL.get().create(this.level());
						break;
					case 4:
						boss = MobsCore.ANKH_LOST.get().create(this.level());
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
        		.add(Attributes.MOVEMENT_SPEED,(double)0.23F)
        		.add(Attributes.ATTACK_DAMAGE, 4.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 30.0D);
     }
}