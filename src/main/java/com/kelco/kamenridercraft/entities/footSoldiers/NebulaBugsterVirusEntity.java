package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NebulaBugsterVirusEntity extends BugsterVirusEntity {

	private BaseHenchmenEntity boss;

	public NebulaBugsterVirusEntity(EntityType<? extends BugsterVirusEntity> type, Level level) {
		super(type, level);
		NAME="nebulabugstervirus";
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Ex_Aid_Rider_Items.BUGSTER_TRIDENT.get()));
	}


	public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
            double num = 100.0;
            if (this.getLastAttacker()instanceof Player playerIn){
                if(playerIn.hasEffect(Effect_core.HAZARD_LEVEL)){
                    num=100-((playerIn.getEffect(Effect_core.HAZARD_LEVEL).getAmplifier()+1)*10);
                }
            }
            if (this.random.nextDouble() * num  <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {
				ResourceKey<Level> MOON = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:city"));
				int bossChoice = 0;
				if (this.level().dimension() == MOON)bossChoice=1;
				switch (bossChoice) {
					case 0:
						boss = MobsCore.KAISER.get().create(this.level());
						if (boss != null) {
							if (this.getLastAttacker()instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
								playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.kaiser"));
							}
						}
						break;
					case 1:
						boss = MobsCore.KAISER_REVERSE.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.kaiser_reverse"));
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