package com.jak.flappy.component.graphic;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Color;

/**
 * Created by manu on 3/7/14.
 */
public class DrawingComponent extends Component{
    private Color color;

    public DrawingComponent(float r, float g, float b, float a) {
        this.color = new Color(r, g, b, a);
    }

    public DrawingComponent() {
        this(255, 255, 255, 1);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
