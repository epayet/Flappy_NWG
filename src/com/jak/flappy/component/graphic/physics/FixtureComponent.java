package com.jak.flappy.component.graphic.physics;

import com.artemis.Component;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by manu on 17/03/14.
 */
public class FixtureComponent extends Component {
    private final FixtureDef fixtureDef;
    private final Fixture fixture;

    public FixtureComponent(Shape shape, float density, float friction, float restitution, Body body) {
        fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = density;
        fixtureDef.friction = friction;
        fixtureDef.restitution = restitution;

        fixture = body.createFixture(fixtureDef);
    }

    public FixtureComponent(PolygonShape shape, Body body) {
        this(shape, 0f, 0f, 0f, body);
    }
}
