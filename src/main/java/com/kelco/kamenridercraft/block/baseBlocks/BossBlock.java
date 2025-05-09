package com.kelco.kamenridercraft.block.baseBlocks;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import javax.annotation.Nullable;
import com.google.common.collect.Lists;
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
public class BossBlock extends BaseBlock {

	private List<Component> TEXT = Lists.newArrayList();
	private Supplier<? extends EntityType<? extends BaseHenchmenEntity>> BOSS;
	private List<Block>  BLOCK;
	private int NUM;
	
	public BossBlock(Properties prop,Supplier<? extends EntityType<? extends BaseHenchmenEntity>> boss) {
		super(prop);
		BOSS =boss;
	}

	public BossBlock(Properties prop,Supplier<? extends EntityType<? extends BaseHenchmenEntity>> boss,Block... block) {
		super(prop);
		BOSS =boss;
		BLOCK = Lists.newArrayList(block);
	}
	
	public BossBlock addLine(Component text) {
		TEXT.add(text);
		return this;
	}
	
	@Override
	public void playerDestroy(Level wolrd, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity p_49831_, ItemStack stack) {
		if (BLOCK!=null) {
				if(NUM==1) {
					for (int n = 0; n < 40; n++)
					{
						Random generator = new Random();
						 int posX = (pos.getX()-10)+generator.nextInt(20);
						 int posY = pos.getY()+generator.nextInt(6);
						 int posZ = (pos.getZ()-10)+generator.nextInt(20);
						BlockPos pos1 = new BlockPos(posX,posY,posZ);
						if (wolrd.isEmptyBlock(pos1))wolrd.setBlockAndUpdate(pos1, BLOCK.get(generator.nextInt(BLOCK.size())).defaultBlockState());
					}
				}else {
					for (int n = 0; n < 40; n++)
					{
						Random generator = new Random();
						 int posX = (pos.getX()-10)+generator.nextInt(20);
						 int posY = pos.getY();
						 int posZ = (pos.getZ()-10)+generator.nextInt(20);
						BlockPos pos1 = new BlockPos(posX,posY,posZ);
						if (wolrd.isEmptyBlock(pos1))wolrd.setBlockAndUpdate(pos1, BLOCK.get(generator.nextInt(BLOCK.size())).defaultBlockState());
					}
				}
		 }
		BaseHenchmenEntity boss = BOSS.get().create(wolrd);
		if (boss != null) {
			boss.moveTo(pos.getX(), pos.getY(), pos.getZ(), 0, 0.0F);
			wolrd.addFreshEntity(boss);
			if (!TEXT.isEmpty()) for (Component text : TEXT) player.sendSystemMessage(text);
		}
		super.playerDestroy(wolrd, player, pos, state, p_49831_, stack);
	}

}