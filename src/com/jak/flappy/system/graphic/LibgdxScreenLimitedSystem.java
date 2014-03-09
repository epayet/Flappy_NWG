package com.jak.flappy.system.graphic;

import com.artemis.Component;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.jak.flappy.component.CameraComponent;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.graphic.LibgdxCameraComponent;
import com.jak.flappy.system.ScreenLimitedSystem;

/**
 * Created by manu on 09/03/14.
 */
public class LibgdxScreenLimitedSystem extends ScreenLimitedSystem {
    @Mapper
    private ComponentMapper<RectangleComponent> rectangleMapper;
    @Mapper
    private ComponentMapper<LibgdxCameraComponent> cameraMapper;

    @Override
    protected RectangleComponent getRectangleComponent(Entity entity) {
        return rectangleMapper.get(entity);
    }

    @Override
    protected CameraComponent getCameraComponent(Entity entity) {
        return cameraMapper.get(entity);
    }
}
