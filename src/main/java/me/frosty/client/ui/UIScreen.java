package me.frosty.client.ui;

import net.minecraft.client.gui.GuiScreen;

/*
 * This class is used for rendering a "custom" menu instead of extending GuiScreen.
 * This makes multi-version support easier etc etc.
 */
public abstract class UIScreen extends GuiScreen {

    /**
     * Renders the screen given the mouse X and Y positions.
     *
     * @param mouseX The mouse X position.
     * @param mouseY The mouse Y position.
     * @author frosty
     */
    public abstract void renderUI(float mouseX, float mouseY);

    /**
     * Fired when the mouse is pressed.
     *
     * @param mouseX The mouse X position.
     * @param mouseY The mouse Y position.
     * @param button The mouse button pressed. (Left or right)
     * @author frosty
     */
    public abstract void mousePressed(float mouseX, float mouseY, int button);

    /**
     * Fired when the mouse is released.
     *
     * @param mouseX The mouse X position.
     * @param mouseY The mouse Y position.
     * @author frosty
     */
    public abstract void mouseReleased(float mouseX, float mouseY);

    /*
     * Methods below are just calling our abstract methods.
     */
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderUI(mouseX, mouseY);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        this.mousePressed(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        this.mouseReleased(mouseX, mouseY);
    }
}
