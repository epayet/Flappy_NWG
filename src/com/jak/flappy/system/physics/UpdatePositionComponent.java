package com.jak.flappy.system.physics;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.math.Vector2;
import com.jak.flappy.component.PositionComponent;
import com.jak.flappy.component.physics.PhysicBodyComponent;

/**
 * Created by manu on 05/04/14.
 */
public class UpdatePositionComponent extends EntityProcessingSystem {

    @Mapper
    private ComponentMapper<PhysicBodyComponent> physicBodyComponentMapper;
    @Mapper
    private ComponentMapper<PositionComponent> positionComponentMapper;

    public UpdatePositionComponent() {
        super(Aspect.getAspectForAll(PhysicBodyComponent.class, PositionComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        PhysicBodyComponent physicBody = physicBodyComponentMapper.get(entity);
        PositionComponent position = positionComponentMapper.get(entity);
        Vector2 bodyPosition = physicBody.getBody().getPosition();
        position.setX(bodyPosition.x);
        position.setY(bodyPosition.y);
    }
}
