package com.kelco.kamenridercraft.block.custom;


import com.kelco.kamenridercraft.block.baseBlocks.BaseBlock;
import com.kelco.kamenridercraft.effect.Effect_core;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class ArtificialGravityBlock extends BaseBlock {

	public ArtificialGravityBlock(Properties prop) {
		super(prop);
		
	}



	@Override
	protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos pos, BlockPos facingPos) {
		if (level.hasNeighborSignal(pos)) {
			level.scheduleTick(pos, this, 20);
		}

		return super.updateShape(state, facing, facingState, level, pos, facingPos);
	}

	@Override
	protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
		level.scheduleTick(pos, this, 20);
	}


	@Override
	protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (level.hasNeighborSignal(pos)) {
			level.scheduleTick(pos, this, 20);

			if (!level.isClientSide()) {

				AABB Effect_pos = new AABB(pos).inflate(20);

				List<LivingEntity> nearbyEntities = level.getEntitiesOfClass(LivingEntity.class, Effect_pos, entity ->
						(entity instanceof Player)
								|| (entity instanceof Mob mob));
				for (LivingEntity enemy : nearbyEntities) {
					enemy.addEffect(new MobEffectInstance(Effect_core.GRAVITY, 70, 3, true, true));
				}
			}
		}
	}
}