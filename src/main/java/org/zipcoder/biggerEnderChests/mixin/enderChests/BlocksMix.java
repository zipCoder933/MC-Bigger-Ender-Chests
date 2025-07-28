package org.zipcoder.biggerEnderChests.mixin.enderChests;

import org.zipcoder.biggerEnderChests.ModBlocks;
import org.zipcoder.biggerEnderChests.enderChests.ChestMenus;
import org.zipcoder.biggerEnderChests.enderChests.ChestType;
import org.zipcoder.biggerEnderChests.enderChests.CustomEnderChestBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static org.zipcoder.biggerEnderChests.BiggerEnderChests.MODID;


@Mixin(value = Blocks.class)
public abstract class BlocksMix {

    @Shadow
    private static Block register(String p_50796_, Block p_50797_) {
        return null;
    }

    @Inject(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/DecoratedPotBlock;<init>(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", shift = At.Shift.BY, by = 2))
    private static void injectedAfter(CallbackInfo ci) {
        ModBlocks.DIAMOND_CHEST = register(
                MODID + ":diamond_ender_chest",
                new CustomEnderChestBlock(
                        BlockBehaviour.Properties.of()
                                .mapColor(MapColor.DIAMOND)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .requiresCorrectToolForDrops()
                                .strength(22.5F, 600.0F)
                                .lightLevel(blockStatex -> 7),
                        ChestType.DIAMOND, () -> ChestMenus.DIAMOND)
        );
        ModBlocks.EMERALD_CHEST = register(
                MODID + ":emerald_ender_chest",
                new CustomEnderChestBlock(
                        BlockBehaviour.Properties.of()
                                .mapColor(MapColor.EMERALD)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .requiresCorrectToolForDrops()
                                .strength(22.5F, 600.0F)
                                .lightLevel(blockStatex -> 7),
                        ChestType.EMERALD, () -> ChestMenus.EMERALD)
        );
        ModBlocks.NETHERITE_CHEST = register(
                MODID + ":netherite_ender_chest",
                new CustomEnderChestBlock(
                        BlockBehaviour.Properties.of()
                                .mapColor(MapColor.COLOR_BLACK)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .requiresCorrectToolForDrops()
                                .strength(22.5F, 600.0F)
                                .lightLevel(blockStatex -> 7),
                        ChestType.NETHERITE, () -> ChestMenus.NETHERITE)
        );
    }
}