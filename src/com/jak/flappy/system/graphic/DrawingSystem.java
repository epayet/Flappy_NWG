package com.jak.flappy.system.graphic;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.jak.flappy.component.CircleComponent;
import com.jak.flappy.component.graphic.LibgdxCameraComponent;
import com.jak.flappy.component.graphic.DrawingComponent;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.graphic.ShapeRendererComponent;

/**
 * Created by manu on 3/7/14.
 */
public class DrawingSystem extends EntityProcessingSystem{
    @Mapper
    ComponentMapper<RectangleComponent> rectangleMapper;
    @Mapper
    ComponentMapper<DrawingComponent> drawingMapper;
    @Mapper
    ComponentMapper<LibgdxCameraComponent> cameraMapper;
    @Mapper
    ComponentMapper<CircleComponent> circleMapper;
    @Mapper
    ComponentMapper<ShapeRendererComponent> shapeRendererMapper;

    public DrawingSystem() {
        super(Aspect.getAspectForAll(DrawingComponent.class, LibgdxCameraComponent.class, ShapeRendererComponent.class));
    }

    @Override
    protected void process(Entity entity) {
        DrawingComponent drawing = drawingMapper.get(entity);
        LibgdxCameraComponent cameraComponent = cameraMapper.get(entity);
        RectangleComponent rectangle = rectangleMapper.getSafe(entity);
        CircleComponent circle = circleMapper.get(entity);
        ShapeRendererComponent shapeRendererComponent = shapeRendererMapper.get(entity);
        ShapeRenderer shapeRenderer = shapeRendererComponent.getShapeRenderer();

        Camera camera = cameraComponent.getCamera();
        if(rectangle != null || circle != null) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(drawing.getColor());

            if(rectangle != null) {
                shapeRenderer.rect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
            }
            else if(circle != null) {
                shapeRenderer.circle(circle.getX(), circle.getY(), circle.getRadius());
            }

            shapeRenderer.end();
        }
    }
}
