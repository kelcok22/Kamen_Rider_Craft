package com.kelco.kamenridercraft.abilities.hit_handling;

import net.minecraft.world.entity.LivingEntity;

import java.util.List;

import static com.kelco.kamenridercraft.abilities.hit_handling.AbilityHitProcessing.kickHit;
import static com.kelco.kamenridercraft.abilities.AbilityUtil.cancelAbility;
import static com.kelco.kamenridercraft.attachments.AttachmentTypes.USED_ABILITY;

public class AbilityHitDetection {
    public static void standardHitDetection(LivingEntity user, String hitType) {
        boolean enemyDetected = false;
        float hitRadius = 0.5F;
        switch (hitType) {
            case "punch":

        }
        List<LivingEntity> nearbyEnemies = user.level().getEntitiesOfClass(LivingEntity.class, user.getBoundingBox().inflate(hitRadius + user.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.SCALE).getValue()), enemy -> (enemy != user));
        for (LivingEntity enemy : nearbyEnemies) {
            enemyDetected = true;
            switch (hitType) {
                case "punch":

            }
        }
        if (enemyDetected) {
            if (hitType.equals("kick")) {
                switch (user.getData(USED_ABILITY)) {
                    case "kiva_kick":
                        cancelAbility(user, "kiva.land", 10);
                    case "kabuto_kick":
                        cancelAbility(user, "", 30);
                        break;
                    case "secondary_rider_kick":
                        cancelAbility(user, "default.flipped_land", 10);
                        break;
                    default:
                        cancelAbility(user, "default.land", 10);
                        break;
                }
            } else {
                cancelAbility(user, "", 10);

            }
        }

    }

    public static void detectHit(LivingEntity user) {
        List<LivingEntity> nearbyEnemies = user.level().getEntitiesOfClass(LivingEntity.class, user.getBoundingBox().inflate(0.5 + user.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.SCALE).getValue()), enemy -> (enemy != user));
        boolean enemyDetected = false;
        for (LivingEntity enemy : nearbyEnemies) {
            enemyDetected = true;
            switch (user.getData(USED_ABILITY)) {
                case "kabuto_kick":
                    kickHit(user, enemy, "kabuto");
                    break;
                case "kiva_rider_kick":
                    kickHit(user, enemy, "kiva_logo");
                default:
                    kickHit(user, enemy, "normal");
            }
        }
        if (enemyDetected) {

        }
    }
}
