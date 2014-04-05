package com.jak.flappy.listener.button;

import com.artemis.Entity;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.jak.flappy.Constants;
import com.jak.flappy.component.DeathComponent;
import com.jak.flappy.component.ScoreComponent;
import com.jak.flappy.component.physics.PhysicBodyComponent;
import com.jak.flappy.util.Listener;
import com.jak.flappy.world.FlappyWorld;
import com.jak.flappy.world.FlappyWorldUtils;

/**
 * Created by manu on 05/04/14.
 */
public class ReplayButtonListener implements Listener{
    private FlappyWorld world;

    public ReplayButtonListener(FlappyWorld world) {
        this.world = world;
    }

    @Override
    public void run() {
        Entity flappy = FlappyWorldUtils.getFlappyEntity(world);
        resetFlappyPositionAndForces(flappy);
        DeathComponent deathComponent = FlappyWorldUtils.getDeathComponent(world);
        deathComponent.setDeath(false);
        ScoreComponent score = FlappyWorldUtils.getScoreComponent(world);
        score.setScore(0);
    }

    private void resetFlappyPositionAndForces(Entity flappy) {
        PhysicBodyComponent physicBodyComponent = flappy.getComponent(PhysicBodyComponent.class);
        Body body = physicBodyComponent.getBody();
        body.setTransform(Constants.START_FLAPPY_X * Constants.WORLD_TO_BOX, Constants.START_FLAPPY_Y * Constants.WORLD_TO_BOX, body.getAngle());
        body.setLinearVelocity(new Vector2(0, 0));
        body.setAngularVelocity(0);
    }
}
