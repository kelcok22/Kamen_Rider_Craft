package com.kelco.kamenridercraft.block.custom;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.block.baseBlocks.BaseBlock;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class BossBlockHokutoTrio extends BaseBlock {

	private List<Component> TEXT = Lists.newArrayList();
	private int NUM;

	public BossBlockHokutoTrio(Properties prop) {
		super(prop);
	}

	
	public BossBlockHokutoTrio addLine(Component text) {
		TEXT.add(text);
		return this;
	}
	
	@Override
	public void playerDestroy(Level wolrd, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity p_49831_, ItemStack stack) {
		BaseHenchmenEntity boss = MobsCore.OWL_LOST_SMASH.get().create(wolrd);
		BaseHenchmenEntity boss2 = MobsCore.STAG_LOST_SMASH.get().create(wolrd);
		BaseHenchmenEntity boss3 = MobsCore.CASTLE_LOST_SMASH.get().create(wolrd);
		if (boss != null&boss2 != null&boss3 != null) {
			boss.moveTo(pos.getX(), pos.getY(), pos.getZ()+1, 0, 0.0F);
			boss2.moveTo(pos.getX(), pos.getY(), pos.getZ(), 0, 0.0F);
			boss3.moveTo(pos.getX(), pos.getY(), pos.getZ()-1, 0, 0.0F);
			wolrd.addFreshEntity(boss);
			wolrd.addFreshEntity(boss2);
			wolrd.addFreshEntity(boss3);
			if (!TEXT.isEmpty()) for (Component text : TEXT) player.sendSystemMessage(text);
		}
		super.playerDestroy(wolrd, player, pos, state, p_49831_, stack);	     
	}

}