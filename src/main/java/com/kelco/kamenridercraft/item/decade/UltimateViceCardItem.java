package com.kelco.kamenridercraft.item.decade;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.footSoldiers.EnemySummonEntity;
import com.kelco.kamenridercraft.entities.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Decade_Rider_Items;
import com.kelco.kamenridercraft.item.Revice_Rider_Items;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
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
        return repair.is(Decade_Rider_Items.BLANK_CARD.get()) || super.isValidRepairItem(toRepair, repair);
    }

    @Override
    public void activateCard(Level level, LivingEntity living, ItemStack stack) {
        LivingEntity summon;
        if (living instanceof Player) summon = MobsCore.RIDER_SUMMON.get().create(level);
        else summon = MobsCore.ENEMY_SUMMON.get().create(level);

        if (summon != null) {
            summon.moveTo(living.getX(), living.getY()+1, living.getZ(), living.getYRot(), living.getXRot());
            summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Revice_Rider_Items.REVICE_HELMET.get()));
            summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Revice_Rider_Items.REVICE_CHESTPLATE.get()));
            summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Revice_Rider_Items.REVICE_LEGGINGS.get()));
            summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(Revice_Rider_Items.BUDDY_BUCKLE.get()));
            RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.GIFFARD_REX_VISTAMP_VICE.get(), 1);

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

            if (!level.isClientSide() && BELT.getItem() == Zero_One_Rider_Items.ZEIN_DRIVER.get() && ((RiderDriverItem) BELT.getItem()).isTransformed(player)) {
                activateCard(level, player, CARD);
                player.displayClientMessage(Component.translatable("attack.kamenridercraft.justice_order"), true);
                if (!player.isCreative()) for (Item item : Decade_Rider_Items.ZEIN_CARDS) player.getCooldowns().addCooldown(item, 2400);
                player.awardStat(Stats.ITEM_USED.get(this));

                return InteractionResultHolder.sidedSuccess(player.getItemInHand(usedHand), level.isClientSide());
            }
        }
        return InteractionResultHolder.fail(player.getItemInHand(usedHand));
    }
}