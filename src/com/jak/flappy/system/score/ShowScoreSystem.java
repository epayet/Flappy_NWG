package com.jak.flappy.system.score;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jak.flappy.Constants;
import com.jak.flappy.component.ScoreComponent;
import com.jak.flappy.world.FlappyWorld;

/**
 * Created by manu on 05/04/14.
 */
public class ShowScoreSystem extends EntityProcessingSystem {

    private final SpriteBatch spriteBatch;
    private final BitmapFont font;
    @Mapper
    private ComponentMapper<ScoreComponent> scoreComponentMapper;

    public ShowScoreSystem(FlappyWorld flappyWorld) {
        super(Aspect.getAspectForAll(ScoreComponent.class));
        font = flappyWorld.getFont();
        spriteBatch = flappyWorld.getSpriteBatch();
    }

    @Override
    protected void process(Entity entity) {
        ScoreComponent score = scoreComponentMapper.get(entity);
        String debugStr = "Score : " +  score.getScore();
        font.setColor(new Color(255, 255, 255, 1));

        spriteBatch.begin();
        font.draw(spriteBatch, debugStr, 10, Constants.WORLD_HEIGHT - 10);
        spriteBatch.end();
    }
}
