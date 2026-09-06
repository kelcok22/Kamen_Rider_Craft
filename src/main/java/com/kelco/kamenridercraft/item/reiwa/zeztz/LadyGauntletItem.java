package com.kelco.kamenridercraft.item.reiwa.zeztz;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.base_items.BaseBlasterItem;
import com.kelco.kamenridercraft.item.reiwa.ZeztzRiderItems;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadyGauntletItem extends BaseBlasterItem {
    public static List<Item> nightmareBelt = new ArrayList<>();

    public LadyGauntletItem(Tier toolTier, int Atk, float Spd, Properties properties) {
        super(toolTier, Atk, Spd, properties);
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int timeLeft) {
        if (livingEntity instanceof Player player) {
            Inventory inv = player.getInventory();
            if (inv.contains(item -> item.getItem() == ZeztzRiderItems.CHAOS_CAPSEM.get())) {
                ItemStack capsem;
                if (inv.getItem(40).getItem() == ZeztzRiderItems.CHAOS_CAPSEM.get()) capsem = inv.getItem(40);
                else capsem = inv.getItem(inv.findSlotMatchingItem(new ItemStack(ZeztzRiderItems.CHAOS_CAPSEM.get())));

                RiderSummonEntity summon = MobsCore.RIDER_SUMMON.get().create(level);
                if (summon != null) {
                    Random generator = new Random();
                    int rand = generator.nextInt(nightmareBelt.size());

                    summon.allowFormChanges(true);
                    summon.moveTo(player.getX(), player.getY() + 1, player.getZ(), player.getYRot(), player.getXRot());
                    summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ZeztzRiderItems.ZEZTZ_HELMET.get()));
                    summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ZeztzRiderItems.ZEZTZ_CHESTPLATE.get()));
                    summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ZeztzRiderItems.ZEZTZ_LEGGINGS.get()));
                    summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(nightmareBelt.get(rand)));

                    level.addFreshEntity(summon);
                    summon.bindToPlayer(player);
                    summon.allowFormChanges(false);
                    summon.takeSummonItem(capsem);

                    player.awardStat(Stats.ITEM_USED.get(this));
                    if (!player.isCreative()) player.getCooldowns().addCooldown(this, 300);
                }

                player.displayClientMessage(Component.translatable("attack.kamenridercraft.chaos_release"), true);
            }

            itemStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);
            player.awardStat(Stats.ITEM_USED.get(this));
        } else super.releaseUsing(itemStack, level, livingEntity, timeLeft);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        Inventory inv = player.getInventory();
        if (!inv.contains(item -> item.getItem() == ZeztzRiderItems.CHAOS_CAPSEM.get())) return InteractionResultHolder.fail(itemstack);
        return super.use(level, player, hand);
    }
}