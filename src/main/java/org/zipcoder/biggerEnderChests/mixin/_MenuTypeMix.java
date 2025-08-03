package org.zipcoder.biggerEnderChests.mixin;

import org.zipcoder.biggerEnderChests.ChestMenus;
import org.zipcoder.biggerEnderChests.ChestType;
import org.zipcoder.biggerEnderChests.CustomChestMenu;
import net.minecraft.world.flag.FeatureElement;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static org.zipcoder.biggerEnderChests.BiggerEnderChests.MODID;
import static org.zipcoder.biggerEnderChests.BiggerEnderChests.printMixin;


@Mixin(value = MenuType.class)
public abstract class _MenuTypeMix<T extends AbstractContainerMenu> implements FeatureElement {

    @Shadow
    private static <T extends AbstractContainerMenu> MenuType<T> register(String p_39989_, MenuType.MenuSupplier<T> p_39990_) {
        return null;
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injectedTail(CallbackInfo ci) {
        printMixin();
        ChestMenus.DIAMOND = register(MODID + ":diamond_chest", (id, inventory) -> new CustomChestMenu(ChestType.DIAMOND, id, inventory, () -> ChestMenus.DIAMOND));
        ChestMenus.EMERALD = register(MODID + ":emerald_chest", (id, inventory) -> new CustomChestMenu(ChestType.EMERALD, id, inventory, () -> ChestMenus.EMERALD));
        ChestMenus.NETHERITE = register(MODID + ":netherite_chest", (id, inventory) -> new CustomChestMenu(ChestType.NETHERITE, id, inventory, () -> ChestMenus.NETHERITE));
    }
}