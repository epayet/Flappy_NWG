package com.jak.flappy.component;

import com.artemis.Component;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by manu on 05/03/14.
 */
public class RectangleComponent extends Component {
    public Rectangle rectangle;

    public RectangleComponent(float x, float y, float width, float height) {
        this.rectangle = new Rectangle(x, y, width, height);
    }
}
