package com.jak.flappy.component.graphic;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by manu on 09/03/14.
 */
public class ShapeRendererComponent extends Component implements Preparable, Disposable{
    private ShapeRenderer shapeRenderer;

    public  ShapeRendererComponent() {
        this.shapeRenderer = new ShapeRenderer();
    }

    public ShapeRendererComponent(boolean noGraphicInit) {

    }

    public ShapeRenderer getShapeRenderer() {
        return shapeRenderer;
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }

    @Override
    public void prepare(Camera camera) {
        shapeRenderer.setProjectionMatrix(camera.combined);
    }
}
