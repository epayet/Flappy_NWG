package com.jak.flappy.system;

import com.artemis.Entity;
import com.artemis.World;
import com.jak.flappy.component.GravityComponent;
import com.jak.flappy.component.RectangleComponent;
import com.jak.flappy.component.VelocityComponent;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by manu on 3/6/14.
 */
public class TestGravitySystem extends TestCase {
    private World world;
    private Entity ninja;

    @Before
    public void setUp() throws Exception {
        world = new World();
        world.initialize();
        world.setSystem(new GravitySystem());
        world.setSystem(new VelocitySystem());

        ninja = world.createEntity();
        ninja.addComponent(new RectangleComponent(50 ,60, 50 , 50));
        ninja.addComponent(new VelocityComponent());
        ninja.addToWorld();
    }

    @After
    public void tearDown() throws Exception {

    }

    public void testGravity0_NinjaDoesntMove() {
        ninja.addComponent(new GravityComponent(0));

        world.process();

        RectangleComponent rectangle = ninja.getComponent(RectangleComponent.class);
        assertEquals(rectangle.getX(), 50f);
        assertEquals(rectangle.getY(), 60f);
    }


    public void testGravity_NinjaMoved() {
        ninja.addComponent(new GravityComponent(10));
        world.setDelta(50);

        world.process();

        RectangleComponent rectangle = ninja.getComponent(RectangleComponent.class);
        assertTrue(rectangle.getX() < 50f);
        assertEquals(rectangle.getY(), 60f);
    }
}
