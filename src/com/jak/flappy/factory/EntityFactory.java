package com.jak.flappy.factory;

import com.artemis.Entity;
import com.artemis.World;
import com.artemis.managers.GroupManager;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
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

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);
        bodyDef.bullet = true;
        PhysicBodyComponent physicBodyDefinitionComponent = new PhysicBodyComponent(bodyDef, world.getPhysicWorld());
        flappy.addComponent(physicBodyDefinitionComponent);

        CircleShapeComponent circleShapeComponent = new CircleShapeComponent(20);
        flappy.addComponent(circleShapeComponent);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShapeComponent.getShape();
        fixtureDef.density = 10f;
        fixtureDef.friction = 0;
        flappy.addComponent(new FixtureComponent(fixtureDef, physicBodyDefinitionComponent.getBody()));

        flappy.addComponent(new InputComponent());
        flappy.addToWorld();
        circleShapeComponent.dispose();
        return flappy;
    }

    public static Entity createGround(FlappyWorld world) {
        return createWall(world, 10);
    }

    public static Entity createRoof(FlappyWorld world) {
        return createWall(world, Constants.WORLD_HEIGHT + 10);
    }

    private static Entity createWall(FlappyWorld world, float y) {
        Entity roof = world.createEntity();

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(0, y);
        PhysicBodyComponent physicBodyComponent = new PhysicBodyComponent(bodyDef, world.getPhysicWorld());
        roof.addComponent(physicBodyComponent);

        BoxShapeComponent boxShapeComponent = new BoxShapeComponent(Constants.WORLD_WIDTH, 10);
        roof.addComponent(boxShapeComponent);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = boxShapeComponent.getShape();
        roof.addComponent(new FixtureComponent(fixtureDef, physicBodyComponent.getBody()));

        roof.addToWorld();
        boxShapeComponent.dispose();
        return roof;
    }

    public static Entity createNinja(FlappyWorld world) {
        Entity ninja = world.createEntity();

        float randomX = MathUtils.random(0, Constants.WORLD_WIDTH);
        float randomY = MathUtils.random(10, Constants.WORLD_HEIGHT);
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(Constants.WORLD_WIDTH, randomY);
        PhysicBodyComponent physicBodyComponent = new PhysicBodyComponent(bodyDef, world.getPhysicWorld(), false);

        ninja.addComponent(physicBodyComponent);
        BoxShapeComponent boxShapeComponent = new BoxShapeComponent(10, 20);
        ninja.addComponent(boxShapeComponent);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = boxShapeComponent.getShape();
        Body body = physicBodyComponent.getBody();
        ninja.addComponent(new FixtureComponent(fixtureDef, body));

        ninja.addToWorld();

        GroupManager groupManager = world.getManager(GroupManager.class);
        groupManager.add(ninja, Constants.GROUP_NINJA);
        boxShapeComponent.dispose();
        return ninja;
    }
}
