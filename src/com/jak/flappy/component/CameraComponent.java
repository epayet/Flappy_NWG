package com.jak.flappy.component;

import com.artemis.Component;

/**
 * Created by manu on 08/03/14.
 */
public abstract class CameraComponent extends Component {
    private float width;
    private float height;

    public CameraComponent(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}
