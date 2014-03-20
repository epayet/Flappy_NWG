package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.managers.GroupManager;
import com.artemis.systems.EntityProcessingSystem;
import com.jak.flappy.Constants;
import com.jak.flappy.component.graphic.physics.PhysicBodyComponent;

/**
 * Created by manu on 3/20/14.
 */
public class MovingNinjaSystem extends EntityProcessingSystem {
    @Mapper
    private ComponentMapper<PhysicBodyComponent> physicBodyComponentMapper;

    public MovingNinjaSystem() {
        super(Aspect.getAspectForAll(PhysicBodyComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        GroupManager groupManager = world.getManager(GroupManager.class);
        if(groupManager.isInGroup(entity, Constants.GROUP_NINJA)) {
            PhysicBodyComponent physicBodyComponent = physicBodyComponentMapper.get(entity);
            physicBodyComponent.getBody().applyForceToCenter(-10000, 0, false);
        }
    }
}
