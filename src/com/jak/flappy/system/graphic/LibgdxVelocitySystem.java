package com.jak.flappy.system.graphic;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.jak.flappy.component.CameraComponent;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.StayInScreenComponent;
import com.jak.flappy.component.VelocityComponent;
import com.jak.flappy.component.graphic.LibgdxCameraComponent;
import com.jak.flappy.system.VelocitySystem;

/**
 * Created by manu on 08/03/14.
 */
public class LibgdxVelocitySystem extends VelocitySystem {
    @Mapper
    private ComponentMapper<RectangleComponent> rectangleMapper;
    @Mapper
    private ComponentMapper<VelocityComponent> velocityMapper;
    @Mapper
    private ComponentMapper<StayInScreenComponent> stayInScreenMapper;
    @Mapper
    ComponentMapper<LibgdxCameraComponent> cameraMapper;

    @Override
    protected CameraComponent getCameraComponent(Entity entity) {
        return cameraMapper.get(entity);
    }

    @Override
    protected RectangleComponent getRectangleComponent(Entity entity) {
        return rectangleMapper.get(entity);
    }

    @Override
    protected VelocityComponent getVelocityComponent(Entity entity) {
        return velocityMapper.get(entity);
    }

    @Override
    protected StayInScreenComponent getStayInScreenComponent(Entity entity) {
        return stayInScreenMapper.getSafe(entity);
    }
}
