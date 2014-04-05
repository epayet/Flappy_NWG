package com.jak.flappy.component.graphic;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Color;

/**
 * Created by manu on 05/04/14.
 */
public class ColorComponent extends Component{
    private Color color;

    public ColorComponent(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
