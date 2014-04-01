package com.jak.flappy.component.graphic.physics;

import com.artemis.Component;
import com.badlogic.gdx.physics.box2d.Fixture;

/**
 * Created by manu on 01/04/14.
 */
public class ContactComponent extends Component {
    private String name;
    private Fixture collided;

    public ContactComponent(String name, Fixture fixture) {
        fixture.setUserData(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Fixture getCollided() {
        return collided;
    }

    public void setCollided(Fixture fixture) {
        this.collided = fixture;
    }

    public boolean hasCollided() {
        return collided != null;
    }

    public void reset() {
        collided = null;
    }
}
