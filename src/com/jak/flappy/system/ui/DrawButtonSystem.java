package com.jak.flappy.system.ui;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.jak.flappy.component.PositionComponent;
import com.jak.flappy.component.SizeComponent;
import com.jak.flappy.component.ui.ButtonComponent;
import com.jak.flappy.component.ui.LabelComponent;
import com.jak.flappy.component.ui.ShowComponent;
import com.jak.flappy.component.util.ListenerComponent;
import com.jak.flappy.manager.input.InputManager;
import com.jak.flappy.world.FlappyWorld;

/**
 * Created by manu on 05/04/14.
 */
public class DrawButtonSystem extends EntityProcessingSystem {

    private final ShapeRenderer shapeRenderer;
    private final BitmapFont font;
    private final SpriteBatch spriteBatch;
    private final InputManager inputManager;
    private final OrthographicCamera camera;

    @Mapper
    private ComponentMapper<LabelComponent> labelComponentMapper;
    @Mapper
    private ComponentMapper<PositionComponent> positionComponentMapper;
    @Mapper
    private ComponentMapper<SizeComponent> sizeComponentMapper;
    @Mapper
    private ComponentMapper<ListenerComponent> listenerComponentMapper;
    @Mapper
    private ComponentMapper<ShowComponent> showComponentMapper;

    public DrawButtonSystem(FlappyWorld flappyWorld) {
        super(Aspect.getAspectForAll(ButtonComponent.class));
        shapeRenderer = flappyWorld.getShapeRenderer();
        font = flappyWorld.getFont();
        spriteBatch = flappyWorld.getSpriteBatch();
        inputManager = flappyWorld.getInputManager();
        camera = flappyWorld.getCamera();
    }

    @Override
    protected void process(Entity entity) {
        PositionComponent position = positionComponentMapper.getSafe(entity);
        SizeComponent size = sizeComponentMapper.getSafe(entity);
        LabelComponent labelComponent = labelComponentMapper.getSafe(entity);
        ShowComponent showComponent = showComponentMapper.getSafe(entity);
        ListenerComponent listener = listenerComponentMapper.get(entity);

        if(showComponent.isShow()) {
            Color color = new Color(255, 255, 255, 1);
            if(isTouchedDown(position, size))
                color = new Color(255, 0, 0, 1);
            else if(isMouseOver(position, size))
                color = new Color(0, 0, 255, 1);
            shapeRenderer.setColor(color);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.rect(position.getX(), position.getY(), size.getWidth(), size.getHeight());
            shapeRenderer.end();

            font.setColor(new Color(255, 255, 255, 1));

            spriteBatch.begin();
            font.draw(spriteBatch, labelComponent.getLabel(), position.getX(), position.getY() + size.getHeight());
            spriteBatch.end();

            if(isTouchedUp(position, size)) {
                listener.run();
            }
        }
    }

    private boolean isTouchedDown(PositionComponent position, SizeComponent size) {
        return isMouseOver(position, size) && inputManager.isTouched();
    }

    private boolean isTouchedUp(PositionComponent position, SizeComponent size) {
        return isMouseOver(position, size) && inputManager.isTouchedUp();
    }

    private boolean isMouseOver(PositionComponent position, SizeComponent size) {
        Vector3 cursor = inputManager.getCursorPosition();
        camera.unproject(cursor);
        boolean isX = (cursor.x >= position.getX() && cursor.x <= position.getX() + size.getWidth());
        boolean isY = (cursor.y >= position.getY() && cursor.y <= position.getY() + size.getHeight());
        return  isX && isY;
    }
}
