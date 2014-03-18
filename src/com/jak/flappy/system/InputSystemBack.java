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
public abstract class InputSystemBack extends EntityProcessingSystem{

    public InputSystemBack(Aspect aspect) {
        super(aspect);
    }

    @Override
    protected void process(Entity entity) {
        InputComponent inputComponent = getInputComponent(entity);
        VelocityComponent velocity = getVelocityComponent(entity);

        float x = 400;
        if(inputComponent.isKeyPressed(Input.Keys.RIGHT)) {
            velocity.setX(x);
        }
        else if(inputComponent.isKeyPressed(Input.Keys.LEFT)) {
            velocity.setX(-x);
        }
        else if(inputComponent.isAccelerometerAvailable()) {
            //between -10 and 10
            velocity.setX(inputComponent.getAccelerometerY() * 100);
        }
        else {
            velocity.setX(0);
        }

        if(inputComponent.isKeyUp(Input.Keys.SPACE) || inputComponent.isTouchedUp()) {
            velocity.setY(5000);
            if(inputComponent.isKeyPressed(Input.Keys.RIGHT))
                velocity.setX(1000);
            else if(inputComponent.isKeyPressed(Input.Keys.LEFT))
                velocity.setX(-1000);
        }
    }

    protected abstract InputComponent getInputComponent(Entity entity);
    protected abstract VelocityComponent getVelocityComponent(Entity entity);
}
