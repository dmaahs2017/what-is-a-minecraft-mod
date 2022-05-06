package net.fabricmc.newblock;


import net.fabricmc.api.*;
import net.fabricmc.fabric.api.item.v1.*;
import net.fabricmc.fabric.api.object.builder.v1.block.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;

public class BlockMod implements ModInitializer {

    public static final Block NEW_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("randomod", "newblock"), NEW_BLOCK);
        Registry.register(Registry.ITEM,
            new Identifier("randomod", "newblock"),
            new BlockItem(NEW_BLOCK, new FabricItemSettings().group(ItemGroup.MISC))
        );


    }
}
