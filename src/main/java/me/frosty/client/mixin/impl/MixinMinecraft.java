package me.frosty.client.mixin.impl;

import me.frosty.client.Client;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Inject(method = "startGame", at = @At("RETURN"))
    public void injectStartGame(CallbackInfo ci) {
        new Client().start();
    }

    @Inject(method = "shutdownMinecraftApplet", at = @At("HEAD"))
    public void injectShutdown(CallbackInfo ci) {
        Client.getInstance().stop();
    }
}
