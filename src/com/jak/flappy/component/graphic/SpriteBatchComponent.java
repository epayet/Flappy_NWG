package com.jak.flappy.component.graphic;

import com.artemis.Component;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by manu on 08/03/14.
 */
public class SpriteBatchComponent extends Component{
    private final SpriteBatch spriteBatch;

    public SpriteBatchComponent() {
        spriteBatch = new SpriteBatch();
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }
}
