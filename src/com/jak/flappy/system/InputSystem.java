package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Input;
import com.jak.flappy.component.InputComponent;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.VelocityComponent;
import com.jak.flappy.component.graphic.physics.PhysicBodyComponent;

/**
 * Created by manu on 3/7/14.
 */
public class InputSystem extends EntityProcessingSystem{
    @Mapper
    private ComponentMapper<PhysicBodyComponent> physicBodyMapper;

    public InputSystem() {
        super(Aspect.getAspectForAll(InputComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        PhysicBodyComponent physicBodyComponent = physicBodyMapper.get(entity);
        physicBodyComponent.getBody().applyForce(0, 0, 0, 0, true);
    }
}
