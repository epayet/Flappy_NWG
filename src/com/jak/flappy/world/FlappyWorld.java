package com.jak.flappy.world;

import com.artemis.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.jak.flappy.Constants;
import com.jak.flappy.factory.LibgdxFactory;
import com.jak.flappy.input.InputManager;
import com.jak.flappy.input.LibgdxInputManager;

/**
 * Created by manu on 3/18/14.
 */
public class FlappyWorld extends World {
    private final com.badlogic.gdx.physics.box2d.World physicWorld;
    private final SpriteBatch spriteBatch;
    private final OrthographicCamera camera;
    private final Box2DDebugRenderer debugRenderer;
    private BitmapFont font;
    private final ShapeRenderer shapeRenderer;
    private final InputManager inputManager;

    public FlappyWorld(float width, float height) {
        super();
        physicWorld = new com.badlogic.gdx.physics.box2d.World(new Vector2(0, -100), true);
        camera = new OrthographicCamera(width, height);
        camera.setToOrtho(false, width, height);
        debugRenderer = new Box2DDebugRenderer();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        spriteBatch = new SpriteBatch();
        spriteBatch.setProjectionMatrix(camera.combined);
        font = LibgdxFactory.createFont("calibri.png", "calibri.fnt", "fonts");
        inputManager = new LibgdxInputManager();
    }

    @Override
    public void process() {
        super.process();
        inputManager.reset();
    }

    public com.badlogic.gdx.physics.box2d.World getPhysicWorld() {
        return physicWorld;
    }

    public InputManager getInputManager() {
        return inputManager;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public Box2DDebugRenderer getDebugRenderer() {
        return debugRenderer;
    }

    @Override
    public void dispose() {
        debugRenderer.dispose();
        physicWorld.dispose();
        font.dispose();
        shapeRenderer.dispose();
        spriteBatch.dispose();
        super.dispose();
    }
}
