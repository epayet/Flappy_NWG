package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
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
        camera.update();
    }
}
