package org.zipcoder.biggerEnderChests.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.EnderChestBlockEntity;
import org.zipcoder.biggerEnderChests.CustomEnderChestBlock;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.zipcoder.biggerEnderChests.ModBlocks;

import static org.zipcoder.biggerEnderChests.BiggerEnderChests.MODID;
import static org.zipcoder.biggerEnderChests.BiggerEnderChests.printMixin;


@Mixin(value = Sheets.class)
public abstract class SheetsMix {
    @Shadow
    @Final
    public static ResourceLocation CHEST_SHEET;

    @Unique
    private static Material endChestMaterial(String string) {
        printMixin("material");
        return new Material(CHEST_SHEET, new ResourceLocation(MODID, "entity/chest/" + string));
    }

    @Unique
    private static final Material DIAMOND = endChestMaterial("diamond");

    @Unique
    private static final Material EMERALD = endChestMaterial("emerald");

    @Unique
    private static final Material NETHERITE = endChestMaterial("netherite");

    /**
     * Mixin for rendering chest texture on client (occurs every frame i think)
     *
     * @param blockEntity
     * @param chestType
     * @param bl
     * @param cir
     */

//    private static EnderChestBlockEntity diamondBlockEntity = new EnderChestBlockEntity(BlockPos.ZERO, ModBlocks.DIAMOND_CHEST.defaultBlockState());
//    private static EnderChestBlockEntity emeraldBlockEntity = new EnderChestBlockEntity(BlockPos.ZERO, ModBlocks.EMERALD_CHEST.defaultBlockState());
//    private static EnderChestBlockEntity netheriteBlockEntity = new EnderChestBlockEntity(BlockPos.ZERO, ModBlocks.NETHERITE_CHEST.defaultBlockState());
    @Inject(method = "chooseMaterial(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/level/block/state/properties/ChestType;Z)Lnet/minecraft/client/resources/model/Material;", at = @At("HEAD"), cancellable = true)
    private static void injectedHead(BlockEntity blockEntity, ChestType chestType, boolean bl, CallbackInfoReturnable<Material> cir) {
        if (blockEntity instanceof EnderChestBlockEntity && //Optional, but hopefully improves performance
                blockEntity.getBlockState().getBlock() instanceof CustomEnderChestBlock customEnderChestBlock) {
//            printMixin("Chest render");
            switch (customEnderChestBlock.type) {
                case DIAMOND -> {
                    cir.setReturnValue(DIAMOND);
                }
                case EMERALD -> {
                    cir.setReturnValue(EMERALD);
                }
                case NETHERITE -> {
                    cir.setReturnValue(NETHERITE);
                }
            }
        }
    }
}