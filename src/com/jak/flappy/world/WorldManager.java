package com.jak.flappy.world;

import com.artemis.Component;
import com.artemis.Entity;
import com.artemis.World;
import com.artemis.managers.GroupManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ObjectMap;
import com.jak.flappy.Constants;
import com.jak.flappy.component.*;
import com.jak.flappy.component.debug.DebubInfoComponent;
import com.jak.flappy.component.graphic.*;
import com.jak.flappy.component.graphic.physics.*;
import com.jak.flappy.system.debug.DebugInfoSystem;
import com.jak.flappy.system.graphic.DrawingSystem;

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
        createReusableComponents();
        initializeWorld();
    }

    public void createFlappyEntity() {
        Entity flappy = world.createEntity();
        //ninja.addComponent(new RectangleComponent(Constants.WORLD_WIDTH/2, 0, 20, 50));
        float y = Constants.WORLD_HEIGHT / 2;
        float x = Constants.WORLD_WIDTH / 2;
        int radius = 20;
        //flappy.addComponent(new CircleComponent(x, y, radius));
        //flappy.addComponent(new DrawingComponent(255, 255, 255, 1));
        //flappy.addComponent(reusableComponents.get(Constants.COMPONENT_SHAPERENDERER));
        /*LibgdxCameraComponent cameraComponent = (LibgdxCameraComponent) reusableComponents.get(Constants.COMPONENT_CAMERA);
        flappy.addComponent(cameraComponent);*/
        //flappy.addComponent(new GravityComponent(10));
        //flappy.addComponent(new StayInScreenComponent());
        //flappy.addComponent(reusableComponents.get(Constants.COMPONENT_INPUT));
        //flappy.addComponent(new VelocityComponent());

        PhysicWorldComponent worldComponent = (PhysicWorldComponent) reusableComponents.get(Constants.COMPONENT_PHYSICWORLD);
        PhysicBodyComponent physicBodyDefinitionComponent = new PhysicBodyComponent(BodyDef.BodyType.DynamicBody, worldComponent.getWorld(), x, y);
        flappy.addComponent(physicBodyDefinitionComponent);

        CircleShapeComponent circleShapeComponent = new CircleShapeComponent(radius);
        flappy.addComponent(circleShapeComponent);
        flappy.addComponent(new FixtureComponent(circleShapeComponent.getShape(), 0.5f, 0.4f, 0.6f, physicBodyDefinitionComponent.getBody()));
        flappy.addToWorld();
    }

    public void createGroundEntity() {
        Entity ground = world.createEntity();
        PhysicWorldComponent physicWorldComponent = (PhysicWorldComponent) reusableComponents.get(Constants.COMPONENT_PHYSICWORLD);
        PhysicBodyComponent physicBodyComponent = new PhysicBodyComponent(BodyDef.BodyType.StaticBody, physicWorldComponent.getWorld(), 0, 10);
        ground.addComponent(physicBodyComponent);
        LibgdxCameraComponent cameraComponent = (LibgdxCameraComponent) reusableComponents.get(Constants.COMPONENT_CAMERA);
        BoxShapeComponent boxShapeComponent = new BoxShapeComponent(cameraComponent.getCamera().viewportWidth, 10);
        ground.addComponent(boxShapeComponent);
        ground.addComponent(new FixtureComponent(boxShapeComponent.getShape(), physicBodyComponent.getBody()));
        ground.addToWorld();
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
        //world.setSystem(new LibgdxScreenLimitedSystem());
        world.setSystem(new DrawingSystem());
        //world.setSystem(new GravitySystem());
        //world.setSystem(new SpawnNinjaSystem(reusableComponents));
        //world.setSystem(new LibgdxInputSystem());
        //world.setSystem(new LibgdxVelocitySystem());
        world.setSystem(new DebugInfoSystem());
    }

    private void createReusableComponents() {
        reusableComponents = new ObjectMap<String, Component>();
        LibgdxCameraComponent cameraComponent = new LibgdxCameraComponent(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        camera = cameraComponent.getCamera();
        BitmapFontComponent bitmapFontComponent = new BitmapFontComponent("calibri.png", "calibri.fnt", "fonts");
        SpriteBatchComponent spriteBatchComponent = new SpriteBatchComponent();
        ShapeRendererComponent shapeRendererComponent = new ShapeRendererComponent();
        PhysicWorldComponent physicWorldComponent = new PhysicWorldComponent(-100);
        DebugRendererComponent debugRendererComponent = new DebugRendererComponent(physicWorldComponent.getWorld());

        reusableComponents.put(Constants.COMPONENT_CAMERA, cameraComponent);
        reusableComponents.put(Constants.COMPONENT_SPRITEBATCH, spriteBatchComponent);
        reusableComponents.put(Constants.COMPONENT_SHAPERENDERER, shapeRendererComponent);
        reusableComponents.put(Constants.COMPONENT_FONT, bitmapFontComponent);
        reusableComponents.put(Constants.COMPONENT_INPUT, new LibgdxInputComponent());
        reusableComponents.put(Constants.COMPONENT_DEBUGRENDERER, debugRendererComponent);
        reusableComponents.put(Constants.COMPONENT_PHYSICWORLD, physicWorldComponent);

        componentsToDispose.add(bitmapFontComponent);
        componentsToDispose.add(spriteBatchComponent);
        componentsToDispose.add(shapeRendererComponent);

        componentsToPrepare.add(shapeRendererComponent);
        componentsToPrepare.add(spriteBatchComponent);
        componentsToPrepare.add(debugRendererComponent);
        componentsToPrepare.add(physicWorldComponent);
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
