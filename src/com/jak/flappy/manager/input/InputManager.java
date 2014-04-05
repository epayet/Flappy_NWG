package com.jak.flappy.manager.input;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by manu on 3/7/14.
 */
public abstract class InputManager extends Component{
    public abstract boolean isKeyPressed(int key);
    public abstract float getAccelerometerY();
    public abstract boolean isAccelerometerAvailable();
    public abstract boolean isTouched();
    public abstract boolean isTouchedUp();
    public abstract boolean isKeyUp(int key);
    public abstract void reset();
    public abstract Vector3 getCursorPosition();
}
