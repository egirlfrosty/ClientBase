package me.frosty.client;

import lombok.Getter;
import me.frosty.client.module.ModuleManager;
import me.frosty.client.util.Logger;
import org.lwjgl.opengl.Display;

@Getter public final class Client {

    @Getter private static Client instance;

    private ModuleManager moduleManager;

    /**
     * Starts and registers everything!
     *
     * @author frosty
     * @see me.frosty.client.mixin.impl.MixinMinecraft
     */
    public void start() {
        instance = this;
        Display.setTitle("Client - v" + this.getVersion());

        Logger.info("Starting Up.");

        this.moduleManager = new ModuleManager();
        Logger.info("Created Module Manager.");
    }

    /**
     * Called on game shutdown.
     *
     * @author frosty
     * @see me.frosty.client.mixin.impl.MixinMinecraft
     */
    public void stop() {
        Logger.info("Shutting Down.");
    }

    /**
     * Returns the client version.
     *
     * @return String.
     * @author frosty
     */
    public String getVersion() {
        return "1.0.0";
    }
}
