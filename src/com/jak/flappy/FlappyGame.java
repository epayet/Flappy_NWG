package com.jak.flappy;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.jak.flappy.component.*;
import com.jak.flappy.component.graphic.LibgdxCameraComponent;
import com.jak.flappy.component.graphic.DrawingComponent;
import com.jak.flappy.component.graphic.LibgdxInputComponent;
import com.jak.flappy.system.graphic.CameraSystem;
import com.jak.flappy.system.graphic.DrawingSystem;
import com.jak.flappy.system.GravitySystem;
import com.jak.flappy.system.VelocitySystem;
import com.jak.flappy.system.graphic.LibgdxInputSystem;
import com.jak.flappy.system.graphic.LibgdxVelocitySystem;

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
        world.setSystem(new LibgdxInputSystem());
        world.setSystem(new LibgdxVelocitySystem());

        Entity ninja = world.createEntity();
        ninja.addComponent(new RectangleComponent(Constants.WORLD_WIDTH/2, 200, 20, 50));
        ninja.addComponent(new DrawingComponent(255, 255, 255, 1));
        ninja.addComponent(new LibgdxCameraComponent(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT));
        ninja.addComponent(new GravityComponent(10));
        ninja.addComponent(new StayInScreenComponent());
        ninja.addComponent(new LibgdxInputComponent());
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
