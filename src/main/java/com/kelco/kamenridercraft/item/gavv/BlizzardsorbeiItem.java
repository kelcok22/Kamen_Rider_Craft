package com.kelco.kamenridercraft.item.gavv;

import java.util.List;

import com.kelco.kamenridercraft.entities.summons.WhippedSoldierEntity;
import com.kelco.kamenridercraft.item.Gavv_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;

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


public class BlizzardsorbeiItem extends RiderFormChangeItem {
    public BlizzardsorbeiItem( Properties properties,int belt,String formName,String ridername,String beltTex, MobEffectInstance... effects) {
        super(properties, belt, formName, ridername, beltTex, effects);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);
        
        if (player.isShiftKeyDown() && BELT.getItem() instanceof RiderDriverItem driver && driver.isTransformed(player)
        && RiderDriverItem.get_Form_Item(BELT, 1) == Gavv_Rider_Items.BLIZZARDSORBEI_GOCHIZO.get()) {
			List<WhippedSoldierEntity> soldiers = level.getEntitiesOfClass(WhippedSoldierEntity.class, player.getBoundingBox().inflate(10), entity -> entity.getOwner() == player);
			if (soldiers.size() == 2 && soldiers.get(0).getAttributeValue(Attributes.SCALE) == 1.0) {
                soldiers.get(0).getAttribute(Attributes.SCALE).setBaseValue(0.5);
                soldiers.get(1).getAttribute(Attributes.SCALE).setBaseValue(2.0);
                player.displayClientMessage(Component.translatable("attack.kamenridercraft.atari"), true);
		player.awardStat(Stats.ITEM_USED.get(this));
            }
            return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
        }
        return super.use(level, player, usedHand);

    }
}
