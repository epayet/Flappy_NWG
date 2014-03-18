package com.jak.flappy.world;

import com.artemis.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.jak.flappy.Constants;

/**
 * Created by manu on 3/18/14.
 */
public class FlappyWorld extends World {
    private final com.badlogic.gdx.physics.box2d.World physicWorld;
    private OrthographicCamera camera;
    private Box2DDebugRenderer debugRenderer;

    public FlappyWorld(float width, float height) {
        super();
        physicWorld = new com.badlogic.gdx.physics.box2d.World(new Vector2(0, -100), true);
        camera = new OrthographicCamera(width, height);
        camera.setToOrtho(false, width, height);
        debugRenderer = new Box2DDebugRenderer();
    }

    @Override
    public void dispose() {
        debugRenderer.dispose();
        physicWorld.dispose();
        super.dispose();
    }

    @Override
    public void process() {
        prepare();
        setDelta(Gdx.graphics.getDeltaTime());
        super.process();
    }

    public com.badlogic.gdx.physics.box2d.World getPhysicWorld() {
        return physicWorld;
    }

    private void prepare() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        debugRenderer.render(physicWorld, camera.combined);
        physicWorld.step(1/60f, 6, 2);
    }
}
