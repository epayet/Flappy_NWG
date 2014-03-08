package com.jak.flappy.system.graphic;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.jak.flappy.component.graphic.LibgdxCameraComponent;

/**
 * Created by manu on 3/7/14.
 */
public class CameraSystem extends EntityProcessingSystem {
    @Mapper
    private ComponentMapper<LibgdxCameraComponent> cameraMapper;

    public CameraSystem() {
        super(Aspect.getAspectForAll(LibgdxCameraComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        LibgdxCameraComponent cameraComponent = cameraMapper.get(entity);
        Camera camera = cameraComponent.getCamera();

        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
    }
}
