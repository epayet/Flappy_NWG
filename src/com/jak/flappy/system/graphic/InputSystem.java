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

    public InputSystem() {
        super(Aspect.getAspectForAll(InputComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        FlappyWorld flappyWorld = (FlappyWorld)world;
        InputManager inputManager = flappyWorld.getInputManager();

        if(inputManager.isKeyUp(Input.Keys.SPACE)) {
            PhysicBodyComponent physicBodyComponent = physicBodyMapper.get(entity);
            Body body = physicBodyComponent.getBody();
            body.applyLinearImpulse(new Vector2(0, 100000), body.getWorldCenter(), true);
        }
    }
}
