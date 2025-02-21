
package com.kelco.kamenridercraft.block.storageBlock;

import com.kelco.kamenridercraft.block.baseBlocks.BaseFacingBlock;
import com.kelco.kamenridercraft.block.entity.AstroswitchPanelBlockEntity;
import com.kelco.kamenridercraft.init.ModMenus;
import com.kelco.kamenridercraft.world.inventory.AstroswitchPanelDoubleGuiMenu;
import com.kelco.kamenridercraft.world.inventory.AstroswitchPanelGuiMenu;
import com.mojang.serialization.MapCodec;
import io.netty.buffer.Unpooled;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class AstroswitchPanelBlock extends BaseFacingBlock {
	private AstroswitchPanelDoubleGuiMenu blockEntityType;

	public static final DirectionProperty FACING;
	public static final EnumProperty<ChestType> TYPE;
	protected static final int AABB_OFFSET = 1;
	protected static final int AABB_HEIGHT = 14;
	private static final DoubleBlockCombiner.Combiner<AstroswitchPanelBlockEntity, Optional<Container>> CHEST_COMBINER;
	private static final DoubleBlockCombiner.Combiner<AstroswitchPanelBlockEntity, Optional<MenuProvider>> MENU_PROVIDER_COMBINER;


	public AstroswitchPanelBlock(Properties properties, Supplier<BlockEntityType<? extends AstroswitchPanelBlockEntity>> blockEntityType) {
		super(properties);
		this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(TYPE, ChestType.SINGLE)));
	}

	public static DoubleBlockCombiner.BlockType getBlockType(BlockState state) {
		ChestType chesttype = (ChestType)state.getValue(TYPE);
		if (chesttype == ChestType.SINGLE) {
			return DoubleBlockCombiner.BlockType.SINGLE;
		} else {
			return chesttype == ChestType.RIGHT ? DoubleBlockCombiner.BlockType.FIRST : DoubleBlockCombiner.BlockType.SECOND;
		}
	}


	protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {

		if (facingState.is(this) && facing.getAxis().isHorizontal()) {
			ChestType chesttype = (ChestType)facingState.getValue(TYPE);
			if (state.getValue(TYPE) == ChestType.SINGLE && chesttype != ChestType.SINGLE && state.getValue(FACING) == facingState.getValue(FACING) && getConnectedDirection(facingState) == facing.getOpposite()) {
				return (BlockState)state.setValue(TYPE, chesttype.getOpposite());
			}
		} else if (getConnectedDirection(state) == facing) {
			return (BlockState)state.setValue(TYPE, ChestType.SINGLE);
		}

		return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
	}

	public static Direction getConnectedDirection(BlockState state) {
		Direction direction = (Direction)state.getValue(FACING);
		return state.getValue(TYPE) == ChestType.LEFT ? direction.getClockWise() : direction.getCounterClockWise();
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		ChestType chesttype = ChestType.SINGLE;
		Direction direction = context.getHorizontalDirection().getOpposite();
		boolean flag = context.isSecondaryUseActive();
		Direction direction1 = context.getClickedFace();
		if (direction1.getAxis().isHorizontal() && flag) {
			Direction direction2 = this.candidatePartnerFacing(context, direction1.getOpposite());
			if (direction2 != null && direction2.getAxis() != direction1.getAxis()) {
				direction = direction2;
				chesttype = direction2.getCounterClockWise() == direction1.getOpposite() ? ChestType.RIGHT : ChestType.LEFT;
			}
		}

		if (chesttype == ChestType.SINGLE && !flag) {
			if (direction == this.candidatePartnerFacing(context, direction.getClockWise())) {
				chesttype = ChestType.LEFT;
			} else if (direction == this.candidatePartnerFacing(context, direction.getCounterClockWise())) {
				chesttype = ChestType.RIGHT;
			}
		}

		return (BlockState)((BlockState)((BlockState)this.defaultBlockState().setValue(FACING, direction)).setValue(TYPE, chesttype));
	}

	@Nullable
	private Direction candidatePartnerFacing(BlockPlaceContext context, Direction direction) {
		BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos().relative(direction));
		return blockstate.is(this) && blockstate.getValue(TYPE) == ChestType.SINGLE ? (Direction)blockstate.getValue(FACING) : null;
	}

	public AstroswitchPanelBlock AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		if (entity instanceof ServerPlayer player) {
			player.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Astroswitch Panel");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new AstroswitchPanelGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
				}
			}, pos);
		}
				return InteractionResult.SUCCESS;
	}





	@Nullable
	public static Container getContainer(AstroswitchPanelBlock chest, BlockState state, Level level, BlockPos pos, boolean override) {
		return (Container)((Optional)chest.combine(state, level, pos, override).apply(CHEST_COMBINER)).orElse((Object)null);
	}

	public DoubleBlockCombiner.NeighborCombineResult<? extends AstroswitchPanelBlockEntity> combine(BlockState state, Level level, BlockPos pos, boolean override) {
		BiPredicate bipredicate = null;
		if (override) {
			bipredicate = (p_51578_, p_51579_) -> {
				return false;
			};
		} else {

		}

		return DoubleBlockCombiner.combineWithNeigbour((BlockEntityType)this.blockEntityType.get(), AstroswitchPanelBlock::getBlockType, AstroswitchPanelBlock::getConnectedDirection, FACING, state, level, pos, bipredicate);
	}

	@Nullable
	protected MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
		return (MenuProvider)((Optional)this.combine(state, level, pos, false).apply(MENU_PROVIDER_COMBINER)).orElse((Object)null);
	}

	public static DoubleBlockCombiner.Combiner<AstroswitchPanelBlockEntity, Float2FloatFunction> opennessCombiner(final LidBlockEntity lid) {
		return new DoubleBlockCombiner.Combiner<AstroswitchPanelBlockEntity, Float2FloatFunction>() {
			public Float2FloatFunction acceptDouble(AstroswitchPanelBlockEntity p_51633_, AstroswitchPanelBlockEntity p_51634_) {
                return null;
            }

			@Override
			public Float2FloatFunction acceptSingle(AstroswitchPanelBlockEntity astroswitchPanelBlockEntity) {
				return null;
			}

			public Float2FloatFunction acceptSingle(ChestBlockEntity p_51631_) {
				Objects.requireNonNull(p_51631_);
				return p_51631_::getOpenNess;
			}

			public Float2FloatFunction acceptNone() {
				LidBlockEntity var10000 = lid;
				Objects.requireNonNull(var10000);
				return var10000::getOpenNess;
			}
		};
	}

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ChestBlockEntity(pos, state);
    }


	private Object blockEntityType() {
        return null;
    }

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof AstroswitchPanelBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof AstroswitchPanelBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}

	protected BlockState mirror(BlockState state, Mirror mirror) {
		BlockState rotated = state.rotate(mirror.getRotation((Direction)state.getValue(FACING)));
		return mirror == Mirror.NONE ? rotated : (BlockState)rotated.setValue(TYPE, ((ChestType)rotated.getValue(TYPE)).getOpposite());
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(new Property[]{FACING, TYPE});
	}

	protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		BlockEntity blockentity = level.getBlockEntity(pos);
		if (blockentity instanceof ChestBlockEntity) {
			((ChestBlockEntity)blockentity).recheckOpen();
		}

	}

	static {
		FACING = HorizontalDirectionalBlock.FACING;
		TYPE = BlockStateProperties.CHEST_TYPE;
		CHEST_COMBINER = new DoubleBlockCombiner.Combiner<AstroswitchPanelBlockEntity, Optional<Container>>() {
			public Optional<Container> acceptDouble(AstroswitchPanelBlockEntity p_51591_, AstroswitchPanelBlockEntity p_51592_) {
				return Optional.of(new CompoundContainer(p_51591_, p_51592_));
			}

			public Optional<Container> acceptSingle(AstroswitchPanelBlockEntity p_51589_) {
				return Optional.of(p_51589_);
			}

			public Optional<Container> acceptNone() {
				return Optional.empty();
			}
		};

		MENU_PROVIDER_COMBINER = new DoubleBlockCombiner.Combiner<>() {
            public Optional<MenuProvider> acceptDouble(final AstroswitchPanelBlockEntity p_51604_, final AstroswitchPanelBlockEntity p_51605_) {
                final Container container = new CompoundContainer(p_51604_, p_51605_);
                return Optional.of(new MenuProvider() {
                    @Nullable
                    public AbstractContainerMenu createMenu(int p_51622_, Inventory p_51623_, Player p_51624_) {
                        if (p_51604_.canOpen(p_51624_) && p_51605_.canOpen(p_51624_)) {
                            p_51604_.unpackLootTable(p_51623_.player);
                            p_51605_.unpackLootTable(p_51623_.player);
                            return ModMenus.ASTROSWITCH_PANEL_DOUBLE_GUI(p_51622_, p_51623_);
                        } else {
                            return null;
                        }
                    }

                    public Component getDisplayName() {
                        if (p_51604_.hasCustomName()) {
                            return p_51604_.getDisplayName();
                        } else {
                            return (Component) (p_51605_.hasCustomName() ? p_51605_.getDisplayName() : Component.translatable("container.astroswitchPanel"));
                        }
                    }
                });
            }

            public Optional<MenuProvider> acceptSingle(AstroswitchPanelBlockEntity p_51602_) {
                return Optional.of(p_51602_);
            }

            public Optional<MenuProvider> acceptNone() {
                return Optional.empty();
            }
        };
	}
}
