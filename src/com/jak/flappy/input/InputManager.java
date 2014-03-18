package com.jak.flappy.input;

import com.artemis.Component;

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
}
