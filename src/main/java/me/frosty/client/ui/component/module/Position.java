package me.frosty.client.ui.component.module;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Position {

    private final Integer x;
    private final Integer y;

    /**
     * Position Constructor.
     *
     * @param x - The X position of the module.
     * @param y - The Y position of the module.
     * @author frosty
     */
    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}
