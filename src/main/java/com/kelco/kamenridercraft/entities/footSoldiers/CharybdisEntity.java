package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.Saber_Rider_Items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CharybdisEntity extends BaseHenchmenEntity {
	
	private BaseHenchmenEntity boss;
	
    public CharybdisEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="charybdis";
    }


	public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
			if (this.random.nextDouble() * 100.0 <= ServerConfig.bossSpawnRate) {
				boss = MobsCore.CHARYBDIS_HERCULES.get().create(this.level());
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