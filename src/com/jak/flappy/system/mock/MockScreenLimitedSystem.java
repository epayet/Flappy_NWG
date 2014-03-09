package com.jak.flappy.system.mock;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.jak.flappy.component.*;
import com.jak.flappy.component.mock.MockCameraComponent;
import com.jak.flappy.system.ScreenLimitedSystem;

/**
 * Created by manu on 09/03/14.
 */
public class MockScreenLimitedSystem extends ScreenLimitedSystem {
    @Mapper
    private ComponentMapper<RectangleComponent> rectangleMapper;
    @Mapper
    private ComponentMapper<CircleComponent> circleMapper;
    @Mapper
    private ComponentMapper<MockCameraComponent> cameraMapper;

    public MockScreenLimitedSystem() {
        super(Aspect.getAspectForAll(StayInScreenComponent.class, VelocityComponent.class, MockCameraComponent.class));
    }

    @Override
    protected CircleComponent getCircleComponent(Entity entity) {
        return circleMapper.get(entity);
    }

    @Override
    protected RectangleComponent getRectangleComponent(Entity entity) {
        return rectangleMapper.get(entity);
    }

    @Override
    protected CameraComponent getCameraComponent(Entity entity) {
        return cameraMapper.get(entity);
    }
}
