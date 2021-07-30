package me.frosty.client.ui.menu;

import me.frosty.client.ui.UIScreen;
import me.frosty.client.ui.component.button.LargeButton;
import me.frosty.client.util.RenderUtil;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiSelectWorld;

import java.awt.*;

public class MainMenu extends UIScreen {

    private final LargeButton singleplayer = new LargeButton("SINGLEPLAYER");
    private final LargeButton multiplayer = new LargeButton("MULTIPLAYER");

    @Override
    public void renderUI(float mouseX, float mouseY) {
        RenderUtil.drawRect(0, 0, this.width, this.height, new Color(150, 150, 150).getRGB());

        this.singleplayer.renderElement(mouseX, mouseY);
        this.multiplayer.renderElement(mouseX, mouseY);

        this.mc.fontRendererObj.drawString("By Frosty!", 3, this.height - 12, -1);
    }

    @Override
    public void initGui() {
        this.singleplayer.setX(this.width / 2 - 100).setY(this.height / 2 - 15).setWidth(200).setHeight(17);
        this.multiplayer.setX(this.width / 2 - 100).setY(this.height / 2 + 15).setWidth(200).setHeight(17);
    }

    @Override
    public void mousePressed(float mouseX, float mouseY, int button) {
        if (this.singleplayer.mouseInside(mouseX, mouseY)) { 
            this.mc.displayGuiScreen(new GuiSelectWorld(this.mc.currentScreen));
        } else if (this.multiplayer.mouseInside(mouseX, mouseY)) {
            this.mc.displayGuiScreen(new GuiMultiplayer(this.mc.currentScreen));
        }
    }

    @Override
    public void mouseReleased(float mouseX, float mouseY) {}
}
