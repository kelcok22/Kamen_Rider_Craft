package com.kelco.kamenridercraft.item.heisei_phase_1.decade;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.EnemySummonEntity;
import com.kelco.kamenridercraft.entity.mobs.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.DecadeRiderItems;
import com.kelco.kamenridercraft.item.reiwa.ReviceRiderItems;
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
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class UltimateViceCardItem extends BaseItem implements ZeinCard {
    public UltimateViceCardItem(Properties properties) {
        super(properties.durability(1));
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(DecadeRiderItems.BLANK_CARD.get()) || super.isValidRepairItem(toRepair, repair);
    }

    @Override
    public void activateCard(Level level, LivingEntity living, ItemStack stack) {
        LivingEntity summon;
        if (living instanceof Player) summon = MobsCore.RIDER_SUMMON.get().create(level);
        else summon = MobsCore.ENEMY_SUMMON.get().create(level);

        if (summon != null) {
            summon.moveTo(living.getX(), living.getY()+1, living.getZ(), living.getYRot(), living.getXRot());
            summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ReviceRiderItems.REVICE_HELMET.get()));
            summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ReviceRiderItems.REVICE_CHESTPLATE.get()));
            summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ReviceRiderItems.REVICE_LEGGINGS.get()));
            summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(ReviceRiderItems.BUDDY_BUCKLE.get()));
            RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.GIFFARD_REX_VISTAMP_VICE.get(), 1);

            level.addFreshEntity(summon);
            if (summon instanceof RiderSummonEntity rider) rider.bindToPlayer((Player) living);
            else ((EnemySummonEntity) summon).setOwnerUUID(living.getUUID());
        }

        if (living instanceof ServerPlayer player) CriteriaTriggers.ITEM_DURABILITY_CHANGED.trigger(player, stack, stack.getDamageValue()+1);
        stack.setDamageValue(1);
        ((ServerLevel) level).sendParticles(new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(this)),
                living.getX(), living.getY()+1, living.getZ(), 10, 0, 0, 0, 0.05);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack CARD = player.getItemInHand(usedHand);
        if (!CARD.isDamaged()) {
            ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

            if (!level.isClientSide() && BELT.getItem() == ZeroOneRiderItems.ZEIN_DRIVER.get() && ((RiderDriverItem) BELT.getItem()).isTransformed(player)) {
                activateCard(level, player, CARD);
                player.displayClientMessage(Component.translatable("attack.kamenridercraft.justice_order"), true);
                if (!player.isCreative()) for (Item item : DecadeRiderItems.ZEIN_CARDS) player.getCooldowns().addCooldown(item, 2400);
                player.awardStat(Stats.ITEM_USED.get(this));

                return InteractionResultHolder.sidedSuccess(player.getItemInHand(usedHand), level.isClientSide());
            }
        }
        return InteractionResultHolder.fail(player.getItemInHand(usedHand));
    }
}