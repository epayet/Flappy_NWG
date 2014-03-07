package com.jak.flappy.component;

import com.artemis.Component;

/**
 * Created by manu on 3/7/14.
 */
public abstract class InputComponent extends Component{
    public abstract boolean isPressed(int key);
}
