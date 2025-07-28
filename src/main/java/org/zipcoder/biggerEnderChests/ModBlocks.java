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
    //Ender chests
    public static Block DIAMOND_CHEST, EMERALD_CHEST, NETHERITE_CHEST;

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
}
