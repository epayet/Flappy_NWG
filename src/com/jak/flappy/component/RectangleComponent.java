package com.jak.flappy.component;

import com.artemis.Component;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by manu on 05/03/14.
 */
public class RectangleComponent extends PositionComponent {
    private Rectangle rectangle;

    public RectangleComponent(float x, float y, float width, float height) {
        super(x, y);
        this.rectangle = new Rectangle(x, y, width, height);
    }

    public RectangleComponent() {
        this(0, 0, 0, 0);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public float getX() {
        return rectangle.getX();
    }

    @Override
    public void setX(float x) {
        rectangle.setX(x);
    }

    @Override
    public float getY() {
        return rectangle.getY();
    }

    @Override
    public void setY(float y) {
        rectangle.setY(y);
    }

    public float getWidth() {
        return rectangle.getWidth();
    }

    public float getHeight() {
        return rectangle.getHeight();
    }


}
