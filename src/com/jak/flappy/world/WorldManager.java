package com.jak.flappy.world;

import com.artemis.Component;
import com.artemis.Entity;
import com.artemis.World;
import com.artemis.managers.GroupManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ObjectMap;
import com.jak.flappy.Constants;
import com.jak.flappy.component.*;
import com.jak.flappy.component.debug.DebubInfoComponent;
import com.jak.flappy.component.graphic.*;
import com.jak.flappy.system.GravitySystem;
import com.jak.flappy.system.debug.DebugInfoSystem;
import com.jak.flappy.system.graphic.DrawingSystem;
import com.jak.flappy.system.graphic.LibgdxInputSystem;
import com.jak.flappy.system.graphic.LibgdxScreenLimitedSystem;
import com.jak.flappy.system.graphic.LibgdxVelocitySystem;

/**
 * Created by manu on 09/03/14.
 */
public class WorldManager {
    private Array<Disposable> componentsToDispose;
    private Array<Preparable> componentsToPrepare;
    private World world;
    private ObjectMap<String, Component> reusableComponents;
    private Camera camera;

    public WorldManager() {
        componentsToDispose = new Array<Disposable>();
        componentsToPrepare = new Array<Preparable>();
        initializeWorld();
        createReusableComponents();
    }

    public void createFlappyEntity() {
        Entity flappy = world.createEntity();
        //ninja.addComponent(new RectangleComponent(Constants.WORLD_WIDTH/2, 0, 20, 50));
        flappy.addComponent(new CircleComponent(Constants.WORLD_WIDTH / 2, Constants.WORLD_HEIGHT / 2, 20));
        flappy.addComponent(new DrawingComponent(255, 255, 255, 1));
        flappy.addComponent(reusableComponents.get(Constants.COMPONENT_SHAPERENDERER));
        flappy.addComponent(reusableComponents.get(Constants.COMPONENT_CAMERA));
        flappy.addComponent(new GravityComponent(10));
        flappy.addComponent(new StayInScreenComponent());
        flappy.addComponent(reusableComponents.get(Constants.COMPONENT_INPUT));
        flappy.addComponent(new VelocityComponent());
        flappy.addToWorld();
    }

    public void createDebugInfoEntity() {
        Entity debugInfo = world.createEntity();
        debugInfo.addComponent(new DebubInfoComponent());
        debugInfo.addComponent(reusableComponents.get(Constants.COMPONENT_SPRITEBATCH));
        debugInfo.addComponent(reusableComponents.get(Constants.COMPONENT_FONT));
        debugInfo.addComponent(new DrawingComponent(255, 255, 255, 1));
        debugInfo.addComponent(reusableComponents.get(Constants.COMPONENT_CAMERA));
        debugInfo.addComponent(reusableComponents.get(Constants.COMPONENT_INPUT));
        debugInfo.addToWorld();
    }

    public void prepare() {
        prepareCamera();
        prepareComponents();
    }

    public void process() {
        world.setDelta(Gdx.graphics.getDeltaTime());
        world.process();
    }

    public void dispose() {
        for(Disposable disposableComponent : componentsToDispose) {
            disposableComponent.dispose();
        }
    }

    private void initializeWorld() {
        world = new World();
        world.initialize();
        world.setManager(new GroupManager());
        setWorldSystems();
    }

    private void setWorldSystems() {
        world.setSystem(new LibgdxScreenLimitedSystem());
        world.setSystem(new DrawingSystem());
        world.setSystem(new GravitySystem());
        //world.setSystem(new SpawnFlappySystem(2, cameraComponent));
        world.setSystem(new LibgdxInputSystem());
        world.setSystem(new LibgdxVelocitySystem());
        world.setSystem(new DebugInfoSystem());
    }

    private void createReusableComponents() {
        reusableComponents = new ObjectMap<String, Component>();
        LibgdxCameraComponent cameraComponent = new LibgdxCameraComponent(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        camera = cameraComponent.getCamera();
        BitmapFontComponent bitmapFontComponent = new BitmapFontComponent("calibri.png", "calibri.fnt", "fonts");
        SpriteBatchComponent spriteBatchComponent = new SpriteBatchComponent();
        ShapeRendererComponent shapeRendererComponent = new ShapeRendererComponent();

        reusableComponents.put(Constants.COMPONENT_CAMERA, cameraComponent);
        reusableComponents.put(Constants.COMPONENT_SPRITEBATCH, spriteBatchComponent);
        reusableComponents.put(Constants.COMPONENT_SHAPERENDERER, shapeRendererComponent);
        reusableComponents.put(Constants.COMPONENT_FONT, bitmapFontComponent);
        reusableComponents.put(Constants.COMPONENT_INPUT, new LibgdxInputComponent());

        componentsToDispose.add(bitmapFontComponent);
        componentsToDispose.add(spriteBatchComponent);
        componentsToDispose.add(shapeRendererComponent);

        componentsToPrepare.add(shapeRendererComponent);
        componentsToPrepare.add(spriteBatchComponent);
    }

    private void prepareComponents() {
        for(Preparable preparableComponent : componentsToPrepare) {
            preparableComponent.prepare(camera);
        }
    }

    private void prepareCamera() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
    }
}
