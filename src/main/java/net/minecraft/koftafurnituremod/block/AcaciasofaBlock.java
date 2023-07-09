
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

public class AcaciasofaBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public AcaciasofaBlock() {
		super(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION).sound(SoundType.WOOL).strength(5f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
			default -> Shapes.or(box(14, 0, 15, 16, 1, 17), box(0, 0, 15, 2, 1, 17), box(0, 0, 4, 2, 1, 6), box(14, 0, 4, 16, 1, 6), box(-4, 8, 4, 0, 13, 17), box(16, 8, 4, 20, 13, 17), box(0, 1, 4, 16, 8, 17), box(0, 4, 0, 16, 23, 4));
			case NORTH -> Shapes.or(box(0, 0, -1, 2, 1, 1), box(14, 0, -1, 16, 1, 1), box(14, 0, 10, 16, 1, 12), box(0, 0, 10, 2, 1, 12), box(16, 8, -1, 20, 13, 12), box(-4, 8, -1, 0, 13, 12), box(0, 1, -1, 16, 8, 12), box(0, 4, 12, 16, 23, 16));
			case EAST -> Shapes.or(box(15, 0, 0, 17, 1, 2), box(15, 0, 14, 17, 1, 16), box(4, 0, 14, 6, 1, 16), box(4, 0, 0, 6, 1, 2), box(4, 8, 16, 17, 13, 20), box(4, 8, -4, 17, 13, 0), box(4, 1, 0, 17, 8, 16), box(0, 4, 0, 4, 23, 16));
			case WEST -> Shapes.or(box(-1, 0, 14, 1, 1, 16), box(-1, 0, 0, 1, 1, 2), box(10, 0, 0, 12, 1, 2), box(10, 0, 14, 12, 1, 16), box(-1, 8, -4, 12, 13, 0), box(-1, 8, 16, 12, 13, 20), box(-1, 1, 0, 12, 8, 16), box(12, 4, 0, 16, 23, 16));
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
