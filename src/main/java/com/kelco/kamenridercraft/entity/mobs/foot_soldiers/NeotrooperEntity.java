package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.item.heisei_phase_1.Kabuto_Rider_Items;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static com.kelco.kamenridercraft.util.MiscUtil.canSpawnBoss;

public class NeotrooperEntity extends BaseHenchmenEntity {

    public NeotrooperEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "neotrooper";
        BOW_COOLDOWN = 35;
        HARD_BOW_COOLDOWN = 15;
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Kabuto_Rider_Items.KABUTOHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Kabuto_Rider_Items.KABUTOCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Kabuto_Rider_Items.KABUTOLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Kabuto_Rider_Items.NEOTROOPER_BELT.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Kabuto_Rider_Items.MACHINEGUN_BLADE.get()));
        this.setMeleeOnSpawn(50.0D);
    }


    public void remove(RemovalReason p_149847_) {
        if (this.isDeadOrDying()) {
            double chance = this.random.nextDouble();
            int gamerule = this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE);

            if (chance * 100.0 <= gamerule && (this.lastHurtByPlayer != null && canSpawnBoss(this.lastHurtByPlayer) || !(this.getLastAttacker() instanceof Player) && chance * 200.0 <= gamerule)) {
                BaseHenchmenEntity boss = MobsCore.CAUCASUS.get().create(this.level());
                if (boss != null) {
                    boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    this.level().addFreshEntity(boss);
                    if (this.getLastAttacker() instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
                        playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.caucasus"));
                    }
                }
            }
        }
        super.remove(p_149847_);
    }

}