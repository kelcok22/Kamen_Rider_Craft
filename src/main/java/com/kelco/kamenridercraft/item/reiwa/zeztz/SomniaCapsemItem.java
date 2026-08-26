package com.kelco.kamenridercraft.item.reiwa.zeztz;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class SomniaCapsemItem extends BaseItem {
    public SomniaCapsemItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (level.isClientSide() && usedHand == InteractionHand.MAIN_HAND) {
            List<LivingEntity> nearbyEnemies = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(50), entity ->
                    (entity instanceof Mob));
            for (LivingEntity enemy : nearbyEnemies) {
                if (enemy.toString().toLowerCase().contains("nightmare") || enemy.toString().toLowerCase().contains("dawn")) {
                    enemy.addEffect(new MobEffectInstance(EffectCore.FLAT, 200, 0, true, true));
                }
            }
            player.getCooldowns().addCooldown(this, 200);
        }
        return super.use(level, player, usedHand);
    }
}