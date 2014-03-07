package com.jak.flappy.system.mock;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.jak.flappy.component.InputComponent;
import com.jak.flappy.component.mock.MockInputComponent;
import com.jak.flappy.component.VelocityComponent;
import com.jak.flappy.system.InputSystem;

/**
 * Created by manu on 3/7/14.
 */
public class MockInputSystem extends InputSystem {
    @Mapper
    private ComponentMapper<MockInputComponent> inputMapper;
    @Mapper
    private ComponentMapper<VelocityComponent> velocityMapper;

    public MockInputSystem() {
        super(Aspect.getAspectForAll(MockInputComponent.class));
    }

    @Override
    protected InputComponent getInputComponent(Entity entity) {
        return inputMapper.get(entity);
    }

    @Override
    protected VelocityComponent getVelocityComponent(Entity entity) {
        return velocityMapper.get(entity);
    }
}
