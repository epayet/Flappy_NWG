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
        PositionComponent position = null;

        if(rectangle != null)
            position = rectangle;
        if(circle != null)
            position = circle;

        if(position.getX() < 0) {
            position.setX(0);
        }
        if(position.getY() < 0) {
            position.setY(0);
        }

        CameraComponent camera = getCameraComponent(entity);
        if(rectangle != null) {
            if(rectangle.getY() > camera.getHeight() - rectangle.getHeight()) {
                rectangle.setY(camera.getHeight() - rectangle.getHeight());
            }
            if(rectangle.getX() > camera.getWidth() - rectangle.getWidth()) {
                rectangle.setX(camera.getWidth() - rectangle.getWidth());
            }
        }

        if(circle != null) {
            if(circle.getY() > camera.getHeight() - circle.getRadius()) {
                circle.setY(camera.getHeight() - circle.getRadius());
            }
            if(circle.getX() > camera.getWidth() - circle.getRadius()) {
                circle.setX(camera.getWidth() - circle.getRadius());
            }
        }
    }

    protected abstract CircleComponent getCircleComponent(Entity entity);
    protected abstract RectangleComponent getRectangleComponent(Entity entity);
    protected abstract CameraComponent getCameraComponent(Entity entity);
}
