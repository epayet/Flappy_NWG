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
import com.jak.flappy.world.WorldManager;

/**
 * Created by manu on 2/19/14.
 */
public class FlappyGame implements ApplicationListener {
    private WorldManager worldManager;

    @Override
    public void create() {
        worldManager = new WorldManager();
        worldManager.createFlappyEntity();
        worldManager.createDebugInfoEntity();
    }

    @Override
    public void render() {
        worldManager.prepare();
        worldManager.process();
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
        worldManager.dispose();
    }
}
