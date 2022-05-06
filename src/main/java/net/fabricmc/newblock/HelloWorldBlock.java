package net.fabricmc.newblock;

import net.minecraft.block.*;
import net.minecraft.client.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.text.*;
import net.minecraft.util.*;
import net.minecraft.util.hit.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class HelloWorldBlock extends Block {
    public HelloWorldBlock(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult onUse(
        BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit
    ) {
        if (!world.isClient) {
            player.sendMessage(new LiteralText("Hello World!"), false);
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(new LiteralText("Example Block"));
    }
}
