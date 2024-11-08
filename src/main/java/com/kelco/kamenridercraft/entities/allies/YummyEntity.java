package com.kelco.kamenridercraft.entities.allies;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;

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
	
    public YummyEntity(EntityType<? extends BaseHenchmenEntity > type, Level level) {
        super(type, level);
        NAME="yummy";
    }


    public void remove(Entity.RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
			int bossChance = this.random.nextInt(50);
			switch (bossChance) {
				case 0:
					BaseHenchmenEntity boss = MobsCore.KAZARI.get().create(this.level());
					if (boss != null) {
						boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss);
					}
					break;
				case 1:
					BaseHenchmenEntity boss2 = MobsCore.UVA.get().create(this.level());
					if (boss2 != null) {
						boss2.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss2);
					}
					break;
				case 2:
					BaseHenchmenEntity boss3 = MobsCore.GAMEL.get().create(this.level());
					if (boss3 != null) {
						boss3.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss3);
					}
					break;
				case 3:
					BaseHenchmenEntity boss4 = MobsCore.MEZOOL.get().create(this.level());
					if (boss4 != null) {
						boss4.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss4);
					}
					break;
				case 4:
					BaseHenchmenEntity boss5 = MobsCore.ANKH_LOST.get().create(this.level());
					if (boss5 != null) {
						boss5.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss5);
					}
					break;
				default:
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