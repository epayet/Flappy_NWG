package com.jak.flappy.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.jak.flappy.component.CameraComponent;
import com.jak.flappy.component.DrawingComponent;
import com.jak.flappy.component.RectangleComponent;

/**
 * Created by manu on 3/7/14.
 */
public class DrawingSystem extends EntityProcessingSystem{
    @Mapper
    ComponentMapper<RectangleComponent> rectangleMapper;
    @Mapper
    ComponentMapper<DrawingComponent> drawingMapper;
    @Mapper
    ComponentMapper<CameraComponent> cameraMapper;

    public DrawingSystem() {
        super(Aspect.getAspectForAll(DrawingComponent.class, CameraComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        DrawingComponent drawing = drawingMapper.get(entity);
        CameraComponent cameraComponent = cameraMapper.get(entity);
        RectangleComponent rectangle = rectangleMapper.getSafe(entity);

        Camera camera = cameraComponent.getCamera();
        if(rectangle != null) {
            ShapeRenderer shapeRenderer = new ShapeRenderer();
            shapeRenderer.setProjectionMatrix(camera.combined);

            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(drawing.getColor());
            shapeRenderer.rect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
            shapeRenderer.end();
        }
    }
}
