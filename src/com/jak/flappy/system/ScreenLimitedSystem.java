package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.jak.flappy.component.*;

/**
 * Created by manu on 09/03/14.
 */
public abstract class ScreenLimitedSystem extends EntityProcessingSystem{
    public ScreenLimitedSystem(Aspect aspect) {
        super(aspect);
    }

    @Override
    protected void process(Entity entity) {
        RectangleComponent rectangle = getRectangleComponent(entity);
        CircleComponent circle = getCircleComponent(entity);
        CameraComponent camera = getCameraComponent(entity);

        if(rectangle != null) {
            if(rectangle.getY() > camera.getHeight() - rectangle.getHeight()) {
                rectangle.setY(camera.getHeight() - rectangle.getHeight());
            }
            if(rectangle.getX() > camera.getWidth() - rectangle.getWidth()) {
                rectangle.setX(camera.getWidth() - rectangle.getWidth());
            }
            if(rectangle.getX() < 0) {
                rectangle.setX(0);
            }
            if(rectangle.getY() < 0) {
                rectangle.setY(0);
            }
        }

        if(circle != null) {
            if(circle.getY() > camera.getHeight() - circle.getRadius()) {
                circle.setY(camera.getHeight() - circle.getRadius());
            }
            if(circle.getX() > camera.getWidth() - circle.getRadius()) {
                circle.setX(camera.getWidth() - circle.getRadius());
            }
            if(circle.getX() < circle.getRadius()) {
                circle.setX(circle.getRadius());
            }
            if(circle.getY() < circle.getRadius()) {
                circle.setY(circle.getRadius());
            }
        }
    }

    protected abstract CircleComponent getCircleComponent(Entity entity);
    protected abstract RectangleComponent getRectangleComponent(Entity entity);
    protected abstract CameraComponent getCameraComponent(Entity entity);
}
