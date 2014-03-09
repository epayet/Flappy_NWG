package com.jak.flappy.component;

import com.artemis.Component;

/**
 * Created by manu on 09/03/14.
 */
public class PositionComponent extends Component {
    private float x;
    private float y;

    public PositionComponent(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
}
