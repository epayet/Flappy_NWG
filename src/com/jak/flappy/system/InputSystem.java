package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Input;
import com.jak.flappy.component.InputComponent;
import com.jak.flappy.component.VelocityComponent;

/**
 * Created by manu on 3/7/14.
 */
public abstract class InputSystem extends EntityProcessingSystem{
    public InputSystem(Aspect aspect) {
        super(aspect);
    }

    @Override
    protected void process(Entity entity) {
        InputComponent inputComponent = getInputComponent(entity);
        VelocityComponent velocity = getVelocityComponent(entity);

        float x = 200;
        if(inputComponent.isKeyPressed(Input.Keys.RIGHT)) {
            velocity.setX(x);
        }
        else if(inputComponent.isKeyPressed(Input.Keys.LEFT)) {
            velocity.setX(-x);
        }
        else {
            velocity.setX(0);
        }
    }

    protected abstract InputComponent getInputComponent(Entity entity);
    protected abstract VelocityComponent getVelocityComponent(Entity entity);
}
