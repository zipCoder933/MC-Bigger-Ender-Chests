package org.zipcoder.biggerEnderChests.mixin;

import net.minecraft.world.inventory.PlayerEnderChestContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = PlayerEnderChestContainer.class)
public abstract class _PlayerEnderChestContainerMix {

    private static final int MAX_SIZE = 9 * 70;

    @ModifyConstant(method = "<init>", constant = @Constant(intValue = 27))
    private static int modifyConst(int value) {
        return MAX_SIZE;
    }
}