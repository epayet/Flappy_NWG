package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.jak.flappy.component.InputComponent;
import com.jak.flappy.component.graphic.physics.PhysicBodyComponent;
import com.jak.flappy.world.FlappyWorld;

/**
 * Created by manu on 3/19/14.
 */
public class CenterCameraFlappySystem extends EntityProcessingSystem {
    @Mapper
    private ComponentMapper<PhysicBodyComponent> physicBodyMapper;
    private OrthographicCamera camera;

    public CenterCameraFlappySystem(FlappyWorld flappyWorld) {
        super(Aspect.getAspectForAll(PhysicBodyComponent.class, InputComponent.class));
        this.camera = flappyWorld.getCamera();
    }

    @Override
    protected void process(Entity entity) {
        PhysicBodyComponent physicBodyComponent = physicBodyMapper.get(entity);
        Body body = physicBodyComponent.getBody();
        Vector3 position = new Vector3(body.getPosition(), 0);
        //camera.unproject(position);
        camera.translate(0, 0);
    }
}
