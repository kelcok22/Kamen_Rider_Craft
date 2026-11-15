package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.block.RiderBlocks;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.item.heisei_phase_2.ExAidRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.core.BlockPos;
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

import java.util.Random;

import static com.kelco.kamenridercraft.util.MiscUtil.canSpawnBoss;

public class BugsterVirusEntity extends BaseHenchmenEntity {
    private BaseHenchmenEntity boss;

    public BugsterVirusEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "bugstervirus";
        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ExAidRiderItems.BUGSTER_TRIDENT.get()));
    }

    public void remove(Entity.RemovalReason removalReason) {
        if (isDeadOrDying() & !(this instanceof NebulaBugsterVirusEntity)) {
            double chance = random.nextDouble();
            int gamerule = level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE);

            if (chance * 100.0 <= gamerule && (lastHurtByPlayer != null && canSpawnBoss(lastHurtByPlayer) || !(getLastAttacker() instanceof Player) && chance * 200.0 <= gamerule)) {
                int bossChoice = random.nextInt(2);
                switch (bossChoice) {
                    case 0:
                        boss = MobsCore.GENM.get().create(level());
                        if (boss != null) {
                            for (int n = 0; n < 40; n++) {
                                Random generator = new Random();

                                int posX = (blockPosition().getX() - 10) + generator.nextInt(20);
                                int posY = blockPosition().getY() + generator.nextInt(6);
                                int posZ = (blockPosition().getZ() - 10) + generator.nextInt(20);
                                BlockPos pos1 = new BlockPos(posX, posY, posZ);
                                if (level().isEmptyBlock(pos1))
                                    level().setBlockAndUpdate(pos1, RiderBlocks.MIGHTY_BLOCK.get().defaultBlockState());
                            }

                            if (getLastAttacker() instanceof Player playerIn && level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) {
                                playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.genm"));
                            }
                        }
                        break;
                    case 1:
                        boss = MobsCore.GRAPHITE_BUGSTER.get().create(level());
                        if (boss != null && getLastAttacker() instanceof Player playerIn && level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) {
                            playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.graphite"));
                        }
                        break;
                    default:
                }
                if (boss != null) {
                    boss.moveTo(getX(), getY(), getZ(), getYRot(), 0.0F);
                    level().addFreshEntity(boss);
                }
            }
        }
        super.remove(removalReason);
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 35.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.23F)
                .add(Attributes.ATTACK_DAMAGE, 4.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }
}