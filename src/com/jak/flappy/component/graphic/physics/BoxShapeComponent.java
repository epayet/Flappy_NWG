package com.jak.flappy.component.graphic.physics;

import com.artemis.Component;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * Created by manu on 17/03/14.
 */
public class BoxShapeComponent extends Component {
    private PolygonShape shape;

    public BoxShapeComponent(float halfWidth, float halfHeight) {
        shape = new PolygonShape();
        shape.setAsBox(halfWidth, halfHeight);
    }

    public PolygonShape getShape() {
        return shape;
    }
}
