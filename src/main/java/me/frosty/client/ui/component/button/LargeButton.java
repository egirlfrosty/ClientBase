package me.frosty.client.ui.component.button;

import lombok.AllArgsConstructor;
import me.frosty.client.ui.UIElement;
import me.frosty.client.util.RenderUtil;

import java.awt.*;

@AllArgsConstructor
public class LargeButton extends UIElement {

    private final String text;

    @Override
    public void renderElement(float mouseX, float mouseY) {
        RenderUtil.drawRect(this.x, this.y, this.x + this.width, this.y + this.height, new Color(0,0,0, 100).getRGB());        //Cba to do this.
        this.mc.fontRendererObj.drawString(this.text, this.x + this.width / 2 - (this.mc.fontRendererObj.getStringWidth(this.text) / 2) , this.y + 4, -1);
    }

    @Override public void mouseClicked(float mouseX, float mouseY, int button) {}

    @Override public void mouseReleased(float mouseX, float mouseY) {}
}
