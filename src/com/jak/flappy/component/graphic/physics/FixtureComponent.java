package com.jak.flappy.component.graphic.physics;

import com.artemis.Component;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by manu on 17/03/14.
 */
public class FixtureComponent extends Component {
    private final Fixture fixture;

    public FixtureComponent(FixtureDef fixtureDef, Body body) {
        fixture = body.createFixture(fixtureDef);
    }

    public Fixture getFixture() {
        return fixture;
    }
}
