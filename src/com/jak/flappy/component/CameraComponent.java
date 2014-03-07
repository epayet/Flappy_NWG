package com.jak.flappy.component;

import com.artemis.Component;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by manu on 3/7/14.
 */
public class CameraComponent extends Component {
    private OrthographicCamera camera;
    private float width;
    private float height;

    public CameraComponent(float width, float height) {
        this.width = width;
        this.height = height;

        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }
}
