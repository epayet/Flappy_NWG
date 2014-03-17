package com.jak.flappy.component.graphic.physics;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.jak.flappy.component.graphic.Preparable;

/**
 * Created by manu on 17/03/14.
 */
public class PhysicWorldComponent extends Component implements Preparable{
    private World world;

    public PhysicWorldComponent(float gravity) {
        world = new World(new Vector2(0, gravity), true);
    }

    @Override
    public void prepare(Camera camera) {
        world.step(1/60f, 6, 2);
    }

    public World getWorld() {
        return world;
    }
}
