package com.jak.flappy.system.mock;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.jak.flappy.component.CameraComponent;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.mock.MockCameraComponent;
import com.jak.flappy.system.ScreenLimitedSystem;

/**
 * Created by manu on 09/03/14.
 */
public class MockScreenLimitedSystem extends ScreenLimitedSystem {
    @Mapper
    private ComponentMapper<RectangleComponent> rectangleMapper;
    @Mapper
    private ComponentMapper<MockCameraComponent> cameraMapper;

    @Override
    protected RectangleComponent getRectangleComponent(Entity entity) {
        return rectangleMapper.get(entity);
    }

    @Override
    protected CameraComponent getCameraComponent(Entity entity) {
        return cameraMapper.get(entity);
    }
}
