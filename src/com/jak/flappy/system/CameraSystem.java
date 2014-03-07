package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.jak.flappy.component.CameraComponent;

/**
 * Created by manu on 3/7/14.
 */
public class CameraSystem extends EntityProcessingSystem {
    @Mapper
    private ComponentMapper<CameraComponent> cameraMapper;

    public CameraSystem() {
        super(Aspect.getAspectForAll(CameraComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        CameraComponent camera = cameraMapper.get(entity);

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.getCamera().update();
    }
}
