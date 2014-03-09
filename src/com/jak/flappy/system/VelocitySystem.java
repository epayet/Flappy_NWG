package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.jak.flappy.component.*;

/**
 * Created by manu on 3/6/14.
 */
public abstract class VelocitySystem extends EntityProcessingSystem{
    public VelocitySystem() {
        super(Aspect.getAspectForAll(VelocityComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        VelocityComponent velocity = getVelocityComponent(entity);
        PositionComponent position = getPositionComponent(entity);

        position.setX(position.getX() + velocity.getX() * world.getDelta());
        position.setY(position.getY() + velocity.getY() * world.getDelta());
    }

    private PositionComponent getPositionComponent(Entity entity) {
        RectangleComponent rectangle = getRectangleComponent(entity);
        CircleComponent circle = getCircleComponent(entity);

        PositionComponent position = null;

        if(rectangle != null)
            position = rectangle;

        if(circle != null)
            position = circle;

        return position;
    }

    protected abstract CircleComponent getCircleComponent(Entity entity);
    protected abstract RectangleComponent getRectangleComponent(Entity entity);
    protected abstract VelocityComponent getVelocityComponent(Entity entity);
}
