
package net.minecraft.koftafurnituremod.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

public class DarkoakbedBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public DarkoakbedBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(15f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(21, 0, -8, 23, 1, -7), box(21, 0, 7, 23, 1, 8), box(-9, 0, 7, -7, 1, 8), box(-9, 0, 21, -7, 1, 22), box(21, 0, 21, 23, 1, 22), box(-9, 0, -8, -7, 1, -7), box(21, 8, -8, 23, 17, 22), box(-7, 1, -8, 23, 8, 22),
					box(-9, 1, -8, -7, 9, 22), box(20, 3, 11, 24, 5, 20), box(20, 3, -6, 24, 5, 3));
			case NORTH -> Shapes.or(box(-7, 0, 23, -5, 1, 24), box(-7, 0, 8, -5, 1, 9), box(23, 0, 8, 25, 1, 9), box(23, 0, -6, 25, 1, -5), box(-7, 0, -6, -5, 1, -5), box(23, 0, 23, 25, 1, 24), box(-7, 8, -6, -5, 17, 24), box(-7, 1, -6, 23, 8, 24),
					box(23, 1, -6, 25, 9, 24), box(-8, 3, -4, -4, 5, 5), box(-8, 3, 13, -4, 5, 22));
			case EAST -> Shapes.or(box(-8, 0, -7, -7, 1, -5), box(7, 0, -7, 8, 1, -5), box(7, 0, 23, 8, 1, 25), box(21, 0, 23, 22, 1, 25), box(21, 0, -7, 22, 1, -5), box(-8, 0, 23, -7, 1, 25), box(-8, 8, -7, 22, 17, -5), box(-8, 1, -7, 22, 8, 23),
					box(-8, 1, 23, 22, 9, 25), box(11, 3, -8, 20, 5, -4), box(-6, 3, -8, 3, 5, -4));
			case WEST -> Shapes.or(box(23, 0, 21, 24, 1, 23), box(8, 0, 21, 9, 1, 23), box(8, 0, -9, 9, 1, -7), box(-6, 0, -9, -5, 1, -7), box(-6, 0, 21, -5, 1, 23), box(23, 0, -9, 24, 1, -7), box(-6, 8, 21, 24, 17, 23), box(-6, 1, -7, 24, 8, 23),
					box(-6, 1, -9, 24, 9, -7), box(-4, 3, 20, 5, 5, 24), box(13, 3, 20, 22, 5, 24));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
}
