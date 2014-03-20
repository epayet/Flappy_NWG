package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.systems.IntervalEntitySystem;
import com.artemis.systems.VoidEntitySystem;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.jak.flappy.Constants;
import com.jak.flappy.component.graphic.physics.BoxShapeComponent;
import com.jak.flappy.component.graphic.physics.FixtureComponent;
import com.jak.flappy.component.graphic.physics.PhysicBodyComponent;
import com.jak.flappy.factory.EntityFactory;
import com.jak.flappy.world.FlappyWorld;

/**
 * Created by manu on 3/19/14.
 */
public class SpawningNinjaSystem extends IntervalEntitySystem {

    public SpawningNinjaSystem(float interval) {
        super(Aspect.getEmpty(), interval);
    }

    @Override
    protected void processEntities(ImmutableBag<Entity> entities) {
        EntityFactory.createNinja((FlappyWorld) world);
    }
}
