package com.kelco.kamenridercraft.item.reiwa.gavv;

import com.kelco.kamenridercraft.entity.mobs.summons.WhippedSoldierEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.reiwa.GavvRiderItems;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class BlizzardsorbeiItem extends RiderFormChangeItem {
    public BlizzardsorbeiItem(Properties properties, String formName, String riderName, String beltTex, MobEffectInstance... effects) {
        super(properties, formName, riderName, beltTex, effects);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if (player.isShiftKeyDown() && BELT.getItem() instanceof RiderDriverItem driver && driver.isTransformed(player)
                && RiderDriverItem.getFormItem(BELT, 1) == GavvRiderItems.BLIZZARDSORBEI_GOCHIZO.get()) {
            List<WhippedSoldierEntity> soldiers = level.getEntitiesOfClass(WhippedSoldierEntity.class, player.getBoundingBox().inflate(10), entity -> entity.getOwner() == player);
            if (soldiers.size() == 2 && soldiers.get(0).getAttributeValue(Attributes.SCALE) == 1.0) {
                soldiers.get(0).getAttribute(Attributes.SCALE).setBaseValue(0.5);
                soldiers.get(1).getAttribute(Attributes.SCALE).setBaseValue(2.0);
                player.displayClientMessage(Component.translatable("attack.kamenridercraft.atari"), true);
                player.awardStat(Stats.ITEM_USED.get(this));
            }
            return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
        }
        return super.use(level, player, interactionHand);

    }
}