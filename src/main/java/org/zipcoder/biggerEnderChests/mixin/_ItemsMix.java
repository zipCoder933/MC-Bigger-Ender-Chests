package org.zipcoder.biggerEnderChests.mixin;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.zipcoder.biggerEnderChests.ModBlocks;
import org.zipcoder.biggerEnderChests.ModItems;

import static org.zipcoder.biggerEnderChests.BiggerEnderChests.printMixin;

@Mixin(value = Items.class)
public abstract class _ItemsMix {

    @Shadow
    private static Item registerBlock(Block p_42806_) {
        return null;
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injectedTail(CallbackInfo ci) {
        printMixin();
        ModItems.DIAMOND_CHEST = registerBlock(ModBlocks.DIAMOND_CHEST);
        ModItems.EMERALD_CHEST = registerBlock(ModBlocks.EMERALD_CHEST);
        ModItems.NETHERITE_CHEST = registerBlock(ModBlocks.NETHERITE_CHEST);
    }
}