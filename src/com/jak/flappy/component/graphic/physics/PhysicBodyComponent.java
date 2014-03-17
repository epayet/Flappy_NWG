package com.jak.flappy.component.graphic.physics;

import com.artemis.Component;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by manu on 17/03/14.
 */
public class PhysicBodyComponent extends Component{
    private BodyDef bodyDef;
    private Body body;
    private World world;

    public PhysicBodyComponent(BodyDef.BodyType bodyType, World world, float x, float y) {
        this.world = world;
        this.bodyDef = new BodyDef();
        bodyDef.type = bodyType;
        bodyDef.position.set(x, y);
        body = world.createBody(bodyDef);
    }

    public Body getBody() {
        return body;
    }
}
