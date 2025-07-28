package org.zipcoder.biggerEnderChests;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static org.zipcoder.biggerEnderChests.BiggerEnderChests.MODID;

public class ModItems {
    // Create a Deferred Register to hold Items which will all be registered under the namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);


    //Ender chests
    public static Item EMERALD_CHEST, DIAMOND_CHEST, NETHERITE_CHEST;

}
