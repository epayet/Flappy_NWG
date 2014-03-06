package com.jak.flappy.component;

import com.artemis.Component;

/**
 * Created by manu on 3/5/14.
 */
public class GravityComponent extends Component {
    private float gravity;

    public GravityComponent(float gravity) {
        this.gravity = gravity;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }
}
