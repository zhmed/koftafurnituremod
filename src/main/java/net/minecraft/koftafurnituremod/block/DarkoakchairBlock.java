
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

public class DarkoakchairBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public DarkoakchairBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
			default -> Shapes.or(box(14, 0, 14, 16, 15, 16), box(14, 0, 0, 16, 15, 2), box(-2, 17, 0, 0, 19, 15), box(16, 17, 0, 18, 19, 15), box(0, 0, 0, 2, 15, 2), box(0, 0, 14, 2, 15, 16), box(0, 15, 0, 16, 17, 14), box(0, 15, 14, 16, 32, 16));
			case NORTH -> Shapes.or(box(0, 0, 0, 2, 15, 2), box(0, 0, 14, 2, 15, 16), box(16, 17, 1, 18, 19, 16), box(-2, 17, 1, 0, 19, 16), box(14, 0, 14, 16, 15, 16), box(14, 0, 0, 16, 15, 2), box(0, 15, 2, 16, 17, 16), box(0, 15, 0, 16, 32, 2));
			case EAST -> Shapes.or(box(14, 0, 0, 16, 15, 2), box(0, 0, 0, 2, 15, 2), box(0, 17, 16, 15, 19, 18), box(0, 17, -2, 15, 19, 0), box(0, 0, 14, 2, 15, 16), box(14, 0, 14, 16, 15, 16), box(0, 15, 0, 14, 17, 16), box(14, 15, 0, 16, 32, 16));
			case WEST -> Shapes.or(box(0, 0, 14, 2, 15, 16), box(14, 0, 14, 16, 15, 16), box(1, 17, -2, 16, 19, 0), box(1, 17, 16, 16, 19, 18), box(14, 0, 0, 16, 15, 2), box(0, 0, 0, 2, 15, 2), box(2, 15, 0, 16, 17, 16), box(0, 15, 0, 2, 32, 16));
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
