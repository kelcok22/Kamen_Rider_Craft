package com.kelco.kamenridercraft.util;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import static com.kelco.kamenridercraft.effects.EffectCore.SAFE_LANDING;
import static net.minecraft.world.entity.EntityType.ZOMBIE;

public class MiscUtil {
    public static boolean canSpawnBoss(Player player) {
        return (player.level() instanceof ServerLevel serverLevel && serverLevel.getDifficulty() == Difficulty.HARD)
                || (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem driver && driver.isTransformed(player));
    }

    public static void spawnEnemy(LivingEntity spawner, Mob enemy, int range) {
        if (spawner != null && spawner.level() instanceof ServerLevel serverLevel && serverLevel.getDifficulty() != Difficulty.PEACEFUL) {
            Random rand = new Random();
            boolean gamerule = serverLevel.getGameRules().getBoolean(ModGameRules.RULE_SPAWN_EFFECT_MOBS_IN_CREATIVE);
            if (spawner instanceof Player player && ((player.isCreative() && !gamerule) || player.isSpectator())) {
                return;
            }

            List<Mob> nearbyEnemies = serverLevel.getEntitiesOfClass(Mob.class, spawner.getBoundingBox().inflate(10), Objects::nonNull);
            if (nearbyEnemies.size() > 10) {
                return;
            }

            int tempRandX = (spawner.getBlockX()
                    + (rand.nextInt(3, range))
                    * (rand.nextInt(3) > 1 ? 1 : -1));

            int tempRandZ = (spawner.getBlockZ()
                    + (rand.nextInt(3, range))
                    * (rand.nextInt(3) > 1 ? 1 : -1));

            enemy.setPos(tempRandX, spawner.getY(), tempRandZ);

            for (int i = 0; i < 400; ++i) {
                int randX = (spawner.getBlockX()
                        + (rand.nextInt(3, range))
                        * (rand.nextInt(3) > 1 ? 1 : -1));

                int randY = (spawner.getBlockY()
                        + rand.nextInt(-10, range));

                int randZ = (spawner.getBlockZ()
                        + (rand.nextInt(3, range))
                        * (rand.nextInt(3) > 1 ? 1 : -1));

                BlockPos potentialPosition = new BlockPos(randX, randY, randZ);
                if (serverLevel.noCollision(EntityType.ZOMBIE.getSpawnAABB(randX, randY, randZ)) &&
                        SpawnPlacements.isSpawnPositionOk(ZOMBIE, spawner.level(), potentialPosition)) {
                    enemy.setPos(randX, randY, randZ);
                    break;
                }
            }
            enemy.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(spawner.blockPosition()), MobSpawnType.MOB_SUMMONED, null);
            spawner.level().addFreshEntity(enemy);
            if (!enemy.onGround()) {
                enemy.addEffect(new MobEffectInstance(SAFE_LANDING, MobEffectInstance.INFINITE_DURATION,
                        255, true, false));
            }
        }
    }

    public static String oooComboCheck(String medalOne, String medalTwo, String medalThree) {
        return switch ((medalOne + " " + medalTwo + " " + medalThree).replace("kamenridercraft:", "")) {
            case "taka_medal tora_medal batta_medal", "taka_ankh_medal tora_medal batta_medal" -> "tatoba";
            case "super_taka_medal super_tora_medal super_batta_medal" -> "super_tatoba";
            case "kuwagata_medal kamakiri_medal batta_medal" -> "gatakiriba";
            case "lion_medal tora_medal cheetah_medal" -> "latorartar";
            case "taka_medal kujaku_medal condor_medal",
                 "blokees_taka_medal blokees_kujaku_medal blokees_condor_medal" -> "tajadol";
            case "taka_eternity_medal kujaku_eternity_medal condor_eternity_medal" -> "tajadol_eternity";
            case "shachi_medal unagi_medal tako_medal" -> "shauta";
            case "sai_medal gorilla_medal zou_medal" -> "sagohzo";
            case "ptera_medal tricera_medal tyranno_medal" -> "putotyra";
            case "cobra_medal kame_medal wani_medal" -> "burakawani";
            case "seiuchi_medal shirokuma_medal penguin_medal" -> "seishirogin";
            case "mukade_medal hachi_medal ari_medal" -> "mukachiri";
            case "shika_medal gazelle_medal ushi_medal" -> "shigazeshi";
            case "ebi_new_medal kani_new_medal sasori_new_medal" -> "bikaso";
            case "same_medal kujira_medal ookamiuo_medal" -> "saramiuo";
            case "love_core_medal love_core2_medal love_core3_medal" -> "renai";
            case "taka_medal imagin_medal shocker_medal" -> "tamashii";
            case "habataki_medal taiga_medal ichigo_medal" -> "legend";
            default -> "";
        };
    }
}
