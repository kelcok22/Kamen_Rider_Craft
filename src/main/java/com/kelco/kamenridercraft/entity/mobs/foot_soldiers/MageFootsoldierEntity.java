package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.item.heisei_phase_2.WizardRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static com.kelco.kamenridercraft.util.MiscUtil.canSpawnBoss;

public class MageFootsoldierEntity extends BaseHenchmenEntity {

    public MageFootsoldierEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "mage_foot_soldiers";
        BOW_COOLDOWN = 35;
        HARD_BOW_COOLDOWN = 15;
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(WizardRiderItems.WIZARD_HEAD.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(WizardRiderItems.WIZARD_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(WizardRiderItems.WIZARD_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(WizardRiderItems.MAGE_DRIVER_FOOT_SOLDIERS.get()));
    }


    public void remove(RemovalReason p_149847_) {
        if (this.isDeadOrDying()) {
            double chance = this.random.nextDouble();
            int gamerule = this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE);

            if (chance * 100.0 <= gamerule && (this.lastHurtByPlayer != null && canSpawnBoss(this.lastHurtByPlayer) || !(this.getLastAttacker() instanceof Player) && chance * 200.0 <= gamerule)) {
                BaseHenchmenEntity boss = MobsCore.SORCERER.get().create(this.level());
                if (boss != null) {
                    boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    this.level().addFreshEntity(boss);
                    if (this.getLastAttacker() instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
                        playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.sorcerer"));
                    }
                }
            }
        }
        super.remove(p_149847_);
    }

}