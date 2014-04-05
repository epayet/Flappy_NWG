package com.jak.flappy.system.death;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.managers.GroupManager;
import com.artemis.systems.EntityProcessingSystem;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jak.flappy.Constants;
import com.jak.flappy.component.DeathComponent;
import com.jak.flappy.world.FlappyWorld;

/**
 * Created by manu on 05/04/14.
 */
public class ShowDeathSystem extends EntityProcessingSystem {

    private final SpriteBatch spriteBatch;
    private final BitmapFont font;
    @Mapper
    private ComponentMapper<DeathComponent> deathComponentMapper;

    public ShowDeathSystem(FlappyWorld flappyWorld) {
        super(Aspect.getAspectForAll(DeathComponent.class));
        font = flappyWorld.getFont();
        spriteBatch = flappyWorld.getSpriteBatch();
    }

    @Override
    protected void process(Entity entity) {
        DeathComponent death = deathComponentMapper.get(entity);
        if(death.isDeath()) {
            String debugStr = "DEAD";
            font.setColor(new Color(255, 0, 0, 1));

            spriteBatch.begin();
            font.draw(spriteBatch, debugStr, Constants.WORLD_WIDTH / 2, Constants.WORLD_HEIGHT / 2);
            spriteBatch.end();
        }
    }
}
