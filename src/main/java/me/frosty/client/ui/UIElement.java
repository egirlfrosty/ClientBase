package me.frosty.client.ui;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.minecraft.client.Minecraft;

/**
 * This class is used for rendering any possible element to the screen!
 *
 * @author frosty
 */
@Setter @Getter
@Accessors(chain = true)
public abstract class UIElement {

    protected Integer x;
    protected Integer y;

    protected Integer width;
    protected Integer height;

    protected final Minecraft mc = Minecraft.getMinecraft();

    /**
     * Sets the size of the element. This can be replaced with chain accessors.
     *
     * @param x      - X Position on the screen to set the element.
     * @param y      - Y Position on the screen to set the element.
     * @param width  - The width of the element.
     * @param height - The height of the element.
     * @author frosty
     */
    public void setSize(Integer x, Integer y, Integer width, Integer height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Renders the element given the mouse X and Y positions.
     *
     * @param mouseX The mouse X position.
     * @param mouseY The mouse Y position.
     * @author frosty
     */
    public abstract void renderElement(float mouseX, float mouseY);

    /**
     * Fired when the mouse is pressed.
     *
     * @param mouseX The mouse X position.
     * @param mouseY The mouse Y position.
     * @param button The mouse button pressed. (Left or right)
     * @author frosty
     */
    public abstract void mouseClicked(float mouseX, float mouseY, int button);

    /**
     * Fired when the mouse is released.
     *
     * @param mouseX The mouse X position.
     * @param mouseY The mouse Y position.
     * @author frosty
     */
    public abstract void mouseReleased(float mouseX, float mouseY);


    /**
     * Checks if the mouse is over the element.
     *
     * @param mouseX The mouse X position.
     * @param mouseY The mouse Y position.
     * @author frosty
     */
    public boolean mouseInside(float mouseX, float mouseY) {
        return mouseX >= this.x && mouseY >= this.y && mouseX <= this.x + this.width && mouseY <= this.y + this.height;
    }
}
