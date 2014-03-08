package com.jak.flappy.system.graphic;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.jak.flappy.component.InputComponent;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.VelocityComponent;
import com.jak.flappy.component.graphic.LibgdxInputComponent;
import com.jak.flappy.component.mock.MockInputComponent;
import com.jak.flappy.system.InputSystem;

/**
 * Created by manu on 08/03/14.
 */
public class LibgdxInputSystem extends InputSystem{
    @Mapper
    private ComponentMapper<LibgdxInputComponent> inputMapper;
    @Mapper
    private ComponentMapper<VelocityComponent> velocityMapper;
    @Mapper
    private ComponentMapper<RectangleComponent> rectangleMapper;

    public LibgdxInputSystem() {
        super(Aspect.getAspectForAll(LibgdxInputComponent.class, VelocityComponent.class));
    }

    @Override
    protected InputComponent getInputComponent(Entity entity) {
        return inputMapper.get(entity);
    }

    @Override
    protected VelocityComponent getVelocityComponent(Entity entity) {
        return velocityMapper.get(entity);
    }

    @Override
    protected RectangleComponent getRectangleComponent(Entity entity) {
        return rectangleMapper.get(entity);
    }
}
