package net.fabricmc.newblock;


import net.fabricmc.api.*;
import net.fabricmc.fabric.api.item.v1.*;
import net.fabricmc.fabric.api.object.builder.v1.block.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;

public class BlockMod implements ModInitializer {

    public static final Block NEW_BLOCK = new HelloWorldBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Block FISHING_MOUNT_BLOCK = new FishingMountBlock(FabricBlockSettings.of(Material.DECORATION));

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("randomod", "newblock"), NEW_BLOCK);
        Registry.register(Registry.ITEM,
            new Identifier("randomod", "newblock"),
            new BlockItem(NEW_BLOCK, new FabricItemSettings().group(ItemGroup.MISC))
        );

        Registry.register(Registry.BLOCK, new Identifier("randomod", "fishing_pole_mount"), FISHING_MOUNT_BLOCK);
        Registry.register(Registry.ITEM,
            new Identifier("randomod", "fishing_pole_mount"),
            new BlockItem(FISHING_MOUNT_BLOCK, new FabricItemSettings().group(ItemGroup.MISC))
        );


    }
}
