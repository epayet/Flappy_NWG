package com.jak.flappy.component.physics;

import com.artemis.Component;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by manu on 17/03/14.
 */
public class CircleShapeComponent extends Component implements Disposable{
    private final CircleShape circle;

    public CircleShapeComponent(float radius) {
        circle = new CircleShape();
        circle.setRadius(radius);
    }

    public CircleShape getShape() {
        return circle;
    }

    @Override
    public void dispose() {
        circle.dispose();
    }
}
