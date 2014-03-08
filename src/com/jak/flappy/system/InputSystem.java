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
    private int acceleration;
    private int lastMoveDirection;

    public InputSystem(Aspect aspect) {
        super(aspect);
        acceleration = 0;
    }

    @Override
    protected void process(Entity entity) {
        InputComponent inputComponent = getInputComponent(entity);
        VelocityComponent velocity = getVelocityComponent(entity);

        float x = 150;
        if(inputComponent.isKeyPressed(Input.Keys.RIGHT)) {
            setAcceleration(Input.Keys.RIGHT);
            velocity.setX(x + acceleration);
        }
        else if(inputComponent.isKeyPressed(Input.Keys.LEFT)) {
            setAcceleration(Input.Keys.LEFT);
            velocity.setX(-x - acceleration);
        }
        else if(inputComponent.isAccelerometerAvailable()) {
            velocity.setX(inputComponent.getAccelerometerY() * 100);
        }
        else {
            velocity.setX(0);
            acceleration = 0;
        }
    }

    private void setAcceleration(int key) {
        if(lastMoveDirection == key)
            acceleration += 5;
        else
            acceleration = 0;
        lastMoveDirection = key;
    }

    protected abstract InputComponent getInputComponent(Entity entity);
    protected abstract VelocityComponent getVelocityComponent(Entity entity);
}
