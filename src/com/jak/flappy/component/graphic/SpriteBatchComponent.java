package com.jak.flappy.component.graphic;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by manu on 08/03/14.
 */
public class SpriteBatchComponent extends Component implements Disposable, Preparable{
    private final SpriteBatch spriteBatch;

    public SpriteBatchComponent() {
        spriteBatch = new SpriteBatch();
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }

    @Override
    public void prepare(Camera camera) {
        spriteBatch.setProjectionMatrix(camera.combined);
    }
}
