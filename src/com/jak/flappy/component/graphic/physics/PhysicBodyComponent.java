package com.jak.flappy.component.graphic.physics;

import com.artemis.Component;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by manu on 17/03/14.
 */
public class PhysicBodyComponent extends Component{
    private Body body;

    public PhysicBodyComponent(BodyDef.BodyType bodyType, World world, float x, float y) {
        this(bodyType, world, x, y, false);
    }

    public PhysicBodyComponent(BodyDef.BodyType bodyType, World world, float x, float y, boolean isBullet) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = bodyType;
        bodyDef.position.set(x, y);
        bodyDef.bullet = isBullet;
        body = world.createBody(bodyDef);
    }

    public PhysicBodyComponent(BodyDef bodyDef, World world) {
        body = world.createBody(bodyDef);
    }

    public Body getBody() {
        return body;
    }
}
