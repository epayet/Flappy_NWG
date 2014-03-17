package com.jak.flappy.component.graphic.physics;

import com.artemis.Component;
import com.badlogic.gdx.physics.box2d.CircleShape;

/**
 * Created by manu on 17/03/14.
 */
public class CircleShapeComponent extends Component {
    private final CircleShape circle;

    public CircleShapeComponent(float radius) {
        circle = new CircleShape();
        circle.setRadius(radius);
    }

    public CircleShape getShape() {
        return circle;
    }
}
