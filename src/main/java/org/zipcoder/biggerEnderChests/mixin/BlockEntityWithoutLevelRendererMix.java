package org.zipcoder.biggerEnderChests.mixin;

import org.zipcoder.biggerEnderChests.ModBlocks;
import org.zipcoder.biggerEnderChests.CustomEnderChestBlock;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.EnderChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static org.zipcoder.biggerEnderChests.BiggerEnderChests.printMixin;

@Mixin(value = BlockEntityWithoutLevelRenderer.class)
public abstract class BlockEntityWithoutLevelRendererMix {

    //This mixin controls the item rendering of the ender chests

    //Cache these for performance
    private static EnderChestBlockEntity diamondBlockEntity = new EnderChestBlockEntity(BlockPos.ZERO, ModBlocks.DIAMOND_CHEST.defaultBlockState());
    private static EnderChestBlockEntity emeraldBlockEntity = new EnderChestBlockEntity(BlockPos.ZERO, ModBlocks.EMERALD_CHEST.defaultBlockState());
    private static EnderChestBlockEntity netheriteBlockEntity = new EnderChestBlockEntity(BlockPos.ZERO, ModBlocks.NETHERITE_CHEST.defaultBlockState());

    /**
     * Tells minecraft what items to render
     * see package net.minecraft.client.renderer renderByItem
     * @param instance
     * @param blockEntity
     * @param poseStack
     * @param mu
     * @param i
     * @param i2
     * @param original
     * @param stack
     * @param p_270899_
     * @param p_108832_
     * @param p_108833_
     * @param p_108834_
     * @param p_108835_
     * @return
     */
    @WrapOperation(method = "renderByItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/blockentity/BlockEntityRenderDispatcher;renderItem(Lnet/minecraft/world/level/block/entity/BlockEntity;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)Z"))
    private boolean wrapOperation(BlockEntityRenderDispatcher instance, BlockEntity blockEntity, PoseStack poseStack, MultiBufferSource mu, int i, int i2, Operation<Boolean> original, ItemStack stack, ItemDisplayContext p_270899_, PoseStack p_108832_, MultiBufferSource p_108833_, int p_108834_, int p_108835_) {
        if (stack.getItem() instanceof BlockItem bi) {
//            printMixin("rbi");
            Block block = bi.getBlock();
            if (block == ModBlocks.DIAMOND_CHEST) blockEntity = diamondBlockEntity;
            else if (block == ModBlocks.EMERALD_CHEST) blockEntity = emeraldBlockEntity;
            else if (block == ModBlocks.NETHERITE_CHEST) blockEntity = netheriteBlockEntity;
        }
        return original.call(instance, blockEntity, poseStack, mu, i, i2);
    }

    /**
     * Tells minecraft that the ender chests are renderable as items
     * We are adding onto if (blockstate.is(Blocks.ENDER_CHEST)) to check if the custom ender chest is an ender chest too.
     * @param original
     * @param itemStack
     * @param itemDisplayContext
     * @param poseStack
     * @param multiBufferSource
     * @param i
     * @param j
     * @return
     */
    @ModifyExpressionValue(method = "renderByItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z", ordinal = 2))
    private boolean modifyExpression(boolean original, ItemStack itemStack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        if (itemStack.getItem() instanceof BlockItem bi) {
//            printMixin("modex");
            if (bi.getBlock()/*.defaultBlockState().getBlock()*/ instanceof CustomEnderChestBlock) {
                return true;
            }
        }
        return original;
    }
}