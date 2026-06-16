package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.item.reiwa.ZeroOneRiderItems;

import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static com.kelco.kamenridercraft.util.MiscUtil.canSpawnBoss;

public class BattleRaiderEntity extends BaseHenchmenEntity {

    private BaseHenchmenEntity boss;

    public BattleRaiderEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "raider_horseshoe_crab";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ZeroOneRiderItems.ZERO_ONE_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ZeroOneRiderItems.ZERO_ONE_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ZeroOneRiderItems.ZERO_ONE_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ZeroOneRiderItems.RAIDRISER_BATTLE.get()));
    }


    public void remove(Entity.RemovalReason p_149847_) {

        if (this.isDeadOrDying()) {
            double chance = this.random.nextDouble();
            int gamerule = this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE);

            if (chance * 100.0 <= gamerule && (this.lastHurtByPlayer != null && canSpawnBoss(this.lastHurtByPlayer) || !(this.getLastAttacker() instanceof Player) && chance * 200.0 <= gamerule)) {
                int bossChoice = this.random.nextInt(5);
                switch (bossChoice) {
                    case 0:
                        boss = MobsCore.RAIDER.get().create(this.level());
                        if (boss != null && this.getLastAttacker() instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
                            playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.raider"));
                        }
                        break;
                    case 1:
                        boss = MobsCore.NAKI.get().create(this.level());
                        if (boss != null && this.getLastAttacker() instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
                            playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.naki"));
                        }
                        break;
                    case 2:
                        boss = MobsCore.ZAIA.get().create(this.level());
                        if (boss != null && this.getLastAttacker() instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
                            playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.zaia"));
                        }
                        break;
                    case 3:
                        boss = MobsCore.DIRE_WOLF_SOLD_MAGIA.get().create(this.level());
                        if (boss != null && this.getLastAttacker() instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
                            playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.dire_wolf_sold_magia"));
                        }
                        break;
                    case 4:
                        boss = MobsCore.SERVAL_TIGER_SOLD_MAGIA.get().create(this.level());
                        if (boss != null && this.getLastAttacker() instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
                            playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.serval_tiger_sold_magia"));
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

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 35.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.23F)
                .add(Attributes.ATTACK_DAMAGE, 8.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }


}