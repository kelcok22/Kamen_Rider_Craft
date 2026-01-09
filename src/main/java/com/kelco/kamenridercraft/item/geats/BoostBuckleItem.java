package com.kelco.kamenridercraft.item.geats;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.bikes.baseBikeEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;


public class BoostBuckleItem extends RiderFormChangeItem {
	public BoostBuckleItem(Properties properties, int belt, String formName, String ridername, String beltTex, MobEffectInstance... effects) {
		super(properties, belt, formName, ridername, beltTex, effects);
	}

	public InteractionResult useOn(UseOnContext context) {
		Player player = context.getPlayer();
		ItemStack itemstack = player.getItemInHand(context.getHand());
		Level level = player.level();

		if (!level.isClientSide() && (!(player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof DesireDriverItem)||player.isShiftKeyDown())) {
			BlockPos pos = context.getClickedPos();
			baseBikeEntity boss = MobsCore.BOOSTRIKER.get().create(level);
			if (boss != null) {
				boss.moveTo(pos.getX(), pos.getY()+1, pos.getZ(), 0, 0.0F);
				level.addFreshEntity(boss);
				player.displayClientMessage(Component.translatable("bike.kamenridercraft.boostriker"), true);
				itemstack.consume(1,player);
				player.awardStat(Stats.ITEM_USED.get(this));
			}
		}
		return InteractionResult.SUCCESS;
	}
}