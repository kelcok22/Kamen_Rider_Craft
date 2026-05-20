package com.kelco.kamenridercraft.item.extra_riders;


import com.kelco.kamenridercraft.entity.mobs.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.showa.IchigoRiderItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import static com.kelco.kamenridercraft.entity.mobs.MobsCore.RIDER_SUMMON;


public class TojimaTakoyakiItem extends BaseItem {

	public TojimaTakoyakiItem(Properties prop) {
		super(prop);
	}

	public InteractionResult useOn(UseOnContext context) {

        Player player = context.getPlayer();
        ItemStack itemstack = player.getItemInHand(context.getHand());
        Level level = player.level();
            if (player.level() instanceof ServerLevel) {
                BlockPos pos = context.getClickedPos();
                RiderSummonEntity boss = RIDER_SUMMON.get().create(level);
                if (boss != null) {
					boss.setItemSlot(EquipmentSlot.HEAD, new ItemStack(IchigoRiderItems.ICHIGOHELMET.get()));
					boss.setItemSlot(EquipmentSlot.CHEST, new ItemStack(IchigoRiderItems.ICHIGOCHESTPLATE.get()));
					boss.setItemSlot(EquipmentSlot.LEGS, new ItemStack(IchigoRiderItems.ICHIGOLEGGINGS.get()));
					ItemStack belt = new ItemStack(IchigoRiderItems.TYPHOON_ICHIGO.get());
					RiderDriverItem.set_Form_Item(belt, IchigoRiderItems.TAKOYAKI_TYPHOON_CORE.get(), 1);

					boss.setItemSlot(EquipmentSlot.FEET,belt);
					;
                    boss.setTame(true, false);
                    boss.bindToPlayer(player);
                    boss.moveTo(pos.getX(), pos.getY() + 1, pos.getZ(), 0, 0.0F);
                    level.addFreshEntity(boss);
                    itemstack.consume(1, player);
                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        return InteractionResult.PASS;
    }
}
