package me.frosty.client.module;

import lombok.Getter;
import lombok.Setter;
import me.frosty.client.ui.component.module.Position;
import net.minecraft.client.Minecraft;

@Getter @Setter
public abstract class AbstractModule {

    protected final Minecraft mc = Minecraft.getMinecraft();

    protected final String name;
    protected final String description;

    @Setter private Position position;

    protected Integer width;
    protected Integer height;

    protected Boolean enabled;

    /**
     * Module constructor.
     *
     * @param name        - The name of the module.
     * @param description - The description of the module.
     * @author frosty
     */
    public AbstractModule(String name, String description) {
        this.name = name;
        this.description = description;
        this.position = new Position(5, 5);
    }

    /**
     * Renders the module to the hud.
     *
     * @param position - The modules position object storing its X and Y.
     * @author frosty
     */
    public abstract void render(Position position);

}
