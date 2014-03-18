package com.jak.flappy.system.debug;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jak.flappy.component.InputComponent;
import com.jak.flappy.component.debug.DebubInfoComponent;
import com.jak.flappy.component.graphic.*;
import com.jak.flappy.input.LibgdxInputManager;

/**
 * Created by manu on 08/03/14.
 */
public class DebugInfoSystem { /*extends EntityProcessingSystem{
    @Mapper
    ComponentMapper<SpriteBatchComponent> spriteBatchMapper;
    @Mapper
    ComponentMapper<BitmapFontComponent> fontMapper;
    @Mapper
    ComponentMapper<DrawingComponent> drawingMapper;
    @Mapper
    ComponentMapper<LibgdxCameraComponent> cameraMapper;
    @Mapper
    ComponentMapper<LibgdxInputManager> inputMapper;

    public DebugInfoSystem() {
        super(Aspect.getAspectForAll(DebubInfoComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        SpriteBatchComponent spriteBatchComponent = spriteBatchMapper.get(entity);
        SpriteBatch spriteBatch = spriteBatchComponent.getSpriteBatch();

        BitmapFontComponent fontComponent = fontMapper.get(entity);
        BitmapFont font = fontComponent.getFont();

        DrawingComponent drawingComponent = drawingMapper.get(entity);
        Color color = drawingComponent.getColor();

        CameraComponent camera = cameraMapper.get(entity);
        InputComponent input = inputMapper.get(entity);

        String debugStr = "acc : " + input.getAccelerometerY();
        font.setColor(color);

        spriteBatch.begin();
        font.draw(spriteBatch, debugStr, 10, camera.getHeight() - 10);
        spriteBatch.end();
    }*/
}
