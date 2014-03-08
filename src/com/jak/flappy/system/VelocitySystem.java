package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.jak.flappy.component.CameraComponent;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.StayInScreenComponent;
import com.jak.flappy.component.VelocityComponent;

/**
 * Created by manu on 3/6/14.
 */
public abstract class VelocitySystem extends EntityProcessingSystem{
    public VelocitySystem() {
        super(Aspect.getAspectForAll(VelocityComponent.class, RectangleComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        RectangleComponent rectangle = getRectangleComponent(entity);
        VelocityComponent velocity = getVelocityComponent(entity);
        StayInScreenComponent stayInScreen = getStayInScreenComponent(entity);

        rectangle.setX(rectangle.getX() + velocity.getX() * world.getDelta());
        rectangle.setY(rectangle.getY() + velocity.getY() * world.getDelta());

        if(stayInScreen != null ) {
            if(rectangle.getX() < 0) {
                rectangle.setX(0);
            }
            if(rectangle.getY() < 0) {
                rectangle.setY(0);
            }

            CameraComponent camera = getCameraComponent(entity);
            if(camera != null) {
                if(rectangle.getY() > camera.getHeight()) {
                    rectangle.setY(camera.getHeight());
                }
                if(rectangle.getX() > camera.getWidth() - rectangle.getWidth()) {
                    rectangle.setX(camera.getWidth() - rectangle.getWidth());
                }
            }
        }
    }

    protected abstract CameraComponent getCameraComponent(Entity entity);
    protected abstract RectangleComponent getRectangleComponent(Entity entity);
    protected abstract VelocityComponent getVelocityComponent(Entity entity);
    protected abstract StayInScreenComponent getStayInScreenComponent(Entity entity);
}
