package com.jak.flappy.system.debug;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.annotations.Mapper;
import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jak.flappy.Constants;
import com.jak.flappy.component.graphic.DrawingComponent;
import com.jak.flappy.world.FlappyWorld;

/**
 * Created by manu on 08/03/14.
 */
public class DebugInfoSystem extends VoidEntitySystem{
    private final BitmapFont font;
    private final SpriteBatch spriteBatch;

    @Mapper
    ComponentMapper<DrawingComponent> drawingMapper;
    private float previousDelta;

    public DebugInfoSystem(FlappyWorld flappyWorld) {
        font = flappyWorld.getFont();
        spriteBatch = flappyWorld.getSpriteBatch();
    }

    @Override
    protected void processSystem() {
        float fps = world.getDelta() * 0.9f + previousDelta * 0.1f;
        String debugStr = "fps: " + fps;
        font.setColor(new Color(255, 255, 255, 1));

        spriteBatch.begin();
        font.draw(spriteBatch, debugStr, 10, Constants.WORLD_HEIGHT - 10);
        spriteBatch.end();
        previousDelta = world.getDelta();
    }
}
