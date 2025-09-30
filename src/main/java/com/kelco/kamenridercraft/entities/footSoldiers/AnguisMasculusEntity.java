package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.Agito_Rider_Items;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AnguisMasculusEntity extends BaseHenchmenEntity {
	
    public AnguisMasculusEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="anguis_masculus";
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Agito_Rider_Items.JUDGEMENT_STAFF.get()));
    }

    public void remove(RemovalReason p_149847_) {
		if ( this.isDeadOrDying()) {
			if (this.random.nextDouble() * 100.0 <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {
				BaseHenchmenEntity boss = MobsCore.ANOTHER_AGITO.get().create(this.level());
				if (boss != null) {
					boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
					this.level().addFreshEntity(boss);

					if (this.getLastAttacker()instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
						playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.another_agito"));
					}
				}
			}
		}
		super.remove(p_149847_);
	}
}