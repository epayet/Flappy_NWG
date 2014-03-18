package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Input;
import com.jak.flappy.component.InputComponent;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.VelocityComponent;

/**
 * Created by manu on 3/7/14.
 */
public class InputSystem extends EntityProcessingSystem{

    public InputSystem() {
        super(Aspect.getAspectForAll(InputComponent.class));
    }

    @Override
    protected void process(Entity entity) {

    }
}
