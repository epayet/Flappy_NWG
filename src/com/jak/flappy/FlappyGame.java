package com.jak.flappy;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.jak.flappy.component.*;
import com.jak.flappy.system.CameraSystem;
import com.jak.flappy.system.DrawingSystem;
import com.jak.flappy.system.GravitySystem;
import com.jak.flappy.system.VelocitySystem;

/**
 * Created by manu on 2/19/14.
 */
public class FlappyGame implements ApplicationListener{
    private World world;

    @Override
    public void create() {
        world = new World();
        world.initialize();
        world.setSystem(new CameraSystem());
        world.setSystem(new DrawingSystem());
        world.setSystem(new GravitySystem());
        world.setSystem(new VelocitySystem());

        Entity ninja = world.createEntity();
        ninja.addComponent(new RectangleComponent(Constants.WORLD_WIDTH/2, 200, 20, 50));
        ninja.addComponent(new DrawingComponent(255, 0, 0, 1));
        ninja.addComponent(new CameraComponent(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT));
        ninja.addComponent(new GravityComponent(10000));
        ninja.addComponent(new VelocityComponent());
        ninja.addToWorld();
    }

    @Override
    public void render() {
        world.setDelta(Gdx.graphics.getDeltaTime());
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

    }
}
