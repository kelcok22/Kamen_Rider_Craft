package com.kelco.kamenridercraft.block.storageBlock;

import com.kelco.kamenridercraft.block.entity.AstroswitchRackBlockEntity;
import com.kelco.kamenridercraft.block.entity.ModBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.CompoundContainer;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class AstroswitchRackBlock extends ChestBlock {
    public AstroswitchRackBlock(Properties properties, Supplier<BlockEntityType<? extends ChestBlockEntity>> blockEntityType) {
        super(properties, blockEntityType);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(TYPE, ChestType.SINGLE).setValue(WATERLOGGED, false));
    }
        public static final MapCodec<AstroswitchRackBlock> CODEC = simpleCodec((p_304364_) -> {
            return new AstroswitchRackBlock(p_304364_, ModBlockEntities.ASTROSWITCH_RACK_BE::get);
        });

    public static DoubleBlockCombiner.@NotNull BlockType getBlockType(BlockState state) {
        ChestType chesttype = state.getValue(TYPE);
        if (chesttype == ChestType.SINGLE) {
            return DoubleBlockCombiner.BlockType.SINGLE;
        } else {
            return chesttype == ChestType.RIGHT ? DoubleBlockCombiner.BlockType.FIRST : DoubleBlockCombiner.BlockType.SECOND;
        }
    }

    public static final DirectionProperty FACING;
    public static final EnumProperty<ChestType> TYPE;
    public static final BooleanProperty WATERLOGGED;
    protected static final VoxelShape NORTH_AABB;
    protected static final VoxelShape SOUTH_AABB;
    protected static final VoxelShape WEST_AABB;
    protected static final VoxelShape EAST_AABB;
    protected static final VoxelShape AABB;
    private static final DoubleBlockCombiner.Combiner<ChestBlockEntity, Optional<Container>> CHEST_COMBINER;
    private static final DoubleBlockCombiner.Combiner<ChestBlockEntity, Optional<MenuProvider>> MENU_PROVIDER_COMBINER;

    @Nullable
    public static Container getContainer(AstroswitchRackBlock chest, BlockState state, Level level, BlockPos pos, boolean override) {
        return (Container)((Optional)chest.combine(state, level, pos, override).apply(CHEST_COMBINER)).orElse((Object)null);
    }
    public DoubleBlockCombiner.NeighborCombineResult<? extends AstroswitchRackBlockEntity> combine(BlockState state, Level level, BlockPos pos, boolean override) {
        BiPredicate bipredicate = null;
        if (override) {
            bipredicate = (p_51578_, p_51579_) -> {
                return false;
            };
        }

        return DoubleBlockCombiner.combineWithNeigbour((BlockEntityType)this.blockEntityType.get(), AstroswitchRackBlock::getBlockType, AstroswitchRackBlock::getConnectedDirection, FACING, state, level, pos, bipredicate);
    }

    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    protected BlockState mirror(BlockState state, Mirror mirror) {
        BlockState rotated = state.rotate(mirror.getRotation(state.getValue(FACING)));
        return mirror == Mirror.NONE ? rotated : rotated.setValue(TYPE, rotated.getValue(TYPE).getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, TYPE, WATERLOGGED});
    }

    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (blockentity instanceof AstroswitchRackBlockEntity) {
            ((AstroswitchRackBlockEntity)blockentity).recheckOpen();
        }

    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        TYPE = BlockStateProperties.CHEST_TYPE;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        NORTH_AABB = Block.box(1.0, 0.0, 0.0, 15.0, 14.0, 15.0);
        SOUTH_AABB = Block.box(1.0, 0.0, 1.0, 15.0, 14.0, 16.0);
        WEST_AABB = Block.box(0.0, 0.0, 1.0, 15.0, 14.0, 15.0);
        EAST_AABB = Block.box(1.0, 0.0, 1.0, 16.0, 14.0, 15.0);
        AABB = Block.box(1.0, 0.0, 1.0, 15.0, 14.0, 15.0);
        CHEST_COMBINER = new DoubleBlockCombiner.Combiner<ChestBlockEntity, Optional<Container>>() {
            public Optional<Container> acceptDouble(ChestBlockEntity p_51591_, ChestBlockEntity p_51592_) {
                return Optional.of(new CompoundContainer(p_51591_, p_51592_));
            }

            public Optional<Container> acceptSingle(ChestBlockEntity p_51589_) {
                return Optional.of(p_51589_);
            }

            public Optional<Container> acceptNone() {
                return Optional.empty();
            }
        };
        MENU_PROVIDER_COMBINER = new DoubleBlockCombiner.Combiner<ChestBlockEntity, Optional<MenuProvider>>() {
            public Optional<MenuProvider> acceptDouble(final ChestBlockEntity p_51604_, final ChestBlockEntity p_51605_) {
                final Container container = new CompoundContainer(p_51604_, p_51605_);
                return Optional.of(new MenuProvider() {
                    @Nullable
                    public AbstractContainerMenu createMenu(int p_51622_, Inventory p_51623_, Player p_51624_) {
                        if (p_51604_.canOpen(p_51624_) && p_51605_.canOpen(p_51624_)) {
                            p_51604_.unpackLootTable(p_51623_.player);
                            p_51605_.unpackLootTable(p_51623_.player);
                            return ChestMenu.sixRows(p_51622_, p_51623_, container);
                        } else {
                            return null;
                        }
                    }

                    public Component getDisplayName() {
                        if (p_51604_.hasCustomName()) {
                            return p_51604_.getDisplayName();
                        } else {
                            return (Component)(p_51605_.hasCustomName() ? p_51605_.getDisplayName() : Component.translatable("container.chestDouble"));
                        }
                    }
                });
            }

            public Optional<MenuProvider> acceptSingle(ChestBlockEntity p_51602_) {
                return Optional.of(p_51602_);
            }

            public Optional<MenuProvider> acceptNone() {
                return Optional.empty();
            }
        };
    }

}
