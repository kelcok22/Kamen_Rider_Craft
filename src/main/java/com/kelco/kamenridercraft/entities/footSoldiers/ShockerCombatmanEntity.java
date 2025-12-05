package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Ghost_Rider_Items;
import com.kelco.kamenridercraft.item.Ichigo_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.level.ModGameRules;
import com.kelco.kamenridercraft.world.damagesource.RiderDamageTypes;
import net.minecraft.network.chat.Component;

import com.kelco.kamenridercraft.entities.MobsCore;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ShockerCombatmanEntity extends BaseHenchmenEntity {


	public ShockerCombatmanEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
		super(type, level);
		NAME="shocker_combatman";

	}

	public void remove(RemovalReason reason) {
		if (reason == RemovalReason.KILLED) {
            if (this.getLastAttacker()instanceof Player playerIn){
                if(!this.level().isClientSide() && playerIn.getItemBySlot(EquipmentSlot.FEET).getItem()== Ichigo_Rider_Items.TYPHOON_ICHIGO.get()&this.getLastDamageSource().is(RiderDamageTypes.RIDER_KICK)){
                    ItemEntity key = new ItemEntity(level(), getX(), getY(), getZ(), new ItemStack(Modded_item_core.LETS_GO_RIDER_MUSIC_DISC.get(), 1), 0, 0, 0);
                    key.setPickUpDelay(0);
                    level().addFreshEntity(key);
                }
}
                if (this.random.nextDouble() * 100.0 <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {
				BaseHenchmenEntity boss = MobsCore.SHOCKER_RIDER.get().create(this.level());
				if (boss != null) {
					boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
					this.level().addFreshEntity(boss);

                    if (this.getLastAttacker()instanceof Player playerIn){
                      if ( this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.shocker_rider"));
				}
                }
			}
		}
		super.remove(reason);
	}
}