package com.jak.flappy.factory;

import com.artemis.Entity;
import com.artemis.managers.GroupManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.jak.flappy.Constants;
import com.jak.flappy.component.*;
import com.jak.flappy.component.graphic.ColorComponent;
import com.jak.flappy.component.physics.*;
import com.jak.flappy.component.ui.ButtonComponent;
import com.jak.flappy.component.ui.LabelComponent;
import com.jak.flappy.component.ui.ShowComponent;
import com.jak.flappy.component.util.ListenerComponent;
import com.jak.flappy.listener.button.ReplayButtonListener;
import com.jak.flappy.world.FlappyWorld;

import java.util.UUID;

/**
 * Created by manu on 3/20/14.
 */
public class EntityFactory {

    public static Entity createFlappy(FlappyWorld world) {
        Entity flappy = world.createEntity();

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(Constants.START_FLAPPY_X * Constants.WORLD_TO_BOX, Constants.START_FLAPPY_Y * Constants.WORLD_TO_BOX);
        bodyDef.gravityScale = 0.1f;
        PhysicBodyComponent physicBodyDefinitionComponent = new PhysicBodyComponent(bodyDef, world.getPhysicWorld());
        flappy.addComponent(physicBodyDefinitionComponent);

        CircleShapeComponent circleShapeComponent = new CircleShapeComponent(30 * Constants.WORLD_TO_BOX);
        flappy.addComponent(circleShapeComponent);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShapeComponent.getShape();
        FixtureComponent fixtureComponent = new FixtureComponent(fixtureDef, physicBodyDefinitionComponent.getBody());
        flappy.addComponent(fixtureComponent);

        flappy.addComponent(new InputComponent());
        flappy.addComponent(new DeathComponent());
        flappy.addComponent(new ContactComponent(Constants.CONTACT_FLAPPY, fixtureComponent.getFixture()));

        GroupManager groupManager = world.getManager(GroupManager.class);
        groupManager.add(flappy, Constants.GROUP_FLAPPY);

        flappy.addToWorld();
        circleShapeComponent.dispose();
        return flappy;
    }

    public static Entity createGround(FlappyWorld world) {
        return createWall(world, 10, Constants.CONTACT_GROUND);
    }

    public static Entity createRoof(FlappyWorld world) {
        return createWall(world, Constants.WORLD_HEIGHT + 10, Constants.CONTACT_ROOF);
    }

    private static Entity createWall(FlappyWorld world, float y, String contactName) {
        Entity wall = world.createEntity();

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(0, y * Constants.WORLD_TO_BOX);
        PhysicBodyComponent physicBodyComponent = new PhysicBodyComponent(bodyDef, world.getPhysicWorld());
        wall.addComponent(physicBodyComponent);

        BoxShapeComponent boxShapeComponent = new BoxShapeComponent(Constants.WORLD_WIDTH * Constants.WORLD_TO_BOX, 10 * Constants.WORLD_TO_BOX);
        wall.addComponent(boxShapeComponent);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = boxShapeComponent.getShape();
        FixtureComponent fixtureComponent = new FixtureComponent(fixtureDef, physicBodyComponent.getBody());
        wall.addComponent(fixtureComponent);
        wall.addComponent(new ContactComponent(contactName, fixtureComponent.getFixture()));

        wall.addToWorld();
        boxShapeComponent.dispose();
        return wall;
    }

    public static Entity createNinja(FlappyWorld world) {
        Entity ninja = world.createEntity();

        float randomX = MathUtils.random(0, Constants.WORLD_WIDTH);
        float randomY = MathUtils.random(10, Constants.WORLD_HEIGHT);
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(Constants.WORLD_WIDTH * Constants.WORLD_TO_BOX, randomY * Constants.WORLD_TO_BOX);
        PhysicBodyComponent physicBodyComponent = new PhysicBodyComponent(bodyDef, world.getPhysicWorld(), false);

        ninja.addComponent(physicBodyComponent);
        BoxShapeComponent boxShapeComponent = new BoxShapeComponent(10 * Constants.WORLD_TO_BOX, 20 * Constants.WORLD_TO_BOX);
        ninja.addComponent(boxShapeComponent);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = boxShapeComponent.getShape();
        Body body = physicBodyComponent.getBody();
        FixtureComponent fixtureComponent = new FixtureComponent(fixtureDef, body);
        ninja.addComponent(fixtureComponent);
        body.applyLinearImpulse(new Vector2(MathUtils.random(-4, -1), 0), body.getWorldCenter(), true);

        ninja.addComponent(new ContactComponent(Constants.CONTACT_NINJA, fixtureComponent.getFixture()));
        ninja.addComponent(new PositionComponent());
        ninja.addComponent(new NinjaComponent());

        ninja.addToWorld();

        GroupManager groupManager = world.getManager(GroupManager.class);
        groupManager.add(ninja, Constants.GROUP_NINJA);
        boxShapeComponent.dispose();
        return ninja;
    }

    public static Entity createScore(FlappyWorld world) {
        Entity score = world.createEntity();
        score.addComponent(new ScoreComponent());

        GroupManager groupManager = world.getManager(GroupManager.class);
        groupManager.add(score, Constants.GROUP_SCORE);

        score.addToWorld();
        return score;
    }

    public static Entity createReplayButton(FlappyWorld world) {
        Entity button = world.createEntity();

        button.addComponent(new LabelComponent(Constants.BUTTON_REPLAY));
        button.addComponent(new PositionComponent(Constants.WORLD_WIDTH / 2, (Constants.WORLD_HEIGHT / 2) - 100));
        button.addComponent(new SizeComponent(90, 30));
        button.addComponent(new ListenerComponent(new ReplayButtonListener(world)));
        button.addComponent(new ShowComponent(false));
        button.addComponent(new ButtonComponent());

        button.addToWorld();
        return button;
    }
}
