package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.reiwa.SaberRiderItems;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ZooousEntity extends BaseHenchmenEntity {

    public ZooousEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="zooous";
    }

	public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying() && this.getLastAttacker() instanceof Player playerIn) {
            if (playerIn.getInventory().countItem(SaberRiderItems.TATEGAMI_HYOUJUU_SENKI_WONDER_RIDE_BOOK.get())!=0){
                BaseHenchmenEntity boss = MobsCore.ZOOOUS_PREDATOR.get().create(this.level());
                if (boss != null) {
                    boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    this.level().addFreshEntity(boss);
                }
            }
            if (playerIn.getInventory().countItem(SaberRiderItems.TENKUU_NO_PEGASUS_WONDER_RIDE_BOOK.get())!=0
            &&playerIn.getInventory().countItem(SaberRiderItems.LION_SENKI_WONDER_RIDE_BOOK.get())!=0
            &&playerIn.getInventory().countItem(SaberRiderItems.PETER_FANTASISTA_WONDER_RIDE_BOOK.get())!=0){
                ItemEntity key = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(SaberRiderItems.KING_LION_DAISENKI_WONDER_RIDE_BOOK.get(), 1), 0, 0, 0);
			    key.setPickUpDelay(0);
			    playerIn.level().addFreshEntity(key);
		        playerIn.sendSystemMessage(Component.translatable("loot.kamenridercraft.king_lion_daisenki"));
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
