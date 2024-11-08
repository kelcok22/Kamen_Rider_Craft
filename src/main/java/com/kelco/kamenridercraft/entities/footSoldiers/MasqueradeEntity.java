package com.kelco.kamenridercraft.entities.footSoldiers;

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

public class MasqueradeEntity extends BaseHenchmenEntity {
	
    public MasqueradeEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="masquerade";
    }


    public void remove(Entity.RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
			int bossChance = this.random.nextInt(40);
			switch (bossChance) {
				case 0:
					BaseHenchmenEntity boss = MobsCore.NASCA_DOPANT.get().create(this.level());
					if (boss != null) {
						boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss);

						if (this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("Nasca!").withStyle(ChatFormatting.BLUE));
						}
					}
					break;
				case 1:
					BaseHenchmenEntity boss2 = MobsCore.CLAYDOLL_DOPANT.get().create(this.level());
					if (boss2 != null) {
						boss2.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss2);

						if (this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("Claydoll!").withStyle(ChatFormatting.GOLD));
						}
					}
					break;
				case 2:
					BaseHenchmenEntity boss3 = MobsCore.SMILODON_DOPANT.get().create(this.level());
					if (boss3 != null) {
						boss3.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss3);

						if (this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("Smilodon!").withStyle(ChatFormatting.GOLD));
						}
					}
					break;
				case 3:
					BaseHenchmenEntity boss4 = MobsCore.WEATHER_DOPANT.get().create(this.level());
					if (boss4 != null) {
						boss4.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss4);

						if (this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("Weather!").withStyle(ChatFormatting.GRAY));
						}
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
        		.add(Attributes.MAX_HEALTH, 30.0D)
        		.add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
     }
}