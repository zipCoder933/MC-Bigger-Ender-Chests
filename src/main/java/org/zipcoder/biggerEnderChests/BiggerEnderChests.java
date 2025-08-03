package org.zipcoder.biggerEnderChests;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import static org.zipcoder.biggerEnderChests.ModBlocks.BLOCKS;
import static org.zipcoder.biggerEnderChests.ModItems.ITEMS;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BiggerEnderChests.MODID)
public class BiggerEnderChests {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "bigger_ender_chests";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final void printMixin(){
//        System.out.println("mixin "+System.currentTimeMillis());
    }
    public static final void printMixin(String str){
//        System.out.println("mixin "+str+"  "+System.currentTimeMillis());
    }

    public BiggerEnderChests() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }


}
