package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.item.extra_riders.ExtraRiderItems;
import com.kelco.kamenridercraft.item.showa.IchigoRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.time.LocalDate;

import static com.kelco.kamenridercraft.util.MiscUtil.canSpawnBoss;

public class ShockerCombatmanEntity extends BaseHenchmenEntity {
    public ShockerCombatmanEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        LocalDate localdate = LocalDate.now();
        int day = localdate.getDayOfMonth();
        if (localdate.getMonthValue() == 12 && day >= 21 && day <= 28) NAME = "shocker_combatman_christmas";
        else NAME = "shocker_combatman";
        getAttribute(Attributes.REINFORCEMENT_CHANCE).setBaseValue(12D);
        setItemSlot(EquipmentSlot.HEAD, new ItemStack(IchigoRiderItems.ICHIGOHELMET.get()));
        setItemSlot(EquipmentSlot.CHEST, new ItemStack(IchigoRiderItems.ICHIGOCHESTPLATE.get()));
        setItemSlot(EquipmentSlot.LEGS, new ItemStack(IchigoRiderItems.ICHIGOLEGGINGS.get()));
        setItemSlot(EquipmentSlot.FEET, new ItemStack(IchigoRiderItems.SHOCKER_BELT.get()));
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
                .add(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE, 35.0D)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED, 0.23F)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE, 4.0D)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR, -17.0D)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH, 45.0D);
    }


    public void remove(RemovalReason removalReason) {
        if (removalReason == RemovalReason.KILLED) {
            LocalDate localdate = LocalDate.now();
            int day = localdate.getDayOfMonth();
            if (localdate.getMonthValue() == 12 && day >= 21 && day <= 28 && lastHurtByPlayer != null) {
                ItemEntity key = new ItemEntity(level(), getX(), getY(), getZ(), new ItemStack(ExtraRiderItems.GIFT.get(), 1), 0, 0, 0);
                key.setPickUpDelay(0);
                level().addFreshEntity(key);
            }
            ((ServerLevel) level()).sendParticles(ParticleTypes.CLOUD,
                    getX() + 0, getY(),
                    getZ() + 0, 100, 0, 0, 0, 0.1);


            double chance = random.nextDouble();
            int gamerule = level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE);
            if (chance * 100.0 <= gamerule && (lastHurtByPlayer != null && canSpawnBoss(lastHurtByPlayer) || !(getLastAttacker() instanceof Player) && chance * 200.0 <= gamerule)) {
                BaseHenchmenEntity boss = MobsCore.SHOCKER_RIDER.get().create(level());
                if (boss != null) {
                    boss.moveTo(getX(), getY(), getZ(), getYRot(), 0.0F);
                    level().addFreshEntity(boss);
                    if (getLastAttacker() instanceof Player playerIn && level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS))
                        playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.shocker_rider"));
                }
            }
        }
        super.remove(removalReason);
    }
}