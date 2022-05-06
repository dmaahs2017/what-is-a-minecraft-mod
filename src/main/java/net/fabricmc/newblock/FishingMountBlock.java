package net.fabricmc.newblock;

import net.minecraft.block.*;
import net.minecraft.util.math.*;
import net.minecraft.util.shape.*;
import net.minecraft.world.*;

public class FishingMountBlock extends Block {
    public FishingMountBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return makeShape();
    }

    public VoxelShape makeShape() {
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0, 0.1875, 0.8125, 0.0625, 0.8125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.0625, 0.1875, 0.8125, 0.5625, 0.25));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.0625, 0.25, 0.25, 0.5625, 0.75));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.0625, 0.75, 0.8125, 0.5625, 0.8125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.75, 0.0625, 0.25, 0.8125, 0.5625, 0.75));

        return shape;
    }
}
