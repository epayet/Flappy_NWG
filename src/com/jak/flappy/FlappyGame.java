package com.jak.flappy;

import com.artemis.Entity;
import com.artemis.World;
import com.artemis.managers.GroupManager;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.jak.flappy.component.*;
import com.jak.flappy.component.debug.DebubInfoComponent;
import com.jak.flappy.component.graphic.*;
import com.jak.flappy.system.SpawnFlappySystem;
import com.jak.flappy.system.debug.DebugInfoSystem;
import com.jak.flappy.system.graphic.*;
import com.jak.flappy.system.GravitySystem;

/**
 * Created by manu on 2/19/14.
 */
public class FlappyGame implements ApplicationListener{
    private World world;
    private Array<Disposable> componentsToDispose;
    private Array<Preparable> componentsToPrepare;
    private Camera camera;

    @Override
    public void create() {
        componentsToDispose = new Array<Disposable>();
        componentsToPrepare = new Array<Preparable>();

        //Libgdx specific
        LibgdxCameraComponent cameraComponent = new LibgdxCameraComponent(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        camera = cameraComponent.getCamera();
        SpriteBatchComponent spriteBatchComponent = new SpriteBatchComponent();
        ShapeRendererComponent shapeRendererComponent = new ShapeRendererComponent();
        BitmapFontComponent bitmapFontComponent = new BitmapFontComponent("calibri.png", "calibri.fnt", "fonts");
        LibgdxInputComponent inputComponent = new LibgdxInputComponent();

        componentsToDispose.add(bitmapFontComponent);
        componentsToDispose.add(spriteBatchComponent);
        componentsToDispose.add(shapeRendererComponent);

        componentsToPrepare.add(shapeRendererComponent);
        componentsToPrepare.add(spriteBatchComponent);


        //world
        world = new World();
        world.initialize();
        world.setSystem(new LibgdxScreenLimitedSystem());
        world.setSystem(new DrawingSystem());
        world.setSystem(new GravitySystem());
        //world.setSystem(new SpawnFlappySystem(2, cameraComponent));
        world.setSystem(new LibgdxInputSystem());
        world.setSystem(new LibgdxVelocitySystem());
        world.setSystem(new DebugInfoSystem());
        world.setManager(new GroupManager());

        //ninja
        Entity ninja = world.createEntity();
        //ninja.addComponent(new RectangleComponent(Constants.WORLD_WIDTH/2, 0, 20, 50));
        ninja.addComponent(new CircleComponent(Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/2, 20));
        ninja.addComponent(new DrawingComponent(255, 255, 255, 1));
        ninja.addComponent(shapeRendererComponent);
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
        debugInfo.addComponent(bitmapFontComponent);
        debugInfo.addComponent(new DrawingComponent(255, 255, 255, 1));
        debugInfo.addComponent(cameraComponent);
        debugInfo.addComponent(inputComponent);
        debugInfo.addToWorld();
    }

    @Override
    public void render() {
        prepareCameraAndComponents();

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
        for(Disposable disposableComponent : componentsToDispose) {
            disposableComponent.dispose();
        }
    }

    private void prepareCameraAndComponents() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        for(Preparable preparableComponent : componentsToPrepare) {
            preparableComponent.prepare(camera);
        }
    }
}
