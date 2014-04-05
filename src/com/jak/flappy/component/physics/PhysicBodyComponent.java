package com.jak.flappy.component.physics;

import com.artemis.Component;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by manu on 17/03/14.
 */
public class PhysicBodyComponent extends Component{
    private Body body;

    public PhysicBodyComponent(BodyDef bodyDef, World world, boolean isAffectedByGravity) {
        body = world.createBody(bodyDef);
        setAffectedByGravity(isAffectedByGravity);
    }

    public PhysicBodyComponent(BodyDef bodyDef, World world) {
        this(bodyDef, world, true);
    }

    private void setAffectedByGravity(boolean isAffectedByGravity) {
        if(!isAffectedByGravity)
            body.setGravityScale(0);
    }

    public Body getBody() {
        return body;
    }
}
