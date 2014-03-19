package com.jak.flappy.system.graphic;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.jak.flappy.component.InputComponent;
import com.jak.flappy.component.graphic.physics.PhysicBodyComponent;
import com.jak.flappy.input.InputManager;
import com.jak.flappy.world.FlappyWorld;

/**
 * Created by manu on 3/7/14.
 */
public class InputSystem extends EntityProcessingSystem{
    @Mapper
    private ComponentMapper<PhysicBodyComponent> physicBodyMapper;
    private InputManager inputManager;

    public InputSystem(InputManager inputManager) {
        super(Aspect.getAspectForAll(InputComponent.class));
        this.inputManager = inputManager;
    }

    @Override
    protected void process(Entity entity) {
        if(inputManager.isKeyUp(Input.Keys.SPACE) || inputManager.isTouchedUp()) {
            PhysicBodyComponent physicBodyComponent = physicBodyMapper.get(entity);
            Body body = physicBodyComponent.getBody();
            body.applyLinearImpulse(new Vector2(0, 10000000f), body.getWorldCenter(), true);
        }
    }
}
