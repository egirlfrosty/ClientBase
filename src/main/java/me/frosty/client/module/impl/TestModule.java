package me.frosty.client.module.impl;

import me.frosty.client.module.AbstractModule;
import me.frosty.client.ui.component.module.Position;

public class TestModule extends AbstractModule {

    public TestModule() {
        super("TestModule", "Epic test module!");
        this.setEnabled(true);
    }

    @Override
    public void render(Position position) {
        this.mc.fontRendererObj.drawString("Test Module!", position.getX(), position.getY(), -1);
    }
}
