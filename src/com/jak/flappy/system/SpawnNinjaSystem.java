package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.Component;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.managers.GroupManager;
import com.artemis.systems.IntervalEntitySystem;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ObjectMap;
import com.jak.flappy.Constants;
import com.jak.flappy.component.*;
import com.jak.flappy.component.graphic.DrawingComponent;
import com.jak.flappy.component.graphic.ShapeRendererComponent;

/**
 * Created by manu on 08/03/14.
 */
public class SpawnNinjaSystem extends IntervalEntitySystem{
    private CameraComponent cameraComponent;
    private ShapeRendererComponent shapeRendererComponent;

    public SpawnNinjaSystem(ObjectMap<String, Component> reusableComponents) {
        super(Aspect.getEmpty(), 0.5f);
        extractReusableComponents(reusableComponents);
    }

    @Override
    protected void processEntities(ImmutableBag<Entity> entities) {
        GroupManager groupManager = world.getManager(GroupManager.class);
        Entity ninja = world.createEntity();
        ninja.addComponent(new DrawingComponent(255, 0, 0, 1));
        boolean isRandomSide = MathUtils.randomBoolean();
        float x, velocityX, y, velocityY;
        int speed = 400;

        if(isRandomSide) {
            boolean isRandomLeft = MathUtils.randomBoolean();
            if(isRandomLeft) {
                x = 0;
                velocityX = speed;
            }
            else {
                x = cameraComponent.getWidth();
                velocityX = -speed;
            }
            velocityY = -speed;
            y = MathUtils.random(0, cameraComponent.getHeight());
        } else {
            boolean isRandomUp = MathUtils.randomBoolean();
            if(isRandomUp) {
                y = cameraComponent.getHeight();
                velocityY = -speed;
            }
            else {
                y = 0;
                velocityY = speed;
            }
            velocityX = 0;
            x = MathUtils.random(0, cameraComponent.getWidth());
        }

        ninja.addComponent(new RectangleComponent(x, y, 20, 40));
        ninja.addComponent(cameraComponent);
        ninja.addComponent(shapeRendererComponent);
        ninja.addComponent(new VelocityComponent(velocityX, velocityY));
        ninja.addToWorld();
        groupManager.add(ninja, Constants.GROUP_FLAPPY);
    }

    private void extractReusableComponents(ObjectMap<String, Component> reusableComponents) {
        this.cameraComponent = (CameraComponent)reusableComponents.get(Constants.COMPONENT_CAMERA);
        this.shapeRendererComponent = (ShapeRendererComponent)reusableComponents.get(Constants.COMPONENT_SHAPERENDERER);
    }
}
