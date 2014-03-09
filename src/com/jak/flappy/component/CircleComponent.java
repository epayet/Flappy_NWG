package com.jak.flappy.component;

import com.artemis.Component;
import com.badlogic.gdx.math.Circle;

/**
 * Created by manu on 08/03/14.
 */
public class CircleComponent extends PositionComponent {
    private Circle circle;

    public CircleComponent(float x, float y, float radius) {
        super(x, y);
        circle = new Circle(x, y, radius);
    }

    public CircleComponent() {
        this(0, 0, 0);
    }

    @Override
    public float getY() {
        return circle.y;
    }

    @Override
    public void setY(float y) {
        circle.y = y;
    }

    @Override
    public float getX() {
        return circle.x;
    }

    @Override
    public void setX(float x) {
        circle.x = x;
    }

    public float getRadius() {
        return circle.radius;
    }

    public void setRadius(float radius) {
        circle.radius = radius;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Circle getCircle() {
        return circle;
    }
}
