package com.jak.flappy.component.graphic.physics;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.jak.flappy.component.graphic.Preparable;

/**
 * Created by manu on 17/03/14.
 */
public class DebugRendererComponent extends Component implements Preparable {
    private Box2DDebugRenderer renderer;
    private World world;

    public DebugRendererComponent(World world) {
        this.world = world;
        renderer = new Box2DDebugRenderer();
    }

    @Override
    public void prepare(Camera camera) {
        renderer.render(world, camera.combined);
    }
}
