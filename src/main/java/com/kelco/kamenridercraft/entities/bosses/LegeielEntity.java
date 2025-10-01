package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Saber_Rider_Items;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class LegeielEntity extends BaseHenchmenEntity {

    public LegeielEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="legeiel";
    }

	public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
            if(this.getLastAttacker() instanceof Player playerIn && playerIn.getInventory().countItem(Saber_Rider_Items.PRIMITIVE_DRAGON_WONDER_RIDE_BOOK.get())!=0){
                BaseHenchmenEntity boss = MobsCore.LEGEIEL_FORBIDDEN.get().create(this.level());
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
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.4F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }
    

}
