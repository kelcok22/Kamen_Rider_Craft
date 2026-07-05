package com.kelco.kamenridercraft.item.heisei_phase_2.ooo;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.OOORiderItems;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;


public class ShowaMedalItem extends BaseItem {
    private RiderDriverItem summonBelt;
    private Item summonWeapon;

    public ShowaMedalItem(Properties properties, RiderDriverItem belt, @Nullable Item weapon) {
        super(properties);
        summonBelt = belt;
        summonWeapon = weapon;
    }

    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);

        if (!level.isClientSide() && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt
                && belt.isTransformed(player) && player.getItemBySlot(EquipmentSlot.FEET).getItem() == OOORiderItems.OOODRIVER.get()
                && player.getInventory().countItem(OOORiderItems.O_SCANNER.get()) != 0) {
            RiderSummonEntity summon = MobsCore.RIDER_SUMMON.get().create(level);
            if (summon != null) {
                summon.moveTo(player.getX(), player.getY() + 1, player.getZ(), player.getYRot(), player.getXRot());
                summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(summonBelt.helmet));
                summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(summonBelt.chestplate));
                summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(summonBelt.leggings));
                summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(summonBelt));
                if (summonWeapon != null) summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(summonWeapon, 1));

                level.addFreshEntity(summon);
                summon.bindToPlayer(player);
                if (!player.isCreative()) {
                    itemstack.shrink(1);
                    player.getCooldowns().addCooldown(this, 500);
                }
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}