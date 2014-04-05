package com.jak.flappy.system.ninja;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.jak.flappy.component.NinjaComponent;
import com.jak.flappy.component.PositionComponent;

/**
 * Created by manu on 05/04/14.
 */
public class DeleteNinjaSystem extends EntityProcessingSystem {
    @Mapper
    private ComponentMapper<PositionComponent> positionComponentMapper;

    public DeleteNinjaSystem() {
        super(Aspect.getAspectForAll(NinjaComponent.class, PositionComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        PositionComponent position = positionComponentMapper.get(entity);
        if(position.getX() <= 0) {
            entity.deleteFromWorld();
        }
    }
}
