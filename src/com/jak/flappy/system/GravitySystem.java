package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.jak.flappy.component.GravityComponent;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.VelocityComponent;

/**
 * Created by manu on 3/5/14.
 */
public class GravitySystem extends EntityProcessingSystem{
    @Mapper
    private ComponentMapper<GravityComponent> gravityMapper;
    @Mapper
    private ComponentMapper<VelocityComponent> velocityMapper;

    public GravitySystem() {
        super(Aspect.getAspectForAll(GravityComponent.class, RectangleComponent.class, VelocityComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        GravityComponent gravity = gravityMapper.get(entity);
        VelocityComponent velocity = velocityMapper.get(entity);

        velocity.setX(-(gravity.getGravity() * world.getDelta() / 1000));
    }
}
