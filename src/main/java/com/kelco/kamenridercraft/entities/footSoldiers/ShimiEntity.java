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

public class ShimiEntity extends BaseHenchmenEntity {
	
	private BaseHenchmenEntity boss;
	
    public ShimiEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="shimi";
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Saber_Rider_Items.SHIMI_LOT.get()));
    }


	public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
			if (this.random.nextDouble() * 100.0 <= ServerConfig.bossSpawnRate) {
				int bossChoice = this.random.nextInt(5);
				switch (bossChoice) {
					case 0:
						boss = MobsCore.CALIBUR.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.calibur"));
						}
						break;
					case 1:
						boss = MobsCore.LEGEIEL.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.legeiel"));
						}
						break;
					case 2:
						boss = MobsCore.ZOOOUS.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.zooous"));
						}
						break;
					case 3:
						boss = MobsCore.STORIOUS.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.storious"));
						}
						break;
					case 4:
						boss = MobsCore.DESAST.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.desast"));
						}
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


}