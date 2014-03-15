package com.jak.flappy;

import com.badlogic.gdx.ApplicationListener;
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
