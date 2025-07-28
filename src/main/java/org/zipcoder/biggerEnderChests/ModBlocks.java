package org.zipcoder.biggerEnderChests;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static org.zipcoder.biggerEnderChests.BiggerEnderChests.MODID;
import static org.zipcoder.biggerEnderChests.ModItems.ITEMS;

public class ModBlocks {
    public static RegistryObject<Block> registerBlockItem(String id, Block block) {
        RegistryObject<Block> blockReg = BLOCKS.register(id, () -> block);
        ITEMS.register(id, () -> new BlockItem(blockReg.get(), new Item.Properties()));
        return blockReg;
    }

    //Ender chests
    public static Block IRON_CHEST, COPPER_CHEST, GOLD_CHEST, LAPIS_CHEST, REDSTONE_CHEST, DIAMOND_CHEST, EMERALD_CHEST, NETHERITE_CHEST;

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);


}
