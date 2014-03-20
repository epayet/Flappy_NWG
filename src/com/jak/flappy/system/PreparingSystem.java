package com.jak.flappy.system;

import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.jak.flappy.world.FlappyWorld;

/**
 * Created by manu on 3/20/14.
 */
public class PreparingSystem extends VoidEntitySystem{
    private final World physicWorld;
    private final OrthographicCamera camera;
    private final Box2DDebugRenderer debugRenderer;

    public PreparingSystem(FlappyWorld world) {
        camera = world.getCamera();
        physicWorld = world.getPhysicWorld();
        debugRenderer = world.getDebugRenderer();
    }

    @Override
    protected void processSystem() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        debugRenderer.render(physicWorld, camera.combined);
        physicWorld.step(world.getDelta(), 8, 6);
    }
}
