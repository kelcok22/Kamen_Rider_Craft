package com.kelco.kamenridercraft.item.reiwa.zeztz;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class SomniaCapsemItem extends BaseItem {
    public SomniaCapsemItem(Properties properties) {
        super(properties);
    }

    @Override
    @NotNull
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (!level.isClientSide() && usedHand == InteractionHand.MAIN_HAND) {
            List<LivingEntity> nearbyEnemies = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(50));
            for (LivingEntity enemy : nearbyEnemies) {
                if (enemy.getItemBySlot(EquipmentSlot.FEET).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/somnia_affected")))) {
                    enemy.addEffect(new MobEffectInstance(EffectCore.FLAT, 200, 0, true, true));
                    //TODO add red petal particle over area of affect
                }
            }
            player.getCooldowns().addCooldown(this, 200);
        }
        return super.use(level, player, usedHand);
    }
}