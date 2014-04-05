package com.jak.flappy.system.ninja;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.managers.GroupManager;
import com.artemis.systems.IntervalEntitySystem;
import com.artemis.utils.ImmutableBag;
import com.jak.flappy.Constants;
import com.jak.flappy.component.DeathComponent;
import com.jak.flappy.factory.EntityFactory;
import com.jak.flappy.world.FlappyWorld;
import com.jak.flappy.world.FlappyWorldUtils;

/**
 * Created by manu on 3/19/14.
 */
public class SpawningNinjaSystem extends IntervalEntitySystem {

    public SpawningNinjaSystem(float interval) {
        super(Aspect.getEmpty(), interval);
    }

    @Override
    protected void processEntities(ImmutableBag<Entity> entities) {
        if(!FlappyWorldUtils.isFlappyDead(world))
            EntityFactory.createNinja((FlappyWorld) world);
    }
}
