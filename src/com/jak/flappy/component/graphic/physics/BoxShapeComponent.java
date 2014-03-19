package com.jak.flappy.component.graphic.physics;

import com.artemis.Component;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by manu on 17/03/14.
 */
public class BoxShapeComponent extends Component implements Disposable{
    private PolygonShape shape;

    public BoxShapeComponent(float halfWidth, float halfHeight) {
        shape = new PolygonShape();
        shape.setAsBox(halfWidth, halfHeight);
    }

    public PolygonShape getShape() {
        return shape;
    }

    @Override
    public void dispose() {
        shape.dispose();
    }
}
