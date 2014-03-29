package com.jak.flappy;

import com.artemis.Entity;
import com.artemis.managers.GroupManager;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.jak.flappy.component.InputComponent;
import com.jak.flappy.component.graphic.physics.*;
import com.jak.flappy.factory.EntityFactory;
import com.jak.flappy.system.*;
import com.jak.flappy.system.graphic.InputSystem;
import com.jak.flappy.world.FlappyWorld;

/**
 * Created by manu on 2/19/14.
 */
public class FlappyGame implements ApplicationListener {
    private FlappyWorld world;

    @Override
    public void create() {
        world = new FlappyWorld(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        world.initialize();
        world.setManager(new GroupManager());
        world.setSystem(new PreparingSystem(world), false);
        world.setSystem(new CenterCameraFlappySystem(world));
        world.setSystem(new InputSystem(world));
        //world.setSystem(new MovingNinjaSystem());
        world.setSystem(new SpawningNinjaSystem(0.5f));
        EntityFactory.createFlappy(world);
        EntityFactory.createGround(world);
        EntityFactory.createRoof(world);

        //EntityFactory.createNinja(world);
    }

    @Override
    public void render() {
        world.setDelta(Gdx.graphics.getDeltaTime());
        world.getSystem(PreparingSystem.class).process();
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
}
