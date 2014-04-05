package com.jak.flappy.world;

import com.artemis.Entity;
import com.artemis.World;
import com.artemis.managers.GroupManager;
import com.jak.flappy.Constants;
import com.jak.flappy.component.DeathComponent;
import com.jak.flappy.component.ScoreComponent;

/**
 * Created by manu on 05/04/14.
 */
public class FlappyWorldUtils {

    public static boolean isFlappyDead(World world) {
        DeathComponent death = getDeathComponent(world);
        return death.isDeath();
    }

    public static Entity getFlappyEntity(World world) {
        GroupManager groupManager = world.getManager(GroupManager.class);
        return groupManager.getEntities(Constants.GROUP_FLAPPY).get(0);
    }

    public static DeathComponent getDeathComponent(World world) {
        Entity flappy = getFlappyEntity(world);
        return flappy.getComponent(DeathComponent.class);
    }

    public static ScoreComponent getScoreComponent(FlappyWorld world) {
        GroupManager groupManager = world.getManager(GroupManager.class);
        Entity scoreEntity = groupManager.getEntities(Constants.GROUP_SCORE).get(0);
        return scoreEntity.getComponent(ScoreComponent.class);
    }
}
