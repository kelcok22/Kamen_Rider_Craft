package com.kelco.kamenridercraft.item.showa.V3;

import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.showa.V3RiderItems;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;


public class V3HopperItem extends BaseItem {
    public V3HopperItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);

        if (!level.isClientSide() && player.getItemBySlot(EquipmentSlot.FEET).getItem() == V3RiderItems.DOUBLE_TYPHOON.get()
                && ((RiderDriverItem) player.getItemBySlot(EquipmentSlot.FEET).getItem()).isTransformed(player)) {
            List<LivingEntity> nearbyAllies = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(15), entity ->
                    (entity instanceof Player && entity != player)
                            || (entity instanceof Mob));
            for (LivingEntity ally : nearbyAllies) {
                ally.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 0, false, true));
            }
            player.getCooldowns().addCooldown(this, 400);
            player.awardStat(Stats.ITEM_USED.get(this));
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}