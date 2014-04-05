package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.jak.flappy.Constants;
import com.jak.flappy.component.InputComponent;
import com.jak.flappy.component.physics.PhysicBodyComponent;
import com.jak.flappy.manager.input.InputManager;
import com.jak.flappy.world.FlappyWorld;
import com.jak.flappy.world.FlappyWorldUtils;

/**
 * Created by manu on 3/7/14.
 */
public class MovingFlappySystem extends EntityProcessingSystem{
    @Mapper
    private ComponentMapper<PhysicBodyComponent> physicBodyMapper;
    private InputManager inputManager;

    public MovingFlappySystem(FlappyWorld flappyWorld) {
        super(Aspect.getAspectForAll(InputComponent.class));
        this.inputManager = flappyWorld.getInputManager();
    }

    @Override
    protected void process(Entity entity) {
        if(!FlappyWorldUtils.isFlappyDead(world) && (inputManager.isKeyUp(Input.Keys.SPACE) || inputManager.isTouchedUp())) {
            PhysicBodyComponent physicBodyComponent = physicBodyMapper.get(entity);
            Body body = physicBodyComponent.getBody();
            float force = 100 * Constants.WORLD_TO_BOX;
            body.applyLinearImpulse(new Vector2(0, force), body.getWorldCenter(), true);
        }
    }
}
