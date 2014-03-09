package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.jak.flappy.component.CameraComponent;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.StayInScreenComponent;
import com.jak.flappy.component.VelocityComponent;

/**
 * Created by manu on 09/03/14.
 */
public abstract class ScreenLimitedSystem extends EntityProcessingSystem{
    public ScreenLimitedSystem() {
        super(Aspect.getAspectForAll(StayInScreenComponent.class, VelocityComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        RectangleComponent rectangle = getRectangleComponent(entity);
        if(rectangle.getX() < 0) {
            rectangle.setX(0);
        }
        if(rectangle.getY() < 0) {
            rectangle.setY(0);
        }

        CameraComponent camera = getCameraComponent(entity);
        if(camera != null) {
            if(rectangle.getY() > camera.getHeight() - rectangle.getHeight()) {
                rectangle.setY(camera.getHeight() - rectangle.getHeight());
            }
            if(rectangle.getX() > camera.getWidth() - rectangle.getWidth()) {
                rectangle.setX(camera.getWidth() - rectangle.getWidth());
            }
        }
    }

    protected abstract RectangleComponent getRectangleComponent(Entity entity);
    protected abstract CameraComponent getCameraComponent(Entity entity);
}
