package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.managers.GroupManager;
import com.artemis.systems.IntervalEntitySystem;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.math.MathUtils;
import com.jak.flappy.Constants;
import com.jak.flappy.component.CameraComponent;
import com.jak.flappy.component.GravityComponent;
import com.jak.flappy.component.VelocityComponent;
import com.jak.flappy.component.CircleComponent;
import com.jak.flappy.component.graphic.DrawingComponent;

/**
 * Created by manu on 08/03/14.
 */
public class SpawnFlappySystem extends EntitySystem{
    private CameraComponent cameraComponent;

    public SpawnFlappySystem(CameraComponent cameraComponent) {
        super(Aspect.getEmpty());
        this.cameraComponent = cameraComponent;
    }

    @Override
    protected void processEntities(ImmutableBag<Entity> entities) {
        GroupManager groupManager = world.getManager(GroupManager.class);
        Entity flappy = world.createEntity();
        flappy.addComponent(new DrawingComponent(255, 255, 255, 1));
        boolean isRandomLeft = MathUtils.randomBoolean();
        float x, velocityX;
        if(isRandomLeft) {
            x = 0;
            velocityX = 200;
        }
        else {
            x = cameraComponent.getWidth();
            velocityX = -200;
        }
        flappy.addComponent(new CircleComponent(x, MathUtils.random(0, cameraComponent.getHeight()), 10));
        flappy.addComponent(cameraComponent);
        flappy.addComponent(new GravityComponent(10));
        VelocityComponent velocity = new VelocityComponent();
        velocity.setX(velocityX);
        flappy.addComponent(velocity);
        flappy.addToWorld();
        groupManager.add(flappy, Constants.GROUP_FLAPPY);
    }

    @Override
    protected boolean checkProcessing() {
        return true;
    }
}
