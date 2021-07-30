package me.frosty.client.module;

import lombok.Getter;
import me.frosty.client.util.Logger;
import me.frosty.client.module.impl.TestModule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleManager {

    @Getter private final List<AbstractModule> modules = new ArrayList<>();

    public ModuleManager() {
        this.register(new TestModule());

        Logger.info("Registered " + this.modules.size() + " Modules!");
    }

    /**
     * Registers a module.
     *
     * @author frosty
     */
    public void register(final AbstractModule module) {
        this.modules.add(module);
    }

    /**
     * Gets all enabled modules as a list.
     *
     * @author frosty
     * @return List<AbstractModule>.
     */
    public List<AbstractModule> getEnabledModules() {
        return this.modules.stream().filter(AbstractModule::getEnabled).collect(Collectors.toList());
    }

    /**
     * Renders the hud to the display.
     *
     * @author frosty
     * @see me.frosty.client.mixin.impl.MixinGuiIngame
     */
    public void renderHud() {
        for (AbstractModule module : this.getEnabledModules()) {
            module.render(module.getPosition());
        }
    }
}
