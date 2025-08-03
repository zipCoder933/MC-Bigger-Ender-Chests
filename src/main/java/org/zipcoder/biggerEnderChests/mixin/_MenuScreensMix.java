package org.zipcoder.biggerEnderChests.mixin;

import org.zipcoder.biggerEnderChests.ChestMenus;
import org.zipcoder.biggerEnderChests.CustomEndChestScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static org.zipcoder.biggerEnderChests.BiggerEnderChests.printMixin;

@Mixin(value = MenuScreens.class)
public abstract class _MenuScreensMix {

    @Shadow
    private static <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> void register(MenuType<? extends M> p_96207_, MenuScreens.ScreenConstructor<M, U> p_96208_) {
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injectedTail(CallbackInfo ci) {
        printMixin();
        register(ChestMenus.DIAMOND, CustomEndChestScreen::new);
        register(ChestMenus.EMERALD, CustomEndChestScreen::new);
        register(ChestMenus.NETHERITE, CustomEndChestScreen::new);
    }
}