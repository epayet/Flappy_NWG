package com.jak.flappy;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jak.flappy.component.*;
import com.jak.flappy.component.debug.DebubInfoComponent;
import com.jak.flappy.component.graphic.*;
import com.jak.flappy.system.debug.DebugInfoSystem;
import com.jak.flappy.system.graphic.CameraSystem;
import com.jak.flappy.system.graphic.DrawingSystem;
import com.jak.flappy.system.GravitySystem;
import com.jak.flappy.system.graphic.LibgdxInputSystem;
import com.jak.flappy.system.graphic.LibgdxVelocitySystem;

/**
 * Created by manu on 2/19/14.
 */
public class FlappyGame implements ApplicationListener{
    private World world;
    private Camera camera;
    private SpriteBatch spriteBatch;

    @Override
    public void create() {
        //world
        world = new World();
        world.initialize();
        world.setSystem(new DrawingSystem());
        world.setSystem(new GravitySystem());
        world.setSystem(new LibgdxInputSystem());
        world.setSystem(new LibgdxVelocitySystem());
        world.setSystem(new DebugInfoSystem());

        //Libgdx specific
        LibgdxCameraComponent cameraComponent = new LibgdxCameraComponent(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        camera = cameraComponent.getCamera();
        LibgdxInputComponent inputComponent = new LibgdxInputComponent();
        SpriteBatchComponent spriteBatchComponent = new SpriteBatchComponent();
        spriteBatch = spriteBatchComponent.getSpriteBatch();

        //ninja
        Entity ninja = world.createEntity();
        ninja.addComponent(new RectangleComponent(Constants.WORLD_WIDTH/2, 200, 20, 50));
        ninja.addComponent(new DrawingComponent(255, 255, 255, 1));
        ninja.addComponent(cameraComponent);
        ninja.addComponent(new GravityComponent(10));
        ninja.addComponent(new StayInScreenComponent());
        ninja.addComponent(inputComponent);
        ninja.addComponent(new VelocityComponent());
        ninja.addToWorld();

        //debug
        Entity debugInfo = world.createEntity();
        debugInfo.addComponent(new DebubInfoComponent());
        debugInfo.addComponent(spriteBatchComponent);
        debugInfo.addComponent(new BitmapFontComponent("calibri.png", "calibri.fnt", "fonts"));
        debugInfo.addComponent(new DrawingComponent(255, 255, 255, 1));
        debugInfo.addComponent(cameraComponent);
        debugInfo.addComponent(inputComponent);
        debugInfo.addToWorld();
    }

    @Override
    public void render() {
        //libgdx
        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);

        //world
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
        spriteBatch.dispose();
    }
}
