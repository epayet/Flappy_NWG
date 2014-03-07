package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.StayInScreenComponent;
import com.jak.flappy.component.VelocityComponent;

/**
 * Created by manu on 3/6/14.
 */
public class VelocitySystem extends EntityProcessingSystem{
    @Mapper
    private ComponentMapper<RectangleComponent> rectangleMapper;
    @Mapper
    private ComponentMapper<VelocityComponent> velocityMapper;
    @Mapper
    private ComponentMapper<StayInScreenComponent> stayInScreenMapper;

    public VelocitySystem() {
        super(Aspect.getAspectForAll(VelocityComponent.class, RectangleComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        RectangleComponent rectangle = rectangleMapper.get(entity);
        VelocityComponent velocity = velocityMapper.get(entity);
        StayInScreenComponent stayInScreen = stayInScreenMapper.getSafe(entity);

        rectangle.setX(rectangle.getX() + velocity.getX() * world.getDelta());
        rectangle.setY(rectangle.getY() + velocity.getY() * world.getDelta());

        if(stayInScreen != null ) {
            if(rectangle.getX() < 0) {
                rectangle.setX(0);
            }
        }
    }
}
