package com.jak.flappy.factory;

import com.artemis.Entity;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.jak.flappy.Constants;
import com.jak.flappy.component.InputComponent;
import com.jak.flappy.component.graphic.physics.BoxShapeComponent;
import com.jak.flappy.component.graphic.physics.CircleShapeComponent;
import com.jak.flappy.component.graphic.physics.FixtureComponent;
import com.jak.flappy.component.graphic.physics.PhysicBodyComponent;
import com.jak.flappy.world.FlappyWorld;

/**
 * Created by manu on 3/20/14.
 */
public class EntityFactory {

    public static Entity createFlappy(FlappyWorld world) {
        Entity flappy = world.createEntity();
        float y = Constants.WORLD_HEIGHT / 2;
        float x = 20;
        PhysicBodyComponent physicBodyDefinitionComponent = new PhysicBodyComponent(BodyDef.BodyType.DynamicBody, world.getPhysicWorld(), x, y, true);
        flappy.addComponent(physicBodyDefinitionComponent);

        CircleShapeComponent circleShapeComponent = new CircleShapeComponent(20);
        flappy.addComponent(circleShapeComponent);
        flappy.addComponent(new FixtureComponent(circleShapeComponent.getShape(), 10f, 0f, 0f, physicBodyDefinitionComponent.getBody()));
        flappy.addComponent(new InputComponent());
        flappy.addToWorld();
        circleShapeComponent.dispose();
        return flappy;
    }

    public static Entity createGround(FlappyWorld world) {
        Entity ground = world.createEntity();
        PhysicBodyComponent physicBodyComponent = new PhysicBodyComponent(BodyDef.BodyType.StaticBody, world.getPhysicWorld(), 0, 10);
        ground.addComponent(physicBodyComponent);
        BoxShapeComponent boxShapeComponent = new BoxShapeComponent(Constants.WORLD_WIDTH, 10);
        ground.addComponent(boxShapeComponent);
        ground.addComponent(new FixtureComponent(boxShapeComponent.getShape(), physicBodyComponent.getBody()));
        ground.addToWorld();
        boxShapeComponent.dispose();
        return ground;
    }
}
