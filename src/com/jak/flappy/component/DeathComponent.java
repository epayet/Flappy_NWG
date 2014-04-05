package com.jak.flappy.component;

import com.artemis.Component;

/**
 * Created by manu on 05/04/14.
 */
public class DeathComponent extends Component{
    private boolean death;

    public void setDeath(boolean death) {
        this.death = death;
    }

    public boolean isDeath() {
        return death;
    }
}
