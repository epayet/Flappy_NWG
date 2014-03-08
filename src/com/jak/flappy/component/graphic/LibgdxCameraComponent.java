package com.jak.flappy.component.graphic;

import com.artemis.Component;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.jak.flappy.component.CameraComponent;

/**
 * Created by manu on 3/7/14.
 */
public class LibgdxCameraComponent extends CameraComponent {
    private OrthographicCamera camera;

    public LibgdxCameraComponent(float width, float height) {
        super(width, height);

        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }
}
