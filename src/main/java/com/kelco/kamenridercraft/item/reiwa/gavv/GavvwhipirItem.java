package com.kelco.kamenridercraft.item.reiwa.gavv;


import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.variants.WhippedSoldierVariant;
import com.kelco.kamenridercraft.entity.mobs.summons.WhippedSoldierEntity;
import com.kelco.kamenridercraft.item.base_items.BaseSwordItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.GavvRiderItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GavvwhipirItem extends BaseSwordItem {
    public GavvwhipirItem(Tier toolTier, int Atk, float Spd, Properties prop) {
        super(toolTier, Atk, Spd, prop);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack belt = player.getItemBySlot(EquipmentSlot.FEET);
        if (!level.isClientSide() && belt.getItem() == GavvRiderItems.HENSHIN_BELT_GAVV.get() && ((RiderDriverItem) belt.getItem()).isTransformed(player)
                && (RiderDriverItem.getFormItem(belt, 1) == GavvRiderItems.CAKING_GOCHIZO.get() || RiderDriverItem.getFormItem(belt, 1) == GavvRiderItems.BLIZZARDSORBEI_GOCHIZO.get())) {
            List<WhippedSoldierEntity> soldiers = level.getEntitiesOfClass(WhippedSoldierEntity.class, player.getBoundingBox().inflate(50), whip -> (whip.getOwner() == player));
            if (soldiers.size() < 2) {
                WhippedSoldierEntity whip = MobsCore.WHIPPED_SOLDIER.get().create(level);
                if (whip != null) {
                    whip.moveTo(player.getX(), player.getY() + 1, player.getZ(), player.getYRot(), player.getXRot());
                    level.addFreshEntity(whip);
                    whip.bindToPlayer(player);
                    if (RiderDriverItem.getFormItem(belt, 1) == GavvRiderItems.BLIZZARDSORBEI_GOCHIZO.get())
                        whip.setVariant(WhippedSoldierVariant.ICE);
                }
                player.displayClientMessage(Component.translatable("attack.kamenridercraft.whip_party"), true);
                if (!player.isCreative()) player.getCooldowns().addCooldown(this, 80);
            }
        }
        return super.use(level, player, hand);
    }
}