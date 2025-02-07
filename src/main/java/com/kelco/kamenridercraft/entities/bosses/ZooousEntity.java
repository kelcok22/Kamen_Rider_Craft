package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;
import com.kelco.kamenridercraft.item.Saber_Rider_Items;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ZooousEntity extends BaseHenchmenEntity {
	
	private BaseHenchmenEntity boss;

    public ZooousEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="zooous";
    }

	public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
            if(this.getLastAttacker() instanceof Player playerIn && playerIn.getInventory().countItem(Saber_Rider_Items.TATEGAMI_HYOUJUU_SENKI_WONDER_RIDE_BOOK.get())!=0){
                boss = MobsCore.ZOOOUS_PREDATOR.get().create(this.level());
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
        		.add(Attributes.MOVEMENT_SPEED,(double)0.4F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }
    

}
