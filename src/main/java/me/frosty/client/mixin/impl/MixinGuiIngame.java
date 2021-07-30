package me.frosty.client.mixin.impl;

import me.frosty.client.Client;
import net.minecraft.client.gui.GuiIngame;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngame.class)
public class MixinGuiIngame {

    @Inject(method = "renderGameOverlay", at = @At("RETURN"))
    public void injectRenderGameOverlay(float partialTicks, CallbackInfo ci) {
        Client.getInstance().getModuleManager().renderHud();
    }
}
