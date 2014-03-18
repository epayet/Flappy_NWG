package com.jak.flappy;

import com.artemis.Entity;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.jak.flappy.component.InputComponent;
import com.jak.flappy.component.graphic.physics.*;
import com.jak.flappy.world.FlappyWorld;

/**
 * Created by manu on 2/19/14.
 */
public class FlappyGame implements ApplicationListener {
    private FlappyWorld world;

    @Override
    public void create() {
        initializeWorld();
        createFlappyEntity();
        createGroundEntity();
    }

    @Override
    public void render() {
        world.process();
    }

    @Override
    public void resize(int i, int i2) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        world.dispose();
    }

    private void initializeWorld() {
        world = new FlappyWorld(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        world.initialize();
    }

    private void createFlappyEntity() {
        Entity flappy = world.createEntity();
        float y = Constants.WORLD_HEIGHT / 2;
        float x = Constants.WORLD_WIDTH / 2;
        PhysicBodyComponent physicBodyDefinitionComponent = new PhysicBodyComponent(BodyDef.BodyType.DynamicBody, world.getPhysicWorld(), x, y);
        flappy.addComponent(physicBodyDefinitionComponent);

        CircleShapeComponent circleShapeComponent = new CircleShapeComponent(20);
        flappy.addComponent(circleShapeComponent);
        flappy.addComponent(new FixtureComponent(circleShapeComponent.getShape(), 0.5f, 0.4f, 1f, physicBodyDefinitionComponent.getBody()));
        flappy.addComponent(new InputComponent());
        flappy.addToWorld();
    }

    private void createGroundEntity() {
        Entity ground = world.createEntity();
        PhysicBodyComponent physicBodyComponent = new PhysicBodyComponent(BodyDef.BodyType.StaticBody, world.getPhysicWorld(), 0, 10);
        ground.addComponent(physicBodyComponent);
        BoxShapeComponent boxShapeComponent = new BoxShapeComponent(Constants.WORLD_WIDTH, 10);
        ground.addComponent(boxShapeComponent);
        ground.addComponent(new FixtureComponent(boxShapeComponent.getShape(), physicBodyComponent.getBody()));
        ground.addToWorld();
    }
}
