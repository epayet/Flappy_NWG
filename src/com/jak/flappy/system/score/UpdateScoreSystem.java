package com.jak.flappy.system.score;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.managers.GroupManager;
import com.artemis.systems.EntityProcessingSystem;
import com.artemis.utils.ImmutableBag;
import com.jak.flappy.Constants;
import com.jak.flappy.component.PositionComponent;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.ScoreComponent;
import com.jak.flappy.world.FlappyWorldUtils;

import java.util.Iterator;

/**
 * Created by manu on 05/04/14.
 */
public class UpdateScoreSystem extends EntityProcessingSystem {

    @Mapper
    private ComponentMapper<ScoreComponent> scoreComponentMapper;

    public UpdateScoreSystem() {
        super(Aspect.getAspectForAll(ScoreComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        ScoreComponent score = scoreComponentMapper.get(entity);
        GroupManager groupManager = world.getManager(GroupManager.class);
        ImmutableBag<Entity> ninjas = groupManager.getEntities(Constants.GROUP_NINJA);
        Iterator<Entity> ninjaIterator = ninjas.iterator();

        if(!FlappyWorldUtils.isFlappyDead(world)) {
            while (ninjaIterator.hasNext()) {
                Entity ninja = ninjaIterator.next();
                PositionComponent position = ninja.getComponent(PositionComponent.class);
                if (position.getX() < 0) {
                    score.setScore(score.getScore() + 1);
                }
            }
        }
    }
}
