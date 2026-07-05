package com.kelco.kamenridercraft.item.heisei_phase_1.decade;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.DecadeRiderItems;
import com.kelco.kamenridercraft.item.reiwa.ZeroOneRiderItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class ZeinRiderCardItem extends RiderCardItem implements ZeinCard {
    private List<MobEffectInstance> zeinEffectList = new ArrayList<>();

    public ZeinRiderCardItem(Properties properties, String formName, String riderName, String beltTex, MobEffectInstance... effects) {
        super(properties.durability(1), formName, riderName, beltTex, effects);
        zeinEffectList.addAll(List.of(effects));
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack toRepair, ItemStack repair) {
        return repair.is(DecadeRiderItems.BLANK_CARD.get()) || super.isValidRepairItem(toRepair, repair);
    }

    @Override
    public void activateCard(Level level, LivingEntity living, ItemStack stack) {
        for (MobEffectInstance effect : zeinEffectList) living.addEffect(effect);
        if (living instanceof ServerPlayer player) {
            CriteriaTriggers.ITEM_DURABILITY_CHANGED.trigger(player, stack, stack.getDamageValue() + 1);
        }
        stack.setDamageValue(1);
        ((ServerLevel) level).sendParticles(new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(this)),
                living.getX(), living.getY() + 1, living.getZ(), 10, 0, 0, 0, 0.05);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack card = player.getItemInHand(interactionHand);
        if (!card.isDamaged()) {
            ItemStack belt = player.getItemBySlot(EquipmentSlot.FEET);

            if (!level.isClientSide() && belt.getItem() == ZeroOneRiderItems.ZEIN_DRIVER.get() && ((RiderDriverItem) belt.getItem()).isTransformed(player)) {
                activateCard(level, player, card);
                player.displayClientMessage(Component.translatable("attack.kamenridercraft.justice_order"), true);
                if (!player.isCreative())
                    for (Item item : DecadeRiderItems.ZEIN_CARDS) player.getCooldowns().addCooldown(item, 2400);
                player.awardStat(Stats.ITEM_USED.get(this));

                return InteractionResultHolder.sidedSuccess(player.getItemInHand(interactionHand), level.isClientSide());
            } else return super.use(level, player, interactionHand);
        }
        return InteractionResultHolder.fail(player.getItemInHand(interactionHand));
    }
}