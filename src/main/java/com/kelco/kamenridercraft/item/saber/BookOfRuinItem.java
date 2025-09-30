package com.kelco.kamenridercraft.item.saber;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.bosses.FalchionEntity;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


public class BookOfRuinItem extends BaseItem {

	public BookOfRuinItem (Properties properties)
	{
		super(properties);
	}

	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);
		if (!p_41128_.isClientSide() && p_41129_.level() instanceof ServerLevel level && level.getDifficulty() != Difficulty.PEACEFUL) {
			Vec3 look = p_41129_.getLookAngle();

			FalchionEntity falchion = MobsCore.FALCHION.get().create(level);
			if (falchion != null) {
				if (p_41128_.getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) p_41129_.sendSystemMessage(Component.translatable("henshin.kamenridercraft.falchion"));
				falchion.moveTo((p_41129_.getX()+ look.x * 3), p_41129_.getY(), (p_41129_.getZ() + look.z * 3), p_41129_.getYRot(), 0.0F);
				level.addFreshEntity(falchion);
				itemstack.shrink(1);	
				p_41129_.awardStat(Stats.ITEM_USED.get(this));
			}
		}

		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}

}