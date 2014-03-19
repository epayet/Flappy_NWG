package com.jak.flappy.system;

import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.jak.flappy.Constants;
import com.jak.flappy.component.graphic.physics.BoxShapeComponent;
import com.jak.flappy.component.graphic.physics.FixtureComponent;
import com.jak.flappy.component.graphic.physics.PhysicBodyComponent;

/**
 * Created by manu on 3/19/14.
 */
public class SpawningNinjaSystem extends VoidEntitySystem {
    private World physicWorld;

    public SpawningNinjaSystem(World physicWorld) {
        this.physicWorld = physicWorld;
    }

    @Override
    protected void processSystem() {
        Entity ninja = world.createEntity();
        float randomX = MathUtils.random(0, Constants.WORLD_WIDTH);
        float randomY = MathUtils.random(0, Constants.WORLD_HEIGHT);
        PhysicBodyComponent physicBodyComponent = new PhysicBodyComponent(BodyDef.BodyType.StaticBody, physicWorld, randomX, randomY);
        ninja.addComponent(physicBodyComponent);
        BoxShapeComponent boxShapeComponent = new BoxShapeComponent(10, 20);
        ninja.addComponent(boxShapeComponent);
        ninja.addComponent(new FixtureComponent(boxShapeComponent.getShape(), physicBodyComponent.getBody()));
        ninja.addToWorld();
        boxShapeComponent.dispose();
    }
}
